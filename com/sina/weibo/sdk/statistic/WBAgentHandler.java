package com.sina.weibo.sdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/statistic/WBAgentHandler.class */
public class WBAgentHandler {
    private static int MAX_CACHE_SIZE = 5;
    private static CopyOnWriteArrayList<PageLog> mActivePages;
    private static WBAgentHandler mInstance;
    private static Timer mLogTimer;
    private static Map<String, PageLog> mPages;
    private static Timer mTimer;

    private WBAgentHandler() {
        mActivePages = new CopyOnWriteArrayList<>();
        mPages = new HashMap();
        LogUtil.i(WBAgent.TAG, "init handler");
    }

    private void checkAppStatus(Context context) {
        if (isBackground(context)) {
            synchronized (mActivePages) {
                saveActivePages(mActivePages);
                mActivePages.clear();
            }
        }
    }

    private void checkNewSession(Context context, long j) {
        if (!PageLog.isNewSession(context, j)) {
            LogUtil.i(WBAgent.TAG, "is not a new session");
            return;
        }
        PageLog pageLog = new PageLog(context);
        pageLog.setType(LogType.SESSION_END);
        PageLog pageLog2 = new PageLog(context, j);
        pageLog2.setType(LogType.SESSION_START);
        synchronized (mActivePages) {
            if (pageLog.getEndTime() > 0) {
                mActivePages.add(pageLog);
            } else {
                LogUtil.d(WBAgent.TAG, "is a new install");
            }
            mActivePages.add(pageLog2);
        }
        LogUtil.d(WBAgent.TAG, "last session--- starttime:" + pageLog.getStartTime() + " ,endtime:" + pageLog.getEndTime());
        StringBuilder sb = new StringBuilder("is a new session--- starttime:");
        sb.append(pageLog2.getStartTime());
        LogUtil.d(WBAgent.TAG, sb.toString());
    }

    private void closeTimer() {
        Timer timer = mTimer;
        if (timer != null) {
            timer.cancel();
            mTimer = null;
        }
    }

    public static WBAgentHandler getInstance() {
        WBAgentHandler wBAgentHandler;
        synchronized (WBAgentHandler.class) {
            try {
                if (mInstance == null) {
                    mInstance = new WBAgentHandler();
                }
                wBAgentHandler = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wBAgentHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogsInMemory() {
        String str;
        synchronized (this) {
            str = "";
            if (mActivePages.size() > 0) {
                synchronized (mActivePages) {
                    str = LogBuilder.getPageLogs(mActivePages);
                    mActivePages.clear();
                }
            }
        }
        return str;
    }

    private boolean isBackground(Context context) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                if (runningAppProcessInfo.importance == 400) {
                    LogUtil.i(WBAgent.TAG, "后台:" + runningAppProcessInfo.processName);
                    return true;
                }
                LogUtil.i(WBAgent.TAG, "前台:" + runningAppProcessInfo.processName);
                return false;
            }
        }
        return false;
    }

