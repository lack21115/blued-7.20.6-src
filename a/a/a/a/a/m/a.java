package a.a.a.a.a.m;

import a.a.a.a.a.a.b;
import a.a.a.a.a.e.e;
import a.a.a.a.a.m.b.a;
import com.qiniu.pili.droid.streaming.StreamingProfile;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/m/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f1450a = 15;
    public static int b = 10;

    /* renamed from: c  reason: collision with root package name */
    public static int f1451c = 3;
    public static int d = 10;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public double j;
    public double k;
    public a.a.a.a.a.m.b.a l;
    public boolean m = false;

    /* renamed from: a.a.a.a.a.m.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/m/a$a.class */
    public static class C0019a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1452a = new a();
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/m/a$b.class */
    public enum b {
        PLBitrateShiftTrendingNone,
        PLBitrateShiftTrendingUp,
        PLBitrateShiftTrendingDown
    }

    public static a a() {
        return C0019a.f1452a;
    }

    public static void a(int i, int i2) {
        f1451c = i;
        d = i2;
        e eVar = e.i;
        eVar.b("PLAdaptiveBitrate", "Threshold: Safe = " + f1451c + ", fps = " + d);
    }

    public final int a(int i) {
        boolean z = true;
        if (i > 0) {
            if (this.g - this.h > 5) {
                z = false;
            }
            double d2 = z ? this.j + 0.20000000298023224d : 0.0d;
            this.j = d2;
            int i2 = (int) (i + d2);
            this.h = this.g;
            this.k = 0.0d;
            return i2;
        }
        int i3 = i;
        if (i < 0) {
            double d3 = this.g - this.i <= 5 ? this.k - 0.20000000298023224d : 0.0d;
            this.k = d3;
            i3 = (int) (i + d3);
            this.i = this.g;
            this.j = 0.0d;
        }
        return i3;
    }

    public b a(a.a.a.a.a.a.b bVar) {
        float f;
        int i;
        b bVar2 = b.PLBitrateShiftTrendingNone;
        b bVar3 = bVar2;
        if (bVar != null) {
            if (!this.m) {
                return bVar2;
            }
            StreamingProfile f2 = bVar.f();
            bVar3 = bVar2;
            if (f2 != null) {
                if (!f2.a()) {
                    return bVar2;
                }
                StreamingProfile.StreamStatus streamStatus = f2.getStreamStatus();
                bVar3 = bVar2;
                if (streamStatus != null) {
                    int i2 = streamStatus.totalAVBitrateProduce;
                    bVar3 = bVar2;
                    if (i2 != 0) {
                        float f3 = streamStatus.meanTcpSendTimeInMilliseconds;
                        if (f3 == 0.0f) {
                            return bVar2;
                        }
                        double d2 = streamStatus.totalAVBitrate - i2;
                        e.i.b("PLAdaptiveBitrate", "diff out - in = " + d2);
                        if (this.l == null) {
                            a.a.a.a.a.m.b.a a2 = a.a.a.a.a.m.b.a.a();
                            this.l = a2;
                            a2.a(f3);
                        }
                        if (this.e > 0.0f) {
                            e.i.b("PLAdaptiveBitrate", "diff send time = " + (f3 - f));
                        }
                        this.e = this.l.b(f3);
                        e.i.b("PLAdaptiveBitrate", "predictedTCPSendTime = " + this.e);
                        if (d2 >= 0.0d) {
                            this.f++;
                        } else {
                            this.f--;
                        }
                        int min = Math.min(a.a.a.a.a.a.j.a.a().c(), a.a.a.a.a.a.j.a.a().d());
                        if (d >= min) {
                            d = min - 2;
                            e.i.c("PLAdaptiveBitrate", "FpsDangerousThreshold = " + d);
                        }
                        if (this.l.b() == a.b.PLNetworkQualityShiftTrendingUp && streamStatus.videoFps > d) {
                            this.f = 0;
                            i = 1;
                        } else if (this.l.b() == a.b.PLNetworkQualityShiftTrendingDown) {
                            this.f = 0;
                            i = -1;
                        } else {
                            i = 0;
                        }
                        int i3 = i;
                        if (this.f >= 3) {
                            i3 = i;
                            if (this.e < f1451c) {
                                i3 = i;
                                if (streamStatus.videoFps > d) {
                                    this.f = 0;
                                    i3 = 1;
                                }
                            }
                        }
                        if (f3 > f1450a) {
                            i3 = -1;
                        } else if (f3 > b && bVar.s() == b.c.FRAME_QUEUE_HAS_MANY_ELEMENTS) {
                            i3 = -1;
                        }
                        e.i.b("PLAdaptiveBitrate", "tcp send time = " + f3 + ", level shift = " + i3);
                        if (i3 != 0) {
                            bVar2 = ((float) i3) > 0.0f ? b.PLBitrateShiftTrendingUp : b.PLBitrateShiftTrendingDown;
                            int a3 = a(i3);
                            if (a3 != 0) {
                                if (bVar2 == b.PLBitrateShiftTrendingDown) {
                                    f2.reduceVideoQuality(Math.abs(a3));
                                } else if (bVar2 == b.PLBitrateShiftTrendingUp) {
                                    f2.improveVideoQuality(a3);
                                }
                                bVar.a(b.c.ADJUST_BITRATE, null);
                            } else {
                                c();
                            }
                        }
                        this.g++;
                        bVar3 = bVar2;
                    }
                }
            }
        }
        return bVar3;
    }

    public void a(boolean z) {
        if (this.m == z) {
            return;
        }
        this.m = z;
    }

    public void b() {
        this.e = -1.0f;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0.0d;
        this.k = 0.0d;
    }

    public final void c() {
        this.j = 0.0d;
        this.k = 0.0d;
    }
}
