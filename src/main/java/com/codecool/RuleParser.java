package com.codecool;



import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleParser extends XMLParser{
    RuleRepository RuleRepository;
    List<String[]> values = new ArrayList<String[]>();


    public RuleParser(){
        RuleRepository = getRepository();
    }



    public RuleRepository getRepository() {
        RuleRepository ruleRepository = new RuleRepository();
        try {
            loadXmlDocument("Rules.xml");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
            NodeList nlist = doc.getElementsByTagName("Rule");
            for(int i = 0; i < nlist.getLength(); i++){
                Node node = nlist.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String id = eElement.getAttribute("id");

                    Answer answer = new Answer();

                    Node n = eElement.getElementsByTagName("Answer").item(0);
                    for(int k = 0; k < 2; k++){
                        boolean bool = false;
                    Node selection = ((Element)n).getElementsByTagName("Selection").item(k);
                    Element e = (Element)selection;
                    String value;
                    if(e.getElementsByTagName("MultipleValue").getLength() != 0){
                        value = e.getElementsByTagName("MultipleValue").item(0).getAttributes().getNamedItem("value").getNodeValue();

                        if(k == 0) {
                            bool = true;

                        }
                        String[] temp = value.split(",");
                        values.add(temp);
                        answer.addValue(new MultipleValue(Arrays.asList(value.split(",")),bool));
                    }
                    else{
                        value = e.getElementsByTagName("SingleValue").item(0).getAttributes().getNamedItem("value").getNodeValue();
                        if(k == 0) {
                            bool = true;

                        }
                        answer.addValue(new SingleValue(value,bool));
                    }

                        }
                    Question question = new Question(id,eElement.getElementsByTagName("Question").item(0).getTextContent(),answer);
                    ruleRepository.addQuestion(question);
                    }
                }

            return ruleRepository;
        }

}

