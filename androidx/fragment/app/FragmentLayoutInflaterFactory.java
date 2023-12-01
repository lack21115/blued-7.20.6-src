package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentLayoutInflaterFactory.class */
public class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    final FragmentManager f2963a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.f2963a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        FragmentStateManager fragmentStateManager;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f2963a);
        }
        boolean equals = "fragment".equals(str);
        Fragment fragment2 = null;
        if (equals) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
            String str2 = attributeValue;
            if (attributeValue == null) {
                str2 = obtainStyledAttributes.getString(R.styleable.Fragment_android_name);
            }
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
            String string = obtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
            obtainStyledAttributes.recycle();
            if (str2 == null || !FragmentFactory.a(context.getClassLoader(), str2)) {
                return null;
            }
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
            }
            if (resourceId != -1) {
                fragment2 = this.f2963a.findFragmentById(resourceId);
            }
            Fragment fragment3 = fragment2;
            if (fragment2 == null) {
                fragment3 = fragment2;
                if (string != null) {
                    fragment3 = this.f2963a.findFragmentByTag(string);
                }
            }
            Fragment fragment4 = fragment3;
            if (fragment3 == null) {
                fragment4 = fragment3;
                if (id != -1) {
                    fragment4 = this.f2963a.findFragmentById(id);
                }
            }
            if (fragment4 == null) {
                Fragment instantiate = this.f2963a.getFragmentFactory().instantiate(context.getClassLoader(), str2);
                instantiate.mFromLayout = true;
                instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
                instantiate.mContainerId = id;
                instantiate.mTag = string;
                instantiate.mInLayout = true;
                instantiate.mFragmentManager = this.f2963a;
                instantiate.mHost = this.f2963a.h();
                instantiate.onInflate(this.f2963a.h().getContext(), attributeSet, instantiate.mSavedFragmentState);
                FragmentStateManager i = this.f2963a.i(instantiate);
                fragment = instantiate;
                fragmentStateManager = i;
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Fragment " + instantiate + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    fragment = instantiate;
                    fragmentStateManager = i;
                }
            } else if (fragment4.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            } else {
                fragment4.mInLayout = true;
                fragment4.mFragmentManager = this.f2963a;
                fragment4.mHost = this.f2963a.h();
                fragment4.onInflate(this.f2963a.h().getContext(), attributeSet, fragment4.mSavedFragmentState);
                FragmentStateManager h = this.f2963a.h(fragment4);
                fragment = fragment4;
                fragmentStateManager = h;
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Retained Fragment " + fragment4 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    fragmentStateManager = h;
                    fragment = fragment4;
                }
            }
            fragment.mContainer = (ViewGroup) view;
            fragmentStateManager.c();
            fragmentStateManager.d();
            if (fragment.mView == null) {
                throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
            }
            if (resourceId != 0) {
                fragment.mView.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            final FragmentStateManager fragmentStateManager2 = fragmentStateManager;
            fragment.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    Fragment a2 = fragmentStateManager2.a();
                    fragmentStateManager2.c();
                    SpecialEffectsController.a((ViewGroup) a2.mView.getParent(), FragmentLayoutInflaterFactory.this.f2963a).d();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
            return fragment.mView;
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
