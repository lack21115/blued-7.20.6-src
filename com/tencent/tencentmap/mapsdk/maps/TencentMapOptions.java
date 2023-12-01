package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.AdapterType;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import java.lang.reflect.Field;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapOptions.class */
public final class TencentMapOptions {
    public static final int LOGO_POSITION_BOTTOM_CENTER = 4;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 1;
    public static final int LOGO_POSITION_TOP_CENTER = 5;
    public static final int LOGO_POSITION_TOP_LEFT = 3;
    public static final int LOGO_POSITION_TOP_RIGHT = 2;
    public static final int SCALEVIEW_POSITION_BOTTOM_CENTER = 4;
    public static final int SCALEVIEW_POSITION_BOTTOM_LEFT = 0;
    public static final int SCALEVIEW_POSITION_BOTTOM_RIGHT = 1;
    public static final int SCALEVIEW_POSITION_TOP_CENTER = 5;
    public static final int SCALEVIEW_POSITION_TOP_LEFT = 3;
    public static final int SCALEVIEW_POSITION_TOP_RIGHT = 2;
    public static final int ZOOM_POSITION_BOTTOM_LEFT = 0;
    public static final int ZOOM_POSITION_BOTTOM_RIGHT = 1;
    public static final int ZOOM_POSITION_TOP_LEFT = 3;
    public static final int ZOOM_POSITION_TOP_RIGHT = 2;
    private String customAssetsPath;
    private String customLocalPath;
    private String mCustomCacheRootPath;
    private String mCustomUserId;
    private String[] mDebugTags;
    private boolean mDisallowIntercept;
    private Object mExtSurface;
    private int mExtSurfaceHeight;
    private int mExtSurfaceWidth;
    private Callback<TencentMap> mMapCallback;
    private IMapKernel mMapKernel;
    private String mMapKey;
    private MapViewType mMapViewType;
    private Bundle mNetParams;
    private boolean mOfflineMapEnable;
    private TencentMap.OnMapLoadedCallback mOnMapLoadedCallback;
    private Object mProtocolDataDesc;
    private int mProtocolFrom;
    private String mSubId;
    private String mSubKey;
    private TrafficStyle mTrafficStyle;
    private Typeface mUserTypeface;
    private boolean isHandDrawMapEnable = false;
    private boolean isEnableMultipleInfoWindow = false;
    private String mSatelliteVersion = "0";
    private AdapterType mNetAdapterType = AdapterType.DEFAULT;
    private OverSeaSource mOverSeaSource = OverSeaSource.DEFAULT;
    private float mMapFrameRate = 60.0f;
    private boolean mOpaque = true;
    private boolean mForceHttps = true;
    private int mMaxIconMemoryCacheSize = 30;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapOptions$IMapKernel.class */
    public interface IMapKernel {
        String name();
    }

