package com.blued.android.module.yy_china.model;

import $r8;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/MusicDTO.class */
public final class MusicDTO {
    private String artist;
    private String coverUrl;
    private long duration;
    private String musicId;
    private String musicName;

    public MusicDTO(String musicId, String musicName, String coverUrl, String artist, long j) {
        Intrinsics.e(musicId, "musicId");
        Intrinsics.e(musicName, "musicName");
        Intrinsics.e(coverUrl, "coverUrl");
        Intrinsics.e(artist, "artist");
        this.musicId = musicId;
        this.musicName = musicName;
        this.coverUrl = coverUrl;
        this.artist = artist;
        this.duration = j;
    }

    public /* synthetic */ MusicDTO(String str, String str2, String str3, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? 0L : j);
    }

    public static /* synthetic */ MusicDTO copy$default(MusicDTO musicDTO, String str, String str2, String str3, String str4, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = musicDTO.musicId;
        }
        if ((i & 2) != 0) {
            str2 = musicDTO.musicName;
        }
        if ((i & 4) != 0) {
            str3 = musicDTO.coverUrl;
        }
        if ((i & 8) != 0) {
            str4 = musicDTO.artist;
        }
        if ((i & 16) != 0) {
            j = musicDTO.duration;
        }
        return musicDTO.copy(str, str2, str3, str4, j);
    }

    public final String component1() {
        return this.musicId;
    }

    public final String component2() {
        return this.musicName;
    }

    public final String component3() {
        return this.coverUrl;
    }

    public final String component4() {
        return this.artist;
    }

    public final long component5() {
        return this.duration;
    }

    public final MusicDTO copy(String musicId, String musicName, String coverUrl, String artist, long j) {
        Intrinsics.e(musicId, "musicId");
        Intrinsics.e(musicName, "musicName");
        Intrinsics.e(coverUrl, "coverUrl");
        Intrinsics.e(artist, "artist");
        return new MusicDTO(musicId, musicName, coverUrl, artist, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MusicDTO) {
            MusicDTO musicDTO = (MusicDTO) obj;
            return Intrinsics.a((Object) this.musicId, (Object) musicDTO.musicId) && Intrinsics.a((Object) this.musicName, (Object) musicDTO.musicName) && Intrinsics.a((Object) this.coverUrl, (Object) musicDTO.coverUrl) && Intrinsics.a((Object) this.artist, (Object) musicDTO.artist) && this.duration == musicDTO.duration;
        }
        return false;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getMusicId() {
        return this.musicId;
    }

    public final String getMusicName() {
        return this.musicName;
    }

    public int hashCode() {
        return (((((((this.musicId.hashCode() * 31) + this.musicName.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.artist.hashCode()) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.duration);
    }

    public final void setArtist(String str) {
        Intrinsics.e(str, "<set-?>");
        this.artist = str;
    }

    public final void setCoverUrl(String str) {
        Intrinsics.e(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final void setMusicId(String str) {
        Intrinsics.e(str, "<set-?>");
        this.musicId = str;
    }

    public final void setMusicName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.musicName = str;
    }

    public String toString() {
        return "MusicDTO(musicId=" + this.musicId + ", musicName=" + this.musicName + ", coverUrl=" + this.coverUrl + ", artist=" + this.artist + ", duration=" + this.duration + ')';
    }
}
