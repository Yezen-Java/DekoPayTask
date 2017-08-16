package com.company;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Executable;
import java.util.List;

/**
 * Created by yezenalnafei on 15/08/2017.
 */
public class XMLReader extends FileReader {

    private Element element;
    public XMLReader(String filePath){
        super(filePath);
    }


    @Override
    public List<User> read() {

        try {
            File xmlFile = new File(getFilePath());
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
    public void write(List<User> users) {

        try{

            XStream xstream = new XStream(new DomDriver("UTF-8"));
            xstream.alias("user", User.class);
            xstream.alias("users", Users.class);
            xstream.aliasField("userid", User.class, "userId");
            xstream.aliasField("firstname", User.class, "firstName");
            xstream.aliasField("lastname", User.class, "lastName");
            xstream.aliasField("username", User.class, "userName");
            xstream.aliasField("useryype", User.class, "userType");
            xstream.aliasField("lastlogintime", User.class, "lastLoginTIme");


            xstream.addImplicitCollection(Users.class, "users");
            Users user2 = new Users();
                    user2.setUsers(users);
            String xml = xstream.toXML(user2);

            super.outputToFile(xml);

            System.out.println(xml);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    private String getElementContext(String itemName){
        return element.getElementsByTagName(itemName).item(0).getTextContent();
    }
}
