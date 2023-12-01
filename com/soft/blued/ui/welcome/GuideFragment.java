package com.soft.blued.ui.welcome;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.R;
import com.soft.blued.utils.AppUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/GuideFragment.class */
public class GuideFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private View f34534a;
    private ViewPager b;

    /* renamed from: c  reason: collision with root package name */
    private NewfeatureGuideAdapter f34535c;

    public static boolean a(Context context) {
        return a(context, false);
    }

    public static boolean a(Context context, boolean z) {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        AppUtils.a(AppInfo.d());
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f34534a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_guide, viewGroup, false);
            this.f34534a = inflate;
            this.b = (ViewPager) inflate.findViewById(R.id.new_feature_gallery);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f34534a.getParent()).removeView(this.f34534a);
        }
        return this.f34534a;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        NewfeatureGuideAdapter newfeatureGuideAdapter = new NewfeatureGuideAdapter(getActivity(), this.b);
        this.f34535c = newfeatureGuideAdapter;
        this.b.setAdapter(newfeatureGuideAdapter);
    }
}
