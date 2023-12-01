package com.bytedance.bdtracker;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/l2.class */
public class l2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f21252a;

    public l2(m2 m2Var) {
        this.f21252a = m2Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= this.f21252a.f21260a.size()) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < 6) {
                        try {
                            this.f21252a.a(this.f21252a.f21260a.get(i2), new String[]{"openudid", "clientudid", "serial_number", "sim_serial_number", "udid", "device_id"}[i4]);
                        } catch (Exception e) {
                            z2.a(e);
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            } catch (Exception e2) {
                return;
            }
        }
    }
}
