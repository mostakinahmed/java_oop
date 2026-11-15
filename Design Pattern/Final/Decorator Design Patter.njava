
interface Coffee {
    String getDescription();

    int cost();
}

class PlainCoffee implements Coffee {
    public String getDescription() {
        return "Plain Coffee";
    }

    public int cost() {
        return 5;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

}

class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    public int cost() {
        return decoratedCoffee.cost() + 5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    public int cost() {
        return decoratedCoffee.cost() + 10;
    }
}

class Main {
    public static void main(String[] args) {
        Coffee coffee;

        coffee = new PlainCoffee();
        System.out.println("Order: " + coffee.getDescription() + " , " + "cost: " + coffee.cost());

        coffee = new MilkDecorator(new SugarDecorator(new PlainCoffee()));
        System.out.println("Order: " + coffee.getDescription() + " , " + "cost: " + coffee.cost());
    }
}