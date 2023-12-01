package com.soft.blued.ui.discover.model;

import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.StringHttpResponseHandler;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/model/MapsApiUtils.class */
public class MapsApiUtils {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/model/MapsApiUtils$OnGetAddressListener.class */
    public interface OnGetAddressListener {
        void onFinish(String str);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/model/MapsApiUtils$OnGetLocationListener.class */
    public interface OnGetLocationListener {
        void onFinish(double[] dArr);
    }

    public static void getAddress(String str, String str2, String str3, final OnGetAddressListener onGetAddressListener) {
        HttpManager.a("http://maps.google.com/maps/api/geocode/json?latlng=" + str2 + "," + str + "&sensor=false®ion=cn&language=" + str3, new StringHttpResponseHandler() { // from class: com.soft.blued.ui.discover.model.MapsApiUtils.2
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str4) {
                super.onFailure(th, i, (int) str4);
                OnGetAddressListener onGetAddressListener2 = OnGetAddressListener.this;
                if (onGetAddressListener2 != null) {
                    onGetAddressListener2.onFinish("");
                }
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onSuccess(String str4) {
                String str5;
                try {
                    str5 = new JSONObject(str4).getJSONArray("results").getJSONObject(0).getString("formatted_address");
                } catch (Exception e) {
                    e.printStackTrace();
                    str5 = "";
                }
                OnGetAddressListener onGetAddressListener2 = OnGetAddressListener.this;
                if (onGetAddressListener2 != null) {
                    onGetAddressListener2.onFinish(str5);
                }
            }
        }).h();
    }

    public static void getLocationInfo(String str, String str2, final OnGetLocationListener onGetLocationListener) {
        String replaceAll = str.replaceAll(" +", "");
        HttpManager.a("http://maps.google.com/maps/api/geocode/json?address=" + replaceAll + "&sensor=false&language=" + str2, new StringHttpResponseHandler() { // from class: com.soft.blued.ui.discover.model.MapsApiUtils.1
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str3) {
                super.onFailure(th, i, (int) str3);
                OnGetLocationListener onGetLocationListener2 = OnGetLocationListener.this;
                if (onGetLocationListener2 != null) {
                    onGetLocationListener2.onFinish(new double[2]);
                }
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onSuccess(String str3) {
                double[] dArr = new double[2];
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.getJSONArray("results").length() > 0) {
                        JSONObject jSONObject2 = jSONObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
                        double d = jSONObject2.getDouble("lng");
                        double d2 = jSONObject2.getDouble("lat");
                        dArr[0] = d;
                        dArr[1] = d2;
                    }
                } catch (Exception e) {
                }
                OnGetLocationListener onGetLocationListener2 = OnGetLocationListener.this;
                if (onGetLocationListener2 != null) {
                    onGetLocationListener2.onFinish(dArr);
                }
            }
        }).h();
    }
}
