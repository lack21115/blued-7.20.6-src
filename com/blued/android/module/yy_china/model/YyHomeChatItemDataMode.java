package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YyHomeChatItemDataMode.class */
public final class YyHomeChatItemDataMode implements MultiItemEntity {
    private final YyHomeChatItemDataInfoMode data;
    private final int type;

    public YyHomeChatItemDataMode(int i, YyHomeChatItemDataInfoMode data) {
        Intrinsics.e(data, "data");
        this.type = i;
        this.data = data;
    }

    public static /* synthetic */ YyHomeChatItemDataMode copy$default(YyHomeChatItemDataMode yyHomeChatItemDataMode, int i, YyHomeChatItemDataInfoMode yyHomeChatItemDataInfoMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yyHomeChatItemDataMode.type;
        }
        if ((i2 & 2) != 0) {
            yyHomeChatItemDataInfoMode = yyHomeChatItemDataMode.data;
        }
        return yyHomeChatItemDataMode.copy(i, yyHomeChatItemDataInfoMode);
    }

    public final int component1() {
        return this.type;
    }

    public final YyHomeChatItemDataInfoMode component2() {
        return this.data;
    }

    public final YyHomeChatItemDataMode copy(int i, YyHomeChatItemDataInfoMode data) {
        Intrinsics.e(data, "data");
        return new YyHomeChatItemDataMode(i, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YyHomeChatItemDataMode) {
            YyHomeChatItemDataMode yyHomeChatItemDataMode = (YyHomeChatItemDataMode) obj;
            return this.type == yyHomeChatItemDataMode.type && Intrinsics.a(this.data, yyHomeChatItemDataMode.data);
        }
        return false;
    }

    public final YyHomeChatItemDataInfoMode getData() {
        return this.data;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.data.hashCode();
    }

    public String toString() {
        return "YyHomeChatItemDataMode(type=" + this.type + ", data=" + this.data + ')';
    }
}
