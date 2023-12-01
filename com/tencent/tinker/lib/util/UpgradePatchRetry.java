package com.tencent.tinker.lib.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.commons.util.IOHelper;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/util/UpgradePatchRetry.class */
public class UpgradePatchRetry {
    private static final String RETRY_COUNT_PROPERTY = "times";
    private static final String RETRY_FILE_MD5_PROPERTY = "md5";
    private static final String RETRY_INFO_NAME = "patch.retry";
    private static final int RETRY_MAX_COUNT = 20;
    private static final String TAG = "Tinker.UpgradePatchRetry";
    private static final String TEMP_PATCH_NAME = "temp.apk";
    private static UpgradePatchRetry sInstance;
    private Context context;
    private boolean isRetryEnable = true;
    private int maxRetryCount = 20;
    private File retryInfoFile;
    private File tempPatchFile;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/util/UpgradePatchRetry$RetryInfo.class */
    public static class RetryInfo {
        String md5;
        String times;

        RetryInfo(String str, String str2) {
            this.md5 = str;
            this.times = str2;
        }

        static RetryInfo readRetryProperty(File file) {
            String str;
            FileInputStream fileInputStream;
            String str2;
            Properties properties = new Properties();
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                fileInputStream2 = fileInputStream;
            } catch (IOException e) {
                e = e;
                str = null;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                IOHelper.closeQuietly(fileInputStream2);
                throw th;
            }
            try {
                try {
                    properties.load(fileInputStream);
                    str = properties.getProperty("md5");
                } catch (IOException e2) {
                    e = e2;
                    str = null;
                }
                try {
                    str2 = properties.getProperty(UpgradePatchRetry.RETRY_COUNT_PROPERTY);
                } catch (IOException e3) {
                    e = e3;
                    StringBuilder sb = new StringBuilder();
                    FileInputStream fileInputStream3 = fileInputStream;
                    sb.append("fail to readRetryProperty:");
                    FileInputStream fileInputStream4 = fileInputStream;
                    sb.append(e);
                    fileInputStream2 = fileInputStream;
                    ShareTinkerLog.e(UpgradePatchRetry.TAG, sb.toString(), new Object[0]);
                    str2 = null;
                    IOHelper.closeQuietly(fileInputStream);
                    return new RetryInfo(str, str2);
                }
                IOHelper.closeQuietly(fileInputStream);
                return new RetryInfo(str, str2);
            } catch (Throwable th2) {
                th = th2;
                IOHelper.closeQuietly(fileInputStream2);
                throw th;
            }
        }

        static void writeRetryProperty(File file, RetryInfo retryInfo) {
            FileOutputStream fileOutputStream;
            if (retryInfo == null) {
                return;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Properties properties = new Properties();
            properties.put("md5", retryInfo.md5);
            properties.put(UpgradePatchRetry.RETRY_COUNT_PROPERTY, retryInfo.times);
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        properties.store(fileOutputStream, (String) null);
                        IOHelper.closeQuietly(fileOutputStream);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        ShareTinkerLog.printErrStackTrace(UpgradePatchRetry.TAG, e, "retry write property fail", new Object[0]);
                        IOHelper.closeQuietly(fileOutputStream);
                    } catch (Throwable th) {
                        fileOutputStream2 = fileOutputStream;
                        th = th;
                        IOHelper.closeQuietly(fileOutputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            }
        }
    }

    public UpgradePatchRetry(Context context) {
        this.retryInfoFile = null;
        this.tempPatchFile = null;
        this.context = null;
        this.context = context;
        this.retryInfoFile = new File(SharePatchFileUtil.getPatchTempDirectory(context), RETRY_INFO_NAME);
        this.tempPatchFile = new File(SharePatchFileUtil.getPatchTempDirectory(context), TEMP_PATCH_NAME);
    }

    private void copyToTempFile(File file) {
        if (file.getAbsolutePath().equals(this.tempPatchFile.getAbsolutePath())) {
            return;
        }
        ShareTinkerLog.w(TAG, "try copy file: %s to %s", file.getAbsolutePath(), this.tempPatchFile.getAbsolutePath());
        try {
            SharePatchFileUtil.copyFileUsingStream(file, this.tempPatchFile);
        } catch (IOException e) {
            ShareTinkerLog.e(TAG, "fail to copy file: %s to %s", file.getAbsolutePath(), this.tempPatchFile.getAbsolutePath());
        }
    }

