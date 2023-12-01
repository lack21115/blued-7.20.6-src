package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYEventsThemeModel.class */
public final class YYEventsThemeModel {
    private final String activity_detail_bg;
    private final String activity_end_icon;
    private String button_color;
    private boolean checked;
    private final String float_window_bg;
    private final String preview_bg;
    private final String thanks_giving_icon;
    private final String theme_name;
    private final String theme_type_icon_gray;
    private final String theme_type_icon_light;
    private final String type_id;
    private final String winner_first;
    private final String winner_second;
    private final String winner_third;

    public YYEventsThemeModel(String type_id, String theme_name, String winner_first, String winner_second, String winner_third, String thanks_giving_icon, String theme_type_icon_gray, String theme_type_icon_light, String activity_end_icon, String activity_detail_bg, String float_window_bg, String preview_bg, String button_color, boolean z) {
        Intrinsics.e(type_id, "type_id");
        Intrinsics.e(theme_name, "theme_name");
        Intrinsics.e(winner_first, "winner_first");
        Intrinsics.e(winner_second, "winner_second");
        Intrinsics.e(winner_third, "winner_third");
        Intrinsics.e(thanks_giving_icon, "thanks_giving_icon");
        Intrinsics.e(theme_type_icon_gray, "theme_type_icon_gray");
        Intrinsics.e(theme_type_icon_light, "theme_type_icon_light");
        Intrinsics.e(activity_end_icon, "activity_end_icon");
        Intrinsics.e(activity_detail_bg, "activity_detail_bg");
        Intrinsics.e(float_window_bg, "float_window_bg");
        Intrinsics.e(preview_bg, "preview_bg");
        Intrinsics.e(button_color, "button_color");
        this.type_id = type_id;
        this.theme_name = theme_name;
        this.winner_first = winner_first;
        this.winner_second = winner_second;
        this.winner_third = winner_third;
        this.thanks_giving_icon = thanks_giving_icon;
        this.theme_type_icon_gray = theme_type_icon_gray;
        this.theme_type_icon_light = theme_type_icon_light;
        this.activity_end_icon = activity_end_icon;
        this.activity_detail_bg = activity_detail_bg;
        this.float_window_bg = float_window_bg;
        this.preview_bg = preview_bg;
        this.button_color = button_color;
        this.checked = z;
    }

