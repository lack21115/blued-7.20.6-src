package com.blued.android.module.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/GiftHitLoadingView.class */
public class GiftHitLoadingView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    protected ImageView f11474a;
    protected ImageView b;

    /* renamed from: c  reason: collision with root package name */
    protected ImageView f11475c;
    protected int d;
    private Context e;
    private LayoutInflater f;

    public GiftHitLoadingView(Context context) {
        super(context);
        this.d = 0;
        this.e = context;
        a();
    }

    public GiftHitLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.e = context;
        a();
    }

    public void a() {
        LayoutInflater from = LayoutInflater.from(this.e);
        this.f = from;
        View inflate = from.inflate(R.layout.gift_hit_loading_layout, (ViewGroup) this, true);
        this.f11474a = (ImageView) inflate.findViewById(R.id.gift_loading_floor);
        this.b = (ImageView) inflate.findViewById(R.id.gift_loading_progress);
        this.f11475c = (ImageView) inflate.findViewById(R.id.gift_text_floor);
    }

    public void a(int i) {
        this.b.setVisibility(0);
        this.d = i;
        setLoadFloorVisibility(8);
        setResources(this.d);
    }

    public void b() {
        this.b.setVisibility(8);
        setLoadFloorVisibility(0);
        this.d = 0;
    }

    public void setLoadFloorVisibility(int i) {
        this.f11474a.setVisibility(i);
    }

    protected void setResources(int i) {
        switch (i) {
            case 2:
                this.b.setImageResource(R.drawable.gift_hit_anim8);
                return;
            case 3:
                this.b.setImageResource(R.drawable.gift_hit_anim7);
                return;
            case 4:
                this.b.setImageResource(R.drawable.gift_hit_anim6);
                return;
            case 5:
                this.b.setImageResource(R.drawable.gift_hit_anim5);
                return;
            case 6:
                this.b.setImageResource(R.drawable.gift_hit_anim4);
                return;
            case 7:
                this.b.setImageResource(R.drawable.gift_hit_anim3);
                return;
            case 8:
                this.b.setImageResource(R.drawable.gift_hit_anim2);
                return;
            case 9:
                this.b.setImageResource(R.drawable.gift_hit_anim1);
                return;
            default:
                this.b.setImageResource(0);
                this.b.setVisibility(8);
                setLoadFloorVisibility(0);
                return;
        }
    }
}
