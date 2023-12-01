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
    private View f30325a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30326c;
    private TextView d;
    private HomeGuideFragment.GuideBean e;

    private void a() {
        this.b = (ImageView) this.f30325a.findViewById(R.id.iv_guide);
        this.f30326c = (TextView) this.f30325a.findViewById(2131372754);
        this.d = (TextView) this.f30325a.findViewById(2131371262);
        HomeGuideFragment.GuideBean guideBean = this.e;
        if (guideBean != null) {
            this.b.setImageResource(guideBean.f30345a);
            this.f30326c.setText(this.e.b);
            this.d.setText(this.e.f30346c);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.e = (HomeGuideFragment.GuideBean) getArguments().getSerializable("data");
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f30325a = layoutInflater.inflate(R.layout.pager_item_home_guide, (ViewGroup) null);
        a();
        return this.f30325a;
    }
}
