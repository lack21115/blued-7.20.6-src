package com.blued.community.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.model.MyCircleExtra;
import com.blued.community.ui.circle.model.MyCircleModel;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleListPresenter.class */
public class CircleListPresenter extends MvpPresenter {
    private int h = 1;
    private CircleConstants.CIRCLE_FROM_PAGE i = CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.circle.presenter.CircleListPresenter$2  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleListPresenter$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19355a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[CircleConstants.CIRCLE_FROM_PAGE.values().length];
            f19355a = iArr;
            try {
                iArr[CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19355a[CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19355a[CircleConstants.CIRCLE_FROM_PAGE.HOT_CIRCLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19355a[CircleConstants.CIRCLE_FROM_PAGE.MANAGED_CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static /* synthetic */ int a(CircleListPresenter circleListPresenter) {
        int i = circleListPresenter.h;
        circleListPresenter.h = i - 1;
        return i;
    }

    private void c(IFetchDataListener iFetchDataListener) {
        int i = AnonymousClass2.f19355a[this.i.ordinal()];
        if (i == 1) {
            CircleHttpUtils.a(d(iFetchDataListener), this.h);
        } else if (i == 2 || i == 3) {
            CircleHttpUtils.c(d(iFetchDataListener), this.h);
        } else if (i != 4) {
        } else {
            CircleHttpUtils.b(d(iFetchDataListener), this.h);
        }
    }

    private BluedUIHttpResponse d(final IFetchDataListener iFetchDataListener) {
        return new BluedUIHttpResponse<BluedEntity<MyCircleModel, MyCircleExtra>>(g()) { // from class: com.blued.community.ui.circle.presenter.CircleListPresenter.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z) {
                    CircleListPresenter.a(CircleListPresenter.this);
                }
                iFetchDataListener.a(z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                iFetchDataListener.a();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<MyCircleModel, MyCircleExtra> bluedEntity) {
                if (bluedEntity != null) {
                    iFetchDataListener.a("CIRCLE_DATA_LIST", bluedEntity.data);
                    iFetchDataListener.b(bluedEntity.hasMore());
                    if (bluedEntity.extra != null) {
                        CircleListPresenter.this.a("CIRCLE_ADMIN_COUNT", (String) bluedEntity.extra);
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<MyCircleModel, MyCircleExtra> parseData(String str) {
                return super.parseData(str);
            }
        };
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.i = (CircleConstants.CIRCLE_FROM_PAGE) bundle.getSerializable("circle_list_page");
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.h = 1;
        c(iFetchDataListener);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.h++;
        c(iFetchDataListener);
    }
}
