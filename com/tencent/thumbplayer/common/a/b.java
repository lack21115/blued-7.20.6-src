package com.tencent.thumbplayer.common.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.tvkbeacon.event.open.BeaconConfig;
import com.tencent.tvkbeacon.event.open.BeaconEvent;
import com.tencent.tvkbeacon.event.open.BeaconReport;
import com.tencent.tvkbeacon.event.open.EventResult;
import com.tencent.tvkbeacon.event.open.EventType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/common/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f39268a = false;

    public static void a(Context context) {
        TPLogUtil.i("TPBeaconReportWrapper", "Beacon sdk init start.");
        if (f39268a) {
            BeaconConfig.Builder builder = BeaconConfig.builder();
            builder.auditEnable(false);
            BeaconReport.getInstance().setModel(TPSystemInfo.getDeviceName());
            if (!TextUtils.isEmpty(TPPlayerConfig.beacon_policy_host) && !TextUtils.isEmpty(TPPlayerConfig.beacon_log_host)) {
                builder.setConfigHost(TPPlayerConfig.beacon_policy_host);
                builder.setUploadHost(TPPlayerConfig.beacon_log_host);
            }
            BeaconReport.getInstance().setLogAble(false);
            BeaconReport.getInstance().setOstar("00000GODBG3702Y1", TPPlayerConfig.getGuid());
            BeaconReport.getInstance().start(context.getApplicationContext(), "00000GODBG3702Y1", builder.build());
        }
    }

    public static void a(String str, a aVar) {
        HashMap hashMap = new HashMap();
        aVar.a(hashMap);
        a(str, "00000GODBG3702Y1", hashMap);
    }

    public static void a(String str, String str2, Map<String, String> map) {
        if (f39268a && TPPlayerConfig.isDataReportEnable() && TPPlayerConfig.isPlayerReportEnable()) {
            EventResult report = BeaconReport.getInstance().report(BeaconEvent.builder().withCode(str).withType(EventType.NORMAL).withAppKey(str2).withParams(map).build());
            if (report.errorCode != 0) {
                TPLogUtil.w("TPBeaconReportWrapper", "reportEvent: failed! eventId = " + report.eventID + ", errorCode=" + report.errorCode);
            }
        }
    }

    public static void a(String str, Map<String, String> map) {
        a(str, "00000GODBG3702Y1", map);
    }
}
