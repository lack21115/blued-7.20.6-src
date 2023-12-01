package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.AppMethods;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/HorizonScrollTextView.class */
public class HorizonScrollTextView extends AppCompatTextView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14307a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private float f14308c;
    private float d;
    private float e;
    private float f;
    private String g;
    private Paint h;
    private Bitmap i;
    private OnScrollListener j;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/HorizonScrollTextView$OnScrollListener.class */
    public interface OnScrollListener {
        void a();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/HorizonScrollTextView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.blued.android.module.live_china.view.HorizonScrollTextView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public boolean f14309a;
        public float b;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14309a = false;
            this.b = 0.0f;
            parcel.readBooleanArray(null);
            this.b = parcel.readFloat();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f14309a = false;
            this.b = 0.0f;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBooleanArray(new boolean[]{this.f14309a});
            parcel.writeFloat(this.b);
        }
    }

    public HorizonScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14308c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.f14307a = false;
        this.g = "";
        c();
        this.b = context;
    }

    public HorizonScrollTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14308c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.f14307a = false;
        this.g = "";
        c();
        this.b = context;
    }

    private void c() {
        setOnClickListener(this);
    }

    public void a() {
        this.f14307a = true;
        invalidate();
    }

    public void b() {
        this.f14307a = false;
        invalidate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.f14307a) {
            b();
        } else {
            a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.i, this.f, 0.0f, this.h);
        canvas.drawText(this.g, this.d, this.e, this.h);
        if (this.f14307a) {
            float f = this.d - 3.0f;
            this.d = f;
            this.f -= 3.0f;
            if (f <= (-this.f14308c)) {
                this.d = this.i.getWidth() + AppMethods.a(8);
                this.f = 0.0f;
                b();
                OnScrollListener onScrollListener = this.j;
                if (onScrollListener != null) {
                    onScrollListener.a();
                }
            }
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.d = savedState.b;
        this.f14307a = savedState.f14309a;
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.b = this.d;
        savedState.f14309a = this.f14307a;
        return savedState;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.j = onScrollListener;
    }
}
