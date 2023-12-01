package skin.support.design.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import skin.support.app.SkinLayoutInflater;
import skin.support.design.widget.SkinMaterialAppBarLayout;
import skin.support.design.widget.SkinMaterialBottomNavigationView;
import skin.support.design.widget.SkinMaterialCollapsingToolbarLayout;
import skin.support.design.widget.SkinMaterialCoordinatorLayout;
import skin.support.design.widget.SkinMaterialFloatingActionButton;
import skin.support.design.widget.SkinMaterialNavigationView;
import skin.support.design.widget.SkinMaterialTabLayout;
import skin.support.design.widget.SkinMaterialTextInputEditText;
import skin.support.design.widget.SkinMaterialTextInputLayout;

/* loaded from: source-3503164-dex2jar.jar:skin/support/design/app/SkinMaterialViewInflater.class */
public class SkinMaterialViewInflater implements SkinLayoutInflater {
    @Override // skin.support.app.SkinLayoutInflater
    public View a(Context context, String str, AttributeSet attributeSet) {
        if ("androidx.coordinatorlayout.widget.CoordinatorLayout".equals(str)) {
            return new SkinMaterialCoordinatorLayout(context, attributeSet);
        }
        if (str.startsWith("com.google.android.material.")) {
            boolean z = true;
            switch (str.hashCode()) {
                case -2119513329:
                    if (str.equals("com.google.android.material.tabs.TabLayout")) {
                        z = true;
                        break;
                    }
                    break;
                case -533274696:
                    if (str.equals("com.google.android.material.appbar.AppBarLayout")) {
                        z = false;
                        break;
                    }
                    break;
                case -204374977:
                    if (str.equals("com.google.android.material.appbar.CollapsingToolbarLayout")) {
                        z = true;
                        break;
                    }
                    break;
                case 391764942:
                    if (str.equals("com.google.android.material.floatingactionbutton.FloatingActionButton")) {
                        z = true;
                        break;
                    }
                    break;
                case 827811731:
                    if (str.equals("com.google.android.material.navigation.NavigationView")) {
                        z = true;
                        break;
                    }
                    break;
                case 1589750150:
                    if (str.equals("com.google.android.material.textfield.TextInputLayout")) {
                        z = true;
                        break;
                    }
                    break;
                case 1634834867:
                    if (str.equals("com.google.android.material.textfield.TextInputEditText")) {
                        z = true;
                        break;
                    }
                    break;
                case 1949496211:
                    if (str.equals("com.google.android.material.bottomnavigation.BottomNavigationView")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    return new SkinMaterialAppBarLayout(context, attributeSet);
                case true:
                    return new SkinMaterialTabLayout(context, attributeSet);
                case true:
                    return new SkinMaterialTextInputLayout(context, attributeSet);
                case true:
                    return new SkinMaterialTextInputEditText(context, attributeSet);
                case true:
                    return new SkinMaterialNavigationView(context, attributeSet);
                case true:
                    return new SkinMaterialFloatingActionButton(context, attributeSet);
                case true:
                    return new SkinMaterialBottomNavigationView(context, attributeSet);
                case true:
                    return new SkinMaterialCollapsingToolbarLayout(context, attributeSet);
                default:
                    return null;
            }
        }
        return null;
    }
}
