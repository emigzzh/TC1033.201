package gui;

public class DummyMaker {
    private String name;
    private String region;
    private String type1;
    private String type2;
    private int hp;
    private int defense;
    private int speed;
    private double weight;
	private double height;
    private String rarity;


	public DummyMaker(String name, String region, String type1, String type2, int hp, 
    		int defense, int speed, double weight, double height, String rarity) {
        this.name = name;
        this.region = region;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.defense = defense;
        this.speed = speed;
        this.weight = weight;
        this.height = height;
        this.rarity = rarity;
    }

    public String getName() {
        return name; }

    public String getRegion() {
        return region; }

    public String getType1() {
        return type1; }

    public String getType2() {
        return type2; }

    public String getHp() {
        return String.valueOf(hp); }

    public String getDefense() {
        return String.valueOf(defense); }

    public String getSpeed() {
        return String.valueOf(speed); }
    
    public String getWeight() {
		return String.valueOf(weight); }

	public String getHeight() {
		return String.valueOf(height); }

	public String getRarity() {
		return rarity; }
}
