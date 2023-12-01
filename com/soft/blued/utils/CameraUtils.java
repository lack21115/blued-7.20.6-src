package com.soft.blued.utils;

import android.content.Intent;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.utils.PermissionUtils;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/CameraUtils.class */
public class CameraUtils {
    public static String a(final Fragment fragment) {
        final String e = RecyclingUtils.e("photo");
        PermissionUtils.b(new PermissionCallbacks() { // from class: com.soft.blued.utils.CameraUtils.1
            public void U_() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, FileUtils.b(e));
                intent.addFlags(2);
                intent.addFlags(1);
                if (AppMethods.a(intent)) {
                    fragment.startActivityForResult(intent, 0);
                } else {
                    AppMethods.d((int) R.string.error_photo_not_support);
                }
            }

            public void a(String[] strArr) {
            }
        });
        return e;
    }
}
