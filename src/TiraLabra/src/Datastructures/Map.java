/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastructures;

/**
 *
 * @author jan
 */
public class Map<K, V> {

    private Object[] key = new Object[10000];
    private Object[] value = new Object[10000];

    public int hashC(Object o) {
        int hash = 0;
        hash = o.hashCode() % key.length;
        return hash;
    }

    public Object get(Object haku) {
        if (key[hashC(haku)] != null) {
            return value[hashC(haku)];
        } else {
            return null;
        }
    }

    public boolean put(Object a, Object b) {
        int hash = hashC(a);
        if (key[hash] != null) {
            if (key[hash] == a) {
                this.value[hash] = b;
            } else if (key[hash] != a) {
                openHash(hash, a, b);
            }
        } else {
            this.key[hash] = a;
            this.value[hash] = b;
        }
        return true;
    }

    public void openHash(int hash, Object a, Object b) {
        for (int i = hash; i < key.length - 1; i++) {
            if (key[i] == null) {
                this.key[hash] = a;
                this.value[hash] = b;
                break;
            }
            if (i == key.length - 2) {
                i = 0;
            }
        }
    }
}
