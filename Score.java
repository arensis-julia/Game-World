public class Score {
    private int score;
    private int rank;
    private String updateTime;

    public Score(int _score, int _rank, String _updateTime) {
        score = _score;
        rank = _rank;
        updateTime = _updateTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int _score) {
        score = _score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int _rank) {
        rank = _rank;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String _updateTime) {
        updateTime = _updateTime;
    }
}