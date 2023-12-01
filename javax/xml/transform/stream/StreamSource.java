package javax.xml.transform.stream;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import javax.xml.transform.Source;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/stream/StreamSource.class */
public class StreamSource implements Source {
    public static final String FEATURE = "http://javax.xml.transform.stream.StreamSource/feature";
    private InputStream inputStream;
    private String publicId;
    private Reader reader;
    private String systemId;

    public StreamSource() {
    }

    public StreamSource(File file) {
        setSystemId(file);
    }

    public StreamSource(InputStream inputStream) {
        setInputStream(inputStream);
    }

    public StreamSource(InputStream inputStream, String str) {
        setInputStream(inputStream);
        setSystemId(str);
    }

    public StreamSource(Reader reader) {
        setReader(reader);
    }

    public StreamSource(Reader reader, String str) {
        setReader(reader);
        setSystemId(str);
    }

    public StreamSource(String str) {
        this.systemId = str;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public String getPublicId() {
        return this.publicId;
    }

    public Reader getReader() {
        return this.reader;
    }

    @Override // javax.xml.transform.Source
    public String getSystemId() {
        return this.systemId;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setPublicId(String str) {
        this.publicId = str;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setSystemId(File file) {
        this.systemId = FilePathToURI.filepath2URI(file.getAbsolutePath());
    }

    @Override // javax.xml.transform.Source
    public void setSystemId(String str) {
        this.systemId = str;
    }
}
