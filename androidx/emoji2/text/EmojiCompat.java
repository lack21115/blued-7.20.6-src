package androidx.emoji2.text;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import androidx.emoji2.text.EmojiProcessor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat.class */
public class EmojiCompat {
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    private static final Object e = new Object();
    private static final Object f = new Object();
    private static volatile EmojiCompat g;
    private static volatile boolean h;

    /* renamed from: a  reason: collision with root package name */
    final MetadataRepoLoader f2812a;
    final boolean b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f2813c;
    final int[] d;
    private final CompatInternal m;
    private final boolean n;
    private final int o;
    private final int p;
    private final GlyphChecker q;
    private final ReadWriteLock i = new ReentrantReadWriteLock();
    private volatile int k = 3;
    private final Handler l = new Handler(Looper.getMainLooper());
    private final Set<InitCallback> j = new ArraySet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$CompatInternal.class */
    public static class CompatInternal {

        /* renamed from: a  reason: collision with root package name */
        final EmojiCompat f2814a;

        CompatInternal(EmojiCompat emojiCompat) {
            this.f2814a = emojiCompat;
        }

        CharSequence a(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return charSequence;
        }

        void a() {
            this.f2814a.a();
        }

        void a(EditorInfo editorInfo) {
        }

        boolean a(CharSequence charSequence) {
            return false;
        }

        boolean a(CharSequence charSequence, int i) {
            return false;
        }

