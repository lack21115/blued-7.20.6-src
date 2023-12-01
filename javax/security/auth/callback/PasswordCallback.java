package javax.security.auth.callback;

import java.io.Serializable;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/callback/PasswordCallback.class */
public class PasswordCallback implements Callback, Serializable {
    private static final long serialVersionUID = 2267422647454909926L;
    boolean echoOn;
    private char[] inputPassword;
    private String prompt;

    public PasswordCallback(String str, boolean z) {
        setPrompt(str);
        this.echoOn = z;
    }

    private void setPrompt(String str) throws IllegalArgumentException {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid prompt");
        }
        this.prompt = str;
    }

    public void clearPassword() {
        if (this.inputPassword != null) {
            Arrays.fill(this.inputPassword, (char) 0);
        }
    }

    public char[] getPassword() {
        if (this.inputPassword != null) {
            char[] cArr = new char[this.inputPassword.length];
            System.arraycopy(this.inputPassword, 0, cArr, 0, cArr.length);
            return cArr;
        }
        return null;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public boolean isEchoOn() {
        return this.echoOn;
    }

    public void setPassword(char[] cArr) {
        if (cArr == null) {
            this.inputPassword = cArr;
            return;
        }
        this.inputPassword = new char[cArr.length];
        System.arraycopy(cArr, 0, this.inputPassword, 0, this.inputPassword.length);
    }
}
