package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/ExpandableStickyListHeadersListView.class */
public class ExpandableStickyListHeadersListView extends StickyListHeadersListView {
    ExpandableStickyListHeadersAdapter a;
    IAnimationExecutor b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/ExpandableStickyListHeadersListView$IAnimationExecutor.class */
    public interface IAnimationExecutor {
    }

    public ExpandableStickyListHeadersListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new IAnimationExecutor() { // from class: com.blued.android.framework.view.stickylistheaders.ExpandableStickyListHeadersListView.1
        };
    }

    public ExpandableStickyListHeadersListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new IAnimationExecutor() { // from class: com.blued.android.framework.view.stickylistheaders.ExpandableStickyListHeadersListView.1
        };
    }

    @Override // com.blued.android.framework.view.stickylistheaders.StickyListHeadersListView
    public ExpandableStickyListHeadersAdapter getAdapter() {
        return this.a;
    }

    @Override // com.blued.android.framework.view.stickylistheaders.StickyListHeadersListView
    public void setAdapter(StickyListHeadersAdapter stickyListHeadersAdapter) {
        ExpandableStickyListHeadersAdapter expandableStickyListHeadersAdapter = new ExpandableStickyListHeadersAdapter(stickyListHeadersAdapter);
        this.a = expandableStickyListHeadersAdapter;
        super.setAdapter(expandableStickyListHeadersAdapter);
    }

    public void setAnimExecutor(IAnimationExecutor iAnimationExecutor) {
        this.b = iAnimationExecutor;
    }
}
