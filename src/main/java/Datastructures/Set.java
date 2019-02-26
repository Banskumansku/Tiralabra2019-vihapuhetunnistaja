/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastructures;

/**
 *
 * @author jan
 * @param <K>
 */
public class Set<K> {

    private Entry<K>[] table;   //Array of Entry.
    private int capacity = 10000;  //Initial capacity of HashMap -> large because lots of words expected
    private int size;

    static class Entry<K> {

        K key;
        K value;
        Entry<K> next;

        public Entry(K key, Entry<K> next) {
            this.key = key;
            this.value = key;
            this.next = next;
        }

    }

    @SuppressWarnings("unchecked")
    public Set() {
        table = new Entry[capacity];
        this.size = 0;
    }

    /**
     * Basic hashSet, you put in key, and you are able to check if key exists in
     * ~O(1) time
     *
     * @param newKey
     */
    public boolean add(K newKey) {
        if (newKey == null) {
            return false;
        }

        int hash = hash(newKey);
        Entry<K> newEntry = new Entry<>(newKey, null);
        // if space is free the entry goes here
        if (table[hash] == null) {
            table[hash] = newEntry;
            this.size++;
            // if not, linked list is iterated until a space is vacant
        } else {
            Entry<K> previous = null;
            Entry<K> current = table[hash];

            while (current != null) {
                if (current.key.equals(newKey)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        this.size++;

                        return true;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        this.size++;

                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
            this.size++;
        }
        return true;
    }

    /**
     *
     * @param key key to search for value
     * @return returned value
     */
    private K get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K> temp = table[hash];
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
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return get(key) != null;
    }

    /**
     * Same as add but in reverse, Also refactors the linked list so that there
     * are no nulls
     *
     * @param deleteKey
     * @return
     */
    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K> previous = null;
            Entry<K> current = table[hash];

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

    public int size() {
        return size;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode()) % capacity;
    }

}
