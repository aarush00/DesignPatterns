import java.util.HashSet;


abstract class  CricketStadium {

    protected int score = 0;
    protected HashSet<App> appset;

    public abstract void addObserver(App app);
    public abstract void removeObserver(App app);
    public abstract void notifyApps();
    public abstract void setScore(int score);
    public abstract int getScore();
}

//Observable 1
class WakhandeStadium extends CricketStadium{

    public WakhandeStadium(){
        this.appset = new HashSet<>();
    }

    @Override
    public void addObserver(App app) {
        appset.add(app);
    }

    @Override
    public void removeObserver(App app) {
        appset.remove(app);
    }

    @Override
    public void notifyApps() {
        for(App app: appset){
            app.update();
        }
    }

    @Override
    public void setScore(int score) {
        this.score = score;
        notifyApps(); //whenever score changes notify apps
    }

    @Override
    public int getScore() {
        return this.score;
    }



}


abstract class App{
    protected int score=0;
    protected CricketStadium cricketStadium;

    public abstract void update();
    public abstract void display();

}

//Observer 1
class CrickBuzz extends App{
    public CrickBuzz (CricketStadium cricketStadium){
        this.cricketStadium = cricketStadium;
    }

    @Override
    public void display() {
        System.out.println(this.score);
    }

    @Override
    public void update(){
        this.score = cricketStadium.getScore();
    }
}

//Observer 2
class HotStar extends App{
    public HotStar (CricketStadium cricketStadium){
        this.cricketStadium = cricketStadium;
    }

    @Override
    public void display() {
        System.out.println(this.score);
    }

    @Override
    public void update(){
        this.score = cricketStadium.getScore();
    }
}



public class ObserverPattern {
    public static void main(String args[]){
        CricketStadium observable1 = new WakhandeStadium();

        App observer1 = new CrickBuzz(observable1);
        App observer2 = new HotStar(observable1);

        observable1.addObserver(observer1);
        observable1.addObserver(observer2);

        observer1.display();
        observer2.display();

        observable1.setScore(175);

        observer1.display();
        observer2.display();

        observable1.setScore(200);

        observer1.display();
        observer2.display();
    }
}
