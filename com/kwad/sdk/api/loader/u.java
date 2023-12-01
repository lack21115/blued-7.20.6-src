package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.m;
import com.umeng.analytics.pro.bh;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/u.class */
public final class u {
    private static final AtomicBoolean aaE = new AtomicBoolean();

    public static void a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (com.kwad.sdk.api.c.tj() || aaE.get() || context == null || iKsAdSDK == null) {
            return;
        }
        aaE.set(true);
        com.kwad.sdk.api.kwai.a.submit(new Runnable() { // from class: com.kwad.sdk.api.loader.u.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (Math.abs(System.currentTimeMillis() - t.s(Context.this, "lastUpdateTime")) < t.s(Context.this, bh.aX) * 1000) {
                        return;
                    }
                    m.tu().a(new v() { // from class: com.kwad.sdk.api.loader.u.1.1
                        @Override // com.kwad.sdk.api.loader.v
                        public final Context getContext() {
                            return Context.this;
                        }

                        @Override // com.kwad.sdk.api.loader.v
                        public final String tx() {
                            return u.access$000();
                        }

                        @Override // com.kwad.sdk.api.loader.v
                        public final IKsAdSDK ty() {
                            return iKsAdSDK;
                        }
                    }, new m.c<Boolean>() { // from class: com.kwad.sdk.api.loader.u.1.2
                        private static void a(Boolean bool) {
                            new StringBuilder("onNewResult: ").append(bool);
                        }

                        @Override // com.kwad.sdk.api.loader.m.c
                        public final /* synthetic */ void b(Boolean bool) {
                            a(bool);
                        }
                    });
                } catch (Throwable th) {
                }
            }
        });
    }

    static /* synthetic */ String access$000() {
        return tw();
    }

    public static void au(Context context) {
        g.h(context, "");
    }

    private static String tw() {
        String aZ = com.kwad.sdk.api.c.aZ("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(aZ) ? aZ : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }
}
