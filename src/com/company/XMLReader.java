package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by yezenalnafei on 15/08/2017.
 */
public class XMLReader extends FileReader {

    private String filePath;
    private Element element;
    public XMLReader(String filePath){
        this.filePath = filePath;
    }


    @Override
    public List<User> read() {

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document document = dBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList =  document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){

                    element = (Element) node;

                    super.addUser(new User(getElementContext("userid"), getElementContext("firstname"),
                            getElementContext("surname"), getElementContext("username"),
                            getElementContext("type"), getElementContext("lastlogintime") ));
                }

            }



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.getUsers();

    }

    @Override
    public void write() {

    }


    private String getElementContext(String itemName){
        return element.getElementsByTagName(itemName).item(0).getTextContent();
    }
}
