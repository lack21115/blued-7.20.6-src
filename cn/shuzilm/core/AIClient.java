package cn.shuzilm.core;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/AIClient.class */
public class AIClient {

    /* renamed from: a  reason: collision with root package name */
    static int f4151a = 0;
    private static long al = 0;
    private static long am = 0;
    public static boolean isf = false;
    private Context an;
    private String ao = null;
    private final int ap = 0;
    private final int aq = 1;

    /* renamed from: ar  reason: collision with root package name */
    private final int f4153ar = 2;
    private final int as = 3;
    private final int at = 4;
    private final int au = 5;
    private final int av = 6;
    private final int aw = 7;
    private static int[] b = {245, 252, 251, 246, 252, 247, 228, 188, 246, 251, 253, 224, 246, 252, 243, 188, 255, 253, 241, 0};

    /* renamed from: c  reason: collision with root package name */
    private static int[] f4152c = {230, 224, 243, 230, 225, 156, 215, 209, 219, 196, 192, 215, 193, 156, 192, 215, 219, 212, 219, 198, 220, 215, 214, 219, 156, 193, 214, 211, 156, 193, 223, 213, 156, 214, 219, 221, 192, 214, 220, 211, 156, 215, 222, 213, 221, 221, 213, 156, 223, 221, 209, 0};
    private static int[] d = {230, 248, 242, 187, 241, 252, 250, 231, 241, 251, 244, 187, 240, 249, 242, 250, 250, 242, 187, 248, 250, 246, 0};
    private static int[] e = {166, 160, 170, 181, 177, 166, 144, 167, 138, 164, 173, 170, 176, 170, 183, 177, 166, 181, 167, 130, 138, 237, 175, 162, 173, 177, 166, 183, 173, 170, 237, 177, 166, 170, 165, 170, 183, 173, 166, 167, 170, 237, 176, 167, 162, 237, 176, 174, 164, 237, 167, 170, 172, 177, 167, 173, 162, 237, 166, 175, 164, 172, 172, 164, 237, 174, 172, 160, 0};
    private static int[] f = {218, 171, 169, 172, 218, 222, 170, 172, 168, 218, 222, 222, 171, 166, 170, 217, 168, 221, 174, 166, 168, 217, 169, 217, 175, 218, 173, 219, 173, 217, 173, 218, 0};
    private static int[] g = {246, 227, 224, 247, 245, 218, 0};
    private static int[] h = {234, 231, 249, 230, 160, 231, 235, 249, 239, 251, 230, 160, 227, 225, 237, 0};
    private static int[] i = {230, 224, 234, 245, 241, 230, 240, 252, 240, 231, 234, 237, 230, 243, 236, 141, 198, 192, 202, 213, 198, 199, 205, 198, 211, 204, 141, 208, 202, 199, 204, 214, 141, 206, 204, 192, 0};
    private static int[] j = {209, 215, 221, 194, 198, 209, 231, 198, 209, 221, 210, 221, 192, 218, 209, 208, 253, 209, 215, 221, 194, 209, 240, 218, 209, 196, 251, 154, 216, 208, 221, 213, 154, 209, 215, 221, 194, 209, 208, 218, 209, 196, 219, 154, 199, 221, 208, 219, 193, 154, 217, 219, 215, 0};
    private static int[] k = {219, 220, 218, 170, 167, 218, 170, 170, 221, 170, 219, 170, 167, 172, 167, 219, 173, 175, 173, 221, 217, 219, 220, 171, 222, 173, 168, 217, 218, 219, 217, 174, 0};
    private static int[] l = {243, 245, 255, 224, 228, 243, 229, 242, 255, 243, 245, 255, 224, 243, 242, 184, 255, 227, 236, 184, 251, 249, 245, 0};
    private static int[] m = {195, 197, 207, 208, 212, 195, 245, 194, 207, 195, 197, 207, 208, 195, 226, 136, 195, 197, 207, 208, 212, 195, 213, 194, 207, 195, 197, 207, 208, 195, 194, 136, 207, 211, 220, 136, 203, 201, 197, 0};
    private static int[] n = {204, 202, 200, 207, 219, 204, 221, 199, 224, 205, 192, 204, 202, 192, 223, 204, 237, 224, 135, 204, 202, 192, 223, 219, 204, 218, 205, 192, 204, 202, 192, 223, 204, 205, 135, 192, 220, 211, 135, 196, 198, 202, 0};
    private static int[] o = {221, 174, 175, 171, 167, 219, 220, 170, 168, 220, 167, 222, 219, 166, 221, 220, 219, 166, 217, 168, 172, 168, 222, 219, 217, 173, 219, 222, 219, 174, 174, 174, 0};
    private static int[] p = {222, 167, 217, 167, 172, 217, 220, 222, 219, 166, 170, 221, 168, 168, 170, 220, 172, 174, 171, 173, 174, 217, 175, 174, 221, 221, 219, 218, 222, 221, 168, 219, 0};
    private static int[] q = {197, 196, 213, 211, 206, 209, 209, 212, 210, 143, 197, 200, 211, 196, 200, 199, 200, 213, 207, 196, 197, 200, 143, 210, 216, 210, 143, 213, 210, 200, 210, 211, 196, 209, 0};
    private static int[] r = {233, 255, 243, 238, 232, 255, 234, 245, 232, 202, 247, 255, 238, 233, 227, 201, 180, 233, 245, 180, 254, 243, 245, 232, 254, 244, 251, 0};
    private static int[] s = {244, 249, 254, 245, 224, 255, 190, 224, 241, 228, 233, 245, 248, 190, 253, 255, 243, 0};
    private static int[] t = {197, 195, 201, 214, 210, 197, 243, 217, 198, 201, 212, 206, 197, 196, 233, 142, 196, 201, 206, 197, 208, 207, 142, 208, 193, 212, 217, 197, 200, 142, 205, 207, 195, 0};
    private static int[] u = {199, 202, 214, 204, 0};
    private static int[] v = {220, 209, 246, 253, 232, 215, 209, 182, 252, 241, 246, 253, 232, 247, 182, 232, 249, 236, 225, 253, 240, 182, 245, 247, 251, 0};
    private static int[] w = {222, 174, 168, 169, 219, 170, 175, 221, 218, 221, 170, 218, 170, 168, 173, 169, 217, 169, 174, 166, 175, 171, 220, 168, 172, 220, 222, 166, 175, 167, 170, 170, 0};
    private static int[] x = {226, 228, 238, 241, 245, 226, 244, 248, 227, 238, 248, 233, 226, 247, 232, 137, 195, 206, 201, 194, 215, 200, 137, 215, 198, 211, 222, 194, 207, 137, 202, 200, 196, 137, 201, 200, 206, 211, 196, 198, 0};
    private static int[] y = {173, 169, 167, 217, 219, 219, 218, 221, 220, 167, 218, 220, 217, 167, 222, 169, 172, 172, 220, 217, 219, 217, 172, 168, 221, 168, 221, 173, 167, 175, 171, 166, 0};
    private static int[] z = {234, 248, 230, 165, 248, 254, 248, 234, 165, 230, 228, 232, 0};
    private static int[] A = {217, 212, 217, 194, 206, 206, 216, 222, 222, 220, 179, 243, 242, 244, 233, 254, 252, 179, 252, 238, 240, 179, 238, 232, 238, 252, 179, 240, 242, 254, 0};
    private static int[] B = {216, 213, 216, 229, 238, 253, 232, 242, 249, 241, 249, 240, 236, 236, 233, 207, 178, 253, 239, 241, 178, 239, 233, 239, 253, 178, 241, 243, 255, 0};
    private static int[] C = {209, 215, 221, 194, 198, 209, 231, 240, 253, 240, 205, 198, 213, 192, 218, 209, 217, 209, 216, 196, 196, 193, 231, 154, 240, 253, 240, 205, 198, 213, 192, 218, 209, 217, 209, 216, 196, 196, 193, 231, 154, 213, 199, 217, 154, 199, 193, 199, 213, 154, 217, 219, 215, 0};
    private static int[] D = {203, 205, 207, 200, 220, 203, 218, 192, 231, 194, 202, 199, 239, 202, 199, 234, 231, 128, 234, 231, 234, 215, 220, 207, 218, 192, 203, 195, 203, 194, 222, 222, 219, 253, 128, 207, 221, 195, 128, 221, 219, 221, 207, 128, 195, 193, 205, 0};
    private static int[] E = {217, 170, 217, 218, 166, 174, 221, 222, 174, 167, 171, 174, 173, 217, 221, 170, 171, 169, 217, 221, 171, 166, 167, 171, 173, 218, 170, 217, 172, 167, 170, 171, 0};
    private static int[] F = {199, 193, 203, 212, 208, 199, 209, 198, 203, 199, 193, 203, 212, 199, 198, 140, 198, 203, 205, 208, 198, 204, 195, 140, 197, 204, 215, 209, 207, 195, 209, 140, 207, 205, 193, 0};
    private static int[] G = {215, 209, 219, 196, 192, 215, 225, 214, 251, 215, 209, 219, 196, 215, 246, 156, 215, 209, 219, 196, 192, 215, 193, 214, 219, 215, 209, 219, 196, 215, 214, 156, 214, 219, 221, 192, 214, 220, 211, 156, 213, 220, 199, 193, 223, 211, 193, 156, 223, 221, 209, 0};
    private static int[] H = {214, 208, 218, 197, 193, 214, 224, 215, 250, 214, 208, 218, 197, 214, 247, 250, 157, 214, 208, 218, 197, 193, 214, 192, 215, 218, 214, 208, 218, 197, 214, 215, 157, 215, 218, 220, 193, 215, 221, 210, 157, 212, 221, 198, 192, 222, 210, 192, 157, 222, 220, 208, 0};
    private static int[] I = {175, 220, 167, 172, 175, 219, 170, 173, 173, 222, 175, 219, 168, 219, 217, 170, 221, 167, 218, 175, 172, 218, 217, 218, 221, 219, 217, 217, 172, 173, 221, 174, 0};
    private static int[] J = {140, 200, 199, 208, 199, 202, 205, 198, 211, 204, 141, 198, 206, 218, 207, 197, 141, 214, 217, 202, 198, 206, 141, 206, 204, 192, 140, 140, 153, 215, 205, 198, 215, 205, 204, 192, 0};
    private static int[] K = {243, 252, 235, 252, 241, 246, 253, 232, 247, 182, 253, 245, 225, 244, 254, 182, 237, 226, 241, 253, 245, 182, 245, 247, 251, 0};
    private static int[] L = {175, 166, 222, 169, 175, 167, 172, 222, 218, 174, 174, 218, 168, 175, 169, 217, 167, 171, 222, 170, 217, 169, 173, 219, 221, 219, 168, 172, 172, 221, 172, 175, 0};
    private static int[] M = {218, 215, 202, 215, 205, 198, 199, 202, 140, 218, 215, 202, 215, 205, 198, 199, 202, 141, 194, 202, 193, 214, 205, 141, 205, 192, 140, 140, 153, 215, 205, 198, 215, 205, 204, 192, 0};
    private static int[] N = {220, 174, 168, 218, 174, 217, 220, 219, 218, 168, 170, 167, 169, 221, 169, 222, 166, 218, 220, 222, 217, 172, 170, 167, 219, 172, 221, 218, 172, 173, 221, 170, 0};
    private static int[] O = {205, 209, 204, 232, 211, 196, 197, 200, 215, 206, 211, 241, 197, 232, 143, 205, 209, 204, 200, 143, 197, 200, 143, 197, 200, 206, 211, 197, 207, 192, 143, 204, 206, 194, 0};
    private static int[] P = {204, 200, 202, 196, 204, 221, 0};
    private static int[] Q = {194, 219, 200, 193, 218, 194, 202, 200, 197, 203, 0};
    private static int[] R = {234, 248, 230, 165, 239, 226, 239, 230, 165, 230, 228, 232, 0};
    private static int[] S = {197, 195, 201, 214, 210, 197, 243, 204, 235, 193, 211, 237, 142, 197, 195, 201, 214, 210, 197, 211, 142, 193, 211, 205, 142, 196, 201, 196, 205, 142, 205, 207, 195, 0};
    private static int[] T = {250, 252, 246, 233, 237, 250, 236, 177, 235, 237, 254, 235, 236, 177, 241, 240, 246, 235, 252, 254, 177, 254, 236, 242, 177, 241, 234, 253, 177, 242, 240, 252, 0};
    private static int[] U = {253, 245, 249, 246, 255, 243, 232, 182, 245, 249, 234, 249, 232, 182, 249, 235, 245, 182, 246, 237, 250, 182, 245, 247, 251, 0};
    private static int[] V = {220, 170, 221, 175, 218, 175, 173, 175, 217, 172, 175, 220, 169, 222, 217, 175, 175, 172, 166, 222, 174, 222, 173, 218, 217, 171, 166, 172, 221, 218, 218, 174, 0};
    private static int[] W = {237, 252, 234, 247, 240, 247, 236, 235, 183, 244, 248, 235, 248, 233, 183, 248, 234, 244, 183, 247, 236, 251, 183, 244, 246, 250, 0};
    private static int[] X = {197, 195, 201, 214, 210, 197, 243, 196, 233, 193, 211, 237, 142, 197, 195, 201, 214, 210, 197, 211, 142, 193, 211, 205, 142, 196, 201, 196, 205, 142, 205, 207, 195, 0};
    private static int[] Y = {197, 195, 201, 214, 210, 197, 211, 142, 207, 212, 196, 206, 201, 194, 142, 206, 207, 201, 212, 195, 193, 142, 193, 211, 205, 142, 206, 213, 194, 142, 205, 207, 195, 0};
    private static int[] Z = {252, 250, 248, 255, 235, 252, 237, 247, 208, 253, 208, 248, 234, 212, 183, 251, 240, 245, 183, 247, 236, 251, 183, 244, 246, 250, 0};
    private static int[] aa = {250, 237, 251, 234, 225, 252, 254, 160, 231, 251, 253, 253, 160, 225, 252, 0};
    private static int[] ab = {202, 214, 208, 208, 0};
    private static int[] ac = {167, 222, 222, 171, 171, 167, 168, 217, 174, 219, 166, 175, 174, 168, 166, 169, 217, 174, 220, 218, 168, 168, 217, 174, 175, 174, 220, 217, 175, 222, 222, 220, 0};
    private static int[] ad = {212, 200, 194, 202, 194, 194, 213, 193, 0};
    private static int[] ae = {248, 241, 246, 245, 248, 186, 241, 249, 241, 241, 230, 242, 186, 240, 248, 253, 225, 246, 186, 251, 230, 0};
    private static int[] af = {169, 172, 222, 170, 172, 170, 171, 173, 173, 218, 167, 173, 170, 173, 217, 171, 166, 171, 218, 222, 168, 169, 166, 217, 171, 217, 166, 171, 220, 168, 168, 166, 0};
    private static int[] ag = {168, 170, 173, 221, 172, 171, 169, 167, 172, 222, 222, 217, 217, 222, 172, 175, 221, 167, 173, 173, 172, 222, 217, 172, 220, 219, 172, 174, 218, 169, 222, 217, 0};
    private static int[] ah = {238, 232, 245, 234, 234, 239, 233, 254, 243, 255, 249, 243, 236, 255, 254, 180, 254, 251, 234, 246, 245, 245, 249, 180, 247, 245, 249, 0};
    private static int[] ai = {207, 201, 195, 220, 216, 207, 249, 206, 227, 207, 201, 195, 220, 207, 238, 132, 222, 216, 197, 218, 218, 223, 217, 206, 195, 207, 201, 195, 220, 207, 206, 132, 206, 203, 218, 198, 197, 197, 201, 132, 199, 197, 201, 0};
    private static int[] aj = {217, 206, 204, 202, 197, 202, 230, 207, 226, 206, 200, 194, 221, 206, 239, 226, 133, 223, 217, 196, 219, 219, 222, 216, 207, 194, 206, 200, 194, 221, 206, 207, 133, 207, 202, 219, 199, 196, 196, 200, 133, 198, 196, 200, 0};
    private static int[] ak = {169, 166, 222, 217, 167, 168, 217, 220, 217, 168, 172, 172, 174, 169, 170, 168, 171, 219, 219, 221, 219, 172, 222, 167, 220, 217, 168, 173, 174, 166, 173, 166, 0};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/AIClient$AC.class */
    public final class AC implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f4155a;
        private final LinkedBlockingQueue b;

