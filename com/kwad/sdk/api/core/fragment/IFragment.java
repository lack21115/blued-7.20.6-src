package com.kwad.sdk.api.core.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KsAdSdkDynamicApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/fragment/IFragment.class */
interface IFragment {
    @KsAdSdkDynamicApi
    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @KsAdSdkDynamicApi
    Activity getActivity();

    @KsAdSdkDynamicApi
    boolean getAllowEnterTransitionOverlap();

    @KsAdSdkDynamicApi
    boolean getAllowReturnTransitionOverlap();

    Bundle getArguments();

    KsFragmentManager getChildFragmentManager();

    @KsAdSdkDynamicApi
    Context getContext();

    @KsAdSdkDynamicApi
    Object getEnterTransition();

    @KsAdSdkDynamicApi
    Object getExitTransition();

    KsFragmentManager getFragmentManager();

    Object getHost();

    int getId();

    @KsAdSdkDynamicApi
    LayoutInflater getLayoutInflater(Bundle bundle);

    KsLifecycle getLifecycle();

    KsFragment getParentFragment();

    @KsAdSdkDynamicApi
    Object getReenterTransition();

    Resources getResources();

    boolean getRetainInstance();

    @KsAdSdkDynamicApi
    Object getReturnTransition();

    @KsAdSdkDynamicApi
    Object getSharedElementEnterTransition();

    @KsAdSdkDynamicApi
    Object getSharedElementReturnTransition();

    String getString(int i);

    String getString(int i, Object... objArr);

    String getTag();

    int getTargetRequestCode();

    CharSequence getText(int i);

    @KsAdSdkDynamicApi
    boolean getUserVisibleHint();

    @KsAdSdkDynamicApi
    View getView();

    boolean hasOptionsMenu();

    boolean isAdded();

    boolean isDetached();

    boolean isHidden();

    boolean isInLayout();

    boolean isMenuVisible();

    boolean isRemoving();

    boolean isResumed();

    boolean isStateSaved();

    boolean isVisible();

    LayoutInflater onGetLayoutInflater(Bundle bundle);

    @KsAdSdkDynamicApi
    void postponeEnterTransition();

    @KsAdSdkDynamicApi
    void registerForContextMenu(View view);

    void requestPermissions(String[] strArr, int i);

    @KsAdSdkDynamicApi
    void setAllowEnterTransitionOverlap(boolean z);

    @KsAdSdkDynamicApi
    void setAllowReturnTransitionOverlap(boolean z);

    @KsAdSdkDynamicApi
    void setArguments(Bundle bundle);

    @KsAdSdkDynamicApi
    void setEnterTransition(Object obj);

    @KsAdSdkDynamicApi
    void setExitTransition(Object obj);

    @KsAdSdkDynamicApi
    void setHasOptionsMenu(boolean z);

    void setInitialSavedState(KsSavedState ksSavedState);

    @KsAdSdkDynamicApi
    void setMenuVisibility(boolean z);

    @KsAdSdkDynamicApi
    void setReenterTransition(Object obj);

    @KsAdSdkDynamicApi
    void setRetainInstance(boolean z);

    @KsAdSdkDynamicApi
    void setReturnTransition(Object obj);

    @KsAdSdkDynamicApi
    void setSharedElementEnterTransition(Object obj);

    @KsAdSdkDynamicApi
    void setSharedElementReturnTransition(Object obj);

    @KsAdSdkDynamicApi
    void setUserVisibleHint(boolean z);

    @KsAdSdkDynamicApi
    boolean shouldShowRequestPermissionRationale(String str);

    @KsAdSdkDynamicApi
    void startActivity(Intent intent);

    @KsAdSdkDynamicApi
    void startActivity(Intent intent, Bundle bundle);

    @KsAdSdkDynamicApi
    void startActivityForResult(Intent intent, int i);

    @KsAdSdkDynamicApi
    void startActivityForResult(Intent intent, int i, Bundle bundle);

    @KsAdSdkDynamicApi
    void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle);

    @KsAdSdkDynamicApi
    void startPostponedEnterTransition();

    @KsAdSdkDynamicApi
    void unregisterForContextMenu(View view);
}
