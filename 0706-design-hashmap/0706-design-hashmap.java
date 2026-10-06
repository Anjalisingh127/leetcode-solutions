import java.util.ArrayList;

class MyHashMap {

    private ArrayList<int[]> list;

    public MyHashMap() {
        list = new ArrayList<>();
    }

    public void put(int key, int value) {

        // Check if key already exists
        for (int[] pair : list) {
            if (pair[0] == key) {
                pair[1] = value;   // update value
                return;
            }
        }

        // Key doesn't exist → add new pair
        list.add(new int[]{key, value});
    }

    public int get(int key) {

        for (int[] pair : list) {
            if (pair[0] == key) {
                return pair[1];
            }
        }

        return -1;
    }

    public void remove(int key) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == key) {
                list.remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */