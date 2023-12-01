package com.sobot.chat.widget.timePicker.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.timepicker.TimeModel;
import com.sobot.chat.widget.timePicker.adapter.SobotWheelAdapter;
import com.sobot.chat.widget.timePicker.listener.SobotOnItemSelectedListener;
import com.sobot.chat.widget.timePicker.model.SobotIPickerViewData;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/lib/SobotWheelView.class */
public class SobotWheelView extends View {
    private static final float SCALECONTENT = 0.8f;
    private static final int VELOCITYFLING = 5;
    private float CENTERCONTENTOFFSET;
    SobotWheelAdapter adapter;
    float centerY;
    int change;
    Context context;
    int dividerColor;
    private DividerType dividerType;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    float firstLineY;
    private GestureDetector gestureDetector;
    int halfCircumference;
    Handler handler;
    int initPosition;
    private boolean isCenterLabel;
    boolean isLoop;
    private boolean isOptions;
    float itemHeight;
    int itemsVisible;
    private String label;
    float lineSpacingMultiplier;
    ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private int mGravity;
    private int mOffset;
    int maxTextHeight;
    int maxTextWidth;
    int measuredHeight;
    int measuredWidth;
    SobotOnItemSelectedListener onItemSelectedListener;
    Paint paintCenterText;
    Paint paintIndicator;
    Paint paintOuterText;
    int preCurrentIndex;
    private float previousY;
    int radius;
    float secondLineY;
    private int selectedItem;
    long startTime;
    int textColorCenter;
    int textColorOut;
    int textSize;
    float totalScrollY;
    Typeface typeface;
    int widthMeasureSpec;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/lib/SobotWheelView$ACTION.class */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/lib/SobotWheelView$DividerType.class */
    public enum DividerType {
        FILL,
        WRAP
    }

    public SobotWheelView(Context context) {
        this(context, null);
    }

