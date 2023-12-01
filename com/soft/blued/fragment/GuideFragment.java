package com.soft.blued.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.ui.BaseDialogFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.ProhibitedSlidingViewPager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/fragment/GuideFragment.class */
public class GuideFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private ProhibitedSlidingViewPager f29648a;
    private GuideAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f29649c;
    private boolean d = false;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/fragment/GuideFragment$GuideAdapter.class */
    public static class GuideAdapter extends PagerAdapter implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private List<View> f29651a = new ArrayList();
        private LayoutInflater b;

        /* renamed from: c  reason: collision with root package name */
        private ProhibitedSlidingViewPager f29652c;
        private Activity d;
        private boolean e;

        public GuideAdapter(Activity activity, ProhibitedSlidingViewPager prohibitedSlidingViewPager, int[] iArr, boolean z) {
            this.e = false;
            this.d = activity;
            this.f29652c = prohibitedSlidingViewPager;
            this.e = z;
            this.b = LayoutInflater.from(activity);
            if (z) {
                for (int i : iArr) {
                    this.f29651a.add(this.b.inflate(i, (ViewGroup) null));
                }
                return;
            }
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                int i4 = iArr[i3];
                View inflate = this.b.inflate(R.layout.layout_guide_item, (ViewGroup) null);
                ((ImageView) inflate.findViewById(2131364541)).setImageResource(i4);
                this.f29651a.add(inflate);
                i2 = i3 + 1;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f29651a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.f29651a.get(i);
            view.setTag(Integer.valueOf(i));
            view.setOnClickListener(this);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue != this.f29651a.size() - 1) {
                this.f29652c.setCurrentItem(intValue + 1, true);
                return;
            }
            this.d.setResult(-1);
            this.d.finish();
        }
    }

    private void a(View view) {
        ProhibitedSlidingViewPager prohibitedSlidingViewPager = (ProhibitedSlidingViewPager) view.findViewById(R.id.guide_vewpager);
        this.f29648a = prohibitedSlidingViewPager;
        prohibitedSlidingViewPager.setAllowedSwipeDirection(ProhibitedSlidingViewPager.SwipeDirection.right);
        this.f29648a.setLastPageToRightListener(new ProhibitedSlidingViewPager.ILastPageScrollToRightListener() { // from class: com.soft.blued.fragment.GuideFragment.1
            @Override // com.soft.blued.customview.ProhibitedSlidingViewPager.ILastPageScrollToRightListener
            public boolean a() {
                GuideFragment.this.getActivity().setResult(-1);
                GuideFragment.this.getActivity().finish();
                return true;
            }
        });
        GuideAdapter guideAdapter = new GuideAdapter(getActivity(), this.f29648a, this.f29649c, this.d);
        this.b = guideAdapter;
        this.f29648a.setAdapter(guideAdapter);
    }

    private void d() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            getActivity().finish();
            return;
        }
        int[] intArray = arguments.getIntArray("guide_ids");
        this.f29649c = intArray;
        if (intArray == null || intArray.length <= 0) {
            getActivity().finish();
        } else {
            this.d = arguments.getBoolean("guide_is_layout");
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_common_guide, (ViewGroup) null);
        d();
        a(inflate);
        return inflate;
    }
}
