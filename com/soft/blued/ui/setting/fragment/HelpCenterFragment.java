package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.msg_group.model.BillIdentifyModel;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.ui.setting.vm.HelperCenterVM;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/HelpCenterFragment.class */
public class HelpCenterFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    View f19692a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f19693c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private HelperCenterVM k;

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        this.k.d().observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.setting.fragment.HelpCenterFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue() && UserInfo.getInstance().isLogin()) {
                    HelpCenterFragment.this.j.setVisibility(0);
                }
            }
        });
    }

    public static void a(Context context) {
        TerminalActivity.d(context, HelpCenterFragment.class, (Bundle) null);
    }

    private void b() {
        CommonTopTitleNoTrans findViewById = this.f19692a.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(R.string.help_and_feedback));
        findViewById.setLeftClickListener(this);
    }

    private void c() {
        this.f19693c = this.f19692a.findViewById(R.id.top_divider);
        this.d = (LinearLayout) this.f19692a.findViewById(R.id.ll_consult_online);
        this.e = (LinearLayout) this.f19692a.findViewById(R.id.ll_termes);
        this.f = (LinearLayout) this.f19692a.findViewById(R.id.ll_code_of_conduct);
        this.g = (LinearLayout) this.f19692a.findViewById(R.id.ll_live_specification);
        this.h = (LinearLayout) this.f19692a.findViewById(R.id.ll_contact);
        this.i = (LinearLayout) this.f19692a.findViewById(R.id.ll_privacy_clause);
        this.j = (LinearLayout) this.f19692a.findViewById(R.id.ll_invoice);
        if (UserInfo.getInstance().isLogin()) {
            this.d.setVisibility(0);
            this.d.setOnClickListener(this);
            this.f19693c.setVisibility(0);
        } else {
            this.d.setVisibility(8);
            this.f19693c.setVisibility(8);
        }
        this.g.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    private void d() {
        MineHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<BillIdentifyModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.HelpCenterFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BillIdentifyModel> bluedEntityA) {
                if (bluedEntityA.hasData() && ((BillIdentifyModel) bluedEntityA.getSingleData()).getVerify() == 1) {
                    WebViewShowInfoFragment.show(HelpCenterFragment.this.getActivity(), Host.a("H5_INVOICE"));
                } else {
                    TerminalActivity.d(HelpCenterFragment.this.getActivity(), InvoiceIdentifyFragment.class, (Bundle) null);
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                if (getActivity() != null) {
                    getActivity().finish();
                    return;
                }
                return;
            case R.id.ll_code_of_conduct /* 2131367707 */:
                WebViewShowInfoFragment.a(this.b, H5Url.a(23), getResources().getString(R.string.code_of_conduct), 7);
                return;
            case R.id.ll_consult_online /* 2131367713 */:
                InstantLog.a("my_consultation");
                WebViewShowInfoFragment.show(this.b, "https://activity.blued.cn/activityblued/pcview/OxINCzt6", 0);
                return;
            case R.id.ll_contact /* 2131367714 */:
                WebViewShowInfoFragment.show(getActivity(), H5Url.a(90), 0);
                return;
            case R.id.ll_invoice /* 2131367931 */:
                d();
                return;
            case R.id.ll_live_specification /* 2131367982 */:
                WebViewShowInfoFragment.a(this.b, H5Url.a(24), getResources().getString(R.string.live_specification), 7);
                return;
            case R.id.ll_privacy_clause /* 2131368141 */:
                WebViewShowInfoFragment.show(getActivity(), H5Url.a(22), 0);
                return;
            case R.id.ll_termes /* 2131368280 */:
                WebViewShowInfoFragment.a(this.b, H5Url.a(21), getResources().getString(R.string.provision), 7);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.f19692a;
        if (view == null) {
            this.f19692a = layoutInflater.inflate(R.layout.fragment_help_center, viewGroup, false);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f19692a.getParent()).removeView(this.f19692a);
        }
        return this.f19692a;
    }

    public void onResume() {
        super.onResume();
        ServiceHelper.f19954a.a((QBadgeContainer) this.f19692a.findViewById(R.id.badge_container), this.f19692a.findViewById(R.id.bindView));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        b();
        c();
        this.k = (HelperCenterVM) new ViewModelProvider(this).get(HelperCenterVM.class);
        a();
        this.k.e();
    }
}
