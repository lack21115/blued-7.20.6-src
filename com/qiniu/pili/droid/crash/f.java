package com.qiniu.pili.droid.crash;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f13790a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f13791c = "placeholder";
    private String d = ".clean.xcrash";
    private String e = ".dirty.xcrash";
    private String f = null;
    private AtomicInteger g = new AtomicInteger();

    /* renamed from: com.qiniu.pili.droid.crash.f$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/f$1.class */
    class AnonymousClass1 implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f13792a;

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f13792a.f13791c);
            sb.append("_");
            return str.startsWith(sb.toString()) && str.endsWith(this.f13792a.d);
        }
    }

    private f() {
    }

    public static f a() {
        if (f13790a == null) {
            f13790a = new f();
        }
        return f13790a;
    }

    private File[] f() {
        return d().listFiles();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        this.b = context;
        this.f = d().getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(File file, i iVar) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            outputStreamWriter.write(iVar.c().toString());
            outputStreamWriter.flush();
            k.a(outputStreamWriter);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        File[] e = e();
        int length = e.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            e[i2].delete();
            i = i2 + 1;
        }
        File[] f = f();
        int length2 = f.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            f[i4].delete();
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c() {
        return this.b.getDir("plcrash_approved", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File d() {
        return this.b.getDir("plcrash_unapproved", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File[] e() {
        return c().listFiles();
    }
}
