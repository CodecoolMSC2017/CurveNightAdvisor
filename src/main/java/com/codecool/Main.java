package com.codecool;

public class Main {
    public static void main(String[] args)  {

        FactParser f = new FactParser();
        RuleParser r = new RuleParser();
        ESProvider esp = new ESProvider(f,r);

        System.out.println(esp.evaluate());

    }
}
