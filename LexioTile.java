public class LexioTile implements Comparable <LexioTile> {
    private LexioSymbol symbol;
    private int num;

    public LexioTile(LexioSymbol _symbol, int _num) {
        symbol = _symbol;
        num = _num;
    }

    public LexioSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(LexioSymbol _symbol) {
        symbol = _symbol;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int _num) {
        num = _num;
    }

    public int compareTo(LexioTile tile) {
        if(this.num > tile.getNum())    return 1;
        else if((this.num == tile.getNum()) && (this.symbol.ordinal() > tile.getSymbol().ordinal()))    return 1;
        else    return -1;
    }
}