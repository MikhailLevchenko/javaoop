package com.yahoo.mikhailjs.desk;

public class Circle extends Shape {
	private Point centrePoint;
	private Point radiusPoint;

	public Circle(Point centrePoint, Point radiusPoint) {
		super();
		if (centrePoint != null && radiusPoint != null) {
			this.centrePoint = centrePoint;
			this.radiusPoint = radiusPoint;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public Circle() {
		this(new Point(0.0, 0.0), new Point(0.0, 1.0));
	}

	public void setCentrePoint(Point centrePoint) {
		if (centrePoint != null) {
			this.centrePoint = centrePoint;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void setRadiusPoint(Point radiusPoint) {
		if (radiusPoint != null) {
			this.radiusPoint = radiusPoint;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public double getRadius() {
		double dX = calcDelta(centrePoint.getX(), radiusPoint.getX());
		double dY = calcDelta(centrePoint.getY(), radiusPoint.getY());

		return Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
	}

	private double calcDelta(double a, double b) {
		return (Double.compare(a, b) > 0) ? a - b : b - a;
	}

	@Override
	public double getArea() {
		return Math.PI * (Math.pow(getRadius(), 2));
	}

	@Override
	public double getPerimetr() {
		return 2 * getRadius() * Math.PI;
	}

	@Override
	public String toString() {
		return "Circle";
	}
}
