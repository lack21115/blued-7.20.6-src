package com.blued.android.module.yy_china.adapter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserCardInfoMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRelationShipItemPagerAdapter.class */
public final class YYRelationShipItemPagerAdapter extends BaseFragmentPagerAdapter {
    private final FragmentManager b;

    /* renamed from: c  reason: collision with root package name */
    private List<YYRelationShipRoomUserCardInfoMode> f16214c;
    private YYRelationShipRoomMode d;
    private View.OnClickListener e;
    private View.OnClickListener f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRelationShipItemPagerAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.e(fm, "fm");
        this.b = fm;
        this.f16214c = new ArrayList();
    }

    private final boolean c(List<YYRelationShipRoomUserCardInfoMode> list) {
        if (list.size() != this.f16214c.size()) {
            this.f16214c = list;
            return true;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.f16214c = list;
                return false;
            }
            YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = this.f16214c.get(i2);
            String str = null;
            String id = yYRelationShipRoomUserCardInfoMode == null ? null : yYRelationShipRoomUserCardInfoMode.getId();
            YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode2 = list.get(i2);
            if (yYRelationShipRoomUserCardInfoMode2 != null) {
                str = yYRelationShipRoomUserCardInfoMode2.getId();
            }
            if (!StringUtils.a(id, str)) {
                this.f16214c = list;
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: a */
    public String getPageTitle(int i) {
        String id;
        YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = this.f16214c.get(i);
        return (yYRelationShipRoomUserCardInfoMode == null || (id = yYRelationShipRoomUserCardInfoMode.getId()) == null) ? "" : id;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public final void a(YYRelationShipRoomMode yYRelationShipRoomMode) {
        this.d = yYRelationShipRoomMode;
    }

    public final YYRelationShipRoomMode b() {
        return this.d;
    }

    public final void b(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public final void b(List<YYRelationShipRoomUserCardInfoMode> tabs) {
        Intrinsics.e(tabs, "tabs");
        if (c(tabs)) {
            List<Fragment> arrayList = new ArrayList<>();
            for (YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode : tabs) {
                YyRelationShipRoomItemFragment yyRelationShipRoomItemFragment = new YyRelationShipRoomItemFragment();
                yyRelationShipRoomItemFragment.a(yYRelationShipRoomUserCardInfoMode);
                yyRelationShipRoomItemFragment.a(b());
                yyRelationShipRoomItemFragment.a(tabs.size());
                yyRelationShipRoomItemFragment.a(c());
                yyRelationShipRoomItemFragment.b(d());
                arrayList.add(yyRelationShipRoomItemFragment);
            }
            a(arrayList);
        }
    }

    public final View.OnClickListener c() {
        return this.e;
    }

    public final View.OnClickListener d() {
        return this.f;
    }
}
