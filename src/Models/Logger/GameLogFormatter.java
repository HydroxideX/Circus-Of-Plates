package Models.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class GameLogFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        StringBuffer s = new StringBuffer();
        s.append("[ " + record.getLevel() + " ]");
        s.append(" " + calcDate(record.getMillis()) + " ");
        s.append(formatMessage(record) + "\n");

        return s.toString();
    }

    private String calcDate(long millisecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("MM\\dd\\yyyy , HH:mm : ");
        Date resultdate = new Date(millisecs);
        return date_format.format(resultdate);
    }
}
