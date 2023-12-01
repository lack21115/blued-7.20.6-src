package a.a.a.a.a.e;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.EGL14;
import android.os.Build;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.WindowManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.qiniu.android.dns.DnsManager;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.http.DnspodFree;
import com.qiniu.android.dns.local.AndroidDnsServer;
import com.qiniu.android.dns.local.Resolver;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.security.SignatureException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.ThreadLocalRandom;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/e/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final long f1363a = (Runtime.getRuntime().maxMemory() * 60) / 100;
    public static final long b = (Runtime.getRuntime().maxMemory() * 90) / 100;

    /* renamed from: c  reason: collision with root package name */
    public static final long f1364c = (Runtime.getRuntime().maxMemory() * 60) / 100;
    public static Random d = new Random();
    public static boolean e = g();

    public static float a(List<Float> list) {
        float f;
        float f2 = 0.0f;
        if (list != null) {
            if (list.size() == 0) {
                return 0.0f;
            }
            if (!(list instanceof RandomAccess)) {
                Iterator<Float> it = list.iterator();
                float f3 = 0.0f;
                while (true) {
                    float f4 = f3;
                    f = f4;
                    if (!it.hasNext()) {
                        break;
                    }
                    f3 = f4 + it.next().floatValue();
                }
            } else {
                int i = 0;
                int size = list.size();
                float f5 = 0.0f;
                while (true) {
                    f = f5;
                    if (i >= size) {
                        break;
                    }
                    f5 += list.get(i).floatValue();
                    i++;
                }
            }
            f2 = f / list.size();
        }
        return f2;
    }

    public static int a(float f) {
        return Math.round(Math.round(f / 16.0f) * 16);
    }

    public static int a(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int a(int i, int i2) {
        int i3 = i;
        if (i2 > i) {
            i3 = i;
            if (i % 16 != 0) {
                i3 = ((i / 16) + 1) * 16;
            }
        }
        return i3;
    }

    public static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static int a(int i, int i2, int i3, int i4) {
        return ((float) i) / ((float) i2) > ((float) i3) / ((float) i4) ? i / i3 : i2 / i4;
    }

    public static int a(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        e eVar = e.f1361c;
        eVar.c("CameraStreamingUtil", "options.width:" + i4 + ",options.height:" + i3 + ",reqWidth:" + i + ",reqHeight:" + i2);
        int i5 = 1;
        int i6 = 1;
        if (i3 > i2 || i4 > i) {
            int i7 = i3 / 2;
            int i8 = i4 / 2;
            while (true) {
                i5 = i6;
                if (i7 / i6 <= i2) {
                    break;
                }
                i5 = i6;
                if (i8 / i6 <= i) {
                    break;
                }
                i6 *= 2;
            }
        }
        e eVar2 = e.f1361c;
        eVar2.c("CameraStreamingUtil", "inSampleSize:" + i5);
        return i5;
    }

    public static Bitmap a(Resources resources, int i, int i2, int i3) {
        BitmapFactory.Options options;
        if (i2 <= 0 || i3 <= 0) {
            options = null;
        } else {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(resources, i, options);
            options.inScaled = true;
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(options.outWidth, options.outHeight, i2, i3);
        }
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2 = bitmap;
        if (i > 0) {
            bitmap2 = bitmap;
            if (i2 > 0) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, i, i2, true);
            }
        }
        return bitmap2;
    }

    public static Bitmap a(String str, int i, int i2) {
        BitmapFactory.Options options;
        if (i <= 0 || i2 <= 0) {
            options = null;
        } else {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            options.inScaled = true;
            options.inSampleSize = a(options.outWidth, options.outHeight, i, i2);
        }
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (r10 == 270) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(byte[] r5, int r6, int r7, int r8, int r9, int r10) {
        /*
            r0 = r10
            r1 = 90
            if (r0 == r1) goto L16
            r0 = r8
            r12 = r0
            r0 = r9
            r11 = r0
            r0 = r10
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 != r1) goto L1d
        L16:
            r0 = r8
            r11 = r0
            r0 = r9
            r12 = r0
        L1d:
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r1 = r0
            r1.<init>()
            r13 = r0
            r0 = r13
            r1 = 1
            r0.inJustDecodeBounds = r1
            r0 = r5
            r1 = r6
            r2 = r7
            r3 = r13
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r1, r2, r3)
            r0 = r13
            r1 = r13
            r2 = r12
            r3 = r11
            int r1 = a(r1, r2, r3)
            r0.inSampleSize = r1
            r0 = r13
            r1 = 0
            r0.inJustDecodeBounds = r1
            r0 = r5
            r1 = r6
            r2 = r7
            r3 = r13
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.e.h.a(byte[], int, int, int, int, int):android.graphics.Bitmap");
    }

    public static String a(StreamingProfile.Stream stream, String str) {
        return String.format("%s://%s/%s/%s?key=%s", str, stream.getPublishRtmpHost(), stream.getHubName(), stream.getTitle(), stream.getPublishKey());
    }

    public static String a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0085 A[Catch: UnsupportedEncodingException -> 0x0097, TRY_ENTER, TryCatch #0 {UnsupportedEncodingException -> 0x0097, blocks: (B:11:0x0025, B:16:0x0036, B:18:0x0045, B:21:0x005c, B:24:0x006e, B:27:0x0085), top: B:36:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> a(java.net.URI r4) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r4
            if (r0 != 0) goto L10
            r0 = r10
            return r0
        L10:
            r0 = r4
            java.lang.String r0 = r0.getQuery()
            r4 = r0
            r0 = r4
            if (r0 != 0) goto L1c
            r0 = r10
            return r0
        L1c:
            r0 = r4
            java.lang.String r1 = "&"
            java.lang.String[] r0 = r0.split(r1)
            r11 = r0
            r0 = r11
            int r0 = r0.length     // Catch: java.io.UnsupportedEncodingException -> L97
            r6 = r0
            r0 = 0
            r5 = r0
        L2b:
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L9c
            r0 = r11
            r1 = r5
            r0 = r0[r1]
            r9 = r0
            r0 = r9
            java.lang.String r1 = "="
            int r0 = r0.indexOf(r1)     // Catch: java.io.UnsupportedEncodingException -> L97
            r8 = r0
            r0 = r8
            if (r0 <= 0) goto L9f
            r0 = r9
            r1 = 0
            r2 = r8
            java.lang.String r0 = r0.substring(r1, r2)     // Catch: java.io.UnsupportedEncodingException -> L97
            java.lang.String r1 = "UTF-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r0, r1)     // Catch: java.io.UnsupportedEncodingException -> L97
            r4 = r0
            goto L57
        L57:
            r0 = r8
            if (r0 <= 0) goto La5
            r0 = r9
            int r0 = r0.length()     // Catch: java.io.UnsupportedEncodingException -> L97
            r7 = r0
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r7
            r1 = r8
            if (r0 <= r1) goto La5
            r0 = r9
            r1 = r8
            java.lang.String r0 = r0.substring(r1)     // Catch: java.io.UnsupportedEncodingException -> L97
            java.lang.String r1 = "UTF-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r0, r1)     // Catch: java.io.UnsupportedEncodingException -> L97
            r9 = r0
            goto L80
        L80:
            r0 = r9
            if (r0 == 0) goto L90
            r0 = r10
            r1 = r4
            r2 = r9
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.io.UnsupportedEncodingException -> L97
        L90:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L2b
        L97:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L9c:
            r0 = r10
            return r0
        L9f:
            r0 = r9
            r4 = r0
            goto L57
        La5:
            r0 = 0
            r9 = r0
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.e.h.a(java.net.URI):java.util.Map");
    }

    public static void a(Matrix matrix, boolean z, int i, int i2, int i3) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(i);
        float f = i2;
        float f2 = f / 2000.0f;
        float f3 = i3;
        matrix.postScale(f2, f3 / 2000.0f);
        matrix.postTranslate(f / 2.0f, f3 / 2.0f);
    }

    public static void a(RectF rectF, Rect rect) {
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
    }

    public static void a(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean a(PLBufferInfo pLBufferInfo) {
        return (pLBufferInfo.flags & 1) != 0;
    }

    public static boolean a(String str) {
        return (str == null || str.trim().isEmpty()) ? false : true;
    }

    public static boolean a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    public static byte[] a(int i, int i2, Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        int[] iArr = new int[i * i2];
        try {
            bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return z ? a(iArr, i, i2) : b(iArr, i, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = i * i2;
        byte[] bArr = new byte[(i5 * 3) / 2];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = 0;
            while (i9 < i) {
                int i10 = iArr[i7];
                int i11 = (iArr[i7] & Spanned.SPAN_PRIORITY) >> 16;
                int i12 = (iArr[i7] & 65280) >> 8;
                int i13 = (iArr[i7] & 255) >> 0;
                int i14 = (((((i11 * 66) + (i12 * 129)) + (i13 * 25)) + 128) >> 8) + 16;
                int i15 = (((((i11 * (-38)) - (i12 * 74)) + (i13 * 112)) + 128) >> 8) + 128;
                int i16 = (((((i11 * 112) - (i12 * 94)) - (i13 * 18)) + 128) >> 8) + 128;
                if (i14 < 0) {
                    i3 = 0;
                } else {
                    i3 = i14;
                    if (i14 > 255) {
                        i3 = 255;
                    }
                }
                bArr[i6] = (byte) i3;
                int i17 = i5;
                if (i8 % 2 == 0) {
                    i17 = i5;
                    if (i7 % 2 == 0) {
                        int i18 = i5 + 1;
                        if (i16 < 0) {
                            i4 = 0;
                        } else {
                            i4 = i16;
                            if (i16 > 255) {
                                i4 = 255;
                            }
                        }
                        bArr[i5] = (byte) i4;
                        int i19 = i18 + 1;
                        bArr[i18] = (byte) (i15 < 0 ? 0 : i15 > 255 ? 255 : i15);
                        i17 = i19;
                    }
                }
                i7++;
                i9++;
                i6++;
                i5 = i17;
            }
        }
        return bArr;
    }

    public static int b(int i, int i2) {
        return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt(i, i2 + 1) : c(i, i2);
    }

    public static int b(Context context) {
        int a2 = a(context);
        if (a2 != 1) {
            if (a2 != 2) {
                return a2 != 3 ? 0 : 270;
            }
            return 180;
        }
        return 90;
    }

    public static String b(StreamingProfile.Stream stream, String str) {
        String str2;
        String str3 = BridgeUtil.SPLIT_MARK + stream.getHubName() + BridgeUtil.SPLIT_MARK + stream.getTitle() + "?nonce=" + (System.currentTimeMillis() / 1000);
        try {
            str2 = a.b(stream.getPublishKey(), str3);
        } catch (SignatureException e2) {
            e2.printStackTrace();
            str2 = null;
        }
        return String.format("%s://%s%s&token=%s", str, stream.getPublishRtmpHost(), str3, str2);
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            }
            i = i2 + 1;
        }
    }

    public static boolean b() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >= f1363a;
    }

    public static boolean b(int i) {
        return i == CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal();
    }

    public static boolean b(PLBufferInfo pLBufferInfo) {
        return (pLBufferInfo.flags & 2) != 0;
    }

    public static byte[] b(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = i * i2;
        int i6 = (i5 / 4) + i5;
        byte[] bArr = new byte[(i5 * 3) / 2];
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = 0;
            while (i10 < i) {
                int i11 = (iArr[i8] & Spanned.SPAN_PRIORITY) >> 16;
                int i12 = (iArr[i8] & 65280) >> 8;
                int i13 = (iArr[i8] & 255) >> 0;
                int i14 = (((((i11 * 66) + (i12 * 129)) + (i13 * 25)) + 128) >> 8) + 16;
                int i15 = (((((i11 * (-38)) - (i12 * 74)) + (i13 * 112)) + 128) >> 8) + 128;
                int i16 = (((((i11 * 112) - (i12 * 94)) - (i13 * 18)) + 128) >> 8) + 128;
                if (i14 < 0) {
                    i3 = 0;
                } else {
                    i3 = i14;
                    if (i14 > 255) {
                        i3 = 255;
                    }
                }
                bArr[i7] = (byte) i3;
                int i17 = i5;
                int i18 = i6;
                if (i9 % 2 == 0) {
                    i17 = i5;
                    i18 = i6;
                    if (i8 % 2 == 0) {
                        if (i15 < 0) {
                            i4 = 0;
                        } else {
                            i4 = i15;
                            if (i15 > 255) {
                                i4 = 255;
                            }
                        }
                        bArr[i6] = (byte) i4;
                        bArr[i5] = (byte) (i16 < 0 ? 0 : i16 > 255 ? 255 : i16);
                        i17 = i5 + 1;
                        i18 = i6 + 1;
                    }
                }
                i8++;
                i10++;
                i7++;
                i5 = i17;
                i6 = i18;
            }
        }
        return bArr;
    }

    public static int c(int i) {
        return (i & (-65536)) >> 16;
    }

    public static int c(int i, int i2) {
        return d.nextInt((i2 - i) + 1) + i;
    }

    public static boolean c() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >= b;
    }

    public static boolean c(Context context) {
        Point d2 = d(context);
        return d2.x > d2.y;
    }

    public static boolean c(PLBufferInfo pLBufferInfo) {
        return (pLBufferInfo.flags & 4) != 0;
    }

    public static boolean c(String str) {
        return str != null && str.matches("(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");
    }

    public static int d(int i, int i2) {
        Random random = new Random();
        int i3 = i;
        if (i2 > i) {
            i3 = i + random.nextInt(i2 - i);
        }
        return i3;
    }

    public static Point d(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(point);
        return point;
    }

    public static boolean d() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >= f1364c;
    }

    public static boolean d(PLBufferInfo pLBufferInfo) {
        return pLBufferInfo.isNeedAddHeader;
    }

    public static boolean d(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$");
    }

    public static boolean e() {
        return Build.HARDWARE.startsWith("mt") || Build.HARDWARE.startsWith("MT");
    }

    public static boolean e(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    public static int f(Context context) {
        int i = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
        if (i != 0) {
            return c(i);
        }
        return 1;
    }

    public static DnsManager f() {
        Resolver resolver;
        DnspodFree dnspodFree = new DnspodFree();
        IResolver defaultResolver = AndroidDnsServer.defaultResolver();
        try {
            resolver = new Resolver(InetAddress.getByName("119.29.29.29"));
        } catch (IOException e2) {
            e2.printStackTrace();
            resolver = null;
        }
        return new DnsManager(NetworkInfo.normal, new IResolver[]{dnspodFree, defaultResolver, resolver});
    }

    public static boolean g() {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                EGL14.eglGetCurrentContext();
                return true;
            } catch (NoClassDefFoundError e2) {
                e.f1361c.c("CameraStreamingUtil", "EGL14 isn't supported on this platform, change to use EGL10.");
                return false;
            }
        }
        return false;
    }

    public static String[] g(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return new String[]{packageInfo.packageName, packageInfo.versionName};
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static String h(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_model", i());
            jSONObject.put("os_version", j());
            jSONObject.put("sdk_version", "librtmp-1.1.0;PLDroidCameraStreaming-3.0.0");
            jSONObject.put("app_name", i(context));
            jSONObject.put("app_version", j(context));
            jSONObject.put("gl_version", f(context));
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return e2.toString();
        }
    }

    public static boolean h() {
        return e;
    }

    public static String i() {
        String trim = Build.MODEL.trim();
        String a2 = a(Build.MANUFACTURER.trim(), trim);
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = a(Build.BRAND.trim(), trim);
        }
        StringBuilder sb = new StringBuilder();
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(trim);
        return b(sb.toString()).replace(" ", BridgeUtil.UNDERLINE_STR);
    }

    public static String i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e2) {
            return "";
        }
    }

    public static String j() {
        return b(("os version:" + Build.VERSION.RELEASE + ", Android SDK_INT:" + Build.VERSION.SDK_INT + ", SoC Hardware:" + Build.HARDWARE).trim());
    }

    public static String j(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            return "";
        }
    }

    public static String k() {
        Random random = new Random();
        return System.currentTimeMillis() + "" + random.nextInt(999);
    }

    public static String k(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("qos", 0);
        String string = sharedPreferences.getString("deviceId", "");
        String str = string;
        if ("".equals(string)) {
            str = k();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("deviceId", str);
            edit.commit();
        }
        return str;
    }

    public static String l(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
