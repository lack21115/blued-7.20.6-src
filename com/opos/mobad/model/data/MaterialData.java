package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.ag;
import com.opos.mobad.b.a.f;
import com.opos.mobad.b.a.q;
import com.opos.mobad.b.a.s;
import com.opos.mobad.b.a.y;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/MaterialData.class */
public class MaterialData extends a implements Parcelable, Comparable {
    public static final Parcelable.Creator<MaterialData> CREATOR = new Parcelable.Creator<MaterialData>() { // from class: com.opos.mobad.model.data.MaterialData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                MaterialData materialData = new MaterialData();
                materialData.a(parcel.readString());
                materialData.a(parcel.readInt());
                materialData.b(parcel.readInt());
                materialData.a(parcel.createTypedArrayList(MaterialFileData.CREATOR));
                materialData.b(parcel.readString());
                materialData.c(parcel.readString());
                materialData.b(parcel.createTypedArrayList(MaterialFileData.CREATOR));
                materialData.a(parcel.readByte() != 0);
                materialData.d(parcel.readString());
                materialData.a(parcel.readLong());
                materialData.e(parcel.readString());
                materialData.c(parcel.createStringArrayList());
                materialData.d(parcel.createStringArrayList());
                materialData.e(parcel.createStringArrayList());
                materialData.f(parcel.readString());
                materialData.g(parcel.readString());
                materialData.c(parcel.readInt());
                materialData.b(parcel.readByte() != 0);
                materialData.h(parcel.readString());
                materialData.i(parcel.readString());
                materialData.b(parcel.readLong());
                materialData.d(parcel.readInt());
                materialData.j(parcel.readString());
                materialData.f(parcel.createStringArrayList());
                materialData.g(parcel.createStringArrayList());
                materialData.h(parcel.createStringArrayList());
                materialData.i(parcel.createStringArrayList());
                materialData.j(parcel.createStringArrayList());
                materialData.k(parcel.createStringArrayList());
                materialData.l(parcel.createStringArrayList());
                materialData.e(parcel.readInt());
                materialData.f(parcel.readInt());
                materialData.c(parcel.readByte() != 0);
                materialData.m(parcel.createTypedArrayList(MaterialFileData.CREATOR));
                materialData.g(parcel.readInt());
                materialData.h(parcel.readInt());
                materialData.i(parcel.readInt());
                materialData.j(parcel.readInt());
                materialData.k(parcel.readInt());
                materialData.d(parcel.readByte() != 0);
                materialData.l(parcel.readInt());
                materialData.k(parcel.readString());
                materialData.e(parcel.readByte() != 0);
                materialData.f(parcel.readByte() != 0);
                materialData.m(parcel.readInt());
                materialData.a((AppDownloadData) parcel.readParcelable(AppDownloadData.class.getClassLoader()));
                materialData.n(parcel.createStringArrayList());
                materialData.o(parcel.createStringArrayList());
                materialData.p(parcel.createStringArrayList());
                materialData.l(parcel.readString());
                materialData.m(parcel.readString());
                materialData.n(parcel.readInt());
                materialData.a((FloatLayerData) parcel.readParcelable(FloatLayerData.class.getClassLoader()));
                materialData.o(parcel.readInt());
                materialData.p(parcel.readInt());
                materialData.g(parcel.readByte() != 0);
                materialData.n(parcel.readString());
                materialData.h(parcel.readByte() != 0);
                materialData.r(parcel.readInt());
                materialData.q(parcel.readInt());
                materialData.i(parcel.readByte() != 0);
                materialData.j(parcel.readByte() != 0);
                materialData.s(parcel.readInt());
                materialData.k(parcel.readByte() != 0);
                materialData.o(parcel.readString());
                boolean z = false;
                if (parcel.readByte() == 1) {
                    z = true;
                }
                materialData.aq = z;
                materialData.f12786ar = (PendantData) parcel.readParcelable(PendantData.class.getClassLoader());
                materialData.as = parcel.readInt();
                materialData.q = parcel.createTypedArrayList(MaterialFileData.CREATOR);
                materialData.at = parcel.readLong();
                materialData.au = parcel.readInt();
                materialData.av = parcel.readInt();
                materialData.aw = parcel.readString();
                materialData.ax = parcel.readString();
                return materialData;
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialData[] newArray(int i) {
            return new MaterialData[i];
        }
    };
    private int A;
    private boolean B;
    private String C;
    private String D;
    private long E;
    private int F;
    private String G;
    private List<String> H;
    private List<String> I;
    private List<String> J;
    private List<String> K;
    private List<String> L;
    private List<String> M;
    private List<String> N;
    private int O;
    private int P;
    private boolean Q;
    private List<MaterialFileData> R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private int Y;
    private String Z;

