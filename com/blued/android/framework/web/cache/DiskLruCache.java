package com.blued.android.framework.web.cache;

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
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/cache/DiskLruCache.class */
public final class DiskLruCache implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream p = new OutputStream() { // from class: com.blued.android.framework.web.cache.DiskLruCache.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    private final int i;
    private Writer k;
    private int m;
    private long j = 0;
    private final LinkedHashMap<String, Entry> l = new LinkedHashMap<>(0, 0.75f, true);
    private long n = 0;
    final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> o = new Callable<Void>() { // from class: com.blued.android.framework.web.cache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.k == null) {
                    return null;
                }
                DiskLruCache.this.h();
                if (DiskLruCache.this.f()) {
                    DiskLruCache.this.e();
                    DiskLruCache.this.m = 0;
                }
                return null;
            }
        }
    };

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/cache/DiskLruCache$Editor.class */
    public final class Editor {
        private final Entry b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/cache/DiskLruCache$Editor$FaultHidingOutputStream.class */
        class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    Editor.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    Editor.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    Editor.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    Editor.this.d = true;
                }
            }
        }

        private Editor(Entry entry) {
            this.b = entry;
            this.c = entry.d ? null : new boolean[DiskLruCache.this.i];
        }

        public OutputStream a(int i) throws IOException {
            FileOutputStream fileOutputStream;
            FaultHidingOutputStream faultHidingOutputStream;
            if (i < 0 || i >= DiskLruCache.this.i) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + DiskLruCache.this.i);
            }
            synchronized (DiskLruCache.this) {
                if (this.b.e != this) {
                    throw new IllegalStateException();
                }
                if (!this.b.d) {
                    this.c[i] = true;
                }
                File b = this.b.b(i);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e) {
                    DiskLruCache.this.c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException e2) {
                        return DiskLruCache.p;
                    }
                }
                faultHidingOutputStream = new FaultHidingOutputStream(fileOutputStream);
            }
            return faultHidingOutputStream;
        }

        public void a() throws IOException {
            if (this.d) {
                DiskLruCache.this.a(this, false);
                DiskLruCache.this.c(this.b.b);
            } else {
                DiskLruCache.this.a(this, true);
            }
            this.e = true;
        }

        public void b() throws IOException {
            DiskLruCache.this.a(this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/cache/DiskLruCache$Entry.class */
    public final class Entry {
        private final String b;
        private final long[] c;
        private boolean d;
        private Editor e;
        private long f;

        private Entry(String str) {
            this.b = str;
            this.c = new long[DiskLruCache.this.i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.i) {
                throw b(strArr);
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        return;
                    }
                    this.c[i2] = Long.parseLong(strArr[i2]);
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
            File file = DiskLruCache.this.c;
            return new File(file, this.b + "." + i);
        }

        public String a() throws IOException {
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

        public File b(int i) {
            File file = DiskLruCache.this.c;
            return new File(file, this.b + "." + i + ".tmp");
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/cache/DiskLruCache$Snapshot.class */
    public final class Snapshot implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        private Snapshot(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }

        public InputStream a(int i) {
            return this.d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            InputStream[] inputStreamArr = this.d;
            int length = inputStreamArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Util.a(inputStreamArr[i2]);
                i = i2 + 1;
            }
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        this.c = file;
        this.g = i;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.i = i2;
        this.h = j;
    }

    private Editor a(String str, long j) throws IOException {
        synchronized (this) {
            g();
            e(str);
            Entry entry = this.l.get(str);
            if (j == -1 || (entry != null && entry.f == j)) {
                if (entry == null) {
                    entry = new Entry(str);
                    this.l.put(str, entry);
                } else if (entry.e != null) {
                    return null;
                }
                Editor editor = new Editor(entry);
                entry.e = editor;
                Writer writer = this.k;
                writer.write("DIRTY " + str + '\n');
                this.k.flush();
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
                if (diskLruCache.d.exists()) {
                    try {
                        diskLruCache.c();
                        diskLruCache.d();
                        return diskLruCache;
                    } catch (IOException e) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                        diskLruCache.delete();
                    }
                }
                file.mkdirs();
                DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
                diskLruCache2.e();
                return diskLruCache2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Editor editor, boolean z) throws IOException {
        synchronized (this) {
            Entry entry = editor.b;
            if (entry.e != editor) {
                throw new IllegalStateException();
            }
            int i = 0;
            if (z) {
                i = 0;
                if (!entry.d) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        i = 0;
                        if (i3 >= this.i) {
                            break;
                        } else if (!editor.c[i3]) {
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
            while (i < this.i) {
                File b = entry.b(i);
                if (!z) {
                    a(b);
                } else if (b.exists()) {
                    File a2 = entry.a(i);
                    b.renameTo(a2);
                    long j = entry.c[i];
                    long length = a2.length();
                    entry.c[i] = length;
                    this.j = (this.j - j) + length;
                }
                i++;
            }
            this.m++;
            entry.e = null;
            if (entry.d || z) {
                entry.d = true;
                this.k.write("CLEAN " + entry.b + entry.a() + '\n');
                if (z) {
                    long j2 = this.n;
                    this.n = 1 + j2;
                    entry.f = j2;
                }
            } else {
                this.l.remove(entry.b);
                this.k.write("REMOVE " + entry.b + '\n');
            }
            this.k.flush();
            if (this.j > this.h || f()) {
                this.b.submit(this.o);
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

    private void c() throws IOException {
        int i;
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.d), Util.a);
        try {
            String a2 = strictLineReader.a();
            String a3 = strictLineReader.a();
            String a4 = strictLineReader.a();
            String a5 = strictLineReader.a();
            String a6 = strictLineReader.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.g).equals(a4) || !Integer.toString(this.i).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    i = i2;
                    d(strictLineReader.a());
                    i2 = i + 1;
                } catch (EOFException e) {
                    this.m = i - this.l.size();
                    if (strictLineReader.b()) {
                        e();
                    } else {
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), Util.a));
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

    private void d() throws IOException {
        a(this.e);
        Iterator<Entry> it = this.l.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            if (next.e == null) {
                for (int i = 0; i < this.i; i++) {
                    this.j += next.c[i];
                }
            } else {
                next.e = null;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.i) {
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
                    this.l.remove(substring2);
                    return;
                }
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        Entry entry = this.l.get(substring);
        Entry entry2 = entry;
        if (entry == null) {
            entry2 = new Entry(substring);
            this.l.put(substring, entry2);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry2.d = true;
            entry2.e = null;
            entry2.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            entry2.e = new Editor(entry2);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws IOException {
        synchronized (this) {
            if (this.k != null) {
                this.k.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), Util.a));
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.l.values()) {
                if (entry.e != null) {
                    bufferedWriter.write("DIRTY " + entry.b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + entry.b + entry.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.d.exists()) {
                a(this.d, this.f, true);
            }
            a(this.e, this.d, false);
            this.f.delete();
            this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), Util.a));
        }
    }

    private void e(String str) {
        if (a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        int i = this.m;
        return i >= 2000 && i >= this.l.size();
    }

    private void g() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws IOException {
        while (this.j > this.h) {
            c(this.l.entrySet().iterator().next().getKey());
        }
    }

    public Snapshot a(String str) throws IOException {
        synchronized (this) {
            g();
            e(str);
            Entry entry = this.l.get(str);
            if (entry == null) {
                return null;
            }
            if (entry.d) {
                InputStream[] inputStreamArr = new InputStream[this.i];
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        if (i2 >= this.i) {
                            break;
                        }
                        inputStreamArr[i2] = new FileInputStream(entry.a(i2));
                        i = i2 + 1;
                    } catch (FileNotFoundException e) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= this.i || inputStreamArr[i4] == null) {
                                break;
                            }
                            Util.a(inputStreamArr[i4]);
                            i3 = i4 + 1;
                        }
                        return null;
                    }
                }
                this.m++;
                this.k.append((CharSequence) ("READ " + str + '\n'));
                if (f()) {
                    this.b.submit(this.o);
                }
                return new Snapshot(str, entry.f, inputStreamArr, entry.c);
            }
            return null;
        }
    }

    public void a() throws IOException {
        synchronized (this) {
            g();
            h();
            this.k.flush();
        }
    }

    public Editor b(String str) throws IOException {
        return a(str, -1L);
    }

    public boolean c(String str) throws IOException {
        synchronized (this) {
            g();
            e(str);
            Entry entry = this.l.get(str);
            if (entry != null && entry.e == null) {
                for (int i = 0; i < this.i; i++) {
                    File a2 = entry.a(i);
                    if (a2.exists() && !a2.delete()) {
                        throw new IOException("failed to delete " + a2);
                    }
                    this.j -= entry.c[i];
                    entry.c[i] = 0;
                }
                this.m++;
                this.k.append((CharSequence) ("REMOVE " + str + '\n'));
                this.l.remove(str);
                if (f()) {
                    this.b.submit(this.o);
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            if (this.k == null) {
                return;
            }
            Iterator it = new ArrayList(this.l.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.e != null) {
                    entry.e.b();
                }
            }
            h();
            this.k.close();
            this.k = null;
        }
    }

    public void delete() throws IOException {
        close();
        Util.a(this.c);
    }
}
