package android.media;

import android.media.IMediaHTTPConnection;
import android.net.NetworkUtils;
import android.net.ProxyInfo;
import android.os.IBinder;
import android.os.StrictMode;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.ads.fw;
import com.tencent.qcloud.core.util.IOUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaHTTPConnection.class */
public class MediaHTTPConnection extends IMediaHTTPConnection.Stub {
    private static final int HTTP_TEMP_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "MediaHTTPConnection";
    private static final boolean VERBOSE = false;
    private long mNativeContext;
    private String mProxyIP;
    private long mCurrentOffset = -1;
    private URL mURL = null;
    private int mProxyPort = 0;
    private Map<String, String> mHeaders = null;
    private HttpURLConnection mConnection = null;
    private long mTotalSize = -1;
    private InputStream mInputStream = null;
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    public MediaHTTPConnection() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
        native_setup();
    }

    private Map<String, String> convertHeaderStringToMap(String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split(IOUtils.LINE_SEPARATOR_WINDOWS);
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashMap;
            }
            String str2 = split[i2];
            int indexOf = str2.indexOf(":");
            if (indexOf >= 0) {
                String substring = str2.substring(0, indexOf);
                String substring2 = str2.substring(indexOf + 1);
                if (!filterOutInternalHeaders(substring, substring2)) {
                    hashMap.put(substring, substring2);
                }
            }
            i = i2 + 1;
        }
    }

    private boolean filterOutInternalHeaders(String str, String str2) {
        boolean z = false;
        Log.d(TAG, "filterOutInternalHeaders: key=" + str + ", val=" + str2);
        if (!"android-allow-cross-domain-redirect".equalsIgnoreCase(str)) {
            if ("use-proxy".equalsIgnoreCase(str)) {
                Log.d(TAG, "filterOutInternalHeaders use-proxy " + str2);
                int indexOf = str2.indexOf(":");
                if (indexOf > 0) {
                    this.mProxyIP = new String(str2.substring(0, indexOf).trim());
                    this.mProxyPort = Integer.parseInt(str2.substring(indexOf + 1));
                    Log.d(TAG, "sta-proxy-ip " + this.mProxyIP + " port " + this.mProxyPort);
                }
            }
            return z;
        }
        this.mAllowCrossDomainRedirect = parseBoolean(str2);
        this.mAllowCrossProtocolRedirect = this.mAllowCrossDomainRedirect;
        z = true;
        return z;
    }

    private static final boolean isLocalHost(URL url) {
        String host;
        if (url == null || (host = url.getHost()) == null) {
            return false;
        }
        try {
            if (host.equalsIgnoreCase(ProxyInfo.LOCAL_HOST)) {
                return true;
            }
            return NetworkUtils.numericToInetAddress(host).isLoopbackAddress();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private final native void native_finalize();

    private final native IBinder native_getIMemory();

    private static final native void native_init();

    private final native int native_readAt(long j, int i);

    private final native void native_setup();

    private boolean parseBoolean(String str) {
        boolean z = false;
        try {
            return Long.parseLong(str) != 0;
        } catch (NumberFormatException e) {
            if (fw.Code.equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str)) {
                z = true;
            }
            return z;
        }
    }

    private int readAt(long j, byte[] bArr, int i) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        try {
            if (j != this.mCurrentOffset) {
                seekTo(j);
            }
            int read = this.mInputStream.read(bArr, 0, i);
            int i2 = read;
            if (read == -1) {
                i2 = 0;
            }
            this.mCurrentOffset += i2;
            return i2;
        } catch (NoRouteToHostException e) {
            Log.w(TAG, "readAt " + j + " / " + i + " => " + e);
            return -1010;
        } catch (ProtocolException e2) {
            Log.w(TAG, "readAt " + j + " / " + i + " => " + e2);
            return -1010;
        } catch (IOException e3) {
            return -1;
        } catch (Exception e4) {
            return -1;
        }
    }

    private void seekTo(long j) throws IOException {
        int lastIndexOf;
        teardownConnection();
        int i = 0;
        try {
            URL url = this.mURL;
            boolean isLocalHost = isLocalHost(url);
            while (true) {
                Log.d(TAG, "proxy " + this.mProxyIP + " port " + this.mProxyPort);
                if (this.mProxyPort > 0) {
                    this.mConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.mProxyIP, this.mProxyPort)));
                    Log.d(TAG, "connection initialized with proxy");
                } else if (isLocalHost) {
                    this.mConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                } else {
                    this.mConnection = (HttpURLConnection) url.openConnection();
                }
                this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
                if (this.mHeaders != null) {
                    for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
                        this.mConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (j > 0) {
                    this.mConnection.setRequestProperty("Range", "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                int responseCode = this.mConnection.getResponseCode();
                if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307) {
                    if (this.mAllowCrossDomainRedirect) {
                        this.mURL = this.mConnection.getURL();
                    }
                    if (responseCode == 206) {
                        String headerField = this.mConnection.getHeaderField("Content-Range");
                        this.mTotalSize = -1L;
                        if (headerField != null && (lastIndexOf = headerField.lastIndexOf(47)) >= 0) {
                            try {
                                this.mTotalSize = Long.parseLong(headerField.substring(lastIndexOf + 1));
                            } catch (NumberFormatException e) {
                            }
                        }
                    } else if (responseCode != 200) {
                        throw new IOException();
                    } else {
                        this.mTotalSize = this.mConnection.getContentLength();
                    }
                    if (j > 0 && responseCode != 206) {
                        throw new ProtocolException();
                    }
                    this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
                    this.mCurrentOffset = j;
                    return;
                }
                int i2 = i + 1;
                if (i2 > 20) {
                    throw new NoRouteToHostException("Too many redirects: " + i2);
                }
                String requestMethod = this.mConnection.getRequestMethod();
                if (responseCode == 307 && !requestMethod.equals("GET") && !requestMethod.equals("HEAD")) {
                    throw new NoRouteToHostException("Invalid redirect");
                }
                String headerField2 = this.mConnection.getHeaderField(HttpHeaders.LOCATION);
                if (headerField2 == null) {
                    throw new NoRouteToHostException("Invalid redirect");
                }
                URL url2 = new URL(this.mURL, headerField2);
                if (!url2.getProtocol().equals("https") && !url2.getProtocol().equals("http")) {
                    throw new NoRouteToHostException("Unsupported protocol redirect");
                }
                boolean equals = this.mURL.getProtocol().equals(url2.getProtocol());
                if (!this.mAllowCrossProtocolRedirect && !equals) {
                    throw new NoRouteToHostException("Cross-protocol redirects are disallowed");
                }
                boolean equals2 = this.mURL.getHost().equals(url2.getHost());
                if (!this.mAllowCrossDomainRedirect && !equals2) {
                    throw new NoRouteToHostException("Cross-domain redirects are disallowed");
                }
                i = i2;
                url = url2;
                if (responseCode != 307) {
                    this.mURL = url2;
                    i = i2;
                    url = url2;
                }
            }
        } catch (IOException e2) {
            this.mTotalSize = -1L;
            this.mInputStream = null;
            this.mConnection = null;
            this.mCurrentOffset = -1L;
            throw e2;
        }
    }

    private void teardownConnection() {
        if (this.mConnection != null) {
            this.mInputStream = null;
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1L;
        }
    }

    @Override // android.media.IMediaHTTPConnection
    public IBinder connect(String str, String str2) {
        try {
            disconnect();
            this.mAllowCrossDomainRedirect = true;
            this.mURL = new URL(str);
            this.mHeaders = convertHeaderStringToMap(str2);
            return native_getIMemory();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    @Override // android.media.IMediaHTTPConnection
    public void disconnect() {
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
    }

    @Override // android.os.Binder
    protected void finalize() {
        native_finalize();
    }

    @Override // android.media.IMediaHTTPConnection
    public String getMIMEType() {
        if (this.mConnection == null) {
            try {
                seekTo(0L);
            } catch (IOException e) {
                return "application/octet-stream";
            }
        }
        return this.mConnection.getContentType();
    }

    @Override // android.media.IMediaHTTPConnection
    public long getSize() {
        if (this.mConnection == null) {
            try {
                seekTo(0L);
            } catch (IOException e) {
                return -1L;
            }
        }
        return this.mTotalSize;
    }

    @Override // android.media.IMediaHTTPConnection
    public String getUri() {
        return this.mURL.toString();
    }

    @Override // android.media.IMediaHTTPConnection
    public int readAt(long j, int i) {
        return native_readAt(j, i);
    }
}
