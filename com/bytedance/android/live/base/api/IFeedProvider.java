package com.bytedance.android.live.base.api;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/IFeedProvider.class */
public interface IFeedProvider extends IService {
    IBaseHorizontalLiveListView getFollowListView(Context context, Bundle bundle, ILiveBorderAnimController iLiveBorderAnimController);
}
