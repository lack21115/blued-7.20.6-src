package com.soft.blued.ui.setting.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/PermissionModel.class */
public final class PermissionModel {
    private String title = "";
    private String desc = "";

    public final String getDesc() {
        return this.desc;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setDesc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc = str;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }
}
