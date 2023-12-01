package com.qiniu.android.storage;

import android.os.Process;
import android.util.Log;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfo;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.DnsPrefetcher;
import com.qiniu.android.http.PostArgs;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.StringMap;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/FormUploader.class */
final class FormUploader {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/FormUploader$2.class */
    public static final class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ PostArgs val$args;
        final /* synthetic */ Client val$client;
        final /* synthetic */ UpCompletionHandler val$completionHandler;
        final /* synthetic */ Configuration val$config;
        final /* synthetic */ String val$key;
        final /* synthetic */ LogHandler val$logHandler;
        final /* synthetic */ UploadOptions val$options;
        final /* synthetic */ ProgressHandler val$progress;
        final /* synthetic */ UpToken val$token;
        final /* synthetic */ String val$upHost;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, LogHandler logHandler, PostArgs postArgs, ProgressHandler progressHandler) {
            this.val$options = uploadOptions;
            this.val$completionHandler = upCompletionHandler;
            this.val$key = str;
            this.val$config = configuration;
            this.val$token = upToken;
            this.val$upHost = str2;
            this.val$client = client;
            this.val$logHandler = logHandler;
            this.val$args = postArgs;
            this.val$progress = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void complete(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
                this.val$options.netReadyHandler.waitReady();
                if (!AndroidNetwork.isNetWorkReady()) {
                    this.val$completionHandler.complete(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.isOK()) {
                this.val$options.progressHandler.progress(this.val$key, 1.0d);
                this.val$completionHandler.complete(this.val$key, responseInfo, jSONObject);
            } else if (!responseInfo.needRetry()) {
                this.val$completionHandler.complete(this.val$key, responseInfo, jSONObject);
            } else {
                final String upHost = this.val$config.zone.upHost(this.val$token.token, this.val$config.useHttps, this.val$upHost);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + upHost);
                this.val$client.asyncMultipartPost(this.val$logHandler, upHost, this.val$args, this.val$token, this.val$progress, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void complete(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.isOK()) {
                            AnonymousClass2.this.val$options.progressHandler.progress(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.val$completionHandler.complete(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (!responseInfo2.needRetry()) {
                            AnonymousClass2.this.val$completionHandler.complete(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else {
                            final String upHost2 = AnonymousClass2.this.val$config.zone.upHost(AnonymousClass2.this.val$token.token, AnonymousClass2.this.val$config.useHttps, upHost);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + upHost2);
                            AnonymousClass2.this.val$client.asyncMultipartPost(AnonymousClass2.this.val$logHandler, upHost2, AnonymousClass2.this.val$args, AnonymousClass2.this.val$token, AnonymousClass2.this.val$progress, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void complete(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.isOK()) {
                                        AnonymousClass2.this.val$options.progressHandler.progress(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.needRetry()) {
                                        AnonymousClass2.this.val$config.zone.frozenDomain(upHost2);
                                    }
                                    AnonymousClass2.this.val$completionHandler.complete(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.val$options.cancellationSignal);
                        }
                    }
                }, this.val$options.cancellationSignal);
            }
        }
    }

    FormUploader() {
    }

    private static void post(LogHandler logHandler, byte[] bArr, File file, final String str, UpToken upToken, UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, Client client, Configuration configuration) {
        StringMap stringMap = new StringMap();
        PostArgs postArgs = new PostArgs();
        if (str != null) {
            stringMap.put("key", str);
            postArgs.fileName = str;
        } else {
            postArgs.fileName = "?";
        }
        if (file != null) {
            postArgs.fileName = file.getName();
        }
        stringMap.put("token", upToken.token);
        if (uploadOptions == null) {
            uploadOptions = UploadOptions.defaultOptions();
        }
        stringMap.putFileds(uploadOptions.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.file(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            j = Crc32.bytes(bArr);
        }
        stringMap.put("crc32", "" + j);
        final UploadOptions uploadOptions2 = uploadOptions;
        ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.FormUploader.1
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j2, long j3) {
                double d = j2 / j3;
                double d2 = d;
                if (d > 0.95d) {
                    d2 = 0.95d;
                }
                UploadOptions.this.progressHandler.progress(str, d2);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = uploadOptions.mimeType;
        postArgs.params = stringMap;
        String upHost = configuration.zone.upHost(upToken.token, configuration.useHttps, (String) null);
        logHandler.send("target_key", str);
        logHandler.send("up_type", "form");
        logHandler.send("tid", Long.valueOf(Process.myTid()));
        UpToken.setCurrent_region_id(logHandler, upHost);
        logHandler.send("target_region_id", DnsPrefetcher.target_region_id);
        Log.d("Qiniu.FormUploader", "upload use up host " + upHost);
        client.asyncMultipartPost(logHandler, upHost, postArgs, upToken, progressHandler, new AnonymousClass2(uploadOptions, upCompletionHandler, str, configuration, upToken, upHost, client, logHandler, postArgs, progressHandler), uploadOptions.cancellationSignal);
    }

    public static ResponseInfo syncUpload(Client client, Configuration configuration, File file, String str, UpToken upToken, UploadOptions uploadOptions) {
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        try {
            return syncUpload0(uplogHandler, client, configuration, null, file, str, upToken, uploadOptions);
        } catch (Exception e) {
            return ResponseInfo.create(uplogHandler, null, 0, "", "", "", "", "", "", 0, 0L, 0L, e.getMessage(), upToken, file != null ? file.length() : 0L);
        }
    }

    public static ResponseInfo syncUpload(Client client, Configuration configuration, byte[] bArr, String str, UpToken upToken, UploadOptions uploadOptions) {
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        try {
            return syncUpload0(uplogHandler, client, configuration, bArr, null, str, upToken, uploadOptions);
        } catch (Exception e) {
            return ResponseInfo.create(uplogHandler, null, 0, "", "", "", "", "", "", 0, 0L, 0L, e.getMessage(), upToken, bArr != null ? bArr.length : 0L);
        }
    }

    private static ResponseInfo syncUpload0(LogHandler logHandler, Client client, Configuration configuration, byte[] bArr, File file, String str, UpToken upToken, UploadOptions uploadOptions) {
        StringMap stringMap = new StringMap();
        PostArgs postArgs = new PostArgs();
        if (str != null) {
            stringMap.put("key", str);
            postArgs.fileName = str;
        } else {
            postArgs.fileName = "?";
        }
        if (file != null) {
            postArgs.fileName = file.getName();
        }
        stringMap.put("token", upToken.token);
        if (uploadOptions == null) {
            uploadOptions = UploadOptions.defaultOptions();
        }
        stringMap.putFileds(uploadOptions.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.file(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            j = Crc32.bytes(bArr);
        }
        stringMap.put("crc32", "" + j);
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = uploadOptions.mimeType;
        postArgs.params = stringMap;
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        uplogHandler.send("up_type", "uc_query");
        if (configuration.zone.preQuery(uplogHandler, upToken.token)) {
            String upHost = configuration.zone.upHost(upToken.token, configuration.useHttps, (String) null);
            logHandler.send("target_key", str);
            logHandler.send("up_type", "form");
            logHandler.send("tid", Long.valueOf(Process.myTid()));
            UpToken.setCurrent_region_id(logHandler, upHost);
            logHandler.send("target_region_id", DnsPrefetcher.target_region_id);
            Log.d("Qiniu.FormUploader", "sync upload use up host " + upHost);
            ResponseInfo syncMultipartPost = client.syncMultipartPost(logHandler, upHost, postArgs, upToken);
            if (syncMultipartPost.isOK()) {
                return syncMultipartPost;
            }
            ResponseInfo responseInfo = syncMultipartPost;
            if (syncMultipartPost.needRetry()) {
                if (syncMultipartPost.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
                    uploadOptions.netReadyHandler.waitReady();
                    if (!AndroidNetwork.isNetWorkReady()) {
                        return syncMultipartPost;
                    }
                }
                String upHost2 = configuration.zone.upHost(upToken.token, configuration.useHttps, upHost);
                Log.d("Qiniu.FormUploader", "sync upload retry first time use up host " + upHost2);
                ResponseInfo syncMultipartPost2 = client.syncMultipartPost(logHandler, upHost2, postArgs, upToken);
                responseInfo = syncMultipartPost2;
                if (syncMultipartPost2.needRetry()) {
                    if (syncMultipartPost2.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
                        uploadOptions.netReadyHandler.waitReady();
                        if (!AndroidNetwork.isNetWorkReady()) {
                            return syncMultipartPost2;
                        }
                    }
                    String upHost3 = configuration.zone.upHost(upToken.token, configuration.useHttps, upHost2);
                    Log.d("Qiniu.FormUploader", "sync upload retry second time use up host " + upHost3);
                    ResponseInfo syncMultipartPost3 = client.syncMultipartPost(logHandler, upHost3, postArgs, upToken);
                    responseInfo = syncMultipartPost3;
                    if (syncMultipartPost3.needRetry()) {
                        configuration.zone.frozenDomain(upHost3);
                        responseInfo = syncMultipartPost3;
                    }
                }
            }
            return responseInfo;
        }
        return ResponseInfo.invalidToken("failed to get up host");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void upload(Client client, Configuration configuration, File file, String str, UpToken upToken, UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions) {
        post(UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo()), null, file, str, upToken, upCompletionHandler, uploadOptions, client, configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void upload(Client client, Configuration configuration, byte[] bArr, String str, UpToken upToken, UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions) {
        post(UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo()), bArr, null, str, upToken, upCompletionHandler, uploadOptions, client, configuration);
    }
}
