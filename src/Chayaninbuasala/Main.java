package Chayaninbuasala;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //สร้างตัวเเปลเอาไว้มารับการซับกัน
        StringPublisher publisher = new StringPublisher();
        StringSubscriber alphabetSubscriber = new AlphabetSubscriber();
        StringSubscriber numberSubscriber = new NumberSubscriber();
        StringSubscriber symbolSubscriber = new SymbolSubscriber();

        publisher.subscribe(alphabetSubscriber);
        publisher.subscribe(numberSubscriber);
        publisher.subscribe(symbolSubscriber);
        while (true) {
            System.out.println("=====================");
            System.out.print("Enter string: ");
            Scanner input = new Scanner(System.in);
            String myString = input.nextLine();
            publisher.publishString(myString);
        }
    }
}
