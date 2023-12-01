package com.qiniu.android.storage;

import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfo;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.collect.UploadInfoElement;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.DnsPrefetcher;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.Json;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/UploadManager.class */
public final class UploadManager {
    private static int DEF_THREAD_NUM = 3;
    static AtomicBoolean atomicLocalPrefetch = new AtomicBoolean(false);
    private final Client client;
    private final Configuration config;
    private int multithreads;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/UploadManager$WarpHandler.class */
    public static class WarpHandler implements UpCompletionHandler {
        final long before = System.currentTimeMillis();
        final UpCompletionHandler complete;
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.complete = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void complete(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.isRecord) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.handleUpload(responseInfo.upToken, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String toRecordMsg() {
                        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getUploadQuality());
                        uplogHandler.send("result", UploadInfoElement.resultCode(responseInfo.statusCode, responseInfo.error));
                        uplogHandler.send("total_elapsed_time", Long.valueOf(currentTimeMillis - WarpHandler.this.before));
                        uplogHandler.send("requests_counts", Long.valueOf(ResponseInfo.requests_count));
                        uplogHandler.send("bytes_sent", Long.valueOf(ResponseInfo.bytes_sent));
                        uplogHandler.send("up_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        ResponseInfo.requests_count = 0L;
                        ResponseInfo.bytes_sent = 0L;
                        return Json.object2Json((UploadInfoElement.UploadQuality) uplogHandler.getUploadInfo());
                    }
                });
            }
            AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.complete.complete(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public UploadManager() {
        this(new Configuration.Builder().build(), DEF_THREAD_NUM);
    }

    public UploadManager(Configuration configuration) {
        this.multithreads = 1;
        this.config = configuration;
        this.client = new Client(configuration.proxy, configuration.connectTimeout, configuration.responseTimeout, configuration.urlConverter, configuration.dns);
        startLocalPrefetch(configuration);
    }

    public UploadManager(Configuration configuration, int i) {
        this.multithreads = 1;
        this.config = configuration;
        this.multithreads = i < 1 ? DEF_THREAD_NUM : i;
        this.client = new Client(configuration.proxy, configuration.connectTimeout, configuration.responseTimeout, configuration.urlConverter, configuration.dns);
        startLocalPrefetch(configuration);
    }

    public UploadManager(Recorder recorder) {
        this(recorder, (KeyGenerator) null);
    }

    public UploadManager(Recorder recorder, int i) {
        this(recorder, null, i);
    }

    public UploadManager(Recorder recorder, KeyGenerator keyGenerator) {
        this(new Configuration.Builder().recorder(recorder, keyGenerator).build());
    }

    public UploadManager(Recorder recorder, KeyGenerator keyGenerator, int i) {
        this(new Configuration.Builder().recorder(recorder, keyGenerator).build(), i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005b, code lost:
        if (r6.length == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.qiniu.android.http.ResponseInfo areInvalidArg(java.lang.String r5, byte[] r6, java.io.File r7, java.lang.String r8, com.qiniu.android.storage.UpToken r9) {
        /*
            r0 = 0
            r10 = r0
            r0 = r7
            if (r0 != 0) goto L11
            r0 = r6
            if (r0 != 0) goto L11
            java.lang.String r0 = "no input data"
            r5 = r0
            goto L29
        L11:
            r0 = r8
            if (r0 == 0) goto L26
            r0 = r8
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L21
            goto L26
        L21:
            r0 = 0
            r5 = r0
            goto L29
        L26:
            java.lang.String r0 = "no token"
            r5 = r0
        L29:
            r0 = r5
            if (r0 == 0) goto L34
            r0 = r5
            r1 = r9
            com.qiniu.android.http.ResponseInfo r0 = com.qiniu.android.http.ResponseInfo.invalidArgument(r0, r1)
            return r0
        L34:
            r0 = r9
            boolean r0 = com.qiniu.android.storage.UpToken.isInvalid(r0)
            if (r0 == 0) goto L42
            java.lang.String r0 = "invalid token"
            com.qiniu.android.http.ResponseInfo r0 = com.qiniu.android.http.ResponseInfo.invalidToken(r0)
            return r0
        L42:
            r0 = r7
            if (r0 == 0) goto L4f
            r0 = r7
            long r0 = r0.length()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L5e
        L4f:
            r0 = r10
            r5 = r0
            r0 = r6
            if (r0 == 0) goto L64
            r0 = r10
            r5 = r0
            r0 = r6
            int r0 = r0.length
            if (r0 != 0) goto L64
        L5e:
            r0 = r9
            com.qiniu.android.http.ResponseInfo r0 = com.qiniu.android.http.ResponseInfo.zeroSize(r0)
            r5 = r0
        L64:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.storage.UploadManager.areInvalidArg(java.lang.String, byte[], java.io.File, java.lang.String, com.qiniu.android.storage.UpToken):com.qiniu.android.http.ResponseInfo");
    }

    private static boolean areInvalidArg(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        if (upCompletionHandler != null) {
            String str3 = (file == null && bArr == null) ? "no input data" : (str2 == null || str2.equals("")) ? "no token" : null;
            ResponseInfo invalidArgument = str3 != null ? ResponseInfo.invalidArgument(str3, upToken) : UpToken.isInvalid(upToken) ? ResponseInfo.invalidToken("invalid token") : ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.zeroSize(upToken);
            if (invalidArgument != null) {
                upCompletionHandler.complete(str, invalidArgument, null);
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("no UpCompletionHandler");
    }

    private void startLocalPrefetch(Configuration configuration) {
        if (atomicLocalPrefetch.compareAndSet(false, true) && DnsPrefetcher.recoverCache(configuration)) {
            new Thread(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    DnsPrefetcher.getDnsPrefetcher().localFetch();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WarpHandler warpHandler(UpCompletionHandler upCompletionHandler, long j) {
        return new WarpHandler(upCompletionHandler, j);
    }

    public void put(final File file, final String str, final String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken parse = UpToken.parse(str2);
        if (areInvalidArg(str, null, file, str2, parse, upCompletionHandler)) {
            return;
        }
        if (DnsPrefetcher.checkRePrefetchDns(str2, this.config)) {
            new Thread(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.4
                @Override // java.lang.Runnable
                public void run() {
                    DnsPrefetcher.startPrefetchDns(str2, UploadManager.this.config);
                }
            }).start();
        }
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        uplogHandler.send("up_type", "uc_query");
        this.config.zone.preQuery(uplogHandler, str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.5
            @Override // com.qiniu.android.common.Zone.QueryHandler
            public void onFailure(int i) {
                upCompletionHandler.complete(str, ResponseInfo.isStatusCodeForBrokenNetwork(i) ? ResponseInfo.networkError(i, parse) : ResponseInfo.invalidToken("invalid token"), null);
            }

            @Override // com.qiniu.android.common.Zone.QueryHandler
            public void onSuccess() {
                long length = file.length();
                UpCompletionHandler upCompletionHandler2 = upCompletionHandler;
                File file2 = file;
                WarpHandler warpHandler = UploadManager.warpHandler(upCompletionHandler2, file2 != null ? file2.length() : 0L);
                if (length <= UploadManager.this.config.putThreshold) {
                    FormUploader.upload(UploadManager.this.client, UploadManager.this.config, file, str, parse, warpHandler, uploadOptions);
                    return;
                }
                String gen = UploadManager.this.config.keyGen.gen(str, file);
                if (UploadManager.this.multithreads == 1) {
                    AsyncRun.runInMain(new ResumeUploader(UploadManager.this.client, UploadManager.this.config, file, str, parse, warpHandler, uploadOptions, gen));
                } else {
                    AsyncRun.runInMain(new ResumeUploaderFast(UploadManager.this.client, UploadManager.this.config, file, str, parse, warpHandler, uploadOptions, gen, UploadManager.this.multithreads));
                }
            }
        });
    }

    public void put(String str, String str2, String str3, UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions) {
        put(new File(str), str2, str3, upCompletionHandler, uploadOptions);
    }

    public void put(final byte[] bArr, final String str, final String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken parse = UpToken.parse(str2);
        if (areInvalidArg(str, bArr, null, str2, parse, upCompletionHandler)) {
            return;
        }
        if (DnsPrefetcher.checkRePrefetchDns(str2, this.config)) {
            new Thread(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // java.lang.Runnable
                public void run() {
                    DnsPrefetcher.startPrefetchDns(str2, UploadManager.this.config);
                }
            }).start();
        }
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        uplogHandler.send("up_type", "uc_query");
        final WarpHandler warpHandler = warpHandler(upCompletionHandler, bArr != null ? bArr.length : 0L);
        this.config.zone.preQuery(uplogHandler, str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.3
            @Override // com.qiniu.android.common.Zone.QueryHandler
            public void onFailure(int i) {
                upCompletionHandler.complete(str, ResponseInfo.isStatusCodeForBrokenNetwork(i) ? ResponseInfo.networkError(i, parse) : ResponseInfo.invalidToken("invalid token"), null);
            }

            @Override // com.qiniu.android.common.Zone.QueryHandler
            public void onSuccess() {
                FormUploader.upload(UploadManager.this.client, UploadManager.this.config, bArr, str, parse, warpHandler, uploadOptions);
            }
        });
    }

    public ResponseInfo syncPut(File file, String str, String str2, UploadOptions uploadOptions) {
        UpToken parse = UpToken.parse(str2);
        ResponseInfo areInvalidArg = areInvalidArg(str, null, file, str2, parse);
        return areInvalidArg != null ? areInvalidArg : FormUploader.syncUpload(this.client, this.config, file, str, parse, uploadOptions);
    }

    public ResponseInfo syncPut(String str, String str2, String str3, UploadOptions uploadOptions) {
        return syncPut(new File(str), str2, str3, uploadOptions);
    }

    public ResponseInfo syncPut(byte[] bArr, String str, String str2, UploadOptions uploadOptions) {
        UpToken parse = UpToken.parse(str2);
        ResponseInfo areInvalidArg = areInvalidArg(str, bArr, null, str2, parse);
        return areInvalidArg != null ? areInvalidArg : FormUploader.syncUpload(this.client, this.config, bArr, str, parse, uploadOptions);
    }
}
