package com.blued.android.module.yy_china.adapter;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/BaseMusicPagerAdapter.class */
public abstract class BaseMusicPagerAdapter<T> extends FragmentPagerAdapter {
    private List<? extends T> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMusicPagerAdapter(FragmentManager fm, int i) {
        super(fm, i);
        Intrinsics.e(fm, "fm");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<T> a() {
        return (List<? extends T>) this.a;
    }

    public final void a(List<? extends T> list) {
        Intrinsics.e(list, "list");
        this.a = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        List<? extends T> list = this.a;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        List<? extends T> list2 = this.a;
        Integer valueOf = list2 == null ? null : Integer.valueOf(list2.size());
        Intrinsics.a(valueOf);
        return valueOf.intValue();
    }
}
