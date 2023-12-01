package com.tencent.qmsp.sdk.e;

import android.content.Context;
import com.tencent.qmsp.sdk.c.f;
import com.tencent.qmsp.sdk.c.i;
import com.tencent.qmsp.sdk.f.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/e/c.class */
public class c {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/e/c$a.class */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            Context context2;
            try {
                context = com.tencent.qmsp.sdk.app.a.getContext();
                if (context == null) {
                    g.d("qp.updTask", 2, "Context is null!");
                    return;
                }
                context2 = com.tencent.qmsp.sdk.app.a.getContext();
                com.tencent.qmsp.sdk.d.c cVar = new com.tencent.qmsp.sdk.d.c(context2);
                f.i().a(cVar);
                cVar.a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a() {
        f.i().c().postDelayed(new a(), i.e);
    }
}
