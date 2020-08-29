public enum LexioSymbol {
    /* CLOUD: cyan, STAR: yellow, MOON: green, SUN: red */
    CLOUD("\u2601", "\033[36m"), STAR("\u2605", "\033[33m"), MOON("\u262A", "\033[32m"), SUN("\u2600", "\033[31m");

    private final String img;
    private final String color;

    private LexioSymbol(String img, String color) {
        this.img = img;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getColorEnd() {
        return "\033[0m";
    }

    public String getImg() {
        return color + img + "\033[0m";
    }
}