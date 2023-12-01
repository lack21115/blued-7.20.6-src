package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomTask.class */
public final class YYRelationShipRoomTask implements MultiItemEntity {
    private String button_name;
    private String button_name_finished;
    private String icon;
    private int is_post;
    private YYRelationShipRoomTaskItemMode itemExtra;
    private int itemTypes;
    private int max_number;
    private String remark;
    private String task_id;
    private String title;

    public YYRelationShipRoomTask(int i, String task_id, String title, int i2, String icon, String remark, YYRelationShipRoomTaskItemMode yYRelationShipRoomTaskItemMode, int i3, String button_name, String button_name_finished) {
        Intrinsics.e(task_id, "task_id");
        Intrinsics.e(title, "title");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(remark, "remark");
        Intrinsics.e(button_name, "button_name");
        Intrinsics.e(button_name_finished, "button_name_finished");
        this.itemTypes = i;
        this.task_id = task_id;
        this.title = title;
        this.max_number = i2;
        this.icon = icon;
        this.remark = remark;
        this.itemExtra = yYRelationShipRoomTaskItemMode;
        this.is_post = i3;
        this.button_name = button_name;
        this.button_name_finished = button_name_finished;
    }

    public /* synthetic */ YYRelationShipRoomTask(int i, String str, String str2, int i2, String str3, String str4, YYRelationShipRoomTaskItemMode yYRelationShipRoomTaskItemMode, int i3, String str5, String str6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, str, str2, i2, str3, str4, (i4 & 64) != 0 ? null : yYRelationShipRoomTaskItemMode, i3, str5, str6);
    }

    public static /* synthetic */ YYRelationShipRoomTask copy$default(YYRelationShipRoomTask yYRelationShipRoomTask, int i, String str, String str2, int i2, String str3, String str4, YYRelationShipRoomTaskItemMode yYRelationShipRoomTaskItemMode, int i3, String str5, String str6, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = yYRelationShipRoomTask.itemTypes;
        }
        if ((i4 & 2) != 0) {
            str = yYRelationShipRoomTask.task_id;
        }
        if ((i4 & 4) != 0) {
            str2 = yYRelationShipRoomTask.title;
        }
        if ((i4 & 8) != 0) {
            i2 = yYRelationShipRoomTask.max_number;
        }
        if ((i4 & 16) != 0) {
            str3 = yYRelationShipRoomTask.icon;
        }
        if ((i4 & 32) != 0) {
            str4 = yYRelationShipRoomTask.remark;
        }
        if ((i4 & 64) != 0) {
            yYRelationShipRoomTaskItemMode = yYRelationShipRoomTask.itemExtra;
        }
        if ((i4 & 128) != 0) {
            i3 = yYRelationShipRoomTask.is_post;
        }
        if ((i4 & 256) != 0) {
            str5 = yYRelationShipRoomTask.button_name;
        }
        if ((i4 & 512) != 0) {
            str6 = yYRelationShipRoomTask.button_name_finished;
        }
        return yYRelationShipRoomTask.copy(i, str, str2, i2, str3, str4, yYRelationShipRoomTaskItemMode, i3, str5, str6);
    }

    public final int component1() {
        return this.itemTypes;
    }

    public final String component10() {
        return this.button_name_finished;
    }

    public final String component2() {
        return this.task_id;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.max_number;
    }

    public final String component5() {
        return this.icon;
    }

    public final String component6() {
        return this.remark;
    }

    public final YYRelationShipRoomTaskItemMode component7() {
        return this.itemExtra;
    }

    public final int component8() {
        return this.is_post;
    }

    public final String component9() {
        return this.button_name;
    }

    public final YYRelationShipRoomTask copy(int i, String task_id, String title, int i2, String icon, String remark, YYRelationShipRoomTaskItemMode yYRelationShipRoomTaskItemMode, int i3, String button_name, String button_name_finished) {
        Intrinsics.e(task_id, "task_id");
        Intrinsics.e(title, "title");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(remark, "remark");
        Intrinsics.e(button_name, "button_name");
        Intrinsics.e(button_name_finished, "button_name_finished");
        return new YYRelationShipRoomTask(i, task_id, title, i2, icon, remark, yYRelationShipRoomTaskItemMode, i3, button_name, button_name_finished);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomTask) {
            YYRelationShipRoomTask yYRelationShipRoomTask = (YYRelationShipRoomTask) obj;
            return this.itemTypes == yYRelationShipRoomTask.itemTypes && Intrinsics.a((Object) this.task_id, (Object) yYRelationShipRoomTask.task_id) && Intrinsics.a((Object) this.title, (Object) yYRelationShipRoomTask.title) && this.max_number == yYRelationShipRoomTask.max_number && Intrinsics.a((Object) this.icon, (Object) yYRelationShipRoomTask.icon) && Intrinsics.a((Object) this.remark, (Object) yYRelationShipRoomTask.remark) && Intrinsics.a(this.itemExtra, yYRelationShipRoomTask.itemExtra) && this.is_post == yYRelationShipRoomTask.is_post && Intrinsics.a((Object) this.button_name, (Object) yYRelationShipRoomTask.button_name) && Intrinsics.a((Object) this.button_name_finished, (Object) yYRelationShipRoomTask.button_name_finished);
        }
        return false;
    }

    public final String getButton_name() {
        return this.button_name;
    }

    public final String getButton_name_finished() {
        return this.button_name_finished;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final YYRelationShipRoomTaskItemMode getItemExtra() {
        return this.itemExtra;
    }

    public int getItemType() {
        return this.itemTypes;
    }

    public final int getItemTypes() {
        return this.itemTypes;
    }

    public final int getMax_number() {
        return this.max_number;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getTask_id() {
        return this.task_id;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i = this.itemTypes;
        int hashCode = this.task_id.hashCode();
        int hashCode2 = this.title.hashCode();
        int i2 = this.max_number;
        int hashCode3 = this.icon.hashCode();
        int hashCode4 = this.remark.hashCode();
        YYRelationShipRoomTaskItemMode yYRelationShipRoomTaskItemMode = this.itemExtra;
        return (((((((((((((((((i * 31) + hashCode) * 31) + hashCode2) * 31) + i2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (yYRelationShipRoomTaskItemMode == null ? 0 : yYRelationShipRoomTaskItemMode.hashCode())) * 31) + this.is_post) * 31) + this.button_name.hashCode()) * 31) + this.button_name_finished.hashCode();
    }

    public final int is_post() {
        return this.is_post;
    }

    public final void setButton_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.button_name = str;
    }

    public final void setButton_name_finished(String str) {
        Intrinsics.e(str, "<set-?>");
        this.button_name_finished = str;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setItemExtra(YYRelationShipRoomTaskItemMode yYRelationShipRoomTaskItemMode) {
        this.itemExtra = yYRelationShipRoomTaskItemMode;
    }

    public final void setItemTypes(int i) {
        this.itemTypes = i;
    }

    public final void setMax_number(int i) {
        this.max_number = i;
    }

    public final void setRemark(String str) {
        Intrinsics.e(str, "<set-?>");
        this.remark = str;
    }

    public final void setTask_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.task_id = str;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }

    public final void set_post(int i) {
        this.is_post = i;
    }

    public String toString() {
        return "YYRelationShipRoomTask(itemTypes=" + this.itemTypes + ", task_id=" + this.task_id + ", title=" + this.title + ", max_number=" + this.max_number + ", icon=" + this.icon + ", remark=" + this.remark + ", itemExtra=" + this.itemExtra + ", is_post=" + this.is_post + ", button_name=" + this.button_name + ", button_name_finished=" + this.button_name_finished + ')';
    }
}
