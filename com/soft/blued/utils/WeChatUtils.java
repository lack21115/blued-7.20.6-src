package com.soft.blued.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.soft.blued.constant.ShareCoreConstants;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/WeChatUtils.class */
public class WeChatUtils {
    public static void a(Context context, String str, String str2) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, ShareCoreConstants.a());
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = str;
        req.path = str2;
        req.miniprogramType = 0;
        createWXAPI.sendReq(req);
    }

    public static boolean a(Context context) {
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            if (installedPackages == null) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= installedPackages.size()) {
                    return false;
                }
                if (installedPackages.get(i2).packageName.equals("com.tencent.mm")) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
