package com.qiniu.pili.droid.shortvideo.a.a;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/a/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private int f27513a = 30;
    private float b = -1.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f27514c = 0.0f;
    private long d = 0;
    private long e = 0;

    public void a(int i) {
        this.f27513a = i;
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
        eVar.c("FPSController", "set desire fps:" + this.f27513a);
    }

    public boolean a() {
        int i;
        this.d++;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.d;
        if (j != 0) {
            long j2 = this.e;
            if (currentTimeMillis - j2 > 1000) {
                int round = Math.round((float) ((j * 1000) / (currentTimeMillis - j2)));
                this.e = currentTimeMillis;
                this.d = 0L;
                if (round <= this.f27513a) {
                    this.b = -1.0f;
                } else {
                    this.b = round / (round - i);
                }
                com.qiniu.pili.droid.shortvideo.f.e.f.b("FPSController", "average fps = " + round + ", delta fps = " + this.b);
            }
        }
        float f = this.b;
        if (f < 0.0f) {
            return false;
        }
        float f2 = this.f27514c + 1.0f;
        this.f27514c = f2;
        if (f2 >= f) {
            this.f27514c = f2 - f;
            return true;
        }
        return false;
    }
}
