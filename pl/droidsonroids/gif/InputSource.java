package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource.class */
public abstract class InputSource {

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$AssetFileDescriptorSource.class */
    public static class AssetFileDescriptorSource extends InputSource {

        /* renamed from: a  reason: collision with root package name */
        private final AssetFileDescriptor f44155a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f44155a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$AssetSource.class */
    public static final class AssetSource extends InputSource {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f44156a;
        private final String b;

        public AssetSource(AssetManager assetManager, String str) {
            super();
            this.f44156a = assetManager;
            this.b = str;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f44156a.openFd(this.b));
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$ByteArraySource.class */
    public static final class ByteArraySource extends InputSource {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f44157a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.f44157a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$DirectByteBufferSource.class */
    public static final class DirectByteBufferSource extends InputSource {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f44158a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.f44158a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$FileDescriptorSource.class */
    public static final class FileDescriptorSource extends InputSource {

        /* renamed from: a  reason: collision with root package name */
        private final FileDescriptor f44159a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f44159a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$FileSource.class */
    public static final class FileSource extends InputSource {

        /* renamed from: a  reason: collision with root package name */
        private final String f44160a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.f44160a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$InputStreamSource.class */
    public static final class InputStreamSource extends InputSource {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f44161a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f44161a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$ResourcesSource.class */
    public static class ResourcesSource extends InputSource {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f44162a;
        private final int b;

        public ResourcesSource(Resources resources, int i) {
            super();
            this.f44162a = resources;
            this.b = i;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f44162a.openRawResourceFd(this.b));
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$UriSource.class */
    public static final class UriSource extends InputSource {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f44163a;
        private final Uri b;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return GifInfoHandle.a(this.f44163a, this.b);
        }
    }

    private InputSource() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract GifInfoHandle a() throws IOException;
}
