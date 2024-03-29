package behavioralDP.mediatorDP;

public class MessageTeacher implements Teacher{

    String name;


    Dispatcher dispatcher;

    public MessageTeacher(String name, Dispatcher dispatcher) {
        this.name = name;
        this.dispatcher = dispatcher;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name+" received message: "+message);
    }

    @Override
    public void sendMessage(String topic, String message) {

        dispatcher.dispatch(topic, message);

    }
}
