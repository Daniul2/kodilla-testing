package collections_2;


import java.util.*;

class Book4 {
    private List<String>evenList = new ArrayList<>();
    private List<String>oddList = new ArrayList<>();

    public void processQueue(Deque<String>theQueue){
        while (theQueue.size() > 0){
            String currentString = theQueue.poll();
            if (currentString.length() %2 == 0){
                evenList.add(currentString);
            }else {
                oddList.add(currentString);
            }
        }
    }
    public void displayStatistics(){
        System.out.println("Strings with even number of 'a': " + evenList.size());
        System.out.println("Strings with odd number of 'a': " + oddList.size());

        System.out.println("\nSample of 3 items from the even list:");
        for (int i = 0; i < Math.min(3,evenList.size()); i++) {
            System.out.println("Length " + evenList.get(i).length() + ": " + evenList.get(i));

        }
    }
}
public class Exercise4 {
    public static void main(String[] args) {
        Deque<String>letterQueue = new ArrayDeque<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int randomCount = random.nextInt(50) + 1;

            String aString = "";
            for (int j = 0; j < randomCount; j++) {
                aString += "a";
            }
            letterQueue.offer(aString);
        }
        System.out.println("The Queue has been filled. Current size: " + letterQueue.size());
        System.out.println();


        Book4 separator = new Book4();
        separator.processQueue(letterQueue);

        separator.displayStatistics();

        System.out.println("\nQueue size after processing: " + letterQueue.size());

    }
}
