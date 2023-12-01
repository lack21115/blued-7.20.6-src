package okhttp3.internal.cache;

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
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache/DiskLruCache.class */
public final class DiskLruCache implements Closeable, Flushable {
    final FileSystem b;
    final File c;
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
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    private long s = 0;
    final LinkedHashMap<String, Entry> f = new LinkedHashMap<>(0, 0.75f, true);
    private long t = 0;
    private final Runnable v = new Runnable() { // from class: okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if ((!DiskLruCache.this.i) || DiskLruCache.this.j) {
                    return;
                }
                try {
                    DiskLruCache.this.h();
                } catch (IOException e) {
                    DiskLruCache.this.k = true;
                }
                try {
                    if (DiskLruCache.this.f()) {
                        DiskLruCache.this.b();
                        DiskLruCache.this.g = 0;
                    }
                } catch (IOException e2) {
                    DiskLruCache.this.l = true;
                    DiskLruCache.this.e = Okio.buffer(Okio.blackhole());
                }
            }
        }
    };

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache/DiskLruCache$Editor.class */
    public final class Editor {
        final Entry a;
        final boolean[] b;
        private boolean d;

        Editor(Entry entry) {
            this.a = entry;
            this.b = entry.e ? null : new boolean[DiskLruCache.this.d];
        }

        public Sink a(int i) {
            synchronized (DiskLruCache.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.a.f != this) {
                    return Okio.blackhole();
                }
                if (!this.a.e) {
                    this.b[i] = true;
                }
                try {
                    return new FaultHidingSink(DiskLruCache.this.b.b(this.a.d[i])) { // from class: okhttp3.internal.cache.DiskLruCache.Editor.1
                        @Override // okhttp3.internal.cache.FaultHidingSink
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

        void a() {
            if (this.a.f != this) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= DiskLruCache.this.d) {
                    this.a.f = null;
                    return;
                } else {
                    try {
                        DiskLruCache.this.b.delete(this.a.d[i2]);
                    } catch (IOException e) {
                    }
                    i = i2 + 1;
                }
            }
        }

        public void b() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.a.f == this) {
                    DiskLruCache.this.a(this, true);
                }
                this.d = true;
            }
        }

        public void c() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.a.f == this) {
                    DiskLruCache.this.a(this, false);
                }
                this.d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache/DiskLruCache$Entry.class */
    public final class Entry {
        final String a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        Editor f;
        long g;

        Entry(String str) {
            this.a = str;
            this.b = new long[DiskLruCache.this.d];
            this.c = new File[DiskLruCache.this.d];
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
                this.c[i2] = new File(DiskLruCache.this.c, sb.toString());
                sb.append(".tmp");
                this.d[i2] = new File(DiskLruCache.this.c, sb.toString());
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
                        return new Snapshot(this.a, this.g, sourceArr, jArr);
                    }
                    sourceArr[i2] = DiskLruCache.this.b.a(this.c[i2]);
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
                        Util.a(sourceArr[i4]);
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

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache/DiskLruCache$Snapshot.class */
    public final class Snapshot implements Closeable {
        private final String b;
        private final long c;
        private final Source[] d;
        private final long[] e;

        Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = sourceArr;
            this.e = jArr;
        }

        @Nullable
        public Editor a() throws IOException {
            return DiskLruCache.this.a(this.b, this.c);
        }

        public Source a(int i) {
            return this.d[i];
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
                Util.a(sourceArr[i2]);
                i = i2 + 1;
            }
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.b = fileSystem;
        this.c = file;
        this.q = i;
        this.n = new File(file, "journal");
        this.o = new File(file, "journal.tmp");
        this.p = new File(file, "journal.bkp");
        this.d = i2;
        this.r = j;
        this.u = executor;
    }

    public static DiskLruCache a(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 > 0) {
                return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.a("OkHttp DiskLruCache", true)));
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
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

    private void e(String str) {
        if (a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void k() throws IOException {
        int i;
        BufferedSource buffer = Okio.buffer(this.b.a(this.n));
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
                    d(buffer.readUtf8LineStrict());
                    i2 = i + 1;
                } catch (EOFException e) {
                    this.g = i - this.f.size();
                    if (buffer.exhausted()) {
                        this.e = l();
                    } else {
                        b();
                    }
                    Util.a(buffer);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.a(buffer);
            throw th;
        }
    }

    private BufferedSink l() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.b.c(this.n)) { // from class: okhttp3.internal.cache.DiskLruCache.2
            static final /* synthetic */ boolean a = !DiskLruCache.class.desiredAssertionStatus();

            @Override // okhttp3.internal.cache.FaultHidingSink
            protected void a(IOException iOException) {
                if (!a && !Thread.holdsLock(DiskLruCache.this)) {
                    throw new AssertionError();
                }
                DiskLruCache.this.h = true;
            }
        });
    }

    private void m() throws IOException {
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
                    this.b.delete(next.c[i3]);
                    this.b.delete(next.d[i3]);
                    i2 = i3 + 1;
                }
                it.remove();
            }
        }
    }

    private void n() {
        synchronized (this) {
            if (g()) {
                throw new IllegalStateException("cache is closed");
            }
        }
    }

    Editor a(String str, long j) throws IOException {
        synchronized (this) {
            a();
            n();
            e(str);
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

    public Snapshot a(String str) throws IOException {
        synchronized (this) {
            a();
            n();
            e(str);
            Entry entry = this.f.get(str);
            if (entry != null && entry.e) {
                Snapshot a2 = entry.a();
                if (a2 == null) {
                    return null;
                }
                this.g++;
                this.e.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
                if (f()) {
                    this.u.execute(this.v);
                }
                return a2;
            }
            return null;
        }
    }

    public void a() throws IOException {
        synchronized (this) {
            if (!m && !Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            if (this.i) {
                return;
            }
            if (this.b.d(this.p)) {
                if (this.b.d(this.n)) {
                    this.b.delete(this.p);
                } else {
                    this.b.a(this.p, this.n);
                }
            }
            if (this.b.d(this.n)) {
                try {
                    k();
                    m();
                    this.i = true;
                    return;
                } catch (IOException e) {
                    Platform e2 = Platform.e();
                    e2.a(5, "DiskLruCache " + this.c + " is corrupt: " + e.getMessage() + ", removing", e);
                    delete();
                    this.j = false;
                }
            }
            b();
            this.i = true;
        }
    }

    void a(Editor editor, boolean z) throws IOException {
        synchronized (this) {
            Entry entry = editor.a;
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
                            editor.c();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                        } else if (!this.b.d(entry.d[i3])) {
                            editor.c();
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
                } else if (this.b.d(file)) {
                    File file2 = entry.c[i];
                    this.b.a(file, file2);
                    long j = entry.b[i];
                    long e = this.b.e(file2);
                    entry.b[i] = e;
                    this.s = (this.s - j) + e;
                }
                i++;
            }
            this.g++;
            entry.f = null;
            if (entry.e || z) {
                entry.e = true;
                this.e.writeUtf8("CLEAN").writeByte(32);
                this.e.writeUtf8(entry.a);
                entry.a(this.e);
                this.e.writeByte(10);
                if (z) {
                    long j2 = this.t;
                    this.t = 1 + j2;
                    entry.g = j2;
                }
            } else {
                this.f.remove(entry.a);
                this.e.writeUtf8("REMOVE").writeByte(32);
                this.e.writeUtf8(entry.a);
                this.e.writeByte(10);
            }
            this.e.flush();
            if (this.s > this.r || f()) {
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
            this.b.delete(entry.c[i2]);
            this.s -= entry.b[i2];
            entry.b[i2] = 0;
            i = i2 + 1;
        }
        this.g++;
        this.e.writeUtf8("REMOVE").writeByte(32).writeUtf8(entry.a).writeByte(10);
        this.f.remove(entry.a);
        if (f()) {
            this.u.execute(this.v);
            return true;
        }
        return true;
    }

    @Nullable
    public Editor b(String str) throws IOException {
        return a(str, -1L);
    }

    void b() throws IOException {
        synchronized (this) {
            if (this.e != null) {
                this.e.close();
            }
            BufferedSink buffer = Okio.buffer(this.b.b(this.o));
            buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeDecimalLong(this.q).writeByte(10);
            buffer.writeDecimalLong(this.d).writeByte(10);
            buffer.writeByte(10);
            for (Entry entry : this.f.values()) {
                if (entry.f != null) {
                    buffer.writeUtf8("DIRTY").writeByte(32);
                    buffer.writeUtf8(entry.a);
                    buffer.writeByte(10);
                } else {
                    buffer.writeUtf8("CLEAN").writeByte(32);
                    buffer.writeUtf8(entry.a);
                    entry.a(buffer);
                    buffer.writeByte(10);
                }
            }
            buffer.close();
            if (this.b.d(this.n)) {
                this.b.a(this.n, this.p);
            }
            this.b.a(this.o, this.n);
            this.b.delete(this.p);
            this.e = l();
            this.h = false;
            this.l = false;
        }
    }

    public File c() {
        return this.c;
    }

    public boolean c(String str) throws IOException {
        synchronized (this) {
            a();
            n();
            e(str);
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
                        h();
                        this.e.close();
                        this.e = null;
                        this.j = true;
                        return;
                    }
                    Entry entry = entryArr[i2];
                    if (entry.f != null) {
                        entry.f.c();
                    }
                    i = i2 + 1;
                }
            }
            this.j = true;
        }
    }

    public long d() {
        long j;
        synchronized (this) {
            j = this.r;
        }
        return j;
    }

    public void delete() throws IOException {
        close();
        this.b.f(this.c);
    }

    public long e() throws IOException {
        long j;
        synchronized (this) {
            a();
            j = this.s;
        }
        return j;
    }

    boolean f() {
        int i = this.g;
        return i >= 2000 && i >= this.f.size();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        synchronized (this) {
            if (this.i) {
                n();
                h();
                this.e.flush();
            }
        }
    }

    public boolean g() {
        boolean z;
        synchronized (this) {
            z = this.j;
        }
        return z;
    }

    void h() throws IOException {
        while (this.s > this.r) {
            a(this.f.values().iterator().next());
        }
        this.k = false;
    }

    public void i() throws IOException {
        synchronized (this) {
            a();
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

    public Iterator<Snapshot> j() throws IOException {
        Iterator<Snapshot> it;
        synchronized (this) {
            a();
            it = new Iterator<Snapshot>() { // from class: okhttp3.internal.cache.DiskLruCache.3
                final Iterator<Entry> a;
                Snapshot b;
                Snapshot c;

                {
                    this.a = new ArrayList(DiskLruCache.this.f.values()).iterator();
                }

                @Override // java.util.Iterator
                /* renamed from: a */
                public Snapshot next() {
                    if (hasNext()) {
                        Snapshot snapshot = this.b;
                        this.c = snapshot;
                        this.b = null;
                        return snapshot;
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    Snapshot a2;
                    if (this.b != null) {
                        return true;
                    }
                    synchronized (DiskLruCache.this) {
                        if (DiskLruCache.this.j) {
                            return false;
                        }
                        while (this.a.hasNext()) {
                            Entry next = this.a.next();
                            if (next.e && (a2 = next.a()) != null) {
                                this.b = a2;
                                return true;
                            }
                        }
                        return false;
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    Snapshot snapshot = this.c;
                    if (snapshot == null) {
                        throw new IllegalStateException("remove() before next()");
                    }
                    try {
                        DiskLruCache.this.c(snapshot.b);
                    } catch (IOException e) {
                    } catch (Throwable th) {
                        this.c = null;
                        throw th;
                    }
                    this.c = null;
                }
            };
        }
        return it;
    }
}
