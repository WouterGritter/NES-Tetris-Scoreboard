package me.woutergritter.tetrisscoreboard;

import java.util.Objects;

public class ScoreboardEntry {
    private final String name;
    private final int score;
    private final int level;

    protected ScoreboardEntry(String name, int score, int level) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreboardEntry that = (ScoreboardEntry) o;
        return score == that.score &&
                level == that.level &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, level);
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
