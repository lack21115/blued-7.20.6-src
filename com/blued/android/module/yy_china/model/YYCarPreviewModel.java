package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCarPreviewModel.class */
public final class YYCarPreviewModel {
    private final String beans;
    private final String color_id;
    private final String icon;
    private final String id;
    private final String image;
    private final String name;
    private final String skin_id;
    private final String special_effects;

    public YYCarPreviewModel(String id, String skin_id, String color_id, String name, String special_effects, String image, String icon, String beans) {
        Intrinsics.e(id, "id");
        Intrinsics.e(skin_id, "skin_id");
        Intrinsics.e(color_id, "color_id");
        Intrinsics.e(name, "name");
        Intrinsics.e(special_effects, "special_effects");
        Intrinsics.e(image, "image");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(beans, "beans");
        this.id = id;
        this.skin_id = skin_id;
        this.color_id = color_id;
        this.name = name;
        this.special_effects = special_effects;
        this.image = image;
        this.icon = icon;
        this.beans = beans;
    }

    public static /* synthetic */ YYCarPreviewModel copy$default(YYCarPreviewModel yYCarPreviewModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYCarPreviewModel.id;
        }
        if ((i & 2) != 0) {
            str2 = yYCarPreviewModel.skin_id;
        }
        if ((i & 4) != 0) {
            str3 = yYCarPreviewModel.color_id;
        }
        if ((i & 8) != 0) {
            str4 = yYCarPreviewModel.name;
        }
        if ((i & 16) != 0) {
            str5 = yYCarPreviewModel.special_effects;
        }
        if ((i & 32) != 0) {
            str6 = yYCarPreviewModel.image;
        }
        if ((i & 64) != 0) {
            str7 = yYCarPreviewModel.icon;
        }
        if ((i & 128) != 0) {
            str8 = yYCarPreviewModel.beans;
        }
        return yYCarPreviewModel.copy(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.skin_id;
    }

    public final String component3() {
        return this.color_id;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.special_effects;
    }

    public final String component6() {
        return this.image;
    }

    public final String component7() {
        return this.icon;
    }

    public final String component8() {
        return this.beans;
    }

    public final YYCarPreviewModel copy(String id, String skin_id, String color_id, String name, String special_effects, String image, String icon, String beans) {
        Intrinsics.e(id, "id");
        Intrinsics.e(skin_id, "skin_id");
        Intrinsics.e(color_id, "color_id");
        Intrinsics.e(name, "name");
        Intrinsics.e(special_effects, "special_effects");
        Intrinsics.e(image, "image");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(beans, "beans");
        return new YYCarPreviewModel(id, skin_id, color_id, name, special_effects, image, icon, beans);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYCarPreviewModel) {
            YYCarPreviewModel yYCarPreviewModel = (YYCarPreviewModel) obj;
            return Intrinsics.a((Object) this.id, (Object) yYCarPreviewModel.id) && Intrinsics.a((Object) this.skin_id, (Object) yYCarPreviewModel.skin_id) && Intrinsics.a((Object) this.color_id, (Object) yYCarPreviewModel.color_id) && Intrinsics.a((Object) this.name, (Object) yYCarPreviewModel.name) && Intrinsics.a((Object) this.special_effects, (Object) yYCarPreviewModel.special_effects) && Intrinsics.a((Object) this.image, (Object) yYCarPreviewModel.image) && Intrinsics.a((Object) this.icon, (Object) yYCarPreviewModel.icon) && Intrinsics.a((Object) this.beans, (Object) yYCarPreviewModel.beans);
        }
        return false;
    }

    public final String getBeans() {
        return this.beans;
    }

    public final String getColor_id() {
        return this.color_id;
    }

    public final String getIcon() {
        return this.icon;
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

    public final String getSkin_id() {
        return this.skin_id;
    }

    public final String getSpecial_effects() {
        return this.special_effects;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.skin_id.hashCode()) * 31) + this.color_id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.special_effects.hashCode()) * 31) + this.image.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.beans.hashCode();
    }

    public String toString() {
        return "YYCarPreviewModel(id=" + this.id + ", skin_id=" + this.skin_id + ", color_id=" + this.color_id + ", name=" + this.name + ", special_effects=" + this.special_effects + ", image=" + this.image + ", icon=" + this.icon + ", beans=" + this.beans + ')';
    }
}
