package com.danlan.android.cognition;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.danlan.android.cognition.collector.TotalInfoCollector;
import com.danlan.android.cognition.collector.base.BaseDeviceInfoCollector;
import com.danlan.android.cognition.collector.listener.CollectorStateObserver;
import com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener;
import com.danlan.android.cognition.collector.listener.DeviceInfoDependency;
import com.danlan.android.cognition.collector.listener.ExtraInfoFroAction;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import com.danlan.android.cognition.common.AppUtil;
import com.danlan.android.cognition.network.HttpUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/Cognition.class */
public final class Cognition implements CollectorStateObserver {
    private static volatile Cognition mInstance;
    private Context mContext;
    private DeviceInfoDependency mDependency;

    /* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/Cognition$HttpTask.class */
    public static class HttpTask implements Callable<Boolean> {
        private final String api;
        private final Context cxt;
        private final String domain;
        private final Map<String, String> headers;
        private final JSONObject requestData;
        private final String userAgent;

        public HttpTask(Context context, String str, String str2, JSONObject jSONObject, String str3, Map<String, String> map) {
            this.requestData = jSONObject;
            this.domain = str;
            this.api = str2;
            this.cxt = context;
            this.userAgent = str3;
            this.headers = map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            try {
                String sendPost = HttpUtil.sendPost(this.cxt, this.domain, this.api, this.requestData, this.userAgent, this.headers);
                if (sendPost != null) {
                    JSONObject jSONObject = new JSONObject(sendPost);
                    try {
                        String decrypt = StringFog.decrypt("YkxDTUhXTU5PcGBo");
                        Log.d(decrypt, StringFog.decrypt("elFBUFFMSlJEfg==") + jSONObject.toString(4));
                        JSONArray jSONArray = jSONObject.getJSONArray(StringFog.decrypt("RUJQQg=="));
                        if (jSONArray.length() != 0) {
                            String decrypt2 = Cryptor.decrypt(jSONArray.getJSONObject(0).getString(StringFog.decrypt("fg==")));
                            if (!TextUtils.isEmpty(decrypt2)) {
                                JSONObject jSONObject2 = new JSONObject(decrypt2);
                                int i = jSONObject2.getInt(StringFog.decrypt("QktBQEo="));
                                String string = jSONObject2.getString(StringFog.decrypt("RUZSSkJGe0hF"));
                                Logger.d(StringFog.decrypt("elFBUFFMSlJEfgRHRFVNQkR8TUcb") + string);
                                if (!TextUtils.isEmpty(string) && i == 0) {
                                    CacheDataManager.syncDeviceId(this.cxt, string);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return Boolean.TRUE;
                }
                throw new IOException(StringFog.decrypt("b0wEUURQUU1VA1ZGVVZWT0RHCg=="));
            } catch (Exception e2) {
                Logger.e(e2.getMessage());
                return Boolean.FALSE;
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/Cognition$InnerCollectListener.class */
    public class InnerCollectListener {
        private boolean hasDeviceInfoCollectListener;
        private DeviceInfoCollectListener mDeviceInfoCollectListener;

        public InnerCollectListener() {
        }
    }

    private Cognition(Context context, DeviceInfoDependency deviceInfoDependency) {
        this.mDependency = deviceInfoDependency;
        this.mContext = context;
        String packageName = context.getPackageName();
        String currentProcessName = AppUtil.getCurrentProcessName();
        if (TextUtils.isEmpty(currentProcessName) || !currentProcessName.contains(packageName) || currentProcessName.equals(packageName)) {
            NativeLib.loadSo();
            uploadForAction(0, null);
        }
    }

    private Cognition addCollector(BaseDeviceInfoCollector baseDeviceInfoCollector) {
        baseDeviceInfoCollector.bindObserver(this);
        return this;
    }

    private Cognition bindListener(InnerCollectListener innerCollectListener, DeviceInfoCollectListener deviceInfoCollectListener) {
        innerCollectListener.mDeviceInfoCollectListener = deviceInfoCollectListener;
        innerCollectListener.hasDeviceInfoCollectListener = true;
        return this;
    }

    private void checkAllDone(InnerCollectListener innerCollectListener) {
        if (innerCollectListener.hasDeviceInfoCollectListener) {
            innerCollectListener.mDeviceInfoCollectListener.onAllDone(this);
        }
    }

    private void doSingleCollectorStopRunning(InnerCollectListener innerCollectListener) {
        synchronized (this) {
            checkAllDone(innerCollectListener);
        }
    }

    public static DeviceInfoDependency getDependency() {
        if (mInstance != null) {
            return mInstance.mDependency;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SafeJSONObject getDeviceData(TotalInfoCollector totalInfoCollector) {
        return totalInfoCollector.getDeviceData();
    }

    public static String getDeviceID(Context context) {
        return CacheDataManager.getDeviceId(context);
    }

    private HashMap<String, String> getDeviceJsonInfo(TotalInfoCollector totalInfoCollector) {
        HashMap<String, String> hashMap = new HashMap<>();
        String jsonInfo = totalInfoCollector.getJsonInfo();
        hashMap.put("deviceInfo", jsonInfo);
        Logger.d(jsonInfo);
        return hashMap;
    }

    public static Cognition getInstance(Context context) {
        if (mInstance == null) {
            synchronized (Cognition.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new Cognition(context, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mInstance;
    }

    public static String getSdkVersion() {
        return BuildConfig.COGNITION_VERSION_NAME;
    }

    public static void init(Context context, DeviceInfoDependency deviceInfoDependency) {
        if (mInstance == null) {
            synchronized (Cognition.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new Cognition(context, deviceInfoDependency);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HttpTask makeUploadRequest(Context context, SafeJSONObject safeJSONObject, DeviceInfoDependency deviceInfoDependency) {
        SafeJSONObject safeJSONObject2 = new SafeJSONObject();
        String str = deviceInfoDependency.setServerDomain().get("server_domain");
        if (!CacheDataManager.hasCacheData(context)) {
            CacheDataManager.putCacheData(context, safeJSONObject);
        }
        String packageName = context.getPackageName();
        safeJSONObject2.put("data", safeJSONObject);
        safeJSONObject2.put("sdk_version", getSdkVersion());
        safeJSONObject2.put("package_name", packageName);
        safeJSONObject2.put("app_version_name", AppUtil.getVersionName(context));
        safeJSONObject2.put("app_version_code", AppUtil.getVersionCode(context));
        safeJSONObject2.put("app_name", deviceInfoDependency.setUserData().get("appName"));
        safeJSONObject2.put("channel", deviceInfoDependency.setUserData().get("channel"));
        safeJSONObject2.put("platform", "android");
        if (!CacheDataManager.checkCacheData(context, safeJSONObject)) {
            Logger.d("[checkCacheData] 当前采集的参数与缓存中的不一致，疑似设备变更");
            safeJSONObject2.put("device_id", "");
        }
        safeJSONObject2.put("device_id", CacheDataManager.getDeviceId(context));
        safeJSONObject2.put("event_time", System.currentTimeMillis());
        String str2 = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[makeUploadRequest] upload data明文-->:");
            sb.append(safeJSONObject2.toString(4));
            Logger.t(sb.toString());
            String encrypt = Cryptor.encrypt(safeJSONObject2.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[makeUploadRequest] upload data密文-->:");
            sb2.append(encrypt);
            str2 = encrypt;
            Logger.t(sb2.toString());
            str2 = encrypt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        SafeJSONObject safeJSONObject3 = new SafeJSONObject();
        safeJSONObject3.put(BridgeUtil.UNDERLINE_STR, str2);
        return new HttpTask(context, str, deviceInfoDependency.setApi().get("data_upload"), safeJSONObject3, deviceInfoDependency.setSpecialUserAgent(), deviceInfoDependency.setHeaderData());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
        if (r0.length() < 5) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb A[LOOP:0: B:28:0x00b1->B:30:0x00bb, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setCollectParam(com.danlan.android.cognition.collector.TotalInfoCollector r6, com.danlan.android.cognition.collector.listener.DeviceInfoDependency r7, int r8, com.danlan.android.cognition.collector.listener.ExtraInfoFroAction r9) {
        /*
            r5 = this;
            r0 = r7
            if (r0 == 0) goto Led
            r0 = r7
            java.util.Map r0 = r0.setUserData()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "action"
            r2 = r8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r7
            java.lang.String r1 = "oaId"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L86
            r0 = r7
            java.lang.String r1 = "oaId"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r10 = r0
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L92
            r0 = r10
            java.lang.String r1 = "NA"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L86
            r0 = r10
            java.lang.String r1 = "Kzs"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L86
            r0 = r10
            java.lang.String r1 = "00000000000000000000000000000000"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L86
            r0 = r10
            java.lang.String r1 = "00000000-0000-0000-0000-000000000000"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L86
            r0 = r10
            java.lang.String r1 = "null"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L86
            r0 = r10
            java.lang.String r1 = "KsZ"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L86
            r0 = r10
            int r0 = r0.length()
            r1 = 5
            if (r0 >= r1) goto L92
        L86:
            r0 = r7
            java.lang.String r1 = "oaId"
            java.lang.String r2 = ""
            java.lang.Object r0 = r0.put(r1, r2)
        L92:
            r0 = r9
            if (r0 == 0) goto Lda
            r0 = r9
            java.util.HashMap r0 = r0.setExtraInfo()
            r9 = r0
            r0 = r9
            if (r0 == 0) goto Lda
            r0 = r9
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
        Lb1:
            r0 = r10
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lda
            r0 = r10
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r11 = r0
            r0 = r7
            r1 = r11
            r2 = r9
            r3 = r11
            java.lang.Object r2 = r2.get(r3)
            java.lang.Object r0 = r0.put(r1, r2)
            goto Lb1
        Lda:
            r0 = r7
            java.lang.String r1 = "soLoaded"
            boolean r2 = com.danlan.android.cognition.NativeLib.getSoLoadStatus()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            goto L103
        Led:
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "soLoaded"
            boolean r2 = com.danlan.android.cognition.NativeLib.getSoLoadStatus()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
        L103:
            r0 = r6
            r1 = r7
            r0.setMapData(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.Cognition.setCollectParam(com.danlan.android.cognition.collector.TotalInfoCollector, com.danlan.android.cognition.collector.listener.DeviceInfoDependency, int, com.danlan.android.cognition.collector.listener.ExtraInfoFroAction):void");
    }

    private void startCollect(TotalInfoCollector totalInfoCollector, InnerCollectListener innerCollectListener) {
        try {
            if (innerCollectListener.hasDeviceInfoCollectListener) {
                innerCollectListener.mDeviceInfoCollectListener.onStart();
            }
            totalInfoCollector.startCollectAutomatically(innerCollectListener);
        } catch (Exception e) {
            Logger.e(e.getMessage());
        }
    }

    @Override // com.danlan.android.cognition.collector.listener.CollectorStateObserver
    public void onCollectionFailure(InnerCollectListener innerCollectListener, BaseDeviceInfoCollector baseDeviceInfoCollector, String str) {
        if (innerCollectListener.hasDeviceInfoCollectListener) {
            innerCollectListener.mDeviceInfoCollectListener.onSingleFailure(baseDeviceInfoCollector, str);
        }
        doSingleCollectorStopRunning(innerCollectListener);
    }

    @Override // com.danlan.android.cognition.collector.listener.CollectorStateObserver
    public void onCollectionSuccess(InnerCollectListener innerCollectListener, BaseDeviceInfoCollector baseDeviceInfoCollector) {
        if (innerCollectListener.hasDeviceInfoCollectListener) {
            innerCollectListener.mDeviceInfoCollectListener.onSingleSuccess(baseDeviceInfoCollector);
        }
        doSingleCollectorStopRunning(innerCollectListener);
    }

    public void uploadForAction(int i, ExtraInfoFroAction extraInfoFroAction) {
        try {
            InnerCollectListener innerCollectListener = new InnerCollectListener();
            final TotalInfoCollector totalInfoCollector = new TotalInfoCollector(this.mContext, "totalInfo");
            DeviceInfoDependency deviceInfoDependency = this.mDependency;
            if (deviceInfoDependency == null) {
                Logger.e("dependency is null");
                return;
            }
            setCollectParam(totalInfoCollector, deviceInfoDependency, i, extraInfoFroAction);
            addCollector(totalInfoCollector).bindListener(innerCollectListener, new DeviceInfoCollectListener() { // from class: com.danlan.android.cognition.Cognition.1
                @Override // com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener
                public void onAllDone(Cognition cognition) {
                    Logger.d(StringFog.decrypt("endLV0BPbU9HTGdMTU9BQlVMVn4ByqOmyLiixo+vwqmxGQ=="));
                    Executors.newSingleThreadExecutor().submit(Cognition.makeUploadRequest(Cognition.this.mContext, Cognition.this.getDeviceData(totalInfoCollector), Cognition.this.mDependency));
                }

                @Override // com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener
                public void onSingleFailure(BaseDeviceInfoCollector baseDeviceInfoCollector, String str) {
                    Logger.d(StringFog.decrypt("endLV0BPbU9HTGdMTU9BQlVMVn4BTEpySE1DT0RlRUhNVlZG"));
                }

                @Override // com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener
                public void onSingleSuccess(BaseDeviceInfoCollector baseDeviceInfoCollector) {
                    Logger.d(StringFog.decrypt("endLV0BPbU9HTGdMTU9BQlVMVn4BTEpySE1DT0RwUUJCRldQGw=="));
                }

                @Override // com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener
                public void onStart() {
                    Logger.d(StringFog.decrypt("endLV0BPbU9HTGdMTU9BQlVMVn4BxpihxISvyqakzbqnGQ=="));
                }
            });
            startCollect(totalInfoCollector, innerCollectListener);
        } catch (Exception e) {
            Logger.e(e.getMessage());
        }
    }
}
