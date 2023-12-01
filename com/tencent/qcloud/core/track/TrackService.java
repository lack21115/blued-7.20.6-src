package com.tencent.qcloud.core.track;

import android.content.Context;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventType;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qimei.sdk.QimeiSDK;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/track/TrackService.class */
public class TrackService {
    private static final String TAG = "TrackService";
    private static String beaconKey;
    private static boolean debug = false;
    private static TrackService instance;
    private Context context;

    private TrackService(Context context) {
        this.context = context.getApplicationContext();
    }

    public static TrackService getInstance() {
        return instance;
    }

    public static void init(Context context, String str, boolean z) {
        synchronized (TrackService.class) {
            try {
                if (instance == null) {
                    instance = new TrackService(context);
                    beaconKey = str;
                    debug = z;
                    if (isIncludeBeacon()) {
                        BeaconConfig build = BeaconConfig.builder().auditEnable(false).bidEnable(false).qmspEnable(false).pagePathEnable(false).setNormalPollingTime(30000L).build();
                        BeaconReport beaconReport = BeaconReport.getInstance();
                        beaconReport.setLogAble(z);
                        try {
                            beaconReport.setCollectProcessInfo(false);
                        } catch (NoSuchMethodError e) {
                        }
                        try {
                            QimeiSDK.getInstance(str).getStrategy().enableOAID(false).enableIMEI(false).enableIMSI(false).enableAndroidId(false).enableMAC(false).enableCid(false).enableProcessInfo(false).enableBuildModel(false);
                            beaconReport.start(context, str, build);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        try {
                            beaconReport.setCollectProcessInfo(false);
                        } catch (NoSuchMethodError e3) {
                        }
                    }
                }
            } finally {
            }
        }
    }

    public static boolean isIncludeBeacon() {
        try {
            Class.forName("com.tencent.beacon.event.open.BeaconReport");
            Class.forName("com.tencent.qimei.sdk.QimeiSDK");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public void track(String str, String str2, Map<String, String> map) {
        if (isIncludeBeacon()) {
            String str3 = beaconKey;
            if (str == null) {
                str = str3;
            }
            EventResult report = BeaconReport.getInstance().report(BeaconEvent.builder().withAppKey(str).withCode(str2).withType(EventType.NORMAL).withParams(map).build());
            if (debug) {
                StringBuilder sb = new StringBuilder("{");
                for (String str4 : map.keySet()) {
                    sb.append(str4 + "=" + map.get(str4) + ", ");
                }
                sb.delete(sb.length() - 2, sb.length()).append("}");
                QCloudLogger.i(TAG, "eventCode: %s, params: %s => result{ eventID: %s, errorCode: %d, errorMsg: %s}", str2, sb, Long.valueOf(report.eventID), Integer.valueOf(report.errorCode), report.errMsg);
            }
        }
    }
}
