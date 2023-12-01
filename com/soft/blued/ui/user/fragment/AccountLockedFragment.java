package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/AccountLockedFragment.class */
public class AccountLockedFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public String f20128a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public Context f20129c;
    public View d;

    public static void a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY_CONTENT", str);
        bundle.putString("KEY_UID", str2);
        TerminalActivity.d(context, AccountLockedFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        EventTrackSettings.a(SettingsProtos.Event.ACCOUNT_LOCK_APPEAL_CLICK);
        InstantLog.a("account_lock_appeal_click");
        WebViewShowInfoFragment.a(this.f20129c, BluedHttpUrl.a(this.b, 2), getResources().getString(R.string.contact_with_us), 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    public void a() {
        this.d.findViewById(2131370694).setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$AccountLockedFragment$sjwVbZyhxJfyQDAaZni-I8Yrrfw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLockedFragment.this.b(view);
            }
        });
        ((TextView) this.d.findViewById(2131371186)).setText(this.f20128a);
        ((TextView) this.d.findViewById(R.id.tv_appeal)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$AccountLockedFragment$KLkIzpPzicRSxH4LiFBGpcPF1I8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLockedFragment.this.a(view);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20129c = getActivity();
        if (this.d == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_account_locked, viewGroup, false);
            if (getArguments() != null) {
                this.f20128a = getArguments().getString("KEY_CONTENT");
                this.b = getArguments().getString("KEY_UID");
            }
            a();
        }
        return this.d;
    }
}
