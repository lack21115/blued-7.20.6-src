package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultCallerLauncher$resultContract$2;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/ActivityResultCallerLauncher.class */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Unit> {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f1508a;
    private final ActivityResultLauncher<I> b;

    /* renamed from: c  reason: collision with root package name */
    private final ActivityResultContract<I, O> f1509c;
    private final I d;

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> launcher, ActivityResultContract<I, O> callerContract, I i) {
        Intrinsics.e(launcher, "launcher");
        Intrinsics.e(callerContract, "callerContract");
        this.b = launcher;
        this.f1509c = callerContract;
        this.d = i;
        this.f1508a = LazyKt.a(new Function0<ActivityResultCallerLauncher$resultContract$2.AnonymousClass1>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new ActivityResultContract<Unit, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public Intent createIntent(Context context, Unit unit) {
                        Intrinsics.e(context, "context");
                        Intent createIntent = ActivityResultCallerLauncher.this.getCallerContract().createIntent(context, ActivityResultCallerLauncher.this.getInput());
                        Intrinsics.c(createIntent, "callerContract.createIntent(context, input)");
                        return createIntent;
                    }

                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public O parseResult(int i2, Intent intent) {
                        return (O) ActivityResultCallerLauncher.this.getCallerContract().parseResult(i2, intent);
                    }
                };
            }
        });
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.f1509c;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract<Unit, ?> getContract() {
        return (ActivityResultContract<Unit, O>) getResultContract();
    }

    public final I getInput() {
        return this.d;
    }

    public final ActivityResultLauncher<I> getLauncher() {
        return this.b;
    }

    public final ActivityResultContract<Unit, O> getResultContract() {
        return (ActivityResultContract) this.f1508a.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(Unit unit, ActivityOptionsCompat activityOptionsCompat) {
        this.b.launch(this.d, activityOptionsCompat);
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.b.unregister();
    }
}
