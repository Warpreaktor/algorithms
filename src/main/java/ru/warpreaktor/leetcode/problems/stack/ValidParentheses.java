package ru.warpreaktor.leetcode.problems.stack;

import java.util.HashMap;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses {

    /**
     * 12.08.2022
     * Runtime: 142 ms, faster than 5.21% of Java online submissions for Valid Parentheses.
     * Memory Usage: 42.2 MB, less than 42.60% of Java online submissions for Valid Parentheses.
     */
    public static boolean isValid(String s) {
        //1. Определим справочник для всех скобок
        HashMap<Character, Character> symbolsMap = new HashMap<>();
        symbolsMap.put(Character.valueOf('('), Character.valueOf(')'));
        symbolsMap.put(Character.valueOf('['), Character.valueOf(']'));
        symbolsMap.put(Character.valueOf('{'), Character.valueOf('}'));

        //Скобок всегда должно быть чётное количество
        if(s.length() %2 != 0){return false;}
        //Проверяем не начинается ли строка с закрытой скобки и не заканчивается ли она открытой
        if(symbolsMap.get(s.charAt(0)) == null){return false;}
        if(symbolsMap.get(s.charAt(s.length()-1)) != null){return false;}

        boolean result = false;
        StringBuilder controlString = new StringBuilder(s);

        //В первом цикле ищем только открывающие скобки, а все найденные пары будут удаляться из строки.
        for(int i = 0; i < controlString.length(); i++){
            result = false;
            //Установим курсор на первый символ в строке
            char cursorI = controlString.charAt(i);
            //Вытащим закрывающую скобку для скобки на которой стоим
            Character closedBracket = symbolsMap.get(cursorI);
            //Если ничего не нашлось - значит мы стоим на закрывающей скобке (невалидном символе), которая и не открывалась.
            if(closedBracket == null){
                return result = false;
            }

            //Во втором цикле ищем только пару для открытой скобки, при чём между ними не должно быть скобок другого типа.
            for(int j = i+1; j < controlString.length(); j++){
                //Установим курсор на следующий после открытой скобки символ
                char cursorJ = controlString.charAt(j);
                //Если скобка закрылась - значит пара схлопнулась. Удаляем их из контрольной строки и обнуляем счетчик.
                if(closedBracket == cursorJ)
                {
                    result = true;
                    controlString.deleteCharAt(j);
                    controlString.deleteCharAt(i);
                    i = -1;
                    break;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void test(){
        boolean result = isValid("()");
        if (result == false) throw new RuntimeException();

        result = isValid("[]");
        if (result != true) throw new RuntimeException();

        result = isValid("(){}");
        if (result == false) throw new RuntimeException(String.format("RESULT = %s", result));

        result = isValid("(){}[]");
        if (result == false) throw new RuntimeException(String.format("RESULT = %s", result));

        result = isValid("{}{}");
        if (result == false) throw new RuntimeException(String.format("RESULT = %s", result));

        result = isValid("[{}]");
        if (result != true) throw new RuntimeException();

        result = isValid("}(");
        if (result != false) throw new RuntimeException();

        result = isValid("(){}{");
        if (result != false) throw new RuntimeException();

        result = isValid("{]");
        if (result == true) throw new RuntimeException(String.format("RESULT = %s", result));

        result = isValid("{[}]");
        if (result == true) throw new RuntimeException(String.format("RESULT = %s", result));

        result = isValid("{]{}{}((()(){}]}");
        if (result == true) throw new RuntimeException(String.format("RESULT = %s", result));
    }
}
