package com.heytap.baselib.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.heytap.baselib.appcompat.PermissionChecker;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/ClientIdUtils.class */
public class ClientIdUtils {
    private static String EMPTY_ID = "";
    private static String EXTRAS_KEY_CLIENT_ID = "clientId";
    private static String EXTRAS_KEY_GEN = "G0";
    public static ClientIdUtils INSTANCE = new ClientIdUtils();
    private static String KEY_CLIENT_ID = "clientId";
    private static String KEY_LOCAL_ID = "localId";
    private static String NAME_CLIENT_INFO = "e3c9997fed83a974";
    private String localIdCache;
    private volatile IDResult result;
    public final String MCS_HIDDEN_FILE_STORAGE_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator + ".mcs";
    public final String MCS_CONTROL_PULL_MSG_INFO_FILE_PATH = this.MCS_HIDDEN_FILE_STORAGE_PATH + File.separator + "mcs_msg.ini";
    public final String CLIENT_INFO_FILE_PATH = this.MCS_HIDDEN_FILE_STORAGE_PATH + File.separator + NAME_CLIENT_INFO + ".ini";

    private ClientIdUtils() {
    }

    private IDResult getClientIdFromSdcard(Context context) {
        IDResult readLocalIdFromSdcard = readLocalIdFromSdcard(context);
        if (!TextUtils.isEmpty(readLocalIdFromSdcard.mResult)) {
            this.localIdCache = readLocalIdFromSdcard.mResult;
            return readLocalIdFromSdcard;
        }
        this.localIdCache = ClientIdHelper.buildClientId();
        readLocalIdFromSdcard.retCode = Constant.RET_CODE_LOCAL_CODE_NEW;
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("自动生成ClientId：" + this.localIdCache);
        }
        writeLocalId(context, this.localIdCache);
        readLocalIdFromSdcard.mResult = this.localIdCache;
        return readLocalIdFromSdcard;
    }

    private IDResult getClientIdWithRetCode(Context context) {
        IDResult iDResult;
        int i;
        if (this.result == null) {
            synchronized (ClientIdUtils.class) {
                try {
                    if (this.result == null) {
                        this.result = obtainClientId(context, true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (!TextUtils.isEmpty(this.result.mResult)) {
            if (ClientIdHelper.hasIMEIRetCode(this.result.retCode)) {
                iDResult = this.result;
                i = Constant.RET_CODE_IMEI_CACHED;
            } else if (ClientIdHelper.hasLocalIDRetCode(this.result.retCode)) {
                iDResult = this.result;
                i = (this.result.retCode & Color.MAGENTA) | Constant.RET_CODE_LOCAL_CODE_CACHED;
            }
            iDResult.retCode = i;
        }
        return this.result;
    }

    private IDResult getIMEI(Context context) {
        IDResult reflectCImei = ImeiHelper.reflectCImei(context);
        IDResult iDResult = reflectCImei;
        if (TextUtils.isEmpty(reflectCImei.mResult)) {
            IDResult iDResult2 = reflectCImei;
            if (Build.VERSION.SDK_INT >= 28) {
                iDResult2 = ImeiHelper.getImeiWhenP(context);
            }
            IDResult iDResult3 = iDResult2;
            if (TextUtils.isEmpty(iDResult2.mResult)) {
                iDResult3 = iDResult2;
                if (Build.VERSION.SDK_INT >= 26) {
                    iDResult3 = ImeiHelper.getImeiWhenO(context);
                }
            }
            iDResult = iDResult3;
            if (TextUtils.isEmpty(iDResult3.mResult)) {
                iDResult = ImeiHelper.getDeviceIdBelowO(context);
            }
        }
        if (ClientIdHelper.isInvalidClientId(iDResult.mResult)) {
            iDResult.mResult = null;
        }
        return iDResult;
    }

    private IDResult obtainClientId(Context context, boolean z) {
        return (PropertyUtils.isOTV(context) || PropertyUtils.isOPTV(context)) ? OptvDevUtil.getUUIDWithRetCode() : obtainPhoneClientId(context, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (android.text.TextUtils.isEmpty(r0.mResult) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.heytap.baselib.utils.IDResult obtainPhoneClientId(android.content.Context r5, boolean r6) {
        /*
            r4 = this;
            r0 = r5
            android.content.Context r0 = r0.getApplicationContext()
            r9 = r0
            boolean r0 = com.heytap.baselib.utils.ClientIdEnvironment.debug
            if (r0 == 0) goto L11
            java.lang.String r0 = "开始获取系统Imei"
            com.heytap.baselib.utils.ClientIdEnvironment.log(r0)
        L11:
            r0 = r4
            r1 = r9
            com.heytap.baselib.utils.IDResult r0 = r0.getIMEI(r1)
            r8 = r0
            boolean r0 = com.heytap.baselib.utils.ClientIdEnvironment.debug
            if (r0 == 0) goto L24
            java.lang.String r0 = "系统Imei:已获取"
            com.heytap.baselib.utils.ClientIdEnvironment.log(r0)
        L24:
            r0 = r8
            if (r0 == 0) goto L37
            r0 = r8
            r5 = r0
            r0 = r8
            java.lang.String r0 = r0.mResult
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L8a
        L37:
            r0 = r8
            r5 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L8a
            boolean r0 = com.heytap.baselib.utils.ClientIdEnvironment.debug
            if (r0 == 0) goto L65
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "系统LocalID: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r0 = r0.toString()
            com.heytap.baselib.utils.ClientIdEnvironment.log(r0)
        L65:
            r0 = r8
            int r0 = r0.retCode
            r7 = r0
            r0 = r6
            if (r0 == 0) goto L79
            r0 = r4
            r1 = r9
            com.heytap.baselib.utils.IDResult r0 = r0.getLocalId(r1)
            r5 = r0
            goto L80
        L79:
            r0 = r4
            r1 = r9
            com.heytap.baselib.utils.IDResult r0 = r0.getClientIdFromSdcard(r1)
            r5 = r0
        L80:
            r0 = r5
            r1 = r5
            int r1 = r1.retCode
            r2 = r7
            r1 = r1 | r2
            r0.retCode = r1
        L8a:
            r0 = r5
            java.lang.String r0 = r0.mResult
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lb6
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto Lb6
            r0 = r5
            r1 = r5
            int r1 = r1.retCode
            r2 = -65281(0xffffffffffff00ff, float:NaN)
            r1 = r1 & r2
            int r2 = com.heytap.baselib.utils.Constant.RET_CODE_VERSION_ABOVE_Q
            r1 = r1 | r2
            r0.retCode = r1
            boolean r0 = com.heytap.baselib.utils.ClientIdEnvironment.debug
            if (r0 == 0) goto Lb6
            java.lang.String r0 = "Android版本大于等于Q"
            com.heytap.baselib.utils.ClientIdEnvironment.log(r0)
        Lb6:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.baselib.utils.ClientIdUtils.obtainPhoneClientId(android.content.Context, boolean):com.heytap.baselib.utils.IDResult");
    }

    private String readLocalIdFromMcsControlPullMsgInfoFilePath() {
        String readFileContent = idIOUtil.readFileContent(this.MCS_CONTROL_PULL_MSG_INFO_FILE_PATH);
        String str = null;
        if (!TextUtils.isEmpty(readFileContent)) {
            String string = idIOUtil.getString(readFileContent, null, EXTRAS_KEY_CLIENT_ID, EMPTY_ID);
            str = null;
            if (ClientIdHelper.isGeneratedClientId(string)) {
                str = string;
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.heytap.baselib.utils.IDResult readLocalIdFromSdcard(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.baselib.utils.ClientIdUtils.readLocalIdFromSdcard(android.content.Context):com.heytap.baselib.utils.IDResult");
    }

    private void writeLocalId(Context context, String str) {
        try {
            ClientIdSharedPreferences.set(context, str);
            if (PermissionChecker.checkCallingOrSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                idIOUtil.encryptTo(str.getBytes(), new File(this.CLIENT_INFO_FILE_PATH));
            }
        } catch (Exception e) {
        }
    }

    public Map<String, String> buildIdMap(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_CLIENT_ID, getClientId(context));
        IDResult localId = getLocalId(context);
        hashMap.put(KEY_LOCAL_ID, localId == null ? EMPTY_ID : localId.mResult);
        return hashMap;
    }

    public String getClientId(Context context) {
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("开始执行getClientId");
        }
        IDResult clientIdWithRetCode = getClientIdWithRetCode(context);
        String str = clientIdWithRetCode == null ? "" : clientIdWithRetCode.mResult;
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("结束执行getClientId");
        }
        return str != null ? str : EMPTY_ID;
    }

    public ClientIdInfo getClientIdInfo(Context context) {
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("开始执行getClientIdInfo");
        }
        ClientIdInfo clientIdInfo = new ClientIdInfo(getClientIdWithRetCode(context));
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("结束执行getClientIdInfo");
        }
        return clientIdInfo;
    }

    IDResult getLocalId(Context context) {
        if (TextUtils.isEmpty(this.localIdCache)) {
            return getClientIdFromSdcard(context);
        }
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("返回内存localId：" + this.localIdCache);
        }
        return new IDResult(this.localIdCache, Constant.RET_CODE_LOCAL_CODE_CACHED);
    }

    public String refreshClientId(Context context) {
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("开始执行refreshClientId");
        }
        this.result = obtainClientId(context, false);
        String str = this.result == null ? EMPTY_ID : this.result.mResult;
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("结束执行refreshClientId");
        }
        return str != null ? str : EMPTY_ID;
    }

    public String refreshClientIdForImei(Context context) {
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("开始执行refreshClientIdForImei");
        }
        this.result = obtainClientId(context, true);
        String str = this.result == null ? EMPTY_ID : this.result.mResult;
        if (ClientIdEnvironment.debug) {
            ClientIdEnvironment.log("结束执行refreshClientIdForImei");
        }
        return str != null ? str : EMPTY_ID;
    }

    @Deprecated
    public String tryNewClientId(Context context) {
        return refreshClientIdForImei(context);
    }
}
