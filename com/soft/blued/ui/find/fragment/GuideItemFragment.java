package com.soft.blued.ui.find.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.R;
import com.soft.blued.ui.find.fragment.HomeGuideFragment;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/GuideItemFragment.class */
public class GuideItemFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private View f16635a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16636c;
    private TextView d;
    private HomeGuideFragment.GuideBean e;

    private void a() {
        this.b = (ImageView) this.f16635a.findViewById(R.id.iv_guide);
        this.f16636c = (TextView) this.f16635a.findViewById(2131372754);
        this.d = (TextView) this.f16635a.findViewById(R.id.tv_desc);
        HomeGuideFragment.GuideBean guideBean = this.e;
        if (guideBean != null) {
            this.b.setImageResource(guideBean.f16655a);
            this.f16636c.setText(this.e.b);
            this.d.setText(this.e.f16656c);
        }
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public boolean onBackPressed() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.e = (HomeGuideFragment.GuideBean) getArguments().getSerializable("data");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16635a = layoutInflater.inflate(R.layout.pager_item_home_guide, (ViewGroup) null);
        a();
        return this.f16635a;
    }
}
