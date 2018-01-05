package Search;

import dataStructure.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	public Value get(Key key) {
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}

	public void put(Key key, Value val) {
		// 查找并更新 否则创建
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public void delete(Key key) {
		if (isEmpty())
			return;
		int i = rank(key);
		if (i == N || keys[i].compareTo(key) != 0)
			return;
		for (int j = i; j < N - 1; j++) {
			keys[j] = keys[j + 1];
			vals[j] = vals[j + 1];
		}
		N--;
		keys[N] = null;
		vals[N] = null;
	}

	public Key min() {
		return keys[0];
	}

	public Key max() {
		return keys[N - 1];
	}

	public Key select(int k) {
		return keys[k];
	}

	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}

	public Key floor(Key key) {
		int i = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0)
			return keys[i];
		if (i == 0)
			return null;
		else
			return keys[i - 1];
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> q = new Queue<Key>();
		for (int i = rank(lo); i < rank(hi); i++)
			q.enqueue(keys[i]);
		if (contains(hi))
			q.enqueue(keys[rank(hi)]);
		return (Iterable<Key>) q;
	}
}
