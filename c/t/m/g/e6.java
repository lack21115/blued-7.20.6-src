package c.t.m.g;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.ads.fw;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e6.class */
public class e6 {
    public static HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("https", fw.Code);
        hashMap.put("up_apps", fw.Code);
        hashMap.put("start_daemon", "false");
        hashMap.put("up_daemon_delay", "300000");
        hashMap.put("gps_kalman", "false");
        hashMap.put("callback_wifis", "false");
        hashMap.put("min_wifi_scan_interval", "8000");
        hashMap.put("collect_bles", fw.Code);
        hashMap.put("start_event_track", fw.Code);
        hashMap.put("f_coll_item", "2");
        hashMap.put("f_coll_up_net", IAdInterListener.AdReqParam.WIDTH);
        hashMap.put("enable_wifi_native_sort", fw.Code);
        hashMap.put("enable_invoke_map", "false");
        hashMap.put("deny_secret_info", "false");
        return hashMap;
    }
}
