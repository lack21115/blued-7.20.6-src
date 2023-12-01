package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/QosManager.class */
public class QosManager {
    private static boolean n = false;
    private static boolean o = true;

    /* renamed from: a  reason: collision with root package name */
    private Context f13841a;
    private SharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences.Editor f13842c;
    private SharedPreferences d;
    private SharedPreferences.Editor e;
    private SharedPreferences f;
    private SharedPreferences.Editor g;
    private SharedPreferences h;
    private SharedPreferences.Editor i;
    private SharedPreferences j;
    private SharedPreferences.Editor k;
    private SharedPreferences l;
    private SharedPreferences.Editor m;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/QosManager$KeyPoint.class */
    public enum KeyPoint {
        record_camera_capture(1),
        record_microphone_capture(2),
        record_video_camera_setting(3),
        record_audio_microphone_setting(4),
        record_video_encode_setting(5),
        record_audio_encode_setting(6),
        record_duration_setting(7),
        record_switch_camera(8),
        record_flash(9),
        record_exposure(10),
        record_focus(11),
        record_zoom(12),
        record_mirror(13),
        record_horizontal(14),
        record_section(15),
        record_speed(16),
        record_audio_only(17),
        record_image_rotate(18),
        record_audio_mix(19),
        record_capture_frame(20),
        record_mute(21),
        record_video_mix(22),
        record_screen(23),
        record_view(24),
        record_external_media(25),
        record_stop_resume(26),
        record_watermark(27),
        record_beauty(28),
        record_preview(29),
        record_custom_effect(30),
        record_filter(31),
        edit_preview(32),
        edit_image(33),
        edit_watermark(34),
        edit_speed(35),
        edit_text(36),
        edit_mv(37),
        edit_paint(38),
        edit_audio_mix(39),
        edit_multi_audio_mix(40),
        edit_rotate(41),
        edit_filter(42),
        compose_video(43),
        compose_trim_video(44),
        compose_gif(45),
        compose_image(46),
        compose_item(47),
        transcode_clip_video(48),
        transcode_video(49),
        transcode_rotate(50),
        trim_video(51),
        upload_video(52),
        upload_resume(53),
        upload_speed_up(54),
        mix_video(55),
        draftbox(56),
        reverse_video(57),
        transition_make(58),
        filter_init(59),
        editor_init(60),
        record_init(61),
        trim_init(62),
        transcode_init(63),
        upload_init(64),
        h265_video(65);
        
        private int id;

        KeyPoint(int i) {
            this.id = i;
        }

        public int id() {
            return this.id;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/QosManager$a.class */
    public enum a {
        method,
        transcode,
        config
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/QosManager$b.class */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final QosManager f13845a = new QosManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/QosManager$c.class */
    public class c implements Runnable {
        private a b;

        c(a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QosManager.o) {
                int i = 0;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://sdk-dau.cn-shanghai.log.aliyuncs.com/logstores/deal_data/track").openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("x-log-apiversion", "0.6.0");
                    httpURLConnection.setRequestProperty("x-log-bodyrawsize", "1234");
                    PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                    printWriter.write(QosManager.this.a(this.b));
                    printWriter.flush();
                    printWriter.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    i = responseCode;
                    httpURLConnection.disconnect();
                    i = responseCode;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i == 200) {
                    QosManager.this.g();
                    if (this.b != a.method) {
                        QosManager.this.k.clear();
                        QosManager.this.k.apply();
                        QosManager.this.m.putLong("last_report_config", System.currentTimeMillis() / 1000);
                        QosManager.this.m.apply();
                        return;
                    }
                    QosManager.this.e.clear();
                    QosManager.this.e.apply();
                    QosManager.this.g.clear();
                    QosManager.this.g.apply();
                    QosManager.this.i.clear();
                    QosManager.this.i.apply();
                    QosManager.this.m.putLong("last_report_method", System.currentTimeMillis() / 1000);
                    QosManager.this.m.apply();
                }
            }
        }
    }

    private QosManager() {
    }

    public static QosManager a() {
        return b.f13845a;
    }

