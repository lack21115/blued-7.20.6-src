package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.jh  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jh.class */
public final class jh {

    /* renamed from: com.amap.api.col.3sl.jh$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jh$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static jh f5209a = new jh();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.p0003sl.ia a(java.lang.String r4, java.util.List<com.amap.api.col.p0003sl.ia> r5) {
        /*
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L9
            r0 = 0
            return r0
        L9:
            r0 = 0
            r6 = r0
        Lb:
            r0 = r5
            if (r0 == 0) goto L60
            r0 = r6
            r1 = r5
            int r1 = r1.size()
            if (r0 >= r1) goto L60
            r0 = r5
            r1 = r6
            java.lang.Object r0 = r0.get(r1)
            com.amap.api.col.3sl.ia r0 = (com.amap.api.col.p0003sl.ia) r0
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L59
            r0 = r8
            java.lang.String[] r0 = r0.f()
            r9 = r0
            r0 = 0
            r7 = r0
        L33:
            r0 = r7
            r1 = r9
            int r1 = r1.length
            if (r0 >= r1) goto L59
            r0 = r9
            r1 = r6
            r0 = r0[r1]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L52
            r0 = r4
            r1 = r9
            r2 = r7
            r1 = r1[r2]
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L52
            r0 = r8
            return r0
        L52:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L33
        L59:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto Lb
        L60:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.jh.a(java.lang.String, java.util.List):com.amap.api.col.3sl.ia");
    }

    private static JSONArray a(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        JSONArray jSONArray = new JSONArray();
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread != null && !str2.equals(thread.getName())) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < 6) {
                        String str3 = new String[]{"AMapPboRenderThread", "GLThread", "AMapGlRenderThread", "AMapThreadUtil", "GNaviMap", "main"}[i2];
                        String name = thread.getName();
                        if (((TextUtils.isEmpty(str3) || TextUtils.isEmpty(name) || (!str3.contains(name) && !name.contains(str3))) ? false : true) && a(thread) != null) {
                            jSONArray.put(a(thread));
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject a(Thread thread) {
        if (thread == null || thread.getStackTrace() == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("threadName", thread.getName());
            jSONObject.put("threadGroup", thread.getThreadGroup());
            StringBuffer stringBuffer = new StringBuffer();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    jSONObject.put("stacks", stringBuffer.toString());
                    return jSONObject;
                }
                stringBuffer.append(stackTrace[i2]);
                stringBuffer.append("<br />");
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    public static boolean a(Context context, String str, String str2, List<ia> list, boolean z, ia iaVar) {
        String str3 = "";
        if (str2 != null) {
            for (Thread thread : Thread.getAllStackTraces().keySet()) {
                if (thread != null && !TextUtils.isEmpty(thread.getName()) && (str2.contains(thread.getName()) || thread.getName().contains(str2))) {
                    StackTraceElement[] stackTrace = thread.getStackTrace();
                    if (stackTrace != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        int length = stackTrace.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            StackTraceElement stackTraceElement = stackTrace[i2];
                            stringBuffer.append("at ");
                            stringBuffer.append(stackTraceElement);
                            stringBuffer.append("<br />");
                            i = i2 + 1;
                        }
                        str3 = stringBuffer.toString();
                    }
                }
            }
            str3 = null;
        }
        ia a2 = a(str3, list);
        if (z && a2 == null) {
            return false;
        }
        String str4 = str + "<br />" + str3;
        JSONArray a3 = a(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashStack", str4);
            jSONObject.put("backStacks", a3);
        } catch (Throwable th) {
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return false;
        }
        try {
            if (z || a2 != null) {
                iw.a(context, a2, jSONObject2, "NATIVE_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
                return true;
            }
            iw.b(context, iaVar, jSONObject2, "NATIVE_APP_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
            return true;
        } catch (Throwable th2) {
            return true;
        }
    }
}
