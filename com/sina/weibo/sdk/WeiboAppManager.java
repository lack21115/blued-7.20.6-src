package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/WeiboAppManager.class */
public class WeiboAppManager {
    private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    private static WeiboAppManager sInstance;
    private Context mContext;
    private static final String TAG = WeiboAppManager.class.getName();
    private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/WeiboAppManager$WeiboInfo.class */
    public static class WeiboInfo {
        private String mPackageName;
        private int mSupportApi;

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageName(String str) {
            this.mPackageName = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSupportApi(int i) {
            this.mSupportApi = i;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public int getSupportApi() {
            return this.mSupportApi;
        }

        public boolean isLegal() {
            return !TextUtils.isEmpty(this.mPackageName) && this.mSupportApi > 0;
        }

        public String toString() {
            return "WeiboInfo: PackageName = " + this.mPackageName + ", supportApi = " + this.mSupportApi;
        }
    }

    private WeiboAppManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static WeiboAppManager getInstance(Context context) {
        WeiboAppManager weiboAppManager;
        synchronized (WeiboAppManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new WeiboAppManager(context);
                }
                weiboAppManager = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return weiboAppManager;
    }

    private WeiboInfo queryWeiboInfoByAsset(Context context) {
        WeiboInfo parseWeiboInfoByAsset;
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        WeiboInfo weiboInfo = null;
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.applicationInfo != null && !TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName) && (parseWeiboInfoByAsset = parseWeiboInfoByAsset(resolveInfo.serviceInfo.applicationInfo.packageName)) != null && (weiboInfo == null || weiboInfo.getSupportApi() < parseWeiboInfoByAsset.getSupportApi())) {
                weiboInfo = parseWeiboInfoByAsset;
            }
        }
        return weiboInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sina.weibo.sdk.WeiboAppManager.WeiboInfo queryWeiboInfoByProvider(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.WeiboAppManager.queryWeiboInfoByProvider(android.content.Context):com.sina.weibo.sdk.WeiboAppManager$WeiboInfo");
    }

    private WeiboInfo queryWeiboInfoInternal(Context context) {
        WeiboInfo queryWeiboInfoByProvider = queryWeiboInfoByProvider(context);
        WeiboInfo queryWeiboInfoByAsset = queryWeiboInfoByAsset(context);
        boolean z = true;
        boolean z2 = queryWeiboInfoByProvider != null;
        if (queryWeiboInfoByAsset == null) {
            z = false;
        }
        if (z2 && z) {
            return queryWeiboInfoByProvider.getSupportApi() >= queryWeiboInfoByAsset.getSupportApi() ? queryWeiboInfoByProvider : queryWeiboInfoByAsset;
        } else if (z2) {
            return queryWeiboInfoByProvider;
        } else {
            if (z) {
                return queryWeiboInfoByAsset;
            }
            return null;
        }
    }

    public WeiboInfo getWeiboInfo() {
        WeiboInfo queryWeiboInfoInternal;
        synchronized (this) {
            queryWeiboInfoInternal = queryWeiboInfoInternal(this.mContext);
        }
        return queryWeiboInfoInternal;
    }

    public WeiboInfo parseWeiboInfoByAsset(String str) {
        InputStream inputStream;
        byte[] bArr;
        InputStream inputStream2 = null;
        try {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    bArr = new byte[4096];
                    inputStream = this.mContext.createPackageContext(str, 2).getAssets().open(SDK_INT_FILE_NAME);
                } catch (PackageManager.NameNotFoundException e) {
                    e = e;
                    inputStream = null;
                } catch (IOException e2) {
                    e = e2;
                    inputStream = null;
                } catch (JSONException e3) {
                    e = e3;
                    inputStream = null;
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e5) {
                            LogUtil.e(TAG, e5.getMessage());
                        }
                    }
                    throw th;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    if (!TextUtils.isEmpty(sb.toString()) && ApiUtils.validateWeiboSign(this.mContext, str)) {
                        int optInt = new JSONObject(sb.toString()).optInt("support_api", -1);
                        WeiboInfo weiboInfo = new WeiboInfo();
                        weiboInfo.setPackageName(str);
                        weiboInfo.setSupportApi(optInt);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return weiboInfo;
                            } catch (IOException e6) {
                                LogUtil.e(TAG, e6.getMessage());
                            }
                        }
                        return weiboInfo;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e7) {
                            LogUtil.e(TAG, e7.getMessage());
                            return null;
                        }
                    }
                    return null;
                } catch (PackageManager.NameNotFoundException e8) {
                    e = e8;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        inputStream.close();
                        return null;
                    }
                    return null;
                } catch (IOException e9) {
                    e = e9;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        inputStream.close();
                        return null;
                    }
                    return null;
                } catch (JSONException e10) {
                    e = e10;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        inputStream.close();
                        return null;
                    }
                    return null;
                } catch (Exception e11) {
                    e = e11;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        inputStream.close();
                        return null;
                    }
                    return null;
                }
            } catch (IOException e12) {
                LogUtil.e(TAG, e12.getMessage());
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
