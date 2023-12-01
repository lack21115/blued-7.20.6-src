package android.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.BackStackRecord;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DebugUtils;
import android.util.Log;
import android.util.LogWriter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.android.internal.R;
import com.android.internal.util.FastPrintWriter;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/FragmentManagerImpl.class */
public final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {
    static boolean DEBUG = false;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    ArrayList<Fragment> mActive;
    Activity mActivity;
    ArrayList<Fragment> mAdded;
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<Integer> mAvailIndices;
    ArrayList<BackStackRecord> mBackStack;
    ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
    ArrayList<BackStackRecord> mBackStackIndices;
    FragmentContainer mContainer;
    ArrayList<Fragment> mCreatedMenus;
    boolean mDestroyed;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList<Runnable> mPendingActions;
    boolean mStateSaved;
    Runnable[] mTmpActions;
    int mCurState = 0;
    Bundle mStateBundle = null;
    SparseArray<Parcelable> mStateArray = null;
    Runnable mExecCommit = new Runnable() { // from class: android.app.FragmentManagerImpl.1
        @Override // java.lang.Runnable
        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    };

    private void checkStateLoss() {
        if (this.mStateSaved) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mNoTransactionsBecause != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
        }
    }

    public static int reverseTransit(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e(TAG, runtimeException.getMessage());
        PrintWriter fastPrintWriter = new FastPrintWriter(new LogWriter(6, TAG), false, 1024);
        if (this.mActivity != null) {
            Log.e(TAG, "Activity state:");
            try {
                this.mActivity.dump("  ", null, fastPrintWriter, new String[0]);
            } catch (Exception e) {
                fastPrintWriter.flush();
                Log.e(TAG, "Failed dumping state", e);
            }
        } else {
            Log.e(TAG, "Fragment manager state:");
            try {
                dump("  ", null, fastPrintWriter, new String[0]);
            } catch (Exception e2) {
                fastPrintWriter.flush();
                Log.e(TAG, "Failed dumping state", e2);
            }
        }
        fastPrintWriter.flush();
        throw runtimeException;
    }

    public static int transitToStyleIndex(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 0 : 1;
            case 4099:
                return z ? 4 : 5;
            case 8194:
                return z ? 2 : 3;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList<>();
        }
        this.mBackStack.add(backStackRecord);
        reportBackStackChanged();
    }

    public void addFragment(Fragment fragment, boolean z) {
        if (this.mAdded == null) {
            this.mAdded = new ArrayList<>();
        }
        if (DEBUG) {
            Log.v(TAG, "add: " + fragment);
        }
        makeActive(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.mAdded.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        this.mAdded.add(fragment);
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        if (z) {
            moveToState(fragment);
        }
    }

    @Override // android.app.FragmentManager
    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList<>();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public int allocBackStackIndex(BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                int intValue = this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1).intValue();
                if (DEBUG) {
                    Log.v(TAG, "Adding back stack index " + intValue + " with " + backStackRecord);
                }
                this.mBackStackIndices.set(intValue, backStackRecord);
                return intValue;
            }
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList<>();
            }
            int size = this.mBackStackIndices.size();
            if (DEBUG) {
                Log.v(TAG, "Setting back stack index " + size + " to " + backStackRecord);
            }
            this.mBackStackIndices.add(backStackRecord);
            return size;
        }
    }

    public void attachActivity(Activity activity, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.mActivity != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mActivity = activity;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
    }

    public void attachFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.mAdded == null) {
                this.mAdded = new ArrayList<>();
            }
            if (this.mAdded.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (DEBUG) {
                Log.v(TAG, "add from attach: " + fragment);
            }
            this.mAdded.add(fragment);
            fragment.mAdded = true;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            moveToState(fragment, this.mCurState, i, i2, false);
        }
    }

    @Override // android.app.FragmentManager
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public void detachFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (this.mAdded != null) {
                if (DEBUG) {
                    Log.v(TAG, "remove from detach: " + fragment);
                }
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            moveToState(fragment, 1, i, i2, false);
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        moveToState(2, false);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        if (this.mAdded == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mAdded.size()) {
                return;
            }
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
            i = i2 + 1;
        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mAdded == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mAdded.size()) {
                return false;
            }
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        moveToState(1, false);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        boolean z2 = false;
        ArrayList<Fragment> arrayList = null;
        ArrayList<Fragment> arrayList2 = null;
        if (this.mAdded != null) {
            int i = 0;
            while (true) {
                arrayList = arrayList2;
                z = z2;
                if (i >= this.mAdded.size()) {
                    break;
                }
                Fragment fragment = this.mAdded.get(i);
                ArrayList<Fragment> arrayList3 = arrayList2;
                boolean z3 = z2;
                if (fragment != null) {
                    arrayList3 = arrayList2;
                    z3 = z2;
                    if (fragment.performCreateOptionsMenu(menu, menuInflater)) {
                        z3 = true;
                        arrayList3 = arrayList2;
                        if (arrayList2 == null) {
                            arrayList3 = new ArrayList<>();
                        }
                        arrayList3.add(fragment);
                    }
                }
                i++;
                arrayList2 = arrayList3;
                z2 = z3;
            }
        }
        if (this.mCreatedMenus != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mCreatedMenus.size()) {
                    break;
                }
                Fragment fragment2 = this.mCreatedMenus.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
                i2 = i3 + 1;
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        moveToState(0, false);
        this.mActivity = null;
        this.mContainer = null;
        this.mParent = null;
    }

    public void dispatchDestroyView() {
        moveToState(1, false);
    }

    public void dispatchLowMemory() {
        if (this.mAdded == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mAdded.size()) {
                return;
            }
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null) {
                fragment.performLowMemory();
            }
            i = i2 + 1;
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mAdded == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mAdded.size()) {
                return false;
            }
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mAdded == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mAdded.size()) {
                return;
            }
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
            i = i2 + 1;
        }
    }

    public void dispatchPause() {
        moveToState(4, false);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        boolean z2 = false;
        if (this.mAdded != null) {
            int i = 0;
            while (true) {
                z = z2;
                if (i >= this.mAdded.size()) {
                    break;
                }
                Fragment fragment = this.mAdded.get(i);
                boolean z3 = z2;
                if (fragment != null) {
                    z3 = z2;
                    if (fragment.performPrepareOptionsMenu(menu)) {
                        z3 = true;
                    }
                }
                i++;
                z2 = z3;
            }
        }
        return z;
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        moveToState(5, false);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        moveToState(4, false);
    }

    public void dispatchStop() {
        moveToState(3, false);
    }

    public void dispatchTrimMemory(int i) {
        if (this.mAdded == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mAdded.size()) {
                return;
            }
            Fragment fragment = this.mAdded.get(i3);
            if (fragment != null) {
                fragment.performTrimMemory(i);
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.app.FragmentManager
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.mActive != null && (size6 = this.mActive.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size6) {
                    break;
                }
                Fragment fragment = this.mActive.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
                i = i2 + 1;
            }
        }
        if (this.mAdded != null && (size5 = this.mAdded.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size5) {
                    break;
                }
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.mAdded.get(i4).toString());
                i3 = i4 + 1;
            }
        }
        if (this.mCreatedMenus != null && (size4 = this.mCreatedMenus.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= size4) {
                    break;
                }
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(this.mCreatedMenus.get(i6).toString());
                i5 = i6 + 1;
            }
        }
        if (this.mBackStack != null && (size3 = this.mBackStack.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size3) {
                    break;
                }
                BackStackRecord backStackRecord = this.mBackStack.get(i8);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i8);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, fileDescriptor, printWriter, strArr);
                i7 = i8 + 1;
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null && (size2 = this.mBackStackIndices.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= size2) {
                        break;
                    }
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i10);
                    printWriter.print(": ");
                    printWriter.println((BackStackRecord) this.mBackStackIndices.get(i10));
                    i9 = i10 + 1;
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
        }
        if (this.mPendingActions != null && (size = this.mPendingActions.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= size) {
                    break;
                }
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i12);
                printWriter.print(": ");
                printWriter.println((Runnable) this.mPendingActions.get(i12));
                i11 = i12 + 1;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.mActivity);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
        if (this.mAvailIndices == null || this.mAvailIndices.size() <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.print("  mAvailIndices: ");
        printWriter.println(Arrays.toString(this.mAvailIndices.toArray()));
    }

    public void enqueueAction(Runnable runnable, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (this.mDestroyed || this.mActivity == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.mPendingActions == null) {
                this.mPendingActions = new ArrayList<>();
            }
            this.mPendingActions.add(runnable);
            if (this.mPendingActions.size() == 1) {
                this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
                this.mActivity.mHandler.post(this.mExecCommit);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
        r4.mExecutingActions = true;
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d7, code lost:
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d9, code lost:
        if (r5 >= r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dc, code lost:
        r4.mTmpActions[r5].run();
        r4.mTmpActions[r5] = null;
        r0 = r5 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean execPendingActions() {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.FragmentManagerImpl.execPendingActions():boolean");
    }

    @Override // android.app.FragmentManager
    public boolean executePendingTransactions() {
        return execPendingActions();
    }

    @Override // android.app.FragmentManager
    public Fragment findFragmentById(int i) {
        Fragment fragment;
        if (this.mAdded != null) {
            int size = this.mAdded.size();
            while (true) {
                int i2 = size - 1;
                if (i2 < 0) {
                    break;
                }
                fragment = this.mAdded.get(i2);
                if (fragment != null && fragment.mFragmentId == i) {
                    break;
                }
                size = i2;
            }
            return fragment;
        }
        if (this.mActive == null) {
            return null;
        }
        int size2 = this.mActive.size();
        while (true) {
            int i3 = size2 - 1;
            if (i3 < 0) {
                return null;
            }
            Fragment fragment2 = this.mActive.get(i3);
            if (fragment2 != null) {
                fragment = fragment2;
                if (fragment2.mFragmentId == i) {
                    break;
                }
            }
            size2 = i3;
        }
    }

    @Override // android.app.FragmentManager
    public Fragment findFragmentByTag(String str) {
        Fragment fragment;
        if (this.mAdded != null && str != null) {
            int size = this.mAdded.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                fragment = this.mAdded.get(i);
                if (fragment != null && str.equals(fragment.mTag)) {
                    break;
                }
                size = i;
            }
        }
        if (this.mActive == null || str == null) {
            return null;
        }
        int size2 = this.mActive.size();
        while (true) {
            int i2 = size2 - 1;
            if (i2 < 0) {
                return null;
            }
            Fragment fragment2 = this.mActive.get(i2);
            if (fragment2 != null) {
                fragment = fragment2;
                if (str.equals(fragment2.mTag)) {
                    break;
                }
            }
            size2 = i2;
        }
        return fragment;
    }

    public Fragment findFragmentByWho(String str) {
        Fragment findFragmentByWho;
        if (this.mActive == null || str == null) {
            return null;
        }
        int size = this.mActive.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return null;
            }
            Fragment fragment = this.mActive.get(i);
            if (fragment != null && (findFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
            size = i;
        }
    }

    public void freeBackStackIndex(int i) {
        synchronized (this) {
            this.mBackStackIndices.set(i, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList<>();
            }
            if (DEBUG) {
                Log.v(TAG, "Freeing back stack index " + i);
            }
            this.mAvailBackStackIndices.add(Integer.valueOf(i));
        }
    }

    @Override // android.app.FragmentManager
    public FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return this.mBackStack.get(i);
    }

    @Override // android.app.FragmentManager
    public int getBackStackEntryCount() {
        if (this.mBackStack != null) {
            return this.mBackStack.size();
        }
        return 0;
    }

    @Override // android.app.FragmentManager
    public Fragment getFragment(Bundle bundle, String str) {
        Fragment fragment;
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            fragment = null;
        } else {
            if (i >= this.mActive.size()) {
                throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
            }
            Fragment fragment2 = this.mActive.get(i);
            fragment = fragment2;
            if (fragment2 == null) {
                throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
                return fragment2;
            }
        }
        return fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this;
    }

    public void hideFragment(final Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        if (fragment.mView != null) {
            Animator loadAnimator = loadAnimator(fragment, i, false, i2);
            if (loadAnimator != null) {
                loadAnimator.setTarget(fragment.mView);
                loadAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.app.FragmentManagerImpl.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (fragment.mView != null) {
                            fragment.mView.setVisibility(8);
                        }
                    }
                });
                loadAnimator.start();
            } else {
                fragment.mView.setVisibility(8);
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.onHiddenChanged(true);
    }

    @Override // android.app.FragmentManager
    public void invalidateOptionsMenu() {
        if (this.mActivity == null || this.mCurState != 5) {
            this.mNeedMenuInvalidate = true;
        } else {
            this.mActivity.invalidateOptionsMenu();
        }
    }

    @Override // android.app.FragmentManager
    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    Animator loadAnimator(Fragment fragment, int i, boolean z, int i2) {
        int transitToStyleIndex;
        Animator loadAnimator;
        Animator onCreateAnimator = fragment.onCreateAnimator(i, z, fragment.mNextAnim);
        if (onCreateAnimator != null) {
            return onCreateAnimator;
        }
        if (fragment.mNextAnim == 0 || (loadAnimator = AnimatorInflater.loadAnimator(this.mActivity, fragment.mNextAnim)) == null) {
            if (i != 0 && (transitToStyleIndex = transitToStyleIndex(i, z)) >= 0) {
                int i3 = i2;
                if (i2 == 0) {
                    i3 = i2;
                    if (this.mActivity.getWindow() != null) {
                        i3 = this.mActivity.getWindow().getAttributes().windowAnimations;
                    }
                }
                if (i3 == 0) {
                    return null;
                }
                TypedArray obtainStyledAttributes = this.mActivity.obtainStyledAttributes(i3, R.styleable.FragmentAnimation);
                int resourceId = obtainStyledAttributes.getResourceId(transitToStyleIndex, 0);
                obtainStyledAttributes.recycle();
                if (resourceId == 0) {
                    return null;
                }
                return AnimatorInflater.loadAnimator(this.mActivity, resourceId);
            }
            return null;
        }
        return loadAnimator;
    }

    void makeActive(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            return;
        }
        if (this.mAvailIndices == null || this.mAvailIndices.size() <= 0) {
            if (this.mActive == null) {
                this.mActive = new ArrayList<>();
            }
            fragment.setIndex(this.mActive.size(), this.mParent);
            this.mActive.add(fragment);
        } else {
            fragment.setIndex(this.mAvailIndices.remove(this.mAvailIndices.size() - 1).intValue(), this.mParent);
            this.mActive.set(fragment.mIndex, fragment);
        }
        if (DEBUG) {
            Log.v(TAG, "Allocated fragment index " + fragment);
        }
    }

    void makeInactive(Fragment fragment) {
        if (fragment.mIndex < 0) {
            return;
        }
        if (DEBUG) {
            Log.v(TAG, "Freeing fragment index " + fragment);
        }
        this.mActive.set(fragment.mIndex, null);
        if (this.mAvailIndices == null) {
            this.mAvailIndices = new ArrayList<>();
        }
        this.mAvailIndices.add(Integer.valueOf(fragment.mIndex));
        this.mActivity.invalidateFragment(fragment.mWho);
        fragment.initState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void moveToState(int i, int i2, int i3, boolean z) {
        if (this.mActivity == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || this.mCurState != i) {
            this.mCurState = i;
            if (this.mActive != null) {
                boolean z2 = false;
                int i4 = 0;
                while (i4 < this.mActive.size()) {
                    Fragment fragment = this.mActive.get(i4);
                    boolean z3 = z2;
                    if (fragment != null) {
                        moveToState(fragment, i, i2, i3, false);
                        z3 = z2;
                        if (fragment.mLoaderManager != null) {
                            z3 = z2 | fragment.mLoaderManager.hasRunningLoaders();
                        }
                    }
                    i4++;
                    z2 = z3;
                }
                if (!z2) {
                    startPendingDeferredFragments();
                }
                if (this.mNeedMenuInvalidate && this.mActivity != null && this.mCurState == 5) {
                    this.mActivity.invalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }

    void moveToState(int i, boolean z) {
        moveToState(i, 0, 0, z);
    }

    void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r9.mDetached != false) goto L181;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void moveToState(final android.app.Fragment r9, int r10, int r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 1541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.FragmentManagerImpl.moveToState(android.app.Fragment, int, int, int, boolean):void");
    }

    public void noteStateNotSaved() {
        this.mStateSaved = false;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
            String str2 = attributeValue;
            if (attributeValue == null) {
                str2 = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
            }
            Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
            Fragment fragment2 = findFragmentById;
            if (findFragmentById == null) {
                fragment2 = findFragmentById;
                if (string != null) {
                    fragment2 = findFragmentByTag(string);
                }
            }
            Fragment fragment3 = fragment2;
            if (fragment2 == null) {
                fragment3 = fragment2;
                if (id != -1) {
                    fragment3 = findFragmentById(id);
                }
            }
            if (DEBUG) {
                Log.v(TAG, "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + fragment3);
            }
            if (fragment3 == null) {
                fragment = Fragment.instantiate(context, str2);
                fragment.mFromLayout = true;
                fragment.mFragmentId = resourceId != 0 ? resourceId : id;
                fragment.mContainerId = id;
                fragment.mTag = string;
                fragment.mInLayout = true;
                fragment.mFragmentManager = this;
                fragment.onInflate(this.mActivity, attributeSet, fragment.mSavedFragmentState);
                addFragment(fragment, true);
            } else if (fragment3.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            } else {
                fragment3.mInLayout = true;
                fragment = fragment3;
                if (!fragment3.mRetaining) {
                    fragment3.onInflate(this.mActivity, attributeSet, fragment3.mSavedFragmentState);
                    fragment = fragment3;
                }
            }
            if (this.mCurState >= 1 || !fragment.mFromLayout) {
                moveToState(fragment);
            } else {
                moveToState(fragment, 1, 0, 0, false);
            }
            if (fragment.mView == null) {
                throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
            }
            if (resourceId != 0) {
                fragment.mView.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    public void performPendingDeferredStart(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            moveToState(fragment, this.mCurState, 0, 0, false);
        }
    }

    @Override // android.app.FragmentManager
    public void popBackStack() {
        enqueueAction(new Runnable() { // from class: android.app.FragmentManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, null, -1, 0);
            }
        }, false);
    }

    @Override // android.app.FragmentManager
    public void popBackStack(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        enqueueAction(new Runnable() { // from class: android.app.FragmentManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, null, i, i2);
            }
        }, false);
    }

    @Override // android.app.FragmentManager
    public void popBackStack(final String str, final int i) {
        enqueueAction(new Runnable() { // from class: android.app.FragmentManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, str, -1, i);
            }
        }, false);
    }

    @Override // android.app.FragmentManager
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(this.mActivity.mHandler, null, -1, 0);
    }

    @Override // android.app.FragmentManager
    public boolean popBackStackImmediate(int i, int i2) {
        checkStateLoss();
        executePendingTransactions();
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        return popBackStackState(this.mActivity.mHandler, null, i, i2);
    }

    @Override // android.app.FragmentManager
    public boolean popBackStackImmediate(String str, int i) {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(this.mActivity.mHandler, str, -1, i);
    }

    boolean popBackStackState(Handler handler, String str, int i, int i2) {
        int i3;
        if (this.mBackStack == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.mBackStack.size() - 1;
            if (size < 0) {
                return false;
            }
            BackStackRecord remove = this.mBackStack.remove(size);
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            remove.calculateBackFragments(sparseArray, sparseArray2);
            remove.popFromBackStack(true, null, sparseArray, sparseArray2);
            reportBackStackChanged();
            return true;
        }
        int i4 = -1;
        if (str != null || i >= 0) {
            int size2 = this.mBackStack.size();
            while (true) {
                i3 = size2 - 1;
                if (i3 < 0) {
                    break;
                }
                BackStackRecord backStackRecord = this.mBackStack.get(i3);
                if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.mIndex)) {
                    break;
                }
                size2 = i3;
            }
            if (i3 < 0) {
                return false;
            }
            i4 = i3;
            if ((i2 & 1) != 0) {
                int i5 = i3;
                while (true) {
                    int i6 = i5 - 1;
                    i4 = i6;
                    if (i6 < 0) {
                        break;
                    }
                    BackStackRecord backStackRecord2 = this.mBackStack.get(i6);
                    if (str == null || !str.equals(backStackRecord2.getName())) {
                        i4 = i6;
                        if (i < 0) {
                            break;
                        }
                        i4 = i6;
                        if (i != backStackRecord2.mIndex) {
                            break;
                        }
                    }
                    i5 = i6;
                }
            }
        }
        if (i4 == this.mBackStack.size() - 1) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int size3 = this.mBackStack.size();
        while (true) {
            int i7 = size3 - 1;
            if (i7 <= i4) {
                break;
            }
            arrayList.add(this.mBackStack.remove(i7));
            size3 = i7;
        }
        int size4 = arrayList.size() - 1;
        SparseArray<Fragment> sparseArray3 = new SparseArray<>();
        SparseArray<Fragment> sparseArray4 = new SparseArray<>();
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 > size4) {
                break;
            }
            ((BackStackRecord) arrayList.get(i9)).calculateBackFragments(sparseArray3, sparseArray4);
            i8 = i9 + 1;
        }
        BackStackRecord.TransitionState transitionState = null;
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 > size4) {
                reportBackStackChanged();
                return true;
            }
            if (DEBUG) {
                Log.v(TAG, "Popping back stack state: " + arrayList.get(i11));
            }
            transitionState = ((BackStackRecord) arrayList.get(i11)).popFromBackStack(i11 == size4, transitionState, sparseArray3, sparseArray4);
            i10 = i11 + 1;
        }
    }

    @Override // android.app.FragmentManager
    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public void removeFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            if (this.mAdded != null) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            moveToState(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    @Override // android.app.FragmentManager
    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(onBackStackChangedListener);
        }
    }

    void reportBackStackChanged() {
        if (this.mBackStackChangeListeners == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mBackStackChangeListeners.size()) {
                return;
            }
            this.mBackStackChangeListeners.get(i2).onBackStackChanged();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restoreAllState(Parcelable parcelable, ArrayList<Fragment> arrayList) {
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                Fragment fragment = arrayList.get(i2);
                if (DEBUG) {
                    Log.v(TAG, "restoreAllState: re-attaching retained " + fragment);
                }
                FragmentState fragmentState = fragmentManagerState.mActive[fragment.mIndex];
                fragmentState.mInstance = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                fragment.mTarget = null;
                if (fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
                    fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                    fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                }
                i = i2 + 1;
            }
        }
        this.mActive = new ArrayList<>(fragmentManagerState.mActive.length);
        if (this.mAvailIndices != null) {
            this.mAvailIndices.clear();
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= fragmentManagerState.mActive.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentManagerState.mActive[i4];
            if (fragmentState2 != null) {
                Fragment instantiate = fragmentState2.instantiate(this.mActivity, this.mParent);
                if (DEBUG) {
                    Log.v(TAG, "restoreAllState: active #" + i4 + ": " + instantiate);
                }
                this.mActive.add(instantiate);
                fragmentState2.mInstance = null;
            } else {
                this.mActive.add(null);
                if (this.mAvailIndices == null) {
                    this.mAvailIndices = new ArrayList<>();
                }
                if (DEBUG) {
                    Log.v(TAG, "restoreAllState: avail #" + i4);
                }
                this.mAvailIndices.add(Integer.valueOf(i4));
            }
            i3 = i4 + 1;
        }
        if (arrayList != null) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= arrayList.size()) {
                    break;
                }
                Fragment fragment2 = arrayList.get(i6);
                if (fragment2.mTargetIndex >= 0) {
                    if (fragment2.mTargetIndex < this.mActive.size()) {
                        fragment2.mTarget = this.mActive.get(fragment2.mTargetIndex);
                    } else {
                        Log.w(TAG, "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                        fragment2.mTarget = null;
                    }
                }
                i5 = i6 + 1;
            }
        }
        if (fragmentManagerState.mAdded != null) {
            this.mAdded = new ArrayList<>(fragmentManagerState.mAdded.length);
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= fragmentManagerState.mAdded.length) {
                    break;
                }
                Fragment fragment3 = this.mActive.get(fragmentManagerState.mAdded[i8]);
                if (fragment3 == null) {
                    throwException(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i8]));
                }
                fragment3.mAdded = true;
                if (DEBUG) {
                    Log.v(TAG, "restoreAllState: added #" + i8 + ": " + fragment3);
                }
                if (this.mAdded.contains(fragment3)) {
                    throw new IllegalStateException("Already added!");
                }
                this.mAdded.add(fragment3);
                i7 = i8 + 1;
            }
        } else {
            this.mAdded = null;
        }
        if (fragmentManagerState.mBackStack == null) {
            this.mBackStack = null;
            return;
        }
        this.mBackStack = new ArrayList<>(fragmentManagerState.mBackStack.length);
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= fragmentManagerState.mBackStack.length) {
                return;
            }
            BackStackRecord instantiate2 = fragmentManagerState.mBackStack[i10].instantiate(this);
            if (DEBUG) {
                Log.v(TAG, "restoreAllState: back stack #" + i10 + " (index " + instantiate2.mIndex + "): " + instantiate2);
                FastPrintWriter fastPrintWriter = new FastPrintWriter(new LogWriter(2, TAG), false, 1024);
                instantiate2.dump("  ", fastPrintWriter, false);
                fastPrintWriter.flush();
            }
            this.mBackStack.add(instantiate2);
            if (instantiate2.mIndex >= 0) {
                setBackStackIndex(instantiate2.mIndex, instantiate2);
            }
            i9 = i10 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Fragment> retainNonConfig() {
        ArrayList<Fragment> arrayList = null;
        ArrayList<Fragment> arrayList2 = null;
        if (this.mActive != null) {
            int i = 0;
            while (true) {
                arrayList = arrayList2;
                if (i >= this.mActive.size()) {
                    break;
                }
                Fragment fragment = this.mActive.get(i);
                ArrayList<Fragment> arrayList3 = arrayList2;
                if (fragment != null) {
                    arrayList3 = arrayList2;
                    if (fragment.mRetainInstance) {
                        ArrayList<Fragment> arrayList4 = arrayList2;
                        if (arrayList2 == null) {
                            arrayList4 = new ArrayList<>();
                        }
                        arrayList4.add(fragment);
                        fragment.mRetaining = true;
                        fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                        arrayList3 = arrayList4;
                        if (DEBUG) {
                            Log.v(TAG, "retainNonConfig: keeping retained " + fragment);
                            arrayList3 = arrayList4;
                        }
                    }
                }
                i++;
                arrayList2 = arrayList3;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable saveAllState() {
        execPendingActions();
        this.mStateSaved = true;
        if (this.mActive == null || this.mActive.size() <= 0) {
            return null;
        }
        int size = this.mActive.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            Fragment fragment = this.mActive.get(i2);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    throwException(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i2] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                } else {
                    fragmentState.mSavedFragmentState = saveFragmentBasicState(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            throwException(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        putFragment(fragmentState.mSavedFragmentState, TARGET_STATE_TAG, fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, fragment.mTargetRequestCode);
                        }
                    }
                }
                z = true;
                if (DEBUG) {
                    Log.v(TAG, "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
                    z = true;
                }
            }
            i = i2 + 1;
        }
        if (!z) {
            if (DEBUG) {
                Log.v(TAG, "saveAllState: no fragments!");
                return null;
            }
            return null;
        }
        int[] iArr = null;
        if (this.mAdded != null) {
            int size2 = this.mAdded.size();
            iArr = null;
            if (size2 > 0) {
                int[] iArr2 = new int[size2];
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    iArr = iArr2;
                    if (i4 >= size2) {
                        break;
                    }
                    iArr2[i4] = this.mAdded.get(i4).mIndex;
                    if (iArr2[i4] < 0) {
                        throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i4) + " has cleared index: " + iArr2[i4]));
                    }
                    if (DEBUG) {
                        Log.v(TAG, "saveAllState: adding fragment #" + i4 + ": " + this.mAdded.get(i4));
                    }
                    i3 = i4 + 1;
                }
            }
        }
        BackStackState[] backStackStateArr = null;
        if (this.mBackStack != null) {
            int size3 = this.mBackStack.size();
            backStackStateArr = null;
            if (size3 > 0) {
                BackStackState[] backStackStateArr2 = new BackStackState[size3];
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    backStackStateArr = backStackStateArr2;
                    if (i6 >= size3) {
                        break;
                    }
                    backStackStateArr2[i6] = new BackStackState(this, this.mBackStack.get(i6));
                    if (DEBUG) {
                        Log.v(TAG, "saveAllState: adding back stack #" + i6 + ": " + this.mBackStack.get(i6));
                    }
                    i5 = i6 + 1;
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.mActive = fragmentStateArr;
        fragmentManagerState.mAdded = iArr;
        fragmentManagerState.mBackStack = backStackStateArr;
        return fragmentManagerState;
    }

    Bundle saveFragmentBasicState(Fragment fragment) {
        Bundle bundle = null;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        if (!this.mStateBundle.isEmpty()) {
            bundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            saveFragmentViewState(fragment);
        }
        Bundle bundle2 = bundle;
        if (fragment.mSavedViewState != null) {
            bundle2 = bundle;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            bundle2.putSparseParcelableArray(VIEW_STATE_TAG, fragment.mSavedViewState);
        }
        Bundle bundle3 = bundle2;
        if (!fragment.mUserVisibleHint) {
            bundle3 = bundle2;
            if (bundle2 == null) {
                bundle3 = new Bundle();
            }
            bundle3.putBoolean(USER_VISIBLE_HINT_TAG, fragment.mUserVisibleHint);
        }
        return bundle3;
    }

    @Override // android.app.FragmentManager
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        Fragment.SavedState savedState = null;
        if (fragment.mState > 0) {
            Bundle saveFragmentBasicState = saveFragmentBasicState(fragment);
            savedState = null;
            if (saveFragmentBasicState != null) {
                savedState = new Fragment.SavedState(saveFragmentBasicState);
            }
        }
        return savedState;
    }

    void saveFragmentViewState(Fragment fragment) {
        if (fragment.mView == null) {
            return;
        }
        if (this.mStateArray == null) {
            this.mStateArray = new SparseArray<>();
        } else {
            this.mStateArray.clear();
        }
        fragment.mView.saveHierarchyState(this.mStateArray);
        if (this.mStateArray.size() > 0) {
            fragment.mSavedViewState = this.mStateArray;
            this.mStateArray = null;
        }
    }

    public void setBackStackIndex(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList<>();
            }
            int size = this.mBackStackIndices.size();
            if (i < size) {
                if (DEBUG) {
                    Log.v(TAG, "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.mBackStackIndices.set(i, backStackRecord);
            } else {
                for (int i2 = size; i2 < i; i2++) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList<>();
                    }
                    if (DEBUG) {
                        Log.v(TAG, "Adding available back stack index " + i2);
                    }
                    this.mAvailBackStackIndices.add(Integer.valueOf(i2));
                }
                if (DEBUG) {
                    Log.v(TAG, "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.mBackStackIndices.add(backStackRecord);
            }
        }
    }

    public void showFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animator loadAnimator = loadAnimator(fragment, i, true, i2);
                if (loadAnimator != null) {
                    loadAnimator.setTarget(fragment.mView);
                    loadAnimator.start();
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPendingDeferredFragments() {
        if (this.mActive == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mActive.size()) {
                return;
            }
            Fragment fragment = this.mActive.get(i2);
            if (fragment != null) {
                performPendingDeferredStart(fragment);
            }
            i = i2 + 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.mParent != null) {
            DebugUtils.buildShortClassTag(this.mParent, sb);
        } else {
            DebugUtils.buildShortClassTag(this.mActivity, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
}
