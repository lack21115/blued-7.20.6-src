package android.util;

import com.igexin.push.core.b;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/util/DebugUtils.class */
public class DebugUtils {
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r0.isEmpty() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void buildShortClassTag(java.lang.Object r4, java.lang.StringBuilder r5) {
        /*
            r0 = r4
            if (r0 != 0) goto Lc
            r0 = r5
            java.lang.String r1 = "null"
            java.lang.StringBuilder r0 = r0.append(r1)
            return
        Lc:
            r0 = r4
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L25
            r0 = r8
            r7 = r0
            r0 = r8
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L46
        L25:
            r0 = r4
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r8 = r0
            r0 = r8
            r1 = 46
            int r0 = r0.lastIndexOf(r1)
            r6 = r0
            r0 = r8
            r7 = r0
            r0 = r6
            if (r0 <= 0) goto L46
            r0 = r8
            r1 = r6
            r2 = 1
            int r1 = r1 + r2
            java.lang.String r0 = r0.substring(r1)
            r7 = r0
        L46:
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = 123(0x7b, float:1.72E-43)
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r4
            int r1 = java.lang.System.identityHashCode(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.util.DebugUtils.buildShortClassTag(java.lang.Object, java.lang.StringBuilder):void");
    }

    public static boolean isObjectSelected(Object obj) {
        boolean z;
        Method declaredMethod;
        boolean z2 = false;
        String str = System.getenv("ANDROID_OBJECT_FILTER");
        boolean z3 = false;
        if (str != null) {
            z3 = false;
            if (str.length() > 0) {
                String[] split = str.split("@");
                z3 = false;
                if (obj.getClass().getSimpleName().matches(split[0])) {
                    int i = 1;
                    while (true) {
                        z3 = z2;
                        if (i >= split.length) {
                            break;
                        }
                        String[] split2 = split[i].split("=");
                        Class<?> cls = obj.getClass();
                        Class<? super Object> cls2 = cls;
                        do {
                            try {
                                declaredMethod = cls2.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET + split2[0].substring(0, 1).toUpperCase(Locale.ROOT) + split2[0].substring(1), null);
                                cls2 = cls.getSuperclass();
                                if (cls2 == null) {
                                    break;
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                                z = z2;
                            } catch (NoSuchMethodException e2) {
                                e2.printStackTrace();
                                z = z2;
                            } catch (InvocationTargetException e3) {
                                e3.printStackTrace();
                                z = z2;
                            }
                        } while (declaredMethod == null);
                        z = z2;
                        if (declaredMethod != null) {
                            Object invoke = declaredMethod.invoke(obj, null);
                            z = z2 | (invoke != null ? invoke.toString() : b.l).matches(split2[1]);
                        }
                        i++;
                        z2 = z;
                    }
                }
            }
        }
        return z3;
    }
}
