package com.blued.android.module.yy_china.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.yy_china.fragment.YYConfessedRankItemFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYConfessedRankItemAdapter.class */
public final class YYConfessedRankItemAdapter extends BaseFragmentPagerAdapter {
    private final FragmentManager b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYConfessedRankItemAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.e(fm, "fm");
        this.b = fm;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: a */
    public String getPageTitle(int i) {
        return "";
    }

    public final void a(String isAll) {
        Intrinsics.e(isAll, "isAll");
        List<Fragment> arrayList = new ArrayList<>();
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                a(arrayList);
                return;
            }
            YYConfessedRankItemFragment yYConfessedRankItemFragment = new YYConfessedRankItemFragment();
            yYConfessedRankItemFragment.c(isAll);
            yYConfessedRankItemFragment.b(i2 == 1);
            arrayList.add(yYConfessedRankItemFragment);
            i = i2 + 1;
        }
    }
}
