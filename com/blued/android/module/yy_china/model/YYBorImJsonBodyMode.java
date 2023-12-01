package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYBorImJsonBodyMode.class */
public final class YYBorImJsonBodyMode {
    private final String light_svga;
    private final String musicId;
    private final YYBorImJsonBodyInfoMode musicInfo;
    private final ArrayList<YYBorImJsonBodyInfoMode> musicList;
    private final String musicName;
    private final int result;
    private final String source_name;
    private final String source_uid;
    private final int status;
    private final String target_name;
    private final String target_uid;

    public YYBorImJsonBodyMode(int i, YYBorImJsonBodyInfoMode musicInfo, ArrayList<YYBorImJsonBodyInfoMode> musicList, int i2, String source_uid, String source_name, String target_uid, String target_name, String light_svga, String musicId, String musicName) {
        Intrinsics.e(musicInfo, "musicInfo");
        Intrinsics.e(musicList, "musicList");
        Intrinsics.e(source_uid, "source_uid");
        Intrinsics.e(source_name, "source_name");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(target_name, "target_name");
        Intrinsics.e(light_svga, "light_svga");
        Intrinsics.e(musicId, "musicId");
        Intrinsics.e(musicName, "musicName");
        this.status = i;
        this.musicInfo = musicInfo;
        this.musicList = musicList;
        this.result = i2;
        this.source_uid = source_uid;
        this.source_name = source_name;
        this.target_uid = target_uid;
        this.target_name = target_name;
        this.light_svga = light_svga;
        this.musicId = musicId;
        this.musicName = musicName;
    }

    public static /* synthetic */ YYBorImJsonBodyMode copy$default(YYBorImJsonBodyMode yYBorImJsonBodyMode, int i, YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode, ArrayList arrayList, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = yYBorImJsonBodyMode.status;
        }
        if ((i3 & 2) != 0) {
            yYBorImJsonBodyInfoMode = yYBorImJsonBodyMode.musicInfo;
        }
        if ((i3 & 4) != 0) {
            arrayList = yYBorImJsonBodyMode.musicList;
        }
        if ((i3 & 8) != 0) {
            i2 = yYBorImJsonBodyMode.result;
        }
        if ((i3 & 16) != 0) {
            str = yYBorImJsonBodyMode.source_uid;
        }
        if ((i3 & 32) != 0) {
            str2 = yYBorImJsonBodyMode.source_name;
        }
        if ((i3 & 64) != 0) {
            str3 = yYBorImJsonBodyMode.target_uid;
        }
        if ((i3 & 128) != 0) {
            str4 = yYBorImJsonBodyMode.target_name;
        }
        if ((i3 & 256) != 0) {
            str5 = yYBorImJsonBodyMode.light_svga;
        }
        if ((i3 & 512) != 0) {
            str6 = yYBorImJsonBodyMode.musicId;
        }
        if ((i3 & 1024) != 0) {
            str7 = yYBorImJsonBodyMode.musicName;
        }
        return yYBorImJsonBodyMode.copy(i, yYBorImJsonBodyInfoMode, arrayList, i2, str, str2, str3, str4, str5, str6, str7);
    }

    public final int component1() {
        return this.status;
    }

    public final String component10() {
        return this.musicId;
    }

    public final String component11() {
        return this.musicName;
    }

    public final YYBorImJsonBodyInfoMode component2() {
        return this.musicInfo;
    }

    public final ArrayList<YYBorImJsonBodyInfoMode> component3() {
        return this.musicList;
    }

    public final int component4() {
        return this.result;
    }

    public final String component5() {
        return this.source_uid;
    }

    public final String component6() {
        return this.source_name;
    }

    public final String component7() {
        return this.target_uid;
    }

    public final String component8() {
        return this.target_name;
    }

    public final String component9() {
        return this.light_svga;
    }

    public final YYBorImJsonBodyMode copy(int i, YYBorImJsonBodyInfoMode musicInfo, ArrayList<YYBorImJsonBodyInfoMode> musicList, int i2, String source_uid, String source_name, String target_uid, String target_name, String light_svga, String musicId, String musicName) {
        Intrinsics.e(musicInfo, "musicInfo");
        Intrinsics.e(musicList, "musicList");
        Intrinsics.e(source_uid, "source_uid");
        Intrinsics.e(source_name, "source_name");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(target_name, "target_name");
        Intrinsics.e(light_svga, "light_svga");
        Intrinsics.e(musicId, "musicId");
        Intrinsics.e(musicName, "musicName");
        return new YYBorImJsonBodyMode(i, musicInfo, musicList, i2, source_uid, source_name, target_uid, target_name, light_svga, musicId, musicName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYBorImJsonBodyMode) {
            YYBorImJsonBodyMode yYBorImJsonBodyMode = (YYBorImJsonBodyMode) obj;
            return this.status == yYBorImJsonBodyMode.status && Intrinsics.a(this.musicInfo, yYBorImJsonBodyMode.musicInfo) && Intrinsics.a(this.musicList, yYBorImJsonBodyMode.musicList) && this.result == yYBorImJsonBodyMode.result && Intrinsics.a((Object) this.source_uid, (Object) yYBorImJsonBodyMode.source_uid) && Intrinsics.a((Object) this.source_name, (Object) yYBorImJsonBodyMode.source_name) && Intrinsics.a((Object) this.target_uid, (Object) yYBorImJsonBodyMode.target_uid) && Intrinsics.a((Object) this.target_name, (Object) yYBorImJsonBodyMode.target_name) && Intrinsics.a((Object) this.light_svga, (Object) yYBorImJsonBodyMode.light_svga) && Intrinsics.a((Object) this.musicId, (Object) yYBorImJsonBodyMode.musicId) && Intrinsics.a((Object) this.musicName, (Object) yYBorImJsonBodyMode.musicName);
        }
        return false;
    }

    public final String getLight_svga() {
        return this.light_svga;
    }

    public final String getMusicId() {
        return this.musicId;
    }

    public final YYBorImJsonBodyInfoMode getMusicInfo() {
        return this.musicInfo;
    }

    public final ArrayList<YYBorImJsonBodyInfoMode> getMusicList() {
        return this.musicList;
    }

    public final String getMusicName() {
        return this.musicName;
    }

    public final int getResult() {
        return this.result;
    }

    public final String getSource_name() {
        return this.source_name;
    }

    public final String getSource_uid() {
        return this.source_uid;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTarget_name() {
        return this.target_name;
    }

    public final String getTarget_uid() {
        return this.target_uid;
    }

    public int hashCode() {
        return (((((((((((((((((((this.status * 31) + this.musicInfo.hashCode()) * 31) + this.musicList.hashCode()) * 31) + this.result) * 31) + this.source_uid.hashCode()) * 31) + this.source_name.hashCode()) * 31) + this.target_uid.hashCode()) * 31) + this.target_name.hashCode()) * 31) + this.light_svga.hashCode()) * 31) + this.musicId.hashCode()) * 31) + this.musicName.hashCode();
    }

    public String toString() {
        return "YYBorImJsonBodyMode(status=" + this.status + ", musicInfo=" + this.musicInfo + ", musicList=" + this.musicList + ", result=" + this.result + ", source_uid=" + this.source_uid + ", source_name=" + this.source_name + ", target_uid=" + this.target_uid + ", target_name=" + this.target_name + ", light_svga=" + this.light_svga + ", musicId=" + this.musicId + ", musicName=" + this.musicName + ')';
    }
}
