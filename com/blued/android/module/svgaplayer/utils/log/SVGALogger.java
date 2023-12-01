package com.blued.android.module.svgaplayer.utils.log;

import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/utils/log/SVGALogger.class */
public final class SVGALogger {

    /* renamed from: a  reason: collision with root package name */
    public static final SVGALogger f16035a = new SVGALogger();
    private static ILogger b = new DefaultLogCat();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16036c;

    private SVGALogger() {
    }

    public final ILogger a() {
        return b;
    }

    public final SVGALogger a(boolean z) {
        f16036c = z;
        return this;
    }

    public final boolean b() {
        return f16036c;
    }
}
