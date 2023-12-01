package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.heytap.msp.mobad.api.R;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/i.class */
public class i extends b {
    private static int h;
    private TextView e;
    private com.opos.cmn.e.a.a.a f;
    private final String g;

    public i(Context context, e eVar) {
        super(context, eVar);
        this.g = "当前是数据网络，播放视频将消耗流量";
    }

    private void e() {
        final int[] iArr = new int[4];
        this.f.setOnTouchListener(new com.opos.cmn.e.a.a.b(iArr));
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.b.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                i.this.b.b(i.this.f, iArr);
            }
        });
    }

    @Override // com.opos.mobad.o.b.b
    protected void a() {
        ImageView imageView = new ImageView(this.f27049a);
        imageView.setImageDrawable(new ColorDrawable(-16777216));
        imageView.setAlpha(0.4f);
        this.f27050c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.o.b.b
    protected void b() {
        TextView textView = new TextView(this.f27049a);
        this.e = textView;
        textView.setText("当前是数据网络，播放视频将消耗流量");
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
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f27049a, R.drawable.native_video_bt);
        this.f = aVar;
        aVar.setText("继续播放");
        this.f.setGravity(17);
        this.f.setTextSize(1, 14.0f);
        this.f.setTextColor(Color.parseColor("#2AD181"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27049a, 70.0f), com.opos.cmn.an.h.f.a.a(this.f27049a, 24.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f27049a, 14.0f);
        layoutParams.addRule(3, h);
        layoutParams.addRule(14);
        this.d.addView(this.f, layoutParams);
        e();
    }

    public View d() {
        return this.f27050c;
    }
}
