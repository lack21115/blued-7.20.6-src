package androidx.activity.result;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/ActivityResultKt.class */
public final class ActivityResultKt {
    public static final int component1(ActivityResult component1) {
        Intrinsics.e(component1, "$this$component1");
        return component1.getResultCode();
    }

    public static final Intent component2(ActivityResult component2) {
        Intrinsics.e(component2, "$this$component2");
        return component2.getData();
    }
}
