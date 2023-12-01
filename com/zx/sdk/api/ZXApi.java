package com.zx.sdk.api;

import android.app.Activity;
import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/zx/sdk/api/ZXApi.class */
public interface ZXApi {
    void addZXIDChangedListener(ZXIDChangedListener zXIDChangedListener);

    void allowPermissionDialog(boolean z);

    void checkPermission(Activity activity, PermissionCallback permissionCallback);

    void getAuthToken(Callback callback);

    void getSAID(String str, String str2, String str3, String str4, String str5, SAIDCallback sAIDCallback);

    void getTag(Callback callback);

    String getVersion();

    void getZXID(ZXIDListener zXIDListener);

    void init(Context context);

    String invoke(String str, String str2);

    boolean isAllowPermissionDialog();

    boolean isEnable();

    void setDebug(boolean z);

    void setEnable(boolean z);
}
