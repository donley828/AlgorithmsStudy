package sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Insertion extends template {
	@SuppressWarnings("deprecation")
	public static void sort(double[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			// 将a[i]插入到a[i]、a[i-1]...中
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
				Draw(a);
				StdDraw.show(100);
				StdDraw.clear();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int N = 500;
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.random();
		show(a);
		sort(a);
		show(a);
	}
}
