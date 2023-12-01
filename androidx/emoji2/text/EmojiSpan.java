package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiSpan.class */
public abstract class EmojiSpan extends ReplacementSpan {
    private final EmojiMetadata b;

    /* renamed from: a  reason: collision with root package name */
    private final Paint.FontMetricsInt f2784a = new Paint.FontMetricsInt();

    /* renamed from: c  reason: collision with root package name */
    private short f2785c = -1;
    private short d = -1;
    private float e = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiSpan(EmojiMetadata emojiMetadata) {
        Preconditions.checkNotNull(emojiMetadata, "metadata cannot be null");
        this.b = emojiMetadata;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.f2785c;
    }

    public final int getHeight() {
        return this.d;
    }

    public final int getId() {
        return getMetadata().getId();
    }

    public final EmojiMetadata getMetadata() {
        return this.b;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f2784a);
        this.e = (Math.abs(this.f2784a.descent - this.f2784a.ascent) * 1.0f) / this.b.getHeight();
        this.d = (short) (this.b.getHeight() * this.e);
        this.f2785c = (short) (this.b.getWidth() * this.e);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = this.f2784a.ascent;
            fontMetricsInt.descent = this.f2784a.descent;
            fontMetricsInt.top = this.f2784a.top;
            fontMetricsInt.bottom = this.f2784a.bottom;
        }
        return this.f2785c;
    }
}
