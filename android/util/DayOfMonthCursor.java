package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/DayOfMonthCursor.class */
public class DayOfMonthCursor extends MonthDisplayHelper {
    private int mColumn;
    private int mRow;

    public DayOfMonthCursor(int i, int i2, int i3, int i4) {
        super(i, i2, i4);
        this.mRow = getRowOf(i3);
        this.mColumn = getColumnOf(i3);
    }

    public boolean down() {
        if (isWithinCurrentMonth(this.mRow + 1, this.mColumn)) {
            this.mRow++;
            return false;
        }
        nextMonth();
        this.mRow = 0;
        while (!isWithinCurrentMonth(this.mRow, this.mColumn)) {
            this.mRow++;
        }
        return true;
    }

    public int getSelectedColumn() {
        return this.mColumn;
    }

    public int getSelectedDayOfMonth() {
        return getDayAt(this.mRow, this.mColumn);
    }

    public int getSelectedMonthOffset() {
        if (isWithinCurrentMonth(this.mRow, this.mColumn)) {
            return 0;
        }
        return this.mRow == 0 ? -1 : 1;
    }

    public int getSelectedRow() {
        return this.mRow;
    }

    public boolean isSelected(int i, int i2) {
        return this.mRow == i && this.mColumn == i2;
    }

    public boolean left() {
        if (this.mColumn == 0) {
            this.mRow--;
            this.mColumn = 6;
        } else {
            this.mColumn--;
        }
        if (isWithinCurrentMonth(this.mRow, this.mColumn)) {
            return false;
        }
        previousMonth();
        int numberOfDaysInMonth = getNumberOfDaysInMonth();
        this.mRow = getRowOf(numberOfDaysInMonth);
        this.mColumn = getColumnOf(numberOfDaysInMonth);
        return true;
    }

    public boolean right() {
        if (this.mColumn == 6) {
            this.mRow++;
            this.mColumn = 0;
        } else {
            this.mColumn++;
        }
        if (isWithinCurrentMonth(this.mRow, this.mColumn)) {
            return false;
        }
        nextMonth();
        this.mRow = 0;
        this.mColumn = 0;
        while (!isWithinCurrentMonth(this.mRow, this.mColumn)) {
            this.mColumn++;
        }
        return true;
    }

    public void setSelectedDayOfMonth(int i) {
        this.mRow = getRowOf(i);
        this.mColumn = getColumnOf(i);
    }

    public void setSelectedRowColumn(int i, int i2) {
        this.mRow = i;
        this.mColumn = i2;
    }

    public boolean up() {
        if (isWithinCurrentMonth(this.mRow - 1, this.mColumn)) {
            this.mRow--;
            return false;
        }
        previousMonth();
        this.mRow = 5;
        while (!isWithinCurrentMonth(this.mRow, this.mColumn)) {
            this.mRow--;
        }
        return true;
    }
}
