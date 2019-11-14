package com.ulto.game.entity.tower;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.GameGrid;
import com.ulto.game.entity.Bullet;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.UpdatableEntity;
import com.ulto.game.entity.enemy.Enemy;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tile.Road;

import javafx.geometry.Point2D;

public abstract class Tower implements GameEntity, UpdatableEntity {
    private final Point2D position;

    private final int damage;
    private final double range;
    private final double delay;
    public double lastShotTime = Integer.MIN_VALUE;

    private Enemy currentTarget = null;

    @Override
    public void update(GameField field) {
        if (field.getTime() - lastShotTime < delay) return;
        if (currentTarget == null || currentTarget.isDestroyed() || !inRange(currentTarget))
            currentTarget = heaviestInRange(field);
        if (currentTarget == null)
            return;
            
        Point2D aim = calculateInterceptionPoint(currentTarget.getPosition(),
                                                    currentTarget.getVelocity(),
                                                    getCenter(),
                                                    Constants.BULLET_SPEED);

        if (aim == null) return;
        shoot(field, aim);
        lastShotTime = field.getTime();
    }

    public void shoot(GameField field, Point2D target) {
        Point2D velocity = target.subtract(getCenter()).normalize().multiply(Constants.BULLET_SPEED);
        double remainTime = getCenter().distance(target) / Constants.BULLET_SPEED;
        field.getEntities().add(new Bullet(getCenter(), velocity, damage, remainTime));
    }

    /**
	 * Calculates the point of interception for one object starting at point
	 * <code>a</code> with speed vector <code>v</code> and another object
	 * starting at point <code>b</code> with a speed of <code>s</code>.
	 * 
	 * @see <a
	 *      href="http://jaran.de/goodbits/2011/07/17/calculating-an-intercept-course-to-a-target-with-constant-direction-and-velocity-in-a-2-dimensional-plane/">Calculating
	 *      an intercept course to a target with constant direction and velocity
	 *      (in a 2-dimensional plane)</a>
	 * 
	 * @param a
	 *            start vector of the object to be intercepted
	 * @param v
	 *            speed vector of the object to be intercepted
	 * @param b
	 *            start vector of the intercepting object
	 * @param s
	 *            speed of the intercepting object
	 * @return vector of interception or <code>null</code> if object cannot be
	 *         intercepted or calculation fails
	 * 
	 * @author Jens Seiler
	 */
	public static Point2D calculateInterceptionPoint(final Point2D a, final Point2D v, final Point2D b, final double s) {
		final double ox = a.getX() - b.getX();
		final double oy = a.getY() - b.getY();
		
		final double h1 = v.getX() * v.getX() + v.getY() * v.getY() - s * s;
		final double h2 = ox * v.getX() + oy * v.getY();
		double t;
		if (h1 == 0) { // problem collapses into a simple linear equation 
			t = -(ox * ox + oy * oy) / (2*h2);
		} else { // solve the quadratic equation
			final double minusPHalf = -h2 / h1;
			 
			final double discriminant = minusPHalf * minusPHalf - (ox * ox + oy * oy) / h1; // term in brackets is h3
			if (discriminant < 0) { // no (real) solution then...
				return null;
			}
		 
			final double root = Math.sqrt(discriminant);
		 
			final double t1 = minusPHalf + root;
			final double t2 = minusPHalf - root;
		 
			final double tMin = Math.min(t1, t2);
			final double tMax = Math.max(t1, t2);
		 
			t = tMin > 0 ? tMin : tMax; // get the smaller of the two times, unless it's negative
			if (t < 0) { // we don't want a solution in the past
				return null;
			}
		}
	 
		// calculate the point of interception using the found intercept time and return it
		return new Point2D(a.getX() + t * v.getX(), a.getY() + t * v.getY());
	}

    private Enemy heaviestInRange(GameField field) {
        double centerX = getX() + Constants.TOWER_SIZE / 2f;
        double centerY = getY() + Constants.TOWER_SIZE / 2f;

        GameGrid grid = field.getGrid();

        int minDistance = Integer.MAX_VALUE;
        double maxWeight = Integer.MIN_VALUE;
        GameEntity heaviestEntity = null;

        for (double u = centerX - range; u <= centerX + range; u += Constants.TILE_SIZE) {
            for (double v = centerY - range; v <= centerY + range; v += Constants.TILE_SIZE) {
                if (!GameGrid.inGrid(u, v)) continue;
                GameTile currentTile = grid.getCell(u, v);

                if (!(currentTile instanceof Road) || !inRange(currentTile)) continue;
                if (((Road)currentTile).getDistance() > minDistance) continue;

                for (GameEntity entity : currentTile.getEntities()) {
                    Enemy e = (Enemy)entity;
                    if (!inRange(e)) continue;

                    if (e.cellWeight() > maxWeight) {
                        minDistance = ((Road)currentTile).getDistance();
                        maxWeight = e.cellWeight();
                        heaviestEntity = e;
                    }
                }
            }
        }

        return (Enemy)heaviestEntity;
    }

    private boolean inRange(GameTile tile) {
        return inRange(tile.getX(), tile.getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);
    }

    private boolean inRange(Enemy e) {
        return inRange(e.getX(), e.getY(), e.getWidth(), e.getHeight());
    }

    private boolean inRange(double u, double v, double w, double h) {
        return inRange(u, v)
                || inRange(u, v + h)
                || inRange(u + w, v)
                || inRange(u + w, v + h);
    }

    private boolean inRange(double u, double v) {
        double centerX = getX() + Constants.TOWER_SIZE / 2f;
        double centerY = getY() + Constants.TOWER_SIZE / 2f;
        return Math.sqrt((centerX - u) * (centerX - u) + (centerY - v) * (centerY - v)) < range;
    }

    protected Tower(Point2D position, int damage, double range, double delay) {
        this.position = position;
        this.damage = damage;
        this.range = range;
        this.delay = delay;
    }

    protected Tower(double x, double y, int damage, double range, double delay) {
        this(new Point2D(x, y), damage, range, delay);
    }

    public Point2D getCenter() {
        return new Point2D(getX() + getWidth()/2f, getY() + getHeight()/2f);
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public Point2D getPosition() {
        return position;
    }

    public double getWidth() {
        return Constants.TOWER_SIZE;
    }

    public double getHeight() {
        return Constants.TOWER_SIZE;
    }

    public int getDamage() {
        return damage;
    }

    public double getRange() {
        return range;
    }

    public double getDelay() {
        return delay;
    }
}