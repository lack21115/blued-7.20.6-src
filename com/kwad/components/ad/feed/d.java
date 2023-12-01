package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.utils.bi;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/d.class */
public final class d {
    private static com.kwad.sdk.core.f.d ef;
    private static Vibrator eg;
    private static List<a> eh = new CopyOnWriteArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/d$a.class */
    public static final class a {
        private b ej;
        private Context mContext;

        public a(b bVar, Context context) {
            this.ej = bVar;
            this.mContext = context;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/d$b.class */
    public interface b {
        boolean b(double d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Vibrator F(Context context) {
        if (eg == null) {
            eg = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
        return eg;
    }

    private static void a(float f, Context context) {
        ef = new com.kwad.sdk.core.f.d(f);
        eh = new CopyOnWriteArrayList();
        ef.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.feed.d.1
            @Override // com.kwad.sdk.core.f.b
            public final void a(double d) {
                if (d.eh != null) {
                    Iterator it = d.eh.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a aVar = (a) it.next();
                        if (aVar.ej != null && aVar.ej.b(d)) {
                            bi.a(aVar.mContext, d.F(aVar.mContext));
                            break;
                        }
                    }
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.feed.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("KSFeedShakeManager", "onShakeEvent openGate2");
                            d.ef.xD();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        ef.e(f);
        ef.aX(context);
    }

    public static void a(float f, Context context, b bVar) {
        if (ef == null) {
            a(f, context);
        }
        eh.add(new a(bVar, context));
    }

    public static void a(b bVar) {
        for (a aVar : eh) {
            if (aVar.ej == bVar) {
                eh.remove(aVar);
            }
        }
        com.kwad.sdk.core.d.b.d("KSFeedShakeManager", "sShakeItems size " + eh.size());
    }
}
