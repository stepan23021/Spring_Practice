package com.example.dmitrii.spring_practice.InterfacesPractice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Dmitrii Stepcenco
 * @created 12 September 2018
 **/

class JSONParser {
    static ArrayList<Double> arr = new ArrayList<>();

    void getRates() throws IOException {

        Element document = Jsoup.connect("http://bnm.md/").get().body();

        Object[] array = (document
                .getElementById("ajax-wrapper-list")
                .select("span")
                .eachText()
                .toArray());
        System.out.println(Arrays.toString(array));
        for (int i = 1, k = 0; i < array.length; i += 2, k++) {
            if (k != 2 && k != 3) {
                Double aDouble = Double.parseDouble(array[i].toString());
                arr.add(aDouble);
            }
        }
        System.out.println(arr);
    }
}
