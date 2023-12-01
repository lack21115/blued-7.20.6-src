package com.sobot.chat.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.anythink.expressad.foundation.h.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ResourceUtils.class */
public class ResourceUtils {
    public static String getColorById(Context context, String str) {
        if (context == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int color = context.getResources().getColor(getResColorId(context, str));
        stringBuffer.append("#");
        stringBuffer.append(Integer.toHexString(Color.alpha(color)));
        stringBuffer.append(Integer.toHexString(Color.red(color)));
        stringBuffer.append(Integer.toHexString(Color.green(color)));
        stringBuffer.append(Integer.toHexString(Color.blue(color)));
        return stringBuffer.toString();
    }

    public static int getDrawableId(Context context, String str) {
        return getIdByName(context, i.f7952c, str);
    }

    public static int getIdByName(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext.getResources().getIdentifier(str2, str, applicationContext.getPackageName());
    }

    public static int getResColorId(Context context, String str) {
        return getIdByName(context, "color", str);
    }

    public static int getResColorValue(Context context, String str) {
        return ContextCompat.getColor(context, getResColorId(context, str));
    }

    public static int getResDimenId(Context context, String str) {
        return context.getResources().getDimensionPixelSize(getIdByName(context, "dimen", str));
    }

    public static int getResId(Context context, String str) {
        return getIdByName(context, "id", str);
    }

    public static int getResLayoutId(Context context, String str) {
        return getIdByName(context, "layout", str);
    }

    public static int getResStrId(Context context, String str) {
        return getIdByName(context, "string", str);
    }

    public static String getResString(Context context, String str) {
        if (SharedPreferencesUtil.getBooleanData(context, "sobot_use_language", false)) {
            String stringData = SharedPreferencesUtil.getStringData(context, ZhiChiConstant.SOBOT_LANGUAGE_STRING_PATH, "");
            if (!TextUtils.isEmpty(stringData) && new File(stringData).exists()) {
                try {
                    JSONObject jSONObject = new JSONObject(readExternal(stringData));
                    if (jSONObject.has(str)) {
                        return jSONObject.optString(str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return context.getResources().getString(getResStrId(context, str));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x007c -> B:38:0x0095). Please submit an issue!!! */
    public static String readExternal(String str) throws IOException {
        FileInputStream fileInputStream;
        StringBuffer stringBuffer = new StringBuffer();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            InputStreamReader inputStreamReader = null;
            try {
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        inputStreamReader = fileInputStream;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return stringBuffer.toString();
                    } catch (Throwable th) {
                        inputStreamReader = fileInputStream;
                        th = th;
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return stringBuffer.toString();
    }
}
