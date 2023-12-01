package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifViewSavedState.class */
public class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new Parcelable.Creator<GifViewSavedState>() { // from class: pl.droidsonroids.gif.GifViewSavedState.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GifViewSavedState[] newArray(int i) {
            return new GifViewSavedState[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final long[][] f44151a;

    /* JADX WARN: Type inference failed for: r1v3, types: [long[], long[][]] */
    private GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f44151a = new long[parcel.readInt()];
        int i = 0;
        while (true) {
            int i2 = i;
            long[][] jArr = this.f44151a;
            if (i2 >= jArr.length) {
                return;
            }
            jArr[i2] = parcel.createLongArray();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v2, types: [long[], long[][]] */
    public GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f44151a = r0;
        ?? r0 = {jArr};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r1v3, types: [long[], long[][]] */
    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f44151a = new long[drawableArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable instanceof GifDrawable) {
                this.f44151a[i2] = ((GifDrawable) drawable).f.m();
            } else {
                this.f44151a[i2] = null;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable, int i) {
        if (this.f44151a[i] == null || !(drawable instanceof GifDrawable)) {
            return;
        }
        GifDrawable gifDrawable = (GifDrawable) drawable;
        gifDrawable.a(gifDrawable.f.a(this.f44151a[i], gifDrawable.e));
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f44151a.length);
        long[][] jArr = this.f44151a;
        int length = jArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            parcel.writeLongArray(jArr[i3]);
            i2 = i3 + 1;
        }
    }
}
