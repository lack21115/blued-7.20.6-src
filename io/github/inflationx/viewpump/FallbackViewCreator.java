package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/FallbackViewCreator.class */
public interface FallbackViewCreator {
    View onCreateView(View view, String str, Context context, AttributeSet attributeSet);
}
