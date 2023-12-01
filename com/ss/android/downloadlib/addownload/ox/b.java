package com.ss.android.downloadlib.addownload.ox;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/ox/b.class */
public class b {
    public static void mb() {
        List<DownloadInfo> mb = com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext());
        if (mb == null || mb.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= mb.size()) {
                return;
            }
            DownloadInfo downloadInfo = mb.get(i2);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long optInt = DownloadSetting.obtain(downloadInfo.getId()).optInt("download_file_expire_hours", 0) * 3600000;
            long j = optInt;
            if (optInt <= 0) {
                j = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= j) {
                mb(file);
                Downloader.getInstance(x.getContext()).clearDownloadData(downloadInfo.getId());
            }
            i = i2 + 1;
        }
    }

    public static void mb(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            mb(externalCacheDir.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void mb(java.io.File r4) {
        /*
            r0 = 0
            r5 = r0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            r1 = r0
            r2 = r4
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            java.lang.String r1 = "1"
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L46
            r0.write(r1)     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L46
            r0 = r6
            r5 = r0
            r0 = r6
            r0.close()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L46
            goto L40
        L1f:
            r7 = move-exception
            goto L2a
        L23:
            r4 = move-exception
            goto L47
        L27:
            r7 = move-exception
            r0 = 0
            r6 = r0
        L2a:
            r0 = r6
            r5 = r0
            r0 = r7
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L46
            r0 = r6
            if (r0 == 0) goto L40
            r0 = r6
            r0.close()     // Catch: java.lang.Exception -> L3b
            goto L40
        L3b:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()
        L40:
            r0 = r4
            boolean r0 = r0.delete()
            return
        L46:
            r4 = move-exception
        L47:
            r0 = r5
            if (r0 == 0) goto L57
            r0 = r5
            r0.close()     // Catch: java.lang.Exception -> L52
            goto L57
        L52:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()
        L57:
            r0 = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.ox.b.mb(java.io.File):void");
    }

    private static void mb(String str) {
        String str2;
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        String[] list = file.list();
        if (list == null) {
            return;
        }
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                file.delete();
                return;
            }
            String str3 = list[i2];
            if (str3 != null) {
                if (str.endsWith(File.separator)) {
                    str2 = str + str3;
                } else {
                    str2 = str + File.separator + str3;
                }
                File file2 = new File(str2);
                if (file2.isFile()) {
                    file2.delete();
                }
                if (file2.isDirectory()) {
                    mb(str2);
                }
            }
            i = i2 + 1;
        }
    }

    public static void ox() {
        DownloadInfo downloadInfo;
        List successedDownloadInfosWithMimeType = Downloader.getInstance(x.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= successedDownloadInfosWithMimeType.size()) {
                return;
            }
            if (((DownloadInfo) successedDownloadInfosWithMimeType.get(i2)) != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long lastModified = file.lastModified();
                    long optInt = DownloadSetting.obtain(downloadInfo.getId()).optInt("download_complete_file_expire_hours", 0) * 3600000;
                    long j = optInt;
                    if (optInt <= 0) {
                        j = 604800000;
                    }
                    boolean z = true;
                    if (currentTimeMillis - lastModified < j && !jb.h(x.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        mb(file);
                    }
                }
            }
            i = i2 + 1;
        }
    }
}
