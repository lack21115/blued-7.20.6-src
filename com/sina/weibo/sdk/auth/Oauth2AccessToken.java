package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/auth/Oauth2AccessToken.class */
public class Oauth2AccessToken {
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_PHONE_NUM = "phone_num";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_UID = "uid";
    private String mAccessToken;
    private long mExpiresTime;
    private String mPhoneNum;
    private String mRefreshToken;
    private String mUid;

    public Oauth2AccessToken() {
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mPhoneNum = "";
    }

    @Deprecated
    public Oauth2AccessToken(String str) {
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mPhoneNum = "";
        if (str == null || str.indexOf("{") < 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setUid(jSONObject.optString("uid"));
            setToken(jSONObject.optString("access_token"));
            setExpiresIn(jSONObject.optString("expires_in"));
            setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
            setPhoneNum(jSONObject.optString(KEY_PHONE_NUM));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Oauth2AccessToken(String str, String str2) {
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mPhoneNum = "";
        this.mAccessToken = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.mExpiresTime = currentTimeMillis;
        if (str2 != null) {
            this.mExpiresTime = currentTimeMillis + (Long.parseLong(str2) * 1000);
        }
    }

    private static String getString(Bundle bundle, String str, String str2) {
        String str3 = str2;
        if (bundle != null) {
            String string = bundle.getString(str);
            str3 = str2;
            if (string != null) {
                str3 = string;
            }
        }
        return str3;
    }

    public static Oauth2AccessToken parseAccessToken(Bundle bundle) {
        if (bundle != null) {
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            oauth2AccessToken.setUid(getString(bundle, "uid", ""));
            oauth2AccessToken.setToken(getString(bundle, "access_token", ""));
            oauth2AccessToken.setExpiresIn(getString(bundle, "expires_in", ""));
            oauth2AccessToken.setRefreshToken(getString(bundle, KEY_REFRESH_TOKEN, ""));
            oauth2AccessToken.setPhoneNum(getString(bundle, KEY_PHONE_NUM, ""));
            return oauth2AccessToken;
        }
        return null;
    }

    public static Oauth2AccessToken parseAccessToken(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("{") < 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            oauth2AccessToken.setUid(jSONObject.optString("uid"));
            oauth2AccessToken.setToken(jSONObject.optString("access_token"));
            oauth2AccessToken.setExpiresIn(jSONObject.optString("expires_in"));
            oauth2AccessToken.setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
            oauth2AccessToken.setPhoneNum(jSONObject.optString(KEY_PHONE_NUM));
            return oauth2AccessToken;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setPhoneNum(String str) {
        this.mPhoneNum = str;
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public String getPhoneNum() {
        return this.mPhoneNum;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getToken() {
        return this.mAccessToken;
    }

    public String getUid() {
        return this.mUid;
    }

    public boolean isSessionValid() {
        return !TextUtils.isEmpty(this.mAccessToken);
    }

    public void setExpiresIn(String str) {
        if (TextUtils.isEmpty(str) || str.equals("0")) {
            return;
        }
        setExpiresTime(System.currentTimeMillis() + (Long.parseLong(str) * 1000));
    }

    public void setExpiresTime(long j) {
        this.mExpiresTime = j;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setToken(String str) {
        this.mAccessToken = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.mUid);
        bundle.putString("access_token", this.mAccessToken);
        bundle.putString(KEY_REFRESH_TOKEN, this.mRefreshToken);
        bundle.putString("expires_in", Long.toString(this.mExpiresTime));
        bundle.putString(KEY_PHONE_NUM, this.mPhoneNum);
        return bundle;
    }

    public String toString() {
        return "uid: " + this.mUid + ", access_token: " + this.mAccessToken + ", " + KEY_REFRESH_TOKEN + ": " + this.mRefreshToken + ", " + KEY_PHONE_NUM + ": " + this.mPhoneNum + ", expires_in: " + Long.toString(this.mExpiresTime);
    }
}
