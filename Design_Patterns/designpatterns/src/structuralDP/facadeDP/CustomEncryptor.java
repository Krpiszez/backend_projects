package structuralDP.facadeDP;

public class CustomEncryptor {

    public static void main(String[] args) {
        //without FacadeDP
        String text = "context";

        AESEncryptor aesEncryptor = new AESEncryptor();
        aesEncryptor.encrypt(text);

        MD5Encryptor md5Encryptor = new MD5Encryptor();
        md5Encryptor.encrypt(text, "security key");

        SHAEncryptor shaEncryptor = new SHAEncryptor();
        shaEncryptor.encrypt(text, "security key", true);

        //with FacadeDP (see FacadeDP class.)
        FacadeEncryptor encryptor = new FacadeEncryptor();
        encryptor.encrypt(text, FacadeEncryptor.EncryptType.AES); // it is using the encrypt method from Facade which acts like kinda interface.
        // thanks to method we create and use the class we create object from as parameter with the help of Enum.
        encryptor.encrypt(text, FacadeEncryptor.EncryptType.SHA);
        encryptor.encrypt(text, FacadeEncryptor.EncryptType.MD5);


    }

}
