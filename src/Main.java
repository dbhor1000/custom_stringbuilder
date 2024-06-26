public class Main {
    public static void main(String[] args) {

        //Вроде бы ничем не отличается от отмены операции в Windows через Ctrl-Z.
        //Можно было бы (развить эту прекрасную идею в отдельное приложение $$$) добавить выброс ошибок, если указано
        //ошибочное количество шагов для перехода, но пока что не стал этого делать. :|

        MyStringBuilder one = new MyStringBuilder();
        one.append("1");
        one.append(" 2");
        one.append(" 3");
        one.append(" 4");
        one.append(" 5");
        one.navigateSnapshotsSteps(-3L);
        System.out.println(one);
        one.append(" 6");
        one.append(" 7");
        System.out.println(one);
        one.navigateSnapshotsSteps(-1L);
        System.out.println(one);
        one.append(" 8");
        one.append(" 9");
        one.append(" 10");
        System.out.println(one);
        one.navigateSnapshotsSteps(-5L);
        System.out.println(one);



    }
}