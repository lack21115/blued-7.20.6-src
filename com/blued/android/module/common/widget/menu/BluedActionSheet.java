package com.blued.android.module.common.widget.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.databinding.DialogActionSheetBluedBinding;
import com.blued.android.module.common.widget.menu.BluedActionSheet;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet.class */
public class BluedActionSheet extends BottomSheetDialog implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, LifecycleOwner {

    /* renamed from: c  reason: collision with root package name */
    private final ListenersWrapper<BluedActionSheet> f11208c;
    private final LifecycleRegistry d;
    private List<OnShowListener> e;
    private List<OnCancelListener> f;
    private List<OnDismissListener> g;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$ActionSheetListener.class */
    public interface ActionSheetListener {
        void a(BluedActionSheet bluedActionSheet, int i);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        protected DialogActionSheetBluedBinding f11209a;
        ArrayList<ActionSheetItem> b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f11210c;
        private ActionSheetAdapter d;
        private BluedActionSheet e;
        private View f;
        private View g;
        private ShapeTextView h;
        private int i = R.style.BluedActionSheetDialogStyle;
        private boolean j = true;
        private float k = 0.5f;
        private boolean l = true;
        private boolean m = true;
        private boolean n = true;
        private boolean o = true;
        private List<OnShowListener> p;
        private List<OnCancelListener> q;
        private List<OnDismissListener> r;
        private OnKeyListener s;
        private OnClickActionSheetListener t;
        private OnClickActionSheetListener u;

