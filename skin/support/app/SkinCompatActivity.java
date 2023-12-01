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
    private SkinCompatDelegate a;

    /* JADX WARN: Multi-variable type inference failed */
    public SkinCompatDelegate a() {
        if (this.a == null) {
            this.a = SkinCompatDelegate.a(this);
        }
        return this.a;
    }

    @Override // skin.support.observe.SkinObserver
    public void a(SkinObservable skinObservable, Object obj) {
        b();
        c();
        a().a();
    }

    protected void b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void c() {
        Drawable a;
        int b = SkinCompatThemeUtils.b(this);
        if (SkinCompatHelper.b(b) == 0 || (a = SkinCompatVectorResources.a(this, b)) == null) {
            return;
        }
        getWindow().setBackgroundDrawable(a);
    }

    public void onCreate(Bundle bundle) {
        LayoutInflaterCompat.setFactory2(getLayoutInflater(), a());
        super.onCreate(bundle);
        b();
        c();
    }

    public void onDestroy() {
        super.onDestroy();
        SkinCompatManager.a().b(this);
    }

    public void onResume() {
        super.onResume();
        SkinCompatManager.a().a((SkinObserver) this);
    }
}
