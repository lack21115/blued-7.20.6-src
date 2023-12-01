package com.blued.android.share.sina;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/sina/AccessTokenKeeper.class */
public class AccessTokenKeeper {
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_UID = "uid";
    private static final String PREFERENCES_NAME = "com_weibo_sdk_android";

    public static void clear(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 32768).edit();
        edit.clear();
        edit.commit();
    }

    public static Oauth2AccessToken readAccessToken(Context context) {
        if (context == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 32768);
        oauth2AccessToken.setUid(sharedPreferences.getString(KEY_UID, ""));
        oauth2AccessToken.setToken(sharedPreferences.getString(KEY_ACCESS_TOKEN, ""));
        oauth2AccessToken.setExpiresTime(sharedPreferences.getLong(KEY_EXPIRES_IN, 0L));
        return oauth2AccessToken;
    }

    public static void writeAccessToken(Context context, Oauth2AccessToken oauth2AccessToken) {
        if (context == null || oauth2AccessToken == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 32768).edit();
        edit.putString(KEY_UID, oauth2AccessToken.getUid());
        edit.putString(KEY_ACCESS_TOKEN, oauth2AccessToken.getToken());
        edit.putLong(KEY_EXPIRES_IN, oauth2AccessToken.getExpiresTime());
        edit.commit();
    }
}
