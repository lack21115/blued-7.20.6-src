package com.tencent.turingcam;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.t;
import com.tencent.turingface.sdk.mfa.A48DB;
import com.tencent.turingface.sdk.mfa.CFgXs;
import com.tencent.turingface.sdk.mfa.HDnuc;
import com.tencent.turingface.sdk.mfa.ITuringDeviceInfoProvider;
import com.tencent.turingface.sdk.mfa.LJPko;
import com.tencent.turingface.sdk.mfa.ZIDl7;
import com.tencent.turingface.sdk.mfa.i3cNc;
import com.tencent.turingface.sdk.mfa.jb1kT;
import com.tencent.turingface.sdk.mfa.n6fHX;
import com.tencent.turingface.sdk.mfa.rBDKv;
import com.tencent.turingface.sdk.mfa.vneRm;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/y8N3A.class */
public class y8N3A {

    /* renamed from: a  reason: collision with root package name */
    private static final y8N3A f26151a = new y8N3A();
    public static final String b = Build.MODEL;

    /* renamed from: c  reason: collision with root package name */
    private Context f26152c;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/y8N3A$ShGzN.class */
    class ShGzN implements n6fHX {
        ShGzN(y8N3A y8n3a) {
        }

        @Override // com.tencent.turingface.sdk.mfa.spXPg
        public boolean a() {
            return true;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/y8N3A$SkEpO.class */
    public static class SkEpO {

        /* renamed from: a  reason: collision with root package name */
        int f26153a = 0;
        String b = "";
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/y8N3A$spXPg.class */
    class spXPg implements ITuringDeviceInfoProvider {
        spXPg(y8N3A y8n3a) {
        }

        @Override // com.tencent.turingface.sdk.mfa.ITuringDeviceInfoProvider
        public String getAndroidId() {
            return null;
        }

        @Override // com.tencent.turingface.sdk.mfa.ITuringDeviceInfoProvider
        public String getImei() {
            return null;
        }

        @Override // com.tencent.turingface.sdk.mfa.ITuringDeviceInfoProvider
        public String getImsi() {
            return null;
        }
    }

    private y8N3A() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static y8N3A a() {
        return f26151a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TuringFaceBuilder turingFaceBuilder) {
        this.f26152c = turingFaceBuilder.getContext().getApplicationContext();
        HashSet hashSet = new HashSet();
        hashSet.add(17);
        hashSet.add(43);
        hashSet.add(40);
        hashSet.add(102);
        hashSet.add(114);
        hashSet.add(5);
        hashSet.add(4);
        jb1kT.spXPg spxpg = new jb1kT.spXPg(this.f26152c, new ShGzN(this));
        spxpg.m = !TextUtils.isEmpty(turingFaceBuilder.getHostUrl()) ? turingFaceBuilder.getHostUrl() : "";
        spxpg.b = 108098;
        spxpg.i = true;
        spxpg.j = true;
        spxpg.l = new spXPg(this);
        spxpg.o = 0L;
        spxpg.n = turingFaceBuilder.getTuringNetwork();
        spxpg.p = hashSet;
        spxpg.q = b;
        jb1kT jb1kt = new jb1kT(spxpg);
        HDnuc.e = jb1kt;
        i3cNc.a(jb1kt.e);
        AtomicBoolean atomicBoolean = HDnuc.d;
        if (atomicBoolean.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.SIMPLIFIED_CHINESE, "TuringFD v%d", 77));
        sb.append(" (7A239E5DD15748A2");
        sb.append(", mfa");
        sb.append(", 150176e");
        StringBuilder sb2 = new StringBuilder();
        if (sb2.toString().length() > 0) {
            sb2.append(t.aE);
        }
        sb2.append("tss");
        if (sb2.toString().length() > 0) {
            sb2.append(t.aE);
        }
        sb2.append("rfr");
        if (sb2.toString().length() > 0) {
            sb2.append(t.aE);
        }
        sb2.append("ite");
        if (sb2.toString().length() > 0) {
            sb2.append(t.aE);
        }
        sb2.append("rs");
        String sb3 = sb2.toString();
        if (!TextUtils.isEmpty(sb3)) {
            sb.append(", ");
            sb.append(sb3);
        }
        sb.append(", ");
        StringBuilder sb4 = new StringBuilder();
        if (sb4.toString().length() > 0) {
            sb4.append(t.aE);
        }
        sb4.append("wup");
        sb.append(sb4.toString());
        sb.append(String.format(Locale.SIMPLIFIED_CHINESE, ", compiled %s)", "2023_03_20_15_32_49"));
        com.tencent.turingface.sdk.mfa.CvowV cvowV = HDnuc.e;
        if (cvowV != null) {
            sb.append(" [");
            StringBuilder sb5 = new StringBuilder();
            StringBuilder b2 = oqKCa.b("url(");
            b2.append(cvowV.i);
            b2.append(")");
            String sb6 = b2.toString();
            if (sb5.toString().length() > 0) {
                sb5.append(t.aE);
            }
            sb5.append(sb6);
            String str = "c(" + cvowV.f + ")";
            if (sb5.toString().length() > 0) {
                sb5.append(t.aE);
            }
            sb5.append(str);
            if (cvowV.x) {
                if (sb5.toString().length() > 0) {
                    sb5.append(t.aE);
                }
                sb5.append("ext");
            }
            sb.append(sb5.toString());
            sb.append("]");
        }
        Log.i("TuringFdJava", sb.toString());
        synchronized (HDnuc.f26189c) {
            int i = jb1kt.f;
            if (i > 0) {
                oqKCa.f26140a = i;
            }
            String str2 = jb1kt.z;
            AtomicReference<String> atomicReference = CFgXs.f26172a;
            if (!TextUtils.isEmpty(str2)) {
                synchronized (atomicReference) {
                    atomicReference.set(str2);
                }
            }
            AtomicBoolean atomicBoolean2 = HDnuc.b;
            if (atomicBoolean2.get()) {
                HDnuc.a(jb1kt);
            } else if (atomicBoolean.get()) {
            } else {
                atomicBoolean.set(true);
                System.currentTimeMillis();
                if (HDnuc.b(jb1kt) != 0) {
                    atomicBoolean2.set(false);
                } else if (HDnuc.c(jb1kt) != 0) {
                    atomicBoolean2.set(false);
                } else if (oqKCa.f26140a == 0) {
                    Log.e("TuringFdJava", "pleace input valid channel !");
                    atomicBoolean2.set(false);
                } else {
                    A48DB.f26166a.b = jb1kt;
                    HDnuc.a(jb1kt);
                    atomicBoolean2.set(true);
                    atomicBoolean.set(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SkEpO b() {
        Context context = this.f26152c;
        int a2 = HDnuc.a();
        vneRm a3 = a2 != 0 ? vneRm.a(a2) : rBDKv.f26294a.a(context, true, 1);
        SkEpO skEpO = new SkEpO();
        vneRm vnerm = a3;
        skEpO.b = vnerm.f26311a;
        skEpO.f26153a = vnerm.f26312c;
        return skEpO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() {
        Context context = this.f26152c;
        com.tencent.turingface.sdk.mfa.CvowV cvowV = LJPko.f26202a;
        ZIDl7 zIDl7 = new ZIDl7();
        zIDl7.b = 0;
        return LJPko.a(context, zIDl7, false);
    }
}
