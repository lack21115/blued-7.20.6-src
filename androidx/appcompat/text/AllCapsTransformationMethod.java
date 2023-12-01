package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/text/AllCapsTransformationMethod.class */
public class AllCapsTransformationMethod implements TransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    private Locale f1586a;

    public AllCapsTransformationMethod(Context context) {
        this.f1586a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f1586a);
        }
        return null;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
