package Chayaninbuasala;

import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {
    Flow.Subscriber subscriber;
    String item;
    public long numcounter;

    public StringSubscription(Flow.Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {
        this.numcounter = n;
    }

    @Override
    public void cancel() {
        this.numcounter=0;
    }

    public void senddata(String str) {
        this.item = str;
        for(int i=0; i<numcounter; i++) {
            subscriber.onNext(item);
        }
        subscriber.onComplete();
    }
}

