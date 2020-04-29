package vtb.tasks;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Task04 {

    public static void main (String[] args){
        String str = "12lklwdalmd$$$2l w d21 2 ";
        findSum(str);
    }

    private static void findSum(String str) {

        StringBuilder temp = new StringBuilder();
        List<Integer> digitArr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                try{
                    while (Character.isDigit(str.charAt(i))){
                        temp.append(str.charAt(i));
                        i++;
                    }
                    digitArr.add(Integer.parseInt(temp.toString()));
                    temp.setLength(0);
                }catch (IndexOutOfBoundsException e){
                    break;
                }
            }
        }
        int sum = 0;
        for (Integer i: digitArr) {
            sum += i;
        }
        System.out.println(sum);
    }

}

