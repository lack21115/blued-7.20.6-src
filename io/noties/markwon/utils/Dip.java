package io.noties.markwon.utils;

import android.content.Context;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/Dip.class */
public class Dip {
    private final float density;

    public Dip(float f) {
        this.density = f;
    }

    public static Dip create(float f) {
        return new Dip(f);
    }

    public static Dip create(Context context) {
        return new Dip(context.getResources().getDisplayMetrics().density);
    }

    public int toPx(int i) {
        return (int) ((i * this.density) + 0.5f);
    }
}
