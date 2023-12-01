package com.soft.blued.ui.user.fragment;

import android.content.Context;
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

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportUserFragment.class */
public class ReportUserFragment extends BaseFragment implements View.OnClickListener, ReportObserver.IReportObserver {

    /* renamed from: a  reason: collision with root package name */
    private View f33959a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f33960c;
    private View d;
    private View e;
    private View f;
    private String g;
    private String h;
    private boolean i = true;

    public static void a(Context context, String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY_REPORT_TARGET_ID", str);
        bundle.putString("KEY_REPORT_TARGET_TEXT", str2);
        bundle.putBoolean("KEY_REPORT_SHOW_BLOCK", z);
        TerminalActivity.d(context, ReportUserFragment.class, bundle);
    }

    public void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.f33959a.findViewById(2131370694);
        commonTopTitleNoTrans.setCenterText(this.b.getResources().getString(2131891497));
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setLeftClickListener(this);
        View findViewById = this.f33959a.findViewById(R.id.view_chat);
        this.f33960c = findViewById;
        ((TextView) findViewById.findViewById(2131372708)).setText(R.string.report_user_chat);
        this.f33960c.setOnClickListener(this);
        View findViewById2 = this.f33959a.findViewById(R.id.view_info);
        this.d = findViewById2;
        ((TextView) findViewById2.findViewById(2131372708)).setText(R.string.report_user_info);
        this.d.setOnClickListener(this);
        View findViewById3 = this.f33959a.findViewById(R.id.view_feed);
        this.e = findViewById3;
        ((TextView) findViewById3.findViewById(2131372708)).setText(R.string.report_user_feed);
        this.e.setOnClickListener(this);
        View findViewById4 = this.f33959a.findViewById(R.id.view_comment);
        this.f = findViewById4;
        ((TextView) findViewById4.findViewById(2131372708)).setText(R.string.report_user_comment);
        this.f.setOnClickListener(this);
    }

    @Override // com.soft.blued.ui.user.observer.ReportObserver.IReportObserver
    public void a(boolean z) {
        if (!z || getActivity() == null) {
            return;
        }
        getActivity().finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.view_chat /* 2131373132 */:
                ReportTipFragment.a(this.b, 1, this.g, this.h);
                return;
            case R.id.view_comment /* 2131373138 */:
                ReportTipFragment.a(this.b, 3, this.g, this.h);
                return;
            case R.id.view_feed /* 2131373165 */:
                ReportTipFragment.a(this.b, 2, this.g, this.h);
                return;
            case R.id.view_info /* 2131373180 */:
                if (this.i) {
                    ReportFragmentNew.b(this.b, 1, this.g, this.h);
                    return;
                } else {
                    ReportFragmentNew.a(this.b, 1, this.g, this.h);
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        if (this.f33959a == null) {
            this.f33959a = layoutInflater.inflate(R.layout.fragment_report_user, viewGroup, false);
            if (getArguments() != null) {
                this.g = getArguments().getString("KEY_REPORT_TARGET_ID");
                this.h = getArguments().getString("KEY_REPORT_TARGET_TEXT");
                this.i = getArguments().getBoolean("KEY_REPORT_SHOW_BLOCK", true);
            }
            a();
            ReportObserver.a().a(this);
        }
        return this.f33959a;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ReportObserver.a().b(this);
    }
}
