package com.blued.android.module.live.base.view.animation;

import android.view.View;
import com.blued.android.core.net.IRequestHost;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/BaseLiveAnimationView.class */
public abstract class BaseLiveAnimationView {

    /* renamed from: a  reason: collision with root package name */
    protected LiveAnimationListener f11493a;

    public abstract View a();

    public void a(IRequestHost iRequestHost) {
    }

    public void a(LiveAnimationListener liveAnimationListener) {
        this.f11493a = liveAnimationListener;
    }

    public void a(String str) {
    }
}
