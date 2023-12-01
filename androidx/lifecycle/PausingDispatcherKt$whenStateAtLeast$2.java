package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "PausingDispatcher.kt", c = {162}, d = "invokeSuspend", e = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2")
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2.class */
final class PausingDispatcherKt$whenStateAtLeast$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super T>, Object> $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super PausingDispatcherKt$whenStateAtLeast$2> continuation) {
        super(2, continuation);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2<>(this.$this_whenStateAtLeast, this.$minState, this.$block, continuation);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((CoroutineScope) obj, (Continuation) ((Continuation) obj2));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        LifecycleController lifecycleController;
        Object a2;
        LifecycleController lifecycleController2;
        Object a3 = IntrinsicsKt.a();
        int i = this.label;
        if (i == 0) {
            ResultKt.a(obj);
            Job job = ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.C_);
            if (job == null) {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
            CoroutineContext pausingDispatcher = new PausingDispatcher();
            lifecycleController = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, job);
            try {
                this.L$0 = lifecycleController;
                this.label = 1;
                a2 = BuildersKt.a(pausingDispatcher, this.$block, (Continuation) this);
                if (a2 == a3) {
                    return a3;
                }
                lifecycleController2 = lifecycleController;
            } catch (Throwable th) {
                th = th;
                lifecycleController.finish();
                throw th;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            lifecycleController2 = (LifecycleController) this.L$0;
            try {
                ResultKt.a(obj);
                a2 = obj;
            } catch (Throwable th2) {
                lifecycleController = lifecycleController2;
                th = th2;
                lifecycleController.finish();
                throw th;
            }
        }
        lifecycleController2.finish();
        return a2;
    }
}
