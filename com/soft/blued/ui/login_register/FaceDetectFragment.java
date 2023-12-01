package com.soft.blued.ui.login_register;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Environment;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import com.baidu.aip.ImageFrame;
import com.baidu.aip.face.CameraImageSource;
import com.baidu.aip.face.DetectRegionProcessor;
import com.baidu.aip.face.FaceDetectManager;
import com.baidu.aip.face.FaceFilter;
import com.baidu.aip.face.PreviewView;
import com.baidu.aip.face.TexturePreviewView;
import com.baidu.aip.face.camera.PermissionCallback;
import com.baidu.idl.facesdk.FaceInfo;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.constant.CameraContents;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.model.AdultVerifyModel;
import com.soft.blued.ui.photo.camera.utils.CameraImageUtils;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.BaiduFaceDetectUtils;
import java.io.File;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/FaceDetectFragment.class */
public class FaceDetectFragment extends MvpFragment {
    private static String f = FaceDetectFragment.class.getName();

    /* renamed from: a  reason: collision with root package name */
    private Context f31365a;
    @BindView
    TextView abortVerify;
    private FaceDetectManager b;
    @BindView
    TextView cameraTips;
    @BindView
    FrameLayout flPreview;
    @BindView
    TextureView mTextureView;
    @BindView
    TexturePreviewView previewView;
    @BindView
    CommonTopTitleNoTrans title;
    @BindView
    TextView tvTips;

    /* renamed from: c  reason: collision with root package name */
    private DetectRegionProcessor f31366c = new DetectRegionProcessor();
    private boolean d = false;
    private boolean e = false;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        ServiceHelper.f33645a.a(this.f31365a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        c();
    }

    public static void a(final Object obj, final int i) {
        if ((obj instanceof Fragment ? ((Fragment) obj).getContext() : (Context) obj) == null) {
            return;
        }
        PermissionUtils.b(new PermissionCallbacks() { // from class: com.soft.blued.ui.login_register.FaceDetectFragment.1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                Bundle bundle = new Bundle();
                Object obj2 = Object.this;
                if (obj2 instanceof Activity) {
                    TerminalActivity.a((Activity) obj2, FaceDetectFragment.class, bundle, i);
                } else if (obj2 instanceof Fragment) {
                    TerminalActivity.a((Fragment) obj2, FaceDetectFragment.class, bundle, i);
                }
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        AdultVerifyFragment.a(this.f31365a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final FaceFilter.TrackedModel trackedModel) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.login_register.-$$Lambda$FaceDetectFragment$1ld-x0bE81IAqio_rftL5imCXQA
            @Override // java.lang.Runnable
            public final void run() {
                FaceDetectFragment.this.c(trackedModel);
            }
        });
    }

