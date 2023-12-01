package com.qiniu.android.storage;

import android.os.Process;
import com.cdo.oaps.ad.OapsKey;
import com.igexin.push.core.b;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/ResumeUploaderFast.class */
public class ResumeUploaderFast implements Runnable {
    private Map<Long, Integer> blockInfo;
    private final Client client;
    private final UpCompletionHandler completionHandler;
    private final Configuration config;
    private final String[] contexts;
    private File f;
    private RandomAccessFile file;
    private final StringMap headers;
    private final String key;
    private final long modifyTime;
    private int multithread;
    private Long[] offsets;
    private final UploadOptions options;
    private final String recorderKey;
    private long recover_from;
    AtomicInteger tblock;
    private UpToken token;
    private final long totalSize;
    AtomicReference upHost = new AtomicReference();
    AtomicInteger retried = new AtomicInteger(0);
    AtomicInteger singleDomainRetry = new AtomicInteger(0);
    private boolean isFirstTask = true;
    private int upBlock = 0;
    private final int domainRetry = 3;
    private boolean isInterrupted = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/ResumeUploaderFast$BlockElement.class */
    public class BlockElement {
        private int blocksize;
        private long offset;

        BlockElement(long j, int i) {
            this.offset = j;
            this.blocksize = i;
        }

        public int getBlocksize() {
            return this.blocksize;
        }

