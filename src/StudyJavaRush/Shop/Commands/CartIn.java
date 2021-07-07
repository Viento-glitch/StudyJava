package StudyJavaRush.Shop.Commands;

Public class CartIn implements CommandInterface {

    public List<String> getNames() {
        return Arrays.asList("cart.in");
    }

    public void execut(){
    if (!cart.isEmpty()) {
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getName() + " " + cart.get(i).getKilograms() + "кг");}
                } else {
                    System.out.println("Корзина пуста");
    }
}
