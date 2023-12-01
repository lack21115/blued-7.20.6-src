package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveVipUpgradeModel.class */
public final class LiveVipUpgradeModel implements Serializable {
    private String url;
    private String vip_frame;
    private int vip_level;
    private String wechat;

    public LiveVipUpgradeModel() {
        this(null, null, 0, null, 15, null);
    }

    public LiveVipUpgradeModel(String str, String str2, int i, String str3) {
        this.wechat = str;
        this.url = str2;
        this.vip_level = i;
        this.vip_frame = str3;
    }

    public /* synthetic */ LiveVipUpgradeModel(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3);
    }

    public static /* synthetic */ LiveVipUpgradeModel copy$default(LiveVipUpgradeModel liveVipUpgradeModel, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = liveVipUpgradeModel.wechat;
        }
        if ((i2 & 2) != 0) {
            str2 = liveVipUpgradeModel.url;
        }
        if ((i2 & 4) != 0) {
            i = liveVipUpgradeModel.vip_level;
        }
        if ((i2 & 8) != 0) {
            str3 = liveVipUpgradeModel.vip_frame;
        }
        return liveVipUpgradeModel.copy(str, str2, i, str3);
    }

    public final String component1() {
        return this.wechat;
    }

    public final String component2() {
        return this.url;
    }

    public final int component3() {
        return this.vip_level;
    }

    public final String component4() {
        return this.vip_frame;
    }

    public final LiveVipUpgradeModel copy(String str, String str2, int i, String str3) {
        return new LiveVipUpgradeModel(str, str2, i, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveVipUpgradeModel) {
            LiveVipUpgradeModel liveVipUpgradeModel = (LiveVipUpgradeModel) obj;
            return Intrinsics.a((Object) this.wechat, (Object) liveVipUpgradeModel.wechat) && Intrinsics.a((Object) this.url, (Object) liveVipUpgradeModel.url) && this.vip_level == liveVipUpgradeModel.vip_level && Intrinsics.a((Object) this.vip_frame, (Object) liveVipUpgradeModel.vip_frame);
        }
        return false;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVip_frame() {
        return this.vip_frame;
    }

    public final int getVip_level() {
        return this.vip_level;
    }

    public final String getWechat() {
        return this.wechat;
    }

    public int hashCode() {
        String str = this.wechat;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.url;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        int i2 = this.vip_level;
        String str3 = this.vip_frame;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return (((((hashCode * 31) + hashCode2) * 31) + i2) * 31) + i;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setVip_frame(String str) {
        this.vip_frame = str;
    }

    public final void setVip_level(int i) {
        this.vip_level = i;
    }

    public final void setWechat(String str) {
        this.wechat = str;
    }

    public String toString() {
        return "LiveVipUpgradeModel(wechat=" + ((Object) this.wechat) + ", url=" + ((Object) this.url) + ", vip_level=" + this.vip_level + ", vip_frame=" + ((Object) this.vip_frame) + ')';
    }
}
