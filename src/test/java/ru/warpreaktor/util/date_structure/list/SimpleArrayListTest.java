package ru.warpreaktor.util.date_structure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @Test
    void size() {
        String str = "abc";
        SimpleArrayList simpleArrayList = new SimpleArrayList();
        Assertions.assertEquals(0, simpleArrayList.size());
        simpleArrayList.add(str);
        Assertions.assertEquals(1, simpleArrayList.size());
        simpleArrayList.add(str);
        simpleArrayList.add(str);
        simpleArrayList.add(str);
        simpleArrayList.add(str);
        Assertions.assertEquals(5, simpleArrayList.size());
    }

    @Test
    void get() {
        String str1 = "Инжектор";
        String str2 = "Водолей";
        String str3 = "Фотограф";
        String str4 = "Ку-Ка-Ре-Куу!";
        String str5 = "Почва была мягкой...";
        SimpleArrayList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add(str1);
        simpleArrayList.add(str2);
        simpleArrayList.add(str3);
        simpleArrayList.add(str4);
        simpleArrayList.add(str5);
        Assertions.assertEquals("Водолей", simpleArrayList.get(1));
        Assertions.assertEquals("Почва была мягкой...", simpleArrayList.get(4));
    }

    @Test
    void set() {
        String str1 = "Инжектор";
        String str2 = "Водолей";
        String str3 = "Фотограф";
        String str4 = "Ку-Ка-Ре-Куу!";
        String str5 = "Почва была мягкой...";
        SimpleArrayList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add(str1);
        simpleArrayList.add(str2);
        simpleArrayList.add(str3);
        simpleArrayList.add(str4);
        simpleArrayList.add(str5);
        simpleArrayList.set(0, "Вермишель");
        Assertions.assertEquals("Вермишель", simpleArrayList.get(0));
        simpleArrayList.set(3, "Последовательность");
        Assertions.assertEquals("Последовательность", simpleArrayList.get(3));
    }

    @Test
    void add() {
        String[] arr = new String[]{"Снегоуборочная машина", "Инжектор", "Водолей", "Фотограф",
                "Ку-Ка-Ре-Куу!","Почва была мягкой...","Скрепки","ШАРОМЫГА","Это оскорбительно! Фи!",
                "Упорство", "Кросс","Корм","Лингвистика","Лопата","Проникновенность","На воре шапка горит!",
                "Кто такой застрельщик?"};
        SimpleArrayList simpleArrayList = new SimpleArrayList();
        for (int i = 0; i < arr.length; i++) {
            simpleArrayList.add(arr[i]);
            Assertions.assertEquals(i+1, simpleArrayList.size());
        }
        Assertions.assertArrayEquals(arr, simpleArrayList.toArray());
    }

    @Test
    void remove() {
        String[] arr = new String[]{"Снегоуборочная машина", "Инжектор", "Водолей", "Фотограф",
                "Ку-Ка-Ре-Куу!","Почва была мягкой...","Скрепки","ШАРОМЫГА","Это оскорбительно! Фи!",
                "Упорство", "Кросс","Корм","Лингвистика","Лопата","Проникновенность","На воре шапка горит!",
                "Кто такой застрельщик?"};
        SimpleArrayList simpleArrayList = new SimpleArrayList();
        for (int i = 0; i < arr.length; i++) {
            simpleArrayList.add(arr[i]);
        }
        Assertions.assertEquals("Снегоуборочная машина", simpleArrayList.get(0));
        int size = simpleArrayList.size();
        simpleArrayList.remove(0);
        Assertions.assertEquals("Инжектор", simpleArrayList.get(0));
        Assertions.assertEquals(size-1, simpleArrayList.size());

        simpleArrayList.remove(15);
        Assertions.assertEquals("На воре шапка горит!", simpleArrayList.get(14));
        Assertions.assertEquals(15, simpleArrayList.size());
    }

    @Test
    void grow() {
        String[] arr = new String[]{"Снегоуборочная машина", "Инжектор", "Водолей", "Фотограф",
                "Ку-Ка-Ре-Куу!","Почва была мягкой...","Скрепки","ШАРОМЫГА","Это оскорбительно! Фи!",
                "Упорство", "Кросс","Корм","Лингвистика","Лопата","Проникновенность","На воре шапка горит!",
                "Кто такой застрельщик?"};
        SimpleArrayList simpleArrayList = new SimpleArrayList();
        for (int i = 0; i < arr.length; i++) {
            simpleArrayList.add(arr[i]);
        }
        Assertions.assertEquals(17, simpleArrayList.size());
        Assertions.assertArrayEquals(arr, simpleArrayList.toArray());
    }
}