package com.blued.android.module.common.svg_android;

import android.graphics.Picture;
import android.graphics.RectF;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/svg_android/SVG.class */
public class SVG {
    private Picture a;
    private RectF b;
    private RectF c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVG(Picture picture, RectF rectF) {
        this.a = picture;
        this.b = rectF;
    }

    public Picture a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RectF rectF) {
        this.c = rectF;
    }
}
