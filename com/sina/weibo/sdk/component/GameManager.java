package com.sina.weibo.sdk.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/GameManager.class */
public class GameManager {
    public static final String DEFAULT_CHARSET = "UTF-8";
    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final String TAG = "GameManager";
    private static StringBuffer URL = new StringBuffer("https://api.weibo.com/2/proxy/darwin/graph/game/");
    private static final String BOUNDARY = HttpManager.getBoundry();
    private static String URL_ACHIEVEMENT_ADD_UPDATE = ((Object) URL) + "achievement/add.json";
    private static String URL_ACHIEVEMENT_RELATION_ADD_UPDATE = ((Object) URL) + "achievement/gain/add.json";
    private static String URL_ACHIEVEMENT_SCORE_ADD_UPDATE = ((Object) URL) + "score/add.json";
    private static String URL_ACHIEVEMENT_READ_PLAYER_SCORE = ((Object) URL) + "score/read_player.json";
    private static String URL_ACHIEVEMENT_READ_PLAYER_FRIENDS = ((Object) URL) + "score/read_player_friends.json";
    private static String URL_ACHIEVEMENT_USER_GAIN = ((Object) URL) + "achievement/user_gain.json";
    private static String INVITATION_URL = "http://widget.weibo.com/invitation/app.php?";
    private static String INVITATION_ONE_FRINED_URL = "http://widget.weibo.com/invitation/appinfo.php?";

    public static String AddOrUpdateGameAchievement(Context context, WeiboParameters weiboParameters) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        weiboParameters.put("updated_time", simpleDateFormat.format(date));
        if (TextUtils.isEmpty((String) weiboParameters.get(WBConstants.GAME_PARAMS_GAME_CREATE_TIME))) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, simpleDateFormat.format(date));
        }
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_ADD_UPDATE, "POST", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String addOrUpdateAchievementScore(Context context, String str, String str2, String str3, String str4, String str5) {
        WeiboParameters weiboParameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(str)) {
            weiboParameters.put("access_token", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboParameters.put("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_ID, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            weiboParameters.put("uid", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_SCORE, str5);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        weiboParameters.put("updated_time", simpleDateFormat.format(date));
        if (TextUtils.isEmpty((String) weiboParameters.get(WBConstants.GAME_PARAMS_GAME_CREATE_TIME))) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, simpleDateFormat.format(date));
        }
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_SCORE_ADD_UPDATE, "POST", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String addOrUpdateGameAchievementRelation(Context context, WeiboParameters weiboParameters) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        weiboParameters.put("updated_time", simpleDateFormat.format(date));
        if (TextUtils.isEmpty((String) weiboParameters.get(WBConstants.GAME_PARAMS_GAME_CREATE_TIME))) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, simpleDateFormat.format(date));
        }
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_RELATION_ADD_UPDATE, "POST", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String readPlayerAchievementGain(Context context, String str, String str2, String str3, String str4) {
        WeiboParameters weiboParameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(str)) {
            weiboParameters.put("access_token", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboParameters.put("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_ID, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            weiboParameters.put("uid", str4);
        }
        weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, new Timestamp(new Date().getTime()));
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_USER_GAIN, "GET", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String readPlayerFriendsScoreInfo(Context context, String str, String str2, String str3, String str4) {
        WeiboParameters weiboParameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(str)) {
            weiboParameters.put("access_token", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboParameters.put("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_ID, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            weiboParameters.put("uid", str4);
        }
        weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, new Timestamp(new Date().getTime()));
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_READ_PLAYER_FRIENDS, "GET", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String readPlayerScoreInfo(Context context, String str, String str2, String str3, String str4) {
        WeiboParameters weiboParameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(str)) {
            weiboParameters.put("access_token", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboParameters.put("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_ID, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            weiboParameters.put("uid", str4);
        }
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_READ_PLAYER_SCORE, "GET", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0241 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.apache.http.HttpResponse requestHttpExecute(android.content.Context r5, java.lang.String r6, java.lang.String r7, com.sina.weibo.sdk.net.WeiboParameters r8) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.component.GameManager.requestHttpExecute(android.content.Context, java.lang.String, java.lang.String, com.sina.weibo.sdk.net.WeiboParameters):org.apache.http.HttpResponse");
    }

    public void invatationWeiboFriendsByList(Context context, String str, String str2, String str3, WeiboAuthListener weiboAuthListener) {
        WeiboParameters weiboParameters = new WeiboParameters(str2);
        weiboParameters.put("access_token", str);
        weiboParameters.put("source", str2);
        String str4 = String.valueOf(INVITATION_URL.toString()) + weiboParameters.encodeUrl();
        GameRequestParam gameRequestParam = new GameRequestParam(context);
        gameRequestParam.setAppKey(str2);
        gameRequestParam.setToken(str);
        gameRequestParam.setLauncher(BrowserLauncher.GAME);
        gameRequestParam.setUrl(str4);
        gameRequestParam.setAuthListener(weiboAuthListener);
        Intent intent = new Intent(context, WeiboSdkBrowser.class);
        Bundle createRequestParamBundle = gameRequestParam.createRequestParamBundle();
        createRequestParamBundle.putString("key_specify_title", str3);
        intent.putExtras(createRequestParamBundle);
        context.startActivity(intent);
    }

    public void invatationWeiboFriendsInOnePage(Context context, String str, String str2, String str3, WeiboAuthListener weiboAuthListener, ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                String str4 = arrayList.get(i2);
                if (i2 == 0) {
                    stringBuffer.append(str4);
                } else {
                    stringBuffer.append("," + str4);
                }
                i = i2 + 1;
            }
        }
        WeiboParameters weiboParameters = new WeiboParameters(str2);
        weiboParameters.put("access_token", str);
        weiboParameters.put("source", str2);
        String str5 = String.valueOf(INVITATION_ONE_FRINED_URL.toString()) + weiboParameters.encodeUrl() + "&uids=" + stringBuffer.toString();
        GameRequestParam gameRequestParam = new GameRequestParam(context);
        gameRequestParam.setAppKey(str2);
        gameRequestParam.setToken(str);
        gameRequestParam.setLauncher(BrowserLauncher.GAME);
        gameRequestParam.setUrl(str5);
        gameRequestParam.setAuthListener(weiboAuthListener);
        Intent intent = new Intent(context, WeiboSdkBrowser.class);
        Bundle createRequestParamBundle = gameRequestParam.createRequestParamBundle();
        createRequestParamBundle.putString("key_specify_title", str3);
        intent.putExtras(createRequestParamBundle);
        context.startActivity(intent);
    }
}
