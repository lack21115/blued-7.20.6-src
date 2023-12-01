package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.fp;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* renamed from: com.amap.api.col.3sl.gy  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gy.class */
public final class gy implements INearbySearch {
    private static long e;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Context f5022c;
    private fp d;
    private ExecutorService f;
    private UploadInfoCallback k;
    private TimerTask l;

    /* renamed from: a  reason: collision with root package name */
    private List<NearbySearch.NearbyListener> f5021a = new ArrayList();
    private LatLonPoint g = null;
    private String h = null;
    private boolean i = false;
    private Timer j = new Timer();

    /* renamed from: com.amap.api.col.3sl.gy$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gy$a.class */
    final class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(gy gyVar, byte b) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                if (gy.this.k != null) {
                    int b = gy.this.b(gy.this.k.OnUploadInfoCallback());
                    Message obtainMessage = gy.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = gy.this.f5021a;
                    obtainMessage.what = b;
                    gy.this.d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                fe.a(th, "NearbySearch", "UpdateDataTask");
            }
        }
    }

    public gy(Context context) throws AMapException {
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
        }
        this.f5022c = context.getApplicationContext();
        this.d = fp.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() throws AMapException {
        try {
            try {
                if (this.i) {
                    throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
                }
                if (a(this.b)) {
                    fn.a(this.f5022c);
                    return new fq(this.f5022c, this.b).d().intValue();
                }
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            } catch (Throwable th) {
                throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
            }
        } catch (AMapException e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(UploadInfo uploadInfo) {
        if (this.i) {
            return 2200;
        }
        return b(uploadInfo);
    }

    private static boolean a(NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(UploadInfo uploadInfo) {
        try {
            fn.a(this.f5022c);
            if (uploadInfo == null) {
                return 2202;
            }
            long time = new Date().getTime();
            if (time - e < 6500) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
            }
            e = time;
            String userID = uploadInfo.getUserID();
            if (a(userID)) {
                if (TextUtils.isEmpty(this.h)) {
                    this.h = userID;
                }
                if (userID.equals(this.h)) {
                    LatLonPoint point = uploadInfo.getPoint();
                    if (point != null && !point.equals(this.g)) {
                        new fs(this.f5022c, uploadInfo).d();
                        this.g = point.copy();
                        return 1000;
                    }
                    return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
                }
                return 2201;
            }
            return 2201;
        } catch (AMapException e2) {
            return e2.getErrorCode();
        } catch (Throwable th) {
            return 1900;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        synchronized (this) {
            try {
                this.f5021a.add(nearbyListener);
            } catch (Throwable th) {
                fe.a(th, "NearbySearch", "addNearbyListener");
            }
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void clearUserInfoAsyn() {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gy.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = gy.this.d.obtainMessage();
                    obtainMessage.arg1 = 8;
                    obtainMessage.obj = gy.this.f5021a;
                    try {
                        try {
                            gy.this.a();
                            obtainMessage.what = 1000;
                            if (gy.this.d != null) {
                                gy.this.d.sendMessage(obtainMessage);
                            }
                        } catch (AMapException e2) {
                            obtainMessage.what = e2.getErrorCode();
                            fe.a(e2, "NearbySearch", "clearUserInfoAsyn");
                            if (gy.this.d != null) {
                                gy.this.d.sendMessage(obtainMessage);
                            }
                        }
                    } catch (Throwable th) {
                        if (gy.this.d != null) {
                            gy.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void destroy() {
        synchronized (this) {
            try {
                this.j.cancel();
            } catch (Throwable th) {
                fe.a(th, "NearbySearch", "destryoy");
            }
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        synchronized (this) {
            if (nearbyListener == null) {
                return;
            }
            try {
                this.f5021a.remove(nearbyListener);
            } catch (Throwable th) {
                fe.a(th, "NearbySearch", "removeNearbyListener");
            }
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            fn.a(this.f5022c);
            if (a(nearbyQuery)) {
                return new fr(this.f5022c, nearbyQuery).d();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable th) {
            fe.a(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void searchNearbyInfoAsyn(final NearbySearch.NearbyQuery nearbyQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gy.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = gy.this.d.obtainMessage();
                    obtainMessage.arg1 = 9;
                    fp.f fVar = new fp.f();
                    fVar.f4966a = gy.this.f5021a;
                    obtainMessage.obj = fVar;
                    try {
                        try {
                            fVar.b = gy.this.searchNearbyInfo(nearbyQuery);
                            obtainMessage.what = 1000;
                            if (gy.this.d != null) {
                                gy.this.d.sendMessage(obtainMessage);
                            }
                        } catch (AMapException e2) {
                            obtainMessage.what = e2.getErrorCode();
                            fe.a(e2, "NearbySearch", "searchNearbyInfoAsyn");
                            if (gy.this.d != null) {
                                gy.this.d.sendMessage(obtainMessage);
                            }
                        }
                    } catch (Throwable th) {
                        if (gy.this.d != null) {
                            gy.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void setUserID(String str) {
        this.b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i) {
        synchronized (this) {
            int i2 = i;
            if (i < 7000) {
                i2 = 7000;
            }
            try {
                this.k = uploadInfoCallback;
                if (this.i && this.l != null) {
                    this.l.cancel();
                }
                this.i = true;
                a aVar = new a(this, (byte) 0);
                this.l = aVar;
                this.j.schedule(aVar, 0L, i2);
            } catch (Throwable th) {
                fe.a(th, "NearbySearch", "startUploadNearbyInfoAuto");
            }
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void stopUploadNearbyInfoAuto() {
        synchronized (this) {
            try {
                if (this.l != null) {
                    this.l.cancel();
                }
                this.i = false;
                this.l = null;
            }
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void uploadNearbyInfoAsyn(final UploadInfo uploadInfo) {
        if (this.f == null) {
            this.f = Executors.newSingleThreadExecutor();
        }
        this.f.submit(new Runnable() { // from class: com.amap.api.col.3sl.gy.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Message obtainMessage = gy.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = gy.this.f5021a;
                    obtainMessage.what = gy.this.a(uploadInfo);
                    gy.this.d.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    fe.a(th, "NearbySearch", "uploadNearbyInfoAsyn");
                }
            }
        });
    }
}
