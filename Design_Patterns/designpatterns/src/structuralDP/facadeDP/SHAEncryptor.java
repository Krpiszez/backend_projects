package structuralDP.facadeDP;

public class SHAEncryptor {

    public void encrypt(String text, String security, boolean type){
        if (type){
            System.out.println("<SHA> " + text +" "+security+" <SHA>");
        }else System.out.println("<SHA> " + security +" "+text+" <SHA>");

    }

}
