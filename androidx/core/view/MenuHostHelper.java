package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/MenuHostHelper.class */
public class MenuHostHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f2643a;
    private final CopyOnWriteArrayList<MenuProvider> b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<MenuProvider, LifecycleContainer> f2644c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/MenuHostHelper$LifecycleContainer.class */
    public static class LifecycleContainer {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f2645a;
        private LifecycleEventObserver b;

        LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.f2645a = lifecycle;
            this.b = lifecycleEventObserver;
            lifecycle.addObserver(lifecycleEventObserver);
        }

        void a() {
            this.f2645a.removeObserver(this.b);
            this.b = null;
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.f2643a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            addMenuProvider(menuProvider);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.b.remove(menuProvider);
            this.f2643a.run();
        }
    }

    public void addMenuProvider(MenuProvider menuProvider) {
        this.b.add(menuProvider);
        this.f2643a.run();
    }

    public void addMenuProvider(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        addMenuProvider(menuProvider);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.f2644c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f2644c.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.-$$Lambda$MenuHostHelper$Q-OE79gGLiIXVCrKe2yY7FTX9zc
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper.this.a(menuProvider, lifecycleOwner2, event);
            }
        }));
    }

    public void addMenuProvider(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.f2644c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f2644c.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.-$$Lambda$MenuHostHelper$U1SPABELr4QFuUXGVHQwbvgMOTA
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper.this.a(state, menuProvider, lifecycleOwner2, event);
            }
        }));
    }

    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Iterator<MenuProvider> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().onCreateMenu(menu, menuInflater);
        }
    }

    public boolean onMenuItemSelected(MenuItem menuItem) {
        Iterator<MenuProvider> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().onMenuItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void removeMenuProvider(MenuProvider menuProvider) {
        this.b.remove(menuProvider);
        LifecycleContainer remove = this.f2644c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f2643a.run();
    }
}
