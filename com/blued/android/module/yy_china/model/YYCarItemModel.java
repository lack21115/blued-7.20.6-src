package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCarItemModel.class */
public final class YYCarItemModel {
    private String beans;
    private final String icon;
    private final String id;
    private final String image;
    private final String name;
    private String name_selected_icon;
    private String name_un_selected_icon;
    private boolean selected;

    public YYCarItemModel(String id, String name, String image, String icon, String beans, String name_selected_icon, String name_un_selected_icon, boolean z) {
        Intrinsics.e(id, "id");
        Intrinsics.e(name, "name");
        Intrinsics.e(image, "image");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(beans, "beans");
        Intrinsics.e(name_selected_icon, "name_selected_icon");
        Intrinsics.e(name_un_selected_icon, "name_un_selected_icon");
        this.id = id;
        this.name = name;
        this.image = image;
        this.icon = icon;
        this.beans = beans;
        this.name_selected_icon = name_selected_icon;
        this.name_un_selected_icon = name_un_selected_icon;
        this.selected = z;
    }

    public static /* synthetic */ YYCarItemModel copy$default(YYCarItemModel yYCarItemModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYCarItemModel.id;
        }
        if ((i & 2) != 0) {
            str2 = yYCarItemModel.name;
        }
        if ((i & 4) != 0) {
            str3 = yYCarItemModel.image;
        }
        if ((i & 8) != 0) {
            str4 = yYCarItemModel.icon;
        }
        if ((i & 16) != 0) {
            str5 = yYCarItemModel.beans;
        }
        if ((i & 32) != 0) {
            str6 = yYCarItemModel.name_selected_icon;
        }
        if ((i & 64) != 0) {
            str7 = yYCarItemModel.name_un_selected_icon;
        }
        if ((i & 128) != 0) {
            z = yYCarItemModel.selected;
        }
        return yYCarItemModel.copy(str, str2, str3, str4, str5, str6, str7, z);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.beans;
    }

    public final String component6() {
        return this.name_selected_icon;
    }

    public final String component7() {
        return this.name_un_selected_icon;
    }

    public final boolean component8() {
        return this.selected;
    }

    public final YYCarItemModel copy(String id, String name, String image, String icon, String beans, String name_selected_icon, String name_un_selected_icon, boolean z) {
        Intrinsics.e(id, "id");
        Intrinsics.e(name, "name");
        Intrinsics.e(image, "image");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(beans, "beans");
        Intrinsics.e(name_selected_icon, "name_selected_icon");
        Intrinsics.e(name_un_selected_icon, "name_un_selected_icon");
        return new YYCarItemModel(id, name, image, icon, beans, name_selected_icon, name_un_selected_icon, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYCarItemModel) {
            YYCarItemModel yYCarItemModel = (YYCarItemModel) obj;
            return Intrinsics.a((Object) this.id, (Object) yYCarItemModel.id) && Intrinsics.a((Object) this.name, (Object) yYCarItemModel.name) && Intrinsics.a((Object) this.image, (Object) yYCarItemModel.image) && Intrinsics.a((Object) this.icon, (Object) yYCarItemModel.icon) && Intrinsics.a((Object) this.beans, (Object) yYCarItemModel.beans) && Intrinsics.a((Object) this.name_selected_icon, (Object) yYCarItemModel.name_selected_icon) && Intrinsics.a((Object) this.name_un_selected_icon, (Object) yYCarItemModel.name_un_selected_icon) && this.selected == yYCarItemModel.selected;
        }
        return false;
    }

    public final String getBeans() {
        return this.beans;
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

    public final String getName_selected_icon() {
        return this.name_selected_icon;
    }

    public final String getName_un_selected_icon() {
        return this.name_un_selected_icon;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void setBeans(String str) {
        Intrinsics.e(str, "<set-?>");
        this.beans = str;
    }

    public final void setName_selected_icon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name_selected_icon = str;
    }

    public final void setName_un_selected_icon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name_un_selected_icon = str;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public String toString() {
        return "YYCarItemModel(id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", icon=" + this.icon + ", beans=" + this.beans + ", name_selected_icon=" + this.name_selected_icon + ", name_un_selected_icon=" + this.name_un_selected_icon + ", selected=" + this.selected + ')';
    }
}
