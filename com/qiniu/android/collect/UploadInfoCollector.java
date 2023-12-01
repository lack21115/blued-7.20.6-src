package com.qiniu.android.collect;

import com.qiniu.android.http.UserAgent;
import com.qiniu.android.storage.UpToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/collect/UploadInfoCollector.class */
public final class UploadInfoCollector {
    private static OkHttpClient httpClient;
    private static UploadInfoCollector httpCollector;
    private static ExecutorService singleServer;
    private long lastUpload;
    private File recordFile = null;
    private final String recordFileName;
    private final String serverURL;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/collect/UploadInfoCollector$RecordMsg.class */
    public static abstract class RecordMsg {
        public abstract String toRecordMsg();
    }

    private UploadInfoCollector(String str, String str2) {
        this.recordFileName = str;
        this.serverURL = str2;
        try {
            reset0();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clean() {
        try {
            if (singleServer != null) {
                singleServer.shutdown();
            }
        } catch (Exception e) {
        }
        singleServer = null;
        httpClient = null;
        try {
            getHttpCollector().clean0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        httpCollector = null;
    }

    private void clean0() {
        try {
            if (this.recordFile != null) {
                this.recordFile.delete();
            } else {
                new File(getRecordDir(Config.recordDir), this.recordFileName).delete();
            }
        } catch (Exception e) {
        }
        this.recordFile = null;
    }

    private static OkHttpClient getHttpClient() {
        if (httpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(10L, TimeUnit.SECONDS);
            builder.readTimeout(15L, TimeUnit.SECONDS);
            builder.writeTimeout((((Config.interval / 2) + 1) * 60) - 10, TimeUnit.SECONDS);
            httpClient = builder.build();
        }
        return httpClient;
    }

    private static UploadInfoCollector getHttpCollector() {
        if (httpCollector == null) {
            httpCollector = new UploadInfoCollector("_qiniu_record_file_hs5z9lo7anx03", Config.serverURL);
        }
        return httpCollector;
    }

    private File getRecordDir(String str) {
        return new File(str);
    }

    private void handle0(final UpToken upToken, final RecordMsg recordMsg) {
        ExecutorService executorService = singleServer;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        singleServer.submit(new Runnable() { // from class: com.qiniu.android.collect.UploadInfoCollector.1
            @Override // java.lang.Runnable
            public void run() {
                if (Config.isRecord) {
                    try {
                        UploadInfoCollector.this.tryRecode(recordMsg.toRecordMsg(), UploadInfoCollector.this.recordFile);
                    } catch (Throwable th) {
                    }
                }
            }
        });
        if (!Config.isUpload || UpToken.isInvalid(upToken)) {
            return;
        }
        singleServer.submit(new Runnable() { // from class: com.qiniu.android.collect.UploadInfoCollector.2
            @Override // java.lang.Runnable
            public void run() {
                if (Config.isRecord && Config.isUpload) {
                    try {
                        UploadInfoCollector.this.tryUploadAndClean(upToken, UploadInfoCollector.this.recordFile);
                    } catch (Throwable th) {
                    }
                }
            }
        });
    }

    public static void handleHttp(UpToken upToken, RecordMsg recordMsg) {
        try {
            if (Config.isRecord) {
                getHttpCollector().handle0(upToken, recordMsg);
            }
        } catch (Throwable th) {
        }
    }

    public static void handleUpload(UpToken upToken, RecordMsg recordMsg) {
        handleHttp(upToken, recordMsg);
    }

    private void initRecordFile(File file) throws IOException {
        if (file == null) {
            throw new IOException("record's dir is not setted");
        }
        if (!file.exists()) {
            if (file.mkdirs()) {
                return;
            }
            throw new IOException("mkdir failed: " + file.getAbsolutePath());
        } else if (file.isDirectory()) {
            this.recordFile = new File(file, this.recordFileName);
        } else {
            throw new IOException(file.getAbsolutePath() + " is not a dir");
        }
    }

    private boolean isOk(Response response) {
        return response.isSuccessful() && response.header("X-Reqid") != null;
    }

    public static void reset() {
        try {
            getHttpCollector().reset0();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset0() throws IOException {
        ExecutorService executorService;
        if (Config.isRecord) {
            initRecordFile(getRecordDir(Config.recordDir));
        }
        if (!Config.isRecord && (executorService = singleServer) != null) {
            executorService.shutdown();
        }
        if (Config.isRecord) {
            ExecutorService executorService2 = singleServer;
            if (executorService2 == null || executorService2.isShutdown()) {
                singleServer = Executors.newSingleThreadExecutor();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryRecode(String str, File file) {
        if (!Config.isRecord || file.length() >= Config.maxRecordFileSize) {
            return;
        }
        writeToFile(file, str + "\n", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUploadAndClean(UpToken upToken, File file) {
        if (!Config.isUpload || file.length() <= Config.uploadThreshold) {
            return;
        }
        long time = new Date().getTime();
        if (time > this.lastUpload + (Config.interval * 60 * 1000)) {
            this.lastUpload = time;
            if (upload(upToken, file)) {
                writeToFile(file, "", false);
                writeToFile(file, "", false);
            }
        }
    }

    private boolean upload(UpToken upToken, File file) {
        try {
            OkHttpClient httpClient2 = getHttpClient();
            RequestBody create = RequestBody.create(MediaType.parse("text/plain"), file);
            Request.Builder url = new Request.Builder().url(this.serverURL);
            Request.Builder post = url.addHeader("Authorization", "UpToken " + upToken.token).addHeader("User-Agent", UserAgent.instance().getUa(upToken.accessKey)).post(create);
            if (UploadInfoElement.x_log_client_id != "") {
                post.addHeader("X-Log-Client-Id", UploadInfoElement.x_log_client_id);
            }
            Response execute = httpClient2.newCall(post.build()).execute();
            UploadInfoElement.x_log_client_id = execute.header("X-Log-Client-Id");
            boolean isOk = isOk(execute);
            try {
                execute.body().close();
                return isOk;
            } catch (Exception e) {
                return isOk;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static void writeToFile(File file, String str, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, z);
                    try {
                        fileOutputStream.write(str.getBytes(Charset.forName("UTF-8")));
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream2 = fileOutputStream;
                        th = th;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (IOException e5) {
                    e = e5;
                    fileOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
        }
    }
}
