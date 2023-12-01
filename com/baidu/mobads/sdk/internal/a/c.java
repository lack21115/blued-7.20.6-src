package com.baidu.mobads.sdk.internal.a;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/a/c.class */
class c implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f9295a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, a aVar) {
        this.b = bVar;
        this.f9295a = aVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || !b.e.equals(iOAdEvent.getType()) || (data = iOAdEvent.getData()) == null || data.isEmpty()) {
            return;
        }
        Object obj = data.get("e_t");
        Object obj2 = data.get("e_n");
        Object obj3 = data.get("e_a");
        if ((obj instanceof String) && (obj2 instanceof String)) {
            Object[] objArr = null;
            if (obj3 instanceof Object[]) {
                objArr = (Object[]) obj3;
            }
            data.put("e_r", this.f9295a.handleEvent((String) obj, (String) obj2, objArr));
        }
    }
}
