package com.soft.blued.ui.home.help;

import android.R;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.common.utils.ToastUtils;
import com.bytedance.applog.tracker.Tracker;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/help/FragmentViewHelper.class */
public class FragmentViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f17349a;
    private AlertDialog b;

    /* renamed from: com.soft.blued.ui.home.help.FragmentViewHelper$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/help/FragmentViewHelper$1.class */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f17350a;
        final /* synthetic */ FragmentViewHelper b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            FragmentViewHelper fragmentViewHelper = this.b;
            fragmentViewHelper.f17349a = fragmentViewHelper.a(this.f17350a.getSupportFragmentManager());
            this.b.a(this.f17350a);
            ToastUtils.a("" + this.b.f17349a);
        }
    }

    private List<FragmentRecord> a(Fragment fragment) {
        ArrayList arrayList = new ArrayList();
        List<Fragment> b = b(fragment.getChildFragmentManager());
        if (b == null || b.isEmpty()) {
            return null;
        }
        for (Fragment fragment2 : b) {
            a(arrayList, fragment2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentActivity fragmentActivity) {
        AlertDialog alertDialog = this.b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            FragmentViewContainer fragmentViewContainer = new FragmentViewContainer(fragmentActivity);
            fragmentViewContainer.a(b(fragmentActivity));
            fragmentViewContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            AlertDialog create = new AlertDialog.Builder(fragmentActivity).setView(fragmentViewContainer).setPositiveButton(R.string.cancel, (DialogInterface.OnClickListener) null).setCancelable(true).create();
            this.b = create;
            create.show();
        }
    }

    private void a(List<FragmentRecord> list, Fragment fragment) {
        list.add(new FragmentRecord(fragment.getClass().getSimpleName(), a(fragment)));
    }

    private List<FragmentRecord> b(FragmentActivity fragmentActivity) {
        ArrayList arrayList = new ArrayList();
        List<Fragment> b = b(fragmentActivity.getSupportFragmentManager());
        if (b == null || b.isEmpty()) {
            return null;
        }
        for (Fragment fragment : b) {
            a(arrayList, fragment);
        }
        return arrayList;
    }

    private List<Fragment> b(FragmentManager fragmentManager) {
        ArrayList arrayList = new ArrayList();
        try {
            Field declaredField = fragmentManager.getClass().getDeclaredField("mActive");
            declaredField.setAccessible(true);
            try {
                SparseArray sparseArray = (SparseArray) declaredField.get(fragmentManager);
                if (sparseArray != null && sparseArray.size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= sparseArray.size()) {
                            break;
                        }
                        arrayList.add((Fragment) sparseArray.valueAt(i2));
                        i = i2 + 1;
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return arrayList;
            }
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public int a(FragmentManager fragmentManager) {
        int i;
        int i2;
        if (fragmentManager == null) {
            return 0;
        }
        int i3 = 0;
        try {
            Field declaredField = fragmentManager.getClass().getDeclaredField("mActive");
            declaredField.setAccessible(true);
            try {
                SparseArray sparseArray = (SparseArray) declaredField.get(fragmentManager);
                i = 0;
                if (sparseArray != null) {
                    i = 0;
                    if (sparseArray.size() > 0) {
                        i3 = sparseArray.size() + 0;
                        int i4 = 0;
                        while (true) {
                            try {
                                int i5 = i4;
                                if (i5 >= sparseArray.size()) {
                                    return i3;
                                }
                                i3 += a(((Fragment) sparseArray.valueAt(i5)).getChildFragmentManager());
                                i4 = i5 + 1;
                            } catch (IllegalAccessException e) {
                                e = e;
                                i2 = i3;
                                e.printStackTrace();
                                return i2;
                            } catch (NoSuchFieldException e2) {
                                e = e2;
                                e.printStackTrace();
                                i = i3;
                                return i;
                            }
                        }
                    }
                }
            } catch (IllegalAccessException e3) {
                e = e3;
                i2 = 0;
            }
        } catch (NoSuchFieldException e4) {
            e = e4;
        }
        return i;
    }
}
