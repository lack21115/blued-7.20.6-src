package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/TypefaceEmojiSpan.class */
public final class TypefaceEmojiSpan extends EmojiSpan {

    /* renamed from: a  reason: collision with root package name */
    private static Paint f2847a;

    public TypefaceEmojiSpan(EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    private static Paint b() {
        if (f2847a == null) {
            TextPaint textPaint = new TextPaint();
            f2847a = textPaint;
            textPaint.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
            f2847a.setStyle(Paint.Style.FILL);
        }
        return f2847a;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            canvas.drawRect(f, i3, f + a(), i5, b());
        }
        getMetadata().draw(canvas, f, i4, paint);
    }
}
