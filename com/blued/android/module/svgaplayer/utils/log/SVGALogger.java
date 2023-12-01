package com.blued.android.module.svgaplayer.utils.log;

import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/utils/log/SVGALogger.class */
public final class SVGALogger {
    public static final SVGALogger a = new SVGALogger();
    private static ILogger b = new DefaultLogCat();
    private static boolean c;

    private SVGALogger() {
    }

    public final ILogger a() {
        return b;
    }

    public final SVGALogger a(boolean z) {
        c = z;
        return this;
    }

    public final boolean b() {
        return c;
    }
}
