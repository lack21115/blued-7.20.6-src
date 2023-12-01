package com.soft.blued.ui.setting.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/FeedBackModel.class */
public final class FeedBackModel {
    private int id;
    private boolean isSelect;
    private String type;

    public FeedBackModel(String str, boolean z) {
        Intrinsics.e(str, "name");
        this.type = "";
        this.type = str;
        this.isSelect = z;
    }

    public final int getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public final void setType(String str) {
        Intrinsics.e(str, "<set-?>");
        this.type = str;
    }
}
