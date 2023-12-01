package com.tencent.smtt.utils;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e.class */
public class e implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f38944a = {127, 'E', 'L', 'F', 0};
    final char[] b = new char[16];

    /* renamed from: c  reason: collision with root package name */
    boolean f38945c;
    j[] d;
    l[] e;
    byte[] f;
    private final com.tencent.smtt.utils.c g;
    private final a h;
    private final k[] i;
    private byte[] j;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$a.class */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        short f38946a;
        short b;

        /* renamed from: c  reason: collision with root package name */
        int f38947c;
        int d;
        short e;
        short f;
        short g;
        short h;
        short i;
        short j;

        abstract long a();

        abstract long b();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$b.class */
    static class b extends a {
        int k;
        int l;
        int m;

        b() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$c.class */
    public static class c extends j {

        /* renamed from: a  reason: collision with root package name */
        int f38948a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f38949c;
        int d;
        int e;
        int f;

        c() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$d.class */
    static class d extends k {

        /* renamed from: a  reason: collision with root package name */
        int f38950a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f38951c;
        int d;
        int e;
        int f;

        d() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return this.d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.f38951c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.smtt.utils.e$e  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$e.class */
    public static class C1007e extends l {

        /* renamed from: a  reason: collision with root package name */
        int f38952a;
        int b;

        C1007e() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$f.class */
    static class f extends a {
        long k;
        long l;
        long m;

        f() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$g.class */
    public static class g extends j {

        /* renamed from: a  reason: collision with root package name */
        long f38953a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        long f38954c;
        long d;
        long e;
        long f;

        g() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$h.class */
    static class h extends k {

        /* renamed from: a  reason: collision with root package name */
        long f38955a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        long f38956c;
        long d;
        long e;
        long f;

        h() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return (int) this.d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.f38956c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$i.class */
    public static class i extends l {

        /* renamed from: a  reason: collision with root package name */
        long f38957a;
        long b;

        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$j.class */
    public static abstract class j {
        int g;
        int h;

        j() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$k.class */
    public static abstract class k {
        int g;
        int h;
        int i;
        int j;

        public abstract int a();

        public abstract long b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/e$l.class */
    public static abstract class l {

        /* renamed from: c  reason: collision with root package name */
        int f38958c;
        char d;
        char e;
        short f;

        l() {
        }
    }

    public e(File file) throws IOException, UnknownFormatConversionException {
        f fVar;
        com.tencent.smtt.utils.c cVar = new com.tencent.smtt.utils.c(file);
        this.g = cVar;
        cVar.a(this.b);
        if (!a()) {
            throw new UnknownFormatConversionException("Invalid elf magic: " + file);
        }
        cVar.a(e());
        boolean d2 = d();
        if (d2) {
            f fVar2 = new f();
            fVar2.f38946a = cVar.a();
            fVar2.b = cVar.a();
            fVar2.f38947c = cVar.b();
            fVar2.k = cVar.c();
            fVar2.l = cVar.c();
            fVar2.m = cVar.c();
            fVar = fVar2;
        } else {
            b bVar = new b();
            bVar.f38946a = cVar.a();
            bVar.b = cVar.a();
            bVar.f38947c = cVar.b();
            bVar.k = cVar.b();
            bVar.l = cVar.b();
            bVar.m = cVar.b();
            fVar = bVar;
        }
        this.h = fVar;
        a aVar = this.h;
        aVar.d = cVar.b();
        aVar.e = cVar.a();
        aVar.f = cVar.a();
        aVar.g = cVar.a();
        aVar.h = cVar.a();
        aVar.i = cVar.a();
        aVar.j = cVar.a();
        this.i = new k[aVar.i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= aVar.i) {
                break;
            }
            cVar.a(aVar.a() + (aVar.h * i3));
            if (d2) {
                h hVar = new h();
                hVar.g = cVar.b();
                hVar.h = cVar.b();
                hVar.f38955a = cVar.c();
                hVar.b = cVar.c();
                hVar.f38956c = cVar.c();
                hVar.d = cVar.c();
                hVar.i = cVar.b();
                hVar.j = cVar.b();
                hVar.e = cVar.c();
                hVar.f = cVar.c();
                this.i[i3] = hVar;
            } else {
                d dVar = new d();
                dVar.g = cVar.b();
                dVar.h = cVar.b();
                dVar.f38950a = cVar.b();
                dVar.b = cVar.b();
                dVar.f38951c = cVar.b();
                dVar.d = cVar.b();
                dVar.i = cVar.b();
                dVar.j = cVar.b();
                dVar.e = cVar.b();
                dVar.f = cVar.b();
                this.i[i3] = dVar;
            }
            i2 = i3 + 1;
        }
        if (aVar.j > -1) {
            short s = aVar.j;
            k[] kVarArr = this.i;
            if (s < kVarArr.length) {
                k kVar = kVarArr[aVar.j];
                if (kVar.h != 3) {
                    throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + ((int) aVar.j));
                }
                this.j = new byte[kVar.a()];
                cVar.a(kVar.b());
                cVar.a(this.j);
                if (this.f38945c) {
                    f();
                    return;
                }
                return;
            }
        }
        throw new UnknownFormatConversionException("Invalid e_shstrndx=" + ((int) aVar.j));
    }

    public static boolean a(File file) {
        boolean z = false;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            long readInt = randomAccessFile.readInt();
            randomAccessFile.close();
            if (readInt == 2135247942) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean b(File file) {
        StringBuilder sb;
        String str;
        if (g() && a(file)) {
            try {
                new e(file);
                return true;
            } catch (IOException e) {
                Log.e("ELF", "checkElfFile IOException: " + e);
                return false;
            } catch (UnknownFormatConversionException e2) {
                e = e2;
                sb = new StringBuilder();
                str = "checkElfFile UnknownFormatConversionException: ";
                sb.append(str);
                sb.append(e);
                Log.e("ELF", sb.toString());
                return true;
            } catch (Throwable th) {
                e = th;
                sb = new StringBuilder();
                str = "checkElfFile Throwable: ";
                sb.append(str);
                sb.append(e);
                Log.e("ELF", sb.toString());
                return true;
            }
        }
        return true;
    }

    private void f() throws IOException {
        a aVar = this.h;
        com.tencent.smtt.utils.c cVar = this.g;
        boolean d2 = d();
        k a2 = a(".dynsym");
        if (a2 != null) {
            cVar.a(a2.b());
            int a3 = a2.a() / (d2 ? 24 : 16);
            this.e = new l[a3];
            char[] cArr = new char[1];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= a3) {
                    break;
                }
                if (d2) {
                    i iVar = new i();
                    iVar.f38958c = cVar.b();
                    cVar.a(cArr);
                    iVar.d = cArr[0];
                    cVar.a(cArr);
                    iVar.e = cArr[0];
                    iVar.f38957a = cVar.c();
                    iVar.b = cVar.c();
                    iVar.f = cVar.a();
                    this.e[i3] = iVar;
                } else {
                    C1007e c1007e = new C1007e();
                    c1007e.f38958c = cVar.b();
                    c1007e.f38952a = cVar.b();
                    c1007e.b = cVar.b();
                    cVar.a(cArr);
                    c1007e.d = cArr[0];
                    cVar.a(cArr);
                    c1007e.e = cArr[0];
                    c1007e.f = cVar.a();
                    this.e[i3] = c1007e;
                }
                i2 = i3 + 1;
            }
            k kVar = this.i[a2.i];
            cVar.a(kVar.b());
            byte[] bArr = new byte[kVar.a()];
            this.f = bArr;
            cVar.a(bArr);
        }
        this.d = new j[aVar.g];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= aVar.g) {
                return;
            }
            cVar.a(aVar.b() + (aVar.f * i5));
            if (d2) {
                g gVar = new g();
                gVar.g = cVar.b();
                gVar.h = cVar.b();
                gVar.f38953a = cVar.c();
                gVar.b = cVar.c();
                gVar.f38954c = cVar.c();
                gVar.d = cVar.c();
                gVar.e = cVar.c();
                gVar.f = cVar.c();
                this.d[i5] = gVar;
            } else {
                c cVar2 = new c();
                cVar2.g = cVar.b();
                cVar2.h = cVar.b();
                cVar2.f38948a = cVar.b();
                cVar2.b = cVar.b();
                cVar2.f38949c = cVar.b();
                cVar2.d = cVar.b();
                cVar2.e = cVar.b();
                cVar2.f = cVar.b();
                this.d[i5] = cVar2;
            }
            i4 = i5 + 1;
        }
    }

    private static boolean g() {
        String property = System.getProperty("java.vm.version");
        return property != null && property.startsWith("2");
    }

    public final k a(String str) {
        k[] kVarArr = this.i;
        int length = kVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return null;
            }
            k kVar = kVarArr[i3];
            if (str.equals(a(kVar.g))) {
                return kVar;
            }
            i2 = i3 + 1;
        }
    }

    public final String a(int i2) {
        if (i2 == 0) {
            return "SHN_UNDEF";
        }
        int i3 = i2;
        while (true) {
            int i4 = i3;
            if (this.j[i4] == 0) {
                return new String(this.j, i2, i4 - i2);
            }
            i3 = i4 + 1;
        }
    }

    final boolean a() {
        boolean z = false;
        if (this.b[0] == f38944a[0]) {
            z = true;
        }
        return z;
    }

    final char b() {
        return this.b[4];
    }

    final char c() {
        return this.b[5];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.close();
    }

    public final boolean d() {
        return b() == 2;
    }

    public final boolean e() {
        return c() == 1;
    }
}
