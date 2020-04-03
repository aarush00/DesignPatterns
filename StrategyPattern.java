


interface Strategy{
    public int doOperation(int a, int b);
}


class OperationAdd implements Strategy{
    @Override
    public int doOperation(int a, int b) {
        return a+b;
    }
}

class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int a, int b){
        return a*b;
    }
}


class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b){
        return strategy.doOperation(a,b);
    }

}

public class StrategyPattern{
    public static void main(String args[]){
        Strategy add = new OperationAdd();
        Strategy mul = new OperationMultiply();


        Context obj1 = new Context(add);
        Context obj2 = new Context(mul);
        Context obj3 = new Context(new OperationAdd());

        System.out.println(obj1.executeStrategy(2,3)+" "+obj2.executeStrategy(2,3)+" "+obj3.executeStrategy(2,3));


    }
}
