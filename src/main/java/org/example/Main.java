package org.example;

public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        System.out.println("Second Commit!");

        cat firstcat = new cat("Барсик","бежевый", 2);
        cat secondcat = new cat("Мурзик", "черно-белый", 3);

        System.out.println("Данные первого кота : " + firstcat.getName() + " ,"
                + firstcat.getColor() + " ," + firstcat.getAge());


        System.out.println("Данные второго кота : " + secondcat.getName() + " ,"
                + secondcat.getColor() + " ," + secondcat.getAge());
    }

}