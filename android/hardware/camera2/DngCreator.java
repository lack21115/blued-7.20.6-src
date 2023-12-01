package android.hardware.camera2;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.location.Location;
import android.media.Image;
import android.os.SystemClock;
import android.text.format.Time;
import android.util.Size;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/DngCreator.class */
public final class DngCreator implements AutoCloseable {
    private static final int BYTES_PER_RGB_PIX = 3;
    private static final int DEFAULT_PIXEL_STRIDE = 2;
    private static final String GPS_LAT_REF_NORTH = "N";
    private static final String GPS_LAT_REF_SOUTH = "S";
    private static final String GPS_LONG_REF_EAST = "E";
    private static final String GPS_LONG_REF_WEST = "W";
    public static final int MAX_THUMBNAIL_DIMENSION = 256;
    private static final String TAG = "DngCreator";
    private final Calendar mGPSTimeStampCalendar = Calendar.getInstance(TimeZone.getTimeZone(Time.TIMEZONE_UTC));
    private long mNativeContext;
    private static final String GPS_DATE_FORMAT_STR = "yyyy:MM:dd";
    private static final DateFormat sExifGPSDateStamp = new SimpleDateFormat(GPS_DATE_FORMAT_STR);
    private static final String TIFF_DATETIME_FORMAT = "yyyy:MM:dd kk:mm:ss";
    private static final DateFormat sDateTimeStampFormat = new SimpleDateFormat(TIFF_DATETIME_FORMAT);

    static {
        sDateTimeStampFormat.setTimeZone(TimeZone.getDefault());
        sExifGPSDateStamp.setTimeZone(TimeZone.getTimeZone(Time.TIMEZONE_UTC));
        nativeClassInit();
    }

