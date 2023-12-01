package com.blued.android.framework.init;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/init/InitTask.class */
public abstract class InitTask {
    private String a;

    public InitTask(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public abstract void b();

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }
}
