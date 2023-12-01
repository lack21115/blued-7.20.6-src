package com.youzan.androidsdk.event;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/EventCenter.class */
public class EventCenter {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Map<String, Event> f1060;

    public EventCenter() {
        this.f1060 = null;
        this.f1060 = new HashMap();
    }

    public boolean dispatch(Context context, String str, String str2) {
        Event event = this.f1060.get(str);
        if (event != null) {
            event.call(context, str2);
            return true;
        }
        return false;
    }

    public List<Event> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f1060.values());
        return arrayList;
    }

    public void subscribe(Event event) {
        if (TextUtils.isEmpty(event.subscribe())) {
            return;
        }
        this.f1060.put(event.subscribe(), event);
    }
}
