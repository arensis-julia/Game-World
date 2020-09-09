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
        // 1
        if(this.num == 1 && (tile.getNum() > 2 || (tile.getNum() == 1 && this.symbol.ordinal() > tile.getSymbol().ordinal())))  return 1;
        else if(tile.getNum() == 1 && (this.num > 2 || (this.num == 1 && tile.getSymbol().ordinal() > this.symbol.ordinal())))  return -1;
        // 2
        else if(this.num == 2 && (tile.getNum() > 2 || tile.getNum() == 1 || (tile.getNum() == 2 && this.symbol.ordinal() > tile.getSymbol().ordinal())))    return 1;
        else if(tile.getNum() == 2 && (this.num> 2 || this.num == 1 || (this.num== 2 && tile.getSymbol().ordinal() > this.symbol.ordinal())))    return -1;
        // else
        else if(this.num > tile.getNum())    return 1;
        else if((this.num == tile.getNum()) && (this.symbol.ordinal() > tile.getSymbol().ordinal()))    return 1;
        else    return -1;
    }
}