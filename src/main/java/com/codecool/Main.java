package com.codecool;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Main {
    public static void main(String[] args)  {

        try {

            File fXmlFile = new File("Facts.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Fact");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Fact id : " + eElement.getAttribute("id"));
                    System.out.println("Money : " + eElement.getElementsByTagName("Eval").item(0).getTextContent());
                    System.out.println("Sex : " + eElement.getElementsByTagName("Eval").item(1).getTextContent());
                    System.out.println("Drink : " + eElement.getElementsByTagName("Eval").item(2).getTextContent());
                    System.out.println("Gamble : " + eElement.getElementsByTagName("Eval").item(3).getTextContent());
                    System.out.println("Narcotics : " + eElement.getElementsByTagName("Eval").item(4).getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
