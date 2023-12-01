package com.tencent.tauth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.connect.common.AssistActivity;
import com.tencent.open.a.f;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tauth/AuthActivity.class */
public class AuthActivity extends Activity {
    private static final String ACTION_ADD_TO_QQFAVORITES = "addToQQFavorites";
    public static final String ACTION_KEY = "action";
    private static final String ACTION_SEND_TO_MY_COMPUTER = "sendToMyComputer";
    public static final String ACTION_SHARE_PRIZE = "sharePrize";
    private static final String ACTION_SHARE_TO_QQ = "shareToQQ";
    private static final String ACTION_SHARE_TO_QZONE = "shareToQzone";
    private static final String ACTION_SHARE_TO_TROOP_BAR = "shareToTroopBar";
    private static final String SHARE_PRIZE_ACTIVITY_ID = "activityid";
    private static final String TAG = "openSDK_LOG.AuthActivity";
    private static int mShareQzoneBackTime;

    private void execAuthCallback(Bundle bundle, String str) {
        f.a(TAG, "execAuthCallback url = " + str);
    }

    private void handleActionUri(Uri uri) {
        String str;
        f.c(TAG, "-->handleActionUri--start");
        if (uri == null || uri.toString() == null || uri.toString().equals("")) {
            f.d(TAG, "-->handleActionUri, uri invalid");
            finish();
            return;
        }
        String uri2 = uri.toString();
        Bundle decodeUrl = Util.decodeUrl(uri2.substring(uri2.indexOf("#") + 1));
        if (decodeUrl == null) {
            f.d(TAG, "-->handleActionUri, bundle is null");
            finish();
            return;
        }
        String string = decodeUrl.getString("action");
        f.c(TAG, "-->handleActionUri, action: " + string);
        if (string == null) {
            execAuthCallback(decodeUrl, uri2);
        } else if (string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("addToQQFavorites") || string.equals("sendToMyComputer") || string.equals("shareToTroopBar")) {
            if (string.equals("shareToQzone") && SystemUtils.getAppVersionName(this, "com.tencent.mobileqq") != null && SystemUtils.compareQQVersion(this, SystemUtils.QQ_VERSION_NAME_5_2_0) < 0) {
                int i = mShareQzoneBackTime + 1;
                mShareQzoneBackTime = i;
                if (i == 2) {
                    mShareQzoneBackTime = 0;
                    finish();
                    return;
                }
            }
            f.c(TAG, "-->handleActionUri, most share action, start assistactivity");
            Intent intent = new Intent(this, AssistActivity.class);
            intent.putExtras(decodeUrl);
            intent.setFlags(603979776);
            startActivity(intent);
            finish();
        } else if (!string.equals(ACTION_SHARE_PRIZE)) {
            execAuthCallback(decodeUrl, uri2);
        } else {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            try {
                str = Util.parseJson(decodeUrl.getString("response")).getString("activityid");
            } catch (Exception e) {
                f.b(TAG, "sharePrize parseJson has exception.", e);
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                launchIntentForPackage.putExtra(ACTION_SHARE_PRIZE, true);
                Bundle bundle = new Bundle();
                bundle.putString("activityid", str);
                launchIntentForPackage.putExtras(bundle);
            }
            startActivity(launchIntentForPackage);
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            f.d(TAG, "-->onCreate, getIntent() return null");
            return;
        }
        Uri uri = null;
        try {
            uri = getIntent().getData();
        } catch (Exception e) {
            f.e(TAG, "-->onCreate, getIntent().getData() has exception! " + e.getMessage());
        }
        f.a(TAG, "-->onCreate, uri: " + uri);
        handleActionUri(uri);
    }
}
