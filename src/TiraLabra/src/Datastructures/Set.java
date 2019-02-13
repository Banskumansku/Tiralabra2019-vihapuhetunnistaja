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

    private final Object[] key = new Object[100000];
    private final boolean[] value = new boolean[100000];

    public int hashC(Object o) {
        return o.hashCode() % key.length;
    }

    public Object contains(Object haku) {
        if (key[hashC(haku)] != null) {
            return value[hashC(haku)];
        } else {
            return false;
        }
    }

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
