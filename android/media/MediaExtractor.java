package android.media;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.IBinder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaExtractor.class */
public final class MediaExtractor {
    public static final int SAMPLE_FLAG_ENCRYPTED = 2;
    public static final int SAMPLE_FLAG_SYNC = 1;
    public static final int SEEK_TO_CLOSEST_SYNC = 2;
    public static final int SEEK_TO_NEXT_SYNC = 1;
    public static final int SEEK_TO_PREVIOUS_SYNC = 0;
    private long mNativeContext;

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    public MediaExtractor() {
        native_setup();
    }

    private native Map<String, Object> getFileFormatNative();

    private native Map<String, Object> getTrackFormatNative(int i);

    private final native void nativeSetDataSource(IBinder iBinder, String str, String[] strArr, String[] strArr2) throws IOException;

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup();

    public native boolean advance();

    protected void finalize() {
        native_finalize();
    }

    public native long getCachedDuration();

    public Map<UUID, byte[]> getPsshInfo() {
        Map<String, Object> fileFormatNative = getFileFormatNative();
        HashMap hashMap = null;
        if (fileFormatNative != null) {
            hashMap = null;
            if (fileFormatNative.containsKey("pssh")) {
                ByteBuffer byteBuffer = (ByteBuffer) fileFormatNative.get("pssh");
                byteBuffer.order(ByteOrder.nativeOrder());
                byteBuffer.rewind();
                fileFormatNative.remove("pssh");
                HashMap hashMap2 = new HashMap();
                while (true) {
                    hashMap = hashMap2;
                    if (byteBuffer.remaining() <= 0) {
                        break;
                    }
                    byteBuffer.order(ByteOrder.BIG_ENDIAN);
                    UUID uuid = new UUID(byteBuffer.getLong(), byteBuffer.getLong());
                    byteBuffer.order(ByteOrder.nativeOrder());
                    byte[] bArr = new byte[byteBuffer.getInt()];
                    byteBuffer.get(bArr);
                    hashMap2.put(uuid, bArr);
                }
            }
        }
        return hashMap;
    }

    public native boolean getSampleCryptoInfo(MediaCodec.CryptoInfo cryptoInfo);

    public native int getSampleFlags();

    public native long getSampleTime();

    public native int getSampleTrackIndex();

    public final native int getTrackCount();

    public MediaFormat getTrackFormat(int i) {
        return new MediaFormat(getTrackFormatNative(i));
    }

    public native boolean hasCacheReachedEndOfStream();

    public native int readSampleData(ByteBuffer byteBuffer, int i);

    public final native void release();

    public native void seekTo(long j, int i);

    public native void selectTrack(int i);

    public final void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equals(ContentResolver.SCHEME_FILE)) {
            setDataSource(uri.getPath());
            return;
        }
        AutoCloseable autoCloseable = null;
        AutoCloseable autoCloseable2 = null;
        AutoCloseable autoCloseable3 = null;
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (openAssetFileDescriptor == null) {
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                    return;
                }
                return;
            }
            if (openAssetFileDescriptor.getDeclaredLength() < 0) {
                setDataSource(openAssetFileDescriptor.getFileDescriptor());
            } else {
                setDataSource(openAssetFileDescriptor.getFileDescriptor(), openAssetFileDescriptor.getStartOffset(), openAssetFileDescriptor.getDeclaredLength());
            }
            if (openAssetFileDescriptor != null) {
                openAssetFileDescriptor.close();
            }
        } catch (IOException e) {
            if (0 != 0) {
                autoCloseable.close();
            }
            setDataSource(uri.toString(), map);
        } catch (SecurityException e2) {
            if (0 != 0) {
                autoCloseable3.close();
            }
            setDataSource(uri.toString(), map);
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable2.close();
            }
            throw th;
        }
    }

    public final native void setDataSource(DataSource dataSource) throws IOException;

    public final void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        setDataSource(fileDescriptor, 0L, 576460752303423487L);
    }

    public final native void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException;

    public final void setDataSource(String str) throws IOException {
        nativeSetDataSource(MediaHTTPService.createHttpServiceBinderIfNecessary(str), str, null, null);
    }

    public final void setDataSource(String str, Map<String, String> map) throws IOException {
        String[] strArr = null;
        String[] strArr2 = null;
        if (map != null) {
            String[] strArr3 = new String[map.size()];
            String[] strArr4 = new String[map.size()];
            int i = 0;
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                strArr = strArr3;
                strArr2 = strArr4;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                strArr3[i] = next.getKey();
                strArr4[i] = next.getValue();
                i++;
            }
        }
        nativeSetDataSource(MediaHTTPService.createHttpServiceBinderIfNecessary(str), str, strArr, strArr2);
    }

    public native void unselectTrack(int i);
}