        String b() {
            return "";
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$CompatInternal19.class */
    static final class CompatInternal19 extends CompatInternal {
        private volatile EmojiProcessor b;

        /* renamed from: c  reason: collision with root package name */
        private volatile MetadataRepo f2815c;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        CharSequence a(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return this.b.a(charSequence, i, i2, i3, z);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void a() {
            try {
                this.f2814a.f2812a.load(new MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompat.CompatInternal19.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onFailed(Throwable th) {
                        CompatInternal19.this.f2814a.a(th);
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onLoaded(MetadataRepo metadataRepo) {
                        CompatInternal19.this.a(metadataRepo);
                    }
                });
            } catch (Throwable th) {
                this.f2814a.a(th);
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void a(EditorInfo editorInfo) {
            editorInfo.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.f2815c.b());
            editorInfo.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.f2814a.b);
        }

        void a(MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.f2814a.a(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f2815c = metadataRepo;
            this.b = new EmojiProcessor(this.f2815c, new SpanFactory(), this.f2814a.q, this.f2814a.f2813c, this.f2814a.d);
            this.f2814a.a();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean a(CharSequence charSequence) {
            return this.b.a(charSequence) != null;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean a(CharSequence charSequence, int i) {
            EmojiMetadata a2 = this.b.a(charSequence);
            return a2 != null && a2.getCompatAdded() <= i;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        String b() {
            String sourceSha = this.f2815c.getMetadataList().sourceSha();
            String str = sourceSha;
            if (sourceSha == null) {
                str = "";
            }
            return str;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$Config.class */
    public static abstract class Config {

        /* renamed from: a  reason: collision with root package name */
        final MetadataRepoLoader f2817a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2818c;
        int[] d;
        Set<InitCallback> e;
        boolean f;
        int g = Color.GREEN;
        int h = 0;
        GlyphChecker i = new EmojiProcessor.DefaultGlyphChecker();

        /* JADX INFO: Access modifiers changed from: protected */
        public Config(MetadataRepoLoader metadataRepoLoader) {
            Preconditions.checkNotNull(metadataRepoLoader, "metadataLoader cannot be null.");
            this.f2817a = metadataRepoLoader;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final MetadataRepoLoader a() {
            return this.f2817a;
        }

        public Config registerInitCallback(InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.e == null) {
                this.e = new ArraySet();
            }
            this.e.add(initCallback);
            return this;
        }

        public Config setEmojiSpanIndicatorColor(int i) {
            this.g = i;
            return this;
        }

        public Config setEmojiSpanIndicatorEnabled(boolean z) {
            this.f = z;
            return this;
        }

        public Config setGlyphChecker(GlyphChecker glyphChecker) {
            Preconditions.checkNotNull(glyphChecker, "GlyphChecker cannot be null");
            this.i = glyphChecker;
            return this;
        }

        public Config setMetadataLoadStrategy(int i) {
            this.h = i;
            return this;
        }

        public Config setReplaceAll(boolean z) {
            this.b = z;
            return this;
        }

        public Config setUseEmojiAsDefaultStyle(boolean z) {
            return setUseEmojiAsDefaultStyle(z, null);
        }

        public Config setUseEmojiAsDefaultStyle(boolean z, List<Integer> list) {
            this.f2818c = z;
            if (!z || list == null) {
                this.d = null;
                return this;
            }
            this.d = new int[list.size()];
            int i = 0;
            for (Integer num : list) {
                this.d[i] = num.intValue();
                i++;
            }
            Arrays.sort(this.d);
            return this;
        }

        public Config unregisterInitCallback(InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            Set<InitCallback> set = this.e;
            if (set != null) {
                set.remove(initCallback);
            }
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$GlyphChecker.class */
    public interface GlyphChecker {
        boolean hasGlyph(CharSequence charSequence, int i, int i2, int i3);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$InitCallback.class */
    public static abstract class InitCallback {
        public void onFailed(Throwable th) {
        }

        public void onInitialized() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$ListenerDispatcher.class */
    public static class ListenerDispatcher implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List<InitCallback> f2819a;
        private final Throwable b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2820c;

        ListenerDispatcher(InitCallback initCallback, int i) {
            this(Arrays.asList((InitCallback) Preconditions.checkNotNull(initCallback, "initCallback cannot be null")), i, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i) {
            this(collection, i, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i, Throwable th) {
            Preconditions.checkNotNull(collection, "initCallbacks cannot be null");
            this.f2819a = new ArrayList(collection);
            this.f2820c = i;
            this.b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f2819a.size();
            if (this.f2820c == 1) {
                for (int i = 0; i < size; i++) {
                    this.f2819a.get(i).onInitialized();
                }
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return;
                }
                this.f2819a.get(i3).onFailed(this.b);
                i2 = i3 + 1;
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$LoadStrategy.class */
    public @interface LoadStrategy {
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$MetadataRepoLoader.class */
    public interface MetadataRepoLoader {
        void load(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$MetadataRepoLoaderCallback.class */
    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(Throwable th);

        public abstract void onLoaded(MetadataRepo metadataRepo);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$ReplaceStrategy.class */
    public @interface ReplaceStrategy {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiCompat$SpanFactory.class */
    public static class SpanFactory {
        SpanFactory() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EmojiSpan a(EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.emoji2.text.EmojiCompat$CompatInternal] */
    private EmojiCompat(Config config) {
        this.b = config.b;
        this.f2813c = config.f2818c;
        this.d = config.d;
        this.n = config.f;
        this.o = config.g;
        this.f2812a = config.f2817a;
        this.p = config.h;
        this.q = config.i;
        if (config.e != null && !config.e.isEmpty()) {
            this.j.addAll(config.e);
        }
        this.m = Build.VERSION.SDK_INT < 19 ? new CompatInternal(this) : new CompatInternal19(this);
        b();
    }

    private void b() {
        this.i.writeLock().lock();
        try {
            if (this.p == 0) {
                this.k = 0;
            }
            this.i.writeLock().unlock();
            if (getLoadState() == 0) {
                this.m.a();
            }
        } catch (Throwable th) {
            this.i.writeLock().unlock();
            throw th;
        }
    }

    private boolean c() {
        return getLoadState() == 1;
    }

    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        synchronized (e) {
            emojiCompat = g;
            Preconditions.checkState(emojiCompat != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            return EmojiProcessor.a(inputConnection, editable, i, i2, z);
        }
        return false;
    }

    public static boolean handleOnKeyDown(Editable editable, int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return EmojiProcessor.a(editable, i, keyEvent);
        }
        return false;
    }

    public static EmojiCompat init(Context context) {
        return init(context, null);
    }

    public static EmojiCompat init(Context context, DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory) {
        EmojiCompat emojiCompat;
        if (h) {
            return g;
        }
        if (defaultEmojiCompatConfigFactory == null) {
            defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
        }
        Config create = defaultEmojiCompatConfigFactory.create(context);
        synchronized (f) {
            if (!h) {
                if (create != null) {
                    init(create);
                }
                h = true;
            }
            emojiCompat = g;
        }
        return emojiCompat;
    }

    public static EmojiCompat init(Config config) {
        EmojiCompat emojiCompat;
        EmojiCompat emojiCompat2 = g;
        if (emojiCompat2 == null) {
            synchronized (e) {
                EmojiCompat emojiCompat3 = g;
                emojiCompat = emojiCompat3;
                if (emojiCompat3 == null) {
                    emojiCompat = new EmojiCompat(config);
                    g = emojiCompat;
                }
            }
            return emojiCompat;
        }
        return emojiCompat2;
    }

    public static boolean isConfigured() {
        return g != null;
    }

    public static EmojiCompat reset(Config config) {
        EmojiCompat emojiCompat;
        synchronized (e) {
            emojiCompat = new EmojiCompat(config);
            g = emojiCompat;
        }
        return emojiCompat;
    }

    public static EmojiCompat reset(EmojiCompat emojiCompat) {
        EmojiCompat emojiCompat2;
        synchronized (e) {
            g = emojiCompat;
            emojiCompat2 = g;
        }
        return emojiCompat2;
    }

    public static void skipDefaultConfigurationLookup(boolean z) {
        synchronized (f) {
            h = z;
        }
    }

    void a() {
        ArrayList arrayList = new ArrayList();
        this.i.writeLock().lock();
        try {
            this.k = 1;
            arrayList.addAll(this.j);
            this.j.clear();
            this.i.writeLock().unlock();
            this.l.post(new ListenerDispatcher(arrayList, this.k));
        } catch (Throwable th) {
            this.i.writeLock().unlock();
            throw th;
        }
    }

    void a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.i.writeLock().lock();
        try {
            this.k = 2;
            arrayList.addAll(this.j);
            this.j.clear();
            this.i.writeLock().unlock();
            this.l.post(new ListenerDispatcher(arrayList, this.k, th));
        } catch (Throwable th2) {
            this.i.writeLock().unlock();
            throw th2;
        }
    }

    public String getAssetSignature() {
        Preconditions.checkState(c(), "Not initialized yet");
        return this.m.b();
    }

    public int getEmojiSpanIndicatorColor() {
        return this.o;
    }

    public int getLoadState() {
        this.i.readLock().lock();
        try {
            return this.k;
        } finally {
            this.i.readLock().unlock();
        }
    }

    public boolean hasEmojiGlyph(CharSequence charSequence) {
        Preconditions.checkState(c(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.m.a(charSequence);
    }

    public boolean hasEmojiGlyph(CharSequence charSequence, int i) {
        Preconditions.checkState(c(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.m.a(charSequence, i);
    }

    public boolean isEmojiSpanIndicatorEnabled() {
        return this.n;
    }

    public void load() {
        boolean z = true;
        if (this.p != 1) {
            z = false;
        }
        Preconditions.checkState(z, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (c()) {
            return;
        }
        this.i.writeLock().lock();
        try {
            if (this.k == 0) {
                return;
            }
            this.k = 0;
            this.i.writeLock().unlock();
            this.m.a();
        } finally {
            this.i.writeLock().unlock();
        }
    }

    public CharSequence process(CharSequence charSequence) {
        return process(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence process(CharSequence charSequence, int i, int i2) {
        return process(charSequence, i, i2, Integer.MAX_VALUE);
    }

    public CharSequence process(CharSequence charSequence, int i, int i2, int i3) {
        return process(charSequence, i, i2, i3, 0);
    }

    public CharSequence process(CharSequence charSequence, int i, int i2, int i3, int i4) {
        Preconditions.checkState(c(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(i, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(i2, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(i3, "maxEmojiCount cannot be negative");
        Preconditions.checkArgument(i <= i2, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.checkArgument(i <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.checkArgument(i2 <= charSequence.length(), "end should be < than charSequence length");
        CharSequence charSequence2 = charSequence;
        if (charSequence.length() != 0) {
            if (i == i2) {
                return charSequence;
            }
            charSequence2 = this.m.a(charSequence, i, i2, i3, i4 != 1 ? i4 != 2 ? this.b : false : true);
        }
        return charSequence2;
    }

    public void registerInitCallback(InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.i.writeLock().lock();
        try {
            if (this.k != 1 && this.k != 2) {
                this.j.add(initCallback);
            }
            this.l.post(new ListenerDispatcher(initCallback, this.k));
        } finally {
            this.i.writeLock().unlock();
        }
    }

    public void unregisterInitCallback(InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.i.writeLock().lock();
        try {
            this.j.remove(initCallback);
        } finally {
            this.i.writeLock().unlock();
        }
    }

    public void updateEditorInfo(EditorInfo editorInfo) {
        if (!c() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.m.a(editorInfo);
    }
}
