package org.xml.sax;

import java.io.InputStream;
import java.io.Reader;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/InputSource.class */
public class InputSource {
    private InputStream byteStream;
    private Reader characterStream;
    private String encoding;
    private String publicId;
    private String systemId;

    public InputSource() {
    }

    public InputSource(InputStream inputStream) {
        setByteStream(inputStream);
    }

    public InputSource(Reader reader) {
        setCharacterStream(reader);
    }

    public InputSource(String str) {
        setSystemId(str);
    }

    public InputStream getByteStream() {
        return this.byteStream;
    }

    public Reader getCharacterStream() {
        return this.characterStream;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public String getPublicId() {
        return this.publicId;
    }

    public String getSystemId() {
        return this.systemId;
    }

    public void setByteStream(InputStream inputStream) {
        this.byteStream = inputStream;
    }

    public void setCharacterStream(Reader reader) {
        this.characterStream = reader;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setPublicId(String str) {
        this.publicId = str;
    }

    public void setSystemId(String str) {
        this.systemId = str;
    }
}
