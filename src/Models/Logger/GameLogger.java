package Models.Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.*;

public class GameLogger {
    FileHandler fh;
    SimpleFormatter sf;
    Logger logger;
    static GameLogger gameLogger;

    static {
        try {
            gameLogger = new GameLogger();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private GameLogger() throws IOException {
        fh = new FileHandler("Log.txt", true);
        fh.setFormatter(new GameLogFormatter());
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setUseParentHandlers(false);
        logger.addHandler(fh);
        logger.setLevel(Level.ALL);
    }

    public static GameLogger getInstance() {
        return gameLogger;
    }


    public void addLog(String level, String message) {
        switch (level.toLowerCase()) {
            case "config":
                logger.config(message);
                break;
            case "severe":
                logger.severe(message);
                break;
            case "warning":
                logger.warning(message);
                break;
            case "info":
                logger.info(message);
                break;
            case "fine":
                logger.fine(message);
                break;
            case "finer":
                logger.finer(message);
                break;
            default:
                logger.finest(message);
        }
    }

}
