package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bg;
import com.kuaishou.weapon.p0.bo;
import com.kuaishou.weapon.p0.bp;
import com.kuaishou.weapon.p0.cj;
import com.kuaishou.weapon.p0.de;
import com.kuaishou.weapon.p0.h;
import java.lang.reflect.Member;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/jni/Engine.class */
public class Engine {
    private static volatile Engine instance;
    public static volatile int loadSoCount = 0;
    public static volatile boolean loadSuccess = false;
    public static volatile String soPath;
    public static volatile String soVersion;

    public static native String abc();

    public static native String bcd();

    public static Engine getInstance(Context context) {
        if (!TextUtils.isEmpty(soVersion) && !loadSuccess && instance == null) {
            synchronized (Engine.class) {
                try {
                    if (instance == null) {
                        instance = new Engine();
                    }
                    h a2 = h.a(context, "re_po_rt");
                    if (!bo.a(context, bp.d + soVersion.replace(".", "") + ".so")) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("l", cj.l);
                        bg.a(context, cj.f10174a, hashMap);
                        loadSuccess = false;
                        return instance;
                    }
                    String b = a2.b(de.f, "");
                    String str = b;
                    if (TextUtils.isEmpty(b)) {
                        str = soVersion;
                        a2.c(de.f, str, false);
                    }
                    loadSoCount = a2.c(de.aY);
                    if (!TextUtils.equals(str, soVersion)) {
                        String str2 = soVersion;
                        loadSoCount = 0;
                        a2.c(de.f, str2, false);
                    }
                    if (loadSoCount + 1 < 10) {
                        loadSoCount++;
                        a2.d(de.aY, loadSoCount);
                        System.loadLibrary(bp.d + soVersion.replace(".", ""));
                        bcd();
                        HashMap hashMap2 = new HashMap();
                        StringBuilder sb = new StringBuilder();
                        sb.append(loadSoCount);
                        hashMap2.put("c", sb.toString());
                        hashMap2.put("v", soVersion);
                        hashMap2.put("l", "s");
                        bg.a(context, "1003001", hashMap2);
                        loadSoCount = 0;
                        loadSuccess = true;
                    }
                    a2.d(de.aY, loadSoCount);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static native int mmo(Member member, int i, int i2);

    public static native int mqc(Member member, int i);

    public static native int off();

    public static native String tao(int i, long j, Object obj);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native String cde();

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native String def();

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    public native String efg();

    public native String eopq(int i, int i2, int i3, String str);

    public native String fgh();

    public native String ghi();

    public native String hij();

    public native String klm(int i, String str);

    public native String nop();

    public native String pqr(int i, int i2, int i3, String str);

    public native String qrs();

    public native String stu(int i, int i2, int i3, int i4, String str);
}
