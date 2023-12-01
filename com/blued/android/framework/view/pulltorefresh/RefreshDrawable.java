package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/RefreshDrawable.class */
public abstract class RefreshDrawable extends Drawable implements Animatable, Drawable.Callback {
    private PullRefreshLayout a;

    public RefreshDrawable(Context context, PullRefreshLayout pullRefreshLayout) {
        this.a = pullRefreshLayout;
    }

    public abstract void a(int[] iArr);

    public PullRefreshLayout c() {
        return this.a;
    }

    public abstract void c(float f);

    public abstract void c(int i);

    public Context getContext() {
        PullRefreshLayout pullRefreshLayout = this.a;
        if (pullRefreshLayout != null) {
            return pullRefreshLayout.getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
