package com.youzan.androidsdkx5.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.youzan.androidsdkx5.R;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/view/LoadingView.class */
public class LoadingView extends RelativeLayout {

    /* renamed from: ˊ  reason: contains not printable characters */
    LinearLayout f1161;

    /* renamed from: ˋ  reason: contains not printable characters */
    ImageView f1162;

    /* renamed from: ˎ  reason: contains not printable characters */
    ImageView f1163;

    public LoadingView(Context context) {
        this(context, null, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9230(context, attributeSet, i);
    }

    public boolean abandonImageLoading(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                return true;
            }
            return (context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed();
        }
        return false;
    }

    public LoadingView blockPage(boolean z) {
        setClickable(z);
        return this;
    }

    public void setImage() {
        if (abandonImageLoading(this.f1162.getContext())) {
            return;
        }
        Glide.b(this.f1162.getContext()).b(Integer.valueOf(R.drawable.yz_loading)).a(this.f1162);
    }

    public void setLoadImage(int i) {
        if (abandonImageLoading(this.f1162.getContext())) {
            return;
        }
        Glide.b(this.f1162.getContext()).b(Integer.valueOf(i)).a(this.f1162);
    }

    public void setLoadImage(String str) {
        if (abandonImageLoading(this.f1162.getContext())) {
            return;
        }
        Glide.b(this.f1162.getContext()).b(str).a(this.f1162);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    void m9230(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(context).inflate(R.layout.yz_view_loading, this);
        this.f1161 = (LinearLayout) findViewById(R.id.yz_ll_content);
        this.f1162 = (ImageView) findViewById(R.id.yz_image);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setClickable(true);
    }
}
