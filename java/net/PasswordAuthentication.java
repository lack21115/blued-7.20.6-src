package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/PasswordAuthentication.class */
public final class PasswordAuthentication {
    private char[] password;
    private String userName;

    public PasswordAuthentication(String str, char[] cArr) {
        this.userName = str;
        this.password = (char[]) cArr.clone();
    }

    public char[] getPassword() {
        return (char[]) this.password.clone();
    }

    public String getUserName() {
        return this.userName;
    }
}