    /* renamed from: a  reason: collision with root package name */
    public String f12785a;
    private boolean aa;
    private int ab;
    private boolean ac;
    private AppDownloadData ad;
    private List<String> ae;
    private List<String> af;
    private List<String> ag;
    private String ah;
    private String ai;
    private int aj;
    private FloatLayerData ak;
    private int al;
    private int am;
    private boolean an;
    private boolean ao;
    private String ap;
    private boolean aq;

    /* renamed from: ar  reason: collision with root package name */
    private PendantData f12786ar;
    private int as;
    private long at;
    private int au;
    private int av;
    private String aw;
    private String ax;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public int f12787c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;
    public List<String> h;
    public String i;
    private String j;
    private int k;
    private int l;
    private List<MaterialFileData> m;
    private String n;
    private String o;
    private List<MaterialFileData> p;
    private List<MaterialFileData> q;
    private boolean r;
    private String s;
    private long t;
    private String u;
    private List<String> v;
    private List<String> w;
    private List<String> x;
    private String y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.model.data.MaterialData$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/MaterialData$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12788a;
        static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f12789c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;
        static final /* synthetic */ int[] f;
        static final /* synthetic */ int[] g;
        static final /* synthetic */ int[] h;
        static final /* synthetic */ int[] i;
        static final /* synthetic */ int[] j;
        static final /* synthetic */ int[] k;
        static final /* synthetic */ int[] l;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x02ab -> B:236:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x02af -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x02b3 -> B:244:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x02b7 -> B:11:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:0x02bb -> B:252:0x0052). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x02bf -> B:264:0x005d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:128:0x02c3 -> B:260:0x0068). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:130:0x02c7 -> B:272:0x0073). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:132:0x02cb -> B:268:0x007e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:134:0x02cf -> B:280:0x008a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x02d3 -> B:276:0x0096). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:138:0x02d7 -> B:288:0x00a2). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:140:0x02db -> B:284:0x00ae). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x02df -> B:296:0x00ba). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x02e3 -> B:292:0x00c6). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:146:0x02e7 -> B:304:0x00d2). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x02eb -> B:300:0x00de). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:150:0x02ef -> B:40:0x00ea). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:152:0x02f3 -> B:306:0x00fe). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:154:0x02f7 -> B:314:0x0109). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:156:0x02fb -> B:312:0x0114). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:158:0x02ff -> B:318:0x011f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x0303 -> B:316:0x012a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x0307 -> B:220:0x0136). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x030b -> B:55:0x0142). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:166:0x030f -> B:224:0x0156). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:168:0x0313 -> B:60:0x0161). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:170:0x0317 -> B:228:0x0175). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:172:0x031b -> B:65:0x0180). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x031f -> B:232:0x0194). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:176:0x0323 -> B:70:0x019f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:178:0x0327 -> B:238:0x01b3). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:180:0x032b -> B:234:0x01be). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:182:0x032f -> B:246:0x01c9). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:184:0x0333 -> B:79:0x01d4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:186:0x0337 -> B:254:0x01e8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:188:0x033b -> B:250:0x01f3). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x033f -> B:86:0x01fe). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:192:0x0343 -> B:258:0x0212). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:194:0x0347 -> B:270:0x021d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:196:0x034b -> B:93:0x0228). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:198:0x034f -> B:278:0x023c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:200:0x0353 -> B:274:0x0247). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:202:0x0357 -> B:286:0x0252). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:204:0x035b -> B:282:0x025d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:206:0x035f -> B:294:0x0268). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:208:0x0363 -> B:290:0x0274). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:210:0x0367 -> B:108:0x0280). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:212:0x036b -> B:298:0x0294). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:214:0x036f -> B:308:0x029f). Please submit an issue!!! */
        static {
            int[] iArr = new int[s.values().length];
            l = iArr;
            try {
                iArr[s.TYPE_16_8.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                l[s.TYPE_16_9.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[y.g.values().length];
            k = iArr2;
            try {
                iArr2[y.g.OPEN_HOME.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                k[y.g.OPEN_DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr3 = new int[y.b.values().length];
            j = iArr3;
            try {
                iArr3[y.b.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                j[y.b.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                j[y.b.TEXT_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                j[y.b.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                j[y.b.FULL_IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                j[y.b.TEXT_ICON_640X320.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            try {
                j[y.b.TEXT_ICON_320X210.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                j[y.b.TEXT_ICON_GROUP_320X210.ordinal()] = 8;
            } catch (NoSuchFieldError e13) {
            }
            try {
                j[y.b.VIDEO_HTML.ordinal()] = 9;
            } catch (NoSuchFieldError e14) {
            }
            try {
                j[y.b.VIDEO_TIP_BAR.ordinal()] = 10;
            } catch (NoSuchFieldError e15) {
            }
            try {
                j[y.b.FULL_VIDEO.ordinal()] = 11;
            } catch (NoSuchFieldError e16) {
            }
            try {
                j[y.b.POP_WINDOW_VIDEO.ordinal()] = 12;
            } catch (NoSuchFieldError e17) {
            }
            try {
                j[y.b.RAW_VIDEO.ordinal()] = 13;
            } catch (NoSuchFieldError e18) {
            }
            try {
                j[y.b.INTERACTIVE_MT.ordinal()] = 14;
            } catch (NoSuchFieldError e19) {
            }
            int[] iArr4 = new int[y.h.values().length];
            i = iArr4;
            try {
                iArr4[y.h.SURFING.ordinal()] = 1;
            } catch (NoSuchFieldError e20) {
            }
            try {
                i[y.h.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e21) {
            }
            try {
                i[y.h.MIDDLE_PAGE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError e22) {
            }
            try {
                i[y.h.OPEN_HOME_PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e23) {
            }
            try {
                i[y.h.OPEN_DETAIL_PAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e24) {
            }
            try {
                i[y.h.OPEN_INSTANT.ordinal()] = 6;
            } catch (NoSuchFieldError e25) {
            }
            try {
                i[y.h.OPEN_MINI_PROGRAM.ordinal()] = 7;
            } catch (NoSuchFieldError e26) {
            }
            int[] iArr5 = new int[y.f.values().length];
            h = iArr5;
            try {
                iArr5[y.f.SHOW_REMINDER_TOAST.ordinal()] = 1;
            } catch (NoSuchFieldError e27) {
            }
            try {
                h[y.f.AUTO_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError e28) {
            }
            int[] iArr6 = new int[y.k.values().length];
            g = iArr6;
            try {
                iArr6[y.k.WEBVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError e29) {
            }
            try {
                g[y.k.SYSTEM_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError e30) {
            }
            int[] iArr7 = new int[y.l.values().length];
            f = iArr7;
            try {
                iArr7[y.l.IMAGE_TIP_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError e31) {
            }
            try {
                f[y.l.GRAPHIC_MIX_TIP_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError e32) {
            }
            int[] iArr8 = new int[y.c.values().length];
            e = iArr8;
            try {
                iArr8[y.c.SDK_APP.ordinal()] = 1;
            } catch (NoSuchFieldError e33) {
            }
            try {
                e[y.c.DEEPLINK_APP.ordinal()] = 2;
            } catch (NoSuchFieldError e34) {
            }
            try {
                e[y.c.DOWNLOADER.ordinal()] = 3;
            } catch (NoSuchFieldError e35) {
            }
            try {
                e[y.c.SAFE_DEEPLINK_APP.ordinal()] = 4;
            } catch (NoSuchFieldError e36) {
            }
            int[] iArr9 = new int[y.m.values().length];
            d = iArr9;
            try {
                iArr9[y.m.JUMP_LANDING_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e37) {
            }
            try {
                d[y.m.JUMP_FLOATING_LAYER.ordinal()] = 2;
            } catch (NoSuchFieldError e38) {
            }
            try {
                d[y.m.NO_JUMP_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError e39) {
            }
            int[] iArr10 = new int[y.d.values().length];
            f12789c = iArr10;
            try {
                iArr10[y.d.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e40) {
            }
            try {
                f12789c[y.d.MODEL_A.ordinal()] = 2;
            } catch (NoSuchFieldError e41) {
            }
            try {
                f12789c[y.d.MODEL_INTERACTION.ordinal()] = 3;
            } catch (NoSuchFieldError e42) {
            }
            int[] iArr11 = new int[ag.c.values().length];
            b = iArr11;
            try {
                iArr11[ag.c.VIDEO_START.ordinal()] = 1;
            } catch (NoSuchFieldError e43) {
            }
            try {
                b[ag.c.VIDEO_PROCESS_25_PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError e44) {
            }
            try {
                b[ag.c.VIDEO_PROCESS_50_PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError e45) {
            }
            try {
                b[ag.c.VIDEO_PROCESS_75_PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError e46) {
            }
            try {
                b[ag.c.VIDEO_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError e47) {
            }
            try {
                b[ag.c.VIDEO_CLICK.ordinal()] = 6;
            } catch (NoSuchFieldError e48) {
            }
            try {
                b[ag.c.VIDEO_CLOSE.ordinal()] = 7;
            } catch (NoSuchFieldError e49) {
            }
            int[] iArr12 = new int[q.b.values().length];
            f12788a = iArr12;
            try {
                iArr12[q.b.DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError e50) {
            }
            try {
                f12788a[q.b.DOWNLOAD_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError e51) {
            }
            try {
                f12788a[q.b.INSTALL_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError e52) {
            }
        }
    }

    public MaterialData() {
        this.B = true;
        this.P = 0;
    }

    public MaterialData(y yVar, List<MaterialFileData> list, List<MaterialFileData> list2, List<MaterialFileData> list3, List<MaterialFileData> list4, FloatLayerData floatLayerData, PendantData pendantData) {
        List<String> list5;
        List<String> list6;
        this.B = true;
        this.P = 0;
        this.j = yVar.P != null ? yVar.P : "";
        this.k = a(yVar.Q);
        this.l = a(yVar.R);
        this.V = a(yVar.au);
        this.W = a(yVar.av);
        this.U = a(yVar.at);
        this.n = yVar.T != null ? yVar.T : "";
        this.o = yVar.U != null ? yVar.U : "";
        this.m = list;
        this.p = list2;
        this.R = list3;
        this.q = list4;
        this.r = (yVar.W != null ? yVar.W : y.f).booleanValue();
        this.s = yVar.X != null ? yVar.X : "";
        this.t = (yVar.Y != null ? yVar.Y : y.g).longValue();
        this.u = yVar.Z != null ? yVar.Z : "";
        List<String> list7 = yVar.aa;
        if (list7 != null && list7.size() > 0) {
            this.v = list7;
        }
        List<String> list8 = yVar.ab;
        if (list8 != null && list8.size() > 0) {
            this.w = list8;
        }
        List<String> list9 = yVar.ac;
        if (list9 != null && list9.size() > 0) {
            this.x = list9;
        }
        this.y = yVar.ad != null ? yVar.ad : "";
        this.z = yVar.ae != null ? yVar.ae : "";
        this.A = (yVar.af != null ? yVar.af : y.h).intValue();
        this.B = (yVar.ag != null ? yVar.ag : y.i).booleanValue();
        this.C = yVar.ah != null ? yVar.ah : "";
        this.D = yVar.ai != null ? yVar.ai : "";
        this.E = (yVar.aj != null ? yVar.aj : y.j).longValue();
        this.F = (yVar.ak != null ? yVar.ak : y.k).intValue();
        this.G = yVar.al != null ? yVar.al : "";
        r(yVar.am);
        this.O = a(yVar.an);
        this.P = a(yVar.ao);
        this.Q = (yVar.ap != null ? yVar.ap : y.n).booleanValue();
        this.S = a(yVar.f12085ar);
        this.T = (yVar.as != null ? yVar.as : y.p).intValue();
        this.X = (yVar.aw != null ? yVar.aw : y.t).booleanValue();
        this.Y = a(yVar.ax);
        this.Z = yVar.ay != null ? yVar.ay : "";
        this.ah = yVar.aF != null ? yVar.aF : "";
        this.ai = yVar.aE != null ? yVar.aE : "";
        this.aj = a(yVar.aG);
        this.an = (yVar.aK != null ? yVar.aK : y.B).booleanValue();
        this.f12785a = yVar.aM != null ? yVar.aM : "";
        this.b = (yVar.aN != null ? yVar.aN : y.D).booleanValue();
        this.d = a(yVar.aO);
        this.f12787c = a(yVar.aP);
        this.e = (yVar.aQ != null ? yVar.aQ : y.G).booleanValue();
        this.f = (yVar.aR != null ? yVar.aR : y.H).booleanValue();
        this.aa = (yVar.aB != null ? yVar.aB : y.x).booleanValue();
        this.ac = (yVar.aA != null ? yVar.aA : y.w).booleanValue();
        this.ab = (yVar.az != null ? yVar.az : y.v).intValue();
        this.ad = a(yVar.aC);
        q(yVar.aD);
        this.ak = floatLayerData;
        this.al = a(yVar.aI);
        this.am = a(yVar.aJ);
        this.i = yVar.aS;
        this.h = yVar.aT;
        this.g = a(yVar.aV);
        this.ao = (yVar.aW != null ? yVar.aW : y.J).booleanValue();
        this.ap = yVar.aU != null ? yVar.aU : "";
        this.aq = (yVar.aX != null ? yVar.aX : y.K).booleanValue();
        this.f12786ar = pendantData;
        this.as = (yVar.aZ != null ? yVar.aZ : y.L).intValue();
        List<String> list10 = this.x;
        if ((list10 == null || list10.size() <= 0) && (list5 = this.M) != null && list5.size() > 0) {
            this.x = this.M;
        }
        List<String> list11 = this.w;
        if ((list11 == null || list11.size() <= 0) && (list6 = this.N) != null && list6.size() > 0) {
            this.w = this.N;
        }
        this.at = (yVar.bb != null ? yVar.bb : y.M).longValue();
        this.au = (yVar.bd != null ? yVar.bd : y.O).intValue();
        this.av = (yVar.bc != null ? yVar.bc : y.N).intValue();
        this.aw = yVar.be != null ? yVar.be : "";
        this.ax = yVar.bf != null ? yVar.bf : "";
    }

    private int a(s sVar) {
        int i = 1;
        if (sVar != null) {
            if (AnonymousClass2.l[sVar.ordinal()] != 1) {
                return 1;
            }
            i = 0;
        }
        return i;
    }

    private static int a(y.b bVar) {
        if (bVar != null) {
            switch (AnonymousClass2.j[bVar.ordinal()]) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                case 9:
                    return 9;
                case 10:
                    return 10;
                case 11:
                    return 11;
                case 12:
                    return 12;
                case 13:
                    return 13;
                case 14:
                    return 14;
                default:
                    return 0;
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r0 != 4) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.mobad.b.a.y.c r3) {
        /*
            r0 = 3
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L25
            int[] r0 = com.opos.mobad.model.data.MaterialData.AnonymousClass2.e
            r1 = r3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L23
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L21
            r0 = r5
            r1 = 4
            if (r0 == r1) goto L27
            goto L25
        L21:
            r0 = 2
            return r0
        L23:
            r0 = 1
            return r0
        L25:
            r0 = 0
            r4 = r0
        L27:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.data.MaterialData.a(com.opos.mobad.b.a.y$c):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0 != 3) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.mobad.b.a.y.d r3) {
        /*
            r0 = 2
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L1e
            int[] r0 = com.opos.mobad.model.data.MaterialData.AnonymousClass2.f12789c
            r1 = r3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L1c
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L20
            goto L1e
        L1c:
            r0 = 1
            return r0
        L1e:
            r0 = 0
            r4 = r0
        L20:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.data.MaterialData.a(com.opos.mobad.b.a.y$d):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0 != 2) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.mobad.b.a.y.f r3) {
        /*
            r0 = 2
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L1e
            int[] r0 = com.opos.mobad.model.data.MaterialData.AnonymousClass2.h
            r1 = r3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L1c
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L20
            goto L1e
        L1c:
            r0 = 1
            return r0
        L1e:
            r0 = 0
            r4 = r0
        L20:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.data.MaterialData.a(com.opos.mobad.b.a.y$f):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0 != 2) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.mobad.b.a.y.g r3) {
        /*
            r0 = 2
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L1e
            int[] r0 = com.opos.mobad.model.data.MaterialData.AnonymousClass2.k
            r1 = r3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L1c
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L20
            goto L1e
        L1c:
            r0 = 1
            return r0
        L1e:
            r0 = 0
            r4 = r0
        L20:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.data.MaterialData.a(com.opos.mobad.b.a.y$g):int");
    }

    public static int a(y.h hVar) {
        if (hVar != null) {
            switch (AnonymousClass2.i[hVar.ordinal()]) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                default:
                    return 0;
            }
        }
        return 0;
    }

    private static int a(y.k kVar) {
        return (kVar == null || AnonymousClass2.g[kVar.ordinal()] != 2) ? 0 : 1;
    }

    private static int a(y.l lVar) {
        return (lVar == null || AnonymousClass2.f[lVar.ordinal()] != 2) ? 0 : 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0 != 3) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.mobad.b.a.y.m r3) {
        /*
            r0 = 2
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L1e
            int[] r0 = com.opos.mobad.model.data.MaterialData.AnonymousClass2.d
            r1 = r3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L1c
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L20
            goto L1e
        L1c:
            r0 = 1
            return r0
        L1e:
            r0 = 0
            r4 = r0
        L20:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.data.MaterialData.a(com.opos.mobad.b.a.y$m):int");
    }

    private AppDownloadData a(f fVar) {
        if (fVar != null) {
            AppDownloadData appDownloadData = new AppDownloadData();
            appDownloadData.a(fVar.d != null ? fVar.d : "");
            appDownloadData.c(fVar.f != null ? fVar.f : "");
            appDownloadData.d(fVar.g != null ? fVar.g : "");
            appDownloadData.b(fVar.e != null ? fVar.e : "");
            return appDownloadData;
        }
        return null;
    }

    private void q(List<q> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (q qVar : list) {
            int i = AnonymousClass2.f12788a[qVar.e.ordinal()];
            if (i == 1) {
                this.ae = qVar.f;
            } else if (i == 2) {
                this.af = qVar.f;
            } else if (i == 3) {
                this.ag = qVar.f;
            }
        }
    }

    private void r(List<ag> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ag agVar : list) {
            switch (AnonymousClass2.b[agVar.e.ordinal()]) {
                case 1:
                    this.H = agVar.f;
                    break;
                case 2:
                    this.I = agVar.f;
                    break;
                case 3:
                    this.J = agVar.f;
                    break;
                case 4:
                    this.K = agVar.f;
                    break;
                case 5:
                    this.L = agVar.f;
                    break;
                case 6:
                    this.M = agVar.f;
                    break;
                case 7:
                    this.N = agVar.f;
                    break;
            }
        }
    }

    public List<String> A() {
        return this.K;
    }

    public List<String> B() {
        return this.L;
    }

    public int C() {
        return this.O;
    }

    public int D() {
        return this.P;
    }

    public boolean E() {
        return this.Q;
    }

    public List<MaterialFileData> F() {
        return this.R;
    }

    public int G() {
        return this.S;
    }

    public int H() {
        return this.T;
    }

    public int I() {
        return this.U;
    }

    public int J() {
        return this.V;
    }

    public int K() {
        return this.W;
    }

    public int L() {
        return this.Y;
    }

    public String M() {
        return this.Z;
    }

    public AppDownloadData N() {
        return this.ad;
    }

    public List<String> O() {
        return this.ae;
    }

    public List<String> P() {
        return this.af;
    }

    public List<String> Q() {
        return this.ag;
    }

    public String R() {
        return this.ah;
    }

    public String S() {
        return this.ai;
    }

    public int T() {
        return this.aj;
    }

    public FloatLayerData U() {
        return this.ak;
    }

    public int V() {
        return this.al;
    }

    public int W() {
        return this.am;
    }

    public boolean X() {
        return this.an;
    }

    public String Y() {
        return this.f12785a;
    }

    public boolean Z() {
        return this.ao;
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(long j) {
        this.t = j;
    }

    public void a(AppDownloadData appDownloadData) {
        this.ad = appDownloadData;
    }

    public void a(FloatLayerData floatLayerData) {
        this.ak = floatLayerData;
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(List<MaterialFileData> list) {
        this.m = list;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public boolean a() {
        return this.aq;
    }

    public String aa() {
        return this.ap;
    }

    public PendantData ab() {
        return this.f12786ar;
    }

    public boolean ac() {
        return this.f12786ar != null;
    }

    public long ad() {
        return this.at;
    }

    public int ae() {
        return this.au;
    }

    public int af() {
        return this.av;
    }

    public String ag() {
        return this.aw;
    }

    public String ah() {
        return this.ax;
    }

    public int b() {
        return this.as;
    }

    public void b(int i) {
        this.l = i;
    }

    public void b(long j) {
        this.E = j;
    }

    public void b(String str) {
        this.n = str;
    }

    public void b(List<MaterialFileData> list) {
        this.p = list;
    }

    public void b(boolean z) {
        this.B = z;
    }

    public String c() {
        return this.j;
    }

    public void c(int i) {
        this.A = i;
    }

    public void c(String str) {
        this.o = str;
    }

    public void c(List<String> list) {
        this.v = list;
    }

    public void c(boolean z) {
        this.Q = z;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof AdItemData) {
            return this.A <= ((MaterialData) obj).A ? -1 : 1;
        }
        return 0;
    }

    public int d() {
        return this.k;
    }

    public void d(int i) {
        this.F = i;
    }

    public void d(String str) {
        this.s = str;
    }

    public void d(List<String> list) {
        this.w = list;
    }

    public void d(boolean z) {
        this.X = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.l;
    }

    public void e(int i) {
        this.O = i;
    }

    public void e(String str) {
        this.u = str;
    }

    public void e(List<String> list) {
        this.x = list;
    }

    public void e(boolean z) {
        this.aa = z;
    }

    public List<MaterialFileData> f() {
        return this.m;
    }

    public void f(int i) {
        this.P = i;
    }

    public void f(String str) {
        this.y = str;
    }

    public void f(List<String> list) {
        this.H = list;
    }

    public void f(boolean z) {
        this.ac = z;
    }

    public List<MaterialFileData> g() {
        return this.q;
    }

    public void g(int i) {
        this.S = i;
    }

    public void g(String str) {
        this.z = str;
    }

    public void g(List<String> list) {
        this.I = list;
    }

    public void g(boolean z) {
        this.an = z;
    }

    public String h() {
        return this.n;
    }

    public void h(int i) {
        this.T = i;
    }

    public void h(String str) {
        this.C = str;
    }

    public void h(List<String> list) {
        this.J = list;
    }

    public void h(boolean z) {
        this.b = z;
    }

    public String i() {
        return this.o;
    }

    public void i(int i) {
        this.U = i;
    }

    public void i(String str) {
        this.D = str;
    }

    public void i(List<String> list) {
        this.K = list;
    }

    public void i(boolean z) {
        this.e = z;
    }

    public List<MaterialFileData> j() {
        return this.p;
    }

    public void j(int i) {
        this.V = i;
    }

    public void j(String str) {
        this.G = str;
    }

    public void j(List<String> list) {
        this.L = list;
    }

    public void j(boolean z) {
        this.f = z;
    }

    public String k() {
        return this.s;
    }

    public void k(int i) {
        this.W = i;
    }

    public void k(String str) {
        this.Z = str;
    }

    public void k(List<String> list) {
        this.M = list;
    }

    public void k(boolean z) {
        this.ao = z;
    }

    public long l() {
        return this.t;
    }

    public void l(int i) {
        this.Y = i;
    }

    public void l(String str) {
        this.ah = str;
    }

    public void l(List<String> list) {
        this.N = list;
    }

    public String m() {
        return this.u;
    }

    public void m(int i) {
        this.ab = i;
    }

    public void m(String str) {
        this.ai = str;
    }

    public void m(List<MaterialFileData> list) {
        this.R = list;
    }

    public List<String> n() {
        return this.v;
    }

    public void n(int i) {
        this.aj = i;
    }

    public void n(String str) {
        this.f12785a = str;
    }

    public void n(List<String> list) {
        this.ae = list;
    }

    public List<String> o() {
        return this.w;
    }

    public void o(int i) {
        this.al = i;
    }

    public void o(String str) {
        this.ap = str;
    }

    public void o(List<String> list) {
        this.af = list;
    }

    public List<String> p() {
        return this.x;
    }

    public void p(int i) {
        this.am = i;
    }

    public void p(List<String> list) {
        this.ag = list;
    }

    public String q() {
        return this.y;
    }

    public void q(int i) {
        this.f12787c = i;
    }

    public String r() {
        return this.z;
    }

    public void r(int i) {
        this.d = i;
    }

    public String s() {
        return this.C;
    }

    public void s(int i) {
        this.g = i;
    }

    public String t() {
        return this.D;
    }

    public String toString() {
        return "MaterialData{materialId='" + this.j + "', creativeType=" + this.k + ", interactionType=" + this.l + ", imgFileList=" + this.m + ", interactiveFileList=" + this.q + ", title='" + this.n + "', desc='" + this.o + "', iconFileList=" + this.p + ", gbClick=" + this.r + ", downloadPkgName='" + this.s + "', apkSize=" + this.t + ", targetUrl='" + this.u + "', expStartUrls=" + this.v + ", expEndUrls=" + this.w + ", clickUrls=" + this.x + ", traceId='" + this.y + "', transparent='" + this.z + "', currentIndex=" + this.A + ", forceJsInit=" + this.B + ", extraUrl='" + this.C + "', dlChannel='" + this.D + "', videoDuration=" + this.E + ", showOffBnTime=" + this.F + ", landingPageUrl='" + this.G + "', videoStartUrls=" + this.H + ", video25PercentUrls=" + this.I + ", video50PercentUrls=" + this.J + ", video75PercentUrls=" + this.K + ", videoCompleteUrls=" + this.L + ", videoClickUrls=" + this.M + ", videoCloseUrls=" + this.N + ", installCompleteAction=" + this.O + ", surfingType=" + this.P + ", isGbClickToast=" + this.Q + ", videoFileList=" + this.R + ", tipBarType=" + this.S + ", rewardLimitTime=" + this.T + ", installedAction=" + this.U + ", extraActionType=" + this.V + ", videoActionType=" + this.W + ", isRemoveRepeatAd=" + this.X + ", downloadStyle=" + this.Y + ", downloadUrl=" + this.Z + ", maxDownloaderNums='" + this.ab + "', showDownloadNotification='" + this.ac + "', wifiRemindAtCellular='" + this.aa + "', trackContent=" + this.ah + ", trackReference=" + this.ai + ", appDownloadData=" + this.ad + "', downloadStartUrls=" + this.ae + "', downloadCompleteUrls=" + this.af + "', downloadInstalledUrls=" + this.ag + "', videoCompleteAction=" + this.aj + "', floatLayerData=" + this.ak + "', floatLayerBtAction=" + this.al + "', floatLayerExtraAction=" + this.am + "', isMobileAutoPlay=" + this.an + "', buttonTitle=" + this.f12785a + "', isShowMediaInfo=" + this.b + "', isShowConvertBar=" + this.e + "', isDynamicPopUpConvert=" + this.f + "', portEndPageModelType=" + this.d + "', landEndPageModelType=" + this.f12787c + "', imgType=" + this.g + "', isShowFeedBack=" + this.ao + "', isVertical=" + this.aq + "', pendantInfo=" + this.f12786ar + "', templateId=" + this.as + "', apkDownloadTimes=" + this.at + "', specificationId=" + this.au + "'}";
    }

    public long u() {
        return this.E;
    }

    public int v() {
        return this.F;
    }

    public String w() {
        return this.G;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeTypedList(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeTypedList(this.p);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeString(this.s);
        parcel.writeLong(this.t);
        parcel.writeString(this.u);
        parcel.writeStringList(this.v);
        parcel.writeStringList(this.w);
        parcel.writeStringList(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeInt(this.A);
        parcel.writeByte(this.B ? (byte) 1 : (byte) 0);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeLong(this.E);
        parcel.writeInt(this.F);
        parcel.writeString(this.G);
        parcel.writeStringList(this.H);
        parcel.writeStringList(this.I);
        parcel.writeStringList(this.J);
        parcel.writeStringList(this.K);
        parcel.writeStringList(this.L);
        parcel.writeStringList(this.M);
        parcel.writeStringList(this.N);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeByte(this.Q ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.R);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        parcel.writeInt(this.W);
        parcel.writeByte(this.X ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.Y);
        parcel.writeString(this.Z);
        parcel.writeByte(this.aa ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ac ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.ab);
        parcel.writeParcelable(this.ad, i);
        parcel.writeStringList(this.ae);
        parcel.writeStringList(this.af);
        parcel.writeStringList(this.ag);
        parcel.writeString(this.ah);
        parcel.writeString(this.ai);
        parcel.writeInt(this.aj);
        parcel.writeParcelable(this.ak, i);
        parcel.writeInt(this.al);
        parcel.writeInt(this.am);
        parcel.writeByte(this.an ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f12785a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.f12787c);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.g);
        parcel.writeByte(this.ao ? (byte) 1 : (byte) 0);
        parcel.writeString(this.ap);
        parcel.writeByte(this.aq ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f12786ar, i);
        parcel.writeInt(this.as);
        parcel.writeTypedList(this.q);
        parcel.writeLong(this.at);
        parcel.writeInt(this.au);
        parcel.writeInt(this.av);
        parcel.writeString(this.aw);
        parcel.writeString(this.ax);
    }

    public List<String> x() {
        return this.H;
    }

    public List<String> y() {
        return this.I;
    }

    public List<String> z() {
        return this.J;
    }
}
