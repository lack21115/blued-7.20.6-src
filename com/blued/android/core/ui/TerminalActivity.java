package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.blued_core.R;
import skin.support.SkinCompatManager;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/TerminalActivity.class */
public class TerminalActivity extends BaseFragmentActivity {

    /* renamed from: c  reason: collision with root package name */
    protected FrameLayout f9724c;
    private IWindowFocusChangedListener d;
    private IRestartListener e;
    private Class<? extends Fragment> f;
    private boolean g = false;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/TerminalActivity$IRestartListener.class */
    public interface IRestartListener {
        void a();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/TerminalActivity$IWindowFocusChangedListener.class */
    public interface IWindowFocusChangedListener {
        void a();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/TerminalActivity$WrapIntent.class */
    public static class WrapIntent {

        /* renamed from: a  reason: collision with root package name */
        private Context f9725a;
        private Intent b;

        public WrapIntent(Context context, Class<? extends Fragment> cls, Bundle bundle, Class<?> cls2) {
            this(context, cls.getName(), bundle, cls2);
        }

        public WrapIntent(Context context, String str, Bundle bundle, Class<?> cls) {
            this.b = null;
            Context d = context == null ? AppInfo.d() : context;
            this.f9725a = d;
            Intent intent = new Intent(d, cls);
            this.b = intent;
            intent.putExtra("arg_fragment_class_name", str);
            this.b.putExtra("arg_fragment_args", bundle);
        }

        public Intent a() {
            return this.b;
        }

        public void a(int i) {
            Context context = this.f9725a;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(this.b, i);
            } else if (AppInfo.m()) {
                throw new RuntimeException("invoke showForResult(int) must be Activity!");
            }
        }

        public void a(int i, Fragment fragment) {
            if (fragment == null || !fragment.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                return;
            }
            fragment.startActivityForResult(this.b, i);
        }

        public void b() {
            if (!(this.f9725a instanceof Activity)) {
                this.b.setFlags(268435456);
            }
            this.f9725a.startActivity(this.b);
        }
    }

    public static Bundle a(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putBoolean("arg_without_fitui", true);
        return bundle2;
    }

    public static void a(Context context, Class<? extends Fragment> cls, Bundle bundle, int i) {
        c(context, cls, bundle).a(i);
    }

    public static void a(Fragment fragment, Class<? extends Fragment> cls, Bundle bundle) {
        c(fragment.getActivity(), cls, bundle).a(4772, fragment);
    }

    public static void a(Fragment fragment, Class<? extends Fragment> cls, Bundle bundle, int i) {
        c(fragment.getActivity(), cls, bundle).a(i, fragment);
    }

    public static Bundle b(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putBoolean("arg_statusbar_darkicon", false);
        return bundle2;
    }

    public static WrapIntent c(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        return new WrapIntent(context, cls, bundle, TerminalActivity.class);
    }

    public static void d(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        c(context, cls, bundle).b();
    }

    public static void e(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        c(context, cls, bundle).a(4893);
    }

    public void a(IRestartListener iRestartListener) {
        this.e = iRestartListener;
    }

    public boolean a(Class<? extends Fragment> cls) {
        return cls == this.f;
    }

    protected void c(Bundle bundle) {
        if (bundle != null) {
            this.g = bundle.getBoolean("arg_bool_backtomain", this.g);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity
    public boolean e() {
        return super.e();
    }

    protected void f() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("arg_fragment_class_name");
        if (TextUtils.isEmpty(stringExtra)) {
            Log.e("TerminalActivity", "invalid fragment class name");
            finish();
            return;
        }
        try {
            Class loadClass = getClassLoader().loadClass(stringExtra);
            this.f = loadClass;
            Fragment fragment = (Fragment) loadClass.newInstance();
            Bundle bundleExtra = intent.getBundleExtra("arg_fragment_args");
            if (bundleExtra != null) {
                fragment.setArguments(bundleExtra);
                c(bundleExtra);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.root_view, fragment, "init_fragment");
            beginTransaction.commitAllowingStateLoss();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            finish();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            finish();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.g) {
            this.g = false;
            if (!isTaskRoot() || AppInfo.b() == null) {
                return;
            }
            AppInfo.b().b(this);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return super.getPageBizName();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.g) {
            this.g = false;
            if (isTaskRoot() && AppInfo.b() != null) {
                AppInfo.b().b(this);
            }
        }
        super.onBackPressed();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean i = AppInfo.i();
        int k = AppInfo.k();
        int l = AppInfo.l();
        int j = AppInfo.j();
        Bundle bundleExtra = getIntent().getBundleExtra("arg_fragment_args");
        boolean z = false;
        boolean z2 = i;
        if (bundleExtra != null) {
            z = bundleExtra.getBoolean("arg_without_fitui", false);
            z2 = bundleExtra.getBoolean("arg_statusbar_darkicon", i);
            k = bundleExtra.getInt("arg_statusbar_start_color", AppInfo.k());
            l = bundleExtra.getInt("arg_statusbar_end_color", AppInfo.l());
            j = bundleExtra.getInt("arg_window_color", AppInfo.j());
            AppInfo.v = bundleExtra.containsKey("arg_statusbar_darkicon");
        }
        boolean a2 = StatusBarHelper.a(this, z2, AppInfo.v);
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        this.f9724c = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (a2) {
            this.f9724c.setFitsSystemWindows(!z);
            if (k != 17170445 && j != 17170445) {
                getWindow().setBackgroundDrawable(StatusBarHelper.a(this, k, l, j, z));
            }
            if (!z && SkinCompatManager.a() != null) {
                findViewById(16908290).setBackgroundColor(BluedSkinUtils.a(this, k));
            }
        }
        this.f9724c.setId(R.id.root_view);
        setContentView(this.f9724c);
        c(bundle);
        if (bundle == null) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        IRestartListener iRestartListener = this.e;
        if (iRestartListener != null) {
            iRestartListener.a();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("arg_bool_backtomain", this.g);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        IWindowFocusChangedListener iWindowFocusChangedListener = this.d;
        if (iWindowFocusChangedListener != null) {
            iWindowFocusChangedListener.a();
        }
    }
}
