package behavioralDP.observerDP;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency{
    private String news;

    private List<Channel> channelList = new ArrayList<>();

    //register channels
    public void addObserver(Channel channel){
        channelList.add(channel);
    }

    //remove channels from the list
    public void removeObserver(Channel channel){
        channelList.remove(channel);
    }

    //method to send updates/news to the registered channels
    public void sendNews(String news){
        this.news = news;
        for(Channel channel: channelList){
            channel.update(this.news);
        }
    }
}
