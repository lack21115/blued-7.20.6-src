package android.graphics.pdf;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.OsConstants;
import dalvik.system.CloseGuard;
import java.io.IOException;
import libcore.io.IoUtils;
import libcore.io.Libcore;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/pdf/PdfEditor.class */
public final class PdfEditor {
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private ParcelFileDescriptor mInput;
    private final long mNativeDocument;
    private int mPageCount;

    public PdfEditor(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        if (parcelFileDescriptor == null) {
            throw new NullPointerException("input cannot be null");
        }
        try {
            Libcore.os.lseek(parcelFileDescriptor.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
            long j = Libcore.os.fstat(parcelFileDescriptor.getFileDescriptor()).st_size;
            this.mInput = parcelFileDescriptor;
            this.mNativeDocument = nativeOpen(this.mInput.getFd(), j);
            this.mPageCount = nativeGetPageCount(this.mNativeDocument);
            this.mCloseGuard.open("close");
        } catch (ErrnoException e) {
            throw new IllegalArgumentException("file descriptor not seekable");
        }
    }

    private void doClose() {
        nativeClose(this.mNativeDocument);
        IoUtils.closeQuietly(this.mInput);
        this.mInput = null;
        this.mCloseGuard.close();
    }

    private static native void nativeClose(long j);

    private static native int nativeGetPageCount(long j);

    private static native boolean nativeGetPageCropBox(long j, int i, Rect rect);

    private static native boolean nativeGetPageMediaBox(long j, int i, Rect rect);

    private static native void nativeGetPageSize(long j, int i, Point point);

    private static native long nativeOpen(int i, long j);

    private static native int nativeRemovePage(long j, int i);

    private static native boolean nativeScaleForPrinting(long j);

    private static native void nativeSetPageCropBox(long j, int i, Rect rect);

    private static native void nativeSetPageMediaBox(long j, int i, Rect rect);

    private static native void nativeSetTransformAndClip(long j, int i, long j2, int i2, int i3, int i4, int i5);

    private static native void nativeWrite(long j, int i);

    private void throwIfClosed() {
        if (this.mInput == null) {
            throw new IllegalStateException("Already closed");
        }
    }

    private void throwIfCropBoxNull(Rect rect) {
        if (rect == null) {
            throw new NullPointerException("cropBox cannot be null");
        }
    }

    private void throwIfMediaBoxNull(Rect rect) {
        if (rect == null) {
            throw new NullPointerException("mediaBox cannot be null");
        }
    }

    private void throwIfNotNullAndNotAfine(Matrix matrix) {
        if (matrix != null && !matrix.isAffine()) {
            throw new IllegalStateException("Matrix must be afine");
        }
    }

    private void throwIfOutCropBoxNull(Rect rect) {
        if (rect == null) {
            throw new NullPointerException("outCropBox cannot be null");
        }
    }

    private void throwIfOutMediaBoxNull(Rect rect) {
        if (rect == null) {
            throw new NullPointerException("outMediaBox cannot be null");
        }
    }

    private void throwIfOutSizeNull(Point point) {
        if (point == null) {
            throw new NullPointerException("outSize cannot be null");
        }
    }

    private void throwIfPageNotInDocument(int i) {
        if (i < 0 || i >= this.mPageCount) {
            throw new IllegalArgumentException("Invalid page index");
        }
    }

    public void close() {
        throwIfClosed();
        doClose();
    }

    protected void finalize() throws Throwable {
        try {
            this.mCloseGuard.warnIfOpen();
            if (this.mInput != null) {
                doClose();
            }
        } finally {
            super.finalize();
        }
    }

    public int getPageCount() {
        throwIfClosed();
        return this.mPageCount;
    }

    public boolean getPageCropBox(int i, Rect rect) {
        throwIfClosed();
        throwIfOutCropBoxNull(rect);
        throwIfPageNotInDocument(i);
        return nativeGetPageCropBox(this.mNativeDocument, i, rect);
    }

    public boolean getPageMediaBox(int i, Rect rect) {
        throwIfClosed();
        throwIfOutMediaBoxNull(rect);
        throwIfPageNotInDocument(i);
        return nativeGetPageMediaBox(this.mNativeDocument, i, rect);
    }

    public void getPageSize(int i, Point point) {
        throwIfClosed();
        throwIfOutSizeNull(point);
        throwIfPageNotInDocument(i);
        nativeGetPageSize(this.mNativeDocument, i, point);
    }

    public void removePage(int i) {
        throwIfClosed();
        throwIfPageNotInDocument(i);
        this.mPageCount = nativeRemovePage(this.mNativeDocument, i);
    }

    public void setPageCropBox(int i, Rect rect) {
        throwIfClosed();
        throwIfCropBoxNull(rect);
        throwIfPageNotInDocument(i);
        nativeSetPageCropBox(this.mNativeDocument, i, rect);
    }

    public void setPageMediaBox(int i, Rect rect) {
        throwIfClosed();
        throwIfMediaBoxNull(rect);
        throwIfPageNotInDocument(i);
        nativeSetPageMediaBox(this.mNativeDocument, i, rect);
    }

    public void setTransformAndClip(int i, Matrix matrix, Rect rect) {
        throwIfClosed();
        throwIfPageNotInDocument(i);
        throwIfNotNullAndNotAfine(matrix);
        Matrix matrix2 = matrix;
        if (matrix == null) {
            matrix2 = Matrix.IDENTITY_MATRIX;
        }
        if (rect != null) {
            nativeSetTransformAndClip(this.mNativeDocument, i, matrix2.native_instance, rect.left, rect.top, rect.right, rect.bottom);
            return;
        }
        Point point = new Point();
        getPageSize(i, point);
        nativeSetTransformAndClip(this.mNativeDocument, i, matrix2.native_instance, 0, 0, point.x, point.y);
    }

    public boolean shouldScaleForPrinting() {
        throwIfClosed();
        return nativeScaleForPrinting(this.mNativeDocument);
    }

    public void write(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        try {
            throwIfClosed();
            nativeWrite(this.mNativeDocument, parcelFileDescriptor.getFd());
        } finally {
            IoUtils.closeQuietly(parcelFileDescriptor);
        }
    }
}
