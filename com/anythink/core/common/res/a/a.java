package com.anythink.core.common.res.a;

import android.text.TextUtils;
import com.anythink.core.common.a.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.f;
import com.anythink.core.common.res.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/a/a.class */
public class a extends com.anythink.core.common.res.image.b {

    /* renamed from: a  reason: collision with root package name */
    final String f6883a;
    public com.anythink.core.common.res.a.b b;
    public List<AbstractC0108a> j;
    public b k;
    int l;
    private final int m;
    private final int n;
    private int o;
    private int p;
    private long q;
    private String r;
    private boolean s;

    /* renamed from: com.anythink.core.common.res.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/a/a$a.class */
    public static abstract class AbstractC0108a {
        public abstract void a(String str, String str2);

        public abstract boolean a(int i, long j, long j2);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/a/a$b.class */
    public static abstract class b {
        public abstract void a(long j, long j2, long j3, long j4, long j5);

        public abstract void a(String str, String str2, long j, long j2, long j3, long j4);
    }

    public a(String str) {
        super(str);
        this.f6883a = a.class.getSimpleName();
        this.m = 0;
        this.n = 1;
        this.l = -1;
        this.j = new ArrayList();
        this.b = new com.anythink.core.common.res.a.b();
        this.p = 0;
        this.q = 0L;
        this.s = false;
        this.o = 0;
    }

    private void a(int i) {
        this.o = i;
    }

    private void a(int i, long j) {
        synchronized (this) {
            if (this.l != i) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6913c);
                sb.append(" notifyDownloadProcess:");
                sb.append(i);
                this.l = i;
            }
            Iterator<AbstractC0108a> it = this.j.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().a(i, j, this.i)) {
                    z = i != 100;
                    it.remove();
                }
            }
            j.a().a(this.f6913c, this.r, this.i, j, i, z);
        }
    }

    private void a(b bVar) {
        this.k = bVar;
    }

    private void b(int i, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6913c);
        sb.append(" notifyDownloadFinish: downloadRate:");
        sb.append(i);
        if (i == 100) {
            j.a().a(this.f6913c, this.r, this.i, j, i, true);
            b bVar = this.k;
            if (bVar != null) {
                bVar.a(this.i, this.e, this.g, this.f, this.h);
            }
        }
    }

    private void b(String str, String str2) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6913c);
            sb.append(" notifyLoadFailed: errorCode:");
            sb.append(str);
            sb.append(",errorMsg:");
            sb.append(str2);
            this.o = 0;
            for (AbstractC0108a abstractC0108a : this.j) {
                abstractC0108a.a(str, str2);
            }
            j();
            if (this.k != null) {
                this.k.a(str, str2, this.i, this.e, this.f, this.h);
            }
        }
    }

    private boolean b(int i) {
        synchronized (this) {
            if (this.s) {
                return true;
            }
            if (this.b.f6888c == 2) {
                if (i >= this.b.f6887a) {
                    return false;
                }
            }
            return true;
        }
    }

    private int g() {
        return this.o;
    }

    private void h() {
        String a2 = d.a(n.a().g()).a(4);
        if (TextUtils.isEmpty(a2)) {
            b("", "without saveDirectory");
            return;
        }
        File file = new File(a2);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.r = d.a(n.a().g()).b(4, f.a(this.f6913c));
        File file2 = new File(this.r);
        if (file2.exists()) {
            this.q = file2.length();
        }
    }

    private boolean i() {
        int i = this.p;
        if (i != 100) {
            return this.o == 0 && i < 100;
        }
        a(i, this.q);
        b(this.p, this.q);
        return false;
    }

    private void j() {
        synchronized (this) {
            this.j.clear();
        }
    }

    @Override // com.anythink.core.common.res.image.b
    public final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(com.anythink.core.common.k.b.b bVar) {
        com.anythink.core.common.k.b.a.a().a(bVar, 5);
    }

    public final void a(AbstractC0108a abstractC0108a) {
        synchronized (this) {
            if (!this.j.contains(abstractC0108a)) {
                this.j.add(abstractC0108a);
            }
        }
    }

    public final void a(com.anythink.core.common.res.a.b bVar) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6913c);
            sb.append(" setVideoUrlLoaderConfig: mReadyRate:");
            sb.append(bVar.f6887a);
            sb.append(",mVideoCtnType:");
            sb.append(bVar.f6888c);
            if (this.b.f6887a < bVar.f6887a) {
                this.b.f6887a = bVar.f6887a;
            }
            if (this.b.f6888c != 1) {
                this.b.f6888c = bVar.f6888c;
            }
        }
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(String str, String str2) {
        b(str, str2);
    }

    @Override // com.anythink.core.common.res.image.b
    public final boolean a(InputStream inputStream) {
        FileOutputStream fileOutputStream;
        boolean z = true;
        if (!TextUtils.isEmpty(this.r)) {
            FileOutputStream fileOutputStream2 = null;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (this.q > 0) {
                    inputStream.skip(this.q);
                    FileOutputStream fileOutputStream3 = new FileOutputStream(this.r, true);
                    int i = (int) (((this.q * 1.0d) / this.i) * 100.0d);
                    this.p = i;
                    a(i, this.q);
                    fileOutputStream = fileOutputStream3;
                } else {
                    FileOutputStream fileOutputStream4 = new FileOutputStream(this.r);
                    this.p = 0;
                    fileOutputStream = fileOutputStream4;
                }
                FileOutputStream fileOutputStream5 = fileOutputStream;
                fileOutputStream2 = fileOutputStream5;
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1 || !b(this.p)) {
                        break;
                    }
                    fileOutputStream5.write(bArr, 0, read);
                    long j = this.q + read;
                    this.q = j;
                    int i2 = (int) (((j * 1.0d) / this.i) * 100.0d);
                    this.p = i2;
                    a(i2, this.q);
                }
                fileOutputStream2 = fileOutputStream5;
                fileOutputStream5.close();
                try {
                    fileOutputStream5.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th4) {
                        }
                    }
                    z = false;
                    b(this.p, this.q);
                    return z;
                } catch (Throwable th5) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th6) {
                        }
                    }
                    throw th5;
                }
            }
            b(this.p, this.q);
            return z;
        }
        z = false;
        b(this.p, this.q);
        return z;
    }

    @Override // com.anythink.core.common.res.image.b
    public final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    public final void c() {
        this.o = 0;
    }

    public final void e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6913c);
        sb.append(" startRequest: canStartLoader():");
        sb.append(i());
        if (i()) {
            h();
            this.o = 1;
            d();
        }
    }

    public final void f() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6913c);
        sb.append(" startRequest: resumeRequest():");
        sb.append(i());
        this.s = true;
        if (i()) {
            h();
            this.o = 1;
            d();
        }
    }
}
