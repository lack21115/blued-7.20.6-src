package com.blued.android.module.yy_china.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.yy_china.fragment.YYConfessedRankFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYConfessedRankAdapter.class */
public final class YYConfessedRankAdapter extends BaseFragmentPagerAdapter {
    private final FragmentManager b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYConfessedRankAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.e(fm, "fm");
        this.b = fm;
    }

    public final void a(int i) {
        List<Fragment> arrayList = new ArrayList<>();
        int i2 = 2;
        while (true) {
            int i3 = i2;
            int i4 = i3 - 1;
            YYConfessedRankFragment yYConfessedRankFragment = new YYConfessedRankFragment();
            yYConfessedRankFragment.c(String.valueOf(i3));
            arrayList.add(yYConfessedRankFragment);
            if (1 > i4) {
                a(arrayList);
                return;
            }
            i2 = i4;
        }
    }

    /* renamed from: b */
    public String getPageTitle(int i) {
        return "";
    }
}
