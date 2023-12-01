package com.anythink.core.common.res;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/a.class */
public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final String f6880a = "journal";
    static final String b = "journal.tmp";

    /* renamed from: c  reason: collision with root package name */
    static final String f6881c = "libcore.io.DiskLruCache";
    static final String d = "1";
    static final long e = -1;
    private static final String f = "CLEAN";
    private static final String g = "DIRTY";
    private static final String h = "REMOVE";
    private static final String i = "READ";
    private static final Charset j = Charset.forName("UTF-8");
    private static final int k = 8192;
    private final File l;
    private final File m;
    private final File n;
    private final long p;
    private Writer s;
    private int u;
    private long r = 0;
    private final LinkedHashMap<String, b> t = new LinkedHashMap<>(0, 0.75f, true);
    private long v = 0;
    private final ExecutorService w = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> x = new Callable<Void>() { // from class: com.anythink.core.common.res.a.1
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.s == null) {
                    return null;
                }
                a.this.l();
                if (a.this.h()) {
                    a.this.d();
                    a.e(a.this);
                }
                return null;
            }
        }
    };
    private final int o = 1;
    private final int q = 1;

    /* renamed from: com.anythink.core.common.res.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/a$a.class */
    public final class C0106a {
        private final b b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6885c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.anythink.core.common.res.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/a$a$a.class */
        public final class C0107a extends FilterOutputStream {
            private C0107a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C0107a(C0106a c0106a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C0106a.b(C0106a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C0106a.b(C0106a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C0106a.b(C0106a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C0106a.b(C0106a.this);
                }
            }
        }

        private C0106a(b bVar) {
            this.b = bVar;
        }

        /* synthetic */ C0106a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        private void a(int i, String str) {
            OutputStreamWriter outputStreamWriter;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(a(i), a.j);
                try {
                    outputStreamWriter2.write(str);
                    a.a(outputStreamWriter2);
                } catch (Throwable th) {
                    outputStreamWriter = outputStreamWriter2;
                    th = th;
                    a.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter = null;
            }
        }

        private InputStream b(int i) {
            synchronized (a.this) {
                if (this.b.e == this) {
                    if (this.b.d) {
                        return new FileInputStream(this.b.a(i));
                    }
                    return null;
                }
                throw new IllegalStateException();
            }
        }

        static /* synthetic */ boolean b(C0106a c0106a) {
            c0106a.f6885c = true;
            return true;
        }

        private String c(int i) {
            InputStream b = b(i);
            if (b != null) {
                return a.a(b);
            }
            return null;
        }

        public final OutputStream a(int i) {
            C0107a c0107a;
            synchronized (a.this) {
                if (this.b.e != this) {
                    throw new IllegalStateException();
                }
                c0107a = new C0107a(this, new FileOutputStream(this.b.b(i)), (byte) 0);
            }
            return c0107a;
        }

        public final void a() {
            if (!this.f6885c) {
                a.this.a(this, true);
                return;
            }
            a.this.a(this, false);
            a.this.c(this.b.b);
        }

        public final void b() {
            a.this.a(this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/a$b.class */
    public final class b {
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final long[] f6890c;
        private boolean d;
        private C0106a e;
        private long f;

        private b(String str) {
            this.b = str;
            this.f6890c = new long[a.this.q];
        }

        /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        static /* synthetic */ void a(b bVar, String[] strArr) {
            if (strArr.length != a.this.q) {
                throw b(strArr);
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        return;
                    }
                    bVar.f6890c[i2] = Long.parseLong(strArr[i2]);
                    i = i2 + 1;
                } catch (NumberFormatException e) {
                    throw b(strArr);
                }
            }
        }

        private void a(String[] strArr) {
            if (strArr.length != a.this.q) {
                throw b(strArr);
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        return;
                    }
                    this.f6890c[i2] = Long.parseLong(strArr[i2]);
                    i = i2 + 1;
                } catch (NumberFormatException e) {
                    throw b(strArr);
                }
            }
        }

        static /* synthetic */ boolean a(b bVar) {
            bVar.d = true;
            return true;
        }

        private static IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File a(int i) {
            File file = a.this.l;
            return new File(file, this.b + "." + i);
        }

        public final String a() {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.f6890c;
            int length = jArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                long j = jArr[i2];
                sb.append(' ');
                sb.append(j);
                i = i2 + 1;
            }
        }

        public final File b(int i) {
            File file = a.this.l;
            return new File(file, this.b + "." + i + ".tmp");
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/a$c.class */
    public final class c implements Closeable {
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final long f6893c;
        private final InputStream[] d;

        private c(String str, long j, InputStream[] inputStreamArr) {
            this.b = str;
            this.f6893c = j;
            this.d = inputStreamArr;
        }

        /* synthetic */ c(a aVar, String str, long j, InputStream[] inputStreamArr, byte b) {
            this(str, j, inputStreamArr);
        }

        private String a(int i) {
            return a.a(this.d[i]);
        }

        private C0106a b() {
            return a.this.a(this.b, this.f6893c);
        }

        public final InputStream a() {
            return this.d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] inputStreamArr = this.d;
            int length = inputStreamArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                a.a((Closeable) inputStreamArr[i2]);
                i = i2 + 1;
            }
        }
    }

    private a(File file, long j2) {
        this.l = file;
        this.m = new File(file, f6880a);
        this.n = new File(file, b);
        this.p = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0106a a(String str, long j2) {
        synchronized (this) {
            j();
            e(str);
            b bVar = this.t.get(str);
            if (j2 == -1 || (bVar != null && bVar.f == j2)) {
                if (bVar == null) {
                    bVar = new b(this, str, (byte) 0);
                    this.t.put(str, bVar);
                } else if (bVar.e != null) {
                    return null;
                }
                C0106a c0106a = new C0106a(this, bVar, (byte) 0);
                bVar.e = c0106a;
                Writer writer = this.s;
                writer.write("DIRTY " + str + '\n');
                this.s.flush();
                return c0106a;
            }
            return null;
        }
    }

    public static a a(File file, long j2) {
        if (j2 > 0) {
            a aVar = new a(file, j2);
            if (aVar.m.exists()) {
                try {
                    aVar.b();
                    aVar.c();
                    aVar.s = new BufferedWriter(new FileWriter(aVar.m, true), 8192);
                    return aVar;
                } catch (IOException e2) {
                    aVar.close();
                    a(aVar.l);
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, j2);
            aVar2.d();
            return aVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    static /* synthetic */ String a(InputStream inputStream) {
        return a((Reader) new InputStreamReader(inputStream, j));
    }

    private static String a(Reader reader) {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } finally {
            reader.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0106a c0106a, boolean z) {
        synchronized (this) {
            b bVar = c0106a.b;
            if (bVar.e != c0106a) {
                throw new IllegalStateException();
            }
            int i2 = 0;
            if (z) {
                i2 = 0;
                if (!bVar.d) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        i2 = 0;
                        if (i4 >= this.q) {
                            break;
                        } else if (!bVar.b(i4).exists()) {
                            c0106a.b();
                            throw new IllegalStateException("edit didn't create file ".concat(String.valueOf(i4)));
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                }
            }
            while (i2 < this.q) {
                File b2 = bVar.b(i2);
                if (!z) {
                    b(b2);
                } else if (b2.exists()) {
                    File a2 = bVar.a(i2);
                    b2.renameTo(a2);
                    long j2 = bVar.f6890c[i2];
                    long length = a2.length();
                    bVar.f6890c[i2] = length;
                    this.r = (this.r - j2) + length;
                }
                i2++;
            }
            this.u++;
            bVar.e = null;
            if (bVar.d || z) {
                b.a(bVar);
                this.s.write("CLEAN " + bVar.b + bVar.a() + '\n');
                if (z) {
                    long j3 = this.v;
                    this.v = 1 + j3;
                    bVar.f = j3;
                }
            } else {
                this.t.remove(bVar.b);
                this.s.write("REMOVE " + bVar.b + '\n');
            }
            this.s.flush();
            if (this.r > this.p || h()) {
                this.w.submit(this.x);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    private static void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IllegalArgumentException("not a directory: ".concat(String.valueOf(file)));
        }
        int length = listFiles.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            File file2 = listFiles[i3];
            if (file2.isDirectory()) {
                a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
            i2 = i3 + 1;
        }
    }

    private static <T> T[] a(T[] tArr, int i2) {
        int length = tArr.length;
        if (2 <= i2) {
            if (2 <= length) {
                int i3 = i2 - 2;
                int min = Math.min(i3, length - 2);
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
                System.arraycopy(tArr, 2, tArr2, 0, min);
                return tArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    private static String b(InputStream inputStream) {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            }
            if (read == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (sb.charAt(i2) == '\r') {
                        sb.setLength(i2);
                    }
                }
                return sb.toString();
            }
            sb.append((char) read);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b3, code lost:
        throw new java.io.IOException("unexpected journal line: ".concat(java.lang.String.valueOf(r0)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.res.a.b():void");
    }

    private static void b(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static String c(InputStream inputStream) {
        return a((Reader) new InputStreamReader(inputStream, j));
    }

    private void c() {
        b(this.n);
        Iterator<b> it = this.t.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.e == null) {
                for (int i2 = 0; i2 < this.q; i2++) {
                    this.r += next.f6890c[i2];
                }
            } else {
                next.e = null;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.q) {
                        break;
                    }
                    b(next.a(i4));
                    b(next.b(i4));
                    i3 = i4 + 1;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this) {
            if (this.s != null) {
                this.s.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.n), 8192);
            bufferedWriter.write(f6881c);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.o));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.q));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.t.values()) {
                if (bVar.e != null) {
                    bufferedWriter.write("DIRTY " + bVar.b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.b + bVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            this.n.renameTo(this.m);
            this.s = new BufferedWriter(new FileWriter(this.m, true), 8192);
        }
    }

    private void d(String str) {
        String[] split = str.split(" ");
        if (split.length < 2) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        String str2 = split[1];
        if (split[0].equals(h) && split.length == 2) {
            this.t.remove(str2);
            return;
        }
        b bVar = this.t.get(str2);
        b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new b(this, str2, (byte) 0);
            this.t.put(str2, bVar2);
        }
        if (!split[0].equals(f) || split.length != this.q + 2) {
            if (split[0].equals(g) && split.length == 2) {
                bVar2.e = new C0106a(this, bVar2, (byte) 0);
                return;
            } else if (!split[0].equals(i) || split.length != 2) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            } else {
                return;
            }
        }
        b.a(bVar2);
        bVar2.e = null;
        int length = split.length;
        int length2 = split.length;
        if (2 > length) {
            throw new IllegalArgumentException();
        }
        if (2 > length2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = length - 2;
        int min = Math.min(i2, length2 - 2);
        Object[] objArr = (Object[]) Array.newInstance(split.getClass().getComponentType(), i2);
        System.arraycopy(split, 2, objArr, 0, min);
        b.a(bVar2, (String[]) objArr);
    }

    static /* synthetic */ int e(a aVar) {
        aVar.u = 0;
        return 0;
    }

    private File e() {
        return this.l;
    }

    private static void e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    private long f() {
        return this.p;
    }

    private long g() {
        long j2;
        synchronized (this) {
            j2 = this.r;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int i2 = this.u;
        return i2 >= 2000 && i2 >= this.t.size();
    }

    private boolean i() {
        return this.s == null;
    }

    private void j() {
        if (this.s == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void k() {
        synchronized (this) {
            j();
            l();
            this.s.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        while (this.r > this.p) {
            c(this.t.entrySet().iterator().next().getKey());
        }
    }

    private void m() {
        close();
        a(this.l);
    }

    public final c a(String str) {
        synchronized (this) {
            j();
            e(str);
            b bVar = this.t.get(str);
            if (bVar == null) {
                return null;
            }
            if (bVar.d) {
                InputStream[] inputStreamArr = new InputStream[this.q];
                int i2 = 0;
                while (true) {
                    try {
                        int i3 = i2;
                        if (i3 >= this.q) {
                            break;
                        }
                        inputStreamArr[i3] = new FileInputStream(bVar.a(i3));
                        i2 = i3 + 1;
                    } catch (FileNotFoundException e2) {
                        return null;
                    }
                }
                this.u++;
                this.s.append((CharSequence) ("READ " + str + '\n'));
                if (h()) {
                    this.w.submit(this.x);
                }
                this.s.flush();
                return new c(this, str, bVar.f, inputStreamArr, (byte) 0);
            }
            return null;
        }
    }

    public final C0106a b(String str) {
        return a(str, -1L);
    }

    public final boolean c(String str) {
        synchronized (this) {
            j();
            e(str);
            b bVar = this.t.get(str);
            if (bVar != null && bVar.e == null) {
                for (int i2 = 0; i2 < this.q; i2++) {
                    File a2 = bVar.a(i2);
                    if (!a2.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(a2)));
                    }
                    this.r -= bVar.f6890c[i2];
                    bVar.f6890c[i2] = 0;
                }
                this.u++;
                this.s.append((CharSequence) ("REMOVE " + str + '\n'));
                this.t.remove(str);
                if (h()) {
                    this.w.submit(this.x);
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (this.s == null) {
                return;
            }
            Iterator it = new ArrayList(this.t.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.e != null) {
                    bVar.e.b();
                }
            }
            l();
            this.s.close();
            this.s = null;
        }
    }
}
