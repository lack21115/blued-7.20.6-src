package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.EmptyCallback;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/ILiveOuterPreviewCoverView.class */
public interface ILiveOuterPreviewCoverView {
    void cancelAutoEnterGuide(boolean z);

    void onShow();

    void release();

    void setCustomBottomView(View view);

    void setOnDislikeCallback(EmptyCallback emptyCallback);

    void stream(String str);
}
