package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiMetadata.class */
public class EmojiMetadata {
    public static final int HAS_GLYPH_ABSENT = 1;
    public static final int HAS_GLYPH_EXISTS = 2;
    public static final int HAS_GLYPH_UNKNOWN = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<MetadataItem> f2825a = new ThreadLocal<>();
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final MetadataRepo f2826c;
    private volatile int d = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiMetadata$HasGlyph.class */
    public @interface HasGlyph {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiMetadata(MetadataRepo metadataRepo, int i) {
        this.f2826c = metadataRepo;
        this.b = i;
    }

    private MetadataItem a() {
        MetadataItem metadataItem = f2825a.get();
        MetadataItem metadataItem2 = metadataItem;
        if (metadataItem == null) {
            metadataItem2 = new MetadataItem();
            f2825a.set(metadataItem2);
        }
        this.f2826c.getMetadataList().list(metadataItem2, this.b);
        return metadataItem2;
    }

    public void draw(Canvas canvas, float f, float f2, Paint paint) {
        Typeface a2 = this.f2826c.a();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(a2);
        canvas.drawText(this.f2826c.getEmojiCharArray(), this.b * 2, 2, f, f2, paint);
        paint.setTypeface(typeface);
    }

    public int getCodepointAt(int i) {
        return a().codepoints(i);
    }

    public int getCodepointsLength() {
        return a().codepointsLength();
    }

    public short getCompatAdded() {
        return a().compatAdded();
    }

    public int getHasGlyph() {
        return this.d;
    }

    public short getHeight() {
        return a().height();
    }

    public int getId() {
        return a().id();
    }

    public short getSdkAdded() {
        return a().sdkAdded();
    }

    public Typeface getTypeface() {
        return this.f2826c.a();
    }

    public short getWidth() {
        return a().width();
    }

    public boolean isDefaultEmoji() {
        return a().emojiStyle();
    }

    public void resetHasGlyphCache() {
        this.d = 0;
    }

    public void setHasGlyph(boolean z) {
        this.d = z ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(getId()));
        sb.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= codepointsLength) {
                return sb.toString();
            }
            sb.append(Integer.toHexString(getCodepointAt(i2)));
            sb.append(" ");
            i = i2 + 1;
        }
    }
}
