package com.bytedance.android.live.base.api.push;

import com.bytedance.android.live.base.api.push.model.PushData;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/push/PushCallback.class */
public interface PushCallback {
    void onFailed(Throwable th);

    void onSuccess(PushData pushData);
}
