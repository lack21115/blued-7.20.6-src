package com.tencent.mapsdk.internal;

import com.tencent.tmsbeacon.base.net.call.Callback;
import com.tencent.tmsbeacon.module.EventModule;
import com.tencent.tmsbeacon.module.ModuleName;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/lj.class */
public final class lj implements Callback<byte[]> {
    private final Set<Long> b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37623c;
    private final String d;
    private com.tencent.tmsbeacon.event.g e;
    private String f;
    private com.tencent.tmsbeacon.event.a.a g;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/lj$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder();
            for (Long l : lj.this.b) {
                sb.append(l);
                sb.append(",");
            }
            com.tencent.tmsbeacon.base.util.c.a(lj.this.f37623c, 4, "delete: %s", Boolean.valueOf(lj.this.g.a(lj.this.f, sb.substring(0, sb.lastIndexOf(",")))));
            lj.this.e.a(lj.this.b);
        }
    }

    public lj(com.tencent.tmsbeacon.event.g gVar, String str, com.tencent.tmsbeacon.event.a.a aVar, Set<Long> set, String str2) {
        this.e = gVar;
        this.f = str;
        this.g = aVar;
        this.b = new HashSet(set);
        this.f37623c = "[EventReport(" + str + ")]";
        this.d = str2;
    }

    @Override // com.tencent.tmsbeacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(byte[] bArr) {
        com.tencent.tmsbeacon.base.util.c.a(this.f37623c, 3, "report success! sendingID will delete this time's IDs. offer task: %s! ", Boolean.valueOf(((EventModule) com.tencent.tmsbeacon.a.c.c.d().a(ModuleName.EVENT)).c().a(new a())));
        if (this.b.size() >= this.e.a()) {
            com.tencent.tmsbeacon.a.b.a.a().a(this.e);
        }
    }

    @Override // com.tencent.tmsbeacon.base.net.call.Callback
    public void onFailure(com.tencent.tmsbeacon.base.net.d dVar) {
        com.tencent.tmsbeacon.base.util.c.a(this.f37623c, 3, "send failure reason: %s. LogID: %s.", dVar.toString(), this.d);
        this.e.a(this.b);
    }
}
