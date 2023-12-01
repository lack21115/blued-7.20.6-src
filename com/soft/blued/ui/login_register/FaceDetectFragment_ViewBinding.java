package com.soft.blued.ui.login_register;

import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.baidu.aip.face.TexturePreviewView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/FaceDetectFragment_ViewBinding.class */
public class FaceDetectFragment_ViewBinding implements Unbinder {
    private FaceDetectFragment b;

    public FaceDetectFragment_ViewBinding(FaceDetectFragment faceDetectFragment, View view) {
        this.b = faceDetectFragment;
        faceDetectFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        faceDetectFragment.previewView = (TexturePreviewView) Utils.a(view, R.id.preview_view, "field 'previewView'", TexturePreviewView.class);
        faceDetectFragment.cameraTips = (TextView) Utils.a(view, R.id.camera_tips, "field 'cameraTips'", TextView.class);
        faceDetectFragment.flPreview = (FrameLayout) Utils.a(view, R.id.fl_preview, "field 'flPreview'", FrameLayout.class);
        faceDetectFragment.abortVerify = (TextView) Utils.a(view, R.id.abort_verify, "field 'abortVerify'", TextView.class);
        faceDetectFragment.mTextureView = (TextureView) Utils.a(view, 2131370638, "field 'mTextureView'", TextureView.class);
        faceDetectFragment.tvTips = (TextView) Utils.a(view, 2131372745, "field 'tvTips'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FaceDetectFragment faceDetectFragment = this.b;
        if (faceDetectFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        faceDetectFragment.title = null;
        faceDetectFragment.previewView = null;
        faceDetectFragment.cameraTips = null;
        faceDetectFragment.flPreview = null;
        faceDetectFragment.abortVerify = null;
        faceDetectFragment.mTextureView = null;
        faceDetectFragment.tvTips = null;
    }
}
