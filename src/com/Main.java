package com;

import com.parser.AbstractParser;
import com.parser.AmountParser;
import com.parser.CurrencyParser;
import com.parser.ValueDateParser;
import com.worker.ParserWorker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId() + " Starting Program......");
        // write your code here

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Collection<Callable<Map<String, String>>> collectionOfTasks = new ArrayList<>();

        for(AbstractParser parser : constructAllParsers()) {
            collectionOfTasks.add(new ParserWorker(parser));
        }

        Collection<Future<Map<String, String>>> futuresCollection = new ArrayList<>();

        try {
            //This is a blocking IO and will wait till all the tasks are complete
            futuresCollection = executor.invokeAll(collectionOfTasks);

            for(Future<Map<String, String>> future : futuresCollection) {
                if(future.get()!=null) {
                    System.out.println(Thread.currentThread().getId() + ":" + future.get().toString());
                }
            }

        } catch (InterruptedException | ExecutionException e) {
            // ... Exception handling code ...
        }
        executor.shutdown();
    }

    public static Collection<AbstractParser> constructAllParsers(){
        // All Parsers that will be invoked by Executors
        AbstractParser currencyParser = new CurrencyParser();
        currencyParser.setMessage("Swift Message");

        AbstractParser amountParser = new AmountParser();
        amountParser.setMessage("Swift Message");

        AbstractParser valueDateParser = new ValueDateParser();
        amountParser.setMessage("Swift Message");

        //Created collection of AbstractParser

        Collection<AbstractParser> parsers = new ArrayList<AbstractParser>();
        parsers.add(currencyParser);
        parsers.add(amountParser);
        parsers.add(valueDateParser);
        return parsers;
    }
}
