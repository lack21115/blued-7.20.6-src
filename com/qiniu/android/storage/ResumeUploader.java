package com.qiniu.android.storage;

import android.os.Process;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfo;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.collect.UploadInfoElement;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.DnsPrefetcher;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.Json;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.UrlSafeBase64;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/ResumeUploader.class */
final class ResumeUploader implements Runnable {
    private final byte[] chunkBuffer;
    private final Client client;
    private final UpCompletionHandler completionHandler;
    private final Configuration config;
    private final String[] contexts;
    private long crc32;
    private File f;
    private RandomAccessFile file;
    private final StringMap headers;
    private final String key;
    private final long modifyTime;
    private final UploadOptions options;
    private final String recorderKey;
    private long recover_from;
    private UpToken token;
    private final long totalSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.client = client;
        this.config = configuration;
        this.f = file;
        this.recorderKey = str2;
        this.totalSize = file.length();
        this.key = str;
        StringMap stringMap = new StringMap();
        this.headers = stringMap.put("Authorization", "UpToken " + upToken.token);
        this.file = null;
        this.completionHandler = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
            @Override // com.qiniu.android.storage.UpCompletionHandler
            public void complete(String str3, ResponseInfo responseInfo, JSONObject jSONObject) {
                if (ResumeUploader.this.file != null) {
                    try {
                        ResumeUploader.this.file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                upCompletionHandler.complete(str3, responseInfo, jSONObject);
            }
        };
        this.options = uploadOptions == null ? UploadOptions.defaultOptions() : uploadOptions;
        this.chunkBuffer = new byte[configuration.chunkSize];
        this.contexts = new String[(int) (((this.totalSize + STMobileHumanActionNative.ST_MOBILE_HAND_666) - 1) / STMobileHumanActionNative.ST_MOBILE_HAND_666)];
        this.modifyTime = file.lastModified();
        this.token = upToken;
    }

    private long calcBlockSize(long j) {
        long j2 = this.totalSize - j;
        return j2 < STMobileHumanActionNative.ST_MOBILE_HAND_666 ? j2 : STMobileHumanActionNative.ST_MOBILE_HAND_666;
    }

    private long calcPutSize(long j) {
        long j2 = this.totalSize - j;
        return j2 < ((long) this.config.chunkSize) ? j2 : this.config.chunkSize;
    }

