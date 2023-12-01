package com.bumptech.glide.disklrucache;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/disklrucache/DiskLruCache.class */
public final class DiskLruCache implements Closeable {
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private final File f7067c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    private final int h;
    private Writer j;
    private int l;
    private long i = 0;
    private final LinkedHashMap<String, Entry> k = new LinkedHashMap<>(0, 0.75f, true);
    private long m = 0;

    /* renamed from: a  reason: collision with root package name */
    final ThreadPoolExecutor f7066a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());
    private final Callable<Void> n = new Callable<Void>() { // from class: com.bumptech.glide.disklrucache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.j == null) {
                    return null;
                }
                DiskLruCache.this.f();
                if (DiskLruCache.this.d()) {
                    DiskLruCache.this.c();
                    DiskLruCache.this.l = 0;
                }
                return null;
            }
        }
    };

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/disklrucache/DiskLruCache$DiskLruCacheThreadFactory.class */
    static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread;
            synchronized (this) {
                thread = new Thread(runnable, "glide-disk-lru-cache-thread");
                thread.setPriority(1);
            }
            return thread;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/disklrucache/DiskLruCache$Editor.class */
    public final class Editor {
        private final Entry b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean[] f7070c;
        private boolean d;

        private Editor(Entry entry) {
            this.b = entry;
            this.f7070c = entry.f ? null : new boolean[DiskLruCache.this.h];
        }

        public File a(int i) throws IOException {
            File b;
            synchronized (DiskLruCache.this) {
                if (this.b.g != this) {
                    throw new IllegalStateException();
                }
                if (!this.b.f) {
                    this.f7070c[i] = true;
                }
                b = this.b.b(i);
                if (!DiskLruCache.this.b.exists()) {
                    DiskLruCache.this.b.mkdirs();
                }
            }
            return b;
        }

        public void a() throws IOException {
            DiskLruCache.this.a(this, true);
            this.d = true;
        }

        public void b() throws IOException {
            DiskLruCache.this.a(this, false);
        }

        public void c() {
            if (this.d) {
                return;
            }
            try {
                b();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/disklrucache/DiskLruCache$Entry.class */
    public final class Entry {

        /* renamed from: a  reason: collision with root package name */
        File[] f7071a;
        File[] b;
        private final String d;
        private final long[] e;
        private boolean f;
        private Editor g;
        private long h;

        private Entry(String str) {
            this.d = str;
            this.e = new long[DiskLruCache.this.h];
            this.f7071a = new File[DiskLruCache.this.h];
            this.b = new File[DiskLruCache.this.h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= DiskLruCache.this.h) {
                    return;
                }
                sb.append(i2);
                this.f7071a[i2] = new File(DiskLruCache.this.b, sb.toString());
                sb.append(".tmp");
                this.b[i2] = new File(DiskLruCache.this.b, sb.toString());
                sb.setLength(length);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.h) {
                throw b(strArr);
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        return;
                    }
                    this.e[i2] = Long.parseLong(strArr[i2]);
                    i = i2 + 1;
                } catch (NumberFormatException e) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.f7071a[i];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.e;
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

        public File b(int i) {
            return this.b[i];
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/disklrucache/DiskLruCache$Value.class */
    public final class Value {
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final long f7074c;
        private final long[] d;
        private final File[] e;

        private Value(String str, long j, File[] fileArr, long[] jArr) {
            this.b = str;
            this.f7074c = j;
            this.e = fileArr;
            this.d = jArr;
        }

        public File a(int i) {
            return this.e[i];
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        this.b = file;
        this.f = i;
        this.f7067c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = i2;
        this.g = j;
    }

    private Editor a(String str, long j) throws IOException {
        synchronized (this) {
            e();
            Entry entry = this.k.get(str);
            if (j == -1 || (entry != null && entry.h == j)) {
                if (entry == null) {
                    entry = new Entry(str);
                    this.k.put(str, entry);
                } else if (entry.g != null) {
                    return null;
                }
                Editor editor = new Editor(entry);
                entry.g = editor;
                this.j.append((CharSequence) "DIRTY");
                this.j.append(' ');
                this.j.append((CharSequence) str);
                this.j.append('\n');
                b(this.j);
                return editor;
            }
            return null;
        }
    }

    public static DiskLruCache a(File file, int i, int i2, long j) throws IOException {
        if (j > 0) {
            if (i2 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        a(file2, file3, false);
                    }
                }
                DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
                if (diskLruCache.f7067c.exists()) {
                    try {
                        diskLruCache.a();
                        diskLruCache.b();
                        return diskLruCache;
                    } catch (IOException e) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                        diskLruCache.delete();
                    }
                }
                file.mkdirs();
                DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
                diskLruCache2.c();
                return diskLruCache2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void a() throws IOException {
        int i;
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.f7067c), Util.f7078a);
        try {
            String a2 = strictLineReader.a();
            String a3 = strictLineReader.a();
            String a4 = strictLineReader.a();
            String a5 = strictLineReader.a();
            String a6 = strictLineReader.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f).equals(a4) || !Integer.toString(this.h).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    i = i2;
                    d(strictLineReader.a());
                    i2 = i + 1;
                } catch (EOFException e) {
                    this.l = i - this.k.size();
                    if (strictLineReader.b()) {
                        c();
                    } else {
                        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7067c, true), Util.f7078a));
                    }
                    Util.a(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.a(strictLineReader);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Editor editor, boolean z) throws IOException {
        synchronized (this) {
            Entry entry = editor.b;
            if (entry.g != editor) {
                throw new IllegalStateException();
            }
            int i = 0;
            if (z) {
                i = 0;
                if (!entry.f) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        i = 0;
                        if (i3 >= this.h) {
                            break;
                        } else if (!editor.f7070c[i3]) {
                            editor.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                        } else if (!entry.b(i3).exists()) {
                            editor.b();
                            return;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                }
            }
            while (i < this.h) {
                File b = entry.b(i);
                if (!z) {
                    a(b);
                } else if (b.exists()) {
                    File a2 = entry.a(i);
                    b.renameTo(a2);
                    long j = entry.e[i];
                    long length = a2.length();
                    entry.e[i] = length;
                    this.i = (this.i - j) + length;
                }
                i++;
            }
            this.l++;
            entry.g = null;
            if (entry.f || z) {
                entry.f = true;
                this.j.append((CharSequence) "CLEAN");
                this.j.append(' ');
                this.j.append((CharSequence) entry.d);
                this.j.append((CharSequence) entry.a());
                this.j.append('\n');
                if (z) {
                    long j2 = this.m;
                    this.m = 1 + j2;
                    entry.h = j2;
                }
            } else {
                this.k.remove(entry.d);
                this.j.append((CharSequence) "REMOVE");
                this.j.append(' ');
                this.j.append((CharSequence) entry.d);
                this.j.append('\n');
            }
            b(this.j);
            if (this.i > this.g || d()) {
                this.f7066a.submit(this.n);
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

    private static void a(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private void b() throws IOException {
        a(this.d);
        Iterator<Entry> it = this.k.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            if (next.g == null) {
                for (int i = 0; i < this.h; i++) {
                    this.i += next.e[i];
                }
            } else {
                next.g = null;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.h) {
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

    private static void b(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() throws IOException {
        synchronized (this) {
            if (this.j != null) {
                a(this.j);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), Util.f7078a));
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.k.values()) {
                if (entry.g != null) {
                    bufferedWriter.write("DIRTY " + entry.d + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + entry.d + entry.a() + '\n');
                }
            }
            a(bufferedWriter);
            if (this.f7067c.exists()) {
                a(this.f7067c, this.e, true);
            }
            a(this.d, this.f7067c, false);
            this.e.delete();
            this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7067c, true), Util.f7078a));
        }
    }

    private void d(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring2 = str.substring(i);
            substring = substring2;
            if (indexOf == 6) {
                substring = substring2;
                if (str.startsWith("REMOVE")) {
                    this.k.remove(substring2);
                    return;
                }
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        Entry entry = this.k.get(substring);
        Entry entry2 = entry;
        if (entry == null) {
            entry2 = new Entry(substring);
            this.k.put(substring, entry2);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry2.f = true;
            entry2.g = null;
            entry2.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            entry2.g = new Editor(entry2);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int i = this.l;
        return i >= 2000 && i >= this.k.size();
    }

    private void e() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws IOException {
        while (this.i > this.g) {
            c(this.k.entrySet().iterator().next().getKey());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
        r10.l++;
        r10.j.append((java.lang.CharSequence) "READ");
        r10.j.append(' ');
        r10.j.append((java.lang.CharSequence) r11);
        r10.j.append('\n');
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
        if (d() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
        r10.f7066a.submit(r10.n);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
        r0 = new com.bumptech.glide.disklrucache.DiskLruCache.Value(r10, r11, r0.h, r0.f7071a, r0.e, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bumptech.glide.disklrucache.DiskLruCache.Value a(java.lang.String r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.a(java.lang.String):com.bumptech.glide.disklrucache.DiskLruCache$Value");
    }

    public Editor b(String str) throws IOException {
        return a(str, -1L);
    }

    public boolean c(String str) throws IOException {
        synchronized (this) {
            e();
            Entry entry = this.k.get(str);
            if (entry != null && entry.g == null) {
                for (int i = 0; i < this.h; i++) {
                    File a2 = entry.a(i);
                    if (a2.exists() && !a2.delete()) {
                        throw new IOException("failed to delete " + a2);
                    }
                    this.i -= entry.e[i];
                    entry.e[i] = 0;
                }
                this.l++;
                this.j.append((CharSequence) "REMOVE");
                this.j.append(' ');
                this.j.append((CharSequence) str);
                this.j.append('\n');
                this.k.remove(str);
                if (d()) {
                    this.f7066a.submit(this.n);
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            if (this.j == null) {
                return;
            }
            Iterator it = new ArrayList(this.k.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.g != null) {
                    entry.g.b();
                }
            }
            f();
            a(this.j);
            this.j = null;
        }
    }

    public void delete() throws IOException {
        close();
        Util.a(this.b);
    }
}
