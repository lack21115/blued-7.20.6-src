package com.tencent.thumbplayer.adapter;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Object f25497a;
    private b g;
    private boolean h;
    private float i;
    private String j;
    private float k;
    private TPProgramInfo o;
    private int m = -1;
    private Map<String, d> b = new HashMap(0);

    /* renamed from: c  reason: collision with root package name */
    private Map<String, a> f25498c = new HashMap(0);
    private h f = new h();
    private Map<Integer, TPOptionalParam> e = new HashMap(0);
    private Map<Integer, TPTrackInfo> l = new HashMap(0);
    private ArrayList<TPTrackInfo> n = new ArrayList<>();
    private ArrayList<C0844c> d = new ArrayList<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f25499a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public List<TPOptionalParam> f25500c;
        public Map<String, String> d;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/c$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f25501a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public long f25502c;
    }

    /* renamed from: com.tencent.thumbplayer.adapter.c$c  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/c$c.class */
    public static class C0844c {

        /* renamed from: a  reason: collision with root package name */
        public int f25503a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public TPTrackInfo f25504c;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/c$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f25505a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f25506c;
        public Map<String, String> d;
    }

    private void a(String str, String str2) {
        this.m++;
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.trackType = 2;
        tPTrackInfo.name = str2;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        this.n.add(tPTrackInfo);
    }

    private void a(String str, String str2, String str3) {
        this.m++;
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.trackType = 3;
        tPTrackInfo.name = str3;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        this.n.add(tPTrackInfo);
    }

    public TPTrackInfo a(int i) {
        return this.l.get(Integer.valueOf(i));
    }

    public void a() {
        this.b.clear();
        this.f25498c.clear();
        this.h = false;
        this.i = 1.0f;
        this.j = "";
        this.k = 1.0f;
        this.l.clear();
        this.f25497a = null;
        this.e.clear();
        this.f = new h();
        this.g = null;
        this.o = null;
        this.m = -1;
        this.n.clear();
        this.d.clear();
    }

    public void a(float f) {
        this.i = f;
    }

    public void a(int i, long j, TPTrackInfo tPTrackInfo) {
        this.l.put(Integer.valueOf(tPTrackInfo.getTrackType()), tPTrackInfo);
        if (i < 0 || i >= this.n.size()) {
            TPLogUtil.w("TPPlaybackParams", "track Index:" + i + " is invalid, trackInfoList size:" + this.n.size());
            return;
        }
        C0844c c0844c = new C0844c();
        c0844c.f25503a = i;
        c0844c.b = j;
        Iterator<TPTrackInfo> it = this.n.iterator();
        while (it.hasNext()) {
            TPTrackInfo next = it.next();
            if (next.trackType == tPTrackInfo.trackType) {
                if ((TextUtils.isEmpty(next.name) && TextUtils.isEmpty(tPTrackInfo.name)) || next.name.equals(tPTrackInfo.name)) {
                    next.isSelected = true;
                    c0844c.f25504c = next;
                } else {
                    next.isSelected = false;
                }
            }
        }
        this.d.add(c0844c);
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        this.f.a(assetFileDescriptor);
    }

    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        this.f.a(parcelFileDescriptor);
    }

    public void a(Surface surface) {
        this.f25497a = surface;
    }

    public void a(SurfaceHolder surfaceHolder) {
        this.f25497a = surfaceHolder;
    }

    public void a(com.tencent.thumbplayer.adapter.a.e eVar, Map<String, String> map) {
        this.f.a(eVar);
        this.f.a(map);
    }

    public void a(TPOptionalParam tPOptionalParam) {
        if (tPOptionalParam != null) {
            this.e.put(Integer.valueOf(tPOptionalParam.getKey()), tPOptionalParam);
        }
    }

    public void a(TPProgramInfo tPProgramInfo) {
        this.o = tPProgramInfo;
    }

    public void a(ITPMediaAsset iTPMediaAsset) {
        this.f.a(iTPMediaAsset);
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(String str, Map<String, String> map) {
        this.f.a(str);
        this.f.a(map);
    }

    public void a(String str, Map<String, String> map, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        d dVar = new d();
        dVar.f25505a = str;
        dVar.d = map;
        dVar.b = str2;
        dVar.f25506c = str3;
        this.b.put(str, dVar);
        a(str, str2, str3);
    }

    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a aVar = new a();
        aVar.f25499a = str;
        aVar.d = map;
        aVar.b = str2;
        aVar.f25500c = list;
        this.f25498c.put(str, aVar);
        a(str, str2);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(boolean z, long j, long j2) {
        if (this.g == null) {
            this.g = new b();
        }
        this.g.f25501a = z;
        this.g.b = j;
        this.g.f25502c = j2;
    }

    public TPOptionalParam b(int i) {
        return this.e.get(Integer.valueOf(i));
    }

    public ArrayList<TPTrackInfo> b() {
        return this.n;
    }

    public void b(float f) {
        this.k = f;
    }

    public void b(int i, long j, TPTrackInfo tPTrackInfo) {
        this.l.remove(Integer.valueOf(tPTrackInfo.getTrackType()));
        if (i < 0 || i >= this.n.size()) {
            TPLogUtil.w("TPPlaybackParams", "track Index:" + i + " is invalid, trackInfoList size:" + this.n.size());
            return;
        }
        Iterator<TPTrackInfo> it = this.n.iterator();
        while (it.hasNext()) {
            TPTrackInfo next = it.next();
            if (next.trackType == tPTrackInfo.trackType && ((TextUtils.isEmpty(next.name) && TextUtils.isEmpty(tPTrackInfo.name)) || next.name.equals(tPTrackInfo.name))) {
                next.isSelected = false;
                break;
            }
        }
        Iterator<C0844c> it2 = this.d.iterator();
        while (it2.hasNext()) {
            C0844c next2 = it2.next();
            if (next2.f25504c != null && next2.f25504c.equals(tPTrackInfo)) {
                this.d.remove(next2);
                return;
            }
        }
    }

    public void b(String str) {
        this.f.a(str);
    }

    public void b(boolean z) {
        if (this.g == null) {
            this.g = new b();
        }
        this.g.f25501a = z;
        this.g.b = 0L;
        this.g.f25502c = -1L;
    }

    public ArrayList<C0844c> c() {
        return this.d;
    }

    public Object d() {
        return this.f25497a;
    }

    public h e() {
        return this.f;
    }

    public boolean f() {
        h hVar = this.f;
        return hVar != null && hVar.h();
    }

    public boolean g() {
        return this.h;
    }

    public float h() {
        return this.i;
    }

    public String i() {
        return this.j;
    }

    public float j() {
        return this.k;
    }

    public b k() {
        return this.g;
    }

    public TPProgramInfo l() {
        return this.o;
    }

    public List<d> m() {
        ArrayList arrayList = new ArrayList(this.b.size());
        for (Map.Entry<String, d> entry : this.b.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    public List<a> n() {
        ArrayList arrayList = new ArrayList(this.f25498c.size());
        for (Map.Entry<String, a> entry : this.f25498c.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    public List<TPOptionalParam> o() {
        ArrayList arrayList = new ArrayList(this.e.size());
        for (Map.Entry<Integer, TPOptionalParam> entry : this.e.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    public boolean p() {
        return e() != null && e().g() == 2;
    }
}
