package behavioralDP.observerDP;

public class ObserverRunner {
    public static void main(String[] args) {

        ObserverRunner runner =new ObserverRunner();
        runner.observerDemo();

    }

    void observerDemo(){

        //channel obj
        Channel channel1 = new NewsChannel();
        Channel channel2 = new NewsChannel();
        Channel channel3 = new NewsChannel();

        //agency obj
        NewsAgency agency = new NewsAgency();

        //register channels to the agency

        agency.addObserver(channel1);
        agency.addObserver(channel2);
        agency.addObserver(channel3);

        //new news/posts
        agency.sendNews("Learn Java at techproed");
        agency.sendNews("Batch 110-111 students are about to complete the bootcamp");

        System.out.println("News from Channel 1: ");
        channel1.printNews();

        System.out.println("News from Channel 2: ");
        channel2.printNews();

        System.out.println("News from Channel 3: ");
        channel3.printNews();



    }
}
