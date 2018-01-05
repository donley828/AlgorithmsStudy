package Search;

public class SequentialSearchST<Key, Value> {
	private Node first;
	private static int N = 0;

	private class Node {
		// 链表首结点
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public Value get(Key key) {
		// 查找
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key))
				return x.val;
		}
		return null;
	}

	public void put(Key key, Value val) {
		// 查找并更新，若不存在则添加
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;// 更新
			}
		}
		first = new Node(key, val, first);
		N++;
	}

	public void delete(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				Node temp = x.next;
				x.val = temp.val;
				x.next = temp.next;
				N--;
			}
		}
	}

	public boolean contains(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.val))
				return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}
}
