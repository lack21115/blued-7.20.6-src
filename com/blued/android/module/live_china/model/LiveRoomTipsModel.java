package com.blued.android.module.live_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomTipsModel.class */
public final class LiveRoomTipsModel {
    private ArrayList<String> colors;
    private int countdown;
    private int direction;
    private String icon;
    private int id;
    private String link;
    private int linkType;
    private int location;
    private int order;
    private String text;

    public LiveRoomTipsModel(int i, String icon, String text, int i2, String link, int i3, int i4, int i5, int i6, ArrayList<String> colors) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(text, "text");
        Intrinsics.e(link, "link");
        Intrinsics.e(colors, "colors");
        this.id = i;
        this.icon = icon;
        this.text = text;
        this.order = i2;
        this.link = link;
        this.linkType = i3;
        this.location = i4;
        this.direction = i5;
        this.countdown = i6;
        this.colors = colors;
    }

    public static /* synthetic */ LiveRoomTipsModel copy$default(LiveRoomTipsModel liveRoomTipsModel, int i, String str, String str2, int i2, String str3, int i3, int i4, int i5, int i6, ArrayList arrayList, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = liveRoomTipsModel.id;
        }
        if ((i7 & 2) != 0) {
            str = liveRoomTipsModel.icon;
        }
        if ((i7 & 4) != 0) {
            str2 = liveRoomTipsModel.text;
        }
        if ((i7 & 8) != 0) {
            i2 = liveRoomTipsModel.order;
        }
        if ((i7 & 16) != 0) {
            str3 = liveRoomTipsModel.link;
        }
        if ((i7 & 32) != 0) {
            i3 = liveRoomTipsModel.linkType;
        }
        if ((i7 & 64) != 0) {
            i4 = liveRoomTipsModel.location;
        }
        if ((i7 & 128) != 0) {
            i5 = liveRoomTipsModel.direction;
        }
        if ((i7 & 256) != 0) {
            i6 = liveRoomTipsModel.countdown;
        }
        if ((i7 & 512) != 0) {
            arrayList = liveRoomTipsModel.colors;
        }
        return liveRoomTipsModel.copy(i, str, str2, i2, str3, i3, i4, i5, i6, arrayList);
    }

    public final int component1() {
        return this.id;
    }

    public final ArrayList<String> component10() {
        return this.colors;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.text;
    }

    public final int component4() {
        return this.order;
    }

    public final String component5() {
        return this.link;
    }

    public final int component6() {
        return this.linkType;
    }

    public final int component7() {
        return this.location;
    }

    public final int component8() {
        return this.direction;
    }

    public final int component9() {
        return this.countdown;
    }

    public final LiveRoomTipsModel copy(int i, String icon, String text, int i2, String link, int i3, int i4, int i5, int i6, ArrayList<String> colors) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(text, "text");
        Intrinsics.e(link, "link");
        Intrinsics.e(colors, "colors");
        return new LiveRoomTipsModel(i, icon, text, i2, link, i3, i4, i5, i6, colors);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveRoomTipsModel) {
            LiveRoomTipsModel liveRoomTipsModel = (LiveRoomTipsModel) obj;
            return this.id == liveRoomTipsModel.id && Intrinsics.a((Object) this.icon, (Object) liveRoomTipsModel.icon) && Intrinsics.a((Object) this.text, (Object) liveRoomTipsModel.text) && this.order == liveRoomTipsModel.order && Intrinsics.a((Object) this.link, (Object) liveRoomTipsModel.link) && this.linkType == liveRoomTipsModel.linkType && this.location == liveRoomTipsModel.location && this.direction == liveRoomTipsModel.direction && this.countdown == liveRoomTipsModel.countdown && Intrinsics.a(this.colors, liveRoomTipsModel.colors);
        }
        return false;
    }

    public final ArrayList<String> getColors() {
        return this.colors;
    }

    public final int getCountdown() {
        return this.countdown;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getLinkType() {
        return this.linkType;
    }

    public final int getLocation() {
        return this.location;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((((((((((((((((this.id * 31) + this.icon.hashCode()) * 31) + this.text.hashCode()) * 31) + this.order) * 31) + this.link.hashCode()) * 31) + this.linkType) * 31) + this.location) * 31) + this.direction) * 31) + this.countdown) * 31) + this.colors.hashCode();
    }

    public final void setColors(ArrayList<String> arrayList) {
        Intrinsics.e(arrayList, "<set-?>");
        this.colors = arrayList;
    }

    public final void setCountdown(int i) {
        this.countdown = i;
    }

    public final void setDirection(int i) {
        this.direction = i;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLink(String str) {
        Intrinsics.e(str, "<set-?>");
        this.link = str;
    }

    public final void setLinkType(int i) {
        this.linkType = i;
    }

    public final void setLocation(int i) {
        this.location = i;
    }

    public final void setOrder(int i) {
        this.order = i;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text = str;
    }

    public String toString() {
        return "LiveRoomTipsModel(id=" + this.id + ", icon='" + this.icon + "', text='" + this.text + "', order=" + this.order + ", link='" + this.link + "', linkType=" + this.linkType + ", location=" + this.location + ", direction=" + this.direction + ", countdown=" + this.countdown + ", colors=" + this.colors + ')';
    }
}
