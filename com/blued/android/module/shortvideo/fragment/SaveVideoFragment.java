package com.blued.android.module.shortvideo.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.base.shortvideo.ISaveInterface;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.utils.StvMediaUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/SaveVideoFragment.class */
public class SaveVideoFragment extends KeyBoardFragment {
    private static String b = "from";
    private ProgressBar c;
    private TextView j;
    private View k;
    private View l;
    private EditDataModel m;
    private int n;

    private void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = getArguments();
        }
        if (bundle2 == null) {
            AppMethods.d(R.string.common_net_error);
            getActivity().finish();
            return;
        }
        CommonModel commonModel = (CommonModel) bundle2.getSerializable("commont_model");
        EditDataModel.SerializableData serializableData = (EditDataModel.SerializableData) bundle2.getSerializable("serializeble_data");
        if ((serializableData == null || TextUtils.isEmpty(serializableData.getVideoPath())) && (commonModel == null || TextUtils.isEmpty(commonModel.getVideoPath()))) {
            AppMethods.d(R.string.common_net_error);
            getActivity().finish();
            return;
        }
        EditDataModel editDataModel = new EditDataModel();
        this.m = editDataModel;
        editDataModel.copyModel(commonModel, serializableData);
        this.n = bundle2.getInt(b);
        StvMediaUtils.a(getContext(), this.m.getSerializableData(), this.m.getSerializableData(), this.n, this.m.getSerializableData().getPrePageType(), new ISaveInterface() { // from class: com.blued.android.module.shortvideo.fragment.SaveVideoFragment.1
            @Override // com.blued.android.module.base.shortvideo.ISaveInterface
            public void a() {
                Logger.c("StvMediaUtils", "onSaveVideoCanceled ");
                SaveVideoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.shortvideo.fragment.SaveVideoFragment.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SaveVideoFragment.this.c.setVisibility(8);
                        AppMethods.d(R.string.common_net_error);
                        SaveVideoFragment.this.getActivity().finish();
                    }
                });
            }

            @Override // com.blued.android.module.base.shortvideo.ISaveInterface
            public void a(final float f) {
                Logger.c("StvMediaUtils", "progress " + f);
                SaveVideoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.shortvideo.fragment.SaveVideoFragment.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = (int) (f * 100.0f);
                        TextView textView = SaveVideoFragment.this.j;
                        textView.setText(i + "%");
                    }
                });
            }

            @Override // com.blued.android.module.base.shortvideo.ISaveInterface
            public void a(int i) {
                Logger.c("StvMediaUtils", "onSaveFailed ");
                SaveVideoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.shortvideo.fragment.SaveVideoFragment.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SaveVideoFragment.this.c.setVisibility(8);
                        AppMethods.d(R.string.common_net_error);
                        SaveVideoFragment.this.getActivity().finish();
                    }
                });
            }

            @Override // com.blued.android.module.base.shortvideo.ISaveInterface
            public void a(final StvResultModel stvResultModel) {
                Logger.c("StvMediaUtils", "onSaveSucess");
                SaveVideoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.shortvideo.fragment.SaveVideoFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SaveVideoFragment.this.j.setText("100%");
                        SaveVideoFragment.this.c.setVisibility(8);
                        SaveVideoFragment.this.a(stvResultModel);
                    }
                });
            }

            @Override // com.blued.android.module.base.shortvideo.ISaveInterface
            public void b() {
                if (SaveVideoFragment.this.k.getVisibility() != 0) {
                    SaveVideoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.shortvideo.fragment.SaveVideoFragment.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            SaveVideoFragment.this.k.setVisibility(0);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StvResultModel stvResultModel) {
        Intent intent = new Intent();
        intent.putExtra("result_model", stvResultModel);
        intent.putExtra("close_page", true);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    public static void a(Object obj, Bundle bundle, int i, int i2) {
        if (bundle == null) {
            return;
        }
        bundle.putSerializable(b, Integer.valueOf(i));
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        if (obj instanceof Activity) {
            TransparentActivity.b((Activity) obj, SaveVideoFragment.class, bundle, i2);
        } else if (obj instanceof Fragment) {
            TransparentActivity.b((Fragment) obj, SaveVideoFragment.class, bundle, i2);
        } else if (obj instanceof Application) {
            TransparentActivity.b((Context) obj, SaveVideoFragment.class, bundle);
        }
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_stv_save, viewGroup, false);
        this.l = inflate;
        this.c = (ProgressBar) inflate.findViewById(R.id.pb);
        this.j = (TextView) this.l.findViewById(R.id.progress);
        this.k = this.l.findViewById(R.id.pblayout);
        a(bundle);
        return this.l;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
    }
}
