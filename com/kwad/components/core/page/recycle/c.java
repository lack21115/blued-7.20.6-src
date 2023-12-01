package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/recycle/c.class */
public final class c extends RecyclerView.ViewHolder {
    public final e Lj;
    public final Presenter mPresenter;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.Lj = eVar;
        this.mPresenter = presenter;
        presenter.E(view);
    }
}
