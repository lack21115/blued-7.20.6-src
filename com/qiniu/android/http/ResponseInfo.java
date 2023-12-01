package com.qiniu.android.http;

import android.os.Process;
import android.security.KeyChain;
import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.collect.UploadInfoElement;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.common.Constants;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.Json;
import com.qiniu.android.utils.StringUtils;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.net.InetAddress;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/ResponseInfo.class */
public final class ResponseInfo {
    public static final int Cancelled = -2;
    public static final int CannotConnectToHost = -1004;
    public static final int Crc32NotMatch = -406;
    public static final int InvalidArgument = -4;
    public static final int InvalidFile = -3;
    public static final int InvalidToken = -5;
    public static final int NetworkConnectionLost = -1005;
    public static final int NetworkError = -1;
    public static final int TimedOut = -1001;
    public static final int UnknownError = 0;
    public static final int UnknownHost = -1003;
    public static final int ZeroSizeFile = -6;
    public static long bytes_sent;
    public static long requests_count;
    public final long duration;
    public final String error;
    public final String host;
    public final String ip;
    public final String path;
    public final int port;
    public final String reqId;
    public final JSONObject response;
    public final long sent;
    public final int statusCode;
    public final long totalSize;
    public final UpToken upToken;
    public String xClientId;
    public final String xlog;
    public final String xvia;
    public final String id = UserAgent.instance().id;
    public final long timeStamp = System.currentTimeMillis() / 1000;

    private ResponseInfo(JSONObject jSONObject, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, long j, long j2, String str8, UpToken upToken, long j3) {
        this.response = jSONObject;
        this.statusCode = i;
        this.xClientId = str;
        this.reqId = str2;
        this.xlog = str3;
        this.xvia = str4;
        this.host = str5;
        this.path = str6;
        this.duration = j;
        this.error = str8;
        this.ip = str7;
        this.port = i2;
        this.sent = j2;
        this.upToken = upToken;
        this.totalSize = j3;
    }

    public static ResponseInfo cancelled(UpToken upToken) {
        return create(null, null, -2, "", "", "", "", "", "", 80, -1L, -1L, "cancelled by user", upToken, 0L);
    }

