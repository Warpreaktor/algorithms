package ru.warpreaktor;

import java.util.Random;

public class Generator {

    private final Character[] abc = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m',
                                                    'n','o','p','q','r','s','t','u','w','v','x','y','z'};
    private final Character[] vowelsEng = new Character[]{'a','e','i','o','u','y'};
    private final Character[] consonantsEng = new Character[]{'b','c','d','f','g','h','j','k','l','m',
            'n','p','q','r','s','t','w','v','x','z'};

    private final Character[] alphabet = new Character[]{'а', 'б','в','г','д','е','ё','ж','з','и','й','к','л','м','н',
            'о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ь','ы','ъ','э','ю','я'};
    private final Character[] vowelsRu = new Character[]{'а', 'е','ё','и','о','у','ы','э','ю','я'};
    private final Character[] lightVowels = new Character[]{'е', 'ё', 'и','ю','я'};
    private final Character[] consonantsRu = new Character[]{'б','в','г','д','ж','з','й','к','л','м','н',
            'п','р','с','т','ф','х','ц','ч','ш','щ'};
    private final Character[] firstCharacter = new Character[]{'а', 'б','в','г','д','е','ё','ж','з','и','к','л','м','н',
            'о','п','р','с','т','у','ф','х','ц','ч','ш','щ','э','ю','я'};
    private final Character[] specialCharacters = new Character[]{'ь','ы','ъ'};
    private final Character[] cha = new Character[]{'ч'};

    private final String[] namesRus = new String[]{"Харсей","Маврикий","Агриппа","Иоанникий","Зосима","Фавий",
            "Савватий","Арес","Матвей","Ираклий","Аполлоний","Лонгин","Карл","Зенон","Павсикакий","Анаклет","Иван","Александр"};

    private static final Random random = new Random();

    /**
     * Генерирует массив int со случайными значениями в пределах от 0 до размера массива.
     * @param arrSize - размер генерируемого масива
     * @param rand - при значении true массив заполнится случайными цифрами. При false массив будет упорядоченным.
     * @return изменяет переданный массив и возвращает его.
     */
    public static int[] genIntegerArray(int arrSize, boolean rand){
        int arr[] = new int[arrSize];
        if (rand) {
            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(arrSize);
            }
        }else{
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }
        return arr;
    }

    /**
     *  Перегруженный метод, в котором по мимо размера массива можно указать границы генерируемых int значений.
     * @param arrSize - размер генерируемого масива.
     * @param numBound - граница генерируемого числа от 0.
     * @return изменяет переданный массив и возвращает его.
     */
    public static int[] genIntegerArray(int arrSize, int numBound){
        Random random = new Random();
        int arr[] = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(numBound);
        }
        return arr;
    }

    /**
     * Генератор английских имен. Пока что абсолютно бестолковый, он просто генерит случайный набор букв из алфавита.
     * @param qNames - количество генерируемых имен
     * @return
     */
    public static String[] genNameArrayEng(int qNames){
        Generator generator = new Generator();
        Character[] abc = generator.abc;
        String[] names = new String[qNames];
        Character[] vowelsEng = generator.vowelsEng;
        Character[] consonantsEng = generator.consonantsEng;

        for (int i = 0; i < qNames; i++) {
            StringBuilder name = new StringBuilder();
            Character previousChar = abc[random.nextInt(abc.length)];
            int charsNumber = random.nextInt(6) + 3;

            name.append(previousChar);

            for (int j = 1; j < charsNumber; j++) {
                if (generator.isVowelEng(previousChar)){
                    previousChar = consonantsEng[random.nextInt(consonantsEng.length)];
                    name.append(previousChar);
                }else{
                    previousChar = vowelsEng[random.nextInt(vowelsEng.length)];
                    name.append(previousChar);
                }
            }
            names[i] = name.toString();
        }
        return names;
    }

    public static String[] genNameArrayRus(int qNames){
        Generator generator = new Generator();
        Character[] firstCharacter = generator.firstCharacter;
        String[] names = new String[qNames];
        Character[] vowelsRu = generator.vowelsRu;
        Character[] consonantsRu = generator.consonantsRu;

        for (int i = 0; i < qNames; i++) {
            StringBuilder name = new StringBuilder();
            Character previousChar = firstCharacter[random.nextInt(firstCharacter.length)];

            int charsNumber = random.nextInt(6) + 3;

            name.append(previousChar);

            for (int j = 1; j < charsNumber; j++) {
                if (generator.isVowelRu(previousChar)){
                    Character currentChar = consonantsRu[random.nextInt(consonantsRu.length)];
                    name.append(currentChar);
                    previousChar = currentChar;
                    continue;
                }
                if(isCha(previousChar)){
                    Character currentChar = vowelsRu[random.nextInt(vowelsRu.length)];
                    if (isLightVowel(currentChar)) {
                        name.append('ь');
                        name.append(currentChar);
                        previousChar = currentChar;
                        continue;
                    }
                }
                if (!generator.isVowelRu(previousChar)){
                    Character currentChar = vowelsRu[random.nextInt(vowelsRu.length)];
                    name.append(currentChar);
                    previousChar = currentChar;
                    continue;
                }
            }
            names[i] = name.toString();
        }
        return names;
    }

    public static String generateNameRusFour(){
        Generator generator = new Generator();
        String[] names = generator.namesRus;
        int numberCharacters = 4;
        StringBuilder name = new StringBuilder();
        String randName = names[random.nextInt(names.length)];
        String startName = randName.substring(0, 2);
        name.append(startName);
        String randName2 = names[random.nextInt(names.length)];
        String endName = randName2.substring(randName2.length()-2);
        name.append(endName);
        return name.toString();
    }

    public static String generateNameRusFive(){
        Generator generator = new Generator();
        String[] names = generator.namesRus;
        int numberCharacters = 5;
        StringBuilder name = new StringBuilder();

//        for (int i = 0; i < numberCharacters; i++) {
        String randName = names[random.nextInt(names.length)];
        String startName = randName.substring(0, 2);
        name.append(startName);

        String randName2 = names[random.nextInt(names.length)];
        String midName = randName2.substring(2, 1);
        name.append(midName);

        String randName3 = names[random.nextInt(names.length)];
        String endName = randName3.substring(randName3.length()-2);
        name.append(endName);
//        }
        return name.toString();
    }

    private static boolean isLightVowel(Character character) {
        Generator generator = new Generator();
        Character[] lightVowels = generator.lightVowels;
        for (int i = 0; i < lightVowels.length; i++) {
            if (lightVowels[i].equals(character)){
                return true;
            }
        }
        return false;
    }


    private static boolean isCha(Character character) {
        Generator generator = new Generator();
        Character[] cha = generator.cha;
        for (int i = 0; i < cha.length; i++) {
            if (cha[i].equals(character)){
                return true;
            }
        }
        return false;
    }

    private boolean isVowelEng(Character character){
        Generator generator = new Generator();
        Character[] vowelsEng = generator.vowelsEng;
        for (int i = 0; i < vowelsEng.length; i++) {
            if (vowelsEng[i].equals(character)){
                return true;
            }
        }
        return false;
    }
    private boolean isVowelRu(Character character){
        Generator generator = new Generator();
        Character[] vowelsRu = generator.vowelsRu;
        for (int i = 0; i < vowelsRu.length; i++) {
            if (vowelsRu[i].equals(character)){
                return true;
            }
        }
        return false;
    }
    private boolean isSpecialCharacter(Character character){
        Generator generator = new Generator();
        Character[] specialCharacters = generator.specialCharacters;
        for (int i = 0; i < vowelsRu.length; i++) {
            if (specialCharacters[i].equals(character)){
                return true;
            }
        }
        return false;
    }

}
