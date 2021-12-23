class HashTableDouble {
    private final DataItem[] hashArray;
    private final int arraySize;
    private final DataItem nonItem;

    HashTableDouble(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    public int hashFunc1(int key) {
        return key % arraySize;
    }

    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
