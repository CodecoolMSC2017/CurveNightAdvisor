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
        /*System.out.println(r.RuleRepository.questionMap.get("narcotics").getEvaluatedAnswer("weed"));
        System.out.println(f.factRepository.factMap.get("vegas").getDescription());
        System.out.println(f.factRepository.factIterator);
        System.out.println(r.RuleRepository.questionIterator);
        for (int i = 0;i<r.values.size();i++){
            for (String str : r.values.get(i)){
                System.out.println(str);
            }
        }*/
        esp.collectAnswers();
        System.out.println(esp.inputMap.get("narcotics"));
        System.out.println(esp.inputMap.get("money"));
        System.out.println(esp.inputMap.get("gamble"));
        System.out.println(esp.inputMap.get("sex"));

    }
}
