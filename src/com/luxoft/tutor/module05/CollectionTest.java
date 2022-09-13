package com.luxoft.tutor.module05;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CollectionTest {
    public void dumpCollection(Collection<?> c) {
        System.out.println("Collection has" + c.size() +
                " elements.");
        Iterator<?> iter = c.iterator();
        while (iter.hasNext()) {
            Object elem = iter.next();
            System.out.println("Next element is" + elem);
//            if (getClause(elem)) {
//                iter.remove();
//            }
        }
    }
    void addTwice(Set<Point> set) {
        set.clear();
        Point p1 = new Point(10, 20);
        Point p2 = new Point(10, 20);
        set.add(p1);
        set.add(p2);
        System.out.println(set.size());
    }

    private class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
