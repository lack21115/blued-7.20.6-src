package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/DoublePeopleNoticeInfoNode.class */
public final class DoublePeopleNoticeInfoNode {
    private final String after_image;
    private final String background;
    private final String content;
    private final int delay;
    private final String image_after;
    private final String link;
    private final int stay_seconds;
    private final int type;

    public DoublePeopleNoticeInfoNode(String after_image, int i, int i2, int i3, String content, String background, String image_after, String link) {
        Intrinsics.e(after_image, "after_image");
        Intrinsics.e(content, "content");
        Intrinsics.e(background, "background");
        Intrinsics.e(image_after, "image_after");
        Intrinsics.e(link, "link");
        this.after_image = after_image;
        this.delay = i;
        this.type = i2;
        this.stay_seconds = i3;
        this.content = content;
        this.background = background;
        this.image_after = image_after;
        this.link = link;
    }

    public static /* synthetic */ DoublePeopleNoticeInfoNode copy$default(DoublePeopleNoticeInfoNode doublePeopleNoticeInfoNode, String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = doublePeopleNoticeInfoNode.after_image;
        }
        if ((i4 & 2) != 0) {
            i = doublePeopleNoticeInfoNode.delay;
        }
        if ((i4 & 4) != 0) {
            i2 = doublePeopleNoticeInfoNode.type;
        }
        if ((i4 & 8) != 0) {
            i3 = doublePeopleNoticeInfoNode.stay_seconds;
        }
        if ((i4 & 16) != 0) {
            str2 = doublePeopleNoticeInfoNode.content;
        }
        if ((i4 & 32) != 0) {
            str3 = doublePeopleNoticeInfoNode.background;
        }
        if ((i4 & 64) != 0) {
            str4 = doublePeopleNoticeInfoNode.image_after;
        }
        if ((i4 & 128) != 0) {
            str5 = doublePeopleNoticeInfoNode.link;
        }
        return doublePeopleNoticeInfoNode.copy(str, i, i2, i3, str2, str3, str4, str5);
    }

    public final String component1() {
        return this.after_image;
    }

    public final int component2() {
        return this.delay;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.stay_seconds;
    }

    public final String component5() {
        return this.content;
    }

    public final String component6() {
        return this.background;
    }

    public final String component7() {
        return this.image_after;
    }

    public final String component8() {
        return this.link;
    }

    public final DoublePeopleNoticeInfoNode copy(String after_image, int i, int i2, int i3, String content, String background, String image_after, String link) {
        Intrinsics.e(after_image, "after_image");
        Intrinsics.e(content, "content");
        Intrinsics.e(background, "background");
        Intrinsics.e(image_after, "image_after");
        Intrinsics.e(link, "link");
        return new DoublePeopleNoticeInfoNode(after_image, i, i2, i3, content, background, image_after, link);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DoublePeopleNoticeInfoNode) {
            DoublePeopleNoticeInfoNode doublePeopleNoticeInfoNode = (DoublePeopleNoticeInfoNode) obj;
            return Intrinsics.a((Object) this.after_image, (Object) doublePeopleNoticeInfoNode.after_image) && this.delay == doublePeopleNoticeInfoNode.delay && this.type == doublePeopleNoticeInfoNode.type && this.stay_seconds == doublePeopleNoticeInfoNode.stay_seconds && Intrinsics.a((Object) this.content, (Object) doublePeopleNoticeInfoNode.content) && Intrinsics.a((Object) this.background, (Object) doublePeopleNoticeInfoNode.background) && Intrinsics.a((Object) this.image_after, (Object) doublePeopleNoticeInfoNode.image_after) && Intrinsics.a((Object) this.link, (Object) doublePeopleNoticeInfoNode.link);
        }
        return false;
    }

    public final String getAfter_image() {
        return this.after_image;
    }

    public final String getBackground() {
        return this.background;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getDelay() {
        return this.delay;
    }

    public final String getImage_after() {
        return this.image_after;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getStay_seconds() {
        return this.stay_seconds;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((this.after_image.hashCode() * 31) + this.delay) * 31) + this.type) * 31) + this.stay_seconds) * 31) + this.content.hashCode()) * 31) + this.background.hashCode()) * 31) + this.image_after.hashCode()) * 31) + this.link.hashCode();
    }

    public String toString() {
        return "DoublePeopleNoticeInfoNode(after_image=" + this.after_image + ", delay=" + this.delay + ", type=" + this.type + ", stay_seconds=" + this.stay_seconds + ", content=" + this.content + ", background=" + this.background + ", image_after=" + this.image_after + ", link=" + this.link + ')';
    }
}
