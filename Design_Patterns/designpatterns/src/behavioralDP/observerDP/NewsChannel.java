package behavioralDP.observerDP;

import java.util.ArrayList;
import java.util.List;

public class NewsChannel implements Channel{

    List<String> newsList = new ArrayList<>();


    @Override
    public void update(String news) {
        newsList.add(news);
    }

    @Override
    public void printNews() {
        for (String w: newsList){
            System.out.println(w);
        }
    }
}
