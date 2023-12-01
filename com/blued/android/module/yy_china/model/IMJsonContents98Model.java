package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents98Model.class */
public final class IMJsonContents98Model {
    private final long countdown;
    private final String icon;
    private final String link;
    private final String multiple;

    public IMJsonContents98Model(String icon, String link, String multiple, long j) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(link, "link");
        Intrinsics.e(multiple, "multiple");
        this.icon = icon;
        this.link = link;
        this.multiple = multiple;
        this.countdown = j;
    }

    public static /* synthetic */ IMJsonContents98Model copy$default(IMJsonContents98Model iMJsonContents98Model, String str, String str2, String str3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iMJsonContents98Model.icon;
        }
        if ((i & 2) != 0) {
            str2 = iMJsonContents98Model.link;
        }
        if ((i & 4) != 0) {
            str3 = iMJsonContents98Model.multiple;
        }
        if ((i & 8) != 0) {
            j = iMJsonContents98Model.countdown;
        }
        return iMJsonContents98Model.copy(str, str2, str3, j);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.link;
    }

    public final String component3() {
        return this.multiple;
    }

    public final long component4() {
        return this.countdown;
    }

    public final IMJsonContents98Model copy(String icon, String link, String multiple, long j) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(link, "link");
        Intrinsics.e(multiple, "multiple");
        return new IMJsonContents98Model(icon, link, multiple, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents98Model) {
            IMJsonContents98Model iMJsonContents98Model = (IMJsonContents98Model) obj;
            return Intrinsics.a((Object) this.icon, (Object) iMJsonContents98Model.icon) && Intrinsics.a((Object) this.link, (Object) iMJsonContents98Model.link) && Intrinsics.a((Object) this.multiple, (Object) iMJsonContents98Model.multiple) && this.countdown == iMJsonContents98Model.countdown;
        }
        return false;
    }

    public final long getCountdown() {
        return this.countdown;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getMultiple() {
        return this.multiple;
    }

    public int hashCode() {
        return (((((this.icon.hashCode() * 31) + this.link.hashCode()) * 31) + this.multiple.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.countdown);
    }

    public String toString() {
        return "IMJsonContents98Model(icon=" + this.icon + ", link=" + this.link + ", multiple=" + this.multiple + ", countdown=" + this.countdown + ')';
    }
}
