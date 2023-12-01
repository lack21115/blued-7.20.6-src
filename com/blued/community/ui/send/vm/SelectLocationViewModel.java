package com.blued.community.ui.send.vm;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.utils.gaode.GaoDeUtils;
import com.blued.android.module.common.utils.gaode.OnPOIListener;
import com.blued.android.module.common.utils.gaode.PositionPOIModel;
import com.blued.android.statistics.BluedStatistics;
import com.blued.community.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/SelectLocationViewModel.class */
public final class SelectLocationViewModel extends BaseViewModel {
    private int a;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int k;
    private MutableLiveData<String> b = new MutableLiveData<>();
    private MutableLiveData<String> c = new MutableLiveData<>();
    private String j = "";
    private final MutableLiveData<Boolean> l = new MutableLiveData<>();
    private List<PositionPOIModel> m = new ArrayList();
    private final MutableLiveData<List<PositionPOIModel>> n = new MutableLiveData<>();
    private final MutableLiveData<Boolean> o = new MutableLiveData<>();

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/SelectLocationViewModel$SEARCH_LVL.class */
    public interface SEARCH_LVL {
        public static final Companion a = Companion.a;

        @Metadata
        /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/SelectLocationViewModel$SEARCH_LVL$Companion.class */
        public static final class Companion {
            static final /* synthetic */ Companion a = new Companion();

            private Companion() {
            }
        }
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void a(LifecycleOwner lifecycleOwner, boolean z, String keyWords) {
        Intrinsics.e(lifecycleOwner, "lifecycleOwner");
        Intrinsics.e(keyWords, "keyWords");
        if (z) {
            this.i = 0;
        } else {
            this.i++;
        }
        this.j = keyWords;
        OnPOIListener onPOIListener = new OnPOIListener() { // from class: com.blued.community.ui.send.vm.SelectLocationViewModel$getPOIList$poiRequestListener$1
            @Override // com.blued.android.module.common.utils.gaode.OnPOIListener
            public void onComplete(int i, List<? extends PositionPOIModel> list, boolean z2) {
                int i2;
                List list2;
                List list3;
                int i3;
                List list4;
                List list5;
                List list6;
                if (i != 0) {
                    BluedStatistics.c().a("FEED_POI", 0L, i, null);
                }
                if (i == 0) {
                    i3 = SelectLocationViewModel.this.i;
                    if (i3 == 0 && SelectLocationViewModel.this.m() == 0) {
                        ArrayList arrayList = new ArrayList();
                        Intrinsics.a(list);
                        int size = list.size();
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= size) {
                                break;
                            }
                            PositionPOIModel positionPOIModel = list.get(i5);
                            if (positionPOIModel != null) {
                                arrayList.add(positionPOIModel);
                            }
                            i4 = i5 + 1;
                        }
                        SelectLocationViewModel.this.m = arrayList;
                        MutableLiveData<List<PositionPOIModel>> o = SelectLocationViewModel.this.o();
                        list6 = SelectLocationViewModel.this.m;
                        o.setValue(list6);
                    } else if (list != null && (!list.isEmpty())) {
                        ArrayList arrayList2 = new ArrayList();
                        int size2 = list.size();
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            if (i7 >= size2) {
                                break;
                            }
                            PositionPOIModel positionPOIModel2 = list.get(i7);
                            if (positionPOIModel2 != null) {
                                arrayList2.add(positionPOIModel2);
                            }
                            i6 = i7 + 1;
                        }
                        list4 = SelectLocationViewModel.this.m;
                        list4.addAll(arrayList2);
                        MutableLiveData<List<PositionPOIModel>> o2 = SelectLocationViewModel.this.o();
                        list5 = SelectLocationViewModel.this.m;
                        o2.setValue(list5);
                    }
                    if (z2) {
                        SelectLocationViewModel.this.n().setValue(false);
                        SelectLocationViewModel.this.p().setValue(true);
                    } else {
                        SelectLocationViewModel.this.n().setValue(Boolean.valueOf(SelectLocationViewModel.this.m() < 2));
                        SelectLocationViewModel.this.p().setValue(false);
                    }
                } else {
                    i2 = SelectLocationViewModel.this.i;
                    if (i2 == 0 && SelectLocationViewModel.this.m() == 0) {
                        list2 = SelectLocationViewModel.this.m;
                        list2.clear();
                        MutableLiveData<List<PositionPOIModel>> o3 = SelectLocationViewModel.this.o();
                        list3 = SelectLocationViewModel.this.m;
                        o3.setValue(list3);
                        SelectLocationViewModel.this.n().setValue(true);
                    }
                }
                SelectLocationViewModel.this.p().setValue(true);
            }
        };
        if (TextUtils.isEmpty(keyWords)) {
            GaoDeUtils.a(lifecycleOwner, this.i, onPOIListener);
            return;
        }
        int i = this.k;
        if (i == 0) {
            GaoDeUtils.b(lifecycleOwner, this.i, keyWords, onPOIListener);
        } else if (i == 1) {
            GaoDeUtils.c(lifecycleOwner, this.i, keyWords, onPOIListener);
        } else if (i != 2) {
            GaoDeUtils.b(lifecycleOwner, this.i, keyWords, onPOIListener);
        } else {
            GaoDeUtils.d(lifecycleOwner, this.i, keyWords, onPOIListener);
        }
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void b(int i) {
        this.g = i;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void c(int i) {
        this.h = i;
    }

    public final void c(String str) {
        this.f = str;
    }

    public final int d() {
        int i = this.a;
        return i > 0 ? i : AppInfo.m - StatusBarHelper.a(AppInfo.d());
    }

    public final MutableLiveData<String> e() {
        return this.b;
    }

    public final MutableLiveData<String> f() {
        return this.c;
    }

    public final String g() {
        return this.d;
    }

    public final String h() {
        return this.e;
    }

    public final String i() {
        return this.f;
    }

    public final int j() {
        return this.g;
    }

    public final int k() {
        return this.h;
    }

    public final String l() {
        return this.j;
    }

    public final int m() {
        return this.k;
    }

    public final MutableLiveData<Boolean> n() {
        return this.l;
    }

    public final MutableLiveData<List<PositionPOIModel>> o() {
        return this.n;
    }

    public final MutableLiveData<Boolean> p() {
        return this.o;
    }

    public final void q() {
        this.k = 0;
    }

    public final boolean r() {
        int i = this.k;
        if (i + 1 >= 2) {
            this.k = 2;
            return true;
        }
        this.k = i + 1;
        return false;
    }

    public final int s() {
        return this.k == 1 ? R.string.expand_search_area_in_contry : R.string.expand_search_area;
    }
}
