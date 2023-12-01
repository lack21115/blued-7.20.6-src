package com.huawei.hms.framework.common;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/common/RunnableEnhance.class */
public class RunnableEnhance implements Runnable {
    static final String TRANCELOGO = " -->";
    private String parentName = Thread.currentThread().getName();
    private Runnable proxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableEnhance(Runnable runnable) {
        this.proxy = runnable;
    }

    public String getParentName() {
        return this.parentName;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.proxy.run();
    }
}
