package sort;

import edu.princeton.cs.algs4.StdDraw;

public class template {
	public static void sort(Comparable<Integer> a) {

	}

	private static boolean less(Comparable<Integer> v, Comparable<Integer> w) {
		return v.compareTo((Integer) w) < 0;
	}

	private static void exch(Comparable<Integer>[] a, int i, int j) {
		Comparable<Integer> t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable<Integer>[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(Comparable<Integer>[] a) {
		for (int i = 0; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args) {
		int[] a = null;
	}

	private static void Draw(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
		StdDraw.enableDoubleBuffering();
	}
}
