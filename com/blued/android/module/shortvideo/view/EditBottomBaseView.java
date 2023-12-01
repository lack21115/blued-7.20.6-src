package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/EditBottomBaseView.class */
public abstract class EditBottomBaseView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected TextView f15887a;
    protected TextView b;

    /* renamed from: c  reason: collision with root package name */
    protected ViewGroup f15888c;
    private ImageView d;
    private long e;

    public EditBottomBaseView(Context context) {
        this(context, null);
    }

    public EditBottomBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditBottomBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0L;
        j();
    }

    private void j() {
        a();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.edit_bottom_base_view, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.btnBack);
        this.d = imageView;
        imageView.setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(R.id.stv_editor_bottom_save);
        this.b = textView;
        textView.setOnClickListener(this);
        this.f15887a = (TextView) inflate.findViewById(R.id.stv_editor_bottom_title);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.stv_editor_bottom_content);
        this.f15888c = viewGroup;
        viewGroup.addView(getContentV(), new RelativeLayout.LayoutParams(-1, -2));
        if (g()) {
            this.f15887a.setVisibility(0);
            this.d.setVisibility(8);
            if (getTitleId() != -1) {
                this.f15887a.setText(getTitleId());
            }
        } else {
            this.d.setVisibility(0);
            this.f15887a.setVisibility(8);
        }
        b();
        addView(inflate);
        setBackgroundColor(getResources().getColor(R.color.stv_bottom_transparent_bg));
    }

    protected abstract void a();

    protected abstract void b();

    public void c() {
        if (getVisibility() == 8) {
            postDelayed(new Runnable() { // from class: com.blued.android.module.shortvideo.view.EditBottomBaseView.1
                @Override // java.lang.Runnable
                public void run() {
                    EditBottomBaseView.this.setVisibility(0);
                    StvViewUtils.a(EditBottomBaseView.this.getContext(), EditBottomBaseView.this);
                }
            }, 200L);
        }
    }

    public void d() {
        if (getVisibility() == 0) {
            StvViewUtils.b(getContext(), this);
        }
    }

    protected abstract void e();

    protected abstract void f();

    protected abstract boolean g();

    protected abstract View getContentV();

    protected abstract int getTitleId();

    public void h() {
    }

    public void i() {
    }

    public void k() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.e == 0) {
            this.e = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - this.e <= 300) {
            this.e = System.currentTimeMillis();
            return;
        }
        StvViewUtils.a(view);
        int id = view.getId();
        if (id == R.id.stv_editor_bottom_save) {
            e();
        } else if (id == R.id.btnBack) {
            f();
        }
    }
}
