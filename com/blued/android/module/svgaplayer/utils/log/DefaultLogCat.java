package com.blued.android.module.svgaplayer.utils.log;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/utils/log/DefaultLogCat.class */
public final class DefaultLogCat implements ILogger {
    @Override // com.blued.android.module.svgaplayer.utils.log.ILogger
    public void a(String tag, String msg) {
        Intrinsics.e(tag, "tag");
        Intrinsics.e(msg, "msg");
        Log.i(tag, msg);
    }

    @Override // com.blued.android.module.svgaplayer.utils.log.ILogger
    public void a(String tag, String str, Throwable th) {
        Intrinsics.e(tag, "tag");
        Log.e(tag, str, th);
    }

    @Override // com.blued.android.module.svgaplayer.utils.log.ILogger
    public void b(String tag, String msg) {
        Intrinsics.e(tag, "tag");
        Intrinsics.e(msg, "msg");
        Log.d(tag, msg);
    }

    @Override // com.blued.android.module.svgaplayer.utils.log.ILogger
    public void c(String tag, String msg) {
        Intrinsics.e(tag, "tag");
        Intrinsics.e(msg, "msg");
        Log.w(tag, msg);
    }
}