    public static ResponseInfo create(final LogHandler logHandler, JSONObject jSONObject, final int i, final String str, String str2, String str3, final String str4, String str5, String str6, final int i2, long j, final long j2, final String str7, final UpToken upToken, long j3) {
        bytes_sent += j2;
        requests_count++;
        String str8 = (str6 + "").split(":")[0];
        final String substring = str8.substring(Math.max(0, str8.indexOf("/") + 1));
        ResponseInfo responseInfo = new ResponseInfo(jSONObject, i, UploadInfoElement.x_log_client_id, str, str2, str3, str4, str5, substring, i2, j, j2, str7, upToken, j3);
        if (Config.isRecord) {
            UploadInfoCollector.handleHttp(upToken, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.http.ResponseInfo.1
                @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                public String toRecordMsg() {
                    LogHandler.this.send("pid", Long.valueOf(Process.myPid()));
                    LogHandler logHandler2 = LogHandler.this;
                    if (logHandler2 == null) {
                        return "";
                    }
                    logHandler2.send("status_code", Integer.valueOf(i));
                    LogHandler.this.send("req_id", str);
                    LogHandler.this.send("host", str4);
                    LogHandler.this.send("remote_ip", substring);
                    LogHandler.this.send(KeyChain.EXTRA_PORT, Integer.valueOf(i2));
                    if (upToken.token != "" && upToken.token != null) {
                        LogHandler.this.send("target_bucket", StringUtils.getBucket(upToken.token));
                    }
                    LogHandler.this.send("bytes_sent", Long.valueOf(j2));
                    List<InetAddress> inetAddressByHost = DnsPrefetcher.getDnsPrefetcher().getInetAddressByHost(str4);
                    if (inetAddressByHost != null) {
                        LogHandler.this.send("prefetched_ip_count", Long.valueOf(inetAddressByHost.size()));
                    }
                    String str9 = str7;
                    if (str9 != null) {
                        LogHandler.this.send(PushMessageHelper.ERROR_TYPE, UploadInfoElement.errorType(i, str9));
                        LogHandler.this.send("error_description", str7);
                    }
                    UploadInfoElement.ReqInfo reqInfo = (UploadInfoElement.ReqInfo) LogHandler.this.getUploadInfo();
                    UploadInfoElementCollector.setReqCommonElements(reqInfo);
                    return Json.object2Json(reqInfo);
                }
            });
        }
        return responseInfo;
    }

    public static ResponseInfo errorInfo(ResponseInfo responseInfo, int i, String str) {
        return new ResponseInfo(responseInfo.response, i, UploadInfoElement.x_log_client_id, responseInfo.reqId, responseInfo.xlog, responseInfo.xvia, responseInfo.host, responseInfo.path, responseInfo.ip, responseInfo.port, responseInfo.duration, responseInfo.sent, str, responseInfo.upToken, responseInfo.totalSize);
    }

    public static ResponseInfo fileError(Exception exc, UpToken upToken) {
        return create(null, null, -3, "", "", "", "", "", "", 80, 0L, 0L, exc.getMessage(), upToken, 0L);
    }

    private static String getUpType(String str) {
        if (str == null || !str.startsWith("/")) {
            return "";
        }
        if ("/".equals(str)) {
            return "form";
        }
        int indexOf = str.indexOf(47, 1);
        if (indexOf < 1) {
            return "";
        }
        String substring = str.substring(1, indexOf);
        boolean z = true;
        switch (substring.hashCode()) {
            case -1072430054:
                if (substring.equals("mkfile")) {
                    z = true;
                    break;
                }
                break;
            case 111375:
                if (substring.equals("put")) {
                    z = true;
                    break;
                }
                break;
            case 3030893:
                if (substring.equals("bput")) {
                    z = true;
                    break;
                }
                break;
            case 103949059:
                if (substring.equals("mkblk")) {
                    z = false;
                    break;
                }
                break;
        }
        return z ? !z ? !z ? !z ? "" : "put" : "mkfile" : "bput" : "mkblk";
    }

    public static ResponseInfo invalidArgument(String str, UpToken upToken) {
        return create(null, null, -4, "", "", "", "", "", "", 80, 0L, 0L, str, upToken, 0L);
    }

    public static ResponseInfo invalidToken(String str) {
        return create(null, null, -5, "", "", "", "", "", "", 80, 0L, 0L, str, null, 0L);
    }

    public static boolean isStatusCodeForBrokenNetwork(int i) {
        return i == -1 || i == -1003 || i == -1004 || i == -1001 || i == -1005;
    }

    public static ResponseInfo networkError(int i, UpToken upToken) {
        return create(null, null, i, "", "", "", "", "", "", 80, 0L, 0L, "Network error during preQuery, Please check your network or use http try again", upToken, 0L);
    }

    public static ResponseInfo zeroSize(UpToken upToken) {
        return create(null, null, -6, "", "", "", "", "", "", 80, 0L, 0L, "file or data size is zero", upToken, 0L);
    }

    public boolean hasReqId() {
        return this.reqId != null;
    }

    public boolean isCancelled() {
        return this.statusCode == -2;
    }

    public boolean isNetworkBroken() {
        int i = this.statusCode;
        return i == -1 || i == -1003 || i == -1004 || i == -1001 || i == -1005;
    }

    public boolean isNotQiniu() {
        int i = this.statusCode;
        return i < 500 && i >= 200 && !hasReqId() && this.response == null;
    }

    public boolean isOK() {
        if (this.statusCode == 200 && this.error == null) {
            return hasReqId() || this.response != null;
        }
        return false;
    }

    public boolean isServerError() {
        int i = this.statusCode;
        return (i >= 500 && i < 600 && i != 579) || this.statusCode == 996;
    }

    public boolean needRetry() {
        int i;
        if (isCancelled()) {
            return false;
        }
        if (needSwitchServer() || (i = this.statusCode) == 406) {
            return true;
        }
        if (i != 200 || this.error == null) {
            return isNotQiniu() && !this.upToken.hasReturnUrl();
        }
        return true;
    }

    public boolean needSwitchServer() {
        return isNetworkBroken() || isServerError();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "{ver:%s,ResponseInfo:%s,status:%d, xClientId:%s, reqId:%s, xlog:%s, xvia:%s, host:%s, path:%s, ip:%s, port:%d, duration:%d s, time:%d, sent:%d,error:%s}", Constants.VERSION, this.id, Integer.valueOf(this.statusCode), this.xClientId, this.reqId, this.xlog, this.xvia, this.host, this.path, this.ip, Integer.valueOf(this.port), Long.valueOf(this.duration), Long.valueOf(this.timeStamp), Long.valueOf(this.sent), this.error);
    }
}
