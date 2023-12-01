package com.bytedance.android.live.base.api;

import android.content.Context;
import android.os.Bundle;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/IOuterLiveService.class */
public interface IOuterLiveService extends IOuterLiveRoomService {
    void enterLiveRoom(Context context, long j, Bundle bundle);

    ILiveOuterPreviewCoverView makePreviewCoverView(Context context, Bundle bundle);

    ILiveOuterPreviewFragment makePreviewFragment();
}
