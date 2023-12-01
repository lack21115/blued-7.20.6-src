package com.igexin.push.core.i;

import android.content.Intent;
import com.igexin.push.core.e;
import com.igexin.sdk.PushActivity;
import com.tencent.open.GameAppOperation;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/i/b.class */
public final class b {
    private static b b;

    /* renamed from: a  reason: collision with root package name */
    private Map<Long, a> f9954a = new HashMap();

    private b() {
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    private void b(a aVar) {
        if (aVar != null) {
            if (aVar != null) {
                this.f9954a.put(aVar.a(), aVar);
            }
            Intent intent = new Intent(e.l, PushActivity.class);
            intent.putExtra(GameAppOperation.SHARE_PRIZE_ACTIVITY_ID, aVar.a());
            intent.setFlags(268435456);
            e.l.startActivity(intent);
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            this.f9954a.put(aVar.a(), aVar);
        }
    }

    public final a a(Long l) {
        return this.f9954a.get(l);
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.f9954a.remove(aVar.a());
        }
    }
}
