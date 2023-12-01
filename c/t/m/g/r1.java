package c.t.m.g;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r1.class */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3909a;
    public File b;

    /* renamed from: c  reason: collision with root package name */
    public FileOutputStream f3910c;
    public BufferedOutputStream d;
    public StringBuilder e;
    public s1 f;
    public String g;
    public int h;
    public boolean i;
    public long j;
    public String k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r1$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3911a;

        public a(String str) {
            this.f3911a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                r2.a(new File(this.f3911a), new File(this.f3911a.substring(0, this.f3911a.length() - r1.this.k.length()) + ".gzip"), true);
            } catch (Throwable th) {
            }
        }
    }

    public r1(File file) throws IOException {
        this(file, 5120);
    }

    public r1(File file, int i) throws IOException {
        this.f3909a = new byte[0];
        this.g = "";
        this.h = 0;
        this.i = false;
        this.j = Long.MAX_VALUE;
        this.k = "";
        this.l = false;
        this.m = false;
        this.n = 1;
        this.o = 0;
        a(file, i);
    }

    public void a() throws IOException {
        synchronized (this.f3909a) {
            if (this.d == null) {
                return;
            }
            a(this.e.toString().getBytes("UTF-8"));
            this.e.setLength(0);
            if (g3.a()) {
                this.b.getAbsolutePath();
                this.b.length();
            }
            this.d.close();
            this.f3910c.close();
            if (this.i && this.l) {
                c();
            }
            this.n = 1;
            this.d = null;
            this.f3910c = null;
        }
    }

    public void a(s1 s1Var) {
        synchronized (this.f3909a) {
            this.f = s1Var;
        }
    }

    public final void a(File file, int i) throws IOException {
        this.b = file;
        File parentFile = file == null ? null : file.getParentFile();
        if ((parentFile == null || !parentFile.exists()) && !parentFile.mkdirs()) {
            return;
        }
        this.g = file.getAbsolutePath();
        this.h = i;
        if (g3.a()) {
            file.getAbsolutePath();
        }
        this.e = new StringBuilder(i);
        this.f3910c = new FileOutputStream(file, true);
        this.d = new BufferedOutputStream(this.f3910c, 5120);
    }

    public void a(String str) throws IOException {
        synchronized (this.f3909a) {
            if (this.e != null) {
                this.e.append(str);
                if (this.e.length() >= this.h) {
                    a(this.e.toString().getBytes("UTF-8"));
                    this.e.setLength(0);
                }
            }
        }
    }

    public void a(byte[] bArr) throws IOException {
        synchronized (this.f3909a) {
            if (this.d == null) {
                return;
            }
            this.d.write(this.f == null ? bArr : this.f.a(bArr));
            if (this.i) {
                int length = this.o + bArr.length;
                this.o = length;
                if (length >= 5120) {
                    this.o = 0;
                    File b = b();
                    if ((b == null ? 0L : b.length()) >= this.j) {
                        this.d.close();
                        this.f3910c.close();
                        c();
                        a(new File(this.g), this.h);
                    }
                }
            }
        }
    }

    public File b() {
        File file;
        synchronized (this.f3909a) {
            file = this.b;
        }
        return file;
    }

    public final void c() {
        File file;
        File file2 = new File(this.g + "_" + this.n + this.k);
        while (true) {
            file = file2;
            if (!file.exists()) {
                break;
            }
            this.n++;
            file2 = new File(this.g + "_" + this.n + this.k);
        }
        this.b.renameTo(file);
        if (g3.a()) {
            this.b.getName();
            file.getName();
        }
        String absolutePath = file.getAbsolutePath();
        if (this.m && !m3.a(absolutePath)) {
            g3.a();
            new Thread(new a(absolutePath), "th_loc_tmp").start();
        }
        this.n++;
    }
}
