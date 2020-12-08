package me.woutergritter.tetrisscoreboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class TetrisScoreboard {
    private static final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-,                                         /              ()              \".                                                                                                                                                ".toCharArray();

    private ScoreboardEntry[] a_entries;
    private ScoreboardEntry[] b_entries;

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


// alphabet:
// DEC HEX LET
// 10  0A  A
// 11  0B  B
// 12  0C  C
// 13  0D  D
// 14  0E  E
// 15  0F  F
// 16  10  G
// 17  11  H
// 18  12  I
// 19  13  J
// 20  14  K
// 21  15  L
// 22  16  M
// 23  17  N
// 24  18  O
// 25  19  P
// 26  1A  Q
// 27  1B  R
// 28  1C  S
// 29  1D  T
// 30  1E  U
// 31  1F  V
// 32  20  W
// 33  21  X
// 34  22  Y
// 35  23  Z
// 255 FF  -
//
// NAMES
// Names are 6 bytes long and are saved as per the alphabet above ^.
//
// Ranges:
// 50 - 55:  A pos 1 name
// 56 - 5B:  A pos 2 name
// 5C - 61:  A pos 3 name
//
// 68 - 6D:  B pos 1 name
// 6E - 73:  B pos 2 name
// 74 - 79:  B pos 3 name
//
//
//
// SCORES
// Scores are saved as a literal dec <> hex transformation.
// Examples:
// 0x01: "01"
// 0x99: "99"
// 0xAB: "AB"
// 0xFF: "FF"
//
// Ranges:
// 00 - 02:  A pos 1 score
// 03 - 05:  A pos 2 score
// 06 - 08:  A pos 3 score
//
// 0C - 0E:  B pos 1 score
// 0F - 11:  B pos 2 score
// 12 - 14:  B pos 3 score
//
//
//
// LEVELS
// Levels are stored as the actual value.
//
// Ranges:
// 18:       A pos 1 level
// 19:       A pos 2 level
// 1A:       A pos 3 level
//
// 1C:       B pos 1 level
// 1D:       B pos 2 level
// 1E:       B pos 3 level
