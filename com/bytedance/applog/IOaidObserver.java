package com.bytedance.applog;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/IOaidObserver.class */
public interface IOaidObserver {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/IOaidObserver$Oaid.class */
    public static final class Oaid {
        public final String id;

        public Oaid(String str) {
            this.id = str;
        }
    }

    void onOaidLoaded(Oaid oaid);
}
