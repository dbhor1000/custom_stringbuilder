public class Main {
    public static void main(String[] args) {

        //Можно переходить на заданное количество шагов вперед или назад. После выполнения одного или нескольких переходов,
        //при последующем сложении строк база обнуляется и получившаяся после сложения строка становится первой.
        //Можно было бы (развить эту прекрасную идею в отдельное приложение $$$) добавить выброс ошибок, если указано
        //ошибочное количество шагов для перехода, но пока что не стал этого делать. :|

        MyStringBuilder one = new MyStringBuilder();
        one.append("Append once");
        one.append(" Save");
        System.out.println(one);
        one.append(" More");
        one.append(" More");
        one.append(" And More");
        System.out.println(one);
        System.out.println(one);
        one.append(" More");
        one.append(" More");
        one.append(" And More");
        System.out.println(one);
        System.out.println(one);
        one.navigateSnapshotsSteps(-7L);
        System.out.println(one);
        one.navigateSnapshotsSteps(1L);
        System.out.println(one);
        one.navigateSnapshotsSteps(3L);
        System.out.println(one);
        one.append(" All clear?");
        one.append(" Let us check!");
        System.out.println(one);
        one.navigateSnapshotsSteps(-1L);
        System.out.println(one);
        one.navigateSnapshotsSteps(1L);
        System.out.println(one);
    }
}