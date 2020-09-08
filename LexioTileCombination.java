import java.util.*;

public class LexioTileCombination {
    private ArrayList<LexioTile> combination = new ArrayList<LexioTile>();
    private LexioRank rank = null;

    public LexioTileCombination() {
        combination = new ArrayList<LexioTile>();
        rank = null;
    }

    public LexioTileCombination(ArrayList<LexioTile> _combination, LexioRank _rank) {
        combination = _combination;
        rank = _rank;
    }

    public ArrayList<LexioTile> getCombination() {
        return combination;
    }

    public void setCombination(ArrayList<LexioTile> _combination) {
        combination = _combination;
    }

    public LexioRank getRank() {
        return rank;
    }

    public void setRank(LexioRank _rank) {
        rank = _rank;
    }
}