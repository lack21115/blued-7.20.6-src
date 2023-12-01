package java.net;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import libcore.net.UriCodec;

/* loaded from: source-2895416-dex2jar.jar:java/net/JarURLConnection.class */
public abstract class JarURLConnection extends URLConnection {
    private String entryName;
    private String file;
    private URL fileURL;
    protected URLConnection jarFileURLConnection;

    /* JADX INFO: Access modifiers changed from: protected */
    public JarURLConnection(URL url) throws MalformedURLException {
        super(url);
        this.file = decode(url.getFile());
        int indexOf = this.file.indexOf("!/");
        if (indexOf < 0) {
            throw new MalformedURLException();
        }
        this.fileURL = new URL(this.file.substring(0, indexOf));
        int i = indexOf + 2;
        if (this.file.length() == i) {
            return;
        }
        this.entryName = this.file.substring(i, this.file.length());
        if (url.getRef() != null) {
            this.entryName += "#" + url.getRef();
        }
    }

    private static String decode(String str) throws MalformedURLException {
        try {
            return UriCodec.decode(str, false, StandardCharsets.UTF_8, true);
        } catch (IllegalArgumentException e) {
            throw new MalformedURLException("Unable to decode URL", e);
        }
    }

    public Attributes getAttributes() throws IOException {
        JarEntry jarEntry = getJarEntry();
        if (jarEntry == null) {
            return null;
        }
        return jarEntry.getAttributes();
    }

    public Certificate[] getCertificates() throws IOException {
        JarEntry jarEntry = getJarEntry();
        if (jarEntry == null) {
            return null;
        }
        return jarEntry.getCertificates();
    }

    public String getEntryName() {
        return this.entryName;
    }

    public JarEntry getJarEntry() throws IOException {
        if (!this.connected) {
            connect();
        }
        if (this.entryName == null) {
            return null;
        }
        return getJarFile().getJarEntry(this.entryName);
    }

    public abstract JarFile getJarFile() throws IOException;

    public URL getJarFileURL() {
        return this.fileURL;
    }

    public Attributes getMainAttributes() throws IOException {
        Manifest manifest = getJarFile().getManifest();
        if (manifest == null) {
            return null;
        }
        return manifest.getMainAttributes();
    }

    public Manifest getManifest() throws IOException {
        return (Manifest) getJarFile().getManifest().clone();
    }
}
