package com.bytedance.android.live.base.api.outer;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/outer/ILiveStatusListener.class */
public interface ILiveStatusListener {
    void onError(String str);

    void onFirstFrame();

    void onLiveStatusChange(boolean z);

    void onPrepare();

    void onVideoSizeChanged(int i, int i2);
}
