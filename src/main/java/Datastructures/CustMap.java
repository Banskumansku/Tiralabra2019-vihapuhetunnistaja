package Datastructures;

public class CustMap<K, V> {

    private Entry<K, V>[] table;   //Array of Entry.
    private int capacity = 10000;  //Initial capacity of HashMap -> large because lots of words expected
    private int size;

    static class Entry<K, V> {

        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    @SuppressWarnings("unchecked")
    public CustMap() {
        table = new Entry[capacity];
        this.size = 0;
    }

    public void put(K newKey, V data) {
        if (newKey == null) {
            return;
        }

        int hash = hash(newKey);
        Entry<K, V> newEntry = new Entry<>(newKey, data, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
            this.size++;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(newKey)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        this.size++;

                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        this.size++;

                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
            this.size++;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean contains(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {
                        table[hash] = table[hash].next;
                        this.size--;
                        return true;
                    } else {
                        previous.next = current.next;
                        this.size--;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    public Object[] keySet() {
        Object[] keyset = new Object[size];
        int index = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    keyset[index] = entry.key;
                    index++;
                    if (index == size()) {
                        return keyset;
                    }
                    entry = entry.next;
                }
            }
        }
        return keyset;
    }

    public int size() {
        return size;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    void resize(int newCapacity) {
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    /**
     * Transfers all entries from current table to newTable.
     */
    void transfer(Entry[] newTable) {
        Entry[] srcTable = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < srcTable.length; j++) {
            Entry<K, V> e = srcTable[j];
            if (e != null) {
                srcTable[j] = null;
                while (e != null) {
                    Entry<K, V> next = e.next;
                    int i = indexFor(hash(e), newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                }
            }
        }
    }

    /**
     * Returns index for hash code h.
     */
    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

}
