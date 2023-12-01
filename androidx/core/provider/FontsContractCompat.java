package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontsContractCompat.class */
public class FontsContractCompat {
    @Deprecated
    public static final String PARCEL_FONT_RESULTS = "font_results";

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontsContractCompat$Columns.class */
    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontsContractCompat$FontFamilyResult.class */
    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;

        /* renamed from: a  reason: collision with root package name */
        private final int f2540a;
        private final FontInfo[] b;

        @Deprecated
        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.f2540a = i;
            this.b = fontInfoArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontFamilyResult a(int i, FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i, fontInfoArr);
        }

        public FontInfo[] getFonts() {
            return this.b;
        }

        public int getStatusCode() {
            return this.f2540a;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontsContractCompat$FontInfo.class */
    public static class FontInfo {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f2541a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2542c;
        private final boolean d;
        private final int e;

        @Deprecated
        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            this.f2541a = (Uri) Preconditions.checkNotNull(uri);
            this.b = i;
            this.f2542c = i2;
            this.d = z;
            this.e = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontInfo a(Uri uri, int i, int i2, boolean z, int i3) {
            return new FontInfo(uri, i, i2, z, i3);
        }

        public int getResultCode() {
            return this.e;
        }

        public int getTtcIndex() {
            return this.b;
        }

        public Uri getUri() {
            return this.f2541a;
        }

        public int getWeight() {
            return this.f2542c;
        }

        public boolean isItalic() {
            return this.d;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontsContractCompat$FontRequestCallback.class */
    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        @Deprecated
        public static final int RESULT_OK = 0;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontsContractCompat$FontRequestCallback$FontRequestFailReason.class */
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    private FontsContractCompat() {
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        return FontProvider.a(context, fontRequest, cancellationSignal);
    }

    @Deprecated
    public static Typeface getFontSync(Context context, FontRequest fontRequest, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z, int i, int i2) {
        return requestFont(context, fontRequest, i2, z, i, ResourcesCompat.FontCallback.getHandler(handler), new TypefaceCompat.ResourcesCallbackAdapter(fontCallback));
    }

    @Deprecated
    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        return FontProvider.a(packageManager, fontRequest, resources);
    }

    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontInfoArr, cancellationSignal);
    }

    public static Typeface requestFont(Context context, FontRequest fontRequest, int i, boolean z, int i2, Handler handler, FontRequestCallback fontRequestCallback) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback, handler);
        return z ? FontRequestWorker.a(context, fontRequest, callbackWithHandler, i, i2) : FontRequestWorker.a(context, fontRequest, i, (Executor) null, callbackWithHandler);
    }

    public static void requestFont(Context context, FontRequest fontRequest, FontRequestCallback fontRequestCallback, Handler handler) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback);
        FontRequestWorker.a(context.getApplicationContext(), fontRequest, 0, RequestExecutor.a(handler), callbackWithHandler);
    }

    @Deprecated
    public static void resetCache() {
        FontRequestWorker.a();
    }

    public static void resetTypefaceCache() {
        FontRequestWorker.a();
    }
}
