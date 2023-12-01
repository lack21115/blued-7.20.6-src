package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCarExhibitionModel.class */
public final class YYCarExhibitionModel {
    private final String image;
    private final String num;
    private final String source_avatar;

    public YYCarExhibitionModel(String image, String source_avatar, String num) {
        Intrinsics.e(image, "image");
        Intrinsics.e(source_avatar, "source_avatar");
        Intrinsics.e(num, "num");
        this.image = image;
        this.source_avatar = source_avatar;
        this.num = num;
    }

    public static /* synthetic */ YYCarExhibitionModel copy$default(YYCarExhibitionModel yYCarExhibitionModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYCarExhibitionModel.image;
        }
        if ((i & 2) != 0) {
            str2 = yYCarExhibitionModel.source_avatar;
        }
        if ((i & 4) != 0) {
            str3 = yYCarExhibitionModel.num;
        }
        return yYCarExhibitionModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.image;
    }

    public final String component2() {
        return this.source_avatar;
    }

    public final String component3() {
        return this.num;
    }

    public final YYCarExhibitionModel copy(String image, String source_avatar, String num) {
        Intrinsics.e(image, "image");
        Intrinsics.e(source_avatar, "source_avatar");
        Intrinsics.e(num, "num");
        return new YYCarExhibitionModel(image, source_avatar, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYCarExhibitionModel) {
            YYCarExhibitionModel yYCarExhibitionModel = (YYCarExhibitionModel) obj;
            return Intrinsics.a((Object) this.image, (Object) yYCarExhibitionModel.image) && Intrinsics.a((Object) this.source_avatar, (Object) yYCarExhibitionModel.source_avatar) && Intrinsics.a((Object) this.num, (Object) yYCarExhibitionModel.num);
        }
        return false;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getNum() {
        return this.num;
    }

    public final String getSource_avatar() {
        return this.source_avatar;
    }

    public int hashCode() {
        return (((this.image.hashCode() * 31) + this.source_avatar.hashCode()) * 31) + this.num.hashCode();
    }

    public String toString() {
        return "YYCarExhibitionModel(image=" + this.image + ", source_avatar=" + this.source_avatar + ", num=" + this.num + ')';
    }
}
