package com.xiaomi.push;

import com.xiaomi.push.ai;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ak.class */
public class ak extends ai.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f41250a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ai aiVar, ai.a aVar) {
        super(aVar);
        this.f41250a = aiVar;
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        Object obj;
        Map map;
        obj = this.f41250a.f173a;
        synchronized (obj) {
            map = this.f41250a.f174a;
            map.remove(this.f41248a.mo11550a());
        }
    }
}
