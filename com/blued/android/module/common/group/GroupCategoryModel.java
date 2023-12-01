package com.blued.android.module.common.group;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/group/GroupCategoryModel.class */
public final class GroupCategoryModel implements Serializable {
    private int id;
    private boolean isSelected;
    private String name = "";

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.a(getClass(), obj == null ? null : obj.getClass())) {
            if (obj != null) {
                return this.id == ((GroupCategoryModel) obj).id;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupCategoryModel");
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.id;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
