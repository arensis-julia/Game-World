import java.util.*;

public class LexioPlayer implements Comparable <LexioPlayer> {
    private User user;
    private int chips = 64;
    private ArrayList<LexioTile> hands = new ArrayList<LexioTile>();
    public final boolean isComputer;

    public LexioPlayer(User _user, boolean _isComputer) {
        user = _user;
        isComputer = _isComputer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User _user) {
        user = _user;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int _chips) {
        chips = _chips;
    }

    public void addChips(int _chips) {
        chips += _chips;
    }

    public void removeChips(int _chips) {
        chips -= _chips;
    }

    public ArrayList<LexioTile> getHands() {
        return hands;
    }

    public void setHands(ArrayList<LexioTile> _hands) {
        hands = _hands;
    }

    public void addHands(LexioTile t) {
        hands.add(t);
    }

    public void removeHands(LexioTile t) {
        hands.remove(t);
    }

    public int compareTo(LexioPlayer user) {
        if(this.hands.size() > user.getHands().size())    return 1;
        else if(this.hands.size() == user.getHands().size())  return 0;
        else    return -1;
    }
}