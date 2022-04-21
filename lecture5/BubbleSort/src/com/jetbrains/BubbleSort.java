package com.jetbrains;

public class BubbleSort {

    public static void main(String[] args) {

        BubbleSort app = new BubbleSort();
        int[] array = {2, 4, 6, 8, 10, 12, 89, 68, 45};
        String output = "Data items in original order\n";

        //append original array values to String output

        for (int counter = 0; counter < array.length; counter++) {
            output += "  " + array[counter];
        }
        app.bubbleSort(array);


        output += "\n\nData items in ascending order\n";


        for (int counter = 0; counter < array.length; counter++)
            output += " " + array[counter];

        System.out.println(output);

    }
        public void bubbleSort(int[] array2){
            for (int pass = 1; pass < array2.length; pass++) {
                for (int element = 0; element < array2.length - 1; element++) {

                    if(array2[element]>array2[element+1]){
                        swap(array2,element,element+1);
                    }
                }
            }
        }

    private void swap(int[] array3, int first, int second) {
        int temp;
        temp=array3[first];
        array3[first]=array3[second];
        array3[second]=temp;
    }

}
