package com.blued.android.module.live_china.utils.dslspannable;

import android.content.Context;
import com.blued.android.core.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/dslspannable/CommUtils.class */
public final class CommUtils {
    public final Context getContext() {
        Context d = AppInfo.d();
        Intrinsics.c(d, "getAppContext()");
        return d;
    }
}
