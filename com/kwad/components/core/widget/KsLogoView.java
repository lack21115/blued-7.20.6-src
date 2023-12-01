package com.kwad.components.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/KsLogoView.class */
public class KsLogoView extends LinearLayout {
    private boolean WU;
    TextView WV;
    ImageView WW;
    private a WX;
    private SimpleImageLoadingListener ey;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/KsLogoView$a.class */
    public interface a {
        void jU();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public KsLogoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, AttributeSet attributeSet, int i) {
        super(k.wrapContextIfNeed(context), attributeSet, i);
        this.ey = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.WX != null) {
                    KsLogoView.this.WX.jU();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.rA();
                if (KsLogoView.this.WX != null) {
                    KsLogoView.this.WX.jU();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z) {
        super(k.wrapContextIfNeed(context));
        this.ey = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.WX != null) {
                    KsLogoView.this.WX.jU();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.rA();
                if (KsLogoView.this.WX != null) {
                    KsLogoView.this.WX.jU();
                }
            }
        };
        if (z) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        TextView textView = ksLogoView.getTextView();
        int ceil = ((ksLogoView.getVisibility() != 0 || textView.getText() == null || textView.getText().length() <= 0) ? 0 : ((int) Math.ceil(textView.getPaint().measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight()) + (ksLogoView.getIcon().getVisibility() == 0 ? com.kwad.sdk.c.kwai.a.a(ksLogoView.getContext(), 18.0f) : 0);
        int a2 = com.kwad.sdk.c.kwai.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(ceil, a2);
        ksLogoView.layout(0, 0, ceil, a2);
        Bitmap createBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return createBitmap;
    }

    private void init() {
        TextView textView;
        int i;
        k.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.WV = (TextView) findViewById(R.id.ksad_logo_text);
        this.WW = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.WU = z;
        if (z) {
            this.WW.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            textView = this.WV;
            i = -6513508;
        } else {
            this.WW.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
            textView = this.WV;
            i = -1711276033;
        }
        textView.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA() {
        this.WW.setImageDrawable(getContext().getResources().getDrawable(this.WU ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (r6 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
        r6.jU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00df, code lost:
        if (r6 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void S(com.kwad.sdk.core.response.model.AdTemplate r6) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.widget.KsLogoView.S(com.kwad.sdk.core.response.model.AdTemplate):void");
    }

    public ImageView getIcon() {
        return this.WW;
    }

    public TextView getTextView() {
        return this.WV;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.WX = aVar;
    }
}
