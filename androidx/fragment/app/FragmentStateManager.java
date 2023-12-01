package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.alipay.sdk.util.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentStateManager.class */
public class FragmentStateManager {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentLifecycleCallbacksDispatcher f2999a;
    private final FragmentStore b;

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f3000c;
    private boolean d = false;
    private int e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.fragment.app.FragmentStateManager$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentStateManager$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3002a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f3002a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3002a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3002a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3002a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment) {
        this.f2999a = fragmentLifecycleCallbacksDispatcher;
        this.b = fragmentStore;
        this.f3000c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment, FragmentState fragmentState) {
        this.f2999a = fragmentLifecycleCallbacksDispatcher;
        this.b = fragmentStore;
        this.f3000c = fragment;
        fragment.mSavedViewState = null;
        this.f3000c.mSavedViewRegistryState = null;
        this.f3000c.mBackStackNesting = 0;
        this.f3000c.mInLayout = false;
        this.f3000c.mAdded = false;
        Fragment fragment2 = this.f3000c;
        fragment2.mTargetWho = fragment2.mTarget != null ? this.f3000c.mTarget.mWho : null;
        this.f3000c.mTarget = null;
        if (fragmentState.m != null) {
            this.f3000c.mSavedFragmentState = fragmentState.m;
        } else {
            this.f3000c.mSavedFragmentState = new Bundle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, ClassLoader classLoader, FragmentFactory fragmentFactory, FragmentState fragmentState) {
        this.f2999a = fragmentLifecycleCallbacksDispatcher;
        this.b = fragmentStore;
        this.f3000c = fragmentFactory.instantiate(classLoader, fragmentState.f2997a);
        if (fragmentState.j != null) {
            fragmentState.j.setClassLoader(classLoader);
        }
        this.f3000c.setArguments(fragmentState.j);
        this.f3000c.mWho = fragmentState.b;
        this.f3000c.mFromLayout = fragmentState.f2998c;
        this.f3000c.mRestored = true;
        this.f3000c.mFragmentId = fragmentState.d;
        this.f3000c.mContainerId = fragmentState.e;
        this.f3000c.mTag = fragmentState.f;
        this.f3000c.mRetainInstance = fragmentState.g;
        this.f3000c.mRemoving = fragmentState.h;
        this.f3000c.mDetached = fragmentState.i;
        this.f3000c.mHidden = fragmentState.k;
        this.f3000c.mMaxState = Lifecycle.State.values()[fragmentState.l];
        if (fragmentState.m != null) {
            this.f3000c.mSavedFragmentState = fragmentState.m;
        } else {
            this.f3000c.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f3000c);
        }
    }

    private boolean a(View view) {
        if (view == this.f3000c.mView) {
            return true;
        }
        ViewParent parent = view.getParent();
        while (true) {
            ViewParent viewParent = parent;
            if (viewParent == null) {
                return false;
            }
            if (viewParent == this.f3000c.mView) {
                return true;
            }
            parent = viewParent.getParent();
        }
    }

    private Bundle t() {
        Bundle bundle = new Bundle();
        this.f3000c.performSaveInstanceState(bundle);
        this.f2999a.d(this.f3000c, bundle, false);
        Bundle bundle2 = bundle;
        if (bundle.isEmpty()) {
            bundle2 = null;
        }
        if (this.f3000c.mView != null) {
            o();
        }
        Bundle bundle3 = bundle2;
        if (this.f3000c.mSavedViewState != null) {
            bundle3 = bundle2;
            if (bundle2 == null) {
                bundle3 = new Bundle();
            }
            bundle3.putSparseParcelableArray("android:view_state", this.f3000c.mSavedViewState);
        }
        Bundle bundle4 = bundle3;
        if (this.f3000c.mSavedViewRegistryState != null) {
            bundle4 = bundle3;
            if (bundle3 == null) {
                bundle4 = new Bundle();
            }
            bundle4.putBundle("android:view_registry_state", this.f3000c.mSavedViewRegistryState);
        }
        Bundle bundle5 = bundle4;
        if (!this.f3000c.mUserVisibleHint) {
            bundle5 = bundle4;
            if (bundle4 == null) {
                bundle5 = new Bundle();
            }
            bundle5.putBoolean("android:user_visible_hint", this.f3000c.mUserVisibleHint);
        }
        return bundle5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a() {
        return this.f3000c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ClassLoader classLoader) {
        if (this.f3000c.mSavedFragmentState == null) {
            return;
        }
        this.f3000c.mSavedFragmentState.setClassLoader(classLoader);
        Fragment fragment = this.f3000c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f3000c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f3000c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        if (this.f3000c.mTargetWho != null) {
            Fragment fragment4 = this.f3000c;
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        if (this.f3000c.mSavedUserVisibleHint != null) {
            Fragment fragment5 = this.f3000c;
            fragment5.mUserVisibleHint = fragment5.mSavedUserVisibleHint.booleanValue();
            this.f3000c.mSavedUserVisibleHint = null;
        } else {
            Fragment fragment6 = this.f3000c;
            fragment6.mUserVisibleHint = fragment6.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (this.f3000c.mUserVisibleHint) {
            return;
        }
        this.f3000c.mDeferStart = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i;
        if (this.f3000c.mFragmentManager == null) {
            return this.f3000c.mState;
        }
        int i2 = this.e;
        int i3 = AnonymousClass2.f3002a[this.f3000c.mMaxState.ordinal()];
        int i4 = i2;
        if (i3 != 1) {
            i4 = i3 != 2 ? i3 != 3 ? i3 != 4 ? Math.min(i2, -1) : Math.min(i2, 0) : Math.min(i2, 1) : Math.min(i2, 5);
        }
        int i5 = i4;
        if (this.f3000c.mFromLayout) {
            if (this.f3000c.mInLayout) {
                int max = Math.max(this.e, 2);
                i5 = max;
                if (this.f3000c.mView != null) {
                    i5 = max;
                    if (this.f3000c.mView.getParent() == null) {
                        i5 = Math.min(max, 2);
                    }
                }
            } else {
                i5 = this.e < 4 ? Math.min(i4, this.f3000c.mState) : Math.min(i4, 1);
            }
        }
        int i6 = i5;
        if (!this.f3000c.mAdded) {
            i6 = Math.min(i5, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = null;
        if (FragmentManager.f2967a) {
            lifecycleImpact = null;
            if (this.f3000c.mContainer != null) {
                lifecycleImpact = SpecialEffectsController.a(this.f3000c.mContainer, this.f3000c.getParentFragmentManager()).a(this);
            }
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i = Math.min(i6, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i = Math.max(i6, 3);
        } else {
            i = i6;
            if (this.f3000c.mRemoving) {
                i = this.f3000c.isInBackStack() ? Math.min(i6, 1) : Math.min(i6, -1);
            }
        }
        int i7 = i;
        if (this.f3000c.mDeferStart) {
            i7 = i;
            if (this.f3000c.mState < 5) {
                i7 = Math.min(i, 4);
            }
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i7 + " for " + this.f3000c);
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.d) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + a());
                return;
            }
            return;
        }
        try {
            this.d = true;
            while (true) {
                int b = b();
                if (b == this.f3000c.mState) {
                    if (FragmentManager.f2967a && this.f3000c.mHiddenChanged) {
                        if (this.f3000c.mView != null && this.f3000c.mContainer != null) {
                            SpecialEffectsController a2 = SpecialEffectsController.a(this.f3000c.mContainer, this.f3000c.getParentFragmentManager());
                            if (this.f3000c.mHidden) {
                                a2.c(this);
                            } else {
                                a2.b(this);
                            }
                        }
                        if (this.f3000c.mFragmentManager != null) {
                            this.f3000c.mFragmentManager.q(this.f3000c);
                        }
                        this.f3000c.mHiddenChanged = false;
                        this.f3000c.onHiddenChanged(this.f3000c.mHidden);
                    }
                    return;
                } else if (b > this.f3000c.mState) {
                    switch (this.f3000c.mState + 1) {
                        case 0:
                            e();
                            continue;
                        case 1:
                            f();
                            continue;
                        case 2:
                            d();
                            g();
                            continue;
                        case 3:
                            h();
                            continue;
                        case 4:
                            if (this.f3000c.mView != null && this.f3000c.mContainer != null) {
                                SpecialEffectsController.a(this.f3000c.mContainer, this.f3000c.getParentFragmentManager()).a(SpecialEffectsController.Operation.State.a(this.f3000c.mView.getVisibility()), this);
                            }
                            this.f3000c.mState = 4;
                            continue;
                        case 5:
                            i();
                            continue;
                        case 6:
                            this.f3000c.mState = 6;
                            continue;
                        case 7:
                            j();
                            continue;
                    }
                } else {
                    switch (this.f3000c.mState - 1) {
                        case -1:
                            r();
                            continue;
                        case 0:
                            q();
                            continue;
                        case 1:
                            p();
                            this.f3000c.mState = 1;
                            continue;
                        case 2:
                            this.f3000c.mInLayout = false;
                            this.f3000c.mState = 2;
                            continue;
                        case 3:
                            if (FragmentManager.a(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f3000c);
                            }
                            if (this.f3000c.mView != null && this.f3000c.mSavedViewState == null) {
                                o();
                            }
                            if (this.f3000c.mView != null && this.f3000c.mContainer != null) {
                                SpecialEffectsController.a(this.f3000c.mContainer, this.f3000c.getParentFragmentManager()).d(this);
                            }
                            this.f3000c.mState = 3;
                            continue;
                        case 4:
                            l();
                            continue;
                        case 5:
                            this.f3000c.mState = 5;
                            continue;
                        case 6:
                            k();
                            continue;
                    }
                }
            }
        } finally {
            this.d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.f3000c.mFromLayout && this.f3000c.mInLayout && !this.f3000c.mPerformedCreateView) {
            if (FragmentManager.a(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3000c);
            }
            Fragment fragment = this.f3000c;
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, this.f3000c.mSavedFragmentState);
            if (this.f3000c.mView != null) {
                this.f3000c.mView.setSaveFromParentEnabled(false);
                this.f3000c.mView.setTag(R.id.fragment_container_view_tag, this.f3000c);
                if (this.f3000c.mHidden) {
                    this.f3000c.mView.setVisibility(8);
                }
                this.f3000c.performViewCreated();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f2999a;
                Fragment fragment2 = this.f3000c;
                fragmentLifecycleCallbacksDispatcher.a(fragment2, fragment2.mView, this.f3000c.mSavedFragmentState, false);
                this.f3000c.mState = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f3000c);
        }
        FragmentStateManager fragmentStateManager = null;
        if (this.f3000c.mTarget != null) {
            fragmentStateManager = this.b.c(this.f3000c.mTarget.mWho);
            if (fragmentStateManager == null) {
                throw new IllegalStateException("Fragment " + this.f3000c + " declared target fragment " + this.f3000c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment = this.f3000c;
            fragment.mTargetWho = fragment.mTarget.mWho;
            this.f3000c.mTarget = null;
        } else if (this.f3000c.mTargetWho != null) {
            fragmentStateManager = this.b.c(this.f3000c.mTargetWho);
            if (fragmentStateManager == null) {
                throw new IllegalStateException("Fragment " + this.f3000c + " declared target fragment " + this.f3000c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (fragmentStateManager != null && (FragmentManager.f2967a || fragmentStateManager.a().mState < 1)) {
            fragmentStateManager.c();
        }
        Fragment fragment2 = this.f3000c;
        fragment2.mHost = fragment2.mFragmentManager.h();
        Fragment fragment3 = this.f3000c;
        fragment3.mParentFragment = fragment3.mFragmentManager.i();
        this.f2999a.a(this.f3000c, false);
        this.f3000c.performAttach();
        this.f2999a.b(this.f3000c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f3000c);
        }
        if (this.f3000c.mIsCreated) {
            Fragment fragment = this.f3000c;
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f3000c.mState = 1;
            return;
        }
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f2999a;
        Fragment fragment2 = this.f3000c;
        fragmentLifecycleCallbacksDispatcher.a(fragment2, fragment2.mSavedFragmentState, false);
        Fragment fragment3 = this.f3000c;
        fragment3.performCreate(fragment3.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher2 = this.f2999a;
        Fragment fragment4 = this.f3000c;
        fragmentLifecycleCallbacksDispatcher2.b(fragment4, fragment4.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        String str;
        if (this.f3000c.mFromLayout) {
            return;
        }
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3000c);
        }
        Fragment fragment = this.f3000c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        if (this.f3000c.mContainer != null) {
            viewGroup = this.f3000c.mContainer;
        } else if (this.f3000c.mContainerId != 0) {
            if (this.f3000c.mContainerId == -1) {
                throw new IllegalArgumentException("Cannot create fragment " + this.f3000c + " for a container view with no id");
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f3000c.mFragmentManager.j().onFindViewById(this.f3000c.mContainerId);
            viewGroup = viewGroup2;
            if (viewGroup2 == null) {
                if (!this.f3000c.mRestored) {
                    try {
                        str = this.f3000c.getResources().getResourceName(this.f3000c.mContainerId);
                    } catch (Resources.NotFoundException e) {
                        str = "unknown";
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f3000c.mContainerId) + " (" + str + ") for fragment " + this.f3000c);
                }
                viewGroup = viewGroup2;
            }
        }
        this.f3000c.mContainer = viewGroup;
        Fragment fragment2 = this.f3000c;
        fragment2.performCreateView(performGetLayoutInflater, viewGroup, fragment2.mSavedFragmentState);
        if (this.f3000c.mView != null) {
            this.f3000c.mView.setSaveFromParentEnabled(false);
            this.f3000c.mView.setTag(R.id.fragment_container_view_tag, this.f3000c);
            if (viewGroup != null) {
                s();
            }
            if (this.f3000c.mHidden) {
                this.f3000c.mView.setVisibility(8);
            }
            if (ViewCompat.isAttachedToWindow(this.f3000c.mView)) {
                ViewCompat.requestApplyInsets(this.f3000c.mView);
            } else {
                final View view = this.f3000c.mView;
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentStateManager.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                        view.removeOnAttachStateChangeListener(this);
                        ViewCompat.requestApplyInsets(view);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                    }
                });
            }
            this.f3000c.performViewCreated();
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f2999a;
            Fragment fragment3 = this.f3000c;
            fragmentLifecycleCallbacksDispatcher.a(fragment3, fragment3.mView, this.f3000c.mSavedFragmentState, false);
            int visibility = this.f3000c.mView.getVisibility();
            float alpha = this.f3000c.mView.getAlpha();
            if (FragmentManager.f2967a) {
                this.f3000c.setPostOnViewCreatedAlpha(alpha);
                if (this.f3000c.mContainer != null && visibility == 0) {
                    View findFocus = this.f3000c.mView.findFocus();
                    if (findFocus != null) {
                        this.f3000c.setFocusedView(findFocus);
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f3000c);
                        }
                    }
                    this.f3000c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment4 = this.f3000c;
                boolean z = false;
                if (visibility == 0) {
                    z = false;
                    if (fragment4.mContainer != null) {
                        z = true;
                    }
                }
                fragment4.mIsNewlyAdded = z;
            }
        }
        this.f3000c.mState = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f3000c);
        }
        Fragment fragment = this.f3000c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f2999a;
        Fragment fragment2 = this.f3000c;
        fragmentLifecycleCallbacksDispatcher.c(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f3000c);
        }
        this.f3000c.performStart();
        this.f2999a.c(this.f3000c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f3000c);
        }
        View focusedView = this.f3000c.getFocusedView();
        if (focusedView != null && a(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.a(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : e.f4661a);
                sb.append(" on Fragment ");
                sb.append(this.f3000c);
                sb.append(" resulting in focused view ");
                sb.append(this.f3000c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f3000c.setFocusedView(null);
        this.f3000c.performResume();
        this.f2999a.d(this.f3000c, false);
        this.f3000c.mSavedFragmentState = null;
        this.f3000c.mSavedViewState = null;
        this.f3000c.mSavedViewRegistryState = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f3000c);
        }
        this.f3000c.performPause();
        this.f2999a.e(this.f3000c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f3000c);
        }
        this.f3000c.performStop();
        this.f2999a.f(this.f3000c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState m() {
        FragmentState fragmentState = new FragmentState(this.f3000c);
        if (this.f3000c.mState <= -1 || fragmentState.m != null) {
            fragmentState.m = this.f3000c.mSavedFragmentState;
        } else {
            fragmentState.m = t();
            if (this.f3000c.mTargetWho != null) {
                if (fragmentState.m == null) {
                    fragmentState.m = new Bundle();
                }
                fragmentState.m.putString("android:target_state", this.f3000c.mTargetWho);
                if (this.f3000c.mTargetRequestCode != 0) {
                    fragmentState.m.putInt("android:target_req_state", this.f3000c.mTargetRequestCode);
                    return fragmentState;
                }
            }
        }
        return fragmentState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment.SavedState n() {
        Fragment.SavedState savedState = null;
        if (this.f3000c.mState > -1) {
            Bundle t = t();
            savedState = null;
            if (t != null) {
                savedState = new Fragment.SavedState(t);
            }
        }
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (this.f3000c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f3000c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f3000c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f3000c.mViewLifecycleOwner.b(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f3000c.mSavedViewRegistryState = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f3000c);
        }
        if (this.f3000c.mContainer != null && this.f3000c.mView != null) {
            this.f3000c.mContainer.removeView(this.f3000c.mView);
        }
        this.f3000c.performDestroyView();
        this.f2999a.g(this.f3000c, false);
        this.f3000c.mContainer = null;
        this.f3000c.mView = null;
        this.f3000c.mViewLifecycleOwner = null;
        this.f3000c.mViewLifecycleOwnerLiveData.setValue(null);
        this.f3000c.mInLayout = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        Fragment e;
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f3000c);
        }
        boolean z = true;
        boolean z2 = this.f3000c.mRemoving && !this.f3000c.isInBackStack();
        if (!(z2 || this.b.a().b(this.f3000c))) {
            if (this.f3000c.mTargetWho != null && (e = this.b.e(this.f3000c.mTargetWho)) != null && e.mRetainInstance) {
                this.f3000c.mTarget = e;
            }
            this.f3000c.mState = 0;
            return;
        }
        FragmentHostCallback<?> fragmentHostCallback = this.f3000c.mHost;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            z = this.b.a().a();
        } else if (fragmentHostCallback.getContext() instanceof Activity) {
            z = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
        }
        if (z2 || z) {
            this.b.a().f(this.f3000c);
        }
        this.f3000c.performDestroy();
        this.f2999a.h(this.f3000c, false);
        for (FragmentStateManager fragmentStateManager : this.b.g()) {
            if (fragmentStateManager != null) {
                Fragment a2 = fragmentStateManager.a();
                if (this.f3000c.mWho.equals(a2.mTargetWho)) {
                    a2.mTarget = this.f3000c;
                    a2.mTargetWho = null;
                }
            }
        }
        if (this.f3000c.mTargetWho != null) {
            Fragment fragment = this.f3000c;
            fragment.mTarget = this.b.e(fragment.mTargetWho);
        }
        this.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f3000c);
        }
        this.f3000c.performDetach();
        this.f2999a.i(this.f3000c, false);
        this.f3000c.mState = -1;
        this.f3000c.mHost = null;
        this.f3000c.mParentFragment = null;
        this.f3000c.mFragmentManager = null;
        boolean z = false;
        if (this.f3000c.mRemoving) {
            z = false;
            if (!this.f3000c.isInBackStack()) {
                z = true;
            }
        }
        if (z || this.b.a().b(this.f3000c)) {
            if (FragmentManager.a(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f3000c);
            }
            this.f3000c.initState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f3000c.mContainer.addView(this.f3000c.mView, this.b.c(this.f3000c));
    }
}
