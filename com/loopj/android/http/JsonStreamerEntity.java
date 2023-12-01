package com.loopj.android.http;

import android.util.Log;
import com.huawei.hms.ads.fw;
import com.igexin.push.core.b;
import com.loopj.android.http.RequestParams;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/JsonStreamerEntity.class */
public class JsonStreamerEntity implements HttpEntity {
    private static final int BUFFER_SIZE = 4096;
    private static final String LOG_TAG = "JsonStreamerEntity";
    private final Header contentEncoding;
    private final ResponseHandlerInterface progressHandler;
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final StringBuilder BUILDER = new StringBuilder(128);
    private static final byte[] JSON_TRUE = fw.Code.getBytes();
    private static final byte[] JSON_FALSE = "false".getBytes();
    private static final byte[] JSON_NULL = b.l.getBytes();
    private static final byte[] STREAM_NAME = escape("name");
    private static final byte[] STREAM_TYPE = escape("type");
    private static final byte[] STREAM_CONTENTS = escape("contents");
    private static final byte[] STREAM_ELAPSED = escape("_elapsed");
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
    private final byte[] buffer = new byte[4096];
    private final Map<String, Object> jsonParams = new HashMap();

    public JsonStreamerEntity(ResponseHandlerInterface responseHandlerInterface, boolean z) {
        this.progressHandler = responseHandlerInterface;
        this.contentEncoding = z ? HEADER_GZIP_ENCODING : null;
    }

    private void endMetaData(OutputStream outputStream) throws IOException {
        outputStream.write(34);
    }

    static byte[] escape(String str) {
        if (str == null) {
            return JSON_NULL;
        }
        BUILDER.append('\"');
        int length = str.length();
        int i = -1;
        while (true) {
            int i2 = i + 1;
            if (i2 >= length) {
                BUILDER.append('\"');
                try {
                    byte[] bytes = BUILDER.toString().getBytes();
                    BUILDER.setLength(0);
                    return bytes;
                } catch (Throwable th) {
                    BUILDER.setLength(0);
                    throw th;
                }
            }
            char charAt = str.charAt(i2);
            if (charAt == '\f') {
                BUILDER.append("\\f");
                i = i2;
            } else if (charAt == '\r') {
                BUILDER.append("\\r");
                i = i2;
            } else if (charAt == '\"') {
                BUILDER.append("\\\"");
                i = i2;
            } else if (charAt != '\\') {
                switch (charAt) {
                    case '\b':
                        BUILDER.append("\\b");
                        i = i2;
                        continue;
                    case '\t':
                        BUILDER.append("\\t");
                        i = i2;
                        continue;
                    case '\n':
                        BUILDER.append("\\n");
                        i = i2;
                        continue;
                    default:
                        if ((charAt < 0 || charAt > 31) && ((charAt < 127 || charAt > 159) && (charAt < 8192 || charAt > 8447))) {
                            BUILDER.append(charAt);
                            i = i2;
                            break;
                        } else {
                            String hexString = Integer.toHexString(charAt);
                            BUILDER.append("\\u");
                            int length2 = hexString.length();
                            for (int i3 = 0; i3 < 4 - length2; i3++) {
                                BUILDER.append('0');
                            }
                            BUILDER.append(hexString.toUpperCase(Locale.US));
                            i = i2;
                            continue;
                        }
                        break;
                }
            } else {
                BUILDER.append("\\\\");
                i = i2;
            }
        }
    }

    private void writeMetaData(OutputStream outputStream, String str, String str2) throws IOException {
        outputStream.write(STREAM_NAME);
        outputStream.write(58);
        outputStream.write(escape(str));
        outputStream.write(44);
        outputStream.write(STREAM_TYPE);
        outputStream.write(58);
        outputStream.write(escape(str2));
        outputStream.write(44);
        outputStream.write(STREAM_CONTENTS);
        outputStream.write(58);
        outputStream.write(34);
    }

