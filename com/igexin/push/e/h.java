package com.igexin.push.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.location.Location;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.base.util.io.IOUtils;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.b.s;
import com.igexin.push.core.d.d;
import com.igexin.push.f.n;
import com.igexin.push.f.o;
import com.igexin.push.f.q;
import com.igexin.sdk.router.TransferGtcProcess;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/h.class */
public final class h {

    /* renamed from: a */
    public static final String f23627a = "com.igexin.sdk.GActivity";
    public static final String b = "com.sdk.plus.EnhActivity";

    /* renamed from: c */
    public static final int f23628c = 1;
    public static final int d = 0;
    private static final String e = "Type145Task";

    /* renamed from: com.igexin.push.e.h$2 */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/h$2.class */
    public static final class AnonymousClass2 implements Call.Callback {

        /* renamed from: a */
        final /* synthetic */ AtomicInteger f23631a;
        final /* synthetic */ String b;

        /* renamed from: c */
        final /* synthetic */ byte[] f23632c;
        final /* synthetic */ int d;

        AnonymousClass2(AtomicInteger atomicInteger, String str, byte[] bArr, int i) {
            this.f23631a = atomicInteger;
            this.b = str;
            this.f23632c = bArr;
            this.d = i;
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onFailure(Call call, Exception exc) {
            com.igexin.c.a.c.a.a(exc);
            if (!"network is not available".equals(exc.getMessage()) && this.f23631a.incrementAndGet() < 3) {
                com.igexin.push.e.a.c.a(this.b, this.f23632c, this);
            }
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onResponse(Call call, Response response) {
            try {
                int code = response.code();
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (jSONObject.has("result")) {
                    String string = jSONObject.getString("result");
                    com.igexin.c.a.c.a.b(h.e, "upload 145 code = " + code + " result = " + string);
                    if (com.igexin.push.core.b.x.equals(string)) {
                        String str = this.d == 1 ? com.igexin.push.core.d.d.f : com.igexin.push.core.d.d.g;
                        com.igexin.push.core.d.d a2 = com.igexin.push.core.d.d.a();
                        a2.a(new d.AnonymousClass4(str).a((com.igexin.push.core.g.a) new d.AnonymousClass3()));
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/h$a.class */
    public static final class a {

        /* renamed from: a */
        private static final h f23635a = new h();

        private a() {
        }
    }

    private static Bitmap a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int length = byteArrayOutputStream.toByteArray().length / 1024;
        Bitmap bitmap2 = bitmap;
        if (length > 200) {
            double d2 = length / 200;
            double width = bitmap.getWidth() / Math.sqrt(d2);
            double height = bitmap.getHeight() / Math.sqrt(d2);
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale((float) (Double.valueOf(width).doubleValue() / width2), (float) (Double.valueOf(height).doubleValue() / height2));
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width2, height2, matrix, true);
        }
        return bitmap2;
    }

    private static Bitmap a(Bitmap bitmap, Double d2, Double d3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((float) (d2.doubleValue() / width), (float) (d3.doubleValue() / height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Pair<Activity, String> a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = Build.VERSION.SDK_INT < 19 ? (HashMap) declaredField.get(invoke) : (ArrayMap) declaredField.get(invoke);
            if (map.size() <= 0) {
                return new Pair<>(null, "");
            }
            StringBuffer stringBuffer = new StringBuffer();
            Activity activity = null;
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(obj);
                Field declaredField3 = cls2.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                if (!declaredField3.getBoolean(obj)) {
                    activity = activity2;
                }
                stringBuffer.append(activity2.getComponentName().getClassName());
                stringBuffer.append(",");
            }
            return new Pair<>(activity, stringBuffer.toString());
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return new Pair<>(null, "");
        }
    }

    public static String a(Activity activity) {
        try {
            View rootView = activity.getWindow().getDecorView().getRootView();
            rootView.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.RGB_565);
            rootView.draw(new Canvas(createBitmap));
            rootView.setDrawingCacheEnabled(false);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            int length = byteArrayOutputStream.toByteArray().length / 1024;
            Bitmap bitmap = createBitmap;
            if (length > 200) {
                int i = length / 200;
                double width = createBitmap.getWidth();
                double d2 = i;
                double sqrt = width / Math.sqrt(d2);
                double height = createBitmap.getHeight() / Math.sqrt(d2);
                int width2 = createBitmap.getWidth();
                int height2 = createBitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale((float) (Double.valueOf(sqrt).doubleValue() / width2), (float) (Double.valueOf(height).doubleValue() / height2));
                bitmap = Bitmap.createBitmap(createBitmap, 0, 0, width2, height2, matrix, true);
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
            try {
                byteArrayOutputStream2.flush();
                byteArrayOutputStream2.close();
            } catch (IOException e2) {
            }
            return Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    private static String a(Context context) {
        return (String) o.b(context, "ua", "");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static String a(Context context, Intent intent, s sVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    static String a(Location location) {
        StringBuilder sb = new StringBuilder();
        if (location == null) {
            sb.append("none");
            sb.append(",");
            sb.append("0");
            sb.append(",");
            sb.append("0");
            sb.append(",");
            sb.append("0");
        } else {
            sb.append(location.getProvider());
            sb.append(",");
            sb.append(location.getLongitude());
            sb.append(",");
            sb.append(location.getLatitude());
            sb.append(",");
            sb.append(location.getAltitude());
        }
        return sb.toString();
    }

    private static String a(com.igexin.push.core.b.d dVar) {
        return dVar.f23435a + "," + dVar.b + "," + dVar.f23436c + "," + dVar.d;
    }

    public static List<String> a(String str, int i) throws Throwable {
        String encodeToString = Base64.encodeToString(SecureCryptTools.getInstance().encrypt(str.getBytes()), 2);
        String str2 = i == 1 ? com.igexin.push.core.d.d.f : com.igexin.push.core.d.d.g;
        ArrayList<String> a2 = com.igexin.push.core.d.d.a().a(str2, new ArrayList<>());
        a2.add(encodeToString);
        com.igexin.push.core.d.d.a().a(str2, (Object) a2);
        return a2;
    }

    private static void a(int i) {
        String str = i == 1 ? com.igexin.push.core.d.d.f : com.igexin.push.core.d.d.g;
        com.igexin.push.core.d.d a2 = com.igexin.push.core.d.d.a();
        a2.a(new d.AnonymousClass4(str).a((com.igexin.push.core.g.a) new d.AnonymousClass3()));
    }

    private static void a(final int i, final String str, final String str2) {
        com.igexin.b.a.a().b().schedule(new Runnable() { // from class: com.igexin.push.e.h.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList<String> a2 = com.igexin.push.core.d.d.a().a(i == 1 ? com.igexin.push.core.d.d.f : com.igexin.push.core.d.d.g, new ArrayList<>());
                    if (a2.isEmpty()) {
                        a2.size();
                        return;
                    }
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= a2.size()) {
                            break;
                        }
                        String str3 = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(a2.get(i3).getBytes(), 2)));
                        if (i3 < a2.size() - 1) {
                            sb.append(str3);
                            sb.append("\n");
                        } else {
                            sb.append(str3);
                        }
                        i2 = i3 + 1;
                    }
                    String sb2 = sb.toString();
                    com.igexin.c.a.c.a.b(h.e, " start145Data  content  = ".concat(String.valueOf(sb2)));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "upload_BI");
                    jSONObject.put("BIType", 145);
                    jSONObject.put("cid", str2);
                    jSONObject.put("BIData", new String(IOUtils.encode(sb2.getBytes(), 0)));
                    byte[] bytes = jSONObject.toString().getBytes();
                    if (bytes == null || bytes.length <= 0) {
                        return;
                    }
                    h.a(str, bytes, i);
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        }, 10000L, TimeUnit.MILLISECONDS);
    }

    public static void a(final Context context, final int i, final Intent intent) {
        long j;
        long j2;
        ServiceManager.b = context;
        final String stringExtra = intent.getStringExtra("biUploadUrl");
        final String stringExtra2 = intent.getStringExtra("cid");
        a(i, stringExtra, stringExtra2);
        if (Build.VERSION.SDK_INT >= 28) {
            com.igexin.c.a.c.a.b(e, "processName  = ".concat(String.valueOf(Application.getProcessName())));
        }
        final String stringExtra3 = intent.getStringExtra("appid");
        final String stringExtra4 = intent.getStringExtra("gtcid");
        final long longExtra = intent.getLongExtra("type145DelayMs", com.igexin.push.config.d.Z);
        boolean booleanExtra = intent.getBooleanExtra("type145Enable", com.igexin.push.config.d.Y);
        final boolean booleanExtra2 = intent.getBooleanExtra("type145PicEnable", com.igexin.push.config.d.aa);
        if (intent.getIntExtra("gtsdkGuardStart", 0) != 1) {
            com.igexin.c.a.c.a.b(e, "gtsdkGuardStart  = false");
        } else if (!booleanExtra) {
            com.igexin.c.a.c.a.b(e, "type145Enable  = false");
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                j2 = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
                j = longExtra - j2;
            } else {
                j = longExtra;
                j2 = 0;
            }
            if (j < 0) {
                j = 0;
            }
            com.igexin.c.a.c.a.b(e, " start145Data  delay  ".concat(String.valueOf(j)));
            final long j3 = j2;
            com.igexin.b.a.a().b().schedule(new Runnable() { // from class: com.igexin.push.e.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    try {
                        Pair<Activity, String> a2 = h.a();
                        Activity activity = a2.first;
                        if (activity == null) {
                            com.igexin.c.a.c.a.b(h.e, " start145Data  return topActivity  = null");
                            return;
                        }
                        String className = activity.getComponentName().getClassName();
                        if (!h.f23627a.equals(className) && !h.b.equals(className)) {
                            String a3 = booleanExtra2 ? h.a(activity) : "";
                            boolean z = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0) != null;
                            String str2 = (String) o.b(context, "ua", "");
                            boolean b2 = h.b(activity);
                            boolean z2 = context.getPackageManager().getActivityInfo(activity.getComponentName(), 0).theme == 16973840;
                            com.igexin.c.a.c.a.b(h.e, " packageData ");
                            if (b2 || !z2 || !className.equals(str2) || z) {
                                s sVar = new s(stringExtra2, stringExtra3, stringExtra4, className, b2, z2, longExtra, z, j3, a2.second, a3, i);
                                Context context2 = context;
                                Intent intent2 = intent;
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.f23459a);
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.b);
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.f23460c);
                                stringBuffer.append("|");
                                stringBuffer.append(2);
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.g);
                                stringBuffer.append("|");
                                stringBuffer.append(1);
                                stringBuffer.append("|");
                                stringBuffer.append(1);
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.d);
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.l);
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.f ? 0 : 1);
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.e ? 1 : 0);
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.h ? 1 : 0);
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.i);
                                stringBuffer.append("|");
                                stringBuffer.append(intent2.getBooleanExtra("type145PicEnable", com.igexin.push.config.d.aa) ? sVar.k : "");
                                stringBuffer.append("|");
                                stringBuffer.append("|");
                                stringBuffer.append(sVar.j);
                                stringBuffer.append("|");
                                stringBuffer.append(intent2.getBooleanExtra("type145IpEnable", com.igexin.push.config.d.ab) ? q.a(context2) : "");
                                stringBuffer.append("|");
                                stringBuffer.append(intent2.getBooleanExtra("type145GpsLocationEnable", com.igexin.push.config.d.ac) ? h.a(n.s()) : "");
                                stringBuffer.append("|");
                                stringBuffer.append(intent2.getBooleanExtra("type145NetLocEnable", com.igexin.push.config.d.ad) ? h.a(n.t()) : "");
                                stringBuffer.append("|");
                                if (intent2.getBooleanExtra("type145CellInfoEnable", com.igexin.push.config.d.ae)) {
                                    com.igexin.push.core.b.d b3 = q.b(context2);
                                    str = b3.f23435a + "," + b3.b + "," + b3.f23436c + "," + b3.d;
                                } else {
                                    str = "";
                                }
                                stringBuffer.append(str);
                                h.a(stringExtra, h.a(h.a(stringBuffer.toString(), i), sVar), i);
                                return;
                            }
                            return;
                        }
                        com.igexin.c.a.c.a.b(h.e, " start145Data  return topActivity  = ".concat(String.valueOf(className)));
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            }, j, TimeUnit.MILLISECONDS);
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            if (CommonUtil.isMainProcess()) {
                a(context, 0, intent);
            } else {
                TransferGtcProcess.getInstance().transferGtcProcess(context, intent, TransferGtcProcess.TYPE145TASK_METHODNAME);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    static /* synthetic */ void a(String str, byte[] bArr, int i) {
        com.igexin.push.e.a.c.a(str, bArr, new AnonymousClass2(new AtomicInteger(0), str, bArr, i));
    }

    public static byte[] a(List<String> list, s sVar) throws Throwable {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                String sb2 = sb.toString();
                com.igexin.c.a.c.a.b(e, " start145Data  content  = ".concat(String.valueOf(sb2)));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "upload_BI");
                jSONObject.put("BIType", 145);
                jSONObject.put("cid", sVar.f23459a);
                jSONObject.put("BIData", new String(IOUtils.encode(sb2.getBytes(), 0)));
                return jSONObject.toString().getBytes();
            }
            String str = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(list.get(i2).getBytes(), 2)));
            int size = list.size();
            sb.append(str);
            if (i2 < size - 1) {
                sb.append("\n");
            }
            i = i2 + 1;
        }
    }

    private static h b() {
        return a.f23635a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static /* synthetic */ String b(Context context, Intent intent, s sVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private static /* synthetic */ void b(int i) {
        String str = i == 1 ? com.igexin.push.core.d.d.f : com.igexin.push.core.d.d.g;
        com.igexin.push.core.d.d a2 = com.igexin.push.core.d.d.a();
        a2.a(new d.AnonymousClass4(str).a((com.igexin.push.core.g.a) new d.AnonymousClass3()));
    }

    private static void b(String str, byte[] bArr, int i) {
        com.igexin.push.e.a.c.a(str, bArr, new AnonymousClass2(new AtomicInteger(0), str, bArr, i));
    }

    public static boolean b(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        IBinder windowToken = decorView.getWindowToken();
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            int indexOf = ((ArrayList) declaredField.get(invoke)).indexOf(decorView);
            if (indexOf < 0) {
                return false;
            }
            Field declaredField2 = cls.getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            ArrayList arrayList = (ArrayList) declaredField2.get(invoke);
            IBinder iBinder = ((WindowManager.LayoutParams) arrayList.get(indexOf)).token;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IBinder iBinder2 = ((WindowManager.LayoutParams) it.next()).token;
                if (iBinder2 == windowToken || iBinder2 == null || iBinder2 == iBinder) {
                    arrayList2.add(iBinder2);
                }
            }
            return arrayList2.size() > 1;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static void c() {
        com.igexin.c.a.c.a.b(e, "doAction ---");
        Intent intent = new Intent(com.igexin.push.core.e.g + ".doaction");
        intent.putExtra("cid", com.igexin.push.core.e.A);
        intent.putExtra("appid", com.igexin.push.core.e.f23495a);
        intent.putExtra("gtcid", com.igexin.push.core.e.C);
        intent.putExtra("type145DelayMs", com.igexin.push.config.d.Z);
        intent.putExtra("type145Enable", com.igexin.push.config.d.Y);
        intent.putExtra("biUploadUrl", SDKUrlConfig.getBiUploadServiceUrl());
        intent.putExtra("gtsdkGuardStart", ServiceManager.getInstance().initType.first);
        intent.putExtra("type145PicEnable", com.igexin.push.config.d.aa);
        intent.putExtra("type145IpEnable", com.igexin.push.config.d.ab);
        intent.putExtra("type145GpsLocationEnable", com.igexin.push.config.d.ac);
        intent.putExtra("type145NetLocEnable", com.igexin.push.config.d.ad);
        intent.putExtra("type145CellInfoEnable", com.igexin.push.config.d.ae);
        a(com.igexin.push.core.e.l, 1, intent);
        h unused = a.f23635a;
        a(com.igexin.push.core.e.l, intent);
    }

    private static Bitmap d() {
        return null;
    }
}
