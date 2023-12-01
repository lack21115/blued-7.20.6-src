package com.tencent.qmsp.sdk.e;

import android.content.Context;
import com.tencent.qmsp.sdk.c.f;
import com.tencent.qmsp.sdk.c.h;
import com.tencent.qmsp.sdk.c.i;
import com.tencent.qmsp.sdk.f.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/e/b.class */
public class b {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/e/b$a.class */
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
                    g.d("qmsp.cbid", 2, "Context is null!");
                    return;
                }
                context2 = com.tencent.qmsp.sdk.app.a.getContext();
                h.a(context2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a() {
        f.i().c().postDelayed(new a(), i.f);
    }
}
