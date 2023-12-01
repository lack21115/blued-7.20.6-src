package android.net.http;

import com.xiaomi.mipush.sdk.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.RequestContent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/net/http/Request.class */
public class Request {
    private static final String ACCEPT_ENCODING_HEADER = "Accept-Encoding";
    private static final String CONTENT_LENGTH_HEADER = "content-length";
    private static final String HOST_HEADER = "Host";
    private static RequestContent requestContentProcessor = new RequestContent();
    private int mBodyLength;
    private InputStream mBodyProvider;
    private Connection mConnection;
    EventHandler mEventHandler;
    HttpHost mHost;
    BasicHttpRequest mHttpRequest;
    String mPath;
    HttpHost mProxyHost;
    volatile boolean mCancelled = false;
    int mFailCount = 0;
    private int mReceivedBytes = 0;
    private final Object mClientResource = new Object();
    private boolean mLoadingPaused = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request(String str, HttpHost httpHost, HttpHost httpHost2, String str2, InputStream inputStream, int i, EventHandler eventHandler, Map<String, String> map) {
        this.mEventHandler = eventHandler;
        this.mHost = httpHost;
        this.mProxyHost = httpHost2;
        this.mPath = str2;
        this.mBodyProvider = inputStream;
        this.mBodyLength = i;
        if (inputStream != null || "POST".equalsIgnoreCase(str)) {
            this.mHttpRequest = new BasicHttpEntityEnclosingRequest(str, getUri());
            if (inputStream != null) {
                setBodyProvider(inputStream, i);
            }
        } else {
            this.mHttpRequest = new BasicHttpRequest(str, getUri());
        }
        addHeader("Host", getHostPort());
        addHeader("Accept-Encoding", "gzip");
        addHeaders(map);
    }

    private static boolean canResponseHaveBody(HttpRequest httpRequest, int i) {
        return ("HEAD".equalsIgnoreCase(httpRequest.getRequestLine().getMethod()) || i < 200 || i == 204 || i == 304) ? false : true;
    }

