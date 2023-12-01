package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveOnlineUserEntityExtra.class */
public final class LiveOnlineUserEntityExtra extends BluedEntityBaseExtra {
    private LiveOnLineBehalfExtra behalf;
    private int count;
    private String footer_desc;
    private int index;
    private final String noble_title;
    private int size;
    private String title;

    public LiveOnlineUserEntityExtra(String title, String noble_title, int i, int i2, int i3, String footer_desc, LiveOnLineBehalfExtra behalf) {
        Intrinsics.e(title, "title");
        Intrinsics.e(noble_title, "noble_title");
        Intrinsics.e(footer_desc, "footer_desc");
        Intrinsics.e(behalf, "behalf");
        this.title = title;
        this.noble_title = noble_title;
        this.count = i;
        this.index = i2;
        this.size = i3;
        this.footer_desc = footer_desc;
        this.behalf = behalf;
    }

    public static /* synthetic */ LiveOnlineUserEntityExtra copy$default(LiveOnlineUserEntityExtra liveOnlineUserEntityExtra, String str, String str2, int i, int i2, int i3, String str3, LiveOnLineBehalfExtra liveOnLineBehalfExtra, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = liveOnlineUserEntityExtra.title;
        }
        if ((i4 & 2) != 0) {
            str2 = liveOnlineUserEntityExtra.noble_title;
        }
        if ((i4 & 4) != 0) {
            i = liveOnlineUserEntityExtra.count;
        }
        if ((i4 & 8) != 0) {
            i2 = liveOnlineUserEntityExtra.index;
        }
        if ((i4 & 16) != 0) {
            i3 = liveOnlineUserEntityExtra.size;
        }
        if ((i4 & 32) != 0) {
            str3 = liveOnlineUserEntityExtra.footer_desc;
        }
        if ((i4 & 64) != 0) {
            liveOnLineBehalfExtra = liveOnlineUserEntityExtra.behalf;
        }
        return liveOnlineUserEntityExtra.copy(str, str2, i, i2, i3, str3, liveOnLineBehalfExtra);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.noble_title;
    }

    public final int component3() {
        return this.count;
    }

    public final int component4() {
        return this.index;
    }

    public final int component5() {
        return this.size;
    }

    public final String component6() {
        return this.footer_desc;
    }

    public final LiveOnLineBehalfExtra component7() {
        return this.behalf;
    }

    public final LiveOnlineUserEntityExtra copy(String title, String noble_title, int i, int i2, int i3, String footer_desc, LiveOnLineBehalfExtra behalf) {
        Intrinsics.e(title, "title");
        Intrinsics.e(noble_title, "noble_title");
        Intrinsics.e(footer_desc, "footer_desc");
        Intrinsics.e(behalf, "behalf");
        return new LiveOnlineUserEntityExtra(title, noble_title, i, i2, i3, footer_desc, behalf);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveOnlineUserEntityExtra) {
            LiveOnlineUserEntityExtra liveOnlineUserEntityExtra = (LiveOnlineUserEntityExtra) obj;
            return Intrinsics.a((Object) this.title, (Object) liveOnlineUserEntityExtra.title) && Intrinsics.a((Object) this.noble_title, (Object) liveOnlineUserEntityExtra.noble_title) && this.count == liveOnlineUserEntityExtra.count && this.index == liveOnlineUserEntityExtra.index && this.size == liveOnlineUserEntityExtra.size && Intrinsics.a((Object) this.footer_desc, (Object) liveOnlineUserEntityExtra.footer_desc) && Intrinsics.a(this.behalf, liveOnlineUserEntityExtra.behalf);
        }
        return false;
    }

    public final LiveOnLineBehalfExtra getBehalf() {
        return this.behalf;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getFooter_desc() {
        return this.footer_desc;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getNoble_title() {
        return this.noble_title;
    }

    public final int getSize() {
        return this.size;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((this.title.hashCode() * 31) + this.noble_title.hashCode()) * 31) + this.count) * 31) + this.index) * 31) + this.size) * 31) + this.footer_desc.hashCode()) * 31) + this.behalf.hashCode();
    }

    public final void setBehalf(LiveOnLineBehalfExtra liveOnLineBehalfExtra) {
        Intrinsics.e(liveOnLineBehalfExtra, "<set-?>");
        this.behalf = liveOnLineBehalfExtra;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setFooter_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.footer_desc = str;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "LiveOnlineUserEntityExtra(title=" + this.title + ", noble_title=" + this.noble_title + ", count=" + this.count + ", index=" + this.index + ", size=" + this.size + ", footer_desc=" + this.footer_desc + ", behalf=" + this.behalf + ')';
    }
}
