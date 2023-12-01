package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/utils/widget/MotionButton.class */
public class MotionButton extends AppCompatButton {

    /* renamed from: a  reason: collision with root package name */
    ViewOutlineProvider f2238a;
    RectF b;

    /* renamed from: c  reason: collision with root package name */
    private float f2239c;
    private float d;
    private Path e;

    public MotionButton(Context context) {
        super(context);
        this.f2239c = 0.0f;
        this.d = Float.NaN;
        a(context, null);
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2239c = 0.0f;
        this.d = Float.NaN;
        a(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2239c = 0.0f;
        this.d = Float.NaN;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R.styleable.ImageFilterView_roundPercent && Build.VERSION.SDK_INT >= 21) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.d == 0.0f || this.e == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.e);
        }
        super.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }

    public float getRound() {
        return this.d;
    }

    public float getRoundPercent() {
        return this.f2239c;
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.d = f;
            float f2 = this.f2239c;
            this.f2239c = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.d != f;
        this.d = f;
        if (f != 0.0f) {
            if (this.e == null) {
                this.e = new Path();
            }
            if (this.b == null) {
                this.b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2238a == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.d);
                        }
                    };
                    this.f2238a = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.b.set(0.0f, 0.0f, getWidth(), getHeight());
            this.e.reset();
            Path path = this.e;
            RectF rectF = this.b;
            float f3 = this.d;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setRoundPercent(float f) {
        boolean z = this.f2239c != f;
        this.f2239c = f;
        if (f != 0.0f) {
            if (this.e == null) {
                this.e = new Path();
            }
            if (this.b == null) {
                this.b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2238a == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            int width = MotionButton.this.getWidth();
                            int height = MotionButton.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionButton.this.f2239c) / 2.0f);
                        }
                    };
                    this.f2238a = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f2239c) / 2.0f;
            this.b.set(0.0f, 0.0f, width, height);
            this.e.reset();
            this.e.addRoundRect(this.b, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }
}
