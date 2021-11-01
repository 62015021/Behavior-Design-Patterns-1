package Chayaninbuasala;


import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber{

    @Override
    public abstract void onSubscribe(Flow.Subscription subscription);

    @Override
    public abstract void onNext(Object item);

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        //System.out.println("Complete!");
    }
}

