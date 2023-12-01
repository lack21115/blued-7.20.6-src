package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiTransformationMethod.class */
class EmojiTransformationMethod implements TransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    private final TransformationMethod f2894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiTransformationMethod(TransformationMethod transformationMethod) {
        this.f2894a = transformationMethod;
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.f2894a;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f2894a;
        CharSequence charSequence2 = charSequence;
        if (transformationMethod != null) {
            charSequence2 = transformationMethod.getTransformation(charSequence, view);
        }
        CharSequence charSequence3 = charSequence2;
        if (charSequence2 != null) {
            if (EmojiCompat.get().getLoadState() != 1) {
                return charSequence2;
            }
            charSequence3 = EmojiCompat.get().process(charSequence2);
        }
        return charSequence3;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        TransformationMethod transformationMethod = this.f2894a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z, i, rect);
        }
    }
}
