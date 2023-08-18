package com.had0uken.be_cool.test;

import com.had0uken.be_cool.enums.Type;

import javax.xml.crypto.Data;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Test {
    public static void main(String[] args) {
/*        LocalDate date = LocalDate.now();

        System.out.println(date.getMonth().toString());*/
        /*Type type = Type.valueOf("YEARLY");
        System.out.println(type);*/


        List<String>data = new ArrayList<>(List.of("aaa","bbb","ccc"));

        String [][] result = new String[data.size()][1];
        final int[] i = {0}; // Using an array to hold an effectively final value for lambda

        Arrays.stream(result)
                .forEach(row -> row[0] = data.get(i[0]++));

        for (String[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }
    public static void print (String [][] ar){
        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ar[i].length;j++)
            {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
    }
}