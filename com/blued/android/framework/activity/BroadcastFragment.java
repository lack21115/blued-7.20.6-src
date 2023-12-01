package com.blued.android.framework.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/BroadcastFragment.class */
public class BroadcastFragment extends KeyBoardFragment {
    private BroadcastReceiver b = new BroadcastReceiver() { // from class: com.blued.android.framework.activity.BroadcastFragment.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BroadcastFragment.this.getActivity().finish();
        }
    };

    @Override // com.blued.android.core.ui.BaseFragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("clear_topic_stack");
        getActivity().registerReceiver(this.b, intentFilter);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDetach() {
        super.onDetach();
        getActivity().unregisterReceiver(this.b);
    }
}
