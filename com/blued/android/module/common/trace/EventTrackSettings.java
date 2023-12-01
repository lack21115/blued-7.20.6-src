package com.blued.android.module.common.trace;

import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.das.settings.SettingsProtos;
import com.blued.track.trackUtils.EventTrackUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/trace/EventTrackSettings.class */
public class EventTrackSettings {
    public static SettingsProtos.ModuleType a(int i, int i2) {
        return i != 0 ? i != 1 ? i != 2 ? SettingsProtos.ModuleType.COMMON_USER : i2 == 2 ? SettingsProtos.ModuleType.EXPIRE_SVIP : SettingsProtos.ModuleType.EXPIRE_VIP : i2 == 2 ? SettingsProtos.ModuleType.SVIP_USER : SettingsProtos.ModuleType.VIP_USER : SettingsProtos.ModuleType.COMMON_USER;
    }

    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(LoginAndRegisterProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(a(str)).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, String str, String str2, double d, String str3) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(a(str)).setPrice(d).setThirdId(a(str2)).setNum(Integer.parseInt(str3)).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, String str, String str2, String str3, double d, double d2, String str4) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(a(str)).setIdParent(a(str2)).setThirdId(a(str3)).setPriceSecond(d2).setPrice(d).setNum(Integer.parseInt(str4)).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, String str, String str2, String str3, String str4, double d, double d2, String str5) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(a(str)).setIdParent(a(str2)).setIdSub(a(str3)).setThirdId(a(str4)).setPriceSecond(d2).setPrice(d).setNum(Integer.parseInt(str5)).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, String str, String str2, String str3, String str4, double d, String str5) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(a(str)).setIdParent(a(str2)).setIdSub(a(str3)).setThirdId(a(str4)).setPrice(d).setNum(Integer.parseInt(str5)).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, String str, String str2, String str3, String str4, String str5) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(a(str)).setIdParent(a(str2)).setIdSub(a(str3)).setThirdId(a(str4)).setNum(Integer.parseInt(str5)).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, String str, String str2, String str3, String str4, String str5, String str6) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(a(str)).setIdParent(a(str2)).setIdSub(a(str3)).setThirdId(a(str4)).setCode(a(str6)).setNum(Integer.parseInt(str5)).build());
        }
    }

    public static void a(SettingsProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(SettingsProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setNum(i).build());
        }
    }

    public static void a(SettingsProtos.Event event, SettingsProtos.ModuleType moduleType) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setModuleType(moduleType).build());
        }
    }

    public static void a(SettingsProtos.Event event, SettingsProtos.ModuleType moduleType, String str, String str2, boolean z) {
        if (event == null || moduleType == null) {
            return;
        }
        EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setModuleType(moduleType).setLinkUrl(a(str)).setBannerId(a(str2)).setIsShadow(z).build());
    }

    public static void a(SettingsProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setLinkUrl(a(str)).build());
        }
    }

    public static void a(SettingsProtos.Event event, String str, int i) {
        if (event == null || str == null) {
            return;
        }
        EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setLinkUrl(a(str)).setNum(i).build());
    }

    public static void a(SettingsProtos.Event event, String str, String str2, boolean z) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setLinkUrl(a(str)).setBannerId(a(str2)).setIsShadow(z).build());
        }
    }

    public static void a(SettingsProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setIsOpen(z).setEvent(event).build());
        }
    }

    public static void b(SettingsProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setPosition(i).build());
        }
    }

    public static void b(SettingsProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setName(a(str)).build());
        }
    }

    public static void b(SettingsProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setIsOpen(z).build());
        }
    }

    public static void c(SettingsProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setFrom(i).build());
        }
    }

    public static void c(SettingsProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(SettingsProtos.SettingsProto.newBuilder().setEvent(event).setIsAuto(z).build());
        }
    }
}
