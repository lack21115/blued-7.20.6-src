package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.alipay.sdk.util.l;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.anythink.core.api.ATAdConst;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.OutputKeys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.bu  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bu.class */
public final class bu {
    public static long a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getFreeBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    public static long a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles == null) {
            return 0L;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return j;
            }
            File file2 = listFiles[i2];
            j += file2.isDirectory() ? a(file2) : file2.length();
            i = i2 + 1;
        }
    }

    private static OfflineMapProvince a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(a(jSONObject, "url"));
        offlineMapProvince.setProvinceName(a(jSONObject, "name"));
        offlineMapProvince.setJianpin(a(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(a(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(c(a(jSONObject, "adcode")));
        offlineMapProvince.setVersion(a(jSONObject, OutputKeys.VERSION));
        offlineMapProvince.setSize(Long.parseLong(a(jSONObject, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)));
        offlineMapProvince.setCityList(b(jSONObject));
        return offlineMapProvince;
    }

    public static String a(Context context, String str) {
        try {
            return dw.a(dq.a(context).open(str));
        } catch (Throwable th) {
            iw.c(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return "";
        }
        String str2 = "";
        if (jSONObject.has(str)) {
            str2 = "";
            if (!"[]".equals(jSONObject.getString(str))) {
                str2 = jSONObject.optString(str).trim();
            }
        }
        return str2;
    }

    public static List<OfflineMapProvince> a(String str, Context context) throws JSONException {
        return (str == null || "".equals(str)) ? new ArrayList() : a(new JSONObject(str), context);
    }

    public static List<OfflineMapProvince> a(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has(l.c)) {
            optJSONObject = jSONObject.optJSONObject(l.c);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(l.c, new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                c(jSONObject2.toString(), context);
                optJSONObject = jSONObject2.optJSONObject(l.c);
            } catch (JSONException e) {
                optJSONObject = jSONObject.optJSONObject(l.c);
                iw.c(e, "Utility", "parseJson");
                e.printStackTrace();
            }
        }
        if (optJSONObject != null) {
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject3 == null) {
                return arrayList;
            }
            optJSONObject2 = optJSONObject3.optJSONObject("offlinemapinfo_with_province");
        } else {
            optJSONObject2 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        }
        if (optJSONObject2 == null) {
            return arrayList;
        }
        if (optJSONObject2.has(OutputKeys.VERSION)) {
            ax.d = a(optJSONObject2, OutputKeys.VERSION);
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                break;
            }
            JSONObject optJSONObject4 = optJSONArray.optJSONObject(i2);
            if (optJSONObject4 != null) {
                arrayList.add(a(optJSONObject4));
            }
            i = i2 + 1;
        }
        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("others");
        JSONObject jSONObject3 = null;
        if (optJSONArray2 != null) {
            jSONObject3 = null;
            if (optJSONArray2.length() > 0) {
                jSONObject3 = optJSONArray2.getJSONObject(0);
            }
        }
        if (jSONObject3 == null) {
            return arrayList;
        }
        arrayList.add(a(jSONObject3));
        return arrayList;
    }

    public static void a(String str) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.exists() && file2.isDirectory()) {
                String[] list = file2.list();
                if (list == null) {
                    file2.delete();
                } else if (list.length == 0) {
                    file2.delete();
                }
            }
            i = i2 + 1;
        }
    }

    public static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.substring(str.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1, str.indexOf(".zip"));
        } catch (Throwable th) {
            iw.c(th, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }

    private static ArrayList<OfflineMapCity> b(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(c(jSONObject));
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return arrayList;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                arrayList.add(c(optJSONObject));
            }
            i = i2 + 1;
        }
    }

    public static void b(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(dw.c(context)).listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                a(dw.c(context));
                return;
            }
            File file = listFiles[i2];
            if (file.exists() && file.getName().contains(str)) {
                b(file);
            }
            i = i2 + 1;
        }
    }

    public static boolean b(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= listFiles.length) {
                    break;
                }
                if (listFiles[i2].isFile()) {
                    if (!listFiles[i2].delete()) {
                        return false;
                    }
                } else if (!b(listFiles[i2])) {
                    return false;
                }
                i = i2 + 1;
            }
        }
        return file.delete();
    }

    private static OfflineMapCity c(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(c(a(jSONObject, "adcode")));
        offlineMapCity.setUrl(a(jSONObject, "url"));
        offlineMapCity.setCity(a(jSONObject, "name"));
        offlineMapCity.setCode(a(jSONObject, "citycode"));
        offlineMapCity.setPinyin(a(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(a(jSONObject, "jianpin"));
        offlineMapCity.setVersion(a(jSONObject, OutputKeys.VERSION));
        offlineMapCity.setSize(Long.parseLong(a(jSONObject, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)));
        return offlineMapCity;
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0121: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:68:0x0121 */
    public static String c(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream3;
        FileInputStream fileInputStream4;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader4.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (FileNotFoundException e) {
                                e = e;
                                fileInputStream3 = fileInputStream;
                                bufferedReader2 = bufferedReader4;
                                iw.c(e, "MapDownloadManager", "readOfflineSD filenotfound");
                                FileInputStream fileInputStream5 = fileInputStream3;
                                e.printStackTrace();
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (fileInputStream3 != null) {
                                    fileInputStream3.close();
                                    return null;
                                }
                                return null;
                            } catch (IOException e3) {
                                e = e3;
                                fileInputStream2 = fileInputStream;
                                bufferedReader = bufferedReader4;
                                iw.c(e, "MapDownloadManager", "readOfflineSD io");
                                FileInputStream fileInputStream6 = fileInputStream2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                    return null;
                                }
                                return null;
                            }
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        try {
                            bufferedReader4.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                            return stringBuffer2;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return stringBuffer2;
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        fileInputStream3 = fileInputStream;
                        bufferedReader2 = null;
                    } catch (IOException e8) {
                        e = e8;
                        fileInputStream2 = fileInputStream;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    bufferedReader2 = null;
                    fileInputStream3 = null;
                } catch (IOException e12) {
                    e = e12;
                    bufferedReader = null;
                    fileInputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            } catch (Throwable th3) {
                fileInputStream = fileInputStream4;
                th = th3;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
            return null;
        }
    }

    private static String c(String str) {
        String str2 = str;
        if ("000001".equals(str)) {
            str2 = "100000";
        }
        return str2;
    }

    public static void c(String str, Context context) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if ("".equals(dw.c(context))) {
            return;
        }
        File file = new File(dw.c(context) + "offlinemapv4.png");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                iw.c(e, "OfflineUpdateCityHandlerAbstract", "writeSD dirCreate");
                e.printStackTrace();
            }
        }
        if (a() <= 1048576) {
            return;
        }
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                FileOutputStream fileOutputStream4 = new FileOutputStream(file);
                try {
                    fileOutputStream4.write(str.getBytes("utf-8"));
                    try {
                        fileOutputStream4.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (FileNotFoundException e3) {
                    fileOutputStream2 = fileOutputStream4;
                    e = e3;
                    iw.c(e, "OfflineUpdateCityHandlerAbstract", "writeSD filenotfound");
                    FileOutputStream fileOutputStream5 = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (IOException e5) {
                    fileOutputStream = fileOutputStream4;
                    e = e5;
                    iw.c(e, "OfflineUpdateCityHandlerAbstract", "writeSD io");
                    FileOutputStream fileOutputStream6 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream3 = fileOutputStream4;
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
                fileOutputStream2 = null;
            } catch (IOException e9) {
                e = e9;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
