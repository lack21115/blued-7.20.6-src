package com.kwad.components.core.r;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.internal.api.SceneImpl;
import com.uc.crashsdk.export.LogType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/k.class */
public class k {
    private static volatile k PY;
    private boolean PZ = false;
    private o.a Qa;
    public static final String TAG = k.class.getSimpleName();
    private static final String PX = k.class.getName();

    private k() {
    }

    private static boolean a(List<String> list, Class cls) {
        int i = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            for (String str : list) {
                if (cls.getName().contains(str)) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            int i2 = i + 1;
            i = i2;
            if (i2 >= 4) {
                return false;
            }
        }
        return false;
    }

    private boolean a(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                for (String str : list) {
                    if (className.contains(str)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return a(list2, stackTrace);
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str = TAG;
        com.kwad.sdk.core.d.b.d(str, "checkBySuper begin:" + elapsedRealtime);
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                x(elapsedRealtime);
                return false;
            }
            String className = stackTraceElementArr[i2].getClassName();
            if (className != null && aB(className) && aC(className)) {
                try {
                    if (a(list, Class.forName(className).getSuperclass())) {
                        x(elapsedRealtime);
                        return true;
                    }
                } catch (Throwable th) {
                }
                try {
                    if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                        x(elapsedRealtime);
                        return true;
                    }
                } catch (Throwable th2) {
                }
            }
            i = i2 + 1;
        }
    }

    private static boolean aB(String str) {
        return (str.startsWith("android") || str.startsWith(LogType.JAVA_TYPE) || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(PX) || !str.startsWith("androidx")) ? false : true;
    }

    private static boolean aC(String str) {
        return !str.startsWith("com.kwad");
    }

    private static boolean aD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Class.forName(str) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    public static k pP() {
        if (PY == null) {
            synchronized (k.class) {
                try {
                    if (PY == null) {
                        PY = new k();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return PY;
    }

    private void pR() {
        o.a aVar = this.Qa;
        if (aVar == null) {
            return;
        }
        if (!this.PZ && aVar.aef.size() > 0) {
            for (String str : this.Qa.aef) {
                boolean aD = aD(str);
                this.PZ = aD;
                if (aD) {
                    break;
                }
            }
        }
        if (this.PZ) {
            ArrayList arrayList = new ArrayList();
            if (this.Qa.aec.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.Qa.aec.entrySet()) {
                    if (aD(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            com.kwad.components.core.m.a.pb().a(a(this.Qa.aed, this.Qa.aee), arrayList);
        }
    }

    private static void x(long j) {
        String str = TAG;
        com.kwad.sdk.core.d.b.d(str, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
    }

    public final boolean a(SceneImpl sceneImpl, String str) {
        boolean a2 = this.PZ ? a(this.Qa.aed, this.Qa.aee) : false;
        com.kwad.components.core.m.a.pb().a(sceneImpl, a2, str);
        return a2;
    }

    public final void init() {
        o.a aVar = (o.a) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.acm);
        this.Qa = aVar;
        if (aVar != null) {
            pR();
        }
    }

    public final int pQ() {
        o.a aVar = this.Qa;
        if (aVar != null) {
            return aVar.aeg;
        }
        return 0;
    }
}
