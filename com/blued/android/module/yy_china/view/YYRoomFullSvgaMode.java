package com.blued.android.module.yy_china.view;

import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRoomFullSvgaMode.class */
public final class YYRoomFullSvgaMode {
    private final SVGADynamicEntity svgaDynamic;
    private final int type;
    private final String url;

    public YYRoomFullSvgaMode(String url, SVGADynamicEntity sVGADynamicEntity, int i) {
        Intrinsics.e(url, "url");
        this.url = url;
        this.svgaDynamic = sVGADynamicEntity;
        this.type = i;
    }

    public static /* synthetic */ YYRoomFullSvgaMode copy$default(YYRoomFullSvgaMode yYRoomFullSvgaMode, String str, SVGADynamicEntity sVGADynamicEntity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yYRoomFullSvgaMode.url;
        }
        if ((i2 & 2) != 0) {
            sVGADynamicEntity = yYRoomFullSvgaMode.svgaDynamic;
        }
        if ((i2 & 4) != 0) {
            i = yYRoomFullSvgaMode.type;
        }
        return yYRoomFullSvgaMode.copy(str, sVGADynamicEntity, i);
    }

    public final String component1() {
        return this.url;
    }

    public final SVGADynamicEntity component2() {
        return this.svgaDynamic;
    }

    public final int component3() {
        return this.type;
    }

    public final YYRoomFullSvgaMode copy(String url, SVGADynamicEntity sVGADynamicEntity, int i) {
        Intrinsics.e(url, "url");
        return new YYRoomFullSvgaMode(url, sVGADynamicEntity, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRoomFullSvgaMode) {
            YYRoomFullSvgaMode yYRoomFullSvgaMode = (YYRoomFullSvgaMode) obj;
            return Intrinsics.a((Object) this.url, (Object) yYRoomFullSvgaMode.url) && Intrinsics.a(this.svgaDynamic, yYRoomFullSvgaMode.svgaDynamic) && this.type == yYRoomFullSvgaMode.type;
        }
        return false;
    }

    public final SVGADynamicEntity getSvgaDynamic() {
        return this.svgaDynamic;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.url.hashCode();
        SVGADynamicEntity sVGADynamicEntity = this.svgaDynamic;
        return (((hashCode * 31) + (sVGADynamicEntity == null ? 0 : sVGADynamicEntity.hashCode())) * 31) + this.type;
    }

    public String toString() {
        return "YYRoomFullSvgaMode(url=" + this.url + ", svgaDynamic=" + this.svgaDynamic + ", type=" + this.type + ')';
    }
}
