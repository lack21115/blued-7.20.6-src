package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.VipPrivilegeModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemVipPrivilege.class */
public final class FitemVipPrivilege extends FreedomItem {
    private VipPrivilegeModel b;

    public FitemVipPrivilege(VipPrivilegeModel mode) {
        Intrinsics.e(mode, "mode");
        this.b = mode;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_vip_privilege;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        f();
    }

    public final void a(VipPrivilegeModel newMode) {
        Intrinsics.e(newMode, "newMode");
        this.b = newMode;
    }

    public final void a(boolean z) {
        View a2;
        BaseViewHolder baseViewHolder = this.f10935a;
        if (baseViewHolder == null || (a2 = baseViewHolder.a(R.id.iv_icon_light)) == null) {
            return;
        }
        a2.animate().alpha(z ? 1.0f : 0.0f).setDuration(200L).start();
    }

    public final VipPrivilegeModel e() {
        return this.b;
    }

    public final void f() {
        Integer num;
        this.f10935a.a(R.id.iv_icon, this.b.getIcon()).a(R.id.iv_icon_light, this.b.getIcon_select()).a(R.id.tv_title, (CharSequence) this.b.getName());
        FreedomAdapter freedomAdapter = this.f10935a.f10931a;
        if (freedomAdapter == null || (num = (Integer) freedomAdapter.a("lightItemPosition", (String) (-1))) == null) {
            return;
        }
        this.f10935a.a(R.id.iv_icon_light, num.intValue() == this.f10935a.getLayoutPosition() ? 1.0f : 0.0f);
    }

    public final Integer g() {
        return Integer.valueOf(this.b.getId() - 1);
    }

    public final VipPrivilegeModel h() {
        return this.b;
    }

    public final int i() {
        return this.f10935a.itemView.getLeft();
    }
}
