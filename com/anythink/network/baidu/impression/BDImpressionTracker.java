package com.anythink.network.baidu.impression;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.anythink.network.baidu.impression.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/BDImpressionTracker.class */
public class BDImpressionTracker {

    /* renamed from: a  reason: collision with root package name */
    private static final int f8904a = 100;
    private final b b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<View, BDImpressionInterface> f8905c;
    private final Map<View, com.anythink.network.baidu.impression.a<BDImpressionInterface>> d;
    private final Handler e;
    private final a f;
    private final b.C0173b g;
    private b.d h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/BDImpressionTracker$a.class */
    public final class a implements Runnable {
        private final ArrayList<View> b = new ArrayList<>();

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (Map.Entry entry : BDImpressionTracker.this.d.entrySet()) {
                View view = (View) entry.getKey();
                com.anythink.network.baidu.impression.a aVar = (com.anythink.network.baidu.impression.a) entry.getValue();
                b.C0173b unused = BDImpressionTracker.this.g;
                if (SystemClock.uptimeMillis() - aVar.b >= ((long) ((BDImpressionInterface) aVar.f8908a).getImpressionMinTimeViewed())) {
                    ((BDImpressionInterface) aVar.f8908a).recordImpression(view);
                    ((BDImpressionInterface) aVar.f8908a).setImpressionRecorded();
                    this.b.add(view);
                }
            }
            Iterator<View> it = this.b.iterator();
            while (it.hasNext()) {
                BDImpressionTracker.this.removeView(it.next());
            }
            this.b.clear();
            if (BDImpressionTracker.this.d.isEmpty()) {
                return;
            }
            BDImpressionTracker.this.a();
        }
    }

    public BDImpressionTracker(Context context) {
        this(new WeakHashMap(), new WeakHashMap(), new b.C0173b(), new b(context), new Handler(Looper.getMainLooper()));
    }

    public BDImpressionTracker(Context context, int i) {
        this(new WeakHashMap(), new WeakHashMap(), new b.C0173b(), new b(context, i), new Handler(Looper.getMainLooper()));
    }

    private BDImpressionTracker(Map<View, BDImpressionInterface> map, Map<View, com.anythink.network.baidu.impression.a<BDImpressionInterface>> map2, b.C0173b c0173b, b bVar, Handler handler) {
        this.f8905c = map;
        this.d = map2;
        this.g = c0173b;
        this.b = bVar;
        b.d dVar = new b.d() { // from class: com.anythink.network.baidu.impression.BDImpressionTracker.1
            @Override // com.anythink.network.baidu.impression.b.d
            public final void onVisibilityChanged(List<View> list, List<View> list2) {
                for (View view : list) {
                    BDImpressionInterface bDImpressionInterface = (BDImpressionInterface) BDImpressionTracker.this.f8905c.get(view);
                    if (bDImpressionInterface == null) {
                        BDImpressionTracker.this.removeView(view);
                    } else {
                        com.anythink.network.baidu.impression.a aVar = (com.anythink.network.baidu.impression.a) BDImpressionTracker.this.d.get(view);
                        if (aVar == null || !bDImpressionInterface.equals(aVar.f8908a)) {
                            BDImpressionTracker.this.d.put(view, new com.anythink.network.baidu.impression.a(bDImpressionInterface));
                        }
                    }
                }
                for (View view2 : list2) {
                    BDImpressionTracker.this.d.remove(view2);
                }
                BDImpressionTracker.this.a();
            }
        };
        this.h = dVar;
        this.b.a(dVar);
        this.e = handler;
        this.f = new a();
    }

    private void a(View view) {
        this.d.remove(view);
    }

    @Deprecated
    private b.d b() {
        return this.h;
    }

    final void a() {
        if (this.e.hasMessages(0)) {
            return;
        }
        this.e.postDelayed(this.f, 100L);
    }

    public void addView(View view, BDImpressionInterface bDImpressionInterface) {
        if (this.f8905c.get(view) == bDImpressionInterface) {
            return;
        }
        removeView(view);
        if (bDImpressionInterface.isImpressionRecorded()) {
            return;
        }
        this.f8905c.put(view, bDImpressionInterface);
        b bVar = this.b;
        int impressionMinPercentageViewed = bDImpressionInterface.getImpressionMinPercentageViewed();
        bVar.a(view, view, impressionMinPercentageViewed, impressionMinPercentageViewed, bDImpressionInterface.getImpressionMinVisiblePx());
    }

    public void clear() {
        this.f8905c.clear();
        this.d.clear();
        this.b.a();
        this.e.removeMessages(0);
    }

    public void destroy() {
        clear();
        this.b.b();
        this.h = null;
    }

    public void removeView(View view) {
        this.f8905c.remove(view);
        this.d.remove(view);
        this.b.a(view);
    }
}
