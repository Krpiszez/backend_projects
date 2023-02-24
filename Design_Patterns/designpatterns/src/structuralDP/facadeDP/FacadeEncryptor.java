package structuralDP.facadeDP;

public class FacadeEncryptor {

    private AESEncryptor aesEncryptor = new AESEncryptor();

    private MD5Encryptor md5Encryptor = new MD5Encryptor();

    private SHAEncryptor shaEncryptor = new SHAEncryptor();

    public void encrypt(String text, EncryptType type){ // type represents class for that we are going to create Enum
        switch (type){
            case SHA -> shaEncryptor.encrypt(text, "security key", true);
            case MD5 -> md5Encryptor.encrypt(text, "security key");
            case AES -> aesEncryptor.encrypt(text);
            default -> throw new IllegalArgumentException(type.toString());
        }
    }

    public enum EncryptType{
        SHA,
        MD5,
        AES
    }

}
