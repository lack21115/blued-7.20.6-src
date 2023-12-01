package android.text.method;

import android.graphics.Rect;
import android.view.View;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/TransformationMethod.class */
public interface TransformationMethod {
    CharSequence getTransformation(CharSequence charSequence, View view);

    void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect);
}
