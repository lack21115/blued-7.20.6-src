package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/LifecycleController.class */
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, final Job job) {
        Intrinsics.e(lifecycle, "lifecycle");
        Intrinsics.e(state, "minState");
        Intrinsics.e(dispatchQueue, "dispatchQueue");
        Intrinsics.e(job, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        this.observer = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Lifecycle.State state2;
                DispatchQueue dispatchQueue2;
                DispatchQueue dispatchQueue3;
                Intrinsics.e(lifecycleOwner, "source");
                Intrinsics.e(event, "$noName_1");
                if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    LifecycleController lifecycleController = LifecycleController.this;
                    Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
                    lifecycleController.finish();
                    return;
                }
                Lifecycle.State currentState = lifecycleOwner.getLifecycle().getCurrentState();
                state2 = LifecycleController.this.minState;
                if (currentState.compareTo(state2) < 0) {
                    dispatchQueue3 = LifecycleController.this.dispatchQueue;
                    dispatchQueue3.pause();
                    return;
                }
                dispatchQueue2 = LifecycleController.this.dispatchQueue;
                dispatchQueue2.resume();
            }
        };
        if (this.lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            this.lifecycle.addObserver(this.observer);
            return;
        }
        Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        finish();
    }

    private final void handleDestroy(Job job) {
        Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        finish();
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
