package com.sobot.chat.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/FileOpenHelper.class */
public class FileOpenHelper {
    public static boolean checkEndsWithInStringArray(String str, Context context, String str2) {
        try {
            String[] stringArray = context.getResources().getStringArray(ResourceUtils.getIdByName(context, "array", str2));
            int length = stringArray.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (str.endsWith(stringArray[i2])) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static Intent getAudioFileIntent(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        intent.setDataAndType(getUri(context, file, intent), "audio/*");
        return intent;
    }

    public static Intent getExcelFileIntent(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(268435456);
        intent.setDataAndType(getUri(context, file, intent), "application/vnd.ms-excel");
        return intent;
    }

    public static Intent getImageFileIntent(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(268435456);
        intent.setDataAndType(getUri(context, file, intent), "image/*");
        return intent;
    }

    public static Intent getOtherFileIntent(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(getUri(context, file, intent), "application");
        return intent;
    }

    public static Intent getPackageFileIntent(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(getUri(context, file, intent), AdBaseConstants.MIME_APK);
        return intent;
    }

    public static Intent getPdfFileIntent(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(268435456);
        intent.setDataAndType(getUri(context, file, intent), "application/pdf");
        return intent;
    }

    public static Intent getPptFileIntent(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(268435456);
        intent.setDataAndType(getUri(context, file, intent), "application/vnd.ms-powerpoint");
        return intent;
    }

    public static Intent getTextFileIntent(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(268435456);
        intent.setDataAndType(getUri(context, file, intent), "text/plain");
        return intent;
    }

    public static Uri getUri(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".sobot_fileprovider", file);
        }
        return Uri.fromFile(file);
    }

    private static Uri getUri(Context context, File file, Intent intent) {
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            return FileProvider.getUriForFile(context, context.getPackageName() + ".sobot_fileprovider", file);
        }
        return Uri.fromFile(file);
    }

    public static Uri getUri(Context context, String str) {
        return getUri(context, new File(str));
    }

    public static Intent getVideoFileIntent(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        intent.setDataAndType(getUri(context, file, intent), "video/*");
        return intent;
    }

    public static Intent getWordFileIntent(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(268435456);
        intent.setDataAndType(getUri(context, file, intent), "application/msword");
        return intent;
    }

    public static void openFileWithType(Context context, File file) {
        if (context != null && file != null && file.exists() && file.isFile()) {
            String lowerCase = file.getName().toLowerCase();
            try {
                context.startActivity(checkEndsWithInStringArray(lowerCase, context, "sobot_fileEndingPackage") ? getOtherFileIntent(context, file) : checkEndsWithInStringArray(lowerCase, context, "sobot_fileEndingVideo") ? getVideoFileIntent(context, file) : checkEndsWithInStringArray(lowerCase, context, "sobot_fileEndingAudio") ? getAudioFileIntent(context, file) : checkEndsWithInStringArray(lowerCase, context, "sobot_fileEndingWord") ? getWordFileIntent(context, file) : checkEndsWithInStringArray(lowerCase, context, "sobot_fileEndingExcel") ? getExcelFileIntent(context, file) : checkEndsWithInStringArray(lowerCase, context, "sobot_fileEndingPPT") ? getPptFileIntent(context, file) : checkEndsWithInStringArray(lowerCase, context, "sobot_fileEndingPdf") ? getPdfFileIntent(context, file) : checkEndsWithInStringArray(lowerCase, context, "sobot_fileEndingText") ? getTextFileIntent(context, file) : checkEndsWithInStringArray(lowerCase, context, "sobot_fileEndingImage") ? getImageFileIntent(context, file) : getOtherFileIntent(context, file));
            } catch (Exception e) {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_cannot_open_file"));
            }
        }
    }
}
