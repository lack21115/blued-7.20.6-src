package com.kwai.sodler.lib.kwai;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.kwad.sdk.utils.q;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.h;
import com.kwai.sodler.lib.kwai.kwai.b;
import java.io.File;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/kwai/a.class */
public final class a extends h {
    private b aKd;
    private Resources aKe;

    public a(String str) {
        super(str);
    }

    private File af(File file) {
        File file2 = new File(file.getParentFile(), this.aJN.JR());
        q.S(file2);
        return file2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r10.canWrite() == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwai.sodler.lib.kwai.kwai.b g(java.io.File r10, java.io.File r11) {
        /*
            r9 = this;
            r0 = r10
            r12 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L36
            r0 = r10
            boolean r0 = r0.canRead()
            if (r0 != 0) goto L17
            r0 = r10
            r1 = 1
            boolean r0 = r0.setReadable(r1)
        L17:
            r0 = r10
            boolean r0 = r0.canWrite()
            if (r0 != 0) goto L24
            r0 = r10
            r1 = 1
            boolean r0 = r0.setWritable(r1)
        L24:
            r0 = r10
            boolean r0 = r0.canRead()
            if (r0 == 0) goto L34
            r0 = r10
            r12 = r0
            r0 = r10
            boolean r0 = r0.canWrite()
            if (r0 != 0) goto L36
        L34:
            r0 = 0
            r12 = r0
        L36:
            com.kwai.sodler.lib.kwai.kwai.b r0 = new com.kwai.sodler.lib.kwai.kwai.b
            r1 = r0
            com.kwai.sodler.lib.kwai.kwai.a r2 = new com.kwai.sodler.lib.kwai.kwai.a
            r3 = r2
            r4 = r9
            java.lang.Class r4 = r4.getClass()
            java.lang.ClassLoader r4 = r4.getClassLoader()
            dalvik.system.BaseDexClassLoader r4 = (dalvik.system.BaseDexClassLoader) r4
            r3.<init>(r4)
            r3 = r11
            java.lang.String r3 = r3.getAbsolutePath()
            r4 = r12
            r5 = r9
            java.io.File r5 = r5.aKl
            java.lang.String r5 = r5.getAbsolutePath()
            r6 = r9
            com.kwai.sodler.lib.c.b r6 = r6.aKr
            java.util.List<java.lang.String> r6 = r6.aLb
            r7 = r9
            com.kwai.sodler.lib.c.b r7 = r7.aKr
            java.util.List<java.lang.String> r7 = r7.aLa
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.sodler.lib.kwai.a.g(java.io.File, java.io.File):com.kwai.sodler.lib.kwai.kwai.b");
    }

    public final b Jv() {
        return this.aKd;
    }

    @Override // com.kwai.sodler.lib.h, com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public final void as(Context context, String str) {
        super.as(context, str);
        File file = new File(str);
        try {
            this.aKd = g(af(file), file);
            try {
                this.aKe = com.kwai.sodler.lib.kwai.a.a.a(context, context.getResources(), str);
                StringBuilder sb = new StringBuilder("Install plugin mClassLoader: ");
                sb.append(this.aKd);
                sb.append(", mResources: ");
                sb.append(this.aKe);
            } catch (Exception e) {
                Log.getStackTraceString(e);
                throw new PluginError.LoadError(e, 4006);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4002);
        }
    }

    public final Resources getResources() {
        return this.aKe;
    }
}
