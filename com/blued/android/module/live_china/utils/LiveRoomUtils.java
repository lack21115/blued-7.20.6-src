package com.blued.android.module.live_china.utils;

import android.text.TextUtils;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BannerModel;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveBubbleBgModel;
import com.blued.android.module.live_china.model.LiveListCommonModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomViewerExtra;
import com.blued.android.module.live_china.model.LiveRoomViewerModel;
import com.blued.android.module.live_china.model.LiveTabData;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveRoomUtils.class */
public class LiveRoomUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, LiveTabData> f14192a = new HashMap();

    public static String a(long j) {
        if (j < 10000) {
            return e(String.valueOf(j));
        }
        String format = String.format("%.1f", Double.valueOf(j / 10000.0d));
        String str = format;
        if (format.indexOf(".") > 0) {
            str = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str + "万";
    }

    public static List<BluedLiveListData> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LiveTabData liveTabData = f14192a.get(str);
        LiveTabData liveTabData2 = liveTabData;
        if (liveTabData == null) {
            liveTabData2 = new LiveTabData();
            f14192a.put(str, liveTabData2);
        }
        if (liveTabData2.getDatas() == null) {
            liveTabData2.setDatas(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(liveTabData2.getDatas());
        return arrayList;
    }

    public static List<LiveRoomData> a(List<BluedLiveListData> list, String str) {
        String str2;
        String str3;
        int i;
        String str4;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (BluedLiveListData bluedLiveListData : list) {
                String str5 = bluedLiveListData.uid;
                UserBasicModel userBasicModel = bluedLiveListData.anchor;
                if (userBasicModel != null) {
                    String str6 = str5;
                    if (TextUtils.isEmpty(str5)) {
                        str6 = userBasicModel.uid;
                    }
                    str2 = userBasicModel.name;
                    String str7 = userBasicModel.avatar;
                    i = userBasicModel.vbadge;
                    str4 = str6;
                    str3 = str7;
                } else {
                    str2 = "";
                    str3 = str2;
                    i = 0;
                    str4 = str5;
                }
                LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(bluedLiveListData.lid, 0L), bluedLiveListData.screen_pattern, str, str4, str2, str3, i);
                if (!TextUtils.isEmpty(bluedLiveListData.live_play)) {
                    liveRoomData.live_url = bluedLiveListData.live_play;
                }
                arrayList.add(liveRoomData);
            }
        }
        return arrayList;
    }

    public static void a(long j, int i) {
        LiveRoomManager.a().a(j, i);
    }

    public static void a(ProfileData profileData, int i) {
        synchronized (LiveRoomUtils.class) {
            try {
                LiveRoomManager.a().a(profileData, i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(IRequestHost iRequestHost, String str) {
        final long d = LiveRoomManager.a().d();
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRoomViewerModel, LiveRoomViewerExtra>>(iRequestHost) { // from class: com.blued.android.module.live_china.utils.LiveRoomUtils.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveRoomViewerModel, LiveRoomViewerExtra> bluedEntity) {
                if (d != LiveRoomManager.a().d()) {
                    return;
                }
                if (bluedEntity != null && bluedEntity.data != null) {
                    Iterator<LiveRoomViewerModel> it = bluedEntity.data.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        LiveRoomViewerModel next = it.next();
                        if (next.uid == LiveRoomInfo.a().g()) {
                            LiveRoomManager.a().a(new LiveBubbleBgModel(next.chat_frame, next.chat_frame_icon, next.chat_frame_gradient_type, next.chat_frame_frame_color, next.chat_frame_border_color));
                            if (UserInfo.getInstance().getLoginUserInfo() != null) {
                                UserInfo.getInstance().getLoginUserInfo().avatar_frame = next.avatar_frame;
                                UserInfo.getInstance().getLoginUserInfo().avatar_frame_type = next.avatar_frame_type;
                            }
                        }
                    }
                }
                LiveRoomManager.a().a(d, bluedEntity.data, (int) bluedEntity.extra.realtime_count);
            }
        }, iRequestHost, String.valueOf(d), str);
    }

    public static void a(String str, LiveListCommonModel liveListCommonModel) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveTabData liveTabData = f14192a.get(str);
        LiveTabData liveTabData2 = liveTabData;
        if (liveTabData == null) {
            liveTabData2 = new LiveTabData();
            f14192a.put(str, liveTabData2);
        }
        liveTabData2.setCommonModel(liveListCommonModel);
    }

    public static void a(String str, List<BluedLiveListData> list) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveTabData liveTabData = f14192a.get(str);
        LiveTabData liveTabData2 = liveTabData;
        if (liveTabData == null) {
            liveTabData2 = new LiveTabData();
            f14192a.put(str, liveTabData2);
        }
        if (liveTabData2.getDatas() == null) {
            liveTabData2.setDatas(new ArrayList());
        }
        liveTabData2.getDatas().clear();
        liveTabData2.getDatas().addAll(list);
    }

    public static List<BannerModel> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LiveTabData liveTabData = f14192a.get(str);
        LiveTabData liveTabData2 = liveTabData;
        if (liveTabData == null) {
            liveTabData2 = new LiveTabData();
            f14192a.put(str, liveTabData2);
        }
        if (liveTabData2.getExtraDatas() == null) {
            liveTabData2.setExtraDatas(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(liveTabData2.getExtraDatas());
        return arrayList;
    }

    public static void b(String str, List<BannerModel> list) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveTabData liveTabData = f14192a.get(str);
        LiveTabData liveTabData2 = liveTabData;
        if (liveTabData == null) {
            liveTabData2 = new LiveTabData();
            f14192a.put(str, liveTabData2);
        }
        if (liveTabData2.getExtraDatas() == null) {
            liveTabData2.setExtraDatas(new ArrayList());
        }
        liveTabData2.getExtraDatas().clear();
        liveTabData2.getExtraDatas().addAll(list);
    }

    public static List<BluedLiveListData> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LiveTabData liveTabData = f14192a.get(str);
        LiveTabData liveTabData2 = liveTabData;
        if (liveTabData == null) {
            liveTabData2 = new LiveTabData();
            f14192a.put(str, liveTabData2);
        }
        if (liveTabData2.getAdapterData() == null) {
            liveTabData2.setAdapterData(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(liveTabData2.getAdapterData());
        return arrayList;
    }

    public static void c(String str, List<BluedLiveListData> list) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveTabData liveTabData = f14192a.get(str);
        LiveTabData liveTabData2 = liveTabData;
        if (liveTabData == null) {
            liveTabData2 = new LiveTabData();
            f14192a.put(str, liveTabData2);
        }
        if (liveTabData2.getAdapterData() == null) {
            liveTabData2.setAdapterData(new ArrayList());
        }
        liveTabData2.getAdapterData().clear();
        liveTabData2.getAdapterData().addAll(list);
    }

    public static LiveListCommonModel d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LiveTabData liveTabData = f14192a.get(str);
        LiveTabData liveTabData2 = liveTabData;
        if (liveTabData == null) {
            liveTabData2 = new LiveTabData();
            f14192a.put(str, liveTabData2);
        }
        return liveTabData2.getCommonModel();
    }

    public static String e(String str) {
        double d;
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        DecimalFormat decimalFormat = str.indexOf(".") > 0 ? (str.length() - str.indexOf(".")) - 1 == 0 ? new DecimalFormat("###,##0") : (str.length() - str.indexOf(".")) - 1 == 1 ? new DecimalFormat("###,##0.0") : new DecimalFormat("###,##0.00") : new DecimalFormat("###,##0");
        try {
            d = Double.parseDouble(str);
        } catch (Exception e) {
            d = 0.0d;
        }
        String format = decimalFormat.format(d);
        String str2 = format;
        if (format.indexOf(".") > 0) {
            str2 = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str2;
    }
}
