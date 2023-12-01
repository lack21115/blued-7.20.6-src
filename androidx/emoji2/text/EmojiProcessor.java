package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiProcessor.class */
final class EmojiProcessor {

    /* renamed from: a  reason: collision with root package name */
    private final EmojiCompat.SpanFactory f2827a;
    private final MetadataRepo b;

    /* renamed from: c  reason: collision with root package name */
    private EmojiCompat.GlyphChecker f2828c;
    private final boolean d;
    private final int[] e;

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiProcessor$CodepointIndexFinder.class */
    static final class CodepointIndexFinder {
        private CodepointIndexFinder() {
        }

        static int a(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    i--;
                    if (i < 0) {
                        return z ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i2--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i2--;
                    } else if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    } else {
                        z = true;
                    }
                }
                return i;
            }
        }

        static int b(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    if (i >= length) {
                        if (z) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i2--;
                        i++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i2--;
                        i++;
                    } else if (Character.isLowSurrogate(charAt)) {
                        return -1;
                    } else {
                        i++;
                        z = true;
                    }
                }
                return i;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiProcessor$DefaultGlyphChecker.class */
    public static class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {

        /* renamed from: a  reason: collision with root package name */
        private static final ThreadLocal<StringBuilder> f2829a = new ThreadLocal<>();
        private final TextPaint b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DefaultGlyphChecker() {
            TextPaint textPaint = new TextPaint();
            this.b = textPaint;
            textPaint.setTextSize(10.0f);
        }

        private static StringBuilder a() {
            if (f2829a.get() == null) {
                f2829a.set(new StringBuilder());
            }
            return f2829a.get();
        }

        @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
        public boolean hasGlyph(CharSequence charSequence, int i, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 23 || i3 <= Build.VERSION.SDK_INT) {
                StringBuilder a2 = a();
                a2.setLength(0);
                while (i < i2) {
                    a2.append(charSequence.charAt(i));
                    i++;
                }
                return PaintCompat.hasGlyph(this.b, a2.toString());
            }
            return false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/EmojiProcessor$ProcessorSm.class */
    static final class ProcessorSm {

        /* renamed from: a  reason: collision with root package name */
        private int f2830a = 1;
        private final MetadataRepo.Node b;

        /* renamed from: c  reason: collision with root package name */
        private MetadataRepo.Node f2831c;
        private MetadataRepo.Node d;
        private int e;
        private int f;
        private final boolean g;
        private final int[] h;

        ProcessorSm(MetadataRepo.Node node, boolean z, int[] iArr) {
            this.b = node;
            this.f2831c = node;
            this.g = z;
            this.h = iArr;
        }

        private static boolean b(int i) {
            return i == 65039;
        }

        private static boolean c(int i) {
            return i == 65038;
        }

        private int d() {
            this.f2830a = 1;
            this.f2831c = this.b;
            this.f = 0;
            return 1;
        }

        private boolean e() {
            if (this.f2831c.a().isDefaultEmoji() || b(this.e)) {
                return true;
            }
            if (this.g) {
                if (this.h == null) {
                    return true;
                }
                return Arrays.binarySearch(this.h, this.f2831c.a().getCodepointAt(0)) < 0;
            }
            return false;
        }

        int a(int i) {
            MetadataRepo.Node a2 = this.f2831c.a(i);
            int i2 = 3;
            if (this.f2830a == 2) {
                if (a2 != null) {
                    this.f2831c = a2;
                    this.f++;
                } else if (c(i)) {
                    i2 = d();
                } else if (!b(i)) {
                    if (this.f2831c.a() == null) {
                        i2 = d();
                    } else if (this.f != 1) {
                        this.d = this.f2831c;
                        d();
                    } else if (e()) {
                        this.d = this.f2831c;
                        d();
                    } else {
                        i2 = d();
                    }
                }
                i2 = 2;
            } else if (a2 == null) {
                i2 = d();
            } else {
                this.f2830a = 2;
                this.f2831c = a2;
                this.f = 1;
                i2 = 2;
            }
            this.e = i;
            return i2;
        }

        EmojiMetadata a() {
            return this.d.a();
        }

        EmojiMetadata b() {
            return this.f2831c.a();
        }

        boolean c() {
            boolean z = true;
            if (this.f2830a == 2 && this.f2831c.a() != null) {
                if (this.f <= 1) {
                    if (e()) {
                        return true;
                    }
                }
                return z;
            }
            z = false;
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, EmojiCompat.GlyphChecker glyphChecker, boolean z, int[] iArr) {
        this.f2827a = spanFactory;
        this.b = metadataRepo;
        this.f2828c = glyphChecker;
        this.d = z;
        this.e = iArr;
    }

    private void a(Spannable spannable, EmojiMetadata emojiMetadata, int i, int i2) {
        spannable.setSpan(this.f2827a.a(emojiMetadata), i, i2, 33);
    }

    private static boolean a(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Editable editable, int i, KeyEvent keyEvent) {
        if (i != 67 ? i != 112 ? false : delete(editable, keyEvent, true) : delete(editable, keyEvent, false)) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            return true;
        }
        return false;
    }

    private static boolean a(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        int max;
        int min;
        if (editable == null || inputConnection == null || i < 0 || i2 < 0) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (a(selectionStart, selectionEnd)) {
            return false;
        }
        if (z) {
            max = CodepointIndexFinder.a(editable, selectionStart, Math.max(i, 0));
            int b = CodepointIndexFinder.b(editable, selectionEnd, Math.max(i2, 0));
            if (max == -1) {
                return false;
            }
            min = b;
            if (b == -1) {
                return false;
            }
        } else {
            max = Math.max(selectionStart - i, 0);
            min = Math.min(selectionEnd + i2, editable.length());
        }
        EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(max, min, EmojiSpan.class);
        if (emojiSpanArr == null || emojiSpanArr.length <= 0) {
            return false;
        }
        int length = emojiSpanArr.length;
        int i3 = max;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                int max2 = Math.max(i3, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
            EmojiSpan emojiSpan = emojiSpanArr[i5];
            int spanStart = editable.getSpanStart(emojiSpan);
            int spanEnd = editable.getSpanEnd(emojiSpan);
            i3 = Math.min(spanStart, i3);
            min = Math.max(spanEnd, min);
            i4 = i5 + 1;
        }
    }

    private boolean a(CharSequence charSequence, int i, int i2, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.getHasGlyph() == 0) {
            emojiMetadata.setHasGlyph(this.f2828c.hasGlyph(charSequence, i, i2, emojiMetadata.getSdkAdded()));
        }
        return emojiMetadata.getHasGlyph() == 2;
    }

    private static boolean delete(Editable editable, KeyEvent keyEvent, boolean z) {
        EmojiSpan[] emojiSpanArr;
        int i;
        int spanStart;
        int spanEnd;
        if (a(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (a(selectionStart, selectionEnd) || (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) == null || emojiSpanArr.length <= 0) {
            return false;
        }
        int length = emojiSpanArr.length;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            EmojiSpan emojiSpan = emojiSpanArr[i2];
            spanStart = editable.getSpanStart(emojiSpan);
            spanEnd = editable.getSpanEnd(emojiSpan);
            i = (!(z && spanStart == selectionStart) && (z || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd)) ? i2 + 1 : 0;
        }
        editable.delete(spanStart, spanEnd);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiMetadata a(CharSequence charSequence) {
        ProcessorSm processorSm = new ProcessorSm(this.b.c(), this.d, this.e);
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                if (processorSm.c()) {
                    return processorSm.b();
                }
                return null;
            }
            int codePointAt = Character.codePointAt(charSequence, i2);
            if (processorSm.a(codePointAt) != 2) {
                return null;
            }
            i = i2 + Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0232, code lost:
        if (a(r7, r15, r9, r0.b()) == false) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0267 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[Catch: all -> 0x027f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x027f, blocks: (B:7:0x001a, B:11:0x0028, B:15:0x0033, B:17:0x0048, B:22:0x0066, B:26:0x0087, B:28:0x008d, B:33:0x00a9, B:36:0x00c5, B:38:0x00d0, B:42:0x00ec, B:49:0x010e, B:50:0x0128, B:50:0x0128, B:51:0x012b, B:57:0x015b, B:68:0x0183, B:73:0x019c, B:75:0x01a7, B:77:0x01c7, B:80:0x01d9, B:82:0x01e6, B:85:0x01fb, B:87:0x0209, B:95:0x0225, B:100:0x023e, B:102:0x0249, B:18:0x0055), top: B:125:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0211  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence a(java.lang.CharSequence r7, int r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 675
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.a(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
