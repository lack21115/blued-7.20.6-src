package android.net.http;

import android.content.Context;
import android.os.SystemClock;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/net/http/Connection.class */
public abstract class Connection {
    private static final int DONE = 3;
    private static final int DRAIN = 2;
    private static final String HTTP_CONNECTION = "http.connection";
    private static final int MAX_PIPE = 3;
    private static final int MIN_PIPE = 2;
    private static final int READ = 1;
    private static final int RETRY_REQUEST_LIMIT = 2;
    private static final int SEND = 0;
    static final int SOCKET_TIMEOUT = 60000;
    private byte[] mBuf;
    Context mContext;
    HttpHost mHost;
    RequestFeeder mRequestFeeder;
    private static final String[] states = {"SEND", "READ", "DRAIN", "DONE"};
    private static int STATE_NORMAL = 0;
    private static int STATE_CANCEL_REQUESTED = 1;
    protected AndroidHttpClientConnection mHttpClientConnection = null;
    protected SslCertificate mCertificate = null;
    private int mActive = STATE_NORMAL;
    private boolean mCanPersist = false;
    private HttpContext mHttpContext = new BasicHttpContext((HttpContext) null);

    /* JADX INFO: Access modifiers changed from: protected */
    public Connection(Context context, HttpHost httpHost, RequestFeeder requestFeeder) {
        this.mContext = context;
        this.mHost = httpHost;
        this.mRequestFeeder = requestFeeder;
    }

