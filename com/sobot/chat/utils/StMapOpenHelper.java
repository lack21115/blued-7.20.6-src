package com.sobot.chat.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sobot.chat.api.model.SobotLocationModel;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/StMapOpenHelper.class */
public class StMapOpenHelper {
    private static final String MAP_BAIDU = "baidumap://map/marker?location=%1$s,%2$s&title=%3$s&content=%4$s&traffic=on&src=%5$s";
    private static final String MAP_GAODE = "androidamap://viewMap?lat=%1$s&lon=%2$s&poiname=%3$s&sourceApplication=%4$s&dev=0";

    public static void firstOpenBaiduMap(Context context, SobotLocationModel sobotLocationModel) {
        String packageName = context.getPackageName();
        Intent obtainBaiduMap = obtainBaiduMap(packageName, sobotLocationModel);
        Intent obtainGaoDeMap = obtainGaoDeMap(packageName, sobotLocationModel);
        if (obtainBaiduMap == null || !openAct(context, obtainBaiduMap)) {
            if (obtainGaoDeMap == null || !openAct(context, obtainGaoDeMap)) {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_not_open_map"));
            }
        }
    }

    public static void firstOpenGaodeMap(Context context, SobotLocationModel sobotLocationModel) {
        String packageName = context.getPackageName();
        Intent obtainBaiduMap = obtainBaiduMap(packageName, sobotLocationModel);
        Intent obtainGaoDeMap = obtainGaoDeMap(packageName, sobotLocationModel);
        if (obtainGaoDeMap == null || !openAct(context, obtainGaoDeMap)) {
            if (obtainBaiduMap == null || !openAct(context, obtainBaiduMap)) {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_not_open_map"));
            }
        }
    }

    public static Intent obtainBaiduMap(String str, SobotLocationModel sobotLocationModel) {
        if (sobotLocationModel != null) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(String.format(MAP_BAIDU, sobotLocationModel.getLat(), sobotLocationModel.getLng(), sobotLocationModel.getLocalName(), sobotLocationModel.getLocalLabel(), str)));
                return intent;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static Intent obtainGaoDeMap(String str, SobotLocationModel sobotLocationModel) {
        if (sobotLocationModel != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setData(Uri.parse(String.format(MAP_GAODE, sobotLocationModel.getLat(), sobotLocationModel.getLng(), sobotLocationModel.getLocalName(), str)));
                intent.setPackage("com.autonavi.minimap");
                return intent;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static boolean openAct(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void openMap(Context context, SobotLocationModel sobotLocationModel) {
        String packageName = context.getPackageName();
        Intent obtainBaiduMap = obtainBaiduMap(packageName, sobotLocationModel);
        if (obtainBaiduMap == null || !openAct(context, obtainBaiduMap)) {
            Intent obtainGaoDeMap = obtainGaoDeMap(packageName, sobotLocationModel);
            if (obtainGaoDeMap == null || !openAct(context, obtainGaoDeMap)) {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_not_open_map"));
            }
        }
    }
}
