package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerResourceLoader.class */
public class TinkerResourceLoader {
    protected static final String RESOURCE_FILE = "resources.apk";
    protected static final String RESOURCE_META_FILE = "assets/res_meta.txt";
    protected static final String RESOURCE_PATH = "res";
    private static final String TAG = "Tinker.ResourceLoader";
    private static ShareResPatchInfo resPatchInfo = new ShareResPatchInfo();

    private TinkerResourceLoader() {
    }

    public static boolean checkComplete(Context context, String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = shareSecurityCheck.getMetaContentMap().get("assets/res_meta.txt");
        if (str2 == null) {
            return true;
        }
        ShareResPatchInfo.parseResPatchInfoFirstLine(str2, resPatchInfo);
        if (resPatchInfo.resArscMd5 == null) {
            return true;
        }
        if (!ShareResPatchInfo.checkResPatchInfo(resPatchInfo)) {
            intent.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, -8);
            ShareIntentUtil.setIntentReturnCode(intent, -8);
            return false;
        }
        String str3 = str + BridgeUtil.SPLIT_MARK + "res" + BridgeUtil.SPLIT_MARK;
        File file = new File(str3);
        if (!file.exists() || !file.isDirectory()) {
            ShareIntentUtil.setIntentReturnCode(intent, -21);
            return false;
        }
        if (!SharePatchFileUtil.isLegalFile(new File(str3 + "resources.apk"))) {
            ShareIntentUtil.setIntentReturnCode(intent, -22);
            return false;
        }
        try {
            TinkerResourcePatcher.isResourceCanPatch(context);
            return true;
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "resource hook check failed.", th);
            intent.putExtra(ShareIntentUtil.INTENT_PATCH_EXCEPTION, th);
            ShareIntentUtil.setIntentReturnCode(intent, -23);
            return false;
        }
    }

    public static boolean loadTinkerResources(TinkerApplication tinkerApplication, String str, Intent intent) {
        ShareResPatchInfo shareResPatchInfo = resPatchInfo;
        if (shareResPatchInfo == null || shareResPatchInfo.resArscMd5 == null) {
            return true;
        }
        String str2 = str + BridgeUtil.SPLIT_MARK + "res" + BridgeUtil.SPLIT_MARK + "resources.apk";
        File file = new File(str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (tinkerApplication.isTinkerLoadVerifyFlag()) {
            if (!SharePatchFileUtil.checkResourceArscMd5(file, resPatchInfo.resArscMd5)) {
                ShareTinkerLog.e(TAG, "Failed to load resource file, path: " + file.getPath() + ", expect md5: " + resPatchInfo.resArscMd5, new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -24);
                return false;
            }
            ShareTinkerLog.i(TAG, "verify resource file:" + file.getPath() + " md5, use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }
        try {
            TinkerResourcePatcher.monkeyPatchExistingResources(tinkerApplication, str2);
            ShareTinkerLog.i(TAG, "monkeyPatchExistingResources resource file:" + str2 + ", use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return true;
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "install resources failed", new Object[0]);
            try {
                SystemClassLoaderAdder.uninstallPatchDex(tinkerApplication.getClassLoader());
            } catch (Throwable th2) {
                ShareTinkerLog.e(TAG, "uninstallPatchDex failed", th);
            }
            intent.putExtra(ShareIntentUtil.INTENT_PATCH_EXCEPTION, th);
            ShareIntentUtil.setIntentReturnCode(intent, -23);
            return false;
        }
    }
}
