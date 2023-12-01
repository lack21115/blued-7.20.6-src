package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RedDot.class */
public final class RedDot implements Serializable {
    private int user_pack_equips;
    private int user_pack_gifts;
    private int user_pack_props;

    public RedDot(int i, int i2, int i3) {
        this.user_pack_props = i;
        this.user_pack_gifts = i2;
        this.user_pack_equips = i3;
    }

    public static /* synthetic */ RedDot copy$default(RedDot redDot, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = redDot.user_pack_props;
        }
        if ((i4 & 2) != 0) {
            i2 = redDot.user_pack_gifts;
        }
        if ((i4 & 4) != 0) {
            i3 = redDot.user_pack_equips;
        }
        return redDot.copy(i, i2, i3);
    }

    public final int component1() {
        return this.user_pack_props;
    }

    public final int component2() {
        return this.user_pack_gifts;
    }

    public final int component3() {
        return this.user_pack_equips;
    }

    public final RedDot copy(int i, int i2, int i3) {
        return new RedDot(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RedDot) {
            RedDot redDot = (RedDot) obj;
            return this.user_pack_props == redDot.user_pack_props && this.user_pack_gifts == redDot.user_pack_gifts && this.user_pack_equips == redDot.user_pack_equips;
        }
        return false;
    }

    public final int getUser_pack_equips() {
        return this.user_pack_equips;
    }

    public final int getUser_pack_gifts() {
        return this.user_pack_gifts;
    }

    public final int getUser_pack_props() {
        return this.user_pack_props;
    }

    public int hashCode() {
        return (((this.user_pack_props * 31) + this.user_pack_gifts) * 31) + this.user_pack_equips;
    }

    public final void setUser_pack_equips(int i) {
        this.user_pack_equips = i;
    }

    public final void setUser_pack_gifts(int i) {
        this.user_pack_gifts = i;
    }

    public final void setUser_pack_props(int i) {
        this.user_pack_props = i;
    }

    public String toString() {
        return "RedDot(user_pack_props=" + this.user_pack_props + ", user_pack_gifts=" + this.user_pack_gifts + ", user_pack_equips=" + this.user_pack_equips + ')';
    }
}
