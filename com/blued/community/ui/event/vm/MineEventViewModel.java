package com.blued.community.ui.event.vm;

import android.os.Bundle;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.community.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/vm/MineEventViewModel.class */
public final class MineEventViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f19597a = new ArrayList();

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    public final List<String> d() {
        List<String> list = this.f19597a;
        if (list == null || list.isEmpty()) {
            List<String> list2 = this.f19597a;
            String a2 = AppUtils.a(R.string.event_mine_sub_tab);
            Intrinsics.c(a2, "getString(R.string.event_mine_sub_tab)");
            list2.add(a2);
            List<String> list3 = this.f19597a;
            String a3 = AppUtils.a(R.string.event_mine_join_tab);
            Intrinsics.c(a3, "getString(R.string.event_mine_join_tab)");
            list3.add(a3);
            List<String> list4 = this.f19597a;
            String a4 = AppUtils.a(R.string.event_mint_post_tab);
            Intrinsics.c(a4, "getString(R.string.event_mint_post_tab)");
            list4.add(a4);
        }
        return this.f19597a;
    }
}
