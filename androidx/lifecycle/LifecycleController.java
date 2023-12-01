package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
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

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State minState, DispatchQueue dispatchQueue, final Job parentJob) {
        Intrinsics.e(lifecycle, "lifecycle");
        Intrinsics.e(minState, "minState");
        Intrinsics.e(dispatchQueue, "dispatchQueue");
        Intrinsics.e(parentJob, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        this.observer = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner source, Lifecycle.Event noName_1) {
                Lifecycle.State state;
                DispatchQueue dispatchQueue2;
                DispatchQueue dispatchQueue3;
                Intrinsics.e(source, "source");
                Intrinsics.e(noName_1, "$noName_1");
                if (source.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    LifecycleController lifecycleController = LifecycleController.this;
                    Job.DefaultImpls.a(parentJob, null, 1, null);
                    lifecycleController.finish();
                    return;
                }
                Lifecycle.State currentState = source.getLifecycle().getCurrentState();
                state = LifecycleController.this.minState;
                if (currentState.compareTo(state) < 0) {
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
        Job.DefaultImpls.a(parentJob, null, 1, null);
        finish();
    }

    private final void handleDestroy(Job job) {
        Job.DefaultImpls.a(job, null, 1, null);
        finish();
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
