package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.compatible.gamecenter.wrapper.ActiveWrapper;
import com.cdo.oaps.ad.compatible.gamecenter.wrapper.StrategyWrapper;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/v.class */
public class v {

    /* renamed from: a  reason: collision with root package name */
    static String[] f21536a = {"/home"};
    static String[] b = {Launcher.Path.MALL, "/home"};

    /* renamed from: c  reason: collision with root package name */
    static String[] f21537c = {"/home", Launcher.Path.MALL, Launcher.Path.VIP, "/dt", Launcher.Path.DETAIL_DOWN, Launcher.Path.ORDER_DETAIL, Launcher.Path.TOPIC, Launcher.Path.CARD_STYLE, "/web", Launcher.Path.ONLINE_SERVICE, Launcher.Path.GIFTS};
    static String[] d = {"/home", Launcher.Path.MALL, Launcher.Path.VIP, "/dt", Launcher.Path.DETAIL_DOWN, Launcher.Path.ORDER_DETAIL, Launcher.Path.TOPIC, Launcher.Path.CARD_STYLE, "/web", Launcher.Path.FORUM_POSTS_DT, Launcher.Path.GIFTS, Launcher.Path.COIN_TICKET, Launcher.Path.GAME_GIFTS, Launcher.Path.ACTIVITIES, Launcher.Path.GAME_ACTIVITIES, Launcher.Path.FORUM_BOARD_DT};

    public static boolean a(Context context, String str) {
        boolean z;
        float a2 = x.a(context);
        if (a2 >= 2.1f) {
            String[] strArr = d;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = false;
                if (i2 >= length) {
                    break;
                } else if (strArr[i2].equals(str)) {
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            z = true;
        } else if (a2 >= 2.0f) {
            String[] strArr2 = f21537c;
            int length2 = strArr2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                z = false;
                if (i4 < length2) {
                    if (strArr2[i4].equals(str)) {
                        break;
                    }
                    i3 = i4 + 1;
                } else {
                    break;
                }
            }
        } else if (a2 >= 1.2f || Math.abs(a2 - 1.2f) < 1.0E-6d) {
            String[] strArr3 = b;
            int length3 = strArr3.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                z = false;
                if (i6 < length3) {
                    if (strArr3[i6].equals(str)) {
                        break;
                    }
                    i5 = i6 + 1;
                } else {
                    break;
                }
            }
        } else {
            z = false;
            if (a2 > 0.0f) {
                String[] strArr4 = f21536a;
                int length4 = strArr4.length;
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    z = false;
                    if (i8 < length4) {
                        if (strArr4[i8].equals(str)) {
                            break;
                        }
                        i7 = i8 + 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return z;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return b(context, map);
    }

    private static boolean b(Context context, Map<String, Object> map) {
        BaseWrapper wrapper = BaseWrapper.wrapper(map);
        if (wrapper.getPath().equals("/home")) {
            return w.a(context, wrapper.getEnterId());
        }
        if (wrapper.getPath().equals("/dt")) {
            return w.a(context, ResourceWrapper.wrapper(map).getId(), wrapper.getEnterId());
        }
        if (wrapper.getPath().equals(Launcher.Path.GAME_GIFT_BAG)) {
            ActiveWrapper wrapper2 = ActiveWrapper.wrapper(map);
            int activeCode = wrapper2.getActiveCode();
            long id = wrapper2.getId();
            String str = "actCode=giftbag" + activeCode + "&actPage=GIFT_BAG_DETAIL#/actDetail";
            String enterId = wrapper.getEnterId();
            return id > 0 ? w.a(context, str, id, enterId) : w.a(context, str, enterId);
        } else if (wrapper.getPath().equals(Launcher.Path.GAME_ACTIVE)) {
            ActiveWrapper wrapper3 = ActiveWrapper.wrapper(map);
            int activeCode2 = wrapper3.getActiveCode();
            long id2 = wrapper3.getId();
            String str2 = "actCode=activity" + activeCode2 + "&actPage=ACTIVITY_DETAIL#/actDetail";
            String enterId2 = wrapper.getEnterId();
            return id2 > 0 ? w.b(context, str2, id2, enterId2) : w.b(context, str2, enterId2);
        } else if (wrapper.getPath().equals(Launcher.Path.TOPIC)) {
            return w.b(context, IDWrapper.wrapper(map).getId(), wrapper.getEnterId());
        } else {
            if (wrapper.getPath().equals(Launcher.Path.STRATEGY)) {
                StrategyWrapper wrapper4 = StrategyWrapper.wrapper(map);
                wrapper4.setTab(1);
                return w.c(context, wrapper4.getId(), wrapper.getEnterId());
            } else if (wrapper.getPath().equals("/point")) {
                return w.b(context, wrapper.getEnterId());
            } else {
                if (wrapper.getPath().equals(Launcher.Path.MALL)) {
                    return w.c(context, wrapper.getEnterId());
                }
                if (wrapper.getPath().equals(Launcher.Path.ONLINE_SERVICE)) {
                    return false;
                }
                wrapper.getPath().equals("/web");
                return false;
            }
        }
    }
}
