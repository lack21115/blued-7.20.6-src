package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rh.class */
public class rh extends ImageView {
    public rh(Context context) {
        super(context);
        setClickable(true);
    }

    public void a() {
        setClickable(false);
        Drawable background = getBackground();
        if (background != null) {
            background.setCallback(null);
        }
        setBackgroundDrawable(null);
    }

    public void a(Context context, Bitmap bitmap, Bitmap bitmap2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new BitmapDrawable(context.getResources(), bitmap2));
        stateListDrawable.addState(View.ENABLED_STATE_SET, bitmapDrawable);
        setBackgroundDrawable(stateListDrawable);
    }

    public void a(Bitmap bitmap, Bitmap bitmap2) {
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), bitmap, bitmap.getNinePatchChunk(), new Rect(), null);
        NinePatchDrawable ninePatchDrawable2 = new NinePatchDrawable(getResources(), bitmap2, bitmap2.getNinePatchChunk(), new Rect(), null);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, ninePatchDrawable2);
        stateListDrawable.addState(View.ENABLED_STATE_SET, ninePatchDrawable);
        setBackgroundDrawable(stateListDrawable);
    }
}
