package com.soft.blued.ui.msg.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.anythink.expressad.a;
import com.cdo.oaps.ad.OapsKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MsgSafeAdapter.class */
public final class MsgSafeAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final List<View> f18486a;
    private final List<String> b;

    /* JADX WARN: Multi-variable type inference failed */
    public MsgSafeAdapter(List<? extends View> list, List<String> list2) {
        Intrinsics.e(list, OapsKey.KEY_VIEWS);
        Intrinsics.e(list2, "titles");
        this.f18486a = list;
        this.b = list2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.e(viewGroup, "container");
        Intrinsics.e(obj, "object");
        viewGroup.removeView(this.f18486a.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f18486a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.b.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Intrinsics.e(viewGroup, "container");
        viewGroup.addView(this.f18486a.get(i));
        return this.f18486a.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.e(view, a.B);
        Intrinsics.e(obj, "object");
        return Intrinsics.a(view, obj);
    }
}