        public long getOffset() {
            return this.offset;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/ResumeUploaderFast$UploadThread.class */
    class UploadThread extends Thread {
        private int blockSize;
        private long offset;
        private String upHost;

        UploadThread(long j, int i, String str) {
            this.offset = j;
            this.blockSize = i;
            this.upHost = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            ResumeUploaderFast.this.mkblk(this.offset, this.blockSize, this.upHost);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploaderFast(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2, int i) {
        this.client = client;
        this.config = configuration;
        this.f = file;
        this.recorderKey = str2;
        this.totalSize = file.length();
        this.key = str;
        StringMap stringMap = new StringMap();
        this.headers = stringMap.put("Authorization", "UpToken " + upToken.token);
        this.file = null;
        this.multithread = i;
        this.completionHandler = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploaderFast.1
            @Override // com.qiniu.android.storage.UpCompletionHandler
            public void complete(String str3, ResponseInfo responseInfo, JSONObject jSONObject) {
                if (ResumeUploaderFast.this.file != null) {
                    try {
                        ResumeUploaderFast.this.file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (this) {
                    if (ResumeUploaderFast.this.isInterrupted) {
                        return;
                    }
                    ResumeUploaderFast.this.isInterrupted = true;
                    upCompletionHandler.complete(str3, responseInfo, jSONObject);
                }
            }
        };
        this.options = uploadOptions == null ? UploadOptions.defaultOptions() : uploadOptions;
        AtomicInteger atomicInteger = new AtomicInteger(((int) ((this.totalSize + STMobileHumanActionNative.ST_MOBILE_HAND_666) - 1)) / 4194304);
        this.tblock = atomicInteger;
        this.offsets = new Long[atomicInteger.get()];
        this.contexts = new String[this.tblock.get()];
        this.modifyTime = file.lastModified();
        this.token = upToken;
        this.blockInfo = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkRetried() {
        return this.retried.get() < 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BlockElement getBlockInfo() {
        BlockElement blockElement;
        synchronized (this) {
            Iterator<Map.Entry<Long, Integer>> it = this.blockInfo.entrySet().iterator();
            long j = 0;
            int i = 0;
            if (it.hasNext()) {
                Map.Entry<Long, Integer> next = it.next();
                j = next.getKey().longValue();
                i = next.getValue().intValue();
                this.blockInfo.remove(Long.valueOf(j));
            }
            blockElement = new BlockElement(j, i);
        }
        return blockElement;
    }

    private CompletionHandler getCompletionHandler(final long j, final int i, final long j2) {
        return new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploaderFast.4
            @Override // com.qiniu.android.http.CompletionHandler
            public void complete(final ResponseInfo responseInfo, JSONObject jSONObject) {
                String str;
                long j3;
                String str2;
                final long myTid = Process.myTid();
                UploadInfoCollector.handleHttp(ResumeUploaderFast.this.token, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.ResumeUploaderFast.4.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String toRecordMsg() {
                        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getBlockInfo());
                        UpToken.setCurrent_region_id(uplogHandler, ResumeUploaderFast.this.upHost.get().toString());
                        uplogHandler.send("target_region_id", DnsPrefetcher.target_region_id);
                        uplogHandler.send("total_elapsed_time", Long.valueOf(responseInfo.duration));
                        uplogHandler.send("bytes_sent", Long.valueOf(responseInfo.sent));
                        uplogHandler.send("recovered_from", Long.valueOf(ResumeUploaderFast.this.recover_from));
                        uplogHandler.send("file_size", Long.valueOf(ResumeUploaderFast.this.totalSize));
                        uplogHandler.send("pid", Long.valueOf(Process.myPid()));
                        uplogHandler.send("tid", Long.valueOf(myTid));
                        uplogHandler.send("up_api_version", 1);
                        uplogHandler.send("up_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        return Json.object2Json((UploadInfoElement.BlockInfo) uplogHandler.getUploadInfo());
                    }
                });
                if (responseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
                    ResumeUploaderFast.this.options.netReadyHandler.waitReady();
                    if (!AndroidNetwork.isNetWorkReady()) {
                        ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, responseInfo, jSONObject);
                        return;
                    }
                }
                if (responseInfo.isCancelled()) {
                    ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, responseInfo, jSONObject);
                } else if (!ResumeUploaderFast.this.isChunkOK(responseInfo, jSONObject)) {
                    if (responseInfo.statusCode == 701 && ResumeUploaderFast.this.checkRetried()) {
                        ResumeUploaderFast.this.updateRetried();
                        ResumeUploaderFast resumeUploaderFast = ResumeUploaderFast.this;
                        resumeUploaderFast.mkblk(j, i, resumeUploaderFast.upHost.get().toString());
                    } else if (ResumeUploaderFast.this.upHost == null || !((ResumeUploaderFast.this.isNotChunkToQiniu(responseInfo, jSONObject) || responseInfo.needRetry()) && ResumeUploaderFast.this.checkRetried())) {
                        ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploaderFast.this.updateRetried();
                        ResumeUploaderFast resumeUploaderFast2 = ResumeUploaderFast.this;
                        resumeUploaderFast2.mkblk(j, i, resumeUploaderFast2.upHost.get().toString());
                    }
                } else if (jSONObject == null && ResumeUploaderFast.this.checkRetried()) {
                    ResumeUploaderFast.this.updateRetried();
                    ResumeUploaderFast resumeUploaderFast3 = ResumeUploaderFast.this;
                    resumeUploaderFast3.mkblk(j, i, resumeUploaderFast3.upHost.get().toString());
                } else {
                    Exception e = null;
                    try {
                        str = jSONObject.getString("ctx");
                        try {
                            j3 = jSONObject.getLong("crc32");
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            j3 = 0;
                            if (str == null) {
                            }
                            ResumeUploaderFast.this.updateRetried();
                            ResumeUploaderFast resumeUploaderFast4 = ResumeUploaderFast.this;
                            resumeUploaderFast4.mkblk(j, i, resumeUploaderFast4.upHost.get().toString());
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = null;
                    }
                    if (!(str == null && j3 == j2) && ResumeUploaderFast.this.checkRetried()) {
                        ResumeUploaderFast.this.updateRetried();
                        ResumeUploaderFast resumeUploaderFast42 = ResumeUploaderFast.this;
                        resumeUploaderFast42.mkblk(j, i, resumeUploaderFast42.upHost.get().toString());
                    } else if (str == null) {
                        if (e != null) {
                            str2 = "get context failed.\n" + e.getMessage();
                        } else {
                            str2 = "get context failed.";
                        }
                        ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, ResponseInfo.errorInfo(responseInfo, 0, str2), jSONObject);
                    } else if (j3 != j2) {
                        ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, ResponseInfo.errorInfo(responseInfo, ResponseInfo.Crc32NotMatch, "block's crc32 is not match. local: " + j2 + ", remote: " + j3), jSONObject);
                    } else {
                        synchronized (this) {
                            ResumeUploaderFast.this.contexts[(int) (j / STMobileHumanActionNative.ST_MOBILE_HAND_666)] = str;
                            ResumeUploaderFast.this.offsets[(int) (j / STMobileHumanActionNative.ST_MOBILE_HAND_666)] = Long.valueOf(j);
                            ResumeUploaderFast.this.record(ResumeUploaderFast.this.offsets);
                            ResumeUploaderFast.this.upBlock++;
                            if (ResumeUploaderFast.this.upBlock == ResumeUploaderFast.this.tblock.get()) {
                                ResumeUploaderFast.this.makeFile(ResumeUploaderFast.this.upHost.get().toString(), ResumeUploaderFast.this.getMkfileCompletionHandler(), ResumeUploaderFast.this.options.cancellationSignal);
                            } else if (ResumeUploaderFast.this.blockInfo.size() > 0) {
                                BlockElement blockInfo = ResumeUploaderFast.this.getBlockInfo();
                                if (blockInfo.getOffset() == 0 || blockInfo.getBlocksize() == 0) {
                                    return;
                                }
                                new UploadThread(blockInfo.getOffset(), blockInfo.getBlocksize(), ResumeUploaderFast.this.upHost.get().toString()).start();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CompletionHandler getMkfileCompletionHandler() {
        return new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploaderFast.3
            @Override // com.qiniu.android.http.CompletionHandler
            public void complete(ResponseInfo responseInfo, JSONObject jSONObject) {
                if (responseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
                    ResumeUploaderFast.this.options.netReadyHandler.waitReady();
                    if (!AndroidNetwork.isNetWorkReady()) {
                        ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, responseInfo, jSONObject);
                        return;
                    }
                }
                if (responseInfo.isOK()) {
                    ResumeUploaderFast.this.removeRecord();
                    ResumeUploaderFast.this.options.progressHandler.progress(ResumeUploaderFast.this.key, 1.0d);
                    ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, responseInfo, jSONObject);
                } else if (!responseInfo.needRetry() || ResumeUploaderFast.this.retried.get() >= ResumeUploaderFast.this.config.retryMax + 1) {
                    ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, responseInfo, jSONObject);
                } else {
                    ResumeUploaderFast resumeUploaderFast = ResumeUploaderFast.this;
                    resumeUploaderFast.makeFile(resumeUploaderFast.upHost.get().toString(), ResumeUploaderFast.this.getMkfileCompletionHandler(), ResumeUploaderFast.this.options.cancellationSignal);
                    ResumeUploaderFast.this.retried.addAndGet(1);
                }
            }
        };
    }

    private ProgressHandler getProgressHandler() {
        return new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploaderFast.2
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j, long j2) {
                long j3;
                Long[] lArr = ResumeUploaderFast.this.offsets;
                int length = lArr.length;
                int i = 0;
                long j4 = 0;
                while (true) {
                    j3 = j4;
                    if (i >= length) {
                        break;
                    }
                    Long l = lArr[i];
                    long j5 = j3;
                    if (l != null) {
                        j5 = j3;
                        if (l.longValue() > 0) {
                            j5 = j3 + 1;
                        }
                    }
                    i++;
                    j4 = j5;
                }
                double d = (j3 * 4194304.0d) / j2;
                double d2 = d;
                if (d > 0.95d) {
                    d2 = 0.95d;
                }
                ResumeUploaderFast.this.options.progressHandler.progress(ResumeUploaderFast.this.key, d2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChunkOK(ResponseInfo responseInfo, JSONObject jSONObject) {
        if (responseInfo.statusCode == 200 && responseInfo.error == null) {
            return responseInfo.hasReqId() || isChunkResOK(jSONObject);
        }
        return false;
    }

    private boolean isChunkResOK(JSONObject jSONObject) {
        try {
            jSONObject.getString("ctx");
            jSONObject.getLong("crc32");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNotChunkToQiniu(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.hasReqId() && !isChunkResOK(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeFile(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
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
            str3 = "/" + StringUtils.join(strArr, "/");
        }
        String format3 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.totalSize), format, format2, str3);
        byte[] bytes = StringUtils.join(this.contexts, ",").getBytes();
        String format4 = String.format("%s%s", str, format3);
        uplogHandler.send("bytes_total", Long.valueOf(bytes.length));
        post(uplogHandler, format4, bytes, 0, bytes.length, null, completionHandler, upCancellationSignal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mkblk(long j, int i, String str) {
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        uplogHandler.send("target_key", this.key);
        uplogHandler.send("up_type", "mkblk");
        uplogHandler.send("tid", Long.valueOf(Process.myTid()));
        uplogHandler.send("file_offset", Long.valueOf(j));
        uplogHandler.send("bytes_total", Long.valueOf(i));
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        byte[] bArr = new byte[i];
        synchronized (this) {
            try {
                this.file.seek(j);
                this.file.read(bArr, 0, i);
            } catch (IOException e) {
                this.completionHandler.complete(this.key, ResponseInfo.fileError(e, this.token), null);
                return;
            }
        }
        post(uplogHandler, String.format("%s%s", str, format), bArr, 0, i, getProgressHandler(), getCompletionHandler(j, i, Crc32.bytes(bArr, 0, i)), this.options.cancellationSignal);
    }

    private void post(LogHandler logHandler, String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.client.asyncPost(logHandler, str, bArr, i, i2, this.headers, this.token, this.totalSize, progressHandler, completionHandler, upCancellationSignal);
    }

    private void putBlockInfo() {
        Long[] recoveryFromRecord = recoveryFromRecord();
        int i = this.tblock.get() - 1;
        if (recoveryFromRecord == null) {
            this.recover_from = 0L;
            for (int i2 = 0; i2 < i; i2++) {
                this.blockInfo.put(Long.valueOf(i2 * STMobileHumanActionNative.ST_MOBILE_HAND_666), 4194304);
            }
            this.blockInfo.put(Long.valueOf(i * STMobileHumanActionNative.ST_MOBILE_HAND_666), Integer.valueOf((int) (this.totalSize - (i * 4194304))));
            return;
        }
        this.recover_from = recoveryFromRecord.length * 4194304;
        HashSet hashSet = new HashSet(Arrays.asList(recoveryFromRecord));
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                break;
            }
            Long valueOf = Long.valueOf(i4 * STMobileHumanActionNative.ST_MOBILE_HAND_666);
            if (hashSet.contains(valueOf)) {
                this.offsets[i4] = valueOf;
                this.upBlock++;
            } else {
                this.blockInfo.put(valueOf, 4194304);
            }
            i3 = i4 + 1;
        }
        Long valueOf2 = Long.valueOf(i * STMobileHumanActionNative.ST_MOBILE_HAND_666);
        if (!hashSet.contains(valueOf2)) {
            this.blockInfo.put(valueOf2, Integer.valueOf((int) (this.totalSize - (i * 4194304))));
            return;
        }
        this.offsets[i] = valueOf2;
        this.upBlock++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void record(Long[] lArr) {
        if (this.config.recorder == null || lArr.length == 0) {
            return;
        }
        this.config.recorder.set(this.recorderKey, String.format(Locale.ENGLISH, "{\"size\":%d,\"offsets\":[%s], \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.totalSize), StringUtils.jsonJoin(lArr), Long.valueOf(this.modifyTime), StringUtils.jsonJoin(this.contexts)).getBytes());
    }

    private Long[] recoveryFromRecord() {
        byte[] bArr;
        int i;
        if (this.config.recorder == null || (bArr = this.config.recorder.get(this.recorderKey)) == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            JSONArray optJSONArray = jSONObject.optJSONArray("offsets");
            long optLong = jSONObject.optLong("modify_time", 0L);
            long optLong2 = jSONObject.optLong(OapsKey.KEY_SIZE, 0L);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("contexts");
            if (optJSONArray.length() == 0 || optLong != this.modifyTime || optLong2 != this.totalSize || optJSONArray2 == null || optJSONArray2.length() == 0) {
                return null;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= optJSONArray2.length()) {
                    break;
                }
                this.contexts[i3] = optJSONArray2.optString(i3);
                i2 = i3 + 1;
            }
            for (i = 0; i < optJSONArray2.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (optString != null && !optString.equals(b.l)) {
                    this.offsets[i] = Long.valueOf(Long.parseLong(optString));
                }
            }
            return this.offsets;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRecord() {
        if (this.config.recorder != null) {
            this.config.recorder.del(this.recorderKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRetried() {
        synchronized (this) {
            if (this.singleDomainRetry.get() < this.config.retryMax) {
                this.singleDomainRetry.getAndAdd(1);
            } else if (this.retried.get() < 3) {
                this.singleDomainRetry.getAndSet(1);
                this.retried.getAndAdd(1);
                this.upHost.getAndSet(this.config.zone.upHost(this.token.token, this.config.useHttps, this.upHost.get().toString()));
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.file = new RandomAccessFile(this.f, "r");
            putBlockInfo();
            this.upHost.set(this.config.zone.upHost(this.token.token, this.config.useHttps, (String) null));
            if (this.blockInfo.size() < this.multithread) {
                this.multithread = this.blockInfo.size();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.multithread) {
                    return;
                }
                BlockElement blockInfo = getBlockInfo();
                new UploadThread(blockInfo.getOffset(), blockInfo.getBlocksize(), this.upHost.get().toString()).start();
                i = i2 + 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.completionHandler.complete(this.key, ResponseInfo.fileError(e, this.token), null);
        }
    }
}
