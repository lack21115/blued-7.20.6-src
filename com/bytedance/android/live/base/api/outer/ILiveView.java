package com.bytedance.android.live.base.api.outer;

import android.view.View;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/outer/ILiveView.class */
public interface ILiveView {
    View getView();

    void openLive();

    void release();

    void setLiveStatusListener(ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z);

    void show();

    void stream();
}
