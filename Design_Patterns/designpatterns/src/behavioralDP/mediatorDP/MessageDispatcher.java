package behavioralDP.mediatorDP;

import java.util.HashMap;
import java.util.Map;

public class MessageDispatcher implements Dispatcher{

    //dispatcher class should know where to send message
    Map<String, Teacher> registeredTeacher  = new HashMap<>();

    void register(String topic, Teacher teacher){
        registeredTeacher.put(topic, teacher);
    }

    @Override
    public void dispatch(String topic, String message) {

        Teacher teacher = registeredTeacher.get(topic);
        if(teacher == null){
            System.out.println("No teacher registered for this topic...");
        }else {
            teacher.receiveMessage(message);
        }

    }
}
