package com.android.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.media.MediaRouter;
import android.util.Log;
import android.view.View;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/MediaRouteDialogPresenter.class */
public abstract class MediaRouteDialogPresenter {
    private static final String CHOOSER_FRAGMENT_TAG = "android.app.MediaRouteButton:MediaRouteChooserDialogFragment";
    private static final String CONTROLLER_FRAGMENT_TAG = "android.app.MediaRouteButton:MediaRouteControllerDialogFragment";
    private static final String TAG = "MediaRouter";

    public static Dialog createDialog(Context context, int i, View.OnClickListener onClickListener) {
        MediaRouter.RouteInfo selectedRoute = ((MediaRouter) context.getSystemService(Context.MEDIA_ROUTER_SERVICE)).getSelectedRoute();
        if (selectedRoute.isDefault() || !selectedRoute.matchesTypes(i)) {
            MediaRouteChooserDialog mediaRouteChooserDialog = new MediaRouteChooserDialog(context, 16974126);
            mediaRouteChooserDialog.setRouteTypes(i);
            mediaRouteChooserDialog.setExtendedSettingsClickListener(onClickListener);
            return mediaRouteChooserDialog;
        }
        return new MediaRouteControllerDialog(context, 16974126);
    }

    public static DialogFragment showDialogFragment(Activity activity, int i, View.OnClickListener onClickListener) {
        MediaRouter mediaRouter = (MediaRouter) activity.getSystemService(Context.MEDIA_ROUTER_SERVICE);
        FragmentManager fragmentManager = activity.getFragmentManager();
        MediaRouter.RouteInfo selectedRoute = mediaRouter.getSelectedRoute();
        if (!selectedRoute.isDefault() && selectedRoute.matchesTypes(i)) {
            if (fragmentManager.findFragmentByTag(CONTROLLER_FRAGMENT_TAG) != null) {
                Log.w(TAG, "showDialog(): Route controller dialog already showing!");
                return null;
            }
            MediaRouteControllerDialogFragment mediaRouteControllerDialogFragment = new MediaRouteControllerDialogFragment();
            mediaRouteControllerDialogFragment.show(fragmentManager, CONTROLLER_FRAGMENT_TAG);
            return mediaRouteControllerDialogFragment;
        } else if (fragmentManager.findFragmentByTag(CHOOSER_FRAGMENT_TAG) != null) {
            Log.w(TAG, "showDialog(): Route chooser dialog already showing!");
            return null;
        } else {
            MediaRouteChooserDialogFragment mediaRouteChooserDialogFragment = new MediaRouteChooserDialogFragment();
            mediaRouteChooserDialogFragment.setRouteTypes(i);
            mediaRouteChooserDialogFragment.setExtendedSettingsClickListener(onClickListener);
            mediaRouteChooserDialogFragment.show(fragmentManager, CHOOSER_FRAGMENT_TAG);
            return mediaRouteChooserDialogFragment;
        }
    }
}
