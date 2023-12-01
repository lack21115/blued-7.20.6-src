package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ChatroomMIcBeansModel;
import com.blued.android.module.yy_china.model.MIcBeansInfoModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.blued.android.module.yy_china.view.YYMemberEntertainmentView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatEntertainmentAdapter.class */
public final class YYSeatEntertainmentAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements View.OnClickListener, SeatChangedObserver {
    private BaseYYStudioFragment a;
    private YYRoomModel b;
    private HashMap<Integer, YYMemberEntertainmentView> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYSeatEntertainmentAdapter(Context context, BaseYYStudioFragment fragmentActive) {
        super(null);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.mContext = context;
        this.a = fragmentActive;
        addItemType(10, R.layout.item_yy_connecting_entertainment_layout);
        this.b = YYRoomInfoManager.e().b();
        this.c = new HashMap<>();
    }

    private final void a(int i, View view) {
        YYRoomModel yYRoomModel;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel2 = this.b;
        if (yYRoomModel2 != null) {
            List<YYSeatMemberModel> list2 = yYRoomModel2 == null ? null : yYRoomModel2.mics;
            if ((list2 == null || list2.isEmpty()) || (yYRoomModel = this.b) == null || (list = yYRoomModel.mics) == null || i > list.size() - 1 || i < 0) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = list.get(i);
            BaseYYStudioFragment baseYYStudioFragment = this.a;
            if (baseYYStudioFragment == null) {
                return;
            }
            baseYYStudioFragment.a(view, yYSeatMemberModel, yYSeatMemberModel.mic_position);
        }
    }

