package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents109Model.class */
public final class IMJsonContents109Model {
    private final String android_goods_id;
    private final String count;
    private final String goods_desc;
    private final String goods_image;
    private final String ios_goods_id;
    private final String total_count;

    public IMJsonContents109Model(String count, String total_count, String goods_image, String goods_desc, String android_goods_id, String ios_goods_id) {
        Intrinsics.e(count, "count");
        Intrinsics.e(total_count, "total_count");
        Intrinsics.e(goods_image, "goods_image");
        Intrinsics.e(goods_desc, "goods_desc");
        Intrinsics.e(android_goods_id, "android_goods_id");
        Intrinsics.e(ios_goods_id, "ios_goods_id");
        this.count = count;
        this.total_count = total_count;
        this.goods_image = goods_image;
        this.goods_desc = goods_desc;
        this.android_goods_id = android_goods_id;
        this.ios_goods_id = ios_goods_id;
    }

    public static /* synthetic */ IMJsonContents109Model copy$default(IMJsonContents109Model iMJsonContents109Model, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iMJsonContents109Model.count;
        }
        if ((i & 2) != 0) {
            str2 = iMJsonContents109Model.total_count;
        }
        if ((i & 4) != 0) {
            str3 = iMJsonContents109Model.goods_image;
        }
        if ((i & 8) != 0) {
            str4 = iMJsonContents109Model.goods_desc;
        }
        if ((i & 16) != 0) {
            str5 = iMJsonContents109Model.android_goods_id;
        }
        if ((i & 32) != 0) {
            str6 = iMJsonContents109Model.ios_goods_id;
        }
        return iMJsonContents109Model.copy(str, str2, str3, str4, str5, str6);
    }

    public final String component1() {
        return this.count;
    }

    public final String component2() {
        return this.total_count;
    }

    public final String component3() {
        return this.goods_image;
    }

    public final String component4() {
        return this.goods_desc;
    }

    public final String component5() {
        return this.android_goods_id;
    }

    public final String component6() {
        return this.ios_goods_id;
    }

    public final IMJsonContents109Model copy(String count, String total_count, String goods_image, String goods_desc, String android_goods_id, String ios_goods_id) {
        Intrinsics.e(count, "count");
        Intrinsics.e(total_count, "total_count");
        Intrinsics.e(goods_image, "goods_image");
        Intrinsics.e(goods_desc, "goods_desc");
        Intrinsics.e(android_goods_id, "android_goods_id");
        Intrinsics.e(ios_goods_id, "ios_goods_id");
        return new IMJsonContents109Model(count, total_count, goods_image, goods_desc, android_goods_id, ios_goods_id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents109Model) {
            IMJsonContents109Model iMJsonContents109Model = (IMJsonContents109Model) obj;
            return Intrinsics.a((Object) this.count, (Object) iMJsonContents109Model.count) && Intrinsics.a((Object) this.total_count, (Object) iMJsonContents109Model.total_count) && Intrinsics.a((Object) this.goods_image, (Object) iMJsonContents109Model.goods_image) && Intrinsics.a((Object) this.goods_desc, (Object) iMJsonContents109Model.goods_desc) && Intrinsics.a((Object) this.android_goods_id, (Object) iMJsonContents109Model.android_goods_id) && Intrinsics.a((Object) this.ios_goods_id, (Object) iMJsonContents109Model.ios_goods_id);
        }
        return false;
    }

    public final String getAndroid_goods_id() {
        return this.android_goods_id;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getGoods_desc() {
        return this.goods_desc;
    }

    public final String getGoods_image() {
        return this.goods_image;
    }

    public final String getIos_goods_id() {
        return this.ios_goods_id;
    }

    public final String getTotal_count() {
        return this.total_count;
    }

    public int hashCode() {
        return (((((((((this.count.hashCode() * 31) + this.total_count.hashCode()) * 31) + this.goods_image.hashCode()) * 31) + this.goods_desc.hashCode()) * 31) + this.android_goods_id.hashCode()) * 31) + this.ios_goods_id.hashCode();
    }

    public String toString() {
        return "IMJsonContents109Model(count=" + this.count + ", total_count=" + this.total_count + ", goods_image=" + this.goods_image + ", goods_desc=" + this.goods_desc + ", android_goods_id=" + this.android_goods_id + ", ios_goods_id=" + this.ios_goods_id + ')';
    }
}
