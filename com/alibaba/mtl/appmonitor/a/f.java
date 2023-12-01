package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.log.e.i;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/f.class */
public enum f {
    ALARM(65501, 30, "alarmData", 5000),
    COUNTER(65502, 30, "counterData", 5000),
    OFFLINE_COUNTER(65133, 30, "counterData", 5000),
    STAT(65503, 30, "statData", 5000);
    
    static String TAG = "EventType";
    private int e;
    private int h;
    private int k;
    private String t;
    private int i = 25;
    private int j = 180;
    private boolean m = true;

    f(int i, int i2, String str, int i3) {
        this.e = i;
        this.h = i2;
        this.t = str;
        this.k = i3;
    }

    public static f a(int i) {
        f[] values = values();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= values.length) {
                return null;
            }
            f fVar = values[i3];
            if (fVar != null && fVar.m8582a() == i) {
                return fVar;
            }
            i2 = i3 + 1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m8582a() {
        return this.e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8583a() {
        return this.t;
    }

    public int b() {
        return this.h;
    }

    public void b(int i) {
        String str = TAG;
        String str2 = this.t;
        i.a(str, "[setTriggerCount]", str2, i + "");
        this.h = i;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public int c() {
        return this.i;
    }

    public void c(int i) {
        this.k = i;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public boolean isOpen() {
        return this.m;
    }

    public void setStatisticsInterval(int i) {
        this.i = i;
        this.j = i;
    }
}
