package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomTaskUiInfo.class */
public final class YYRelationShipRoomTaskUiInfo {
    private final String icon_task_dai;
    private final String icon_task_qichuang;
    private final String icon_task_songli;
    private final String icon_task_wanan;

    public YYRelationShipRoomTaskUiInfo(String icon_task_qichuang, String icon_task_dai, String icon_task_songli, String icon_task_wanan) {
        Intrinsics.e(icon_task_qichuang, "icon_task_qichuang");
        Intrinsics.e(icon_task_dai, "icon_task_dai");
        Intrinsics.e(icon_task_songli, "icon_task_songli");
        Intrinsics.e(icon_task_wanan, "icon_task_wanan");
        this.icon_task_qichuang = icon_task_qichuang;
        this.icon_task_dai = icon_task_dai;
        this.icon_task_songli = icon_task_songli;
        this.icon_task_wanan = icon_task_wanan;
    }

    public static /* synthetic */ YYRelationShipRoomTaskUiInfo copy$default(YYRelationShipRoomTaskUiInfo yYRelationShipRoomTaskUiInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRelationShipRoomTaskUiInfo.icon_task_qichuang;
        }
        if ((i & 2) != 0) {
            str2 = yYRelationShipRoomTaskUiInfo.icon_task_dai;
        }
        if ((i & 4) != 0) {
            str3 = yYRelationShipRoomTaskUiInfo.icon_task_songli;
        }
        if ((i & 8) != 0) {
            str4 = yYRelationShipRoomTaskUiInfo.icon_task_wanan;
        }
        return yYRelationShipRoomTaskUiInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.icon_task_qichuang;
    }

    public final String component2() {
        return this.icon_task_dai;
    }

    public final String component3() {
        return this.icon_task_songli;
    }

    public final String component4() {
        return this.icon_task_wanan;
    }

    public final YYRelationShipRoomTaskUiInfo copy(String icon_task_qichuang, String icon_task_dai, String icon_task_songli, String icon_task_wanan) {
        Intrinsics.e(icon_task_qichuang, "icon_task_qichuang");
        Intrinsics.e(icon_task_dai, "icon_task_dai");
        Intrinsics.e(icon_task_songli, "icon_task_songli");
        Intrinsics.e(icon_task_wanan, "icon_task_wanan");
        return new YYRelationShipRoomTaskUiInfo(icon_task_qichuang, icon_task_dai, icon_task_songli, icon_task_wanan);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomTaskUiInfo) {
            YYRelationShipRoomTaskUiInfo yYRelationShipRoomTaskUiInfo = (YYRelationShipRoomTaskUiInfo) obj;
            return Intrinsics.a((Object) this.icon_task_qichuang, (Object) yYRelationShipRoomTaskUiInfo.icon_task_qichuang) && Intrinsics.a((Object) this.icon_task_dai, (Object) yYRelationShipRoomTaskUiInfo.icon_task_dai) && Intrinsics.a((Object) this.icon_task_songli, (Object) yYRelationShipRoomTaskUiInfo.icon_task_songli) && Intrinsics.a((Object) this.icon_task_wanan, (Object) yYRelationShipRoomTaskUiInfo.icon_task_wanan);
        }
        return false;
    }

    public final String getIcon_task_dai() {
        return this.icon_task_dai;
    }

    public final String getIcon_task_qichuang() {
        return this.icon_task_qichuang;
    }

    public final String getIcon_task_songli() {
        return this.icon_task_songli;
    }

    public final String getIcon_task_wanan() {
        return this.icon_task_wanan;
    }

    public int hashCode() {
        return (((((this.icon_task_qichuang.hashCode() * 31) + this.icon_task_dai.hashCode()) * 31) + this.icon_task_songli.hashCode()) * 31) + this.icon_task_wanan.hashCode();
    }

    public String toString() {
        return "YYRelationShipRoomTaskUiInfo(icon_task_qichuang=" + this.icon_task_qichuang + ", icon_task_dai=" + this.icon_task_dai + ", icon_task_songli=" + this.icon_task_songli + ", icon_task_wanan=" + this.icon_task_wanan + ')';
    }
}