        public Builder(Context context) {
            this.f11210c = context;
            a();
            g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            OnClickActionSheetListener onClickActionSheetListener = this.u;
            if (onClickActionSheetListener != null) {
                onClickActionSheetListener.onClickActionSheet(this.e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            OnClickActionSheetListener onClickActionSheetListener = this.t;
            if (onClickActionSheetListener != null) {
                onClickActionSheetListener.onClickActionSheet(this.e);
            }
            if (this.o) {
                e();
            }
        }

        private void g() {
            this.f11209a.b.setLayoutManager(new LinearLayoutManager(getContext()));
            this.d = new ActionSheetAdapter(null);
            this.f11209a.b.setAdapter(this.d);
            ShapeHelper.b(this.f11209a.f10713c, R.color.syc_b);
            ShapeHelper.c(this.f11209a.f10713c, R.color.syc_c);
            this.f11209a.f10713c.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
            this.f11209a.f10713c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.menu.-$$Lambda$BluedActionSheet$Builder$73DTjMTm1WXOHsn3urFA517uPWU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BluedActionSheet.Builder.this.c(view);
                }
            });
            View inflate = LayoutInflater.from(this.f11210c).inflate(R.layout.dialog_action_sheet_blued_title, (ViewGroup) null, false);
            this.g = inflate;
            ShapeTextView shapeTextView = (ShapeTextView) inflate.findViewById(R.id.stv_title);
            this.h = shapeTextView;
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.menu.-$$Lambda$BluedActionSheet$Builder$wa1DwObp9D3_plEuNJaOCQ1Ok_U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BluedActionSheet.Builder.this.b(view);
                }
            });
        }

        private BluedActionSheet h() {
            if (this.f != null) {
                BluedActionSheet a2 = a(this.f11210c, this.i);
                this.e = a2;
                a2.setContentView(this.f);
                this.e.setCancelable(this.l);
                if (this.l) {
                    this.e.setCanceledOnTouchOutside(this.n);
                }
                Window window = this.e.getWindow();
                if (window != null) {
                    window.setAttributes(window.getAttributes());
                    if (this.j) {
                        window.addFlags(2);
                        window.setDimAmount(this.k);
                    } else {
                        window.clearFlags(2);
                    }
                }
                List<OnShowListener> list = this.p;
                if (list != null) {
                    this.e.a(list);
                }
                List<OnCancelListener> list2 = this.q;
                if (list2 != null) {
                    this.e.b(list2);
                }
                List<OnDismissListener> list3 = this.r;
                if (list3 != null) {
                    this.e.c(list3);
                }
                OnKeyListener onKeyListener = this.s;
                if (onKeyListener != null) {
                    this.e.a(onKeyListener);
                }
                return this.e;
            }
            throw new IllegalArgumentException("are you ok?");
        }

        public Builder a() {
            DialogActionSheetBluedBinding a2 = DialogActionSheetBluedBinding.a(LayoutInflater.from(this.f11210c), new FrameLayout(this.f11210c), false);
            this.f11209a = a2;
            return a(a2.getRoot());
        }

        public Builder a(View view) {
            this.f = view;
            if (f()) {
                this.e.setContentView(view);
            }
            return this;
        }

        public Builder a(ActionSheetItem actionSheetItem) {
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            this.b.add(actionSheetItem);
            return a(this.b);
        }

        public Builder a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.d.removeAllHeaderView();
            } else {
                this.h.setText(str);
                this.d.addHeaderView(this.g);
            }
            this.d.notifyDataSetChanged();
            return this;
        }

        public Builder a(String str, OnClickActionSheetListener onClickActionSheetListener) {
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            this.b.add(ActionSheetDefaultItem.a().a(str).b(onClickActionSheetListener));
            return a(this.b);
        }

        public Builder a(List<ActionSheetItem> list) {
            if (this.d != null) {
                ArrayList arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList();
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    int i3 = i2 + 1;
                    arrayList.get(i2).b = i3;
                    arrayList.get(i2).f11205c = this;
                    i = i3;
                }
                this.d.setNewData(arrayList);
            }
            return this;
        }

        protected BluedActionSheet a(Context context, int i) {
            return new BluedActionSheet(context, i);
        }

        public BluedActionSheet b() {
            return this.e;
        }

        public boolean c() {
            return this.m;
        }

        public BluedActionSheet d() {
            if (!f()) {
                h();
            }
            this.e.show();
            return this.e;
        }

        public void e() {
            BluedActionSheet bluedActionSheet = this.e;
            if (bluedActionSheet != null) {
                bluedActionSheet.dismiss();
            }
        }

        public boolean f() {
            return this.e != null;
        }

        public Context getContext() {
            return this.f11210c;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$CancelListenerWrapper.class */
    static final class CancelListenerWrapper extends SoftReference<DialogInterface.OnCancelListener> implements OnCancelListener {
        private CancelListenerWrapper(DialogInterface.OnCancelListener onCancelListener) {
            super(onCancelListener);
        }

        @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnCancelListener
        public void a(BluedActionSheet bluedActionSheet) {
            if (get() != null) {
                get().onCancel(bluedActionSheet);
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$DismissListenerWrapper.class */
    static final class DismissListenerWrapper extends SoftReference<DialogInterface.OnDismissListener> implements OnDismissListener {
        private DismissListenerWrapper(DialogInterface.OnDismissListener onDismissListener) {
            super(onDismissListener);
        }

        @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnDismissListener
        public void a(BluedActionSheet bluedActionSheet) {
            if (get() != null) {
                get().onDismiss(bluedActionSheet);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$KeyListenerWrapper.class */
    public static final class KeyListenerWrapper implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        private final OnKeyListener f11211a;

        private KeyListenerWrapper(OnKeyListener onKeyListener) {
            this.f11211a = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            OnKeyListener onKeyListener = this.f11211a;
            if (onKeyListener == null || !(dialogInterface instanceof BluedActionSheet)) {
                return false;
            }
            onKeyListener.a((BluedActionSheet) dialogInterface, keyEvent);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$ListenersWrapper.class */
    public static final class ListenersWrapper<T extends DialogInterface.OnShowListener & DialogInterface.OnCancelListener & DialogInterface.OnDismissListener> extends SoftReference<T> implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
        private ListenersWrapper(T t) {
            super(t);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (get() != 0) {
                ((DialogInterface.OnCancelListener) ((DialogInterface.OnShowListener) get())).onCancel(dialogInterface);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (get() != 0) {
                ((DialogInterface.OnDismissListener) ((DialogInterface.OnShowListener) get())).onDismiss(dialogInterface);
            }
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (get() != 0) {
                ((DialogInterface.OnShowListener) get()).onShow(dialogInterface);
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$OnCancelListener.class */
    public interface OnCancelListener {
        void a(BluedActionSheet bluedActionSheet);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$OnClickActionSheetListener.class */
    public interface OnClickActionSheetListener {
        void onClickActionSheet(BluedActionSheet bluedActionSheet);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$OnClickListener.class */
    public interface OnClickListener<V extends View> {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$OnDismissListener.class */
    public interface OnDismissListener {
        void a(BluedActionSheet bluedActionSheet);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$OnKeyListener.class */
    public interface OnKeyListener {
        boolean a(BluedActionSheet bluedActionSheet, KeyEvent keyEvent);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$OnShowListener.class */
    public interface OnShowListener {
        void a(BluedActionSheet bluedActionSheet);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BluedActionSheet$ShowListenerWrapper.class */
    static final class ShowListenerWrapper extends SoftReference<DialogInterface.OnShowListener> implements OnShowListener {
        private ShowListenerWrapper(DialogInterface.OnShowListener onShowListener) {
            super(onShowListener);
        }

        @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnShowListener
        public void a(BluedActionSheet bluedActionSheet) {
            if (get() != null) {
                get().onShow(bluedActionSheet);
            }
        }
    }

    public BluedActionSheet(Context context, int i) {
        super(context, i);
        this.f11208c = new ListenersWrapper<>(this);
        this.d = new LifecycleRegistry(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<OnShowListener> list) {
        super.setOnShowListener(this.f11208c);
        this.e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<OnCancelListener> list) {
        super.setOnCancelListener(this.f11208c);
        this.f = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<OnDismissListener> list) {
        super.setOnDismissListener(this.f11208c);
        this.g = list;
    }

    public void a(OnCancelListener onCancelListener) {
        if (this.f == null) {
            this.f = new ArrayList();
            super.setOnCancelListener(this.f11208c);
        }
        this.f.add(onCancelListener);
    }

    public void a(OnDismissListener onDismissListener) {
        if (this.g == null) {
            this.g = new ArrayList();
            super.setOnDismissListener(this.f11208c);
        }
        this.g.add(onDismissListener);
    }

    public void a(OnKeyListener onKeyListener) {
        super.setOnKeyListener(new KeyListenerWrapper(onKeyListener));
    }

    public void a(OnShowListener onShowListener) {
        if (this.e == null) {
            this.e = new ArrayList();
            super.setOnShowListener(this.f11208c);
        }
        this.e.add(onShowListener);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) ContextCompat.getSystemService(getContext(), InputMethodManager.class)).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        super.dismiss();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.d;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f.size()) {
                return;
            }
            this.f.get(i2).a(this);
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        if (this.g == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return;
            }
            this.g.get(i2).a(this);
            i = i2 + 1;
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (this.e == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return;
            }
            this.e.get(i2).a(this);
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        if (onCancelListener == null) {
            return;
        }
        a(new CancelListenerWrapper(onCancelListener));
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener == null) {
            return;
        }
        a(new DismissListenerWrapper(onDismissListener));
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        super.setOnKeyListener(onKeyListener);
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        if (onShowListener == null) {
            return;
        }
        a(new ShowListenerWrapper(onShowListener));
    }
}
