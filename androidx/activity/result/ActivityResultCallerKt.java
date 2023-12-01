package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/ActivityResultCallerKt.class */
public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller registerForActivityResult, ActivityResultContract<I, O> contract, I i, ActivityResultRegistry registry, final Function1<? super O, Unit> callback) {
        Intrinsics.e(registerForActivityResult, "$this$registerForActivityResult");
        Intrinsics.e(contract, "contract");
        Intrinsics.e(registry, "registry");
        Intrinsics.e(callback, "callback");
        ActivityResultLauncher<I> registerForActivityResult2 = registerForActivityResult.registerForActivityResult(contract, registry, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                Function1.this.invoke(o);
            }
        });
        Intrinsics.c(registerForActivityResult2, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult2, contract, i);
    }

    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller registerForActivityResult, ActivityResultContract<I, O> contract, I i, final Function1<? super O, Unit> callback) {
        Intrinsics.e(registerForActivityResult, "$this$registerForActivityResult");
        Intrinsics.e(contract, "contract");
        Intrinsics.e(callback, "callback");
        ActivityResultLauncher<I> registerForActivityResult2 = registerForActivityResult.registerForActivityResult(contract, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                Function1.this.invoke(o);
            }
        });
        Intrinsics.c(registerForActivityResult2, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult2, contract, i);
    }
}
