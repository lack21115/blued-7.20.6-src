package com.tencent.lbssearch;

import android.content.Context;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.Address2GeoParam;
import com.tencent.lbssearch.object.param.DistrictChildrenParam;
import com.tencent.lbssearch.object.param.DistrictSearchParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.ParamObject;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.SearchParam;
import com.tencent.lbssearch.object.param.StreetViewParam;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.param.TranslateParam;
import com.tencent.lbssearch.object.result.Address2GeoResultObject;
import com.tencent.lbssearch.object.result.DistrictResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.StreetViewResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.lbssearch.object.result.TranslateResultObject;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.net.http.HttpResponseListener;
import com.tencent.mapsdk.internal.c7;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/TencentSearch.class */
public class TencentSearch implements UrlConstant {
    private final String mApiKey;
    private final Context mContext;
    private boolean mIsDebuggable;
    private final String mSecretKey;

    public TencentSearch(Context context) {
        this(context, null);
    }

    public TencentSearch(Context context, String str) {
        this(context, null, str);
    }

    public TencentSearch(Context context, String str, String str2) {
        this.mIsDebuggable = false;
        this.mContext = context;
        this.mApiKey = str;
        this.mSecretKey = str2;
        c7.a(context, str, context.getPackageName(), "");
    }

    private <T extends BaseObject> void doHttpGet(String str, ParamObject paramObject, Class<T> cls, HttpResponseListener<T> httpResponseListener) {
        if (!TencentMapInitializer.getAgreePrivacy()) {
            if (httpResponseListener != null) {
                httpResponseListener.onFailure(-1, "请确保隐私政策已取得用户同意", null);
            }
        } else if (paramObject == null || !paramObject.checkParams()) {
            if (this.mIsDebuggable) {
                Log.e("search", "wrong parameter");
            }
            if (httpResponseListener != null) {
                httpResponseListener.onFailure(-1, "参数缺少必要字段", null);
            }
        } else {
            String str2 = this.mApiKey;
            String str3 = str2;
            if (TextUtils.isEmpty(str2)) {
                String metaKey = Util.getMetaKey(this.mContext, "TencentMapSDK");
                str3 = metaKey;
                if (TextUtils.isEmpty(metaKey)) {
                    if (httpResponseListener != null) {
                        httpResponseListener.onFailure(-1, "请申请并填写开发者密钥", null);
                        return;
                    }
                    return;
                }
            }
            RequestParams buildParameters = paramObject.buildParameters();
            if (buildParameters != null) {
                buildParameters.add("key", str3);
                buildParameters.add(MediaStore.EXTRA_OUTPUT, "json");
            } else {
                buildParameters = new RequestParams();
            }
            if (!TextUtils.isEmpty(c7.A())) {
                buildParameters.add("__suid", c7.A());
            }
            if (!TextUtils.isEmpty(c7.z())) {
                buildParameters.add("__duid", c7.z());
            }
            buildParameters.add("__pf", "android");
            buildParameters.add("__chan", "search");
            buildParameters.add("__pid", Util.getRawAppName(this.mContext));
            buildParameters.add("__psv", Util.getAppVersion(this.mContext));
            buildParameters.add("__ver", "1.0.0");
            buildParameters.setDebuggable(this.mIsDebuggable);
            HttpProvider.get(this.mContext, str, buildParameters, cls, this.mSecretKey, httpResponseListener);
        }
    }

    public void address2geo(Address2GeoParam address2GeoParam, HttpResponseListener httpResponseListener) {
        doHttpGet(UrlConstant.GEOCODER_URL, address2GeoParam, Address2GeoResultObject.class, httpResponseListener);
    }

    public void geo2address(Geo2AddressParam geo2AddressParam, HttpResponseListener httpResponseListener) {
        doHttpGet(UrlConstant.GEOCODER_URL, geo2AddressParam, Geo2AddressResultObject.class, httpResponseListener);
    }

    public void getDistrictChildren(DistrictChildrenParam districtChildrenParam, HttpResponseListener httpResponseListener) {
        doHttpGet(UrlConstant.DISTRICT_CHILDREN_URL, districtChildrenParam, DistrictResultObject.class, httpResponseListener);
    }

    public void getDistrictList(HttpResponseListener httpResponseListener) {
        doHttpGet(UrlConstant.DISTRICT_LIST_URL, new DistrictChildrenParam(), DistrictResultObject.class, httpResponseListener);
    }

    public void getDistrictSearch(DistrictSearchParam districtSearchParam, HttpResponseListener httpResponseListener) {
        doHttpGet(UrlConstant.DISTRICT_SEARCH_URL, districtSearchParam, DistrictResultObject.class, httpResponseListener);
    }

    public void getRoutePlan(RoutePlanningParam routePlanningParam, HttpResponseListener httpResponseListener) {
        doHttpGet(routePlanningParam.getUrl(), routePlanningParam, routePlanningParam.getResultClass(), httpResponseListener);
    }

    public void getpano(StreetViewParam streetViewParam, HttpResponseListener httpResponseListener) {
        doHttpGet(UrlConstant.GETPANO_URL, streetViewParam, StreetViewResultObject.class, httpResponseListener);
    }

    public void search(SearchParam searchParam, HttpResponseListener httpResponseListener) {
        doHttpGet(UrlConstant.SEARCH_URL, searchParam, SearchResultObject.class, httpResponseListener);
    }

    public void setDebuggable(boolean z) {
        this.mIsDebuggable = z;
    }

    public void suggestion(SuggestionParam suggestionParam, HttpResponseListener httpResponseListener) {
        doHttpGet(UrlConstant.SUGGESTOIN_URL, suggestionParam, SuggestionResultObject.class, httpResponseListener);
    }

    public void translate(TranslateParam translateParam, HttpResponseListener httpResponseListener) {
        doHttpGet(UrlConstant.TRANSLATE_URL, translateParam, TranslateResultObject.class, httpResponseListener);
    }
}
