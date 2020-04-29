package vtb.tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//2.Написать функцию, которая принимает
// на вход строку и возвращает наиболее часто
// встречающееся в этой строке слово (java)

public class Task02 {
    public static void main(String[] args) {
        String str = "Some str! Let's find out, which word is most frequent in here? The word is any word which presents in dictionary!";
        windFreqWord(str);
    }

    private static void windFreqWord(String str) {
        String replacedStr = str.toLowerCase().replaceAll("[^\\d\\w]\\s|\\s|\\.{3}|[^\\w']", " ");
        String[] strArr = replacedStr.split(" ");

        HashMap<String, Integer> bagOfWords = new HashMap<>();

        for (String o : strArr) {
            bagOfWords.merge(o, 1, Integer::sum);
        }

        Map.Entry<String, Integer> max = null;

        for (Map.Entry<String, Integer> entry : bagOfWords.entrySet()) {
            if (max == null || entry.getValue().compareTo(max.getValue()) > 0) {
                max = entry;
            }
        }
        System.out.println(max);
    }
}
