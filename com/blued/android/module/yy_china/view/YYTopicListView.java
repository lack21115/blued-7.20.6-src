package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.TopicTypeListMode;
import com.blued.android.module.yy_china.model.YYTopicDataModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYTopicListView.class */
public final class YYTopicListView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f18526a;
    private final Paint b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f18527c;
    private final Paint d;
    private final Paint e;
    private final float f;
    private final float g;
    private final float h;
    private final ArrayList<YYTopicDataModel> i;
    private final int j;
    private OnCLickTopicListener k;
    private int l;
    private float m;
    private final ArrayList<YYTopicDataModel> n;
    private final ArrayList<YYTopicDataModel> o;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYTopicListView$OnCLickTopicListener.class */
    public interface OnCLickTopicListener {
        void a(TopicTypeListMode topicTypeListMode);
    }

    public YYTopicListView(Context context) {
        this(context, null);
    }

    public YYTopicListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYTopicListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.white));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(getResources().getDimensionPixelOffset(R.dimen.sp_12));
        this.f18526a = paint;
        Paint paint2 = new Paint();
        paint2.setColor(getResources().getColor(R.color.syc_989898));
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setTextSize(getResources().getDimensionPixelOffset(R.dimen.sp_12));
        this.b = paint2;
        Paint paint3 = new Paint();
        paint3.setColor(getResources().getColor(R.color.white));
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint3.setStrokeWidth(60.0f);
        this.f18527c = paint3;
        Paint paint4 = new Paint();
        paint4.setColor(getResources().getColor(R.color.syc_1B1B1B));
        paint4.setAntiAlias(true);
        paint4.setStyle(Paint.Style.FILL);
        paint4.setStrokeCap(Paint.Cap.ROUND);
        paint4.setStrokeWidth(60.0f);
        this.d = paint4;
        Paint paint5 = new Paint();
        paint5.setColor(getResources().getColor(R.color.white_alpha06));
        paint5.setAntiAlias(true);
        paint5.setStyle(Paint.Style.FILL);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        paint5.setStrokeWidth(60.0f);
        this.e = paint5;
        this.f = getResources().getDimensionPixelOffset(R.dimen.dp_12);
        this.g = getResources().getDimensionPixelOffset(R.dimen.dp_6);
        this.h = getResources().getDimensionPixelOffset(R.dimen.dp_30);
        this.i = new ArrayList<>();
        this.j = 2;
        Paint.FontMetrics fontMetrics = this.f18526a.getFontMetrics();
        this.m = ((fontMetrics.bottom - fontMetrics.top) / 2) - fontMetrics.bottom;
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
    }

    private final YYTopicDataModel getDataNum() {
        if (this.l >= this.i.size()) {
            this.l = 0;
        }
        YYTopicDataModel yYTopicDataModel = this.i.get(this.l);
        Intrinsics.c(yYTopicDataModel, "dats[mNum]");
        YYTopicDataModel yYTopicDataModel2 = yYTopicDataModel;
        this.l++;
        yYTopicDataModel2.setLeft(getWidth() + this.g);
        yYTopicDataModel2.setRight(yYTopicDataModel2.getLeft() + yYTopicDataModel2.getLenght());
        return yYTopicDataModel2;
    }

    public final void a(TopicTypeListMode name) {
        Intrinsics.e(name, "name");
        this.i.add(new YYTopicDataModel(name, false, this.b.measureText(name.getTopic()) + (this.f * 2), 0.0f, 0.0f));
    }

    public final void a(String topic) {
        Intrinsics.e(topic, "topic");
        ArrayList<YYTopicDataModel> arrayList = new ArrayList();
        arrayList.addAll(this.i);
        for (YYTopicDataModel yYTopicDataModel : arrayList) {
            if (Intrinsics.a((Object) yYTopicDataModel.getTopic().getTopic(), (Object) topic)) {
                ArrayList<YYTopicDataModel> arrayList2 = new ArrayList();
                arrayList2.addAll(this.i);
                for (YYTopicDataModel yYTopicDataModel2 : arrayList2) {
                    yYTopicDataModel2.setClick(false);
                }
                yYTopicDataModel.setClick(true);
                OnCLickTopicListener onClickTopic = getOnClickTopic();
                if (onClickTopic == null) {
                    return;
                }
                onClickTopic.a(yYTopicDataModel.getTopic());
                return;
            }
        }
    }

    public final void a(ArrayList<TopicTypeListMode> da) {
        Intrinsics.e(da, "da");
        this.i.clear();
        this.n.clear();
        this.o.clear();
        invalidate();
        for (TopicTypeListMode topicTypeListMode : da) {
            a(topicTypeListMode);
        }
        this.l = 0;
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.i.size() == 0) {
            return;
        }
        if (this.n.size() == 0) {
            this.n.add(getDataNum());
        } else {
            ArrayList<YYTopicDataModel> arrayList = this.n;
            YYTopicDataModel yYTopicDataModel = arrayList.get(arrayList.size() - 1);
            Intrinsics.c(yYTopicDataModel, "daLin1[daLin1.size - 1]");
            if (yYTopicDataModel.getRight() < getWidth()) {
                this.n.add(getDataNum());
            }
        }
        for (YYTopicDataModel yYTopicDataModel2 : this.n) {
            if (yYTopicDataModel2.isClick()) {
                Paint paint = this.f18527c;
                float left = yYTopicDataModel2.getLeft();
                float f = 2;
                paint.setShader(new LinearGradient(left, this.h / f, yYTopicDataModel2.getRight(), this.h / f, getResources().getColor(R.color.syc_3883FD), getResources().getColor(R.color.syc_00E0AB), Shader.TileMode.CLAMP));
                if (canvas != null) {
                    float left2 = yYTopicDataModel2.getLeft();
                    float right = yYTopicDataModel2.getRight();
                    float f2 = this.h;
                    canvas.drawRoundRect(left2, 0.0f, right, f2, f2 / f, f2 / f, this.f18527c);
                }
                if (canvas != null) {
                    float left3 = yYTopicDataModel2.getLeft();
                    float f3 = 4;
                    float right2 = yYTopicDataModel2.getRight();
                    float f4 = this.h;
                    canvas.drawRoundRect(left3 + f3, 4.0f, right2 - f3, f4 - f3, f4 / f, f4 / f, this.d);
                }
                if (canvas != null) {
                    float left4 = yYTopicDataModel2.getLeft();
                    float f5 = 4;
                    float right3 = yYTopicDataModel2.getRight();
                    float f6 = this.h;
                    canvas.drawRoundRect(left4 + f5, 4.0f, right3 - f5, f6 - f5, f6 / f, f6 / f, this.e);
                }
                if (canvas != null) {
                    canvas.drawText(yYTopicDataModel2.getTopic().getTopic(), yYTopicDataModel2.getLeft() + this.f, (this.h / f) + this.m, this.f18526a);
                }
            } else {
                if (canvas != null) {
                    float left5 = yYTopicDataModel2.getLeft();
                    float right4 = yYTopicDataModel2.getRight();
                    float f7 = this.h;
                    float f8 = 2;
                    canvas.drawRoundRect(left5, 0.0f, right4, f7, f7 / f8, f7 / f8, this.e);
                }
                if (canvas != null) {
                    canvas.drawText(yYTopicDataModel2.getTopic().getTopic(), yYTopicDataModel2.getLeft() + this.f, (this.h / 2) + this.m, this.b);
                }
            }
            yYTopicDataModel2.setLeft(yYTopicDataModel2.getLeft() - this.j);
            yYTopicDataModel2.setRight(yYTopicDataModel2.getRight() - this.j);
        }
        if (this.o.size() == 0) {
            this.o.add(getDataNum());
        } else {
            ArrayList<YYTopicDataModel> arrayList2 = this.o;
            YYTopicDataModel yYTopicDataModel3 = arrayList2.get(arrayList2.size() - 1);
            Intrinsics.c(yYTopicDataModel3, "daLin2[daLin2.size - 1]");
            if (yYTopicDataModel3.getRight() < getWidth()) {
                this.o.add(getDataNum());
            }
        }
        float f9 = this.h;
        float f10 = this.f;
        float f11 = f9 + f10;
        float f12 = (2.0f * f9) + f10;
        float f13 = (f9 * 1.5f) + f10;
        for (YYTopicDataModel yYTopicDataModel4 : this.o) {
            if (yYTopicDataModel4.isClick()) {
                this.f18527c.setShader(new LinearGradient(yYTopicDataModel4.getLeft(), f13, yYTopicDataModel4.getRight(), f13, getResources().getColor(R.color.syc_3883FD), getResources().getColor(R.color.syc_00E0AB), Shader.TileMode.CLAMP));
                if (canvas != null) {
                    float left6 = yYTopicDataModel4.getLeft();
                    float right5 = yYTopicDataModel4.getRight();
                    float f14 = this.h;
                    float f15 = 2;
                    canvas.drawRoundRect(left6, f11, right5, f12, f14 / f15, f14 / f15, this.f18527c);
                }
                if (canvas != null) {
                    float left7 = yYTopicDataModel4.getLeft();
                    float f16 = 4;
                    float right6 = yYTopicDataModel4.getRight();
                    float f17 = this.h;
                    float f18 = 2;
                    canvas.drawRoundRect(left7 + f16, f11 + 4.0f, right6 - f16, f12 - f16, f17 / f18, f17 / f18, this.d);
                }
                if (canvas != null) {
                    canvas.drawText(yYTopicDataModel4.getTopic().getTopic(), yYTopicDataModel4.getLeft() + this.f, f13 + this.m, this.f18526a);
                }
            } else {
                if (canvas != null) {
                    float left8 = yYTopicDataModel4.getLeft();
                    float right7 = yYTopicDataModel4.getRight();
                    float f19 = this.h;
                    float f20 = 2;
                    canvas.drawRoundRect(left8, f11, right7, f12, f19 / f20, f19 / f20, this.e);
                }
                if (canvas != null) {
                    canvas.drawText(yYTopicDataModel4.getTopic().getTopic(), yYTopicDataModel4.getLeft() + this.f, f13 + this.m, this.b);
                }
            }
            yYTopicDataModel4.setLeft(yYTopicDataModel4.getLeft() - this.j);
            yYTopicDataModel4.setRight(yYTopicDataModel4.getRight() - this.j);
        }
        if (this.n.size() > 0 && this.n.get(0).getRight() < 0.0f) {
            ArrayList<YYTopicDataModel> arrayList3 = this.n;
            arrayList3.remove(arrayList3.get(0));
        }
        if (this.o.size() > 0 && this.o.get(0).getRight() < 0.0f) {
            ArrayList<YYTopicDataModel> arrayList4 = this.o;
            arrayList4.remove(arrayList4.get(0));
        }
        invalidate();
    }

    public final OnCLickTopicListener getOnClickTopic() {
        return this.k;
    }

    public final void getRanTopic() {
        ArrayList<YYTopicDataModel> arrayList = this.i;
        if (arrayList != null && arrayList.size() > 0) {
            YYTopicDataModel yYTopicDataModel = this.i.get((int) (Math.random() * this.i.size()));
            Intrinsics.c(yYTopicDataModel, "dats[i]");
            YYTopicDataModel yYTopicDataModel2 = yYTopicDataModel;
            for (YYTopicDataModel yYTopicDataModel3 : this.i) {
                yYTopicDataModel3.setClick(false);
            }
            yYTopicDataModel2.setClick(true);
            OnCLickTopicListener onClickTopic = getOnClickTopic();
            if (onClickTopic == null) {
                return;
            }
            onClickTopic.a(yYTopicDataModel2.getTopic());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            ArrayList<YYTopicDataModel> arrayList = new ArrayList();
            if (motionEvent.getY() < this.h) {
                arrayList.addAll(this.n);
            }
            if (motionEvent.getY() > this.h + this.f) {
                arrayList.addAll(this.o);
            }
            for (YYTopicDataModel yYTopicDataModel : arrayList) {
                if (yYTopicDataModel.getLeft() <= motionEvent.getX() && yYTopicDataModel.getRight() >= motionEvent.getX()) {
                    ArrayList<YYTopicDataModel> arrayList2 = new ArrayList();
                    arrayList2.addAll(this.i);
                    for (YYTopicDataModel yYTopicDataModel2 : arrayList2) {
                        yYTopicDataModel2.setClick(false);
                    }
                    yYTopicDataModel.setClick(true);
                    OnCLickTopicListener onClickTopic = getOnClickTopic();
                    if (onClickTopic == null) {
                        return true;
                    }
                    onClickTopic.a(yYTopicDataModel.getTopic());
                    return true;
                }
            }
            return true;
        }
        return true;
    }

    public final void setOnClickTopic(OnCLickTopicListener onCLickTopicListener) {
        this.k = onCLickTopicListener;
    }
}
