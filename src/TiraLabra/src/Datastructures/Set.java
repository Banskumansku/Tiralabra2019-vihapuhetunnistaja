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

    private final Object[] key;
    private final Object[] value;

    public Set() {
        this.value = new Object[50000];
        this.key = new Object[50000];
    }

    public int hashC(Object o) {
        return Math.abs(o.hashCode()) % key.length;
    }

    /**
     *
     * @param haku
     * @return returns boolean if set contains object
     */
    public boolean contains(Object haku) {
        if (key[hashC(haku)] != null) {
            if (value[hashC(haku)] == haku) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param a any object
     * @return returns true if object is succesfully added
     */
    public boolean add(Object a) {
        int hash = hashC(a);
        if (key[hash] != null) {
            if (key[hash] == a) {
                this.value[hash] = true;
            } else if (key[hash] != a) {
                openHash(hash, a);
            }
        } else {
            this.key[hash] = a;
            this.value[hash] = true;
        }
        return true;
    }

    /**
     * Used when collisions happen in adding objects to hashset
     * @param hash value of hashcode
     * @param a any object
     */
    public void openHash(int hash, Object a) {
        for (int i = hash; i < key.length - 1; i++) {
            if (key[i] == null) {
                this.key[hash] = a;
                this.value[hash] = true;
                break;
            }
            if (i == key.length - 2) {
                i = 0;
            }
        }
    }
}
