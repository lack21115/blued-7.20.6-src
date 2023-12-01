package com.scwang.smartrefresh.layout.impl;

import android.view.View;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/impl/RefreshFooterWrapper.class */
public class RefreshFooterWrapper extends InternalAbstract implements RefreshFooter {
    public RefreshFooterWrapper(View view) {
        super(view);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean a(boolean z) {
        return (this.y instanceof RefreshFooter) && ((RefreshFooter) this.y).a(z);
    }
}
