package rf_lab6;

public class GradeDiff<X, Y> {
    public final X x;
    public final Y y;
    public GradeDiff(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

}