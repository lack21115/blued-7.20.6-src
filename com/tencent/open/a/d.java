package com.tencent.open.a;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a/d.class */
public class d {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a/d$a.class */
    public static final class a {
        public static final boolean a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a/d$b.class */
    public static final class b {
        public static boolean a() {
            String externalStorageState = Environment.getExternalStorageState();
            return Environment.MEDIA_MOUNTED.equals(externalStorageState) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalStorageState);
        }

        public static c b() {
            if (a()) {
                return c.b(Environment.getExternalStorageDirectory());
            }
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a/d$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private File f24542a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private long f24543c;

        public static c b(File file) {
            StatFs statFs;
            c cVar = new c();
            cVar.a(file);
            long blockSize = new StatFs(file.getAbsolutePath()).getBlockSize();
            cVar.a(statFs.getBlockCount() * blockSize);
            cVar.b(statFs.getAvailableBlocks() * blockSize);
            return cVar;
        }

        public File a() {
            return this.f24542a;
        }

        public void a(long j) {
            this.b = j;
        }

        public void a(File file) {
            this.f24542a = file;
        }

        public long b() {
            return this.b;
        }

        public void b(long j) {
            this.f24543c = j;
        }

        public long c() {
            return this.f24543c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }
    }

    /* renamed from: com.tencent.open.a.d$d  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a/d$d.class */
    public static final class C0803d {
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }
}
