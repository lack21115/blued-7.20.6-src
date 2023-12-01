package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/f.class */
public final class f extends ViewOutlineProvider {
    private float Xb;

    private f(float f) {
        this.Xb = f;
    }

    public static void b(View view, float f) {
        boolean z;
        if (f <= 0.0f) {
            view.setOutlineProvider(null);
            z = false;
        } else {
            view.setOutlineProvider(new f(f));
            z = true;
        }
        view.setClipToOutline(z);
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.Xb);
    }
}
