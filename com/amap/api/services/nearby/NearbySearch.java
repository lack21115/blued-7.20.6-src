package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.p0003sl.gy;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/nearby/NearbySearch.class */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;
    private static NearbySearch a;
    private INearbySearch b;

    /* renamed from: com.amap.api.services.nearby.NearbySearch$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/nearby/NearbySearch$1.class */
    static final /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[NearbySearchFunctionType.values().length];
            a = iArr;
            try {
                iArr[NearbySearchFunctionType.DISTANCE_SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[NearbySearchFunctionType.DRIVING_DISTANCE_SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/nearby/NearbySearch$NearbyListener.class */
    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i);

        void onNearbyInfoUploaded(int i);

        void onUserInfoCleared(int i);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/nearby/NearbySearch$NearbyQuery.class */
    public static class NearbyQuery {
        private LatLonPoint a;
        private NearbySearchFunctionType b = NearbySearchFunctionType.DISTANCE_SEARCH;
        private int c = 1000;
        private int d = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        private int e = 1;

        public LatLonPoint getCenterPoint() {
            return this.a;
        }

        public int getCoordType() {
            return this.e;
        }

        public int getRadius() {
            return this.c;
        }

        public int getTimeRange() {
            return this.d;
        }

        public int getType() {
            int i = AnonymousClass1.a[this.b.ordinal()];
            int i2 = 1;
            if (i == 1 || i != 2) {
                i2 = 0;
            }
            return i2;
        }

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.a = latLonPoint;
        }

        public void setCoordType(int i) {
            if (i == 0 || i == 1) {
                this.e = i;
            } else {
                this.e = 1;
            }
        }

        public void setRadius(int i) {
            int i2 = i;
            if (i > 10000) {
                i2 = 10000;
            }
            this.c = i2;
        }

        public void setTimeRange(int i) {
            int i2;
            if (i < 5) {
                i2 = 5;
            } else {
                i2 = i;
                if (i > 86400) {
                    i2 = 86400;
                }
            }
            this.d = i2;
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.b = nearbySearchFunctionType;
        }
    }

    private NearbySearch(Context context) throws AMapException {
        if (this.b == null) {
            try {
                this.b = new gy(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    private void a() {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.destroy();
        }
        this.b = null;
    }

    public static void destroy() {
        synchronized (NearbySearch.class) {
            try {
                if (a != null) {
                    a.a();
                }
                a = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static NearbySearch getInstance(Context context) throws AMapException {
        NearbySearch nearbySearch;
        synchronized (NearbySearch.class) {
            try {
                if (a == null) {
                    try {
                        a = new NearbySearch(context);
                    } catch (AMapException e) {
                        throw e;
                    }
                }
                nearbySearch = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nearbySearch;
    }

    public void addNearbyListener(NearbyListener nearbyListener) {
        synchronized (this) {
            if (this.b != null) {
                this.b.addNearbyListener(nearbyListener);
            }
        }
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public void removeNearbyListener(NearbyListener nearbyListener) {
        synchronized (this) {
            if (this.b != null) {
                this.b.removeNearbyListener(nearbyListener);
            }
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i) {
        synchronized (this) {
            if (this.b != null) {
                this.b.startUploadNearbyInfoAuto(uploadInfoCallback, i);
            }
        }
    }

    public void stopUploadNearbyInfoAuto() {
        synchronized (this) {
            if (this.b != null) {
                this.b.stopUploadNearbyInfoAuto();
            }
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }
}