    public static /* synthetic */ YYEventsThemeModel copy$default(YYEventsThemeModel yYEventsThemeModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYEventsThemeModel.type_id;
        }
        if ((i & 2) != 0) {
            str2 = yYEventsThemeModel.theme_name;
        }
        if ((i & 4) != 0) {
            str3 = yYEventsThemeModel.winner_first;
        }
        if ((i & 8) != 0) {
            str4 = yYEventsThemeModel.winner_second;
        }
        if ((i & 16) != 0) {
            str5 = yYEventsThemeModel.winner_third;
        }
        if ((i & 32) != 0) {
            str6 = yYEventsThemeModel.thanks_giving_icon;
        }
        if ((i & 64) != 0) {
            str7 = yYEventsThemeModel.theme_type_icon_gray;
        }
        if ((i & 128) != 0) {
            str8 = yYEventsThemeModel.theme_type_icon_light;
        }
        if ((i & 256) != 0) {
            str9 = yYEventsThemeModel.activity_end_icon;
        }
        if ((i & 512) != 0) {
            str10 = yYEventsThemeModel.activity_detail_bg;
        }
        if ((i & 1024) != 0) {
            str11 = yYEventsThemeModel.float_window_bg;
        }
        if ((i & 2048) != 0) {
            str12 = yYEventsThemeModel.preview_bg;
        }
        if ((i & 4096) != 0) {
            str13 = yYEventsThemeModel.button_color;
        }
        if ((i & 8192) != 0) {
            z = yYEventsThemeModel.checked;
        }
        return yYEventsThemeModel.copy(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, z);
    }

    public final String component1() {
        return this.type_id;
    }

    public final String component10() {
        return this.activity_detail_bg;
    }

    public final String component11() {
        return this.float_window_bg;
    }

    public final String component12() {
        return this.preview_bg;
    }

    public final String component13() {
        return this.button_color;
    }

    public final boolean component14() {
        return this.checked;
    }

    public final String component2() {
        return this.theme_name;
    }

    public final String component3() {
        return this.winner_first;
    }

    public final String component4() {
        return this.winner_second;
    }

    public final String component5() {
        return this.winner_third;
    }

    public final String component6() {
        return this.thanks_giving_icon;
    }

    public final String component7() {
        return this.theme_type_icon_gray;
    }

    public final String component8() {
        return this.theme_type_icon_light;
    }

    public final String component9() {
        return this.activity_end_icon;
    }

    public final YYEventsThemeModel copy(String type_id, String theme_name, String winner_first, String winner_second, String winner_third, String thanks_giving_icon, String theme_type_icon_gray, String theme_type_icon_light, String activity_end_icon, String activity_detail_bg, String float_window_bg, String preview_bg, String button_color, boolean z) {
        Intrinsics.e(type_id, "type_id");
        Intrinsics.e(theme_name, "theme_name");
        Intrinsics.e(winner_first, "winner_first");
        Intrinsics.e(winner_second, "winner_second");
        Intrinsics.e(winner_third, "winner_third");
        Intrinsics.e(thanks_giving_icon, "thanks_giving_icon");
        Intrinsics.e(theme_type_icon_gray, "theme_type_icon_gray");
        Intrinsics.e(theme_type_icon_light, "theme_type_icon_light");
        Intrinsics.e(activity_end_icon, "activity_end_icon");
        Intrinsics.e(activity_detail_bg, "activity_detail_bg");
        Intrinsics.e(float_window_bg, "float_window_bg");
        Intrinsics.e(preview_bg, "preview_bg");
        Intrinsics.e(button_color, "button_color");
        return new YYEventsThemeModel(type_id, theme_name, winner_first, winner_second, winner_third, thanks_giving_icon, theme_type_icon_gray, theme_type_icon_light, activity_end_icon, activity_detail_bg, float_window_bg, preview_bg, button_color, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYEventsThemeModel) {
            YYEventsThemeModel yYEventsThemeModel = (YYEventsThemeModel) obj;
            return Intrinsics.a((Object) this.type_id, (Object) yYEventsThemeModel.type_id) && Intrinsics.a((Object) this.theme_name, (Object) yYEventsThemeModel.theme_name) && Intrinsics.a((Object) this.winner_first, (Object) yYEventsThemeModel.winner_first) && Intrinsics.a((Object) this.winner_second, (Object) yYEventsThemeModel.winner_second) && Intrinsics.a((Object) this.winner_third, (Object) yYEventsThemeModel.winner_third) && Intrinsics.a((Object) this.thanks_giving_icon, (Object) yYEventsThemeModel.thanks_giving_icon) && Intrinsics.a((Object) this.theme_type_icon_gray, (Object) yYEventsThemeModel.theme_type_icon_gray) && Intrinsics.a((Object) this.theme_type_icon_light, (Object) yYEventsThemeModel.theme_type_icon_light) && Intrinsics.a((Object) this.activity_end_icon, (Object) yYEventsThemeModel.activity_end_icon) && Intrinsics.a((Object) this.activity_detail_bg, (Object) yYEventsThemeModel.activity_detail_bg) && Intrinsics.a((Object) this.float_window_bg, (Object) yYEventsThemeModel.float_window_bg) && Intrinsics.a((Object) this.preview_bg, (Object) yYEventsThemeModel.preview_bg) && Intrinsics.a((Object) this.button_color, (Object) yYEventsThemeModel.button_color) && this.checked == yYEventsThemeModel.checked;
        }
        return false;
    }

    public final String getActivity_detail_bg() {
        return this.activity_detail_bg;
    }

    public final String getActivity_end_icon() {
        return this.activity_end_icon;
    }

    public final String getButton_color() {
        return this.button_color;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final String getFloat_window_bg() {
        return this.float_window_bg;
    }

    public final String getPreview_bg() {
        return this.preview_bg;
    }

    public final String getThanks_giving_icon() {
        return this.thanks_giving_icon;
    }

    public final String getTheme_name() {
        return this.theme_name;
    }

    public final String getTheme_type_icon_gray() {
        return this.theme_type_icon_gray;
    }

    public final String getTheme_type_icon_light() {
        return this.theme_type_icon_light;
    }

    public final String getType_id() {
        return this.type_id;
    }

    public final String getWinner_first() {
        return this.winner_first;
    }

    public final String getWinner_second() {
        return this.winner_second;
    }

    public final String getWinner_third() {
        return this.winner_third;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void setButton_color(String str) {
        Intrinsics.e(str, "<set-?>");
        this.button_color = str;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public String toString() {
        return "YYEventsThemeModel(type_id=" + this.type_id + ", theme_name=" + this.theme_name + ", winner_first=" + this.winner_first + ", winner_second=" + this.winner_second + ", winner_third=" + this.winner_third + ", thanks_giving_icon=" + this.thanks_giving_icon + ", theme_type_icon_gray=" + this.theme_type_icon_gray + ", theme_type_icon_light=" + this.theme_type_icon_light + ", activity_end_icon=" + this.activity_end_icon + ", activity_detail_bg=" + this.activity_detail_bg + ", float_window_bg=" + this.float_window_bg + ", preview_bg=" + this.preview_bg + ", button_color=" + this.button_color + ", checked=" + this.checked + ')';
    }
}
