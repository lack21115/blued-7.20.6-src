package com.umeng.analytics.vshelper;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/vshelper/PageNameMonitor.class */
public class PageNameMonitor implements com.umeng.analytics.vshelper.a {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/vshelper/PageNameMonitor$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final PageNameMonitor f40810a = new PageNameMonitor();

        private a() {
        }
    }

    private PageNameMonitor() {
    }

    public static PageNameMonitor getInstance() {
        return a.f40810a;
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            if (currentCustomPage != null) {
                return currentCustomPage;
            } else if (currentActivity != null) {
                return currentActivity;
            } else {
                return null;
            }
        }
    }

    public String getCurrentActivityName() {
        String str;
        synchronized (lock) {
            str = currentActivity;
        }
        return str;
    }
}
