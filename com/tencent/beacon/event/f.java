package com.tencent.beacon.event;

import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/f.class */
public final class f implements Callback<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Long> f21362a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21363c;
    private long d = new Date().getTime();
    private g e;
    private String f;
    private com.tencent.beacon.event.a.a g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar, String str, com.tencent.beacon.event.a.a aVar, Set<Long> set, String str2) {
        this.e = gVar;
        this.f = str;
        this.g = aVar;
        this.f21362a = new HashSet(set);
        this.b = "[EventReport(" + str + ")]";
        this.f21363c = str2;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(byte[] bArr) {
        com.tencent.beacon.base.util.c.a(this.b, 3, "report success! sendingID will delete this time's IDs. offer task: %s! ", Boolean.valueOf(((EventModule) com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT)).d().a(new e(this, new Date().getTime() - this.d))));
        if (this.f21362a.size() >= this.e.a()) {
            com.tencent.beacon.a.b.a.a().a(this.e);
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        com.tencent.beacon.base.util.c.a(this.b, 3, "send failure reason: %s. LogID: %s.", dVar.toString(), this.f21363c);
        this.e.a(this.f21362a);
    }
}
