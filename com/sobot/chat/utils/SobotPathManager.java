package com.sobot.chat.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.sobot.chat.api.apiUtils.SobotApp;
import com.sobot.chat.application.MyApplication;
import java.io.File;
import java.security.MessageDigest;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/SobotPathManager.class */
public class SobotPathManager {
    private static final String CACHE_DIR = "cache";
    private static final String PIC_DIR = "pic";
    private static final String ROOT_DIR = "download";
    private static final String VIDEO_DIR = "video";
    private static final String VOICE_DIR = "voice";
    private static SobotPathManager instance;
    private static String mRootPath;
    private Context mContext;

    private SobotPathManager(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = MyApplication.getInstance().getLastActivity();
        }
    }

    private String encode(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String hexString = Integer.toHexString(digest[i2] & 255);
                if (hexString.length() < 2) {
                    sb.append("0");
                }
                sb.append(hexString);
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static SobotPathManager getInstance() {
        if (instance == null) {
            synchronized (SobotPathManager.class) {
                try {
                    if (instance == null) {
                        instance = new SobotPathManager(SobotApp.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public String getCacheDir() {
        if (Build.VERSION.SDK_INT < 19) {
            return getRootDir() + File.separator + CACHE_DIR + File.separator;
        }
        return this.mContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath() + File.separator + CACHE_DIR + File.separator;
    }

    public String getPicDir() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getPath() + File.separator;
        }
        return getRootDir() + File.separator + PIC_DIR + File.separator;
    }

    public String getRootDir() {
        if (mRootPath == null) {
            Context context = this.mContext;
            String packageName = context != null ? context.getPackageName() : "";
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getPath());
            sb.append(File.separator);
            sb.append("download");
            sb.append(File.separator);
            sb.append(encode(packageName + "cache_sobot"));
            mRootPath = sb.toString();
        }
        return mRootPath;
    }

    public String getVideoDir() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.mContext.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath() + File.separator;
        }
        return getRootDir() + File.separator + "video" + File.separator;
    }

    public String getVoiceDir() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.mContext.getExternalFilesDir(Environment.DIRECTORY_MUSIC).getPath() + File.separator;
        }
        return getRootDir() + File.separator + "voice" + File.separator;
    }
}
