package com.tencent.turingface.sdk.mfa;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/TNative$aa.class */
public class TNative$aa {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/TNative$aa$bb.class */
    public static class bb implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static native SparseArray<Object> a77(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Map<Integer, String> map2, int i);

    public static native SparseArray<Object> b77(SparseArray<Object> sparseArray, byte[] bArr, Map<String, String> map, int i);

    public static native SparseArray<Object> c77(SparseArray<Object> sparseArray, Context context);

    public static native SparseArray<Object> d77(SparseArray<Object> sparseArray, Context context, int i);

    public static native SparseArray<Object> e77(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

    public static native SparseArray<Object> f77(SparseArray<Object> sparseArray, byte[] bArr, int i);

    public static native SparseArray<Object> g77(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

    public static native SparseArray<Object> h77(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

    public static native SparseArray<Object> i77(SparseArray<Object> sparseArray, Context context, Map<String, String> map);
}
