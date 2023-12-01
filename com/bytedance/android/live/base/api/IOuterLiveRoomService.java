package com.bytedance.android.live.base.api;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.outer.ILiveProvider;
import com.bytedance.android.live.base.api.push.ILivePush;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/IOuterLiveRoomService.class */
public interface IOuterLiveRoomService {
    Object callExpandMethod(String str, Object... objArr);

    void enterRoomWithDraw();

    ILiveProvider getLiveProvider();

    ILivePush getPushService();

    IBaseHorizontalLiveListView makeFollowListView(Context context, Bundle bundle, ILiveBorderAnimController iLiveBorderAnimController);

    void setEventListener(IEventListener iEventListener);

    void setNeedPersonalRecommend(boolean z);
}
