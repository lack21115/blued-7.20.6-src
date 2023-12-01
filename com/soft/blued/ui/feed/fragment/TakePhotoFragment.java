package com.soft.blued.ui.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.utils.StorageUtils;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.OapsWrapper;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.soft.blued.R;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/TakePhotoFragment.class */
public class TakePhotoFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f16337a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16338c;
    private View d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private String h;
    private String i;
    private ImageView j;
    private PhotoViewAttacher k;
    private ProgressBar l;
    private int m;
    private String n;
    private Dialog o;
    private String p;

    /* renamed from: com.soft.blued.ui.feed.fragment.TakePhotoFragment$5  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/TakePhotoFragment$5.class */
    class AnonymousClass5 implements PermissionCallbacks {
        AnonymousClass5() {
        }

        public void U_() {
            Logger.a("onActivityResult", new Object[]{"requestCode TAKE_PHOTO"});
            final String str = TakePhotoFragment.this.h;
            LogUtils.c("oldPath: " + str);
            if (TakePhotoFragment.this.o == null) {
                TakePhotoFragment takePhotoFragment = TakePhotoFragment.this;
                takePhotoFragment.o = DialogUtils.a(takePhotoFragment.getActivity());
            }
            TakePhotoFragment.this.o.show();
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            TakePhotoFragment takePhotoFragment2 = TakePhotoFragment.this;
            takePhotoFragment2.p = externalStoragePublicDirectory.getAbsolutePath() + File.separator + "blued" + File.separator + TakePhotoFragment.this.i;
            LogUtils.c("oldPath: " + str + ", imgSavePath: " + TakePhotoFragment.this.p + ", mFileName: " + TakePhotoFragment.this.i);
            ThreadManager.a().a(new ThreadExecutor("saveImgToPicDir") { // from class: com.soft.blued.ui.feed.fragment.TakePhotoFragment.5.1
                public void execute() {
                    FileUtils.a(str, TakePhotoFragment.this.p, TakePhotoFragment.this.i);
                    Houyi.a().a(TakePhotoFragment.this.h).b();
                    TakePhotoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.feed.fragment.TakePhotoFragment.5.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TakePhotoFragment.this.o != null) {
                                TakePhotoFragment.this.o.dismiss();
                            }
                            FragmentActivity activity = TakePhotoFragment.this.getActivity();
                            activity.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + TakePhotoFragment.this.p)));
                            TakePhotoFragment.this.d();
                        }
                    });
                }
            });
        }

        public void a(String[] strArr) {
        }
    }

    public static void a(final BaseFragment baseFragment, final int i, final int i2, final String str) {
        PermissionUtils.b(new PermissionCallbacks() { // from class: com.soft.blued.ui.feed.fragment.TakePhotoFragment.1
            public void U_() {
                Bundle bundle = new Bundle();
                bundle.putInt("select_photo", i2);
                bundle.putString("super_topic_id", str);
                TerminalActivity.a(baseFragment, TakePhotoFragment.class, bundle, i);
            }

            public void a(String[] strArr) {
            }
        });
    }

    private void c() {
        View findViewById = this.b.findViewById(2131370694);
        this.d = findViewById;
        this.f = (ImageView) findViewById.findViewById(2131363120);
        this.e = (TextView) this.d.findViewById(2131363108);
        this.g = (ImageView) this.d.findViewById(2131363126);
        this.f16338c = (TextView) this.b.findViewById(R.id.done_view);
        this.g.setVisibility(8);
        this.f16338c.setVisibility(0);
        this.f16338c.setText(this.f16337a.getResources().getString(R.string.photo_end));
        this.j = (ImageView) this.b.findViewById(R.id.photo_view);
        this.l = (ProgressBar) this.b.findViewById(R.id.loading_view);
        this.k = new PhotoViewAttacher(this.j);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.TakePhotoFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TakePhotoFragment.this.getActivity().finish();
            }
        });
        this.f16338c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.TakePhotoFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChildImageInfo childImageInfo = new ChildImageInfo();
                childImageInfo.mImagePath = TakePhotoFragment.this.h;
                childImageInfo.mSelect = true;
                SelectPhotoManager.a().a(childImageInfo);
                TakePhotoFragment.this.getActivity().setResult(-1);
                TakePhotoFragment.this.getActivity().finish();
                int i = TakePhotoFragment.this.m;
                if (i == 5) {
                    SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.f16284a);
                } else if (i != 7) {
                    FeedAddPostFragment.a(TakePhotoFragment.this.f16337a);
                } else {
                    SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.f16284a);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ImageLoader.d(getFragmentActive(), this.h).a(new ImageLoadResult(getFragmentActive()) { // from class: com.soft.blued.ui.feed.fragment.TakePhotoFragment.4
            public void a() {
                TakePhotoFragment.this.k.update();
            }
        }).a(this.j);
    }

    public void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.m = arguments.getInt("select_photo", 0);
            this.n = arguments.getString("super_topic_id");
        }
    }

    public void b() {
        String a2 = RecyclingUtils.a();
        this.i = System.currentTimeMillis() + ".jpg";
        this.h = a2 + File.separator + this.i;
        File file = new File(a2);
        if (!file.exists()) {
            file.mkdirs();
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addFlags(1);
        intent.addFlags(2);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, StorageUtils.b(this.h));
        startActivityForResult(intent, 0);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Logger.a("onActivityResult", new Object[]{"requestCode = ", Integer.valueOf(i)});
        if (i2 == 0) {
            if (i == 0) {
                getActivity().setResult(0, intent);
            }
            getActivity().finish();
        } else if (i == 0) {
            PermissionUtils.f(new AnonymousClass5());
            super.onActivityResult(i, i2, intent);
        } else {
            throw new IllegalStateException("Unexpected value: " + i);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16337a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_send_take_photo, viewGroup, false);
            c();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        if (bundle == null) {
            b();
        } else {
            this.h = bundle.getString(OapsWrapper.KEY_PATH);
            this.i = bundle.getString("name");
        }
        return this.b;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(OapsWrapper.KEY_PATH, this.h);
        bundle.putString("name", this.i);
        super.onSaveInstanceState(bundle);
    }
}
