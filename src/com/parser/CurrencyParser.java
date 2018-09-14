package com.parser;

import java.util.HashMap;
import java.util.Map;

//Your Factory class to parse Currency
public class CurrencyParser extends AbstractParser {

    @Override
    public Map<String,String> parse() {
        super.getMessage();
        //Common Method Invoked to get Regular Expression
        String regularExpression = super.getRegularExpression("CURRENCY_REGEX");

        Map<String, String> myMap = new HashMap<>();
        myMap.put("CURRENCY","USD");
        return myMap;
    }
}
