package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftBasic.class */
public final class LiveGiftBasic implements Serializable {
    private final String desc;
    private final String id;
    private final String image;
    private final String name;
    private final String package_image;
    private final int status;

    public LiveGiftBasic(String desc, String id, String image, String name, String package_image, int i) {
        Intrinsics.e(desc, "desc");
        Intrinsics.e(id, "id");
        Intrinsics.e(image, "image");
        Intrinsics.e(name, "name");
        Intrinsics.e(package_image, "package_image");
        this.desc = desc;
        this.id = id;
        this.image = image;
        this.name = name;
        this.package_image = package_image;
        this.status = i;
    }

    public static /* synthetic */ LiveGiftBasic copy$default(LiveGiftBasic liveGiftBasic, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = liveGiftBasic.desc;
        }
        if ((i2 & 2) != 0) {
            str2 = liveGiftBasic.id;
        }
        if ((i2 & 4) != 0) {
            str3 = liveGiftBasic.image;
        }
        if ((i2 & 8) != 0) {
            str4 = liveGiftBasic.name;
        }
        if ((i2 & 16) != 0) {
            str5 = liveGiftBasic.package_image;
        }
        if ((i2 & 32) != 0) {
            i = liveGiftBasic.status;
        }
        return liveGiftBasic.copy(str, str2, str3, str4, str5, i);
    }

    public final String component1() {
        return this.desc;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.package_image;
    }

    public final int component6() {
        return this.status;
    }

    public final LiveGiftBasic copy(String desc, String id, String image, String name, String package_image, int i) {
        Intrinsics.e(desc, "desc");
        Intrinsics.e(id, "id");
        Intrinsics.e(image, "image");
        Intrinsics.e(name, "name");
        Intrinsics.e(package_image, "package_image");
        return new LiveGiftBasic(desc, id, image, name, package_image, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGiftBasic) {
            LiveGiftBasic liveGiftBasic = (LiveGiftBasic) obj;
            return Intrinsics.a((Object) this.desc, (Object) liveGiftBasic.desc) && Intrinsics.a((Object) this.id, (Object) liveGiftBasic.id) && Intrinsics.a((Object) this.image, (Object) liveGiftBasic.image) && Intrinsics.a((Object) this.name, (Object) liveGiftBasic.name) && Intrinsics.a((Object) this.package_image, (Object) liveGiftBasic.package_image) && this.status == liveGiftBasic.status;
        }
        return false;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackage_image() {
        return this.package_image;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((((this.desc.hashCode() * 31) + this.id.hashCode()) * 31) + this.image.hashCode()) * 31) + this.name.hashCode()) * 31) + this.package_image.hashCode()) * 31) + this.status;
    }

    public String toString() {
        return "LiveGiftBasic(desc=" + this.desc + ", id=" + this.id + ", image=" + this.image + ", name=" + this.name + ", package_image=" + this.package_image + ", status=" + this.status + ')';
    }
}
