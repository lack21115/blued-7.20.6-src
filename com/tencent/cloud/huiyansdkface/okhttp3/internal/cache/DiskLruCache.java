package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.io.FileSystem;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache/DiskLruCache.class */
public final class DiskLruCache implements Closeable, Flushable {
    final FileSystem b;

    /* renamed from: c  reason: collision with root package name */
    final File f35914c;
    final int d;
    BufferedSink e;
    int g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private final File n;
    private final File o;
    private final File p;
    private final int q;
    private long r;
    private final Executor u;
    static final /* synthetic */ boolean m = !DiskLruCache.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f35913a = Pattern.compile("[a-z0-9_-]{1,120}");
    private long s = 0;
    final LinkedHashMap<String, Entry> f = new LinkedHashMap<>(0, 0.75f, true);
    private long t = 0;
    private final Runnable v = new Runnable() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if ((!DiskLruCache.this.i) || DiskLruCache.this.j) {
                    return;
                }
                try {
                    DiskLruCache.this.c();
                } catch (IOException e) {
                    DiskLruCache.this.k = true;
                }
                try {
                    if (DiskLruCache.this.b()) {
                        DiskLruCache.this.a();
                        DiskLruCache.this.g = 0;
                    }
                } catch (IOException e2) {
                    DiskLruCache.this.l = true;
                    DiskLruCache.this.e = Okio.buffer(Okio.blackhole());
                }
            }
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache/DiskLruCache$Editor.class */
    public final class Editor {

        /* renamed from: a  reason: collision with root package name */
        final Entry f35919a;
        final boolean[] b;
        private boolean d;

        Editor(Entry entry) {
            this.f35919a = entry;
            this.b = entry.e ? null : new boolean[DiskLruCache.this.d];
        }

        void a() {
            if (this.f35919a.f != this) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= DiskLruCache.this.d) {
                    this.f35919a.f = null;
                    return;
                } else {
                    try {
                        DiskLruCache.this.b.delete(this.f35919a.d[i2]);
                    } catch (IOException e) {
                    }
                    i = i2 + 1;
                }
            }
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f35919a.f == this) {
                    DiskLruCache.this.a(this, false);
                }
                this.d = true;
            }
        }

        public void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.d && this.f35919a.f == this) {
                    try {
                        DiskLruCache.this.a(this, false);
                    } catch (IOException e) {
                    }
                }
            }
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f35919a.f == this) {
                    DiskLruCache.this.a(this, true);
                }
                this.d = true;
            }
        }

        public Sink newSink(int i) {
            synchronized (DiskLruCache.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f35919a.f != this) {
                    return Okio.blackhole();
                }
                if (!this.f35919a.e) {
                    this.b[i] = true;
                }
                try {
                    return new FaultHidingSink(DiskLruCache.this.b.sink(this.f35919a.d[i])) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache.Editor.1
                        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.FaultHidingSink
                        protected void a(IOException iOException) {
                            synchronized (DiskLruCache.this) {
                                Editor.this.a();
                            }
                        }
                    };
                } catch (FileNotFoundException e) {
                    return Okio.blackhole();
                }
            }
        }

        public Source newSource(int i) {
            synchronized (DiskLruCache.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f35919a.e && this.f35919a.f == this) {
                    try {
                        return DiskLruCache.this.b.source(this.f35919a.f35923c[i]);
                    } catch (FileNotFoundException e) {
                        return null;
                    }
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache/DiskLruCache$Entry.class */
    public final class Entry {

        /* renamed from: a  reason: collision with root package name */
        final String f35922a;
        final long[] b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f35923c;
        final File[] d;
        boolean e;
        Editor f;
        long g;

        Entry(String str) {
            this.f35922a = str;
            this.b = new long[DiskLruCache.this.d];
            this.f35923c = new File[DiskLruCache.this.d];
            this.d = new File[DiskLruCache.this.d];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= DiskLruCache.this.d) {
                    return;
                }
                sb.append(i2);
                this.f35923c[i2] = new File(DiskLruCache.this.f35914c, sb.toString());
                sb.append(".tmp");
                this.d[i2] = new File(DiskLruCache.this.f35914c, sb.toString());
                sb.setLength(length);
                i = i2 + 1;
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        Snapshot a() {
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.this.d];
            long[] jArr = (long[]) this.b.clone();
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= DiskLruCache.this.d) {
                        return new Snapshot(this.f35922a, this.g, sourceArr, jArr);
                    }
                    sourceArr[i2] = DiskLruCache.this.b.source(this.f35923c[i2]);
                    i = i2 + 1;
                } catch (FileNotFoundException e) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= DiskLruCache.this.d || sourceArr[i4] == null) {
                            try {
                                DiskLruCache.this.a(this);
                                return null;
                            } catch (IOException e2) {
                                return null;
                            }
                        }
                        Util.closeQuietly(sourceArr[i4]);
                        i3 = i4 + 1;
                    }
                }
            }
        }

        void a(BufferedSink bufferedSink) throws IOException {
            long[] jArr = this.b;
            int length = jArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                bufferedSink.writeByte(32).writeDecimalLong(jArr[i2]);
                i = i2 + 1;
            }
        }

        void a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.d) {
                throw b(strArr);
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        return;
                    }
                    this.b[i2] = Long.parseLong(strArr[i2]);
                    i = i2 + 1;
                } catch (NumberFormatException e) {
                    throw b(strArr);
                }
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache/DiskLruCache$Snapshot.class */
    public final class Snapshot implements Closeable {
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final long f35925c;
        private final Source[] d;
        private final long[] e;

        Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.b = str;
            this.f35925c = j;
            this.d = sourceArr;
            this.e = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Source[] sourceArr = this.d;
            int length = sourceArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Util.closeQuietly(sourceArr[i2]);
                i = i2 + 1;
            }
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.a(this.b, this.f35925c);
        }

        public long getLength(int i) {
            return this.e[i];
        }

        public Source getSource(int i) {
            return this.d[i];
        }

        public String key() {
            return this.b;
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.b = fileSystem;
        this.f35914c = file;
        this.q = i;
        this.n = new File(file, "journal");
        this.o = new File(file, "journal.tmp");
        this.p = new File(file, "journal.bkp");
        this.d = i2;
        this.r = j;
        this.u = executor;
    }

    private void a(String str) throws IOException {
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
                    this.f.remove(substring2);
                    return;
                }
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        Entry entry = this.f.get(substring);
        Entry entry2 = entry;
        if (entry == null) {
            entry2 = new Entry(substring);
            this.f.put(substring, entry2);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry2.e = true;
            entry2.f = null;
            entry2.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            entry2.f = new Editor(entry2);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void b(String str) {
        if (f35913a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 > 0) {
                return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void d() throws IOException {
        int i;
        BufferedSource buffer = Okio.buffer(this.b.source(this.n));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.q).equals(readUtf8LineStrict3) || !Integer.toString(this.d).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    i = i2;
                    a(buffer.readUtf8LineStrict());
                    i2 = i + 1;
                } catch (EOFException e) {
                    this.g = i - this.f.size();
                    if (buffer.exhausted()) {
                        this.e = e();
                    } else {
                        a();
                    }
                    Util.closeQuietly(buffer);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(buffer);
            throw th;
        }
    }

    private BufferedSink e() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.b.appendingSink(this.n)) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache.2

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f35916a = !DiskLruCache.class.desiredAssertionStatus();

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.FaultHidingSink
            protected void a(IOException iOException) {
                if (!f35916a && !Thread.holdsLock(DiskLruCache.this)) {
                    throw new AssertionError();
                }
                DiskLruCache.this.h = true;
            }
        });
    }

    private void f() throws IOException {
        this.b.delete(this.o);
        Iterator<Entry> it = this.f.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            if (next.f == null) {
                for (int i = 0; i < this.d; i++) {
                    this.s += next.b[i];
                }
            } else {
                next.f = null;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.d) {
                        break;
                    }
                    this.b.delete(next.f35923c[i3]);
                    this.b.delete(next.d[i3]);
                    i2 = i3 + 1;
                }
                it.remove();
            }
        }
    }

    private void g() {
        synchronized (this) {
            if (isClosed()) {
                throw new IllegalStateException("cache is closed");
            }
        }
    }

    Editor a(String str, long j) throws IOException {
        synchronized (this) {
            initialize();
            g();
            b(str);
            Entry entry = this.f.get(str);
            if (j == -1 || (entry != null && entry.g == j)) {
                if (entry == null || entry.f == null) {
                    if (!this.k && !this.l) {
                        this.e.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
                        this.e.flush();
                        if (this.h) {
                            return null;
                        }
                        Entry entry2 = entry;
                        if (entry == null) {
                            entry2 = new Entry(str);
                            this.f.put(str, entry2);
                        }
                        Editor editor = new Editor(entry2);
                        entry2.f = editor;
                        return editor;
                    }
                    this.u.execute(this.v);
                    return null;
                }
                return null;
            }
            return null;
        }
    }

    void a() throws IOException {
        synchronized (this) {
            if (this.e != null) {
                this.e.close();
            }
            BufferedSink buffer = Okio.buffer(this.b.sink(this.o));
            buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeDecimalLong(this.q).writeByte(10);
            buffer.writeDecimalLong(this.d).writeByte(10);
            buffer.writeByte(10);
            for (Entry entry : this.f.values()) {
                if (entry.f != null) {
                    buffer.writeUtf8("DIRTY").writeByte(32);
                    buffer.writeUtf8(entry.f35922a);
                } else {
                    buffer.writeUtf8("CLEAN").writeByte(32);
                    buffer.writeUtf8(entry.f35922a);
                    entry.a(buffer);
                }
                buffer.writeByte(10);
            }
            buffer.close();
            if (this.b.exists(this.n)) {
                this.b.rename(this.n, this.p);
            }
            this.b.rename(this.o, this.n);
            this.b.delete(this.p);
            this.e = e();
            this.h = false;
            this.l = false;
        }
    }

    void a(Editor editor, boolean z) throws IOException {
        synchronized (this) {
            Entry entry = editor.f35919a;
            if (entry.f != editor) {
                throw new IllegalStateException();
            }
            int i = 0;
            if (z) {
                i = 0;
                if (!entry.e) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        i = 0;
                        if (i3 >= this.d) {
                            break;
                        } else if (!editor.b[i3]) {
                            editor.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                        } else if (!this.b.exists(entry.d[i3])) {
                            editor.abort();
                            return;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                }
            }
            while (i < this.d) {
                File file = entry.d[i];
                if (!z) {
                    this.b.delete(file);
                } else if (this.b.exists(file)) {
                    File file2 = entry.f35923c[i];
                    this.b.rename(file, file2);
                    long j = entry.b[i];
                    long size = this.b.size(file2);
                    entry.b[i] = size;
                    this.s = (this.s - j) + size;
                }
                i++;
            }
            this.g++;
            entry.f = null;
            if (entry.e || z) {
                entry.e = true;
                this.e.writeUtf8("CLEAN").writeByte(32);
                this.e.writeUtf8(entry.f35922a);
                entry.a(this.e);
                this.e.writeByte(10);
                if (z) {
                    long j2 = this.t;
                    this.t = 1 + j2;
                    entry.g = j2;
                }
            } else {
                this.f.remove(entry.f35922a);
                this.e.writeUtf8("REMOVE").writeByte(32);
                this.e.writeUtf8(entry.f35922a);
                this.e.writeByte(10);
            }
            this.e.flush();
            if (this.s > this.r || b()) {
                this.u.execute(this.v);
            }
        }
    }

    boolean a(Entry entry) throws IOException {
        if (entry.f != null) {
            entry.f.a();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d) {
                break;
            }
            this.b.delete(entry.f35923c[i2]);
            this.s -= entry.b[i2];
            entry.b[i2] = 0;
            i = i2 + 1;
        }
        this.g++;
        this.e.writeUtf8("REMOVE").writeByte(32).writeUtf8(entry.f35922a).writeByte(10);
        this.f.remove(entry.f35922a);
        if (b()) {
            this.u.execute(this.v);
            return true;
        }
        return true;
    }

    boolean b() {
        int i = this.g;
        return i >= 2000 && i >= this.f.size();
    }

    void c() throws IOException {
        while (this.s > this.r) {
            a(this.f.values().iterator().next());
        }
        this.k = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            if (this.i && !this.j) {
                Entry[] entryArr = (Entry[]) this.f.values().toArray(new Entry[this.f.size()]);
                int length = entryArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        c();
                        this.e.close();
                        this.e = null;
                        this.j = true;
                        return;
                    }
                    Entry entry = entryArr[i2];
                    if (entry.f != null) {
                        entry.f.abort();
                    }
                    i = i2 + 1;
                }
            }
            this.j = true;
        }
    }

    public void delete() throws IOException {
        close();
        this.b.deleteContents(this.f35914c);
    }

    public Editor edit(String str) throws IOException {
        return a(str, -1L);
    }

    public void evictAll() throws IOException {
        synchronized (this) {
            initialize();
            Entry[] entryArr = (Entry[]) this.f.values().toArray(new Entry[this.f.size()]);
            int length = entryArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    a(entryArr[i2]);
                    i = i2 + 1;
                } else {
                    this.k = false;
                }
            }
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        synchronized (this) {
            if (this.i) {
                g();
                c();
                this.e.flush();
            }
        }
    }

    public Snapshot get(String str) throws IOException {
        synchronized (this) {
            initialize();
            g();
            b(str);
            Entry entry = this.f.get(str);
            if (entry != null && entry.e) {
                Snapshot a2 = entry.a();
                if (a2 == null) {
                    return null;
                }
                this.g++;
                this.e.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
                if (b()) {
                    this.u.execute(this.v);
                }
                return a2;
            }
            return null;
        }
    }

    public File getDirectory() {
        return this.f35914c;
    }

    public long getMaxSize() {
        long j;
        synchronized (this) {
            j = this.r;
        }
        return j;
    }

    public void initialize() throws IOException {
        synchronized (this) {
            if (!m && !Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            if (this.i) {
                return;
            }
            if (this.b.exists(this.p)) {
                if (this.b.exists(this.n)) {
                    this.b.delete(this.p);
                } else {
                    this.b.rename(this.p, this.n);
                }
            }
            if (this.b.exists(this.n)) {
                try {
                    d();
                    f();
                    this.i = true;
                    return;
                } catch (IOException e) {
                    Platform platform = Platform.get();
                    platform.log(5, "DiskLruCache " + this.f35914c + " is corrupt: " + e.getMessage() + ", removing", e);
                    delete();
                    this.j = false;
                }
            }
            a();
            this.i = true;
        }
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.j;
        }
        return z;
    }

    public boolean remove(String str) throws IOException {
        synchronized (this) {
            initialize();
            g();
            b(str);
            Entry entry = this.f.get(str);
            if (entry == null) {
                return false;
            }
            boolean a2 = a(entry);
            if (a2 && this.s <= this.r) {
                this.k = false;
            }
            return a2;
        }
    }

    public void setMaxSize(long j) {
        synchronized (this) {
            this.r = j;
            if (this.i) {
                this.u.execute(this.v);
            }
        }
    }

    public long size() throws IOException {
        long j;
        synchronized (this) {
            initialize();
            j = this.s;
        }
        return j;
    }

    public Iterator<Snapshot> snapshots() throws IOException {
        Iterator<Snapshot> it;
        synchronized (this) {
            initialize();
            it = new Iterator<Snapshot>() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache.3

                /* renamed from: a  reason: collision with root package name */
                final Iterator<Entry> f35917a;
                Snapshot b;

                /* renamed from: c  reason: collision with root package name */
                Snapshot f35918c;

                {
                    this.f35917a = new ArrayList(DiskLruCache.this.f.values()).iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.b != null) {
                        return true;
                    }
                    synchronized (DiskLruCache.this) {
                        if (DiskLruCache.this.j) {
                            return false;
                        }
                        while (this.f35917a.hasNext()) {
                            Snapshot a2 = this.f35917a.next().a();
                            if (a2 != null) {
                                this.b = a2;
                                return true;
                            }
                        }
                        return false;
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Snapshot next() {
                    if (hasNext()) {
                        Snapshot snapshot = this.b;
                        this.f35918c = snapshot;
                        this.b = null;
                        return snapshot;
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    Snapshot snapshot = this.f35918c;
                    if (snapshot == null) {
                        throw new IllegalStateException("remove() before next()");
                    }
                    try {
                        DiskLruCache.this.remove(snapshot.b);
                    } catch (IOException e) {
                    } catch (Throwable th) {
                        this.f35918c = null;
                        throw th;
                    }
                    this.f35918c = null;
                }
            };
        }
        return it;
    }
}
