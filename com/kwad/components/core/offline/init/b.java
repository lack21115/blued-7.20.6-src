package com.kwad.components.core.offline.init;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.offline.init.kwai.g;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.utils.aw;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/init/b.class */
public final class b {
    private static final AtomicBoolean Ip = new AtomicBoolean();

    @ForInvoker(methodId = "initOC")
    public static void af(Context context) {
        com.kwad.components.offline.adLive.a.ak(context);
        com.kwad.components.offline.obiwan.a.ak(context);
        com.kwad.components.offline.tk.b.ak(context);
    }

    public static void init(final Context context) {
        if (Ip.get()) {
            return;
        }
        Ip.set(true);
        OfflineHostProvider.get().init(context, new g());
        com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.components.core.offline.init.b.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                b.af(Context.this);
            }
        });
    }
}
