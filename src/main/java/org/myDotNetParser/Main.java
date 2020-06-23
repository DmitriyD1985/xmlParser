package org.myDotNetParser;


public class Main {

    public static void main(String[] args) {
        DotNetParser dotNetParser = new DotNetParser();
        String result = dotNetParser.parseStringFromDotNet();
        System.out.println(result);
//        Person value = xmlMapper.readValue(XML, Person.class);
    }
}
