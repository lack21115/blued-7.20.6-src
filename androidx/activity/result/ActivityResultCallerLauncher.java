package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultCallerLauncher$resultContract$2;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import com.anythink.expressad.d.a.b;
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
    private final Lazy f1460a;
    private final ActivityResultLauncher<I> b;

    /* renamed from: c  reason: collision with root package name */
    private final ActivityResultContract<I, O> f1461c;
    private final I d;

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> activityResultLauncher, ActivityResultContract<I, O> activityResultContract, I i) {
        Intrinsics.e(activityResultLauncher, b.bU);
        Intrinsics.e(activityResultContract, "callerContract");
        this.b = activityResultLauncher;
        this.f1461c = activityResultContract;
        this.d = i;
        this.f1460a = LazyKt.a(new Function0<ActivityResultCallerLauncher$resultContract$2.AnonymousClass1>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
            /* renamed from: invoke */
            public final AnonymousClass1 m1071invoke() {
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
        return this.f1461c;
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
        return (ActivityResultContract) this.f1460a.getValue();
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
