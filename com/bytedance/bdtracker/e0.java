package com.bytedance.bdtracker;

import com.bytedance.applog.IEventObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e0.class */
public class e0 implements IEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArraySet<IEventObserver> f7605a = new CopyOnWriteArraySet<>();

    public void a(IEventObserver iEventObserver) {
        if (iEventObserver != null) {
            this.f7605a.add(iEventObserver);
        }
    }

    public void b(IEventObserver iEventObserver) {
        if (iEventObserver != null) {
            this.f7605a.remove(iEventObserver);
        }
    }

    @Override // com.bytedance.applog.IEventObserver
    public void onEvent(String str, String str2, String str3, long j, long j2, String str4) {
        Iterator<IEventObserver> it = this.f7605a.iterator();
        while (it.hasNext()) {
            it.next().onEvent(str, str2, str3, j, j2, str4);
        }
    }

    @Override // com.bytedance.applog.IEventObserver
    public void onEventV3(String str, JSONObject jSONObject) {
        Iterator<IEventObserver> it = this.f7605a.iterator();
        while (it.hasNext()) {
            it.next().onEventV3(str, jSONObject);
        }
    }
}
