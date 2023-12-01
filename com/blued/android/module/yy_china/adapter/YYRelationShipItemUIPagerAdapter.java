package com.blued.android.module.yy_china.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.yy_china.fragment.RealtionRoomVIewFragment;
import com.blued.android.module.yy_china.model.YYRelationShipRoomLevelInfoMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRelationShipItemUIPagerAdapter.class */
public final class YYRelationShipItemUIPagerAdapter extends BaseFragmentPagerAdapter {
    private final FragmentManager b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRelationShipItemUIPagerAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.e(fm, "fm");
        this.b = fm;
    }

    /* renamed from: a */
    public String getPageTitle(int i) {
        return "";
    }

    public final void a(ArrayList<YYRelationShipRoomLevelInfoMode> tabs, int i) {
        Intrinsics.e(tabs, "tabs");
        List<Fragment> arrayList = new ArrayList<>();
        int size = tabs.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                a(arrayList);
                return;
            }
            RealtionRoomVIewFragment realtionRoomVIewFragment = new RealtionRoomVIewFragment();
            realtionRoomVIewFragment.a(i);
            realtionRoomVIewFragment.b(i3);
            realtionRoomVIewFragment.d().addAll(tabs);
            arrayList.add(realtionRoomVIewFragment);
            i2 = i3 + 1;
        }
    }
}
