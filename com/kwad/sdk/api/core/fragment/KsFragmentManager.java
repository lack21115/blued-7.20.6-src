package com.kwad.sdk.api.core.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@KsAdSdkDynamicApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/fragment/KsFragmentManager.class */
public class KsFragmentManager {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    private final FragmentManager mBase;

    @KsAdSdkDynamicApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/fragment/KsFragmentManager$FragmentLifecycleCallbacks.class */
    public static abstract class FragmentLifecycleCallbacks {
        private FragmentManager.FragmentLifecycleCallbacks mBase;

        FragmentManager.FragmentLifecycleCallbacks getBase() {
            return this.mBase;
        }

        @KsAdSdkDynamicApi
        public void onFragmentActivityCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentAttached(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Context context) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentDestroyed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentDetached(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentPaused(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentPreAttached(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Context context) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentPreCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentResumed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentSaveInstanceState(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentStarted(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentStopped(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentViewCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, View view, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        public void onFragmentViewDestroyed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        void setBase(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
            this.mBase = fragmentLifecycleCallbacks;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KsFragmentManager(FragmentManager fragmentManager) {
        this.mBase = fragmentManager;
    }

    @KsAdSdkDynamicApi
    public static void enableDebugLogging(boolean z) {
        while (true) {
        }
    }

    @KsAdSdkDynamicApi
    public KsFragmentTransaction beginTransaction() {
        return new KsFragmentTransaction(this.mBase.beginTransaction());
    }

    @KsAdSdkDynamicApi
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mBase.dump(str, fileDescriptor, printWriter, strArr);
    }

    @KsAdSdkDynamicApi
    public boolean executePendingTransactions() {
        return this.mBase.executePendingTransactions();
    }

    @KsAdSdkDynamicApi
    public KsFragment findFragmentById(int i) {
        Fragment findFragmentById = this.mBase.findFragmentById(i);
        if (findFragmentById instanceof IDelegateFragment) {
            return ((IDelegateFragment) findFragmentById).getBase();
        }
        if (findFragmentById == null) {
            return null;
        }
        throw new RuntimeException(findFragmentById + " is not a DelegateFragment");
    }

    @KsAdSdkDynamicApi
    public KsFragment findFragmentByTag(String str) {
        Fragment findFragmentByTag = this.mBase.findFragmentByTag(str);
        if (findFragmentByTag instanceof IDelegateFragment) {
            return ((IDelegateFragment) findFragmentByTag).getBase();
        }
        if (findFragmentByTag == null) {
            return null;
        }
        throw new RuntimeException(findFragmentByTag + " is not a DelegateFragment");
    }

    @KsAdSdkDynamicApi
    public int getBackStackEntryCount() {
        return this.mBase.getBackStackEntryCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentManager getBase() {
        return this.mBase;
    }

    @KsAdSdkDynamicApi
    public KsFragment getFragment(Bundle bundle, String str) {
        Fragment fragment = this.mBase.getFragment(bundle, str);
        if (fragment instanceof IDelegateFragment) {
            return ((IDelegateFragment) fragment).getBase();
        }
        if (fragment == null) {
            return null;
        }
        throw new RuntimeException(fragment + " is not a DelegateFragment or DelegateDialogFragment");
    }

    @KsAdSdkDynamicApi
    public List<KsFragment> getFragments() {
        List<Fragment> fragments = this.mBase.getFragments();
        ArrayList arrayList = new ArrayList(fragments.size());
        for (Fragment fragment : fragments) {
            if (!(fragment instanceof IDelegateFragment)) {
                throw new RuntimeException(fragment + " is not a DelegateFragment");
            }
            arrayList.add(((IDelegateFragment) fragment).getBase());
        }
        return arrayList;
    }

    @KsAdSdkDynamicApi
    public boolean isDestroyed() {
        return this.mBase.isDestroyed();
    }

    @KsAdSdkDynamicApi
    public boolean isStateSaved() {
        return this.mBase.isStateSaved();
    }

    @KsAdSdkDynamicApi
    @Deprecated
    public KsFragmentTransaction openTransaction() {
        return new KsFragmentTransaction(this.mBase.beginTransaction());
    }

    @KsAdSdkDynamicApi
    public void popBackStack() {
        this.mBase.popBackStack();
    }

    @KsAdSdkDynamicApi
    public void popBackStack(int i, int i2) {
        this.mBase.popBackStack(i, i2);
    }

    @KsAdSdkDynamicApi
    public void popBackStack(String str, int i) {
        this.mBase.popBackStack(str, i);
    }

    @KsAdSdkDynamicApi
    public boolean popBackStackImmediate() {
        return this.mBase.popBackStackImmediate();
    }

    @KsAdSdkDynamicApi
    public boolean popBackStackImmediate(int i, int i2) {
        return this.mBase.popBackStackImmediate(i, i2);
    }

    @KsAdSdkDynamicApi
    public boolean popBackStackImmediate(String str, int i) {
        return this.mBase.popBackStackImmediate(str, i);
    }

    @KsAdSdkDynamicApi
    public void putFragment(Bundle bundle, String str, KsFragment ksFragment) {
        this.mBase.putFragment(bundle, str, ksFragment.getBase());
    }

    @KsAdSdkDynamicApi
    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        fragmentLifecycleCallbacks.setBase(new DelegateFragmentLifecycleCallbacks(this, fragmentLifecycleCallbacks));
        this.mBase.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks.getBase(), z);
    }

    @KsAdSdkDynamicApi
    public KsSavedState saveFragmentInstanceState(KsFragment ksFragment) {
        return new KsSavedState(this.mBase.saveFragmentInstanceState(ksFragment.getBase()));
    }

    @KsAdSdkDynamicApi
    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mBase.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks.getBase());
    }
}
