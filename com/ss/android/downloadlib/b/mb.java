package com.ss.android.downloadlib.b;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.oplus.quickgame.sdk.hall.Constant;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/mb.class */
public class mb implements IDownloadCompleteHandler {
    private void mb(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri(Constant.Param.KEY_RPK_EXTERNAL), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{AdBaseConstants.MIME_APK}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.b.mb.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, uri.toString());
                        DownloadComponentManager.getDownloadCache().updateDownloadInfo(downloadInfo);
                    }
                }
            });
        } else {
            downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, ContentUris.withAppendedId(MediaStore.Files.getContentUri(Constant.Param.KEY_RPK_EXTERNAL), query.getInt(query.getColumnIndex("_id"))).toString());
        }
        DownloadUtils.safeClose(query);
    }

    private boolean mb(DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        File file = new File(str);
        String mb = com.ss.android.socialbase.appdownloader.u.mb.h.mb(x.getContext(), com.ss.android.socialbase.appdownloader.b.mb(downloadInfo, file), str);
        boolean z = false;
        if (!TextUtils.isEmpty(mb)) {
            String str2 = mb + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            z = false;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(downloadInfo.getSavePath());
                sb.append(File.separator);
                sb.append(str2);
                boolean renameTo = file.renameTo(new File(sb.toString()));
                z = renameTo;
                if (renameTo) {
                    z = renameTo;
                    downloadInfo.setName(str2);
                    return renameTo;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !mb(downloadInfo)) {
            return;
        }
        mb(x.getContext(), downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.utils.hj.ox(DownloadSetting.obtain(downloadInfo.getId()));
        }
        return false;
    }
}
