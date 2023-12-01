package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionParser;
import com.airbnb.lottie.utils.Utils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieCompositionFactory.class */
public class LottieCompositionFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, LottieTask<LottieComposition>> f4217a = new HashMap();

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieCompositionFactory$4.class */
    static final class AnonymousClass4 implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f4223a;
        final /* synthetic */ String b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.a(this.f4223a, this.b);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$5  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieCompositionFactory$5.class */
    static final class AnonymousClass5 implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f4224a;
        final /* synthetic */ String b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.a(this.f4224a, this.b);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$6  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieCompositionFactory$6.class */
    static final class AnonymousClass6 implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f4225a;
        final /* synthetic */ String b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.a(this.f4225a, this.b);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$8  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieCompositionFactory$8.class */
    static final class AnonymousClass8 implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZipInputStream f4227a;
        final /* synthetic */ String b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.a(this.f4227a, this.b);
        }
    }

    private LottieCompositionFactory() {
    }

    private static LottieImageAsset a(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.l().values()) {
            if (lottieImageAsset.b().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    private static LottieResult<LottieComposition> a(JsonReader jsonReader, String str, boolean z) {
        try {
            try {
                LottieComposition a2 = LottieCompositionParser.a(jsonReader);
                LottieCompositionCache.a().a(str, a2);
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(a2);
                if (z) {
                    Utils.a(jsonReader);
                }
                return lottieResult;
            } catch (Exception e) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e);
                if (z) {
                    Utils.a(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z) {
                Utils.a(jsonReader);
            }
            throw th;
        }
    }

    public static LottieResult<LottieComposition> a(InputStream inputStream, String str) {
        return a(inputStream, str, true);
    }

    private static LottieResult<LottieComposition> a(InputStream inputStream, String str, boolean z) {
        try {
            LottieResult<LottieComposition> b = b(new JsonReader(new InputStreamReader(inputStream)), str);
            if (z) {
                Utils.a(inputStream);
            }
            return b;
        } catch (Throwable th) {
            if (z) {
                Utils.a(inputStream);
            }
            throw th;
        }
    }

    public static LottieResult<LottieComposition> a(String str, String str2) {
        return b(new JsonReader(new StringReader(str)), str2);
    }

    public static LottieResult<LottieComposition> a(ZipInputStream zipInputStream, String str) {
        try {
            return b(zipInputStream, str);
        } finally {
            Utils.a(zipInputStream);
        }
    }

    @Deprecated
    public static LottieResult<LottieComposition> a(JSONObject jSONObject, String str) {
        return a(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> a(Context context, final int i) {
        final Context applicationContext = context.getApplicationContext();
        return a(a(i), new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.LottieCompositionFactory.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.b(Context.this, i);
            }
        });
    }

    public static LottieTask<LottieComposition> a(final Context context, final String str) {
        return a("url_" + str, new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.LottieCompositionFactory.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return NetworkFetcher.a(Context.this, str);
            }
        });
    }

    public static LottieTask<LottieComposition> a(final JsonReader jsonReader, final String str) {
        return a(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.LottieCompositionFactory.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.b(JsonReader.this, str);
            }
        });
    }

    private static LottieTask<LottieComposition> a(final String str, Callable<LottieResult<LottieComposition>> callable) {
        LottieComposition a2 = str == null ? null : LottieCompositionCache.a().a(str);
        if (a2 != null) {
            final LottieComposition lottieComposition = a2;
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.LottieCompositionFactory.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public LottieResult<LottieComposition> call() {
                    return new LottieResult<>(LottieComposition.this);
                }
            });
        } else if (str == null || !f4217a.containsKey(str)) {
            LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
            lottieTask.a(new LottieListener<LottieComposition>() { // from class: com.airbnb.lottie.LottieCompositionFactory.10
                @Override // com.airbnb.lottie.LottieListener
                public void a(LottieComposition lottieComposition2) {
                    if (String.this != null) {
                        LottieCompositionCache.a().a(String.this, lottieComposition2);
                    }
                    LottieCompositionFactory.f4217a.remove(String.this);
                }
            });
            lottieTask.c(new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieCompositionFactory.11
                @Override // com.airbnb.lottie.LottieListener
                public void a(Throwable th) {
                    LottieCompositionFactory.f4217a.remove(String.this);
                }
            });
            f4217a.put(str, lottieTask);
            return lottieTask;
        } else {
            return f4217a.get(str);
        }
    }

    private static String a(int i) {
        return "rawRes_" + i;
    }

    public static LottieResult<LottieComposition> b(Context context, int i) {
        try {
            return a(context.getResources().openRawResource(i), a(i));
        } catch (Resources.NotFoundException e) {
            return new LottieResult<>(e);
        }
    }

    public static LottieResult<LottieComposition> b(JsonReader jsonReader, String str) {
        return a(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> b(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (name.contains(".json")) {
                    lottieComposition = a(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).a();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp")) {
                        zipInputStream.closeEntry();
                    }
                    String[] split = name.split(BridgeUtil.SPLIT_MARK);
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset a2 = a(lottieComposition, (String) entry.getKey());
                if (a2 != null) {
                    a2.a((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.l().entrySet()) {
                if (entry2.getValue().c() == null) {
                    return new LottieResult<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            LottieCompositionCache.a().a(str, lottieComposition);
            return new LottieResult<>(lottieComposition);
        } catch (IOException e) {
            return new LottieResult<>(e);
        }
    }

    public static LottieTask<LottieComposition> b(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return a(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.LottieCompositionFactory.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.c(Context.this, str);
            }
        });
    }

    public static LottieResult<LottieComposition> c(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            return str.endsWith(".zip") ? a(new ZipInputStream(context.getAssets().open(str)), str2) : a(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new LottieResult<>(e);
        }
    }
}
