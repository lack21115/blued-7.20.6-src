package com.blued.android.module.media.selector.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.media.selector.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/view/NoDataAndLoadFailView.class */
public class NoDataAndLoadFailView extends LinearLayout {
    private Context a;
    private View b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private ViewGroup k;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/view/NoDataAndLoadFailView$NoDataViewListener.class */
    public interface NoDataViewListener {
        void a();
    }

    public NoDataAndLoadFailView(Context context) {
        super(context);
        this.j = false;
        this.a = context;
        c();
    }

    public NoDataAndLoadFailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.a = context;
        c();
    }

    public NoDataAndLoadFailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.a = context;
        c();
    }

    public NoDataAndLoadFailView(Context context, ViewGroup viewGroup) {
        super(context);
        this.j = false;
        this.a = context;
        this.k = viewGroup;
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.ViewGroup] */
    private void c() {
        LayoutInflater from = LayoutInflater.from(this.a);
        int i = R.layout.item_ll_nodata;
        ?? r0 = this.k;
        NoDataAndLoadFailView noDataAndLoadFailView = r0;
        if (r0 == 0) {
            noDataAndLoadFailView = this;
        }
        View inflate = from.inflate(i, noDataAndLoadFailView);
        this.b = inflate;
        inflate.setVisibility(8);
        this.c = (ImageView) this.b.findViewById(R.id.img_nodata);
        this.d = (TextView) this.b.findViewById(R.id.tv_nodata);
        this.e = (TextView) this.b.findViewById(R.id.tv_reload);
        this.f = R.drawable.icon_no_data_posted;
        this.g = R.string.foudation_media_no_content_for_now;
        this.h = R.drawable.icon_data_load_failed;
        this.i = R.string.foudation_media_connecting_failed;
        b();
    }

    public void a() {
        this.b.setVisibility(0);
        this.c.setImageResource(this.f);
        this.d.setText(this.g);
        this.e.setVisibility(4);
    }

    public void b() {
        this.b.setVisibility(8);
    }

    public boolean getIfViewVisible() {
        return this.b.getVisibility() == 0;
    }

    public void setBackgroundColorRes(int i) {
        this.b.findViewById(R.id.ll_main).setBackgroundColor(this.a.getResources().getColor(i));
    }

    public void setBtnStr(int i) {
        this.e.setText(i);
    }

    public void setFailStr(int i) {
        this.i = i;
    }

    public void setFailimg(int i) {
        this.h = i;
    }

    public void setIfBtnVisibility(int i) {
        if (i == 0) {
            this.j = true;
        } else {
            this.j = false;
        }
    }

    public void setListener(final NoDataViewListener noDataViewListener) {
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.view.NoDataAndLoadFailView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                noDataViewListener.a();
            }
        });
        this.j = true;
    }

    public void setNoDataImg(int i) {
        this.f = i;
    }

    public void setNoDataStr(int i) {
        this.g = i;
    }
}
