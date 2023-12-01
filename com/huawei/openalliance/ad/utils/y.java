package com.huawei.openalliance.ad.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.constant.bm;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/y.class */
public class y {
    private static final String Code = "ImageUtil";
    private static final byte[] V = new byte[0];
    private static final Map<String, Set<aj>> I = new HashMap();

    private static Set<aj> B(String str) {
        return I.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(String str) {
        synchronized (V) {
            Set<aj> B = B(str);
            if (B != null) {
                for (aj ajVar : B) {
                    ajVar.Code();
                }
            }
            Z(str);
        }
    }

    private static int Code(InputStream inputStream) {
        try {
            String Code2 = p.Code(inputStream);
            if (com.huawei.openalliance.ad.constant.t.an.equals(Code2)) {
                return 4;
            }
            return Code2 != null ? 2 : 100;
        } catch (Resources.NotFoundException e) {
            ge.Z(Code, "resId is not found");
            return 100;
        }
    }

    public static Bitmap Code(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            ge.V(Code, "BitmapDrawable");
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i = 1;
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 1;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth > 0) {
            i = intrinsicWidth;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Code(drawable, createBitmap);
        return createBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [android.graphics.drawable.BitmapDrawable] */
    /* JADX WARN: Type inference failed for: r0v45, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v54, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v68, types: [android.graphics.drawable.Drawable] */
    private static Pair<Drawable, String> Code(Context context, String str) {
        String str2;
        String str3;
        String str4;
        BitmapFactory.Options options = new BitmapFactory.Options();
        String str5 = null;
        try {
            options.inJustDecodeBounds = false;
            try {
            } catch (OutOfMemoryError e) {
                str2 = str5;
                ge.I(Code, "OOM read image");
                str3 = "OOM read image";
                return new Pair<>(str2, str3);
            } catch (Throwable th) {
                str2 = str;
                th = th;
                ge.I(Code, "loadImageFromDisk " + th.getClass().getSimpleName());
                str3 = "loadImageFromDisk " + th.getClass().getSimpleName();
                return new Pair<>(str2, str3);
            }
        } catch (OutOfMemoryError e2) {
            str2 = null;
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
        if (str.startsWith(bm.RES.toString())) {
            Pair<Drawable, String> I2 = I(options, str, context);
            str2 = I2.first;
            str4 = I2.second;
        } else if (str.startsWith(bm.ASSET.toString())) {
            Pair<Drawable, String> V2 = V(options, str, context);
            str2 = V2.first;
            str4 = V2.second;
        } else if (!str.startsWith(bm.CONTENT.toString())) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile == null) {
                ge.V(Code, "Image decode fail");
                am.Code(context).V((Integer) 0);
            }
            str2 = new BitmapDrawable(context.getResources(), decodeFile);
            str3 = null;
            return new Pair<>(str2, str3);
        } else {
            Pair<Drawable, String> Code2 = Code(options, str, context);
            str2 = Code2.first;
            str4 = Code2.second;
        }
        str = str2;
        str5 = str2;
        str3 = str4;
        return new Pair<>(str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    private static Pair<Drawable, String> Code(BitmapFactory.Options options, String str, Context context) {
        InputStream inputStream;
        InputStream inputStream2;
        String sb;
        String sb2;
        Closeable closeable = null;
        try {
            try {
                Uri parse = Uri.parse(str);
                ContentResolver contentResolver = context.getContentResolver();
                inputStream2 = contentResolver.openInputStream(parse);
                try {
                    if (Code(inputStream2) == 4) {
                        Pair<Drawable, String> pair = new Pair<>(new fb(context, str), null);
                        at.Code((Closeable) inputStream2);
                        at.Code((Closeable) null);
                        return pair;
                    }
                    InputStream openInputStream = contentResolver.openInputStream(parse);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                        if (decodeStream == null) {
                            ge.V(Code, "Image decode fail");
                            am.Code(context).V((Integer) 0);
                        }
                        Pair<Drawable, String> pair2 = new Pair<>(new BitmapDrawable(context.getResources(), decodeStream), null);
                        at.Code((Closeable) inputStream2);
                        at.Code((Closeable) openInputStream);
                        return pair2;
                    } catch (FileNotFoundException e) {
                        e = e;
                        inputStream = openInputStream;
                        sb = "loadFromProvider FileNotFoundException";
                        StringBuilder sb3 = new StringBuilder();
                        InputStream inputStream3 = inputStream2;
                        sb3.append("lfP ");
                        InputStream inputStream4 = inputStream2;
                        sb3.append(e.getClass().getSimpleName());
                        InputStream inputStream5 = inputStream2;
                        sb2 = sb3.toString();
                        InputStream inputStream6 = inputStream2;
                        ge.I(Code, sb2);
                        at.Code((Closeable) inputStream2);
                        at.Code((Closeable) inputStream);
                        return new Pair<>(null, sb);
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = openInputStream;
                        StringBuilder sb4 = new StringBuilder();
                        InputStream inputStream7 = inputStream2;
                        sb4.append("loadFromProvider ");
                        InputStream inputStream8 = inputStream2;
                        sb4.append(e.getClass().getSimpleName());
                        InputStream inputStream9 = inputStream2;
                        sb = sb4.toString();
                        InputStream inputStream10 = inputStream2;
                        StringBuilder sb5 = new StringBuilder();
                        InputStream inputStream11 = inputStream2;
                        sb5.append("lfP ");
                        InputStream inputStream12 = inputStream2;
                        sb5.append(e.getClass().getSimpleName());
                        InputStream inputStream13 = inputStream2;
                        sb2 = sb5.toString();
                        InputStream inputStream62 = inputStream2;
                        ge.I(Code, sb2);
                        at.Code((Closeable) inputStream2);
                        at.Code((Closeable) inputStream);
                        return new Pair<>(null, sb);
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    inputStream = null;
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    str = inputStream2;
                    at.Code((Closeable) str);
                    at.Code(closeable);
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                inputStream = null;
                inputStream2 = null;
            } catch (Exception e6) {
                e = e6;
                inputStream = null;
                inputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                str = null;
                closeable = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void Code(Context context, SourceParam sourceParam, aj ajVar) {
        Code(context.getApplicationContext(), sourceParam, (String) null, ajVar);
    }

    public static void Code(final Context context, final SourceParam sourceParam, final String str, final aj ajVar) {
        if (sourceParam == null || sourceParam.B() == null) {
            ajVar.Code();
            V(context, 1, sourceParam, "url is null");
            return;
        }
        ge.V(Code, "load: " + bc.Code(sourceParam.B()));
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.y.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (y.V) {
                    String B = SourceParam.this.B();
                    if (y.I(B)) {
                        y.V(B, ajVar);
                        return;
                    }
                    y.V(B, ajVar);
                    if (y.V(context, SourceParam.this.B(), SourceParam.this.B(), SourceParam.this)) {
                        return;
                    }
                    f.V(new Runnable() { // from class: com.huawei.openalliance.ad.utils.y.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            y.V(context, SourceParam.this, str);
                        }
                    });
                }
            }
        });
    }

    private static void Code(Drawable drawable, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
    }

    private static void Code(String str, Drawable drawable) {
        synchronized (V) {
            Set<aj> B = B(str);
            if (B != null) {
                for (aj ajVar : B) {
                    ajVar.Code(str, drawable);
                }
            }
            Z(str);
        }
    }

    private static Pair<Drawable, String> I(BitmapFactory.Options options, String str, Context context) {
        Object obj;
        String substring = str.substring(bm.RES.toString().length());
        BitmapDrawable bitmapDrawable = null;
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), Integer.parseInt(substring), options);
            if (decodeResource == null) {
                ge.V(Code, "Image decode fail");
                am.Code(context).V((Integer) 0);
            }
            obj = null;
            bitmapDrawable = new BitmapDrawable(context.getResources(), decodeResource);
        } catch (Resources.NotFoundException e) {
            ge.I(Code, "loadImage " + e.getClass().getSimpleName());
            obj = "loadResImg Resources.NotFoundException";
        } catch (NumberFormatException e2) {
            ge.I(Code, "loadImage " + e2.getClass().getSimpleName());
            obj = "loadResImg NumberFormatException";
        }
        return new Pair<>(bitmapDrawable, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(String str) {
        boolean containsKey;
        synchronized (V) {
            containsKey = I.containsKey(str);
        }
        return containsKey;
    }

    private static Drawable S(String str) {
        return x.Code().Code(aq.Code(str));
    }

    public static Bitmap V(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap Code2 = Code(drawable);
        Bitmap bitmap = null;
        if (Code2 != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(-1.0f, 1.0f);
            bitmap = Bitmap.createBitmap(Code2, 0, 0, Code2.getWidth(), Code2.getHeight(), matrix, false);
        }
        return bitmap;
    }

    private static Pair<Drawable, String> V(BitmapFactory.Options options, String str, Context context) {
        InputStream inputStream;
        String str2;
        BitmapDrawable bitmapDrawable;
        InputStream open;
        try {
            try {
                open = context.getAssets().open(str.substring(bm.ASSET.toString().length()));
            } catch (IOException e) {
                e = e;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                at.Code((Closeable) null);
                throw th;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
                if (decodeStream == null) {
                    ge.V(Code, "Image decode fail");
                    am.Code(context).V((Integer) 0);
                }
                bitmapDrawable = new BitmapDrawable(context.getResources(), decodeStream);
                at.Code((Closeable) open);
                str2 = null;
            } catch (IOException e2) {
                e = e2;
                inputStream = open;
                StringBuilder sb = new StringBuilder();
                InputStream inputStream2 = inputStream;
                sb.append("loadAssetImg ");
                InputStream inputStream3 = inputStream;
                sb.append(e.getClass().getSimpleName());
                InputStream inputStream4 = inputStream;
                String sb2 = sb.toString();
                InputStream inputStream5 = inputStream;
                StringBuilder sb3 = new StringBuilder();
                InputStream inputStream6 = inputStream;
                sb3.append("lAI ");
                InputStream inputStream7 = inputStream;
                sb3.append(e.getClass().getSimpleName());
                InputStream inputStream8 = inputStream;
                ge.I(Code, sb3.toString());
                at.Code((Closeable) inputStream);
                str2 = sb2;
                bitmapDrawable = null;
                return new Pair<>(bitmapDrawable, str2);
            }
            return new Pair<>(bitmapDrawable, str2);
        } catch (Throwable th2) {
            th = th2;
            at.Code((Closeable) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, int i, SourceParam sourceParam, String str) {
        if (sourceParam == null || sourceParam.F() == null) {
            return;
        }
        eh.Code(context, i, str, sourceParam.F());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(final Context context, final SourceParam sourceParam, String str) {
        if (!au.B(sourceParam.B())) {
            C(sourceParam.B());
            V(context, 2, sourceParam, "fromNet url is not http | " + sourceParam.D());
            return;
        }
        ge.V(Code, "loadImageFromNet");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", str);
            jSONObject.put("content", z.V(sourceParam));
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.p.L, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.y.2
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                    Context applicationContext;
                    int i;
                    SourceParam sourceParam2;
                    String str3;
                    String data = callResult.getData();
                    ge.V(y.Code, "get drawable from net, errorCode: %s filePath: %s", Integer.valueOf(callResult.getCode()), bc.Code(data));
                    if (data == null) {
                        y.C(SourceParam.this.B());
                        applicationContext = context.getApplicationContext();
                        i = 3;
                        sourceParam2 = SourceParam.this;
                        str3 = "filepath is null";
                    } else if (y.V(context.getApplicationContext(), SourceParam.this.B(), data, SourceParam.this)) {
                        return;
                    } else {
                        y.C(SourceParam.this.B());
                        applicationContext = context.getApplicationContext();
                        i = 4;
                        sourceParam2 = SourceParam.this;
                        str3 = "image not download";
                    }
                    y.V(applicationContext, i, sourceParam2, str3);
                }
            }, String.class);
        } catch (JSONException e) {
            ge.I(Code, "loadImageInfo jsonex");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(String str, aj ajVar) {
        if (ajVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (V) {
            Set<aj> set = I.get(str);
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                I.put(str, hashSet);
            }
            hashSet.add(ajVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean V(Context context, String str, String str2, SourceParam sourceParam) {
        Integer c2 = am.Code(context).c();
        if (c2 != null) {
            sourceParam.V(c2.intValue());
        }
        Drawable S = S(str);
        if (S != null) {
            ge.V(Code, "get drawable from cache");
            Code(str, S);
            return true;
        } else if (au.B(str2)) {
            return false;
        } else {
            Pair<Drawable, String> Code2 = Code(context, str2);
            Drawable drawable = Code2.first;
            sourceParam.Z(Code2.second);
            if (drawable != null) {
                ge.V(Code, "get drawable from disk");
                x.Code().Code(aq.Code(str), drawable);
                Code(str, drawable);
                return true;
            }
            return false;
        }
    }

    private static void Z(String str) {
        synchronized (V) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            I.remove(str);
        }
    }
}
