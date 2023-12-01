package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/RequestManagerRetriever.class */
public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory i = new RequestManagerFactory() { // from class: com.bumptech.glide.manager.RequestManagerRetriever.1
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        public RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private volatile RequestManager f7414c;
    private final Handler d;
    private final RequestManagerFactory e;

    /* renamed from: a  reason: collision with root package name */
    final Map<FragmentManager, RequestManagerFragment> f7413a = new HashMap();
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> b = new HashMap();
    private final ArrayMap<View, Fragment> f = new ArrayMap<>();
    private final ArrayMap<View, android.app.Fragment> g = new ArrayMap<>();
    private final Bundle h = new Bundle();

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/RequestManagerRetriever$RequestManagerFactory.class */
    public interface RequestManagerFactory {
        RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory) {
        this.e = requestManagerFactory == null ? i : requestManagerFactory;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    @Deprecated
    private RequestManager a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment a2 = a(fragmentManager, fragment, z);
        RequestManager b = a2.b();
        RequestManager requestManager = b;
        if (b == null) {
            requestManager = this.e.a(Glide.a(context), a2.a(), a2.c(), context);
            a2.a(requestManager);
        }
        return requestManager;
    }

    private RequestManager a(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        SupportRequestManagerFragment a2 = a(fragmentManager, fragment, z);
        RequestManager b = a2.b();
        RequestManager requestManager = b;
        if (b == null) {
            requestManager = this.e.a(Glide.a(context), a2.a(), a2.c(), context);
            a2.a(requestManager);
        }
        return requestManager;
    }

    private RequestManagerFragment a(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        RequestManagerFragment requestManagerFragment2 = requestManagerFragment;
        if (requestManagerFragment == null) {
            RequestManagerFragment requestManagerFragment3 = this.f7413a.get(fragmentManager);
            requestManagerFragment2 = requestManagerFragment3;
            if (requestManagerFragment3 == null) {
                requestManagerFragment2 = new RequestManagerFragment();
                requestManagerFragment2.a(fragment);
                if (z) {
                    requestManagerFragment2.a().a();
                }
                this.f7413a.put(fragmentManager, requestManagerFragment2);
                fragmentManager.beginTransaction().add(requestManagerFragment2, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.d.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        return requestManagerFragment2;
    }

    private SupportRequestManagerFragment a(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        SupportRequestManagerFragment supportRequestManagerFragment2 = supportRequestManagerFragment;
        if (supportRequestManagerFragment == null) {
            SupportRequestManagerFragment supportRequestManagerFragment3 = this.b.get(fragmentManager);
            supportRequestManagerFragment2 = supportRequestManagerFragment3;
            if (supportRequestManagerFragment3 == null) {
                supportRequestManagerFragment2 = new SupportRequestManagerFragment();
                supportRequestManagerFragment2.a(fragment);
                if (z) {
                    supportRequestManagerFragment2.a().a();
                }
                this.b.put(fragmentManager, supportRequestManagerFragment2);
                fragmentManager.beginTransaction().add(supportRequestManagerFragment2, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.d.obtainMessage(2, fragmentManager).sendToTarget();
            }
        }
        return supportRequestManagerFragment2;
    }

    private RequestManager b(Context context) {
        if (this.f7414c == null) {
            synchronized (this) {
                if (this.f7414c == null) {
                    this.f7414c = this.e.a(Glide.a(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.f7414c;
    }

    private static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static boolean d(Context context) {
        Activity c2 = c(context);
        return c2 == null || !c2.isFinishing();
    }

    public RequestManager a(Activity activity) {
        if (Util.d()) {
            return a(activity.getApplicationContext());
        }
        c(activity);
        return a(activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    public RequestManager a(Context context) {
        if (context != null) {
            if (Util.c() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return a((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return a(contextWrapper.getBaseContext());
                    }
                }
            }
            return b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public RequestManager a(Fragment fragment) {
        Preconditions.a(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.d()) {
            return a(fragment.getContext().getApplicationContext());
        }
        return a(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public RequestManager a(FragmentActivity fragmentActivity) {
        if (Util.d()) {
            return a(fragmentActivity.getApplicationContext());
        }
        c((Activity) fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, d(fragmentActivity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportRequestManagerFragment a(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return a(fragmentManager, (Fragment) null, d(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public RequestManagerFragment b(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        int i2 = message.what;
        SupportRequestManagerFragment supportRequestManagerFragment = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            supportRequestManagerFragment = this.f7413a.remove(obj);
        } else if (i2 != 2) {
            z = false;
            obj = null;
        } else {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            supportRequestManagerFragment = this.b.remove(obj);
        }
        if (z && supportRequestManagerFragment == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
