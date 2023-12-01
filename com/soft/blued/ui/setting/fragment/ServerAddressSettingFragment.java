package com.soft.blued.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.statistics.BluedStatistics;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.utils.BluedPreferences;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ServerAddressSettingFragment.class */
public class ServerAddressSettingFragment extends BaseFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private View f33596a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private RadioGroup f33597c;
    private RadioButton d;
    private RadioButton e;
    private RadioButton f;
    private Button g;
    private ImageView h;

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        Tracker.onCheckedChanged(radioGroup, i);
        String sDKVersion = TTAdSdk.getAdManager().getSDKVersion();
        if (i == 2131369056) {
            Host.a(1);
        } else if (i != 2131369058) {
            Host.a(0);
        } else {
            Host.a(2);
        }
        TextView textView = this.b;
        textView.setText(Host.b() + "\n穿山甲版本号：" + sDKVersion);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131362611) {
            return;
        }
        if (this.f33597c.getCheckedRadioButtonId() == this.d.getId()) {
            BluedHttpUrl.l();
        } else if (this.f33597c.getCheckedRadioButtonId() == this.e.getId()) {
            BluedHttpUrl.k();
        } else if (this.f33597c.getCheckedRadioButtonId() == this.f.getId()) {
            BluedHttpUrl.m();
        }
        BluedApplicationLike.initCoroutineRequestHost();
        BluedStatistics.a(AppInfo.d(), BluedHttpUrl.w(), 443, HappyDnsUtils.d());
        LiveMsgSendManager.a().b();
        getActivity().finish();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f33596a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_server_head_change, viewGroup, false);
            this.f33596a = inflate;
            RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.rdgrp_servers);
            this.f33597c = radioGroup;
            radioGroup.setOnCheckedChangeListener(this);
            this.d = (RadioButton) this.f33596a.findViewById(R.id.rd_online);
            this.f = (RadioButton) this.f33596a.findViewById(R.id.rd_pre_online);
            this.e = (RadioButton) this.f33596a.findViewById(R.id.rd_debug);
            this.b = (TextView) this.f33596a.findViewById(R.id.address);
            this.h = (ImageView) this.f33596a.findViewById(R.id.iv_splash_toggle);
            int j = BluedHttpUrl.j();
            if (j == 1) {
                this.e.setChecked(true);
            } else if (j != 2) {
                this.d.setChecked(true);
            } else {
                this.f.setChecked(true);
            }
            Host.a(BluedHttpUrl.i());
            this.b.setText(Host.b());
            if (BluedPreferences.E()) {
                this.h.setImageResource(2131237259);
            } else {
                this.h.setImageResource(2131237258);
            }
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ServerAddressSettingFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    BluedPreferences.a(!BluedPreferences.E());
                    if (BluedPreferences.E()) {
                        ServerAddressSettingFragment.this.h.setImageResource(2131237259);
                    } else {
                        ServerAddressSettingFragment.this.h.setImageResource(2131237258);
                    }
                }
            });
            Button button = (Button) this.f33596a.findViewById(2131362611);
            this.g = button;
            button.setOnClickListener(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f33596a.getParent()).removeView(this.f33596a);
        }
        return this.f33596a;
    }
}
