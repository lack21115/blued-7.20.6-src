package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveAnnounceContentModel;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.find.model.UserFindResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveAnnoContentDialogFragment.class */
public class LiveAnnoContentDialogFragment extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    IEventCallback f12694a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f12695c;
    private View d;
    private RecyclerView e;
    private LiveAnnounceAdapter f;
    private Context g;
    private boolean h = false;
    private List<LiveAnnounceContentModel> i = new ArrayList();
    private String j;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveAnnoContentDialogFragment$IEventCallback.class */
    public interface IEventCallback {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveAnnoContentDialogFragment$LiveAnnounceAdapter.class */
    public class LiveAnnounceAdapter extends BaseQuickAdapter<LiveAnnounceContentModel, BaseViewHolder> {
        private List<LiveAnnounceContentModel> b;

        public LiveAnnounceAdapter(Context context) {
            super(R.layout.live_announce_content_item);
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            setNewData(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final LiveAnnounceContentModel liveAnnounceContentModel) {
            if (liveAnnounceContentModel == null) {
                return;
            }
            baseViewHolder.setText(R.id.tv_content, liveAnnounceContentModel.option_notice);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_content);
            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) baseViewHolder.getView(R.id.sfl_content);
            ShapeModel shapeModel = new ShapeModel();
            shapeModel.H = DensityUtils.a(this.mContext, 6.0f);
            if (TextUtils.equals(LiveAnnoContentDialogFragment.this.j, liveAnnounceContentModel.option_notice)) {
                shapeModel.k = ContextCompat.getColor(this.mContext, R.color.syc_dark_1a1A7EFF);
                shapeModel.n = ContextCompat.getColor(this.mContext, R.color.syc_dark_1A7EFF);
                shapeModel.q = DensityUtils.a(LiveAnnoContentDialogFragment.this.getContext(), 0.5f);
                textView.setTextColor(ContextCompat.getColor(this.mContext, R.color.syc_dark_1A7EFF));
            } else {
                shapeModel.k = ContextCompat.getColor(this.mContext, R.color.syc_dark_00000000);
                textView.setTextColor(ContextCompat.getColor(this.mContext, R.color.syc_dark_1e1f23));
            }
            shapeFrameLayout.setShapeModel(shapeModel);
            textView.setText(liveAnnounceContentModel.option_notice);
            baseViewHolder.getView(R.id.fl_root).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveAnnoContentDialogFragment.LiveAnnounceAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (TextUtils.equals(LiveAnnoContentDialogFragment.this.j, liveAnnounceContentModel.option_notice)) {
                        LiveAnnoContentDialogFragment.this.j = "";
                    } else {
                        LiveAnnoContentDialogFragment.this.j = liveAnnounceContentModel.option_notice;
                    }
                    LiveAnnounceAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    private void e() {
        if (getArguments() != null) {
            ArrayList<String> stringArrayList = getArguments().getStringArrayList("announce");
            this.j = getArguments().getString(UserFindResult.USER_SORT_BY.SELECTED);
            if (stringArrayList != null) {
                for (String str : stringArrayList) {
                    LiveAnnounceContentModel liveAnnounceContentModel = new LiveAnnounceContentModel();
                    liveAnnounceContentModel.option_notice = str;
                    this.i.add(liveAnnounceContentModel);
                }
            }
        }
    }

    private void f() {
        this.f12695c = this.b.findViewById(R.id.tv_cancel);
        this.d = this.b.findViewById(R.id.tv_save);
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R.id.recy_view);
        this.e = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LiveAnnounceAdapter liveAnnounceAdapter = new LiveAnnounceAdapter(getContext());
        this.f = liveAnnounceAdapter;
        this.e.setAdapter(liveAnnounceAdapter);
        this.f12695c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f.setNewData(this.i);
    }

    public void a(IEventCallback iEventCallback) {
        this.f12694a = iEventCallback;
    }

    public boolean d() {
        return this.h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_cancel) {
            dismissAllowingStateLoss();
        } else if (view.getId() == R.id.tv_save) {
            dismissAllowingStateLoss();
            IEventCallback iEventCallback = this.f12694a;
            if (iEventCallback != null) {
                iEventCallback.a(this.j);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.g = getContext();
        this.h = true;
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_announce_content, (ViewGroup) null);
        int a2 = DensityUtils.a(this.g, 364.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - a2;
        dialog.onWindowAttributesChanged(attributes);
        e();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.dialog_live_announce_content, viewGroup, false);
            f();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveAnnoContentDialogFragment.1
            @Override // java.lang.Runnable
            public void run() {
                LiveAnnoContentDialogFragment.this.h = false;
            }
        }, 300L);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
