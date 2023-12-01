package com.tencent.txcopyrightedmedia.impl.utils;

import com.tencent.txcopyrightedmedia.impl.utils.u;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/v.class */
public final class v extends u {
    public static int d = 8351;
    public static String e = "localhost";
    private List<a> f;
    private AtomicBoolean g;
    private final int h = 3;
    private int i = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/v$a.class */
    public interface a {
        u.n a(String str, String str2, Map<String, String> map);
    }

    public v(List<a> list) {
        this.f40158a = e;
        this.f = list;
        this.g = new AtomicBoolean(false);
    }

    static /* synthetic */ void a(v vVar) {
        vVar.b = d;
        vVar.b();
    }

    static /* synthetic */ int c(v vVar) {
        int i = vVar.i;
        vVar.i = i + 1;
        return i;
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.u
    public final u.n a(u.l lVar) {
        String f = lVar.f();
        String str = f;
        if (f == null) {
            str = "";
        }
        String e2 = lVar.e();
        String str2 = e2;
        if (e2 == null) {
            str2 = "";
        }
        bd bdVar = new bd("", "");
        bdVar.e();
        List<a> list = this.f;
        if (list != null) {
            for (a aVar : list) {
                u.n a2 = aVar.a(str, str2, lVar.b());
                if (a2 != null && a2.f40176a == u.n.c.OK) {
                    return a2;
                }
            }
        }
        ah a3 = ah.a();
        bdVar.p = -6;
        a3.a(bdVar.a(str.toString()));
        return super.a(lVar);
    }

    public final void h() {
        if (a() || !this.g.compareAndSet(false, true)) {
            return;
        }
        new Thread(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.v.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    v.a(v.this);
                } catch (IOException e2) {
                    StringBuilder sb = new StringBuilder("checkAndStart default e = ");
                    while (true) {
                        sb.append(e2.getMessage());
                        ae.b();
                        if (v.this.i >= 3) {
                            break;
                        }
                        v.c(v.this);
                        try {
                            v vVar = v.this;
                            v.d = ad.a(5000, 20000);
                            vVar.b = v.d;
                            vVar.b();
                            new StringBuilder("startWithRandomPort finish randomPort = ").append(v.d);
                            ae.a();
                            break;
                        } catch (IOException e3) {
                            sb = new StringBuilder("checkAndStart random e = ");
                        }
                    }
                }
                v.this.g.set(false);
            }
        }).start();
    }
}