    public static UpgradePatchRetry getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new UpgradePatchRetry(context);
        }
        return sInstance;
    }

    public boolean onPatchListenerCheck(String str) {
        int parseInt;
        if (!this.isRetryEnable) {
            ShareTinkerLog.w(TAG, "onPatchListenerCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.retryInfoFile.exists()) {
            ShareTinkerLog.w(TAG, "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            ShareTinkerLog.w(TAG, "onPatchListenerCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            RetryInfo readRetryProperty = RetryInfo.readRetryProperty(this.retryInfoFile);
            if (!str.equals(readRetryProperty.md5) || (parseInt = Integer.parseInt(readRetryProperty.times)) < this.maxRetryCount) {
                return true;
            }
            ShareTinkerLog.w(TAG, "onPatchListenerCheck, retry count %d must exceed than max retry count", Integer.valueOf(parseInt));
            SharePatchFileUtil.safeDeleteFile(this.tempPatchFile);
            return false;
        }
    }

    public boolean onPatchResetMaxCheck(String str) {
        if (!this.isRetryEnable) {
            ShareTinkerLog.w(TAG, "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.retryInfoFile.exists()) {
            ShareTinkerLog.w(TAG, "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            ShareTinkerLog.w(TAG, "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            RetryInfo readRetryProperty = RetryInfo.readRetryProperty(this.retryInfoFile);
            if (str.equals(readRetryProperty.md5)) {
                ShareTinkerLog.i(TAG, "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
                readRetryProperty.times = "1";
                RetryInfo.writeRetryProperty(this.retryInfoFile, readRetryProperty);
                return true;
            }
            return true;
        }
    }

    public boolean onPatchRetryLoad() {
        if (!this.isRetryEnable) {
            ShareTinkerLog.w(TAG, "onPatchRetryLoad retry disabled, just return", new Object[0]);
            return false;
        } else if (!Tinker.with(this.context).isMainProcess()) {
            ShareTinkerLog.w(TAG, "onPatchRetryLoad retry is not main process, just return", new Object[0]);
            return false;
        } else if (!this.retryInfoFile.exists()) {
            ShareTinkerLog.w(TAG, "onPatchRetryLoad retry info not exist, just return", new Object[0]);
            return false;
        } else if (TinkerServiceInternals.isTinkerPatchServiceRunning(this.context)) {
            ShareTinkerLog.w(TAG, "onPatchRetryLoad tinker service is running, just return", new Object[0]);
            return false;
        } else {
            String absolutePath = this.tempPatchFile.getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                ShareTinkerLog.w(TAG, "onPatchRetryLoad patch file: %s is not exist, just return", absolutePath);
                return false;
            }
            ShareTinkerLog.w(TAG, "onPatchRetryLoad patch file: %s is exist, retry to patch", absolutePath);
            TinkerInstaller.onReceiveUpgradePatch(this.context, absolutePath);
            return true;
        }
    }

    public void onPatchServiceResult() {
        if (!this.isRetryEnable) {
            ShareTinkerLog.w(TAG, "onPatchServiceResult retry disabled, just return", new Object[0]);
        } else if (this.tempPatchFile.exists()) {
            SharePatchFileUtil.safeDeleteFile(this.tempPatchFile);
        }
    }

    public void onPatchServiceStart(Intent intent) {
        RetryInfo retryInfo;
        if (!this.isRetryEnable) {
            ShareTinkerLog.w(TAG, "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            ShareTinkerLog.e(TAG, "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            String patchPathExtra = TinkerPatchService.getPatchPathExtra(intent);
            if (patchPathExtra == null) {
                ShareTinkerLog.w(TAG, "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(patchPathExtra);
            String md5 = SharePatchFileUtil.getMD5(file);
            if (md5 == null) {
                ShareTinkerLog.w(TAG, "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            if (this.retryInfoFile.exists()) {
                retryInfo = RetryInfo.readRetryProperty(this.retryInfoFile);
                if (retryInfo.md5 == null || retryInfo.times == null || !md5.equals(retryInfo.md5)) {
                    copyToTempFile(file);
                    retryInfo.md5 = md5;
                    retryInfo.times = "1";
                } else {
                    int parseInt = Integer.parseInt(retryInfo.times);
                    if (parseInt >= this.maxRetryCount) {
                        SharePatchFileUtil.safeDeleteFile(this.tempPatchFile);
                        ShareTinkerLog.w(TAG, "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                        return;
                    }
                    retryInfo.times = String.valueOf(parseInt + 1);
                }
            } else {
                copyToTempFile(file);
                retryInfo = new RetryInfo(md5, "1");
            }
            RetryInfo.writeRetryProperty(this.retryInfoFile, retryInfo);
        }
    }

    public void setMaxRetryCount(int i) {
        if (i <= 0) {
            ShareTinkerLog.e(TAG, "max count must large than 0", new Object[0]);
        } else {
            this.maxRetryCount = i;
        }
    }

    public void setRetryEnable(boolean z) {
        this.isRetryEnable = z;
    }
}
