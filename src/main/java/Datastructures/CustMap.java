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

    /**
     * Basic hashMap, you put in key, values
     * @param newKey 
     * @param data
     */
    public void put(K newKey, V data) {
        if (newKey == null) {
            return;
        }

        int hash = hash(newKey);
        Entry<K, V> newEntry = new Entry<>(newKey, data, null);
        // if space is free the entry goes here
        if (table[hash] == null) {
            table[hash] = newEntry;
            this.size++;
            // if not, linked list is iterated until a space is vacant
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

    /**
     *
     * @param key key to search for value
     * @return returned value
     */
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

    /**
     * Basically get, but with boolean
     * @param key
     * @return
     */
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
    
    /**
     *  Same as put but in reverse,
     * Also refactors the linked list so that 
     * there are no nulls
     * @param deleteKey
     * @return
     */
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

    /**
     * Returns entire keyset
     * @return
     */
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

}
