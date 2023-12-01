package com.kwad.sdk.widget.swipe;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/swipe/a.class */
public abstract class a {
    private boolean aDA;

    protected abstract boolean FG();

    protected abstract boolean FH();

    public final boolean b(View view, MotionEvent motionEvent) {
        return !this.aDA && FG();
    }

    public final boolean c(View view, MotionEvent motionEvent) {
        return !this.aDA && FH();
    }
}
