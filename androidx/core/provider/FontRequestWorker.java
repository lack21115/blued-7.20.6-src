package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontRequestWorker.class */
public class FontRequestWorker {

    /* renamed from: a  reason: collision with root package name */
    static final LruCache<String, Typeface> f2483a = new LruCache<>(16);
    private static final ExecutorService d = RequestExecutor.a("fonts-androidx", 10, 10000);
    static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> f2484c = new SimpleArrayMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontRequestWorker$TypefaceResult.class */
    public static final class TypefaceResult {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f2491a;
        final int b;

        TypefaceResult(int i) {
            this.f2491a = null;
            this.b = i;
        }

        TypefaceResult(Typeface typeface) {
            this.f2491a = typeface;
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.b == 0;
        }
    }

    private FontRequestWorker() {
    }

    private static int a(FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i = 1;
        if (fontFamilyResult.getStatusCode() != 0) {
            return fontFamilyResult.getStatusCode() != 1 ? -3 : -2;
        }
        FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
        if (fonts != null) {
            if (fonts.length != 0) {
                int length = fonts.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    i = 0;
                    if (i3 >= length) {
                        break;
                    }
                    int resultCode = fonts[i3].getResultCode();
                    if (resultCode != 0) {
                        if (resultCode < 0) {
                            return -3;
                        }
                        return resultCode;
                    }
                    i2 = i3 + 1;
                }
            } else {
                return 1;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface a(final Context context, final FontRequest fontRequest, final int i, Executor executor, final CallbackWithHandler callbackWithHandler) {
        final String a2 = a(fontRequest, i);
        Typeface typeface = f2483a.get(a2);
        if (typeface != null) {
            callbackWithHandler.a(new TypefaceResult(typeface));
            return typeface;
        }
        Consumer<TypefaceResult> consumer = new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.2
            @Override // androidx.core.util.Consumer
            public void accept(TypefaceResult typefaceResult) {
                TypefaceResult typefaceResult2 = typefaceResult;
                if (typefaceResult == null) {
                    typefaceResult2 = new TypefaceResult(-3);
                }
                CallbackWithHandler.this.a(typefaceResult2);
            }
        };
        synchronized (b) {
            ArrayList<Consumer<TypefaceResult>> arrayList = f2484c.get(a2);
            if (arrayList != null) {
                arrayList.add(consumer);
                return null;
            }
            ArrayList<Consumer<TypefaceResult>> arrayList2 = new ArrayList<>();
            arrayList2.add(consumer);
            f2484c.put(a2, arrayList2);
            Callable<TypefaceResult> callable = new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public TypefaceResult call() {
                    try {
                        return FontRequestWorker.a(a2, context, fontRequest, i);
                    } catch (Throwable th) {
                        return new TypefaceResult(-3);
                    }
                }
            };
            ExecutorService executorService = executor;
            if (executor == null) {
                executorService = d;
            }
            RequestExecutor.a(executorService, callable, new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.4
                @Override // androidx.core.util.Consumer
                public void accept(TypefaceResult typefaceResult) {
                    synchronized (FontRequestWorker.b) {
                        ArrayList<Consumer<TypefaceResult>> arrayList3 = FontRequestWorker.f2484c.get(a2);
                        if (arrayList3 == null) {
                            return;
                        }
                        FontRequestWorker.f2484c.remove(a2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= arrayList3.size()) {
                                return;
                            }
                            arrayList3.get(i3).accept(typefaceResult);
                            i2 = i3 + 1;
                        }
                    }
                }
            });
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface a(final Context context, final FontRequest fontRequest, CallbackWithHandler callbackWithHandler, final int i, int i2) {
        final String a2 = a(fontRequest, i);
        Typeface typeface = f2483a.get(a2);
        if (typeface != null) {
            callbackWithHandler.a(new TypefaceResult(typeface));
            return typeface;
        } else if (i2 == -1) {
            TypefaceResult a3 = a(a2, context, fontRequest, i);
            callbackWithHandler.a(a3);
            return a3.f2491a;
        } else {
            try {
                TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.a(d, new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public TypefaceResult call() {
                        return FontRequestWorker.a(a2, context, fontRequest, i);
                    }
                }, i2);
                callbackWithHandler.a(typefaceResult);
                return typefaceResult.f2491a;
            } catch (InterruptedException e) {
                callbackWithHandler.a(new TypefaceResult(-3));
                return null;
            }
        }
    }

    static TypefaceResult a(String str, Context context, FontRequest fontRequest, int i) {
        Typeface typeface = f2483a.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult a2 = FontProvider.a(context, fontRequest, (CancellationSignal) null);
            int a3 = a(a2);
            if (a3 != 0) {
                return new TypefaceResult(a3);
            }
            Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, a2.getFonts(), i);
            if (createFromFontInfo != null) {
                f2483a.put(str, createFromFontInfo);
                return new TypefaceResult(createFromFontInfo);
            }
            return new TypefaceResult(-3);
        } catch (PackageManager.NameNotFoundException e) {
            return new TypefaceResult(-1);
        }
    }

    private static String a(FontRequest fontRequest, int i) {
        return fontRequest.a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        f2483a.evictAll();
    }
}
