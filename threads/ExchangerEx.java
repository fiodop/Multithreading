package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friendAction = new ArrayList<>();
        friendAction.add(Action.NOJNITCI);
        friendAction.add(Action.BUMAGA);
        friendAction.add(Action.NOJNITCI);
        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.BUMAGA);
        friend2Action.add(Action.KAMEN);
        friendAction.add(Action.KAMEN);

    }
}

enum Action{
    KAMEN, NOJNITCI, BUMAGA;
}

class Bestfriend extends Thread{
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public Bestfriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }
    private void whoWins(Action myAction, Action friendsAction){
        if (myAction == Action.KAMEN && friendsAction == Action.NOJNITCI
                || myAction == Action.BUMAGA && friendsAction == Action.KAMEN
                || myAction == Action.NOJNITCI && friendsAction == Action.BUMAGA) {
            System.out.println(name + " wins!!!");
            int cnt = 0;
            cnt ++;
        }
    }

    @Override
    public void run() {
        Action reply;
        for (Action action: myActions){
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}