package com.qiniu.pili.droid.shortvideo;

import android.animation.Animator;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLTransition.class */
public abstract class PLTransition {

    /* renamed from: a  reason: collision with root package name */
    protected long f13816a;
    protected long b;

    public PLTransition(long j, long j2) {
        this.b = j;
        this.f13816a = j2;
    }

    public long a() {
        return this.b + this.f13816a;
    }

    public abstract Animator a(View view);

    public long b() {
        return this.b;
    }
}
