package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.user.observer.ReportObserver;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ChooseReportReasonFragment.class */
public class ChooseReportReasonFragment extends BaseFragment implements View.OnClickListener, ReportObserver.IReportObserver {

    /* renamed from: a  reason: collision with root package name */
    private View f20149a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private int f20150c;
    private String d;
    private boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;

    public static void a(BaseFragment baseFragment, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("KEY_HIDE_RIGHT_ARROW", z);
        bundle.putBoolean("KEY_REPORT_EVENT_TYPE", z2);
        TerminalActivity.a(baseFragment, ChooseReportReasonFragment.class, bundle, 1);
    }

    public void a() {
        CommonTopTitleNoTrans findViewById = this.f20149a.findViewById(2131370694);
        findViewById.setCenterText(this.b.getResources().getString(2131891497));
        findViewById.a();
        findViewById.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ChooseReportReasonFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChooseReportReasonFragment.this.a(0);
            }
        });
        View findViewById2 = this.f20149a.findViewById(R.id.view_cheat);
        this.g = findViewById2;
        ((TextView) findViewById2.findViewById(2131372708)).setText(R.string.cheat_report);
        this.g.setOnClickListener(this);
        View findViewById3 = this.f20149a.findViewById(R.id.view_unauth);
        this.h = findViewById3;
        ((TextView) findViewById3.findViewById(2131372708)).setText(R.string.content_unauth_report);
        this.h.setOnClickListener(this);
        View findViewById4 = this.f20149a.findViewById(R.id.view_personal);
        this.i = findViewById4;
        ((TextView) findViewById4.findViewById(2131372708)).setText(R.string.personal_report);
        this.i.setOnClickListener(this);
        View findViewById5 = this.f20149a.findViewById(R.id.view_drug);
        this.j = findViewById5;
        ((TextView) findViewById5.findViewById(2131372708)).setText(R.string.drug_report);
        this.j.setOnClickListener(this);
        View findViewById6 = this.f20149a.findViewById(R.id.view_political);
        this.k = findViewById6;
        ((TextView) findViewById6.findViewById(2131372708)).setText(R.string.political_report);
        this.k.setOnClickListener(this);
        View findViewById7 = this.f20149a.findViewById(R.id.view_porn);
        this.l = findViewById7;
        ((TextView) findViewById7.findViewById(2131372708)).setText(R.string.porn_repot);
        this.l.setOnClickListener(this);
        View findViewById8 = this.f20149a.findViewById(R.id.view_ad);
        this.m = findViewById8;
        ((TextView) findViewById8.findViewById(2131372708)).setText(R.string.ad_report);
        this.m.setOnClickListener(this);
        View findViewById9 = this.f20149a.findViewById(R.id.view_other);
        this.o = findViewById9;
        ((TextView) findViewById9.findViewById(2131372708)).setText(R.string.other_dialog_report);
        this.o.setOnClickListener(this);
        View findViewById10 = this.f20149a.findViewById(R.id.view_minors);
        this.n = findViewById10;
        ((TextView) findViewById10.findViewById(2131372708)).setText(R.string.minors_report);
        this.n.setOnClickListener(this);
        View findViewById11 = this.f20149a.findViewById(R.id.view_gambling);
        this.p = findViewById11;
        ((TextView) findViewById11.findViewById(2131372708)).setText(R.string.gambling_report);
        this.p.setOnClickListener(this);
        this.p.setVisibility(8);
        if (this.e) {
            this.g.findViewById(R.id.img_right_arrow).setVisibility(8);
            this.h.findViewById(R.id.img_right_arrow).setVisibility(8);
            this.i.findViewById(R.id.img_right_arrow).setVisibility(8);
            this.j.findViewById(R.id.img_right_arrow).setVisibility(8);
            this.k.findViewById(R.id.img_right_arrow).setVisibility(8);
            this.l.findViewById(R.id.img_right_arrow).setVisibility(8);
            this.m.findViewById(R.id.img_right_arrow).setVisibility(8);
            this.o.findViewById(R.id.img_right_arrow).setVisibility(8);
            this.n.findViewById(R.id.img_right_arrow).setVisibility(8);
        }
        if (this.f) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.p.setVisibility(0);
        }
    }

    public void a(int i) {
        if (i == 0) {
            getActivity().setResult(i);
        } else {
            Intent intent = new Intent();
            intent.putExtra("KEY_REPORT_ITEM_ID", this.f20150c);
            intent.putExtra("KEY_REPORT_ITEM_TEXT", this.d);
            getActivity().setResult(-1, intent);
        }
        getActivity().finish();
    }

    @Override // com.soft.blued.ui.user.observer.ReportObserver.IReportObserver
    public void a(boolean z) {
        if (!z || getActivity() == null) {
            return;
        }
        getActivity().finish();
    }

    public boolean onBackPressed() {
        a(0);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.view_ad /* 2131373103 */:
                this.f20150c = 1;
                this.d = this.b.getResources().getString(R.string.ad_report);
                break;
            case R.id.view_cheat /* 2131373134 */:
                this.f20150c = 6;
                this.d = this.b.getResources().getString(R.string.cheat_report);
                break;
            case R.id.view_drug /* 2131373160 */:
                this.f20150c = 5;
                this.d = this.b.getResources().getString(R.string.drug_report);
                break;
            case R.id.view_gambling /* 2131373170 */:
                this.f20150c = 10;
                this.d = this.b.getResources().getString(R.string.gambling_report);
                break;
            case R.id.view_minors /* 2131373194 */:
                this.f20150c = 9;
                this.d = this.b.getResources().getString(R.string.minors_report);
                break;
            case R.id.view_other /* 2131373206 */:
                this.f20150c = 0;
                this.d = this.b.getResources().getString(R.string.other_dialog_report);
                break;
            case R.id.view_personal /* 2131373211 */:
                this.f20150c = 8;
                this.d = this.b.getResources().getString(R.string.personal_report);
                break;
            case R.id.view_political /* 2131373216 */:
                this.f20150c = 4;
                this.d = this.b.getResources().getString(R.string.political_report);
                break;
            case R.id.view_porn /* 2131373217 */:
                this.f20150c = 2;
                this.d = this.b.getResources().getString(R.string.porn_repot);
                break;
            case R.id.view_unauth /* 2131373262 */:
                this.f20150c = 7;
                this.d = this.b.getResources().getString(R.string.content_unauth_report);
                break;
        }
        a(-1);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        if (this.f20149a == null) {
            this.f20149a = layoutInflater.inflate(R.layout.fragment_choose_report_reason, viewGroup, false);
            if (getArguments() != null) {
                this.e = getArguments().getBoolean("KEY_HIDE_RIGHT_ARROW");
                this.f = getArguments().getBoolean("KEY_REPORT_EVENT_TYPE");
            }
            a();
            ReportObserver.a().a(this);
        }
        return this.f20149a;
    }

    public void onDestroy() {
        super.onDestroy();
        ReportObserver.a().b(this);
    }
}
