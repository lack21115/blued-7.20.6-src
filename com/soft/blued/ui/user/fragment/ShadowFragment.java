package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ShadowFragment.class */
public class ShadowFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f33966a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f33967c;
    private TextView d;
    private TextView e;
    private LinearLayout f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private LinearLayout j;
    private TextView k;
    private RelativeLayout l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private LinearLayout p;
    private LinearLayout q;
    private TextView r;
    private RelativeLayout s;
    private RelativeLayout t;

    private void a() {
        this.f33967c = (LinearLayout) this.b.findViewById(R.id.shadow_price_layout);
        this.d = (TextView) this.b.findViewById(R.id.shadow_price);
        this.e = (TextView) this.b.findViewById(R.id.shadow_price_unit);
        this.f = (LinearLayout) this.b.findViewById(R.id.shadow_renew_layout);
        this.g = (TextView) this.b.findViewById(R.id.shadow_renew);
        this.h = (TextView) this.b.findViewById(R.id.shadow_renew_date);
        this.i = (ImageView) this.b.findViewById(R.id.shadow_top_up_btn);
        this.j = (LinearLayout) this.b.findViewById(R.id.shadow_mine_layout);
        this.l = (RelativeLayout) this.b.findViewById(R.id.shadow_setting_layout);
        this.m = (ImageView) this.b.findViewById(R.id.shadow_mine_icon);
        this.n = (TextView) this.b.findViewById(R.id.shadow_address);
        this.o = (TextView) this.b.findViewById(R.id.shadow_setting);
        this.p = (LinearLayout) this.b.findViewById(R.id.shadow_open_layout);
        this.q = (LinearLayout) this.b.findViewById(R.id.shadow_what_layout);
        this.r = (TextView) this.b.findViewById(R.id.shadow_tips);
        this.k = (TextView) this.b.findViewById(R.id.shadow_close);
        this.s = (RelativeLayout) this.b.findViewById(R.id.shadow_privacy_clause);
        this.t = (RelativeLayout) this.b.findViewById(R.id.shadow_renew_agreement);
        this.i.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
    }

    private void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        commonTopTitleNoTrans.setCenterText(getString(R.string.shadow_title));
        commonTopTitleNoTrans.setLeftClickListener(this);
        commonTopTitleNoTrans.getRightTextView().setVisibility(8);
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
        this.f33966a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_shadow, viewGroup, false);
            b();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
