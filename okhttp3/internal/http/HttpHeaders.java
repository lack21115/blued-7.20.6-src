package okhttp3.internal.http;

import com.android.internal.telephony.PhoneConstants;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/HttpHeaders.class */
public final class HttpHeaders {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteString f43887a = ByteString.encodeUtf8("\"\\");
    private static final ByteString b = ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    private static int a(Buffer buffer, byte b2) {
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b2) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static long a(Headers headers) {
        return a(headers.get("Content-Length"));
    }

    public static long a(Response response) {
        return a(response.headers());
    }

    private static String a(char c2, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c2);
        return new String(cArr);
    }

    public static List<Challenge> a(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= headers.size()) {
                return arrayList;
            }
            if (str.equalsIgnoreCase(headers.name(i2))) {
                a(arrayList, new Buffer().writeUtf8(headers.value(i2)));
            }
            i = i2 + 1;
        }
    }

    public static Headers a(Headers headers, Headers headers2) {
        Set<String> c2 = c(headers2);
        if (c2.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (c2.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e0, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e0, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.util.List<okhttp3.Challenge> r7, okio.Buffer r8) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.a(java.util.List, okio.Buffer):void");
    }

    public static void a(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    public static boolean a(Response response, Headers headers, Request request) {
        for (String str : e(response)) {
            if (!Util.a(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Buffer buffer) {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b2 = buffer.getByte(0L);
            if (b2 != 44) {
                if (b2 != 32 && b2 != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z = true;
            }
        }
        return z;
    }

    public static int b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException e) {
            return i;
        }
    }

    private static String b(Buffer buffer) {
        if (buffer.readByte() != 34) {
            throw new IllegalArgumentException();
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long indexOfElement = buffer.indexOfElement(f43887a);
            if (indexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(indexOfElement) == 34) {
                buffer2.write(buffer, indexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            } else if (buffer.size() == indexOfElement + 1) {
                return null;
            } else {
                buffer2.write(buffer, indexOfElement);
                buffer.readByte();
                buffer2.write(buffer, 1L);
            }
        }
    }

    public static boolean b(Headers headers) {
        return c(headers).contains(PhoneConstants.APN_TYPE_ALL);
    }

    public static boolean b(Response response) {
        return b(response.headers());
    }

    private static String c(Buffer buffer) {
        try {
            long indexOfElement = buffer.indexOfElement(b);
            long j = indexOfElement;
            if (indexOfElement == -1) {
                j = buffer.size();
            }
            if (j != 0) {
                return buffer.readUtf8(j);
            }
            return null;
        } catch (EOFException e) {
            throw new AssertionError();
        }
    }

    public static Set<String> c(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return emptySet;
            }
            if (com.google.common.net.HttpHeaders.VARY.equalsIgnoreCase(headers.name(i2))) {
                String value = headers.value(i2);
                TreeSet treeSet = emptySet;
                if (emptySet.isEmpty()) {
                    treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                String[] split = value.split(",");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    emptySet = treeSet;
                    if (i4 < length) {
                        treeSet.add(split[i4].trim());
                        i3 = i4 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public static Headers c(Response response) {
        return a(response.networkResponse().request().headers(), response.headers());
    }

    public static boolean d(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && a(response) == -1 && !DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    private static Set<String> e(Response response) {
        return c(response.headers());
    }
}
