package com.blued.android.module.yy_china.model;

import $r8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents96Model.class */
public final class IMJsonContents96Model {
    private final long delay;
    private final String font_color;
    private final String icon;
    private final String link;
    private final int num;
    private final String progress_bg_color;
    private final String progress_end_color;
    private final String progress_start_color;
    private final int total;

    public IMJsonContents96Model(String link, String icon, int i, int i2, String font_color, String progress_bg_color, String progress_start_color, String progress_end_color, long j) {
        Intrinsics.e(link, "link");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(font_color, "font_color");
        Intrinsics.e(progress_bg_color, "progress_bg_color");
        Intrinsics.e(progress_start_color, "progress_start_color");
        Intrinsics.e(progress_end_color, "progress_end_color");
        this.link = link;
        this.icon = icon;
        this.num = i;
        this.total = i2;
        this.font_color = font_color;
        this.progress_bg_color = progress_bg_color;
        this.progress_start_color = progress_start_color;
        this.progress_end_color = progress_end_color;
        this.delay = j;
    }

    public static /* synthetic */ IMJsonContents96Model copy$default(IMJsonContents96Model iMJsonContents96Model, String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = iMJsonContents96Model.link;
        }
        if ((i3 & 2) != 0) {
            str2 = iMJsonContents96Model.icon;
        }
        if ((i3 & 4) != 0) {
            i = iMJsonContents96Model.num;
        }
        if ((i3 & 8) != 0) {
            i2 = iMJsonContents96Model.total;
        }
        if ((i3 & 16) != 0) {
            str3 = iMJsonContents96Model.font_color;
        }
        if ((i3 & 32) != 0) {
            str4 = iMJsonContents96Model.progress_bg_color;
        }
        if ((i3 & 64) != 0) {
            str5 = iMJsonContents96Model.progress_start_color;
        }
        if ((i3 & 128) != 0) {
            str6 = iMJsonContents96Model.progress_end_color;
        }
        if ((i3 & 256) != 0) {
            j = iMJsonContents96Model.delay;
        }
        return iMJsonContents96Model.copy(str, str2, i, i2, str3, str4, str5, str6, j);
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.icon;
    }

    public final int component3() {
        return this.num;
    }

    public final int component4() {
        return this.total;
    }

    public final String component5() {
        return this.font_color;
    }

    public final String component6() {
        return this.progress_bg_color;
    }

    public final String component7() {
        return this.progress_start_color;
    }

    public final String component8() {
        return this.progress_end_color;
    }

    public final long component9() {
        return this.delay;
    }

    public final IMJsonContents96Model copy(String link, String icon, int i, int i2, String font_color, String progress_bg_color, String progress_start_color, String progress_end_color, long j) {
        Intrinsics.e(link, "link");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(font_color, "font_color");
        Intrinsics.e(progress_bg_color, "progress_bg_color");
        Intrinsics.e(progress_start_color, "progress_start_color");
        Intrinsics.e(progress_end_color, "progress_end_color");
        return new IMJsonContents96Model(link, icon, i, i2, font_color, progress_bg_color, progress_start_color, progress_end_color, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents96Model) {
            IMJsonContents96Model iMJsonContents96Model = (IMJsonContents96Model) obj;
            return Intrinsics.a((Object) this.link, (Object) iMJsonContents96Model.link) && Intrinsics.a((Object) this.icon, (Object) iMJsonContents96Model.icon) && this.num == iMJsonContents96Model.num && this.total == iMJsonContents96Model.total && Intrinsics.a((Object) this.font_color, (Object) iMJsonContents96Model.font_color) && Intrinsics.a((Object) this.progress_bg_color, (Object) iMJsonContents96Model.progress_bg_color) && Intrinsics.a((Object) this.progress_start_color, (Object) iMJsonContents96Model.progress_start_color) && Intrinsics.a((Object) this.progress_end_color, (Object) iMJsonContents96Model.progress_end_color) && this.delay == iMJsonContents96Model.delay;
        }
        return false;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final String getFont_color() {
        return this.font_color;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getNum() {
        return this.num;
    }

    public final String getProgress_bg_color() {
        return this.progress_bg_color;
    }

    public final String getProgress_end_color() {
        return this.progress_end_color;
    }

    public final String getProgress_start_color() {
        return this.progress_start_color;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((((((((((((((this.link.hashCode() * 31) + this.icon.hashCode()) * 31) + this.num) * 31) + this.total) * 31) + this.font_color.hashCode()) * 31) + this.progress_bg_color.hashCode()) * 31) + this.progress_start_color.hashCode()) * 31) + this.progress_end_color.hashCode()) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.delay);
    }

    public String toString() {
        return "IMJsonContents96Model(link=" + this.link + ", icon=" + this.icon + ", num=" + this.num + ", total=" + this.total + ", font_color=" + this.font_color + ", progress_bg_color=" + this.progress_bg_color + ", progress_start_color=" + this.progress_start_color + ", progress_end_color=" + this.progress_end_color + ", delay=" + this.delay + ')';
    }
}
