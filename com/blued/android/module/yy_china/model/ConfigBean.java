package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ConfigBean.class */
public final class ConfigBean {
    private final String avatar;
    private final String base;
    private final String color;
    private final String sign;

    public ConfigBean(String sign, String avatar, String base, String color) {
        Intrinsics.e(sign, "sign");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(base, "base");
        Intrinsics.e(color, "color");
        this.sign = sign;
        this.avatar = avatar;
        this.base = base;
        this.color = color;
    }

    public static /* synthetic */ ConfigBean copy$default(ConfigBean configBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = configBean.sign;
        }
        if ((i & 2) != 0) {
            str2 = configBean.avatar;
        }
        if ((i & 4) != 0) {
            str3 = configBean.base;
        }
        if ((i & 8) != 0) {
            str4 = configBean.color;
        }
        return configBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.sign;
    }

    public final String component2() {
        return this.avatar;
    }

    public final String component3() {
        return this.base;
    }

    public final String component4() {
        return this.color;
    }

    public final ConfigBean copy(String sign, String avatar, String base, String color) {
        Intrinsics.e(sign, "sign");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(base, "base");
        Intrinsics.e(color, "color");
        return new ConfigBean(sign, avatar, base, color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfigBean) {
            ConfigBean configBean = (ConfigBean) obj;
            return Intrinsics.a((Object) this.sign, (Object) configBean.sign) && Intrinsics.a((Object) this.avatar, (Object) configBean.avatar) && Intrinsics.a((Object) this.base, (Object) configBean.base) && Intrinsics.a((Object) this.color, (Object) configBean.color);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBase() {
        return this.base;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getSign() {
        return this.sign;
    }

    public int hashCode() {
        return (((((this.sign.hashCode() * 31) + this.avatar.hashCode()) * 31) + this.base.hashCode()) * 31) + this.color.hashCode();
    }

    public String toString() {
        return "ConfigBean(sign=" + this.sign + ", avatar=" + this.avatar + ", base=" + this.base + ", color=" + this.color + ')';
    }
}
