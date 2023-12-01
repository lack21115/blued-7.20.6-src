package com.tencent.turingcam;

import android.hardware.Camera;
import com.tencent.turingcam.kWj12;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/s7Dnc.class */
public abstract class s7Dnc {

    /* renamed from: a  reason: collision with root package name */
    private final String f39832a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/s7Dnc$spXPg.class */
    public static class spXPg {

        /* renamed from: a  reason: collision with root package name */
        public long f39833a;
        public byte[] b;
    }

    public s7Dnc(String str) {
        this.f39832a = str;
    }

    public abstract long a(kWj12.spXPg spxpg);

    public String a() {
        return this.f39832a;
    }

    public abstract boolean a(spXPg spxpg, Camera camera, wmqhz wmqhzVar);
}
