package java.security.cert;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/Extension.class */
public interface Extension {
    void encode(OutputStream outputStream) throws IOException;

    String getId();

    byte[] getValue();

    boolean isCritical();
}
