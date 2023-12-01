package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieAnimationView.class */
public class LottieAnimationView extends AppCompatImageView {
    private static final String a = LottieAnimationView.class.getSimpleName();
    private final LottieListener<LottieComposition> b;
    private final LottieListener<Throwable> c;
    private final LottieDrawable d;
    private String e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private RenderMode j;
    private Set<LottieOnCompositionLoadedListener> k;
    private LottieTask<LottieComposition> l;
    private LottieComposition m;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.airbnb.lottie.LottieAnimationView$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieAnimationView$3.class */
    class AnonymousClass3<T> extends LottieValueCallback<T> {
        final /* synthetic */ SimpleLottieValueCallback a;

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public T a(LottieFrameInfo<T> lottieFrameInfo) {
            return (T) this.a.a(lottieFrameInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.LottieAnimationView$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieAnimationView$4.class */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[RenderMode.values().length];
            a = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieAnimationView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
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
        String a;
        int b;
        float c;
        boolean d;
        String e;
        int f;
        int g;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.c = parcel.readFloat();
            this.d = parcel.readInt() != 1 ? false : true;
            this.e = parcel.readString();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.b = new LottieListener<LottieComposition>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            public void a(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.c = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.LottieListener
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.d = new LottieDrawable();
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = RenderMode.AUTOMATIC;
        this.k = new HashSet();
        a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new LottieListener<LottieComposition>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            public void a(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.c = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.LottieListener
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.d = new LottieDrawable();
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = RenderMode.AUTOMATIC;
        this.k = new HashSet();
        a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new LottieListener<LottieComposition>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            public void a(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.c = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.LottieListener
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.d = new LottieDrawable();
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = RenderMode.AUTOMATIC;
        this.k = new HashSet();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView);
        boolean z = false;
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.h = true;
            this.i = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.d.e(-1);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        a(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            a(new KeyPath("**"), LottieProperty.B, new LottieValueCallback(new SimpleColorFilter(obtainStyledAttributes.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0))));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.d.e(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        LottieDrawable lottieDrawable = this.d;
        if (Utils.a(getContext()) != 0.0f) {
            z = true;
        }
        lottieDrawable.a(Boolean.valueOf(z));
        h();
    }

    private void f() {
        LottieTask<LottieComposition> lottieTask = this.l;
        if (lottieTask != null) {
            lottieTask.b(this.b);
            this.l.d(this.c);
        }
    }

    private void g() {
        this.m = null;
        this.d.d();
    }

    private void h() {
        LottieComposition lottieComposition;
        int i = AnonymousClass4.a[this.j.ordinal()];
        if (i == 1) {
            setLayerType(2, null);
        } else if (i == 2) {
            setLayerType(1, null);
        } else if (i != 3) {
        } else {
            LottieComposition lottieComposition2 = this.m;
            boolean z = false;
            if ((lottieComposition2 == null || !lottieComposition2.a() || Build.VERSION.SDK_INT >= 28) && ((lottieComposition = this.m) == null || lottieComposition.b() <= 4)) {
                z = true;
            }
            setLayerType(z ? 2 : 1, null);
        }
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        g();
        f();
        this.l = lottieTask.a(this.b).c(this.c);
    }

    public void a() {
        if (!isShown()) {
            this.g = true;
            return;
        }
        this.d.e();
        h();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.d.a(animatorListener);
    }

    public void a(JsonReader jsonReader, String str) {
        setCompositionTask(LottieCompositionFactory.a(jsonReader, str));
    }

    public <T> void a(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        this.d.a(keyPath, t, lottieValueCallback);
    }

    public void a(String str, String str2) {
        a(new JsonReader(new StringReader(str)), str2);
    }

    public void a(boolean z) {
        this.d.a(z);
    }

    public void b() {
        if (!isShown()) {
            this.g = true;
            return;
        }
        this.d.g();
        h();
    }

    public void buildDrawingCache(boolean z) {
        super.buildDrawingCache(z);
        if (getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
    }

    public boolean c() {
        return this.d.n();
    }

    public void d() {
        this.g = false;
        this.d.s();
        h();
    }

    public void e() {
        this.h = false;
        this.g = false;
        this.d.t();
        h();
    }

    public LottieComposition getComposition() {
        return this.m;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.m;
        if (lottieComposition != null) {
            return lottieComposition.e();
        }
        return 0L;
    }

    public int getFrame() {
        return this.d.k();
    }

    public String getImageAssetsFolder() {
        return this.d.b();
    }

    public float getMaxFrame() {
        return this.d.i();
    }

    public float getMinFrame() {
        return this.d.h();
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.d.c();
    }

    public float getProgress() {
        return this.d.u();
    }

    public int getRepeatCount() {
        return this.d.m();
    }

    public int getRepeatMode() {
        return this.d.l();
    }

    public float getScale() {
        return this.d.q();
    }

    public float getSpeed() {
        return this.d.j();
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.d;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i && this.h) {
            a();
        }
    }

    protected void onDetachedFromWindow() {
        if (c()) {
            d();
            this.h = true;
        }
        super.onDetachedFromWindow();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.a;
        this.e = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.e);
        }
        int i = savedState.b;
        this.f = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.c);
        if (savedState.d) {
            a();
        }
        this.d.a(savedState.e);
        setRepeatMode(savedState.f);
        setRepeatCount(savedState.g);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.e;
        savedState.b = this.f;
        savedState.c = this.d.u();
        savedState.d = this.d.n();
        savedState.e = this.d.b();
        savedState.f = this.d.l();
        savedState.g = this.d.m();
        return savedState;
    }

    protected void onVisibilityChanged(View view, int i) {
        if (this.d == null) {
            return;
        }
        if (isShown()) {
            if (this.g) {
                b();
                this.g = false;
            }
        } else if (c()) {
            e();
            this.g = true;
        }
    }

    public void setAnimation(int i) {
        this.f = i;
        this.e = null;
        setCompositionTask(LottieCompositionFactory.a(getContext(), i));
    }

    public void setAnimation(String str) {
        this.e = str;
        this.f = 0;
        setCompositionTask(LottieCompositionFactory.b(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        a(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(LottieCompositionFactory.a(getContext(), str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setComposition(LottieComposition lottieComposition) {
        if (L.a) {
            String str = a;
            Log.v(str, "Set Composition \n" + lottieComposition);
        }
        this.d.setCallback(this);
        this.m = lottieComposition;
        boolean a2 = this.d.a(lottieComposition);
        h();
        if (getDrawable() != this.d || a2) {
            setImageDrawable(null);
            setImageDrawable(this.d);
            requestLayout();
            for (LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener : this.k) {
                lottieOnCompositionLoadedListener.a(lottieComposition);
            }
        }
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.d.a(fontAssetDelegate);
    }

    public void setFrame(int i) {
        this.d.c(i);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.d.a(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.d.a(str);
    }

    public void setImageBitmap(Bitmap bitmap) {
        f();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        f();
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i) {
        f();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.d.b(i);
    }

    public void setMaxFrame(String str) {
        this.d.c(str);
    }

    public void setMaxProgress(float f) {
        this.d.b(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.d.d(str);
    }

    public void setMinFrame(int i) {
        this.d.a(i);
    }

    public void setMinFrame(String str) {
        this.d.b(str);
    }

    public void setMinProgress(float f) {
        this.d.a(f);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.d.b(z);
    }

    public void setProgress(float f) {
        this.d.d(f);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.j = renderMode;
        h();
    }

    public void setRepeatCount(int i) {
        this.d.e(i);
    }

    public void setRepeatMode(int i) {
        this.d.d(i);
    }

    public void setScale(float f) {
        this.d.e(f);
        if (getDrawable() == this.d) {
            setImageDrawable(null);
            setImageDrawable(this.d);
        }
    }

    public void setSpeed(float f) {
        this.d.c(f);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.d.a(textDelegate);
    }
}
