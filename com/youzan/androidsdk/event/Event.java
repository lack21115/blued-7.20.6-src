package com.youzan.androidsdk.event;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/Event.class */
public interface Event {
    void call(Context context, String str);

    String subscribe();
}
