package com.parser;

import java.util.HashMap;
import java.util.Map;

//Your Factory class to parse Amount
public class AmountParser extends AbstractParser {


    @Override
    public Map<String,String> parse() {
        super.getMessage();
        //Common Method Invoked to get Regular Expression
        String regularExpression = super.getRegularExpression("AMOUNT_REGEX");

        Map<String, String> myMap = new HashMap<>();
        myMap.put("AMOUNT","12345.00");
        return myMap;
    }
}
