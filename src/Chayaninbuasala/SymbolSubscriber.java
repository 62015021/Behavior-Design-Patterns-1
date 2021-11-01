package Chayaninbuasala;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolSubscriber extends StringSubscriber {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
        //PrintString
        try {
            FileWriter symbolWT = new FileWriter("symbol.txt", true);
            symbolWT.write(item.toString());
            symbolWT.close();
            System.out.println("Symbol subscriber" + item);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

