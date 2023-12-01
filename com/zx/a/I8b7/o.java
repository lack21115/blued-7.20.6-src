package com.zx.a.I8b7;

import android.content.Context;
import com.zx.module.annotation.Java2C;
import com.zx.module.base.ZXModule;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f28461a = a();

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/o$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final o f28462a = new o();
    }

    @Java2C.Method2C
    private native ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0086, code lost:
        throw new java.io.FileNotFoundException("Failed to ensure directory: " + r8.getAbsolutePath());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.File r8, java.io.File r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.o.a(java.io.File, java.io.File):void");
    }

    @Java2C.Method2C
    private native String[] a();

    @Java2C.Method2C
    private native ZXModule b(Context context);

    @Java2C.Method2C
    public native ZXModule a(Context context);
}
