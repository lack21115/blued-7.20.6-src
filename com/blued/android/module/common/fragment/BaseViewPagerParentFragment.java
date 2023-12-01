package com.blued.android.module.common.fragment;

import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.module.common.R;
import com.blued.android.module.common.adapter.BaseViewPagerFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/fragment/BaseViewPagerParentFragment.class */
public abstract class BaseViewPagerParentFragment extends SimpleFragment {
    public ViewPager h;
    protected BaseViewPagerFragmentPagerAdapter i;
    public List<BaseFragment> j = new ArrayList();
    protected List<String> k = new ArrayList();

    protected abstract void a();

    protected abstract BaseFragment b(int i);

    public void e() {
        f();
        this.i.a(this.j);
        this.i.b(this.k);
        this.i.notifyDataSetChanged();
        if (this.h.getCurrentItem() < this.j.size() || this.j.size() <= 0) {
            return;
        }
        this.h.setCurrentItem(this.j.size() - 1, false);
    }

    protected void f() {
        this.k.clear();
        if (this.k.size() >= this.j.size()) {
            return;
        }
        int size = this.k.size();
        while (true) {
            int i = size;
            if (i >= this.j.size()) {
                return;
            }
            this.k.add(String.valueOf(i));
            size = i + 1;
        }
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.h = (ViewPager) this.rootView.findViewById(R.id.base_view_pager_id);
        BaseViewPagerFragmentPagerAdapter baseViewPagerFragmentPagerAdapter = new BaseViewPagerFragmentPagerAdapter(getChildFragmentManager()) { // from class: com.blued.android.module.common.fragment.BaseViewPagerParentFragment.1
            @Override // com.blued.android.module.common.adapter.BaseViewPagerFragmentPagerAdapter
            public BaseFragment b(int i) {
                return BaseViewPagerParentFragment.this.b(i);
            }
        };
        this.i = baseViewPagerFragmentPagerAdapter;
        baseViewPagerFragmentPagerAdapter.a(R.id.base_view_pager_id);
        this.h.setAdapter(this.i);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitViewFinished() {
        super.onInitViewFinished();
        a();
        e();
    }
}
