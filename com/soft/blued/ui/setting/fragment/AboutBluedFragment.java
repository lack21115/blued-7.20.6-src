package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.MarketTool;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.version.update.UpdateVersionFragment;
import com.soft.blued.version.update.UpdateVersionHelper;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/AboutBluedFragment.class */
public class AboutBluedFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f33315a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f33316c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private View h;
    private ShapeTextView i;
    private ShapeTextView j;
    private Dialog k;
    private String l = AboutBluedFragment.class.getSimpleName();

    private void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.h.findViewById(2131370749);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setCenterText(getString(R.string.about_blued));
        commonTopTitleNoTrans.setLeftClickListener(this);
    }

    private void b() {
        this.b = (TextView) this.h.findViewById(R.id.tv_version_update);
        String str = getResources().getString(R.string.version_str) + " " + DeviceUtils.c();
        String str2 = str;
        if ("a8888a".equals(AppInfo.f9487c)) {
            str2 = str + " beta";
        }
        this.b.setText(str2);
        this.f33316c = (LinearLayout) this.h.findViewById(R.id.ll_version_update);
        this.d = (LinearLayout) this.h.findViewById(R.id.ll_official);
        this.f = (LinearLayout) this.h.findViewById(R.id.ll_rate_blued);
        this.i = (ShapeTextView) this.h.findViewById(R.id.iv_update_dot);
        this.e = (LinearLayout) this.h.findViewById(R.id.ll_microblogging);
        this.g = (LinearLayout) this.h.findViewById(R.id.ll_introduce);
        this.j = (ShapeTextView) this.h.findViewById(R.id.iv_introduce_dot);
        this.f33316c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
        if (DeviceUtils.f()) {
            this.d.setVisibility(8);
        }
        this.k = DialogUtils.a(getActivity());
        if (DeviceUtils.b() > StringUtils.a(BluedPreferences.dn(), 0)) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    private void c() {
        MineHttpUtils.a(getActivity(), "1", new BluedUIHttpResponse<BluedEntityA<DownloadBaseInfo>>() { // from class: com.soft.blued.ui.setting.fragment.AboutBluedFragment.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<DownloadBaseInfo> bluedEntityA) {
                if (CommonTools.a(AboutBluedFragment.this)) {
                    DialogUtils.b(AboutBluedFragment.this.k);
                    if (bluedEntityA != null) {
                        try {
                            if (bluedEntityA.hasData()) {
                                DownloadBaseInfo downloadBaseInfo = bluedEntityA.data.get(0);
                                String str = downloadBaseInfo.type;
                                if (!StringUtils.d(str) && str.equals("0")) {
                                    AppMethods.a((CharSequence) AboutBluedFragment.this.getResources().getString(R.string.biao_version_new));
                                } else if (!TextUtils.isEmpty(str) && str.equals("1")) {
                                    UpdateVersionFragment.a(AboutBluedFragment.this.f33315a, downloadBaseInfo, "i_s_weak_update");
                                } else if (TextUtils.isEmpty(str) || !str.equals("2")) {
                                } else {
                                    UpdateVersionFragment.a(AboutBluedFragment.this.f33315a, downloadBaseInfo, "i_s_strong_update");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(AboutBluedFragment.this.k);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.ll_introduce /* 2131367929 */:
                if (this.j.getVisibility() == 0) {
                    BluedPreferences.Y("" + DeviceUtils.b());
                    this.j.setVisibility(8);
                }
                WebViewShowInfoFragment.a(getActivity(), H5Url.a(49), getResources().getString(R.string.introduce), 7);
                return;
            case R.id.ll_microblogging /* 2131368031 */:
                WebViewShowInfoFragment.a(getActivity(), getResources().getString(R.string.blog_url), getResources().getString(R.string.microblogging), 7);
                return;
            case R.id.ll_official /* 2131368098 */:
                WebViewShowInfoFragment.a(getActivity(), "CN".equals(BlueAppLocal.c().getCountry()) ? BluedHttpUrl.f10844a : "http://m.bluedapp.com", getResources().getString(R.string.official), 2);
                return;
            case R.id.ll_rate_blued /* 2131368162 */:
                Intent b = MarketTool.a().b();
                if (AppUtils.a(b)) {
                    startActivity(b);
                    return;
                }
                return;
            case R.id.ll_version_update /* 2131368340 */:
                if (DeviceUtils.f()) {
                    return;
                }
                int a2 = UpdateVersionHelper.a(this.f33315a);
                if (a2 == -1) {
                    c();
                    return;
                } else if (a2 == 2) {
                    AppMethods.d(2131892290);
                    return;
                } else if (a2 != 8) {
                    return;
                } else {
                    UpdateVersionFragment.a(this.f33315a, "i_s_install_update");
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33315a = getActivity();
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_about_blued, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }
}
