package com.bytedance.applog.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.mobads.sdk.internal.bw;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IPageMeta;
import com.bytedance.applog.IPicker;
import com.bytedance.applog.R;
import com.bytedance.applog.annotation.PageMeta;
import com.bytedance.bdtracker.c;
import com.bytedance.bdtracker.z2;
import com.huawei.openalliance.ad.constant.t;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

@PageMeta(path = "/simulateLaunch", title = "圈选/埋点验证")
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/util/SimulateLaunchActivity.class */
public class SimulateLaunchActivity extends AppCompatActivity implements IPageMeta {
    public static final String KEY_QR_PARAM = "qr_param";

    /* renamed from: a  reason: collision with root package name */
    public a f7577a = a.QR;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f7578c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;
    public TextView i;
    public b j;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/util/SimulateLaunchActivity$a.class */
    public enum a {
        QR,
        NO_QR
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/util/SimulateLaunchActivity$b.class */
    public class b extends AsyncTask<Void, Void, JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final c f7581a;

        public b(c cVar) {
            this.f7581a = cVar;
        }

        @Override // android.os.AsyncTask
        public JSONObject doInBackground(Void[] voidArr) {
            return SimulateLaunchActivity.this.f7577a == a.QR ? this.f7581a.j.a(SimulateLaunchActivity.this.b, SimulateLaunchActivity.this.f, SimulateLaunchActivity.this.f7578c, SimulateLaunchActivity.this.d, SimulateLaunchActivity.this.g, SimulateLaunchActivity.this.e) : this.f7581a.j.a(this, SimulateLaunchActivity.this.b, SimulateLaunchActivity.this.f, SimulateLaunchActivity.this.f7578c, SimulateLaunchActivity.this.d, SimulateLaunchActivity.this.g);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(JSONObject jSONObject) {
            JSONObject optJSONObject;
            JSONObject jSONObject2 = jSONObject;
            if (jSONObject2 == null) {
                SimulateLaunchActivity.this.i.setText("启动失败,请按电脑提示检查原因然后重新扫码(response is null)");
                return;
            }
            String optString = jSONObject2.optString("message");
            String optString2 = jSONObject2.optString("Set-Cookie");
            int optInt = jSONObject2.optInt("status");
            String str = optString2;
            if (optString2 != null) {
                int indexOf = optString2.indexOf(t.aE);
                str = optString2;
                if (indexOf >= 0) {
                    str = optString2.substring(0, indexOf);
                }
            }
            if (SimulateLaunchActivity.this.f7577a == a.NO_QR && (optJSONObject = jSONObject2.optJSONObject("data")) != null) {
                SimulateLaunchActivity.this.h = optJSONObject.optString("mode", "").equals("log") ? "debug_log" : "bind_query";
            }
            if ("debug_log".equals(SimulateLaunchActivity.this.h) && optInt == 0 && !TextUtils.isEmpty(str)) {
                this.f7581a.setRangersEventVerifyEnable(true, str);
                Intent launchIntentForPackage = SimulateLaunchActivity.this.getPackageManager().getLaunchIntentForPackage(SimulateLaunchActivity.this.getApplicationInfo().packageName);
                if (launchIntentForPackage == null) {
                    return;
                }
                launchIntentForPackage.setPackage(null);
                SimulateLaunchActivity.this.startActivity(launchIntentForPackage);
            } else if (!bw.k.equals(optString) || TextUtils.isEmpty(str)) {
                TextView textView = SimulateLaunchActivity.this.i;
                StringBuilder a2 = com.bytedance.bdtracker.a.a("启动失败,请按电脑提示检查原因然后重新扫码(");
                a2.append(jSONObject2.toString());
                a2.append(")");
                textView.setText(a2.toString());
                return;
            } else {
                Intent launchIntentForPackage2 = SimulateLaunchActivity.this.getPackageManager().getLaunchIntentForPackage(SimulateLaunchActivity.this.getApplicationInfo().packageName);
                if (launchIntentForPackage2 == null) {
                    return;
                }
                launchIntentForPackage2.setPackage(null);
                SimulateLaunchActivity.this.startActivity(launchIntentForPackage2);
                IPicker iPicker = null;
                if (this.f7581a.getInitConfig() != null) {
                    iPicker = null;
                    if (this.f7581a.getInitConfig().getPicker() != null) {
                        iPicker = this.f7581a.getInitConfig().getPicker();
                    }
                }
                if (iPicker != null) {
                    iPicker.setMarqueeCookie(str);
                }
                this.f7581a.startSimulator(str);
            }
            SimulateLaunchActivity.this.finish();
        }
    }

