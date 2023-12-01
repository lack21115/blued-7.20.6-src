package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiTextViewHelper.class */
public final class EmojiTextViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f2839a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiTextViewHelper$HelperInternal.class */
    static class HelperInternal {
        HelperInternal() {
        }

        TransformationMethod a(TransformationMethod transformationMethod) {
            return transformationMethod;
        }

        void a() {
        }

        void a(boolean z) {
        }

        InputFilter[] a(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        void b(boolean z) {
        }

        public boolean isEnabled() {
            return false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiTextViewHelper$HelperInternal19.class */
    static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f2840a;
        private final EmojiInputFilter b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2841c = true;

        HelperInternal19(TextView textView) {
            this.f2840a = textView;
            this.b = new EmojiInputFilter(textView);
        }

        private TransformationMethod b(TransformationMethod transformationMethod) {
            TransformationMethod transformationMethod2 = transformationMethod;
            if (transformationMethod instanceof EmojiTransformationMethod) {
                transformationMethod2 = ((EmojiTransformationMethod) transformationMethod).getOriginalTransformationMethod();
            }
            return transformationMethod2;
        }

        private void b() {
            this.f2840a.setFilters(a(this.f2840a.getFilters()));
        }

        private InputFilter[] b(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
                    System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
                    inputFilterArr2[length] = this.b;
                    return inputFilterArr2;
                } else if (inputFilterArr[i2] == this.b) {
                    return inputFilterArr;
                } else {
                    i = i2 + 1;
                }
            }
        }

        private TransformationMethod c(TransformationMethod transformationMethod) {
            if (!(transformationMethod instanceof EmojiTransformationMethod) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                return new EmojiTransformationMethod(transformationMethod);
            }
            return transformationMethod;
        }

        private InputFilter[] c(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> d = d(inputFilterArr);
            if (d.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - d.size()];
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= length) {
                    return inputFilterArr2;
                }
                int i4 = i3;
                if (d.indexOfKey(i) < 0) {
                    inputFilterArr2[i3] = inputFilterArr[i];
                    i4 = i3 + 1;
                }
                i++;
                i2 = i4;
            }
        }

        private SparseArray<InputFilter> d(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= inputFilterArr.length) {
                    return sparseArray;
                }
                if (inputFilterArr[i2] instanceof EmojiInputFilter) {
                    sparseArray.put(i2, inputFilterArr[i2]);
                }
                i = i2 + 1;
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        TransformationMethod a(TransformationMethod transformationMethod) {
            return this.f2841c ? c(transformationMethod) : b(transformationMethod);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void a() {
            this.f2840a.setTransformationMethod(a(this.f2840a.getTransformationMethod()));
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void a(boolean z) {
            if (z) {
                a();
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f2841c ? c(inputFilterArr) : b(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void b(boolean z) {
            this.f2841c = z;
            a();
            b();
        }

        void c(boolean z) {
            this.f2841c = z;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.f2841c;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiTextViewHelper$SkippingHelper19.class */
    static class SkippingHelper19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final HelperInternal19 f2842a;

        SkippingHelper19(TextView textView) {
            this.f2842a = new HelperInternal19(textView);
        }

        private boolean b() {
            return !EmojiCompat.isConfigured();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        TransformationMethod a(TransformationMethod transformationMethod) {
            return b() ? transformationMethod : this.f2842a.a(transformationMethod);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void a() {
            if (b()) {
                return;
            }
            this.f2842a.a();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void a(boolean z) {
            if (b()) {
                return;
            }
            this.f2842a.a(z);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return b() ? inputFilterArr : this.f2842a.a(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void b(boolean z) {
            if (b()) {
                this.f2842a.c(z);
            } else {
                this.f2842a.b(z);
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.f2842a.isEnabled();
        }
    }

    public EmojiTextViewHelper(TextView textView) {
        this(textView, true);
    }

    public EmojiTextViewHelper(TextView textView, boolean z) {
        Preconditions.checkNotNull(textView, "textView cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.f2839a = new HelperInternal();
        } else if (z) {
            this.f2839a = new HelperInternal19(textView);
        } else {
            this.f2839a = new SkippingHelper19(textView);
        }
    }

    public InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        return this.f2839a.a(inputFilterArr);
    }

    public boolean isEnabled() {
        return this.f2839a.isEnabled();
    }

    public void setAllCaps(boolean z) {
        this.f2839a.a(z);
    }

    public void setEnabled(boolean z) {
        this.f2839a.b(z);
    }

    public void updateTransformationMethod() {
        this.f2839a.a();
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
        return this.f2839a.a(transformationMethod);
    }
}
