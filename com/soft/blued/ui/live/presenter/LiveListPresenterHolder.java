package com.soft.blued.ui.live.presenter;

import android.util.Log;
import com.blued.android.core.AppInfo;
import com.soft.blued.ui.live.contract.LiveListContract;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveListPresenterHolder.class */
public class LiveListPresenterHolder {

    /* renamed from: a  reason: collision with root package name */
    private static final String f17603a = LiveListPresenterHolder.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private Lock f17604c = new ReentrantLock();
    private HashMap<String, LiveListContract.IPresenter> b = new HashMap<>(10);

    public LiveListContract.IPresenter a(String str, int i) {
        this.f17604c.lock();
        HashMap<String, LiveListContract.IPresenter> hashMap = this.b;
        LiveListContract.IPresenter iPresenter = hashMap.get(str + i);
        Log.d(f17603a, "getPresenter");
        LiveListPresenter liveListPresenter = iPresenter;
        if (iPresenter == null) {
            Log.d(f17603a, "Create a new presenter");
            liveListPresenter = new LiveListPresenter(AppInfo.d(), str, i);
            HashMap<String, LiveListContract.IPresenter> hashMap2 = this.b;
            hashMap2.put(str + i, liveListPresenter);
        }
        this.f17604c.unlock();
        return liveListPresenter;
    }

    public void a() {
        this.f17604c.lock();
        Iterator<Map.Entry<String, LiveListContract.IPresenter>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            LiveListContract.IPresenter value = it.next().getValue();
            if (value != null) {
                value.c();
                value.e();
            }
            it.remove();
        }
        this.f17604c.unlock();
    }

    public void b(String str, int i) {
        this.f17604c.lock();
        HashMap<String, LiveListContract.IPresenter> hashMap = this.b;
        LiveListContract.IPresenter iPresenter = hashMap.get(str + i);
        Log.d(f17603a, "deletePresenter");
        if (iPresenter != null) {
            iPresenter.e();
        }
        this.f17604c.unlock();
    }
}
