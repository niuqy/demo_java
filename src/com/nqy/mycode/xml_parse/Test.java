package com.nqy.mycode.xml_parse;

/**
 * Created by abner on 6/26/15.
 */
public class Test {
    public static void main(String[] args) {
        DomDemo dom = new DomDemo();
        String filePath = "../demo_java/src/com/nqy/mycode/xml_parse/dimen";
//        dom.parserXml2(filePath);
//        dom.writeToXml();
        dom.parseAndWrite(filePath);

//        String s = "410dp";
//        String sub = s.substring(0,s.length()-2);
//        int init = Integer.parseInt(sub);
//        int r = (int) (init*0.66+0.5);
//        System.out.println((int)(Integer.parseInt(s.substring(0,s.length()-2))*0.66+0.5));
    }

    private static void parseUseDom(String file) {
        DomDemo dom = new DomDemo();
        dom.parserXml2(file);
    }
}
