package com.soft.blued.ui.live.presenter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRecommendModel;
import com.blued.community.model.LiveRecommendExtra;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveFollowPresenter.class */
public class LiveFollowPresenter extends MvpPresenter {
    private String j;
    private List<LiveRecommendModel> k;
    private boolean m;
    private boolean n;
    private final String i = "LiveFollowPresenter";
    public int h = 1;
    private int l = 1;
    private boolean o = false;

    /* renamed from: com.soft.blued.ui.live.presenter.LiveFollowPresenter$6  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveFollowPresenter$6.class */
    class AnonymousClass6 implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluedLiveListData f17569a;
        final /* synthetic */ LiveFollowPresenter b;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            if (!BluedPreferences.aL()) {
                this.b.a(this.f17569a);
                return;
            }
            final AlertDialog create = new AlertDialog.Builder(this.b.h()).create();
            Window window = create.getWindow();
            create.show();
            window.setContentView((LinearLayout) LayoutInflater.from(this.b.h()).inflate(R.layout.dialog_cancel_action, (ViewGroup) null));
            window.clearFlags(131072);
            create.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.soft.blued.ui.live.presenter.LiveFollowPresenter.6.1
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface2, int i2, KeyEvent keyEvent) {
                    return i2 == 4;
                }
            });
            ((TextView) window.findViewById(R.id.dialog_action_right)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.presenter.LiveFollowPresenter.6.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Dialog dialog = create;
                    if (dialog != null) {
                        dialog.cancel();
                    }
                    BluedPreferences.aM();
                    AnonymousClass6.this.b.a(AnonymousClass6.this.f17569a);
                }
            });
        }
    }

    private void a(BluedUIHttpResponse<BluedEntity<LiveRecommendModel, LiveRecommendExtra>> bluedUIHttpResponse) {
        LiveHttpUtils.a(bluedUIHttpResponse, g(), this.h, this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BluedLiveListData bluedLiveListData) {
        UserHttpUtils.a(h(), new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.live.presenter.LiveFollowPresenter.2
            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a() {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b() {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
                LiveFollowPresenter.this.a("recommend_list_user_no_more", bluedLiveListData, false);
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
            }
        }, bluedLiveListData.uid, "", (IRequestHost) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<BluedLiveListData> list) {
        List<LiveRecommendModel> list2;
        int i;
        if (list == null || (list2 = this.k) == null || list2.isEmpty()) {
            return;
        }
        this.o = true;
        Iterator<BluedLiveListData> it = list.iterator();
        int i2 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            } else if (CommonStringUtils.c(it.next().lid) == 0) {
                Logger.e("LiveFollowPresenter", "推荐数为：", Integer.valueOf(this.k.size()));
                Logger.e("LiveFollowPresenter", "position = " + i);
                break;
            } else {
                i2 = i + 1;
            }
        }
        list.add(i, n());
    }

    static /* synthetic */ int c(LiveFollowPresenter liveFollowPresenter) {
        int i = liveFollowPresenter.l;
        liveFollowPresenter.l = i + 1;
        return i;
    }

    private void d(final IFetchDataListener iFetchDataListener) {
        a(new BluedUIHttpResponse<BluedEntity<LiveRecommendModel, LiveRecommendExtra>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveFollowPresenter.5
            public void onUIUpdate(BluedEntity<LiveRecommendModel, LiveRecommendExtra> bluedEntity) {
                LiveRecommendExtra liveRecommendExtra = bluedEntity.extra;
                if (liveRecommendExtra == null) {
                    LiveFollowPresenter.this.c(iFetchDataListener);
                    return;
                }
                if (liveRecommendExtra.is_new == 1) {
                    if (bluedEntity.data == null) {
                        bluedEntity.data = new ArrayList();
                    }
                    LiveFollowPresenter.this.a("recommend_list_user", bluedEntity.data);
                    LiveFollowPresenter.this.f_("recommend_list_user_has_more");
                } else {
                    LiveFollowPresenter.this.k = bluedEntity.data;
                    LiveFollowPresenter.this.c(iFetchDataListener);
                }
                LiveFollowPresenter.this.j = liveRecommendExtra.last_id;
                if (bluedEntity.hasMore()) {
                    LiveFollowPresenter.this.h++;
                }
            }
        });
    }

    private BluedLiveListData n() {
        BluedLiveListData bluedLiveListData = new BluedLiveListData();
        bluedLiveListData.liveType = 1;
        bluedLiveListData.livetype = 0;
        bluedLiveListData.liveRecommendModelList = this.k;
        bluedLiveListData.recommend_type = 1;
        bluedLiveListData.lid = "0";
        bluedLiveListData.anchor = new UserBasicModel();
        return bluedLiveListData;
    }

    public void a(LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_DELETE_ALL_RECOMMEND_USER, String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.soft.blued.ui.live.presenter.LiveFollowPresenter.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                LiveFollowPresenter.this.m();
            }
        });
    }

    public void a(IFetchDataListener iFetchDataListener) {
        this.h = 1;
        this.l = 1;
        this.o = false;
        List<LiveRecommendModel> list = this.k;
        if (list != null) {
            list.clear();
            this.k = null;
        }
        d(iFetchDataListener);
    }

    public void b(IFetchDataListener iFetchDataListener) {
        c(iFetchDataListener);
    }

    public void c(final IFetchDataListener iFetchDataListener) {
        LiveHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveFollowPresenter.3
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveListData> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    LiveFollowPresenter.this.m = false;
                    return;
                }
                LiveFollowPresenter.this.m = bluedEntityA.hasMore();
                if (!LiveFollowPresenter.this.o) {
                    LiveFollowPresenter.this.a(bluedEntityA.data);
                }
                iFetchDataListener.a("follow_list_user", bluedEntityA.data);
                iFetchDataListener.b(LiveFollowPresenter.this.m);
                if (LiveFollowPresenter.this.m) {
                    LiveFollowPresenter.c(LiveFollowPresenter.this);
                }
            }

            public boolean onUIFailure(int i, String str) {
                LiveFollowPresenter.this.m = false;
                return super.onUIFailure(i, str);
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                Logger.e("LiveFollowPresenter", "onFinish");
                iFetchDataListener.a(z);
            }
        }, String.valueOf(this.l), g());
    }

    public void m() {
        a(new BluedUIHttpResponse<BluedEntity<LiveRecommendModel, LiveRecommendExtra>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveFollowPresenter.4
            public boolean onUIFailure(int i, String str) {
                LiveFollowPresenter.this.n = false;
                return super.onUIFailure(i, str);
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (LiveFollowPresenter.this.n) {
                    LiveFollowPresenter.this.f_("recommend_list_user_has_more");
                } else {
                    LiveFollowPresenter.this.f_("recommend_list_user_no_more");
                }
            }

            public void onUIUpdate(BluedEntity<LiveRecommendModel, LiveRecommendExtra> bluedEntity) {
                if (bluedEntity == null) {
                    LiveFollowPresenter.this.n = false;
                    return;
                }
                if (bluedEntity.extra != null) {
                    LiveFollowPresenter.this.j = bluedEntity.extra.last_id;
                }
                if (bluedEntity.data != null) {
                    LiveFollowPresenter.this.a("more_recommend_list_new_user", bluedEntity.data, false);
                }
                LiveFollowPresenter.this.n = bluedEntity.hasMore();
                if (LiveFollowPresenter.this.n) {
                    LiveFollowPresenter.this.h++;
                }
            }
        });
    }
}
