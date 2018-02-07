package com.codecool;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args)  {

        FactParser f = new FactParser();
        RuleParser r = new RuleParser();
        ESProvider esp = new ESProvider(f,r);

        System.out.println(esp.evaluate());

    }
}
