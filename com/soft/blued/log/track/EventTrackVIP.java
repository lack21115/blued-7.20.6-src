package com.soft.blued.log.track;

import com.blued.ad.ADConstants;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.das.vip.VipProtos;
import com.blued.track.trackUtils.EventTrackUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackVIP.class */
public class EventTrackVIP {

    /* renamed from: com.soft.blued.log.track.EventTrackVIP$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackVIP$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f29693a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[ADConstants.AD_POSITION.values().length];
            f29693a = iArr;
            try {
                iArr[ADConstants.AD_POSITION.USER_PROFILE_TAB.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f29693a[ADConstants.AD_POSITION.VISITOR_ORIGIN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f29693a[ADConstants.AD_POSITION.VISITOR_BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f29693a[ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f29693a[ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f29693a[ADConstants.AD_POSITION.NEARBY_HOME_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f29693a[ADConstants.AD_POSITION.NEARBY_HOME_ORIGIN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f29693a[ADConstants.AD_POSITION.NEARBY_FLOAT_AD.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static VipProtos.OrderType a(String str) {
        boolean z;
        switch (str.hashCode()) {
            case 116765:
                if (str.equals("vip")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 3045982:
                if (str.equals("call")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3172656:
                if (str.equals("gift")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3542730:
                if (str.equals("svip")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 93610691:
                if (str.equals(ReqAckPackage.REQ_RESPONSE_KEY.BEANS)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        return z ? !z ? !z ? !z ? !z ? VipProtos.OrderType.UNKNOWN_ORDER_TYPE : VipProtos.OrderType.ORDER_SOCIAL : VipProtos.OrderType.ORDER_WANDOU : VipProtos.OrderType.ORDER_CALL : VipProtos.OrderType.ORDER_SVIP : VipProtos.OrderType.ORDER_VIP;
    }

    public static VipProtos.PageLevel a(int i) {
        return i != 1 ? i != 2 ? VipProtos.PageLevel.UNKNOWN_PAGE_LEVEL : VipProtos.PageLevel.SVIP_PAGE : VipProtos.PageLevel.VIP_PAGE;
    }

    public static String a(ADConstants.AD_POSITION ad_position) {
        switch (AnonymousClass1.f29693a[ad_position.ordinal()]) {
            case 1:
                return "no_ad_personal_page";
            case 2:
                return "no_ad_visit_page";
            case 3:
                return "no_ad_visit_page_banner";
            case 4:
            case 5:
                return "no_ad_home_page_banner2";
            case 6:
                return "no_ad_home_page_banner1";
            case 7:
                return "no_ad_home_page";
            case 8:
                return "no_ad_home_page_layer";
            default:
                return "";
        }
    }

    public static void a() {
        EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(VipProtos.Event.VIRTUAL_PACK_TAB_CLICK).build());
    }

    public static void a(int i, int i2, boolean z, int i3) {
        VipProtos.VipProto.Builder isOpen = VipProtos.VipProto.newBuilder().setEvent(VipProtos.Event.VIP_CENTER_PRIVILEGE_CLICK).setIdentityType(b(i)).setPageLevel(a(i2)).setIsOpen(z);
        EventTrackUtils.a(isOpen.setPrivilegeId(i3 + "").build());
    }

    public static void a(VipProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(VipProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setPageLevel(a(i)).build());
        }
    }

    public static void a(VipProtos.Event event, int i, int i2) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIdentityType(b(i)).setPageLevel(a(i2)).build());
        }
    }

    public static void a(VipProtos.Event event, int i, int i2, VipProtos.BtnType btnType) {
        if (event == null || btnType == null) {
            return;
        }
        EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIdentityType(b(i)).setPageLevel(a(i2)).setBtnType(btnType).build());
    }

    public static void a(VipProtos.Event event, int i, int i2, String str) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIdentityType(b(i)).setPageLevel(a(i2)).setBannerUrl(b(str)).build());
        }
    }

    public static void a(VipProtos.Event event, int i, String str) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setNum(i).setOrderType(a(str)).build());
        }
    }

    public static void a(VipProtos.Event event, int i, boolean z) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIdentityType(b(i)).setIsOpen(z).build());
        }
    }

    public static void a(VipProtos.Event event, VipProtos.AdPage adPage, String str) {
        if (event != null) {
            VipProtos.VipProto.Builder event2 = VipProtos.VipProto.newBuilder().setEvent(event);
            VipProtos.AdPage adPage2 = adPage;
            if (adPage == null) {
                adPage2 = VipProtos.AdPage.UNKNOWN_AD_PAGE;
            }
            VipProtos.VipProto.Builder adPage3 = event2.setAdPage(adPage2);
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            EventTrackUtils.a(adPage3.setAdType(str2).build());
        }
    }

    public static void a(VipProtos.Event event, VipProtos.FromType fromType, String str) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setFrom(fromType).setSkuId(b(str)).build());
        }
    }

    public static void a(VipProtos.Event event, VipProtos.HideType hideType) {
        if (event == null || hideType == null) {
            return;
        }
        EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setHideType(hideType).build());
    }

    public static void a(VipProtos.Event event, VipProtos.IdentityType identityType) {
        if (event == null || identityType == null) {
            return;
        }
        EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIdentityType(identityType).build());
    }

    public static void a(VipProtos.Event event, VipProtos.Name name, VipProtos.FromType fromType, VipProtos.PageVersion pageVersion) {
        if (event == null || name == null || fromType == null || pageVersion == null) {
            return;
        }
        EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setName(name).setFrom(fromType).setPageVersion(pageVersion).build());
    }

    public static void a(VipProtos.Event event, VipProtos.Name name, VipProtos.PageVersion pageVersion) {
        if (event == null || name == null || pageVersion == null) {
            return;
        }
        EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setName(name).setPageVersion(pageVersion).build());
    }

    public static void a(VipProtos.Event event, VipProtos.OrderType orderType, String str) {
        if (event == null || orderType == null) {
            return;
        }
        EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setOrderType(orderType).setThirdId(str).build());
    }

    public static void a(VipProtos.Event event, VipProtos.PageLevel pageLevel, String str) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setPageLevel(pageLevel).setType(b(str)).build());
        }
    }

    public static void a(VipProtos.Event event, VipProtos.VocativeType vocativeType) {
        if (event == null || vocativeType == null) {
            return;
        }
        EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setVocativeType(vocativeType).build());
    }

    public static void a(VipProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setId(b(str)).build());
        }
    }

    public static void a(VipProtos.Event event, String str, int i) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setId(b(str)).setCount(i).build());
        }
    }

    public static void a(VipProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setLatitude(str).setLongitude(str2).build());
        }
    }

    public static void a(VipProtos.Event event, String str, String str2, boolean z) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setId(b(str)).setType(b(str2)).setIsVague(z).build());
        }
    }

    public static void a(VipProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIsShadow(z).build());
        }
    }

    public static void a(VipProtos.Event event, boolean z, boolean z2, boolean z3, boolean z4) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIsHideAll(z).setIsHideAge(z4).setIsHideDistance(z2).setIsHideRole(z3).build());
        }
    }

    public static VipProtos.AdPage b(ADConstants.AD_POSITION ad_position) {
        VipProtos.AdPage adPage = VipProtos.AdPage.UNKNOWN_AD_PAGE;
        switch (AnonymousClass1.f29693a[ad_position.ordinal()]) {
            case 1:
                return VipProtos.AdPage.AD_PERSONAL;
            case 2:
                return VipProtos.AdPage.AD_VISIT;
            case 3:
                return VipProtos.AdPage.AD_BANNER;
            case 4:
            case 5:
                return VipProtos.AdPage.AD_HOME_BANNER2;
            case 6:
                return VipProtos.AdPage.AD_HOME_BANNER1;
            case 7:
                return VipProtos.AdPage.AD_HOME;
            case 8:
                return VipProtos.AdPage.AD_HOME_POP;
            default:
                return adPage;
        }
    }

    public static VipProtos.IdentityType b(int i) {
        return i != 1 ? i != 2 ? VipProtos.IdentityType.NONE : VipProtos.IdentityType.SVIP_TYPE : VipProtos.IdentityType.VIP_TYPE;
    }

    private static String b(String str) {
        return EventTrackUtils.a(str);
    }

    public static void b(VipProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIdentityType(b(i)).build());
        }
    }

    public static void b(VipProtos.Event event, int i, String str) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIdentityType(b(i)).setTargetUid(str).build());
        }
    }

    public static void b(VipProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setImageId(b(str)).build());
        }
    }

    public static void b(VipProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setIsOpen(z).build());
        }
    }

    public static VipProtos.OrderType c(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? VipProtos.OrderType.UNKNOWN_ORDER_TYPE : VipProtos.OrderType.ORDER_CALL : VipProtos.OrderType.ORDER_EXPOSURE : VipProtos.OrderType.ORDER_SVIP : VipProtos.OrderType.ORDER_VIP;
    }

    public static void c(VipProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setUrl(b(str)).build());
        }
    }

    public static void d(VipProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).setTargetUid(b(str)).build());
        }
    }
}
