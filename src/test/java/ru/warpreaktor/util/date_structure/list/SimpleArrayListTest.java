package ru.warpreaktor.util.date_structure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @Test
    void size() {
        String str = "abc";
        ArrayList arrayList = new ArrayList();
        Assertions.assertEquals(0, arrayList.size());
        arrayList.add(str);
        Assertions.assertEquals(1, arrayList.size());
        arrayList.add(str);
        arrayList.add(str);
        arrayList.add(str);
        arrayList.add(str);
        Assertions.assertEquals(5, arrayList.size());
    }

    @Test
    void get() {
        String str1 = "Инжектор";
        String str2 = "Водолей";
        String str3 = "Фотограф";
        String str4 = "Ку-Ка-Ре-Куу!";
        String str5 = "Почва была мягкой...";
        ArrayList arrayList = new ArrayList();
        arrayList.add(str1);
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str4);
        arrayList.add(str5);
        Assertions.assertEquals("Водолей", arrayList.get(1));
        Assertions.assertEquals("Почва была мягкой...", arrayList.get(4));
    }

    @Test
    void set() {
        String str1 = "Инжектор";
        String str2 = "Водолей";
        String str3 = "Фотограф";
        String str4 = "Ку-Ка-Ре-Куу!";
        String str5 = "Почва была мягкой...";
        ArrayList arrayList = new ArrayList();
        arrayList.add(str1);
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str4);
        arrayList.add(str5);
        arrayList.set(0, "Вермишель");
        Assertions.assertEquals("Вермишель", arrayList.get(0));
        arrayList.set(3, "Последовательность");
        Assertions.assertEquals("Последовательность", arrayList.get(3));
    }

    @Test
    void add() {
        String[] arr = new String[]{"Снегоуборочная машина", "Инжектор", "Водолей", "Фотограф",
                "Ку-Ка-Ре-Куу!","Почва была мягкой...","Скрепки","ШАРОМЫГА","Это оскорбительно! Фи!",
                "Упорство", "Кросс","Корм","Лингвистика","Лопата","Проникновенность","На воре шапка горит!",
                "Кто такой застрельщик?"};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
            Assertions.assertEquals(i+1, arrayList.size());
        }
        Assertions.assertArrayEquals(arr, arrayList.toArray());
    }

    @Test
    void remove() {
        String[] arr = new String[]{"Снегоуборочная машина", "Инжектор", "Водолей", "Фотограф",
                "Ку-Ка-Ре-Куу!","Почва была мягкой...","Скрепки","ШАРОМЫГА","Это оскорбительно! Фи!",
                "Упорство", "Кросс","Корм","Лингвистика","Лопата","Проникновенность","На воре шапка горит!",
                "Кто такой застрельщик?"};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        Assertions.assertEquals("Снегоуборочная машина", arrayList.get(0));
        int size = arrayList.size();
        arrayList.remove(0);
        Assertions.assertEquals("Инжектор", arrayList.get(0));
        Assertions.assertEquals(size-1, arrayList.size());

        arrayList.remove(15);
        Assertions.assertEquals("На воре шапка горит!", arrayList.get(14));
        Assertions.assertEquals(15, arrayList.size());
    }

    @Test
    void grow() {
        String[] arr = new String[]{"Снегоуборочная машина", "Инжектор", "Водолей", "Фотограф",
                "Ку-Ка-Ре-Куу!","Почва была мягкой...","Скрепки","ШАРОМЫГА","Это оскорбительно! Фи!",
                "Упорство", "Кросс","Корм","Лингвистика","Лопата","Проникновенность","На воре шапка горит!",
                "Кто такой застрельщик?"};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        Assertions.assertEquals(17, arrayList.size());
        Assertions.assertArrayEquals(arr, arrayList.toArray());
    }
}