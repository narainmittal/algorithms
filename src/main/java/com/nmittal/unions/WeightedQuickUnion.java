package com.nmittal.unions;

import java.util.Arrays;


public class WeightedQuickUnion {

    private int[] a;
    private int[] size;

    WeightedQuickUnion(int n) {
        a = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnion find = new WeightedQuickUnion(10);
        find.union(3, 4);
        find.union(5, 6);
        find.union(6, 7);
        find.union(3, 1);
        find.union(4, 9);
        System.out.println("Union " + Arrays.toString(find.getA()));
        System.out.println("Connected 5,6 " + find.connected(5, 6));
        System.out.println("Connected 1,4 " + find.connected(1, 4));
        System.out.println("Connected 1,9 " + find.connected(1, 9));
    }

    public int[] getA() {
        return a;
    }

    public int root(int p) {
        while (a[p] != p) {
            // Flattening
            a[p] = a[a[p]];
            p = a[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pdex = a[p];
        int qdex = a[q];
        int proot = root(p);
        int qroot = root(q);
        if (size[qroot] <= size[proot]) {
            a[q] = proot;
            size[proot]++;
            System.out.println(String.format("Union(%s,%s): updated %s to %s", p, q, qdex, proot));
        } else {
            a[p] = qroot;
            size[qroot]++;
            System.out.println(String.format("Union(%s,%s): updated %s to %s", p, q, pdex, qroot));
        }
    }

    public boolean connected(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        return pRoot == qRoot;
    }

    public int[] getSize() {
        return size;
    }
}
