package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeUtils.class */
public class WeUtils {
    private static <T> Class<T> a(Type type) {
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        } else if (!(type instanceof Class)) {
            return null;
        }
        return (Class) type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean a(WeReq.Callback<T> callback) {
        try {
            return !callback.getClass().getMethod("onSuccess", WeReq.class, Object.class).isAnnotationPresent(OnNetThread.class);
        } catch (NoSuchMethodException e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean b(WeReq.Callback<T> callback) {
        try {
            return !callback.getClass().getMethod("onFailed", WeReq.class, WeReq.ErrType.class, Integer.TYPE, String.class, IOException.class).isAnnotationPresent(OnNetThread.class);
        } catch (NoSuchMethodException e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean c(WeReq.Callback<T> callback) {
        try {
            return !callback.getClass().getMethod("onFinish", new Class[0]).isAnnotationPresent(OnNetThread.class);
        } catch (NoSuchMethodException e) {
            return true;
        }
    }

    public static <T> Class<T> getClassOfReturn(WeReq.Callback<T> callback) {
        return a(getTypeOfReturn(callback));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r3 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
        r0 = r0.getGenericSuperclass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
        r3 = r0;
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
        if ((r3 instanceof java.lang.Class) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
        r0 = ((java.lang.Class) r3).getGenericSuperclass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a8, code lost:
        return ((java.lang.reflect.ParameterizedType) r6).getActualTypeArguments()[0];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> java.lang.reflect.Type getTypeOfReturn(com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback<T> r3) {
        /*
            r0 = r3
            java.lang.Class r0 = r0.getClass()
            r7 = r0
            r0 = 0
            r3 = r0
            r0 = r7
            r6 = r0
        Lb:
            r0 = r6
            java.lang.reflect.Type[] r0 = r0.getGenericInterfaces()
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L83
            r0 = r9
            int r0 = r0.length
            if (r0 != 0) goto L1f
            goto L83
        L1f:
            r0 = r9
            int r0 = r0.length
            r5 = r0
            r0 = 0
            r4 = r0
        L25:
            r0 = r4
            r1 = r5
            if (r0 >= r1) goto L72
            r0 = r9
            r1 = r4
            r0 = r0[r1]
            r8 = r0
            r0 = r8
            boolean r0 = r0 instanceof java.lang.Class
            if (r0 == 0) goto L45
            r0 = r8
            java.lang.Class<com.tencent.cloud.huiyansdkface.wehttp2.WeReq$Callback> r1 = com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback.class
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L45
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            return r0
        L45:
            r0 = r8
            boolean r0 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r0 != 0) goto L50
            goto L6b
        L50:
            java.lang.Class<com.tencent.cloud.huiyansdkface.wehttp2.WeReq$Callback> r0 = com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback.class
            r1 = r8
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
            java.lang.reflect.Type r1 = r1.getRawType()
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 != 0) goto L68
            goto L6b
        L68:
            r0 = r8
            r3 = r0
        L6b:
            r0 = r4
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
            goto L25
        L72:
            r0 = r3
            if (r0 == 0) goto L7b
            r0 = r3
            r6 = r0
            goto L9d
        L7b:
            r0 = r6
            java.lang.Class r0 = r0.getSuperclass()
            r6 = r0
            goto Lb
        L83:
            r0 = r7
            java.lang.reflect.Type r0 = r0.getGenericSuperclass()
            r3 = r0
        L89:
            r0 = r3
            r6 = r0
            r0 = r3
            boolean r0 = r0 instanceof java.lang.Class
            if (r0 == 0) goto L9d
            r0 = r3
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.reflect.Type r0 = r0.getGenericSuperclass()
            r3 = r0
            goto L89
        L9d:
            r0 = r6
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type[] r0 = r0.getActualTypeArguments()
            r1 = 0
            r0 = r0[r1]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.wehttp2.WeUtils.getTypeOfReturn(com.tencent.cloud.huiyansdkface.wehttp2.WeReq$Callback):java.lang.reflect.Type");
    }

    public static String sha1hex2pin(String str) {
        return "sha1/" + ByteString.decodeHex(str.replaceAll("\\s+", "")).base64();
    }

    public static String sha256hex2pin(String str) {
        return "sha256/" + ByteString.decodeHex(str.replaceAll("\\s+", "")).base64();
    }
}
