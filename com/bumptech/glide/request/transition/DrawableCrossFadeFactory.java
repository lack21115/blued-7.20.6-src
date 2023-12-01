package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/DrawableCrossFadeFactory.class */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f7473a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private DrawableCrossFadeTransition f7474c;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/DrawableCrossFadeFactory$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final int f7475a;
        private boolean b;

        public Builder() {
            this(300);
        }

        public Builder(int i) {
            this.f7475a = i;
        }

        public Builder a(boolean z) {
            this.b = z;
            return this;
        }

        public DrawableCrossFadeFactory a() {
            return new DrawableCrossFadeFactory(this.f7475a, this.b);
        }
    }

    protected DrawableCrossFadeFactory(int i, boolean z) {
        this.f7473a = i;
        this.b = z;
    }

    private Transition<Drawable> a() {
        if (this.f7474c == null) {
            this.f7474c = new DrawableCrossFadeTransition(this.f7473a, this.b);
        }
        return this.f7474c;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<Drawable> a(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? NoTransition.b() : a();
    }
}