    public static boolean isFirstStartBoolean(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(WBConstants.THIRD_APP_IS_FIRST, 0);
        boolean z = sharedPreferences.getBoolean(WBConstants.THIRD_APP_IS_FIRST_KEY, true);
        if (z) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(WBConstants.THIRD_APP_IS_FIRST_KEY, false);
            edit.commit();
        }
        return z;
    }

    private void saveActivePages(CopyOnWriteArrayList<PageLog> copyOnWriteArrayList) {
        synchronized (this) {
            final String pageLogs = LogBuilder.getPageLogs(copyOnWriteArrayList);
            WBAgentExecutor.execute(new Runnable() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    LogFileUtil.writeToFile(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME), pageLogs, true);
                }
            });
        }
    }

    private Timer timerTask(final Context context, long j, long j2) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
            }
        };
        if (j2 == 0) {
            timer.schedule(timerTask, j);
            return timer;
        }
        timer.schedule(timerTask, j, j2);
        return timer;
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        EventLog eventLog = new EventLog(str, str2, map);
        eventLog.setType(LogType.EVENT);
        synchronized (mActivePages) {
            mActivePages.add(eventLog);
        }
        if (map == null) {
            LogUtil.d(WBAgent.TAG, "event--- page:" + str + " ,event name:" + str2);
        } else {
            LogUtil.d(WBAgent.TAG, "event--- page:" + str + " ,event name:" + str2 + " ,extend:" + map.toString());
        }
        if (mActivePages.size() >= MAX_CACHE_SIZE) {
            synchronized (mActivePages) {
                saveActivePages(mActivePages);
                mActivePages.clear();
            }
        }
    }

    public void onKillProcess() {
        LogUtil.i(WBAgent.TAG, "save applogs and close timer and shutdown thread executor");
        synchronized (mActivePages) {
            saveActivePages(mActivePages);
        }
        mInstance = null;
        closeTimer();
        WBAgentExecutor.shutDownExecutor();
    }

    public void onPageEnd(String str) {
        if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
            return;
        }
        if (mPages.containsKey(str)) {
            PageLog pageLog = mPages.get(str);
            pageLog.setDuration(System.currentTimeMillis() - pageLog.getStartTime());
            synchronized (mActivePages) {
                mActivePages.add(pageLog);
            }
            synchronized (mPages) {
                mPages.remove(str);
            }
            LogUtil.d(WBAgent.TAG, String.valueOf(str) + ", " + (pageLog.getStartTime() / 1000) + ", " + (pageLog.getDuration() / 1000));
        } else {
            LogUtil.e(WBAgent.TAG, "please call onPageStart before onPageEnd");
        }
        if (mActivePages.size() >= MAX_CACHE_SIZE) {
            synchronized (mActivePages) {
                saveActivePages(mActivePages);
                mActivePages.clear();
            }
        }
    }

    public void onPageStart(String str) {
        if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
            return;
        }
        PageLog pageLog = new PageLog(str);
        pageLog.setType(LogType.FRAGMENT);
        synchronized (mPages) {
            mPages.put(str, pageLog);
        }
        LogUtil.d(WBAgent.TAG, String.valueOf(str) + ", " + (pageLog.getStartTime() / 1000));
    }

    public void onPause(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String name = context.getClass().getName();
        LogUtil.i(WBAgent.TAG, "update last page endtime:" + (currentTimeMillis / 1000));
        PageLog.updateSession(context, null, 0L, Long.valueOf(currentTimeMillis));
        if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
            if (mPages.containsKey(name)) {
                PageLog pageLog = mPages.get(name);
                pageLog.setDuration(currentTimeMillis - pageLog.getStartTime());
                synchronized (mActivePages) {
                    mActivePages.add(pageLog);
                }
                synchronized (mPages) {
                    mPages.remove(name);
                }
                LogUtil.d(WBAgent.TAG, String.valueOf(name) + ", " + (pageLog.getStartTime() / 1000) + ", " + (pageLog.getDuration() / 1000));
            } else {
                LogUtil.e(WBAgent.TAG, "please call onResume before onPause");
            }
            if (mActivePages.size() >= MAX_CACHE_SIZE) {
                synchronized (mActivePages) {
                    saveActivePages(mActivePages);
                    mActivePages.clear();
                }
            }
        }
        checkAppStatus(context);
    }

    public void onResume(Context context) {
        if (LogReport.getPackageName() == null) {
            LogReport.setPackageName(context.getPackageName());
        }
        if (mTimer == null) {
            mTimer = timerTask(context, 500L, StatisticConfig.getUploadInterval());
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = context.getClass().getName();
        checkNewSession(context, currentTimeMillis);
        if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
            PageLog pageLog = new PageLog(name, currentTimeMillis);
            pageLog.setType(LogType.ACTIVITY);
            synchronized (mPages) {
                mPages.put(name, pageLog);
            }
        }
        LogUtil.d(WBAgent.TAG, String.valueOf(name) + ", " + (currentTimeMillis / 1000));
    }

    public void onStop(Context context) {
        checkAppStatus(context);
    }

    public void registerApptoAd(final Context context, final String str, Map<String, String> map) {
        try {
            final AdEventLog adEventLog = new AdEventLog();
            adEventLog.setType(LogType.APP_AD_START);
            if (isFirstStartBoolean(context)) {
                adEventLog.setmEvent_id("1");
            }
            adEventLog.setmImei(MD5.hexdigest(Utility.getImei(context)));
            adEventLog.setmStart_time(System.currentTimeMillis());
            adEventLog.setmExtend(map);
            String aid = Utility.getAid(context, str);
            if (!TextUtils.isEmpty(aid)) {
                adEventLog.setmAid(aid);
                uploadAdlog(context, adEventLog);
                return;
            }
            TimerTask timerTask = new TimerTask() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    adEventLog.setmAid(Utility.getAid(context, str));
                    WBAgentHandler.this.uploadAdlog(context, adEventLog);
                }
            };
            Timer timer = new Timer();
            mLogTimer = timer;
            timer.schedule(timerTask, 5000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadAdlog(final Context context, AdEventLog adEventLog) {
        mActivePages.add(adEventLog);
        WBAgentExecutor.execute(new Runnable() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.5
            @Override // java.lang.Runnable
            public void run() {
                LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
            }
        });
    }

    public void uploadAppLogs(final Context context) {
        long currentTimeMillis = System.currentTimeMillis() - LogReport.getTime(context);
        if (LogReport.getTime(context) <= 0 || currentTimeMillis >= 30000) {
            WBAgentExecutor.execute(new Runnable() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
                }
            });
        } else {
            timerTask(context, 30000 - currentTimeMillis, 0L);
        }
    }
}
