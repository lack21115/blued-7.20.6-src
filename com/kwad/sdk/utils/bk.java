package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bk.class */
public final class bk {
    private View aBB;
    public Point aBA = new Point();
    public Rect aBy = new Rect();
    public Rect aBz = new Rect();

    public bk(View view) {
        this.aBB = view;
    }

    public final boolean Fa() {
        boolean globalVisibleRect = this.aBB.getGlobalVisibleRect(this.aBy, this.aBA);
        if (this.aBA.x == 0 && this.aBA.y == 0 && this.aBy.height() == this.aBB.getHeight() && this.aBz.height() != 0 && Math.abs(this.aBy.top - this.aBz.top) > this.aBB.getHeight() / 2) {
            this.aBy.set(this.aBz);
        }
        this.aBz.set(this.aBy);
        return globalVisibleRect;
    }
}
