package com.soft.blued.ui.feed.fragment;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.bytedance.applog.tracker.Tracker;
import com.github.chrisbanes.photoview.OnOutsidePhotoTapListener;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.soft.blued.R;
import com.soft.blued.utils.DeviceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/ImageDetailFragment.class */
public class ImageDetailFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f29894a;
    private PhotoView b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f29895c;
    private boolean d;
    private int e;
    private LoadOptions f;
    private Bitmap g;
    private int h;
    private int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.feed.fragment.ImageDetailFragment$3  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/ImageDetailFragment$3.class */
    public class AnonymousClass3 extends ImageLoadResult {
        AnonymousClass3(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a() {
            ImageDetailFragment.this.b.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.feed.fragment.ImageDetailFragment.3.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    CommonShowBottomWindow.a(ImageDetailFragment.this.getActivity(), AppInfo.d().getResources().getStringArray(2130903082), "#3494f4", new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.feed.fragment.ImageDetailFragment.3.1.1
                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, int i) {
                            ImageUtils.a(ImageDetailFragment.this.g);
                        }

                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, boolean z) {
                        }
                    });
                    return false;
                }
            });
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void b() {
            ImageDetailFragment.this.f29895c.setVisibility(8);
        }
    }

    public static ImageDetailFragment a(String str, boolean z, int i, LoadOptions loadOptions, int i2, int i3) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putBoolean("islocal", z);
        bundle.putInt("come_code", i);
        bundle.putInt("current_position", i2);
        bundle.putInt("start_position", i3);
        bundle.putSerializable("photo_options", loadOptions);
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.h != this.i) {
            getActivity().finish();
            ActivityChangeAnimationUtils.j(getActivity());
        } else if (Build.VERSION.SDK_INT >= 21 && !DeviceUtils.e()) {
            getActivity().finishAfterTransition();
        } else {
            getActivity().finish();
            ActivityChangeAnimationUtils.j(getActivity());
        }
    }

    private ImageLoadResult b() {
        return new AnonymousClass3(getFragmentActive());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        if (TextUtils.isEmpty(this.f29894a)) {
            this.b.setImageResource(2131237310);
            return;
        }
        this.f29895c.setVisibility(0);
        if (this.d) {
            this.b.setLayerType(1, null);
            (this.f29894a.toLowerCase().startsWith("content://") ? ImageLoader.b(getFragmentActive(), this.f29894a) : ImageLoader.d(getFragmentActive(), this.f29894a)).a(b()).a(this.b);
            return;
        }
        String str2 = this.f29894a;
        if (this.e == 1) {
            str2 = AvatarUtils.a(0, str2);
        }
        if (this.e == 5) {
            str = this.f29894a + "!o.png";
        } else {
            str = this.f29894a + "!original.png";
        }
        ImageLoader.a(getFragmentActive(), str).a(str2).e().a(b()).a(this.b);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        EventCallbackObserver.a().d();
        a();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        view.getId();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f29894a = getArguments() != null ? getArguments().getString("url") : null;
        this.d = getArguments() != null && getArguments().getBoolean("islocal");
        this.e = getArguments() != null ? getArguments().getInt("come_code") : 0;
        this.h = getArguments() != null ? getArguments().getInt("current_position") : 0;
        int i = 0;
        if (getArguments() != null) {
            i = getArguments().getInt("start_position");
        }
        this.i = i;
        LoadOptions loadOptions = (LoadOptions) getArguments().getSerializable("photo_options");
        this.f = loadOptions;
        if (loadOptions == null) {
            this.f = new LoadOptions();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_image_detail, viewGroup, false);
        this.f29895c = (ProgressBar) inflate.findViewById(2131368385);
        PhotoView photoView = (PhotoView) inflate.findViewById(2131368855);
        this.b = photoView;
        photoView.setMaximumScale(5.0f);
        this.b.setOnPhotoTapListener(new OnPhotoTapListener() { // from class: com.soft.blued.ui.feed.fragment.ImageDetailFragment.1
            @Override // com.github.chrisbanes.photoview.OnPhotoTapListener
            public void a(ImageView imageView, float f, float f2) {
                if (ImageDetailFragment.this.e != 4) {
                    ImageDetailFragment.this.a();
                } else {
                    EventCallbackObserver.a().a(ImageDetailFragment.this.b);
                }
            }
        });
        this.b.setOnOutsidePhotoTapListener(new OnOutsidePhotoTapListener() { // from class: com.soft.blued.ui.feed.fragment.ImageDetailFragment.2
            @Override // com.github.chrisbanes.photoview.OnOutsidePhotoTapListener
            public void a(ImageView imageView) {
                if (ImageDetailFragment.this.e != 4) {
                    ImageDetailFragment.this.a();
                } else {
                    EventCallbackObserver.a().b(ImageDetailFragment.this.b);
                }
            }
        });
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.b.setImageDrawable(null);
    }
}
