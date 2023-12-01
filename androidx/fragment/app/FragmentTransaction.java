package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTransaction.class */
public abstract class FragmentTransaction {
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;

    /* renamed from: a  reason: collision with root package name */
    private final FragmentFactory f3011a;
    private final ClassLoader b;
    ArrayList<Op> d;
    int e;
    int f;
    int g;
    int h;
    int i;
    boolean j;
    boolean k;
    String l;
    int m;
    CharSequence n;
    int o;
    CharSequence p;
    ArrayList<String> q;
    ArrayList<String> r;
    boolean s;
    ArrayList<Runnable> t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTransaction$Op.class */
    public static final class Op {

        /* renamed from: a  reason: collision with root package name */
        int f3012a;
        Fragment b;

        /* renamed from: c  reason: collision with root package name */
        int f3013c;
        int d;
        int e;
        int f;
        Lifecycle.State g;
        Lifecycle.State h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Op() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Op(int i, Fragment fragment) {
            this.f3012a = i;
            this.b = fragment;
            this.g = Lifecycle.State.RESUMED;
            this.h = Lifecycle.State.RESUMED;
        }

        Op(int i, Fragment fragment, Lifecycle.State state) {
            this.f3012a = i;
            this.b = fragment;
            this.g = fragment.mMaxState;
            this.h = state;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.d = new ArrayList<>();
        this.k = true;
        this.s = false;
        this.f3011a = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.d = new ArrayList<>();
        this.k = true;
        this.s = false;
        this.f3011a = fragmentFactory;
        this.b = classLoader;
    }

    private Fragment a(Class<? extends Fragment> cls, Bundle bundle) {
        FragmentFactory fragmentFactory = this.f3011a;
        if (fragmentFactory != null) {
            ClassLoader classLoader = this.b;
            if (classLoader != null) {
                Fragment instantiate = fragmentFactory.instantiate(classLoader, cls.getName());
                if (bundle != null) {
                    instantiate.setArguments(bundle);
                }
                return instantiate;
            }
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentTransaction a(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return add(viewGroup.getId(), fragment, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            } else {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            }
        }
        a(new Op(i2, fragment));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Op op) {
        this.d.add(op);
        op.f3013c = this.e;
        op.d = this.f;
        op.e = this.g;
        op.f = this.h;
    }

    public FragmentTransaction add(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public FragmentTransaction add(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    public final FragmentTransaction add(int i, Class<? extends Fragment> cls, Bundle bundle) {
        return add(i, a(cls, bundle));
    }

    public final FragmentTransaction add(int i, Class<? extends Fragment> cls, Bundle bundle, String str) {
        return add(i, a(cls, bundle), str);
    }

    public FragmentTransaction add(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public final FragmentTransaction add(Class<? extends Fragment> cls, Bundle bundle, String str) {
        return add(a(cls, bundle), str);
    }

    public FragmentTransaction addSharedElement(View view, String str) {
        if (FragmentTransition.a()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                if (this.q == null) {
                    this.q = new ArrayList<>();
                    this.r = new ArrayList<>();
                } else if (this.r.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.q.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                }
                this.q.add(transitionName);
                this.r.add(str);
                return this;
            }
            throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        }
        return this;
    }

    public FragmentTransaction addToBackStack(String str) {
        if (this.k) {
            this.j = true;
            this.l = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public FragmentTransaction attach(Fragment fragment) {
        a(new Op(7, fragment));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public FragmentTransaction detach(Fragment fragment) {
        a(new Op(6, fragment));
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if (this.j) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.k = false;
        return this;
    }

    public FragmentTransaction hide(Fragment fragment) {
        a(new Op(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.k;
    }

    public boolean isEmpty() {
        return this.d.isEmpty();
    }

    public FragmentTransaction remove(Fragment fragment) {
        a(new Op(3, fragment));
        return this;
    }

    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, (String) null);
    }

    public FragmentTransaction replace(int i, Fragment fragment, String str) {
        if (i != 0) {
            a(i, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public final FragmentTransaction replace(int i, Class<? extends Fragment> cls, Bundle bundle) {
        return replace(i, cls, bundle, null);
    }

    public final FragmentTransaction replace(int i, Class<? extends Fragment> cls, Bundle bundle, String str) {
        return replace(i, a(cls, bundle), str);
    }

    public FragmentTransaction runOnCommit(Runnable runnable) {
        disallowAddToBackStack();
        if (this.t == null) {
            this.t = new ArrayList<>();
        }
        this.t.add(runnable);
        return this;
    }

    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean z) {
        return setReorderingAllowed(z);
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(int i) {
        this.o = i;
        this.p = null;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.o = 0;
        this.p = charSequence;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(int i) {
        this.m = i;
        this.n = null;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.m = 0;
        this.n = charSequence;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int i, int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        return this;
    }

    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        a(new Op(10, fragment, state));
        return this;
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        a(new Op(8, fragment));
        return this;
    }

    public FragmentTransaction setReorderingAllowed(boolean z) {
        this.s = z;
        return this;
    }

    public FragmentTransaction setTransition(int i) {
        this.i = i;
        return this;
    }

    @Deprecated
    public FragmentTransaction setTransitionStyle(int i) {
        return this;
    }

    public FragmentTransaction show(Fragment fragment) {
        a(new Op(5, fragment));
        return this;
    }
}
