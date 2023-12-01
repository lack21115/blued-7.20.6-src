package com.blued.android.module.common.utils.click;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleTouchProxy.class */
public final class SingleTouchProxy implements View.OnTouchListener {
    private final TouchListener a;
    private long b;
    private final long c;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleTouchProxy$TouchListener.class */
    public interface TouchListener {
        boolean a();
    }

    public SingleTouchProxy(TouchListener listener) {
        Intrinsics.e(listener, "listener");
        this.a = listener;
        this.c = 300L;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.e(v, "v");
        Intrinsics.e(event, "event");
        if (event.getAction() == 1) {
            if (System.currentTimeMillis() - this.b >= this.c) {
                this.b = System.currentTimeMillis();
                return this.a.a();
            }
            return true;
        }
        return false;
    }
}