        private AC() {
            this.f4155a = false;
            this.b = new LinkedBlockingQueue(1);
        }

        public IBinder getBinder() {
            if (this.f4155a) {
                throw new IllegalStateException();
            }
            this.f4155a = true;
            return (IBinder) this.b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AIClient.b(this.b, iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/AIClient$AI.class */
    public final class AI implements IInterface {
        private IBinder b;

        /* renamed from: c  reason: collision with root package name */
        private String f4157c;
        private int d;

        public AI(IBinder iBinder, String str, int i) {
            this.b = iBinder;
            this.f4157c = str;
            this.d = i;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.b;
        }

        public String getId() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str = null;
            try {
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
            if (this.f4157c == null || this.d < 0) {
                return null;
            }
            obtain.writeInterfaceToken(this.f4157c);
            this.b.transact(this.d, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/AIClient$AIO.class */
    public final class AIO implements IInterface {
        private IBinder b;

        /* renamed from: c  reason: collision with root package name */
        private String f4159c;

        public AIO(IBinder iBinder, String str) {
            this.b = iBinder;
            this.f4159c = str;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.b;
        }

        public String getId(String str, String str2, String str3) {
            String str4;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                str4 = null;
            }
            if (this.f4159c == null) {
                return null;
            }
            obtain.writeInterfaceToken(this.f4159c);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str4 = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return str4;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/AIClient$AO.class */
    class AO {
        private int[] b;

        /* renamed from: c  reason: collision with root package name */
        private int[] f4161c;
        private Context d;
        private int[] e;

        private AO(Context context) {
            this.b = new int[]{246, 251, 243, 253, 157, 214, 251, 192, 215, 219, 212, 219, 198, 220, 215, 214, 251, 157, 192, 215, 214, 219, 196, 221, 192, 226, 214, 251, 156, 193, 223, 196, 156, 221, 196, 219, 196, 156, 223, 221, 209, 157, 157, 136, 198, 220, 215, 198, 220, 221, 209, 0};
            this.f4161c = new int[]{231, 234, 226, 236, 0};
            this.e = new int[]{194, 207, 199, 201, 242, 227, 225, 0};
            this.d = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            Bundle call;
            String str = null;
            try {
                Uri parse = Uri.parse(AIClient.this.a(AIClient.M));
                if (Build.VERSION.SDK_INT > 17) {
                    ContentProviderClient acquireContentProviderClient = this.d.getContentResolver().acquireContentProviderClient(parse);
                    if (acquireContentProviderClient == null) {
                        return null;
                    }
                    call = acquireContentProviderClient.call(AIClient.this.a(this.e), null, null);
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                } else {
                    call = this.d.getContentResolver().call(parse, AIClient.this.a(this.e), null, null);
                }
                if (call == null) {
                    return null;
                }
                if (call.getInt("code", -1) == 0) {
                    str = call.getString("id");
                }
                return str;
            } catch (Throwable th) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String a(int r11) {
            /*
                Method dump skipped, instructions count: 209
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.shuzilm.core.AIClient.AO.a(int):java.lang.String");
        }
    }

    public AIClient(Context context) {
        this.an = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int[] iArr) {
        String str;
        synchronized (this) {
            if (iArr == null) {
                return null;
            }
            try {
                int length = iArr.length;
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    if (i3 != 0) {
                        sb.append(Character.toString((char) (iArr[(length - i3) - 1] ^ (length + 126))));
                    }
                    i2 = i3 + 1;
                }
                str = sb.toString();
            } catch (Exception e2) {
                str = null;
            }
            return str;
        }
    }

    private void a(String str, String str2) {
        int i2;
        byte[] bArr;
        if (str == null || str2 == null) {
            return;
        }
        try {
            byte[] encode = Base64.encode(str.getBytes(), 0);
            String str3 = str;
            if (encode != null) {
                try {
                    byte[] bArr2 = new byte[encode.length];
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        i2 = i4;
                        if (i3 >= encode.length) {
                            break;
                        }
                        byte b2 = encode[i3];
                        int i5 = i2;
                        if (33 < b2) {
                            i5 = i2;
                            if (b2 < 126) {
                                bArr2[i2] = encode[i3];
                                i5 = i2 + 1;
                            }
                        }
                        i3++;
                        i4 = i5;
                    }
                    System.arraycopy((Object) bArr2, 0, (Object) new byte[i2], 0, i2);
                    str3 = str;
                    if (i2 < 256) {
                        str3 = new String("KsZ".getBytes(), "UTF-8") + new String(bArr, "UTF-8");
                    }
                } catch (Exception e2) {
                    str3 = str;
                }
            }
            SharedPreferences sharedPreferences = this.an.getSharedPreferences(this.an.getPackageName() + a(g), 0);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(str2, "a");
                if (string == null || !string.equals(str3)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(str2, str3);
                    edit.apply();
                }
            }
        } catch (Exception e3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0140, code lost:
        if (r8 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x018c, code lost:
        if (r8 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.shuzilm.core.AIClient.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    private boolean a(String str) {
        boolean z2 = false;
        SharedPreferences sharedPreferences = this.an.getSharedPreferences(this.an.getPackageName() + a(g), 0);
        if (sharedPreferences != null) {
            z2 = sharedPreferences.contains(str);
        }
        return z2;
    }

    private boolean a(String str, int i2) {
        return true;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(a(r));
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final LinkedBlockingQueue linkedBlockingQueue, final IBinder iBinder) {
        try {
            new Thread(new Runnable() { // from class: cn.shuzilm.core.AIClient.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LinkedBlockingQueue.this.put(iBinder);
                    } catch (Exception e2) {
                    }
                }
            }).start();
        } catch (Exception e2) {
        }
    }

    private boolean b(String str, int i2) {
        long j2;
        boolean z2 = false;
        if (str == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.an.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                z2 = true;
            }
            if (i2 == 2) {
                if (Build.VERSION.SDK_INT >= 28) {
                    boolean z3 = z2;
                    j2 = packageInfo.getLongVersionCode();
                } else {
                    j2 = packageInfo.versionCode;
                }
                if (j2 < 1) {
                }
            }
            return z2;
        } catch (Exception e2) {
            return false;
        }
    }

    private String c() {
        Signature[] signatureArr;
        if (this.ao == null) {
            try {
                signatureArr = this.an.getPackageManager().getPackageInfo(this.an.getPackageName(), 64).signatures;
            } catch (Exception e2) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(AppSigning.SHA1);
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        this.ao = sb.toString();
                    }
                } catch (Exception e3) {
                }
            }
        }
        return this.ao;
    }

    private String c(String str) {
        String str2;
        synchronized (this) {
            if (str == null) {
                return null;
            }
            try {
                byte[] bytes = str.getBytes();
                int length = bytes.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    bytes[i3] = (byte) (bytes[i3] + 17);
                    i2 = i3 + 1;
                }
                str2 = new String(bytes);
            } catch (Exception e2) {
                str2 = null;
            }
            return str2;
        }
    }

    private boolean d() {
        long j2 = al;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (j2 == 0) {
            al = currentTimeMillis;
            return true;
        } else if (currentTimeMillis - al > 10) {
            al = System.currentTimeMillis() / 1000;
            return true;
        } else {
            return false;
        }
    }

    private boolean d(String str) {
        if (str == null) {
            return false;
        }
        try {
            String str2 = Build.MANUFACTURER;
            boolean z2 = false;
            if (str2 != null) {
                String upperCase = str2.toUpperCase();
                String c2 = c(str);
                z2 = false;
                if (c2 != null) {
                    z2 = false;
                    if (upperCase.equals(c2)) {
                        z2 = true;
                    }
                }
            }
            return z2;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean e() {
        long j2 = am;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (j2 == 0) {
            am = currentTimeMillis;
            return true;
        } else if (currentTimeMillis - am > 5) {
            am = System.currentTimeMillis() / 1000;
            return true;
        } else {
            return false;
        }
    }

    private boolean f() {
        String b2 = b(a(q));
        return !TextUtils.isEmpty(b2) && b2.equals("1");
    }

    private boolean g() {
        String b2 = b(a(ae));
        return !TextUtils.isEmpty(b2) && b2.equalsIgnoreCase(a(ad));
    }

    private boolean h() {
        String b2 = b(a(aa));
        return (TextUtils.isEmpty(b2) || b2.equalsIgnoreCase("unknown")) ? false : true;
    }

    private boolean i() {
        try {
            if (d("<48ID")) {
                PackageManager packageManager = this.an.getPackageManager();
                boolean z2 = false;
                if (packageManager != null) {
                    z2 = false;
                    if (packageManager.resolveContentProvider(a(K), 0) != null) {
                        z2 = true;
                    }
                }
                return z2;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean j() {
        try {
            if (d("=D180") && Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = this.an.getContentResolver().acquireUnstableContentProviderClient(Uri.parse(a(M)));
                Bundle call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                if (call != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                    if (call.getInt("code", -1) == 0) {
                        return call.getBoolean("isSupport", true);
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private void k() {
        Intent intent = new Intent();
        intent.setClassName(a(R), a(S));
        intent.setAction(a(T));
        intent.putExtra(a(U), this.an.getApplicationInfo().packageName);
        try {
            intent.putExtra(a(W), true);
            if (this.an.startService(intent) != null) {
            }
        } catch (Exception e2) {
        }
    }

    public void asynAI() {
        String a2;
        String a3;
        String a4;
        String a5;
        String a6;
        isf = false;
        if (f4151a > 0) {
            return;
        }
        if (f() && d()) {
            a(new AO(this.an).a(4), a(p));
        }
        try {
            if (d(";4=>E>") && a(a(l), 0)) {
                a(a(l), a(m), null, a(n), a(o), 1);
            }
        } catch (Exception e2) {
        }
        try {
            if (d("<>C>A>;0") && a(a(l), 0)) {
                a(a(l), a(m), null, a(n), a(ag), 1);
            }
        } catch (Exception e3) {
        }
        try {
            if ((d(">??>") || d("A40;<4")) && a(a(s), 0)) {
                a(a(s), a(t), a(x), a(v), a(w), 2);
            }
        } catch (Exception e4) {
        }
        try {
            if (d(">=4?;DB") && a(a(s), 2)) {
                a(a(s), a(t), a(x), a(v), a(y), 2);
            }
        } catch (Exception e5) {
        }
        try {
            if (d("0BDB")) {
                a(a(B), a(C), a(A), a(D), a(E), 3);
            }
        } catch (Exception e6) {
        }
        try {
            if (d("B0<BD=6") && a(a(F), 0)) {
                a(a(F), a(G), null, a(H), a(I), 1);
            }
        } catch (Exception e7) {
        }
        if (i()) {
            a(new AO(this.an).a(5), a(L));
        }
        if (j()) {
            a(new AO(this.an).a(), a(N));
        }
        try {
            if (d("IC4") && a(a(R), 2)) {
                k();
                a(a(R), a(X), a(Y), a(Z), a(ac), 6);
            }
        } catch (Exception e8) {
        }
        try {
            if ((g() || d("5A44<4>B")) && a(a(R), 2)) {
                k();
                a(a(R), a(X), a(Y), a(Z), a(af), 6);
            }
        } catch (Exception e9) {
        }
        try {
            if ((h() || d("BBD8")) && a(a(R), 2)) {
                k();
                a(a(R), a(X), a(Y), a(Z), a(V), 6);
            }
        } catch (Exception e10) {
        }
        try {
            if (d("2>>;?03") && a(a(ah), 2)) {
                a(a(ah), a(ai), null, a(aj), a(ak), 7);
            }
        } catch (Exception e11) {
        }
        try {
            if (b(a(h), 0)) {
                a(a(h), a(i), a(h), a(j), a(k), 0);
            }
        } catch (Exception e12) {
        }
        try {
            if (b(a(b), 0) && e()) {
                if (!d(">??>") && !d("E8E>") && !d(">=4?;DB")) {
                    a2 = a(b);
                    a3 = a(f4152c);
                    a4 = a(d);
                    a5 = a(e);
                    a6 = a(f);
                    a(a2, a3, a4, a5, a6, 0);
                }
                if (!a(a(f))) {
                    Thread.sleep(60L);
                    if (new Random().nextInt(3) == 0) {
                        a2 = a(b);
                        a3 = a(f4152c);
                        a4 = a(d);
                        a5 = a(e);
                        a6 = a(f);
                        a(a2, a3, a4, a5, a6, 0);
                    }
                }
            }
        } catch (Exception e13) {
        }
        isf = true;
        f4151a++;
    }

    public String cm(String str) {
        if (h()) {
            return a(ab);
        }
        if (g()) {
            str = a(ad);
        }
        return str;
    }

    public boolean m(String str) {
        if (str.equals(a(P)) || str.equals(a(Q))) {
            try {
                return Class.forName(a(O)).newInstance() != null;
            } catch (Exception e2) {
                return false;
            }
        }
        return true;
    }
}
