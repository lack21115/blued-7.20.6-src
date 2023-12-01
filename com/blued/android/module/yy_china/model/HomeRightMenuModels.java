package com.blued.android.module.yy_china.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/HomeRightMenuModels.class */
public final class HomeRightMenuModels {
    private final List<HomeRightMenuModel> datas;

    public HomeRightMenuModels(List<HomeRightMenuModel> datas) {
        Intrinsics.e(datas, "datas");
        this.datas = datas;
    }

    public static /* synthetic */ HomeRightMenuModels copy$default(HomeRightMenuModels homeRightMenuModels, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = homeRightMenuModels.datas;
        }
        return homeRightMenuModels.copy(list);
    }

    public final List<HomeRightMenuModel> component1() {
        return this.datas;
    }

    public final HomeRightMenuModels copy(List<HomeRightMenuModel> datas) {
        Intrinsics.e(datas, "datas");
        return new HomeRightMenuModels(datas);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HomeRightMenuModels) && Intrinsics.a(this.datas, ((HomeRightMenuModels) obj).datas);
    }

    public final List<HomeRightMenuModel> getDatas() {
        return this.datas;
    }

    public int hashCode() {
        return this.datas.hashCode();
    }

    public String toString() {
        return "HomeRightMenuModels(datas=" + this.datas + ')';
    }
}
