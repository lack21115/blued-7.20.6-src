package android.graphics.pdf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import dalvik.system.CloseGuard;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/pdf/PdfDocument.class */
public class PdfDocument {
    private Page mCurrentPage;
    private final byte[] mChunk = new byte[4096];
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private final List<PageInfo> mPages = new ArrayList();
    private long mNativeDocument = nativeCreateDocument();

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/pdf/PdfDocument$Page.class */
    public static final class Page {
        private Canvas mCanvas;
        private final PageInfo mPageInfo;

        private Page(Canvas canvas, PageInfo pageInfo) {
            this.mCanvas = canvas;
            this.mPageInfo = pageInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void finish() {
            if (this.mCanvas != null) {
                this.mCanvas.release();
                this.mCanvas = null;
            }
        }

        public Canvas getCanvas() {
            return this.mCanvas;
        }

        public PageInfo getInfo() {
            return this.mPageInfo;
        }

        boolean isFinished() {
            return this.mCanvas == null;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/pdf/PdfDocument$PageInfo.class */
    public static final class PageInfo {
        private Rect mContentRect;
        private int mPageHeight;
        private int mPageNumber;
        private int mPageWidth;

        /* loaded from: source-9557208-dex2jar.jar:android/graphics/pdf/PdfDocument$PageInfo$Builder.class */
        public static final class Builder {
            private final PageInfo mPageInfo = new PageInfo();

            public Builder(int i, int i2, int i3) {
                if (i <= 0) {
                    throw new IllegalArgumentException("page width must be positive");
                }
                if (i2 <= 0) {
                    throw new IllegalArgumentException("page width must be positive");
                }
                if (i3 < 0) {
                    throw new IllegalArgumentException("pageNumber must be non negative");
                }
                this.mPageInfo.mPageWidth = i;
                this.mPageInfo.mPageHeight = i2;
                this.mPageInfo.mPageNumber = i3;
            }

            public PageInfo create() {
                if (this.mPageInfo.mContentRect == null) {
                    this.mPageInfo.mContentRect = new Rect(0, 0, this.mPageInfo.mPageWidth, this.mPageInfo.mPageHeight);
                }
                return this.mPageInfo;
            }

            public Builder setContentRect(Rect rect) {
                if (rect == null || (rect.left >= 0 && rect.top >= 0 && rect.right <= this.mPageInfo.mPageWidth && rect.bottom <= this.mPageInfo.mPageHeight)) {
                    this.mPageInfo.mContentRect = rect;
                    return this;
                }
                throw new IllegalArgumentException("contentRect does not fit the page");
            }
        }

        private PageInfo() {
        }

        public Rect getContentRect() {
            return this.mContentRect;
        }

        public int getPageHeight() {
            return this.mPageHeight;
        }

        public int getPageNumber() {
            return this.mPageNumber;
        }

        public int getPageWidth() {
            return this.mPageWidth;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/pdf/PdfDocument$PdfCanvas.class */
    private final class PdfCanvas extends Canvas {
        public PdfCanvas(long j) {
            super(j);
        }

        @Override // android.graphics.Canvas
        public void setBitmap(Bitmap bitmap) {
            throw new UnsupportedOperationException();
        }
    }

    public PdfDocument() {
        this.mCloseGuard.open("close");
    }

    private void dispose() {
        if (this.mNativeDocument != 0) {
            nativeClose(this.mNativeDocument);
            this.mCloseGuard.close();
            this.mNativeDocument = 0L;
        }
    }

    private native void nativeClose(long j);

    private native long nativeCreateDocument();

    private native void nativeFinishPage(long j);

    private static native long nativeStartPage(long j, int i, int i2, int i3, int i4, int i5, int i6);

    private native void nativeWriteTo(long j, OutputStream outputStream, byte[] bArr);

    private void throwIfClosed() {
        if (this.mNativeDocument == 0) {
            throw new IllegalStateException("document is closed!");
        }
    }

    private void throwIfCurrentPageNotFinished() {
        if (this.mCurrentPage != null) {
            throw new IllegalStateException("Current page not finished!");
        }
    }

    public void close() {
        throwIfCurrentPageNotFinished();
        dispose();
    }

    protected void finalize() throws Throwable {
        try {
            this.mCloseGuard.warnIfOpen();
            dispose();
        } finally {
            super.finalize();
        }
    }

    public void finishPage(Page page) {
        throwIfClosed();
        if (page == null) {
            throw new IllegalArgumentException("page cannot be null");
        }
        if (page != this.mCurrentPage) {
            throw new IllegalStateException("invalid page");
        }
        if (page.isFinished()) {
            throw new IllegalStateException("page already finished");
        }
        this.mPages.add(page.getInfo());
        this.mCurrentPage = null;
        nativeFinishPage(this.mNativeDocument);
        page.finish();
    }

    public List<PageInfo> getPages() {
        return Collections.unmodifiableList(this.mPages);
    }

    public Page startPage(PageInfo pageInfo) {
        throwIfClosed();
        throwIfCurrentPageNotFinished();
        if (pageInfo == null) {
            throw new IllegalArgumentException("page cannot be null");
        }
        this.mCurrentPage = new Page(new PdfCanvas(nativeStartPage(this.mNativeDocument, pageInfo.mPageWidth, pageInfo.mPageHeight, pageInfo.mContentRect.left, pageInfo.mContentRect.top, pageInfo.mContentRect.right, pageInfo.mContentRect.bottom)), pageInfo);
        return this.mCurrentPage;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        throwIfClosed();
        throwIfCurrentPageNotFinished();
        if (outputStream == null) {
            throw new IllegalArgumentException("out cannot be null!");
        }
        nativeWriteTo(this.mNativeDocument, outputStream, this.mChunk);
    }
}
