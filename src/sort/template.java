package sort;

import edu.princeton.cs.algs4.StdDraw;

public class template {

	public static boolean less(double v, double w) {
		return v < w;
	}

	public static void exch(double[] a, int i, int j) {
		double t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void show(double[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(double[] a) {
		for (int i = 0; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void Draw(double[] a) {
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
