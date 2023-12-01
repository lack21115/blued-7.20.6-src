package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLTextView.class */
public class PLTextView extends EditText {
    public PLTextView(Context context) {
        this(context, null);
    }

    public PLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setCursorVisible(false);
        setBackgroundColor(0);
    }
}
