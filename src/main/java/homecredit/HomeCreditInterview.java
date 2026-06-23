package homecredit;

import java.util.*;

//Q1: Reverse the list //INPUT : 1,2,3,4,5,6,7
//OUTPUT: 7,1,2,3,4,5,6
//        7,6,1,2,3,4,5
//        7,6,5,1,2,3,4
//        7,6,5,4,1,2,3
//        7,6,5,4,3,1,2
//        7,6,5,4,3,2,1
//Q2: Swipe the linklist : 1,2,3,4 OUTPUT: 2,1,4,3
//Q3: Input Array:{1,2,3,4,5} Output:{2,3,4,5,1} // 1-1 index piche krna hai to first wala last me chala jayega NOTE: Without using any extra ref
//Q4: Input ArrayList:{1,2,3,4,5} Output:{2,3,4,5,1} // 1-1 index piche krna hai to first wala last me chala jayega
public class HomeCreditInterview {
    public static void main(String[] args) {
//        Question One Solution
        List<Integer> inputOne = Arrays.asList(1,2,3,4,5,6,7);
        QuestionOne(inputOne);

//        Question Two Solution
        QuestionTwo();
        QuestionThree();
        QuestionFour();
    }

    private static void QuestionOne(List<Integer> list){
        List<Integer> prefix = new ArrayList<>();

        System.out.println("Answer One");
        for(int i=list.size()-1;i>=0;i--){
            prefix.add(list.get(i));

            List<Integer> result = new ArrayList<>(prefix);
            result.addAll(list.subList(0,i));

            System.out.println(result);
        }
    }

    private static void QuestionTwo() {
//        LinkedList<Integer> inputTwo = new LinkedList<>(Arrays.asList(2,3,4,5,6,7));
//        for (int i = 0; i < inputTwo.size() - 1; i += 2) {
//            Integer temp = inputTwo.get(i);
//            inputTwo.set(i, inputTwo.get(i + 1));
//            inputTwo.set(i + 1, temp);
//        }
//        System.out.println("Answer Two");
//        System.out.println(inputTwo);

        LinkedList<Integer> inputTwo = new LinkedList<>(Arrays.asList(2,3,4,5,6,7));


        ListIterator<Integer> it = inputTwo.listIterator();

        while (it.hasNext()) {
            Integer first = it.next();
            if (!it.hasNext()) break;

            Integer second = it.next();

            // swap values
            it.set(first);
            it.previous();
            it.previous();
            it.set(second);
            it.next();
            it.next();
        }

        System.out.println(inputTwo);
    }

    private static void QuestionThree(){
        int[] input = {1,2,3,4,5};
        for (int i = 0; i < input.length -1; i++) {
            input[i] = input[i] + input[i + 1];
            input[i + 1] = input[i] - input[i + 1];
            input[i] = input[i] - input[i + 1];
        }
        System.out.println("Answer Three");
        System.out.println(Arrays.toString(input));
    }
    private static void QuestionFour(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        list.add(list.get(0));
        list.remove(0);
        System.out.println("Answer Four");
        System.out.println(list);
    }
}
