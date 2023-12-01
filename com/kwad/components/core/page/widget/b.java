package com.kwad.components.core.page.widget;

import android.content.Context;
import android.view.TextureView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/widget/b.class */
public final class b extends TextureView {
    public b(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
