package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.widget.SectionIndexer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/SectionIndexerAdapterWrapper.class */
class SectionIndexerAdapterWrapper extends AdapterWrapper implements SectionIndexer {
    final SectionIndexer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SectionIndexerAdapterWrapper(Context context, StickyListHeadersAdapter stickyListHeadersAdapter) {
        super(context, stickyListHeadersAdapter);
        this.b = (SectionIndexer) stickyListHeadersAdapter;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        return this.b.getPositionForSection(i);
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return this.b.getSectionForPosition(i);
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.b.getSections();
    }
}
