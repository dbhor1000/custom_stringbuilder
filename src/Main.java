public class Main {
    public static void main(String[] args) {

        MyStringBuilder one = new MyStringBuilder();
        one.append("Append once");
        one.append(" Save");
        System.out.println(one);
        one.hitSave();
        one.append(" More");
        one.append(" More");
        one.append(" And More");
        System.out.println(one);
        one.hitUndo();
        System.out.println(one);
        one.append(" More");
        one.append(" More");
        one.append(" And More");
        System.out.println(one);
        one.hitUndo();
        System.out.println(one);
    }
}