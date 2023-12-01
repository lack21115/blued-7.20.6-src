package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fitem.FitemDesireSelectGift;
import com.blued.android.module.live_china.model.LiveDesireSelectGiftModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireSelectGiftDialogFragment.class */
public class LiveDesireSelectGiftDialogFragment extends BaseDialogFragment implements OnClickCallback {
    public Context a;
    public long b;
    public FitemDesireSelectGift c;
    private TextView d;
    private TextView e;
    private RecyclerView f;
    private SmartRefreshLayout g;
    private FreedomAdapter h;
    private List<FitemDesireSelectGift> i;
    private RelativeLayout j;
    private SelectGiftCallBack k;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireSelectGiftDialogFragment$SelectGiftCallBack.class */
    public interface SelectGiftCallBack {
        void selectGift(LiveDesireSelectGiftModel liveDesireSelectGiftModel);
    }

    public LiveDesireSelectGiftDialogFragment(Context context, long j, SelectGiftCallBack selectGiftCallBack) {
        this.a = context;
        this.k = selectGiftCallBack;
        if (j > 0) {
            this.b = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        SelectGiftCallBack selectGiftCallBack = this.k;
        if (selectGiftCallBack == null) {
            return;
        }
        selectGiftCallBack.selectGift(this.c.b);
        dismiss();
    }

    private void d() {
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireSelectGiftDialogFragment$qGPtl3g752h9SyaqWTeYJStvm1k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireSelectGiftDialogFragment.this.a(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireSelectGiftDialogFragment$p-G5eQWOP-2wip4BtrXwft_mgAc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireSelectGiftDialogFragment.this.b(view);
            }
        });
        this.e.setClickable(false);
        this.g.c(false);
        this.g.b(false);
        this.g.f(true);
        this.g.e(true);
        this.g.g(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        FreedomAdapter freedomAdapter = this.h;
        if (freedomAdapter != null) {
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveDesireSelectGiftDialogFragment.1
            public int getSpanSize(int i) {
                return ((FreedomItem) LiveDesireSelectGiftDialogFragment.this.i.get(i)).a(gridLayoutManager.getSpanCount());
            }
        });
        this.f.setLayoutManager(gridLayoutManager);
        FreedomAdapter freedomAdapter2 = new FreedomAdapter(this.a, a(), this.i, this);
        this.h = freedomAdapter2;
        this.f.setAdapter(freedomAdapter2);
    }

    private void f() {
        LiveRoomHttpUtils.A(new BluedUIHttpResponse<BluedEntityA<LiveDesireSelectGiftModel>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveDesireSelectGiftDialogFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveDesireSelectGiftModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null) {
                    return;
                }
                if (LiveDesireSelectGiftDialogFragment.this.i == null) {
                    LiveDesireSelectGiftDialogFragment.this.i = new ArrayList();
                } else {
                    LiveDesireSelectGiftDialogFragment.this.i.clear();
                }
                for (LiveDesireSelectGiftModel liveDesireSelectGiftModel : bluedEntityA.data) {
                    FitemDesireSelectGift fitemDesireSelectGift = new FitemDesireSelectGift(liveDesireSelectGiftModel);
                    if (LiveDesireSelectGiftDialogFragment.this.b > 0 && liveDesireSelectGiftModel.goods_id == LiveDesireSelectGiftDialogFragment.this.b) {
                        fitemDesireSelectGift.c = true;
                        LiveDesireSelectGiftDialogFragment.this.c = fitemDesireSelectGift;
                        LiveDesireSelectGiftDialogFragment.this.e.setClickable(true);
                        LiveDesireSelectGiftDialogFragment.this.e.animate().alpha(1.0f).setDuration(200L);
                    }
                    LiveDesireSelectGiftDialogFragment.this.i.add(fitemDesireSelectGift);
                }
                LiveDesireSelectGiftDialogFragment.this.e();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveDesireSelectGiftDialogFragment.this.j.setVisibility(8);
            }
        });
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
        List<FitemDesireSelectGift> list = this.i;
        if (list == null || list.size() <= i) {
            return;
        }
        FitemDesireSelectGift fitemDesireSelectGift = this.i.get(i);
        if (this.b == fitemDesireSelectGift.b.goods_id) {
            return;
        }
        FitemDesireSelectGift fitemDesireSelectGift2 = this.c;
        if (fitemDesireSelectGift2 != null) {
            fitemDesireSelectGift2.a(false);
        }
        fitemDesireSelectGift.a(true);
        this.b = fitemDesireSelectGift.b.goods_id;
        this.c = fitemDesireSelectGift;
        if (this.e.isClickable()) {
            return;
        }
        this.e.setClickable(true);
        this.e.animate().alpha(1.0f).setDuration(200L);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_desire_adddesire_select_gift, (ViewGroup) null);
        int a = DensityUtils.a(this.a, 364.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, a));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - a;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_desire_adddesire_select_gift, viewGroup);
        this.d = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.e = (TextView) inflate.findViewById(R.id.tv_save);
        this.f = inflate.findViewById(R.id.recycler_view);
        this.g = inflate.findViewById(R.id.smart_refresh);
        this.j = (RelativeLayout) inflate.findViewById(R.id.loading);
        d();
        f();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
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
