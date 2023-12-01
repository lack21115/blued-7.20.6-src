package com.blued.login.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.anythink.expressad.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/view/ViewPagerAdapter.class */
public final class ViewPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final List<View> f6998a;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewPagerAdapter(List<? extends View> list) {
        Intrinsics.e(list, "viewList");
        this.f6998a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.e(viewGroup, "container");
        Intrinsics.e(obj, "object");
        viewGroup.removeView(this.f6998a.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f6998a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Intrinsics.e(viewGroup, "container");
        viewGroup.addView(this.f6998a.get(i));
        return this.f6998a.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.e(view, a.B);
        Intrinsics.e(obj, "object");
        return view == obj;
    }
}
