package com.sobot.network.http.cookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/cookie/PersistentCookieStore.class */
public class PersistentCookieStore implements CookieStore {
    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private static final String LOG_TAG = "PersistentCookieStore";
    private final SharedPreferences cookiePrefs;
    private final HashMap<String, ConcurrentHashMap<String, HttpCookie>> cookies = new HashMap<>();

    public PersistentCookieStore(Context context) {
        HttpCookie decodeCookie;
        this.cookiePrefs = context.getSharedPreferences(COOKIE_PREFS, 0);
        for (Map.Entry<String, ?> entry : this.cookiePrefs.getAll().entrySet()) {
            if (((String) entry.getValue()) != null && !((String) entry.getValue()).startsWith(COOKIE_NAME_PREFIX)) {
                String[] split = TextUtils.split((String) entry.getValue(), ",");
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        String str = split[i2];
                        SharedPreferences sharedPreferences = this.cookiePrefs;
                        String string = sharedPreferences.getString(COOKIE_NAME_PREFIX + str, null);
                        if (string != null && (decodeCookie = decodeCookie(string)) != null) {
                            if (!this.cookies.containsKey(entry.getKey())) {
                                this.cookies.put(entry.getKey(), new ConcurrentHashMap<>());
                            }
                            this.cookies.get(entry.getKey()).put(str, decodeCookie);
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
    }

    @Override // java.net.CookieStore
    public void add(URI uri, HttpCookie httpCookie) {
        String cookieToken = getCookieToken(uri, httpCookie);
        if (!httpCookie.hasExpired()) {
            if (!this.cookies.containsKey(uri.getHost())) {
                this.cookies.put(uri.getHost(), new ConcurrentHashMap<>());
            }
            this.cookies.get(uri.getHost()).put(cookieToken, httpCookie);
        } else if (this.cookies.containsKey(uri.toString())) {
            this.cookies.get(uri.getHost()).remove(cookieToken);
        }
        SharedPreferences.Editor edit = this.cookiePrefs.edit();
        edit.putString(uri.getHost(), TextUtils.join(",", this.cookies.get(uri.getHost()).keySet()));
        edit.putString(COOKIE_NAME_PREFIX + cookieToken, encodeCookie(new SerializableHttpCookie(httpCookie)));
        edit.commit();
    }

    protected String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString().toUpperCase(Locale.US);
            }
            int i3 = bArr[i2] & 255;
            if (i3 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i3));
            i = i2 + 1;
        }
    }

    protected HttpCookie decodeCookie(String str) {
        try {
            return ((SerializableHttpCookie) new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(str))).readObject()).getCookie();
        } catch (IOException e) {
            Log.d(LOG_TAG, "IOException in decodeCookie", e);
            return null;
        } catch (ClassNotFoundException e2) {
            Log.d(LOG_TAG, "ClassNotFoundException in decodeCookie", e2);
            return null;
        }
    }

    protected String encodeCookie(SerializableHttpCookie serializableHttpCookie) {
        if (serializableHttpCookie == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializableHttpCookie);
            return byteArrayToHexString(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            Log.d(LOG_TAG, "IOException in encodeCookie", e);
            return null;
        }
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> get(URI uri) {
        ArrayList arrayList = new ArrayList();
        if (this.cookies.containsKey(uri.getHost())) {
            arrayList.addAll(this.cookies.get(uri.getHost()).values());
        }
        return arrayList;
    }

    protected String getCookieToken(URI uri, HttpCookie httpCookie) {
        return httpCookie.getName() + httpCookie.getDomain();
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> getCookies() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.cookies.keySet()) {
            arrayList.addAll(this.cookies.get(str).values());
        }
        return arrayList;
    }

    @Override // java.net.CookieStore
    public List<URI> getURIs() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.cookies.keySet()) {
            try {
                arrayList.add(new URI(str));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    protected byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
            i = i2 + 2;
        }
    }

    @Override // java.net.CookieStore
    public boolean remove(URI uri, HttpCookie httpCookie) {
        String cookieToken = getCookieToken(uri, httpCookie);
        if (this.cookies.containsKey(uri.getHost()) && this.cookies.get(uri.getHost()).containsKey(cookieToken)) {
            this.cookies.get(uri.getHost()).remove(cookieToken);
            SharedPreferences.Editor edit = this.cookiePrefs.edit();
            SharedPreferences sharedPreferences = this.cookiePrefs;
            if (sharedPreferences.contains(COOKIE_NAME_PREFIX + cookieToken)) {
                edit.remove(COOKIE_NAME_PREFIX + cookieToken);
            }
            edit.putString(uri.getHost(), TextUtils.join(",", this.cookies.get(uri.getHost()).keySet()));
            edit.commit();
            return true;
        }
        return false;
    }

    @Override // java.net.CookieStore
    public boolean removeAll() {
        SharedPreferences.Editor edit = this.cookiePrefs.edit();
        edit.clear();
        edit.commit();
        this.cookies.clear();
        return true;
    }
}