    public DngCreator(CameraCharacteristics cameraCharacteristics, CaptureResult captureResult) {
        if (cameraCharacteristics == null || captureResult == null) {
            throw new IllegalArgumentException("Null argument to DngCreator constructor");
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l = (Long) captureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        nativeInit(cameraCharacteristics.getNativeCopy(), captureResult.getNativeCopy(), sDateTimeStampFormat.format(Long.valueOf(l != null ? (l.longValue() / 1000000) + (currentTimeMillis - elapsedRealtime) : currentTimeMillis)));
    }

    private static void colorToRgb(int i, int i2, byte[] bArr) {
        bArr[i2] = (byte) Color.red(i);
        bArr[i2 + 1] = (byte) Color.green(i);
        bArr[i2 + 2] = (byte) Color.blue(i);
    }

    private static ByteBuffer convertToRGB(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * 3 * height);
        int[] iArr = new int[width];
        byte[] bArr = new byte[width * 3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= height) {
                allocateDirect.rewind();
                return allocateDirect;
            }
            bitmap.getPixels(iArr, 0, width, 0, i2, width, 1);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < width) {
                    colorToRgb(iArr[i4], i4 * 3, bArr);
                    i3 = i4 + 1;
                }
            }
            allocateDirect.put(bArr);
            i = i2 + 1;
        }
    }

    private static ByteBuffer convertToRGB(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * 3 * height);
        Image.Plane plane = image.getPlanes()[0];
        Image.Plane plane2 = image.getPlanes()[1];
        Image.Plane plane3 = image.getPlanes()[2];
        ByteBuffer buffer = plane.getBuffer();
        ByteBuffer buffer2 = plane2.getBuffer();
        ByteBuffer buffer3 = plane3.getBuffer();
        buffer.rewind();
        buffer2.rewind();
        buffer3.rewind();
        int rowStride = plane.getRowStride();
        int rowStride2 = plane3.getRowStride();
        int rowStride3 = plane2.getRowStride();
        int pixelStride = plane.getPixelStride();
        int pixelStride2 = plane3.getPixelStride();
        int pixelStride3 = plane2.getPixelStride();
        byte[] bArr = {0, 0, 0};
        byte[] bArr2 = new byte[((width - 1) * pixelStride) + 1];
        byte[] bArr3 = new byte[(((width / 2) - 1) * pixelStride3) + 1];
        byte[] bArr4 = new byte[(((width / 2) - 1) * pixelStride2) + 1];
        byte[] bArr5 = new byte[width * 3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= height) {
                buffer.rewind();
                buffer2.rewind();
                buffer3.rewind();
                allocateDirect.rewind();
                return allocateDirect;
            }
            int i3 = i2 / 2;
            buffer.position(rowStride * i2);
            buffer.get(bArr2);
            buffer2.position(rowStride3 * i3);
            buffer2.get(bArr3);
            buffer3.position(rowStride2 * i3);
            buffer3.get(bArr4);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < width) {
                    int i6 = i5 / 2;
                    bArr[0] = bArr2[pixelStride * i5];
                    bArr[1] = bArr3[pixelStride3 * i6];
                    bArr[2] = bArr4[pixelStride2 * i6];
                    yuvToRgb(bArr, i5 * 3, bArr5);
                    i4 = i5 + 1;
                }
            }
            allocateDirect.put(bArr5);
            i = i2 + 1;
        }
    }

    private static native void nativeClassInit();

    private native synchronized void nativeDestroy();

    private native synchronized void nativeInit(CameraMetadataNative cameraMetadataNative, CameraMetadataNative cameraMetadataNative2, String str);

    private native synchronized void nativeSetDescription(String str);

    private native synchronized void nativeSetGpsTags(int[] iArr, String str, int[] iArr2, String str2, String str3, int[] iArr3);

    private native synchronized void nativeSetOrientation(int i);

    private native synchronized void nativeSetThumbnail(ByteBuffer byteBuffer, int i, int i2);

    private native synchronized void nativeWriteImage(OutputStream outputStream, int i, int i2, ByteBuffer byteBuffer, int i3, int i4, long j, boolean z) throws IOException;

    private native synchronized void nativeWriteInputStream(OutputStream outputStream, InputStream inputStream, int i, int i2, long j) throws IOException;

    private static int[] toExifLatLong(double d) {
        double abs = Math.abs(d);
        int i = (int) abs;
        double d2 = (abs - i) * 60.0d;
        int i2 = (int) d2;
        return new int[]{i, 1, i2, 1, (int) ((d2 - i2) * 6000.0d), 100};
    }

    private void writeByteBuffer(int i, int i2, ByteBuffer byteBuffer, OutputStream outputStream, int i3, int i4, long j) throws IOException {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Image with invalid width, height: (" + i + "," + i2 + ") passed to write");
        }
        long capacity = byteBuffer.capacity();
        long j2 = (i4 * i2) + j;
        if (capacity < j2) {
            throw new IllegalArgumentException("Image size " + capacity + " is too small (must be larger than " + j2 + ")");
        }
        int i5 = i3 * i;
        if (i5 > i4) {
            throw new IllegalArgumentException("Invalid image pixel stride, row byte width " + i5 + " is too large, expecting " + i4);
        }
        byteBuffer.clear();
        nativeWriteImage(outputStream, i, i2, byteBuffer, i4, i3, j, byteBuffer.isDirect());
        byteBuffer.clear();
    }

    private static void yuvToRgb(byte[] bArr, int i, byte[] bArr2) {
        float f = bArr[0] & 255;
        float f2 = bArr[1] & 255;
        float f3 = bArr[2] & 255;
        bArr2[i] = (byte) Math.max(0.0f, Math.min(255.0f, f + (1.402f * (f3 - 128.0f))));
        bArr2[i + 1] = (byte) Math.max(0.0f, Math.min(255.0f, (f - (0.34414f * (f2 - 128.0f))) - (0.71414f * (f3 - 128.0f))));
        bArr2[i + 2] = (byte) Math.max(0.0f, Math.min(255.0f, f + (1.772f * (f2 - 128.0f))));
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        nativeDestroy();
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public DngCreator setDescription(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null description passed to setDescription.");
        }
        nativeSetDescription(str);
        return this;
    }

    public DngCreator setLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Null location passed to setLocation");
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        long time = location.getTime();
        int[] exifLatLong = toExifLatLong(latitude);
        int[] exifLatLong2 = toExifLatLong(longitude);
        String str = latitude >= 0.0d ? "N" : "S";
        String str2 = longitude >= 0.0d ? "E" : "W";
        String format = sExifGPSDateStamp.format(Long.valueOf(time));
        this.mGPSTimeStampCalendar.setTimeInMillis(time);
        nativeSetGpsTags(exifLatLong, str, exifLatLong2, str2, format, new int[]{this.mGPSTimeStampCalendar.get(11), 1, this.mGPSTimeStampCalendar.get(12), 1, this.mGPSTimeStampCalendar.get(13), 1});
        return this;
    }

    public DngCreator setOrientation(int i) {
        if (i < 0 || i > 8) {
            throw new IllegalArgumentException("Orientation " + i + " is not a valid EXIF orientation value");
        }
        nativeSetOrientation(i);
        return this;
    }

    public DngCreator setThumbnail(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("Null argument to setThumbnail");
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 256 || height > 256) {
            throw new IllegalArgumentException("Thumbnail dimensions width,height (" + width + "," + height + ") too large, dimensions must be smaller than 256");
        }
        nativeSetThumbnail(convertToRGB(bitmap), width, height);
        return this;
    }

    public DngCreator setThumbnail(Image image) {
        if (image == null) {
            throw new IllegalArgumentException("Null argument to setThumbnail");
        }
        int format = image.getFormat();
        if (format != 35) {
            throw new IllegalArgumentException("Unsupported Image format " + format);
        }
        int width = image.getWidth();
        int height = image.getHeight();
        if (width > 256 || height > 256) {
            throw new IllegalArgumentException("Thumbnail dimensions width,height (" + width + "," + height + ") too large, dimensions must be smaller than 256");
        }
        nativeSetThumbnail(convertToRGB(image), width, height);
        return this;
    }

    public void writeByteBuffer(OutputStream outputStream, Size size, ByteBuffer byteBuffer, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Null dngOutput passed to writeByteBuffer");
        }
        if (size == null) {
            throw new IllegalArgumentException("Null size passed to writeByteBuffer");
        }
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Null pixels passed to writeByteBuffer");
        }
        if (j < 0) {
            throw new IllegalArgumentException("Negative offset passed to writeByteBuffer");
        }
        int width = size.getWidth();
        writeByteBuffer(width, size.getHeight(), byteBuffer, outputStream, 2, width * 2, j);
    }

    public void writeImage(OutputStream outputStream, Image image) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Null dngOutput to writeImage");
        }
        if (image == null) {
            throw new IllegalArgumentException("Null pixels to writeImage");
        }
        int format = image.getFormat();
        if (format != 32) {
            throw new IllegalArgumentException("Unsupported image format " + format);
        }
        Image.Plane[] planes = image.getPlanes();
        if (planes == null || planes.length <= 0) {
            throw new IllegalArgumentException("Image with no planes passed to writeImage");
        }
        writeByteBuffer(image.getWidth(), image.getHeight(), planes[0].getBuffer(), outputStream, planes[0].getPixelStride(), planes[0].getRowStride(), 0L);
    }

    public void writeInputStream(OutputStream outputStream, Size size, InputStream inputStream, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Null dngOutput passed to writeInputStream");
        }
        if (size == null) {
            throw new IllegalArgumentException("Null size passed to writeInputStream");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("Null pixels passed to writeInputStream");
        }
        if (j < 0) {
            throw new IllegalArgumentException("Negative offset passed to writeInputStream");
        }
        int width = size.getWidth();
        int height = size.getHeight();
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Size with invalid width, height: (" + width + "," + height + ") passed to writeInputStream");
        }
        nativeWriteInputStream(outputStream, inputStream, width, height, j);
    }
}
