package com.tencent.turingface.sdk.mfa;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/A0PGF.class */
public final class A0PGF extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f39855a;
    public final /* synthetic */ HashMap b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ITuringDeviceInfoProvider f39856c;
    public final /* synthetic */ Object d;

    public A0PGF(AtomicBoolean atomicBoolean, HashMap hashMap, ITuringDeviceInfoProvider iTuringDeviceInfoProvider, Object obj) {
        this.f39855a = atomicBoolean;
        this.b = hashMap;
        this.f39856c = iTuringDeviceInfoProvider;
        this.d = obj;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        if (this.f39855a.get()) {
            return;
        }
        try {
            HashMap hashMap = this.b;
            String imei = this.f39856c.getImei();
            String str = imei;
            if (imei == null) {
                str = "";
            }
            hashMap.put("274", str);
            HashMap hashMap2 = this.b;
            String imsi = this.f39856c.getImsi();
            String str2 = imsi;
            if (imsi == null) {
                str2 = "";
            }
            hashMap2.put("276", str2);
            HashMap hashMap3 = this.b;
            String androidId = this.f39856c.getAndroidId();
            String str3 = androidId;
            if (androidId == null) {
                str3 = "";
            }
            hashMap3.put("275", str3);
        } catch (Throwable th) {
            Log.w("Turing", "invoke info impl exception");
        }
        synchronized (this.d) {
            this.d.notify();
        }
    }
}
