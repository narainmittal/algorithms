package com.nmittal.unions;

import java.util.Arrays;


public class QuickUnion {

    public int[] a;


    QuickUnion(int n) {
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
    }

    public static void main(String[] args) {
        QuickUnion find = new QuickUnion(10);
        find.union(3, 4);
        find.union(5, 6);
        find.union(6, 7);
        find.union(3, 1);
        find.union(4, 9);
        System.out.println("Union " + Arrays.toString(find.a));
        System.out.println("Connected 5,6 " + find.connected(5, 6));
        System.out.println("Connected 1,4 " + find.connected(1, 4));
        System.out.println("Connected 1,9 " + find.connected(1, 9));
    }

    public void union(int p, int q) {
        int pdex = a[p];
        int qdex = a[q];
        while (a[qdex] != qdex) {
            qdex = a[qdex];
        }
        a[p] = qdex;
        System.out.println(String.format("Union(%s,%s): updated %s to %s", p, q, pdex, qdex));
    }

    public boolean connected(int p, int q) {
        int pRoot = a[p];
        int qRoot = a[q];
        while (pRoot != a[pRoot]) {
            pRoot = a[pRoot];
        }
        while (qRoot != a[qRoot]) {
            qRoot = a[qRoot];
        }
        return pRoot == qRoot;
    }
}
