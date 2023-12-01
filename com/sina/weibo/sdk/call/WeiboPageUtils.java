package com.sina.weibo.sdk.call;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/call/WeiboPageUtils.class */
public final class WeiboPageUtils {
    private WeiboPageUtils() {
    }

    public static void displayInWeiboMap(Context context, Position position, String str) throws WeiboNotInstalledException {
        String str2;
        String str3;
        String str4;
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (position != null) {
            String strLongitude = position.getStrLongitude();
            str3 = position.getStrLatitude();
            str2 = position.getStrOffset();
            str4 = strLongitude;
        } else {
            str2 = "";
            str3 = str2;
            str4 = "";
        }
        openInWeiboBrowser(context, String.format("http://weibo.cn/dpool/ttt/maps.php?xy=%s,%s&amp;size=320x320&amp;offset=%s", str4, str3, str2), "default", str);
    }

    public static void openInWeiboBrowser(Context context, String str, String str2, String str3) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.URL_ERROR);
        }
        if (!TextUtils.isEmpty(str2) && !"topnav".equals(str2) && !"default".equals(str2) && !"fullscreen".equals(str2)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.SINAINTERNALBROWSER);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.BROWSER);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put(WBPageConstants.ParamKey.SINAINTERNALBROWSER, str2);
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str3);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void openQrcodeScanner(Context context, String str) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.QRCODE);
        HashMap hashMap = new HashMap();
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void postNewWeibo(Context context, String str, String str2, String str3, Position position, String str4, String str5) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.SENDWEIBO);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("content", URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        hashMap.put(WBPageConstants.ParamKey.POIID, str2);
        hashMap.put(WBPageConstants.ParamKey.POINAME, str3);
        if (position != null) {
            hashMap.put("longitude", position.getStrLongitude());
            hashMap.put("latitude", position.getStrLatitude());
        }
        hashMap.put(WBPageConstants.ParamKey.PAGEID, str4);
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str5);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewNearPhotoList(Context context, String str, String str2, Integer num, String str3) throws WeiboNotInstalledException {
        viewPagePhotoList(context, "100101" + str + BridgeUtil.UNDERLINE_STR + str2, "nearphoto", "周边热图", num, str3);
    }

    public static void viewNearbyPeople(Context context, Position position, String str) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.NEARBYPEOPLE);
        HashMap hashMap = new HashMap();
        if (position != null) {
            hashMap.put("longitude", position.getStrLongitude());
            hashMap.put("latitude", position.getStrLatitude());
            hashMap.put("offset", position.getStrOffset());
        }
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewNearbyWeibo(Context context, Position position, String str) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.NEARBYWEIBO);
        HashMap hashMap = new HashMap();
        if (position != null) {
            hashMap.put("longitude", position.getStrLongitude());
            hashMap.put("latitude", position.getStrLatitude());
            hashMap.put("offset", position.getStrOffset());
        }
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewPageDetailInfo(Context context, String str, String str2, String str3, String str4) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEDETAILINFO);
        HashMap hashMap = new HashMap();
        hashMap.put(WBPageConstants.ParamKey.PAGEID, str);
        hashMap.put(WBPageConstants.ParamKey.CARDID, str2);
        hashMap.put("title", str3);
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str4);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewPageInfo(Context context, String str, String str2, String str3) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEINFO);
        HashMap hashMap = new HashMap();
        hashMap.put(WBPageConstants.ParamKey.PAGEID, str);
        hashMap.put("title", str2);
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str3);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewPagePhotoList(Context context, String str, String str2, String str3, Integer num, String str4) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        if (num != null && num.intValue() < 0) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.COUNT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEPHOTOLIST);
        HashMap hashMap = new HashMap();
        hashMap.put(WBPageConstants.ParamKey.PAGEID, str);
        hashMap.put(WBPageConstants.ParamKey.CARDID, str2);
        hashMap.put("title", str3);
        hashMap.put(WBPageConstants.ParamKey.PAGE, "1");
        hashMap.put("count", String.valueOf(num));
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str4);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewPageProductList(Context context, String str, String str2, String str3, Integer num, String str4) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        if (num != null && num.intValue() < 0) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.COUNT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEPRODUCTLIST);
        HashMap hashMap = new HashMap();
        hashMap.put(WBPageConstants.ParamKey.PAGEID, str);
        hashMap.put(WBPageConstants.ParamKey.CARDID, str2);
        hashMap.put("title", str3);
        hashMap.put(WBPageConstants.ParamKey.PAGE, "1");
        hashMap.put("count", String.valueOf(num));
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str4);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewPageUserList(Context context, String str, String str2, String str3, Integer num, String str4) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        if (num != null && num.intValue() < 0) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.COUNT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEUSERLIST);
        HashMap hashMap = new HashMap();
        hashMap.put(WBPageConstants.ParamKey.PAGEID, str);
        hashMap.put(WBPageConstants.ParamKey.CARDID, str2);
        hashMap.put("title", str3);
        hashMap.put(WBPageConstants.ParamKey.PAGE, "1");
        hashMap.put("count", String.valueOf(num));
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str4);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewPageWeiboList(Context context, String str, String str2, String str3, Integer num, String str4) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        if (num != null && num.intValue() < 0) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.COUNT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEWEIBOLIST);
        HashMap hashMap = new HashMap();
        hashMap.put(WBPageConstants.ParamKey.PAGEID, str);
        hashMap.put(WBPageConstants.ParamKey.CARDID, str2);
        hashMap.put("title", str3);
        hashMap.put(WBPageConstants.ParamKey.PAGE, "1");
        hashMap.put("count", String.valueOf(num));
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str4);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewPoiPage(Context context, String str, String str2, String str3, String str4) throws WeiboNotInstalledException {
        viewPageInfo(context, "100101" + str + BridgeUtil.UNDERLINE_STR + str2, str3, str4);
    }

    public static void viewPoiPhotoList(Context context, String str, Integer num, String str2) throws WeiboNotInstalledException {
        viewPagePhotoList(context, "100101" + str, "nearphoto", "周边热图", num, str2);
    }

    public static void viewUserInfo(Context context, String str, String str2, String str3) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.UID_NICK_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.USERINFO);
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put(WBPageConstants.ParamKey.NICK, str2);
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str3);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void viewUsertrends(Context context, String str, String str2) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.UID_NICK_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.USERTRENDS);
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str2);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }

    public static void weiboDetail(Context context, String str, String str2) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.MBLOGDETAIL);
        HashMap hashMap = new HashMap();
        hashMap.put(WBPageConstants.ParamKey.MBLOGID, str);
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str2);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString());
    }
}
