package com.nmittal.problems.convexhull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ConvexHull Description.
 *
 * @author NarainM
 */
public final class ConvexHull {

    private Point start;
    private List<Point> points;

    public ConvexHull(List<Point> points) {
        this.points = points;
    }

    public static double angle(Point p, Point q) {
        int deltaY1 = q.getY() - p.getY();
        int deltaX1 = q.getX() - p.getX();
        return Math.toDegrees(Math.atan2(deltaY1, deltaX1));
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();

        points.add(new Point(2, 1));
        points.add(new Point(4, 4));
        points.add(new Point(4, 1));
        points.add(new Point(2, 5));
        points.add(new Point(1, 1));
        points.add(new Point(2, 3));
        points.add(new Point(3, 3));
        points.add(new Point(3, 2));

        ConvexHull hull = new ConvexHull(points);
        hull.findConvexHull();

        //System.out.println(angle(new Point(1, 1), new Point(4, 4)));

    }

    public void findConvexHull() {
        findStart();

        Collections.sort(points, new PointComparator(this.start));

        System.out.println(String.format("Sorted list: %s", points));

        int i = 1;
        while (i < points.size() - 1) {

            if (angle(points.get(i - 1), points.get(i)) < angle(points.get(i), points.get(i + 1))) {
                points.remove(i);
                i--;
            } else {
                i++;
            }

        }

        System.out.println(String.format("Convex Hull: %s", points));

    }

    private void findStart() {
        Point start = null;
        for (final Point p : points) {
            if (start == null || p.getX() < start.getX() || (p.getX() == start.getX() && p.getY() < start.getY())) {
                start = p;
            }
        }
        this.start = start;

        System.out.println(String.format("Start: %s", start));
    }

    private class PointComparator implements Comparator<Point> {

        private Point start;

        public PointComparator(Point start) {
            this.start = start;
        }

        @Override
        public int compare(Point o1, Point o2) {
            if (o1 == start) {
                return -1;
            }

            if (o2 == start) {
                return 1;
            }

            return Double.compare(ConvexHull.angle(start, o2), ConvexHull.angle(start, o1));
        }


    }
}

