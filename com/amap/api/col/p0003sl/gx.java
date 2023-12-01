package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

/* renamed from: com.amap.api.col.3sl.gx  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gx.class */
public final class gx implements IInputtipsSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f5018a;
    private Inputtips.InputtipsListener b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f5019c;
    private InputtipsQuery d;

    public gx(Context context, Inputtips.InputtipsListener inputtipsListener) throws AMapException {
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
        }
        this.f5018a = context.getApplicationContext();
        this.b = inputtipsListener;
        this.f5019c = fp.a();
    }

    public gx(Context context, InputtipsQuery inputtipsQuery) {
        this.f5018a = context.getApplicationContext();
        this.d = inputtipsQuery;
        this.f5019c = fp.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Tip> a(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            fn.a(this.f5018a);
            if (inputtipsQuery != null) {
                if (inputtipsQuery.getKeyword() == null || inputtipsQuery.getKeyword().equals("")) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                return new fl(this.f5018a, inputtipsQuery).d();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (Throwable th) {
            fe.a(th, "Inputtips", "requestInputtips");
            if (th instanceof AMapException) {
                throw th;
            }
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final InputtipsQuery getQuery() {
        return this.d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final ArrayList<Tip> requestInputtips() throws AMapException {
        return a(this.d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str == null || str.equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
        this.d = inputtipsQuery;
        inputtipsQuery.setType(str3);
        requestInputtipsAsyn();
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gx.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.obj = gx.this.b;
                    obtainMessage.arg1 = 5;
                    try {
                        ArrayList<? extends Parcelable> a2 = gx.this.a(gx.this.d);
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("result", a2);
                        obtainMessage.setData(bundle);
                        obtainMessage.what = 1000;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } finally {
                        gx.this.f5019c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(InputtipsQuery inputtipsQuery) {
        this.d = inputtipsQuery;
    }
}
