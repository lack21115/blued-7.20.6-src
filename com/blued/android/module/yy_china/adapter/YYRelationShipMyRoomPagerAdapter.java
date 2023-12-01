package com.blued.android.module.yy_china.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.yy_china.fragment.YYRelationShipMyRoomItemFragment;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRelationShipMyRoomPagerAdapter.class */
public final class YYRelationShipMyRoomPagerAdapter extends BaseFragmentPagerAdapter {
    private final FragmentManager b;

    /* renamed from: c  reason: collision with root package name */
    private List<YYRelationShipRoomMode> f16215c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRelationShipMyRoomPagerAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.e(fm, "fm");
        this.b = fm;
        this.f16215c = new ArrayList();
    }

    private final boolean c(List<YYRelationShipRoomMode> list) {
        if (list.size() != this.f16215c.size()) {
            this.f16215c = list;
            return true;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.f16215c = list;
                return false;
            } else if (!Intrinsics.a((Object) this.f16215c.get(i2).getId(), (Object) list.get(i2).getId())) {
                this.f16215c = list;
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: a */
    public String getPageTitle(int i) {
        return this.f16215c.get(i).getRelation_name();
    }

    public final void b(List<YYRelationShipRoomMode> tabs) {
        Intrinsics.e(tabs, "tabs");
        if (c(tabs)) {
            List<Fragment> arrayList = new ArrayList<>();
            for (YYRelationShipRoomMode yYRelationShipRoomMode : tabs) {
                YYRelationShipMyRoomItemFragment yYRelationShipMyRoomItemFragment = new YYRelationShipMyRoomItemFragment();
                Bundle bundle = new Bundle();
                yYRelationShipMyRoomItemFragment.a(yYRelationShipRoomMode);
                bundle.putString("relation_id", yYRelationShipRoomMode.getId());
                yYRelationShipMyRoomItemFragment.setArguments(bundle);
                arrayList.add(yYRelationShipMyRoomItemFragment);
            }
            a(arrayList);
        }
    }
}
