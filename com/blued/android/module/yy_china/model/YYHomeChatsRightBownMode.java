package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYHomeChatsRightBownMode.class */
public final class YYHomeChatsRightBownMode {
    private final String background_image;
    private final int frequency_seconds;
    private final String link;
    private final int position;
    private final ArrayList<String> sub_title;
    private final String title;

    public YYHomeChatsRightBownMode(int i, String title, String background_image, int i2, String link, ArrayList<String> sub_title) {
        Intrinsics.e(title, "title");
        Intrinsics.e(background_image, "background_image");
        Intrinsics.e(link, "link");
        Intrinsics.e(sub_title, "sub_title");
        this.position = i;
        this.title = title;
        this.background_image = background_image;
        this.frequency_seconds = i2;
        this.link = link;
        this.sub_title = sub_title;
    }

    public static /* synthetic */ YYHomeChatsRightBownMode copy$default(YYHomeChatsRightBownMode yYHomeChatsRightBownMode, int i, String str, String str2, int i2, String str3, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = yYHomeChatsRightBownMode.position;
        }
        if ((i3 & 2) != 0) {
            str = yYHomeChatsRightBownMode.title;
        }
        if ((i3 & 4) != 0) {
            str2 = yYHomeChatsRightBownMode.background_image;
        }
        if ((i3 & 8) != 0) {
            i2 = yYHomeChatsRightBownMode.frequency_seconds;
        }
        if ((i3 & 16) != 0) {
            str3 = yYHomeChatsRightBownMode.link;
        }
        if ((i3 & 32) != 0) {
            arrayList = yYHomeChatsRightBownMode.sub_title;
        }
        return yYHomeChatsRightBownMode.copy(i, str, str2, i2, str3, arrayList);
    }

    public final int component1() {
        return this.position;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.background_image;
    }

    public final int component4() {
        return this.frequency_seconds;
    }

    public final String component5() {
        return this.link;
    }

    public final ArrayList<String> component6() {
        return this.sub_title;
    }

    public final YYHomeChatsRightBownMode copy(int i, String title, String background_image, int i2, String link, ArrayList<String> sub_title) {
        Intrinsics.e(title, "title");
        Intrinsics.e(background_image, "background_image");
        Intrinsics.e(link, "link");
        Intrinsics.e(sub_title, "sub_title");
        return new YYHomeChatsRightBownMode(i, title, background_image, i2, link, sub_title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYHomeChatsRightBownMode) {
            YYHomeChatsRightBownMode yYHomeChatsRightBownMode = (YYHomeChatsRightBownMode) obj;
            return this.position == yYHomeChatsRightBownMode.position && Intrinsics.a((Object) this.title, (Object) yYHomeChatsRightBownMode.title) && Intrinsics.a((Object) this.background_image, (Object) yYHomeChatsRightBownMode.background_image) && this.frequency_seconds == yYHomeChatsRightBownMode.frequency_seconds && Intrinsics.a((Object) this.link, (Object) yYHomeChatsRightBownMode.link) && Intrinsics.a(this.sub_title, yYHomeChatsRightBownMode.sub_title);
        }
        return false;
    }

    public final String getBackground_image() {
        return this.background_image;
    }

    public final int getFrequency_seconds() {
        return this.frequency_seconds;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getPosition() {
        return this.position;
    }

    public final ArrayList<String> getSub_title() {
        return this.sub_title;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((this.position * 31) + this.title.hashCode()) * 31) + this.background_image.hashCode()) * 31) + this.frequency_seconds) * 31) + this.link.hashCode()) * 31) + this.sub_title.hashCode();
    }

    public String toString() {
        return "YYHomeChatsRightBownMode(position=" + this.position + ", title=" + this.title + ", background_image=" + this.background_image + ", frequency_seconds=" + this.frequency_seconds + ", link=" + this.link + ", sub_title=" + this.sub_title + ')';
    }
}
