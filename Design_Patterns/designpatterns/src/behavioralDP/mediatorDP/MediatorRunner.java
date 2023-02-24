package behavioralDP.mediatorDP;

public class MediatorRunner {

    public static void main(String[] args) {
     mediator();
    }

    static void mediator(){
        //dispatcher obj
        MessageDispatcher dispatcher = new MessageDispatcher();

        //create 4 teacher/experts
        Teacher chemistryTeacher = new MessageTeacher("ChemistryTeacher", dispatcher);
        Teacher mathTeacher = new MessageTeacher("MathematicsTeacher", dispatcher);
        Teacher physicsTeacher = new MessageTeacher("PhysicsTeacher", dispatcher);
        Teacher biologyTeacher = new MessageTeacher("BiologyTeacher", dispatcher);


        //register teacher to the dispathcer
        dispatcher.register("chemistry", chemistryTeacher);
        dispatcher.register("mathematics", mathTeacher);
        dispatcher.register("physics", physicsTeacher);
        dispatcher.register("biology", biologyTeacher);


        //one teacher can ask question from other

        chemistryTeacher.sendMessage("mathematics", "Message about Math");
        chemistryTeacher.sendMessage("physics", "Message about Physics");
        chemistryTeacher.sendMessage("biology", "Message about Biology");


    }
}
