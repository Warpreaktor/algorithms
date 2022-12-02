package ru.warpreaktor.util.date_structure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class OneWayLinkedListTest {

    @Test
    void getSize() {
        OneWayLinkedList<Integer> oneWayLinkedList = new OneWayLinkedList<>();
        oneWayLinkedList.add(1);
        Assertions.assertEquals(1, oneWayLinkedList.getSize());
        oneWayLinkedList.add(2);
        oneWayLinkedList.add(3);
        Assertions.assertEquals(3, oneWayLinkedList.getSize());
        for (int i = 4; i <= 100; i++) {
            oneWayLinkedList.add(i);
        }
        Assertions.assertEquals(100, oneWayLinkedList.getSize());
    }

    @Test
    void addInteger() {
        OneWayLinkedList<Integer> oneWayLinkedList = new OneWayLinkedList<>();
        oneWayLinkedList.add(1);
        Assertions.assertEquals(1, oneWayLinkedList.get(0));
        oneWayLinkedList.add(2);
        Assertions.assertEquals(2, oneWayLinkedList.get(1));
        oneWayLinkedList.add(3);
        Assertions.assertEquals(3, oneWayLinkedList.get(2));
    }

    @Test
    void addString() {
        OneWayLinkedList<String> oneWayLinkedList = new OneWayLinkedList<>();
        String shershen =
                "Что делать если вас укусил шершень: " +
                "1. Не бегите сразу в травмпункт, а сначала попробуйте его раздавить и посмотреть, залетит ли он обратно. " +
                "2. Если шершень залетел обратно, отпустите его и он улетит. " +
                "3. Если шершня не удалось поймать, возьмите пинцет, положите его на стол и прижмите им шершня к столу. " +
                "4. Если шершень не хочет стоять и его нужно придерживать, возьмите его за голову и подержите ее несколько секунд. " +
                "5. Если шершней было несколько, раздавите их всех и соберите в банку";
        oneWayLinkedList.add(shershen);
        Assertions.assertEquals(shershen, oneWayLinkedList.get(0));
        String barman =
                "Как понять что перед вами Настоящий Бармен: " +
                "1. Настоящий Бармен - это не человек " +
                "2. Если он увидит вас, он обязательно подумает, что он - Бог " +
                "3. Он обязательно предложит вам выпить " +
                "4. Напиток будет стоить дороже, чем вы бы заплатили в обычном баре с обычным барменом" +
                "5. Рядом с Настоящим Барменом вы будете выглядеть глупо " +
                "6. Вы обязательно будете выглядеть глупо " +
                "7. В конце концов вы просто выпьете и заплатите больше " +
                "8. Не думайте, что он вернёт вам деньги " +
                "9. Если вернёт - вы будете чувствовать себя виноватым ";
        oneWayLinkedList.add(barman);
        String candy =
                "Как просто отобрать конфетку у ребенка: " +
                "Возьмите у ребенка конфету и сразу же отдайте ее ему. " +
                "Малыш вспомнит, что нельзя брать конфеты у незнакомых и никогда не будет просить ее у вас.";
        oneWayLinkedList.add(candy);
        String alive = "Я возьму этот микрофон чтобы рассказать вам, как я рад, что вы все ещё живы.";
        oneWayLinkedList.add(alive);
        String shoe = "Сегодня мне принесли обувь для починки, я внимательно осмотрел туфлю и сказал: " +
                "\"Ну, вот видите, ничего страшного, просто надо немного обрезать\". А потом спросил: \"А где ваша нога?\"";
        oneWayLinkedList.add(shoe);
        Assertions.assertEquals(shoe, oneWayLinkedList.get(4));
    }

    @Test
    void remove() {
        OneWayLinkedList<Integer> oneWayLinkedList = new OneWayLinkedList<>();
        oneWayLinkedList.add(1);
        Assertions.assertEquals(1, oneWayLinkedList.getSize());
        oneWayLinkedList.remove(0);
        Assertions.assertEquals(0, oneWayLinkedList.getSize());
        oneWayLinkedList.add(2);
        oneWayLinkedList.add(3);
        Assertions.assertEquals(3, oneWayLinkedList.get(1));
    }

    @Test
    public void get() {
            OneWayLinkedList<Integer> oneWayLinkedList = new OneWayLinkedList<>();
            for (int i = 0; i < 100; i++) {
                oneWayLinkedList.add(i);
            }
            Assertions.assertEquals(55, oneWayLinkedList.get(55));
            oneWayLinkedList.remove(0);
            Assertions.assertEquals(1, oneWayLinkedList.get(0));
            Assertions.assertEquals(99, oneWayLinkedList.get(98));
            oneWayLinkedList.add(100);
            Assertions.assertEquals(99, oneWayLinkedList.get(98));
            oneWayLinkedList.remove(98);
            Assertions.assertEquals(100, oneWayLinkedList.get(98));
            Assertions.assertEquals(98, oneWayLinkedList.get(97));
    }

    @Test
    public void find() {
        OneWayLinkedList<Integer> oneWayLinkedList = new OneWayLinkedList<>();
        Assertions.assertThrows(NoSuchElementException.class, () ->
                oneWayLinkedList.find(13));

        for (int i = 0; i < 100; i++) {
            oneWayLinkedList.add(i);
        }
        Assertions.assertEquals(55, oneWayLinkedList.find(55));

        oneWayLinkedList.remove(0);
        Assertions.assertThrows(NoSuchElementException.class, () ->
                oneWayLinkedList.find(0));

        Assertions.assertEquals(98, oneWayLinkedList.find(98));

        oneWayLinkedList.add(-55);
        Assertions.assertEquals(55, oneWayLinkedList.find(55));
        oneWayLinkedList.remove(54);
        Assertions.assertThrows(NoSuchElementException.class, () ->
                oneWayLinkedList.find(55));
    }

}