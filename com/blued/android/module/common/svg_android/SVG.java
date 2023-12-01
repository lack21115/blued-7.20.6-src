package com.blued.android.module.common.svg_android;

import android.graphics.Picture;
import android.graphics.RectF;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/svg_android/SVG.class */
public class SVG {

    /* renamed from: a  reason: collision with root package name */
    private Picture f10827a;
    private RectF b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f10828c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVG(Picture picture, RectF rectF) {
        this.f10827a = picture;
        this.b = rectF;
    }

    public Picture a() {
        return this.f10827a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RectF rectF) {
        this.f10828c = rectF;
    }
}
