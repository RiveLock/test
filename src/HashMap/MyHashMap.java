package HashMap;

import java.util.LinkedList;

public class MyHashMap implements IHashMap {

	LinkedList<Entry>[] values = new LinkedList[2000];

	@Override
	public void put(Object key, Object value) {
	    // 获得 hash 值
		int hashcode = hashcode(key);
		// 根据 hash 值确定存储在哪个链表位置
		LinkedList<Entry> list = values[hashcode];
		if (null == list) {
			list = new LinkedList<>();
			values[hashcode] = list;
		}
		boolean found = false;
		for (Entry entry : list) {
		    // 通过比较确定存储的链表位置
			if (key.equals(entry.key)) {
				entry.value = value;
				found = true;
				break;
			}
		}
		if (!found) {
			Entry entry = new Entry(key, value);
			list.add(entry);
		}
	}

	@Override
	public Object get(Object key) {
	    // 获得 hash 值
		int hashcode = hashcode(key);
		// 根据 hash 值确定存储在哪个链表位置
		LinkedList<Entry> list = values[hashcode];
		if (null == list)
			return null;
		Object result = null;
		 // 通过比较确定存储的链表位置，并取出相应的 value
		for (Entry entry : list) {
			if (entry.key.equals(key)) {
				result = entry.value;
			}
		}
		return result;
	}
    
    // 自定义 hash 值，使其落在 0~1999 之间
	private int hashcode(Object obj) {
	    String str = obj.toString();
		if (0 == str.length())
			return 0;

		int hashcode = 0;
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			hashcode += cs[i];
		}
		hashcode *= 23;
		// 取绝对值
		Math.abs(hashcode);
		// 取值落在 0 - 1999 之间
		hashcode %= 2000;
		return hashcode;
	}
	
	public static void main(String[] args) {
        MyHashMap map =new MyHashMap();

		map.put("test", "坦克");
		map.put("test", "物理");
		map.put("t", "坦克2");
		System.out.println(map.get("test"));
        

   }

}