    private void writeToFromFile(OutputStream outputStream, RequestParams.FileWrapper fileWrapper) throws IOException {
        writeMetaData(outputStream, fileWrapper.file.getName(), fileWrapper.contentType);
        int length = (int) fileWrapper.file.length();
        FileInputStream fileInputStream = new FileInputStream(fileWrapper.file);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        int i = 0;
        while (true) {
            int read = fileInputStream.read(this.buffer);
            if (read == -1) {
                AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
                endMetaData(outputStream);
                AsyncHttpClient.silentCloseInputStream(fileInputStream);
                return;
            }
            base64OutputStream.write(this.buffer, 0, read);
            i += read;
            this.progressHandler.sendProgressMessage(i, length);
        }
    }

    private void writeToFromStream(OutputStream outputStream, RequestParams.StreamWrapper streamWrapper) throws IOException {
        writeMetaData(outputStream, streamWrapper.name, streamWrapper.contentType);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        while (true) {
            int read = streamWrapper.inputStream.read(this.buffer);
            if (read == -1) {
                break;
            }
            base64OutputStream.write(this.buffer, 0, read);
        }
        AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
        endMetaData(outputStream);
        if (streamWrapper.autoClose) {
            AsyncHttpClient.silentCloseInputStream(streamWrapper.inputStream);
        }
    }

    public void addPart(String str, Object obj) {
        this.jsonParams.put(str, obj);
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
    }

    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw ERR_UNSUPPORTED;
    }

    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    public long getContentLength() {
        return -1L;
    }

    public Header getContentType() {
        return HEADER_JSON_CONTENT;
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        GZIPOutputStream gZIPOutputStream = outputStream;
        if (this.contentEncoding != null) {
            gZIPOutputStream = new GZIPOutputStream(outputStream, 4096);
        }
        gZIPOutputStream.write(123);
        for (String str : this.jsonParams.keySet()) {
            Object obj = this.jsonParams.get(str);
            if (obj != null) {
                gZIPOutputStream.write(escape(str));
                gZIPOutputStream.write(58);
                boolean z = obj instanceof RequestParams.FileWrapper;
                if (z || (obj instanceof RequestParams.StreamWrapper)) {
                    gZIPOutputStream.write(123);
                    if (z) {
                        writeToFromFile(gZIPOutputStream, (RequestParams.FileWrapper) obj);
                    } else {
                        writeToFromStream(gZIPOutputStream, (RequestParams.StreamWrapper) obj);
                    }
                    gZIPOutputStream.write(125);
                } else if (obj instanceof JsonValueInterface) {
                    gZIPOutputStream.write(((JsonValueInterface) obj).getEscapedJsonValue());
                } else if (obj instanceof JSONObject) {
                    gZIPOutputStream.write(((JSONObject) obj).toString().getBytes());
                } else if (obj instanceof JSONArray) {
                    gZIPOutputStream.write(((JSONArray) obj).toString().getBytes());
                } else if (obj instanceof Boolean) {
                    gZIPOutputStream.write(((Boolean) obj).booleanValue() ? JSON_TRUE : JSON_FALSE);
                } else if (obj instanceof Long) {
                    gZIPOutputStream.write((((Number) obj).longValue() + "").getBytes());
                } else if (obj instanceof Double) {
                    gZIPOutputStream.write((((Number) obj).doubleValue() + "").getBytes());
                } else if (obj instanceof Float) {
                    gZIPOutputStream.write((((Number) obj).floatValue() + "").getBytes());
                } else if (obj instanceof Integer) {
                    gZIPOutputStream.write((((Number) obj).intValue() + "").getBytes());
                } else {
                    gZIPOutputStream.write(escape(obj.toString()));
                }
                gZIPOutputStream.write(44);
            }
        }
        gZIPOutputStream.write(STREAM_ELAPSED);
        gZIPOutputStream.write(58);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        gZIPOutputStream.write((currentTimeMillis2 + "}").getBytes());
        Log.i(LOG_TAG, "Uploaded JSON in " + Math.floor((double) (currentTimeMillis2 / 1000)) + " seconds");
        gZIPOutputStream.flush();
        AsyncHttpClient.silentCloseOutputStream(gZIPOutputStream);
    }
}
