package com.opos.mobad.q.a.f;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.q.a.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f13507a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f13508c;
    private TextView d;
    private View e;
    private TextView f;
    private ImageView g;
    private View h;
    private View i;
    private a j;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/b$a.class */
    public interface a {
        void b(View view, int[] iArr);

        void c(View view, int[] iArr);

        void d(View view, int[] iArr);
    }

    public b(Context context) {
        this.f13507a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.opos_mob_layout_reward_title, (ViewGroup) null);
        this.b = inflate;
        this.f13508c = (ViewGroup) inflate.findViewById(R.id.opos_mob_video_title_left);
        this.d = (TextView) this.b.findViewById(R.id.opos_mob_video_btn_vip);
        this.e = this.b.findViewById(R.id.opos_mob_txt_video_left_split);
        this.f = (TextView) this.b.findViewById(R.id.opos_mob_txt_video_count);
        this.g = (ImageView) this.b.findViewById(R.id.opos_mob_btn_video_sound);
        this.h = this.b.findViewById(R.id.opos_mob_txt_video_right_split);
        this.i = this.b.findViewById(R.id.opos_mob_btn_video_close);
        i iVar = new i() { // from class: com.opos.mobad.q.a.f.b.1
            @Override // com.opos.mobad.q.a.i
            public void a(View view, int[] iArr) {
                a aVar = b.this.j;
                if (aVar == null) {
                    return;
                }
                if (view == b.this.d) {
                    aVar.b(view, iArr);
                } else if (view == b.this.g) {
                    aVar.d(view, iArr);
                } else if (view == b.this.i) {
                    aVar.c(view, iArr);
                }
            }
        };
        this.d.setOnTouchListener(iVar);
        this.i.setOnTouchListener(iVar);
        this.g.setOnTouchListener(iVar);
        this.d.setOnClickListener(iVar);
        this.i.setOnClickListener(iVar);
        this.g.setOnClickListener(iVar);
        b(false);
    }

    private void b(boolean z) {
        this.i.setVisibility(z ? 0 : 8);
        View view = this.h;
        int i = 8;
        if (z) {
            i = 0;
        }
        view.setVisibility(i);
    }

    public void a() {
        b(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 8
            r7 = r0
            r0 = r4
            if (r0 != 0) goto L16
            r0 = r5
            if (r0 != 0) goto L16
            r0 = r3
            android.view.ViewGroup r0 = r0.f13508c
            r1 = 8
            r0.setVisibility(r1)
            return
        L16:
            r0 = r3
            android.view.ViewGroup r0 = r0.f13508c
            r1 = 0
            r0.setVisibility(r1)
            r0 = r3
            android.widget.TextView r0 = r0.f
            r8 = r0
            r0 = r5
            if (r0 == 0) goto L2d
            r0 = 0
            r6 = r0
            goto L30
        L2d:
            r0 = 8
            r6 = r0
        L30:
            r0 = r8
            r1 = r6
            r0.setVisibility(r1)
            r0 = 1
            r6 = r0
            r0 = r4
            r1 = 1
            if (r0 != r1) goto L5b
            r0 = r3
            android.widget.TextView r0 = r0.d
            r9 = r0
            java.lang.String r0 = "跳过广告"
            r8 = r0
        L47:
            r0 = r9
            r1 = r8
            r0.setText(r1)
            r0 = r3
            android.widget.TextView r0 = r0.d
            r1 = 0
            r0.setVisibility(r1)
            r0 = r6
            r4 = r0
            goto L78
        L5b:
            r0 = r4
            r1 = 2
            if (r0 != r1) goto L6d
            r0 = r3
            android.widget.TextView r0 = r0.d
            r9 = r0
            java.lang.String r0 = "VIP免广告"
            r8 = r0
            goto L47
        L6d:
            r0 = r3
            android.widget.TextView r0 = r0.d
            r1 = 8
            r0.setVisibility(r1)
            r0 = 0
            r4 = r0
        L78:
            r0 = r3
            android.view.View r0 = r0.e
            r8 = r0
            r0 = r7
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L8e
            r0 = r7
            r6 = r0
            r0 = r4
            if (r0 == 0) goto L8e
            r0 = 0
            r6 = r0
        L8e:
            r0 = r8
            r1 = r6
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.f.b.a(int, boolean):void");
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public void a(String str) {
        this.f.setText(str);
    }

    public void a(boolean z) {
        ImageView imageView;
        Resources resources;
        int i;
        if (z) {
            imageView = this.g;
            resources = this.f13507a.getResources();
            i = R.drawable.opos_mob_drawable_sound_on;
        } else {
            imageView = this.g;
            resources = this.f13507a.getResources();
            i = R.drawable.opos_mob_drawable_sound_off;
        }
        imageView.setImageDrawable(resources.getDrawable(i));
    }

    public View b() {
        return this.b;
    }
}
