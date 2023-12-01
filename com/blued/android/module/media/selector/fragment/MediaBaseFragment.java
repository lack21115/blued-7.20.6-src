package com.blued.android.module.media.selector.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.media.selector.utils.LogUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/fragment/MediaBaseFragment.class */
public abstract class MediaBaseFragment<V, T extends MediaBasePresent<V>> extends BaseFragment {
    public T b;
    public Context c;

    protected abstract void A();

    protected abstract T B();

    public abstract boolean a(Bundle bundle);

    protected abstract void b(Bundle bundle);

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        T t = this.b;
        if (t != null) {
            t.a(getActivity(), i, i2, intent);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = getContext();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        b(bundle);
        x();
        T B = B();
        this.b = B;
        if (B != null) {
            B.a(this);
            this.b.a(bundle);
        }
        A();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        T t = this.b;
        if (t != null) {
            t.o();
        }
        super.onDestroy();
        LogUtils.a(MediaBaseFragment.class.getSimpleName() + " onDestroy()");
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onSaveInstanceState(Bundle bundle) {
        T t;
        super.onSaveInstanceState(bundle);
        if (a(bundle) || (t = this.b) == null) {
            return;
        }
        t.b(bundle);
    }

    protected abstract void x();
}
