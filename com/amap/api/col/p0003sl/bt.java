package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.amap.api.col.3sl.bt  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bt.class */
public final class bt {
    private b a;

    /* renamed from: com.amap.api.col.3sl.bt$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bt$a.class */
    public static final class a {
        public boolean a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.bt$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bt$b.class */
    public static final class b {
        private String a;
        private String b;
        private bp c;
        private a d = new a();
        private String e;

        public b(bq bqVar, bp bpVar) {
            this.c = null;
            this.a = bqVar.x();
            this.b = bqVar.y();
            this.c = bpVar;
        }

        public final String a() {
            return this.a;
        }

        public final void a(String str) {
            if (str.length() > 1) {
                this.e = str;
            }
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.e;
        }

        public final bp d() {
            return this.c;
        }

        public final a e() {
            return this.d;
        }

        public final void f() {
            this.d.a = true;
        }
    }

    /* renamed from: com.amap.api.col.3sl.bt$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bt$c.class */
    public interface c {
        void a();

        void a(long j);
    }

    public bt(bq bqVar, bp bpVar) {
        this.a = new b(bqVar, bpVar);
    }

    private static int a(File file, ZipInputStream zipInputStream, long j, long j2, c cVar, a aVar) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i;
            } else if (aVar != null && aVar.a) {
                bufferedOutputStream.close();
                return i;
            } else {
                bufferedOutputStream.write(bArr, 0, read);
                int i2 = i + read;
                i = i2;
                if (j2 > 0) {
                    i = i2;
                    if (cVar != null) {
                        long j3 = ((i2 + j) * 100) / j2;
                        if (aVar != null) {
                            i = i2;
                            if (!aVar.a) {
                            }
                        }
                        cVar.a(j3);
                        i = i2;
                    }
                }
            }
        }
    }

    private static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        final bp d = bVar.d();
        if (d != null) {
            d.p();
        }
        String a2 = bVar.a();
        String b2 = bVar.b();
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(b2)) {
            if (bVar.e().a) {
                if (d != null) {
                    d.r();
                    return;
                }
                return;
            } else if (d != null) {
                d.q();
                return;
            } else {
                return;
            }
        }
        File file = new File(a2);
        if (!file.exists()) {
            if (bVar.e().a) {
                if (d != null) {
                    d.r();
                    return;
                }
                return;
            } else if (d != null) {
                d.q();
                return;
            } else {
                return;
            }
        }
        File file2 = new File(b2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        c cVar = new c() { // from class: com.amap.api.col.3sl.bt.1
            @Override // com.amap.api.col.p0003sl.bt.c
            public final void a() {
                bp bpVar = bp.this;
                if (bpVar != null) {
                    bpVar.q();
                }
            }

            @Override // com.amap.api.col.p0003sl.bt.c
            public final void a(long j) {
                try {
                    if (bp.this != null) {
                        bp.this.a(j);
                    }
                } catch (Exception e) {
                }
            }
        };
        try {
            if (bVar.e().a && d != null) {
                d.r();
            }
            a(file, file2, cVar, bVar);
            if (bVar.e().a) {
                if (d != null) {
                    d.r();
                }
            } else if (d != null) {
                d.b(bVar.c());
            }
        } catch (Throwable th) {
            if (bVar.e().a) {
                if (d != null) {
                    d.r();
                }
            } else if (d != null) {
                d.q();
            }
        }
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        a(parentFile);
        parentFile.mkdir();
    }

    private static void a(File file, File file2, c cVar, b bVar) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        a e = bVar.e();
        long j = 0;
        long j2 = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
            ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
            while (true) {
                long j3 = j;
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (e != null && e.a) {
                        long j4 = j;
                        zipInputStream.closeEntry();
                        long j5 = j;
                        zipInputStream.close();
                        long j6 = j;
                        checkedInputStream.close();
                        long j7 = j;
                        fileInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        long j8 = j;
                        if (!a(nextEntry.getName())) {
                            long j9 = j;
                            cVar.a();
                            break;
                        }
                        stringBuffer.append(nextEntry.getName());
                        long j10 = j;
                        stringBuffer.append(i.b);
                    }
                    long j11 = j;
                    j += nextEntry.getSize();
                    zipInputStream.closeEntry();
                } else {
                    break;
                }
            }
            bVar.a(stringBuffer.toString());
            long j12 = j;
            zipInputStream.close();
            long j13 = j;
            checkedInputStream.close();
            j2 = j;
            fileInputStream.close();
            j2 = j;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        a(file2, zipInputStream2, j2, cVar, e);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static void a(File file, ZipInputStream zipInputStream, long j, c cVar, a aVar) throws Exception {
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (aVar != null && aVar.a) {
                zipInputStream.closeEntry();
                return;
            }
            String str = file.getPath() + File.separator + nextEntry.getName();
            if (!a(nextEntry.getName())) {
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            }
            File file2 = new File(str);
            a(file2);
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                i += a(file2, zipInputStream, i, j, cVar, aVar);
            }
            zipInputStream.closeEntry();
        }
    }

    private static boolean a(String str) {
        return (str.contains("..") || str.contains(BridgeUtil.SPLIT_MARK) || str.contains("\\") || str.contains("%")) ? false : true;
    }

    public final void a() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void b() {
        b bVar = this.a;
        if (bVar != null) {
            a(bVar);
        }
    }
}
