package com.emoji.second;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector() {
        this(0, 0, 0);
    }

    public double norm() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double dotProduct(Vector oth) {
        return x * oth.x + y * oth.y + z * oth.z;
    }

    public Vector crossProduct(Vector oth) {
        double newX = y * oth.z - z * oth.y;
        double newY = z * oth.x - x * oth.z;
        double newZ = x * oth.y - y * oth.x;
        return new Vector(newX, newY, newZ);
    }

    public double angleBetween(Vector oth) {
        return Math.acos(dotProduct(oth) / (norm() * oth.norm())) * 180.0 / Math.PI;
    }

    public Vector add(Vector oth) {
        return new Vector(x + oth.x, y + oth.y, z + oth.z);
    }

    public Vector sub(Vector oth) {
        return new Vector(x - oth.x, y - oth.y, z - oth.z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static Vector[] getRandomArray(int n) {
        Vector[] res = new Vector[n];
        for (int i = 0; i < n; i++) {
            res[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return res;
    }
}
