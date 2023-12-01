package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/DrawableCrossFadeFactory.class */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f21079a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private DrawableCrossFadeTransition f21080c;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/DrawableCrossFadeFactory$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final int f21081a;
        private boolean b;

        public Builder() {
            this(300);
        }

        public Builder(int i) {
            this.f21081a = i;
        }

        public Builder a(boolean z) {
            this.b = z;
            return this;
        }

        public DrawableCrossFadeFactory a() {
            return new DrawableCrossFadeFactory(this.f21081a, this.b);
        }
    }

    protected DrawableCrossFadeFactory(int i, boolean z) {
        this.f21079a = i;
        this.b = z;
    }

    private Transition<Drawable> a() {
        if (this.f21080c == null) {
            this.f21080c = new DrawableCrossFadeTransition(this.f21079a, this.b);
        }
        return this.f21080c;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<Drawable> a(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? NoTransition.b() : a();
    }
}