    private void c() {
        CommonAlertDialog.a(getActivity(), "", this.f31365a.getResources().getString(R.string.av_abort_confirm_text), this.f31365a.getResources().getString(R.string.av_abort), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$FaceDetectFragment$kwxJ4ruRU2zjPQ1tYUccKc0r2Hg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FaceDetectFragment.c(dialogInterface, i);
            }
        }, this.f31365a.getResources().getString(R.string.av_continue_verify), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        UserRelationshipUtils.a("", new int[0]);
    }

    private void d() {
        if (BaiduFaceDetectUtils.a((Activity) getActivity()) < 200) {
            BaiduFaceDetectUtils.a(getActivity(), 200);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean e() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 100);
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f31365a = getActivity();
        b();
    }

    /* renamed from: a */
    public void c(FaceFilter.TrackedModel trackedModel) {
        if (trackedModel == null || this.d) {
            return;
        }
        if (!trackedModel.meetCriteria()) {
            this.tvTips.setVisibility(0);
            this.tvTips.setText(2131887882);
            return;
        }
        this.tvTips.setVisibility(8);
        FaceInfo info = trackedModel.getInfo();
        trackedModel.getImageFrame().retain();
        this.previewView.mapFromOriginalRect(new RectF((info.mCenter_x - 2) - ((info.mWidth * 3) / 5), (info.mCenter_y - 2) - ((info.mWidth * 3) / 5), info.mCenter_x + 2 + ((info.mWidth * 3) / 5), info.mCenter_y + 2 + ((info.mWidth * 3) / 5)));
        this.d = true;
        this.title.setCenterText(this.f31365a.getResources().getString(2131892566));
        final String absolutePath = new File((AppInfo.d().getExternalFilesDir(Environment.DIRECTORY_PICTURES) + CameraContents.f28312c + CameraContents.d.format(new Date())) + ".jpg").getAbsolutePath();
        if (CameraImageUtils.a(trackedModel.cropFace(), absolutePath).length() <= 0) {
            this.d = false;
            return;
        }
        CameraImageUtils.a(absolutePath);
        a(new BluedUIHttpResponse<BluedEntity<AdultVerifyModel, BluedEntityBaseExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.login_register.FaceDetectFragment.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 4036712) {
                    FaceDetectFragment.this.c(str);
                    return true;
                }
                FaceDetectFragment.this.title.e();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<AdultVerifyModel, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("KEY_AV_MODEL", bluedEntity.getSingleData());
                intent.putExtra("KEY_FILE_PATH", absolutePath);
                FaceDetectFragment.this.getActivity().setResult(-1, intent);
                FaceDetectFragment.this.getActivity().finish();
            }
        }, absolutePath, getFragmentActive());
    }

    public void a(final BluedUIHttpResponse bluedUIHttpResponse, final String str, final IRequestHost iRequestHost) {
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.soft.blued.ui.login_register.FaceDetectFragment.5

            /* renamed from: a  reason: collision with root package name */
            boolean f31371a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    AppMethods.d(2131887272);
                    return;
                }
                QiniuUploadUtils.a(str, bluedEntityA.getSingleData(), new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.login_register.FaceDetectFragment.5.1
                    @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                    public void a(String str2) {
                        AppMethods.d(2131887272);
                        if (bluedUIHttpResponse != null) {
                            bluedUIHttpResponse.onFinish();
                        }
                    }

                    @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                    public void a(String str2, double d) {
                    }

                    @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                    public void a(String str2, String str3) {
                        LoginRegisterHttpUtils.b(bluedUIHttpResponse, iRequestHost, str2);
                    }

                    @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                    public boolean a() {
                        return false;
                    }
                });
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                this.f31371a = true;
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                BluedUIHttpResponse bluedUIHttpResponse2 = bluedUIHttpResponse;
                if (bluedUIHttpResponse2 != null) {
                    bluedUIHttpResponse2.onFinish();
                }
            }
        }, iRequestHost);
    }

    public void b() {
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$FaceDetectFragment$vXFpHkEVpA9rG7s2J_niub3WCbM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceDetectFragment.this.b(view);
            }
        });
        this.title.d();
        this.mTextureView.setOpaque(false);
        this.mTextureView.setKeepScreenOn(true);
        this.b = new FaceDetectManager(this.f31365a);
        CameraImageSource cameraImageSource = new CameraImageSource(this.f31365a);
        cameraImageSource.setPreviewView(this.previewView);
        this.b.setImageSource(cameraImageSource);
        this.b.setOnFaceDetectListener(new FaceDetectManager.OnFaceDetectListener() { // from class: com.soft.blued.ui.login_register.FaceDetectFragment.2
            @Override // com.baidu.aip.face.FaceDetectManager.OnFaceDetectListener
            public void onDetectFace(int i, FaceInfo[] faceInfoArr, ImageFrame imageFrame) {
            }
        });
        this.b.setOnTrackListener(new FaceFilter.OnTrackListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$FaceDetectFragment$rOxpmsmXswaI_9-qtQkQmj12Ctk
            @Override // com.baidu.aip.face.FaceFilter.OnTrackListener
            public final void onTrack(FaceFilter.TrackedModel trackedModel) {
                FaceDetectFragment.this.b(trackedModel);
            }
        });
        cameraImageSource.getCameraControl().setPermissionCallback(new PermissionCallback() { // from class: com.soft.blued.ui.login_register.-$$Lambda$FaceDetectFragment$frCciQxd8Wlb3XKoFhvACAS_aNM
            @Override // com.baidu.aip.face.camera.PermissionCallback
            public final boolean onRequestPermission() {
                boolean e;
                e = FaceDetectFragment.this.e();
                return e;
            }
        });
        cameraImageSource.getCameraControl().setPreviewView(this.previewView);
        this.b.addPreProcessor(this.f31366c);
        this.previewView.setScaleType(PreviewView.ScaleType.FIT_WIDTH);
        cameraImageSource.getCameraControl().setDisplayOrientation(getActivity().getWindowManager().getDefaultDisplay().getRotation());
        cameraImageSource.getCameraControl().setCameraFacing(1);
        d();
        this.abortVerify.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$FaceDetectFragment$M372l3bB_9EdpdnXLmvT4eieXEI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceDetectFragment.this.a(view);
            }
        });
    }

    public void c(String str) {
        CommonAlertDialog.a(this.f31365a, this.f31365a.getResources().getString(2131887885), str, this.f31365a.getResources().getString(R.string.av_contact_service), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$FaceDetectFragment$RXWnB5Dg9ugDKJiPAntuleVXrVU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FaceDetectFragment.this.b(dialogInterface, i);
            }
        }, this.f31365a.getResources().getString(R.string.av_again_take_photo), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$FaceDetectFragment$cA2mQ3Fa5lsqNeHfLYO-_1TBjVA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FaceDetectFragment.this.a(dialogInterface, i);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_adult_verify_detect;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        c();
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.e) {
            this.b.start();
            this.e = false;
        }
        CommonTopTitleNoTrans commonTopTitleNoTrans = this.title;
        if (commonTopTitleNoTrans != null) {
            commonTopTitleNoTrans.setCenterText(this.f31365a.getResources().getString(R.string.av_plz_verify));
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.b.stop();
        this.e = true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.login_register.FaceDetectFragment.3
            @Override // java.lang.Runnable
            public void run() {
                FaceDetectFragment.this.f31366c.setDetectedRect(new RectF(FaceDetectFragment.this.flPreview.getLeft(), FaceDetectFragment.this.flPreview.getTop(), FaceDetectFragment.this.flPreview.getRight(), FaceDetectFragment.this.flPreview.getBottom()));
                FaceDetectFragment.this.b.start();
            }
        }, 500L);
    }
}