    private void setTypeface(Typeface typeface, boolean z) {
        if (typeface == null) {
            return;
        }
        if (!z) {
            this.mUserTypeface = typeface;
            return;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("DEFAULT");
            declaredField.setAccessible(true);
            declaredField.set(Typeface.DEFAULT, typeface);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TencentMapOptions.class != obj.getClass()) {
            return false;
        }
        TencentMapOptions tencentMapOptions = (TencentMapOptions) obj;
        if (this.isHandDrawMapEnable == tencentMapOptions.isHandDrawMapEnable && this.mExtSurfaceWidth == tencentMapOptions.mExtSurfaceWidth && this.mExtSurfaceHeight == tencentMapOptions.mExtSurfaceHeight && this.isEnableMultipleInfoWindow == tencentMapOptions.isEnableMultipleInfoWindow && this.mProtocolFrom == tencentMapOptions.mProtocolFrom && this.mOfflineMapEnable == tencentMapOptions.mOfflineMapEnable && Float.compare(tencentMapOptions.mMapFrameRate, this.mMapFrameRate) == 0 && this.mForceHttps == tencentMapOptions.mForceHttps) {
            String str = this.customAssetsPath;
            if (str != null) {
                if (!str.equals(tencentMapOptions.customAssetsPath)) {
                    return false;
                }
            } else if (tencentMapOptions.customAssetsPath != null) {
                return false;
            }
            String str2 = this.customLocalPath;
            if (str2 != null) {
                if (!str2.equals(tencentMapOptions.customLocalPath)) {
                    return false;
                }
            } else if (tencentMapOptions.customLocalPath != null) {
                return false;
            }
            String str3 = this.mCustomCacheRootPath;
            if (str3 != null) {
                if (!str3.equals(tencentMapOptions.mCustomCacheRootPath)) {
                    return false;
                }
            } else if (tencentMapOptions.mCustomCacheRootPath != null) {
                return false;
            }
            Object obj2 = this.mExtSurface;
            if (obj2 != null) {
                if (!obj2.equals(tencentMapOptions.mExtSurface)) {
                    return false;
                }
            } else if (tencentMapOptions.mExtSurface != null) {
                return false;
            }
            String str4 = this.mSubId;
            if (str4 != null) {
                if (!str4.equals(tencentMapOptions.mSubId)) {
                    return false;
                }
            } else if (tencentMapOptions.mSubId != null) {
                return false;
            }
            String str5 = this.mSubKey;
            if (str5 != null) {
                if (!str5.equals(tencentMapOptions.mSubKey)) {
                    return false;
                }
            } else if (tencentMapOptions.mSubKey != null) {
                return false;
            }
            String str6 = this.mMapKey;
            if (str6 != null) {
                if (!str6.equals(tencentMapOptions.mMapKey)) {
                    return false;
                }
            } else if (tencentMapOptions.mMapKey != null) {
                return false;
            }
            if (Arrays.equals(this.mDebugTags, tencentMapOptions.mDebugTags)) {
                String str7 = this.mSatelliteVersion;
                if (str7 != null) {
                    if (!str7.equals(tencentMapOptions.mSatelliteVersion)) {
                        return false;
                    }
                } else if (tencentMapOptions.mSatelliteVersion != null) {
                    return false;
                }
                if (this.mMapViewType != tencentMapOptions.mMapViewType) {
                    return false;
                }
                IMapKernel iMapKernel = this.mMapKernel;
                if (iMapKernel != null) {
                    if (!iMapKernel.equals(tencentMapOptions.mMapKernel)) {
                        return false;
                    }
                } else if (tencentMapOptions.mMapKernel != null) {
                    return false;
                }
                Typeface typeface = this.mUserTypeface;
                if (typeface != null) {
                    if (!typeface.equals(tencentMapOptions.mUserTypeface)) {
                        return false;
                    }
                } else if (tencentMapOptions.mUserTypeface != null) {
                    return false;
                }
                Object obj3 = this.mProtocolDataDesc;
                if (obj3 != null) {
                    if (!obj3.equals(tencentMapOptions.mProtocolDataDesc)) {
                        return false;
                    }
                } else if (tencentMapOptions.mProtocolDataDesc != null) {
                    return false;
                }
                if (this.mNetAdapterType != tencentMapOptions.mNetAdapterType) {
                    return false;
                }
                Bundle bundle = this.mNetParams;
                if (bundle != null) {
                    if (!bundle.equals(tencentMapOptions.mNetParams)) {
                        return false;
                    }
                } else if (tencentMapOptions.mNetParams != null) {
                    return false;
                }
                String str8 = this.mCustomUserId;
                if (str8 != null) {
                    if (!str8.equals(tencentMapOptions.mCustomUserId)) {
                        return false;
                    }
                } else if (tencentMapOptions.mCustomUserId != null) {
                    return false;
                }
                Callback<TencentMap> callback = this.mMapCallback;
                if (callback != null) {
                    if (!callback.equals(tencentMapOptions.mMapCallback)) {
                        return false;
                    }
                } else if (tencentMapOptions.mMapCallback != null) {
                    return false;
                }
                if (this.mOverSeaSource != tencentMapOptions.mOverSeaSource) {
                    return false;
                }
                TrafficStyle trafficStyle = this.mTrafficStyle;
                TrafficStyle trafficStyle2 = tencentMapOptions.mTrafficStyle;
                return trafficStyle != null ? trafficStyle.equals(trafficStyle2) : trafficStyle2 == null;
            }
            return false;
        }
        return false;
    }

    public final String getCustomAssetsPath() {
        return this.customAssetsPath;
    }

    public final String getCustomCacheRootPath() {
        return this.mCustomCacheRootPath;
    }

