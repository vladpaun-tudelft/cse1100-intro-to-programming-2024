public class FruitApplication {

    /**
     * Adds a few fruits to a FruitBasket and prints the total cost.
     *
     * @param args
     */
    public static void main(String[] args) {
        Fruit apple = new Fruit("Apple", 0.9);
        Fruit banana = new Fruit("Banana", 1.20);
        Fruit mango = new Fruit("Mango", 3.10);

        FruitBasket basket = new FruitBasket(5);
        basket.addFruit(apple);
        basket.addFruit(banana);
        basket.addFruit(mango);

        System.out.println("Total cost: " + basket.calculatePrice());
    }

}
