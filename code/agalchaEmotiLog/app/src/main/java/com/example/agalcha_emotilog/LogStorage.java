package com.example.agalcha_emotilog;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * LogStorage
 * This is a simple shared storage class that keeps all logs in memory.
 * Each log is saved as "emotion @ timestamp".

 * Why this design:
 *   It’s static so that all fragments can access it easily without passing data around.
 *   It avoids the complexity of setting up a database.

 * Notes / Issues:
 *   Data is lost when the app closes (no permanent storage).
 *   If the app got bigger, this design wouldn’t scale.
 */

public class LogStorage {
    private static ArrayList<String> logs = new ArrayList<>();

    public static void addLog(String emotion, String timestamp) {
        logs.add(emotion + " @ " + timestamp);
    }

    public static ArrayList<String> getLogs() {
        return logs;
    }

    public static HashMap<String, Integer> getSummary() {
        HashMap<String, Integer> map = new HashMap<>();
        for (String log : logs) {
            String emotion = log.split(" @ ")[0];
            map.put(emotion, map.getOrDefault(emotion, 0) + 1);
        }
        return map;
    }
}
