package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.b;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/mvp/Presenter.class */
public class Presenter {
    private Object aus;
    private View mRootView;
    private final List<Presenter> aur = new CopyOnWriteArrayList();
    private PresenterState aut = PresenterState.INIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/mvp/Presenter$PresenterState.class */
    public enum PresenterState {
        INIT(0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
            }
        },
        CREATE(1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aur) {
                    try {
                        presenter2.E(presenter.mRootView);
                    } catch (Exception e) {
                        b.gatherException(e);
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                    }
                }
            }
        },
        BIND(2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aur) {
                    try {
                        presenter2.f(presenter.aus);
                    } catch (Throwable th) {
                        b.gatherException(th);
                        com.kwad.sdk.core.d.b.printStackTrace(th);
                    }
                }
            }
        },
        UNBIND(3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aur) {
                    try {
                        presenter2.jW();
                    } catch (Exception e) {
                        b.gatherException(e);
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                    }
                }
            }
        },
        DESTROY(4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aur) {
                    try {
                        presenter2.destroy();
                    } catch (Exception e) {
                        b.gatherException(e);
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                    }
                }
            }
        };
        
        private int mIndex;

        PresenterState(int i) {
            this.mIndex = i;
        }

        public int index() {
            return this.mIndex;
        }

        abstract void performCallState(Presenter presenter);
    }

    private boolean Bf() {
        return this.aut.index() >= PresenterState.CREATE.index();
    }

    private void b(Presenter presenter) {
        Object obj;
        View view;
        if (this.aut.index() >= PresenterState.UNBIND.index() || presenter.aut.index() >= PresenterState.UNBIND.index()) {
            return;
        }
        if (Bf() && !presenter.Bf() && (view = this.mRootView) != null) {
            presenter.E(view);
        }
        if (!isBound() || !presenter.Bf() || presenter.isBound() || (obj = this.aus) == null) {
            return;
        }
        presenter.f(obj);
    }

    private boolean isBound() {
        return this.aut == PresenterState.BIND;
    }

    public final List<Presenter> Bg() {
        return this.aur;
    }

    public final Object Bh() {
        return this.aus;
    }

    public final void E(View view) {
        this.aut = PresenterState.CREATE;
        this.mRootView = view;
        onCreate();
        this.aut.performCallState(this);
    }

    public final void a(Presenter presenter) {
        this.aur.add(presenter);
        if (!Bf() || presenter.Bf()) {
            return;
        }
        E(this.mRootView);
    }

    public final void a(Presenter presenter, boolean z) {
        this.aur.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th) {
            b.gatherException(th);
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    public void ar() {
    }

    public final void destroy() {
        if (this.aut == PresenterState.BIND) {
            jW();
        }
        this.aut = PresenterState.DESTROY;
        onDestroy();
        this.aut.performCallState(this);
    }

    public final void f(Object obj) {
        if (this.aut != PresenterState.INIT) {
            PresenterState presenterState = PresenterState.DESTROY;
        }
        if (this.aut == PresenterState.BIND) {
            jW();
        }
        this.aut = PresenterState.BIND;
        this.aus = obj;
        ar();
        this.aut.performCallState(this);
    }

    public final <T extends View> T findViewById(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public final Activity getActivity() {
        return k.dj(getContext());
    }

    public final Context getContext() {
        View view = this.mRootView;
        if (view == null) {
            return null;
        }
        return view.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    public final void jW() {
        this.aut = PresenterState.UNBIND;
        onUnbind();
        this.aut.performCallState(this);
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onUnbind() {
    }
}
