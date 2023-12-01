package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.observer.AudienceCountObserver;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/AudienceCountTextView.class */
public class AudienceCountTextView extends AppCompatTextView implements AudienceCountObserver {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f17893a;

    public AudienceCountTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AudienceCountTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.blued.android.module.yy_china.observer.AudienceCountObserver
    public void a(final int i) {
        this.f17893a.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.AudienceCountTextView.1
            @Override // java.lang.Runnable
            public void run() {
                AudienceCountTextView audienceCountTextView = AudienceCountTextView.this;
                audienceCountTextView.setText(String.format(audienceCountTextView.getResources().getString(R.string.yy_audience_count), Integer.valueOf(i)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
