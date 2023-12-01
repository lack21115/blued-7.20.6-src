package com.blued.android.module.yy_china.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.yy_china.fragment.YYRelationShipRankItemFragment;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRelationShipRankPagerAdapter.class */
public final class YYRelationShipRankPagerAdapter extends BaseFragmentPagerAdapter {
    private final FragmentManager b;

    /* renamed from: c  reason: collision with root package name */
    private List<YYRelationShipRoomMode> f16217c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRelationShipRankPagerAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.e(fm, "fm");
        this.b = fm;
        this.f16217c = new ArrayList();
    }

    private final boolean c(List<YYRelationShipRoomMode> list) {
        if (list.size() != this.f16217c.size()) {
            this.f16217c = list;
            return true;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.f16217c = list;
                return false;
            } else if (!Intrinsics.a((Object) this.f16217c.get(i2).getId(), (Object) list.get(i2).getId())) {
                this.f16217c = list;
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: a */
    public String getPageTitle(int i) {
        return this.f16217c.get(i).getRelation_name();
    }

    public final void b(List<YYRelationShipRoomMode> tabs) {
        Intrinsics.e(tabs, "tabs");
        if (c(tabs)) {
            List<Fragment> arrayList = new ArrayList<>();
            for (YYRelationShipRoomMode yYRelationShipRoomMode : tabs) {
                YYRelationShipRankItemFragment yYRelationShipRankItemFragment = new YYRelationShipRankItemFragment();
                Bundle bundle = new Bundle();
                bundle.putString("relation_id", yYRelationShipRoomMode.getId());
                yYRelationShipRankItemFragment.a(yYRelationShipRoomMode);
                yYRelationShipRankItemFragment.setArguments(bundle);
                arrayList.add(yYRelationShipRankItemFragment);
            }
            a(arrayList);
        }
    }
}
