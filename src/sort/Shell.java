package sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Shell extends template {
	@SuppressWarnings("deprecation")
	public static void sort(double[] a) {
		// 将a[]按升序排列
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			// 将数组变为h有序
			for (int i = h; i < N; i++) {
				// 将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...中
				for (int j = i; j > h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
					Draw(a);
					StdDraw.show(10);
					StdDraw.clear();
				}
			}
			h = h / 3;
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int N = 100;
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.random();
		show(a);
		sort(a);
		show(a);
	}
}
