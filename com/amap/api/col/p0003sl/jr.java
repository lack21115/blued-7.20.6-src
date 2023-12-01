package com.amap.api.col.p0003sl;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* renamed from: com.amap.api.col.3sl.jr  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jr.class */
public final class jr implements Closeable {
    private final File e;
    private final File f;
    private final File g;
    private final File h;
    private long j;
    private Writer m;
    private int p;
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final Charset b = Charset.forName("US-ASCII");
    static final Charset c = Charset.forName("UTF-8");
    private static final ThreadFactory r = new ThreadFactory() { // from class: com.amap.api.col.3sl.jr.1
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
        }
    };
    static ThreadPoolExecutor d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r);
    private static final OutputStream t = new OutputStream() { // from class: com.amap.api.col.3sl.jr.3
        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    };
    private long l = 0;
    private int n = 1000;
    private final LinkedHashMap<String, c> o = new LinkedHashMap<>(0, 0.75f, true);
    private long q = 0;
    private final Callable<Void> s = new Callable<Void>() { // from class: com.amap.api.col.3sl.jr.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (jr.this) {
                if (jr.this.m == null) {
                    return null;
                }
                jr.this.l();
                if (jr.this.j()) {
                    jr.this.i();
                    jr.e(jr.this);
                }
                return null;
            }
        }
    };
    private final int i = 1;
    private final int k = 1;

    /* renamed from: com.amap.api.col.3sl.jr$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jr$a.class */
    public final class a {
        private final c b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        /* renamed from: com.amap.api.col.3sl.jr$a$a  reason: collision with other inner class name */
        /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jr$a$a.class */
        final class C0018a extends FilterOutputStream {
            private C0018a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C0018a(a aVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    a.c(a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    a.c(a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    a.c(a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    a.c(a.this);
                }
            }
        }

        private a(c cVar) {
            this.b = cVar;
            this.c = cVar.d ? null : new boolean[jr.this.k];
        }

        /* synthetic */ a(jr jrVar, c cVar, byte b) {
            this(cVar);
        }

        static /* synthetic */ boolean c(a aVar) {
            aVar.d = true;
            return true;
        }

        public final OutputStream a() throws IOException {
            FileOutputStream fileOutputStream;
            C0018a c0018a;
            if (jr.this.k <= 0) {
                throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + jr.this.k);
            }
            synchronized (jr.this) {
                if (this.b.e != this) {
                    throw new IllegalStateException();
                }
                if (!this.b.d) {
                    this.c[0] = true;
                }
                File b = this.b.b(0);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e) {
                    jr.this.e.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException e2) {
                        return jr.t;
                    }
                }
                c0018a = new C0018a(this, fileOutputStream, (byte) 0);
            }
            return c0018a;
        }

        public final void b() throws IOException {
            if (this.d) {
                jr.this.a(this, false);
                jr.this.c(this.b.b);
            } else {
                jr.this.a(this, true);
            }
            this.e = true;
        }

        public final void c() throws IOException {
            jr.this.a(this, false);
        }
    }

    /* renamed from: com.amap.api.col.3sl.jr$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jr$b.class */
    public final class b implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        private b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }

        /* synthetic */ b(jr jrVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
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
                jr.a(inputStreamArr[i2]);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.jr$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jr$c.class */
    public final class c {
        private final String b;
        private final long[] c;
        private boolean d;
        private a e;
        private long f;

        private c(String str) {
            this.b = str;
            this.c = new long[jr.this.k];
        }

        /* synthetic */ c(jr jrVar, String str, byte b) {
            this(str);
        }

        private static IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length != jr.this.k) {
                throw a(strArr);
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        return;
                    }
                    cVar.c[i2] = Long.parseLong(strArr[i2]);
                    i = i2 + 1;
                } catch (NumberFormatException e) {
                    throw a(strArr);
                }
            }
        }

        static /* synthetic */ boolean a(c cVar) {
            cVar.d = true;
            return true;
        }

        public final File a(int i) {
            File file = jr.this.e;
            return new File(file, this.b + "." + i);
        }

        public final String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.c;
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
            File file = jr.this.e;
            return new File(file, this.b + "." + i + ".tmp");
        }
    }

    private jr(File file, long j) {
        this.e = file;
        this.f = new File(file, "journal");
        this.g = new File(file, "journal.tmp");
        this.h = new File(file, "journal.bkp");
        this.j = j;
    }

    public static jr a(File file, long j) throws IOException {
        if (j > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            jr jrVar = new jr(file, j);
            if (jrVar.f.exists()) {
                try {
                    jrVar.g();
                    jrVar.h();
                    jrVar.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jrVar.f, true), b));
                    return jrVar;
                } catch (Throwable th) {
                    jrVar.d();
                }
            }
            file.mkdirs();
            jr jrVar2 = new jr(file, j);
            jrVar2.i();
            return jrVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void a() {
        ThreadPoolExecutor threadPoolExecutor = d;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        d.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) throws IOException {
        synchronized (this) {
            c cVar = aVar.b;
            if (cVar.e != aVar) {
                throw new IllegalStateException();
            }
            int i = 0;
            if (z) {
                i = 0;
                if (!cVar.d) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        i = 0;
                        if (i3 >= this.k) {
                            break;
                        } else if (!aVar.c[i3]) {
                            aVar.c();
                            throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i3)));
                        } else if (!cVar.b(i3).exists()) {
                            aVar.c();
                            return;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                }
            }
            while (i < this.k) {
                File b2 = cVar.b(i);
                if (!z) {
                    a(b2);
                } else if (b2.exists()) {
                    File a2 = cVar.a(i);
                    b2.renameTo(a2);
                    long j = cVar.c[i];
                    long length = a2.length();
                    cVar.c[i] = length;
                    this.l = (this.l - j) + length;
                }
                i++;
            }
            this.p++;
            cVar.e = null;
            if (cVar.d || z) {
                c.a(cVar);
                this.m.write("CLEAN " + cVar.b + cVar.a() + '\n');
                if (z) {
                    long j2 = this.q;
                    this.q = 1 + j2;
                    cVar.f = j2;
                }
            } else {
                this.o.remove(cVar.b);
                this.m.write("REMOVE " + cVar.b + '\n');
            }
            this.m.flush();
            if (this.l > this.j || j()) {
                f().submit(this.s);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                b(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
            i = i2 + 1;
        }
    }

    private a d(String str) throws IOException {
        synchronized (this) {
            k();
            e(str);
            c cVar = this.o.get(str);
            if (cVar == null) {
                cVar = new c(this, str, (byte) 0);
                this.o.put(str, cVar);
            } else if (cVar.e != null) {
                return null;
            }
            a aVar = new a(this, cVar, (byte) 0);
            cVar.e = aVar;
            Writer writer = this.m;
            writer.write("DIRTY " + str + '\n');
            this.m.flush();
            return aVar;
        }
    }

    static /* synthetic */ int e(jr jrVar) {
        jrVar.p = 0;
        return 0;
    }

    private static void e(String str) {
        if (a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private static ThreadPoolExecutor f() {
        try {
            if (d == null || d.isShutdown()) {
                d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return d;
    }

    private void g() throws IOException {
        int i;
        String a2;
        String substring;
        js jsVar = new js(new FileInputStream(this.f), b);
        try {
            String a3 = jsVar.a();
            String a4 = jsVar.a();
            String a5 = jsVar.a();
            String a6 = jsVar.a();
            String a7 = jsVar.a();
            if (!"libcore.io.DiskLruCache".equals(a3) || !"1".equals(a4) || !Integer.toString(this.i).equals(a5) || !Integer.toString(this.k).equals(a6) || !"".equals(a7)) {
                throw new IOException("unexpected journal header: [" + a3 + ", " + a4 + ", " + a6 + ", " + a7 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    i = i2;
                    a2 = jsVar.a();
                    int indexOf = a2.indexOf(32);
                    if (indexOf == -1) {
                        throw new IOException("unexpected journal line: ".concat(String.valueOf(a2)));
                    }
                    int i3 = indexOf + 1;
                    int indexOf2 = a2.indexOf(32, i3);
                    if (indexOf2 == -1) {
                        String substring2 = a2.substring(i3);
                        substring = substring2;
                        if (indexOf == 6) {
                            substring = substring2;
                            if (a2.startsWith("REMOVE")) {
                                this.o.remove(substring2);
                                i2 = i + 1;
                            }
                        }
                    } else {
                        substring = a2.substring(i3, indexOf2);
                    }
                    c cVar = this.o.get(substring);
                    c cVar2 = cVar;
                    if (cVar == null) {
                        cVar2 = new c(this, substring, (byte) 0);
                        this.o.put(substring, cVar2);
                    }
                    if (indexOf2 != -1 && indexOf == 5 && a2.startsWith("CLEAN")) {
                        String[] split = a2.substring(indexOf2 + 1).split(" ");
                        c.a(cVar2);
                        cVar2.e = null;
                        c.a(cVar2, split);
                    } else if (indexOf2 == -1 && indexOf == 5 && a2.startsWith("DIRTY")) {
                        cVar2.e = new a(this, cVar2, (byte) 0);
                    } else if (indexOf2 != -1 || indexOf != 4 || !a2.startsWith("READ")) {
                        break;
                    }
                    i2 = i + 1;
                } catch (EOFException e) {
                    this.p = i - this.o.size();
                    a(jsVar);
                    return;
                }
            }
            throw new IOException("unexpected journal line: ".concat(String.valueOf(a2)));
        } catch (Throwable th) {
            a(jsVar);
            throw th;
        }
    }

    private void h() throws IOException {
        a(this.g);
        Iterator<c> it = this.o.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.e == null) {
                for (int i = 0; i < this.k; i++) {
                    this.l += next.c[i];
                }
            } else {
                next.e = null;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.k) {
                        break;
                    }
                    a(next.a(i3));
                    a(next.b(i3));
                    i2 = i3 + 1;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() throws IOException {
        synchronized (this) {
            if (this.m != null) {
                this.m.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g), b));
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.k));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.o.values()) {
                if (cVar.e != null) {
                    bufferedWriter.write("DIRTY " + cVar.b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.b + cVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f.exists()) {
                a(this.f, this.h, true);
            }
            a(this.g, this.f, false);
            this.h.delete();
            this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f, true), b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        int i = this.p;
        return i >= 2000 && i >= this.o.size();
    }

    private void k() {
        if (this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws IOException {
        while (true) {
            if (this.l <= this.j && this.o.size() <= this.n) {
                return;
            }
            c(this.o.entrySet().iterator().next().getKey());
        }
    }

    public final b a(String str) throws IOException {
        synchronized (this) {
            k();
            e(str);
            c cVar = this.o.get(str);
            if (cVar == null) {
                return null;
            }
            if (cVar.d) {
                InputStream[] inputStreamArr = new InputStream[this.k];
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        if (i2 >= this.k) {
                            break;
                        }
                        inputStreamArr[i2] = new FileInputStream(cVar.a(i2));
                        i = i2 + 1;
                    } catch (FileNotFoundException e) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= this.k || inputStreamArr[i4] == null) {
                                break;
                            }
                            a(inputStreamArr[i4]);
                            i3 = i4 + 1;
                        }
                        return null;
                    }
                }
                this.p++;
                this.m.append((CharSequence) ("READ " + str + '\n'));
                if (j()) {
                    f().submit(this.s);
                }
                return new b(this, str, cVar.f, inputStreamArr, cVar.c, (byte) 0);
            }
            return null;
        }
    }

    public final void a(int i) {
        int i2;
        if (i < 10) {
            i2 = 10;
        } else {
            i2 = i;
            if (i > 10000) {
                i2 = 10000;
            }
        }
        this.n = i2;
    }

    public final a b(String str) throws IOException {
        return d(str);
    }

    public final File b() {
        return this.e;
    }

    public final void c() throws IOException {
        synchronized (this) {
            k();
            l();
            this.m.flush();
        }
    }

    public final boolean c(String str) throws IOException {
        synchronized (this) {
            k();
            e(str);
            c cVar = this.o.get(str);
            if (cVar != null && cVar.e == null) {
                for (int i = 0; i < this.k; i++) {
                    File a2 = cVar.a(i);
                    if (a2.exists() && !a2.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(a2)));
                    }
                    this.l -= cVar.c[i];
                    cVar.c[i] = 0;
                }
                this.p++;
                this.m.append((CharSequence) ("REMOVE " + str + '\n'));
                this.o.remove(str);
                if (j()) {
                    f().submit(this.s);
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            if (this.m == null) {
                return;
            }
            Iterator it = new ArrayList(this.o.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.e != null) {
                    cVar.e.c();
                }
            }
            l();
            this.m.close();
            this.m = null;
        }
    }

    public final void d() throws IOException {
        close();
        b(this.e);
    }
}
