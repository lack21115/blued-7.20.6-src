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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentStateManager.class */
public class FragmentStateManager {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentLifecycleCallbacksDispatcher f2951a;
    private final FragmentStore b;

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f2952c;
    private boolean d = false;
    private int e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.fragment.app.FragmentStateManager$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentStateManager$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2954a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f2954a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2954a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2954a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2954a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment) {
        this.f2951a = fragmentLifecycleCallbacksDispatcher;
        this.b = fragmentStore;
        this.f2952c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment, FragmentState fragmentState) {
        this.f2951a = fragmentLifecycleCallbacksDispatcher;
        this.b = fragmentStore;
        this.f2952c = fragment;
        fragment.mSavedViewState = null;
        this.f2952c.mSavedViewRegistryState = null;
        this.f2952c.mBackStackNesting = 0;
        this.f2952c.mInLayout = false;
        this.f2952c.mAdded = false;
        Fragment fragment2 = this.f2952c;
        fragment2.mTargetWho = fragment2.mTarget != null ? this.f2952c.mTarget.mWho : null;
        this.f2952c.mTarget = null;
        if (fragmentState.m != null) {
            this.f2952c.mSavedFragmentState = fragmentState.m;
        } else {
            this.f2952c.mSavedFragmentState = new Bundle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, ClassLoader classLoader, FragmentFactory fragmentFactory, FragmentState fragmentState) {
        this.f2951a = fragmentLifecycleCallbacksDispatcher;
        this.b = fragmentStore;
        this.f2952c = fragmentFactory.instantiate(classLoader, fragmentState.f2949a);
        if (fragmentState.j != null) {
            fragmentState.j.setClassLoader(classLoader);
        }
        this.f2952c.setArguments(fragmentState.j);
        this.f2952c.mWho = fragmentState.b;
        this.f2952c.mFromLayout = fragmentState.f2950c;
        this.f2952c.mRestored = true;
        this.f2952c.mFragmentId = fragmentState.d;
        this.f2952c.mContainerId = fragmentState.e;
        this.f2952c.mTag = fragmentState.f;
        this.f2952c.mRetainInstance = fragmentState.g;
        this.f2952c.mRemoving = fragmentState.h;
        this.f2952c.mDetached = fragmentState.i;
        this.f2952c.mHidden = fragmentState.k;
        this.f2952c.mMaxState = Lifecycle.State.values()[fragmentState.l];
        if (fragmentState.m != null) {
            this.f2952c.mSavedFragmentState = fragmentState.m;
        } else {
            this.f2952c.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f2952c);
        }
    }

    private boolean a(View view) {
        if (view == this.f2952c.mView) {
            return true;
        }
        ViewParent parent = view.getParent();
        while (true) {
            ViewParent viewParent = parent;
            if (viewParent == null) {
                return false;
            }
            if (viewParent == this.f2952c.mView) {
                return true;
            }
            parent = viewParent.getParent();
        }
    }

    private Bundle t() {
        Bundle bundle = new Bundle();
        this.f2952c.performSaveInstanceState(bundle);
        this.f2951a.d(this.f2952c, bundle, false);
        Bundle bundle2 = bundle;
        if (bundle.isEmpty()) {
            bundle2 = null;
        }
        if (this.f2952c.mView != null) {
            o();
        }
        Bundle bundle3 = bundle2;
        if (this.f2952c.mSavedViewState != null) {
            bundle3 = bundle2;
            if (bundle2 == null) {
                bundle3 = new Bundle();
            }
            bundle3.putSparseParcelableArray("android:view_state", this.f2952c.mSavedViewState);
        }
        Bundle bundle4 = bundle3;
        if (this.f2952c.mSavedViewRegistryState != null) {
            bundle4 = bundle3;
            if (bundle3 == null) {
                bundle4 = new Bundle();
            }
            bundle4.putBundle("android:view_registry_state", this.f2952c.mSavedViewRegistryState);
        }
        Bundle bundle5 = bundle4;
        if (!this.f2952c.mUserVisibleHint) {
            bundle5 = bundle4;
            if (bundle4 == null) {
                bundle5 = new Bundle();
            }
            bundle5.putBoolean("android:user_visible_hint", this.f2952c.mUserVisibleHint);
        }
        return bundle5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a() {
        return this.f2952c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ClassLoader classLoader) {
        if (this.f2952c.mSavedFragmentState == null) {
            return;
        }
        this.f2952c.mSavedFragmentState.setClassLoader(classLoader);
        Fragment fragment = this.f2952c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f2952c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f2952c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        if (this.f2952c.mTargetWho != null) {
            Fragment fragment4 = this.f2952c;
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        if (this.f2952c.mSavedUserVisibleHint != null) {
            Fragment fragment5 = this.f2952c;
            fragment5.mUserVisibleHint = fragment5.mSavedUserVisibleHint.booleanValue();
            this.f2952c.mSavedUserVisibleHint = null;
        } else {
            Fragment fragment6 = this.f2952c;
            fragment6.mUserVisibleHint = fragment6.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (this.f2952c.mUserVisibleHint) {
            return;
        }
        this.f2952c.mDeferStart = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i;
        if (this.f2952c.mFragmentManager == null) {
            return this.f2952c.mState;
        }
        int i2 = this.e;
        int i3 = AnonymousClass2.f2954a[this.f2952c.mMaxState.ordinal()];
        int i4 = i2;
        if (i3 != 1) {
            i4 = i3 != 2 ? i3 != 3 ? i3 != 4 ? Math.min(i2, -1) : Math.min(i2, 0) : Math.min(i2, 1) : Math.min(i2, 5);
        }
        int i5 = i4;
        if (this.f2952c.mFromLayout) {
            if (this.f2952c.mInLayout) {
                int max = Math.max(this.e, 2);
                i5 = max;
                if (this.f2952c.mView != null) {
                    i5 = max;
                    if (this.f2952c.mView.getParent() == null) {
                        i5 = Math.min(max, 2);
                    }
                }
            } else {
                i5 = this.e < 4 ? Math.min(i4, this.f2952c.mState) : Math.min(i4, 1);
            }
        }
        int i6 = i5;
        if (!this.f2952c.mAdded) {
            i6 = Math.min(i5, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = null;
        if (FragmentManager.f2919a) {
            lifecycleImpact = null;
            if (this.f2952c.mContainer != null) {
                lifecycleImpact = SpecialEffectsController.a(this.f2952c.mContainer, this.f2952c.getParentFragmentManager()).a(this);
            }
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i = Math.min(i6, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i = Math.max(i6, 3);
        } else {
            i = i6;
            if (this.f2952c.mRemoving) {
                i = this.f2952c.isInBackStack() ? Math.min(i6, 1) : Math.min(i6, -1);
            }
        }
        int i7 = i;
        if (this.f2952c.mDeferStart) {
            i7 = i;
            if (this.f2952c.mState < 5) {
                i7 = Math.min(i, 4);
            }
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i7 + " for " + this.f2952c);
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
                if (b == this.f2952c.mState) {
                    if (FragmentManager.f2919a && this.f2952c.mHiddenChanged) {
                        if (this.f2952c.mView != null && this.f2952c.mContainer != null) {
                            SpecialEffectsController a2 = SpecialEffectsController.a(this.f2952c.mContainer, this.f2952c.getParentFragmentManager());
                            if (this.f2952c.mHidden) {
                                a2.c(this);
                            } else {
                                a2.b(this);
                            }
                        }
                        if (this.f2952c.mFragmentManager != null) {
                            this.f2952c.mFragmentManager.q(this.f2952c);
                        }
                        this.f2952c.mHiddenChanged = false;
                        this.f2952c.onHiddenChanged(this.f2952c.mHidden);
                    }
                    return;
                } else if (b > this.f2952c.mState) {
                    switch (this.f2952c.mState + 1) {
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
                            if (this.f2952c.mView != null && this.f2952c.mContainer != null) {
                                SpecialEffectsController.a(this.f2952c.mContainer, this.f2952c.getParentFragmentManager()).a(SpecialEffectsController.Operation.State.a(this.f2952c.mView.getVisibility()), this);
                            }
                            this.f2952c.mState = 4;
                            continue;
                        case 5:
                            i();
                            continue;
                        case 6:
                            this.f2952c.mState = 6;
                            continue;
                        case 7:
                            j();
                            continue;
                    }
                } else {
                    switch (this.f2952c.mState - 1) {
                        case -1:
                            r();
                            continue;
                        case 0:
                            q();
                            continue;
                        case 1:
                            p();
                            this.f2952c.mState = 1;
                            continue;
                        case 2:
                            this.f2952c.mInLayout = false;
                            this.f2952c.mState = 2;
                            continue;
                        case 3:
                            if (FragmentManager.a(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f2952c);
                            }
                            if (this.f2952c.mView != null && this.f2952c.mSavedViewState == null) {
                                o();
                            }
                            if (this.f2952c.mView != null && this.f2952c.mContainer != null) {
                                SpecialEffectsController.a(this.f2952c.mContainer, this.f2952c.getParentFragmentManager()).d(this);
                            }
                            this.f2952c.mState = 3;
                            continue;
                        case 4:
                            l();
                            continue;
                        case 5:
                            this.f2952c.mState = 5;
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
        if (this.f2952c.mFromLayout && this.f2952c.mInLayout && !this.f2952c.mPerformedCreateView) {
            if (FragmentManager.a(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2952c);
            }
            Fragment fragment = this.f2952c;
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, this.f2952c.mSavedFragmentState);
            if (this.f2952c.mView != null) {
                this.f2952c.mView.setSaveFromParentEnabled(false);
                this.f2952c.mView.setTag(R.id.fragment_container_view_tag, this.f2952c);
                if (this.f2952c.mHidden) {
                    this.f2952c.mView.setVisibility(8);
                }
                this.f2952c.performViewCreated();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f2951a;
                Fragment fragment2 = this.f2952c;
                fragmentLifecycleCallbacksDispatcher.a(fragment2, fragment2.mView, this.f2952c.mSavedFragmentState, false);
                this.f2952c.mState = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f2952c);
        }
        FragmentStateManager fragmentStateManager = null;
        if (this.f2952c.mTarget != null) {
            fragmentStateManager = this.b.c(this.f2952c.mTarget.mWho);
            if (fragmentStateManager == null) {
                throw new IllegalStateException("Fragment " + this.f2952c + " declared target fragment " + this.f2952c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment = this.f2952c;
            fragment.mTargetWho = fragment.mTarget.mWho;
            this.f2952c.mTarget = null;
        } else if (this.f2952c.mTargetWho != null) {
            fragmentStateManager = this.b.c(this.f2952c.mTargetWho);
            if (fragmentStateManager == null) {
                throw new IllegalStateException("Fragment " + this.f2952c + " declared target fragment " + this.f2952c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (fragmentStateManager != null && (FragmentManager.f2919a || fragmentStateManager.a().mState < 1)) {
            fragmentStateManager.c();
        }
        Fragment fragment2 = this.f2952c;
        fragment2.mHost = fragment2.mFragmentManager.h();
        Fragment fragment3 = this.f2952c;
        fragment3.mParentFragment = fragment3.mFragmentManager.i();
        this.f2951a.a(this.f2952c, false);
        this.f2952c.performAttach();
        this.f2951a.b(this.f2952c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f2952c);
        }
        if (this.f2952c.mIsCreated) {
            Fragment fragment = this.f2952c;
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f2952c.mState = 1;
            return;
        }
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f2951a;
        Fragment fragment2 = this.f2952c;
        fragmentLifecycleCallbacksDispatcher.a(fragment2, fragment2.mSavedFragmentState, false);
        Fragment fragment3 = this.f2952c;
        fragment3.performCreate(fragment3.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher2 = this.f2951a;
        Fragment fragment4 = this.f2952c;
        fragmentLifecycleCallbacksDispatcher2.b(fragment4, fragment4.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        String str;
        if (this.f2952c.mFromLayout) {
            return;
        }
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2952c);
        }
        Fragment fragment = this.f2952c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        if (this.f2952c.mContainer != null) {
            viewGroup = this.f2952c.mContainer;
        } else if (this.f2952c.mContainerId != 0) {
            if (this.f2952c.mContainerId == -1) {
                throw new IllegalArgumentException("Cannot create fragment " + this.f2952c + " for a container view with no id");
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f2952c.mFragmentManager.j().onFindViewById(this.f2952c.mContainerId);
            viewGroup = viewGroup2;
            if (viewGroup2 == null) {
                if (!this.f2952c.mRestored) {
                    try {
                        str = this.f2952c.getResources().getResourceName(this.f2952c.mContainerId);
                    } catch (Resources.NotFoundException e) {
                        str = "unknown";
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f2952c.mContainerId) + " (" + str + ") for fragment " + this.f2952c);
                }
                viewGroup = viewGroup2;
            }
        }
        this.f2952c.mContainer = viewGroup;
        Fragment fragment2 = this.f2952c;
        fragment2.performCreateView(performGetLayoutInflater, viewGroup, fragment2.mSavedFragmentState);
        if (this.f2952c.mView != null) {
            this.f2952c.mView.setSaveFromParentEnabled(false);
            this.f2952c.mView.setTag(R.id.fragment_container_view_tag, this.f2952c);
            if (viewGroup != null) {
                s();
            }
            if (this.f2952c.mHidden) {
                this.f2952c.mView.setVisibility(8);
            }
            if (ViewCompat.isAttachedToWindow(this.f2952c.mView)) {
                ViewCompat.requestApplyInsets(this.f2952c.mView);
            } else {
                final View view = this.f2952c.mView;
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
            this.f2952c.performViewCreated();
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f2951a;
            Fragment fragment3 = this.f2952c;
            fragmentLifecycleCallbacksDispatcher.a(fragment3, fragment3.mView, this.f2952c.mSavedFragmentState, false);
            int visibility = this.f2952c.mView.getVisibility();
            float alpha = this.f2952c.mView.getAlpha();
            if (FragmentManager.f2919a) {
                this.f2952c.setPostOnViewCreatedAlpha(alpha);
                if (this.f2952c.mContainer != null && visibility == 0) {
                    View findFocus = this.f2952c.mView.findFocus();
                    if (findFocus != null) {
                        this.f2952c.setFocusedView(findFocus);
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f2952c);
                        }
                    }
                    this.f2952c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment4 = this.f2952c;
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
        this.f2952c.mState = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f2952c);
        }
        Fragment fragment = this.f2952c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f2951a;
        Fragment fragment2 = this.f2952c;
        fragmentLifecycleCallbacksDispatcher.c(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f2952c);
        }
        this.f2952c.performStart();
        this.f2951a.c(this.f2952c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f2952c);
        }
        View focusedView = this.f2952c.getFocusedView();
        if (focusedView != null && a(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.a(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f2952c);
                sb.append(" resulting in focused view ");
                sb.append(this.f2952c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f2952c.setFocusedView(null);
        this.f2952c.performResume();
        this.f2951a.d(this.f2952c, false);
        this.f2952c.mSavedFragmentState = null;
        this.f2952c.mSavedViewState = null;
        this.f2952c.mSavedViewRegistryState = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f2952c);
        }
        this.f2952c.performPause();
        this.f2951a.e(this.f2952c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f2952c);
        }
        this.f2952c.performStop();
        this.f2951a.f(this.f2952c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState m() {
        FragmentState fragmentState = new FragmentState(this.f2952c);
        if (this.f2952c.mState <= -1 || fragmentState.m != null) {
            fragmentState.m = this.f2952c.mSavedFragmentState;
        } else {
            fragmentState.m = t();
            if (this.f2952c.mTargetWho != null) {
                if (fragmentState.m == null) {
                    fragmentState.m = new Bundle();
                }
                fragmentState.m.putString("android:target_state", this.f2952c.mTargetWho);
                if (this.f2952c.mTargetRequestCode != 0) {
                    fragmentState.m.putInt("android:target_req_state", this.f2952c.mTargetRequestCode);
                    return fragmentState;
                }
            }
        }
        return fragmentState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment.SavedState n() {
        Fragment.SavedState savedState = null;
        if (this.f2952c.mState > -1) {
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
        if (this.f2952c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f2952c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f2952c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f2952c.mViewLifecycleOwner.b(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f2952c.mSavedViewRegistryState = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f2952c);
        }
        if (this.f2952c.mContainer != null && this.f2952c.mView != null) {
            this.f2952c.mContainer.removeView(this.f2952c.mView);
        }
        this.f2952c.performDestroyView();
        this.f2951a.g(this.f2952c, false);
        this.f2952c.mContainer = null;
        this.f2952c.mView = null;
        this.f2952c.mViewLifecycleOwner = null;
        this.f2952c.mViewLifecycleOwnerLiveData.setValue(null);
        this.f2952c.mInLayout = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        Fragment e;
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f2952c);
        }
        boolean z = true;
        boolean z2 = this.f2952c.mRemoving && !this.f2952c.isInBackStack();
        if (!(z2 || this.b.a().b(this.f2952c))) {
            if (this.f2952c.mTargetWho != null && (e = this.b.e(this.f2952c.mTargetWho)) != null && e.mRetainInstance) {
                this.f2952c.mTarget = e;
            }
            this.f2952c.mState = 0;
            return;
        }
        FragmentHostCallback<?> fragmentHostCallback = this.f2952c.mHost;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            z = this.b.a().a();
        } else if (fragmentHostCallback.getContext() instanceof Activity) {
            z = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
        }
        if (z2 || z) {
            this.b.a().f(this.f2952c);
        }
        this.f2952c.performDestroy();
        this.f2951a.h(this.f2952c, false);
        for (FragmentStateManager fragmentStateManager : this.b.g()) {
            if (fragmentStateManager != null) {
                Fragment a2 = fragmentStateManager.a();
                if (this.f2952c.mWho.equals(a2.mTargetWho)) {
                    a2.mTarget = this.f2952c;
                    a2.mTargetWho = null;
                }
            }
        }
        if (this.f2952c.mTargetWho != null) {
            Fragment fragment = this.f2952c;
            fragment.mTarget = this.b.e(fragment.mTargetWho);
        }
        this.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f2952c);
        }
        this.f2952c.performDetach();
        this.f2951a.i(this.f2952c, false);
        this.f2952c.mState = -1;
        this.f2952c.mHost = null;
        this.f2952c.mParentFragment = null;
        this.f2952c.mFragmentManager = null;
        boolean z = false;
        if (this.f2952c.mRemoving) {
            z = false;
            if (!this.f2952c.isInBackStack()) {
                z = true;
            }
        }
        if (z || this.b.a().b(this.f2952c)) {
            if (FragmentManager.a(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f2952c);
            }
            this.f2952c.initState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f2952c.mContainer.addView(this.f2952c.mView, this.b.c(this.f2952c));
    }
}
