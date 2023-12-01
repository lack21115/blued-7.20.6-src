package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bh.class */
public class bh {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f41278a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f41279c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bh$a.class */
    public static final class a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private boolean f41280a;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) {
            int read;
            if (this.f41280a || (read = super.read(bArr, i, i2)) == -1) {
                this.f41280a = true;
                return -1;
            }
            return read;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bh$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f41281a;

        /* renamed from: a  reason: collision with other field name */
        public Map<String, String> f218a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f41281a), this.f218a.toString());
        }
    }

    public static int a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static NetworkInfo m11534a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static bf a(Context context, String str, String str2, Map<String, String> map, String str3) {
        BufferedReader bufferedReader;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z;
        bf bfVar = new bf();
        try {
            try {
                try {
                    HttpURLConnection m11536a = m11536a(context, m11537a(str));
                    m11536a.setConnectTimeout(10000);
                    m11536a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == null) {
                        str4 = "GET";
                    }
                    m11536a.setRequestMethod(str4);
                    int i = 0;
                    if (map != null) {
                        boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(map.get("Content-Encoding"));
                        Iterator<String> it = map.keySet().iterator();
                        while (true) {
                            z = equalsIgnoreCase;
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            m11536a.setRequestProperty(next, map.get(next));
                        }
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        m11536a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        GZIPOutputStream gZIPOutputStream = z ? new GZIPOutputStream(m11536a.getOutputStream()) : m11536a.getOutputStream();
                        try {
                            gZIPOutputStream.write(bytes, 0, bytes.length);
                            gZIPOutputStream.flush();
                            gZIPOutputStream.close();
                        } catch (IOException e) {
                            e = e;
                            outputStream = gZIPOutputStream;
                            bufferedReader = null;
                            OutputStream outputStream3 = outputStream;
                            StringBuilder sb = new StringBuilder("err while request ");
                            OutputStream outputStream4 = outputStream;
                            sb.append(str);
                            OutputStream outputStream5 = outputStream;
                            sb.append(":");
                            OutputStream outputStream6 = outputStream;
                            sb.append(e.getClass().getSimpleName());
                            OutputStream outputStream7 = outputStream;
                            throw new IOException(sb.toString());
                        } catch (Throwable th) {
                            th = th;
                            outputStream2 = gZIPOutputStream;
                            bufferedReader = null;
                            throw new IOException(th.getMessage());
                        }
                    }
                    bfVar.f41277a = m11536a.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.b.m11394a("Http POST Response Code: " + bfVar.f41277a);
                    while (true) {
                        String headerFieldKey = m11536a.getHeaderFieldKey(i);
                        String headerField = m11536a.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException e2) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new a(m11536a.getErrorStream())));
                            }
                        } else {
                            bfVar.f217a.put(headerFieldKey, headerField);
                            i = i + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new a(m11536a.getInputStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(property);
                        }
                        bfVar.f216a = stringBuffer.toString();
                        bufferedReader.close();
                        x.a((Closeable) null);
                        x.a((Closeable) null);
                        return bfVar;
                    } catch (IOException e3) {
                        e = e3;
                        outputStream = null;
                        OutputStream outputStream32 = outputStream;
                        StringBuilder sb2 = new StringBuilder("err while request ");
                        OutputStream outputStream42 = outputStream;
                        sb2.append(str);
                        OutputStream outputStream52 = outputStream;
                        sb2.append(":");
                        OutputStream outputStream62 = outputStream;
                        sb2.append(e.getClass().getSimpleName());
                        OutputStream outputStream72 = outputStream;
                        throw new IOException(sb2.toString());
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream2 = null;
                        throw new IOException(th.getMessage());
                    }
                } catch (IOException e4) {
                    e = e4;
                    bufferedReader = null;
                    outputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                outputStream2 = null;
            }
        } catch (Throwable th4) {
            x.a((Closeable) str3);
            x.a((Closeable) null);
            throw th4;
        }
    }

    public static bf a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        if (context != null) {
            if (url != null) {
                URL url2 = !z ? new URL(a(url.toString())) : url;
                try {
                    HttpURLConnection.setFollowRedirects(true);
                    HttpURLConnection m11536a = m11536a(context, url2);
                    m11536a.setConnectTimeout(10000);
                    m11536a.setReadTimeout(15000);
                    if (!TextUtils.isEmpty(str)) {
                        m11536a.setRequestProperty("User-Agent", str);
                    }
                    if (str2 != null) {
                        m11536a.setRequestProperty("Cookie", str2);
                    }
                    if (map != null) {
                        for (String str3 : map.keySet()) {
                            m11536a.setRequestProperty(str3, map.get(str3));
                        }
                    }
                    if (bVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                        bVar.f41281a = m11536a.getResponseCode();
                        if (bVar.f218a == null) {
                            bVar.f218a = new HashMap();
                        }
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            String headerFieldKey = m11536a.getHeaderFieldKey(i2);
                            String headerField = m11536a.getHeaderField(i2);
                            if (headerFieldKey == null && headerField == null) {
                                break;
                            }
                            if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                                bVar.f218a.put(headerFieldKey, headerField);
                            }
                            i = i2 + 1;
                        }
                    }
                    return new a(m11536a.getInputStream());
                } catch (IOException e) {
                    throw new IOException("IOException:" + e.getClass().getSimpleName());
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }
            throw new IllegalArgumentException("url");
        }
        throw new IllegalArgumentException("context");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m11535a(Context context) {
        if (e(context)) {
            return "wifi";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return "";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            return (activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName() + "-" + activeNetworkInfo.getExtraInfo()).toLowerCase();
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = a(context, url, z, str, str3);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 == read) {
                    x.a((Closeable) inputStream);
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            x.a((Closeable) inputStream);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, bm.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", com.anythink.expressad.foundation.g.f.g.c.f7906c);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    bufferedReader = new BufferedReader(new InputStreamReader(new a(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                String stringBuffer2 = stringBuffer.toString();
                                x.a((Closeable) fileInputStream2);
                                x.a(bufferedReader);
                                return stringBuffer2;
                            }
                            stringBuffer.append(readLine);
                        } catch (IOException e) {
                            e = e;
                            bufferedReader2 = bufferedReader;
                            fileInputStream = fileInputStream2;
                            e = e;
                            FileInputStream fileInputStream3 = fileInputStream;
                            StringBuilder sb = new StringBuilder("IOException:");
                            FileInputStream fileInputStream4 = fileInputStream;
                            sb.append(e.getClass().getSimpleName());
                            FileInputStream fileInputStream5 = fileInputStream;
                            throw new IOException(sb.toString());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedReader2 = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            x.a((Closeable) file);
            x.a((Closeable) null);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("Failed to convert from params map to string: ".concat(String.valueOf(e)));
                    com.xiaomi.channel.commonutils.logger.b.m11394a("map: " + map.toString());
                    return null;
                }
            }
        }
        StringBuffer stringBuffer2 = stringBuffer;
        if (stringBuffer.length() > 0) {
            stringBuffer2 = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HttpURLConnection m11536a(Context context, URL url) {
        return (HttpURLConnection) (("http".equals(url.getProtocol()) && m11538a(context)) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
    }

    /* renamed from: a  reason: collision with other method in class */
    private static URL m11537a(String str) {
        return new URL(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m11538a(Context context) {
        if ("CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager == null) {
                    return false;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                return !TextUtils.isEmpty(extraInfo) && extraInfo.length() >= 3 && extraInfo.contains("ctwap");
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        return a(context) >= 0;
    }

    public static boolean c(Context context) {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities != null) {
                        z = networkCapabilities.hasCapability(16);
                    }
                } catch (Exception e) {
                }
            } else {
                z = b(context);
            }
            return z && d(context);
        }
        z = false;
        if (z) {
            return false;
        }
    }

    public static boolean d(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        } catch (Exception e) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean e(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean f(Context context) {
        NetworkInfo m11534a = m11534a(context);
        return m11534a != null && m11534a.getType() == 0 && 20 == m11534a.getSubtype();
    }

    public static boolean g(Context context) {
        NetworkInfo m11534a = m11534a(context);
        return m11534a != null && m11534a.getType() == 0 && 13 == m11534a.getSubtype();
    }

    public static boolean h(Context context) {
        NetworkInfo m11534a = m11534a(context);
        if (m11534a != null && m11534a.getType() == 0) {
            String subtypeName = m11534a.getSubtypeName();
            if ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName)) {
                return true;
            }
            switch (m11534a.getSubtype()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return true;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return false;
    }

    public static boolean i(Context context) {
        NetworkInfo m11534a = m11534a(context);
        if (m11534a != null && m11534a.getType() == 0) {
            int subtype = m11534a.getSubtype();
            return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
        }
        return false;
    }
}
