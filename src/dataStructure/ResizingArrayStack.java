package dataStructure;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[1]; // 栈数量
	private int N = 0; // 元素数量

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		@SuppressWarnings("unchecked")
		// 将栈移动到一个大小为max的新数组
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	public void push(Item item) {
		// 将元素添加到栈顶
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}

	public Item pop() {
		// 从栈顶删除元素
		Item item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		// 支持后进后出的迭代
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			return a[--i];
		}

		public void remove() {
		}
	}

	public static void main(String[] args) {
		ResizingArrayStack<Double> test = new ResizingArrayStack<Double>();
		System.out.println(test.size());
		test.push(5.023);
		System.out.println(test.size());
		System.out.println(test.pop());
	}
}
