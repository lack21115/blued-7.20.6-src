package com.android.internal.http.multipart;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EncodingUtils;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:com/android/internal/http/multipart/MultipartEntity.class */
public class MultipartEntity extends AbstractHttpEntity {
    public static final String MULTIPART_BOUNDARY = "http.method.multipart.boundary";
    private static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    private boolean contentConsumed = false;
    private byte[] multipartBoundary;
    private HttpParams params;
    protected Part[] parts;
    private static final Log log = LogFactory.getLog(MultipartEntity.class);
    private static byte[] MULTIPART_CHARS = EncodingUtils.getAsciiBytes("-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

    public MultipartEntity(Part[] partArr) {
        setContentType("multipart/form-data");
        if (partArr == null) {
            throw new IllegalArgumentException("parts cannot be null");
        }
        this.parts = partArr;
        this.params = null;
    }

    public MultipartEntity(Part[] partArr, HttpParams httpParams) {
        if (partArr == null) {
            throw new IllegalArgumentException("parts cannot be null");
        }
        if (httpParams == null) {
            throw new IllegalArgumentException("params cannot be null");
        }
        this.parts = partArr;
        this.params = httpParams;
    }

    private static byte[] generateMultipartBoundary() {
        Random random = new Random();
        byte[] bArr = new byte[random.nextInt(11) + 30];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return bArr;
            }
            bArr[i2] = MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)];
            i = i2 + 1;
        }
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        if (isRepeatable() || !this.contentConsumed) {
            this.contentConsumed = true;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Part.sendParts(byteArrayOutputStream, this.parts, this.multipartBoundary);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        throw new IllegalStateException("Content has been consumed");
    }

    public long getContentLength() {
        try {
            return Part.getLengthOfParts(this.parts, getMultipartBoundary());
        } catch (Exception e) {
            log.error("An exception occurred while getting the length of the parts", e);
            return 0L;
        }
    }

    public Header getContentType() {
        StringBuffer stringBuffer = new StringBuffer("multipart/form-data");
        stringBuffer.append("; boundary=");
        stringBuffer.append(EncodingUtils.getAsciiString(getMultipartBoundary()));
        return new BasicHeader("Content-Type", stringBuffer.toString());
    }

    protected byte[] getMultipartBoundary() {
        if (this.multipartBoundary == null) {
            String str = null;
            if (this.params != null) {
                str = (String) this.params.getParameter(MULTIPART_BOUNDARY);
            }
            if (str != null) {
                this.multipartBoundary = EncodingUtils.getAsciiBytes(str);
            } else {
                this.multipartBoundary = generateMultipartBoundary();
            }
        }
        return this.multipartBoundary;
    }

    public boolean isRepeatable() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.parts.length) {
                return true;
            }
            if (!this.parts[i2].isRepeatable()) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Part.sendParts(outputStream, this.parts, getMultipartBoundary());
    }
}
