package com.soft.blued.http;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.api.ErrorCode;
import com.anythink.pd.ExHandler;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.NearbyPopupModel;
import com.blued.community.utils.CityHelper;
import com.blued.community.utils.CommunityPreferences;
import com.blued.track.bytedance.ByteDanceLogUtils;
import com.google.gson.Gson;
import com.igexin.assist.util.AssistUtils;
import com.libyuv.util.YuvUtil;
import com.qq.e.comm.managers.GDTAdSdk;
import com.soft.blued.R;
import com.soft.blued.ui.find.manager.FilterNewHelper;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.MapToken;
import com.soft.blued.ui.find.model.NearbyModule;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.ADUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.WeChatUtils;
import com.tencent.tendinsv.a.b;
import com.umeng.analytics.pro.bh;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/NearbyHttpUtils.class */
public class NearbyHttpUtils {
    public static FilterEntity a(Context context, FilterEntity filterEntity) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String[] stringArray;
        String[] stringArray2;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        if (BluedPreferences.H()) {
            int aF = BluedPreferences.aF();
            boolean z2 = aF != 1 && aF == 2;
            if (z2) {
                stringArray = AppInfo.d().getResources().getStringArray(R.array.inch_height_list_all);
                stringArray2 = StringUtils.a(AppInfo.d());
            } else {
                stringArray = AppInfo.d().getResources().getStringArray(R.array.height_array_key_all);
                stringArray2 = AppInfo.d().getResources().getStringArray(R.array.weight_key_all);
            }
            String[] stringArray3 = AppInfo.d().getResources().getStringArray(R.array.age_array_key_all);
            String I = !TextUtils.isEmpty(BluedPreferences.I()) ? BluedPreferences.I() : "";
            if (TextUtils.isEmpty(BluedPreferences.K())) {
                str14 = "0-300";
            } else {
                String K = BluedPreferences.K();
                str14 = K;
                if (!StringUtils.d(K)) {
                    str14 = K;
                    if (K.split("-").length == 2) {
                        String[] split = K.split("-");
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int i = parseInt2;
                        int i2 = parseInt;
                        if (parseInt2 >= stringArray3.length) {
                            i2 = parseInt;
                            if (parseInt >= stringArray3.length) {
                                i2 = 0;
                            }
                            i = stringArray3.length - 1;
                            BluedPreferences.l(i2 + "-" + i);
                        }
                        String str20 = stringArray3[i2];
                        String str21 = stringArray3[i];
                        if (FilterNewHelper.f30593a.a(str20) && FilterNewHelper.f30593a.a(str21)) {
                            str19 = stringArray3[stringArray3.length - 2] + "-" + stringArray3[stringArray3.length - 2];
                        } else if (FilterNewHelper.f30593a.a(str20)) {
                            str19 = "0-" + str21;
                        } else if (FilterNewHelper.f30593a.a(str21)) {
                            str19 = str20 + "-300";
                        } else if (str20.equals(str21)) {
                            str19 = str20 + "-" + str21;
                        } else {
                            str19 = str20 + "-" + str21;
                        }
                        str14 = str19;
                    }
                }
            }
            String M = z2 ? BluedPreferences.M() : BluedPreferences.L();
            if (StringUtils.d(M) || M.split("-").length != 2) {
                str = "0-500";
            } else {
                String[] split2 = M.split("-");
                int parseInt3 = Integer.parseInt(split2[0]);
                int parseInt4 = Integer.parseInt(split2[1]);
                if (parseInt4 > stringArray.length - 1) {
                    if (parseInt3 >= stringArray.length) {
                        str17 = stringArray[0];
                        parseInt3 = 0;
                    } else {
                        str17 = stringArray[parseInt3];
                    }
                    str18 = stringArray[stringArray.length - 1];
                    if (z2) {
                        BluedPreferences.n(parseInt3 + "-" + (stringArray.length - 1));
                    } else {
                        BluedPreferences.m(parseInt3 + "-" + (stringArray.length - 1));
                    }
                } else {
                    str17 = stringArray[parseInt3];
                    str18 = stringArray[parseInt4];
                }
                if (parseInt3 == 0 && parseInt4 == 0) {
                    if (z2) {
                        int b = UserRelationshipUtils.b(stringArray[1]);
                        str = b + "-" + b;
                    } else {
                        str = stringArray[1] + "-" + stringArray[1];
                    }
                } else if (parseInt3 == stringArray.length - 1 && parseInt4 == stringArray.length - 1) {
                    if (z2) {
                        int b2 = UserRelationshipUtils.b(stringArray[stringArray.length - 2]);
                        str = b2 + "-" + b2;
                    } else {
                        str = stringArray[stringArray.length - 2] + "-" + stringArray[stringArray.length - 2];
                    }
                } else if (FilterNewHelper.f30593a.a(str17) && FilterNewHelper.f30593a.a(str18)) {
                    str = "";
                } else if (FilterNewHelper.f30593a.a(str17)) {
                    if (z2) {
                        str = "0-" + UserRelationshipUtils.b(str18);
                    } else {
                        str = "0-" + str18;
                    }
                } else if (FilterNewHelper.f30593a.a(str18)) {
                    if (z2) {
                        str = UserRelationshipUtils.b(str17) + "-500";
                    } else {
                        str = str17 + "-500";
                    }
                } else if (str17.equals(str18)) {
                    if (z2) {
                        str = UserRelationshipUtils.b(str17) + "-" + UserRelationshipUtils.b(str18);
                    } else {
                        str = str17 + "-" + str18;
                    }
                } else if (z2) {
                    str = UserRelationshipUtils.b(str17) + "-" + UserRelationshipUtils.b(str18);
                } else {
                    str = str17 + "-" + str18;
                }
            }
            String O = z2 ? BluedPreferences.O() : BluedPreferences.N();
            if (StringUtils.d(O) || O.split("-").length != 2) {
                str13 = "0-1000";
            } else {
                String[] split3 = O.split("-");
                int intValue = Integer.valueOf(split3[0]).intValue();
                int intValue2 = Integer.valueOf(split3[1]).intValue();
                if (intValue2 > stringArray2.length - 1) {
                    if (intValue >= stringArray2.length) {
                        str15 = stringArray2[0];
                        intValue = 0;
                    } else {
                        str15 = stringArray2[intValue];
                    }
                    str16 = stringArray2[stringArray2.length - 1];
                    if (z2) {
                        BluedPreferences.p(intValue + "-" + (stringArray2.length - 1));
                    } else {
                        BluedPreferences.o(intValue + "-" + (stringArray2.length - 1));
                    }
                } else {
                    str15 = stringArray2[intValue];
                    str16 = stringArray2[intValue2];
                }
                if (intValue == 0 && intValue2 == 0) {
                    int c2 = UserRelationshipUtils.c(stringArray2[1]);
                    str13 = c2 + "-" + c2;
                } else if (intValue == stringArray2.length - 1 && intValue2 == stringArray2.length - 1) {
                    str13 = stringArray2[stringArray2.length - 2] + "-" + stringArray2[stringArray2.length - 2];
                } else if (FilterNewHelper.f30593a.a(str15) && FilterNewHelper.f30593a.a(str16)) {
                    str13 = "";
                } else if (FilterNewHelper.f30593a.a(str15)) {
                    if (z2) {
                        str13 = "0-" + UserRelationshipUtils.c(str16);
                    } else {
                        str13 = "0-" + str16;
                    }
                } else if (FilterNewHelper.f30593a.a(str16)) {
                    if (z2) {
                        str13 = UserRelationshipUtils.c(str15) + "-1000";
                    } else {
                        str13 = str15 + "-1000";
                    }
                } else if (str15.equals(str16)) {
                    if (z2) {
                        str13 = UserRelationshipUtils.c(str15) + "-" + UserRelationshipUtils.c(str16);
                    } else {
                        str13 = str15 + "-" + str16;
                    }
                } else if (z2) {
                    str13 = UserRelationshipUtils.c(str15) + "-" + UserRelationshipUtils.c(str16);
                } else {
                    str13 = str15 + "-" + str16;
                }
            }
            str12 = BluedPreferences.P() ? "1" : "";
            String str22 = BluedPreferences.R() ? "1" : "";
            str11 = BluedPreferences.S() ? "1" : "";
            String V = BluedPreferences.V();
            String T = BluedPreferences.T();
            z = BluedPreferences.Y();
            String Z = BluedPreferences.Z();
            if (TextUtils.isEmpty(Z)) {
                Z = "0-max";
            }
            String aa = BluedPreferences.aa();
            String str23 = TextUtils.isEmpty(aa) ? "0-max" : aa;
            String str24 = BluedPreferences.Q() ? "1" : "";
            str5 = BluedPreferences.fJ();
            String str25 = str22;
            str4 = T;
            str8 = str14;
            String str26 = I;
            str2 = str24;
            str3 = str25;
            str10 = V;
            str9 = str26;
            str7 = Z;
            str6 = str23;
        } else {
            z = false;
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str4;
            str7 = str4;
            str8 = str3;
            str9 = str3;
            str10 = str3;
            str11 = str3;
            str12 = str;
            str13 = "";
        }
        if (StringUtils.d(filterEntity.longitude)) {
            filterEntity.longitude = CommonPreferences.u();
        }
        if (StringUtils.d(filterEntity.latitude)) {
            filterEntity.latitude = CommonPreferences.v();
        }
        filterEntity.role = str9;
        filterEntity.age = str8;
        filterEntity.height = str;
        filterEntity.weight = str13;
        filterEntity.has_avatar = str12;
        filterEntity.ai_photo = str3;
        filterEntity.online = "";
        filterEntity.verified = str11;
        filterEntity.tagsid = str10;
        filterEntity.mate = str4;
        filterEntity.nickName = "";
        filterEntity.if_vip_only = z;
        filterEntity.geo_reach = str7;
        filterEntity.time_span = str6;
        filterEntity.ticktocks_pic_count = str2;
        filterEntity.zodiac = str5;
        return filterEntity;
    }

    public static String a(FilterEntity filterEntity) {
        ArrayMap arrayMap = new ArrayMap();
        Gson f = AppInfo.f();
        if (filterEntity.if_vip_only) {
            arrayMap.put("is_vip", "1");
        }
        if (!StringUtils.d(filterEntity.role)) {
            arrayMap.put("role", filterEntity.role);
        }
        if (!StringUtils.d(filterEntity.age)) {
            arrayMap.put(ATCustomRuleKeys.AGE, filterEntity.age);
        }
        if (!StringUtils.d(filterEntity.height)) {
            arrayMap.put("height", filterEntity.height);
        }
        if (!StringUtils.d(filterEntity.weight)) {
            arrayMap.put("weight", filterEntity.weight);
        }
        if (!StringUtils.d(filterEntity.has_avatar)) {
            arrayMap.put("has_avatar", filterEntity.has_avatar);
        }
        if (!StringUtils.d(filterEntity.online)) {
            arrayMap.put(UserFindResult.USER_SORT_BY.ONLINE, filterEntity.online);
        }
        if (!StringUtils.d(filterEntity.verified)) {
            arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.VBADGE, "4");
        }
        if (!StringUtils.d(filterEntity.nickName)) {
            arrayMap.put("name", filterEntity.nickName);
        }
        if (!StringUtils.d(filterEntity.tagsid)) {
            arrayMap.put("tags", filterEntity.tagsid);
        }
        if (!StringUtils.d(filterEntity.mate) && !filterEntity.mate.contains("0") && !filterEntity.mate.contains("-1")) {
            arrayMap.put("mate", filterEntity.mate);
        }
        if (BluedConfig.a().e() && !StringUtils.d(filterEntity.ai_photo)) {
            arrayMap.put("is_human_face", filterEntity.ai_photo);
        }
        if (!StringUtils.d(filterEntity.geo_reach)) {
            arrayMap.put("geo_reach", filterEntity.geo_reach);
        }
        if (!StringUtils.d(filterEntity.time_span)) {
            arrayMap.put("time_span", filterEntity.time_span);
        }
        if (!StringUtils.d(filterEntity.ticktocks_pic_count)) {
            arrayMap.put("ticktocks_pic_count", filterEntity.ticktocks_pic_count);
        }
        if (!StringUtils.d(filterEntity.zodiac)) {
            arrayMap.put("zodiac", filterEntity.zodiac);
        }
        if (UserHttpUtils.d && "recommend".equals(filterEntity.sort_by)) {
            arrayMap.put("repeat", UserHttpUtils.f29667a + "");
            UserHttpUtils.f29667a = UserHttpUtils.f29667a + 1;
        }
        return f.toJson(arrayMap);
    }

    public static void a() {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("is_free_use", "1");
        HttpManager.b(BluedHttpUrl.q() + "/users/map").a(a2).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, FilterEntity filterEntity, String str, IRequestHost iRequestHost) {
        if (UserInfo.getInstance().getLoginUserInfo() != null && BluedConfig.a().g().is_filter_vip == 0) {
            BluedPreferences.i(false);
            BluedPreferences.v("");
            BluedPreferences.w("");
            BluedPreferences.h(false);
            BluedPreferences.f(false);
        }
        b(context, bluedUIHttpResponse, a(context, filterEntity), str, iRequestHost);
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/floats", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str) {
        HttpManager.a(BluedHttpUrl.q() + "/users/moment?type=conf&c=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, String str, String str2) {
        String str3 = BluedHttpUrl.q() + "/users/" + str + "/joy";
        String str4 = str3;
        if (!StringUtils.d(str2)) {
            str4 = str3 + "?filter=" + str2;
        }
        Map<String, String> a2 = BluedHttpTools.a();
        String update = !Build.MANUFACTURER.toLowerCase().equals(AssistUtils.BRAND_HW) ? YuvUtil.getUpdate() : "";
        a2.put(ExHandler.JSON_REQUEST_BOOT_MARK, "");
        a2.put(ExHandler.JSON_REQUEST_UPDATE_MARK, update);
        a2.put("android_model", Build.MANUFACTURER + Build.MODEL);
        a2.put("android_version", Build.VERSION.RELEASE);
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            a2.put("android_id", Settings.System.getString(AppInfo.d().getContentResolver(), "android_id"));
        }
        a2.put("android_oaid", BluedDeviceIdentity.a().h());
        String d = DeviceUtils.d();
        boolean z = true;
        switch (d.hashCode()) {
            case -840190066:
                if (d.equals("China Telecom")) {
                    z = true;
                    break;
                }
                break;
            case -357112885:
                if (d.equals("China Mobile")) {
                    z = true;
                    break;
                }
                break;
            case -128800326:
                if (d.equals("China Unicom")) {
                    z = true;
                    break;
                }
                break;
            case 618558396:
                if (d.equals("中国电信")) {
                    z = true;
                    break;
                }
                break;
            case 618596989:
                if (d.equals("中国移动")) {
                    z = false;
                    break;
                }
                break;
            case 618663094:
                if (d.equals("中国联通")) {
                    z = true;
                    break;
                }
                break;
        }
        a2.put(bh.P, ((!z || z) ? 1 : (z || z) ? 2 : (z || z) ? 3 : 0) + "");
        String buyerId = GDTAdSdk.getGDTAdManger().getBuyerId(new ArrayMap());
        String sDKInfo = GDTAdSdk.getGDTAdManger().getSDKInfo(ErrorCode.networkError);
        Log.v("drb", "buyerId:" + buyerId + " -- sdkInfo:" + sDKInfo);
        a2.put("gdt_buyer_id", buyerId);
        a2.put("gdt_sdk_info", sDKInfo);
        a2.put("conn_type", NetworkUtils.b() + "");
        a2.put("make", Build.MANUFACTURER);
        a2.put("model", Build.MODEL);
        a2.put(b.a.q, DeviceUtils.k());
        a2.put("ipv6", DeviceUtils.l());
        a2.put("h", AppInfo.m + "");
        a2.put(IAdInterListener.AdReqParam.WIDTH, AppInfo.l + "");
        a2.put("imei", AppInfo.d);
        a2.put("didmd5", Md5.a(AppInfo.d).toLowerCase());
        a2.put(bh.x, "Android");
        a2.put("country", Locale.getDefault().getCountry());
        a2.put("latitude", CommonPreferences.v());
        a2.put("longitude", CommonPreferences.u());
        a2.put("wx", WeChatUtils.a(AppInfo.d()) ? "1" : "0");
        a2.put("wx_sdk", "5.5.8");
        a2.put("channel", AppInfo.f9487c);
        a2.put("req_id", ADUtils.b());
        HttpManager.a(str4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, List<NearbyModule> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        String str = "";
        while (true) {
            String str2 = str;
            if (i >= list.size()) {
                Map<String, String> a2 = BluedHttpTools.a();
                a2.put("custom", str2);
                HttpManager.b(BluedHttpUrl.q() + "/users/custom", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
                return;
            }
            String str3 = str2;
            if (list.get(i).is_show == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(StringUtils.d(str2) ? "" : ",");
                sb.append(list.get(i).cid);
                str3 = sb.toString();
            }
            i++;
            str = str3;
        }
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/custom?from=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, boolean z) {
        String str = BluedHttpUrl.q() + "/blued/confirm_mobile";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("is_use", z ? "1" : "0");
        HttpManager.b(str, bluedUIHttpResponse).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b() {
        LogUtils.c("模态弹层 getNearbyGuideModeLeaveOne:" + CommunityPreferences.al());
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("longitude", CommonPreferences.u());
        a2.put("latitude", CommonPreferences.v());
        a2.put("leave_one", String.valueOf(CommunityPreferences.al()));
        HttpManager.a(BluedHttpUrl.q() + "/ticktocks/popups", new BluedUIHttpResponse<BluedEntityA<NearbyPopupModel>>(null) { // from class: com.soft.blued.http.NearbyHttpUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:78:0x03fd, code lost:
                if (r0.getSubType() == 10) goto L69;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.blued.community.model.NearbyPopupModel> r8) {
                /*
                    Method dump skipped, instructions count: 1789
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.http.NearbyHttpUtils.AnonymousClass1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                CommunityPreferences.a(CommunityManager.f19086a.a().o());
                CommunityPreferences.b(CommunityManager.f19086a.a().p());
            }
        }, null).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, FilterEntity filterEntity, String str, IRequestHost iRequestHost) {
        if (BluedPreferences.H() != UserHttpUtils.b && !BluedPreferences.H() && "recommend".equals(filterEntity.sort_by)) {
            UserHttpUtils.d = true;
            UserHttpUtils.f29667a = 1;
        }
        FilterEntity filterEntity2 = filterEntity;
        if (UserHttpUtils.d) {
            filterEntity2 = filterEntity;
            if ("recommend".equals(filterEntity.sort_by)) {
                filterEntity2 = filterEntity;
                if (!BluedPreferences.H()) {
                    filterEntity2 = filterEntity;
                    if (UserHttpUtils.f29667a <= 5) {
                        filterEntity2 = UserHttpUtils.f29668c;
                    }
                }
            }
        }
        Map<String, String> a2 = BluedHttpTools.a();
        if (!StringUtils.d(filterEntity2.f)) {
            a2.put("f", filterEntity2.f);
        }
        a2.put("sort_by", filterEntity2.sort_by);
        a2.put("latitude", filterEntity2.latitude);
        a2.put("longitude", filterEntity2.longitude);
        a2.put("ssid", ByteDanceLogUtils.b());
        MapToken mapToken = new MapToken();
        mapToken.lat = filterEntity2.latitude;
        mapToken.lon = filterEntity2.longitude;
        mapToken.time = System.currentTimeMillis();
        try {
            a2.put("extra_info", AesCrypto.b(AppInfo.f().toJson(mapToken)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        a2.put("source", filterEntity2.source);
        a2.put("cid", filterEntity2.cid + "");
        a2.put("scroll_type", filterEntity2.scroll_type + "");
        a2.put("from", filterEntity2.if_grid ? "grid" : "list");
        if (filterEntity2.column == 3) {
            a2.put("column", filterEntity2.column + "");
        }
        a2.put("filters", a(filterEntity2));
        Log.v("http_params", a2.get("filters"));
        a2.put("start", filterEntity2.start);
        a2.put("limit", filterEntity2.limit);
        a2.put("next_min_dist", filterEntity2.next_min_dist);
        a2.put("next_skip_uid", filterEntity2.next_skip_uid);
        if (!StringUtils.d(filterEntity2.custom)) {
            a2.put("custom", filterEntity2.custom);
        }
        if (!StringUtils.d(str)) {
            a2.put("exclude_id", str);
        }
        if (!StringUtils.d(filterEntity2.is_map_ok_click)) {
            a2.put("action", filterEntity2.is_map_ok_click);
        }
        a2.put("android_model", Build.MANUFACTURER + Build.MODEL);
        a2.put("android_version", Build.VERSION.RELEASE);
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            a2.put("android_id", Settings.System.getString(AppInfo.d().getContentResolver(), "android_id"));
        }
        a2.put("android_oaid", BluedDeviceIdentity.a().h());
        a2.put("req_id", ADUtils.b());
        Log.e("xxx", "findUserList: paramsJson = " + BluedHttpTools.a(a2));
        HttpManager.a(BluedHttpUrl.q() + "/users", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
        UserHttpUtils.b = BluedPreferences.H();
        if ("recommend".equals(filterEntity2.sort_by) && BluedPreferences.H()) {
            UserHttpUtils.f29668c = filterEntity2;
        }
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/map", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("bubble_click", str);
        HttpManager.b(BluedHttpUrl.q() + "/ticktocks/users/feed/bubble", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/confirm_mobile", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("longitude", CommonPreferences.u());
        a2.put("latitude", CommonPreferences.v());
        HttpManager.a(BluedHttpUrl.q() + "/ticktocks/users/feed/bubble", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("longitude", CityHelper.a().c());
        a2.put("latitude", CityHelper.a().e());
        HttpManager.a(LiveRoomInfo.a().k() + "/users/selection", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }
}
