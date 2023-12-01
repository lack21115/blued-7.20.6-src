package com.tencent.tmsqmsp.sdk.e;

import android.content.Context;
import com.tencent.mapsdk.internal.oj;
import com.tencent.tmsqmsp.sdk.c.f;
import com.tencent.tmsqmsp.sdk.c.i;
import com.tencent.tmsqmsp.sdk.f.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/e/c.class */
public class c {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/e/c$a.class */
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Context context;
            Context context2;
            try {
                context = oj.getContext();
                if (context == null) {
                    g.d("qp.updTask", 2, "Context is null!");
                    return;
                }
                context2 = oj.getContext();
                com.tencent.tmsqmsp.sdk.d.c cVar = new com.tencent.tmsqmsp.sdk.d.c(context2);
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
