package com.tencent.cloud.huiyansdkface.okhttp3.internal;

import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.RequestBody;
import com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Header;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.codec.CharEncoding;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/Util.class */
public final class Util {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f35904a;

    /* renamed from: c  reason: collision with root package name */
    public static final ResponseBody f35905c;
    public static final RequestBody d;
    private static final Method r;
    private static final Pattern s;
    public static final String[] b = new String[0];
    private static final ByteString i = ByteString.decodeHex("efbbbf");
    private static final ByteString j = ByteString.decodeHex("feff");
    private static final ByteString k = ByteString.decodeHex("fffe");
    private static final ByteString l = ByteString.decodeHex("0000ffff");
    private static final ByteString m = ByteString.decodeHex("ffff0000");
    public static final Charset e = Charset.forName("UTF-8");
    public static final Charset f = Charset.forName("ISO-8859-1");
    private static final Charset n = Charset.forName(CharEncoding.UTF_16BE);
    private static final Charset o = Charset.forName(CharEncoding.UTF_16LE);
    private static final Charset p = Charset.forName("UTF-32BE");
    private static final Charset q = Charset.forName("UTF-32LE");
    public static final TimeZone g = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> h = new Comparator<String>() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.Util.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    static {
        byte[] bArr = new byte[0];
        f35904a = bArr;
        Method method = null;
        f35905c = ResponseBody.create((MediaType) null, bArr);
        d = RequestBody.create((MediaType) null, f35904a);
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception e2) {
        }
        r = method;
        s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    private Util() {
    }

    private static String a(byte[] bArr) {
        int i2;
        int i3;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i2 = i6;
            if (i5 >= bArr.length) {
                break;
            }
            int i7 = i5;
            while (true) {
                i3 = i7;
                if (i3 >= 16 || bArr[i3] != 0 || bArr[i3 + 1] != 0) {
                    break;
                }
                i7 = i3 + 2;
            }
            int i8 = i3 - i5;
            int i9 = i4;
            int i10 = i2;
            if (i8 > i2) {
                i9 = i4;
                i10 = i2;
                if (i8 >= 4) {
                    i10 = i8;
                    i9 = i5;
                }
            }
            i5 = i3 + 2;
            i4 = i9;
            i6 = i10;
        }
        Buffer buffer = new Buffer();
        int i11 = 0;
        while (i11 < bArr.length) {
            if (i11 == i4) {
                buffer.writeByte(58);
                int i12 = i11 + i2;
                i11 = i12;
                if (i12 == 16) {
                    buffer.writeByte(58);
                    i11 = i12;
                }
            } else {
                if (i11 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong(((bArr[i11] & 255) << 8) | (bArr[i11 + 1] & 255));
                i11 += 2;
            }
        }
        return buffer.readUtf8();
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0126, code lost:
        if (r12 == 16) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012c, code lost:
        if (r14 != (-1)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012f, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0131, code lost:
        r0 = r12 - r14;
        java.lang.System.arraycopy((java.lang.Object) r0, r14, (java.lang.Object) r0, 16 - r0, r0);
        java.util.Arrays.fill(r0, r14, (16 - r12) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x015c, code lost:
        return java.net.InetAddress.getByAddress(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0164, code lost:
        throw new java.lang.AssertionError();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress a(java.lang.String r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.Util.a(java.lang.String, int, int):java.net.InetAddress");
    }

    private static boolean a(String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= str.length()) {
                return false;
            }
            char charAt = str.charAt(i3);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        char charAt;
        int i5 = i4;
        int i6 = i2;
        while (i6 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            int i7 = i6;
            if (i5 != i4) {
                if (str.charAt(i6) != '.') {
                    return false;
                }
                i7 = i6 + 1;
            }
            i6 = i7;
            int i8 = 0;
            while (i6 < i3 && (charAt = str.charAt(i6)) >= '0' && charAt <= '9') {
                if (i8 == 0 && i7 != i6) {
                    return false;
                }
                i8 = ((i8 * 10) + charAt) - 48;
                if (i8 > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i7 == 0) {
                return false;
            }
            bArr[i5] = (byte) i8;
            i5++;
        }
        return i5 == i4 + 4;
    }

    public static void addSuppressedIfPossible(Throwable th, Throwable th2) {
        Method method = r;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
            }
        }
    }

    public static AssertionError assertionError(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
            return assertionError;
        } catch (IllegalStateException e2) {
            return assertionError;
        }
    }

    public static Charset bomAwareCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        if (bufferedSource.rangeEquals(0L, i)) {
            bufferedSource.skip(i.size());
            return e;
        } else if (bufferedSource.rangeEquals(0L, j)) {
            bufferedSource.skip(j.size());
            return n;
        } else if (bufferedSource.rangeEquals(0L, k)) {
            bufferedSource.skip(k.size());
            return o;
        } else if (bufferedSource.rangeEquals(0L, l)) {
            bufferedSource.skip(l.size());
            return p;
        } else if (bufferedSource.rangeEquals(0L, m)) {
            bufferedSource.skip(m.size());
            return q;
        } else {
            return charset;
        }
    }

