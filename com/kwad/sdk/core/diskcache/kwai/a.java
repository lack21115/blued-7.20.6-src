package com.kwad.sdk.core.diskcache.kwai;

import com.kwad.sdk.utils.q;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/kwai/a.class */
public final class a implements Closeable {
    private final File aeo;
    private final File aep;
    private final File aeq;
    private final File aer;
    private final int aes;
    private int aet;
    private final int aeu;
    private Writer aew;
    private int aey;
    private long maxSize;
    static final Pattern aen = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream aeC = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    private long size = 0;
    private int aev = 0;
    private final LinkedHashMap<String, b> aex = new LinkedHashMap<>(0, 0.75f, true);
    private long aez = 0;
    final ThreadPoolExecutor aeA = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.kwai.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> aeB = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: vi */
        public Void call() {
            synchronized (a.this) {
                if (a.this.aew == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.vo();
                if (a.this.vn()) {
                    a.this.vl();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/kwai/a$a.class */
    public final class C0557a {
        private final b aeE;
        private final boolean[] aeF;
        private boolean aeG;
        private boolean aeH;

        /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/kwai/a$a$a.class */
        final class C0558a extends FilterOutputStream {
            private C0558a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C0558a(C0557a c0557a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C0557a.b(C0557a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C0557a.b(C0557a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C0557a.b(C0557a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C0557a.b(C0557a.this, true);
                }
            }
        }

        private C0557a(b bVar) {
            this.aeE = bVar;
            this.aeF = bVar.aeK ? null : new boolean[a.this.aeu];
        }

        /* synthetic */ C0557a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        static /* synthetic */ boolean b(C0557a c0557a, boolean z) {
            c0557a.aeG = true;
            return true;
        }

        public final OutputStream aW(int i) {
            FileOutputStream fileOutputStream;
            C0558a c0558a;
            synchronized (a.this) {
                if (this.aeE.aeL != this) {
                    throw new IllegalStateException();
                }
                if (!this.aeE.aeK) {
                    this.aeF[0] = true;
                }
                File aY = this.aeE.aY(0);
                try {
                    fileOutputStream = new FileOutputStream(aY);
                } catch (FileNotFoundException e) {
                    a.this.aeo.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(aY);
                    } catch (FileNotFoundException e2) {
                        return a.aeC;
                    }
                }
                c0558a = new C0558a(this, fileOutputStream, (byte) 0);
            }
            return c0558a;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void commit() {
            if (this.aeG) {
                a.this.a(this, false);
                a.this.remove(this.aeE.key);
            } else {
                a.this.a(this, true);
            }
            this.aeH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/kwai/a$b.class */
    public final class b {
        private final long[] aeJ;
        private boolean aeK;
        private C0557a aeL;
        private long aeM;
        private final String key;

        private b(String str) {
            this.key = str;
            this.aeJ = new long[a.this.aeu];
        }

        /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.aeK = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length != a.this.aeu) {
                throw c(strArr);
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        return;
                    }
                    this.aeJ[i2] = Long.parseLong(strArr[i2]);
                    i = i2 + 1;
                } catch (NumberFormatException e) {
                    throw c(strArr);
                }
            }
        }

        private static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File aX(int i) {
            File file = a.this.aeo;
            return new File(file, this.key + i);
        }

        public final File aY(int i) {
            File file = a.this.aeo;
            return new File(file, this.key + i + ".tmp");
        }

        public final String vq() {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.aeJ;
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
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/kwai/a$c.class */
    public final class c implements Closeable {
        private final long[] aeJ;
        private final long aeM;
        private File[] aeN;
        private final InputStream[] aeO;
        private final String key;

        private c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aeM = j;
            this.aeN = fileArr;
            this.aeO = inputStreamArr;
            this.aeJ = jArr;
        }

        /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        public final File aZ(int i) {
            return this.aeN[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] inputStreamArr = this.aeO;
            int length = inputStreamArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamArr[i2]);
                i = i2 + 1;
            }
        }
    }

    private a(File file, int i, int i2, long j, int i3) {
        this.aeo = file;
        this.aes = i;
        this.aep = new File(file, "journal");
        this.aeq = new File(file, "journal.tmp");
        this.aer = new File(file, "journal.bkp");
        this.aeu = i2;
        this.maxSize = j;
        this.aet = i3;
    }

    static /* synthetic */ int a(a aVar, int i) {
        aVar.aey = 0;
        return 0;
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i, int i2, long j, int i3) {
        if (j > 0) {
            if (i3 > 0) {
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
                    a aVar = new a(file, i, i2, j, i3);
                    if (aVar.aep.exists()) {
                        try {
                            aVar.vj();
                            aVar.vk();
                            aVar.aew = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.aep, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                            return aVar;
                        } catch (IOException e) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                            aVar.delete();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i, i2, j, i3);
                    aVar2.vl();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0557a c0557a, boolean z) {
        synchronized (this) {
            b bVar = c0557a.aeE;
            if (bVar.aeL != c0557a) {
                throw new IllegalStateException();
            }
            int i = 0;
            if (z) {
                i = 0;
                if (!bVar.aeK) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        i = 0;
                        if (i3 >= this.aeu) {
                            break;
                        } else if (!c0557a.aeF[i3]) {
                            c0557a.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                        } else if (!bVar.aY(i3).exists()) {
                            c0557a.abort();
                            return;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                }
            }
            while (i < this.aeu) {
                File aY = bVar.aY(i);
                if (!z) {
                    k(aY);
                } else if (aY.exists()) {
                    File aX = bVar.aX(i);
                    aY.renameTo(aX);
                    long j = bVar.aeJ[i];
                    long length = aX.length();
                    bVar.aeJ[i] = length;
                    this.size = (this.size - j) + length;
                    this.aev++;
                }
                i++;
            }
            this.aey++;
            bVar.aeL = null;
            if (bVar.aeK || z) {
                b.a(bVar, true);
                this.aew.write("CLEAN " + bVar.key + bVar.vq() + '\n');
                if (z) {
                    long j2 = this.aez;
                    this.aez = 1 + j2;
                    bVar.aeM = j2;
                }
            } else {
                this.aex.remove(bVar.key);
                this.aew.write("REMOVE " + bVar.key + '\n');
            }
            this.aew.flush();
            if (this.size > this.maxSize || this.aev > this.aet || vn()) {
                this.aeA.submit(this.aeB);
            }
        }
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            k(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void bE(String str) {
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
                    this.aex.remove(substring2);
                    return;
                }
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        b bVar = this.aex.get(substring);
        b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new b(this, substring, (byte) 0);
            this.aex.put(substring, bVar2);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            b.a(bVar2, true);
            bVar2.aeL = null;
            bVar2.b(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar2.aeL = new C0557a(this, bVar2, (byte) 0);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private static void bH(String str) {
        if (aen.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private void checkNotClosed() {
        if (this.aew == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private C0557a e(String str, long j) {
        synchronized (this) {
            checkNotClosed();
            bH(str);
            b bVar = this.aex.get(str);
            if (bVar == null) {
                bVar = new b(this, str, (byte) 0);
                this.aex.put(str, bVar);
            } else if (bVar.aeL != null) {
                return null;
            }
            C0557a c0557a = new C0557a(this, bVar, (byte) 0);
            bVar.aeL = c0557a;
            Writer writer = this.aew;
            writer.write("DIRTY " + str + '\n');
            this.aew.flush();
            return c0557a;
        }
    }

    private static void k(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.aex.entrySet().iterator().next().getKey());
        }
    }

    private void vj() {
        int i;
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.aep), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.aes).equals(readLine3) || !Integer.toString(this.aeu).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    i = i2;
                    bE(bVar.readLine());
                    i2 = i + 1;
                } catch (EOFException e) {
                    this.aey = i - this.aex.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void vk() {
        k(this.aeq);
        Iterator<b> it = this.aex.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.aeL == null) {
                for (int i = 0; i < this.aeu; i++) {
                    this.size += next.aeJ[i];
                    this.aev++;
                }
            } else {
                next.aeL = null;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.aeu) {
                        break;
                    }
                    k(next.aX(i3));
                    k(next.aY(i3));
                    i2 = i3 + 1;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl() {
        synchronized (this) {
            if (this.aew != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(this.aew);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aeq), com.kwad.sdk.crash.utils.a.US_ASCII));
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aes));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aeu));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.aex.values()) {
                bufferedWriter.write(bVar.aeL != null ? "DIRTY " + bVar.key + '\n' : "CLEAN " + bVar.key + bVar.vq() + '\n');
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            if (this.aep.exists()) {
                a(this.aep, this.aer, true);
            }
            a(this.aeq, this.aep, false);
            this.aer.delete();
            this.aew = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aep, true), com.kwad.sdk.crash.utils.a.US_ASCII));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vn() {
        int i = this.aey;
        return i >= 2000 && i >= this.aex.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vo() {
        while (this.aev > this.aet) {
            remove(this.aex.entrySet().iterator().next().getKey());
        }
    }

    public final c bF(String str) {
        synchronized (this) {
            checkNotClosed();
            bH(str);
            b bVar = this.aex.get(str);
            if (bVar == null) {
                return null;
            }
            if (bVar.aeK) {
                File[] fileArr = new File[this.aeu];
                InputStream[] inputStreamArr = new InputStream[this.aeu];
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        if (i2 >= this.aeu) {
                            break;
                        }
                        File aX = bVar.aX(i2);
                        fileArr[i2] = aX;
                        inputStreamArr[i2] = new FileInputStream(aX);
                        i = i2 + 1;
                    } catch (FileNotFoundException e) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= this.aeu || inputStreamArr[i4] == null) {
                                break;
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamArr[i4]);
                            i3 = i4 + 1;
                        }
                        return null;
                    }
                }
                this.aey++;
                this.aew.append((CharSequence) ("READ " + str + '\n'));
                if (vn()) {
                    this.aeA.submit(this.aeB);
                }
                return new c(this, str, bVar.aeM, fileArr, inputStreamArr, bVar.aeJ, (byte) 0);
            }
            return null;
        }
    }

    public final C0557a bG(String str) {
        return e(str, -1L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (this.aew == null) {
                return;
            }
            Iterator it = new ArrayList(this.aex.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.aeL != null) {
                    bVar.aeL.abort();
                }
            }
            trimToSize();
            vo();
            com.kwad.sdk.crash.utils.b.closeQuietly(this.aew);
            this.aew = null;
        }
    }

    public final void delete() {
        close();
        q.deleteContents(this.aeo);
    }

    public final void flush() {
        synchronized (this) {
            checkNotClosed();
            trimToSize();
            vo();
            this.aew.flush();
        }
    }

    public final File getDirectory() {
        return this.aeo;
    }

    public final long getMaxSize() {
        long j;
        synchronized (this) {
            j = this.maxSize;
        }
        return j;
    }

    public final boolean remove(String str) {
        synchronized (this) {
            checkNotClosed();
            bH(str);
            b bVar = this.aex.get(str);
            if (bVar != null && bVar.aeL == null) {
                for (int i = 0; i < this.aeu; i++) {
                    File aX = bVar.aX(i);
                    if (aX.exists() && !aX.delete()) {
                        throw new IOException("failed to delete " + aX);
                    }
                    this.size -= bVar.aeJ[i];
                    this.aev--;
                    bVar.aeJ[i] = 0;
                }
                this.aey++;
                this.aew.append((CharSequence) ("REMOVE " + str + '\n'));
                this.aex.remove(str);
                if (vn()) {
                    this.aeA.submit(this.aeB);
                }
                return true;
            }
            return false;
        }
    }

    public final int vm() {
        int i;
        synchronized (this) {
            i = this.aet;
        }
        return i;
    }
}
