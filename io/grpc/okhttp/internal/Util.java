package io.grpc.okhttp.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/internal/Util.class */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private Util() {
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void closeAll(Closeable closeable, Closeable closeable2) throws IOException {
        IOException iOException;
        try {
            closeable.close();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            closeable2.close();
            iOException = th;
        } catch (Throwable th2) {
            iOException = th;
            if (th == null) {
                iOException = th2;
            }
        }
        if (iOException == null) {
            return;
        }
        if (iOException instanceof IOException) {
            throw iOException;
        }
        if (iOException instanceof RuntimeException) {
            throw iOException;
        }
        if (!(iOException instanceof Error)) {
            throw new AssertionError(iOException);
        }
        throw iOException;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!isAndroidGetsocknameError(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static boolean discard(Source source, int i, TimeUnit timeUnit) {
        try {
            return skipAll(source, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> immutableList(T[] tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    private static <T> List<T> intersect(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            T t = tArr[i2];
            int length2 = tArr2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < length2) {
                    T t2 = tArr2[i4];
                    if (t.equals(t2)) {
                        arrayList.add(t2);
                        break;
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] intersect(Class<T> cls, T[] tArr, T[] tArr2) {
        List intersect = intersect(tArr, tArr2);
        return (T[]) intersect.toArray((Object[]) Array.newInstance((Class<?>) cls, intersect.size()));
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static String md5Hex(String str) {
        try {
            return ByteString.of(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"))).hex();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static ByteString sha1(ByteString byteString) {
        try {
            return ByteString.of(MessageDigest.getInstance("SHA-1").digest(byteString.toByteArray()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static String shaBase64(String str) {
        try {
            return ByteString.of(MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8"))).base64();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static boolean skipAll(Source source, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 2048L) != -1) {
                buffer.clear();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return true;
            }
            source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return true;
        } catch (InterruptedIOException e) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return false;
            }
            source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: io.grpc.okhttp.internal.Util.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, String.this);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
        r0 = new okio.Buffer();
        r0.writeUtf8(r5, 0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
        if (r6 >= r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
        r0 = r5.codePointAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        if (r0 <= 31) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (r0 >= 127) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        r0 = 63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
        r0.writeUtf8CodePoint(r0);
        r6 = r6 + java.lang.Character.charCount(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        r10 = r0.readUtf8();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String toHumanReadableAscii(java.lang.String r5) {
        /*
            r0 = r5
            int r0 = r0.length()
            r9 = r0
            r0 = 0
            r6 = r0
        L8:
            r0 = r5
            r10 = r0
            r0 = r6
            r1 = r9
            if (r0 >= r1) goto L77
            r0 = r5
            r1 = r6
            int r0 = r0.codePointAt(r1)
            r7 = r0
            r0 = r7
            r1 = 31
            if (r0 <= r1) goto L2d
            r0 = r7
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 >= r1) goto L2d
            r0 = r6
            r1 = r7
            int r1 = java.lang.Character.charCount(r1)
            int r0 = r0 + r1
            r6 = r0
            goto L8
        L2d:
            okio.Buffer r0 = new okio.Buffer
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            r1 = r5
            r2 = 0
            r3 = r6
            okio.Buffer r0 = r0.writeUtf8(r1, r2, r3)
        L3f:
            r0 = r6
            r1 = r9
            if (r0 >= r1) goto L70
            r0 = r5
            r1 = r6
            int r0 = r0.codePointAt(r1)
            r8 = r0
            r0 = r8
            r1 = 31
            if (r0 <= r1) goto L5c
            r0 = r8
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 >= r1) goto L5c
            r0 = r8
            r7 = r0
            goto L5f
        L5c:
            r0 = 63
            r7 = r0
        L5f:
            r0 = r10
            r1 = r7
            okio.Buffer r0 = r0.writeUtf8CodePoint(r1)
            r0 = r6
            r1 = r8
            int r1 = java.lang.Character.charCount(r1)
            int r0 = r0 + r1
            r6 = r0
            goto L3f
        L70:
            r0 = r10
            java.lang.String r0 = r0.readUtf8()
            r10 = r0
        L77:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.internal.Util.toHumanReadableAscii(java.lang.String):java.lang.String");
    }
}
