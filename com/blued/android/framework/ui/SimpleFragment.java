package com.blued.android.framework.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.R;
import com.blued.android.framework.utils.Logger;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/ui/SimpleFragment.class */
public abstract class SimpleFragment extends BaseFragment {
    private static final String TAG = SimpleFragment.class.getName();
    protected Bundle args;
    protected LayoutInflater mLayoutInflater;
    public Dialog mLoadingDialog;
    public View rootView;

    public final void finish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public void hideLoading() {
        Dialog dialog;
        if (!getFragmentActive().isActive() || (dialog = this.mLoadingDialog) == null) {
            return;
        }
        dialog.dismiss();
    }

    public boolean isActive() {
        return getFragmentActive().isActive();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Logger.b(TAG, " onActivityCreated()");
        onLoadData();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.b(TAG, " onCreate()");
        onPreConfigured();
        Bundle arguments = getArguments();
        this.args = arguments;
        if (arguments == null) {
            this.args = new Bundle();
        }
        onParseArguments();
        Logger.b(TAG, " getArguments: ", this.args.toString());
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Logger.b(TAG, " onCreateView()");
        this.mLayoutInflater = layoutInflater;
        View view = this.rootView;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
            Logger.b(TAG, "rootView.getParent()).removeView(rootView)");
            return this.rootView;
        }
        this.rootView = this.mLayoutInflater.inflate(onSetRootViewId(), viewGroup, false);
        Dialog dialog = new Dialog(getContext(), R.style.TranslucentBackground);
        this.mLoadingDialog = dialog;
        dialog.setContentView(R.layout.common_loading_dialog);
        StatusBarHelper.a(this.mLoadingDialog.getWindow());
        this.mLoadingDialog.setCancelable(true);
        return this.rootView;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mLoadingDialog.dismiss();
        }
        super.onDestroy();
    }

    public void onInitListener() {
    }

    public void onInitView() {
    }

    public void onInitViewFinished() {
    }

    public void onLoadData() {
    }

    public void onParseArguments() {
    }

    protected void onPreConfigured() {
    }

    public abstract int onSetRootViewId();

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Logger.b(TAG, " onViewCreated()");
        onInitView();
        onInitViewFinished();
        onInitListener();
    }

    public void setLoadingDialog(Dialog dialog) {
        this.mLoadingDialog = dialog;
    }

    public final void setResult(int i) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(i);
        }
    }

    public final void setResult(int i, Intent intent) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(i, intent);
        }
    }

    public void showLoading() {
        Dialog dialog;
        if (!getFragmentActive().isActive() || (dialog = this.mLoadingDialog) == null) {
            return;
        }
        dialog.show();
    }
}
