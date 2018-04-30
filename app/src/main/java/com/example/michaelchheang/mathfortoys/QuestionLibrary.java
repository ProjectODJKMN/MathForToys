package com.example.michaelchheang.mathfortoys;

import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;

public class QuestionLibrary {

    private int answer;
    private Random random = new Random();
    private ArrayList<Integer> num = new ArrayList<>();
    int x,y,z,n;

    public String getQuestion(int j) {
        num.clear();
        switch (j) {
            case 0:
                x = random.nextInt(11);
                y = random.nextInt(11);
                z = random.nextInt(2);
                answer = (z == 0) ? x + y : Math.max(x, y) - Math.min(x, y);
                num.add(answer);
                while (num.size() < 4) {
                    n = (answer + (random.nextInt(200)) % 11);
                    if (!num.contains(n)) {
                        num.add(n);
                    }
                }
                return (z == 0) ? x + " + " + y : Math.max(x, y) + " - " + Math.min(x, y);

            case 1:
                x = random.nextInt(51);
                y = random.nextInt(51);
                z = random.nextInt(4);
                switch (z) {
                    case 0:
                        fillQuestions(x, y, z);
                        return x + " + " + y;
                    case 1:
                        fillQuestions(x, y, z);
                        return x + " - " + y;
                    case 2:
                        x = random.nextInt(7) + 1;
                        y = random.nextInt(7) + 1;
                        fillQuestions(x, y, z);
                        return x + " x " + y;

                    case 3:
                        x = random.nextInt(7) + 1;
                        y = random.nextInt(7) + 1;
                        fillQuestions(x, y, z);
                        return x * y + " ÷ " + y;
                    default:
                        return "broken";
                }
            case 2:
                x = random.nextInt(101);
                y = random.nextInt(101);
                z = random.nextInt(4);
                switch (z) {
                    case 0:
                        fillQuestions(x, y, z);
                        return x + " + " + y;
                    case 1:
                        fillQuestions(x, y, z);
                        return x + " - " + y;
                    case 2:
                        x = random.nextInt(13) + 1;
                        y = random.nextInt(13) + 1;
                        fillQuestions(x, y, z);
                        return x + " x " + y;

                    case 3:
                        x = random.nextInt(13) + 1;
                        y = random.nextInt(13) + 2;
                        fillQuestions(x, y, z);
                        return x * y + " ÷ " + y;
                    default:
                        return "broken";
                }
            default:
                return "broken";
        }
    }

    public int getChoice(int k) {
        return (num.get(k));
    }
    public int getAnswer(){
        return answer;
    }
    public void fillQuestions(int x, int y, int z){
        switch(z){
            case 0:
                answer = x + y;
                num.add(answer);
                while (num.size() < 4) {
                    n = (answer + ((random.nextInt(11)) % 11) - (random.nextInt(6) % 11));
                    if (!num.contains(n)) {
                        num.add(n);
                    }
                }
                break;
            case 1:
                answer = x - y;
                num.add(answer);
                while (num.size() < 4) {
                    n = (answer + ((random.nextInt(11)) % 11) - (random.nextInt(6) % 11));
                    if (!num.contains(n)) {
                        num.add(n);
                    }
                }
                break;
            case 2:
                answer = x * y;
                num.add(answer);
                while (num.size() < 4) {
                    n = (x * ((random.nextInt(5) + 1)) - (random.nextInt(x) + 1));
                    if (!num.contains(n)) {
                        num.add(n);
                    }
                }
                break;
            case 3:
                answer = x;
                num.add(answer);
                while (num.size() < 4) {
                    n = (y + (random.nextInt(5)) - (random.nextInt(y) + 1));
                    if (!num.contains(n)) {
                        num.add(n);
                    }
                }
                break;
            case 4:
                num.add(1);
                num.add(2);
                num.add(3);
                num.add(4);
                break;
            default:
                System.out.println("sup " + answer);
        }
    }
}