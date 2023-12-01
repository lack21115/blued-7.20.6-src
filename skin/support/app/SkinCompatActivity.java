package skin.support.app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import skin.support.SkinCompatManager;
import skin.support.content.res.SkinCompatThemeUtils;
import skin.support.content.res.SkinCompatVectorResources;
import skin.support.observe.SkinObservable;
import skin.support.observe.SkinObserver;
import skin.support.widget.SkinCompatHelper;

@Deprecated
/* loaded from: source-3503164-dex2jar.jar:skin/support/app/SkinCompatActivity.class */
public class SkinCompatActivity extends AppCompatActivity implements SkinObserver {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatDelegate f44197a;

    public SkinCompatDelegate a() {
        if (this.f44197a == null) {
            this.f44197a = SkinCompatDelegate.a(this);
        }
        return this.f44197a;
    }

    @Override // skin.support.observe.SkinObserver
    public void a(SkinObservable skinObservable, Object obj) {
        b();
        c();
        a().a();
    }

    protected void b() {
    }

    protected void c() {
        Drawable a2;
        int b = SkinCompatThemeUtils.b(this);
        if (SkinCompatHelper.b(b) == 0 || (a2 = SkinCompatVectorResources.a(this, b)) == null) {
            return;
        }
        getWindow().setBackgroundDrawable(a2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        LayoutInflaterCompat.setFactory2(getLayoutInflater(), a());
        super.onCreate(bundle);
        b();
        c();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SkinCompatManager.a().b(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SkinCompatManager.a().a((SkinObserver) this);
    }
}