    public static QosManager a(Context context) {
        QosManager qosManager;
        synchronized (QosManager.class) {
            try {
                b.f13845a.b(context);
                qosManager = b.f13845a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qosManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (aVar == a.method) {
            try {
                JSONObject i = i();
                i.put("error_info", Base64.encodeToString(j().toString().getBytes(), 0));
                i.put("data_type", a.method);
                jSONArray.put(i);
            } catch (Exception e) {
            }
        } else {
            for (Map.Entry<String, ?> entry : this.j.getAll().entrySet()) {
                try {
                    JSONObject a2 = a(entry.getValue().toString());
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                } catch (Exception e2) {
                }
            }
        }
        jSONObject.put("__logs__", jSONArray);
        return jSONObject.toString();
    }

    private JSONObject a(String str) throws JSONException {
        JSONObject h = h();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            h.put(next, jSONObject.getString(next));
        }
        return h;
    }

    private String b(int i) {
        return i == 0 ? "error_io_exception" : i == 1 ? "error_wrong_status" : i == 2 ? "error_empty_sections" : i == 3 ? "error_muxer_stop_failed" : i == 4 ? "error_setup_camera_failed" : i == 5 ? "error_setup_microphone_failed" : i == 6 ? "error_setup_video_encoder_failed" : i == 7 ? "error_setup_audio_encoder_failed" : i == 8 ? "error_unauthorized" : i == 9 ? "error_unsupported_android_version" : i == 10 ? "error_invalid_arg" : i == 11 ? "error_different_audio_params" : i == 12 ? "error_missing_dynamic_library" : i == 13 ? "error_no_video_track" : i == 14 ? "error_src_dst_same_file_path" : i == 15 ? "error_low_memory" : i == 16 ? "error_multi_codec_wrong" : i == 17 ? "error_setup_video_decoder_failed" : i == 18 ? "error_muxer_start_failed" : i == 19 ? "error_video_encoder_exceptional_stop" : i == 20 ? "error_video_decode_failed" : "error_unknown";
    }

    private void e() {
        SharedPreferences sharedPreferences = this.f13841a.getSharedPreferences("ReportData_BaseInfo", 0);
        this.b = sharedPreferences;
        this.f13842c = sharedPreferences.edit();
        SharedPreferences sharedPreferences2 = this.f13841a.getSharedPreferences("ReportData_FunctionPart1", 0);
        this.d = sharedPreferences2;
        this.e = sharedPreferences2.edit();
        SharedPreferences sharedPreferences3 = this.f13841a.getSharedPreferences("ReportData_FunctionPart2", 0);
        this.f = sharedPreferences3;
        this.g = sharedPreferences3.edit();
        SharedPreferences sharedPreferences4 = this.f13841a.getSharedPreferences("ReportData_Error", 0);
        this.h = sharedPreferences4;
        this.i = sharedPreferences4.edit();
        SharedPreferences sharedPreferences5 = this.f13841a.getSharedPreferences("ReportData_Config", 0);
        this.j = sharedPreferences5;
        this.k = sharedPreferences5.edit();
        SharedPreferences sharedPreferences6 = this.f13841a.getSharedPreferences("Other", 0);
        this.l = sharedPreferences6;
        this.m = sharedPreferences6.edit();
        if (com.igexin.push.core.b.l.equals(this.l.getString("uuid", com.igexin.push.core.b.l))) {
            this.m.putString("uuid", UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
            this.m.apply();
        }
    }

    private void f() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
        long j = this.l.getLong("last_report_config", 0L);
        if (j == 0) {
            g();
            this.m.putLong("last_report_method", com.qiniu.pili.droid.shortvideo.f.j.c(System.currentTimeMillis()));
            this.m.putLong("last_report_config", com.qiniu.pili.droid.shortvideo.f.j.c(System.currentTimeMillis()));
            this.m.apply();
            newScheduledThreadPool.scheduleWithFixedDelay(new c(a.config), 60L, 60L, TimeUnit.MINUTES);
            newScheduledThreadPool.scheduleWithFixedDelay(new c(a.method), 1440L, 1440L, TimeUnit.MINUTES);
            return;
        }
        long c2 = com.qiniu.pili.droid.shortvideo.f.j.c(System.currentTimeMillis()) - j;
        if (c2 >= 60) {
            newScheduledThreadPool.scheduleWithFixedDelay(new c(a.config), 0L, 60L, TimeUnit.MINUTES);
        } else {
            newScheduledThreadPool.scheduleWithFixedDelay(new c(a.config), 60 - c2, 60L, TimeUnit.MINUTES);
        }
        long c3 = com.qiniu.pili.droid.shortvideo.f.j.c(System.currentTimeMillis()) - this.l.getLong("last_report_method", 0L);
        if (c3 >= 1440) {
            newScheduledThreadPool.scheduleWithFixedDelay(new c(a.method), 0L, 1440L, TimeUnit.MINUTES);
        } else {
            newScheduledThreadPool.scheduleWithFixedDelay(new c(a.method), 1440 - c3, 1440L, TimeUnit.MINUTES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f13842c.clear();
        String string = Settings.System.getString(this.f13841a.getContentResolver(), "android_id");
        String str = string;
        if (string == null) {
            str = this.l.getString("uuid", com.igexin.push.core.b.l);
        }
        this.f13842c.putString("start_time", String.valueOf(System.currentTimeMillis() / 1000));
        this.f13842c.putString("os_platform", "android");
        this.f13842c.putString("bundle_id", this.f13841a.getPackageName());
        this.f13842c.putString("app_name", com.qiniu.pili.droid.shortvideo.f.j.i(this.f13841a));
        this.f13842c.putString("app_version", com.qiniu.pili.droid.shortvideo.f.j.h(this.f13841a));
        this.f13842c.putString("device_id", str);
        this.f13842c.putString("device_model", com.qiniu.pili.droid.shortvideo.f.j.b());
        this.f13842c.putString("os_version", Build.VERSION.RELEASE);
        this.f13842c.putString("sdk_version", "3.1.1");
        this.f13842c.putString("gl_version", Integer.toString(com.qiniu.pili.droid.shortvideo.f.j.d(this.f13841a)));
        this.f13842c.putString("qos_version", "2.0");
        this.f13842c.apply();
    }

    private JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        if (this.b.getAll().isEmpty()) {
            g();
        }
        try {
            for (Map.Entry<String, ?> entry : this.b.getAll().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (JSONException e) {
            this.f13842c.clear();
            this.f13842c.apply();
        }
        return jSONObject;
    }

    private JSONObject i() {
        JSONObject h = h();
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, ?> entry : this.d.getAll().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().toString());
            }
            h.put("function_part1", Base64.encodeToString(jSONObject.toString().getBytes(), 0));
        } catch (JSONException e) {
            this.e.clear();
            this.e.apply();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            for (Map.Entry<String, ?> entry2 : this.f.getAll().entrySet()) {
                jSONObject2.put(entry2.getKey(), entry2.getValue().toString());
            }
            h.put("function_part2", Base64.encodeToString(jSONObject2.toString().getBytes(), 0));
            return h;
        } catch (JSONException e2) {
            this.g.clear();
            this.g.apply();
            return h;
        }
    }

    private JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, ?> entry : this.h.getAll().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (JSONException e) {
            this.i.clear();
            this.i.apply();
        }
        return jSONObject;
    }

