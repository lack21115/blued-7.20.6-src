package com.blued.login.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/view/ViewPagerAdapter.class */
public final class ViewPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final List<View> f20604a;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewPagerAdapter(List<? extends View> viewList) {
        Intrinsics.e(viewList, "viewList");
        this.f20604a = viewList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int i, Object object) {
        Intrinsics.e(container, "container");
        Intrinsics.e(object, "object");
        container.removeView(this.f20604a.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f20604a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int i) {
        Intrinsics.e(container, "container");
        container.addView(this.f20604a.get(i));
        return this.f20604a.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.e(view, "view");
        Intrinsics.e(object, "object");
        return view == object;
    }
}
