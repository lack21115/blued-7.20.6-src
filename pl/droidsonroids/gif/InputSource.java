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
        private final AssetFileDescriptor a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$AssetSource.class */
    public static final class AssetSource extends InputSource {
        private final AssetManager a;
        private final String b;

        public AssetSource(AssetManager assetManager, String str) {
            super();
            this.a = assetManager;
            this.b = str;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a.openFd(this.b));
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$ByteArraySource.class */
    public static final class ByteArraySource extends InputSource {
        private final byte[] a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$DirectByteBufferSource.class */
    public static final class DirectByteBufferSource extends InputSource {
        private final ByteBuffer a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$FileDescriptorSource.class */
    public static final class FileDescriptorSource extends InputSource {
        private final FileDescriptor a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$FileSource.class */
    public static final class FileSource extends InputSource {
        private final String a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$InputStreamSource.class */
    public static final class InputStreamSource extends InputSource {
        private final InputStream a;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$ResourcesSource.class */
    public static class ResourcesSource extends InputSource {
        private final Resources a;
        private final int b;

        public ResourcesSource(Resources resources, int i) {
            super();
            this.a = resources;
            this.b = i;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a.openRawResourceFd(this.b));
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InputSource$UriSource.class */
    public static final class UriSource extends InputSource {
        private final ContentResolver a;
        private final Uri b;

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle a() throws IOException {
            return GifInfoHandle.a(this.a, this.b);
        }
    }

    private InputSource() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract GifInfoHandle a() throws IOException;
}
