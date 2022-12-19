package ru.warpreaktor.util.date_structure.hash_table;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void put() {
        HashTable<String, String> hashTable = new HashTable<>();
        for (int i = 0; i < 10; i++) {
            hashTable.put("example"+i, "example"+i);
        }
        for (int i = 0; i < 10; i++) {
            hashTable.put("example"+i, "example"+i);
        }
    }

    @Test
    void getSize() {
        HashTable<String, String> hashTable = new HashTable<>();
        for (int i = 0; i < 10; i++) {
            hashTable.put("example"+i, "example"+i);
        }
        Assertions.assertEquals(10, hashTable.getSize());
        for (int i = 0; i < 10; i++) {
            hashTable.put("example"+i, "example"+i);
        }
        Assertions.assertEquals(10, hashTable.getSize());
        for (int i = 0; i < 10; i++) {
            hashTable.put("Хабрахабр -- торт! ЧЫМДШРС example"+i, "example"+i+i);
        }
        Assertions.assertEquals(20, hashTable.getSize());
    }

    @Test
    void get() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("Ёжик", "Европа");
        hashTable.put("Буйвол", "Африка и Азия");
        hashTable.put("Жираф", "Африка");
        hashTable.put("Енот", "Северная Америка");
        hashTable.put("Зебра", "Африка");
        hashTable.put("Слон", "Африка и Азия");
        hashTable.put("Слон", "Европа, Северная Африка, Азия и Северная Америка");
        hashTable.put("Горилла", "Африка");
        hashTable.put("Хабрахабр -- торт! ЧЫМДШРС Пост-алгоритмика Зебра", "Луна");
        //Вытащить то чего нет в таблице
        Assertions.assertEquals(null, hashTable.get("Кенгуру"));
        Assertions.assertEquals("Африка", hashTable.get("Горилла"));
        Assertions.assertEquals("Африка", hashTable.get("Жираф"));
        Assertions.assertEquals("Европа", hashTable.get("Ёжик"));
        //Вытащить из одного бакет
        Assertions.assertEquals("Северная Америка", hashTable.get("Енот"));
    }

    @Test
    void remove() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("Ёжик", "Европа");
        hashTable.put("Буйвол", "Африка и Азия");
        hashTable.remove("Буйвол");
        Assertions.assertEquals(null, hashTable.get("Буйвол"));
        hashTable.put("Жираф", "Африка");
        hashTable.put("Енот", "Северная Америка");
        hashTable.put("Зебра", "Африка");
        hashTable.put("Слон", "Африка и Азия");
        hashTable.put("Хабрахабр -- торт! ЧЫМДШРС Ёжик", "Марс");
        Assertions.assertEquals(null, hashTable.get("Буйвол"));
        hashTable.put("Слон", "Европа, Северная Африка, Азия и Северная Америка");
        hashTable.put("Горилла", "Африка");
        Assertions.assertEquals("Африка", hashTable.get("Горилла"));
        Assertions.assertEquals("Африка", hashTable.get("Жираф"));
        hashTable.remove("Хабрахабр -- торт! ЧЫМДШРС Ёжик");
        Assertions.assertEquals("Европа", hashTable.get("Ёжик"));

    }

    @Test
    void index() {
        int capacity = 100;
        HashTable hashTable = new HashTable(capacity, 0.7F);
        int index = 0;
        Random random = new Random();
        int hash = 0;
        for (int i = 0; i < 1000; i++) {
            hash =  (int)(random.nextDouble() * 100000000);
            index = hashTable.index(hash);
            Assertions.assertEquals(true, index <= capacity);
        }
    }

    @Test
    void fullTest() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("Ёжик", "Европа");
        hashTable.put("Буйвол", "Африка и Азия");
        hashTable.put("Хабрахабр -- торт! ЧЫМДШРС Ёжик", "Марс");
        hashTable.put("Жираф", "Африка");
        hashTable.put("Енот", "Северная Америка");
        hashTable.put("Зебра", "Африка");
        hashTable.put("Слон", "Африка и Азия");
        hashTable.put("Слон", "Европа, Северная Африка, Азия и Северная Америка");
        hashTable.put("Горилла", "Африка");
        Assertions.assertEquals("Африка", hashTable.get("Жираф"));
    }
}