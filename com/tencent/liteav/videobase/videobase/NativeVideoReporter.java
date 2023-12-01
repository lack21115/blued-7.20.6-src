package com.tencent.liteav.videobase.videobase;

import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.videobase.h;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/NativeVideoReporter.class */
public class NativeVideoReporter implements IVideoReporter {
    private static final String TAG = "NativeVideoReporter";
    private boolean mIsConsumer;
    private long mNativeVideoReporter;

    public NativeVideoReporter(long j, boolean z) {
        this.mIsConsumer = false;
        this.mNativeVideoReporter = j;
        this.mIsConsumer = z;
    }

    private native void nativeNotifyError(long j, int i, String str);

    private native void nativeNotifyEvent(long j, int i, String str);

    private native void nativeNotifyWarning(long j, int i, String str);

    private native void nativeUpdateKeyStatus(long j, int i, int i2, double d);

    private native void nativeUpdateKeyStatusObject(long j, int i, int i2, Object obj);

    private native void nativeUpdateStatus(long j, int i, double d);

    private native void nativeUpdateStatusObject(long j, int i, Object obj);

    private native void nativeUpdateStatusString(long j, int i, String str);

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public void notifyError(h.a aVar, String str, Object... objArr) {
        synchronized (this) {
            if (this.mNativeVideoReporter != 0) {
                String str2 = "";
                if (str != null) {
                    str2 = "";
                    if (!str.isEmpty()) {
                        str2 = "" + String.format(str, objArr);
                    }
                }
                int a2 = h.a(aVar);
                if (a2 != 0) {
                    nativeNotifyError(this.mNativeVideoReporter, a2, str2);
                    return;
                }
                Log.i(TAG, "notifyError error code:" + aVar + ", do not need transfer to LiteAvCode:" + a2, new Object[0]);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public void notifyEvent(h.b bVar, String str, Object... objArr) {
        synchronized (this) {
            if (this.mNativeVideoReporter != 0) {
                String str2 = "";
                if (str != null) {
                    str2 = "";
                    if (!str.isEmpty()) {
                        str2 = String.format(str, objArr);
                    }
                }
                int a2 = h.a(bVar);
                if (a2 != 0) {
                    if (h.b(bVar)) {
                        nativeNotifyWarning(this.mNativeVideoReporter, a2, str2);
                        return;
                    } else {
                        nativeNotifyEvent(this.mNativeVideoReporter, a2, str2);
                        return;
                    }
                }
                Log.i(TAG, "notifyEvent event code:" + bVar + ", do not need transfer to LiteAvCode:" + a2, new Object[0]);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public void notifyWarning(h.c cVar, String str, Object... objArr) {
        synchronized (this) {
            if (this.mNativeVideoReporter != 0) {
                String str2 = "";
                if (str != null) {
                    str2 = "";
                    if (!str.isEmpty()) {
                        str2 = "" + String.format(str, objArr);
                    }
                }
                int a2 = h.a(cVar);
                if (a2 != 0) {
                    nativeNotifyWarning(this.mNativeVideoReporter, a2, str2);
                    return;
                }
                Log.i(TAG, "notifyWarning warning code:" + cVar + ", do not need transfer to LiteAvCode:" + a2, new Object[0]);
            }
        }
    }

    public void reset() {
        synchronized (this) {
            this.mNativeVideoReporter = 0L;
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public void updateStatus(i iVar, int i, Object obj) {
        synchronized (this) {
            if (this.mNativeVideoReporter != 0) {
                if (iVar.value < i.STATUS_VIDEO_CAPTURE_FRAME.value) {
                    return;
                }
                if (obj instanceof Double) {
                    nativeUpdateKeyStatus(this.mNativeVideoReporter, iVar.value, i, ((Double) obj).doubleValue());
                } else if (obj instanceof Float) {
                    nativeUpdateKeyStatus(this.mNativeVideoReporter, iVar.value, i, ((Float) obj).floatValue());
                } else if (obj instanceof Integer) {
                    nativeUpdateKeyStatus(this.mNativeVideoReporter, iVar.value, i, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    nativeUpdateKeyStatus(this.mNativeVideoReporter, iVar.value, i, ((Long) obj).longValue());
                } else {
                    nativeUpdateKeyStatusObject(this.mNativeVideoReporter, iVar.value, i, obj);
                }
            }
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public void updateStatus(i iVar, Object obj) {
        synchronized (this) {
            if (this.mNativeVideoReporter != 0) {
                if (iVar.value < i.STATUS_VIDEO_CAPTURE_FRAME.value) {
                    return;
                }
                if (obj instanceof Double) {
                    nativeUpdateStatus(this.mNativeVideoReporter, iVar.value, ((Double) obj).doubleValue());
                } else if (obj instanceof Float) {
                    nativeUpdateStatus(this.mNativeVideoReporter, iVar.value, ((Float) obj).floatValue());
                } else if (obj instanceof Long) {
                    nativeUpdateStatus(this.mNativeVideoReporter, iVar.value, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    nativeUpdateStatus(this.mNativeVideoReporter, iVar.value, ((Integer) obj).intValue());
                } else if (obj instanceof String) {
                    nativeUpdateStatusString(this.mNativeVideoReporter, iVar.value, (String) obj);
                } else {
                    nativeUpdateStatusObject(this.mNativeVideoReporter, iVar.value, obj);
                }
            }
        }
    }
}
