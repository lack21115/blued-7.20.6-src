package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.view.LiveFansLevelView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveEntranceData;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/EntranceEffectLayout.class */
public class EntranceEffectLayout extends LinearLayout {
    private static int C = 500;
    private static int D = 2900;
    private static int E = 500;
    private static int F = 1200;
    private static float G = 150.0f;
    private static int H = 400;
    private List<LiveEntranceData> A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    private View f14256a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Context f14257c;
    private ImageView d;
    private ImageView e;
    private LiveFansLevelView f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private HalfCircle l;
    private LinearLayout m;
    private LinearLayout n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private View t;
    private View u;
    private TextView v;
    private TextView w;
    private ImageView x;
    private ImageView y;
    private ImageView z;

    /* renamed from: com.blued.android.module.live_china.view.EntranceEffectLayout$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/EntranceEffectLayout$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveEntranceData f14258a;

        AnonymousClass1(LiveEntranceData liveEntranceData) {
            this.f14258a = liveEntranceData;
        }

        @Override // java.lang.Runnable
        public void run() {
            EntranceEffectLayout.this.b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            EntranceEffectLayout.this.b.layout(0, 0, EntranceEffectLayout.this.b.getMeasuredWidth(), EntranceEffectLayout.this.b.getMeasuredHeight());
            EntranceEffectLayout entranceEffectLayout = EntranceEffectLayout.this;
            entranceEffectLayout.a(entranceEffectLayout.b.getMeasuredWidth(), this.f14258a).start();
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.EntranceEffectLayout$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/EntranceEffectLayout$2.class */
    class AnonymousClass2 implements ImageFileLoader.OnLoadFileListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveEntranceData f14260a;