    public final String getCustomLocalPath() {
        return this.customLocalPath;
    }

    public String getCustomUserId() {
        return this.mCustomUserId;
    }

    public String[] getDebugTags() {
        return this.mDebugTags;
    }

    public final Object getExtSurface() {
        return this.mExtSurface;
    }

    public final int getExtSurfaceHeight() {
        return this.mExtSurfaceHeight;
    }

    public final int getExtSurfaceWidth() {
        return this.mExtSurfaceWidth;
    }

    public Callback<TencentMap> getMapAsyncCallback() {
        return this.mMapCallback;
    }

    public float getMapFrameRate() {
        return this.mMapFrameRate;
    }

    public IMapKernel getMapKernel() {
        return this.mMapKernel;
    }

    public final String getMapKey() {
        return this.mMapKey;
    }

    public MapViewType getMapViewType() {
        return this.mMapViewType;
    }

    public int getMaxIconMemoryCacheSize() {
        return this.mMaxIconMemoryCacheSize;
    }

    public AdapterType getNetAdapterType() {
        return this.mNetAdapterType;
    }

    public Bundle getNetParams() {
        return this.mNetParams;
    }

    public TencentMap.OnMapLoadedCallback getOnMapLoadedCallback() {
        return this.mOnMapLoadedCallback;
    }

    public OverSeaSource getOverSeaSource() {
        return this.mOverSeaSource;
    }

    public Object getProtocolDataDesc() {
        return this.mProtocolDataDesc;
    }

    public int getProtocolFrom() {
        return this.mProtocolFrom;
    }

    public String getSatelliteVersion() {
        return this.mSatelliteVersion;
    }

    public final String getSubId() {
        return this.mSubId;
    }

    public final String getSubKey() {
        return this.mSubKey;
    }

    public TrafficStyle getTrafficStyle() {
        return this.mTrafficStyle;
    }