    public static void startSimulatorWithoutQR(Context context, String str) {
        startSimulatorWithoutQR(context, AppLog.getAppId(), str);
    }

    public static void startSimulatorWithoutQR(Context context, String str, String str2) {
        Intent intent = new Intent(context, SimulateLaunchActivity.class);
        intent.putExtra("url_prefix_no_qr", str2);
        intent.putExtra("aid_no_qr", str);
        context.startActivity(intent);
    }

    public final void a(c cVar) {
        Object obj = null;
        if (cVar.o != null) {
            obj = cVar.o.a("resolution", (String) null, String.class);
        }
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            String[] split = ((String) Objects.requireNonNull(str)).split("x");
            this.d = Integer.parseInt(split[0]);
            this.f7578c = Integer.parseInt(split[1]);
        }
        this.b = cVar.l;
        this.g = cVar.getDid();
        try {
            this.f = getPackageManager().getPackageInfo(getApplicationInfo().packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            this.f = "1.0.0";
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.applog_activity_simulate);
        this.i = (TextView) findViewById(R.id.text_tip);
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (intent.hasExtra("url_prefix_no_qr") && intent.hasExtra("aid_no_qr")) {
            this.f7577a = a.NO_QR;
            String stringExtra = intent.getStringExtra("url_prefix_no_qr");
            c a2 = com.bytedance.bdtracker.b.a(intent.getStringExtra("aid_no_qr"));
            if (a2 != null) {
                if (!a2.s) {
                    this.i.setText("启动失败,请按电脑提示检查原因然后重新扫码(AppLog未初始化)");
                    return;
                }
                a2.j.f7684a = stringExtra;
                a(a2);
                b bVar = new b(a2);
                this.j = bVar;
                bVar.execute(new Void[0]);
            }
        } else if (data != null) {
            this.f7577a = a.QR;
            c a3 = com.bytedance.bdtracker.b.a(data.getQueryParameter("aid"));
            if (a3 == null) {
                this.i.setText("启动失败：请按电脑提示检查原因然后重新扫码(aid错误或AppLog未初始化)");
            } else if (!a3.s) {
                this.i.setText("启动失败：请按电脑提示检查原因然后重新扫码(AppLog未初始化)");
            } else {
                String queryParameter = data.getQueryParameter("type");
                this.h = queryParameter;
                "debug_log".equals(queryParameter);
                String queryParameter2 = data.getQueryParameter("url_prefix");
                z2.a("urlPrefix=" + queryParameter2);
                if (TextUtils.isEmpty(queryParameter2)) {
                    this.i.setText("启动失败：无url_prefix参数");
                    return;
                }
                a3.j.f7684a = queryParameter2;
                this.e = data.getQueryParameter(KEY_QR_PARAM);
                a(a3);
                b bVar2 = new b(a3);
                this.j = bVar2;
                bVar2.execute(new Void[0]);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.j;
        if (bVar != null) {
            bVar.cancel(true);
            this.j = null;
        }
    }

    @Override // com.bytedance.applog.IPageMeta
    public JSONObject pageProperties() {
        try {
            return new JSONObject().put("class_name", "SimulateLaunchActivity");
        } catch (JSONException e) {
            z2.c("U SHALL NOT PASS!", e);
            return null;
        }
    }

    @Override // com.bytedance.applog.IPageMeta
    public String path() {
        return "/simulateLaunch";
    }

    @Override // com.bytedance.applog.IPageMeta
    public String title() {
        return "圈选/埋点验证";
    }
}
