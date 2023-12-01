package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveBubbleBgModel;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMsgBgFrameLayout.class */
public class LiveMsgBgFrameLayout extends FrameLayout {
    private int[] A;
    private int[] B;
    private int[] C;
    private int[] D;

    /* renamed from: a  reason: collision with root package name */
    private Context f14608a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14609c;
    private int[] d;
    private int[] e;
    private Paint f;
    private RectF g;
    private GradientDrawable.Orientation h;
    private int i;
    private boolean j;
    private Paint k;
    private RectF l;
    private LinearGradient m;
    private LinearGradient n;
    private int[] o;
    private int[] p;
    private int[] q;
    private int[] r;
    private int[] s;
    private int[] t;
    private int[] u;
    private int[] v;
    private int[] w;
    private int[] x;
    private int[] y;
    private int[] z;

    public LiveMsgBgFrameLayout(Context context) {
        this(context, null);
    }

    public LiveMsgBgFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMsgBgFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new Paint();
        this.g = new RectF();
        this.h = GradientDrawable.Orientation.LEFT_RIGHT;
        this.j = true;
        this.l = new RectF();
        this.f14608a = context;
        a();
    }

    private void a() {
        this.i = AppInfo.d().getResources().getColor(R.color.trans_black_seven);
        this.f14609c = DisplayUtil.a(this.f14608a, 14.0f);
        this.b = DisplayUtil.a(this.f14608a, 1.0f);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setAntiAlias(true);
        this.f.setDither(true);
        this.f.setStrokeWidth(this.b);
        this.f.setColor(this.i);
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.k.setDither(true);
        this.k.setColor(this.i);
        this.k.setStrokeWidth(this.b);
        this.k.setStyle(Paint.Style.FILL);
        this.o = new int[]{Color.parseColor("#4D000000")};
        this.p = new int[]{Color.parseColor("#7f29acff")};
        this.q = new int[]{Color.parseColor("#7f555fff")};
        this.r = new int[]{Color.parseColor("#7fcc5eff")};
        this.s = new int[]{Color.parseColor("#56c4fc")};
        this.t = new int[]{Color.parseColor("#660c2db7")};
        this.u = new int[]{Color.parseColor("#ffa468")};
        this.v = new int[]{Color.parseColor("#66F54821")};
        this.w = new int[]{Color.parseColor("#a500ff")};
        this.x = new int[]{Color.parseColor("#668e23d6")};
        this.y = new int[]{Color.parseColor("#ff3e16")};
        this.z = new int[]{Color.parseColor("#66e22d00")};
        this.A = new int[]{Color.parseColor("#ffe095")};
        this.B = new int[]{Color.parseColor("#aff35c39")};
        this.C = new int[]{Color.parseColor("#B0BCB0FF"), Color.parseColor("#B0FF969F")};
        this.D = new int[]{Color.parseColor("#B0EC2D36"), Color.parseColor("#B04E43FF")};
    }

    public void a(LiveBubbleBgModel liveBubbleBgModel, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (liveBubbleBgModel == null || !liveBubbleBgModel.isValid()) {
            this.j = true;
            if (i >= 0 && i <= 15) {
                int[] iArr = this.o;
                this.e = iArr;
                this.d = iArr;
            } else if (i >= 16 && i <= 20) {
                int[] iArr2 = this.p;
                this.e = iArr2;
                this.d = iArr2;
            } else if (i >= 21 && i <= 25) {
                int[] iArr3 = this.q;
                this.e = iArr3;
                this.d = iArr3;
            } else if (i >= 26 && i < 30) {
                int[] iArr4 = this.r;
                this.e = iArr4;
                this.d = iArr4;
            } else if (i == 30) {
                this.d = this.s;
                this.e = this.t;
            } else if (i == 31) {
                this.d = this.u;
                this.e = this.v;
            } else if (i == 32) {
                this.d = this.w;
                this.e = this.x;
            } else if (i == 33) {
                this.d = this.y;
                this.e = this.z;
            } else if (i == 34) {
                this.d = this.A;
                this.e = this.B;
            } else if (i == 35) {
                this.d = this.C;
                this.e = this.D;
                this.h = GradientDrawable.Orientation.LEFT_RIGHT;
            }
            setBackgroundResource(R.drawable.transparent);
            invalidate();
            return;
        }
        if (liveBubbleBgModel.chat_frame_gradient_type == 2) {
            z = this.h != GradientDrawable.Orientation.TOP_BOTTOM;
            this.h = GradientDrawable.Orientation.TOP_BOTTOM;
        } else {
            z = this.h != GradientDrawable.Orientation.LEFT_RIGHT;
            this.h = GradientDrawable.Orientation.LEFT_RIGHT;
        }
        if (z || this.d == null || liveBubbleBgModel.stokeColors == null || this.d.length != liveBubbleBgModel.stokeColors.length) {
            this.d = liveBubbleBgModel.stokeColors;
            this.m = null;
        } else {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int[] iArr5 = this.d;
                if (i3 >= iArr5.length) {
                    z3 = false;
                    break;
                } else if (iArr5[i3] != liveBubbleBgModel.stokeColors[i3]) {
                    z3 = true;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (z3) {
                this.d = liveBubbleBgModel.stokeColors;
                this.m = null;
            }
        }
        if (z || this.e == null || liveBubbleBgModel.frameColors == null || this.e.length != liveBubbleBgModel.frameColors.length) {
            this.e = liveBubbleBgModel.frameColors;
            this.n = null;
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                int[] iArr6 = this.e;
                if (i5 >= iArr6.length) {
                    z2 = false;
                    break;
                } else if (iArr6[i5] != liveBubbleBgModel.frameColors[i5]) {
                    z2 = true;
                    break;
                } else {
                    i4 = i5 + 1;
                }
            }
            if (z2) {
                this.e = liveBubbleBgModel.frameColors;
                this.n = null;
            }
        }
        setBackgroundResource(R.drawable.transparent);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.j) {
            RectF rectF = this.l;
            float f = this.b * 1.0f;
            rectF.top = f;
            rectF.left = f;
            this.l.right = getMeasuredWidth() - (this.b * 1.0f);
            this.l.bottom = getMeasuredHeight() - (this.b * 1.0f);
            int[] iArr = this.e;
            if (iArr == null || iArr.length == 0) {
                this.n = null;
                this.k.setColor(this.i);
            } else if (iArr.length == 1) {
                this.k.setColor(iArr[0]);
                this.n = null;
            } else {
                if (this.h == GradientDrawable.Orientation.TOP_BOTTOM) {
                    if (this.n == null) {
                        this.n = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), this.e, (float[]) null, Shader.TileMode.REPEAT);
                    }
                } else if (this.n == null) {
                    this.n = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, this.e, (float[]) null, Shader.TileMode.REPEAT);
                }
                this.k.setColor(this.e[0] | (-16777216));
            }
            this.k.setShader(this.n);
            RectF rectF2 = this.l;
            int i = this.f14609c;
            canvas.drawRoundRect(rectF2, i - 1, i - 1, this.k);
            RectF rectF3 = this.g;
            float f2 = this.b * 0.5f;
            rectF3.top = f2;
            rectF3.left = f2;
            this.g.right = getMeasuredWidth() - (this.b * 0.5f);
            this.g.bottom = getMeasuredHeight() - (this.b * 0.5f);
            int[] iArr2 = this.d;
            if (iArr2 == null || iArr2.length == 0) {
                this.f.setColor(this.i);
                this.m = null;
            } else if (iArr2.length == 1) {
                this.f.setColor(iArr2[0]);
                this.m = null;
            } else {
                this.f.setColor(iArr2[0] | (-16777216));
                if (this.h == GradientDrawable.Orientation.TOP_BOTTOM) {
                    if (this.m == null) {
                        this.m = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), this.d, (float[]) null, Shader.TileMode.REPEAT);
                    }
                } else if (this.m == null) {
                    this.m = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, this.d, (float[]) null, Shader.TileMode.REPEAT);
                }
            }
            this.f.setShader(this.m);
            RectF rectF4 = this.g;
            int i2 = this.f14609c;
            canvas.drawRoundRect(rectF4, i2, i2, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.m = null;
            this.n = null;
            invalidate();
        }
    }

    public void setValidColors(boolean z) {
        this.j = z;
        invalidate();
    }
}
