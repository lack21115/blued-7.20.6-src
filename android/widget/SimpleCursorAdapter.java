package android.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;

/* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleCursorAdapter.class */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleCursorAdapter$CursorToStringConverter.class */
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleCursorAdapter$ViewBinder.class */
    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i);
    }

    @Deprecated
    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.mStringConversionColumn = -1;
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.mStringConversionColumn = -1;
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }

    private void findColumns(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            this.mFrom = null;
            return;
        }
        int length = strArr.length;
        if (this.mFrom == null || this.mFrom.length != length) {
            this.mFrom = new int[length];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mFrom[i2] = cursor.getColumnIndexOrThrow(strArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.mViewBinder;
        int length = this.mTo.length;
        int[] iArr = this.mFrom;
        int[] iArr2 = this.mTo;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            View findViewById = view.findViewById(iArr2[i2]);
            if (findViewById != null) {
                boolean z = false;
                if (viewBinder != null) {
                    z = viewBinder.setViewValue(findViewById, cursor, iArr[i2]);
                }
                if (z) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i2]);
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
        this.mOriginalFrom = strArr;
        this.mTo = iArr;
        findColumns(cursor, this.mOriginalFrom);
        super.changeCursor(cursor);
    }

    @Override // android.widget.CursorAdapter, android.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        return this.mCursorToStringConverter != null ? this.mCursorToStringConverter.convertToString(cursor) : this.mStringConversionColumn > -1 ? cursor.getString(this.mStringConversionColumn) : super.convertToString(cursor);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.mCursorToStringConverter = cursorToStringConverter;
    }

    public void setStringConversionColumn(int i) {
        this.mStringConversionColumn = i;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
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

    @Override // android.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        findColumns(cursor, this.mOriginalFrom);
        return super.swapCursor(cursor);
    }
}
