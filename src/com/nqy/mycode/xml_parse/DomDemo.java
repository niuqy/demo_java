package com.nqy.mycode.xml_parse;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Alexia
 *
 * DOM 解析XML文档
 */
public class DomDemo implements XmlDocument {
    private Document document;

    public void parserXml(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);
            NodeList users = document.getChildNodes();

            System.out.println("----1NodeList size:"+users.getLength());

            for (int i = 0; i < users.getLength(); i++) {
                Node user = users.item(i);
                NodeList userInfo = user.getChildNodes();

                System.out.println("----4userInfo size:"+userInfo.getLength());

                for (int j = 0; j < userInfo.getLength(); j++) {
                    Node node = userInfo.item(j);
                    NodeList userMeta = node.getChildNodes();

                    System.out.println("----3userMeta size:"+userMeta.getLength());

                    for (int k = 0; k < userMeta.getLength(); k++) {
                        if(userMeta.item(k).getNodeName() != "#text")
                            System.out.println(userMeta.item(k).getNodeName()
                                    + ":" + userMeta.item(k).getTextContent());
                    }

                    System.out.println();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parserXml2(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);

            Element root = document.getDocumentElement();
            NodeList list = root.getElementsByTagName("user");
            System.out.println(list.getLength());

            for (int i = 0; i < list.getLength(); i++) {
                //通过item()方法找到集合中的节点，并向下转型为Element对象
                Element n = (Element) list.item(i);
                //获取对象中的属性map，用for循环提取并打印
                NamedNodeMap node = n.getAttributes();
                for (int x = 0; x < node.getLength(); x++) {
                    Node nn = node.item(x);
                    System.out.println(nn.getNodeName() + ": " + nn.getNodeValue());
                }
                NodeList meta = n.getChildNodes();
                for(int j=0;j<meta.getLength();j++){
                    Node m = meta.item(j);
                    if(m.getNodeName() != "#text"){
                        System.out.println(m.getNodeName()+":"+m.getTextContent());
                    }
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToXml(){
        //实例化解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        //创建Document对象
        Document doc = builder.newDocument();

        //创建XML文件所需的各种对象并序列化
        Element root = doc.createElement("root");
        Element name = doc.createElement("name");
        Text nameText = doc.createTextNode("zs");

        name.appendChild(nameText);
        root.appendChild(name);
        doc.appendChild(root);

        name.setAttribute("id", "2");

        doc2XmlFile(doc,"test.xml");

    }

    public void parseAndWrite(String fileName){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);

            Document doc = db.newDocument();
            Element root2 = doc.createElement("dimens");

            Element root = document.getDocumentElement();
            NodeList list = root.getElementsByTagName("dimen");

            for (int i = 0; i < list.getLength(); i++) {
                Element n = (Element) list.item(i);
                Element dimen2 = doc.createElement("dimen");

                NamedNodeMap attrs = n.getAttributes();
                for(int k=0;k<attrs.getLength();k++){
                    Node a = attrs.item(k);
                    dimen2.setAttribute(a.getNodeName(),a.getNodeValue());
                }

                Text nameText;
                if(n.getNodeName() != "#text"){
                    String s = n.getTextContent();
                    s = String.valueOf((int)(Integer.parseInt(s.substring(0,s.length()-2))*0.66+0.5))+s.subSequence(s.length()-2,s.length());
                    nameText = doc.createTextNode(s);
                    dimen2.appendChild(nameText);
                }

                root2.appendChild(dimen2);


            }
            doc.appendChild(root2);
            doc2XmlFile(doc,"dimen.xml");

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean doc2XmlFile(Document document, String filename) {
        boolean flag = true;
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            /** 编码 */
            // transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
        } catch (Exception ex) {
            flag = false;
            ex.printStackTrace();
        }
        return flag;
    }
}