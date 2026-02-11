package tools;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> companies = new ArrayList<>();
        companies.add("DELL");
        companies.add("APPLE");
        companies.add("SAMSUNG");
        companies.add("SONY");
        companies.add("ALCATEL");

        String result = "";

        for (int i = 0; i < companies.size(); i++) {
            result += companies.get(i);
            if (i < companies.size() - 1) {
                result += ", ";
            }
        }

        System.out.println(result);
    }
}
