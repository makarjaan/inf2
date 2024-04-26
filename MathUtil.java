package ru.itis.inf304.lab7;

public class MathUtil {
    public static Double exp(Double x) {
        double epsylon = 0.000001;
        Double sum = 1d;
        double x_ = x;
        int n =1;

        while (Math.abs(x_) > epsylon) {
            x_ = x_*x/n;
            n++;
            sum += x_;
        }
        return sum;
    }

    static void flip(int arr[], int i)
    {
        int temp, start = 0;
        while (start < i)
        {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    static int findMax(int arr[], int n)
    {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }
    static int[] pancakeSort(int arr[], int n)
    {
        for (int curr_size = n; curr_size > 1;
             --curr_size)
        {
            int mi = findMax(arr, curr_size);
            if (mi != curr_size-1)
            {
                flip(arr, mi);
                flip(arr, curr_size-1);
            }
        }
        return arr;
    }

    String tmd = "ggssfbjhgfdcvnk";


}
