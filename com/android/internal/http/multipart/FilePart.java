package com.android.internal.http.multipart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.util.EncodingUtils;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:com/android/internal/http/multipart/FilePart.class */
public class FilePart extends PartBase {
    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    private PartSource source;
    private static final Log LOG = LogFactory.getLog(FilePart.class);
    protected static final String FILE_NAME = "; filename=";
    private static final byte[] FILE_NAME_BYTES = EncodingUtils.getAsciiBytes(FILE_NAME);

    public FilePart(String str, PartSource partSource) {
        this(str, partSource, (String) null, (String) null);
    }

    public FilePart(String str, PartSource partSource, String str2, String str3) {
        super(str, str2 == null ? DEFAULT_CONTENT_TYPE : str2, str3 == null ? "ISO-8859-1" : str3, DEFAULT_TRANSFER_ENCODING);
        if (partSource == null) {
            throw new IllegalArgumentException("Source may not be null");
        }
        this.source = partSource;
    }

    public FilePart(String str, File file) throws FileNotFoundException {
        this(str, new FilePartSource(file), (String) null, (String) null);
    }

    public FilePart(String str, File file, String str2, String str3) throws FileNotFoundException {
        this(str, new FilePartSource(file), str2, str3);
    }

    public FilePart(String str, String str2, File file) throws FileNotFoundException {
        this(str, new FilePartSource(str2, file), (String) null, (String) null);
    }

    public FilePart(String str, String str2, File file, String str3, String str4) throws FileNotFoundException {
        this(str, new FilePartSource(str2, file), str3, str4);
    }

    protected PartSource getSource() {
        LOG.trace("enter getSource()");
        return this.source;
    }

    @Override // com.android.internal.http.multipart.Part
    protected long lengthOfData() {
        LOG.trace("enter lengthOfData()");
        return this.source.getLength();
    }

    @Override // com.android.internal.http.multipart.Part
    protected void sendData(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendData(OutputStream out)");
        if (lengthOfData() == 0) {
            LOG.debug("No data to send.");
            return;
        }
        byte[] bArr = new byte[4096];
        InputStream createInputStream = this.source.createInputStream();
        while (true) {
            try {
                int read = createInputStream.read(bArr);
                if (read < 0) {
                    return;
                }
                outputStream.write(bArr, 0, read);
            } finally {
                createInputStream.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.http.multipart.Part
    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendDispositionHeader(OutputStream out)");
        super.sendDispositionHeader(outputStream);
        String fileName = this.source.getFileName();
        if (fileName != null) {
            outputStream.write(FILE_NAME_BYTES);
            outputStream.write(QUOTE_BYTES);
            outputStream.write(EncodingUtils.getAsciiBytes(fileName));
            outputStream.write(QUOTE_BYTES);
        }
    }
}
