package com.blued.community.manager;

import android.text.TextUtils;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.community.model.HomeTabBubbleExtra;
import com.blued.community.model.NearbyGuideModel;
import com.blued.community.utils.UserInfoUtils;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunityManager.class */
public final class CommunityManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19086a = new Companion(null);
    private static final Lazy<CommunityManager> u = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<CommunityManager>() { // from class: com.blued.community.manager.CommunityManager$Companion$instance$2
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final CommunityManager invoke() {
            return new CommunityManager();
        }
    });
    private HomeTabBubbleExtra b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19087c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private ArrayList<NearbyGuideModel> h = new ArrayList<>();
    private boolean i = true;
    private boolean j = true;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private float p;
    private float q;
    private String r;
    private String s;
    private boolean t;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunityManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommunityManager a() {
            return (CommunityManager) CommunityManager.u.getValue();
        }
    }

    public final HomeTabBubbleExtra a() {
        return this.b;
    }

    public final void a(float f) {
        this.p = f;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(HomeTabBubbleExtra homeTabBubbleExtra) {
        this.b = homeTabBubbleExtra;
    }

    public final void a(String str) {
        this.r = str;
    }

    public final void a(boolean z) {
        this.f19087c = z;
    }

    public final void b(float f) {
        this.q = f;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final void b(String str) {
        this.s = str;
    }

    public final void b(boolean z) {
        this.g = z;
    }

    public final boolean b() {
        return this.f19087c;
    }

    public final int c() {
        return this.d;
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public final boolean c(String str) {
        String str2 = str;
        return !TextUtils.isEmpty(str2) && TextUtils.equals(str2, UserInfoUtils.c());
    }

    public final int d() {
        return this.e;
    }

    public final void d(boolean z) {
        this.j = z;
    }

    public final void e(boolean z) {
        this.k = z;
    }

    public final boolean e() {
        return this.f;
    }

    public final void f(boolean z) {
        this.l = z;
    }

    public final boolean f() {
        return this.g;
    }

    public final ArrayList<NearbyGuideModel> g() {
        return this.h;
    }

    public final void g(boolean z) {
        this.m = z;
    }

    public final void h(boolean z) {
        this.n = z;
    }

    public final boolean h() {
        return this.i;
    }

    public final void i(boolean z) {
        this.o = z;
    }

    public final boolean i() {
        return this.j;
    }

    public final void j(boolean z) {
        this.t = z;
    }

    public final boolean j() {
        return this.k;
    }

    public final boolean k() {
        return this.l;
    }

    public final boolean l() {
        return this.m;
    }

    public final boolean m() {
        return this.n;
    }

    public final boolean n() {
        return this.o;
    }

    public final float o() {
        return this.p;
    }

    public final float p() {
        return this.q;
    }

    public final String q() {
        return this.s;
    }

    public final boolean r() {
        return this.t;
    }

    public final boolean s() {
        return !BluedSkinUtils.c();
    }

    public final String t() {
        return "";
    }
}
