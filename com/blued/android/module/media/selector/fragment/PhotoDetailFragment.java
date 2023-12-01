package com.blued.android.module.media.selector.fragment;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.fragment.PhotoDetailFragment;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.blued.android.module.player.media.view.ViewDragHelperLayout;
import com.github.chrisbanes.photoview.OnScaleChangedListener;
import com.github.chrisbanes.photoview.PhotoView;
import java.io.File;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/fragment/PhotoDetailFragment.class */
public class PhotoDetailFragment extends BaseFragment implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a  reason: collision with root package name */
    protected ViewDragHelperLayout f15555a;
    protected FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    protected FrameLayout f15556c;
    protected PhotoView d;
    protected ProgressBar e;
    protected LoadOptions f;
    public String g;
    private View i;
    private GetConfigCallback m;
    private boolean n;
    private boolean j = true;
    private boolean k = true;
    private double l = 1.0d;
    ViewDragHelperLayout.OnLayoutStateListener h = new ViewDragHelperLayout.OnLayoutStateListener() { // from class: com.blued.android.module.media.selector.fragment.PhotoDetailFragment.2
        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void a() {
            if (PhotoDetailFragment.this.getActivity() != null) {
                PhotoDetailFragment.this.getActivity().finish();
                PhotoDetailFragment.this.getActivity().overridePendingTransition(0, 0);
            }
            EventCallbackObserver.a().b();
        }

        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void a(int i) {
            EventCallbackObserver.a().a(i);
        }

        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void b() {
            EventCallbackObserver.a().c();
        }

        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void c() {
        }

        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void d() {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.media.selector.fragment.PhotoDetailFragment$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/fragment/PhotoDetailFragment$3.class */
    public class AnonymousClass3 extends ImageLoadResult {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f15559a;
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(IRequestHost iRequestHost, String str, String str2) {
            super(iRequestHost);
            this.f15559a = str;
            this.b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(File file, Exception exc) {
            if (file == null || !file.exists()) {
                return;
            }
            PhotoDetailFragment.this.b(file);
            EventCallbackObserver.a().b(PhotoDetailFragment.this.d, file);
            PhotoDetailFragment.this.a(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(File file, Exception exc) {
            if (file == null || !file.exists()) {
                return;
            }
            PhotoDetailFragment.this.b(file);
            PhotoDetailFragment.this.a(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            PhotoDetailFragment.this.aj_();
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a() {
            PhotoDetailFragment.this.g();
            if (PhotoDetailFragment.this.j) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.media.selector.fragment.-$$Lambda$PhotoDetailFragment$3$Q4Uc6hP3-HdCu7UhUDUqhZVFAm8
                    @Override // java.lang.Runnable
                    public final void run() {
                        PhotoDetailFragment.AnonymousClass3.this.d();
                    }
                });
            }
            ImageFileLoader.a(PhotoDetailFragment.this.getFragmentActive()).a(this.b).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.media.selector.fragment.-$$Lambda$PhotoDetailFragment$3$asdAWbcFuFB9ejKFVVnd8OOZWb4
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc) {
                    PhotoDetailFragment.AnonymousClass3.this.a(file, exc);
                }
            }).a();
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a(int i, Exception exc) {
            PhotoDetailFragment.this.g();
            AppMethods.d(R.string.foudation_media_load_fail);
            ImageFileLoader.a(PhotoDetailFragment.this.getFragmentActive()).a(this.f15559a).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.media.selector.fragment.-$$Lambda$PhotoDetailFragment$3$kX_qZw44nbAU114Ns1BYDdXX-GU
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc2) {
                    PhotoDetailFragment.AnonymousClass3.this.b(file, exc2);
                }
            }).a();
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/fragment/PhotoDetailFragment$GetConfigCallback.class */
    public interface GetConfigCallback {
        View a();

        View b();

        ImageView.ScaleType c();
    }

    public static Bundle a(String str, LoadOptions loadOptions, boolean z, boolean z2) {
        return a(str, loadOptions, z, z2, 1.0d);
    }

    public static Bundle a(String str, LoadOptions loadOptions, boolean z, boolean z2, double d) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putSerializable("photo_options", loadOptions);
        bundle.putBoolean("scroll", z);
        bundle.putBoolean("scroll_out", z2);
        bundle.putDouble("scale_scroll_out_border_num", d);
        return bundle;
    }

    public static PhotoDetailFragment a(String str, LoadOptions loadOptions, boolean z) {
        PhotoDetailFragment photoDetailFragment = new PhotoDetailFragment();
        photoDetailFragment.setArguments(a(str, loadOptions, true, z));
        return photoDetailFragment;
    }

    private String a(String str) {
        return str.replace("!100x100.png", "").replace("!200x200.png", "").replace("!480x480.png", "").replace("!480x720.png", "").replace("!640x640.png", "").replace("!640x960.png", "").replace("!720x720.png", "").replace("!720x1080.png", "").replace("!1080x1080.png", "").replace("!1080x1620.png", "").replace("!o.png", "").replace("!original.png", "");
    }

    private void a() {
        this.f15555a = (ViewDragHelperLayout) this.i.findViewById(R.id.view_drag_layout);
        this.e = (ProgressBar) this.i.findViewById(R.id.loading_view);
        new TypedValue();
        this.e.getIndeterminateDrawable().setColorFilter(getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        this.d = (PhotoView) this.i.findViewById(R.id.photo_preview);
        this.b = (FrameLayout) this.i.findViewById(R.id.top_title);
        this.f15556c = (FrameLayout) this.i.findViewById(R.id.bottom_tab);
        GetConfigCallback getConfigCallback = this.m;
        if (getConfigCallback != null) {
            this.d.setScaleType(getConfigCallback.c());
            if (this.m.a() != null) {
                this.b.addView(this.m.a(), new FrameLayout.LayoutParams(-1, -2));
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
            if (this.m.b() != null) {
                this.f15556c.addView(this.m.b(), new FrameLayout.LayoutParams(-1, -2));
                this.f15556c.setVisibility(0);
            } else {
                this.f15556c.setVisibility(8);
            }
        } else {
            this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.b.setVisibility(8);
            this.f15556c.setVisibility(8);
        }
        this.d.setZoomTransitionDuration(200);
        PhotoView photoView = this.d;
        photoView.setMediumScale(photoView.getMinimumScale() + 0.001f);
        if (this.j) {
            this.f15555a.setClickable(true);
            this.d.setMaximumScale(5.0f);
            this.f15555a.setScrollDisable(this.k);
            this.d.setOnScaleChangeListener(new OnScaleChangedListener() { // from class: com.blued.android.module.media.selector.fragment.PhotoDetailFragment.1
                @Override // com.github.chrisbanes.photoview.OnScaleChangedListener
                public void a(float f, float f2, float f3) {
                    EventCallbackObserver.a().a(f, f2, f3);
                    if (PhotoDetailFragment.this.k) {
                        if (((int) PhotoDetailFragment.this.d.getScale()) > PhotoDetailFragment.this.l) {
                            PhotoDetailFragment.this.f15555a.setScrollDisable(false);
                        } else {
                            PhotoDetailFragment.this.f15555a.setScrollDisable(true);
                        }
                    }
                }
            });
            this.d.setOnDoubleTapListener(this);
        } else {
            this.k = false;
            this.f15555a.setClickable(false);
            this.d.setZoomable(false);
        }
        if (this.k) {
            this.f15555a.setOnLayoutStateListener(this.h);
        }
    }

    private void a(String str, String str2) {
        e();
        ImageLoader.a(getFragmentActive(), str).e().a(str2).d(R.drawable.album_load_failed_icon).a(new AnonymousClass3(getFragmentActive(), str2, str)).a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final File file) {
        this.d.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.media.selector.fragment.PhotoDetailFragment.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                EventCallbackObserver.a().a(PhotoDetailFragment.this.g, file);
                return false;
            }
        });
    }

    private void h() {
        if (TextUtils.isEmpty(this.g)) {
            ImageLoader.a(getFragmentActive(), R.drawable.user_bg_round).a(this.d);
        } else if (!this.g.toLowerCase().contains("http://") && !this.g.toLowerCase().contains("https://")) {
            if (this.g.toLowerCase().startsWith("content://")) {
                ImageLoader.b(getFragmentActive(), this.g).a(this.d);
            } else {
                ImageLoader.d(getFragmentActive(), this.g).a(this.d);
            }
        } else {
            String str = new String(this.g);
            if (!this.g.toLowerCase().contains("scontent.cdninstagram.com")) {
                this.g = a(this.g);
                this.g += ah_();
            }
            a(this.g, str);
        }
    }

    public void a(GetConfigCallback getConfigCallback) {
        this.m = getConfigCallback;
    }

    protected void a(File file) {
    }

    public String ah_() {
        return "!o.png";
    }

    public void ai_() {
        this.g = getArguments() != null ? getArguments().getString("url") : null;
        LoadOptions loadOptions = null;
        if (getArguments() != null) {
            loadOptions = (LoadOptions) getArguments().getSerializable("photo_options");
        }
        this.f = loadOptions;
        if (loadOptions == null) {
            this.f = new LoadOptions();
        }
        if (getArguments() != null) {
            this.j = getArguments().getBoolean("scroll");
            this.k = getArguments().getBoolean("scroll_out");
        } else {
            this.j = true;
            this.k = true;
        }
        double d = getArguments() != null ? getArguments().getDouble("scale_scroll_out_border_num") : 1.0d;
        this.l = d;
        if (d < 1.0d) {
            this.l = 1.0d;
        }
    }

    public void aj_() {
        RectF a2;
        float f;
        float width;
        float f2;
        PhotoView photoView = this.d;
        if (photoView == null || photoView.getAttacher() == null || (a2 = this.d.getAttacher().a()) == null) {
            return;
        }
        float width2 = a2.width();
        float height = a2.height();
        if (width2 > height) {
            if (width2 > height * 3.0f) {
                f = AppInfo.m - DensityUtils.a(getActivity());
                width = a2.height();
                f2 = f / width;
            }
            f2 = 0.0f;
        } else {
            if (height > width2 * 3.0f) {
                f = AppInfo.l;
                width = a2.width();
                f2 = f / width;
            }
            f2 = 0.0f;
        }
        if (f2 == 0.0f || f2 <= this.d.getMediumScale()) {
            return;
        }
        this.d.setMaximumScale(f2);
    }

    protected void e() {
        ProgressBar progressBar = this.e;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public boolean f() {
        return this.k;
    }

    protected void g() {
        ProgressBar progressBar = this.e;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        h();
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        EventCallbackObserver.a().d();
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.i;
        if (view == null) {
            this.i = layoutInflater.inflate(R.layout.fragment_photo_detail, viewGroup, false);
            StatusBarHelper.a((Activity) getActivity());
            ai_();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.i.getParent()).removeView(this.i);
        }
        this.n = true;
        return this.i;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PhotoView photoView = this.d;
        if (photoView != null) {
            ImageLoader.a((IRequestHost) null, photoView);
            this.d.setImageDrawable(null);
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        try {
            float scale = this.d.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.d.getMaximumScale()) {
                this.d.a(this.d.getMaximumScale(), x, y, true);
                return true;
            }
            this.d.a(this.d.getMinimumScale(), x, y, true);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.d.getVisibility() != 0 || this.d.getAttacher() == null) {
            return;
        }
        PhotoView photoView = this.d;
        photoView.a(photoView.getMinimumScale(), true);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ViewDragHelperLayout viewDragHelperLayout = this.f15555a;
        if (viewDragHelperLayout != null) {
            viewDragHelperLayout.setScrollDisable(this.k);
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect = this.d.getDisplayRect();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (displayRect != null) {
            if (displayRect.contains(x, y)) {
                EventCallbackObserver.a().a(this.d);
                return true;
            }
            EventCallbackObserver.a().b(this.d);
            return false;
        }
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.n) {
            if (z) {
                a();
            } else if (this.d.getVisibility() != 0 || this.d.getAttacher() == null) {
            } else {
                PhotoView photoView = this.d;
                photoView.a(photoView.getMinimumScale(), true);
                this.f15555a.setScrollDisable(this.k);
            }
        }
    }
}
