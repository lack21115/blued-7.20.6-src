package androidx.activity.result;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/ActivityResultKt.class */
public final class ActivityResultKt {
    public static final int component1(ActivityResult activityResult) {
        Intrinsics.e(activityResult, "$this$component1");
        return activityResult.getResultCode();
    }

    public static final Intent component2(ActivityResult activityResult) {
        Intrinsics.e(activityResult, "$this$component2");
        return activityResult.getData();
    }
}