    public void a(int i) {
        synchronized (this) {
            if (o) {
                String b2 = b(i);
                this.i.putInt(b2, this.h.getInt(b2, 0) + 1);
                this.i.apply();
            }
        }
    }

    public void a(KeyPoint keyPoint) {
        synchronized (this) {
            if (o) {
                if (keyPoint.id() < 51) {
                    this.e.putInt(keyPoint.name(), this.d.getInt(keyPoint.name(), 0) + 1);
                    this.e.apply();
                } else {
                    this.g.putInt(keyPoint.name(), this.f.getInt(keyPoint.name(), 0) + 1);
                    this.g.apply();
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
        synchronized (this) {
            if (o && jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equals("data_type")) {
                        int i = 0;
                        try {
                            i = jSONObject.optInt(next, 0);
                        } catch (Exception e) {
                        }
                        if (i == 0) {
                            arrayList.add(next);
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONObject.remove((String) it.next());
                }
                this.k.putString(UUID.randomUUID().toString(), jSONObject.toString());
                this.k.apply();
            }
        }
    }

    public void b() {
        o = true;
    }

    public void b(Context context) {
        synchronized (this) {
            if (n) {
                return;
            }
            n = true;
            this.f13841a = context.getApplicationContext();
            String[] strArr = com.qiniu.pili.droid.shortvideo.core.c.f13851a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                if (com.qiniu.pili.droid.shortvideo.f.j.g(context).contains(strArr[i2])) {
                    o = false;
                    break;
                }
                i = i2 + 1;
            }
            e();
            f();
        }
    }

    public void c() {
        o = false;
    }
}
