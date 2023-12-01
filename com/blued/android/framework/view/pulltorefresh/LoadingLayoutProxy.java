package com.blued.android.framework.view.pulltorefresh;

import android.graphics.drawable.Drawable;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/LoadingLayoutProxy.class */
public class LoadingLayoutProxy implements ILoadingLayout {

    /* renamed from: a  reason: collision with root package name */
    private final HashSet<LoadingLayout> f10216a = new HashSet<>();

    public void a(LoadingLayout loadingLayout) {
        if (loadingLayout != null) {
            this.f10216a.add(loadingLayout);
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f10216a.iterator();
        while (it.hasNext()) {
            it.next().setLastUpdatedLabel(charSequence);
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public void setLoadingDrawable(Drawable drawable) {
        Iterator<LoadingLayout> it = this.f10216a.iterator();
        while (it.hasNext()) {
            it.next().setLoadingDrawable(drawable);
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public void setPullLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f10216a.iterator();
        while (it.hasNext()) {
            it.next().setPullLabel(charSequence);
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f10216a.iterator();
        while (it.hasNext()) {
            it.next().setRefreshingLabel(charSequence);
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public void setReleaseLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f10216a.iterator();
        while (it.hasNext()) {
            it.next().setReleaseLabel(charSequence);
        }
    }
}
