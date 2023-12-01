package com.brandongogetap.stickyheaders;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-7206380-dex2jar.jar:com/brandongogetap/stickyheaders/ViewRetriever.class */
interface ViewRetriever {

    /* loaded from: source-7206380-dex2jar.jar:com/brandongogetap/stickyheaders/ViewRetriever$RecyclerViewRetriever.class */
    public static final class RecyclerViewRetriever implements ViewRetriever {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclerView f20642a;
        private RecyclerView.ViewHolder b;

        /* renamed from: c  reason: collision with root package name */
        private int f20643c = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RecyclerViewRetriever(RecyclerView recyclerView) {
            this.f20642a = recyclerView;
        }

        @Override // com.brandongogetap.stickyheaders.ViewRetriever
        public RecyclerView.ViewHolder a(int i) {
            if (this.f20643c != this.f20642a.getAdapter().getItemViewType(i)) {
                this.f20643c = this.f20642a.getAdapter().getItemViewType(i);
                this.b = this.f20642a.getAdapter().createViewHolder((ViewGroup) this.f20642a.getParent(), this.f20643c);
            }
            return this.b;
        }
    }

    RecyclerView.ViewHolder a(int i);
}
