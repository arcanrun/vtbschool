package vtb.tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Task03 {
    public static void main(String[] args) {
        String pattern = "yyyy@dd@MM";
        String str = " 2019@20@01 some/ string-where@you must23 find date by pattern 2020@01@02 dwdwdwdwdw wd wdwd";
        findDateInString(str, pattern);
    }

    private static void findDateInString(String str, String pattern) {
     
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);


        List<String> stack = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                try {
                    while (!Character.isAlphabetic(str.charAt(i))) {
                        temp.append(str.charAt(i));
                        i++;
                    }
                    stack.add(temp.toString().trim());
                    temp.setLength(0);
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }

        }

        List<String> res = new ArrayList<>();
        for (String o : stack) {
            try {
                dateFormat.parse(o);
                res.add(o);
            } catch (ParseException ignored) {

            }
        }
        System.out.println(res);
    }

}
