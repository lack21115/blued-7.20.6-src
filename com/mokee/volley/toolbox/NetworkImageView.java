package com.mokee.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mokee.volley.VolleyError;
import com.mokee.volley.toolbox.ImageLoader;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/NetworkImageView.class */
public class NetworkImageView extends ImageView {
    private ImageLoader.ImageContainer a;
    private int b;
    private int c;
    private String d;
    private ImageLoader e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/NetworkImageView$a.class */
    public class a implements ImageLoader.ImageListener {
        private final /* synthetic */ boolean val$isInLayoutPass;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/NetworkImageView$a$b.class */
        public class b implements Runnable {
            private final /* synthetic */ ImageLoader.ImageContainer val$response;

            b(ImageLoader.ImageContainer imageContainer) {
                this.val$response = imageContainer;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.onResponse(this.val$response, false);
            }
        }

        a(boolean z) {
            this.val$isInLayoutPass = z;
        }

        @Override // com.mokee.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (NetworkImageView.this.c != 0) {
                NetworkImageView.this.setImageResource(NetworkImageView.this.c);
            }
        }

        @Override // com.mokee.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
            if (z && this.val$isInLayoutPass) {
                NetworkImageView.this.post(new b(imageContainer));
                return;
            }
            if (imageContainer.getBitmap() != null) {
                NetworkImageView.this.setImageBitmap(imageContainer.getBitmap());
                if (!ImageLoader.h) {
                    return;
                }
            }
            if (NetworkImageView.this.b != 0) {
                NetworkImageView.this.setImageResource(NetworkImageView.this.b);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        if (this.b != 0) {
            setImageResource(this.b);
            if (!ImageLoader.h) {
                return;
            }
        }
        setImageBitmap(null);
    }

    void a(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int width = getWidth();
        int height = getHeight();
        if (getLayoutParams() != null) {
            z3 = getLayoutParams().width == -2;
            z2 = getLayoutParams().height == -2;
        } else {
            z2 = false;
            z3 = false;
        }
        if (!z3 || !z2) {
            z4 = false;
        }
        if (width == 0 && height == 0 && !z4) {
            return;
        }
        if (TextUtils.isEmpty(this.d)) {
            if (this.a != null) {
                this.a.cancelRequest();
                this.a = null;
            }
            a();
            return;
        }
        if (this.a != null && this.a.getRequestUrl() != null) {
            if (this.a.getRequestUrl().equals(this.d)) {
                return;
            }
            this.a.cancelRequest();
            a();
        }
        this.a = this.e.get(this.d, new a(z), z3 ? 0 : width, z2 ? 0 : height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.a != null) {
            this.a.cancelRequest();
            setImageBitmap(null);
            this.a = null;
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(true);
    }

    public void setDefaultImageResId(int i) {
        this.b = i;
    }

    public void setErrorImageResId(int i) {
        this.c = i;
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        this.d = str;
        this.e = imageLoader;
        a(false);
    }
}
