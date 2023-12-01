package com.soft.blued.ui.photo.fragment;

import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.media.selector.fragment.PhotoDetailFragment;
import com.blued.android.module.player.media.observer.EventCallBackListener;
import com.blued.android.module.player.media.observer.EventCallbackObserver;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/BizPhotoDetailFragment.class */
public class BizPhotoDetailFragment extends PhotoDetailFragment implements EventCallBackListener {
    private int i;
    private float j;
    private String k;
    private String l;

    public static BizPhotoDetailFragment a(String str, int i, LoadOptions loadOptions) {
        return a(str, i, loadOptions, true, true);
    }

    public static BizPhotoDetailFragment a(String str, int i, LoadOptions loadOptions, String str2, String str3) {
        BizPhotoDetailFragment bizPhotoDetailFragment = new BizPhotoDetailFragment();
        Bundle a2 = a(str, loadOptions, true, true);
        a2.putInt("come_code", i);
        a2.putString("key_feed_id", str2);
        a2.putString("target_uid", str3);
        bizPhotoDetailFragment.setArguments(a2);
        return bizPhotoDetailFragment;
    }

    public static BizPhotoDetailFragment a(String str, int i, LoadOptions loadOptions, boolean z, boolean z2) {
        BizPhotoDetailFragment bizPhotoDetailFragment = new BizPhotoDetailFragment();
        Bundle a2 = a(str, loadOptions, z, z2);
        a2.putInt("come_code", i);
        bizPhotoDetailFragment.setArguments(a2);
        return bizPhotoDetailFragment;
    }

    private boolean h() {
        if (i() == null) {
            return false;
        }
        return i().height() > i().width() * 3.0f;
    }

    private RectF i() {
        return this.d.getAttacher().a();
    }

    public void a(float f, float f2, float f3) {
    }

    public void a(int i) {
        if (h()) {
            this.a.setScrollDisable(false);
        }
    }

    public void a(View view) {
    }

    public void a(Object... objArr) {
    }

    public String ah_() {
        int i = this.i;
        return i == 5 ? "!o.png" : i == 8 ? "" : "!original.png";
    }

    public void ai_() {
        this.i = getArguments() != null ? getArguments().getInt("come_code") : 0;
        this.k = getArguments() != null ? getArguments().getString("key_feed_id") : "";
        this.l = getArguments() != null ? getArguments().getString("target_uid") : "";
        StatusBarHelper.a(getActivity(), false);
        super.ai_();
    }

    public void aj_() {
        if (!h()) {
            super.aj_();
            return;
        }
        float width = AppInfo.l / i().width();
        this.j = width;
        if (width == 0.0f || width <= this.d.getMediumScale()) {
            return;
        }
        if (this.j > this.d.getMaximumScale()) {
            this.d.setMaximumScale(this.j * 1.5f);
        }
        this.d.a(this.j, 0.0f, 0.0f, false);
        if (f()) {
            this.a.setScrollDisable(false);
        }
    }

    public void ak_() {
    }

    public void al_() {
    }

    public void am_() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void b(View view) {
    }

    public void b(Object... objArr) {
    }

    public void d() {
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        EventCallbackObserver.a().a(this);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        EventCallbackObserver.a().b(this);
        super.onDestroy();
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (h()) {
            try {
                float scale = this.d.getScale();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (scale == this.j) {
                    this.d.a(this.d.getMaximumScale(), x, y, true);
                    return true;
                } else if (this.j < this.d.getMinimumScale() || this.j > this.d.getMaximumScale()) {
                    return true;
                } else {
                    this.d.a(this.j, x, y, true);
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return super.onDoubleTap(motionEvent);
            }
        }
        return super.onDoubleTap(motionEvent);
    }
}
