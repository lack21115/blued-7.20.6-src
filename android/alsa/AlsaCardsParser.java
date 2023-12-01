package android.alsa;

import android.util.Slog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/* loaded from: source-9557208-dex2jar.jar:android/alsa/AlsaCardsParser.class */
public class AlsaCardsParser {
    private static final String TAG = "AlsaCardsParser";
    private static LineTokenizer tokenizer_ = new LineTokenizer(" :[]");
    private Vector<AlsaCardRecord> cardRecords_ = new Vector<>();

    /* loaded from: source-9557208-dex2jar.jar:android/alsa/AlsaCardsParser$AlsaCardRecord.class */
    public class AlsaCardRecord {
        public int mCardNum = -1;
        public String mField1 = "";
        public String mCardName = "";
        public String mCardDescription = "";

        public AlsaCardRecord() {
        }

        public boolean parse(String str, int i) {
            int nextToken;
            if (i == 0) {
                int nextToken2 = AlsaCardsParser.tokenizer_.nextToken(str, AlsaCardsParser.tokenizer_.nextDelimiter(str, AlsaCardsParser.tokenizer_.nextToken(str, 0)));
                int nextDelimiter = AlsaCardsParser.tokenizer_.nextDelimiter(str, nextToken2);
                this.mField1 = str.substring(nextToken2, nextDelimiter);
                this.mCardName = str.substring(AlsaCardsParser.tokenizer_.nextToken(str, nextDelimiter));
                return true;
            } else if (i != 1 || (nextToken = AlsaCardsParser.tokenizer_.nextToken(str, 0)) == -1) {
                return true;
            } else {
                this.mCardDescription = str.substring(nextToken);
                return true;
            }
        }

        public String textFormat() {
            return this.mCardName + " : " + this.mCardDescription;
        }
    }

    public void Log() {
        int numCardRecords = getNumCardRecords();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= numCardRecords) {
                return;
            }
            Slog.w(TAG, "usb:" + getCardRecordAt(i2).textFormat());
            i = i2 + 1;
        }
    }

    public AlsaCardRecord getCardRecordAt(int i) {
        return this.cardRecords_.get(i);
    }

    public int getNumCardRecords() {
        return this.cardRecords_.size();
    }

    public void scan() {
        this.cardRecords_.clear();
        try {
            FileReader fileReader = new FileReader(new File("/proc/asound/cards"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    fileReader.close();
                    return;
                }
                AlsaCardRecord alsaCardRecord = new AlsaCardRecord();
                alsaCardRecord.parse(readLine, 0);
                alsaCardRecord.parse(bufferedReader.readLine(), 1);
                this.cardRecords_.add(alsaCardRecord);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
