package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/u.class */
public abstract class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f41711a;

    /* renamed from: a  reason: collision with other field name */
    private File f1092a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f1093a;

    private u(Context context, File file) {
        this.f41711a = context;
        this.f1092a = file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(Context context, File file, v vVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new v(context, file, runnable).run();
    }

    protected abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        t tVar = null;
        t tVar2 = null;
        try {
            try {
                if (this.f1092a == null) {
                    this.f1092a = new File(this.f41711a.getFilesDir(), "default_locker");
                }
                t a2 = t.a(this.f41711a, this.f1092a);
                if (this.f1093a != null) {
                    this.f1093a.run();
                }
                tVar = a2;
                tVar2 = a2;
                a(this.f41711a);
                if (a2 != null) {
                    a2.a();
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (tVar2 != null) {
                    tVar2.a();
                }
            }
        } catch (Throwable th) {
            if (tVar != null) {
                tVar.a();
            }
            throw th;
        }
    }
}
