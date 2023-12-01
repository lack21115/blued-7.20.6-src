package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomMode.class */
public final class YYRelationShipRoomMode {
    private final boolean checked;
    private final String id;
    private final ArrayList<YYRelationShipRoomLevelInfoMode> level_info;
    private final String relation_name;
    private final YYRelationShipRoomUiInfo resource_options;
    private final YYRelationShipRoomTaskUiInfo resource_options_task;

    public YYRelationShipRoomMode(String id, String relation_name, boolean z, YYRelationShipRoomUiInfo resource_options, YYRelationShipRoomTaskUiInfo resource_options_task, ArrayList<YYRelationShipRoomLevelInfoMode> level_info) {
        Intrinsics.e(id, "id");
        Intrinsics.e(relation_name, "relation_name");
        Intrinsics.e(resource_options, "resource_options");
        Intrinsics.e(resource_options_task, "resource_options_task");
        Intrinsics.e(level_info, "level_info");
        this.id = id;
        this.relation_name = relation_name;
        this.checked = z;
        this.resource_options = resource_options;
        this.resource_options_task = resource_options_task;
        this.level_info = level_info;
    }

    public static /* synthetic */ YYRelationShipRoomMode copy$default(YYRelationShipRoomMode yYRelationShipRoomMode, String str, String str2, boolean z, YYRelationShipRoomUiInfo yYRelationShipRoomUiInfo, YYRelationShipRoomTaskUiInfo yYRelationShipRoomTaskUiInfo, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRelationShipRoomMode.id;
        }
        if ((i & 2) != 0) {
            str2 = yYRelationShipRoomMode.relation_name;
        }
        if ((i & 4) != 0) {
            z = yYRelationShipRoomMode.checked;
        }
        if ((i & 8) != 0) {
            yYRelationShipRoomUiInfo = yYRelationShipRoomMode.resource_options;
        }
        if ((i & 16) != 0) {
            yYRelationShipRoomTaskUiInfo = yYRelationShipRoomMode.resource_options_task;
        }
        if ((i & 32) != 0) {
            arrayList = yYRelationShipRoomMode.level_info;
        }
        return yYRelationShipRoomMode.copy(str, str2, z, yYRelationShipRoomUiInfo, yYRelationShipRoomTaskUiInfo, arrayList);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.relation_name;
    }

    public final boolean component3() {
        return this.checked;
    }

    public final YYRelationShipRoomUiInfo component4() {
        return this.resource_options;
    }

    public final YYRelationShipRoomTaskUiInfo component5() {
        return this.resource_options_task;
    }

    public final ArrayList<YYRelationShipRoomLevelInfoMode> component6() {
        return this.level_info;
    }

    public final YYRelationShipRoomMode copy(String id, String relation_name, boolean z, YYRelationShipRoomUiInfo resource_options, YYRelationShipRoomTaskUiInfo resource_options_task, ArrayList<YYRelationShipRoomLevelInfoMode> level_info) {
        Intrinsics.e(id, "id");
        Intrinsics.e(relation_name, "relation_name");
        Intrinsics.e(resource_options, "resource_options");
        Intrinsics.e(resource_options_task, "resource_options_task");
        Intrinsics.e(level_info, "level_info");
        return new YYRelationShipRoomMode(id, relation_name, z, resource_options, resource_options_task, level_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomMode) {
            YYRelationShipRoomMode yYRelationShipRoomMode = (YYRelationShipRoomMode) obj;
            return Intrinsics.a((Object) this.id, (Object) yYRelationShipRoomMode.id) && Intrinsics.a((Object) this.relation_name, (Object) yYRelationShipRoomMode.relation_name) && this.checked == yYRelationShipRoomMode.checked && Intrinsics.a(this.resource_options, yYRelationShipRoomMode.resource_options) && Intrinsics.a(this.resource_options_task, yYRelationShipRoomMode.resource_options_task) && Intrinsics.a(this.level_info, yYRelationShipRoomMode.level_info);
        }
        return false;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final String getId() {
        return this.id;
    }

    public final ArrayList<YYRelationShipRoomLevelInfoMode> getLevel_info() {
        return this.level_info;
    }

    public final String getRelation_name() {
        return this.relation_name;
    }

    public final YYRelationShipRoomUiInfo getResource_options() {
        return this.resource_options;
    }

    public final YYRelationShipRoomTaskUiInfo getResource_options_task() {
        return this.resource_options_task;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public String toString() {
        return "YYRelationShipRoomMode(id=" + this.id + ", relation_name=" + this.relation_name + ", checked=" + this.checked + ", resource_options=" + this.resource_options + ", resource_options_task=" + this.resource_options_task + ", level_info=" + this.level_info + ')';
    }
}
