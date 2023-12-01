package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.igexin.push.core.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager.class */
public abstract class FragmentManager implements FragmentResultOwner {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    /* renamed from: a  reason: collision with root package name */
    static boolean f2919a = true;
    private static boolean f = false;
    private ActivityResultLauncher<Intent> C;
    private ActivityResultLauncher<IntentSenderRequest> D;
    private ActivityResultLauncher<String[]> E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private ArrayList<BackStackRecord> K;
    private ArrayList<Boolean> L;
    private ArrayList<Fragment> M;
    private ArrayList<StartEnterTransitionListener> N;
    private FragmentManagerViewModel O;
    ArrayList<BackStackRecord> b;
    Fragment d;
    private boolean h;
    private ArrayList<Fragment> j;
    private OnBackPressedDispatcher l;
    private ArrayList<OnBackStackChangedListener> q;
    private FragmentHostCallback<?> v;
    private FragmentContainer w;
    private Fragment x;
    private final ArrayList<OpGenerator> g = new ArrayList<>();
    private final FragmentStore i = new FragmentStore();
    private final FragmentLayoutInflaterFactory k = new FragmentLayoutInflaterFactory(this);
    private final OnBackPressedCallback m = new OnBackPressedCallback(false) { // from class: androidx.fragment.app.FragmentManager.1
        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            FragmentManager.this.a();
        }
    };
    private final AtomicInteger n = new AtomicInteger();
    private final Map<String, Bundle> o = Collections.synchronizedMap(new HashMap());
    private final Map<String, LifecycleAwareResultListener> p = Collections.synchronizedMap(new HashMap());
    private Map<Fragment, HashSet<CancellationSignal>> r = Collections.synchronizedMap(new HashMap());
    private final FragmentTransition.Callback s = new FragmentTransition.Callback() { // from class: androidx.fragment.app.FragmentManager.2
        @Override // androidx.fragment.app.FragmentTransition.Callback
        public void onComplete(Fragment fragment, CancellationSignal cancellationSignal) {
            if (cancellationSignal.isCanceled()) {
                return;
            }
            FragmentManager.this.b(fragment, cancellationSignal);
        }

        @Override // androidx.fragment.app.FragmentTransition.Callback
        public void onStart(Fragment fragment, CancellationSignal cancellationSignal) {
            FragmentManager.this.a(fragment, cancellationSignal);
        }
    };
    private final FragmentLifecycleCallbacksDispatcher t = new FragmentLifecycleCallbacksDispatcher(this);
    private final CopyOnWriteArrayList<FragmentOnAttachListener> u = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    int f2920c = -1;
    private FragmentFactory y = null;
    private FragmentFactory z = new FragmentFactory() { // from class: androidx.fragment.app.FragmentManager.3
        @Override // androidx.fragment.app.FragmentFactory
        public Fragment instantiate(ClassLoader classLoader, String str) {
            return FragmentManager.this.h().instantiate(FragmentManager.this.h().getContext(), str, null);
        }
    };
    private SpecialEffectsControllerFactory A = null;
    private SpecialEffectsControllerFactory B = new SpecialEffectsControllerFactory() { // from class: androidx.fragment.app.FragmentManager.4
        @Override // androidx.fragment.app.SpecialEffectsControllerFactory
        public SpecialEffectsController createController(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    };
    ArrayDeque<LaunchedFragmentInfo> e = new ArrayDeque<>();
    private Runnable P = new Runnable() { // from class: androidx.fragment.app.FragmentManager.5
        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.a(true);
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager$BackStackEntry.class */
    public interface BackStackEntry {
        @Deprecated
        CharSequence getBreadCrumbShortTitle();

        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Deprecated
        CharSequence getBreadCrumbTitle();

        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager$FragmentIntentSenderContract.class */
    public static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            Intent intent = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            IntentSenderRequest intentSenderRequest2 = intentSenderRequest;
            if (fillInIntent != null) {
                Bundle bundleExtra = fillInIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                intentSenderRequest2 = intentSenderRequest;
                if (bundleExtra != null) {
                    intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundleExtra);
                    fillInIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                    intentSenderRequest2 = intentSenderRequest;
                    if (fillInIntent.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        intentSenderRequest2 = new IntentSenderRequest.Builder(intentSenderRequest.getIntentSender()).setFillInIntent(null).setFlags(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).build();
                    }
                }
            }
            intent.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest2);
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks.class */
    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager$LaunchedFragmentInfo.class */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>() { // from class: androidx.fragment.app.FragmentManager.LaunchedFragmentInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LaunchedFragmentInfo[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        String f2934a;
        int b;

        LaunchedFragmentInfo(Parcel parcel) {
            this.f2934a = parcel.readString();
            this.b = parcel.readInt();
        }

        LaunchedFragmentInfo(String str, int i) {
            this.f2934a = str;
            this.b = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2934a);
            parcel.writeInt(this.b);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager$LifecycleAwareResultListener.class */
    static class LifecycleAwareResultListener implements FragmentResultListener {

        /* renamed from: a  reason: collision with root package name */
        private final Lifecycle f2935a;
        private final FragmentResultListener b;

        /* renamed from: c  reason: collision with root package name */
        private final LifecycleEventObserver f2936c;

        LifecycleAwareResultListener(Lifecycle lifecycle, FragmentResultListener fragmentResultListener, LifecycleEventObserver lifecycleEventObserver) {
            this.f2935a = lifecycle;
            this.b = fragmentResultListener;
            this.f2936c = lifecycleEventObserver;
        }

        public boolean isAtLeast(Lifecycle.State state) {
            return this.f2935a.getCurrentState().isAtLeast(state);
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(String str, Bundle bundle) {
            this.b.onFragmentResult(str, bundle);
        }

        public void removeObserver() {
            this.f2935a.removeObserver(this.f2936c);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager$OnBackStackChangedListener.class */
    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager$OpGenerator.class */
    public interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager$PopBackStackState.class */
    class PopBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        final String f2937a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final int f2938c;

        PopBackStackState(String str, int i, int i2) {
            this.f2937a = str;
            this.b = i;
            this.f2938c = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            if (FragmentManager.this.d == null || this.b >= 0 || this.f2937a != null || !FragmentManager.this.d.getChildFragmentManager().popBackStackImmediate()) {
                return FragmentManager.this.a(arrayList, arrayList2, this.f2937a, this.b, this.f2938c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManager$StartEnterTransitionListener.class */
    public static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {

        /* renamed from: a  reason: collision with root package name */
        final boolean f2939a;
        final BackStackRecord b;

        /* renamed from: c  reason: collision with root package name */
        private int f2940c;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.f2939a = z;
            this.b = backStackRecord;
        }

        void a() {
            boolean z = this.f2940c > 0;
            for (Fragment fragment : this.b.f2852a.getFragments()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            this.b.f2852a.a(this.b, this.f2939a, !z, true);
        }

        void b() {
            this.b.f2852a.a(this.b, this.f2939a, false, false);
        }

        public boolean isReady() {
            return this.f2940c == 0;
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void onStartEnterTransition() {
            int i = this.f2940c - 1;
            this.f2940c = i;
            if (i != 0) {
                return;
            }
            this.b.f2852a.d();
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void startListening() {
            this.f2940c++;
        }
    }

    private void C() {
        synchronized (this.g) {
            boolean z = true;
            if (!this.g.isEmpty()) {
                this.m.setEnabled(true);
                return;
            }
            OnBackPressedCallback onBackPressedCallback = this.m;
            if (getBackStackEntryCount() <= 0 || !a(this.x)) {
                z = false;
            }
            onBackPressedCallback.setEnabled(z);
        }
    }

    private void D() {
        for (FragmentStateManager fragmentStateManager : this.i.g()) {
            a(fragmentStateManager);
        }
    }

    private void E() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void F() {
        this.h = false;
        this.L.clear();
        this.K.clear();
    }

    private void G() {
        if (f2919a) {
            for (SpecialEffectsController specialEffectsController : I()) {
                specialEffectsController.b();
            }
        } else if (this.N != null) {
            while (!this.N.isEmpty()) {
                this.N.remove(0).a();
            }
        }
    }

    private void H() {
        if (f2919a) {
            for (SpecialEffectsController specialEffectsController : I()) {
                specialEffectsController.d();
            }
        } else if (!this.r.isEmpty()) {
            for (Fragment fragment : this.r.keySet()) {
                s(fragment);
                f(fragment);
            }
        }
    }

    private Set<SpecialEffectsController> I() {
        HashSet hashSet = new HashSet();
        for (FragmentStateManager fragmentStateManager : this.i.g()) {
            ViewGroup viewGroup = fragmentStateManager.a().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.a(viewGroup, y()));
            }
        }
        return hashSet;
    }

    private void J() {
        if (this.J) {
            this.J = false;
            D();
        }
    }

    private void K() {
        if (this.q == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.q.size()) {
                return;
            }
            this.q.get(i2).onBackStackChanged();
            i = i2 + 1;
        }
    }

    private int a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ArraySet<Fragment> arraySet) {
        int i3 = i2 - 1;
        int i4 = i2;
        while (true) {
            int i5 = i4;
            if (i3 < i) {
                return i5;
            }
            BackStackRecord backStackRecord = arrayList.get(i3);
            boolean booleanValue = arrayList2.get(i3).booleanValue();
            int i6 = i5;
            if (backStackRecord.b() && !backStackRecord.a(arrayList, i3 + 1, i2)) {
                if (this.N == null) {
                    this.N = new ArrayList<>();
                }
                StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                this.N.add(startEnterTransitionListener);
                backStackRecord.a(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.a();
                } else {
                    backStackRecord.b(false);
                }
                i6 = i5 - 1;
                if (i3 != i6) {
                    arrayList.remove(i3);
                    arrayList.add(i6, backStackRecord);
                }
                b(arraySet);
            }
            i3--;
            i4 = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Fragment a(View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private Set<SpecialEffectsController> a(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator<FragmentTransaction.Op> it = arrayList.get(i).d.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.a(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    private void a(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            Fragment valueAt = arraySet.valueAt(i2);
            if (!valueAt.mAdded) {
                View requireView = valueAt.requireView();
                valueAt.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
            i = i2 + 1;
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        FragmentHostCallback<?> fragmentHostCallback = this.v;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    private void a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int i;
        int indexOf;
        int indexOf2;
        ArrayList<StartEnterTransitionListener> arrayList3 = this.N;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = size;
            if (i3 >= i4) {
                return;
            }
            StartEnterTransitionListener startEnterTransitionListener = this.N.get(i3);
            if (arrayList == null || startEnterTransitionListener.f2939a || (indexOf2 = arrayList.indexOf(startEnterTransitionListener.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if (!startEnterTransitionListener.isReady()) {
                    size = i4;
                    i = i3;
                    if (arrayList != null) {
                        size = i4;
                        i = i3;
                        if (!startEnterTransitionListener.b.a(arrayList, 0, arrayList.size())) {
                        }
                    }
                }
                this.N.remove(i3);
                i = i3 - 1;
                size = i4 - 1;
                if (arrayList == null || startEnterTransitionListener.f2939a || (indexOf = arrayList.indexOf(startEnterTransitionListener.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                    startEnterTransitionListener.a();
                } else {
                    startEnterTransitionListener.b();
                }
            } else {
                this.N.remove(i3);
                i = i3 - 1;
                size = i4 - 1;
                startEnterTransitionListener.b();
            }
            i2 = i + 1;
        }
    }

    private void a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        boolean z = arrayList.get(i).s;
        ArrayList<Fragment> arrayList3 = this.M;
        if (arrayList3 == null) {
            this.M = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.M.addAll(this.i.h());
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z2 = false;
        for (int i4 = i; i4 < i2; i4++) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            primaryNavigationFragment = !arrayList2.get(i4).booleanValue() ? backStackRecord.a(this.M, primaryNavigationFragment) : backStackRecord.b(this.M, primaryNavigationFragment);
            z2 = z2 || backStackRecord.j;
        }
        this.M.clear();
        if (!z && this.f2920c >= 1) {
            if (f2919a) {
                int i5 = i;
                while (true) {
                    int i6 = i5;
                    if (i6 >= i2) {
                        break;
                    }
                    Iterator<FragmentTransaction.Op> it = arrayList.get(i6).d.iterator();
                    while (it.hasNext()) {
                        Fragment fragment = it.next().b;
                        if (fragment != null && fragment.mFragmentManager != null) {
                            this.i.a(h(fragment));
                        }
                    }
                    i5 = i6 + 1;
                }
            } else {
                FragmentTransition.a(this.v.getContext(), this.w, arrayList, arrayList2, i, i2, false, this.s);
            }
        }
        b(arrayList, arrayList2, i, i2);
        if (f2919a) {
            boolean booleanValue = arrayList2.get(i2 - 1).booleanValue();
            int i7 = i;
            while (true) {
                int i8 = i7;
                if (i8 >= i2) {
                    break;
                }
                BackStackRecord backStackRecord2 = arrayList.get(i8);
                if (booleanValue) {
                    int size = backStackRecord2.d.size();
                    while (true) {
                        int i9 = size - 1;
                        if (i9 >= 0) {
                            Fragment fragment2 = backStackRecord2.d.get(i9).b;
                            if (fragment2 != null) {
                                h(fragment2).c();
                            }
                            size = i9;
                        }
                    }
                } else {
                    Iterator<FragmentTransaction.Op> it2 = backStackRecord2.d.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment3 = it2.next().b;
                        if (fragment3 != null) {
                            h(fragment3).c();
                        }
                    }
                }
                i7 = i8 + 1;
            }
            a(this.f2920c, true);
            for (SpecialEffectsController specialEffectsController : a(arrayList, i, i2)) {
                specialEffectsController.a(booleanValue);
                specialEffectsController.a();
                specialEffectsController.c();
            }
        } else {
            if (z) {
                ArraySet<Fragment> arraySet = new ArraySet<>();
                b(arraySet);
                i3 = a(arrayList, arrayList2, i, i2, arraySet);
                a(arraySet);
            } else {
                i3 = i2;
            }
            if (i3 == i || !z) {
                arrayList2 = arrayList2;
            } else {
                if (this.f2920c >= 1) {
                    FragmentTransition.a(this.v.getContext(), this.w, arrayList, arrayList2, i, i3, true, this.s);
                }
                arrayList2 = arrayList2;
                a(this.f2920c, true);
            }
        }
        while (i < i2) {
            BackStackRecord backStackRecord3 = arrayList.get(i);
            if (arrayList2.get(i).booleanValue() && backStackRecord3.f2853c >= 0) {
                backStackRecord3.f2853c = -1;
            }
            backStackRecord3.runOnCommitRunnables();
            i++;
        }
        if (z2) {
            K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(int i) {
        return f || Log.isLoggable("FragmentManager", i);
    }

    private boolean a(String str, int i, int i2) {
        a(false);
        d(true);
        Fragment fragment = this.d;
        if (fragment == null || i >= 0 || str != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
            boolean a2 = a(this.K, this.L, str, i, i2);
            if (a2) {
                this.h = true;
                try {
                    b(this.K, this.L);
                } finally {
                    F();
                }
            }
            C();
            J();
            this.i.d();
            return a2;
        }
        return true;
    }

    private static Fragment b(View view) {
        while (view != null) {
            Fragment a2 = a(view);
            if (a2 != null) {
                return a2;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void b(ArraySet<Fragment> arraySet) {
        int i = this.f2920c;
        if (i < 1) {
            return;
        }
        int min = Math.min(i, 5);
        for (Fragment fragment : this.i.h()) {
            if (fragment.mState < min) {
                a(fragment, min);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    private void b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int i;
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        a(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= size) {
                break;
            }
            int i4 = i2;
            int i5 = i;
            if (!arrayList.get(i2).s) {
                if (i != i2) {
                    a(arrayList, arrayList2, i, i2);
                }
                int i6 = i2 + 1;
                i5 = i6;
                if (arrayList2.get(i2).booleanValue()) {
                    while (true) {
                        i5 = i6;
                        if (i6 >= size) {
                            break;
                        }
                        i5 = i6;
                        if (!arrayList2.get(i6).booleanValue()) {
                            break;
                        }
                        i5 = i6;
                        if (arrayList.get(i6).s) {
                            break;
                        }
                        i6++;
                    }
                }
                a(arrayList, arrayList2, i2, i5);
                i4 = i5 - 1;
            }
            i2 = i4 + 1;
            i3 = i5;
        }
        if (i != size) {
            a(arrayList, arrayList2, i, size);
        }
    }

    private static void b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = arrayList.get(i);
            boolean z = true;
            if (arrayList2.get(i).booleanValue()) {
                backStackRecord.a(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                backStackRecord.b(z);
            } else {
                backStackRecord.a(1);
                backStackRecord.a();
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i) {
        int i2 = 8194;
        if (i != 4097) {
            if (i != 4099) {
                return i != 8194 ? 0 : 4097;
            }
            i2 = 4099;
        }
        return i2;
    }

    private boolean c(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.g) {
            if (this.g.isEmpty()) {
                return false;
            }
            int size = this.g.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                z |= this.g.get(i).generateOps(arrayList, arrayList2);
            }
            this.g.clear();
            this.v.a().removeCallbacks(this.P);
            return z;
        }
    }

    private void d(int i) {
        try {
            this.h = true;
            this.i.a(i);
            a(i, false);
            if (f2919a) {
                for (SpecialEffectsController specialEffectsController : I()) {
                    specialEffectsController.d();
                }
            }
            this.h = false;
            a(true);
        } catch (Throwable th) {
            this.h = false;
            throw th;
        }
    }

    private void d(boolean z) {
        if (this.h) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.v == null) {
            if (!this.I) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        } else if (Looper.myLooper() != this.v.a().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                E();
            }
            if (this.K == null) {
                this.K = new ArrayList<>();
                this.L = new ArrayList<>();
            }
            this.h = true;
            try {
                a((ArrayList<BackStackRecord>) null, (ArrayList<Boolean>) null);
            } finally {
                this.h = false;
            }
        }
    }

    @Deprecated
    public static void enableDebugLogging(boolean z) {
        f = z;
    }

    public static void enableNewStateManager(boolean z) {
        f2919a = z;
    }

    public static <F extends Fragment> F findFragment(View view) {
        F f2 = (F) b(view);
        if (f2 != null) {
            return f2;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    private FragmentManagerViewModel r(Fragment fragment) {
        return this.O.d(fragment);
    }

    private void s(Fragment fragment) {
        HashSet<CancellationSignal> hashSet = this.r.get(fragment);
        if (hashSet != null) {
            Iterator<CancellationSignal> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            hashSet.clear();
            t(fragment);
            this.r.remove(fragment);
        }
    }

    private void t(Fragment fragment) {
        fragment.performDestroyView();
        this.t.g(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    private void u(final Fragment fragment) {
        if (fragment.mView != null) {
            FragmentAnim.AnimationOrAnimator a2 = FragmentAnim.a(this.v.getContext(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (a2 == null || a2.animator == null) {
                if (a2 != null) {
                    fragment.mView.startAnimation(a2.animation);
                    a2.animation.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                a2.animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    a2.animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.FragmentManager.7
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView == null || !fragment.mHidden) {
                                return;
                            }
                            fragment.mView.setVisibility(8);
                        }
                    });
                }
                a2.animator.start();
            }
        }
        q(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void v(Fragment fragment) {
        ViewGroup w = w(fragment);
        if (w == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (w.getTag(R.id.visible_removing_fragment_view_tag) == null) {
            w.setTag(R.id.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) w.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
    }

    private ViewGroup w(Fragment fragment) {
        if (fragment.mContainer != null) {
            return fragment.mContainer;
        }
        if (fragment.mContainerId > 0 && this.w.onHasView()) {
            View onFindViewById = this.w.onFindViewById(fragment.mContainerId);
            if (onFindViewById instanceof ViewGroup) {
                return (ViewGroup) onFindViewById;
            }
            return null;
        }
        return null;
    }

    private void x(Fragment fragment) {
        if (fragment == null || !fragment.equals(b(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private boolean y(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.A();
    }

    boolean A() {
        boolean z = false;
        for (Fragment fragment : this.i.i()) {
            boolean z2 = z;
            if (fragment != null) {
                z2 = y(fragment);
            }
            z = z2;
            if (z2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 B() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(String str) {
        return this.i.d(str);
    }

    void a() {
        a(true);
        if (this.m.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.l.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.v == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f2920c) {
            this.f2920c = i;
            if (f2919a) {
                this.i.c();
            } else {
                for (Fragment fragment : this.i.h()) {
                    g(fragment);
                }
                for (FragmentStateManager fragmentStateManager : this.i.g()) {
                    Fragment a2 = fragmentStateManager.a();
                    if (!a2.mIsNewlyAdded) {
                        g(a2);
                    }
                    if (a2.mRemoving && !a2.isInBackStack()) {
                        this.i.b(fragmentStateManager);
                    }
                }
            }
            D();
            if (this.F && (fragmentHostCallback = this.v) != null && this.f2920c == 7) {
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
                this.F = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable) {
        FragmentStateManager fragmentStateManager;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f2943a == null) {
            return;
        }
        this.i.b();
        Iterator<FragmentState> it = fragmentManagerState.f2943a.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            if (next != null) {
                Fragment a2 = this.O.a(next.b);
                if (a2 != null) {
                    if (a(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + a2);
                    }
                    fragmentStateManager = new FragmentStateManager(this.t, this.i, a2, next);
                } else {
                    fragmentStateManager = new FragmentStateManager(this.t, this.i, this.v.getContext().getClassLoader(), getFragmentFactory(), next);
                }
                Fragment a3 = fragmentStateManager.a();
                a3.mFragmentManager = this;
                if (a(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + a3.mWho + "): " + a3);
                }
                fragmentStateManager.a(this.v.getContext().getClassLoader());
                this.i.a(fragmentStateManager);
                fragmentStateManager.a(this.f2920c);
            }
        }
        for (Fragment fragment : this.O.b()) {
            if (!this.i.b(fragment.mWho)) {
                if (a(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f2943a);
                }
                this.O.c(fragment);
                fragment.mFragmentManager = this;
                FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.t, this.i, fragment);
                fragmentStateManager2.a(1);
                fragmentStateManager2.c();
                fragment.mRemoving = true;
                fragmentStateManager2.c();
            }
        }
        this.i.a(fragmentManagerState.b);
        if (fragmentManagerState.f2944c != null) {
            this.b = new ArrayList<>(fragmentManagerState.f2944c.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= fragmentManagerState.f2944c.length) {
                    break;
                }
                BackStackRecord instantiate = fragmentManagerState.f2944c[i2].instantiate(this);
                if (a(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + instantiate.f2853c + "): " + instantiate);
                    PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                    instantiate.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.b.add(instantiate);
                i = i2 + 1;
            }
        } else {
            this.b = null;
        }
        this.n.set(fragmentManagerState.d);
        if (fragmentManagerState.e != null) {
            Fragment b = b(fragmentManagerState.e);
            this.d = b;
            x(b);
        }
        ArrayList<String> arrayList = fragmentManagerState.f;
        if (arrayList != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= arrayList.size()) {
                    break;
                }
                Bundle bundle = fragmentManagerState.g.get(i4);
                bundle.setClassLoader(this.v.getContext().getClassLoader());
                this.o.put(arrayList.get(i4), bundle);
                i3 = i4 + 1;
            }
        }
        this.e = new ArrayDeque<>(fragmentManagerState.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.v instanceof ViewModelStoreOwner) {
            a(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.O.a(fragmentManagerNonConfig);
        a(parcelable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BackStackRecord backStackRecord) {
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        this.b.add(backStackRecord);
    }

    void a(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.b(z3);
        } else {
            backStackRecord.a();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.f2920c >= 1) {
            FragmentTransition.a(this.v.getContext(), this.w, arrayList, arrayList2, 0, 1, true, this.s);
        }
        if (z3) {
            a(this.f2920c, true);
        }
        for (Fragment fragment : this.i.i()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && backStackRecord.b(fragment.mContainerId)) {
                if (fragment.mPostponedAlpha > 0.0f) {
                    fragment.mView.setAlpha(fragment.mPostponedAlpha);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(androidx.fragment.app.Fragment r7, int r8) {
        /*
            Method dump skipped, instructions count: 784
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.a(androidx.fragment.app.Fragment, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (this.C == null) {
            this.v.onStartActivityFromFragment(fragment, intent, i, bundle);
            return;
        }
        this.e.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
        if (intent != null && bundle != null) {
            intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle);
        }
        this.C.launch(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.D == null) {
            this.v.onStartIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (a(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + fragment);
            }
            intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle);
        }
        IntentSenderRequest build = new IntentSenderRequest.Builder(intentSender).setFillInIntent(intent).setFlags(i3, i2).build();
        this.e.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
        if (a(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.D.launch(build);
    }

    void a(Fragment fragment, CancellationSignal cancellationSignal) {
        if (this.r.get(fragment) == null) {
            this.r.put(fragment, new HashSet<>());
        }
        this.r.get(fragment).add(cancellationSignal);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, boolean z) {
        ViewGroup w = w(fragment);
        if (w == null || !(w instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) w).setDrawDisappearingViewsLast(!z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, String[] strArr, int i) {
        if (this.E == null) {
            this.v.onRequestPermissionsFromFragment(fragment, strArr, i);
            return;
        }
        this.e.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
        this.E.launch(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentContainerView fragmentContainerView) {
        for (FragmentStateManager fragmentStateManager : this.i.g()) {
            Fragment a2 = fragmentStateManager.a();
            if (a2.mContainerId == fragmentContainerView.getId() && a2.mView != null && a2.mView.getParent() == null) {
                a2.mContainer = fragmentContainerView;
                fragmentStateManager.s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentHostCallback<?> fragmentHostCallback, FragmentContainer fragmentContainer, final Fragment fragment) {
        String str;
        if (this.v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.v = fragmentHostCallback;
        this.w = fragmentContainer;
        this.x = fragment;
        if (fragment != null) {
            addFragmentOnAttachListener(new FragmentOnAttachListener() { // from class: androidx.fragment.app.FragmentManager.8
                @Override // androidx.fragment.app.FragmentOnAttachListener
                public void onAttachFragment(FragmentManager fragmentManager, Fragment fragment2) {
                    fragment.onAttachFragment(fragment2);
                }
            });
        } else if (fragmentHostCallback instanceof FragmentOnAttachListener) {
            addFragmentOnAttachListener((FragmentOnAttachListener) fragmentHostCallback);
        }
        if (this.x != null) {
            C();
        }
        if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
            this.l = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwner2 = onBackPressedDispatcherOwner;
            if (fragment != null) {
                onBackPressedDispatcherOwner2 = fragment;
            }
            this.l.addCallback(onBackPressedDispatcherOwner2, this.m);
        }
        if (fragment != null) {
            this.O = fragment.mFragmentManager.r(fragment);
        } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            this.O = FragmentManagerViewModel.a(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore());
        } else {
            this.O = new FragmentManagerViewModel(false);
        }
        this.O.a(isStateSaved());
        this.i.a(this.O);
        FragmentHostCallback<?> fragmentHostCallback2 = this.v;
        if (fragmentHostCallback2 instanceof ActivityResultRegistryOwner) {
            ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) fragmentHostCallback2).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.C = activityResultRegistry.register(str2 + "StartActivityForResult", new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.9
                @Override // androidx.activity.result.ActivityResultCallback
                public void onActivityResult(ActivityResult activityResult) {
                    LaunchedFragmentInfo pollFirst = FragmentManager.this.e.pollFirst();
                    if (pollFirst == null) {
                        Log.w("FragmentManager", "No Activities were started for result for " + this);
                        return;
                    }
                    String str3 = pollFirst.f2934a;
                    int i = pollFirst.b;
                    Fragment d = FragmentManager.this.i.d(str3);
                    if (d != null) {
                        d.onActivityResult(i, activityResult.getResultCode(), activityResult.getData());
                        return;
                    }
                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                }
            });
            this.D = activityResultRegistry.register(str2 + "StartIntentSenderForResult", new FragmentIntentSenderContract(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.10
                @Override // androidx.activity.result.ActivityResultCallback
                public void onActivityResult(ActivityResult activityResult) {
                    LaunchedFragmentInfo pollFirst = FragmentManager.this.e.pollFirst();
                    if (pollFirst == null) {
                        Log.w("FragmentManager", "No IntentSenders were started for " + this);
                        return;
                    }
                    String str3 = pollFirst.f2934a;
                    int i = pollFirst.b;
                    Fragment d = FragmentManager.this.i.d(str3);
                    if (d != null) {
                        d.onActivityResult(i, activityResult.getResultCode(), activityResult.getData());
                        return;
                    }
                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                }
            });
            this.E = activityResultRegistry.register(str2 + "RequestPermissions", new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() { // from class: androidx.fragment.app.FragmentManager.11
                @Override // androidx.activity.result.ActivityResultCallback
                public void onActivityResult(Map<String, Boolean> map) {
                    String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                    ArrayList arrayList = new ArrayList(map.values());
                    int[] iArr = new int[arrayList.size()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
                        i = i2 + 1;
                    }
                    LaunchedFragmentInfo pollFirst = FragmentManager.this.e.pollFirst();
                    if (pollFirst == null) {
                        Log.w("FragmentManager", "No permissions were requested for " + this);
                        return;
                    }
                    String str3 = pollFirst.f2934a;
                    int i3 = pollFirst.b;
                    Fragment d = FragmentManager.this.i.d(str3);
                    if (d != null) {
                        d.onRequestPermissionsResult(i3, strArr, iArr);
                        return;
                    }
                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OpGenerator opGenerator, boolean z) {
        if (!z) {
            if (this.v == null) {
                if (!this.I) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            E();
        }
        synchronized (this.g) {
            if (this.v == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.g.add(opGenerator);
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentStateManager fragmentStateManager) {
        Fragment a2 = fragmentStateManager.a();
        if (a2.mDeferStart) {
            if (this.h) {
                this.J = true;
                return;
            }
            a2.mDeferStart = false;
            if (f2919a) {
                fragmentStateManager.c();
            } else {
                f(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Menu menu) {
        boolean z = false;
        if (this.f2920c < 1) {
            return false;
        }
        for (Fragment fragment : this.i.h()) {
            if (fragment != null && b(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.f2920c < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.i.h()) {
            if (fragment != null && b(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                ArrayList<Fragment> arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<>();
                }
                arrayList2.add(fragment);
                z = true;
                arrayList = arrayList2;
            }
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                Fragment fragment2 = this.j.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.j = arrayList;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(MenuItem menuItem) {
        if (this.f2920c < 1) {
            return false;
        }
        for (Fragment fragment : this.i.h()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.getPrimaryNavigationFragment()) && a(fragmentManager.x);
    }

    boolean a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        int i4;
        ArrayList<BackStackRecord> arrayList3 = this.b;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.b.remove(size));
            arrayList2.add(true);
            return true;
        }
        if (str != null || i >= 0) {
            int size2 = this.b.size();
            while (true) {
                i3 = size2 - 1;
                if (i3 < 0) {
                    break;
                }
                BackStackRecord backStackRecord = this.b.get(i3);
                if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.f2853c)) {
                    break;
                }
                size2 = i3;
            }
            if (i3 < 0) {
                return false;
            }
            int i5 = i3;
            if ((i2 & 1) != 0) {
                while (true) {
                    int i6 = i3 - 1;
                    i5 = i6;
                    if (i6 < 0) {
                        break;
                    }
                    BackStackRecord backStackRecord2 = this.b.get(i6);
                    if (str != null) {
                        i3 = i6;
                        if (str.equals(backStackRecord2.getName())) {
                            continue;
                        }
                    }
                    i5 = i6;
                    if (i < 0) {
                        break;
                    }
                    i5 = i6;
                    if (i != backStackRecord2.f2853c) {
                        break;
                    }
                    i3 = i6;
                }
            }
            i4 = i5;
        } else {
            i4 = -1;
        }
        if (i4 == this.b.size() - 1) {
            return false;
        }
        int size3 = this.b.size();
        while (true) {
            int i7 = size3 - 1;
            if (i7 <= i4) {
                return true;
            }
            arrayList.add(this.b.remove(i7));
            arrayList2.add(true);
            size3 = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(boolean z) {
        d(z);
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (!c(this.K, this.L)) {
                C();
                J();
                this.i.d();
                return z3;
            }
            this.h = true;
            try {
                b(this.K, this.L);
                F();
                z2 = true;
            } catch (Throwable th) {
                F();
                throw th;
            }
        }
    }

    public void addFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.u.add(fragmentOnAttachListener);
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.q == null) {
            this.q = new ArrayList<>();
        }
        this.q.add(onBackStackChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment b(String str) {
        return this.i.e(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> b() {
        return this.i.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Menu menu) {
        if (this.f2920c < 1) {
            return;
        }
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    void b(Fragment fragment, CancellationSignal cancellationSignal) {
        HashSet<CancellationSignal> hashSet = this.r.get(fragment);
        if (hashSet != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
            this.r.remove(fragment);
            if (fragment.mState < 5) {
                t(fragment);
                f(fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(OpGenerator opGenerator, boolean z) {
        if (z && (this.v == null || this.I)) {
            return;
        }
        d(z);
        if (opGenerator.generateOps(this.K, this.L)) {
            this.h = true;
            try {
                b(this.K, this.L);
            } finally {
                F();
            }
        }
        C();
        J();
        this.i.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        return this.f2920c >= i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(MenuItem menuItem) {
        if (this.f2920c < 1) {
            return false;
        }
        for (Fragment fragment : this.i.h()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewModelStore c(Fragment fragment) {
        return this.O.e(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z) {
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(String str) {
        this.o.remove(str);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(String str) {
        LifecycleAwareResultListener remove = this.p.remove(str);
        if (remove != null) {
            remove.removeObserver();
        }
    }

    void d() {
        synchronized (this.g) {
            boolean z = false;
            boolean z2 = (this.N == null || this.N.isEmpty()) ? false : true;
            if (this.g.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.v.a().removeCallbacks(this.P);
                this.v.a().post(this.P);
                C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment) {
        this.O.a(fragment);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.i.a(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.j;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size2) {
                    break;
                }
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.j.get(i2).toString());
                i = i2 + 1;
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.b;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    break;
                }
                BackStackRecord backStackRecord = this.b.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, printWriter);
                i3 = i4 + 1;
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.n.get());
        synchronized (this.g) {
            int size3 = this.g.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= size3) {
                        break;
                    }
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println(this.g.get(i6));
                    i5 = i6 + 1;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.w);
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2920c);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.G);
        printWriter.print(" mStopped=");
        printWriter.print(this.H);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.I);
        if (this.F) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.n.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment) {
        this.O.c(fragment);
    }

    public boolean executePendingTransactions() {
        boolean a2 = a(true);
        G();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public FragmentManagerNonConfig f() {
        if (this.v instanceof ViewModelStoreOwner) {
            a(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.O.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        a(fragment, this.f2920c);
    }

    public Fragment findFragmentById(int i) {
        return this.i.b(i);
    }

    public Fragment findFragmentByTag(String str) {
        return this.i.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable g() {
        G();
        H();
        a(true);
        this.G = true;
        this.O.a(true);
        ArrayList<FragmentState> e = this.i.e();
        if (e.isEmpty()) {
            if (a(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return null;
            }
            return null;
        }
        ArrayList<String> f2 = this.i.f();
        ArrayList<BackStackRecord> arrayList = this.b;
        BackStackState[] backStackStateArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            backStackStateArr = null;
            if (size > 0) {
                BackStackState[] backStackStateArr2 = new BackStackState[size];
                int i = 0;
                while (true) {
                    int i2 = i;
                    backStackStateArr = backStackStateArr2;
                    if (i2 >= size) {
                        break;
                    }
                    backStackStateArr2[i2] = new BackStackState(this.b.get(i2));
                    if (a(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.b.get(i2));
                    }
                    i = i2 + 1;
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f2943a = e;
        fragmentManagerState.b = f2;
        fragmentManagerState.f2944c = backStackStateArr;
        fragmentManagerState.d = this.n.get();
        Fragment fragment = this.d;
        if (fragment != null) {
            fragmentManagerState.e = fragment.mWho;
        }
        fragmentManagerState.f.addAll(this.o.keySet());
        fragmentManagerState.g.addAll(this.o.values());
        fragmentManagerState.h = new ArrayList<>(this.e);
        return fragmentManagerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment) {
        if (!this.i.b(fragment.mWho)) {
            if (a(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f2920c + "since it is not added to " + this);
                return;
            }
            return;
        }
        f(fragment);
        if (fragment.mView != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            if (fragment.mPostponedAlpha > 0.0f) {
                fragment.mView.setAlpha(fragment.mPostponedAlpha);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            FragmentAnim.AnimationOrAnimator a2 = FragmentAnim.a(this.v.getContext(), fragment, true, fragment.getPopDirection());
            if (a2 != null) {
                if (a2.animation != null) {
                    fragment.mView.startAnimation(a2.animation);
                } else {
                    a2.animator.setTarget(fragment.mView);
                    a2.animator.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            u(fragment);
        }
    }

    public BackStackEntry getBackStackEntryAt(int i) {
        return this.b.get(i);
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> arrayList = this.b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public Fragment getFragment(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment b = b(string);
        if (b == null) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return b;
    }

    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.y;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.x;
        return fragment != null ? fragment.mFragmentManager.getFragmentFactory() : this.z;
    }

    public List<Fragment> getFragments() {
        return this.i.h();
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentHostCallback<?> h() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager h(Fragment fragment) {
        FragmentStateManager c2 = this.i.c(fragment.mWho);
        if (c2 != null) {
            return c2;
        }
        FragmentStateManager fragmentStateManager = new FragmentStateManager(this.t, this.i, fragment);
        fragmentStateManager.a(this.v.getContext().getClassLoader());
        fragmentStateManager.a(this.f2920c);
        return fragmentStateManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager i(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        FragmentStateManager h = h(fragment);
        fragment.mFragmentManager = this;
        this.i.a(h);
        if (!fragment.mDetached) {
            this.i.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (y(fragment)) {
                this.F = true;
            }
        }
        return h;
    }

    public boolean isDestroyed() {
        return this.I;
    }

    public boolean isStateSaved() {
        return this.G || this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentContainer j() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean isInBackStack = fragment.isInBackStack();
        if (!fragment.mDetached || (!isInBackStack)) {
            this.i.b(fragment);
            if (y(fragment)) {
                this.F = true;
            }
            fragment.mRemoving = true;
            v(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStore k() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        v(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (this.v == null) {
            return;
        }
        this.G = false;
        this.H = false;
        this.O.a(false);
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        d(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (a(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.i.b(fragment);
            if (y(fragment)) {
                this.F = true;
            }
            v(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        d(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.i.a(fragment);
            if (a(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (y(fragment)) {
                this.F = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        d(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Fragment fragment) {
        if (fragment == null || (fragment.equals(b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.d;
            this.d = fragment;
            x(fragment2);
            x(this.d);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        d(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Fragment fragment) {
        Iterator<FragmentOnAttachListener> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().onAttachFragment(this, fragment);
        }
    }

    public void popBackStack() {
        a((OpGenerator) new PopBackStackState(null, -1, 0), false);
    }

    public void popBackStack(int i, int i2) {
        if (i >= 0) {
            a((OpGenerator) new PopBackStackState(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public void popBackStack(String str, int i) {
        a((OpGenerator) new PopBackStackState(str, -1, i), false);
    }

    public boolean popBackStackImmediate() {
        return a((String) null, -1, 0);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        if (i >= 0) {
            return a((String) null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public boolean popBackStackImmediate(String str, int i) {
        return a(str, -1, i);
    }

    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        d(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Fragment fragment) {
        if (fragment.mAdded && y(fragment)) {
            this.F = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        d(7);
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.t.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, z);
    }

    public void removeFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.u.remove(fragmentOnAttachListener);
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList = this.q;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        d(5);
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        FragmentStateManager c2 = this.i.c(fragment.mWho);
        if (c2 == null || !c2.a().equals(fragment)) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return c2.n();
    }

    public void setFragmentFactory(FragmentFactory fragmentFactory) {
        this.y = fragmentFactory;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResult(String str, Bundle bundle) {
        LifecycleAwareResultListener lifecycleAwareResultListener = this.p.get(str);
        if (lifecycleAwareResultListener == null || !lifecycleAwareResultListener.isAtLeast(Lifecycle.State.STARTED)) {
            this.o.put(str, bundle);
        } else {
            lifecycleAwareResultListener.onFragmentResult(str, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResultListener(final String str, LifecycleOwner lifecycleOwner, final FragmentResultListener fragmentResultListener) {
        final Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.fragment.app.FragmentManager.6
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                Bundle bundle;
                if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.o.get(str)) != null) {
                    fragmentResultListener.onFragmentResult(str, bundle);
                    FragmentManager.this.clearFragmentResult(str);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver(this);
                    FragmentManager.this.p.remove(str);
                }
            }
        };
        lifecycle.addObserver(lifecycleEventObserver);
        LifecycleAwareResultListener put = this.p.put(str, new LifecycleAwareResultListener(lifecycle, fragmentResultListener, lifecycleEventObserver));
        if (put != null) {
            put.removeObserver();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.H = true;
        this.O.a(true);
        d(4);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.x)));
            sb.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.v;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.v)));
                sb.append("}");
            } else {
                sb.append(b.l);
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        d(1);
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.t.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.I = true;
        a(true);
        H();
        d(-1);
        this.v = null;
        this.w = null;
        this.x = null;
        if (this.l != null) {
            this.m.remove();
            this.l = null;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.C;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
            this.D.unregister();
            this.E.unregister();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        C();
        x(this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpecialEffectsControllerFactory y() {
        SpecialEffectsControllerFactory specialEffectsControllerFactory = this.A;
        if (specialEffectsControllerFactory != null) {
            return specialEffectsControllerFactory;
        }
        Fragment fragment = this.x;
        return fragment != null ? fragment.mFragmentManager.y() : this.B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentLifecycleCallbacksDispatcher z() {
        return this.t;
    }
}
