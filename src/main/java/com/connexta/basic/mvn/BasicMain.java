package com.connexta.basic.mvn;


public class BasicMain {
    public static final String MY_THOUGHTS = "Hello World!";
    String myWords = BasicMain.MY_THOUGHTS;

    public static void main(String[] args) {
        BasicMain myMind = new BasicMain();
        System.out.println(myMind.speak());
        myMind.interject("Changed it!");
        System.out.println(myMind.speak());
    }

    public String speak() {
        return myWords;
    }

    public void interject(String statement) {
        myWords = statement;
    }

}
