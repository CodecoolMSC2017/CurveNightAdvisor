package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser {
    FactRepository factRepository;


    public FactParser() {
        factRepository = getFactRepository();
    }

    public FactRepository getFactRepository() {
        FactRepository factRepo = new FactRepository();
        boolean value;
        Fact fact;

        try {
            loadXmlDocument("Facts.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        NodeList nlist = doc.getElementsByTagName("Fact");

        for (int i = 0; i < nlist.getLength(); i++) {
            Node node = nlist.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;
                String id = eElement.getAttribute("id");

                String description = eElement.getElementsByTagName("Description").item(0).getAttributes().getNamedItem("value").getNodeValue();

                fact = new Fact(description);
                NodeList evals = eElement.getElementsByTagName("Eval");

                for (int k = 0; k < evals.getLength(); k++) {

                    Node mNode = evals.item(k);
                    if (mNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eval = (Element) mNode;
                        String evalId = eval.getAttribute("id");
                        value = Boolean.parseBoolean(eval.getTextContent().trim());

                        fact.setFactValueById(evalId, value);
                    }

                }
                factRepo.addFact(id, fact);

            }
        }
        return factRepo;
    }
}
