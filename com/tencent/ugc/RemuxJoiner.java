package com.tencent.ugc;

import android.content.ContentResolver;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.List;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/RemuxJoiner.class */
public class RemuxJoiner {
    private static final String TAG = "RemuxJoiner";
    private RemuxJoinerListener mListener;
    private long mNativeHandle;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/RemuxJoiner$RemuxJoinerListener.class */
    public interface RemuxJoinerListener {
        void onRemuxJoinerComplete(int i, String str);

        void onRemuxJoinerProgress(float f);
    }

    public static boolean isConcatableWithoutReencode(List<String> list) {
        if (list.size() < 2) {
            return true;
        }
        String str = list.get(0);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return true;
            }
            if (!nativeIsConcatableWithoutReencode(str, list.get(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static native long nativeCreate(RemuxJoiner remuxJoiner);

    private static native void nativeDestroy(long j);

    private static native boolean nativeIsConcatableWithoutReencode(String str, String str2);

    private static native boolean nativeSetSourcePaths(long j, Object[] objArr);

    private static native boolean nativeSetTargetPath(long j, String str);

    private static native boolean nativeStart(long j);

    private static native void nativeStop(long j);

    private void onComplete(int i, String str) {
        RemuxJoinerListener remuxJoinerListener = this.mListener;
        if (remuxJoinerListener != null) {
            remuxJoinerListener.onRemuxJoinerComplete(i, str);
        }
    }

    private void onProgress(float f) {
        RemuxJoinerListener remuxJoinerListener = this.mListener;
        if (remuxJoinerListener != null) {
            remuxJoinerListener.onRemuxJoinerProgress(f);
        }
    }

    public void initialize() {
        LiteavLog.i(TAG, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        if (this.mNativeHandle != 0) {
            LiteavLog.w(TAG, "RemuxJoiner is already initialize!");
        }
        this.mNativeHandle = nativeCreate(this);
    }

    public boolean setSourcePaths(List<String> list) {
        long j = this.mNativeHandle;
        if (j == 0) {
            LiteavLog.w(TAG, "RemuxJoiner is not initialize");
            return false;
        }
        return nativeSetSourcePaths(j, list.toArray());
    }

    public boolean setTargetPath(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            LiteavLog.w(TAG, "RemuxJoiner is not initialize");
            return false;
        }
        return nativeSetTargetPath(j, str);
    }

    public void setVideoJoinerListener(RemuxJoinerListener remuxJoinerListener) {
        this.mListener = remuxJoinerListener;
    }

    public boolean start() {
        long j = this.mNativeHandle;
        if (j == 0) {
            LiteavLog.w(TAG, "RemuxJoiner is not initialize");
            return false;
        } else if (nativeStart(j)) {
            return true;
        } else {
            LiteavLog.e(TAG, "native RemuxJoiner start failed.");
            return false;
        }
    }

    public void stop() {
        long j = this.mNativeHandle;
        if (j == 0) {
            LiteavLog.w(TAG, "RemuxJoiner is not initialize");
        } else {
            nativeStop(j);
        }
    }

    public void uninitialize() {
        LiteavLog.i(TAG, "unInitialize");
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeHandle = 0L;
        }
    }
}
