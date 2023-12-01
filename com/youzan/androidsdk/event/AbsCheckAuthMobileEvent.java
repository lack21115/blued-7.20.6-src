package com.youzan.androidsdk.event;

import android.content.Context;
import com.youzan.androidsdk.YouzanSDK;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsCheckAuthMobileEvent.class */
public abstract class AbsCheckAuthMobileEvent implements Event {
    @Override // com.youzan.androidsdk.event.Event
    public void call(Context context, String str) {
        YouzanSDK.getSDKAdapter().isBoundMobile = true;
    }

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return EventAPI.EVENT_CHECK_AUTH_MOBILE;
    }
}
