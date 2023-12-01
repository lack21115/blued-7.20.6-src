package com.blued.android.module.svgaplayer.utils.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/utils/log/LogUtils.class */
public final class LogUtils {
    public static final LogUtils a = new LogUtils();

    private LogUtils() {
    }

    public final void a(String tag, String msg) {
        ILogger a2;
        Intrinsics.e(tag, "tag");
        Intrinsics.e(msg, "msg");
        if (SVGALogger.a.b() && (a2 = SVGALogger.a.a()) != null) {
            a2.a(tag, msg);
        }
    }

    public final void a(String tag, String msg, Throwable error) {
        ILogger a2;
        Intrinsics.e(tag, "tag");
        Intrinsics.e(msg, "msg");
        Intrinsics.e(error, "error");
        if (SVGALogger.a.b() && (a2 = SVGALogger.a.a()) != null) {
            a2.a(tag, msg, error);
        }
    }

    public final void a(String tag, Throwable error) {
        ILogger a2;
        Intrinsics.e(tag, "tag");
        Intrinsics.e(error, "error");
        if (SVGALogger.a.b() && (a2 = SVGALogger.a.a()) != null) {
            a2.a(tag, error.getMessage(), error);
        }
    }

    public final void b(String tag, String msg) {
        ILogger a2;
        Intrinsics.e(tag, "tag");
        Intrinsics.e(msg, "msg");
        if (SVGALogger.a.b() && (a2 = SVGALogger.a.a()) != null) {
            a2.b(tag, msg);
        }
    }

    public final void c(String tag, String msg) {
        ILogger a2;
        Intrinsics.e(tag, "tag");
        Intrinsics.e(msg, "msg");
        if (SVGALogger.a.b() && (a2 = SVGALogger.a.a()) != null) {
            a2.c(tag, msg);
        }
    }

    public final void d(String tag, String msg) {
        ILogger a2;
        Intrinsics.e(tag, "tag");
        Intrinsics.e(msg, "msg");
        if (SVGALogger.a.b() && (a2 = SVGALogger.a.a()) != null) {
            a2.a(tag, msg, null);
        }
    }
}
