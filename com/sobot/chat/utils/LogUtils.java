package com.sobot.chat.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.apiUtils.SobotApp;
import com.sobot.chat.core.channel.Const;
import com.sobot.chat.core.channel.SobotMsgManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/LogUtils.class */
public class LogUtils {
    public static final String LOGTYPE_ERROE = "1";
    public static final String LOGTYPE_EXCEPTION = "2";
    public static final String LOGTYPE_INFO = "3";
    public static final String LOGTYPE_INIT = "5";
    public static final String LOGTYPE_START = "4";
    private static final int MAX_LENGTH = 3072;
    public static boolean allowD = false;
    public static boolean allowE = false;
    public static boolean allowI = false;
    public static boolean allowV = false;
    public static boolean allowW = false;
    public static boolean allowWtf = false;
    private static File file;
    public static boolean isCache = true;
    public static boolean isDebug = false;
    private static String mAppName = "sobot_chat";
    public static int maxTime = 3;
    public static String path;

    private LogUtils() {
    }

    public static void clearAllLog() {
        synchronized (LogUtils.class) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= listFiles.length) {
                            break;
                        }
                        if (listFiles[i2].isFile()) {
                            listFiles[i2].delete();
                        }
                        i = i2 + 1;
                    }
                }
            } catch (Exception e) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void clearLog() {
        Context applicationContext = SobotApp.getApplicationContext();
        String stringData = SharedPreferencesUtil.getStringData(applicationContext, ZhiChiConstant.SOBOT_CONFIG_APPKEY, null);
        if (maxTime >= 0 && FileSizeUtil.getFileOrFilesSize(path, 3) > 2.0d && stringData != null) {
            SobotMsgManager.getInstance(applicationContext).getZhiChiApi().logCollect(applicationContext, stringData, false);
        }
    }

    public static void d(String str) {
        if (isDebug && allowD) {
            Log.d(generateTag(), str);
        }
    }

    public static void d(String str, Throwable th) {
        if (isDebug && allowD) {
            Log.d(generateTag(), str, th);
        }
    }

    public static void e(String str) {
        if (isDebug && allowE) {
            Log.e(generateTag(), str);
        }
    }

    public static void e(String str, Throwable th) {
        if (isDebug && allowE) {
            Log.e(generateTag(), str, th);
        }
    }

    private static String generateTag() {
        return "sobot_log";
    }

    private static String getCurrentTime(String str) {
        return new SimpleDateFormat(str).format(new Date());
    }

    public static String getFileContent() {
        synchronized (LogUtils.class) {
            try {
                File file2 = new File(path);
                if (file2.exists()) {
                    String str = "";
                    String str2 = str;
                    if (!file2.isDirectory()) {
                        str2 = str;
                        if (file2.getName().endsWith("txt")) {
                            str2 = str;
                            String str3 = str;
                            try {
                                FileInputStream fileInputStream = new FileInputStream(file2);
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                                while (true) {
                                    String str4 = str;
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    String str5 = str;
                                    sb.append(str);
                                    String str6 = str;
                                    sb.append(readLine);
                                    String str7 = str;
                                    sb.append("\n");
                                    String str8 = str;
                                    str = sb.toString();
                                }
                                str2 = str;
                                str3 = str;
                                fileInputStream.close();
                                str2 = str;
                            } catch (FileNotFoundException e) {
                                Log.d("TestFile", "The File doesn't not exist.");
                                str2 = str3;
                            } catch (IOException e2) {
                                Log.d("TestFile", e2.getMessage());
                            }
                        }
                    }
                    return str2;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String getLogContent() {
        BufferedReader bufferedReader;
        Exception e;
        synchronized (LogUtils.class) {
            try {
                File file2 = new File(path);
                BufferedReader bufferedReader2 = null;
                if (file2.exists()) {
                    JSONArray jSONArray = new JSONArray();
                    try {
                        try {
                            bufferedReader = new BufferedReader(new FileReader(file2));
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        try {
                                            break;
                                        } catch (IOException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            return jSONArray.toString();
                                        }
                                    }
                                    jSONArray.put(new JSONObject(readLine));
                                } catch (Exception e3) {
                                    e = e3;
                                    bufferedReader2 = bufferedReader;
                                    e.printStackTrace();
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e4) {
                                            e = e4;
                                            e.printStackTrace();
                                            return jSONArray.toString();
                                        }
                                    }
                                    return jSONArray.toString();
                                } catch (Throwable th) {
                                    bufferedReader2 = bufferedReader;
                                    th = th;
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e6) {
                        bufferedReader = null;
                        e = e6;
                    }
                    return jSONArray.toString();
                }
                return null;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static File getLogFile() {
        return file;
    }

    public static String getLogFileByDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file2 = file;
        File file3 = new File(file2, mAppName + BridgeUtil.UNDERLINE_STR + str + "_log.txt");
        if (file3.exists()) {
            return file3.getAbsolutePath();
        }
        return null;
    }

    public static String getLogFilePath() {
        return path;
    }

    public static void i(String str) {
        if (isDebug && allowI) {
            String generateTag = generateTag();
            if (str.length() <= MAX_LENGTH) {
                Log.i(generateTag, str);
                return;
            }
            String substring = str.substring(0, MAX_LENGTH);
            Log.i(generateTag + "分段打印开始", substring);
            String substring2 = str.substring(MAX_LENGTH, str.length());
            if (str.length() - MAX_LENGTH > MAX_LENGTH) {
                i(substring2);
                return;
            }
            Log.i(generateTag + "分段打印结束", substring2);
        }
    }

    public static void i(String str, Throwable th) {
        if (isDebug && allowI) {
            Log.i(generateTag(), str, th);
        }
    }

    public static void i2Local(Context context, Map<String, String> map) {
        synchronized (LogUtils.class) {
            try {
                String currentTime = getCurrentTime("yyyy-MM-dd HH:mm:ss");
                if (context != null) {
                    String stringData = SharedPreferencesUtil.getStringData(SobotApp.getApplicationContext(), Const.SOBOT_APPKEY, null);
                    if (!TextUtils.isEmpty(stringData)) {
                        map.put("appkey", stringData);
                    }
                }
                map.put("type", "3");
                map.put("time", currentTime);
                save2Local(null, null, GsonUtil.map2Json(map), null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void i2Local(Context context, Map<String, String> map, String str) {
        synchronized (LogUtils.class) {
            try {
                String currentTime = getCurrentTime("yyyy-MM-dd HH:mm:ss");
                if (map == null) {
                    return;
                }
                if (context != null) {
                    String stringData = SharedPreferencesUtil.getStringData(context, Const.SOBOT_APPKEY, null);
                    if (!TextUtils.isEmpty(stringData)) {
                        map.put("appkey", stringData);
                    }
                }
                map.put("type", str);
                map.put("time", currentTime);
                save2Local(null, null, GsonUtil.map2Json(map), null);
            } finally {
            }
        }
    }

    public static void i2Local(String str, String str2) {
        synchronized (LogUtils.class) {
            try {
                String currentTime = getCurrentTime("yyyy-MM-dd HH:mm:ss");
                HashMap hashMap = new HashMap();
                hashMap.put("time", currentTime);
                hashMap.put("logtype", str);
                hashMap.put("logContent", str2);
                save2Local(null, null, GsonUtil.map2Json(hashMap), null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void i2Local(Map<String, String> map, String str) {
        synchronized (LogUtils.class) {
            try {
                i2Local(null, map, str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void init(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            mAppName = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (isCache) {
            setSaveDir(CommonUtils.getSDCardRootPath(context));
        }
    }

    public static void printLogPath() {
        Log.i(generateTag(), file.getPath());
    }

    public static void save2Local(String str, String str2, String str3, Throwable th) {
        PrintWriter printWriter;
        Throwable th2;
        PrintWriter printWriter2;
        String str4;
        if (TextUtils.isEmpty(path)) {
            return;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            printWriter2 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path, true), "utf-8"));
            str4 = str3;
        } catch (Exception e) {
            printWriter2 = null;
        } catch (Throwable th3) {
            printWriter = null;
            th2 = th3;
        }
        try {
            if (TextUtils.isEmpty(str3)) {
                str4 = "";
            }
            printWriter2.println(str4);
            printWriter2.flush();
            if (th != null) {
                th.printStackTrace(printWriter2);
            }
            printWriter2.flush();
            printWriter2.close();
        } catch (Exception e2) {
            if (printWriter2 != null) {
                printWriter2.close();
            }
            clearLog();
        } catch (Throwable th4) {
            th2 = th4;
            printWriter = printWriter2;
            if (printWriter != null) {
                printWriter.close();
            }
            throw th2;
        }
        clearLog();
    }

    public static void setCacheTime(int i) {
        if (i < 0) {
            return;
        }
        maxTime = i;
    }

    public static void setIsCache(boolean z) {
        isCache = z;
    }

    public static void setIsDebug(boolean z) {
        isDebug = z;
    }

    public static void setSaveDir(String str) {
        String str2 = str + File.separator + mAppName + File.separator + "sobot";
        path = str2 + File.separator + "sobot_log.txt";
        file = new File(str2);
    }

    public static void v(String str) {
        if (isDebug && allowV) {
            Log.v(generateTag(), str);
        }
    }

    public static void v(String str, Throwable th) {
        if (isDebug && allowV) {
            Log.v(generateTag(), str, th);
        }
    }

    public static void w(String str) {
        if (isDebug && allowW) {
            Log.w(generateTag(), str);
        }
    }

    public static void w(String str, Throwable th) {
        if (isDebug && allowW) {
            Log.w(generateTag(), str, th);
        }
    }

    public static void w(Throwable th) {
        if (isDebug && allowW) {
            Log.w(generateTag(), th);
        }
    }

    public static void wtf(String str) {
        if (isDebug && allowWtf) {
            Log.wtf(generateTag(), str);
        }
    }

    public static void wtf(String str, Throwable th) {
        if (isDebug && allowWtf) {
            Log.wtf(generateTag(), str, th);
        }
    }

    public static void wtf(Throwable th) {
        if (isDebug && allowWtf) {
            Log.wtf(generateTag(), th);
        }
    }
}