    private final void a(int i, YYSeatMemberModel yYSeatMemberModel) {
        HashMap<Integer, YYMemberEntertainmentView> hashMap = this.c;
        ActivityFragmentActive activityFragmentActive = null;
        YYMemberEntertainmentView yYMemberEntertainmentView = hashMap == null ? null : hashMap.get(Integer.valueOf(i));
        if (yYMemberEntertainmentView == null) {
            return;
        }
        yYSeatMemberModel.isBoss = yYSeatMemberModel.mic_position == 8;
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        if (baseYYStudioFragment != null) {
            activityFragmentActive = baseYYStudioFragment.getFragmentActive();
        }
        yYMemberEntertainmentView.a(yYSeatMemberModel, activityFragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    private final void b() {
        YYRoomModel yYRoomModel;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel2 = this.b;
        if (yYRoomModel2 == null) {
            return;
        }
        List<YYSeatMemberModel> list2 = yYRoomModel2 == null ? null : yYRoomModel2.mics;
        if ((list2 == null || list2.isEmpty()) || (yYRoomModel = this.b) == null || (list = yYRoomModel.mics) == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            YYSeatMemberModel member = list.get(i2);
            Intrinsics.c(member, "member");
            a(i2, member);
            i = i2 + 1;
        }
    }

    public final void a() {
        YYRoomModel yYRoomModel;
        ChatroomMIcBeansModel chatroomMIcBeansModel;
        YYRoomModel yYRoomModel2;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel3 = this.b;
        if (yYRoomModel3 == null) {
            return;
        }
        List<YYSeatMemberModel> list2 = yYRoomModel3 == null ? null : yYRoomModel3.mics;
        if ((list2 == null || list2.isEmpty()) || (yYRoomModel = this.b) == null || (chatroomMIcBeansModel = yYRoomModel.micBeansModel) == null || (yYRoomModel2 = this.b) == null || (list = yYRoomModel2.mics) == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = list.get(i2);
            HashMap<Integer, YYMemberEntertainmentView> hashMap = this.c;
            YYMemberEntertainmentView yYMemberEntertainmentView = hashMap == null ? null : hashMap.get(Integer.valueOf(i2));
            if (chatroomMIcBeansModel.getStatus() == 0 && yYMemberEntertainmentView != null) {
                yYMemberEntertainmentView.a("0", false);
            }
            if (chatroomMIcBeansModel.getStatus() == 1) {
                String str = "0";
                for (MIcBeansInfoModel mIcBeansInfoModel : chatroomMIcBeansModel.getMic_beans_info()) {
                    if (yYSeatMemberModel.getUid().equals(mIcBeansInfoModel.getUid())) {
                        str = mIcBeansInfoModel.getBean();
                    }
                }
                if (yYMemberEntertainmentView != null) {
                    String b = CommonStringUtils.b(Float.parseFloat(str));
                    Intrinsics.c(b, "formatLeveValue(beans.toFloat())");
                    yYMemberEntertainmentView.a(b, true);
                }
            }
            if (chatroomMIcBeansModel.getStatus() == 2 && yYMemberEntertainmentView != null) {
                yYMemberEntertainmentView.a("0", true);
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void a(int i, int i2) {
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel != null) {
            if ((yYRoomModel == null ? null : yYRoomModel.mics) == null) {
                return;
            }
            YYRoomModel yYRoomModel2 = this.b;
            if (yYRoomModel2 != null && (list = yYRoomModel2.mics) != null) {
                int i3 = 0;
                int size = list.size();
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    YYSeatMemberModel yYSeatMemberModel = list.get(i3);
                    if (yYSeatMemberModel.mic_position != i) {
                        i3++;
                    } else if (i2 == 1) {
                        yYSeatMemberModel.position_status = -1;
                    } else {
                        yYSeatMemberModel.position_status = i2;
                    }
                }
            }
            b();
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, String str, String str2, YYImModel yYImModel) {
        HashMap<Integer, YYMemberEntertainmentView> hashMap = this.c;
        if (hashMap != null) {
            ActivityFragmentActive activityFragmentActive = null;
            Integer valueOf = hashMap == null ? null : Integer.valueOf(hashMap.size());
            Intrinsics.a(valueOf);
            if (i > valueOf.intValue()) {
                return;
            }
            HashMap<Integer, YYMemberEntertainmentView> hashMap2 = this.c;
            YYMemberEntertainmentView yYMemberEntertainmentView = hashMap2 == null ? null : hashMap2.get(Integer.valueOf(i));
            if (yYMemberEntertainmentView == null) {
                return;
            }
            BaseYYStudioFragment baseYYStudioFragment = this.a;
            if (baseYYStudioFragment != null) {
                activityFragmentActive = baseYYStudioFragment.getFragmentActive();
            }
            yYMemberEntertainmentView.a(activityFragmentActive, str, str2, yYImModel);
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str) {
        List<YYSeatMemberModel> list;
        HashMap<Integer, YYMemberEntertainmentView> hashMap;
        YYMemberEntertainmentView yYMemberEntertainmentView;
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel == null || (list = yYRoomModel.mics) == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.a(str, list.get(i).getUid()) && (hashMap = this.c) != null && (yYMemberEntertainmentView = hashMap.get(Integer.valueOf(i))) != null) {
                yYMemberEntertainmentView.a(getViewX_Y_W_H);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        ConstraintLayout view;
        if (baseViewHolder != null && (view = baseViewHolder.getView(R.id.item_ktv_root)) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatEntertainmentAdapter$NKd_GUzpdq3guRp05yveEjPOX1c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYSeatEntertainmentAdapter.a(view2);
                }
            });
        }
        YYMemberEntertainmentView yYMemberEntertainmentView = baseViewHolder == null ? null : (YYMemberEntertainmentView) baseViewHolder.getView(R.id.user_1);
        if (yYMemberEntertainmentView != null) {
            yYMemberEntertainmentView.setOnClickListener(this);
        }
        YYMemberEntertainmentView yYMemberEntertainmentView2 = baseViewHolder == null ? null : (YYMemberEntertainmentView) baseViewHolder.getView(R.id.user_2);
        if (yYMemberEntertainmentView2 != null) {
            yYMemberEntertainmentView2.setOnClickListener(this);
        }
        YYMemberEntertainmentView yYMemberEntertainmentView3 = baseViewHolder == null ? null : (YYMemberEntertainmentView) baseViewHolder.getView(R.id.user_3);
        if (yYMemberEntertainmentView3 != null) {
            yYMemberEntertainmentView3.setOnClickListener(this);
        }
        YYMemberEntertainmentView yYMemberEntertainmentView4 = baseViewHolder == null ? null : (YYMemberEntertainmentView) baseViewHolder.getView(R.id.user_4);
        if (yYMemberEntertainmentView4 != null) {
            yYMemberEntertainmentView4.setOnClickListener(this);
        }
        YYMemberEntertainmentView yYMemberEntertainmentView5 = baseViewHolder == null ? null : (YYMemberEntertainmentView) baseViewHolder.getView(R.id.user_5);
        if (yYMemberEntertainmentView5 != null) {
            yYMemberEntertainmentView5.setOnClickListener(this);
        }
        YYMemberEntertainmentView yYMemberEntertainmentView6 = baseViewHolder == null ? null : (YYMemberEntertainmentView) baseViewHolder.getView(R.id.user_6);
        if (yYMemberEntertainmentView6 != null) {
            yYMemberEntertainmentView6.setOnClickListener(this);
        }
        YYMemberEntertainmentView yYMemberEntertainmentView7 = baseViewHolder == null ? null : (YYMemberEntertainmentView) baseViewHolder.getView(R.id.user_7);
        if (yYMemberEntertainmentView7 != null) {
            yYMemberEntertainmentView7.setOnClickListener(this);
        }
        YYMemberEntertainmentView yYMemberEntertainmentView8 = baseViewHolder == null ? null : (YYMemberEntertainmentView) baseViewHolder.getView(R.id.user_8);
        if (yYMemberEntertainmentView8 != null) {
            yYMemberEntertainmentView8.setOnClickListener(this);
        }
        YYMemberEntertainmentView yYMemberEntertainmentView9 = baseViewHolder == null ? null : (YYMemberEntertainmentView) baseViewHolder.getView(R.id.user_9);
        if (yYMemberEntertainmentView9 != null) {
            yYMemberEntertainmentView9.setOnClickListener(this);
        }
        HashMap<Integer, YYMemberEntertainmentView> hashMap = this.c;
        if (hashMap != null) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap2 = hashMap;
            hashMap2.put(0, yYMemberEntertainmentView);
            hashMap2.put(1, yYMemberEntertainmentView2);
            hashMap2.put(2, yYMemberEntertainmentView3);
            hashMap2.put(3, yYMemberEntertainmentView4);
            hashMap2.put(4, yYMemberEntertainmentView5);
            hashMap2.put(5, yYMemberEntertainmentView6);
            hashMap2.put(6, yYMemberEntertainmentView7);
            hashMap2.put(7, yYMemberEntertainmentView8);
            hashMap2.put(8, yYMemberEntertainmentView9);
        }
        b();
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(String str, String str2) {
        YYRoomModel yYRoomModel;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel2 = this.b;
        if (yYRoomModel2 == null) {
            return;
        }
        List<YYSeatMemberModel> list2 = yYRoomModel2 == null ? null : yYRoomModel2.mics;
        if ((list2 == null || list2.isEmpty()) || (yYRoomModel = this.b) == null || (list = yYRoomModel.mics) == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            YYSeatMemberModel member = list.get(i2);
            if (TextUtils.equals(member.getUid(), str)) {
                member.chat_anchor = str2;
                Intrinsics.c(member, "member");
                a(i2, member);
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(Set<String> set) {
        List<YYSeatMemberModel> list;
        YYMemberEntertainmentView yYMemberEntertainmentView;
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel == null || (list = yYRoomModel.mics) == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = list.get(i2);
            if (yYSeatMemberModel.is_open_mic != 0) {
                Set<String> set2 = set;
                if ((set2 == null || set2.isEmpty()) || !set.contains(yYSeatMemberModel.getUid())) {
                    yYSeatMemberModel.is_open_mic = 1;
                } else {
                    yYSeatMemberModel.is_open_mic = 2;
                }
                HashMap<Integer, YYMemberEntertainmentView> hashMap = this.c;
                if (hashMap != null && (yYMemberEntertainmentView = hashMap.get(Integer.valueOf(i2))) != null) {
                    yYMemberEntertainmentView.a(set, yYSeatMemberModel);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void b(List<YYSeatMemberModel> list) {
        if (list == null) {
            return;
        }
        b();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Logger.e("observer", "YYSeatKTVAdapter onAttachedToRecyclerView ...");
        YYObserverManager.a().a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.blued.android.module.yy_china.view.YYMemberEntertainmentView] */
    /* JADX WARN: Type inference failed for: r0v36, types: [com.blued.android.module.yy_china.view.YYMemberEntertainmentView] */
    /* JADX WARN: Type inference failed for: r0v44, types: [com.blued.android.module.yy_china.view.YYMemberEntertainmentView] */
    /* JADX WARN: Type inference failed for: r0v52, types: [com.blued.android.module.yy_china.view.YYMemberEntertainmentView] */
    /* JADX WARN: Type inference failed for: r0v60, types: [com.blued.android.module.yy_china.view.YYMemberEntertainmentView] */
    /* JADX WARN: Type inference failed for: r0v68, types: [com.blued.android.module.yy_china.view.YYMemberEntertainmentView] */
    /* JADX WARN: Type inference failed for: r0v76, types: [com.blued.android.module.yy_china.view.YYMemberEntertainmentView] */
    /* JADX WARN: Type inference failed for: r0v84, types: [com.blued.android.module.yy_china.view.YYMemberEntertainmentView] */
    /* JADX WARN: Type inference failed for: r0v93, types: [com.blued.android.module.yy_china.view.YYMemberEntertainmentView] */
    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Tracker.onClick(v);
        Intrinsics.e(v, "v");
        int id = v.getId();
        View view = null;
        if (id == R.id.user_1) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap = this.c;
            if (hashMap != null) {
                view = hashMap.get(0);
            }
            a(0, view);
        } else if (id == R.id.user_2) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap2 = this.c;
            a(1, hashMap2 == null ? null : hashMap2.get(1));
        } else if (id == R.id.user_3) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap3 = this.c;
            a(2, hashMap3 == null ? null : hashMap3.get(2));
        } else if (id == R.id.user_4) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap4 = this.c;
            a(3, hashMap4 == null ? null : hashMap4.get(3));
        } else if (id == R.id.user_5) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap5 = this.c;
            a(4, hashMap5 == null ? null : hashMap5.get(4));
        } else if (id == R.id.user_6) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap6 = this.c;
            a(5, hashMap6 == null ? null : hashMap6.get(5));
        } else if (id == R.id.user_7) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap7 = this.c;
            a(6, hashMap7 == null ? null : hashMap7.get(6));
        } else if (id == R.id.user_8) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap8 = this.c;
            a(7, hashMap8 == null ? null : hashMap8.get(7));
        } else if (id == R.id.user_9) {
            HashMap<Integer, YYMemberEntertainmentView> hashMap9 = this.c;
            a(8, hashMap9 == null ? null : hashMap9.get(8));
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.e(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        Logger.e("observer", "YYSeatKTVAdapter onDetachedFromRecyclerView ...");
        YYObserverManager.a().b(this);
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null) {
            return;
        }
        yYRoomModel.clearEmojiAndSendMessage();
    }

    public void setNewData(List<? extends YYSeatMemberModel> list) {
        ArrayList arrayList = new ArrayList();
        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
        yYSeatMemberModel.itemType = 10;
        arrayList.add(yYSeatMemberModel);
        super.setNewData(arrayList);
    }
}
