package me.woutergritter.tetrisscoreboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class TetrisScoreboard {
    private static final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-,                                         /              ()              \".                                                                                                                                                ".toCharArray();

    private ScoreboardEntry[] a_entries = null;
    private ScoreboardEntry[] b_entries = null;

    public TetrisScoreboard() {
    }

    public void load(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);

        byte[] buf = new byte[256];
        int bytesRead = fis.read(buf);

        fis.close();

        if(bytesRead < 176) {
            throw new IllegalStateException("The file is too small.");
        }

        a_entries = new ScoreboardEntry[] {
                readScoreboardEntry(buf, 0x50, 0x00, 0x18), // #1
                readScoreboardEntry(buf, 0x56, 0x03, 0x19), // #2
                readScoreboardEntry(buf, 0x5C, 0x06, 0x1A)  // #3
        };

        b_entries = new ScoreboardEntry[] {
                readScoreboardEntry(buf, 0x68, 0x0C, 0x1C), // #1
                readScoreboardEntry(buf, 0x6E, 0x0F, 0x1D), // #2
                readScoreboardEntry(buf, 0x74, 0x12, 0x1E)  // #3
        };
    }

    public ScoreboardEntry[] getAEntries() {
        return a_entries;
    }

    public ScoreboardEntry[] getBEntries() {
        return b_entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TetrisScoreboard that = (TetrisScoreboard) o;
        return Arrays.equals(a_entries, that.a_entries) &&
                Arrays.equals(b_entries, that.b_entries);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(a_entries);
        result = 31 * result + Arrays.hashCode(b_entries);
        return result;
    }

    @Override
    public String toString() {
        return "TetrisScoreboard{" +
                "a_entries=" + Arrays.toString(a_entries) +
                ", b_entries=" + Arrays.toString(b_entries) +
                '}';
    }

    private static ScoreboardEntry readScoreboardEntry(byte[] buf, int nameIndex, int scoreIndex, int levelIndex) {
        String name = readName(buf, nameIndex);
        int score = readScore(buf, scoreIndex);
        int level = readLevel(buf, levelIndex);

        return new ScoreboardEntry(name, score, level);
    }

    private static String readName(byte[] buf, int index) {
        char[] name = new char[6];
        for(int i = 0; i < 6; i++) {
            name[i] = ALPHABET[buf[index + i] & 0xFF];
        }

        return new String(name);
    }

    private static int readScore(byte[] buf, int index) {
        StringBuilder scoreStr = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            String nums = Integer.toString(buf[index + i] & 0xFF, 16);
            if(nums.length() == 1) {
                scoreStr.append('0');
            }

            scoreStr.append(nums);
        }

        return Integer.parseInt(scoreStr.toString());
    }

    private static int readLevel(byte[] buf, int index) {
        return buf[index];
    }
}
