package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/ActivityResultRegistry.class */
public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    private Random f1464a = new Random();
    private final Map<Integer, String> g = new HashMap();
    final Map<String, Integer> b = new HashMap();
    private final Map<String, LifecycleContainer> h = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<String> f1465c = new ArrayList<>();
    final transient Map<String, CallbackAndContract<?>> d = new HashMap();
    final Map<String, Object> e = new HashMap();
    final Bundle f = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/ActivityResultRegistry$CallbackAndContract.class */
    public static class CallbackAndContract<O> {

        /* renamed from: a  reason: collision with root package name */
        final ActivityResultCallback<O> f1472a;
        final ActivityResultContract<?, O> b;

        CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.f1472a = activityResultCallback;
            this.b = activityResultContract;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/ActivityResultRegistry$LifecycleContainer.class */
    public static class LifecycleContainer {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f1473a;
        private final ArrayList<LifecycleEventObserver> b = new ArrayList<>();

        LifecycleContainer(Lifecycle lifecycle) {
            this.f1473a = lifecycle;
        }

        void a() {
            Iterator<LifecycleEventObserver> it = this.b.iterator();
            while (it.hasNext()) {
                this.f1473a.removeObserver(it.next());
            }
            this.b.clear();
        }

        void a(LifecycleEventObserver lifecycleEventObserver) {
            this.f1473a.addObserver(lifecycleEventObserver);
            this.b.add(lifecycleEventObserver);
        }
    }

    private int a() {
        int nextInt = this.f1464a.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (!this.g.containsKey(Integer.valueOf(i))) {
                return i;
            }
            nextInt = this.f1464a.nextInt(2147418112);
        }
    }

    private void a(int i, String str) {
        this.g.put(Integer.valueOf(i), str);
        this.b.put(str, Integer.valueOf(i));
    }

    private <O> void a(String str, int i, Intent intent, CallbackAndContract<O> callbackAndContract) {
        if (callbackAndContract != null && callbackAndContract.f1472a != null) {
            callbackAndContract.f1472a.onActivityResult(callbackAndContract.b.parseResult(i, intent));
            return;
        }
        this.e.remove(str);
        this.f.putParcelable(str, new ActivityResult(i, intent));
    }

    private int b(String str) {
        Integer num = this.b.get(str);
        if (num != null) {
            return num.intValue();
        }
        int a2 = a();
        a(a2, str);
        return a2;
    }

    final void a(String str) {
        Integer remove;
        if (!this.f1465c.contains(str) && (remove = this.b.remove(str)) != null) {
            this.g.remove(remove);
        }
        this.d.remove(str);
        if (this.e.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.e.get(str));
            this.e.remove(str);
        }
        if (this.f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f.getParcelable(str));
            this.f.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.h.get(str);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
            this.h.remove(str);
        }
    }

    public final boolean dispatchResult(int i, int i2, Intent intent) {
        String str = this.g.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.f1465c.remove(str);
        a(str, i2, intent, this.d.get(str));
        return true;
    }

    public final <O> boolean dispatchResult(int i, O o) {
        String str = this.g.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.f1465c.remove(str);
        CallbackAndContract<?> callbackAndContract = this.d.get(str);
        if (callbackAndContract != null && callbackAndContract.f1472a != null) {
            callbackAndContract.f1472a.onActivityResult(o);
            return true;
        }
        this.f.remove(str);
        this.e.put(str, o);
        return true;
    }

    public abstract <I, O> void onLaunch(int i, ActivityResultContract<I, O> activityResultContract, I i2, ActivityOptionsCompat activityOptionsCompat);

    public final void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f1465c = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f1464a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringArrayList.size()) {
                return;
            }
            String str = stringArrayList.get(i2);
            if (this.b.containsKey(str)) {
                Integer remove = this.b.remove(str);
                if (!this.f.containsKey(str)) {
                    this.g.remove(remove);
                }
            }
            a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
            i = i2 + 1;
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f1465c));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f1464a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> ActivityResultLauncher<I> register(final String str, final ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        final int b = b(str);
        this.d.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
        if (this.e.containsKey(str)) {
            Object obj = this.e.get(str);
            this.e.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f.getParcelable(str);
        if (activityResult != null) {
            this.f.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.3
            @Override // androidx.activity.result.ActivityResultLauncher
            public ActivityResultContract<I, ?> getContract() {
                return activityResultContract;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
                ActivityResultRegistry.this.f1465c.add(str);
                Integer num = ActivityResultRegistry.this.b.get(str);
                ActivityResultRegistry.this.onLaunch(num != null ? num.intValue() : b, activityResultContract, i, activityOptionsCompat);
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultRegistry.this.a(str);
            }
        };
    }

    public final <I, O> ActivityResultLauncher<I> register(final String str, LifecycleOwner lifecycleOwner, final ActivityResultContract<I, O> activityResultContract, final ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
        }
        final int b = b(str);
        LifecycleContainer lifecycleContainer = this.h.get(str);
        LifecycleContainer lifecycleContainer2 = lifecycleContainer;
        if (lifecycleContainer == null) {
            lifecycleContainer2 = new LifecycleContainer(lifecycle);
        }
        lifecycleContainer2.a(new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                if (!Lifecycle.Event.ON_START.equals(event)) {
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.d.remove(str);
                        return;
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        ActivityResultRegistry.this.a(str);
                        return;
                    } else {
                        return;
                    }
                }
                ActivityResultRegistry.this.d.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
                if (ActivityResultRegistry.this.e.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.e.get(str);
                    ActivityResultRegistry.this.e.remove(str);
                    activityResultCallback.onActivityResult(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f.getParcelable(str);
                if (activityResult != null) {
                    ActivityResultRegistry.this.f.remove(str);
                    activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
                }
            }
        });
        this.h.put(str, lifecycleContainer2);
        return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.2
            @Override // androidx.activity.result.ActivityResultLauncher
            public ActivityResultContract<I, ?> getContract() {
                return activityResultContract;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
                ActivityResultRegistry.this.f1465c.add(str);
                Integer num = ActivityResultRegistry.this.b.get(str);
                ActivityResultRegistry.this.onLaunch(num != null ? num.intValue() : b, activityResultContract, i, activityOptionsCompat);
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultRegistry.this.a(str);
            }
        };
    }
}