    private void setBodyProvider(InputStream inputStream, int i) {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("bodyProvider must support mark()");
        }
        inputStream.mark(Integer.MAX_VALUE);
        this.mHttpRequest.setEntity(new InputStreamEntity(inputStream, i));
    }

    void addHeader(String str, String str2) {
        if (str == null) {
            HttpLog.e("Null http header name");
            throw new NullPointerException("Null http header name");
        } else if (str2 != null && str2.length() != 0) {
            this.mHttpRequest.addHeader(str, str2);
        } else {
            String str3 = "Null or empty value for header \"" + str + "\"";
            HttpLog.e(str3);
            throw new RuntimeException(str3);
        }
    }

    void addHeaders(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            addHeader(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel() {
        synchronized (this) {
            this.mLoadingPaused = false;
            notify();
            this.mCancelled = true;
            if (this.mConnection != null) {
                this.mConnection.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void complete() {
        synchronized (this.mClientResource) {
            this.mClientResource.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void error(int i, int i2) {
        this.mEventHandler.error(i, this.mConnection.mContext.getText(i2).toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventHandler getEventHandler() {
        return this.mEventHandler;
    }

    String getHostPort() {
        String schemeName = this.mHost.getSchemeName();
        int port = this.mHost.getPort();
        return ((port == 80 || !schemeName.equals("http")) && (port == 443 || !schemeName.equals("https"))) ? this.mHost.getHostName() : this.mHost.toHostString();
    }

    String getUri() {
        return (this.mProxyHost == null || this.mHost.getSchemeName().equals("https")) ? this.mPath : this.mHost.getSchemeName() + "://" + getHostPort() + this.mPath;
    }

    public void handleSslErrorResponse(boolean z) {
        HttpsConnection httpsConnection = (HttpsConnection) this.mConnection;
        if (httpsConnection != null) {
            httpsConnection.restartConnection(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Finally extract failed */
    public void readResponse(AndroidHttpClientConnection androidHttpClientConnection) throws IOException, ParseException {
        StatusLine parseResponseHeader;
        int statusCode;
        if (this.mCancelled) {
            return;
        }
        androidHttpClientConnection.flush();
        Headers headers = new Headers();
        do {
            parseResponseHeader = androidHttpClientConnection.parseResponseHeader(headers);
            statusCode = parseResponseHeader.getStatusCode();
        } while (statusCode < 200);
        ProtocolVersion protocolVersion = parseResponseHeader.getProtocolVersion();
        this.mEventHandler.status(protocolVersion.getMajor(), protocolVersion.getMinor(), statusCode, parseResponseHeader.getReasonPhrase());
        this.mEventHandler.headers(headers);
        HttpEntity httpEntity = null;
        if (canResponseHaveBody(this.mHttpRequest, statusCode)) {
            httpEntity = androidHttpClientConnection.receiveResponseEntity(headers);
        }
        boolean equalsIgnoreCase = "bytes".equalsIgnoreCase(headers.getAcceptRanges());
        if (httpEntity != null) {
            ProtocolVersion content = httpEntity.getContent();
            Header contentEncoding = httpEntity.getContentEncoding();
            int i = 0;
            try {
                if (contentEncoding != null) {
                    byte[] bArr = null;
                    int i2 = 0;
                    ProtocolVersion protocolVersion2 = null;
                    byte[] bArr2 = null;
                    int i3 = 0;
                    ProtocolVersion protocolVersion3 = null;
                    protocolVersion = null;
                    try {
                        if (contentEncoding.getValue().equals("gzip")) {
                            content = new GZIPInputStream(content);
                        }
                    } catch (EOFException e) {
                        if (i2 > 0) {
                            this.mEventHandler.data(bArr, i2);
                        }
                        if (protocolVersion2 != null) {
                            protocolVersion2.close();
                        }
                    } catch (IOException e2) {
                        if (statusCode == 200 || statusCode == 206) {
                            if (equalsIgnoreCase && i3 > 0) {
                                this.mEventHandler.data(bArr2, i3);
                            }
                            ProtocolVersion protocolVersion4 = protocolVersion3;
                            throw e2;
                        } else if (protocolVersion3 != null) {
                            protocolVersion3.close();
                        }
                    }
                }
                byte[] buf = this.mConnection.getBuf();
                int length = buf.length / 2;
                int i4 = 0;
                while (i4 != -1) {
                    synchronized (this) {
                        while (this.mLoadingPaused) {
                            try {
                                try {
                                    wait();
                                } catch (InterruptedException e3) {
                                    HttpLog.e("Interrupted exception whilst network thread paused at WebCore's request. " + e3.getMessage());
                                }
                            } finally {
                            }
                        }
                    }
                    int read = content.read(buf, i, buf.length - i);
                    int i5 = i;
                    if (read != -1) {
                        int i6 = i + read;
                        i5 = i6;
                        if (equalsIgnoreCase) {
                            this.mReceivedBytes += read;
                            i5 = i6;
                        }
                    }
                    if (read != -1) {
                        i = i5;
                        i4 = read;
                        if (i5 >= length) {
                        }
                    }
                    this.mEventHandler.data(buf, i5);
                    i = 0;
                    i4 = read;
                }
                if (content != null) {
                    content.close();
                }
            } catch (Throwable th) {
                if (protocolVersion != null) {
                    protocolVersion.close();
                }
                throw th;
            }
        }
        this.mConnection.setCanPersist(httpEntity, parseResponseHeader.getProtocolVersion(), headers.getConnectionType());
        this.mEventHandler.endData();
        complete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.mHttpRequest.removeHeaders("content-length");
        if (this.mBodyProvider != null) {
            try {
                this.mBodyProvider.reset();
            } catch (IOException e) {
            }
            setBodyProvider(this.mBodyProvider, this.mBodyLength);
        }
        if (this.mReceivedBytes > 0) {
            this.mFailCount = 0;
            HttpLog.v("*** Request.reset() to range:" + this.mReceivedBytes);
            this.mHttpRequest.setHeader("Range", "bytes=" + this.mReceivedBytes + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendRequest(AndroidHttpClientConnection androidHttpClientConnection) throws HttpException, IOException {
        if (this.mCancelled) {
            return;
        }
        requestContentProcessor.process(this.mHttpRequest, this.mConnection.getHttpContext());
        androidHttpClientConnection.sendRequestHeader(this.mHttpRequest);
        if (this.mHttpRequest instanceof HttpEntityEnclosingRequest) {
            androidHttpClientConnection.sendRequestEntity((HttpEntityEnclosingRequest) this.mHttpRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnection(Connection connection) {
        this.mConnection = connection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoadingPaused(boolean z) {
        synchronized (this) {
            this.mLoadingPaused = z;
            if (!this.mLoadingPaused) {
                notify();
            }
        }
    }

    public String toString() {
        return this.mPath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void waitUntilComplete() {
        synchronized (this.mClientResource) {
            try {
                this.mClientResource.wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
