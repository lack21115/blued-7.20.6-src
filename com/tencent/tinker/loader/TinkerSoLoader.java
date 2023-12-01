package com.tencent.tinker.loader;

import android.content.Intent;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerSoLoader.class */
public class TinkerSoLoader {
    protected static final String SO_MEAT_FILE = "assets/so_meta.txt";
    protected static final String SO_PATH = "lib";
    private static final String TAG = "Tinker.TinkerSoLoader";

    public static boolean checkComplete(String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = shareSecurityCheck.getMetaContentMap().get("assets/so_meta.txt");
        if (str2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        ShareBsDiffPatchInfo.parseDiffPatchInfo(str2, arrayList);
        if (arrayList.isEmpty()) {
            return true;
        }
        String str3 = str + "/lib/";
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
            if (!ShareBsDiffPatchInfo.checkDiffPatchInfo(shareBsDiffPatchInfo)) {
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, -4);
                ShareIntentUtil.setIntentReturnCode(intent, -8);
                return false;
            }
            hashMap.put(shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.md5);
        }
        File file = new File(str3);
        if (!file.exists() || !file.isDirectory()) {
            ShareIntentUtil.setIntentReturnCode(intent, -17);
            return false;
        }
        for (String str4 : hashMap.keySet()) {
            File file2 = new File(str3 + str4);
            if (!SharePatchFileUtil.isLegalFile(file2)) {
                ShareIntentUtil.setIntentReturnCode(intent, -18);
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_MISSING_LIB_PATH, file2.getAbsolutePath());
                return false;
            }
        }
        intent.putExtra(ShareIntentUtil.INTENT_PATCH_LIBS_PATH, hashMap);
        return true;
    }
}
