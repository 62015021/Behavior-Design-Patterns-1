package Chayaninbuasala;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;


public class AlphabetSubscriber extends StringSubscriber {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Object item) {

        try {
            FileWriter Alwriter = new FileWriter("al.txt", true);
            Alwriter.write(item.toString());
            Alwriter.close();
            System.out.println("Al subscriber: " + item);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}