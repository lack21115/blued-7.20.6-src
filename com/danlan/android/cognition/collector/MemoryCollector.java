package com.danlan.android.cognition.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/MemoryCollector.class */
public class MemoryCollector extends SubCollector {
    private static String android_ctime = "";
    private static String android_mtime = "";
    private static String data_ctime = "";
    private static String data_mtime = "";
    private static String dicm_ctime = "";
    private static String dicm_mtime = "";
    private static String[] ext_root_dirs = {StringFog.decrypt("DlBQTFNCQ0QORklWTUJQREUMFA=="), StringFog.decrypt("DlBAQEBRQA=="), StringFog.decrypt("DlBQTFNCQ0QOUEBAQFFA")};
    private static String sdcard_ctime = "";
    private static String sdcard_mtime = "";
    private Context mcontext;

    public MemoryCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    private void getAndroidCreateTime() {
        try {
            if (NativeLib.checkLoadSo()) {
                String[] strArr = ext_root_dirs;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str = strArr[i2];
                    JSONObject jSONObject = new JSONObject(NativeLib.ft(str + StringFog.decrypt("DmJKR1NMTUU=")));
                    android_ctime = jSONObject.getString(StringFog.decrypt("QldNTkQ="));
                    android_mtime = jSONObject.getString(StringFog.decrypt("TFdNTkQ="));
                    if (!TextUtils.isEmpty(android_ctime)) {
                        break;
                    }
                    i = i2 + 1;
                }
                if (TextUtils.isEmpty(android_ctime)) {
                    String externalStoragePath = getExternalStoragePath();
                    if (TextUtils.isEmpty(externalStoragePath)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(NativeLib.ft(externalStoragePath + StringFog.decrypt("DmJKR1NMTUU=")));
                    android_ctime = jSONObject2.getString(StringFog.decrypt("QldNTkQ="));
                    android_mtime = jSONObject2.getString(StringFog.decrypt("TFdNTkQ="));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDCIMCreateTime() {
        try {
            if (NativeLib.checkLoadSo()) {
                String[] strArr = ext_root_dirs;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str = strArr[i2];
                    JSONObject jSONObject = new JSONObject(NativeLib.ft(str + StringFog.decrypt("Dmdnamw=")));
                    dicm_ctime = jSONObject.getString(StringFog.decrypt("QldNTkQ="));
                    dicm_mtime = jSONObject.getString(StringFog.decrypt("TFdNTkQ="));
                    if (!TextUtils.isEmpty(dicm_ctime)) {
                        break;
                    }
                    i = i2 + 1;
                }
                if (TextUtils.isEmpty(dicm_ctime)) {
                    String externalStoragePath = getExternalStoragePath();
                    if (TextUtils.isEmpty(externalStoragePath)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(NativeLib.ft(externalStoragePath + StringFog.decrypt("Dmdnamw=")));
                    dicm_ctime = jSONObject2.getString(StringFog.decrypt("QldNTkQ="));
                    dicm_mtime = jSONObject2.getString(StringFog.decrypt("TFdNTkQ="));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDataCreateTime() {
        try {
            if (NativeLib.checkLoadSo()) {
                JSONObject jSONObject = new JSONObject(NativeLib.ft(StringFog.decrypt("DkdFV0AMQEBVQg==")));
                data_ctime = jSONObject.getString(StringFog.decrypt("QldNTkQ="));
                data_mtime = jSONObject.getString(StringFog.decrypt("TFdNTkQ="));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSdcardCreateTime() {
        try {
            if (NativeLib.checkLoadSo()) {
                String[] strArr = ext_root_dirs;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    JSONObject jSONObject = new JSONObject(NativeLib.ft(strArr[i2]));
                    sdcard_ctime = jSONObject.getString(StringFog.decrypt("QldNTkQ="));
                    sdcard_mtime = jSONObject.getString(StringFog.decrypt("TFdNTkQ="));
                    if (!TextUtils.isEmpty(sdcard_ctime)) {
                        break;
                    }
                    i = i2 + 1;
                }
                if (TextUtils.isEmpty(sdcard_ctime)) {
                    String externalStoragePath = getExternalStoragePath();
                    if (TextUtils.isEmpty(externalStoragePath)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(NativeLib.ft(externalStoragePath));
                    sdcard_ctime = jSONObject2.getString(StringFog.decrypt("QldNTkQ="));
                    sdcard_mtime = jSONObject2.getString(StringFog.decrypt("TFdNTkQ="));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void collectSystemDirCreateTime() {
        getAndroidCreateTime();
        getDCIMCreateTime();
        getSdcardCreateTime();
        getDataCreateTime();
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        safeJSONObject.put(StringFog.decrypt("VUxQQk1xZWw="), getTotalRAM());
        safeJSONObject.put(StringFog.decrypt("SUJXZllXQVNPQkhwZWBFU0U="), hasExternalSDCard());
        safeJSONObject.put(StringFog.decrypt("VUxQQk1qSlVEUUpCTW5BTE5RXXBIWUE="), getTotalInternalMemorySize());
        safeJSONObject.put(StringFog.decrypt("VUxQQk1mXFVEUUpCTW5BTE5RXXBIWUE="), getTotalExternalMemorySize());
        safeJSONObject.put(StringFog.decrypt("QFVFSk1CRk1EakpXRFFKQE1uQU5OUV1ySFlB"), getAvailableInternalMemorySize());
        safeJSONObject.put(StringFog.decrypt("QFVFSk1CRk1EZlxXRFFKQE1uQU5OUV1ySFlB"), getAvailableExternalMemorySize());
        safeJSONObject.put(StringFog.decrypt("RFtQRlNNRU1yV0tRQERBcUBXTA=="), getExternalStoragePath());
        collectSystemDirCreateTime();
        safeJSONObject.put(StringFog.decrypt("QE1AUU5KQH5CV01ORA=="), android_ctime);
        safeJSONObject.put(StringFog.decrypt("QE1AUU5KQH5MV01ORA=="), android_mtime);
        safeJSONObject.put(StringFog.decrypt("RUpHTn5AUEhMRg=="), dicm_ctime);
        safeJSONObject.put(StringFog.decrypt("RUpHTn5OUEhMRg=="), dicm_mtime);
        safeJSONObject.put(StringFog.decrypt("UkdHQlNHe0JVSklG"), sdcard_ctime);
        safeJSONObject.put(StringFog.decrypt("UkdHQlNHe0xVSklG"), sdcard_mtime);
        safeJSONObject.put(StringFog.decrypt("RUJQQn5AUEhMRg=="), data_ctime);
        safeJSONObject.put(StringFog.decrypt("RUJQQn5OUEhMRg=="), data_mtime);
        put(StringFog.decrypt("TEZJTFNa"), safeJSONObject);
        collectDone();
    }

    public final long getAvailableExternalMemorySize() {
        StatFs statFs;
        long j;
        long j2;
        if (hasExternalSDCard()) {
            try {
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    if (i < 18) {
                        j = statFs.getBlockSize();
                        j2 = statFs.getAvailableBlocks();
                        return j2 * j;
                    }
                } else {
                    statFs = new StatFs(this.mcontext.getExternalFilesDir("").getAbsolutePath());
                }
                j = statFs.getBlockSizeLong();
                j2 = statFs.getAvailableBlocksLong();
                return j2 * j;
            } catch (Exception e) {
                return 0L;
            }
        }
        return 0L;
    }

    public final long getAvailableInternalMemorySize() {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return availableBlocks * blockSize;
        } catch (Exception e) {
            return 0L;
        }
    }

    public final String getExternalStoragePath() {
        try {
            return Environment.getExternalStorageDirectory().getPath();
        } catch (Exception e) {
            return "";
        }
    }

    public final long getTotalExternalMemorySize() {
        StatFs statFs;
        long j;
        long j2;
        if (hasExternalSDCard()) {
            try {
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    if (i < 18) {
                        j = statFs.getBlockSize();
                        j2 = statFs.getBlockCount();
                        return j2 * j;
                    }
                } else {
                    statFs = new StatFs(this.mcontext.getExternalFilesDir("").getAbsolutePath());
                }
                j = statFs.getBlockSizeLong();
                j2 = statFs.getBlockCountLong();
                return j2 * j;
            } catch (Exception e) {
                return 0L;
            }
        }
        return 0L;
    }

    public final long getTotalInternalMemorySize() {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockCount * blockSize;
        } catch (Exception e) {
            return 0L;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|9|10|11|12|13|14|15))|20|6|7|8|9|10|11|12|13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0074, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0076, code lost:
        r10.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Long getTotalRAM() {
        /*
            r5 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 < r1) goto L38
            android.app.ActivityManager$MemoryInfo r0 = new android.app.ActivityManager$MemoryInfo
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r5
            android.content.Context r0 = r0.mcontext
            java.lang.String r1 = "QEBQSldKUFg="
            java.lang.String r1 = com.danlan.android.cognition.StringFog.decrypt(r1)
            java.lang.Object r0 = r0.getSystemService(r1)
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L38
            r0 = r11
            r1 = r10
            r0.getMemoryInfo(r1)
            r0 = r10
            long r0 = r0.totalMem
            r8 = r0
            goto L3a
        L38:
            r0 = 0
            r8 = r0
        L3a:
            r0 = r8
            r6 = r0
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch: java.lang.Exception -> L74
            r1 = r0
            java.lang.String r2 = "DlNWTEIMSURMSkpFTg=="
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)     // Catch: java.lang.Exception -> L74
            java.lang.String r3 = "Uw=="
            java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Exception -> L74
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L74
            r10 = r0
            r0 = r8
            r6 = r0
            r0 = r10
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Exception -> L74
            java.lang.String r1 = "fWcP"
            java.lang.String r1 = com.danlan.android.cognition.StringFog.decrypt(r1)     // Catch: java.lang.Exception -> L74
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replaceAll(r1, r2)     // Catch: java.lang.Exception -> L74
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L74
            long r0 = (long) r0     // Catch: java.lang.Exception -> L74
            r8 = r0
            r0 = r8
            r6 = r0
            r0 = r10
            r0.close()     // Catch: java.lang.Exception -> L74
            r0 = r8
            r6 = r0
            goto L7b
        L74:
            r10 = move-exception
            r0 = r10
            r0.printStackTrace()
        L7b:
            r0 = r6
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.MemoryCollector.getTotalRAM():java.lang.Long");
    }

    public final boolean hasExternalSDCard() {
        try {
            return Environment.getExternalStorageState().equals(StringFog.decrypt("TExRTVVGQA=="));
        } catch (Exception e) {
            return false;
        }
    }
}
