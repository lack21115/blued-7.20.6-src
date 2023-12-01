package com.android.internal.app;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/MediaRouteChooserDialogFragment.class */
public class MediaRouteChooserDialogFragment extends DialogFragment {
    private final String ARGUMENT_ROUTE_TYPES = "routeTypes";
    private View.OnClickListener mExtendedSettingsClickListener;

    public MediaRouteChooserDialogFragment() {
        setCancelable(true);
        setStyle(0, R.style.Theme_DeviceDefault_Dialog);
    }

    public int getRouteTypes() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt("routeTypes");
        }
        return 0;
    }

    public MediaRouteChooserDialog onCreateChooserDialog(Context context, Bundle bundle) {
        return new MediaRouteChooserDialog(context, getTheme());
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        MediaRouteChooserDialog onCreateChooserDialog = onCreateChooserDialog(getActivity(), bundle);
        onCreateChooserDialog.setRouteTypes(getRouteTypes());
        onCreateChooserDialog.setExtendedSettingsClickListener(this.mExtendedSettingsClickListener);
        return onCreateChooserDialog;
    }

    public void setExtendedSettingsClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != this.mExtendedSettingsClickListener) {
            this.mExtendedSettingsClickListener = onClickListener;
            MediaRouteChooserDialog mediaRouteChooserDialog = (MediaRouteChooserDialog) getDialog();
            if (mediaRouteChooserDialog != null) {
                mediaRouteChooserDialog.setExtendedSettingsClickListener(onClickListener);
            }
        }
    }

    public void setRouteTypes(int i) {
        if (i != getRouteTypes()) {
            Bundle arguments = getArguments();
            Bundle bundle = arguments;
            if (arguments == null) {
                bundle = new Bundle();
            }
            bundle.putInt("routeTypes", i);
            setArguments(bundle);
            MediaRouteChooserDialog mediaRouteChooserDialog = (MediaRouteChooserDialog) getDialog();
            if (mediaRouteChooserDialog != null) {
                mediaRouteChooserDialog.setRouteTypes(i);
            }
        }
    }
}
