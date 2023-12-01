package com.kwad.components.core.widget.kwai;

import android.view.View;
import com.kwad.sdk.utils.bl;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/kwai/b.class */
public class b extends a {
    private View mRootView;

    public b(View view, int i) {
        super(view, i);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.kwai.a
    public boolean et() {
        return bl.a(this.mRootView, 70, true);
    }
}
