abstract class Bevrage{
    protected int cost = 0;

    public abstract String getDesctiption();
    public abstract int getCost();
    public abstract void setCost(int cost);

}

class DarkCoffee extends Bevrage{
    protected int cost = 100;

    @Override
    public String getDesctiption() {
        return ("Dark Coffee is coffe that is dark");
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public void setCost(int cost){
        this.cost = cost;
    }
}

class Mocha extends Bevrage{
    protected int cost = 150;

    @Override
    public String getDesctiption() {
        return "Mocha hai mere bete";
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }
}

// No need to add getCost() and getDescription() and setCost() as AddOn class extends Bevrage
//Decorator class
abstract class AddOn extends Bevrage{
    protected Bevrage bevrage;
}

class Caramel extends AddOn{

    protected int cost = 50;

    public Caramel(Bevrage bevrage){
        this.bevrage = bevrage;
    }

    @Override
    public String getDesctiption() {
        return (bevrage.getDesctiption()+" ## with add on Caramel");
    }

    @Override
    public int getCost() {
        return (bevrage.getCost()+this.cost);
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }
}

class Chocolate extends AddOn{

    int cost = 30;

    public Chocolate(Bevrage bevrage){
        this.bevrage = bevrage;
    }

    @Override
    public String getDesctiption() {
        return (bevrage.getDesctiption()+" ## with add on Chocolate");
    }

    @Override
    public int getCost() {
        return (bevrage.getCost()+this.cost);
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }
}



public class DecoratorPattern {
    public static void main(String args[]){
        AddOn choc_mocha = new Chocolate(new Mocha());
        System.out.println(choc_mocha.getCost());

        AddOn caramel_choc_mocha = new Caramel(choc_mocha);
        System.out.println(caramel_choc_mocha.getCost());
    }
}