    private boolean isCancelled() {
        return this.options.cancellationSignal.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isChunkOK(ResponseInfo responseInfo, JSONObject jSONObject) {
        if (responseInfo.statusCode == 200 && responseInfo.error == null) {
            return responseInfo.hasReqId() || isChunkResOK(jSONObject);
        }
        return false;
    }

    private static boolean isChunkResOK(JSONObject jSONObject) {
        try {
            jSONObject.getString("ctx");
            jSONObject.getLong("crc32");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNotChunkToQiniu(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.hasReqId() && !isChunkResOK(jSONObject);
    }

    private void makeBlock(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        uplogHandler.send("target_key", this.key);
        uplogHandler.send("up_type", "mkblk");
        uplogHandler.send("tid", Long.valueOf(Process.myTid()));
        uplogHandler.send("file_offset", Long.valueOf(j));
        uplogHandler.send("bytes_total", Long.valueOf(i2));
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.chunkBuffer, 0, i2);
            this.crc32 = Crc32.bytes(this.chunkBuffer, 0, i2);
            post(uplogHandler, String.format("%s%s", str, format), this.chunkBuffer, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.completionHandler.complete(this.key, ResponseInfo.fileError(e, this.token), null);
        }
    }

    private void makeFile(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        uplogHandler.send("target_key", this.key);
        uplogHandler.send("up_type", "mkfile");
        uplogHandler.send("tid", Long.valueOf(Process.myTid()));
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.encodeToString(this.options.mimeType), UrlSafeBase64.encodeToString(this.f.getName()));
        String str2 = this.key;
        String str3 = "";
        String format2 = str2 != null ? String.format("/key/%s", UrlSafeBase64.encodeToString(str2)) : "";
        if (this.options.params.size() != 0) {
            String[] strArr = new String[this.options.params.size()];
            Iterator<Map.Entry<String, String>> it = this.options.params.entrySet().iterator();
            int i = 0;
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                strArr[i2] = String.format(Locale.ENGLISH, "%s/%s", next.getKey(), UrlSafeBase64.encodeToString(next.getValue()));
                i = i2 + 1;
            }
            str3 = BridgeUtil.SPLIT_MARK + StringUtils.join(strArr, BridgeUtil.SPLIT_MARK);
        }
        String format3 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.totalSize), format, format2, str3);
        byte[] bytes = StringUtils.join(this.contexts, ",").getBytes();
        String format4 = String.format("%s%s", str, format3);
        uplogHandler.send("file_offset", 0);
        uplogHandler.send("bytes_total", Long.valueOf(bytes.length));
        post(uplogHandler, format4, bytes, 0, bytes.length, null, completionHandler, upCancellationSignal);
    }

    private URI newURI(URI uri, String str) {
        try {
            return new URI(uri.getScheme(), null, uri.getHost(), uri.getPort(), str, null, null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextTask(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.completionHandler.complete(this.key, ResponseInfo.cancelled(this.token), null);
        } else if (j == this.totalSize) {
            makeFile(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void complete(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String upHost;
                    if (responseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
                        ResumeUploader.this.options.netReadyHandler.waitReady();
                        if (!AndroidNetwork.isNetWorkReady()) {
                            ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isOK()) {
                        ResumeUploader.this.removeRecord();
                        ResumeUploader.this.options.progressHandler.progress(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.needRetry() || i >= ResumeUploader.this.config.retryMax + 1 || (upHost = ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, str)) == null) {
                        ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.nextTask(j, i + 1, upHost);
                    }
                }
            }, this.options.cancellationSignal);
        } else {
            final int calcPutSize = (int) calcPutSize(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    double d2 = d;
                    if (d > 0.95d) {
                        d2 = 0.95d;
                    }
                    ResumeUploader.this.options.progressHandler.progress(ResumeUploader.this.key, d2);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void complete(final ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    String str3;
                    final long myTid = Process.myTid();
                    UploadInfoCollector.handleHttp(ResumeUploader.this.token, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.ResumeUploader.4.1
                        @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                        public String toRecordMsg() {
                            LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getBlockInfo());
                            UpToken.setCurrent_region_id(uplogHandler, str);
                            uplogHandler.send("target_region_id", DnsPrefetcher.target_region_id);
                            uplogHandler.send("total_elapsed_time", Long.valueOf(responseInfo.duration));
                            uplogHandler.send("bytes_sent", Long.valueOf(responseInfo.sent));
                            uplogHandler.send("recovered_from", Long.valueOf(ResumeUploader.this.recover_from));
                            uplogHandler.send("file_size", Long.valueOf(ResumeUploader.this.totalSize));
                            uplogHandler.send("pid", Long.valueOf(Process.myPid()));
                            uplogHandler.send("tid", Long.valueOf(myTid));
                            uplogHandler.send("up_api_version", 1);
                            uplogHandler.send("up_time", Long.valueOf(System.currentTimeMillis() / 1000));
                            return Json.object2Json((UploadInfoElement.BlockInfo) uplogHandler.getUploadInfo());
                        }
                    });
                    if (responseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
                        ResumeUploader.this.options.netReadyHandler.waitReady();
                        if (!AndroidNetwork.isNetWorkReady()) {
                            ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.isChunkOK(responseInfo, jSONObject)) {
                        String upHost = ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.config.retryMax) {
                            ResumeUploader.this.nextTask((j / STMobileHumanActionNative.ST_MOBILE_HAND_666) * STMobileHumanActionNative.ST_MOBILE_HAND_666, i + 1, str);
                        } else if (upHost == null || (!(ResumeUploader.isNotChunkToQiniu(responseInfo, jSONObject) || responseInfo.needRetry()) || i >= ResumeUploader.this.config.retryMax)) {
                            ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.nextTask(j, i + 1, upHost);
                        }
                    } else if (jSONObject == null && i < ResumeUploader.this.config.retryMax) {
                        ResumeUploader.this.nextTask(j, i + 1, ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, str));
                    } else {
                        long j2 = 0;
                        Exception e = null;
                        try {
                            str2 = jSONObject.getString("ctx");
                        } catch (Exception e2) {
                            e = e2;
                            str2 = null;
                        }
                        try {
                            j2 = jSONObject.getLong("crc32");
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (str2 == null) {
                            }
                            ResumeUploader.this.nextTask(j, i + 1, ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, str));
                        }
                        if (!(str2 == null && j2 == ResumeUploader.this.crc32) && i < ResumeUploader.this.config.retryMax) {
                            ResumeUploader.this.nextTask(j, i + 1, ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, str));
                        } else if (str2 == null) {
                            if (e != null) {
                                str3 = "get context failed.\n" + e.getMessage();
                            } else {
                                str3 = "get context failed.";
                            }
                            ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, ResponseInfo.errorInfo(responseInfo, 0, str3), jSONObject);
                        } else if (j2 == ResumeUploader.this.crc32) {
                            String[] strArr = ResumeUploader.this.contexts;
                            long j3 = j;
                            strArr[(int) (j3 / STMobileHumanActionNative.ST_MOBILE_HAND_666)] = str2;
                            ResumeUploader.this.record(j3 + calcPutSize);
                            ResumeUploader.this.nextTask(j + calcPutSize, i, str);
                        } else {
                            ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, ResponseInfo.errorInfo(responseInfo, ResponseInfo.Crc32NotMatch, "block's crc32 is not match. local: " + ResumeUploader.this.crc32 + ", remote: " + j2), jSONObject);
                        }
                    }
                }
            };
            if (j % STMobileHumanActionNative.ST_MOBILE_HAND_666 == 0) {
                makeBlock(str, j, (int) calcBlockSize(j), calcPutSize, progressHandler, completionHandler, this.options.cancellationSignal);
            } else {
                putChunk(str, j, calcPutSize, this.contexts[(int) (j / STMobileHumanActionNative.ST_MOBILE_HAND_666)], progressHandler, completionHandler, this.options.cancellationSignal);
            }
        }
    }

    private void post(LogHandler logHandler, String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.client.asyncPost(logHandler, str, bArr, i, i2, this.headers, this.token, this.totalSize, progressHandler, completionHandler, upCancellationSignal);
    }

    private void putChunk(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        uplogHandler.send("target_key", this.key);
        uplogHandler.send("up_type", "bput");
        uplogHandler.send("tid", Long.valueOf(Process.myTid()));
        uplogHandler.send("file_offset", Long.valueOf(j));
        uplogHandler.send("bytes_total", Long.valueOf(i));
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % STMobileHumanActionNative.ST_MOBILE_HAND_666)));
        try {
            this.file.seek(j);
            this.file.read(this.chunkBuffer, 0, i);
            this.crc32 = Crc32.bytes(this.chunkBuffer, 0, i);
            post(uplogHandler, String.format("%s%s", str, format), this.chunkBuffer, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.completionHandler.complete(this.key, ResponseInfo.fileError(e, this.token), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void record(long j) {
        if (this.config.recorder == null || j == 0) {
            return;
        }
        this.config.recorder.set(this.recorderKey, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.totalSize), Long.valueOf(j), Long.valueOf(this.modifyTime), StringUtils.jsonJoin(this.contexts)).getBytes());
    }

    private long recoveryFromRecord() {
        byte[] bArr;
        if (this.config.recorder == null || (bArr = this.config.recorder.get(this.recorderKey)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong("size", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.modifyTime || optLong3 != this.totalSize || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return optLong;
                }
                this.contexts[i2] = optJSONArray.optString(i2);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRecord() {
        if (this.config.recorder != null) {
            this.config.recorder.del(this.recorderKey);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        long recoveryFromRecord = recoveryFromRecord();
        if (recoveryFromRecord > 0) {
            this.recover_from = recoveryFromRecord;
        }
        try {
            this.file = new RandomAccessFile(this.f, "r");
            nextTask(recoveryFromRecord, 0, this.config.zone.upHost(this.token.token, this.config.useHttps, (String) null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.completionHandler.complete(this.key, ResponseInfo.fileError(e, this.token), null);
        }
    }
}
