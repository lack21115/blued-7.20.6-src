package com.zego.ve;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.FileNotFoundException;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/FileMediaDataSource.class */
public class FileMediaDataSource {
    private static final String TAG = "FileMediaDataSource";
    private int uriFd = -1;

    private String getAppDataPath(Context context) {
        return context.getApplicationInfo().dataDir;
    }

    private int initDataSource(Context context, String str, boolean z) throws FileNotFoundException {
        Log.d(TAG, "initDataSource enter, uri: " + str);
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String str2 = z ? "r" : "rw";
        if (!TextUtils.isEmpty(scheme) && !scheme.equalsIgnoreCase("content") && !scheme.equalsIgnoreCase(ContentResolver.SCHEME_FILE)) {
            Log.e(TAG, "Invalid path:  " + str);
            return -2;
        }
        try {
            this.uriFd = context.getContentResolver().openFileDescriptor(parse, str2).detachFd();
            Log.d(TAG, "Open file: " + parse.getPath() + " successful, get fd " + this.uriFd);
            return this.uriFd;
        } catch (FileNotFoundException e) {
            Log.d(TAG, "Open file: " + parse.getPath() + " failed with exception: " + e.getMessage());
            return -1;
        }
    }
}
