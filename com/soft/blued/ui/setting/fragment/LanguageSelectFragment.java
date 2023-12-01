package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.expressad.video.dynview.a.a;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.assist.sdk.AssistPushConsts;
import com.opos.acs.st.STManager;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.community.model.DiscoveryPageTabModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.controller.tools.IMManager;
import com.soft.blued.ui.msg.model.MessageTabModel;
import com.soft.blued.user.BluedConfig;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/LanguageSelectFragment.class */
public class LanguageSelectFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f19700a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private CommonTopTitleNoTrans f19701c;
    private Dialog d;
    private View f;
    private View g;
    private View h;
    private View i;
    private TextView j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private int o;
    private int p;
    private String e = LanguageSelectFragment.class.getSimpleName();
    private long q = m.ag;
    private Handler r = new Handler();
    private boolean s = false;

    private void a() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        this.f19701c = findViewById;
        findViewById.setCenterText(getString(R.string.laguage_more));
        this.f19701c.setRightText((int) R.string.save);
        this.f19701c.setRightTextColor(2131101772);
        this.f19701c.setLeftClickListener(this);
        this.f19701c.setRightClickListener(this);
    }

    private void a(int i) {
        if (i == 1) {
            this.h.setVisibility(0);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
        } else if (i == 2) {
            this.h.setVisibility(8);
            this.g.setVisibility(0);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
        } else if (i == 3) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.f.setVisibility(0);
            this.i.setVisibility(8);
        } else if (i == 4) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(0);
        } else if (i == 5) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
        } else if (i == 6) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
        } else if (i == 7) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
        } else if (i == 8) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
        } else if (i == 9) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
        } else if (i == 10) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public static void a(Context context) {
        TerminalActivity.d(context, LanguageSelectFragment.class, (Bundle) null);
    }

    private void a(String str, String str2) {
        LocaleUtils.a(false);
        LocaleUtils.a(this.f19700a, new Locale(str, str2));
        BluedConfig.a().d();
        b();
    }

    private void b() {
        final long currentTimeMillis = System.currentTimeMillis();
        DialogUtils.a(this.d);
        MineHttpUtils.e(this.f19700a, new BluedUIHttpResponse() { // from class: com.soft.blued.ui.setting.fragment.LanguageSelectFragment.1
            public void onUIFinish() {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 < m.ag) {
                    LanguageSelectFragment.this.r.postDelayed(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.LanguageSelectFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LanguageSelectFragment.this.f19700a != null) {
                                DialogUtils.b(LanguageSelectFragment.this.d);
                                LocaleUtils.c(AppInfo.d());
                                Intent intent = new Intent(LanguageSelectFragment.this.f19700a, HomeActivity.class);
                                intent.setFlags(268468224);
                                LanguageSelectFragment.this.f19700a.startActivity(intent);
                                ChatManager.getInstance().initLanguage();
                                LiveMsgSendManager.a().c();
                            }
                        }
                    }, LanguageSelectFragment.this.q - currentTimeMillis2);
                    return;
                }
                DialogUtils.b(LanguageSelectFragment.this.d);
                LocaleUtils.c(AppInfo.d());
                Intent intent = new Intent(LanguageSelectFragment.this.f19700a, HomeActivity.class);
                intent.setFlags(268468224);
                LanguageSelectFragment.this.f19700a.startActivity(intent);
                ChatManager.getInstance().initLanguage();
                IMManager.a().b();
                LiveMsgSendManager.a().c();
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    private void c() {
        String str;
        this.d = DialogUtils.a(this.f19700a);
        this.j = (TextView) this.b.findViewById(R.id.tv_system);
        this.i = this.b.findViewById(R.id.tv_select_en);
        this.g = this.b.findViewById(R.id.tv_select_zhcn);
        this.f = this.b.findViewById(R.id.tv_select_zhtw);
        this.h = this.b.findViewById(R.id.tv_select_sys);
        Locale e = LocaleUtils.e();
        String language = e.getLanguage();
        String country = e.getCountry();
        if (TextUtils.isEmpty(language)) {
            this.j.setText(getResources().getString(R.string.laguage_system));
        } else if (language.equals(a.V)) {
            if (TextUtils.isEmpty(country) || !(country.equals("TW") || country.equals(a.ae))) {
                TextView textView = this.j;
                textView.setText(getResources().getString(R.string.laguage_system) + " (" + getResources().getString(R.string.laguage_zhcn) + ")");
            } else {
                TextView textView2 = this.j;
                textView2.setText(getResources().getString(R.string.laguage_system) + " (" + getResources().getString(R.string.laguage_zhtw) + ")");
            }
        } else if (language.equals("en")) {
            TextView textView3 = this.j;
            textView3.setText(getResources().getString(R.string.laguage_system) + " (" + getResources().getString(R.string.laguage_english) + ")");
        } else {
            TextView textView4 = this.j;
            textView4.setText(getResources().getString(R.string.laguage_system) + " (" + getResources().getString(R.string.laguage_english) + ")");
        }
        Locale c2 = LocaleUtils.c();
        String str2 = "";
        if (LocaleUtils.a() || c2 == null) {
            str = "";
        } else {
            str2 = c2.getLanguage();
            str = c2.getCountry();
        }
        if (TextUtils.isEmpty(str2)) {
            this.p = 1;
            this.o = 1;
        } else if (str2.equals(a.V)) {
            if (TextUtils.isEmpty(str) || !(TextUtils.equals(str, "TW") || TextUtils.equals(str, a.ae))) {
                this.p = 2;
                this.o = 2;
            } else {
                this.p = 3;
                this.o = 3;
            }
        } else if (str2.equals("en")) {
            this.p = 4;
            this.o = 4;
        } else if (str2.equals(a.W)) {
            this.p = 4;
            this.o = 4;
        } else if (str2.equals(a.Y)) {
            this.p = 4;
            this.o = 4;
        } else if (str2.equals("th")) {
            this.p = 4;
            this.o = 4;
        } else if (str2.equals(a.Z)) {
            this.p = 4;
            this.o = 4;
        } else if (str2.equals("es")) {
            this.p = 4;
            this.o = 4;
        } else if (str2.equals("pt")) {
            this.p = 4;
            this.o = 4;
        } else {
            this.p = 1;
            this.o = 1;
        }
        a(this.o);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_system);
        this.k = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.b.findViewById(R.id.ll_zh_cn);
        this.l = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) this.b.findViewById(R.id.ll_zh_tw);
        this.m = linearLayout3;
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) this.b.findViewById(R.id.ll_en);
        this.n = linearLayout4;
        linearLayout4.setOnClickListener(this);
    }

    public boolean onBackPressed() {
        getActivity().finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                onBackPressed();
                return;
            case 2131363126:
                if (this.s) {
                    DiscoveryPageTabModel.clearTabs();
                    MessageTabModel.clearTabs();
                    int i = this.p;
                    if (i == 1) {
                        LocaleUtils.a(true);
                        LocaleUtils.a(this.f19700a, LocaleUtils.e());
                        BluedConfig.a().d();
                        b();
                        return;
                    } else if (i == 2) {
                        a(a.V, "CN");
                        return;
                    } else if (i == 3) {
                        a(a.V, "TW");
                        return;
                    } else if (i == 4) {
                        a("en", "US");
                        return;
                    } else if (i == 5) {
                        a(a.W, "JP");
                        return;
                    } else if (i == 6) {
                        a(a.Y, "KR");
                        return;
                    } else if (i == 7) {
                        a("th", STManager.REGION_OF_TH);
                        return;
                    } else if (i == 8) {
                        a(a.Z, "FR");
                        return;
                    } else if (i == 9) {
                        a("es", "ES");
                        return;
                    } else if (i == 10) {
                        a("pt", AssistPushConsts.MSG_VALUE_PAYLOAD);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case R.id.ll_en /* 2131367763 */:
                this.p = 4;
                a(4);
                this.s = true;
                this.f19701c.setRightTextColor(2131101766);
                return;
            case R.id.ll_system /* 2131368265 */:
                this.p = 1;
                a(1);
                this.s = true;
                this.f19701c.setRightTextColor(2131101766);
                return;
            case R.id.ll_zh_cn /* 2131368372 */:
                this.p = 2;
                a(2);
                this.s = true;
                this.f19701c.setRightTextColor(2131101766);
                return;
            case R.id.ll_zh_tw /* 2131368373 */:
                this.p = 3;
                a(3);
                this.s = true;
                this.f19701c.setRightTextColor(2131101766);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19700a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_language_select, viewGroup, false);
            a();
            c();
        } else {
            ((ViewGroup) view.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
