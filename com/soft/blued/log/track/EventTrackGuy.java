package com.soft.blued.log.track;

import android.text.TextUtils;
import com.blued.das.guy.GuyProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import com.soft.blued.ui.find.model.UserFindResult;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackGuy.class */
public class EventTrackGuy {
    public static GuyProtos.VocativeSourcePage a(String str) {
        GuyProtos.VocativeSourcePage vocativeSourcePage = GuyProtos.VocativeSourcePage.UNKNOWN_VOCATIVE_SOURCE_PAGE;
        if (TextUtils.isEmpty(str)) {
            return vocativeSourcePage;
        }
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != -235377960) {
            if (hashCode != 119794870) {
                if (hashCode == 1536204444 && str.equals("vocative_end_report")) {
                    z = true;
                }
            } else if (str.equals("mine_vocative_order")) {
                z = false;
            }
        } else if (str.equals("mine_vocative_order_is_remain")) {
            z = true;
        }
        return z ? !z ? !z ? vocativeSourcePage : GuyProtos.VocativeSourcePage.ORDER_BUY_MORE : GuyProtos.VocativeSourcePage.REPORT_KEEP_ON : GuyProtos.VocativeSourcePage.ORDER_BUY;
    }

    public static void a(GuyProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(GuyProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setRow(i).build());
        }
    }

    public static void a(GuyProtos.Event event, GuyProtos.BtnType btnType) {
        if (event == null || btnType == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setBtnType(btnType).build());
    }

    public static void a(GuyProtos.Event event, GuyProtos.ShowType showType) {
        if (event == null || showType == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setShowType(showType).build());
    }

    public static void a(GuyProtos.Event event, GuyProtos.SortType sortType) {
        if (event == null || sortType == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setSortType(sortType).build());
    }

    public static void a(GuyProtos.Event event, GuyProtos.SortType sortType, boolean z) {
        if (event == null || sortType == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setSortType(sortType).setIsMapFind(z).build());
    }

    public static void a(GuyProtos.Event event, GuyProtos.VocativeSourcePage vocativeSourcePage, GuyProtos.VocativeType vocativeType, String str) {
        if (event == null || vocativeSourcePage == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setVocativeSourcePage(vocativeSourcePage).setType(d(str)).setVocativeType(vocativeType).build());
    }

    public static void a(GuyProtos.Event event, GuyProtos.VocativeSourcePage vocativeSourcePage, String str) {
        if (event == null || vocativeSourcePage == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setVocativeSourcePage(vocativeSourcePage).setSkuId(d(str)).build());
    }

    public static void a(GuyProtos.Event event, GuyProtos.VocativeSourcePage vocativeSourcePage, String str, GuyProtos.VocativeType vocativeType) {
        if (event == null || vocativeSourcePage == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setVocativeSourcePage(vocativeSourcePage).setSkuId(d(str)).setVocativeType(vocativeType).build());
    }

    public static void a(GuyProtos.Event event, GuyProtos.VocativeStatus vocativeStatus) {
        if (event == null || vocativeStatus == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setVocativeStatus(vocativeStatus).build());
    }

    public static void a(GuyProtos.Event event, GuyProtos.VocativeType vocativeType) {
        if (event == null || vocativeType == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setVocativeType(vocativeType).build());
    }

    public static void a(GuyProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setTargetUid(d(str)).build());
        }
    }

    public static void a(GuyProtos.Event event, String str, GuyProtos.SortType sortType, GuyProtos.ShowType showType, boolean z) {
        if (event == null || sortType == null || showType == null) {
            return;
        }
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setTargetUid(d(str)).setSortType(sortType).setShowType(showType).setIsMapFind(z).build());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(GuyProtos.Event event, String str, GuyProtos.SortType sortType, GuyProtos.ShowType showType, boolean z, boolean z2, boolean z3, boolean z4, String str2, boolean z5, boolean z6, boolean z7, int i, String str3, boolean z8, int i2, boolean z9, boolean z10, String str4, boolean z11) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(GuyProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setKeyword(d(str)).setTargetUid(d(str2)).build());
        }
    }

    public static void a(GuyProtos.Event event, String str, String str2, GuyProtos.ShowType showType, int i) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setType(d(str)).setId(d(str2)).setShowType(showType).setNum(i).build());
        }
    }

    public static void a(GuyProtos.Event event, String str, String str2, GuyProtos.SortType sortType) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setKeyword(d(str)).setTargetUid(d(str2)).setSortType(sortType).build());
        }
    }

    public static void a(GuyProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setTargetUid(d(str)).setRoomId(d(str2)).setRoomUid(d(str3)).build());
        }
    }

    public static void a(GuyProtos.Event event, String str, String str2, String str3, int i, GuyProtos.SortType sortType, boolean z) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setLiveId(d(str)).setTargetUid(d(str2)).setRecommendType(d(str3)).setNum(i).setSortType(sortType).setIsOpen(z).build());
        }
    }

    public static void a(GuyProtos.Event event, String str, String str2, String str3, String str4, int i) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setLiveId(d(str)).setTargetUid(d(str2)).setLiveClassStr(d(str3)).setRecommendType(d(str4)).setNum(i).build());
        }
    }

    public static void a(GuyProtos.Event event, String str, String str2, String str3, String str4, String str5) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setType(d(str)).setId(d(str2)).setUrl(d(str3)).setLiveId(d(str4)).setTargetUid(d(str5)).build());
        }
    }

    public static void a(GuyProtos.Event event, String str, boolean z) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setConfigJson(d(str)).setIsOpen(z).build());
        }
    }

    public static void a(GuyProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setIsVip(z).build());
        }
    }

    public static void a(GuyProtos.Event event, boolean z, String str) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setIsVip(z).setId(d(str)).build());
        }
    }

    public static void a(GuyProtos.Event event, boolean z, boolean z2, boolean z3) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setIsVip(z).setIsAuto(z2).setIsShadow(z3).build());
        }
    }

    public static void b(GuyProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).build());
        }
    }

    public static void b(GuyProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setKeyword(d(str)).build());
        }
    }

    public static void b(GuyProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setKeyword(d(str)).setId(d(str2)).build());
        }
    }

    public static void b(GuyProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setIsAuto(z).build());
        }
    }

    public static void b(String str) {
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(GuyProtos.Event.PAGE_REFRESH).setType(d(str)).build());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static GuyProtos.SortType c(String str) {
        boolean z;
        switch (str.hashCode()) {
            case -1572566948:
                if (str.equals("msg_hello_detail")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1049482625:
                if (str.equals(UserFindResult.USER_SORT_BY.NEARBY)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1048842402:
                if (str.equals(UserFindResult.USER_SORT_BY.NEWBEE)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1012222381:
                if (str.equals(UserFindResult.USER_SORT_BY.ONLINE)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 492822833:
                if (str.equals(UserFindResult.USER_SORT_BY.INTEGRATE)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (z) {
            if (!z) {
                if (!z) {
                    if (!z) {
                        if (!z) {
                            return null;
                        }
                        return GuyProtos.SortType.CALL_SECOND_PAGE;
                    }
                    return GuyProtos.SortType.NEW_FACE;
                }
                return GuyProtos.SortType.DISTANCE_SORT;
            }
            return GuyProtos.SortType.ONLINE_TIME_SORT;
        }
        return GuyProtos.SortType.COMPLEX_SORT;
    }

    public static void c(GuyProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setRole(d(str)).build());
        }
    }

    public static void c(GuyProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setKeyword(d(str)).setName(d(str2)).build());
        }
    }

    public static void c(GuyProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(event).setIsShadow(z).build());
        }
    }

    private static String d(String str) {
        return EventTrackUtils.a(str);
    }
}
