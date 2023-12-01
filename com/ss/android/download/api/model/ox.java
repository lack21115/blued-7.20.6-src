package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/model/ox.class */
public class ox {
    private final String b;
    private final long h;
    private final boolean hj;

    /* renamed from: io  reason: collision with root package name */
    private final JSONObject f21192io;
    private final int jb;
    private final Object je;
    private final long ko;
    private final String lc;
    private final JSONObject lz;
    private String mb;
    private final String nk;
    private final boolean o;
    private final String ox;
    private final String u;
    private final JSONObject ww;
    private final List<String> x;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/model/ox$mb.class */
    public static class mb {
        private String b;
        private JSONObject e;
        private long h;

        /* renamed from: io  reason: collision with root package name */
        private String f21193io;
        private List<String> jb;
        private int je;
        private long ko;
        private JSONObject lz;
        private String mb;
        private Object nk;
        private String o;
        private String ox;
        private String u;
        private JSONObject ww;
        private Map<String, Object> x;
        private boolean hj = false;
        private boolean lc = false;

        public mb b(String str) {
            this.u = str;
            return this;
        }

        public mb hj(String str) {
            this.o = str;
            return this;
        }

        public mb mb(int i) {
            this.je = i;
            return this;
        }

        public mb mb(long j) {
            this.h = j;
            return this;
        }

        public mb mb(Object obj) {
            this.nk = obj;
            return this;
        }

        public mb mb(String str) {
            this.ox = str;
            return this;
        }

        public mb mb(List<String> list) {
            this.jb = list;
            return this;
        }

        public mb mb(JSONObject jSONObject) {
            this.ww = jSONObject;
            return this;
        }

        public mb mb(boolean z) {
            this.lc = z;
            return this;
        }

        public ox mb() {
            if (TextUtils.isEmpty(this.mb)) {
                this.mb = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.ww == null) {
                this.ww = new JSONObject();
            }
            try {
                if (this.x != null && !this.x.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.x.entrySet()) {
                        if (!this.ww.has(entry.getKey())) {
                            this.ww.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.lc) {
                    this.f21193io = this.b;
                    JSONObject jSONObject2 = new JSONObject();
                    this.e = jSONObject2;
                    if (this.hj) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.ww.toString());
                    } else {
                        Iterator<String> keys = this.ww.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.e.put(next, this.ww.get(next));
                        }
                    }
                    this.e.put("category", this.mb);
                    this.e.put("tag", this.ox);
                    this.e.put("value", this.h);
                    this.e.put("ext_value", this.ko);
                    if (!TextUtils.isEmpty(this.o)) {
                        this.e.put("refer", this.o);
                    }
                    if (this.lz != null) {
                        this.e = com.ss.android.download.api.b.ox.mb(this.lz, this.e);
                    }
                    if (this.hj) {
                        if (!this.e.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.u)) {
                            this.e.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.u);
                        }
                        this.e.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.hj) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.ww.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.u)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.u);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.ww);
                }
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.putOpt("refer", this.o);
                }
                JSONObject jSONObject3 = jSONObject;
                if (this.lz != null) {
                    jSONObject3 = com.ss.android.download.api.b.ox.mb(this.lz, jSONObject);
                }
                this.ww = jSONObject3;
            } catch (Exception e) {
                x.m().mb(e, "DownloadEventModel build");
            }
            return new ox(this);
        }

        public mb ox(long j) {
            this.ko = j;
            return this;
        }

        public mb ox(String str) {
            this.b = str;
            return this;
        }

        public mb ox(JSONObject jSONObject) {
            this.lz = jSONObject;
            return this;
        }

        public mb ox(boolean z) {
            this.hj = z;
            return this;
        }
    }

    ox(mb mbVar) {
        this.mb = mbVar.mb;
        this.ox = mbVar.ox;
        this.b = mbVar.b;
        this.hj = mbVar.hj;
        this.h = mbVar.h;
        this.u = mbVar.u;
        this.ko = mbVar.ko;
        this.ww = mbVar.ww;
        this.lz = mbVar.lz;
        this.x = mbVar.jb;
        this.jb = mbVar.je;
        this.je = mbVar.nk;
        this.o = mbVar.lc;
        this.lc = mbVar.f21193io;
        this.f21192io = mbVar.e;
        this.nk = mbVar.o;
    }

    public String b() {
        return this.b;
    }

    public long h() {
        return this.h;
    }

    public boolean hj() {
        return this.hj;
    }

    public int jb() {
        return this.jb;
    }

    public Object je() {
        return this.je;
    }

    public long ko() {
        return this.ko;
    }

    public JSONObject lc() {
        return this.f21192io;
    }

    public JSONObject lz() {
        return this.lz;
    }

    public String mb() {
        return this.mb;
    }

    public boolean nk() {
        return this.o;
    }

    public String o() {
        return this.lc;
    }

    public String ox() {
        return this.ox;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.mb);
        sb.append("\ttag: ");
        sb.append(this.ox);
        sb.append("\tlabel: ");
        sb.append(this.b);
        sb.append("\nisAd: ");
        sb.append(this.hj);
        sb.append("\tadId: ");
        sb.append(this.h);
        sb.append("\tlogExtra: ");
        sb.append(this.u);
        sb.append("\textValue: ");
        sb.append(this.ko);
        sb.append("\nextJson: ");
        sb.append(this.ww);
        sb.append("\nparamsJson: ");
        sb.append(this.lz);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.x;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.jb);
        sb.append("\textraObject: ");
        Object obj = this.je;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.o);
        sb.append("\tV3EventName: ");
        sb.append(this.lc);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.f21192io;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public String u() {
        return this.u;
    }

    public JSONObject ww() {
        return this.ww;
    }

    public List<String> x() {
        return this.x;
    }
}
