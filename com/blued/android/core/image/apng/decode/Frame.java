package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blued.android.core.image.apng.io.Reader;
import com.blued.android.core.image.apng.io.Writer;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/Frame.class */
public abstract class Frame<R extends Reader, W extends Writer> {
    protected final R g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public Frame(R r) {
        this.g = r;
    }

    public abstract Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);
}
