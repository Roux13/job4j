package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        // проверить. что массив word имеет последние элементы одинаковые с post
        if (post.length <= word.length) {
            result = true;
            for (int i = 0; i < post.length; i++) {
                if (post[(post.length - 1 - i)] != word[word.length - 1 - i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}