//package observer;
//
//
//import model.Item;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Subject {
//    private List<ItemObserver> observers = new ArrayList<>();
//
//    public void addObserver(ItemObserver itemObserver) {
//        if (!observers.contains(itemObserver)) {
//            observers.add(itemObserver);
//        }
//    }
//
//    public void notifyObservers(Item i) {
//        System.out.println("ToDos added this session: ");
//        for (ItemObserver observer : observers) {
//            observer.update(i);
//        }
//    }
//
//}
