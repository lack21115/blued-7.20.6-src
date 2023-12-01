package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontProvider.class */
public class FontProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<byte[]> f2480a = new Comparator<byte[]>() { // from class: androidx.core.provider.FontProvider.1
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v19, types: [int] */
        /* JADX WARN: Type inference failed for: r0v21, types: [int] */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            byte b;
            byte b2;
            if (bArr.length != bArr2.length) {
                b = bArr.length;
                b2 = bArr2.length;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bArr.length) {
                        return 0;
                    }
                    if (bArr[i2] != bArr2[i2]) {
                        byte b3 = bArr[i2];
                        byte b4 = bArr2[i2];
                        b = b3;
                        b2 = b4;
                        break;
                    }
                    i = i2 + 1;
                }
            }
            return b - b2;
        }
    };

    private FontProvider() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ProviderInfo a(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (!resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        } else {
            List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, f2480a);
            List<List<byte[]>> a3 = a(fontRequest, resources);
            for (int i = 0; i < a3.size(); i++) {
                ArrayList arrayList = new ArrayList(a3.get(i));
                Collections.sort(arrayList, f2480a);
                if (a(a2, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FontsContractCompat.FontFamilyResult a(Context context, FontRequest fontRequest, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), fontRequest, context.getResources());
        return a2 == null ? FontsContractCompat.FontFamilyResult.a(1, null) : FontsContractCompat.FontFamilyResult.a(0, query(context, fontRequest, a2.authority, cancellationSignal));
    }

    private static List<List<byte[]>> a(FontRequest fontRequest, Resources resources) {
        return fontRequest.getCertificates() != null ? fontRequest.getCertificates() : FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= signatureArr.length) {
                return arrayList;
            }
            arrayList.add(signatureArr[i2].toByteArray());
            i = i2 + 1;
        }
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return true;
            }
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    static FontsContractCompat.FontInfo[] query(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath(ContentResolver.SCHEME_FILE).build();
        Cursor cursor = null;
        try {
            String[] strArr = new String[7];
            strArr[0] = "_id";
            strArr[1] = FontsContractCompat.Columns.FILE_ID;
            strArr[2] = FontsContractCompat.Columns.TTC_INDEX;
            strArr[3] = FontsContractCompat.Columns.VARIATION_SETTINGS;
            strArr[4] = FontsContractCompat.Columns.WEIGHT;
            strArr[5] = FontsContractCompat.Columns.ITALIC;
            strArr[6] = FontsContractCompat.Columns.RESULT_CODE;
            cursor = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(build, strArr, "query = ?", new String[]{fontRequest.getQuery()}, null, cancellationSignal) : context.getContentResolver().query(build, strArr, "query = ?", new String[]{fontRequest.getQuery()}, null);
            ArrayList arrayList2 = arrayList;
            if (cursor != null) {
                arrayList2 = arrayList;
                if (cursor.getCount() > 0) {
                    Cursor cursor2 = cursor;
                    int columnIndex = cursor.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);
                    Cursor cursor3 = cursor;
                    ArrayList arrayList3 = new ArrayList();
                    Cursor cursor4 = cursor;
                    int columnIndex2 = cursor.getColumnIndex("_id");
                    Cursor cursor5 = cursor;
                    int columnIndex3 = cursor.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                    Cursor cursor6 = cursor;
                    int columnIndex4 = cursor.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                    Cursor cursor7 = cursor;
                    int columnIndex5 = cursor.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                    Cursor cursor8 = cursor;
                    int columnIndex6 = cursor.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                    while (true) {
                        cursor = cursor;
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        arrayList3.add(FontsContractCompat.FontInfo.a(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, columnIndex != -1 ? cursor.getInt(columnIndex) : 0));
                    }
                    arrayList2 = arrayList3;
                }
            }
            return (FontsContractCompat.FontInfo[]) arrayList2.toArray(new FontsContractCompat.FontInfo[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
