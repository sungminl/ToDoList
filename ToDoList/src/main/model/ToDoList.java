package model;

import exceptions.SameNameTaskException;
import exceptions.TooManyThingsToDo;
//import observer.Subject;

import java.io.*;
import java.util.*;


public class ToDoList implements Loadable, Saveable {
    private ArrayList<Item> itemList;

    public ToDoList() {
        itemList = new ArrayList<>();
    }

    //EFFECTS: Gets Item from this
    public Item getItem(Integer i) {
        return this.itemList.get(i);
    }

    // EFFECTS: Gets size of this
    public int getSize() {
        return this.itemList.size();
    }

    // EFFECTS: Checks if this contains Item and returns a boolean value
    public boolean contains(Item i) {
        return this.itemList.contains(i);
    }

    // EFFECTS: Returns a list of Items of this
    public List<Item> getItems() {
        return itemList;
    }

    // MODIFIES: This
    // EFFECTS: Inserts Item into this
    public void insertItem(Item i) throws TooManyThingsToDo, SameNameTaskException {
        for (Item item : itemList) {
            if (item.getName().equals(i.getName())) {
                throw new SameNameTaskException();
            }
        }
        if (getUncompletedItems() >= 5) {
            throw new TooManyThingsToDo();
        }
        this.itemList.add(i);
    }


    // MODIFIES: This
    // EFFECTS: Removes Item from this
    public void removeItem(String name) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName().equals(name)) {
                itemList.remove(itemList.get(i));
            }
        }
    }


    // EFFECTS: Returns number of uncompleted tasks in this
    public int getUncompletedItems() {
        int x = 0;
        for (Item item : itemList) {
            if (item.getStatus().equals("FINISH SOON")
                    || item.getStatus().equals("Not Completed")) {
                x++;
            }
        }
        return x;
    }

    // MODIFIES: File
    // EFFECTS: Saves this into a chosen file
    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Item[] items = itemList.toArray(new Item[itemList.size()]);

        oos.writeObject(items);

        oos.close();
    }

    // MODIFIES: This
    // EFFECTS: Loads contents of file into this
    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Item[] items = (Item[]) ois.readObject();
            itemList.clear();
            itemList.addAll(Arrays.asList(items));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }

    // EFFECTS: Match string with each item in this, run complete(); if there is a match
    public void completed(String name) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName().equals(name)) {
                itemList.get(i).complete();
            }
        }
    }

    // MODIFIES: This
    // EFFECTS: Removes all item from this
    public void clearAll() {
        itemList.clear();
//        for (int i = 1000; i >= 0; i--) {
//            if (itemList.size() > i) {
//                itemList.remove(itemList.get(i));
//            }
//        }
    }

}
