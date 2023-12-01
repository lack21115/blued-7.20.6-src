package com.zx.a.I8b7;

import android.content.Context;
import android.os.Handler;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/x.class */
public class x implements d0 {
    public static Map<File, Handler> d = new ConcurrentHashMap();
    public static Map<File, SecretKey> e = new ConcurrentHashMap();
    public static Map<File, IvParameterSpec> f = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public File f28534a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public Context f28535c;

    public x(Context context) {
        this.f28535c = context.getApplicationContext();
        this.b = context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()) + ".log";
        this.f28534a = new File("sdcard/libs", this.b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0104, code lost:
        if (((java.util.concurrent.ConcurrentHashMap) com.zx.a.I8b7.x.f).get(r7.f28534a) == null) goto L14;
     */
    @Override // com.zx.a.I8b7.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.x.a(int, java.lang.String, java.lang.String):void");
    }
}
