package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.soft.blued.ui.user.model.VirtualImageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageState.class */
public final class VirtualImageState implements UiState {
    private List<VirtualImageModel.CategoryModel> allCategoriesList;
    private List<VirtualImageModel.CategoryModel> allPackageCategoriesList;
    private List<VirtualImageModel.GuestImageGoodsModel> guestGoodsList;
    private int redDot;

    public VirtualImageState() {
        this(null, null, null, 0, 15, null);
    }

    public VirtualImageState(List<VirtualImageModel.CategoryModel> list, List<VirtualImageModel.CategoryModel> list2, List<VirtualImageModel.GuestImageGoodsModel> list3, int i) {
        this.allCategoriesList = list;
        this.allPackageCategoriesList = list2;
        this.guestGoodsList = list3;
        this.redDot = i;
    }

    public /* synthetic */ VirtualImageState(List list, List list2, List list3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : list2, (i2 & 4) != 0 ? null : list3, (i2 & 8) != 0 ? 0 : i);
    }

    public static /* synthetic */ VirtualImageState copy$default(VirtualImageState virtualImageState, List list, List list2, List list3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = virtualImageState.allCategoriesList;
        }
        if ((i2 & 2) != 0) {
            list2 = virtualImageState.allPackageCategoriesList;
        }
        if ((i2 & 4) != 0) {
            list3 = virtualImageState.guestGoodsList;
        }
        if ((i2 & 8) != 0) {
            i = virtualImageState.redDot;
        }
        return virtualImageState.copy(list, list2, list3, i);
    }

    public final List<VirtualImageModel.CategoryModel> component1() {
        return this.allCategoriesList;
    }

    public final List<VirtualImageModel.CategoryModel> component2() {
        return this.allPackageCategoriesList;
    }

    public final List<VirtualImageModel.GuestImageGoodsModel> component3() {
        return this.guestGoodsList;
    }

    public final int component4() {
        return this.redDot;
    }

    public final VirtualImageState copy(List<VirtualImageModel.CategoryModel> list, List<VirtualImageModel.CategoryModel> list2, List<VirtualImageModel.GuestImageGoodsModel> list3, int i) {
        return new VirtualImageState(list, list2, list3, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VirtualImageState) {
            VirtualImageState virtualImageState = (VirtualImageState) obj;
            return Intrinsics.a(this.allCategoriesList, virtualImageState.allCategoriesList) && Intrinsics.a(this.allPackageCategoriesList, virtualImageState.allPackageCategoriesList) && Intrinsics.a(this.guestGoodsList, virtualImageState.guestGoodsList) && this.redDot == virtualImageState.redDot;
        }
        return false;
    }

    public final List<VirtualImageModel.CategoryModel> getAllCategoriesList() {
        return this.allCategoriesList;
    }

    public final List<VirtualImageModel.CategoryModel> getAllPackageCategoriesList() {
        return this.allPackageCategoriesList;
    }

    public final List<VirtualImageModel.GuestImageGoodsModel> getGuestGoodsList() {
        return this.guestGoodsList;
    }

    public final int getRedDot() {
        return this.redDot;
    }

    public int hashCode() {
        List<VirtualImageModel.CategoryModel> list = this.allCategoriesList;
        int i = 0;
        int hashCode = list == null ? 0 : list.hashCode();
        List<VirtualImageModel.CategoryModel> list2 = this.allPackageCategoriesList;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        List<VirtualImageModel.GuestImageGoodsModel> list3 = this.guestGoodsList;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return (((((hashCode * 31) + hashCode2) * 31) + i) * 31) + this.redDot;
    }

    public final void setAllCategoriesList(List<VirtualImageModel.CategoryModel> list) {
        this.allCategoriesList = list;
    }

    public final void setAllPackageCategoriesList(List<VirtualImageModel.CategoryModel> list) {
        this.allPackageCategoriesList = list;
    }

    public final void setGuestGoodsList(List<VirtualImageModel.GuestImageGoodsModel> list) {
        this.guestGoodsList = list;
    }

    public final void setRedDot(int i) {
        this.redDot = i;
    }

    public String toString() {
        return "VirtualImageState(allCategoriesList=" + this.allCategoriesList + ", allPackageCategoriesList=" + this.allPackageCategoriesList + ", guestGoodsList=" + this.guestGoodsList + ", redDot=" + this.redDot + ')';
    }
}
