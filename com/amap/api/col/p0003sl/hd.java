package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* renamed from: com.amap.api.col.3sl.hd  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hd.class */
public final class hd implements IShareSearch {
    private static String b = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";
    private static String c = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";
    private static String d = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";
    private static String e = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";
    private static final String f = "";
    private Context a;
    private ShareSearch.OnShareSearchListener g;

    public hd(Context context) throws AMapException {
        hy a = hx.a(context, fd.a(false));
        if (a.a != hx.c.SuccessCode) {
            throw new AMapException(a.b, 1, a.b, a.a.a());
        }
        this.a = context;
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        try {
            if (shareBusRouteQuery != null) {
                int busMode = shareBusRouteQuery.getBusMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                return new gh(this.a, String.format(b, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), shareFromAndTo.getFromName(), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), shareFromAndTo.getToName(), Integer.valueOf(busMode), 1, 0, f, f, f)).d();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            fe.a(e2, "ShareSearch", "searchBusRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchBusRouteShareUrlAsyn(final ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hd.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (hd.this.g == null) {
                        return;
                    }
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
                    obtainMessage.obj = hd.this.g;
                    try {
                        try {
                            String searchBusRouteShareUrl = hd.this.searchBusRouteShareUrl(shareBusRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchBusRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                            fp.a().sendMessage(obtainMessage);
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                            fp.a().sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        fp.a().sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        try {
            if (shareDrivingRouteQuery != null) {
                int drivingMode = shareDrivingRouteQuery.getDrivingMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                return new gh(this.a, String.format(b, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), shareFromAndTo.getFromName(), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), shareFromAndTo.getToName(), Integer.valueOf(drivingMode), 0, 0, f, f, f)).d();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            fe.a(e2, "ShareSearch", "searchDrivingRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchDrivingRouteShareUrlAsyn(final ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hd.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (hd.this.g == null) {
                        return;
                    }
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1104;
                    obtainMessage.obj = hd.this.g;
                    try {
                        try {
                            String searchDrivingRouteShareUrl = hd.this.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                            fp.a().sendMessage(obtainMessage);
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                            fp.a().sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        fp.a().sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        try {
            if (latLonSharePoint != null) {
                return new gh(this.a, String.format(c, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).d();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            fe.a(e2, "ShareSearch", "searchLocationShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchLocationShareUrlAsyn(final LatLonSharePoint latLonSharePoint) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hd.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (hd.this.g == null) {
                        return;
                    }
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1101;
                    obtainMessage.obj = hd.this.g;
                    try {
                        try {
                            String searchLocationShareUrl = hd.this.searchLocationShareUrl(latLonSharePoint);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchLocationShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                            fp.a().sendMessage(obtainMessage);
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                            fp.a().sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        fp.a().sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        try {
            if (shareNaviQuery != null) {
                ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
                if (fromAndTo.getTo() != null) {
                    LatLonPoint from = fromAndTo.getFrom();
                    LatLonPoint to = fromAndTo.getTo();
                    int naviMode = shareNaviQuery.getNaviMode();
                    return new gh(this.a, fromAndTo.getFrom() == null ? String.format(d, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode)) : String.format(d, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode))).d();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            fe.a(e2, "ShareSearch", "searchNaviShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchNaviShareUrlAsyn(final ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hd.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (hd.this.g == null) {
                        return;
                    }
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1102;
                    obtainMessage.obj = hd.this.g;
                    try {
                        try {
                            String searchNaviShareUrl = hd.this.searchNaviShareUrl(shareNaviQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchNaviShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                            fp.a().sendMessage(obtainMessage);
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                            fp.a().sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        fp.a().sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return new gh(this.a, String.format(e, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).d();
                }
            } catch (AMapException e2) {
                fe.a(e2, "ShareSearch", "searchPoiShareUrl");
                throw e2;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchPoiShareUrlAsyn(final PoiItem poiItem) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hd.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (hd.this.g == null) {
                        return;
                    }
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RESPONSE_ERROR;
                    obtainMessage.obj = hd.this.g;
                    try {
                        try {
                            String searchPoiShareUrl = hd.this.searchPoiShareUrl(poiItem);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchPoiShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                            fp.a().sendMessage(obtainMessage);
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                            fp.a().sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        fp.a().sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        try {
            if (shareWalkRouteQuery != null) {
                int walkMode = shareWalkRouteQuery.getWalkMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                return new gh(this.a, String.format(b, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), shareFromAndTo.getFromName(), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), shareFromAndTo.getToName(), Integer.valueOf(walkMode), 2, 0, f, f, f)).d();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            fe.a(e2, "ShareSearch", "searchWalkRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchWalkRouteShareUrlAsyn(final ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hd.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (hd.this.g == null) {
                        return;
                    }
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1105;
                    obtainMessage.obj = hd.this.g;
                    try {
                        try {
                            String searchWalkRouteShareUrl = hd.this.searchWalkRouteShareUrl(shareWalkRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                            fp.a().sendMessage(obtainMessage);
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                            fp.a().sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        fp.a().sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.g = onShareSearchListener;
    }
}
