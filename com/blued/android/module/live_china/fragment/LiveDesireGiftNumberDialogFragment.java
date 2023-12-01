package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveDesireGiftNumberAdapter;
import com.blued.android.module.live_china.model.LiveDesireGiftNumberModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireGiftNumberDialogFragment.class */
public class LiveDesireGiftNumberDialogFragment extends BaseDialogFragment {
    public Context a;
    public Observer<Boolean> b;
    public LiveDesireGiftNumberModel c;
    private View d;
    private View e;
    private TextView f;
    private RecyclerView g;
    private SmartRefreshLayout h;
    private LiveDesireGiftNumberAdapter i;
    private List<LiveDesireGiftNumberModel> j;
    private RelativeLayout k;
    private SelectGiftNumberCallBack l;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireGiftNumberDialogFragment$SelectGiftNumberCallBack.class */
    public interface SelectGiftNumberCallBack {
        void selectGiftNumber(int i);
    }

    public LiveDesireGiftNumberDialogFragment(Context context, int i, SelectGiftNumberCallBack selectGiftNumberCallBack) {
        this.a = context;
        this.l = selectGiftNumberCallBack;
        if (i > 0) {
            LiveDesireGiftNumberModel liveDesireGiftNumberModel = new LiveDesireGiftNumberModel();
            this.c = liveDesireGiftNumberModel;
            liveDesireGiftNumberModel.count = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        LiveDesireGiftNumberModel liveDesireGiftNumberModel;
        SelectGiftNumberCallBack selectGiftNumberCallBack = this.l;
        if (selectGiftNumberCallBack == null || (liveDesireGiftNumberModel = this.c) == null) {
            return;
        }
        selectGiftNumberCallBack.selectGiftNumber(liveDesireGiftNumberModel.count);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, Boolean bool) {
        view.animate().translationY(bool.booleanValue() ? 0.0f : view.getHeight()).setStartDelay(bool.booleanValue() ? 100L : 0L).setDuration(350L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveDesireGiftNumberModel liveDesireGiftNumberModel) {
        this.c = liveDesireGiftNumberModel;
        this.f.setClickable(liveDesireGiftNumberModel != null);
        this.f.animate().alpha(liveDesireGiftNumberModel == null ? 0.3f : 1.0f).setDuration(200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        dismiss();
    }

    private void d() {
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireGiftNumberDialogFragment$UTnO1bP3fNbmoVSOmQ2aqTsEl90
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireGiftNumberDialogFragment.this.c(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireGiftNumberDialogFragment$_z_W4vNArb9QzFbb7enpn2MMeho
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireGiftNumberDialogFragment.this.b(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireGiftNumberDialogFragment$O44u9qhwHwKPHchF0dLUnSk6bw8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireGiftNumberDialogFragment.this.a(view);
            }
        });
        this.f.setClickable(false);
        this.h.c(false);
        this.h.b(false);
        this.h.f(true);
        this.h.e(true);
        this.h.g(true);
    }

    private void e() {
        this.i = new LiveDesireGiftNumberAdapter(this.a, getFragmentManager(), new LiveDesireGiftNumberAdapter.GiftNumberEventCallBack() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireGiftNumberDialogFragment$rRkvtEQfrDetaCz4gVzo0bsEBE0
            @Override // com.blued.android.module.live_china.adapter.LiveDesireGiftNumberAdapter.GiftNumberEventCallBack
            public final void giftNumber(LiveDesireGiftNumberModel liveDesireGiftNumberModel) {
                LiveDesireGiftNumberDialogFragment.this.a(liveDesireGiftNumberModel);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.g.setLayoutManager(linearLayoutManager);
        this.g.setAdapter(this.i);
    }

    private void f() {
        LiveRoomHttpUtils.B(new BluedUIHttpResponse<BluedEntityA<LiveDesireGiftNumberModel>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveDesireGiftNumberDialogFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveDesireGiftNumberModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null) {
                    return;
                }
                if (LiveDesireGiftNumberDialogFragment.this.j == null) {
                    LiveDesireGiftNumberDialogFragment.this.j = new ArrayList();
                } else {
                    LiveDesireGiftNumberDialogFragment.this.j.clear();
                }
                if (bluedEntityA.data != null && bluedEntityA.data.size() != 0) {
                    LiveDesireGiftNumberDialogFragment.this.j.addAll(bluedEntityA.data);
                }
                int i = 0;
                while (i < LiveDesireGiftNumberDialogFragment.this.j.size()) {
                    LiveDesireGiftNumberModel liveDesireGiftNumberModel = (LiveDesireGiftNumberModel) LiveDesireGiftNumberDialogFragment.this.j.get(i);
                    i++;
                    liveDesireGiftNumberModel.id = i;
                }
                int i2 = 0;
                if (LiveDesireGiftNumberDialogFragment.this.c != null) {
                    i2 = 0;
                    if (LiveDesireGiftNumberDialogFragment.this.c.count > 0) {
                        i2 = LiveDesireGiftNumberDialogFragment.this.c.count;
                    }
                }
                LiveDesireGiftNumberModel liveDesireGiftNumberModel2 = null;
                LiveDesireGiftNumberModel liveDesireGiftNumberModel3 = null;
                if (i2 > 0) {
                    Iterator it = LiveDesireGiftNumberDialogFragment.this.j.iterator();
                    while (true) {
                        liveDesireGiftNumberModel2 = liveDesireGiftNumberModel3;
                        if (!it.hasNext()) {
                            break;
                        }
                        LiveDesireGiftNumberModel liveDesireGiftNumberModel4 = (LiveDesireGiftNumberModel) it.next();
                        if (liveDesireGiftNumberModel4.count == i2) {
                            liveDesireGiftNumberModel3 = liveDesireGiftNumberModel4;
                        }
                    }
                }
                LiveDesireGiftNumberModel liveDesireGiftNumberModel5 = new LiveDesireGiftNumberModel();
                liveDesireGiftNumberModel5.type = 1;
                liveDesireGiftNumberModel5.id = LiveDesireGiftNumberDialogFragment.this.j.size() + 1;
                LiveDesireGiftNumberModel liveDesireGiftNumberModel6 = liveDesireGiftNumberModel2;
                if (i2 > 0) {
                    liveDesireGiftNumberModel6 = liveDesireGiftNumberModel2;
                    if (liveDesireGiftNumberModel2 == null) {
                        liveDesireGiftNumberModel5.count = i2;
                        liveDesireGiftNumberModel6 = liveDesireGiftNumberModel5;
                    }
                }
                LiveDesireGiftNumberDialogFragment.this.j.add(liveDesireGiftNumberModel5);
                if (i2 > 0 && liveDesireGiftNumberModel6 != null) {
                    LiveDesireGiftNumberDialogFragment.this.c = liveDesireGiftNumberModel6;
                    LiveDesireGiftNumberDialogFragment.this.i.c = liveDesireGiftNumberModel6.id;
                    LiveDesireGiftNumberDialogFragment.this.f.setClickable(true);
                    LiveDesireGiftNumberDialogFragment.this.f.animate().alpha(1.0f).setDuration(200L);
                }
                LiveDesireGiftNumberDialogFragment.this.i.a(LiveDesireGiftNumberDialogFragment.this.j);
                LiveDesireGiftNumberDialogFragment.this.i.notifyDataSetChanged();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveDesireGiftNumberDialogFragment.this.k.setVisibility(8);
            }
        });
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_desire_adddesire_gift_number, (ViewGroup) null);
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, height));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = height;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        final View inflate = layoutInflater.inflate(R.layout.dialog_live_desire_adddesire_gift_number, viewGroup);
        this.d = inflate.findViewById(R.id.rl_root);
        this.e = inflate.findViewById(R.id.iv_close);
        this.f = (TextView) inflate.findViewById(R.id.tv_confirm);
        this.g = inflate.findViewById(R.id.recycler_view);
        this.h = inflate.findViewById(R.id.smart_refresh);
        this.k = (RelativeLayout) inflate.findViewById(R.id.loading);
        d();
        e();
        f();
        this.b = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireGiftNumberDialogFragment$0oh-zaaB23wI0Q3fq33OVMHz6Bc
            public final void onChanged(Object obj) {
                LiveDesireGiftNumberDialogFragment.a(View.this, (Boolean) obj);
            }
        };
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
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
