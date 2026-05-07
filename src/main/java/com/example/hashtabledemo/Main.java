import java.util.Random;

public class Main {

    public static void main(String[] args) {

        MyHashTable<MyTestingClass, Student> table =
                new MyHashTable<>(101);

        Random random = new Random();

        // Add 10000 random elements
        for (int i = 0; i < 10000; i++) {

            int id = random.nextInt(100000);

            String code = "CODE" + random.nextInt(100000);

            MyTestingClass key =
                    new MyTestingClass(id, code);

            Student student =
                    new Student("Student" + i,
                            18 + random.nextInt(10));

            table.put(key, student);
        }

        // Print total size
        System.out.println("Total elements: " + table.size());

        // Print bucket distribution
        table.printBucketSizes();
    }
}