package com.blued.android.kbswitch;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.kbswitch.KBConstants;
import com.blued.android.kbswitch.KeyboardHelper;
import com.blued.android.kbswitch.listener.KeyboardHeightChangedListener;
import com.blued.android.kbswitch.listener.KeyboardStatusListener;
import com.blued.android.kbswitch.listener.SwitchPreHandleListener;
import com.blued.android.kbswitch.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/KeyboardHelper.class */
public final class KeyboardHelper {
    public static final Companion a = new Companion(null);
    private final Activity b;
    private KeyboardPop c;
    private KeyboardConstraintLayout d;
    private View e;
    private EditText f;
    private View g;
    private RecyclerView h;
    private View i;
    private int j;
    private boolean k;
    private Pair<Boolean, Boolean> l;
    private List<? extends Pair<? extends View, ? extends View>> m;
    private SwitchPreHandleListener n;
    private KeyboardStatusListener o;

    @Metadata
    /* renamed from: com.blued.android.kbswitch.KeyboardHelper$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/KeyboardHelper$1.class */
    public static final class AnonymousClass1 implements LifecycleObserver {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(KeyboardHelper this$0) {
            Intrinsics.e(this$0, "this$0");
            KeyboardPop keyboardPop = this$0.c;
            KeyboardPop keyboardPop2 = keyboardPop;
            if (keyboardPop == null) {
                Intrinsics.c("keyboardPop");
                keyboardPop2 = null;
            }
            keyboardPop2.a();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public final void onCreate(LifecycleOwner owner) {
            Intrinsics.e(owner, "owner");
            KeyboardHelper.this.b.getWindow().setSoftInputMode(51);
            View parentView = KeyboardHelper.this.b.findViewById(16908290);
            KeyboardHelper keyboardHelper = KeyboardHelper.this;
            Activity activity = KeyboardHelper.this.b;
            Intrinsics.c(parentView, "parentView");
            keyboardHelper.c = new KeyboardPop(activity, parentView);
            KeyboardPop keyboardPop = KeyboardHelper.this.c;
            KeyboardPop keyboardPop2 = keyboardPop;
            if (keyboardPop == null) {
                Intrinsics.c("keyboardPop");
                keyboardPop2 = null;
            }
            final KeyboardHelper keyboardHelper2 = KeyboardHelper.this;
            keyboardPop2.a(new KeyboardHeightChangedListener() { // from class: com.blued.android.kbswitch.KeyboardHelper$1$onCreate$1
                @Override // com.blued.android.kbswitch.listener.KeyboardHeightChangedListener
                public void a(int i, int i2) {
                    KeyboardHelper.this.a(i, i2);
                }
            });
            final KeyboardHelper keyboardHelper3 = KeyboardHelper.this;
            parentView.post(new Runnable() { // from class: com.blued.android.kbswitch.-$$Lambda$KeyboardHelper$1$uCk1EkpjkA6NszSuScAdHxHPtHs
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardHelper.AnonymousClass1.a(KeyboardHelper.this);
                }
            });
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy(LifecycleOwner owner) {
            Intrinsics.e(owner, "owner");
            KeyboardPop keyboardPop = KeyboardHelper.this.c;
            KeyboardPop keyboardPop2 = keyboardPop;
            if (keyboardPop == null) {
                Intrinsics.c("keyboardPop");
                keyboardPop2 = null;
            }
            keyboardPop2.a(null);
            KeyboardPop keyboardPop3 = KeyboardHelper.this.c;
            if (keyboardPop3 == null) {
                Intrinsics.c("keyboardPop");
                keyboardPop3 = null;
            }
            keyboardPop3.dismiss();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public final void onStop(LifecycleOwner owner) {
            Intrinsics.e(owner, "owner");
            if ((owner instanceof Activity) && ((Activity) owner).isFinishing()) {
                KeyboardPop keyboardPop = KeyboardHelper.this.c;
                KeyboardPop keyboardPop2 = keyboardPop;
                if (keyboardPop == null) {
                    Intrinsics.c("keyboardPop");
                    keyboardPop2 = null;
                }
                keyboardPop2.a(null);
                KeyboardHelper.this.c();
            }
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/KeyboardHelper$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KeyboardHelper a(Activity activity) {
            Intrinsics.e(activity, "activity");
            return new KeyboardHelper(activity, null);
        }
    }

    private KeyboardHelper(Activity activity) {
        this.b = activity;
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity) activity).getLifecycle().addObserver(new AnonymousClass1());
        }
    }

