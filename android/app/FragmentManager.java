package android.app;

import android.app.Fragment;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/app/FragmentManager.class */
public abstract class FragmentManager {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    /* loaded from: source-9557208-dex2jar.jar:android/app/FragmentManager$BackStackEntry.class */
    public interface BackStackEntry {
        CharSequence getBreadCrumbShortTitle();

        int getBreadCrumbShortTitleRes();

        CharSequence getBreadCrumbTitle();

        int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/FragmentManager$OnBackStackChangedListener.class */
    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    public static void enableDebugLogging(boolean z) {
        FragmentManagerImpl.DEBUG = z;
    }

    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener);

    public abstract FragmentTransaction beginTransaction();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(int i);

    public abstract Fragment findFragmentByTag(String str);

    public abstract BackStackEntry getBackStackEntryAt(int i);

    public abstract int getBackStackEntryCount();

    public abstract Fragment getFragment(Bundle bundle, String str);

    public void invalidateOptionsMenu() {
    }

    public abstract boolean isDestroyed();

    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public abstract void popBackStack();

    public abstract void popBackStack(int i, int i2);

    public abstract void popBackStack(String str, int i);

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate(int i, int i2);

    public abstract boolean popBackStackImmediate(String str, int i);

    public abstract void putFragment(Bundle bundle, String str, Fragment fragment);

    public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener);

    public abstract Fragment.SavedState saveFragmentInstanceState(Fragment fragment);
}
