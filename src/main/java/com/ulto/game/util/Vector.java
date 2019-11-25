package com.ulto.game.util;

public class Vector {
    private double x;
    private double y;

    public static final Vector ZERO = new Vector(0, 0);

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector mul(double k) {
        return new Vector(k*x, k*y);
    }

    public double magn() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector norm() {
        double magn = magn();
        return new Vector(x/magn, y/magn);
    }

    public Vector plus(Vector other) {
        return new Vector(x + other.x, y + other.y);
    }

    public Vector minus(Vector other) {
        return new Vector(x - other.x, y - other.y);
    }

    public double dot(Vector other) {
        return x * other.x + y * other.y;
    }

    public double dist(Vector other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}