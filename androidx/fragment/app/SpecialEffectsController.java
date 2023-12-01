package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/SpecialEffectsController.class */
public abstract class SpecialEffectsController {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<Operation> f3004a = new ArrayList<>();
    final ArrayList<Operation> b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    boolean f3005c = false;
    boolean d = false;
    private final ViewGroup e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.fragment.app.SpecialEffectsController$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/SpecialEffectsController$3.class */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3008a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0060 -> B:40:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0064 -> B:36:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0068 -> B:8:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006c -> B:42:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0070 -> B:38:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0074 -> B:34:0x0054). Please submit an issue!!! */
        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            b = iArr;
            try {
                iArr[Operation.LifecycleImpact.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[Operation.LifecycleImpact.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[Operation.State.values().length];
            f3008a = iArr2;
            try {
                iArr2[Operation.State.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3008a[Operation.State.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3008a[Operation.State.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f3008a[Operation.State.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation.class */
    public static class FragmentStateManagerOperation extends Operation {

        /* renamed from: a  reason: collision with root package name */
        private final FragmentStateManager f3009a;

        FragmentStateManagerOperation(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, fragmentStateManager.a(), cancellationSignal);
            this.f3009a = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        void a() {
            if (b() == Operation.LifecycleImpact.ADDING) {
                Fragment a2 = this.f3009a.a();
                View findFocus = a2.mView.findFocus();
                if (findFocus != null) {
                    a2.setFocusedView(findFocus);
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + a2);
                    }
                }
                View requireView = getFragment().requireView();
                if (requireView.getParent() == null) {
                    this.f3009a.s();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(a2.getPostOnViewCreatedAlpha());
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.f3009a.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/SpecialEffectsController$Operation.class */
    public static class Operation {

        /* renamed from: a  reason: collision with root package name */
        private State f3010a;
        private LifecycleImpact b;

        /* renamed from: c  reason: collision with root package name */
        private final Fragment f3011c;
        private final List<Runnable> d = new ArrayList();
        private final HashSet<CancellationSignal> e = new HashSet<>();
        private boolean f = false;
        private boolean g = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact.class */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/SpecialEffectsController$Operation$State.class */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* JADX INFO: Access modifiers changed from: package-private */
            public static State a(int i) {
                if (i != 0) {
                    if (i != 4) {
                        if (i == 8) {
                            return GONE;
                        }
                        throw new IllegalArgumentException("Unknown visibility " + i);
                    }
                    return INVISIBLE;
                }
                return VISIBLE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static State a(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : a(view.getVisibility());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void b(View view) {
                int i = AnonymousClass3.f3008a[ordinal()];
                if (i == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i == 2) {
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (i == 3) {
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                } else if (i != 4) {
                } else {
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }
        }

        Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, CancellationSignal cancellationSignal) {
            this.f3010a = state;
            this.b = lifecycleImpact;
            this.f3011c = fragment;
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.SpecialEffectsController.Operation.1
                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    Operation.this.d();
                }
            });
        }

        void a() {
        }

        final void a(State state, LifecycleImpact lifecycleImpact) {
            int i = AnonymousClass3.b[lifecycleImpact.ordinal()];
            if (i == 1) {
                if (this.f3010a == State.REMOVED) {
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3011c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                    }
                    this.f3010a = State.VISIBLE;
                    this.b = LifecycleImpact.ADDING;
                }
            } else if (i == 2) {
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3011c + " mFinalState = " + this.f3010a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
                }
                this.f3010a = State.REMOVED;
                this.b = LifecycleImpact.REMOVING;
            } else if (i == 3 && this.f3010a != State.REMOVED) {
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3011c + " mFinalState = " + this.f3010a + " -> " + state + ". ");
                }
                this.f3010a = state;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.d.add(runnable);
        }

        LifecycleImpact b() {
            return this.b;
        }

        final boolean c() {
            return this.f;
        }

        public void complete() {
            if (this.g) {
                return;
            }
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            for (Runnable runnable : this.d) {
                runnable.run();
            }
        }

        public final void completeSpecialEffect(CancellationSignal cancellationSignal) {
            if (this.e.remove(cancellationSignal) && this.e.isEmpty()) {
                complete();
            }
        }

        final void d() {
            if (c()) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                complete();
                return;
            }
            Iterator it = new ArrayList(this.e).iterator();
            while (it.hasNext()) {
                ((CancellationSignal) it.next()).cancel();
            }
        }

        final boolean e() {
            return this.g;
        }

        public State getFinalState() {
            return this.f3010a;
        }

        public final Fragment getFragment() {
            return this.f3011c;
        }

        public final void markStartedSpecialEffect(CancellationSignal cancellationSignal) {
            a();
            this.e.add(cancellationSignal);
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f3010a + "} {mLifecycleImpact = " + this.b + "} {mFragment = " + this.f3011c + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpecialEffectsController(ViewGroup viewGroup) {
        this.e = viewGroup;
    }

    private Operation a(Fragment fragment) {
        Iterator<Operation> it = this.f3004a.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getFragment().equals(fragment) && !next.c()) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpecialEffectsController a(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return a(viewGroup, fragmentManager.y());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpecialEffectsController a(ViewGroup viewGroup, SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController createController = specialEffectsControllerFactory.createController(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, createController);
        return createController;
    }

    private void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        synchronized (this.f3004a) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Operation a2 = a(fragmentStateManager.a());
            if (a2 != null) {
                a2.a(state, lifecycleImpact);
                return;
            }
            final FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.f3004a.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialEffectsController.this.f3004a.contains(fragmentStateManagerOperation)) {
                        fragmentStateManagerOperation.getFinalState().b(fragmentStateManagerOperation.getFragment().mView);
                    }
                }
            });
            fragmentStateManagerOperation.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.2
                @Override // java.lang.Runnable
                public void run() {
                    SpecialEffectsController.this.f3004a.remove(fragmentStateManagerOperation);
                    SpecialEffectsController.this.b.remove(fragmentStateManagerOperation);
                }
            });
        }
    }

    private Operation b(Fragment fragment) {
        Iterator<Operation> it = this.b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getFragment().equals(fragment) && !next.c()) {
                return next;
            }
        }
        return null;
    }

    private void e() {
        Iterator<Operation> it = this.f3004a.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.b() == Operation.LifecycleImpact.ADDING) {
                next.a(Operation.State.a(next.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Operation.LifecycleImpact a(FragmentStateManager fragmentStateManager) {
        Operation a2 = a(fragmentStateManager.a());
        Operation.LifecycleImpact b = a2 != null ? a2.b() : null;
        Operation b2 = b(fragmentStateManager.a());
        return (b2 == null || !(b == null || b == Operation.LifecycleImpact.NONE)) ? b : b2.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f3004a) {
            e();
            this.d = false;
            int size = this.f3004a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                Operation operation = this.f3004a.get(i);
                Operation.State a2 = Operation.State.a(operation.getFragment().mView);
                if (operation.getFinalState() == Operation.State.VISIBLE && a2 != Operation.State.VISIBLE) {
                    this.d = operation.getFragment().isPostponed();
                    break;
                }
                size = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Operation.State state, FragmentStateManager fragmentStateManager) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.a());
        }
        a(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    abstract void a(List<Operation> list, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f3005c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.d) {
            this.d = false;
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.a());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.d) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow(this.e)) {
            d();
            this.f3005c = false;
            return;
        }
        synchronized (this.f3004a) {
            if (!this.f3004a.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.b);
                this.b.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Operation operation = (Operation) it.next();
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                    }
                    operation.d();
                    if (!operation.e()) {
                        this.b.add(operation);
                    }
                }
                e();
                ArrayList arrayList2 = new ArrayList(this.f3004a);
                this.f3004a.clear();
                this.b.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Operation) it2.next()).a();
                }
                a(arrayList2, this.f3005c);
                this.f3005c = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.a());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        String str;
        String str2;
        boolean isAttachedToWindow = ViewCompat.isAttachedToWindow(this.e);
        synchronized (this.f3004a) {
            e();
            Iterator<Operation> it = this.f3004a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            Iterator it2 = new ArrayList(this.b).iterator();
            while (it2.hasNext()) {
                Operation operation = (Operation) it2.next();
                if (FragmentManager.a(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.e + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    Log.v("FragmentManager", sb.toString());
                }
                operation.d();
            }
            Iterator it3 = new ArrayList(this.f3004a).iterator();
            while (it3.hasNext()) {
                Operation operation2 = (Operation) it3.next();
                if (FragmentManager.a(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.e + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(operation2);
                    Log.v("FragmentManager", sb2.toString());
                }
                operation2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.a());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public ViewGroup getContainer() {
        return this.e;
    }
}
