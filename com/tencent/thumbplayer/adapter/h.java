package com.tencent.thumbplayer.adapter;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private String f25517a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private ParcelFileDescriptor f25518c;
    private AssetFileDescriptor d;
    private Map<String, String> e = new HashMap();
    private ITPMediaAsset f;
    private com.tencent.thumbplayer.adapter.a.e g;

    public String a() {
        return this.f25517a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AssetFileDescriptor assetFileDescriptor) {
        this.f25517a = null;
        this.b = 4;
        this.e.clear();
        this.f25518c = null;
        this.d = assetFileDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        this.f25517a = null;
        this.b = 1;
        this.e.clear();
        this.f25518c = parcelFileDescriptor;
        this.d = null;
    }

    public void a(com.tencent.thumbplayer.adapter.a.e eVar) {
        this.f25517a = null;
        this.b = 3;
        this.f25518c = null;
        this.d = null;
        this.g = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ITPMediaAsset iTPMediaAsset) {
        this.f25517a = null;
        this.b = 2;
        this.e.clear();
        this.f25518c = null;
        this.d = null;
        this.f = iTPMediaAsset;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f25517a = str;
        this.b = 0;
        this.f25518c = null;
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Map<String, String> map) {
        this.e.clear();
        Map<String, String> map2 = this.e;
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap(0);
        }
        map2.putAll(hashMap);
    }

    public Map<String, String> b() {
        return this.e;
    }

    public ParcelFileDescriptor c() {
        return this.f25518c;
    }

    public AssetFileDescriptor d() {
        return this.d;
    }

    public ITPMediaAsset e() {
        return this.f;
    }

    public com.tencent.thumbplayer.adapter.a.e f() {
        return this.g;
    }

    public int g() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        return (TextUtils.isEmpty(this.f25517a) && this.f25518c == null && this.d == null && this.f == null && this.g == null) ? false : true;
    }
}
