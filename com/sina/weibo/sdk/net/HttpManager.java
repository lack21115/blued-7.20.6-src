package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.common.net.HttpHeaders;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.Utility;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/HttpManager.class */
public class HttpManager {
    private static final String BOUNDARY;
    private static final int BUFFER_SIZE = 8192;
    private static final int CONNECTION_TIMEOUT = 25000;
    private static final String END_MP_BOUNDARY;
    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";
    private static final String MP_BOUNDARY;
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final int SOCKET_TIMEOUT = 20000;
    private static final String TAG = "HttpManager";
    private static SSLSocketFactory sSSLSocketFactory;

    static {
        System.loadLibrary("weibosdkcore");
        BOUNDARY = getBoundry();
        MP_BOUNDARY = "--" + BOUNDARY;
        END_MP_BOUNDARY = "--" + BOUNDARY + "--";
    }

    public static void buildParams(OutputStream outputStream, WeiboParameters weiboParameters) throws WeiboException {
        try {
            Set<String> keySet = weiboParameters.keySet();
            for (String str : keySet) {
                if (weiboParameters.get(str) instanceof String) {
                    StringBuilder sb = new StringBuilder(100);
                    sb.setLength(0);
                    sb.append(MP_BOUNDARY);
                    sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                    sb.append("content-disposition: form-data; name=\"");
                    sb.append(str);
                    sb.append("\"\r\n\r\n");
                    sb.append(weiboParameters.get(str));
                    sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                    outputStream.write(sb.toString().getBytes());
                }
            }
            for (String str2 : keySet) {
                Object obj = weiboParameters.get(str2);
                if (obj instanceof Bitmap) {
                    outputStream.write((MP_BOUNDARY + IOUtils.LINE_SEPARATOR_WINDOWS + "content-disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"\r\nContent-Type: application/octet-stream; charset=utf-8\r\n\r\n").getBytes());
                    Bitmap bitmap = (Bitmap) obj;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
                } else if (obj instanceof ByteArrayOutputStream) {
                    outputStream.write((MP_BOUNDARY + IOUtils.LINE_SEPARATOR_WINDOWS + "content-disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"\r\nContent-Type: application/octet-stream; charset=utf-8\r\n\r\n").getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) obj;
                    outputStream.write(byteArrayOutputStream2.toByteArray());
                    outputStream.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
                    byteArrayOutputStream2.close();
                }
            }
            outputStream.write((IOUtils.LINE_SEPARATOR_WINDOWS + END_MP_BOUNDARY).getBytes());
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    private static native String calcOauthSignNative(Context context, String str, String str2);

    public static String downloadFile(Context context, String str, String str2, String str3) throws WeiboException {
        ClientConnectionManager connectionManager;
        TimeUnit timeUnit;
        long j;
        long j2;
        synchronized (HttpManager.class) {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str3);
                if (file2.exists()) {
                    return file2.getPath();
                } else if (URLUtil.isValidUrl(str)) {
                    HttpClient newHttpClient = getNewHttpClient();
                    File file3 = new File(str2, String.valueOf(str3) + "_temp");
                    try {
                        if (file3.exists()) {
                            j = file3.length();
                        } else {
                            file3.createNewFile();
                            j = 0;
                        }
                        HttpGet httpGet = new HttpGet(str);
                        httpGet.setHeader("RANGE", "bytes=" + j + "-");
                        HttpResponse execute = newHttpClient.execute(httpGet);
                        int statusCode = execute.getStatusLine().getStatusCode();
                        if (statusCode == 206) {
                            Header[] headers = execute.getHeaders("Content-Range");
                            if (headers == null || headers.length == 0) {
                                j2 = 0;
                            } else {
                                String value = headers[0].getValue();
                                j2 = Long.parseLong(value.substring(value.indexOf(47) + 1));
                            }
                        } else if (statusCode != 200) {
                            throw new WeiboHttpException(readRsponse(execute), statusCode);
                        } else {
                            Header firstHeader = execute.getFirstHeader("Content-Length");
                            if (firstHeader != null) {
                                j2 = Integer.valueOf(firstHeader.getValue()).intValue();
                                j = 0;
                            } else {
                                j = 0;
                                j2 = 0;
                            }
                        }
                        HttpEntity entity = execute.getEntity();
                        Header firstHeader2 = execute.getFirstHeader("Content-Encoding");
                        GZIPInputStream content = (firstHeader2 == null || firstHeader2.getValue().toLowerCase().indexOf("gzip") <= -1) ? entity.getContent() : new GZIPInputStream(entity.getContent());
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
                        randomAccessFile.seek(j);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = content.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            randomAccessFile.write(bArr, 0, read);
                        }
                        randomAccessFile.close();
                        content.close();
                        if (j2 != 0 && file3.length() >= j2) {
                            file3.renameTo(file2);
                            String path = file2.getPath();
                            if (newHttpClient != null) {
                                newHttpClient.getConnectionManager().closeExpiredConnections();
                                newHttpClient.getConnectionManager().closeIdleConnections(300L, TimeUnit.SECONDS);
                            }
                            return path;
                        }
                        file3.delete();
                    } catch (IOException e) {
                        e.printStackTrace();
                        file3.delete();
                        if (newHttpClient != null) {
                            newHttpClient.getConnectionManager().closeExpiredConnections();
                            connectionManager = newHttpClient.getConnectionManager();
                            timeUnit = TimeUnit.SECONDS;
                        }
                    }
                    if (newHttpClient != null) {
                        newHttpClient.getConnectionManager().closeExpiredConnections();
                        connectionManager = newHttpClient.getConnectionManager();
                        timeUnit = TimeUnit.SECONDS;
                        connectionManager.closeIdleConnections(300L, timeUnit);
                    }
                    return "";
                } else {
                    return "";
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String getBoundry() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 12) {
                return stringBuffer.toString();
            }
            long currentTimeMillis = System.currentTimeMillis() + i2;
            long j = currentTimeMillis % 3;
            if (j == 0) {
                stringBuffer.append(((char) currentTimeMillis) % '\t');
            } else if (j == 1) {
                stringBuffer.append((char) ((currentTimeMillis % 26) + 65));
            } else {
                stringBuffer.append((char) ((currentTimeMillis % 26) + 97));
            }
            i = i2 + 1;
        }
    }

    private static Certificate getCertificate(String str) throws CertificateException, IOException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream resourceAsStream = HttpManager.class.getResourceAsStream(str);
        try {
            Certificate generateCertificate = certificateFactory.generateCertificate(resourceAsStream);
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return generateCertificate;
        } catch (Throwable th) {
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            throw th;
        }
    }

    public static HttpClient getNewHttpClient() {
        try {
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", getSSLSocketFactory(), 443));
            ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 25000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
            return new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    private static String getOauthSign(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
        }
        return calcOauthSignNative(context, sb.toString(), str4);
    }

    private static SSLSocketFactory getSSLSocketFactory() {
        if (sSSLSocketFactory == null) {
            try {
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                Certificate certificate = getCertificate("cacert_cn.cer");
                Certificate certificate2 = getCertificate("cacert_com.cer");
                keyStore.setCertificateEntry("cnca", certificate);
                keyStore.setCertificateEntry("comca", certificate2);
                sSSLSocketFactory = new SSLSocketFactoryEx(keyStore);
                LogUtil.d(TAG, "getSSLSocketFactory noraml !!!!!");
            } catch (Exception e) {
                e.printStackTrace();
                sSSLSocketFactory = SSLSocketFactory.getSocketFactory();
                LogUtil.d(TAG, "getSSLSocketFactory error default !!!!!");
            }
        }
        return sSSLSocketFactory;
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String openRedirectUrl4LocationUri(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpPost httpPost;
        HttpClient httpClient = null;
        try {
            try {
                CustomRedirectHandler customRedirectHandler = new CustomRedirectHandler() { // from class: com.sina.weibo.sdk.net.HttpManager.2
                    @Override // com.sina.weibo.sdk.net.CustomRedirectHandler
                    public void onReceivedException() {
                    }

                    @Override // com.sina.weibo.sdk.net.CustomRedirectHandler
                    public boolean shouldRedirectUrl(String str3) {
                        return true;
                    }
                };
                HttpClient httpClient2 = (DefaultHttpClient) getNewHttpClient();
                try {
                    httpClient2.setRedirectHandler(customRedirectHandler);
                    setHttpCommonParam(context, weiboParameters);
                    httpClient2.getParams().setParameter("http.route.default-proxy", NetStateManager.getAPN());
                    if (str2.equals("GET")) {
                        httpPost = new HttpGet(String.valueOf(str) + "?" + weiboParameters.encodeUrl());
                    } else {
                        httpPost = null;
                        if (str2.equals("POST")) {
                            httpPost = new HttpPost(str);
                        }
                    }
                    httpPost.setHeader("User-Agent", NetworkHelper.generateUA(context));
                    httpClient2.execute(httpPost);
                    String redirectUrl = customRedirectHandler.getRedirectUrl();
                    shutdownHttpClient(httpClient2);
                    return redirectUrl;
                } catch (IOException e) {
                    e = e;
                    throw new WeiboException(e);
                } catch (Throwable th) {
                    th = th;
                    httpClient = httpClient2;
                    shutdownHttpClient(httpClient);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String openUrl(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        String readRsponse = readRsponse(requestHttpExecute(context, str, str2, weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String openUrl4RdirectURL(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        HttpPost httpPost;
        HttpClient httpClient = null;
        try {
            try {
                HttpClient httpClient2 = (DefaultHttpClient) getNewHttpClient();
                try {
                    httpClient2.setRedirectHandler(new RedirectHandler() { // from class: com.sina.weibo.sdk.net.HttpManager.1
                        public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
                            LogUtil.d(HttpManager.TAG, "openUrl4RdirectURL getLocationURI method");
                            return null;
                        }

                        public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                            LogUtil.d(HttpManager.TAG, "openUrl4RdirectURL isRedirectRequested method");
                            return false;
                        }
                    });
                    setHttpCommonParam(context, weiboParameters);
                    httpClient2.getParams().setParameter("http.route.default-proxy", NetStateManager.getAPN());
                    if (str2.equals("GET")) {
                        String str3 = String.valueOf(str) + "?" + weiboParameters.encodeUrl();
                        LogUtil.d(TAG, "openUrl4RdirectURL GET url : " + str3);
                        httpPost = new HttpGet(str3);
                    } else {
                        httpPost = null;
                        if (str2.equals("POST")) {
                            httpPost = new HttpPost(str);
                            LogUtil.d(TAG, "openUrl4RdirectURL POST url : " + str);
                        }
                    }
                    HttpResponse execute = httpClient2.execute(httpPost);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    if (statusCode != 301 && statusCode != 302) {
                        if (statusCode == 200) {
                            String readRsponse = readRsponse(execute);
                            shutdownHttpClient(httpClient2);
                            return readRsponse;
                        }
                        throw new WeiboHttpException(readRsponse(execute), statusCode);
                    }
                    String value = execute.getFirstHeader(HttpHeaders.LOCATION).getValue();
                    LogUtil.d(TAG, "RedirectURL = " + value);
                    shutdownHttpClient(httpClient2);
                    return value;
                } catch (IOException e) {
                    e = e;
                    throw new WeiboException(e);
                } catch (Throwable th) {
                    th = th;
                    httpClient = httpClient2;
                    shutdownHttpClient(httpClient);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String readRsponse(HttpResponse httpResponse) throws WeiboException {
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        if (httpResponse == null) {
            return null;
        }
        HttpEntity entity = httpResponse.getEntity();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                InputStream content = entity.getContent();
                Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
                GZIPInputStream gZIPInputStream = content;
                if (firstHeader != null) {
                    gZIPInputStream = content;
                    if (firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
                        gZIPInputStream = new GZIPInputStream(content);
                    }
                }
                InputStream inputStream3 = gZIPInputStream;
                byte[] bArr = new byte[8192];
                while (true) {
                    InputStream inputStream4 = gZIPInputStream;
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                InputStream inputStream5 = gZIPInputStream;
                StringBuilder sb = new StringBuilder("readRsponse result : ");
                InputStream inputStream6 = gZIPInputStream;
                sb.append(str);
                inputStream2 = gZIPInputStream;
                inputStream = gZIPInputStream;
                LogUtil.d(TAG, sb.toString());
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                    return str;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return str;
                }
            } catch (IOException e3) {
                inputStream2 = inputStream;
                throw new WeiboException(e3);
            }
        } catch (Throwable th) {
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0247 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.apache.http.HttpResponse requestHttpExecute(android.content.Context r5, java.lang.String r6, java.lang.String r7, com.sina.weibo.sdk.net.WeiboParameters r8) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.HttpManager.requestHttpExecute(android.content.Context, java.lang.String, java.lang.String, com.sina.weibo.sdk.net.WeiboParameters):org.apache.http.HttpResponse");
    }

    private static void setHttpCommonParam(Context context, WeiboParameters weiboParameters) {
        String str;
        String str2;
        if (TextUtils.isEmpty(weiboParameters.getAppKey())) {
            str = "";
        } else {
            String aid = Utility.getAid(context, weiboParameters.getAppKey());
            str = aid;
            if (!TextUtils.isEmpty(aid)) {
                weiboParameters.put("aid", aid);
                str = aid;
            }
        }
        String timestamp = getTimestamp();
        weiboParameters.put("oauth_timestamp", timestamp);
        Object obj = weiboParameters.get("access_token");
        Object obj2 = weiboParameters.get(Oauth2AccessToken.KEY_REFRESH_TOKEN);
        Object obj3 = weiboParameters.get("phone");
        if (obj != null && (obj instanceof String)) {
            str2 = (String) obj;
        } else if (obj2 == null || !(obj2 instanceof String)) {
            str2 = "";
            if (obj3 != null) {
                str2 = "";
                if (obj3 instanceof String) {
                    str2 = (String) obj3;
                }
            }
        } else {
            str2 = (String) obj2;
        }
        weiboParameters.put("oauth_sign", getOauthSign(context, str, str2, weiboParameters.getAppKey(), timestamp));
    }

    public static void shutdownHttpClient(HttpClient httpClient) {
        if (httpClient != null) {
            try {
                httpClient.getConnectionManager().closeExpiredConnections();
            } catch (Exception e) {
            }
        }
    }
}
