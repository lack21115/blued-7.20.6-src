package com.youzan.androidsdk.event;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsAuthEvent.class */
public abstract class AbsAuthEvent implements Event {
    @Override // com.youzan.androidsdk.event.Event
    public final void call(Context context, String str) {
        call(context, EventAPI.SIGN_NEED_LOGIN.equals(str));
    }

    public abstract void call(Context context, boolean z);

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return "getUserInfo";
    }
}
