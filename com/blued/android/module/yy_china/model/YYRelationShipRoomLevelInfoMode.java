package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomLevelInfoMode.class */
public final class YYRelationShipRoomLevelInfoMode {
    private final String alias;
    private final String level;
    private final YYRelationShipRoomUserLeveLInfoUiMode resource_options;
    private final String score;

    public YYRelationShipRoomLevelInfoMode(String level, String score, String alias, YYRelationShipRoomUserLeveLInfoUiMode resource_options) {
        Intrinsics.e(level, "level");
        Intrinsics.e(score, "score");
        Intrinsics.e(alias, "alias");
        Intrinsics.e(resource_options, "resource_options");
        this.level = level;
        this.score = score;
        this.alias = alias;
        this.resource_options = resource_options;
    }

    public static /* synthetic */ YYRelationShipRoomLevelInfoMode copy$default(YYRelationShipRoomLevelInfoMode yYRelationShipRoomLevelInfoMode, String str, String str2, String str3, YYRelationShipRoomUserLeveLInfoUiMode yYRelationShipRoomUserLeveLInfoUiMode, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRelationShipRoomLevelInfoMode.level;
        }
        if ((i & 2) != 0) {
            str2 = yYRelationShipRoomLevelInfoMode.score;
        }
        if ((i & 4) != 0) {
            str3 = yYRelationShipRoomLevelInfoMode.alias;
        }
        if ((i & 8) != 0) {
            yYRelationShipRoomUserLeveLInfoUiMode = yYRelationShipRoomLevelInfoMode.resource_options;
        }
        return yYRelationShipRoomLevelInfoMode.copy(str, str2, str3, yYRelationShipRoomUserLeveLInfoUiMode);
    }

    public final String component1() {
        return this.level;
    }

    public final String component2() {
        return this.score;
    }

    public final String component3() {
        return this.alias;
    }

    public final YYRelationShipRoomUserLeveLInfoUiMode component4() {
        return this.resource_options;
    }

    public final YYRelationShipRoomLevelInfoMode copy(String level, String score, String alias, YYRelationShipRoomUserLeveLInfoUiMode resource_options) {
        Intrinsics.e(level, "level");
        Intrinsics.e(score, "score");
        Intrinsics.e(alias, "alias");
        Intrinsics.e(resource_options, "resource_options");
        return new YYRelationShipRoomLevelInfoMode(level, score, alias, resource_options);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomLevelInfoMode) {
            YYRelationShipRoomLevelInfoMode yYRelationShipRoomLevelInfoMode = (YYRelationShipRoomLevelInfoMode) obj;
            return Intrinsics.a((Object) this.level, (Object) yYRelationShipRoomLevelInfoMode.level) && Intrinsics.a((Object) this.score, (Object) yYRelationShipRoomLevelInfoMode.score) && Intrinsics.a((Object) this.alias, (Object) yYRelationShipRoomLevelInfoMode.alias) && Intrinsics.a(this.resource_options, yYRelationShipRoomLevelInfoMode.resource_options);
        }
        return false;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getLevel() {
        return this.level;
    }

    public final YYRelationShipRoomUserLeveLInfoUiMode getResource_options() {
        return this.resource_options;
    }

    public final String getScore() {
        return this.score;
    }

    public int hashCode() {
        return (((((this.level.hashCode() * 31) + this.score.hashCode()) * 31) + this.alias.hashCode()) * 31) + this.resource_options.hashCode();
    }

    public String toString() {
        return "YYRelationShipRoomLevelInfoMode(level=" + this.level + ", score=" + this.score + ", alias=" + this.alias + ", resource_options=" + this.resource_options + ')';
    }
}
