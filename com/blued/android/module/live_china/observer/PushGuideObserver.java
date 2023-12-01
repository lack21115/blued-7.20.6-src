package com.blued.android.module.live_china.observer;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/PushGuideObserver.class */
public final class PushGuideObserver {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13957a = new Companion(null);
    private static final PushGuideObserver b = new PushGuideObserver();

    /* renamed from: c  reason: collision with root package name */
    private static final ArrayList<IPushGuideObserver> f13958c = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/PushGuideObserver$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PushGuideObserver a() {
            return PushGuideObserver.b;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/PushGuideObserver$IPushGuideObserver.class */
    public interface IPushGuideObserver {
        void a();

        void a(View view, View view2);

        void setLiveRecommendViewData(View view);

        void setMsgHotWordViewData(View view);
    }

    private PushGuideObserver() {
    }

    @JvmStatic
    public static final PushGuideObserver d() {
        return f13957a.a();
    }

    public final void a(View view) {
        synchronized (this) {
            Iterator<IPushGuideObserver> it = f13958c.iterator();
            while (it.hasNext()) {
                IPushGuideObserver next = it.next();
                if (next != null) {
                    next.setMsgHotWordViewData(view);
                }
            }
        }
    }

    public final void a(View view, View view2) {
        synchronized (this) {
            Iterator<IPushGuideObserver> it = f13958c.iterator();
            while (it.hasNext()) {
                IPushGuideObserver next = it.next();
                if (next != null) {
                    next.a(view, view2);
                }
            }
        }
    }

    public final void a(IPushGuideObserver iPushGuideObserver) {
        synchronized (this) {
            if (iPushGuideObserver != null) {
                f13958c.add(iPushGuideObserver);
            }
        }
    }

    public final boolean a() {
        ArrayList<IPushGuideObserver> arrayList = f13958c;
        return !(arrayList == null || arrayList.isEmpty());
    }

    public final void b() {
        synchronized (this) {
            f13958c.removeAll(f13958c);
            f13958c.clear();
        }
    }

    public final void b(View view) {
        synchronized (this) {
            Iterator<IPushGuideObserver> it = f13958c.iterator();
            while (it.hasNext()) {
                IPushGuideObserver next = it.next();
                if (next != null) {
                    next.setLiveRecommendViewData(view);
                }
            }
        }
    }

    public final void b(IPushGuideObserver iPushGuideObserver) {
        synchronized (this) {
            if (iPushGuideObserver != null) {
                f13958c.remove(iPushGuideObserver);
            }
        }
    }

    public final void c() {
        synchronized (this) {
            Iterator<IPushGuideObserver> it = f13958c.iterator();
            while (it.hasNext()) {
                IPushGuideObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }
}
