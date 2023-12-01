package com.blued.android.module.common.utils.freedom;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.freedom.clickcallback.onViewRecycledCallback;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/freedom/BaseViewHolder.class */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public FreedomAdapter f10931a;
    public IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    public onViewRecycledCallback f10932c;
    private final SparseArray<View> d;

    public BaseViewHolder(FreedomAdapter freedomAdapter, View view, IRequestHost iRequestHost) {
        super(view);
        this.f10931a = freedomAdapter;
        this.d = new SparseArray<>();
        this.b = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean f(View view) {
        FreedomAdapter freedomAdapter = this.f10931a;
        if (freedomAdapter == null || freedomAdapter.b() == null) {
            return false;
        }
        int adapterPosition = getAdapterPosition();
        int i = adapterPosition;
        if (this.f10931a.f10934c) {
            i = adapterPosition;
            if (this.f10931a.f10933a != null) {
                i = adapterPosition % this.f10931a.f10933a.size();
            }
        }
        this.f10931a.b().onLongClick(view, i, this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        FreedomAdapter freedomAdapter = this.f10931a;
        if (freedomAdapter == null || freedomAdapter.a() == null) {
            return;
        }
        int adapterPosition = getAdapterPosition();
        int i = adapterPosition;
        if (this.f10931a.f10934c) {
            i = adapterPosition;
            if (this.f10931a.f10933a != null) {
                i = adapterPosition % this.f10931a.f10933a.size();
            }
        }
        this.f10931a.a().onClick(view, i, this);
    }

    public <T extends View> T a(int i) {
        View view = this.d.get(i);
        View view2 = view;
        if (view == null) {
            view2 = this.itemView.findViewById(i);
            this.d.put(i, view2);
        }
        return (T) view2;
    }

    public BaseViewHolder a(int i, float f) {
        a(a(i), f);
        return this;
    }

    public BaseViewHolder a(int i, int i2) {
        View a2 = a(i);
        if (a2 != null && (a2 instanceof TextView)) {
            ((TextView) a2).setText(i2);
        }
        return this;
    }

    public BaseViewHolder a(int i, View.OnClickListener onClickListener) {
        a(a(i), onClickListener);
        return this;
    }

    public BaseViewHolder a(int i, CharSequence charSequence) {
        View a2 = a(i);
        if (a2 != null && (a2 instanceof TextView)) {
            a((TextView) a2, charSequence);
        }
        return this;
    }

    public BaseViewHolder a(int i, String str) {
        a((ImageView) a(i), str, 0, false, 0.0f, 0, false, -1);
        return this;
    }

    public BaseViewHolder a(int i, String str, int i2) {
        a((ImageView) a(i), str, i2, false, 0.0f, 0, false, -1);
        return this;
    }

    public BaseViewHolder a(int i, String str, int i2, boolean z) {
        a((ImageView) a(i), str, i2, z, 0.0f, 0, false, -1);
        return this;
    }

    public BaseViewHolder a(int i, String str, int i2, boolean z, float f, int i3) {
        a((ImageView) a(i), str, i2, z, f, i3, false, -1);
        return this;
    }

    public BaseViewHolder a(int i, String str, int i2, boolean z, float f, int i3, String str2) {
        a((ImageView) a(i), str, i2, z, f, i3, false, -1, str2);
        return this;
    }

    public BaseViewHolder a(int i, String str, boolean z, int i2) {
        a((ImageView) a(i), str, 0, false, 0.0f, 0, z, i2);
        return this;
    }

    public BaseViewHolder a(int i, boolean z) {
        View a2 = a(i);
        if (a2 != null && (a2 instanceof TextView)) {
            a((TextView) a2, z);
        }
        return this;
    }

    public BaseViewHolder a(View.OnClickListener onClickListener) {
        a(this.itemView, onClickListener);
        return this;
    }

    public BaseViewHolder a(View view) {
        if (view != null && !b(view)) {
            view.setVisibility(8);
        }
        return this;
    }

    public BaseViewHolder a(View view, float f) {
        if (view != null && view.getAlpha() != f) {
            view.setAlpha(f);
        }
        return this;
    }

    public BaseViewHolder a(View view, int i) {
        if (view != null) {
            view.setBackgroundResource(i);
        }
        return this;
    }

    public BaseViewHolder a(View view, View.OnClickListener onClickListener) {
        if (view != null && onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
        return this;
    }

    public BaseViewHolder a(View view, View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null) {
            view.setOnLongClickListener(onLongClickListener);
        }
        return this;
    }

    public BaseViewHolder a(View view, boolean z) {
        if (view != null) {
            if (z && view.getVisibility() != 0) {
                view.setVisibility(0);
                return this;
            } else if (!z && view.getVisibility() != 8) {
                view.setVisibility(8);
            }
        }
        return this;
    }

    public BaseViewHolder a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        return this;
    }

    public BaseViewHolder a(ImageView imageView, String str, int i, boolean z) {
        a(imageView, str, i, z, 0.0f, 0, false, -1);
        return this;
    }

    public BaseViewHolder a(ImageView imageView, String str, int i, boolean z, float f, int i2, boolean z2, int i3) {
        if (imageView != null) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            ImageWrapper a2 = ImageLoader.a(this.b, str);
            a2.b(i);
            if (z) {
                if (f <= 0.0f) {
                    a2.c();
                } else {
                    a2.a(f, i2);
                }
            }
            if (z2) {
                a2.g();
                a2.g(i3);
            }
            a2.c(300);
            a2.a(imageView);
        }
        return this;
    }

    public BaseViewHolder a(ImageView imageView, String str, int i, boolean z, float f, int i2, boolean z2, int i3, String str2) {
        if (imageView == null) {
            return this;
        }
        String str3 = str;
        float f2 = f;
        if (TextUtils.isEmpty(str)) {
            str3 = str;
            f2 = f;
            if (!TextUtils.isEmpty(str2)) {
                f2 = 0.0f;
                str3 = str2;
            }
        }
        ImageWrapper a2 = ImageLoader.a(this.b, str3);
        a2.b(i);
        if (z) {
            if (f2 <= 0.0f) {
                a2.c();
            } else {
                a2.a(f2, i2);
            }
        }
        if (z2) {
            a2.g();
            a2.g(i3);
        }
        a2.c(300);
        a2.a(imageView);
        return this;
    }

    public BaseViewHolder a(ImageView imageView, String str, boolean z, int i) {
        a(imageView, str, 0, false, 0.0f, 0, z, i);
        return this;
    }

    public BaseViewHolder a(TextView textView, int i) {
        if (textView != null) {
            textView.setText(i);
        }
        return this;
    }

    public BaseViewHolder a(TextView textView, CharSequence charSequence) {
        if (textView != null) {
            CharSequence charSequence2 = charSequence;
            if (charSequence == null) {
                charSequence2 = "";
            }
            textView.setText(charSequence2);
        }
        return this;
    }

    public BaseViewHolder a(TextView textView, boolean z) {
        if (textView != null) {
            textView.getPaint().setFakeBoldText(z);
        }
        return this;
    }

    public CharSequence a(TextView textView) {
        return textView != null ? textView.getText() : "";
    }

    public void a() {
        onViewRecycledCallback onviewrecycledcallback = this.f10932c;
        if (onviewrecycledcallback != null) {
            onviewrecycledcallback.a();
        }
    }

    public BaseViewHolder b() {
        a(this.itemView, new View.OnClickListener() { // from class: com.blued.android.module.common.utils.freedom.-$$Lambda$BaseViewHolder$18ihjGMRkNmoP71RWuZjzKfmSe0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseViewHolder.this.g(view);
            }
        });
        return this;
    }

    public BaseViewHolder b(int i, int i2) {
        View a2 = a(i);
        if (a2 != null && (a2 instanceof TextView)) {
            b((TextView) a2, i2);
        }
        return this;
    }

    public BaseViewHolder b(int i, boolean z) {
        a(a(i), z);
        return this;
    }

    public BaseViewHolder b(View view, boolean z) {
        if (view != null) {
            view.setClickable(z);
        }
        return this;
    }

    public BaseViewHolder b(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(i);
        }
        return this;
    }

    public CharSequence b(int i) {
        return a((TextView) a(i));
    }

    public boolean b(View view) {
        boolean z = false;
        if (view != null) {
            z = false;
            if (view.getVisibility() == 8) {
                z = true;
            }
        }
        return z;
    }

    public BaseViewHolder c() {
        e(this.itemView);
        return this;
    }

    public BaseViewHolder c(int i) {
        a(a(i));
        return this;
    }

    public BaseViewHolder c(int i, int i2) {
        View a2 = a(i);
        if (a2 != null && (a2 instanceof ImageView)) {
            a((ImageView) a2, i2);
        }
        return this;
    }

    public BaseViewHolder c(int i, boolean z) {
        b(a(i), z);
        return this;
    }

    public BaseViewHolder c(View view) {
        if (view != null && !d(view)) {
            view.setVisibility(0);
        }
        return this;
    }

    public BaseViewHolder d(int i) {
        c(a(i));
        return this;
    }

    public BaseViewHolder d(int i, int i2) {
        a(a(i), i2);
        return this;
    }

    public boolean d(View view) {
        boolean z = false;
        if (view != null) {
            z = false;
            if (view.getVisibility() == 0) {
                z = true;
            }
        }
        return z;
    }

    public BaseViewHolder e(View view) {
        a(view, new View.OnLongClickListener() { // from class: com.blued.android.module.common.utils.freedom.-$$Lambda$BaseViewHolder$gdIVWCNHR1kHN1r-vbfCgzQn4OU
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean f;
                f = BaseViewHolder.this.f(view2);
                return f;
            }
        });
        return this;
    }
}
