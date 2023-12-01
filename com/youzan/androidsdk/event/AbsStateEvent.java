package com.youzan.androidsdk.event;

import android.content.Context;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsStateEvent.class */
public abstract class AbsStateEvent implements Event {
    public abstract void call(Context context);

    @Override // com.youzan.androidsdk.event.Event
    public final void call(Context context, String str) {
        call(context);
    }

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return "webReady";
    }
}
