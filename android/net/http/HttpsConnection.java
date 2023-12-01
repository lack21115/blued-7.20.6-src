package android.net.http;

import android.content.Context;
import android.media.AudioSystem;
import android.util.Log;
import com.android.org.conscrypt.FileClientSessionCache;
import com.android.org.conscrypt.OpenSSLContextImpl;
import com.android.org.conscrypt.SSLClientSessionCache;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;
import java.util.Locale;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/HttpsConnection.class */
public class HttpsConnection extends Connection {
    private static SSLSocketFactory mSslSocketFactory = null;
    private boolean mAborted;
    private HttpHost mProxyHost;
    private Object mSuspendLock;
    private boolean mSuspended;

    static {
        initializeEngine(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsConnection(Context context, HttpHost httpHost, HttpHost httpHost2, RequestFeeder requestFeeder) {
        super(context, httpHost, requestFeeder);
        this.mSuspendLock = new Object();
        this.mSuspended = false;
        this.mAborted = false;
        this.mProxyHost = httpHost2;
    }

    private static SSLSocketFactory getSocketFactory() {
        SSLSocketFactory sSLSocketFactory;
        synchronized (HttpsConnection.class) {
            try {
                sSLSocketFactory = mSslSocketFactory;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sSLSocketFactory;
    }

    public static void initializeEngine(File file) {
        SSLClientSessionCache sSLClientSessionCache = null;
        if (file != null) {
            try {
                Log.d("HttpsConnection", "Caching SSL sessions in " + file + ".");
                sSLClientSessionCache = FileClientSessionCache.usingDirectory(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (KeyManagementException e2) {
                throw new RuntimeException(e2);
            }
        }
        OpenSSLContextImpl openSSLContextImpl = new OpenSSLContextImpl();
        openSSLContextImpl.engineInit(null, new TrustManager[]{new X509TrustManager() { // from class: android.net.http.HttpsConnection.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }}, null);
        openSSLContextImpl.engineGetClientSessionContext().setPersistentCache(sSLClientSessionCache);
        synchronized (HttpsConnection.class) {
            mSslSocketFactory = openSSLContextImpl.engineGetSocketFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.net.http.Connection
    public void closeConnection() {
        if (this.mSuspended) {
            restartConnection(false);
        }
        try {
            if (this.mHttpClientConnection == null || !this.mHttpClientConnection.isOpen()) {
                return;
            }
            this.mHttpClientConnection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // android.net.http.Connection
    String getScheme() {
        return "https";
    }

    @Override // android.net.http.Connection
    AndroidHttpClientConnection openConnection(Request request) throws IOException {
        SSLSocket sSLSocket;
        AndroidHttpClientConnection androidHttpClientConnection;
        Socket socket;
        StatusLine parseResponseHeader;
        int statusCode;
        SSLSocket sSLSocket2 = null;
        if (this.mProxyHost != null) {
            try {
                socket = new Socket(this.mProxyHost.getHostName(), this.mProxyHost.getPort());
                try {
                    socket.setSoTimeout(60000);
                    androidHttpClientConnection = new AndroidHttpClientConnection();
                } catch (IOException e) {
                    e = e;
                    androidHttpClientConnection = null;
                }
            } catch (IOException e2) {
                e = e2;
                androidHttpClientConnection = null;
            }
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
                androidHttpClientConnection.bind(socket, basicHttpParams);
                Headers headers = new Headers();
                try {
                    BasicHttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", this.mHost.toHostString());
                    Header[] allHeaders = request.mHttpRequest.getAllHeaders();
                    int length = allHeaders.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        Header header = allHeaders[i2];
                        String lowerCase = header.getName().toLowerCase(Locale.ROOT);
                        if (lowerCase.startsWith(AudioSystem.DEVICE_OUT_PROXY_NAME) || lowerCase.equals("keep-alive") || lowerCase.equals("host")) {
                            basicHttpRequest.addHeader(header);
                        }
                        i = i2 + 1;
                    }
                    androidHttpClientConnection.sendRequestHeader(basicHttpRequest);
                    androidHttpClientConnection.flush();
                    do {
                        parseResponseHeader = androidHttpClientConnection.parseResponseHeader(headers);
                        statusCode = parseResponseHeader.getStatusCode();
                    } while (statusCode < 200);
                    if (statusCode != 200) {
                        ProtocolVersion protocolVersion = parseResponseHeader.getProtocolVersion();
                        request.mEventHandler.status(protocolVersion.getMajor(), protocolVersion.getMinor(), statusCode, parseResponseHeader.getReasonPhrase());
                        request.mEventHandler.headers(headers);
                        request.mEventHandler.endData();
                        androidHttpClientConnection.close();
                        return null;
                    }
                    try {
                        sSLSocket = (SSLSocket) getSocketFactory().createSocket(socket, this.mHost.getHostName(), this.mHost.getPort(), true);
                    } catch (IOException e3) {
                        if (0 != 0) {
                            throw new NullPointerException();
                        }
                        String message = e3.getMessage();
                        String str = message;
                        if (message == null) {
                            str = "failed to create an SSL socket";
                        }
                        throw new IOException(str);
                    }
                } catch (ParseException e4) {
                    String message2 = e4.getMessage();
                    String str2 = message2;
                    if (message2 == null) {
                        str2 = "failed to send a CONNECT request";
                    }
                    throw new IOException(str2);
                } catch (IOException e5) {
                    String message3 = e5.getMessage();
                    String str3 = message3;
                    if (message3 == null) {
                        str3 = "failed to send a CONNECT request";
                    }
                    throw new IOException(str3);
                } catch (HttpException e6) {
                    String message4 = e6.getMessage();
                    String str4 = message4;
                    if (message4 == null) {
                        str4 = "failed to send a CONNECT request";
                    }
                    throw new IOException(str4);
                }
            } catch (IOException e7) {
                e = e7;
                if (androidHttpClientConnection != null) {
                    androidHttpClientConnection.close();
                }
                String message5 = e.getMessage();
                String str5 = message5;
                if (message5 == null) {
                    str5 = "failed to establish a connection to the proxy";
                }
                throw new IOException(str5);
            }
        } else {
            try {
                SSLSocket sSLSocket3 = (SSLSocket) getSocketFactory().createSocket(this.mHost.getHostName(), this.mHost.getPort());
                sSLSocket2 = sSLSocket3;
                sSLSocket3.setSoTimeout(60000);
                sSLSocket = sSLSocket3;
            } catch (IOException e8) {
                if (sSLSocket2 != null) {
                    sSLSocket2.close();
                }
                String message6 = e8.getMessage();
                String str6 = message6;
                if (message6 == null) {
                    str6 = "failed to create an SSL socket";
                }
                throw new IOException(str6);
            }
        }
        SslError doHandshakeAndValidateServerCertificates = CertificateChainValidator.getInstance().doHandshakeAndValidateServerCertificates(this, sSLSocket, this.mHost.getHostName());
        if (doHandshakeAndValidateServerCertificates != null) {
            synchronized (this.mSuspendLock) {
                this.mSuspended = true;
            }
            if (!request.getEventHandler().handleSslErrorRequest(doHandshakeAndValidateServerCertificates)) {
                throw new IOException("failed to handle " + doHandshakeAndValidateServerCertificates);
            }
            synchronized (this.mSuspendLock) {
                if (this.mSuspended) {
                    try {
                        this.mSuspendLock.wait(600000L);
                        if (this.mSuspended) {
                            this.mSuspended = false;
                            this.mAborted = true;
                        }
                    } catch (InterruptedException e9) {
                    }
                }
                if (this.mAborted) {
                    sSLSocket.close();
                    throw new SSLConnectionClosedByUserException("connection closed by the user");
                }
            }
        }
        AndroidHttpClientConnection androidHttpClientConnection2 = new AndroidHttpClientConnection();
        BasicHttpParams basicHttpParams2 = new BasicHttpParams();
        basicHttpParams2.setIntParameter("http.socket.buffer-size", 8192);
        androidHttpClientConnection2.bind(sSLSocket, basicHttpParams2);
        return androidHttpClientConnection2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restartConnection(boolean z) {
        boolean z2 = false;
        synchronized (this.mSuspendLock) {
            if (this.mSuspended) {
                this.mSuspended = false;
                if (!z) {
                    z2 = true;
                }
                this.mAborted = z2;
                this.mSuspendLock.notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCertificate(SslCertificate sslCertificate) {
        this.mCertificate = sslCertificate;
    }

    @Override // android.net.http.Connection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
