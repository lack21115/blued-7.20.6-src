package com.brandongogetap.stickyheaders;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-7206380-dex2jar.jar:com/brandongogetap/stickyheaders/ViewRetriever.class */
interface ViewRetriever {

    /* loaded from: source-7206380-dex2jar.jar:com/brandongogetap/stickyheaders/ViewRetriever$RecyclerViewRetriever.class */
    public static final class RecyclerViewRetriever implements ViewRetriever {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclerView f7036a;
        private RecyclerView.ViewHolder b;

        /* renamed from: c  reason: collision with root package name */
        private int f7037c = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RecyclerViewRetriever(RecyclerView recyclerView) {
            this.f7036a = recyclerView;
        }

        @Override // com.brandongogetap.stickyheaders.ViewRetriever
        public RecyclerView.ViewHolder a(int i) {
            if (this.f7037c != this.f7036a.getAdapter().getItemViewType(i)) {
                this.f7037c = this.f7036a.getAdapter().getItemViewType(i);
                this.b = this.f7036a.getAdapter().createViewHolder((ViewGroup) this.f7036a.getParent(), this.f7037c);
            }
            return this.b;
        }
    }

    RecyclerView.ViewHolder a(int i);
}
