package test;

import collection.SimpleArrayList;
import model.Bus;
import sort.BubbleSort;

import java.util.Comparator;
import java.util.List;

public class SimpleTests {
    public static void main(String[] args) {
        testSimpleArrayList();
        testBubbleSortByNumber();
        testBubbleSortByMileage();
        System.out.println("All simple tests passed.");
    }

    private static void testSimpleArrayList() {
        SimpleArrayList<Bus> list = new SimpleArrayList<>();
        Bus b1 = new Bus.Builder().number("B1").model("A").mileage(10).build();
        Bus b2 = new Bus.Builder().number("B2").model("B").mileage(20).build();
        list.add(b1);
        list.add(b2);
        if (list.size() != 2) throw new AssertionError("Size failed");
        if (!list.get(0).getNumber().equals("B1")) throw new AssertionError("Get failed");
        list.set(0, new Bus.Builder().number("B0").model("A").mileage(5).build());
        if (!list.get(0).getNumber().equals("B0")) throw new AssertionError("Set failed");
    }

    private static void testBubbleSortByNumber() {
        List<Bus> list = new java.util.ArrayList<>();
        list.add(new Bus.Builder().number("B3").model("X").mileage(30).build());
        list.add(new Bus.Builder().number("B1").model("Y").mileage(10).build());
        list.add(new Bus.Builder().number("B2").model("Z").mileage(20).build());
        BubbleSort<Bus> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(list, Comparator.comparing(Bus::getNumber));
        if (!list.get(0).getNumber().equals("B1")) throw new AssertionError("Sort1 failed");
        if (!list.get(1).getNumber().equals("B2")) throw new AssertionError("Sort2 failed");
        if (!list.get(2).getNumber().equals("B3")) throw new AssertionError("Sort3 failed");
    }

    private static void testBubbleSortByMileage() {
        List<Bus> list = new java.util.ArrayList<>();
        list.add(new Bus.Builder().number("N1").model("M1").mileage(100).build());
        list.add(new Bus.Builder().number("N2").model("M2").mileage(50).build());
        list.add(new Bus.Builder().number("N3").model("M3").mileage(200).build());
        BubbleSort<Bus> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(list, Comparator.comparingLong(Bus::getMileage));
        if (list.get(0).getMileage() != 50) throw new AssertionError("M1");
        if (list.get(1).getMileage() != 100) throw new AssertionError("M2");
        if (list.get(2).getMileage() != 200) throw new AssertionError("M3");
    }
}