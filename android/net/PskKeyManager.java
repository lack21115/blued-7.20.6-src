package android.net;

import com.android.org.conscrypt.PSKKeyManager;
import java.net.Socket;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngine;

/* loaded from: source-9557208-dex2jar.jar:android/net/PskKeyManager.class */
public abstract class PskKeyManager implements PSKKeyManager {
    public static final int MAX_IDENTITY_HINT_LENGTH_BYTES = 128;
    public static final int MAX_IDENTITY_LENGTH_BYTES = 128;
    public static final int MAX_KEY_LENGTH_BYTES = 256;

    public String chooseClientKeyIdentity(String str, Socket socket) {
        return "";
    }

    public String chooseClientKeyIdentity(String str, SSLEngine sSLEngine) {
        return "";
    }

    public String chooseServerKeyIdentityHint(Socket socket) {
        return null;
    }

    public String chooseServerKeyIdentityHint(SSLEngine sSLEngine) {
        return null;
    }

    public SecretKey getKey(String str, String str2, Socket socket) {
        return null;
    }

    public SecretKey getKey(String str, String str2, SSLEngine sSLEngine) {
        return null;
    }
}
