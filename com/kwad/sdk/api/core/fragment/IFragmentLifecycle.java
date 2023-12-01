package com.kwad.sdk.api.core.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/fragment/IFragmentLifecycle.class */
interface IFragmentLifecycle {
    @Deprecated
    void onActivityCreated(Bundle bundle);

    void onActivityResult(int i, int i2, Intent intent);

    void onAttach(Activity activity);

    void onAttach(Context context);

    void onAttachFragment(KsFragment ksFragment);

    void onConfigurationChanged(Configuration configuration);

    boolean onContextItemSelected(MenuItem menuItem);

    void onCreate(Bundle bundle);

    Animation onCreateAnimation(int i, boolean z, int i2);

    Animator onCreateAnimator(int i, boolean z, int i2);

    void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

    View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void onDestroy();

    void onDestroyOptionsMenu();

    void onDestroyView();

    void onDetach();

    void onHiddenChanged(boolean z);

    void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle);

    void onInflate(Context context, AttributeSet attributeSet, Bundle bundle);

    void onLowMemory();

    void onMultiWindowModeChanged(boolean z);

    boolean onOptionsItemSelected(MenuItem menuItem);

    void onOptionsMenuClosed(Menu menu);

    void onPause();

    void onPictureInPictureModeChanged(boolean z);

    void onPrepareOptionsMenu(Menu menu);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void onViewCreated(View view, Bundle bundle);

    void onViewStateRestored(Bundle bundle);
}
