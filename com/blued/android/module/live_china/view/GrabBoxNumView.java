package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.igexin.push.config.c;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/GrabBoxNumView.class */
public class GrabBoxNumView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f14279a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f14280c;
    private TextView d;
    private ImageView e;

    public GrabBoxNumView(Context context) {
        super(context);
        this.b = context;
        a();
    }

    public GrabBoxNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f14280c = from;
        View inflate = from.inflate(R.layout.grab_box_wandou_toast, (ViewGroup) this, true);
        this.f14279a = inflate;
        this.d = (TextView) inflate.findViewById(R.id.grab_box_num);
        this.e = (ImageView) this.f14279a.findViewById(R.id.grab_box_icon);
        setVisibility(8);
    }

    public void a(int i, String str) {
        ImageLoader.a((IRequestHost) null, str).a(this.e);
        TextView textView = this.d;
        textView.setText(i + "");
        setVisibility(0);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.GrabBoxNumView.1
            @Override // java.lang.Runnable
            public void run() {
                GrabBoxNumView.this.setVisibility(8);
            }
        }, c.j);
    }
}
