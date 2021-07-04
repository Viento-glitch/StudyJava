package StudyJavaRush.Shop;

class Plant {
    private String name;
    private String tip;
    private int pricePerKilogram;
    private int kilograms;
    private int price = pricePerKilogram * kilograms;
    private boolean bayed;

    public Plant(Plant plant) {
        this.name = plant.getName();
        this.tip = plant.getTip();
        this.pricePerKilogram = plant.getPricePerKilogram();
        this.kilograms = plant.getKilograms();
        this.bayed = plant.isBayed();

    }

    public boolean isBayed() {
        return bayed;
    }

    public void setBayed(boolean bayed) {
        this.bayed = bayed;
    }

    public Plant(String name, String tip, int pricePerKilogram, int kilograms, boolean bayed) {
        this.name = name;
        this.tip = tip;
        this.pricePerKilogram = pricePerKilogram;
        this.kilograms = kilograms;
        this.bayed = bayed;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerKilogram() {
        return pricePerKilogram;
    }

    public void setPricePerKilogram(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public int getKilograms() {
        return kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    public int getPrice() {
        return price;
    }
}