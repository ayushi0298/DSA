package Interview.Arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
public class MiniumumNoOfPlatforms {
    public int minimumPlatforms(int arr1[], int arr2[]){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=1,j=0;

        int count=1;
        int platform=1;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<= arr2[j]){
                platform++;
                i++;
            }
            else if(arr1[i]>arr2[j]){
                platform--   ;
                j++;

            }
            if (platform > count)
                count = platform;
        }

        return count;
    }

    public static void main(String args[]){

        MiniumumNoOfPlatforms mn= new MiniumumNoOfPlatforms();
        int arr[] = { 9, 1, 2,5,6, 8 };
        int dep[] = { 10,4, 3, 6, 7, 9 };
        System.out.println(mn.minimumPlatforms(arr,dep));

    }
}
