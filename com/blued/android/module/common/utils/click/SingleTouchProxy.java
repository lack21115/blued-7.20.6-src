package com.blued.android.module.common.utils.click;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleTouchProxy.class */
public final class SingleTouchProxy implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final TouchListener f10929a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10930c;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleTouchProxy$TouchListener.class */
    public interface TouchListener {
        boolean a();
    }

    public SingleTouchProxy(TouchListener listener) {
        Intrinsics.e(listener, "listener");
        this.f10929a = listener;
        this.f10930c = 300L;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.e(v, "v");
        Intrinsics.e(event, "event");
        if (event.getAction() == 1) {
            if (System.currentTimeMillis() - this.b >= this.f10930c) {
                this.b = System.currentTimeMillis();
                return this.f10929a.a();
            }
            return true;
        }
        return false;
    }
}
