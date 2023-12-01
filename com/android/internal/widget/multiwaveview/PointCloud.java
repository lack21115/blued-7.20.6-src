package com.android.internal.widget.multiwaveview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/PointCloud.class */
public class PointCloud {
    private static final int INNER_POINTS = 8;
    private static final float MAX_POINT_SIZE = 4.0f;
    private static final float MIN_POINT_SIZE = 2.0f;
    private static final float PI = 3.1415927f;
    private static final String TAG = "PointCloud";
    private float mCenterX;
    private float mCenterY;
    private Drawable mDrawable;
    private float mOuterRadius;
    private ArrayList<Point> mPointCloud = new ArrayList<>();
    private float mScale = 1.0f;
    WaveManager waveManager = new WaveManager();
    GlowManager glowManager = new GlowManager();
    private Paint mPaint = new Paint();

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/PointCloud$GlowManager.class */
    public class GlowManager {
        private float x;
        private float y;
        private float radius = 0.0f;
        private float alpha = 0.0f;

        public GlowManager() {
        }

        public float getAlpha() {
            return this.alpha;
        }

        public float getRadius() {
            return this.radius;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public void setAlpha(float f) {
            this.alpha = f;
        }

        public void setRadius(float f) {
            this.radius = f;
        }

        public void setX(float f) {
            this.x = f;
        }

        public void setY(float f) {
            this.y = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/PointCloud$Point.class */
    public class Point {
        float radius;
        float x;
        float y;

        public Point(float f, float f2, float f3) {
            this.x = f;
            this.y = f2;
            this.radius = f3;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/PointCloud$WaveManager.class */
    public class WaveManager {
        private float radius = 50.0f;
        private float alpha = 0.0f;

        public WaveManager() {
        }

        public float getAlpha() {
            return this.alpha;
        }

        public float getRadius() {
            return this.radius;
        }

        public void setAlpha(float f) {
            this.alpha = f;
        }

        public void setRadius(float f) {
            this.radius = f;
        }
    }

    public PointCloud(Drawable drawable) {
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setColor(Color.rgb(255, 255, 255));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mDrawable = drawable;
        if (this.mDrawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    private static float hypot(float f, float f2) {
        return FloatMath.sqrt((f * f) + (f2 * f2));
    }

    private float interp(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    private static float max(float f, float f2) {
        return f > f2 ? f : f2;
    }

    public void draw(Canvas canvas) {
        ArrayList<Point> arrayList = this.mPointCloud;
        canvas.save(1);
        canvas.scale(this.mScale, this.mScale, this.mCenterX, this.mCenterY);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                canvas.restore();
                return;
            }
            Point point = arrayList.get(i2);
            float interp = interp(4.0f, MIN_POINT_SIZE, point.radius / this.mOuterRadius);
            float f = point.x + this.mCenterX;
            float f2 = point.y + this.mCenterY;
            int alphaForPoint = getAlphaForPoint(point);
            if (alphaForPoint != 0) {
                if (this.mDrawable != null) {
                    canvas.save(1);
                    float intrinsicWidth = this.mDrawable.getIntrinsicWidth();
                    float intrinsicHeight = this.mDrawable.getIntrinsicHeight();
                    float f3 = interp / 4.0f;
                    canvas.scale(f3, f3, f, f2);
                    canvas.translate(f - (intrinsicWidth * 0.5f), f2 - (intrinsicHeight * 0.5f));
                    this.mDrawable.setAlpha(alphaForPoint);
                    this.mDrawable.draw(canvas);
                    canvas.restore();
                } else {
                    this.mPaint.setAlpha(alphaForPoint);
                    canvas.drawCircle(f, f2, interp, this.mPaint);
                }
            }
            i = i2 + 1;
        }
    }

    public int getAlphaForPoint(Point point) {
        float hypot;
        float hypot2;
        float f = 0.0f;
        if (hypot(this.glowManager.x - point.x, this.glowManager.y - point.y) < this.glowManager.radius) {
            f = this.glowManager.alpha * max(0.0f, (float) Math.pow(FloatMath.cos((0.7853982f * hypot) / this.glowManager.radius), 10.0d));
        }
        float f2 = 0.0f;
        if (hypot(point.x, point.y) < this.waveManager.radius * MIN_POINT_SIZE) {
            f2 = this.waveManager.alpha * max(0.0f, (float) Math.pow(FloatMath.cos((1.5707964f * (hypot2 - this.waveManager.radius)) / this.waveManager.radius), 6.0d));
        }
        return (int) (max(f, f2) * 255.0f);
    }

    public float getScale() {
        return this.mScale;
    }

    public void makePointCloud(float f, float f2) {
        if (f == 0.0f) {
            Log.w(TAG, "Must specify an inner radius");
            return;
        }
        this.mOuterRadius = f2;
        this.mPointCloud.clear();
        float f3 = f2 - f;
        float f4 = (6.2831855f * f) / 8.0f;
        int round = Math.round(f3 / f4);
        float f5 = f3 / round;
        int i = 0;
        while (i <= round) {
            int i2 = (int) ((6.2831855f * f) / f4);
            float f6 = 1.5707964f;
            float f7 = 6.2831855f / i2;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < i2) {
                    float cos = FloatMath.cos(f6);
                    float sin = FloatMath.sin(f6);
                    f6 += f7;
                    this.mPointCloud.add(new Point(f * cos, f * sin, f));
                    i3 = i4 + 1;
                }
            }
            i++;
            f += f5;
        }
    }

    public void setCenter(float f, float f2) {
        this.mCenterX = f;
        this.mCenterY = f2;
    }

    public void setScale(float f) {
        this.mScale = f;
    }
}
