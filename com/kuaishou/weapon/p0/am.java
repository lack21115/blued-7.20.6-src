package com.kuaishou.weapon.p0;

import android.content.Context;
import android.media.AudioSystem;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/am.class */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10115a = "tun";
    private static final String b = "ppp";

    /* renamed from: c  reason: collision with root package name */
    private static int f10116c;

    public static JSONArray a() {
        BufferedReader bufferedReader;
        DataInputStream dataInputStream;
        JSONArray jSONArray = new JSONArray();
        try {
            dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /proc/net/route").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                try {
                    HashSet hashSet = new HashSet();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String a2 = bn.a(readLine);
                        if (a2.contains(f10115a) || a2.contains(b)) {
                            hashSet.add(a2.split("\t")[0]);
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    try {
                        dataInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th) {
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (bufferedReader == null) {
                        return jSONArray;
                    }
                    bufferedReader.close();
                    return jSONArray;
                }
            } catch (Throwable th2) {
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            dataInputStream = null;
        }
        try {
            bufferedReader.close();
            return jSONArray;
        } catch (IOException e3) {
            return jSONArray;
        }
    }

    public static boolean a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                return networkCapabilities != null && networkCapabilities.hasTransport(4);
            }
            return connectivityManager.getNetworkInfo(17).isConnectedOrConnecting();
        } catch (Throwable th) {
            return false;
        }
    }

    public static String b() {
        String property = System.getProperty("http.proxyHost");
        String str = property;
        if (TextUtils.isEmpty(property)) {
            str = "";
        }
        return str;
    }

    public static String b(Context context) {
        try {
            JSONArray a2 = a();
            return a2 != null ? a2.toString() : a(context) ? "[\"con\"]" : "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static int c() {
        return f10116c;
    }

    public static String d() {
        StringBuilder sb = new StringBuilder();
        try {
            f10116c = 0;
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            if (keyStore != null) {
                keyStore.load(null, null);
                Enumeration<String> aliases = keyStore.aliases();
                while (aliases.hasMoreElements()) {
                    f10116c++;
                    X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                    if (x509Certificate.getIssuerDN().getName().contains("2022") || x509Certificate.getIssuerDN().getName().contains("2023") || x509Certificate.getIssuerDN().getName().contains("HttpCanary") || x509Certificate.getIssuerDN().getName().contains("macbook") || x509Certificate.getIssuerDN().getName().contains(AudioSystem.DEVICE_OUT_PROXY_NAME) || x509Certificate.getIssuerDN().getName().contains("Proxy") || x509Certificate.getIssuerDN().getName().contains(com.baidu.mobads.sdk.internal.at.f6479a) || x509Certificate.getIssuerDN().getName().contains("github")) {
                        sb.append(x509Certificate.getIssuerDN().getName());
                        sb.append("|");
                    }
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable th) {
        }
        return sb.toString();
    }
}
