package HashMap;

import java.util.LinkedList;

public class MyHashMap implements IHashMap {

	LinkedList<Entry>[] values = new LinkedList[2000];

	@Override
	public void put(Object key, Object value) {
	    // ��� hash ֵ
		int hashcode = hashcode(key);
		// ���� hash ֵȷ���洢���ĸ�����λ��
		LinkedList<Entry> list = values[hashcode];
		if (null == list) {
			list = new LinkedList<>();
			values[hashcode] = list;
		}
		boolean found = false;
		for (Entry entry : list) {
		    // ͨ���Ƚ�ȷ���洢������λ��
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
	    // ��� hash ֵ
		int hashcode = hashcode(key);
		// ���� hash ֵȷ���洢���ĸ�����λ��
		LinkedList<Entry> list = values[hashcode];
		if (null == list)
			return null;
		Object result = null;
		 // ͨ���Ƚ�ȷ���洢������λ�ã���ȡ����Ӧ�� value
		for (Entry entry : list) {
			if (entry.key.equals(key)) {
				result = entry.value;
			}
		}
		return result;
	}
    
    // �Զ��� hash ֵ��ʹ������ 0~1999 ֮��
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
		// ȡ����ֵ
		Math.abs(hashcode);
		// ȡֵ���� 0 - 1999 ֮��
		hashcode %= 2000;
		return hashcode;
	}
	
	public static void main(String[] args) {
        MyHashMap map =new MyHashMap();

		map.put("test", "̹��");
		map.put("test", "����");
		map.put("t", "̹��2");
		System.out.println(map.get("test"));
        

   }

}