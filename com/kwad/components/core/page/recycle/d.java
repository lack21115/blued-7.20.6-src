package com.kwad.components.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/recycle/d.class */
public abstract class d extends RecyclerView.Adapter<c> {
    private List<Presenter> MR = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.mPresenter.jW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        c b = b(viewGroup, i);
        this.MR.add(b.mPresenter);
        return b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i) {
        cVar.mPresenter.f(cVar.Lj);
    }

    protected abstract c b(ViewGroup viewGroup, int i);

    public final void oM() {
        for (Presenter presenter : this.MR) {
            presenter.destroy();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        oM();
    }
}
