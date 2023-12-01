package android.graphics.pdf;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.OsConstants;
import dalvik.system.CloseGuard;
import java.io.IOException;
import libcore.io.Libcore;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/pdf/PdfRenderer.class */
public final class PdfRenderer implements AutoCloseable {
    private Page mCurrentPage;
    private ParcelFileDescriptor mInput;
    private final long mNativeDocument;
    private final int mPageCount;
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private final Point mTempPoint = new Point();

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/pdf/PdfRenderer$Page.class */
    public final class Page implements AutoCloseable {
        public static final int RENDER_MODE_FOR_DISPLAY = 1;
        public static final int RENDER_MODE_FOR_PRINT = 2;
        private final CloseGuard mCloseGuard;
        private final int mHeight;
        private final int mIndex;
        private long mNativePage;
        private final int mWidth;

        private Page(int i) {
            this.mCloseGuard = CloseGuard.get();
            Point point = PdfRenderer.this.mTempPoint;
            this.mNativePage = PdfRenderer.nativeOpenPageAndGetSize(PdfRenderer.this.mNativeDocument, i, point);
            this.mIndex = i;
            this.mWidth = point.x;
            this.mHeight = point.y;
            this.mCloseGuard.open("close");
        }

        private void doClose() {
            PdfRenderer.nativeClosePage(this.mNativePage);
            this.mNativePage = 0L;
            this.mCloseGuard.close();
            PdfRenderer.this.mCurrentPage = null;
        }

        private void throwIfClosed() {
            if (this.mNativePage == 0) {
                throw new IllegalStateException("Already closed");
            }
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            throwIfClosed();
            doClose();
        }

        protected void finalize() throws Throwable {
            try {
                this.mCloseGuard.warnIfOpen();
                if (this.mNativePage != 0) {
                    doClose();
                }
            } finally {
                super.finalize();
            }
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public void render(Bitmap bitmap, Rect rect, Matrix matrix, int i) {
            if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                throw new IllegalArgumentException("Unsupported pixel format");
            }
            if (rect != null && (rect.left < 0 || rect.top < 0 || rect.right > bitmap.getWidth() || rect.bottom > bitmap.getHeight())) {
                throw new IllegalArgumentException("destBounds not in destination");
            }
            if (matrix != null && !matrix.isAffine()) {
                throw new IllegalArgumentException("transform not affine");
            }
            if (i != 2 && i != 1) {
                throw new IllegalArgumentException("Unsupported render mode");
            }
            if (i == 2 && i == 1) {
                throw new IllegalArgumentException("Only single render mode supported");
            }
            PdfRenderer.nativeRenderPage(PdfRenderer.this.mNativeDocument, this.mNativePage, bitmap.mNativeBitmap, rect != null ? rect.left : 0, rect != null ? rect.top : 0, rect != null ? rect.right : bitmap.getWidth(), rect != null ? rect.bottom : bitmap.getHeight(), matrix != null ? matrix.native_instance : 0L, i);
        }
    }

    public PdfRenderer(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        if (parcelFileDescriptor == null) {
            throw new NullPointerException("input cannot be null");
        }
        try {
            Libcore.os.lseek(parcelFileDescriptor.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
            long j = Libcore.os.fstat(parcelFileDescriptor.getFileDescriptor()).st_size;
            this.mInput = parcelFileDescriptor;
            this.mNativeDocument = nativeCreate(this.mInput.getFd(), j);
            this.mPageCount = nativeGetPageCount(this.mNativeDocument);
            this.mCloseGuard.open("close");
        } catch (ErrnoException e) {
            throw new IllegalArgumentException("file descriptor not seekable");
        }
    }

    private void doClose() {
        if (this.mCurrentPage != null) {
            this.mCurrentPage.close();
        }
        nativeClose(this.mNativeDocument);
        try {
            this.mInput.close();
        } catch (IOException e) {
        }
        this.mInput = null;
        this.mCloseGuard.close();
    }

    private static native void nativeClose(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeClosePage(long j);

    private static native long nativeCreate(int i, long j);

    private static native int nativeGetPageCount(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeOpenPageAndGetSize(long j, int i, Point point);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRenderPage(long j, long j2, long j3, int i, int i2, int i3, int i4, long j4, int i5);

    private static native boolean nativeScaleForPrinting(long j);

    private void throwIfClosed() {
        if (this.mInput == null) {
            throw new IllegalStateException("Already closed");
        }
    }

    private void throwIfPageNotInDocument(int i) {
        if (i < 0 || i >= this.mPageCount) {
            throw new IllegalArgumentException("Invalid page index");
        }
    }

    private void throwIfPageOpened() {
        if (this.mCurrentPage != null) {
            throw new IllegalStateException("Current page not closed");
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        throwIfClosed();
        throwIfPageOpened();
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

    public Page openPage(int i) {
        throwIfClosed();
        throwIfPageOpened();
        throwIfPageNotInDocument(i);
        this.mCurrentPage = new Page(i);
        return this.mCurrentPage;
    }

    public boolean shouldScaleForPrinting() {
        throwIfClosed();
        return nativeScaleForPrinting(this.mNativeDocument);
    }
}