    public static String canonicalizeHost(String str) {
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (a(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException e2) {
                return null;
            }
        }
        InetAddress a2 = (str.startsWith("[") && str.endsWith("]")) ? a(str, 1, str.length() - 1) : a(str, 0, str.length());
        if (a2 == null) {
            return null;
        }
        byte[] address = a2.getAddress();
        if (address.length == 16) {
            return a(address);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    public static int checkDuration(String str, long j2, TimeUnit timeUnit) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || i2 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static void checkOffsetAndCount(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!isAndroidGetsocknameError(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception e4) {
            }
        }
    }

    public static String[] concat(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int decodeHexDigit(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public static int delimiterOffset(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int delimiterOffset(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static boolean discard(Source source, int i2, TimeUnit timeUnit) {
        try {
            return skipAll(source, i2, timeUnit);
        } catch (IOException e2) {
            return false;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x004b, code lost:
        if (r3.port() != com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl.defaultPort(r3.scheme())) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String hostHeader(com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl r3, boolean r4) {
        /*
            r0 = r3
            java.lang.String r0 = r0.host()
            java.lang.String r1 = ":"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L35
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "["
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r3
            java.lang.String r1 = r1.host()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r1 = "]"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r0 = r0.toString()
            r5 = r0
            goto L3a
        L35:
            r0 = r3
            java.lang.String r0 = r0.host()
            r5 = r0
        L3a:
            r0 = r4
            if (r0 != 0) goto L4e
            r0 = r5
            r6 = r0
            r0 = r3
            int r0 = r0.port()
            r1 = r3
            java.lang.String r1 = r1.scheme()
            int r1 = com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl.defaultPort(r1)
            if (r0 == r1) goto L71
        L4e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r3
            int r1 = r1.port()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r0 = r0.toString()
            r6 = r0
        L71:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.Util.hostHeader(com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl, boolean):java.lang.String");
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> immutableList(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int indexOf(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return -1;
            }
            if (comparator.compare(strArr[i3], str) == 0) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public static int indexOfControlOrNonAscii(String str) {
        int i2;
        int length = str.length();
        while (true) {
            int i3 = i2;
            if (i3 < length) {
                char charAt = str.charAt(i3);
                i2 = (charAt > 31 && charAt < 127) ? i3 + 1 : 0;
                return i3;
            }
            return -1;
        }
    }

    public static String[] intersect(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            String str = strArr[i3];
            int length2 = strArr2.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2) {
                    break;
                } else if (comparator.compare(str, strArr2[i5]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean nonEmptyIntersection(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            String str = strArr[i3];
            int length2 = strArr2.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < length2) {
                    if (comparator.compare(str, strArr2[i5]) == 0) {
                        return true;
                    }
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    public static X509TrustManager platformTrustManager() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw assertionError("No System TLS", e2);
        }
    }

    public static boolean skipAll(Source source, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i2)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            Timeout timeout = source.timeout();
            if (deadlineNanoTime == Long.MAX_VALUE) {
                timeout.clearDeadline();
                return true;
            }
            timeout.deadlineNanoTime(nanoTime + deadlineNanoTime);
            return true;
        } catch (InterruptedIOException e2) {
            Timeout timeout2 = source.timeout();
            if (deadlineNanoTime == Long.MAX_VALUE) {
                timeout2.clearDeadline();
                return false;
            }
            timeout2.deadlineNanoTime(nanoTime + deadlineNanoTime);
            return false;
        } catch (Throwable th) {
            Timeout timeout3 = source.timeout();
            if (deadlineNanoTime == Long.MAX_VALUE) {
                timeout3.clearDeadline();
            } else {
                timeout3.deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static int skipLeadingAsciiWhitespace(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i2, int i3) {
        while (true) {
            i3--;
            if (i3 < i2) {
                return i2;
            }
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.Util.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, String.this);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static Headers toHeaders(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            Internal.f35902a.addLenient(builder, header.g.utf8(), header.h.utf8());
        }
        return builder.build();
    }

    public static String trimSubstring(String str, int i2, int i3) {
        int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i2, i3);
        return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i3));
    }

    public static boolean verifyAsIpAddress(String str) {
        return s.matcher(str).matches();
    }
}
