package hashmapandhashfunctionproblem.customhashmap;

import java.util.LinkedList;

// Implementing a Custom Hash Map using Separate Chaining
class CustomHashMap<K, V> {
    private static final int SIZE = 16; // Default size of the hash table
    private LinkedList<Entry<K, V>>[] table;

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Initializing the hash table
    public CustomHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Inserting a key-value pair into the hash map
    public void put(K key, V value) {
        int index = getIndex(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Updating existing key
                return;
            }
        }
        table[index].add(new Entry<>(key, value)); // Adding new entry
    }

    // Retrieving a value associated with a key
    public V get(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Removing a key-value pair from the hash map
    public void remove(K key) {
        int index = getIndex(key);
        table[index].removeIf(entry -> entry.key.equals(key));
    }

    // Getting the index for a given key
    private int getIndex(K key) {
        return key.hashCode() % SIZE;
    }
}

