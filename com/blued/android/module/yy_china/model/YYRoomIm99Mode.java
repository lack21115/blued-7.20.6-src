package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomIm99Mode.class */
public final class YYRoomIm99Mode {
    private final YYRoomBasicPropItemMode speech_ripple;
    private final ArrayList<YYRoomBasicPropItemMode> title;
    private final String type;

    public YYRoomIm99Mode(String type, YYRoomBasicPropItemMode speech_ripple, ArrayList<YYRoomBasicPropItemMode> title) {
        Intrinsics.e(type, "type");
        Intrinsics.e(speech_ripple, "speech_ripple");
        Intrinsics.e(title, "title");
        this.type = type;
        this.speech_ripple = speech_ripple;
        this.title = title;
    }

    public static /* synthetic */ YYRoomIm99Mode copy$default(YYRoomIm99Mode yYRoomIm99Mode, String str, YYRoomBasicPropItemMode yYRoomBasicPropItemMode, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRoomIm99Mode.type;
        }
        if ((i & 2) != 0) {
            yYRoomBasicPropItemMode = yYRoomIm99Mode.speech_ripple;
        }
        if ((i & 4) != 0) {
            arrayList = yYRoomIm99Mode.title;
        }
        return yYRoomIm99Mode.copy(str, yYRoomBasicPropItemMode, arrayList);
    }

    public final String component1() {
        return this.type;
    }

    public final YYRoomBasicPropItemMode component2() {
        return this.speech_ripple;
    }

    public final ArrayList<YYRoomBasicPropItemMode> component3() {
        return this.title;
    }

    public final YYRoomIm99Mode copy(String type, YYRoomBasicPropItemMode speech_ripple, ArrayList<YYRoomBasicPropItemMode> title) {
        Intrinsics.e(type, "type");
        Intrinsics.e(speech_ripple, "speech_ripple");
        Intrinsics.e(title, "title");
        return new YYRoomIm99Mode(type, speech_ripple, title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRoomIm99Mode) {
            YYRoomIm99Mode yYRoomIm99Mode = (YYRoomIm99Mode) obj;
            return Intrinsics.a((Object) this.type, (Object) yYRoomIm99Mode.type) && Intrinsics.a(this.speech_ripple, yYRoomIm99Mode.speech_ripple) && Intrinsics.a(this.title, yYRoomIm99Mode.title);
        }
        return false;
    }

    public final YYRoomBasicPropItemMode getSpeech_ripple() {
        return this.speech_ripple;
    }

    public final ArrayList<YYRoomBasicPropItemMode> getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.speech_ripple.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "YYRoomIm99Mode(type=" + this.type + ", speech_ripple=" + this.speech_ripple + ", title=" + this.title + ')';
    }
}
