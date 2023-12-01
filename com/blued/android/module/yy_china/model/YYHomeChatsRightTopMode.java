package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYHomeChatsRightTopMode.class */
public final class YYHomeChatsRightTopMode {
    private final String background_image;
    private final int frequency_seconds;
    private boolean isDrwa;
    private final String link;
    private final int position;
    private final ArrayList<String> sub_title;
    private final String title;

    public YYHomeChatsRightTopMode(boolean z, int i, String title, String background_image, int i2, String link, ArrayList<String> sub_title) {
        Intrinsics.e(title, "title");
        Intrinsics.e(background_image, "background_image");
        Intrinsics.e(link, "link");
        Intrinsics.e(sub_title, "sub_title");
        this.isDrwa = z;
        this.position = i;
        this.title = title;
        this.background_image = background_image;
        this.frequency_seconds = i2;
        this.link = link;
        this.sub_title = sub_title;
    }

    public /* synthetic */ YYHomeChatsRightTopMode(boolean z, int i, String str, String str2, int i2, String str3, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, i, str, str2, i2, str3, arrayList);
    }

    public static /* synthetic */ YYHomeChatsRightTopMode copy$default(YYHomeChatsRightTopMode yYHomeChatsRightTopMode, boolean z, int i, String str, String str2, int i2, String str3, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = yYHomeChatsRightTopMode.isDrwa;
        }
        if ((i3 & 2) != 0) {
            i = yYHomeChatsRightTopMode.position;
        }
        if ((i3 & 4) != 0) {
            str = yYHomeChatsRightTopMode.title;
        }
        if ((i3 & 8) != 0) {
            str2 = yYHomeChatsRightTopMode.background_image;
        }
        if ((i3 & 16) != 0) {
            i2 = yYHomeChatsRightTopMode.frequency_seconds;
        }
        if ((i3 & 32) != 0) {
            str3 = yYHomeChatsRightTopMode.link;
        }
        if ((i3 & 64) != 0) {
            arrayList = yYHomeChatsRightTopMode.sub_title;
        }
        return yYHomeChatsRightTopMode.copy(z, i, str, str2, i2, str3, arrayList);
    }

    public final boolean component1() {
        return this.isDrwa;
    }

    public final int component2() {
        return this.position;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.background_image;
    }

    public final int component5() {
        return this.frequency_seconds;
    }

    public final String component6() {
        return this.link;
    }

    public final ArrayList<String> component7() {
        return this.sub_title;
    }

    public final YYHomeChatsRightTopMode copy(boolean z, int i, String title, String background_image, int i2, String link, ArrayList<String> sub_title) {
        Intrinsics.e(title, "title");
        Intrinsics.e(background_image, "background_image");
        Intrinsics.e(link, "link");
        Intrinsics.e(sub_title, "sub_title");
        return new YYHomeChatsRightTopMode(z, i, title, background_image, i2, link, sub_title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYHomeChatsRightTopMode) {
            YYHomeChatsRightTopMode yYHomeChatsRightTopMode = (YYHomeChatsRightTopMode) obj;
            return this.isDrwa == yYHomeChatsRightTopMode.isDrwa && this.position == yYHomeChatsRightTopMode.position && Intrinsics.a((Object) this.title, (Object) yYHomeChatsRightTopMode.title) && Intrinsics.a((Object) this.background_image, (Object) yYHomeChatsRightTopMode.background_image) && this.frequency_seconds == yYHomeChatsRightTopMode.frequency_seconds && Intrinsics.a((Object) this.link, (Object) yYHomeChatsRightTopMode.link) && Intrinsics.a(this.sub_title, yYHomeChatsRightTopMode.sub_title);
        }
        return false;
    }

    public final String getBackground_image() {
        return this.background_image;
    }

    public final int getFrequency_seconds() {
        return this.frequency_seconds;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getPosition() {
        return this.position;
    }

    public final ArrayList<String> getSub_title() {
        return this.sub_title;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final boolean isDrwa() {
        return this.isDrwa;
    }

    public final void setDrwa(boolean z) {
        this.isDrwa = z;
    }

    public String toString() {
        return "YYHomeChatsRightTopMode(isDrwa=" + this.isDrwa + ", position=" + this.position + ", title=" + this.title + ", background_image=" + this.background_image + ", frequency_seconds=" + this.frequency_seconds + ", link=" + this.link + ", sub_title=" + this.sub_title + ')';
    }
}
