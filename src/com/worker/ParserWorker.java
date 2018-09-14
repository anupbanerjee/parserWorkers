package com.worker;

import com.parser.AbstractParser;

import java.util.Map;
import java.util.concurrent.Callable;

public class ParserWorker implements Callable<Map<String,String>> {
    private final AbstractParser parser;

    public ParserWorker(AbstractParser parser) {
        this.parser = parser;
    }

    @Override
    public Map<String,String> call()  {
        return parser.parse();
    }
}