    public SobotWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isOptions = false;
        this.isCenterLabel = true;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.MONOSPACE;
        this.textColorOut = -5723992;
        this.textColorCenter = -14013910;
        this.dividerColor = -2763307;
        this.lineSpacingMultiplier = 1.6f;
        this.itemsVisible = 11;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.textSize = (int) TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics());
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.CENTERCONTENTOFFSET = 2.4f;
        } else {
            int i = (1.0f > f ? 1 : (1.0f == f ? 0 : -1));
            if (i <= 0 && f < 2.0f) {
                this.CENTERCONTENTOFFSET = 3.6f;
            } else if (i <= 0 && f < 2.0f) {
                this.CENTERCONTENTOFFSET = 4.5f;
            } else if (2.0f <= f && f < 3.0f) {
                this.CENTERCONTENTOFFSET = 6.0f;
            } else if (f >= 3.0f) {
                this.CENTERCONTENTOFFSET = f * 2.5f;
            }
        }
        judgeLineSpae();
        initLoopView(context);
    }

    private String getContentText(Object obj) {
        return obj == null ? "" : obj instanceof SobotIPickerViewData ? ((SobotIPickerViewData) obj).getPickerViewText() : obj instanceof Integer ? String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private int getLoopMappingIndex(int i) {
        if (i < 0) {
            return getLoopMappingIndex(i + this.adapter.getItemsCount());
        }
        int i2 = i;
        if (i > this.adapter.getItemsCount() - 1) {
            i2 = getLoopMappingIndex(i - this.adapter.getItemsCount());
        }
        return i2;
    }

    private void initLoopView(Context context) {
        this.context = context;
        this.handler = new SobotMessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new SobotLoopViewGestureListener(this));
        this.gestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        initPaints();
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.paintOuterText = paint;
        paint.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize(this.textSize);
        Paint paint2 = new Paint();
        this.paintCenterText = paint2;
        paint2.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize(this.textSize);
        Paint paint3 = new Paint();
        this.paintIndicator = paint3;
        paint3.setColor(this.dividerColor);
        this.paintIndicator.setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private void judgeLineSpae() {
        float f = this.lineSpacingMultiplier;
        if (f < 1.2f) {
            this.lineSpacingMultiplier = 1.2f;
        } else if (f > 2.0f) {
            this.lineSpacingMultiplier = 2.0f;
        }
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.adapter.getItemsCount()) {
                this.itemHeight = this.lineSpacingMultiplier * this.maxTextHeight;
                return;
            }
            String contentText = getContentText(this.adapter.getItem(i2));
            this.paintCenterText.getTextBounds(contentText, 0, contentText.length(), rect);
            int width = rect.width();
            if (width > this.maxTextWidth) {
                this.maxTextWidth = width;
            }
            this.paintCenterText.getTextBounds("星期", 0, 2, rect);
            this.maxTextHeight = rect.height() + 2;
            i = i2 + 1;
        }
    }

    private void measuredCenterContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.mGravity;
        if (i == 3) {
            this.drawCenterContentStart = 0;
        } else if (i == 5) {
            this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTERCONTENTOFFSET);
        } else if (i != 17) {
        } else {
            if (this.isOptions || (str2 = this.label) == null || str2.equals("") || !this.isCenterLabel) {
                this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
            } else {
                this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.25d);
            }
        }
    }

    private void measuredOutContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.mGravity;
        if (i == 3) {
            this.drawOutContentStart = 0;
        } else if (i == 5) {
            this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTERCONTENTOFFSET);
        } else if (i != 17) {
        } else {
            if (this.isOptions || (str2 = this.label) == null || str2.equals("") || !this.isCenterLabel) {
                this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
            } else {
                this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.25d);
            }
        }
    }

    private void reMeasureTextSize(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.measuredWidth; width = rect.width()) {
            i--;
            this.paintCenterText.setTextSize(i);
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        }
        this.paintOuterText.setTextSize(i);
    }

    private void remeasure() {
        if (this.adapter == null) {
            return;
        }
        measureTextWidthHeight();
        int i = (int) (this.itemHeight * (this.itemsVisible - 1));
        this.halfCircumference = i;
        this.measuredHeight = (int) ((i * 2) / 3.141592653589793d);
        this.radius = (int) (i / 3.141592653589793d);
        this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
        int i2 = this.measuredHeight;
        float f = i2;
        float f2 = this.itemHeight;
        this.firstLineY = (f - f2) / 2.0f;
        float f3 = (i2 + f2) / 2.0f;
        this.secondLineY = f3;
        this.centerY = (f3 - ((f2 - this.maxTextHeight) / 2.0f)) - this.CENTERCONTENTOFFSET;
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.adapter.getItemsCount() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    public final SobotWheelAdapter getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        return this.selectedItem;
    }

    public int getItemsCount() {
        SobotWheelAdapter sobotWheelAdapter = this.adapter;
        if (sobotWheelAdapter != null) {
            return sobotWheelAdapter.getItemsCount();
        }
        return 0;
    }

    public int getTextWidth(Paint paint, String str) {
        float[] fArr;
        int i = 0;
        if (str != null) {
            i = 0;
            if (str.length() > 0) {
                int length = str.length();
                paint.getTextWidths(str, new float[length]);
                i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    i += (int) Math.ceil(fArr[i2]);
                }
            }
        }
        return i;
    }

    public void isCenterLabel(Boolean bool) {
        this.isCenterLabel = bool.booleanValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String contentText;
        if (this.adapter == null) {
            return;
        }
        if (this.initPosition < 0) {
            this.initPosition = 0;
        }
        if (this.initPosition >= this.adapter.getItemsCount()) {
            this.initPosition = this.adapter.getItemsCount() - 1;
        }
        Object[] objArr = new Object[this.itemsVisible];
        int i = (int) (this.totalScrollY / this.itemHeight);
        this.change = i;
        try {
            this.preCurrentIndex = this.initPosition + (i % this.adapter.getItemsCount());
        } catch (ArithmeticException e) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (this.isLoop) {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = this.adapter.getItemsCount() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex -= this.adapter.getItemsCount();
            }
        } else {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex = this.adapter.getItemsCount() - 1;
            }
        }
        float f = this.totalScrollY;
        float f2 = this.itemHeight;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = this.itemsVisible;
            if (i3 >= i4) {
                break;
            }
            int i5 = this.preCurrentIndex - ((i4 / 2) - i3);
            if (this.isLoop) {
                objArr[i3] = this.adapter.getItem(getLoopMappingIndex(i5));
            } else if (i5 < 0) {
                objArr[i3] = "";
            } else if (i5 > this.adapter.getItemsCount() - 1) {
                objArr[i3] = "";
            } else {
                objArr[i3] = this.adapter.getItem(i5);
            }
            i2 = i3 + 1;
        }
        if (this.dividerType == DividerType.WRAP) {
            float f3 = (TextUtils.isEmpty(this.label) ? (this.measuredWidth - this.maxTextWidth) / 2 : (this.measuredWidth - this.maxTextWidth) / 4) - 12;
            if (f3 <= 0.0f) {
                f3 = 10.0f;
            }
            float f4 = this.measuredWidth - f3;
            float f5 = this.firstLineY;
            canvas.drawLine(f3, f5, f4, f5, this.paintIndicator);
            float f6 = this.secondLineY;
            canvas.drawLine(f3, f6, f4, f6, this.paintIndicator);
        } else {
            float f7 = this.firstLineY;
            canvas.drawLine(0.0f, f7, this.measuredWidth, f7, this.paintIndicator);
            float f8 = this.secondLineY;
            canvas.drawLine(0.0f, f8, this.measuredWidth, f8, this.paintIndicator);
        }
        if (!TextUtils.isEmpty(this.label) && this.isCenterLabel) {
            canvas.drawText(this.label, (this.measuredWidth - getTextWidth(this.paintCenterText, this.label)) - this.CENTERCONTENTOFFSET, this.centerY, this.paintCenterText);
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.itemsVisible) {
                return;
            }
            canvas.save();
            double d = ((this.itemHeight * i7) - (f % f2)) / this.radius;
            float f9 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f9 >= 90.0f || f9 <= -90.0f) {
                canvas.restore();
            } else {
                if (this.isCenterLabel || TextUtils.isEmpty(this.label) || TextUtils.isEmpty(getContentText(objArr[i7]))) {
                    contentText = getContentText(objArr[i7]);
                } else {
                    contentText = getContentText(objArr[i7]) + this.label;
                }
                reMeasureTextSize(contentText);
                measuredCenterContentStart(contentText);
                measuredOutContentStart(contentText);
                float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.maxTextHeight) / 2.0d));
                canvas.translate(0.0f, cos);
                canvas.scale(1.0f, (float) Math.sin(d));
                float f10 = this.firstLineY;
                if (cos > f10 || this.maxTextHeight + cos < f10) {
                    float f11 = this.secondLineY;
                    if (cos > f11 || this.maxTextHeight + cos < f11) {
                        if (cos >= this.firstLineY) {
                            int i8 = this.maxTextHeight;
                            if (i8 + cos <= this.secondLineY) {
                                canvas.drawText(contentText, this.drawCenterContentStart, i8 - this.CENTERCONTENTOFFSET, this.paintCenterText);
                                this.selectedItem = this.adapter.indexOf(objArr[i7]);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.CENTERCONTENTOFFSET, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.secondLineY - cos, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    }
                } else {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                    canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.firstLineY - cos, this.measuredWidth, (int) this.itemHeight);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.CENTERCONTENTOFFSET, this.paintCenterText);
                    canvas.restore();
                }
                canvas.restore();
                this.paintCenterText.setTextSize(this.textSize);
            }
            i6 = i7 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new SobotOnItemSelectedRunnable(this), 200L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.widthMeasureSpec = i;
        remeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTime = System.currentTimeMillis();
            cancelFuture();
            this.previousY = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.previousY - motionEvent.getRawY();
            this.previousY = motionEvent.getRawY();
            this.totalScrollY += rawY;
            if (!this.isLoop) {
                float f3 = (-this.initPosition) * this.itemHeight;
                float itemsCount = (this.adapter.getItemsCount() - 1) - this.initPosition;
                float f4 = this.itemHeight;
                float f5 = itemsCount * f4;
                float f6 = this.totalScrollY;
                if (f6 - (f4 * 0.25d) < f3) {
                    f2 = f6 - rawY;
                    f = f5;
                } else {
                    f = f5;
                    f2 = f3;
                    if (f6 + (f4 * 0.25d) > f5) {
                        f = f6 - rawY;
                        f2 = f3;
                    }
                }
                float f7 = this.totalScrollY;
                if (f7 < f2) {
                    this.totalScrollY = (int) f2;
                } else if (f7 > f) {
                    this.totalScrollY = (int) f;
                }
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i = this.radius;
            double acos = Math.acos((i - y) / i);
            double d = this.radius;
            float f8 = this.itemHeight;
            this.mOffset = (int) (((((int) (((acos * d) + (f8 / 2.0f)) / f8)) - (this.itemsVisible / 2)) * f8) - (((this.totalScrollY % f8) + f8) % f8));
            if (System.currentTimeMillis() - this.startTime > 120) {
                smoothScroll(ACTION.DAGGLE);
            } else {
                smoothScroll(ACTION.CLICK);
            }
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void scrollBy(float f) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SobotInertiaTimerTask(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(SobotWheelAdapter sobotWheelAdapter) {
        this.adapter = sobotWheelAdapter;
        remeasure();
        invalidate();
    }

    public final void setCurrentItem(int i) {
        this.selectedItem = i;
        this.initPosition = i;
        this.totalScrollY = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.isLoop = z;
    }

    public void setDividerColor(int i) {
        if (i != 0) {
            this.dividerColor = i;
            this.paintIndicator.setColor(i);
        }
    }

    public void setDividerType(DividerType dividerType) {
        this.dividerType = dividerType;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public void setIsOptions(boolean z) {
        this.isOptions = z;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.lineSpacingMultiplier = f;
            judgeLineSpae();
        }
    }

    public final void setOnItemSelectedListener(SobotOnItemSelectedListener sobotOnItemSelectedListener) {
        this.onItemSelectedListener = sobotOnItemSelectedListener;
    }

    public void setTextColorCenter(int i) {
        if (i != 0) {
            this.textColorCenter = i;
            this.paintCenterText.setColor(i);
        }
    }

    public void setTextColorOut(int i) {
        if (i != 0) {
            this.textColorOut = i;
            this.paintOuterText.setColor(i);
        }
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.textSize = i;
            this.paintOuterText.setTextSize(i);
            this.paintCenterText.setTextSize(this.textSize);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.paintOuterText.setTypeface(typeface);
        this.paintCenterText.setTypeface(this.typeface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.totalScrollY;
            float f2 = this.itemHeight;
            int i = (int) (((f % f2) + f2) % f2);
            this.mOffset = i;
            if (i > f2 / 2.0f) {
                this.mOffset = (int) (f2 - i);
            } else {
                this.mOffset = -i;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SobotSmoothScrollTimerTask(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }
}
