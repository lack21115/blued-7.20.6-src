package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/Glide.class */
public class Glide implements ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Glide f20645a;
    private static volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final Engine f20646c;
    private final BitmapPool d;
    private final MemoryCache e;
    private final GlideContext f;
    private final Registry g;
    private final ArrayPool h;
    private final RequestManagerRetriever i;
    private final ConnectivityMonitorFactory j;
    private final RequestOptionsFactory l;
    private final List<RequestManager> k = new ArrayList();
    private MemoryCategory m = MemoryCategory.NORMAL;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/Glide$RequestOptionsFactory.class */
    public interface RequestOptionsFactory {
        RequestOptions a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v133, types: [com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder] */
    /* JADX WARN: Type inference failed for: r0v134, types: [com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder] */
    public Glide(Context context, Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, ArrayPool arrayPool, RequestManagerRetriever requestManagerRetriever, ConnectivityMonitorFactory connectivityMonitorFactory, int i, RequestOptionsFactory requestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, boolean z, boolean z2) {
        ByteBufferBitmapDecoder byteBufferBitmapDecoder;
        StreamBitmapDecoder streamBitmapDecoder;
        this.f20646c = engine;
        this.d = bitmapPool;
        this.h = arrayPool;
        this.e = memoryCache;
        this.i = requestManagerRetriever;
        this.j = connectivityMonitorFactory;
        this.l = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.g = registry;
        registry.a((ImageHeaderParser) new DefaultImageHeaderParser());
        if (Build.VERSION.SDK_INT >= 27) {
            this.g.a((ImageHeaderParser) new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> a2 = this.g.a();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, a2, bitmapPool, arrayPool);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> b2 = VideoDecoder.b(bitmapPool);
        Downsampler downsampler = new Downsampler(this.g.a(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        if (!z2 || Build.VERSION.SDK_INT < 28) {
            byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
            streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool);
        } else {
            streamBitmapDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        this.g.a(ByteBuffer.class, new ByteBufferEncoder()).a(InputStream.class, new StreamEncoder(arrayPool)).a("Bitmap", ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).a("Bitmap", InputStream.class, Bitmap.class, streamBitmapDecoder);
        if (ParcelFileDescriptorRewinder.c()) {
            this.g.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        this.g.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b2).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.a(bitmapPool)).a(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.b()).a("Bitmap", Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).a(Bitmap.class, (ResourceEncoder) bitmapEncoder).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, b2)).a(BitmapDrawable.class, (ResourceEncoder) new BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).a("Gif", InputStream.class, GifDrawable.class, new StreamGifDecoder(a2, byteBufferGifDecoder, arrayPool)).a("Gif", ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).a(GifDrawable.class, (ResourceEncoder) new GifDrawableEncoder()).a(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.b()).a("Bitmap", GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool)).a(Uri.class, Drawable.class, resourceDrawableDecoder).a(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).a((DataRewinder.Factory<?>) new ByteBufferRewinder.Factory()).a(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).a(File.class, InputStream.class, new FileLoader.StreamFactory()).a(File.class, File.class, new FileDecoder()).a(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).a(File.class, File.class, UnitModelLoader.Factory.b()).a((DataRewinder.Factory<?>) new InputStreamRewinder.Factory(arrayPool));
        if (ParcelFileDescriptorRewinder.c()) {
            this.g.a((DataRewinder.Factory<?>) new ParcelFileDescriptorRewinder.Factory());
        }
        this.g.a(Integer.TYPE, InputStream.class, streamFactory).a(Integer.TYPE, ParcelFileDescriptor.class, fileDescriptorFactory).a(Integer.class, InputStream.class, streamFactory).a(Integer.class, ParcelFileDescriptor.class, fileDescriptorFactory).a(Integer.class, Uri.class, uriFactory).a(Integer.TYPE, AssetFileDescriptor.class, assetFileDescriptorFactory).a(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory).a(Integer.TYPE, Uri.class, uriFactory).a(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).a(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).a(String.class, InputStream.class, new StringLoader.StreamFactory()).a(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).a(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).a(Uri.class, InputStream.class, new HttpUriLoader.Factory()).a(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).a(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context)).a(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        if (Build.VERSION.SDK_INT >= 29) {
            this.g.a(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
            this.g.a(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        this.g.a(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver)).a(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).a(URL.class, InputStream.class, new UrlLoader.StreamFactory()).a(Uri.class, File.class, new MediaStoreFileLoader.Factory(context)).a(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).a(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).a(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).a(Uri.class, Uri.class, UnitModelLoader.Factory.b()).a(Drawable.class, Drawable.class, UnitModelLoader.Factory.b()).a(Drawable.class, Drawable.class, new UnitDrawableDecoder()).a(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).a(Bitmap.class, byte[].class, bitmapBytesTranscoder).a(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).a(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        if (Build.VERSION.SDK_INT >= 23) {
            ResourceDecoder<ByteBuffer, Bitmap> c2 = VideoDecoder.c(bitmapPool);
            this.g.a(ByteBuffer.class, Bitmap.class, c2);
            this.g.a(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, c2));
        }
        this.f = new GlideContext(context, arrayPool, this.g, new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, z, i);
    }

    public static Glide a(Context context) {
        if (f20645a == null) {
            GeneratedAppGlideModule c2 = c(context.getApplicationContext());
            synchronized (Glide.class) {
                try {
                    if (f20645a == null) {
                        a(context, c2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f20645a;
    }

    public static RequestManager a(Activity activity) {
        return d(activity).a(activity);
    }

    public static RequestManager a(Fragment fragment) {
        return d(fragment.getContext()).a(fragment);
    }

    public static RequestManager a(FragmentActivity fragmentActivity) {
        return d(fragmentActivity).a(fragmentActivity);
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (b) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        b = true;
        b(context, generatedAppGlideModule);
        b = false;
    }

    private static void a(Context context, GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new ManifestParser(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.a().isEmpty()) {
            Set<Class<?>> a2 = generatedAppGlideModule.a();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (a2.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (GlideModule glideModule : emptyList) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + glideModule.getClass());
            }
        }
        glideBuilder.a(generatedAppGlideModule != null ? generatedAppGlideModule.b() : null);
        for (GlideModule glideModule2 : emptyList) {
            glideModule2.a(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, glideBuilder);
        }
        Glide a3 = glideBuilder.a(applicationContext);
        for (GlideModule glideModule3 : emptyList) {
            try {
                glideModule3.a(applicationContext, a3, a3.g);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule3.getClass().getName(), e);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a3, a3.g);
        }
        applicationContext.registerComponentCallbacks(a3);
        f20645a = a3;
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static RequestManager b(Context context) {
        return d(context).a(context);
    }

    private static void b(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        a(context, new GlideBuilder(), generatedAppGlideModule);
    }

    private static GeneratedAppGlideModule c(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException e) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                return null;
            }
            return null;
        } catch (IllegalAccessException e2) {
            a(e2);
            return null;
        } catch (InstantiationException e3) {
            a(e3);
            return null;
        } catch (NoSuchMethodException e4) {
            a(e4);
            return null;
        } catch (InvocationTargetException e5) {
            a(e5);
            return null;
        }
    }

    private static RequestManagerRetriever d(Context context) {
        Preconditions.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).g();
    }

    public BitmapPool a() {
        return this.d;
    }

    public void a(int i) {
        Util.a();
        for (RequestManager requestManager : this.k) {
            requestManager.onTrimMemory(i);
        }
        this.e.a(i);
        this.d.a(i);
        this.h.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RequestManager requestManager) {
        synchronized (this.k) {
            if (this.k.contains(requestManager)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.k.add(requestManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Target<?> target) {
        synchronized (this.k) {
            Iterator<RequestManager> it = this.k.iterator();
            do {
                if (!it.hasNext()) {
                    return false;
                }
            } while (!it.next().b(target));
            return true;
        }
    }

    public ArrayPool b() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RequestManager requestManager) {
        synchronized (this.k) {
            if (!this.k.contains(requestManager)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.k.remove(requestManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectivityMonitorFactory c() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GlideContext d() {
        return this.f;
    }

    public void e() {
        Util.a();
        this.e.c();
        this.d.a();
        this.h.a();
    }

    public void f() {
        Util.b();
        this.f20646c.a();
    }

    public RequestManagerRetriever g() {
        return this.i;
    }

    public Context getContext() {
        return this.f.getBaseContext();
    }

    public Registry h() {
        return this.g;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        e();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        a(i);
    }
}
