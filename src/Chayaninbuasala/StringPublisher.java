package Chayaninbuasala;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPublisher implements Flow.Publisher {
    List<StringSubscription> collectinfo = new ArrayList<>();
    private String StringBuffer;


    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        StringSubscription subscrip = new StringSubscription(subscriber);
        collectinfo.add(subscrip);
        subscriber.onSubscribe(subscrip);
    }


    public void publishString(String str) {
        StringBuffer = str;


        for(StringSubscription subscription : collectinfo) {
            if(subscription.subscriber instanceof AlphabetSubscriber && hasPattern("[a-zA-z]")) {
                subscription.senddata(StringBuffer);
            }
            if(subscription.subscriber instanceof NumberSubscriber && hasPattern("[0-9]")) {
                subscription.senddata(StringBuffer);
            }
            if(subscription.subscriber instanceof SymbolSubscriber && hasPattern("[,!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]")) {
                subscription.senddata(StringBuffer);
            }
        }
    }

    private boolean hasPattern( String pattern) {
        Pattern stringItem = Pattern.compile(pattern);
        Matcher result = stringItem.matcher(StringBuffer);
        return result.find();
    }

}