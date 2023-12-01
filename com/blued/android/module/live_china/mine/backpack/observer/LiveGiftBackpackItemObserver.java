package com.blued.android.module.live_china.mine.backpack.observer;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/observer/LiveGiftBackpackItemObserver.class */
public final class LiveGiftBackpackItemObserver {
    public static final Companion a = new Companion(null);
    private static final LiveGiftBackpackItemObserver c = new LiveGiftBackpackItemObserver();
    private final ArrayList<ILiveBackpackObserver> b = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/observer/LiveGiftBackpackItemObserver$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LiveGiftBackpackItemObserver a() {
            return LiveGiftBackpackItemObserver.c;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/observer/LiveGiftBackpackItemObserver$ILiveBackpackObserver.class */
    public interface ILiveBackpackObserver {
        void a(Object obj);

        void a(Object obj, int i);

        void a(Object obj, int i, int i2);
    }

    @JvmStatic
    public static final LiveGiftBackpackItemObserver a() {
        return a.a();
    }

    public final void a(ILiveBackpackObserver iLiveBackpackObserver) {
        synchronized (this) {
            if (iLiveBackpackObserver != null) {
                if (!this.b.contains(iLiveBackpackObserver)) {
                    this.b.add(iLiveBackpackObserver);
                }
            }
        }
    }

    public final void a(Object obj) {
        synchronized (this) {
            Iterator<ILiveBackpackObserver> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(obj);
            }
        }
    }

    public final void a(Object obj, int i) {
        synchronized (this) {
            Iterator<ILiveBackpackObserver> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(obj, i);
            }
        }
    }

    public final void a(Object obj, int i, int i2) {
        synchronized (this) {
            Iterator<ILiveBackpackObserver> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(obj, i, i2);
            }
        }
    }

    public final void b(ILiveBackpackObserver iLiveBackpackObserver) {
        synchronized (this) {
            if (iLiveBackpackObserver != null) {
                this.b.remove(iLiveBackpackObserver);
            }
        }
    }
}
