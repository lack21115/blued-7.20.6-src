package com.tencent.tendinsv.tool;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.tendinsv.listener.SwitchNetworkCallbacks;
import com.tencent.tendinsv.utils.s;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/n.class */
public class n extends b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile n f25401a;
    private SwitchNetworkCallbacks b;

    public static b a() {
        if (f25401a == null) {
            synchronized (n.class) {
                try {
                    if (f25401a == null) {
                        f25401a = new n();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25401a;
    }

    private ZipEntry a(ZipFile zipFile) {
        if (b() == null || b().length <= 0) {
            return null;
        }
        String[] b = b();
        int length = b.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            String str = b[i2];
            ZipEntry entry = zipFile.getEntry("lib/" + str + "/libShanYCore.so");
            com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.J, " _CUPABI=", str);
            if (entry != null) {
                com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.J, "ExistSoFile_ABI=", str);
                return entry;
            }
            i = i2 + 1;
        }
    }

    private String[] b() {
        return Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    @Override // com.tencent.tendinsv.tool.b
    public void a(Context context, long j, long j2, long j3) {
        this.b = new com.tencent.tendinsv.c.f(context);
        try {
            if (com.tencent.tendinsv.utils.c.a(context, null) && com.tencent.tendinsv.utils.c.a(context) && a(context)) {
                s.n(context);
                this.b.switchSuccessed(1, 1, "check_success", "check_success", 1, j, j2, j3);
            }
        } catch (Throwable th) {
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "check_failed==", th.getMessage());
            this.b.switchFailed(0, 0, "check_failed", "check_failed", 1, j, j2, j3);
        }
    }

    public boolean a(Context context) {
        boolean z = true;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && applicationInfo.sourceDir != null) {
                if (a(new ZipFile(applicationInfo.sourceDir)) != null) {
                    return z;
                }
                com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.J, "not_Exist_SoFile");
            }
            z = false;
            return z;
        } catch (Exception e) {
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "isExistSoFile=", e.getMessage());
            return false;
        }
    }
}
