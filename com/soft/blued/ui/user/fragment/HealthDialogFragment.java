package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.android.module.common.url.Blued_healthUrl;
import com.blued.android.module.common.url.Danlan_loveUrl;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/HealthDialogFragment.class */
public class HealthDialogFragment extends CommonDialogFragment {
    public static boolean b;

    public static void a(Context context) {
        new HealthDialogFragment().show(((FragmentActivity) context).getSupportFragmentManager(), "");
    }

    public void a(View view) {
        View findViewById = view.findViewById(R.id.dismiss_view);
        View findViewById2 = view.findViewById(R.id.order_view);
        View findViewById3 = view.findViewById(R.id.more_view);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.HealthDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                HealthDialogFragment.this.dismiss();
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.HealthDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                WebViewShowInfoFragment.show(HealthDialogFragment.this.getActivity(), Danlan_loveUrl.a(0), -1);
            }
        });
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.HealthDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                WebViewShowInfoFragment.show(HealthDialogFragment.this.getActivity(), Blued_healthUrl.a(0), -1);
            }
        });
    }

    public int d() {
        return R.layout.pop_user_health;
    }

    public int f() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b = true;
    }

    public void onDestroy() {
        super.onDestroy();
        b = false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
