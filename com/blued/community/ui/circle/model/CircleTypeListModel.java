package com.blued.community.ui.circle.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/CircleTypeListModel.class */
public final class CircleTypeListModel {
    private boolean success;
    private List<? extends MyCircleModel> circleList = new ArrayList();
    private int page = 1;
    private boolean hasMore = true;
    private int[] rvLocation = {0, 0};

    public final List<MyCircleModel> getCircleList() {
        return this.circleList;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final int getPage() {
        return this.page;
    }

    public final int[] getRvLocation() {
        return this.rvLocation;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setCircleList(List<? extends MyCircleModel> list) {
        Intrinsics.e(list, "<set-?>");
        this.circleList = list;
    }

    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    public final void setRvLocation(int[] iArr) {
        Intrinsics.e(iArr, "<set-?>");
        this.rvLocation = iArr;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }
}
