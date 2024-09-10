public class Main {
    public static void main(String[] args) {
        OrderedList gamers = new OrderedList();
        gamers.add(new Gamer("Marcos", 50));
        gamers.add(new Gamer("Luis", 12350));
        gamers.add(new Gamer("Mathias", 51));
        gamers.add(new Gamer("Grazi", 2));
        gamers.add(new Gamer("Jubileu", 5121));

        System.out.println(gamers);
        gamers.remove(2);
        System.out.println(gamers.get(0));
        System.out.println(gamers);
    }
}
