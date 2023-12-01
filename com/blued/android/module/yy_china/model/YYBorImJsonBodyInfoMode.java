package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYBorImJsonBodyInfoMode.class */
public final class YYBorImJsonBodyInfoMode {
    private String accompanyUrl;
    private final String ani_rob_svga;
    private final String avatar;
    private String bgLight;
    private String bgLightSvga;
    private final String bgNoLight;
    private boolean completedLrc;
    private boolean completedMidi;
    private final String coverUrl;
    private long currentTime;
    private final int duration;
    private final String dynamicLyricUrl;
    private final long endTime;
    private final String musicId;
    private final String musicName;
    private String musicUrl;
    private final String name;
    private final String playToken;
    private final long startTime;
    private final String staticLyricUrl;
    private final String uid;

    public YYBorImJsonBodyInfoMode(String uid, String name, String avatar, String musicId, String musicName, String ani_rob_svga, int i, long j, long j2, long j3, String coverUrl, String dynamicLyricUrl, String playToken, String staticLyricUrl, String accompanyUrl, String musicUrl, String bgNoLight, String bgLight, String bgLightSvga, boolean z, boolean z2) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(musicId, "musicId");
        Intrinsics.e(musicName, "musicName");
        Intrinsics.e(ani_rob_svga, "ani_rob_svga");
        Intrinsics.e(coverUrl, "coverUrl");
        Intrinsics.e(dynamicLyricUrl, "dynamicLyricUrl");
        Intrinsics.e(playToken, "playToken");
        Intrinsics.e(staticLyricUrl, "staticLyricUrl");
        Intrinsics.e(accompanyUrl, "accompanyUrl");
        Intrinsics.e(musicUrl, "musicUrl");
        Intrinsics.e(bgNoLight, "bgNoLight");
        Intrinsics.e(bgLight, "bgLight");
        Intrinsics.e(bgLightSvga, "bgLightSvga");
        this.uid = uid;
        this.name = name;
        this.avatar = avatar;
        this.musicId = musicId;
        this.musicName = musicName;
        this.ani_rob_svga = ani_rob_svga;
        this.duration = i;
        this.endTime = j;
        this.currentTime = j2;
        this.startTime = j3;
        this.coverUrl = coverUrl;
        this.dynamicLyricUrl = dynamicLyricUrl;
        this.playToken = playToken;
        this.staticLyricUrl = staticLyricUrl;
        this.accompanyUrl = accompanyUrl;
        this.musicUrl = musicUrl;
        this.bgNoLight = bgNoLight;
        this.bgLight = bgLight;
        this.bgLightSvga = bgLightSvga;
        this.completedLrc = z;
        this.completedMidi = z2;
    }

    public /* synthetic */ YYBorImJsonBodyInfoMode(String str, String str2, String str3, String str4, String str5, String str6, int i, long j, long j2, long j3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, i, j, j2, j3, str7, str8, str9, str10, str11, str12, str13, str14, str15, (i2 & 524288) != 0 ? false : z, (i2 & 1048576) != 0 ? false : z2);
    }

    public static /* synthetic */ YYBorImJsonBodyInfoMode copy$default(YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode, String str, String str2, String str3, String str4, String str5, String str6, int i, long j, long j2, long j3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yYBorImJsonBodyInfoMode.uid;
        }
        if ((i2 & 2) != 0) {
            str2 = yYBorImJsonBodyInfoMode.name;
        }
        if ((i2 & 4) != 0) {
            str3 = yYBorImJsonBodyInfoMode.avatar;
        }
        if ((i2 & 8) != 0) {
            str4 = yYBorImJsonBodyInfoMode.musicId;
        }
        if ((i2 & 16) != 0) {
            str5 = yYBorImJsonBodyInfoMode.musicName;
        }
        if ((i2 & 32) != 0) {
            str6 = yYBorImJsonBodyInfoMode.ani_rob_svga;
        }
        if ((i2 & 64) != 0) {
            i = yYBorImJsonBodyInfoMode.duration;
        }
        if ((i2 & 128) != 0) {
            j = yYBorImJsonBodyInfoMode.endTime;
        }
        if ((i2 & 256) != 0) {
            j2 = yYBorImJsonBodyInfoMode.currentTime;
        }
        if ((i2 & 512) != 0) {
            j3 = yYBorImJsonBodyInfoMode.startTime;
        }
        if ((i2 & 1024) != 0) {
            str7 = yYBorImJsonBodyInfoMode.coverUrl;
        }
        if ((i2 & 2048) != 0) {
            str8 = yYBorImJsonBodyInfoMode.dynamicLyricUrl;
        }
        if ((i2 & 4096) != 0) {
            str9 = yYBorImJsonBodyInfoMode.playToken;
        }
        if ((i2 & 8192) != 0) {
            str10 = yYBorImJsonBodyInfoMode.staticLyricUrl;
        }
        if ((i2 & 16384) != 0) {
            str11 = yYBorImJsonBodyInfoMode.accompanyUrl;
        }
        if ((i2 & 32768) != 0) {
            str12 = yYBorImJsonBodyInfoMode.musicUrl;
        }
        if ((i2 & 65536) != 0) {
            str13 = yYBorImJsonBodyInfoMode.bgNoLight;
        }
        if ((i2 & 131072) != 0) {
            str14 = yYBorImJsonBodyInfoMode.bgLight;
        }
        if ((i2 & 262144) != 0) {
            str15 = yYBorImJsonBodyInfoMode.bgLightSvga;
        }
        if ((i2 & 524288) != 0) {
            z = yYBorImJsonBodyInfoMode.completedLrc;
        }
        if ((i2 & 1048576) != 0) {
            z2 = yYBorImJsonBodyInfoMode.completedMidi;
        }
        return yYBorImJsonBodyInfoMode.copy(str, str2, str3, str4, str5, str6, i, j, j2, j3, str7, str8, str9, str10, str11, str12, str13, str14, str15, z, z2);
    }

    public final String component1() {
        return this.uid;
    }

    public final long component10() {
        return this.startTime;
    }

    public final String component11() {
        return this.coverUrl;
    }

    public final String component12() {
        return this.dynamicLyricUrl;
    }

    public final String component13() {
        return this.playToken;
    }

    public final String component14() {
        return this.staticLyricUrl;
    }

    public final String component15() {
        return this.accompanyUrl;
    }

    public final String component16() {
        return this.musicUrl;
    }

    public final String component17() {
        return this.bgNoLight;
    }

    public final String component18() {
        return this.bgLight;
    }

    public final String component19() {
        return this.bgLightSvga;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component20() {
        return this.completedLrc;
    }

    public final boolean component21() {
        return this.completedMidi;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.musicId;
    }

    public final String component5() {
        return this.musicName;
    }

    public final String component6() {
        return this.ani_rob_svga;
    }

    public final int component7() {
        return this.duration;
    }

    public final long component8() {
        return this.endTime;
    }

    public final long component9() {
        return this.currentTime;
    }

    public final YYBorImJsonBodyInfoMode copy(String uid, String name, String avatar, String musicId, String musicName, String ani_rob_svga, int i, long j, long j2, long j3, String coverUrl, String dynamicLyricUrl, String playToken, String staticLyricUrl, String accompanyUrl, String musicUrl, String bgNoLight, String bgLight, String bgLightSvga, boolean z, boolean z2) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(musicId, "musicId");
        Intrinsics.e(musicName, "musicName");
        Intrinsics.e(ani_rob_svga, "ani_rob_svga");
        Intrinsics.e(coverUrl, "coverUrl");
        Intrinsics.e(dynamicLyricUrl, "dynamicLyricUrl");
        Intrinsics.e(playToken, "playToken");
        Intrinsics.e(staticLyricUrl, "staticLyricUrl");
        Intrinsics.e(accompanyUrl, "accompanyUrl");
        Intrinsics.e(musicUrl, "musicUrl");
        Intrinsics.e(bgNoLight, "bgNoLight");
        Intrinsics.e(bgLight, "bgLight");
        Intrinsics.e(bgLightSvga, "bgLightSvga");
        return new YYBorImJsonBodyInfoMode(uid, name, avatar, musicId, musicName, ani_rob_svga, i, j, j2, j3, coverUrl, dynamicLyricUrl, playToken, staticLyricUrl, accompanyUrl, musicUrl, bgNoLight, bgLight, bgLightSvga, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYBorImJsonBodyInfoMode) {
            YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode = (YYBorImJsonBodyInfoMode) obj;
            return Intrinsics.a((Object) this.uid, (Object) yYBorImJsonBodyInfoMode.uid) && Intrinsics.a((Object) this.name, (Object) yYBorImJsonBodyInfoMode.name) && Intrinsics.a((Object) this.avatar, (Object) yYBorImJsonBodyInfoMode.avatar) && Intrinsics.a((Object) this.musicId, (Object) yYBorImJsonBodyInfoMode.musicId) && Intrinsics.a((Object) this.musicName, (Object) yYBorImJsonBodyInfoMode.musicName) && Intrinsics.a((Object) this.ani_rob_svga, (Object) yYBorImJsonBodyInfoMode.ani_rob_svga) && this.duration == yYBorImJsonBodyInfoMode.duration && this.endTime == yYBorImJsonBodyInfoMode.endTime && this.currentTime == yYBorImJsonBodyInfoMode.currentTime && this.startTime == yYBorImJsonBodyInfoMode.startTime && Intrinsics.a((Object) this.coverUrl, (Object) yYBorImJsonBodyInfoMode.coverUrl) && Intrinsics.a((Object) this.dynamicLyricUrl, (Object) yYBorImJsonBodyInfoMode.dynamicLyricUrl) && Intrinsics.a((Object) this.playToken, (Object) yYBorImJsonBodyInfoMode.playToken) && Intrinsics.a((Object) this.staticLyricUrl, (Object) yYBorImJsonBodyInfoMode.staticLyricUrl) && Intrinsics.a((Object) this.accompanyUrl, (Object) yYBorImJsonBodyInfoMode.accompanyUrl) && Intrinsics.a((Object) this.musicUrl, (Object) yYBorImJsonBodyInfoMode.musicUrl) && Intrinsics.a((Object) this.bgNoLight, (Object) yYBorImJsonBodyInfoMode.bgNoLight) && Intrinsics.a((Object) this.bgLight, (Object) yYBorImJsonBodyInfoMode.bgLight) && Intrinsics.a((Object) this.bgLightSvga, (Object) yYBorImJsonBodyInfoMode.bgLightSvga) && this.completedLrc == yYBorImJsonBodyInfoMode.completedLrc && this.completedMidi == yYBorImJsonBodyInfoMode.completedMidi;
        }
        return false;
    }

    public final String getAccompanyUrl() {
        return this.accompanyUrl;
    }

    public final String getAni_rob_svga() {
        return this.ani_rob_svga;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBgLight() {
        return this.bgLight;
    }

    public final String getBgLightSvga() {
        return this.bgLightSvga;
    }

    public final String getBgNoLight() {
        return this.bgNoLight;
    }

    public final boolean getCompletedLrc() {
        return this.completedLrc;
    }

    public final boolean getCompletedMidi() {
        return this.completedMidi;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getDynamicLyricUrl() {
        return this.dynamicLyricUrl;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getMusicId() {
        return this.musicId;
    }

    public final String getMusicName() {
        return this.musicName;
    }

    public final String getMusicUrl() {
        return this.musicUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlayToken() {
        return this.playToken;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getStaticLyricUrl() {
        return this.staticLyricUrl;
    }

    public final String getUid() {
        return this.uid;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void setAccompanyUrl(String str) {
        Intrinsics.e(str, "<set-?>");
        this.accompanyUrl = str;
    }

    public final void setBgLight(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bgLight = str;
    }

    public final void setBgLightSvga(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bgLightSvga = str;
    }

    public final void setCompletedLrc(boolean z) {
        this.completedLrc = z;
    }

    public final void setCompletedMidi(boolean z) {
        this.completedMidi = z;
    }

    public final void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public final void setMusicUrl(String str) {
        Intrinsics.e(str, "<set-?>");
        this.musicUrl = str;
    }

    public String toString() {
        return "YYBorImJsonBodyInfoMode(uid=" + this.uid + ", name=" + this.name + ", avatar=" + this.avatar + ", musicId=" + this.musicId + ", musicName=" + this.musicName + ", ani_rob_svga=" + this.ani_rob_svga + ", duration=" + this.duration + ", endTime=" + this.endTime + ", currentTime=" + this.currentTime + ", startTime=" + this.startTime + ", coverUrl=" + this.coverUrl + ", dynamicLyricUrl=" + this.dynamicLyricUrl + ", playToken=" + this.playToken + ", staticLyricUrl=" + this.staticLyricUrl + ", accompanyUrl=" + this.accompanyUrl + ", musicUrl=" + this.musicUrl + ", bgNoLight=" + this.bgNoLight + ", bgLight=" + this.bgLight + ", bgLightSvga=" + this.bgLightSvga + ", completedLrc=" + this.completedLrc + ", completedMidi=" + this.completedMidi + ')';
    }
}
