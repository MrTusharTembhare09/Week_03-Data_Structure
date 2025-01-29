package hashmapandhashfunctionproblem.customhashmap;

// Main class to test Custom Hash Map
class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Inserting key-value pairs
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Retrieving values
        System.out.println("Value for 'two': " + map.get("two"));

        // Removing a key
        map.remove("two");

        // Checking if removal was successful
        System.out.println("Value for 'two' after removal: " + map.get("two"));
    }
}

