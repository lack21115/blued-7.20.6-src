package com.soft.blued.ui.login_register;

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
import com.soft.blued.ui.setting.fragment.VerifyOriginalAccountDetailFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/LinkMobileSuccessFragment.class */
public class LinkMobileSuccessFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f31397a = LinkMobileSuccessFragment.class.getSimpleName();
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Context f31398c;
    private CommonTopTitleNoTrans d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private String i;
    private String j;
    private String k;
    private int l;

    private void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        this.d = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.d.f();
        this.d.setTitleBackgroundDrawable(2131101191);
        this.d.setLeftClickListener(this);
        this.d.setCenterText("");
        if (this.l == 1) {
            this.g.setText(this.f31398c.getResources().getString(2131886184));
        } else {
            this.g.setText(this.f31398c.getResources().getString(2131892292));
        }
    }

    private void b() {
        this.g = (TextView) this.b.findViewById(R.id.tv_page_title);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_change_phone);
        this.h = textView;
        textView.setOnClickListener(this);
        this.e = (TextView) this.b.findViewById(R.id.tv_binding_description);
        this.f = (TextView) this.b.findViewById(R.id.tv_binding_type);
    }

    private void c() {
        if (getArguments() != null) {
            int i = getArguments().getInt(LoginRegisterTools.f31399a);
            this.l = i;
            if (i == 1) {
                String string = getArguments().getString(LoginRegisterTools.e);
                this.i = string;
                this.i = LoginRegisterTools.e(string);
                this.j = getArguments().getString(LoginRegisterTools.g);
                TextView textView = this.f;
                textView.setText(getResources().getString(2131886705) + this.i);
            } else if (i == 0) {
                this.k = getArguments().getString(LoginRegisterTools.f);
                this.e.setText(2131886080);
                TextView textView2 = this.f;
                textView2.setText(getResources().getString(2131886081) + this.k);
                this.h.setText(2131886917);
            }
        }
    }

    private void d() {
        Bundle bundle = new Bundle();
        bundle.putString(LoginRegisterTools.k, LoginRegisterTools.l);
        bundle.putString(LoginRegisterTools.e, this.i);
        bundle.putString(LoginRegisterTools.g, this.j);
        TerminalActivity.d(getActivity(), LinkMobileFragment.class, bundle);
        getActivity().finish();
    }

    private void e() {
        Bundle bundle = new Bundle();
        bundle.putString("binding_type", "change");
        TerminalActivity.d(this.f31398c, VerifyOriginalAccountDetailFragment.class, bundle);
        getActivity().finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131371077) {
        } else {
            int i = this.l;
            if (i == 1) {
                d();
            } else if (i == 0) {
                e();
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f31398c = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_linkmobile_success, viewGroup, false);
            b();
            c();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
