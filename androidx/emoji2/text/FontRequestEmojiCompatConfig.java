package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/FontRequestEmojiCompatConfig.class */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper j = new FontProviderHelper();

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/FontRequestEmojiCompatConfig$ExponentialBackoffRetryPolicy.class */
    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {

        /* renamed from: a  reason: collision with root package name */
        private final long f2786a;
        private long b;

        public ExponentialBackoffRetryPolicy(long j) {
            this.f2786a = j;
        }

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getRetryDelay() {
            if (this.b == 0) {
                this.b = SystemClock.uptimeMillis();
                return 0L;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.b;
            if (uptimeMillis > this.f2786a) {
                return -1L;
            }
            return Math.min(Math.max(uptimeMillis, 1000L), this.f2786a - uptimeMillis);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/FontRequestEmojiCompatConfig$FontProviderHelper.class */
    public static class FontProviderHelper {
        public Typeface buildTypeface(Context context, FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public FontsContractCompat.FontFamilyResult fetchFonts(Context context, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, null, fontRequest);
        }

        public void registerObserver(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader.class */
    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        EmojiCompat.MetadataRepoLoaderCallback f2787a;
        private final Context b;

        /* renamed from: c  reason: collision with root package name */
        private final FontRequest f2788c;
        private final FontProviderHelper d;
        private final Object e = new Object();
        private Handler f;
        private Executor g;
        private ThreadPoolExecutor h;
        private RetryPolicy i;
        private ContentObserver j;
        private Runnable k;

        FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
            this.b = context.getApplicationContext();
            this.f2788c = fontRequest;
            this.d = fontProviderHelper;
        }

        private void a(Uri uri, long j) {
            synchronized (this.e) {
                Handler handler = this.f;
                Handler handler2 = handler;
                if (handler == null) {
                    handler2 = ConcurrencyHelpers.a();
                    this.f = handler2;
                }
                if (this.j == null) {
                    ContentObserver contentObserver = new ContentObserver(handler2) { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1
                        @Override // android.database.ContentObserver
                        public void onChange(boolean z, Uri uri2) {
                            FontRequestMetadataLoader.this.a();
                        }
                    };
                    this.j = contentObserver;
                    this.d.registerObserver(this.b, uri, contentObserver);
                }
                if (this.k == null) {
                    this.k = new Runnable() { // from class: androidx.emoji2.text.-$$Lambda$beKeQOlp-OldrE4lAYQ_DZqqdPI
                        @Override // java.lang.Runnable
                        public final void run() {
                            FontRequestEmojiCompatConfig.FontRequestMetadataLoader.this.a();
                        }
                    };
                }
                handler2.postDelayed(this.k, j);
            }
        }

        private FontsContractCompat.FontInfo c() {
            try {
                FontsContractCompat.FontFamilyResult fetchFonts = this.d.fetchFonts(this.b, this.f2788c);
                if (fetchFonts.getStatusCode() == 0) {
                    FontsContractCompat.FontInfo[] fonts = fetchFonts.getFonts();
                    if (fonts == null || fonts.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return fonts[0];
                }
                throw new RuntimeException("fetchFonts failed (" + fetchFonts.getStatusCode() + ")");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        private void d() {
            synchronized (this.e) {
                this.f2787a = null;
                if (this.j != null) {
                    this.d.unregisterObserver(this.b, this.j);
                    this.j = null;
                }
                if (this.f != null) {
                    this.f.removeCallbacks(this.k);
                }
                this.f = null;
                if (this.h != null) {
                    this.h.shutdown();
                }
                this.g = null;
                this.h = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            synchronized (this.e) {
                if (this.f2787a == null) {
                    return;
                }
                if (this.g == null) {
                    ThreadPoolExecutor a2 = ConcurrencyHelpers.a("emojiCompat");
                    this.h = a2;
                    this.g = a2;
                }
                this.g.execute(new Runnable() { // from class: androidx.emoji2.text.-$$Lambda$bxg7EtAUPu0Sol5BnbTwJ7vXqNg
                    @Override // java.lang.Runnable
                    public final void run() {
                        FontRequestEmojiCompatConfig.FontRequestMetadataLoader.this.b();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            synchronized (this.e) {
                if (this.f2787a == null) {
                    return;
                }
                try {
                    FontsContractCompat.FontInfo c2 = c();
                    int resultCode = c2.getResultCode();
                    if (resultCode == 2) {
                        synchronized (this.e) {
                            if (this.i != null) {
                                long retryDelay = this.i.getRetryDelay();
                                if (retryDelay >= 0) {
                                    a(c2.getUri(), retryDelay);
                                    return;
                                }
                            }
                        }
                    }
                    if (resultCode != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + resultCode + ")");
                    }
                    TraceCompat.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                    Typeface buildTypeface = this.d.buildTypeface(this.b, c2);
                    ByteBuffer mmap = TypefaceCompatUtil.mmap(this.b, null, c2.getUri());
                    if (mmap == null || buildTypeface == null) {
                        throw new RuntimeException("Unable to open file.");
                    }
                    MetadataRepo create = MetadataRepo.create(buildTypeface, mmap);
                    TraceCompat.endSection();
                    synchronized (this.e) {
                        if (this.f2787a != null) {
                            this.f2787a.onLoaded(create);
                        }
                    }
                    d();
                } catch (Throwable th) {
                    synchronized (this.e) {
                        if (this.f2787a != null) {
                            this.f2787a.onFailed(th);
                        }
                        d();
                    }
                }
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.e) {
                this.f2787a = metadataRepoLoaderCallback;
            }
            a();
        }

        public void setExecutor(Executor executor) {
            synchronized (this.e) {
                this.g = executor;
            }
        }

        public void setRetryPolicy(RetryPolicy retryPolicy) {
            synchronized (this.e) {
                this.i = retryPolicy;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/FontRequestEmojiCompatConfig$RetryPolicy.class */
    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, j));
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, fontRequest, fontProviderHelper));
    }

    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(Handler handler) {
        if (handler == null) {
            return this;
        }
        setLoadingExecutor(ConcurrencyHelpers.a(handler));
        return this;
    }

    public FontRequestEmojiCompatConfig setLoadingExecutor(Executor executor) {
        ((FontRequestMetadataLoader) a()).setExecutor(executor);
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy retryPolicy) {
        ((FontRequestMetadataLoader) a()).setRetryPolicy(retryPolicy);
        return this;
    }
}
