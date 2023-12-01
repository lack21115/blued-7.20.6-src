package com.ss.android.socialbase.appdownloader.h;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.applog.tracker.Tracker;
import com.ss.android.socialbase.appdownloader.b.o;
import com.ss.android.socialbase.appdownloader.lz;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/h/hj.class */
public class hj {
    private static com.ss.android.socialbase.appdownloader.view.mb b;
    private static AlertDialog hj;
    private static final String mb = hj.class.getSimpleName();
    private static List<o> ox = new ArrayList();

    public static void mb(final Activity activity, final o oVar) {
        synchronized (hj.class) {
            if (oVar == null) {
                return;
            }
            if (activity != null) {
                try {
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        mb(false);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (!activity.isFinishing()) {
                    int mb2 = lz.mb(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_title");
                    int mb3 = lz.mb(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_message");
                    int mb4 = lz.mb(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_yes");
                    int mb5 = lz.mb(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_no");
                    ox.add(oVar);
                    if (hj == null || !hj.isShowing()) {
                        hj = new AlertDialog.Builder(activity).setTitle(mb2).setMessage(mb3).setPositiveButton(mb4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.h.hj.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                                hj.ox(Activity.this, oVar);
                                dialogInterface.cancel();
                                AlertDialog unused = hj.hj = null;
                            }
                        }).setNegativeButton(mb5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.h.hj.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                                hj.mb(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.h.hj.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i == 4) {
                                    if (keyEvent.getAction() == 1) {
                                        hj.mb(false);
                                        return true;
                                    }
                                    return true;
                                }
                                return false;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            }
            oVar.ox();
        }
    }

    public static void mb(boolean z) {
        synchronized (hj.class) {
            try {
                if (hj != null) {
                    hj.cancel();
                    hj = null;
                }
                for (o oVar : ox) {
                    if (oVar != null) {
                        if (z) {
                            oVar.mb();
                        } else {
                            oVar.ox();
                        }
                    }
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static boolean mb() {
        try {
            return NotificationManagerCompat.from(DownloadComponentManager.getAppContext()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static void ox(Activity activity, o oVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    com.ss.android.socialbase.appdownloader.view.mb mbVar = (com.ss.android.socialbase.appdownloader.view.mb) fragmentManager.findFragmentByTag(mb);
                    b = mbVar;
                    if (mbVar == null) {
                        b = new com.ss.android.socialbase.appdownloader.view.mb();
                        fragmentManager.beginTransaction().add(b, mb).commitAllowingStateLoss();
                        fragmentManager.executePendingTransactions();
                    }
                    b.mb();
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    oVar.mb();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
        }
        oVar.mb();
    }
}
