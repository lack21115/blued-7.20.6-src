package com.kwad.sdk.api.core.lifecycle;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/lifecycle/KsLifecycle.class */
public class KsLifecycle {
    private Lifecycle mBase;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/lifecycle/KsLifecycle$KsLifeEvent.class */
    public enum KsLifeEvent {
        ON_CREATE(Lifecycle.Event.ON_CREATE),
        ON_START(Lifecycle.Event.ON_START),
        ON_RESUME(Lifecycle.Event.ON_RESUME),
        ON_PAUSE(Lifecycle.Event.ON_PAUSE),
        ON_STOP(Lifecycle.Event.ON_STOP),
        ON_DESTROY(Lifecycle.Event.ON_DESTROY),
        ON_ANY(Lifecycle.Event.ON_ANY);
        
        Lifecycle.Event mRealValue;

        KsLifeEvent(Lifecycle.Event event) {
            this.mRealValue = event;
        }

        public static KsLifeEvent createfrom(Lifecycle.Event event) {
            KsLifeEvent[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                KsLifeEvent ksLifeEvent = values[i2];
                if (ksLifeEvent.getReal() == event) {
                    return ksLifeEvent;
                }
                i = i2 + 1;
            }
        }

        public final Lifecycle.Event getReal() {
            return this.mRealValue;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/lifecycle/KsLifecycle$KsLifeState.class */
    public enum KsLifeState {
        DESTROYED(Lifecycle.State.DESTROYED),
        INITIALIZED(Lifecycle.State.DESTROYED),
        CREATED(Lifecycle.State.DESTROYED),
        STARTED(Lifecycle.State.DESTROYED),
        RESUMED(Lifecycle.State.DESTROYED);
        
        Lifecycle.State mReal;

        KsLifeState(Lifecycle.State state) {
            this.mReal = state;
        }

        public static KsLifeState createFrom(Lifecycle.State state) {
            KsLifeState[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                KsLifeState ksLifeState = values[i2];
                if (ksLifeState.mReal == state) {
                    return ksLifeState;
                }
                i = i2 + 1;
            }
        }

        public final boolean isAtLeast(KsLifeState ksLifeState) {
            return compareTo(ksLifeState) >= 0;
        }
    }

    public KsLifecycle(Lifecycle lifecycle) {
        this.mBase = lifecycle;
    }

    public void addObserver(final KsLifecycleObserver ksLifecycleObserver) {
        if (ksLifecycleObserver instanceof KsGenericLifecycleObserver) {
            GenericLifecycleObserver genericLifecycleObserver = new GenericLifecycleObserver() { // from class: com.kwad.sdk.api.core.lifecycle.KsLifecycle.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    ((KsGenericLifecycleObserver) ksLifecycleObserver).onStateChanged(KsLifeEvent.createfrom(event));
                }
            };
            ksLifecycleObserver.setBase(genericLifecycleObserver);
            this.mBase.addObserver(genericLifecycleObserver);
        }
    }

    public KsLifeState getCurrentState() {
        return KsLifeState.createFrom(this.mBase.getCurrentState());
    }

    public void removeObserver(KsLifecycleObserver ksLifecycleObserver) {
        this.mBase.removeObserver(ksLifecycleObserver.getBase());
    }
}
