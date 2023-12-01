package com.blued.android.framework.view;

import android.widget.AbsListView;
import com.blued.android.core.imagecache.RecyclingImageLoader;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/PauseOnScrollListener.class */
public class PauseOnScrollListener implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f10182a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private AbsListView.OnScrollListener f10183c;

    public PauseOnScrollListener(boolean z, boolean z2) {
        this(z, z2, null);
    }

    public PauseOnScrollListener(boolean z, boolean z2, AbsListView.OnScrollListener onScrollListener) {
        this.f10182a = z;
        this.b = z2;
        this.f10183c = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.f10183c;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            RecyclingImageLoader.c();
        } else if (i != 1) {
            if (i == 2 && this.b) {
                RecyclingImageLoader.b();
            }
        } else if (this.f10182a) {
            RecyclingImageLoader.b();
        }
        AbsListView.OnScrollListener onScrollListener = this.f10183c;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }
}
