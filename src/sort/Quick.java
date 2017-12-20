package sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Quick extends template {
	public static void sort(double[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	@SuppressWarnings("deprecation")
	public static void sort(double[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		Draw(a);
		StdDraw.show(10);
		StdDraw.clear();
		sort(a, lo, j - 1); // 左半部分排序
		sort(a, j + 1, hi); // 右半部分排序
	}

	private static int partition(double[] a, int lo, int hi) {
		// 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
		int i = lo, j = hi + 1; // 左右扫描指针
		double v = a[lo]; // 切分元素
		while (true) {
			// 扫描左右，检查扫描是否结束并交换元素
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);

		}
		exch(a, lo, j); // 将v=a[j]放入正确的位置

		return j; // a[lo..j-1] <= a[j] <= a[j+1..hi]
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int N = 2000;
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.random();
		show(a);
		sort(a);
		show(a);
	}
}
