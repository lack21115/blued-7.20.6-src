package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/inputmethod/InputContentInfoCompat.class */
public final class InputContentInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    private final InputContentInfoCompatImpl f2738a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/inputmethod/InputContentInfoCompat$InputContentInfoCompatApi25Impl.class */
    static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f2739a;

        InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f2739a = new InputContentInfo(uri, clipDescription, uri2);
        }

        InputContentInfoCompatApi25Impl(Object obj) {
            this.f2739a = (InputContentInfo) obj;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getContentUri() {
            return this.f2739a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.f2739a.getDescription();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object getInputContentInfo() {
            return this.f2739a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getLinkUri() {
            return this.f2739a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
            this.f2739a.releasePermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
            this.f2739a.requestPermission();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/inputmethod/InputContentInfoCompat$InputContentInfoCompatBaseImpl.class */
    static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f2740a;
        private final ClipDescription b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f2741c;

        InputContentInfoCompatBaseImpl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f2740a = uri;
            this.b = clipDescription;
            this.f2741c = uri2;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getContentUri() {
            return this.f2740a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.b;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object getInputContentInfo() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getLinkUri() {
            return this.f2741c;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/inputmethod/InputContentInfoCompat$InputContentInfoCompatImpl.class */
    interface InputContentInfoCompatImpl {
        Uri getContentUri();

        ClipDescription getDescription();

        Object getInputContentInfo();

        Uri getLinkUri();

        void releasePermission();

        void requestPermission();
    }

    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f2738a = new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.f2738a = new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.f2738a = inputContentInfoCompatImpl;
    }

    public static InputContentInfoCompat wrap(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
        }
        return null;
    }

    public Uri getContentUri() {
        return this.f2738a.getContentUri();
    }

    public ClipDescription getDescription() {
        return this.f2738a.getDescription();
    }

    public Uri getLinkUri() {
        return this.f2738a.getLinkUri();
    }

    public void releasePermission() {
        this.f2738a.releasePermission();
    }

    public void requestPermission() {
        this.f2738a.requestPermission();
    }

    public Object unwrap() {
        return this.f2738a.getInputContentInfo();
    }
}