        AnonymousClass2(LiveEntranceData liveEntranceData) {
            this.f14260a = liveEntranceData;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00e5  */
        @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onUIFinish(java.io.File r8, java.lang.Exception r9) {
            /*
                Method dump skipped, instructions count: 382
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.EntranceEffectLayout.AnonymousClass2.onUIFinish(java.io.File, java.lang.Exception):void");
        }
    }

    public EntranceEffectLayout(Context context) {
        super(context);
        this.f14257c = context;
        c();
    }

    public EntranceEffectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14257c = context;
        c();
    }

    public EntranceEffectLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14257c = context;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(int i) {
        final int measuredWidth = i - this.r.getMeasuredWidth();
        new ObjectAnimator();
        ValueAnimator ofInt = ObjectAnimator.ofInt(0, measuredWidth);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceEffectLayout.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) EntranceEffectLayout.this.r.getLayoutParams();
                layoutParams.leftMargin = intValue;
                EntranceEffectLayout.this.r.setLayoutParams(layoutParams);
                if (measuredWidth - intValue > EntranceEffectLayout.G || measuredWidth - intValue < 0) {
                    EntranceEffectLayout.this.r.setAlpha(1.0f);
                } else {
                    EntranceEffectLayout.this.r.setAlpha((measuredWidth - intValue) / EntranceEffectLayout.G);
                }
            }
        });
        ofInt.setDuration(F);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofInt;
    }

    private AnimatorSet a(final View view) {
        view.clearAnimation();
        new ObjectAnimator();
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.0f, 0.5f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceEffectLayout.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setScaleY(floatValue);
                view.setScaleX(floatValue);
                view.setAlpha(floatValue);
            }
        });
        Random random = new Random();
        ofFloat.setDuration(random.nextInt(200) + 300);
        new ObjectAnimator();
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(0.5f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceEffectLayout.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setScaleY(floatValue);
                view.setScaleX(floatValue);
                view.setAlpha(floatValue);
            }
        });
        ofFloat2.setDuration(random.nextInt(100) + 100);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(arrayList);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void b(LiveEntranceData liveEntranceData) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void c() {
        View inflate = LayoutInflater.from(this.f14257c).inflate(R.layout.item_entrance_effect, this);
        this.f14256a = inflate;
        View findViewById = inflate.findViewById(R.id.fl_main);
        this.b = findViewById;
        findViewById.setVisibility(4);
        this.s = (ImageView) this.b.findViewById(R.id.img_manager_icon);
        this.d = (ImageView) this.b.findViewById(R.id.img_effect);
        this.h = (TextView) this.b.findViewById(R.id.tv_name);
        this.i = (TextView) this.b.findViewById(R.id.tv_content);
        this.j = (TextView) this.b.findViewById(R.id.tv_top_line);
        this.k = (TextView) this.b.findViewById(R.id.tv_btm_line);
        this.l = (HalfCircle) this.b.findViewById(R.id.left_half_circle);
        this.m = (LinearLayout) this.b.findViewById(R.id.ll_content);
        this.n = (LinearLayout) this.b.findViewById(R.id.ll_top_layer);
        this.o = (ImageView) this.b.findViewById(R.id.star_first);
        this.p = (ImageView) this.b.findViewById(R.id.star_second);
        this.q = (ImageView) this.b.findViewById(R.id.star_third);
        this.r = (ImageView) this.b.findViewById(R.id.img_light);
        this.e = (ImageView) this.b.findViewById(R.id.img_rich_rank);
        this.f = (LiveFansLevelView) this.b.findViewById(R.id.fans_level);
        this.t = this.b.findViewById(R.id.fl_normal);
        this.u = this.b.findViewById(R.id.fl_vip);
        this.v = (TextView) this.b.findViewById(R.id.tv_vip_name);
        this.w = (TextView) this.b.findViewById(R.id.tv_vip_des);
        this.x = (ImageView) this.b.findViewById(R.id.iv_vip_bg);
        this.y = (ImageView) this.b.findViewById(R.id.iv_vip_avatar_frame);
        this.z = (ImageView) this.b.findViewById(R.id.iv_vip_avatar);
        this.g = (ImageView) this.b.findViewById(R.id.img_noble_icon);
        this.A = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet getStarsAnims() {
        AnimatorSet a2 = a(this.o);
        AnimatorSet a3 = a(this.p);
        AnimatorSet a4 = a(this.q);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(a2, a3, a4);
        return animatorSet;
    }

    public AnimatorSet a(float f, final LiveEntranceData liveEntranceData) {
        this.b.setVisibility(0);
        if (liveEntranceData == null || !TextUtils.isEmpty(liveEntranceData.medium_image)) {
            D = 2900;
        } else {
            D = 5000;
        }
        new ObjectAnimator();
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(this.f14257c.getResources().getDisplayMetrics().widthPixels, DensityUtils.a(this.f14257c, 20.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceEffectLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) EntranceEffectLayout.this.b.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                EntranceEffectLayout.this.b.setLayoutParams(layoutParams);
            }
        });
        ofFloat.setDuration(C);
        new ObjectAnimator();
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(DensityUtils.a(this.f14257c, 20.0f), DensityUtils.a(this.f14257c, 5.0f));
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceEffectLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) EntranceEffectLayout.this.b.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                EntranceEffectLayout.this.b.setLayoutParams(layoutParams);
            }
        });
        ofFloat2.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.EntranceEffectLayout.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(EntranceEffectLayout.this.getStarsAnims(), EntranceEffectLayout.this.getStarsAnims(), EntranceEffectLayout.this.getStarsAnims(), EntranceEffectLayout.this.getStarsAnims(), EntranceEffectLayout.this.getStarsAnims(), EntranceEffectLayout.this.getStarsAnims());
                animatorSet.start();
                AnimatorSet animatorSet2 = new AnimatorSet();
                EntranceEffectLayout entranceEffectLayout = EntranceEffectLayout.this;
                Animator a2 = entranceEffectLayout.a(entranceEffectLayout.m.getMeasuredWidth());
                a2.setStartDelay(EntranceEffectLayout.H);
                EntranceEffectLayout entranceEffectLayout2 = EntranceEffectLayout.this;
                animatorSet2.playSequentially(entranceEffectLayout2.a(entranceEffectLayout2.m.getMeasuredWidth()), a2);
                animatorSet2.start();
            }
        });
        ofFloat2.setDuration(D);
        new ObjectAnimator();
        ValueAnimator ofFloat3 = ObjectAnimator.ofFloat(DensityUtils.a(this.f14257c, 5.0f), -f);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceEffectLayout.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) EntranceEffectLayout.this.b.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                EntranceEffectLayout.this.b.setLayoutParams(layoutParams);
            }
        });
        ofFloat3.setDuration(E);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(arrayList);
        this.b.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.EntranceEffectLayout.7
            @Override // java.lang.Runnable
            public void run() {
                EntranceEffectLayout.this.B = false;
                EntranceEffectLayout.this.b.setVisibility(8);
                if (EntranceEffectLayout.this.A.size() > 0) {
                    EntranceEffectLayout.this.A.remove(liveEntranceData);
                }
                if (EntranceEffectLayout.this.A.size() > 0) {
                    EntranceEffectLayout entranceEffectLayout = EntranceEffectLayout.this;
                    entranceEffectLayout.b((LiveEntranceData) entranceEffectLayout.A.get(0));
                }
            }
        }, C + D + E);
        return animatorSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.module.live_china.model.LiveEntranceData r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 == 0) goto L70
            r0 = r5
            com.blued.android.chat.data.ProfileData r0 = r0.userData
            if (r0 == 0) goto L47
            com.blued.android.module.live_china.live_info.LiveRoomInfo r0 = com.blued.android.module.live_china.live_info.LiveRoomInfo.a()
            java.lang.String r0 = r0.f()
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            r1 = r5
            com.blued.android.chat.data.ProfileData r1 = r1.userData
            long r1 = r1.uid
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r7
            java.lang.String r1 = r1.toString()
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L47
            r0 = r4
            java.util.List<com.blued.android.module.live_china.model.LiveEntranceData> r0 = r0.A
            r1 = 0
            r2 = r5
            r0.add(r1, r2)
            goto L52
        L47:
            r0 = r4
            java.util.List<com.blued.android.module.live_china.model.LiveEntranceData> r0 = r0.A
            r1 = r5
            boolean r0 = r0.add(r1)
        L52:
            r0 = r4
            java.util.List<com.blued.android.module.live_china.model.LiveEntranceData> r0 = r0.A
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L70
            r0 = r4
            r1 = r4
            java.util.List<com.blued.android.module.live_china.model.LiveEntranceData> r1 = r1.A
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.blued.android.module.live_china.model.LiveEntranceData r1 = (com.blued.android.module.live_china.model.LiveEntranceData) r1
            r0.b(r1)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.EntranceEffectLayout.a(com.blued.android.module.live_china.model.LiveEntranceData):void");
    }

    public int[] a(String str, String str2, int i, int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return iArr;
            }
            if (i4 <= i - 1) {
                try {
                    iArr[i4] = Color.parseColor(str);
                } catch (Exception e) {
                    iArr[i4] = Color.parseColor("#FF000000");
                }
            } else {
                try {
                    iArr[i4] = Color.parseColor(str2);
                } catch (Exception e2) {
                    iArr[i4] = Color.parseColor("#00000000");
                }
            }
            i3 = i4 + 1;
        }
    }
}
