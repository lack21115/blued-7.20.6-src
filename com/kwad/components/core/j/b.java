package com.kwad.components.core.j;

import com.kwad.components.core.j.a;
import com.kwad.components.core.l.d;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/j/b.class */
public abstract class b<T extends a> extends d {
    private final com.kwad.sdk.i.kwai.a mBackPressDelete = new com.kwad.sdk.i.kwai.a();
    public T mCallerContext;
    public Presenter mPresenter;

    private void notifyOnCreate() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.j.kwai.a aVar : t.JT) {
            aVar.fY();
        }
    }

    private void notifyOnDestroy() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.j.kwai.a aVar : t.JT) {
            aVar.c(this);
        }
    }

    private void notifyOnPause() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.j.kwai.a aVar : t.JT) {
            aVar.b(this);
        }
    }

    private void notifyOnResume() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.j.kwai.a aVar : t.JT) {
            aVar.a(this);
        }
    }

    public void addBackPressable(com.kwad.sdk.i.kwai.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    public void addBackPressable(com.kwad.sdk.i.kwai.b bVar, int i) {
        this.mBackPressDelete.addBackPressable(bVar, i);
    }

    public void initMVP() {
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.E(this.mRootView);
        }
        this.mPresenter.f(this.mCallerContext);
    }

    @Override // com.kwad.components.core.l.d
    public void onActivityCreate() {
        super.onActivityCreate();
        initMVP();
        notifyOnCreate();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mBackPressDelete.bX()) {
            return;
        }
        super.onBackPressed();
    }

    protected abstract T onCreateCallerContext();

    protected abstract Presenter onCreatePresenter();

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        notifyOnDestroy();
        T t = this.mCallerContext;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        notifyOnPause();
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        notifyOnResume();
    }

    public void removeBackPressable(com.kwad.sdk.i.kwai.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }
}
