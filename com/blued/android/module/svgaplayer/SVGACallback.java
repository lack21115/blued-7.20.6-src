package com.blued.android.module.svgaplayer;

import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGACallback.class */
public interface SVGACallback {
    void onFinished();

    void onPause();

    void onRepeat();

    void onStep(int i, double d);
}
