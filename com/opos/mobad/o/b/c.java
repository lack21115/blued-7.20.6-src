package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/c.class */
public class c extends b {
    private static int h;
    private TextView e;
    private com.opos.cmn.e.a.a.c f;
    private final String g;
    private final String i;

    public c(Context context, e eVar) {
        super(context, eVar);
        this.g = "抱歉，视频播放失败，请点击重试";
        this.i = "opos_module_biz_ui_native_video_replay_cover.png";
    }

    private void e() {
        final int[] iArr = new int[4];
        this.f.setOnTouchListener(new com.opos.cmn.e.a.a.b(iArr));
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                c.this.b.a(c.this.f, iArr);
            }
        });
    }

    @Override // com.opos.mobad.o.b.b
    protected void a() {
        ImageView imageView = new ImageView(this.f13361a);
        imageView.setImageDrawable(new ColorDrawable(-16777216));
        imageView.setAlpha(1.0f);
        this.f13362c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.o.b.b
    protected void b() {
        TextView textView = new TextView(this.f13361a);
        this.e = textView;
        textView.setText("抱歉，视频播放失败，请点击重试");
        int a2 = com.opos.mobad.cmn.a.b.g.a();
        h = a2;
        this.e.setId(a2);
        this.e.setTextColor(-1);
        this.e.setTextSize(1, 14.0f);
        this.e.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.d.addView(this.e, layoutParams);
    }

    @Override // com.opos.mobad.o.b.b
    protected void c() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f13361a, 50.0f);
        this.f = cVar;
        cVar.setScaleType(ImageView.ScaleType.CENTER);
        this.f.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f13361a, "opos_module_biz_ui_native_video_replay_cover.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f13361a, 40.0f), com.opos.cmn.an.h.f.a.a(this.f13361a, 40.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f13361a, 14.0f);
        layoutParams.addRule(3, h);
        layoutParams.addRule(14);
        this.d.addView(this.f, layoutParams);
        e();
    }

    public View d() {
        return this.f13362c;
    }
}
