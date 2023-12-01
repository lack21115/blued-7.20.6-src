package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003sl.aw;
import com.amap.api.col.p0003sl.ax;
import com.amap.api.col.p0003sl.bb;
import com.amap.api.col.p0003sl.dt;
import com.amap.api.col.p0003sl.dw;
import com.amap.api.col.p0003sl.hu;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.col.p0003sl.hy;
import com.amap.api.col.p0003sl.iw;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/offlinemap/OfflineMapManager.class */
public final class OfflineMapManager {
    bb a;
    ax b;
    private Context c;
    private OfflineMapDownloadListener d;
    private OfflineLoadedListener e;
    private Handler f;
    private Handler g;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/offlinemap/OfflineMapManager$OfflineLoadedListener.class */
    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/offlinemap/OfflineMapManager$OfflineMapDownloadListener.class */
    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) throws Exception {
        hy a = hx.a(context, dw.a());
        if (a.a != hx.c.SuccessCode) {
            throw new Exception(a.b);
        }
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        this.f = new Handler(this.c.getMainLooper());
        this.g = new Handler(this.c.getMainLooper());
        a(context);
        hu.a().a(this.c);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        this.f = new Handler(this.c.getMainLooper());
        this.g = new Handler(this.c.getMainLooper());
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() throws AMapException {
        if (!dw.d(this.c)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    private void a(Context context) {
        this.c = context.getApplicationContext();
        ax.b = false;
        ax a = ax.a(this.c);
        this.b = a;
        a.a(new ax.a() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1
            @Override // com.amap.api.col.p0003sl.ax.a
            public final void a() {
                if (OfflineMapManager.this.e != null) {
                    OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override // com.amap.api.col.p0003sl.ax.a
            public final void a(final aw awVar) {
                if (OfflineMapManager.this.d == null || awVar == null) {
                    return;
                }
                OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            OfflineMapManager.this.d.onDownload(awVar.c().b(), awVar.getcompleteCode(), awVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.p0003sl.ax.a
            public final void b(final aw awVar) {
                if (OfflineMapManager.this.d == null || awVar == null) {
                    return;
                }
                OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (!awVar.c().equals(awVar.g) && !awVar.c().equals(awVar.a)) {
                                OfflineMapManager.this.d.onCheckUpdate(false, awVar.getCity());
                                return;
                            }
                            OfflineMapManager.this.d.onCheckUpdate(true, awVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.p0003sl.ax.a
            public final void c(final aw awVar) {
                if (OfflineMapManager.this.d == null || awVar == null) {
                    return;
                }
                OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (awVar.c().equals(awVar.a)) {
                                OfflineMapManager.this.d.onRemove(true, awVar.getCity(), "");
                            } else {
                                OfflineMapManager.this.d.onRemove(false, awVar.getCity(), "");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        });
        try {
            this.b.a();
            this.a = this.b.f;
            dt.b(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String str) throws AMapException {
        this.b.a(str);
    }

    private void b() {
        this.d = null;
    }

    public final void destroy() {
        try {
            if (this.b != null) {
                this.b.f();
            }
            b();
            if (this.f != null) {
                this.f.removeCallbacksAndMessages(null);
            }
            this.f = null;
            if (this.g != null) {
                this.g.removeCallbacksAndMessages(null);
            }
            this.g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(String str) throws AMapException {
        try {
            this.b.f(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(String str) throws AMapException {
        try {
            this.b.e(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByProvinceName(String str) throws AMapException {
        try {
            a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            Iterator<OfflineMapCity> it = itemByProvinceName.getCityList().iterator();
            while (it.hasNext()) {
                final String city = it.next().getCity();
                this.g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            OfflineMapManager.this.b.e(city);
                        } catch (AMapException e) {
                            iw.c(e, "OfflineMapManager", "downloadByProvinceName");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                throw th;
            }
            iw.c(th, "OfflineMapManager", "downloadByProvinceName");
        }
    }

    public final ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.a.c();
    }

    public final ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.a.d();
    }

    public final ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.a.e();
    }

    public final ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.a.f();
    }

    public final OfflineMapCity getItemByCityCode(String str) {
        return this.a.a(str);
    }

    public final OfflineMapCity getItemByCityName(String str) {
        return this.a.b(str);
    }

    public final OfflineMapProvince getItemByProvinceName(String str) {
        return this.a.c(str);
    }

    public final ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.a.b();
    }

    public final ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.a.a();
    }

    public final void pause() {
        this.b.e();
    }

    public final void pauseByName(String str) {
        this.b.d(str);
    }

    public final void remove(String str) {
        try {
            if (this.b.b(str)) {
                this.b.c(str);
                return;
            }
            OfflineMapProvince c = this.a.c(str);
            if (c != null && c.getCityList() != null) {
                Iterator<OfflineMapCity> it = c.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            OfflineMapManager.this.b.c(city);
                        }
                    });
                }
                return;
            }
            if (this.d != null) {
                this.d.onRemove(false, str, "没有该城市");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void restart() {
    }

    public final void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.e = offlineLoadedListener;
    }

    public final void stop() {
        this.b.d();
    }

    public final void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        a(itemByCityCode.getCity());
    }

    public final void updateOfflineCityByName(String str) throws AMapException {
        a(str);
    }

    public final void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str);
    }
}
