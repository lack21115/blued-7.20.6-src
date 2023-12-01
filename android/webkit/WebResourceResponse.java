package android.webkit;

import java.io.InputStream;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebResourceResponse.class */
public class WebResourceResponse {
    private String mEncoding;
    private InputStream mInputStream;
    private String mMimeType;
    private String mReasonPhrase;
    private Map<String, String> mResponseHeaders;
    private int mStatusCode;

    public WebResourceResponse(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        setStatusCodeAndReasonPhrase(i, str3);
        setResponseHeaders(map);
    }

    public WebResourceResponse(String str, String str2, InputStream inputStream) {
        this.mMimeType = str;
        this.mEncoding = str2;
        this.mInputStream = inputStream;
    }

    public InputStream getData() {
        return this.mInputStream;
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setData(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public void setEncoding(String str) {
        this.mEncoding = str;
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public void setResponseHeaders(Map<String, String> map) {
        this.mResponseHeaders = map;
    }

    public void setStatusCodeAndReasonPhrase(int i, String str) {
        if (i < 100) {
            throw new IllegalArgumentException("statusCode can't be less than 100.");
        }
        if (i > 599) {
            throw new IllegalArgumentException("statusCode can't be greater than 599.");
        }
        if (i > 299 && i < 400) {
            throw new IllegalArgumentException("statusCode can't be in the [300, 399] range.");
        }
        if (str == null) {
            throw new IllegalArgumentException("reasonPhrase can't be null.");
        }
        if (str.trim().isEmpty()) {
            throw new IllegalArgumentException("reasonPhrase can't be empty.");
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= str.length()) {
                this.mStatusCode = i;
                this.mReasonPhrase = str;
                return;
            } else if (str.charAt(i3) > 127) {
                throw new IllegalArgumentException("reasonPhrase can't contain non-ASCII characters.");
            } else {
                i2 = i3 + 1;
            }
        }
    }
}
