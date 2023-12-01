package java.security;

import java.io.Serializable;
import java.net.URL;

/* loaded from: source-2895416-dex2jar.jar:java/security/CodeSource.class */
public class CodeSource implements Serializable {
    public CodeSource(URL url, CodeSigner[] codeSignerArr) {
    }

    public CodeSource(URL url, java.security.cert.Certificate[] certificateArr) {
    }

    public final java.security.cert.Certificate[] getCertificates() {
        return null;
    }

    public final CodeSigner[] getCodeSigners() {
        return null;
    }

    public final URL getLocation() {
        return null;
    }

    public boolean implies(CodeSource codeSource) {
        return true;
    }
}
