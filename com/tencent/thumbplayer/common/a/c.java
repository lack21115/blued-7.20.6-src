package com.tencent.thumbplayer.common.a;

import com.tencent.thumbplayer.api.TPNativeException;
import com.tencent.thumbplayer.api.capability.TPCapability;
import com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet;
import com.tencent.thumbplayer.common.a.d;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.l;
import java.util.UUID;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/common/a/c.class */
public class c {
    private void a(d.a aVar, a aVar2) {
        TPVCodecCapabilityForGet b = b();
        if (b != null) {
            aVar.f25580a = b.getMaxProfile();
            aVar.b = b.getMaxLevel();
        }
        aVar.a(aVar2);
    }

    private void a(d.b bVar, a aVar) {
        bVar.f25583c = TPSystemInfo.SDK_INT;
        bVar.f25582a = UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform();
        bVar.b = TPPlayerConfig.getPlatform();
        bVar.d = String.format("Android %s", TPSystemInfo.getOsVersion());
        bVar.e = String.format("%s_%s", TPSystemInfo.getDeviceManufacturer(), TPSystemInfo.getDeviceName());
        bVar.g = TPSystemInfo.getCpuHarewareName();
        bVar.a(aVar);
    }

    private void a(d.c cVar, a aVar) {
        TPVCodecCapabilityForGet e = e();
        if (e != null) {
            cVar.f25584a = e.getMaxProfile();
            cVar.b = e.getMaxLevel();
        }
        cVar.a(aVar);
    }

    private void a(d.C0847d c0847d, a aVar) {
        TPVCodecCapabilityForGet d = d();
        if (d != null) {
            c0847d.f25586a = d.getMaxProfile();
            c0847d.b = d.getMaxLevel();
        }
        c0847d.a(aVar);
    }

    private void a(d.e eVar, a aVar) {
        TPVCodecCapabilityForGet c2 = c();
        if (c2 != null) {
            eVar.f25588a = c2.getMaxProfile();
            eVar.b = c2.getMaxLevel();
        }
        eVar.a(aVar);
    }

    private static TPVCodecCapabilityForGet b() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        try {
            tPVCodecCapabilityForGet = TPCapability.getThumbPlayerVCodecTypeMaxCapability(1029, 102);
        } catch (TPNativeException e) {
            TPLogUtil.e("TPDeviceCapabilityReportManager", e);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == TPVCodecCapabilityForGet.mDefaultVCodecCapability) {
            return null;
        }
        return tPVCodecCapabilityForGet;
    }

    private static TPVCodecCapabilityForGet c() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        try {
            tPVCodecCapabilityForGet = TPCapability.getThumbPlayerVCodecTypeMaxCapability(166, 102);
        } catch (TPNativeException e) {
            TPLogUtil.e("TPDeviceCapabilityReportManager", e);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == TPVCodecCapabilityForGet.mDefaultVCodecCapability) {
            return null;
        }
        return tPVCodecCapabilityForGet;
    }

    private static TPVCodecCapabilityForGet d() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        try {
            tPVCodecCapabilityForGet = TPCapability.getThumbPlayerVCodecTypeMaxCapability(138, 102);
        } catch (TPNativeException e) {
            TPLogUtil.e("TPDeviceCapabilityReportManager", e);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == TPVCodecCapabilityForGet.mDefaultVCodecCapability) {
            return null;
        }
        return tPVCodecCapabilityForGet;
    }

    private static TPVCodecCapabilityForGet e() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        try {
            tPVCodecCapabilityForGet = TPCapability.getThumbPlayerVCodecTypeMaxCapability(172, 102);
        } catch (TPNativeException e) {
            TPLogUtil.e("TPDeviceCapabilityReportManager", e);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == TPVCodecCapabilityForGet.mDefaultVCodecCapability) {
            return null;
        }
        return tPVCodecCapabilityForGet;
    }

    private void f() {
        d dVar = new d();
        l lVar = new l();
        a(dVar.a(), lVar);
        a(dVar.b(), lVar);
        a(dVar.c(), lVar);
        a(dVar.d(), lVar);
        a(dVar.e(), lVar);
        TPLogUtil.i("TPDeviceCapabilityReportManager", "device capability report:" + lVar.toString());
        b.a("tp_common_device_cap", lVar);
    }

    public void a() {
        f();
    }
}