    public Typeface getTypeface() {
        Typeface typeface = this.mUserTypeface;
        Typeface typeface2 = typeface;
        if (typeface == null) {
            typeface2 = Typeface.DEFAULT;
        }
        return typeface2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public boolean isDisallowInterceptTouchEvent() {
        return this.mDisallowIntercept;
    }

    public boolean isForceHttps() {
        return this.mForceHttps;
    }

    public final boolean isHandDrawMapEnable() {
        return this.isHandDrawMapEnable;
    }

    public final boolean isMultipleInfoWindowEnable() {
        return this.isEnableMultipleInfoWindow;
    }

    public boolean isOfflineMapEnable() {
        return this.mOfflineMapEnable;
    }

    public boolean isOpaque() {
        return this.mOpaque;
    }

    public final TencentMapOptions openDebugLogByTags(String... strArr) {
        this.mDebugTags = strArr;
        return this;
    }

    public final TencentMapOptions setCustomAssetsPath(String str) {
        this.customAssetsPath = str;
        return this;
    }

    public final TencentMapOptions setCustomCacheRootPath(String str) {
        this.mCustomCacheRootPath = str;
        return this;
    }

    public final TencentMapOptions setCustomLocalPath(String str) {
        this.customLocalPath = str;
        return this;
    }

    public TencentMapOptions setCustomUserID(String str) {
        this.mCustomUserId = str;
        return this;
    }

    public TencentMapOptions setDisallowInterceptTouchEvent(boolean z) {
        this.mDisallowIntercept = z;
        return this;
    }

    public final TencentMapOptions setExtSurface(Object obj) {
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture) || (obj instanceof SurfaceHolder)) {
            this.mExtSurface = obj;
            return this;
        }
        throw new IllegalArgumentException("Parameter Surface should be Surface,SurfaceTexture or SurfaceHolder");
    }

    public final TencentMapOptions setExtSurfaceDimension(int i, int i2) {
        this.mExtSurfaceWidth = i;
        this.mExtSurfaceHeight = i2;
        return this;
    }

    public TencentMapOptions setForceHttps(boolean z) {
        this.mForceHttps = z;
        return this;
    }

    public TencentMapOptions setGetMapAsync(Callback<TencentMap> callback) {
        this.mMapCallback = callback;
        return this;
    }

    public final TencentMapOptions setHandDrawMapEnable(boolean z) {
        this.isHandDrawMapEnable = z;
        return this;
    }

    public TencentMapOptions setMapFrameRate(float f) {
        this.mMapFrameRate = f;
        return this;
    }

    public final TencentMapOptions setMapKernel(IMapKernel iMapKernel) {
        this.mMapKernel = iMapKernel;
        return this;
    }

    public final TencentMapOptions setMapKey(String str) {
        this.mMapKey = str;
        return this;
    }

    public final TencentMapOptions setMapViewType(MapViewType mapViewType) {
        this.mMapViewType = mapViewType;
        return this;
    }

    public TencentMapOptions setMaxIconMemoryCacheSize(int i) {
        this.mMaxIconMemoryCacheSize = i;
        return this;
    }

    public final TencentMapOptions setMultipleInfoWindowEnable(boolean z) {
        this.isEnableMultipleInfoWindow = z;
        return this;
    }

    public TencentMapOptions setNetAdapter(AdapterType adapterType, Bundle bundle) {
        this.mNetAdapterType = adapterType;
        this.mNetParams = bundle;
        return this;
    }

    public TencentMapOptions setOfflineMapEnable(boolean z) {
        this.mOfflineMapEnable = z;
        return this;
    }

    public TencentMapOptions setOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.mOnMapLoadedCallback = onMapLoadedCallback;
        return this;
    }

    public TencentMapOptions setOpaque(boolean z) {
        this.mOpaque = z;
        return this;
    }

    public TencentMapOptions setOverSeaSource(OverSeaSource overSeaSource) {
        this.mOverSeaSource = overSeaSource;
        return this;
    }

    public TencentMapOptions setSatelliteVersion(String str) {
        this.mSatelliteVersion = str;
        return this;
    }

    public TencentMapOptions setServiceProtocol(int i, Object obj) {
        this.mProtocolFrom = i;
        this.mProtocolDataDesc = obj;
        return this;
    }

    public final TencentMapOptions setSubInfo(String str, String str2) {
        if (str != null) {
            this.mSubKey = str.trim();
        } else {
            this.mSubKey = "";
        }
        if (str2 != null) {
            this.mSubId = str2.trim();
            return this;
        }
        this.mSubId = "";
        return this;
    }

    public TencentMapOptions setTrafficStyle(TrafficStyle trafficStyle) {
        this.mTrafficStyle = trafficStyle;
        return this;
    }

    public final TencentMapOptions setTypeface(Typeface typeface) {
        setTypeface(typeface, false);
        return this;
    }

    public String toString() {
        return "TencentMapOptions{customAssetsPath='" + this.customAssetsPath + "', customLocalPath='" + this.customLocalPath + "', mCustomCacheRootPath='" + this.mCustomCacheRootPath + "', isHandDrawMapEnable=" + this.isHandDrawMapEnable + ", mExtSurface=" + this.mExtSurface + ", mExtSurfaceWidth=" + this.mExtSurfaceWidth + ", mExtSurfaceHeight=" + this.mExtSurfaceHeight + ", mSubId='" + this.mSubId + "', mSubKey='" + this.mSubKey + "', mMapKey='" + this.mMapKey + "', isEnableMultipleInfoWindow=" + this.isEnableMultipleInfoWindow + ", mDebugTags=" + Arrays.toString(this.mDebugTags) + ", mSatelliteVersion='" + this.mSatelliteVersion + "', mMapViewType=" + this.mMapViewType + ", mMapKernel=" + this.mMapKernel + ", mUserTypeface=" + this.mUserTypeface + ", mProtocolFrom=" + this.mProtocolFrom + ", mProtocolDataDesc=" + this.mProtocolDataDesc + ", mNetAdapterType=" + this.mNetAdapterType + ", mNetParams=" + this.mNetParams + ", mCustomUserId='" + this.mCustomUserId + "', mMapCallback=" + this.mMapCallback + ", mOfflineMapEnable=" + this.mOfflineMapEnable + ", mOverSeaSource=" + this.mOverSeaSource + ", mTrafficStyle=" + this.mTrafficStyle + ", mMapFrameRate=" + this.mMapFrameRate + ", mForceHttps=" + this.mForceHttps + ", mDisallowIntercept=" + this.mDisallowIntercept + '}';
    }
}
