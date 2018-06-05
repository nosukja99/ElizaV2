package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String input;
        String output = "";
        ArrayList<String> hedges = new ArrayList<>();
        ArrayList<String> qualifiers = new ArrayList<>();
        HashMap<String, String> hmap = new HashMap<String, String>();

        hedges.add("Please tell me more");
        hedges.add("Many of my patients tell me the same thing");
        hedges.add("It is getting late, maybe we had better quit");

        qualifiers.add("Why do you say that");
        qualifiers.add("You seem to think that");
        qualifiers.add("So, you are concerned that");

        hmap.put("I", "you");
        hmap.put("my", "your");
        hmap.put("me", "you");
        hmap.put("am", "are");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Good day. What is your problem?");
        System.out.println("Enter your response here or Q to quit: ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        input = buf.readLine();

        while (!input.equalsIgnoreCase("q")) {
            Iterator it = hmap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if (input.contains(pair.getKey().toString())) {
                    output = input.replaceAll(pair.getKey().toString(), pair.getValue().toString());
                   // System.out.println("my output "+output);
                    input = output;
                }
            }

            Random rand = new Random();
            int x = rand.nextInt(2);
            switch (x) {
                case 0:
                    int i = rand.nextInt(3);
                    System.out.println(hedges.get(i));
                    output = "";
                    break;
                case 1:
                    int n = rand.nextInt(3);
                    System.out.println(qualifiers.get(n) +" "+ output);
                    output = "";
                    break;
            }
            System.out.println("Enter your response here or Q to quit: ");
            buf = new BufferedReader(new InputStreamReader(System.in));
            input = buf.readLine();
        }
    }
}

