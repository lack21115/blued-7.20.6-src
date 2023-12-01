package com.soft.blued.ui.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.app.share.ShareUtils;
import com.app.share.model.ShareEntity;
import com.blued.android.module.common.utils.BitmapUtils;
import com.soft.blued.ui.group.model.BluedGroupLists;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share/BluedShareUtils.class */
public class BluedShareUtils extends ShareUtils {

    /* renamed from: a  reason: collision with root package name */
    private static BluedShareUtils f33694a;

    public static BluedShareUtils b() {
        if (f33694a == null) {
            f33694a = new BluedShareUtils();
        }
        return f33694a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Activity activity, int i, String str, View view, Bitmap bitmap, String str2, String str3, String str4, String str5, int i2, BluedGroupLists bluedGroupLists) {
        String a2 = bitmap != null ? BitmapUtils.a(bitmap, false) : view != null ? BitmapUtils.a(BitmapUtils.a(view), true) : "";
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.flag = i;
        shareEntity.netImgUrl = str;
        shareEntity.fileUrl = a2;
        shareEntity.linkUrl = str2;
        shareEntity.title = str3;
        shareEntity.content = str4;
        shareEntity.mainBody = str5;
        shareEntity.shareType = i2;
        shareEntity.shareBackLister = null;
        shareEntity.b = -1;
        shareEntity.shareFrom = 2;
        shareEntity.f9215a = bluedGroupLists;
        b(activity, shareEntity);
    }
}