    private boolean clearPipe(LinkedList<Request> linkedList) {
        boolean z;
        boolean z2 = true;
        synchronized (this.mRequestFeeder) {
            while (!linkedList.isEmpty()) {
                this.mRequestFeeder.requeueRequest(linkedList.removeLast());
                z2 = false;
            }
            z = z2;
            if (z2) {
                z = !this.mRequestFeeder.haveRequest(this.mHost);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Connection getConnection(Context context, HttpHost httpHost, HttpHost httpHost2, RequestFeeder requestFeeder) {
        return httpHost.getSchemeName().equals("http") ? new HttpConnection(context, httpHost, requestFeeder) : new HttpsConnection(context, httpHost, httpHost2, requestFeeder);
    }

    private boolean httpFailure(Request request, int i, Exception exc) {
        String th;
        boolean z = true;
        int i2 = request.mFailCount + 1;
        request.mFailCount = i2;
        if (i2 >= 2) {
            z = false;
            if (i < 0) {
                th = ErrorStrings.getString(i, this.mContext);
            } else {
                Throwable cause = exc.getCause();
                th = cause != null ? cause.toString() : exc.getMessage();
            }
            request.mEventHandler.error(i, th);
            request.complete();
        }
        closeConnection();
        this.mHttpContext.removeAttribute(HTTP_CONNECTION);
        return z;
    }

    private boolean keepAlive(HttpEntity httpEntity, ProtocolVersion protocolVersion, int i, HttpContext httpContext) {
        boolean z = true;
        org.apache.http.HttpConnection httpConnection = (org.apache.http.HttpConnection) httpContext.getAttribute(HTTP_CONNECTION);
        if (httpConnection == null || httpConnection.isOpen()) {
            if ((httpEntity == null || httpEntity.getContentLength() >= 0 || (httpEntity.isChunked() && !protocolVersion.lessEquals(HttpVersion.HTTP_1_0))) && i != 1) {
                if (i == 2) {
                    return true;
                }
                if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                    z = false;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    private boolean openHttpConnection(Request request) {
        boolean z = true;
        SystemClock.uptimeMillis();
        int i = 0;
        Exception e = null;
        try {
            this.mCertificate = null;
            this.mHttpClientConnection = openConnection(request);
        } catch (SSLConnectionClosedByUserException e2) {
            request.mFailCount = 2;
            return false;
        } catch (UnknownHostException e3) {
            e = e3;
            i = -2;
        } catch (SSLHandshakeException e4) {
            e = e4;
            request.mFailCount = 2;
            i = -11;
        } catch (IOException e5) {
            e = e5;
            i = -6;
        } catch (IllegalArgumentException e6) {
            e = e6;
            i = -6;
            request.mFailCount = 2;
        }
        if (this.mHttpClientConnection == null) {
            request.mFailCount = 2;
            return false;
        }
        this.mHttpClientConnection.setSocketTimeout(60000);
        this.mHttpContext.setAttribute(HTTP_CONNECTION, this.mHttpClientConnection);
        if (i == 0) {
            return true;
        }
        if (request.mFailCount < 2) {
            this.mRequestFeeder.requeueRequest(request);
            request.mFailCount++;
        } else {
            httpFailure(request, i, e);
        }
        if (i != 0) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel() {
        this.mActive = STATE_CANCEL_REQUESTED;
        closeConnection();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void closeConnection();

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getBuf() {
        if (this.mBuf == null) {
            this.mBuf = new byte[8192];
        }
        return this.mBuf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getCanPersist() {
        return this.mCanPersist;
    }

    SslCertificate getCertificate() {
        return this.mCertificate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpHost getHost() {
        return this.mHost;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpContext getHttpContext() {
        return this.mHttpContext;
    }

    abstract String getScheme();

    abstract AndroidHttpClientConnection openConnection(Request request) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processRequests(Request request) {
        int i;
        Request request2;
        int i2;
        int i3 = 0;
        LinkedList<Request> linkedList = new LinkedList<>();
        int i4 = 2;
        int i5 = 3;
        char c2 = 0;
        Request request3 = request;
        Exception e = null;
        while (c2 != 3) {
            if (this.mActive == STATE_CANCEL_REQUESTED) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                }
                this.mActive = STATE_NORMAL;
            }
            switch (c2) {
                case 0:
                    if (linkedList.size() != i5) {
                        if (request3 == null) {
                            request2 = request3;
                            request3 = this.mRequestFeeder.getRequest(this.mHost);
                        } else {
                            request2 = null;
                        }
                        if (request3 != null) {
                            request3.setConnection(this);
                            if (!request3.mCancelled) {
                                if ((this.mHttpClientConnection != null && this.mHttpClientConnection.isOpen()) || openHttpConnection(request3)) {
                                    request3.mEventHandler.certificate(this.mCertificate);
                                    try {
                                        request3.sendRequest(this.mHttpClientConnection);
                                        e = e;
                                        i2 = i3;
                                    } catch (IOException e3) {
                                        e = e3;
                                        i2 = -7;
                                    } catch (IllegalStateException e4) {
                                        e = e4;
                                        i2 = -7;
                                    } catch (HttpException e5) {
                                        e = e5;
                                        i2 = -1;
                                    }
                                    if (e == null) {
                                        linkedList.addLast(request3);
                                        i3 = i2;
                                        e = e;
                                        request3 = request2;
                                        if (!this.mCanPersist) {
                                            c2 = 1;
                                            i3 = i2;
                                            e = e;
                                            request3 = request2;
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        if (httpFailure(request3, i2, e) && !request3.mCancelled) {
                                            linkedList.addLast(request3);
                                        }
                                        e = null;
                                        c2 = clearPipe(linkedList) ? (char) 3 : (char) 0;
                                        i5 = 1;
                                        i4 = 1;
                                        i3 = i2;
                                        request3 = request2;
                                        break;
                                    }
                                } else {
                                    c2 = 3;
                                    request3 = request2;
                                    break;
                                }
                            } else {
                                request3.complete();
                                request3 = request2;
                                break;
                            }
                        } else {
                            c2 = 2;
                            request3 = request2;
                            break;
                        }
                    } else {
                        c2 = 1;
                        break;
                    }
                case 1:
                case 2:
                    boolean z = !this.mRequestFeeder.haveRequest(this.mHost);
                    int size = linkedList.size();
                    if (c2 != 2 && size < i4 && !z && this.mCanPersist) {
                        c2 = 0;
                        break;
                    } else if (size != 0) {
                        Request removeFirst = linkedList.removeFirst();
                        try {
                            removeFirst.readResponse(this.mHttpClientConnection);
                            i = i3;
                        } catch (IOException e6) {
                            e = e6;
                            i = -7;
                        } catch (IllegalStateException e7) {
                            e = e7;
                            i = -7;
                        } catch (ParseException e8) {
                            e = e8;
                            i = -7;
                        }
                        Exception exc = e;
                        if (e != null) {
                            if (httpFailure(removeFirst, i, e) && !removeFirst.mCancelled) {
                                removeFirst.reset();
                                linkedList.addFirst(removeFirst);
                            }
                            exc = null;
                            this.mCanPersist = false;
                        }
                        i3 = i;
                        e = exc;
                        if (!this.mCanPersist) {
                            closeConnection();
                            this.mHttpContext.removeAttribute(HTTP_CONNECTION);
                            clearPipe(linkedList);
                            i5 = 1;
                            i4 = 1;
                            c2 = 0;
                            i3 = i;
                            e = exc;
                            break;
                        } else {
                            break;
                        }
                    } else if (!z) {
                        c2 = 0;
                        break;
                    } else {
                        c2 = 3;
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanPersist(HttpEntity httpEntity, ProtocolVersion protocolVersion, int i) {
        this.mCanPersist = keepAlive(httpEntity, protocolVersion, i, this.mHttpContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanPersist(boolean z) {
        this.mCanPersist = z;
    }

    public String toString() {
        String httpHost;
        synchronized (this) {
            httpHost = this.mHost.toString();
        }
        return httpHost;
    }
}
