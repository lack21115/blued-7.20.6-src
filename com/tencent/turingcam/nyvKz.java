package com.tencent.turingcam;

import android.hardware.Camera;
import android.text.TextUtils;
import com.tencent.turingcam.EQsUZ;
import com.tencent.turingcam.kWj12;
import com.tencent.turingcam.s7Dnc;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/nyvKz.class */
public class nyvKz extends s7Dnc {
    private static final String b = WOMZP.b("XrAtCLyRZD+iVG+xiPkUocfEh7sxA2as2/upDg==");

    /* renamed from: c  reason: collision with root package name */
    private static final String f26139c = WOMZP.b("QkyoZDoA2EfeXs1uxHxbayaYRl76hMTg");
    private String d;
    private int e;
    private int f;
    private int g;
    private long h;

    public nyvKz() {
        super("4");
        this.f = -1;
        this.h = 0L;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public long a(kWj12.spXPg spxpg) {
        this.f = -1;
        this.d = spxpg.d();
        this.e = spxpg.a(5);
        Camera a2 = spxpg.a();
        EQsUZ.spXPg spxpg2 = new EQsUZ.spXPg();
        if (!EQsUZ.a(a2, b, spxpg2)) {
            hxUS9.b().a("checker_start_codes", a(), String.valueOf(-1001L));
            return -1001L;
        }
        this.g = ((Integer) spxpg2.a()).intValue();
        if (a2 == null || TextUtils.isEmpty(this.d)) {
            hxUS9.b().a("checker_start_codes", a(), String.valueOf(-1001L));
            return -1001L;
        }
        hxUS9.b().a("checker_start_codes", a(), String.valueOf(0L));
        return 0L;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public boolean a(s7Dnc.spXPg spxpg, Camera camera, wmqhz wmqhzVar) {
        if (this.f < 0) {
            byte[] bArr = spxpg.b;
            byte[] bytes = this.d.getBytes();
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            WeakReference weakReference = new WeakReference(camera);
            Class cls = Integer.TYPE;
            if (EQsUZ.a(camera, f26139c, new Class[]{Object.class, cls, cls, cls, Object.class}, new Object[]{weakReference, Integer.valueOf(this.g), 0, 0, bArr2})) {
                this.h = System.currentTimeMillis();
                this.f++;
                return false;
            }
            return true;
        }
        try {
            if (this.h > spxpg.f26142a) {
                return false;
            }
            int length = this.d.getBytes().length;
            byte[] bArr3 = new byte[length];
            System.arraycopy(spxpg.b, 0, bArr3, 0, length);
            Bi3eT bi3eT = new Bi3eT();
            bi3eT.b = a();
            bi3eT.f26119c = this.f;
            bi3eT.d = bArr3;
            wmqhzVar.f26150c.add(bi3eT);
            Arrays.equals(bArr3, this.d.getBytes());
            int i = this.f + 1;
            this.f = i;
            return i > this.e;
        } catch (Throwable th) {
            return false;
        }
    }
}
