package com.soft.blued.ui.live.presenter;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveHotListDiversion;
import com.blued.android.module.live_china.model.LiveListCommonModel;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.model.LiveListRankFlagExtra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveListHotPresenter.class */
public class LiveListHotPresenter extends MvpPresenter {
    private LiveListCommonModel h;
    private List<BluedLiveListData> i;
    private List<BluedLiveListData> j;
    private List<LiveHotListDiversion> k;
    private List<BluedLiveListData> l;
    private List<BluedLiveListData> m;
    private List<BluedLiveListData> n;
    private int o;
    private boolean p = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> bluedEntity, IFetchDataListener iFetchDataListener) {
        ArrayList arrayList = new ArrayList();
        try {
            if (bluedEntity == null) {
                if (this.h.getPage() != 1) {
                    this.h.setPage(this.h.getPage() - 1);
                    return;
                } else if (iFetchDataListener != null) {
                    iFetchDataListener.a("HOT_LIST", (List) null);
                    return;
                } else {
                    return;
                }
            }
            if (bluedEntity.data == null) {
                bluedEntity.data = new ArrayList();
            }
            if (this.h.getPage() == 1) {
                this.l.clear();
                if (bluedEntity.extra != null && ((LiveListRankFlagExtra) bluedEntity.extra).fresh_beans_list != null) {
                    this.l.addAll(((LiveListRankFlagExtra) bluedEntity.extra).fresh_beans_list);
                }
                this.m.clear();
                if (bluedEntity.extra != null && ((LiveListRankFlagExtra) bluedEntity.extra).official_list != null) {
                    this.m.addAll(((LiveListRankFlagExtra) bluedEntity.extra).official_list);
                }
                this.n.clear();
                if (bluedEntity.extra != null && ((LiveListRankFlagExtra) bluedEntity.extra).hotpk_list != null) {
                    this.n.addAll(((LiveListRankFlagExtra) bluedEntity.extra).hotpk_list);
                }
                this.k.clear();
                if (bluedEntity.extra != null && ((LiveListRankFlagExtra) bluedEntity.extra).hot_list_diversion != null) {
                    this.k.addAll(((LiveListRankFlagExtra) bluedEntity.extra).hot_list_diversion);
                }
                if (bluedEntity.extra != null) {
                    this.o = ((LiveListRankFlagExtra) bluedEntity.extra).pkhasmore;
                }
                if (this.k.size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.k.size()) {
                            break;
                        }
                        LiveHotListDiversion liveHotListDiversion = this.k.get(i2);
                        BluedLiveListData bluedLiveListData = new BluedLiveListData();
                        bluedLiveListData.hot_diversion = liveHotListDiversion;
                        bluedLiveListData.lid = String.valueOf(liveHotListDiversion.id);
                        if (bluedEntity.data.size() > liveHotListDiversion.index) {
                            bluedEntity.data.add(liveHotListDiversion.index, bluedLiveListData);
                        }
                        i = i2 + 1;
                    }
                }
                if (this.n.size() > 0) {
                    BluedLiveListData bluedLiveListData2 = new BluedLiveListData();
                    bluedLiveListData2.lid = bluedLiveListData2.hashCode() + "";
                    bluedLiveListData2.liveType = 7;
                    bluedLiveListData2.hotpk_list = this.n;
                    bluedEntity.data.add(0, bluedLiveListData2);
                    LogData logData = new LogData();
                    logData.logService = "live_list_pk_show";
                    logData.num = String.valueOf(this.n.size());
                    InstantLog.a(logData);
                }
                if (this.l.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= this.l.size()) {
                            break;
                        }
                        this.l.get(i4).liveType = 2;
                        i3 = i4 + 1;
                    }
                    arrayList.addAll(this.l);
                }
                if (this.m.size() > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= this.m.size()) {
                            break;
                        }
                        this.m.get(i6).liveType = 1;
                        i5 = i6 + 1;
                    }
                    arrayList.addAll(this.m);
                }
                a(bluedEntity.data);
                arrayList.addAll(bluedEntity.data);
                Log.i("xpm", "a====");
                if (iFetchDataListener != null) {
                    iFetchDataListener.a("HOT_LIST", arrayList);
                }
                if (n() == 1) {
                    this.i.clear();
                }
                this.i.addAll(bluedEntity.data);
            } else {
                a(bluedEntity.data);
                arrayList.addAll(bluedEntity.data);
                Log.i("xpm", "b====");
                if (iFetchDataListener != null) {
                    iFetchDataListener.a("HOT_LIST", arrayList);
                }
                if (n() == 1) {
                    this.i.clear();
                }
                this.i.addAll(bluedEntity.data);
            }
            if (bluedEntity.data == null && bluedEntity.data.size() <= 0) {
                if (this.h.getPage() > 1) {
                    this.h.setPage(this.h.getPage() - 1);
                }
                if (iFetchDataListener != null) {
                    iFetchDataListener.b(false);
                    return;
                }
                return;
            }
            boolean hasMore = bluedEntity.hasMore();
            this.h.setHasData(hasMore);
            if (iFetchDataListener != null) {
                iFetchDataListener.b(hasMore);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.h.getPage() != 1) {
                LiveListCommonModel liveListCommonModel = this.h;
                liveListCommonModel.setPage(liveListCommonModel.getPage() - 1);
            }
            AppMethods.a(h().getString(2131887272));
        }
    }

    private void a(List<BluedLiveListData> list) {
        if (this.l.size() == 0 || list == null || list.size() == 0) {
            return;
        }
        for (BluedLiveListData bluedLiveListData : this.l) {
            if (list.size() > 0) {
                Iterator<BluedLiveListData> it = list.iterator();
                while (it.hasNext()) {
                    BluedLiveListData next = it.next();
                    if (bluedLiveListData.lid.equals(next.lid) && next.is_emperor_recommend != 1) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void a(boolean z, IFetchDataListener iFetchDataListener) {
        if (z) {
            m();
            this.h.setPage(1);
            this.h.setHasData(true);
        } else {
            LiveListCommonModel liveListCommonModel = this.h;
            liveListCommonModel.setPage(liveListCommonModel.getPage() + 1);
            if (!this.h.getHasData() && this.h.getPage() != 1) {
                LiveListCommonModel liveListCommonModel2 = this.h;
                liveListCommonModel2.setPage(liveListCommonModel2.getPage() - 1);
                AppMethods.a(h().getResources().getString(2131887275));
                b("", false);
                return;
            }
        }
        Log.i("xpm", "requestLiveListData page:" + n());
        c(iFetchDataListener);
    }

    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.h = new LiveListCommonModel();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.m = new ArrayList();
        this.l = new ArrayList();
        this.n = new ArrayList();
    }

    public void a(IFetchDataListener iFetchDataListener) {
        a(true, iFetchDataListener);
    }

    public void b(IFetchDataListener iFetchDataListener) {
        a(false, iFetchDataListener);
    }

    public void c(final IFetchDataListener iFetchDataListener) {
        BluedUIHttpResponse<BluedEntity<BluedLiveListData, LiveListRankFlagExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<BluedLiveListData, LiveListRankFlagExtra>>("hot_live_list", null) { // from class: com.soft.blued.ui.live.presenter.LiveListHotPresenter.1
            public void onUICache(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> bluedEntity) {
                super.onUICache(bluedEntity);
                LiveListHotPresenter.this.a(bluedEntity, iFetchDataListener);
            }

            public boolean onUIFailure(int i, String str) {
                LiveListHotPresenter.this.a((BluedEntity<BluedLiveListData, LiveListRankFlagExtra>) null, iFetchDataListener);
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(true);
                }
            }

            public void onUIUpdate(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> bluedEntity) {
                LiveListHotPresenter.this.a(bluedEntity, iFetchDataListener);
            }
        };
        if (!this.p && this.h.getPage() == 1) {
            Log.i("xpm", "refresh cache");
            this.p = true;
            bluedUIHttpResponse.refresh();
        }
        LiveHttpUtils.a(bluedUIHttpResponse, this.h.getPage() + "", (IRequestHost) null);
    }

    public boolean c() {
        return false;
    }

    public void m() {
        List<BluedLiveListData> list = this.l;
        if (list != null) {
            list.clear();
        }
        List<BluedLiveListData> list2 = this.m;
        if (list2 != null) {
            list2.clear();
        }
        List<BluedLiveListData> list3 = this.i;
        if (list3 != null) {
            list3.clear();
        }
        List<BluedLiveListData> list4 = this.j;
        if (list4 != null) {
            list4.clear();
        }
    }

    public int n() {
        return this.h.getPage();
    }

    public boolean o() {
        return this.o == 1;
    }
}
