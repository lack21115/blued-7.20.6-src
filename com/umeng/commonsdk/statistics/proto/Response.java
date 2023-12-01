package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cp;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cs;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cx;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.cz;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/Response.class */
public class Response implements bq<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, cc> metaDataMap;
    private static final Map<Class<? extends cx>, cy> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final cu STRUCT_DESC = new cu("Response");
    private static final ck RESP_CODE_FIELD_DESC = new ck("resp_code", (byte) 8, 1);
    private static final ck MSG_FIELD_DESC = new ck("msg", (byte) 11, 2);
    private static final ck IMPRINT_FIELD_DESC = new ck(bh.X, (byte) 12, 3);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/Response$a.class */
    public static class a extends cz<Response> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a */
        public void b(cp cpVar, Response response) throws bw {
            cpVar.j();
            while (true) {
                ck l = cpVar.l();
                if (l.b == 0) {
                    break;
                }
                short s = l.f40700c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, l.b);
                        } else if (l.b == 12) {
                            response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                            response.imprint.read(cpVar);
                            response.setImprintIsSet(true);
                        } else {
                            cs.a(cpVar, l.b);
                        }
                    } else if (l.b == 11) {
                        response.msg = cpVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        cs.a(cpVar, l.b);
                    }
                } else if (l.b == 8) {
                    response.resp_code = cpVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    cs.a(cpVar, l.b);
                }
                cpVar.m();
            }
            cpVar.k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            throw new cq("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b */
        public void a(cp cpVar, Response response) throws bw {
            response.validate();
            cpVar.a(Response.STRUCT_DESC);
            cpVar.a(Response.RESP_CODE_FIELD_DESC);
            cpVar.a(response.resp_code);
            cpVar.c();
            if (response.msg != null && response.isSetMsg()) {
                cpVar.a(Response.MSG_FIELD_DESC);
                cpVar.a(response.msg);
                cpVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                cpVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(cpVar);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/Response$b.class */
    static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/Response$c.class */
    public static class c extends da<Response> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, Response response) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            cvVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                cvVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(cvVar);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, Response response) throws bw {
            cv cvVar = (cv) cpVar;
            response.resp_code = cvVar.w();
            response.setResp_codeIsSet(true);
            BitSet b = cvVar.b(2);
            if (b.get(0)) {
                response.msg = cvVar.z();
                response.setMsgIsSet(true);
            }
            if (b.get(1)) {
                response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint.read(cvVar);
                response.setImprintIsSet(true);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/Response$d.class */
    static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/Response$e.class */
    public enum e implements bx {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, bh.X);
        
        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator<E> it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return IMPRINT;
                }
                return MSG;
            }
            return RESP_CODE;
        }

        public static e a(String str) {
            return d.get(str);
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.bx
        public String b() {
            return this.f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        schemes = hashMap;
        hashMap.put(cz.class, new b());
        schemes.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.RESP_CODE, (e) new cc("resp_code", (byte) 1, new cd((byte) 8)));
        enumMap.put((EnumMap) e.MSG, (e) new cc("msg", (byte) 2, new cd((byte) 11)));
        enumMap.put((EnumMap) e.IMPRINT, (e) new cc(bh.X, (byte) 2, new ch((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        Map<e, cc> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = unmodifiableMap;
        cc.a(Response.class, unmodifiableMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cj(new db(objectOutputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public bq<Response, e> deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.bq
    public e fieldForId(int i) {
        return e.a(i);
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return bn.a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        schemes.get(cpVar.D()).b().b(cpVar, this);
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = bn.a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = bn.b(this.__isset_bitfield, 0);
    }

    public void validate() throws bw {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        schemes.get(cpVar.D()).b().a(cpVar, this);
    }
}
