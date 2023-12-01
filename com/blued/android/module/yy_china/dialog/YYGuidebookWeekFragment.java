package com.blued.android.module.yy_china.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYCityAdapter;
import com.blued.android.module.yy_china.databinding.DialogRomanticCityListBinding;
import com.blued.android.module.yy_china.fragment.BaseLazyFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRomanticCityExtra;
import com.blued.android.module.yy_china.model.YYRomanticCityModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/dialog/YYGuidebookWeekFragment.class */
public final class YYGuidebookWeekFragment extends BaseLazyFragment {
    private DialogRomanticCityListBinding b;

    /* renamed from: c  reason: collision with root package name */
    private YYCityAdapter f16988c;

    /* renamed from: a  reason: collision with root package name */
    private final String f16987a = "https://web.bldimg.com/image-manager/1687760089_43172.png";
    private String d = "";
    private String e = "";

    private final void a(boolean z) {
        DialogRomanticCityListBinding dialogRomanticCityListBinding = this.b;
        DialogRomanticCityListBinding dialogRomanticCityListBinding2 = dialogRomanticCityListBinding;
        if (dialogRomanticCityListBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticCityListBinding2 = null;
        }
        dialogRomanticCityListBinding2.f16395a.setVisibility(z ? 8 : 0);
        DialogRomanticCityListBinding dialogRomanticCityListBinding3 = this.b;
        DialogRomanticCityListBinding dialogRomanticCityListBinding4 = dialogRomanticCityListBinding3;
        if (dialogRomanticCityListBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticCityListBinding4 = null;
        }
        dialogRomanticCityListBinding4.f16396c.setVisibility(z ? 8 : 0);
        DialogRomanticCityListBinding dialogRomanticCityListBinding5 = this.b;
        if (dialogRomanticCityListBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticCityListBinding5 = null;
        }
        RecyclerView recyclerView = dialogRomanticCityListBinding5.b;
        int i = 8;
        if (z) {
            i = 0;
        }
        recyclerView.setVisibility(i);
    }

    private final void b() {
        String str = this.e;
        String str2 = this.d;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.y(str, str2, new BluedUIHttpResponse<BluedEntity<YYRomanticCityModel, YYRomanticCityExtra>>(fragmentActive) { // from class: com.blued.android.module.yy_china.dialog.YYGuidebookWeekFragment$loadCityList$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str3) {
                YYGuidebookWeekFragment.this.e();
                return super.onUIFailure(i, str3);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYRomanticCityModel, YYRomanticCityExtra> bluedEntity) {
                YYCityAdapter yYCityAdapter;
                String str3;
                DialogRomanticCityListBinding dialogRomanticCityListBinding;
                if (bluedEntity == null) {
                    return;
                }
                if (bluedEntity.extra != null) {
                    str3 = YYGuidebookWeekFragment.this.d;
                    if (TextUtils.equals("2", str3)) {
                        dialogRomanticCityListBinding = YYGuidebookWeekFragment.this.b;
                        DialogRomanticCityListBinding dialogRomanticCityListBinding2 = dialogRomanticCityListBinding;
                        if (dialogRomanticCityListBinding == null) {
                            Intrinsics.c("mBinding");
                            dialogRomanticCityListBinding2 = null;
                        }
                        dialogRomanticCityListBinding2.d.setText("注：当收集" + bluedEntity.extra.getReceive_all_low() + "个稀有地点，可获得初级专属勋章，永久有效；当收集" + bluedEntity.extra.getReceive_all_high() + "个稀有地点，可获得高级专属勋章，永久有效。");
                    }
                }
                if (!bluedEntity.hasData()) {
                    YYGuidebookWeekFragment.this.e();
                    return;
                }
                yYCityAdapter = YYGuidebookWeekFragment.this.f16988c;
                YYCityAdapter yYCityAdapter2 = yYCityAdapter;
                if (yYCityAdapter2 == null) {
                    Intrinsics.c("cityAdapter");
                    yYCityAdapter2 = null;
                }
                yYCityAdapter2.setNewData(bluedEntity.data);
                YYGuidebookWeekFragment.this.d();
            }
        }, getFragmentActive());
    }

    private final void c() {
        if (TextUtils.equals("1", this.d)) {
            DialogRomanticCityListBinding dialogRomanticCityListBinding = this.b;
            DialogRomanticCityListBinding dialogRomanticCityListBinding2 = dialogRomanticCityListBinding;
            if (dialogRomanticCityListBinding == null) {
                Intrinsics.c("mBinding");
                dialogRomanticCityListBinding2 = null;
            }
            dialogRomanticCityListBinding2.d.setText("注：每周一00:00:00-每周末23:59:59收集到所有地点，即可获得专属勋章和专属称号");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        a(false);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.d = String.valueOf(arguments == null ? null : arguments.getString("type"));
        Bundle arguments2 = getArguments();
        this.e = String.valueOf(arguments2 == null ? null : arguments2.getString("user_id"));
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_romantic_city_list, (ViewGroup) null);
        DialogRomanticCityListBinding a2 = DialogRomanticCityListBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.b = a2;
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseLazyFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        b();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        ImageWrapper a2 = ImageLoader.a(getFragmentActive(), this.f16987a);
        DialogRomanticCityListBinding dialogRomanticCityListBinding = this.b;
        DialogRomanticCityListBinding dialogRomanticCityListBinding2 = dialogRomanticCityListBinding;
        if (dialogRomanticCityListBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticCityListBinding2 = null;
        }
        a2.a(dialogRomanticCityListBinding2.f16395a);
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        this.f16988c = new YYCityAdapter(fragmentActive);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        DialogRomanticCityListBinding dialogRomanticCityListBinding3 = this.b;
        DialogRomanticCityListBinding dialogRomanticCityListBinding4 = dialogRomanticCityListBinding3;
        if (dialogRomanticCityListBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticCityListBinding4 = null;
        }
        dialogRomanticCityListBinding4.b.setLayoutManager(gridLayoutManager);
        DialogRomanticCityListBinding dialogRomanticCityListBinding5 = this.b;
        DialogRomanticCityListBinding dialogRomanticCityListBinding6 = dialogRomanticCityListBinding5;
        if (dialogRomanticCityListBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticCityListBinding6 = null;
        }
        RecyclerView recyclerView = dialogRomanticCityListBinding6.b;
        YYCityAdapter yYCityAdapter = this.f16988c;
        if (yYCityAdapter == null) {
            Intrinsics.c("cityAdapter");
            yYCityAdapter = null;
        }
        recyclerView.setAdapter(yYCityAdapter);
        c();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(TextUtils.equals("1", this.d) ? ChatRoomProtos.Event.YY_ROMANTIC_HANDBOOK_PAGE_SHOW : ChatRoomProtos.Event.YY_ROMANTIC_ALL_HANDBOOK_PAGE_SHOW, b.room_id, b.uid);
    }
}
