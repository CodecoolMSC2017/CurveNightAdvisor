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


        RuleParser r = new RuleParser();
        System.out.println(r.RuleRepository.questionMap.get("narcotics").getEvaluatedAnswer("weed"));
        FactParser f = new FactParser();
        System.out.println(f.factRepository.factMap.get("vegas").getDescription());
        System.out.println(f.factRepository.factIterator);
        System.out.println(r.RuleRepository.questionIterator);
    }
}
