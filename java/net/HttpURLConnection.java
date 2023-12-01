package java.net;

import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.io.InputStream;
import java.security.Permission;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/net/HttpURLConnection.class */
public abstract class HttpURLConnection extends URLConnection {
    private static final int DEFAULT_CHUNK_LENGTH = 1024;
    public static final int HTTP_ACCEPTED = 202;
    public static final int HTTP_BAD_GATEWAY = 502;
    public static final int HTTP_BAD_METHOD = 405;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_CLIENT_TIMEOUT = 408;
    public static final int HTTP_CONFLICT = 409;
    public static final int HTTP_CREATED = 201;
    public static final int HTTP_ENTITY_TOO_LARGE = 413;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_GATEWAY_TIMEOUT = 504;
    public static final int HTTP_GONE = 410;
    public static final int HTTP_INTERNAL_ERROR = 500;
    public static final int HTTP_LENGTH_REQUIRED = 411;
    public static final int HTTP_MOVED_PERM = 301;
    public static final int HTTP_MOVED_TEMP = 302;
    public static final int HTTP_MULT_CHOICE = 300;
    public static final int HTTP_NOT_ACCEPTABLE = 406;
    public static final int HTTP_NOT_AUTHORITATIVE = 203;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_NOT_IMPLEMENTED = 501;
    public static final int HTTP_NOT_MODIFIED = 304;
    public static final int HTTP_NO_CONTENT = 204;
    public static final int HTTP_OK = 200;
    public static final int HTTP_PARTIAL = 206;
    public static final int HTTP_PAYMENT_REQUIRED = 402;
    public static final int HTTP_PRECON_FAILED = 412;
    public static final int HTTP_PROXY_AUTH = 407;
    public static final int HTTP_REQ_TOO_LONG = 414;
    public static final int HTTP_RESET = 205;
    public static final int HTTP_SEE_OTHER = 303;
    @Deprecated
    public static final int HTTP_SERVER_ERROR = 500;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_UNAVAILABLE = 503;
    public static final int HTTP_UNSUPPORTED_TYPE = 415;
    public static final int HTTP_USE_PROXY = 305;
    public static final int HTTP_VERSION = 505;
    private static final String[] PERMITTED_USER_METHODS = {"OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", HttpConstants.RequestMethod.TRACE};
    private static boolean followRedirects = true;
    protected int chunkLength;
    protected int fixedContentLength;
    protected long fixedContentLengthLong;
    protected boolean instanceFollowRedirects;
    protected String method;
    protected int responseCode;
    protected String responseMessage;

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpURLConnection(URL url) {
        super(url);
        this.method = "GET";
        this.responseCode = -1;
        this.instanceFollowRedirects = followRedirects;
        this.chunkLength = -1;
        this.fixedContentLength = -1;
        this.fixedContentLengthLong = -1L;
    }

    public static boolean getFollowRedirects() {
        return followRedirects;
    }

    public static void setFollowRedirects(boolean z) {
        followRedirects = z;
    }

    public abstract void disconnect();

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return super.getContentEncoding();
    }

    public InputStream getErrorStream() {
        return null;
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return super.getHeaderFieldDate(str, j);
    }

    public boolean getInstanceFollowRedirects() {
        return this.instanceFollowRedirects;
    }

    @Override // java.net.URLConnection
    public Permission getPermission() throws IOException {
        int port = this.url.getPort();
        int i = port;
        if (port < 0) {
            i = 80;
        }
        return new SocketPermission(this.url.getHost() + ":" + i, "connect, resolve");
    }

    public String getRequestMethod() {
        return this.method;
    }

    public int getResponseCode() throws IOException {
        getInputStream();
        String headerField = getHeaderField(0);
        if (headerField == null) {
            return -1;
        }
        String trim = headerField.trim();
        int indexOf = trim.indexOf(" ") + 1;
        if (indexOf != 0) {
            int i = indexOf + 3;
            int i2 = i;
            if (i > trim.length()) {
                i2 = trim.length();
            }
            this.responseCode = Integer.parseInt(trim.substring(indexOf, i2));
            if (i2 + 1 <= trim.length()) {
                this.responseMessage = trim.substring(i2 + 1);
            }
            return this.responseCode;
        }
        return -1;
    }

    public String getResponseMessage() throws IOException {
        if (this.responseMessage != null) {
            return this.responseMessage;
        }
        getResponseCode();
        return this.responseMessage;
    }

    public void setChunkedStreamingMode(int i) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (this.fixedContentLength >= 0) {
            throw new IllegalStateException("Already in fixed-length mode");
        }
        if (i <= 0) {
            this.chunkLength = 1024;
        } else {
            this.chunkLength = i;
        }
    }

    public void setFixedLengthStreamingMode(int i) {
        setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long j) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        }
        if (j < 0) {
            throw new IllegalArgumentException("contentLength < 0");
        }
        this.fixedContentLength = (int) Math.min(j, 2147483647L);
        this.fixedContentLengthLong = j;
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.instanceFollowRedirects = z;
    }

    public void setRequestMethod(String str) throws ProtocolException {
        if (this.connected) {
            throw new ProtocolException("Connection already established");
        }
        String[] strArr = PERMITTED_USER_METHODS;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new ProtocolException("Unknown method '" + str + "'; must be one of " + Arrays.toString(PERMITTED_USER_METHODS));
            }
            String str2 = strArr[i2];
            if (str2.equals(str)) {
                this.method = str2;
                return;
            }
            i = i2 + 1;
        }
    }

    public abstract boolean usingProxy();
}
