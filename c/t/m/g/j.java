package c.t.m.g;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.ads.fw;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3796a = false;
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f3797c = false;
    public static boolean d = false;
    public static boolean e = true;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static volatile c i;
    public static final a j = new a();
    public static u1 k = u1.f3957a;

    public static final int a(String str) {
        if (str.startsWith("fc4") || str.startsWith("dc4")) {
            return 4;
        }
        if (str.startsWith("fc3") || str.startsWith("dc3")) {
            return 3;
        }
        if (str.startsWith("fc2") || str.startsWith("dc2")) {
            return 2;
        }
        return (str.startsWith("fc1") || str.startsWith("fc") || str.startsWith(OapsKey.KEY_DOWNLOAD_COUNT)) ? 1 : -1;
    }

    public static final String a(int i2) {
        if (f3796a) {
            StringBuilder sb = new StringBuilder();
            sb.append(h ? "https://lstest.map.qq.com/nlpdr?sf" : "https://nlp.map.qq.com/?sf");
            sb.append(i2);
            return sb.toString();
        }
        String str = h ? "https://testdatalbs.sparta.html5.qq.com/tr?sf" : "https://analytics.map.qq.com/?sf";
        if (i2 <= 1) {
            return i2 == 1 ? str : "";
        }
        return str + i2;
    }

    public static HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("D_CH_ID", "fc_sdk");
        hashMap.put("D_FC_SRC", "209");
        hashMap.put("D_UP_INTERVAL", "1800000");
        hashMap.put("D_UP_USE_HTTPS", fw.Code);
        hashMap.put("D_MAX_1F_SIZE", "102400");
        hashMap.put("D_NUM_UP", "1");
        hashMap.put("D_MAX_BUF_WF", "25600");
        hashMap.put("D_MAX_FOLDER_SIZE", "104857600");
        hashMap.put("D_MAX_DAY_RENAME", "3");
        hashMap.put("D_MAX_DAY_DELETE", BaseWrapper.ENTER_ID_TOOLKIT);
        hashMap.put("D_MAX_SIZE_UP_1DAY", "10485760");
        hashMap.put("D_UP_NET", IAdInterListener.AdReqParam.WIDTH);
        hashMap.put("D_POS_COLL", "false");
        hashMap.put("D_WRITE_MAC", "false");
        hashMap.put("D_UP_WF_INFO", fw.Code);
        hashMap.put("D_UP_U_TRACK_INFO", "false");
        hashMap.put("D_UP_GPS_FOR_NAVI", "false");
        return hashMap;
    }

    public static final String b() {
        return "fc4.";
    }
}
