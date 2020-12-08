package me.woutergritter.tetrisscoreboard;

public class ScoreboardEntry {
    private final String name;
    private final int score;
    private final int level;

    public ScoreboardEntry(String name, int score, int level) {
        this.name = name;
        this.score = score;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "ScoreboardEntry{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", level=" + level +
                '}';
    }
}
