package com.soft.blued.log.track;

import android.util.Log;
import com.blued.ad.ADConstants;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import com.soft.blued.utils.third.BluedFingerPrintUtils;
import com.soft.blued.utils.third.YouMengUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackLoginAndRegister.class */
public class EventTrackLoginAndRegister {
    public static int a(BluedADExtra bluedADExtra) {
        if (bluedADExtra.bannerPosition != null) {
            if (bluedADExtra.bannerPosition.ordinal() == ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER.ordinal()) {
                return 2;
            }
            return bluedADExtra.bannerPosition.ordinal() == ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER.ordinal() ? 3 : 0;
        }
        return 0;
    }

    public static void a(LoginAndRegisterProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, BluedADExtra bluedADExtra) {
        if (event == null || bluedADExtra == null) {
            return;
        }
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder event2 = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event);
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder id = event2.setId(b(bluedADExtra.ads_id + ""));
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder reqId = id.setType(b(bluedADExtra.adms_type + "")).setThirdId(b(bluedADExtra.third_id)).setPositionCode(b(bluedADExtra.position_code)).setReqId(b(bluedADExtra.request_id));
        EventTrackUtils.a(reqId.setLayout(a(bluedADExtra) + "").build());
    }

    public static void a(LoginAndRegisterProtos.Event event, BluedADExtra bluedADExtra, String str, String str2) {
        if (event == null || bluedADExtra == null) {
            return;
        }
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder event2 = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event);
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder id = event2.setId(b(bluedADExtra.ads_id + ""));
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder code = id.setType(b(bluedADExtra.adms_type + "")).setThirdId(b(bluedADExtra.third_id)).setPositionCode(b(bluedADExtra.position_code)).setReqId(b(bluedADExtra.request_id)).setReason(b(str)).setCode(b(str2));
        EventTrackUtils.a(code.setLayout(a(bluedADExtra) + "").build());
    }

    public static void a(LoginAndRegisterProtos.Event event, LoginAndRegisterProtos.LabelType labelType, LoginAndRegisterProtos.LabelStatus labelStatus) {
        if (event == null || labelType == null || labelStatus == null) {
            return;
        }
        EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setLabelType(labelType).setLabelStatus(labelStatus).build());
    }

    public static void a(LoginAndRegisterProtos.Event event, LoginAndRegisterProtos.RoleType roleType) {
        if (event == null || roleType == null) {
            return;
        }
        EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setRoleType(roleType).build());
    }

    public static void a(LoginAndRegisterProtos.Event event, LoginAndRegisterProtos.Source source) {
        a(event, source, "");
    }

    public static void a(LoginAndRegisterProtos.Event event, LoginAndRegisterProtos.Source source, String str) {
        if (event != null) {
            LoginAndRegisterProtos.LoginAndRegisterProto.Builder event2 = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event);
            LoginAndRegisterProtos.Source source2 = source;
            if (source == null) {
                source2 = LoginAndRegisterProtos.Source.UNKNOWN_SOURCE;
            }
            EventTrackUtils.a(event2.setSource(source2).build());
            if (event == LoginAndRegisterProtos.Event.REGISTER_SUCCESS) {
                BluedFingerPrintUtils.a(2, str);
            } else if (event == LoginAndRegisterProtos.Event.LOGIN_SUCCESS) {
                BluedFingerPrintUtils.a(1, str);
            }
            YouMengUtils.a(UserInfo.getInstance().getLoginUserInfo().uid);
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, LoginAndRegisterProtos.UnitType unitType) {
        if (event == null || unitType == null) {
            return;
        }
        EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setUnitType(unitType).build());
    }

    public static void a(LoginAndRegisterProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(b(str)).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setReqId(b(str)).setCode(b(str2)).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setSpeed(b(str)).setAngle(b(str2)).setOpDuration(b(str3)).build());
        }
    }

    public static void a(LoginAndRegisterProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(b(str)).setPositionCode(b(str3)).setType(b(str2)).setReqId(b(str4)).build());
        }
    }

    public static void a(String str) {
        EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(LoginAndRegisterProtos.Event.HW_CHANNEL_DATA).setJson(b(str)).build());
    }

    private static String b(String str) {
        return EventTrackUtils.a(str);
    }

    public static void b(LoginAndRegisterProtos.Event event, BluedADExtra bluedADExtra) {
        if (event == null || bluedADExtra == null) {
            return;
        }
        Log.v("drb", "广告返回成功埋点 requestId:" + bluedADExtra.request_id);
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder event2 = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event);
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder id = event2.setId(b(bluedADExtra.ads_id + ""));
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder reqId = id.setType(b(bluedADExtra.adms_type + "")).setThirdId(b(bluedADExtra.third_id)).setPositionCode(b(bluedADExtra.position_code)).setPrice(bluedADExtra.price).setReqId(b(bluedADExtra.request_id));
        EventTrackUtils.a(reqId.setLayout(a(bluedADExtra) + "").build());
    }

    public static void b(LoginAndRegisterProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setReqId(b(str)).build());
        }
    }

    public static void b(LoginAndRegisterProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(b(str)).setType(b(str2)).build());
        }
    }

    public static void b(LoginAndRegisterProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(b(str)).setType(b(str2)).setPosition(b(str3)).build());
        }
    }

    public static void b(LoginAndRegisterProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(b(str)).setReason(b(str2)).setCode(b(str3)).setType(b(str4)).build());
        }
    }

    public static void c(LoginAndRegisterProtos.Event event, BluedADExtra bluedADExtra) {
        if (event == null || bluedADExtra == null) {
            return;
        }
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder event2 = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event);
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder id = event2.setId(b(bluedADExtra.ads_id + ""));
        EventTrackUtils.a(id.setType(b(bluedADExtra.adms_type + "")).setThirdId(b(bluedADExtra.third_id)).setPositionCode(b(bluedADExtra.position_code)).setReqId(b(bluedADExtra.request_id)).build());
    }

    public static void c(LoginAndRegisterProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(b(str)).build());
        }
    }

    public static void c(LoginAndRegisterProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setId(b(str)).setType(b(str2)).setPosition(b(str3)).setCode(b(str4)).build());
        }
    }

    public static void d(LoginAndRegisterProtos.Event event, BluedADExtra bluedADExtra) {
        if (event == null || bluedADExtra == null) {
            return;
        }
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder event2 = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event);
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder id = event2.setId(b(bluedADExtra.ads_id + ""));
        EventTrackUtils.a(id.setType(b(bluedADExtra.adms_type + "")).setThirdId(b(bluedADExtra.third_id)).setPositionCode(b(bluedADExtra.position_code)).setReqId(b(bluedADExtra.request_id)).setPrice(bluedADExtra.price).build());
    }

    public static void e(LoginAndRegisterProtos.Event event, BluedADExtra bluedADExtra) {
        if (event == null || bluedADExtra == null) {
            return;
        }
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder event2 = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event);
        LoginAndRegisterProtos.LoginAndRegisterProto.Builder id = event2.setId(b(bluedADExtra.ads_id + ""));
        EventTrackUtils.a(id.setType(b(bluedADExtra.adms_type + "")).setThirdId(b(bluedADExtra.third_id)).setPositionCode(b(bluedADExtra.position_code)).setReqId(b(bluedADExtra.request_id)).build());
    }
}
