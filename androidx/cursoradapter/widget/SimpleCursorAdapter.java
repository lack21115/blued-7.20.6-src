package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: source-8756600-dex2jar.jar:androidx/cursoradapter/widget/SimpleCursorAdapter.class */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    protected int[] j;
    protected int[] k;
    String[] l;
    private int m;
    private CursorToStringConverter n;
    private ViewBinder o;

    /* loaded from: source-8756600-dex2jar.jar:androidx/cursoradapter/widget/SimpleCursorAdapter$CursorToStringConverter.class */
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/cursoradapter/widget/SimpleCursorAdapter$ViewBinder.class */
    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i);
    }

    @Deprecated
    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.m = -1;
        this.k = iArr;
        this.l = strArr;
        a(cursor, strArr);
    }

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.m = -1;
        this.k = iArr;
        this.l = strArr;
        a(cursor, strArr);
    }

    private void a(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            this.j = null;
            return;
        }
        int length = strArr.length;
        int[] iArr = this.j;
        if (iArr == null || iArr.length != length) {
            this.j = new int[length];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.j[i2] = cursor.getColumnIndexOrThrow(strArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.o;
        int[] iArr = this.k;
        int length = iArr.length;
        int[] iArr2 = this.j;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            View findViewById = view.findViewById(iArr[i2]);
            if (findViewById != null) {
                if (viewBinder != null ? viewBinder.setViewValue(findViewById, cursor, iArr2[i2]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i2]);
                    String str = string;
                    if (string == null) {
                        str = "";
                    }
                    if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, str);
                    } else if (!(findViewById instanceof ImageView)) {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                    } else {
                        setViewImage((ImageView) findViewById, str);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        this.l = strArr;
        this.k = iArr;
        a(cursor, strArr);
        super.changeCursor(cursor);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.n;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int i = this.m;
        return i > -1 ? cursor.getString(i) : super.convertToString(cursor);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.n;
    }

    public int getStringConversionColumn() {
        return this.m;
    }

    public ViewBinder getViewBinder() {
        return this.o;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.n = cursorToStringConverter;
    }

    public void setStringConversionColumn(int i) {
        this.m = i;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.o = viewBinder;
    }

    public void setViewImage(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        a(cursor, this.l);
        return super.swapCursor(cursor);
    }
}
