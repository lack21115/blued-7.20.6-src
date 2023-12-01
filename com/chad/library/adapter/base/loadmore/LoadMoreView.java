package com.chad.library.adapter.base.loadmore;

import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/loadmore/LoadMoreView.class */
public abstract class LoadMoreView {

    /* renamed from: a  reason: collision with root package name */
    private int f7968a = 1;
    private boolean b = false;

    private void a(BaseViewHolder baseViewHolder, boolean z) {
        baseViewHolder.setVisible(b(), z);
    }

    private void b(BaseViewHolder baseViewHolder, boolean z) {
        baseViewHolder.setVisible(c(), z);
    }

    private void c(BaseViewHolder baseViewHolder, boolean z) {
        int d = d();
        if (d != 0) {
            baseViewHolder.setVisible(d, z);
        }
    }

    public abstract int a();

    public void a(int i) {
        this.f7968a = i;
    }

    public void a(BaseViewHolder baseViewHolder) {
        int i = this.f7968a;
        if (i == 1) {
            a(baseViewHolder, false);
            b(baseViewHolder, false);
            c(baseViewHolder, false);
        } else if (i == 2) {
            a(baseViewHolder, true);
            b(baseViewHolder, false);
            c(baseViewHolder, false);
        } else if (i == 3) {
            a(baseViewHolder, false);
            b(baseViewHolder, true);
            c(baseViewHolder, false);
        } else if (i != 4) {
        } else {
            a(baseViewHolder, false);
            b(baseViewHolder, false);
            c(baseViewHolder, true);
        }
    }

    public final void a(boolean z) {
        this.b = z;
    }

    protected abstract int b();

    protected abstract int c();

    protected abstract int d();

    public int e() {
        return this.f7968a;
    }

    public final boolean f() {
        if (d() == 0) {
            return true;
        }
        return this.b;
    }
}
