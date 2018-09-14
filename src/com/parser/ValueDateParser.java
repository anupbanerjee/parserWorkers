package com.parser;

import java.util.HashMap;
import java.util.Map;

//Your Factory class to parse ValueDate
public class ValueDateParser extends AbstractParser{
    @Override
    public Map<String,String> parse() {
        super.getMessage();
        //Common Method Invoked to get Regular Expression
        String regularExpression = super.getRegularExpression("VALUE_DATE_REGEX");
        //Map<String, String> myMap = new HashMap<>();
        //myMap.put("VALUE_DATE","2018-10-31");
        //return myMap;
        return null;
    }
}
