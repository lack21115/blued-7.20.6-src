package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/je.class */
public class je {
    private static com.ss.android.downloadlib.addownload.mb.b mb;

    public static com.ss.android.downloadlib.addownload.mb.b mb() {
        return mb;
    }

    public static void mb(com.ss.android.downloadlib.addownload.mb.b bVar) {
        mb = bVar;
    }

    public static boolean mb(int i) {
        boolean z = true;
        if (i != 1) {
            z = true;
            if (i != 2) {
                z = true;
                if (i != 3) {
                    z = true;
                    if (i != 4) {
                        z = true;
                        if (i != 5) {
                            z = true;
                            if (i != 7) {
                                if (i == 8) {
                                    return true;
                                }
                                z = false;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public static boolean mb(final com.ss.android.downloadad.api.mb.ox oxVar, DownloadInfo downloadInfo, int i, final com.ss.android.downloadlib.addownload.b.b bVar) {
        if (oxVar == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("tryReverseWifi nativeModel null");
            return false;
        } else if (downloadInfo == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("tryReverseWifi info null");
            return false;
        } else {
            final int id = downloadInfo.getId();
            boolean ox = com.ss.android.downloadlib.utils.hj.ox(oxVar);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.SWITCH_STATUS, Integer.valueOf(ox ? 1 : 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_RESERVE_WIFI_SWITCH_STATUS, jSONObject, oxVar);
            if (ox && mb(i) && !DownloadUtils.isWifi(x.getContext()) && !downloadInfo.hasPauseReservedOnWifi()) {
                mb(new com.ss.android.downloadlib.addownload.mb.b() { // from class: com.ss.android.downloadlib.addownload.je.1
                    @Override // com.ss.android.downloadlib.addownload.mb.b
                    public void mb() {
                        je.mb((com.ss.android.downloadlib.addownload.mb.b) null);
                        DownloadInfo downloadInfo2 = Downloader.getInstance(x.getContext()).getDownloadInfo(id);
                        if (downloadInfo2 != null) {
                            downloadInfo2.startPauseReserveOnWifi();
                            RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo2);
                            AdEventHandler.mb().ox(EventConstants.Label.PAUSE_RESERVE_WIFI_CONFIRM, oxVar);
                        }
                        bVar.mb(oxVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.mb.b
                    public void ox() {
                        je.mb((com.ss.android.downloadlib.addownload.mb.b) null);
                        DownloadInfo downloadInfo2 = Downloader.getInstance(x.getContext()).getDownloadInfo(id);
                        if (downloadInfo2 != null) {
                            downloadInfo2.stopPauseReserveOnWifi();
                        }
                        AdEventHandler.mb().ox(EventConstants.Label.PAUSE_RESERVE_WIFI_CANCEL, oxVar);
                        bVar.mb(oxVar);
                    }
                });
                TTDelegateActivity.ox(oxVar);
                return true;
            }
            return false;
        }
    }
}
