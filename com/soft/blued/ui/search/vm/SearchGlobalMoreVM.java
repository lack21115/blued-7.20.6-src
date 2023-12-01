package com.soft.blued.ui.search.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.ui.search.utils.SearchGlobalUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalMoreVM.class */
public final class SearchGlobalMoreVM extends BaseListViewModel<SearchGlobalInfo> {

    /* renamed from: c  reason: collision with root package name */
    private int f19488c;

    /* renamed from: a  reason: collision with root package name */
    private int f19487a = 2;
    private String b = "";
    private HashSet<String> d = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 854
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.search.vm.SearchGlobalMoreVM.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.search.vm.SearchGlobalMoreVM.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        List<SearchSessionModel> a2 = SearchGlobalUtil.f19484a.a(this.b);
        ArrayList arrayList = new ArrayList();
        for (SearchSessionModel searchSessionModel : a2) {
            SearchGlobalInfo searchGlobalInfo = new SearchGlobalInfo();
            searchGlobalInfo.a(searchSessionModel);
            searchGlobalInfo.a(1);
            arrayList.add(searchGlobalInfo);
        }
        loadListSucceed(arrayList, false);
    }

    public final int a() {
        return this.f19487a;
    }

    public final void a(int i) {
        this.f19487a = i;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(int i) {
        this.f19488c = i;
    }

    public final int c() {
        return this.f19488c;
    }

    public void requestData() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.c().plus((CoroutineExceptionHandler) new SearchGlobalMoreVM$requestData$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.b)), (CoroutineStart) null, new SearchGlobalMoreVM$requestData$2(this, null), 2, (Object) null);
    }
}