    public /* synthetic */ KeyboardHelper(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    private final void a(final int i) {
        View view = null;
        if (i == 4 || i == 5) {
            RecyclerView recyclerView = this.g;
            if (recyclerView instanceof RecyclerView) {
                if (recyclerView == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                }
                UtilsKt.a(recyclerView, false, false, 3, (Object) null);
            }
        }
        if (!this.k) {
            View view2 = this.e;
            if (view2 == null) {
                Intrinsics.c("panelView");
            } else {
                view = view2;
            }
            UtilsKt.a(view);
        }
        a(k(), this.k, this.b.getResources().getConfiguration().orientation);
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.blued.android.kbswitch.-$$Lambda$KeyboardHelper$KHoHFUP7Ez8888rzWWPEqMl1jg8
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardHelper.a(KeyboardHelper.this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2) {
        if (i > 0) {
            this.j = i;
        }
        if (!(i > 0) && this.k) {
            a(1);
            return;
        }
        int i3 = i > 0 ? this.k ? 3 : 4 : 0;
        this.k = false;
        a(i3);
    }

    private final void a(View view) {
        boolean z;
        boolean z2 = false;
        if (!this.k) {
            SwitchPreHandleListener switchPreHandleListener = this.n;
            if (switchPreHandleListener != null && switchPreHandleListener.a(this, view, false, true)) {
                z2 = true;
            }
            if (z2) {
                return;
            }
            view.setSelected(true);
            b(view);
            i();
            return;
        }
        View view2 = this.e;
        View view3 = view2;
        if (view2 == null) {
            Intrinsics.c("panelView");
            view3 = null;
        }
        if (UtilsKt.a(view3, view)) {
            SwitchPreHandleListener switchPreHandleListener2 = this.n;
            if (switchPreHandleListener2 == null) {
                z = false;
            } else {
                z = false;
                if (switchPreHandleListener2.a(this, view, true, false)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            h();
            j();
            return;
        }
        SwitchPreHandleListener switchPreHandleListener3 = this.n;
        if (switchPreHandleListener3 != null && switchPreHandleListener3.a(this, view, false, true)) {
            return;
        }
        h();
        view.setSelected(true);
        b(view);
        KeyboardStatusListener keyboardStatusListener = this.o;
        if (keyboardStatusListener != null) {
            keyboardStatusListener.a(this, false, true, this.b.getResources().getConfiguration().orientation);
        }
        a(6);
    }

    private final void a(View view, Activity activity) {
        Object systemService = activity.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (view != null) {
            view.requestFocus();
        }
        inputMethodManager.showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(KeyboardHelper this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        KeyboardConstraintLayout keyboardConstraintLayout = this$0.d;
        KeyboardConstraintLayout keyboardConstraintLayout2 = keyboardConstraintLayout;
        if (keyboardConstraintLayout == null) {
            Intrinsics.c("keyboardLayout");
            keyboardConstraintLayout2 = null;
        }
        keyboardConstraintLayout2.a(this$0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(KeyboardHelper this$0, View v) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(v, "v");
        this$0.a(v);
    }

    private final void a(boolean z, boolean z2, int i) {
        Pair<Boolean, Boolean> pair = this.l;
        if (pair != null && pair.a().booleanValue() == z && pair.b().booleanValue() == z2) {
            return;
        }
        this.l = new Pair<>(Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z) {
            h();
        }
        KeyboardStatusListener keyboardStatusListener = this.o;
        if (keyboardStatusListener == null) {
            return;
        }
        keyboardStatusListener.a(this, z, z2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(View view, MotionEvent motionEvent) {
        if (l()) {
            return view != null ? (!(view instanceof ViewGroup) || motionEvent == null) ? a(CollectionsKt.a(view), this) : a(UtilsKt.a((ViewGroup) view, motionEvent, true, (Integer) 0, (int[]) null, 8, (Object) null), this) : c();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(KeyboardHelper this$0, View it, View view, MotionEvent motionEvent) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        if (motionEvent.getAction() == 0) {
            this$0.a(it, motionEvent);
            return false;
        }
        return false;
    }

    private static final boolean a(List<? extends View> list, KeyboardHelper keyboardHelper) {
        boolean z;
        List<? extends View> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<? extends View> it = list2.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                } else if (!(!UtilsKt.c(it.next()))) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf == null) {
            return false;
        }
        valueOf.booleanValue();
        return Boolean.valueOf(keyboardHelper.c()).booleanValue();
    }

    private final void b(View view) {
        List<? extends Pair<? extends View, ? extends View>> list = this.m;
        if (list != null) {
            for (Pair<? extends View, ? extends View> pair : list) {
                if (pair.a().getId() == view.getId()) {
                    View b = pair.b();
                    this.i = b;
                    if (b != null) {
                        View view2 = this.e;
                        View view3 = view2;
                        if (view2 == null) {
                            Intrinsics.c("panelView");
                            view3 = null;
                        }
                        view3.setBackground(b.getBackground());
                    }
                    View view4 = this.i;
                    if (view4 != null) {
                        view4.setVisibility(0);
                    }
                } else {
                    View b2 = pair.b();
                    if (b2 != null) {
                        b2.setVisibility(4);
                    }
                }
            }
        }
        View view5 = this.e;
        if (view5 == null) {
            Intrinsics.c("panelView");
            view5 = null;
        }
        UtilsKt.a(view5, view.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(KeyboardHelper this$0, View v) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(v, "v");
        this$0.a(v);
    }

    private final boolean f() {
        KeyboardPop keyboardPop = this.c;
        KeyboardPop keyboardPop2 = keyboardPop;
        if (keyboardPop == null) {
            Intrinsics.c("keyboardPop");
            keyboardPop2 = null;
        }
        if (keyboardPop2.b()) {
            UtilsKt.a(this.f, this.b);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g() {
        if (this.k) {
            this.k = false;
            a(2);
            return true;
        }
        return false;
    }

    private final void h() {
        List<? extends Pair<? extends View, ? extends View>> list = this.m;
        if (list == null) {
            return;
        }
        for (Pair<? extends View, ? extends View> pair : list) {
            pair.a().setSelected(false);
            View b = pair.b();
            if (b != null) {
                b.setVisibility(4);
            }
        }
    }

    private final boolean i() {
        if (this.k) {
            return false;
        }
        this.k = true;
        KeyboardPop keyboardPop = this.c;
        KeyboardPop keyboardPop2 = keyboardPop;
        if (keyboardPop == null) {
            Intrinsics.c("keyboardPop");
            keyboardPop2 = null;
        }
        if (keyboardPop2.b()) {
            UtilsKt.a(this.f, this.b);
            return true;
        }
        a(5);
        return true;
    }

    private final boolean j() {
        KeyboardPop keyboardPop = this.c;
        KeyboardPop keyboardPop2 = keyboardPop;
        if (keyboardPop == null) {
            Intrinsics.c("keyboardPop");
            keyboardPop2 = null;
        }
        if (keyboardPop2.b()) {
            return false;
        }
        a(this.f, this.b);
        return true;
    }

    private final boolean k() {
        KeyboardPop keyboardPop = this.c;
        KeyboardPop keyboardPop2 = keyboardPop;
        if (keyboardPop == null) {
            Intrinsics.c("keyboardPop");
            keyboardPop2 = null;
        }
        return keyboardPop2.b();
    }

    private final boolean l() {
        if (this.k) {
            return true;
        }
        KeyboardPop keyboardPop = this.c;
        KeyboardPop keyboardPop2 = keyboardPop;
        if (keyboardPop == null) {
            Intrinsics.c("keyboardPop");
            keyboardPop2 = null;
        }
        return keyboardPop2.b();
    }

    public final List<Pair<View, View>> a() {
        return this.m;
    }

    public final void a(KeyboardConstraintLayout layout) {
        Intrinsics.e(layout, "layout");
        this.d = layout;
        KeyboardConstraintLayout keyboardConstraintLayout = layout;
        if (layout == null) {
            Intrinsics.c("keyboardLayout");
            keyboardConstraintLayout = null;
        }
        this.f = keyboardConstraintLayout.b();
        KeyboardConstraintLayout keyboardConstraintLayout2 = this.d;
        KeyboardConstraintLayout keyboardConstraintLayout3 = keyboardConstraintLayout2;
        if (keyboardConstraintLayout2 == null) {
            Intrinsics.c("keyboardLayout");
            keyboardConstraintLayout3 = null;
        }
        this.g = keyboardConstraintLayout3.c();
        KeyboardConstraintLayout keyboardConstraintLayout4 = this.d;
        KeyboardConstraintLayout keyboardConstraintLayout5 = keyboardConstraintLayout4;
        if (keyboardConstraintLayout4 == null) {
            Intrinsics.c("keyboardLayout");
            keyboardConstraintLayout5 = null;
        }
        this.h = keyboardConstraintLayout5.d();
        KeyboardConstraintLayout keyboardConstraintLayout6 = this.d;
        KeyboardConstraintLayout keyboardConstraintLayout7 = keyboardConstraintLayout6;
        if (keyboardConstraintLayout6 == null) {
            Intrinsics.c("keyboardLayout");
            keyboardConstraintLayout7 = null;
        }
        this.e = keyboardConstraintLayout7.getPanelView();
        ComponentActivity componentActivity = this.b;
        ComponentActivity componentActivity2 = componentActivity instanceof ComponentActivity ? componentActivity : null;
        if (componentActivity2 != null) {
            final ComponentActivity componentActivity3 = componentActivity2;
            componentActivity2.getOnBackPressedDispatcher().addCallback(componentActivity2, new OnBackPressedCallback() { // from class: com.blued.android.kbswitch.KeyboardHelper$start$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(true);
                }

                public void handleOnBackPressed() {
                    boolean g;
                    g = KeyboardHelper.this.g();
                    if (g) {
                        return;
                    }
                    setEnabled(false);
                    componentActivity3.getOnBackPressedDispatcher().onBackPressed();
                }
            });
        }
        View view = this.e;
        View view2 = view;
        if (view == null) {
            Intrinsics.c("panelView");
            view2 = null;
        }
        UtilsKt.b(view2);
        List<? extends Pair<? extends View, ? extends View>> list = this.m;
        if (list == null || list.isEmpty()) {
            KeyboardConstraintLayout keyboardConstraintLayout8 = this.d;
            if (keyboardConstraintLayout8 == null) {
                Intrinsics.c("keyboardLayout");
                keyboardConstraintLayout8 = null;
            }
            List<Pair<View, View>> e = keyboardConstraintLayout8.e();
            this.m = e;
            if (e != null) {
                for (Pair<View, View> pair : e) {
                    UtilsKt.b(pair.a());
                    pair.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.kbswitch.-$$Lambda$KeyboardHelper$U9ymqMDqrpJErfmdv3FeBDz8ju0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            KeyboardHelper.b(KeyboardHelper.this, view3);
                        }
                    });
                }
            }
        }
        final View view3 = this.g;
        if (view3 != null) {
            view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.kbswitch.-$$Lambda$KeyboardHelper$2nOcs4a-6y-FHIkHH-EAxHFm-bQ
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view4, MotionEvent motionEvent) {
                    boolean a2;
                    a2 = KeyboardHelper.a(KeyboardHelper.this, view3, view4, motionEvent);
                    return a2;
                }
            });
        }
        final RecyclerView recyclerView = this.h;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.blued.android.kbswitch.KeyboardHelper$start$4$1
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent ev) {
                Intrinsics.e(rv, "rv");
                Intrinsics.e(ev, "ev");
                if (ev.getAction() == 0) {
                    KeyboardHelper.this.a(recyclerView, ev);
                }
                return super.onInterceptTouchEvent(rv, ev);
            }
        });
    }

