package android.print.pdf;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.print.PrintAttributes;

/* loaded from: source-9557208-dex2jar.jar:android/print/pdf/PrintedPdfDocument.class */
public class PrintedPdfDocument extends PdfDocument {
    private static final int MILS_PER_INCH = 1000;
    private static final int POINTS_IN_INCH = 72;
    private final Rect mContentRect;
    private final int mPageHeight;
    private final int mPageWidth;

    public PrintedPdfDocument(Context context, PrintAttributes printAttributes) {
        PrintAttributes.MediaSize mediaSize = printAttributes.getMediaSize();
        this.mPageWidth = (int) ((mediaSize.getWidthMils() / 1000.0f) * 72.0f);
        this.mPageHeight = (int) ((mediaSize.getHeightMils() / 1000.0f) * 72.0f);
        PrintAttributes.Margins minMargins = printAttributes.getMinMargins();
        this.mContentRect = new Rect((int) ((minMargins.getLeftMils() / 1000.0f) * 72.0f), (int) ((minMargins.getTopMils() / 1000.0f) * 72.0f), this.mPageWidth - ((int) ((minMargins.getRightMils() / 1000.0f) * 72.0f)), this.mPageHeight - ((int) ((minMargins.getBottomMils() / 1000.0f) * 72.0f)));
    }

    public Rect getPageContentRect() {
        return this.mContentRect;
    }

    public int getPageHeight() {
        return this.mPageHeight;
    }

    public int getPageWidth() {
        return this.mPageWidth;
    }

    public PdfDocument.Page startPage(int i) {
        return startPage(new PdfDocument.PageInfo.Builder(this.mPageWidth, this.mPageHeight, i).setContentRect(this.mContentRect).create());
    }
}
