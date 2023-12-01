package com.amap.api.col.p0003sl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.col.3sl.af  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/af.class */
public final class af implements IUiSettingsDelegate {
    private IAMapDelegate b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4738c = true;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;
    private boolean i = true;
    private boolean j = false;
    private boolean k = true;
    private int l = 0;
    private int m = 1;
    private boolean n = true;
    private boolean o = false;
    private boolean p = false;

    /* renamed from: a  reason: collision with root package name */
    final Handler f4737a = new Handler(Looper.getMainLooper()) { // from class: com.amap.api.col.3sl.af.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message == null || af.this.b == null) {
                return;
            }
            try {
                switch (message.what) {
                    case 0:
                        af.this.b.showZoomControlsEnabled(af.this.h);
                        return;
                    case 1:
                        af.this.b.showScaleEnabled(af.this.j);
                        return;
                    case 2:
                        af.this.b.showCompassEnabled(af.this.i);
                        return;
                    case 3:
                        af.this.b.showMyLocationButtonEnabled(af.this.f);
                        return;
                    case 4:
                        af.this.b.showIndoorSwitchControlsEnabled(af.this.n);
                        return;
                    case 5:
                        af.this.b.showLogoEnabled(af.this.k);
                        return;
                    case 6:
                        af.this.b.refreshLogo();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                iw.c(th, "UiSettingsDelegateImp", "handleMessage");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final float getLogoMarginRate(int i) {
        return this.b.getLogoMarginRate(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getLogoPosition() throws RemoteException {
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getZoomPosition() throws RemoteException {
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isCompassEnabled() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isLogoEnable() {
        return this.k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isRotateGesturesEnabled() throws RemoteException {
        return this.f4738c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScaleControlsEnabled() throws RemoteException {
        return this.j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScrollGesturesEnabled() throws RemoteException {
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isTiltGesturesEnabled() throws RemoteException {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomControlsEnabled() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomGesturesEnabled() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomInByScreenCenter() {
        return this.o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void requestRefreshLogo() {
        this.f4737a.obtainMessage(6).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setAllGesturesEnabled(boolean z) throws RemoteException {
        setRotateGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setScrollGesturesEnabled(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setCompassEnabled(boolean z) throws RemoteException {
        this.i = z;
        this.f4737a.obtainMessage(2).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setGestureScaleByMapCenter(boolean z) throws RemoteException {
        this.p = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setIndoorSwitchEnabled(boolean z) throws RemoteException {
        this.n = z;
        this.f4737a.obtainMessage(4).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoBottomMargin(int i) {
        this.b.setLogoBottomMargin(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoEnable(boolean z) {
        this.k = z;
        this.f4737a.obtainMessage(5).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoLeftMargin(int i) {
        this.b.setLogoLeftMargin(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoMarginRate(int i, float f) {
        this.b.setLogoMarginRate(i, f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoPosition(int i) throws RemoteException {
        this.l = i;
        this.b.setLogoPosition(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setMyLocationButtonEnabled(boolean z) throws RemoteException {
        this.f = z;
        this.f4737a.obtainMessage(3).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setRotateGesturesEnabled(boolean z) throws RemoteException {
        this.f4738c = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScaleControlsEnabled(boolean z) throws RemoteException {
        this.j = z;
        this.f4737a.obtainMessage(1).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScrollGesturesEnabled(boolean z) throws RemoteException {
        this.d = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setTiltGesturesEnabled(boolean z) throws RemoteException {
        this.e = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomControlsEnabled(boolean z) throws RemoteException {
        this.h = z;
        this.f4737a.obtainMessage(0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomGesturesEnabled(boolean z) throws RemoteException {
        this.g = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomInByScreenCenter(boolean z) {
        this.o = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomPosition(int i) throws RemoteException {
        this.m = i;
        this.b.setZoomPosition(i);
    }
}