    public final void a(KeyboardStatusListener keyboardStatusListener) {
        this.o = keyboardStatusListener;
    }

    public final void a(SwitchPreHandleListener switchPreHandleListener) {
        this.n = switchPreHandleListener;
    }

    public final void a(Map<View, ? extends View> map) {
        Intrinsics.e(map, "map");
        this.m = new ArrayList();
        for (Map.Entry<View, ? extends View> entry : map.entrySet()) {
            List<Pair<View, View>> a2 = a();
            if (a2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Pair<android.view.View, android.view.View?>>");
            }
            TypeIntrinsics.f(a2).add(new Pair(entry.getKey(), entry.getValue()));
        }
        List<? extends Pair<? extends View, ? extends View>> list = this.m;
        if (list == null) {
            return;
        }
        for (Pair<? extends View, ? extends View> pair : list) {
            UtilsKt.b(pair.a());
            pair.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.kbswitch.-$$Lambda$KeyboardHelper$80xaMdpw0rymGZ3oNq6FV7ownPI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KeyboardHelper.a(KeyboardHelper.this, view);
                }
            });
        }
    }

    public final int b() {
        return this.j;
    }

    public final boolean c() {
        h();
        if (f()) {
            return true;
        }
        return g();
    }

    public final KBConstants.KeyboardStatus d() {
        return l() ? this.k ? KBConstants.KeyboardStatus.KB_STATUS_PANEL : KBConstants.KeyboardStatus.KB_STATUS_KEYBOARD : KBConstants.KeyboardStatus.KB_STATUS_NONE;
    }

    public final int e() {
        View view = this.i;
        if (view == null) {
            return 0;
        }
        return view.getHeight();
    }
}
