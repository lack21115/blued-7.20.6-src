package com.soft.blued.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/fragment/PendingFragment.class */
public class PendingFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private int f29653a = 0;
    private Context b;

    private void a(Bundle bundle) {
        Logger.b("PendingFragment", "action:", Integer.valueOf(this.f29653a));
        if (bundle == null) {
            getActivity().finish();
            return;
        }
        if (this.f29653a == 1) {
            DialogSkipFragment.a(this.b, (ChannelModel) bundle.getSerializable("CHANNEL"));
        }
        getActivity().finish();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Logger.b("PendingFragment", "onCreate");
        this.b = getActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f29653a = arguments.getInt("action", 0);
        }
        a(arguments);
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
