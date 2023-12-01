package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.p0003sl.hd;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/share/ShareSearch.class */
public class ShareSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoHighWay = 3;
    public static final int DrivingNoHighWayAvoidCongestion = 6;
    public static final int DrivingNoHighWaySaveMoney = 5;
    public static final int DrivingNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 7;
    public static final int DrivingShortDistance = 2;
    public static final int NaviAvoidCongestion = 4;
    public static final int NaviDefault = 0;
    public static final int NaviNoHighWay = 3;
    public static final int NaviNoHighWayAvoidCongestion = 6;
    public static final int NaviNoHighWaySaveMoney = 5;
    public static final int NaviNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int NaviSaveMoney = 1;
    public static final int NaviSaveMoneyAvoidCongestion = 7;
    public static final int NaviShortDistance = 2;

    /* renamed from: a  reason: collision with root package name */
    private IShareSearch f5790a;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/share/ShareSearch$OnShareSearchListener.class */
    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String str, int i);

        void onDrivingRouteShareUrlSearched(String str, int i);

        void onLocationShareUrlSearched(String str, int i);

        void onNaviShareUrlSearched(String str, int i);

        void onPoiShareUrlSearched(String str, int i);

        void onWalkRouteShareUrlSearched(String str, int i);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/share/ShareSearch$ShareBusRouteQuery.class */
    public static class ShareBusRouteQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f5791a;
        private int b;

        public ShareBusRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f5791a = shareFromAndTo;
            this.b = i;
        }

        public int getBusMode() {
            return this.b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f5791a;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/share/ShareSearch$ShareDrivingRouteQuery.class */
    public static class ShareDrivingRouteQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f5792a;
        private int b;

        public ShareDrivingRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f5792a = shareFromAndTo;
            this.b = i;
        }

        public int getDrivingMode() {
            return this.b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f5792a;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/share/ShareSearch$ShareFromAndTo.class */
    public static class ShareFromAndTo {

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f5793a;
        private LatLonPoint b;

        /* renamed from: c  reason: collision with root package name */
        private String f5794c = "起点";
        private String d = "终点";

        public ShareFromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f5793a = latLonPoint;
            this.b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.f5793a;
        }

        public String getFromName() {
            return this.f5794c;
        }

        public LatLonPoint getTo() {
            return this.b;
        }

        public String getToName() {
            return this.d;
        }

        public void setFromName(String str) {
            this.f5794c = str;
        }

        public void setToName(String str) {
            this.d = str;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/share/ShareSearch$ShareNaviQuery.class */
    public static class ShareNaviQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f5795a;
        private int b;

        public ShareNaviQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f5795a = shareFromAndTo;
            this.b = i;
        }

        public ShareFromAndTo getFromAndTo() {
            return this.f5795a;
        }

        public int getNaviMode() {
            return this.b;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/share/ShareSearch$ShareWalkRouteQuery.class */
    public static class ShareWalkRouteQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f5796a;
        private int b;

        public ShareWalkRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f5796a = shareFromAndTo;
            this.b = i;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f5796a;
        }

        public int getWalkMode() {
            return this.b;
        }
    }

    public ShareSearch(Context context) throws AMapException {
        if (this.f5790a == null) {
            try {
                this.f5790a = new hd(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
            return null;
        }
        return null;
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery shareBusRouteQuery) {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
            return null;
        }
        return null;
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery shareDrivingRouteQuery) {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrl(latLonSharePoint);
            return null;
        }
        return null;
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public String searchNaviShareUrl(ShareNaviQuery shareNaviQuery) throws AMapException {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrl(shareNaviQuery);
            return null;
        }
        return null;
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery shareNaviQuery) {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrl(poiItem);
            return null;
        }
        return null;
    }

    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
            return null;
        }
        return null;
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery shareWalkRouteQuery) {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void setOnShareSearchListener(OnShareSearchListener onShareSearchListener) {
        IShareSearch iShareSearch = this.f5790a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }
}
