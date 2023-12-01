package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.user.observer.ReportObserver;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportTipFragment.class */
public class ReportTipFragment extends BaseFragment implements View.OnClickListener, ReportObserver.IReportObserver {

    /* renamed from: a  reason: collision with root package name */
    private View f33954a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f33955c;
    private TextView d;
    private ImageView e;
    private ShapeTextView f;
    private ShapeTextView g;
    private String h;
    private String i;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportTipFragment$REPORT_TYPE.class */
    public interface REPORT_TYPE {
    }

    public static void a(Context context, int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("KEY_REPORT_TARGET_ID", str);
        bundle.putString("KEY_REPORT_TARGET_TEXT", str2);
        TerminalActivity.d(context, ReportTipFragment.class, bundle);
    }

    private void b() {
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt("type") : 0;
        if (i == 2) {
            this.f33955c.setText(R.string.report_user_feed_help);
            this.d.setText(R.string.report_user_feed_tip);
            this.e.setImageResource(R.drawable.report_tip_feed);
            this.f.setText(R.string.report_to_feed);
            this.g.setVisibility(8);
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportTipFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    BluedURIRouterAdapter.openUserInfoPage(ReportTipFragment.this.b, ReportTipFragment.this.h, ReportTipFragment.this.i, 0, 1, "", false, "");
                }
            });
        } else if (i == 3) {
            this.f33955c.setText(R.string.report_user_comment_help);
            this.d.setText(R.string.report_user_comment_tip);
            this.e.setImageResource(R.drawable.report_tip_comment);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
        } else {
            this.f33955c.setText(R.string.report_user_chat_help);
            this.d.setText(R.string.report_user_chat_tip);
            this.e.setImageResource(R.drawable.report_tip_chat);
            this.f.setText(R.string.report_to_chat);
            this.g.setVisibility(0);
            this.g.setText(R.string.report_to_report);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportTipFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ReportFragmentNew.b(ReportTipFragment.this.b, 1, ReportTipFragment.this.h, ReportTipFragment.this.i);
                }
            });
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportTipFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    HomeArgumentHelper.a(ReportTipFragment.this.b, "msg", (Bundle) null);
                }
            });
        }
    }

    public void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.f33954a.findViewById(2131370694);
        commonTopTitleNoTrans.setCenterText(this.b.getResources().getString(2131891497));
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setLeftClickListener(this);
        this.f33955c = (TextView) this.f33954a.findViewById(R.id.tv_report_help);
        this.d = (TextView) this.f33954a.findViewById(R.id.tv_report_tip);
        this.e = (ImageView) this.f33954a.findViewById(R.id.iv_report_tip);
        this.f = (ShapeTextView) this.f33954a.findViewById(R.id.tv_to_page);
        this.g = (ShapeTextView) this.f33954a.findViewById(R.id.tv_to_report);
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
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        if (this.f33954a == null) {
            this.f33954a = layoutInflater.inflate(R.layout.fragment_report_tip, viewGroup, false);
            if (getArguments() != null) {
                this.h = getArguments().getString("KEY_REPORT_TARGET_ID");
                this.i = getArguments().getString("KEY_REPORT_TARGET_TEXT");
            }
            a();
            b();
            ReportObserver.a().a(this);
        }
        return this.f33954a;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ReportObserver.a().b(this);
    }
}
