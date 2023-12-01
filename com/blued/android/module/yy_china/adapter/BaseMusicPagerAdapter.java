package com.blued.android.module.yy_china.adapter;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/BaseMusicPagerAdapter.class */
public abstract class BaseMusicPagerAdapter<T> extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<? extends T> f16114a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMusicPagerAdapter(FragmentManager fm, int i) {
        super(fm, i);
        Intrinsics.e(fm, "fm");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<T> a() {
        return (List<? extends T>) this.f16114a;
    }

    public final void a(List<? extends T> list) {
        Intrinsics.e(list, "list");
        this.f16114a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<? extends T> list = this.f16114a;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        List<? extends T> list2 = this.f16114a;
        Integer valueOf = list2 == null ? null : Integer.valueOf(list2.size());
        Intrinsics.a(valueOf);
        return valueOf.intValue();
    }
}
