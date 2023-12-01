package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/common/hianalytics/InitReport.class */
public class InitReport {
    private static final int EVENT_LIMIT = 10;
    private static final String TAG = "HaReport";
    private static List<Runnable> eventsToReport = new CopyOnWriteArrayList();
    private static boolean hasConnectNet = false;

    public static void enableConnectNet() {
        hasConnectNet = true;
        try {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new Runnable() { // from class: com.huawei.hms.framework.common.hianalytics.InitReport.1
                @Override // java.lang.Runnable
                public void run() {
                    InitReport.submitAllEvents();
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.e(TAG, "the thread submit has rejectedExecutionException!");
        } catch (Throwable th) {
            Logger.e(TAG, "the thread submit has fatal error!");
        }
    }

    public static void reportWhenInit(Runnable runnable) {
        if (!hasConnectNet) {
            if (eventsToReport.size() > 10) {
                Logger.e("TAG", "the event to be report when init exceed the limit!");
                return;
            } else {
                eventsToReport.add(runnable);
                return;
            }
        }
        try {
            HianalyticsHelper.getInstance().getReportExecutor().execute(runnable);
        } catch (RejectedExecutionException e) {
            Logger.e(TAG, "the thread submit has rejectedExecutionException!");
        } catch (Throwable th) {
            Logger.e(TAG, "the thread submit has fatal error!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void submitAllEvents() {
        try {
            for (Runnable runnable : eventsToReport) {
                HianalyticsHelper.getInstance().getReportExecutor().submit(runnable);
            }
            eventsToReport.clear();
        } catch (NullPointerException e) {
            Logger.e(TAG, "event is null occured");
        } catch (RejectedExecutionException e2) {
            Logger.e(TAG, "submit failed of rejected execution exception");
        } catch (Exception e3) {
            Logger.e(TAG, "submit failed because of some exception");
        }
    }
}
