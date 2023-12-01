package com.baidu.aip.face.stat;

import android.content.Context;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.expressad.foundation.d.l;
import com.baidu.aip.face.stat.NetUtil;
import com.baidu.idl.facesdk.FaceInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.umeng.analytics.pro.bh;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/stat/Ast.class */
public class Ast {
    private static final String AS_FILE_NAME = "ast";
    private static final String FACE_HIT_KEY_LASSTTIME = "FACE_HIT_KEY_LASSTTIME";
    private static final long SAVE_INTERVAL = 15000;
    private static final long UPADTE_DEFUALT_DELAY_TIME = 15000;
    private static final String UPLOAD_LASSTTIME = "UPLOAD_LASSTTIME";
    private static Ast instance;
    private File asFile;
    private Context context;
    private Dev dev;
    private boolean isInit;
    private long lastSavetime;
    private Properties properties;
    private String scene;
    private String faceHitKey = "";
    private SparseArray<Integer> faceIds = new SparseArray<>();
    ExecutorService es = Executors.newSingleThreadExecutor();
    Future future = null;

    private Ast() {
    }

    private void clear() {
        this.properties.clear();
    }

    private String generateFaceHitKey(String str) {
        return new SimpleDateFormat("yyyy_MM_dd_HH").format(new Date()) + BridgeUtil.UNDERLINE_STR + str;
    }

    public static Ast getInstance() {
        if (instance == null) {
            synchronized (Ast.class) {
                try {
                    instance = new Ast();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private boolean initFile() {
        this.asFile = new File(this.context.getFilesDir(), AS_FILE_NAME);
        this.properties = new Properties();
        if (FileUtil.createFile(this.asFile)) {
            return FileUtil.loadPropertiesFile(this.asFile, this.properties);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netRequest() {
        if (this.properties.size() == 0) {
            return;
        }
        NetUtil.uploadData(new NetUtil.RequestAdapter<Object>() { // from class: com.baidu.aip.face.stat.Ast.2
            @Override // com.baidu.aip.face.stat.NetUtil.RequestAdapter
            public String getRequestString() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("mh", "faceSdkStatistic");
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<Object, Object> entry : ((Properties) Ast.this.properties.clone()).entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        if (!str.equalsIgnoreCase(Ast.FACE_HIT_KEY_LASSTTIME) && !str.equalsIgnoreCase(Ast.UPLOAD_LASSTTIME)) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("type", "facesdk");
                            jSONObject2.put("scene", Ast.this.scene);
                            jSONObject2.put("appid", Ast.this.dev.getPackagename());
                            jSONObject2.put("device", Ast.this.dev.getBrand());
                            jSONObject2.put("imei", Ast.this.dev.getUniqueID());
                            jSONObject2.put(bh.x, "Android");
                            jSONObject2.put("system", Ast.this.dev.getSysVersion());
                            jSONObject2.put("version", Ast.this.dev.getSdkVersion());
                            if (str.contains("liveness")) {
                                jSONObject2.put("isliving", "true");
                            } else {
                                jSONObject2.put("isliving", "false");
                            }
                            jSONObject2.put("finish", "1");
                            String[] split = str.split(BridgeUtil.UNDERLINE_STR);
                            if (split.length > 4) {
                                jSONObject2.put(MediaStore.Audio.AudioColumns.YEAR, split[0]);
                                jSONObject2.put("month", split[1]);
                                jSONObject2.put("day", split[2]);
                                jSONObject2.put("hour", split[3]);
                            }
                            jSONObject2.put(l.d, str2);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("dt", jSONArray);
                    return jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    return "";
                }
            }

            @Override // com.baidu.aip.face.stat.NetUtil.RequestAdapter
            public String getURL() {
                return "http://brain.baidu.com/record/api";
            }

            @Override // com.baidu.aip.face.stat.NetUtil.RequestAdapter
            public void parseResponse(InputStream inputStream) throws IOException, JSONException {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        throw th;
                    }
                }
                byteArrayOutputStream.flush();
                if (new JSONObject(new String(byteArrayOutputStream.toByteArray(), "UTF-8")).optInt("code") == 0) {
                    Ast.this.properties.clear();
                    Ast.this.dev.setFirstRun(false);
                    FileUtil.savePropertiesFile(Ast.this.asFile, Ast.this.properties);
                    Ast.this.properties.setProperty(Ast.UPLOAD_LASSTTIME, String.valueOf(System.currentTimeMillis()));
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void sendData() {
        Future future = this.future;
        if (future == null || future.isDone()) {
            this.future = this.es.submit(new Runnable() { // from class: com.baidu.aip.face.stat.Ast.1
                @Override // java.lang.Runnable
                public void run() {
                    Ast.this.netRequest();
                }
            });
        }
    }

    public void faceHit() {
        faceHit("liveness", 15000L, 1);
    }

    public void faceHit(String str) {
        faceHit(str, 15000L, 1);
    }

    public void faceHit(String str, int i) {
        faceHit(str, 15000L, i);
    }

    public void faceHit(String str, int i, FaceInfo[] faceInfoArr) {
        int i2;
        if (faceInfoArr == null) {
            this.faceIds.clear();
            return;
        }
        int length = faceInfoArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = i4;
            if (i3 >= length) {
                break;
            }
            FaceInfo faceInfo = faceInfoArr[i3];
            int i5 = i2;
            if (this.faceIds.get(faceInfo.face_id) == null) {
                this.faceIds.put(faceInfo.face_id, Integer.valueOf(faceInfo.face_id));
                i5 = i2 + 1;
            }
            i3++;
            i4 = i5;
        }
        if (i2 == 0) {
            return;
        }
        faceHit(str, i, i2);
    }

    public void faceHit(String str, long j, int i) {
        long j2;
        long j3;
        String generateFaceHitKey = generateFaceHitKey(str);
        String property = this.properties.getProperty(generateFaceHitKey);
        if (TextUtils.isEmpty(property)) {
            this.properties.setProperty(generateFaceHitKey, String.valueOf(i));
            this.properties.setProperty(FACE_HIT_KEY_LASSTTIME, String.valueOf(System.currentTimeMillis()));
        } else {
            this.properties.setProperty(generateFaceHitKey, String.valueOf(Integer.parseInt(property) + i));
        }
        try {
            j2 = Long.parseLong(this.properties.getProperty(FACE_HIT_KEY_LASSTTIME));
        } catch (Exception e) {
            e.printStackTrace();
            j2 = 0;
        }
        if (System.currentTimeMillis() - j2 > 15000) {
            System.currentTimeMillis();
            FileUtil.savePropertiesFile(this.asFile, this.properties);
            this.properties.setProperty(FACE_HIT_KEY_LASSTTIME, String.valueOf(System.currentTimeMillis()));
        }
        try {
            j3 = Long.parseLong(this.properties.getProperty(UPLOAD_LASSTTIME));
        } catch (Exception e2) {
            e2.printStackTrace();
            j3 = 0;
        }
        if (this.dev.getFirstRun() || System.currentTimeMillis() - j3 >= j) {
            sendData();
        }
    }

    public void immediatelyUpload() {
        sendData();
    }

    public boolean init(Context context, String str, String str2) {
        if (this.isInit || context == null) {
            return true;
        }
        this.context = context.getApplicationContext();
        Dev dev = new Dev();
        this.dev = dev;
        dev.init(context);
        this.dev.setSdkVersion(str);
        this.scene = str2;
        initFile();
        return true;
    }
}
