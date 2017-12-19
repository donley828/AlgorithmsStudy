package sort;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Selection {
	@SuppressWarnings("deprecation")
	public static void sort(double[] a) {
		int N = a.length; // 获取数组长度
		for (int i = 0; i < N; i++) {
			// a[i]和a[i+1...N]中的最小值交换
			int min = i;
			for (int j = i + 1; j < N; j++)
				if (less(a[j], a[min]))
					min = j;
			exch(a, i, min);
			Draw(a);
			StdDraw.show(1000);
			StdDraw.clear();
		}
	}

	private static boolean less(double v, double w) {
		return v < w;
	}

	private static void exch(double[] a, int i, int j) {
		double t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(double[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	private static void Draw(double[] a) {
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

	@SuppressWarnings("deprecation")
	public static void test() {
		int N = 50;
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.random();
		Arrays.sort(a);
		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// double[] a = { 8, 5, 6, 2, 1, 5, 8 };
		int N = 10;
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.random();
		sort(a);
	}
}
