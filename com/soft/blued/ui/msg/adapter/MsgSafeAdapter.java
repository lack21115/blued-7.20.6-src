package com.soft.blued.ui.msg.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MsgSafeAdapter.class */
public final class MsgSafeAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final List<View> f32176a;
    private final List<String> b;

    /* JADX WARN: Multi-variable type inference failed */
    public MsgSafeAdapter(List<? extends View> views, List<String> titles) {
        Intrinsics.e(views, "views");
        Intrinsics.e(titles, "titles");
        this.f32176a = views;
        this.b = titles;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int i, Object object) {
        Intrinsics.e(container, "container");
        Intrinsics.e(object, "object");
        container.removeView(this.f32176a.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f32176a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.b.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int i) {
        Intrinsics.e(container, "container");
        container.addView(this.f32176a.get(i));
        return this.f32176a.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.e(view, "view");
        Intrinsics.e(object, "object");
        return Intrinsics.a(view, object);
    }
}
