import java.util.Arrays;
import java.util.Stack;

/**
 * @Author 12629
 * @Description：
 */
public class TestSort {


    /**
     * 时间复杂度：
     *   最坏情况下：什么情况下最坏？逆序：O(N^2)
     *   最好情况下：什么情况下是最好情况？ 有序：O(n)
     *   得出一个结论：当数据量不多，且基本上趋于有序的时候，直接插入排序是非常快的！
     * 空间复杂度：  O(1)
     * 稳定性： 稳定
     *        一个本身就稳定的排序，可以实现为不稳定的排序
     *        但是一个本身就不稳定的排序 能实现为稳定的排序吗？？
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0;j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }


    /**
     * O(N^1.3)
     * 不是稳定的排序
     * @param array
     * @param gap
     */
    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0;j-=gap) {
                if(array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            gap /= 2;
            shell(array,gap);
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(n^2)   和数据是否有序无序 无关 都是这样的
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    //更新minIndex的值
                    minIndex = j;
                }
            }
            //处理两个下标是一样的情况
            if(i != minIndex) {
                swap(array, minIndex, i);
            }
        }
    }
    private static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void selectSort2(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = left;
            for (int j = left+1; j <= right; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
                if(array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            //把最小值交换到前面
            swap(array,minIndex,left);
            //这里 如果max下标正好是Left说明上次 已经把最大值从Left位置换到了minIdex位置
            if(maxIndex == left) {
                maxIndex = minIndex;
            }
            //把最大值交换到后面
            swap(array,maxIndex,right);
            left++;
            right--;
        }
    }


    /**
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的算法
     * @param array
     */
    public static void heapSort(int[] array) {
        createBigHeap(array);//O(n)
        int end = array.length-1;
        while (end > 0) {
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }

    private static void createBigHeap(int[] array) {
        for (int parent = (array.length-1-1)/2; parent >= 0 ; parent--) {
            shiftDown(array,parent,array.length);
        }
    }

    private static void shiftDown(int[] array,int parent,int len) {
        int child = (2*parent)+1;
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            if(array[child] > array[parent]) {
                swap(array,child,parent);
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    /**
     * 时间复杂度：（不考虑优化）：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        //最外层控制的是趟数
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    swap(array,j,j+1);
                    flg = true;
                }
            }
            if(flg == false) {
                break;
            }
        }
    }

    /**
     *
     * @param array
     * @param left
     * @param right
     * @return
     *  1. 为什么从右边开始找？
     *  2. array[right] >= pivot 为什么取等号
     */
    private static int partitionHoare(int[] array,int left,int right) {
        int i = left;
        int pivot = array[left];
        while (left < right) {
            //left < right &&  这个条件不能少 预防后面都比基准大
            while (left < right && array[right] >= pivot) {
                right--;
            }
            //right下标的值 小于pivot
            while (left < right && array[left] <= pivot) {
                left++;
            }
            //left下标的值 大于pivot
            swap(array,left,right);
        }
        //交换 和 原来的left
        swap(array,left,i);
        return left;
    }

    private static int partition2(int[] array,int left,int right) {
        int pivot = array[left];
        while (left < right) {
            //left < right &&  这个条件不能少 预防后面都比基准大
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            //right下标的值 小于pivot
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        //交换 和 原来的left
        array[left] = pivot;
        return left;
    }

    private static int partition(int[] array, int left, int right) {
        int prev = left ;
        int cur = left+1;
        while (cur <= right) {
            if(array[cur] < array[left] && array[++prev] != array[cur]) {
                swap(array,cur,prev);
            }
            cur++;
        }
        swap(array,prev,left);
        return prev;
    }

    /**
     * 对指定区间的数据进行插入排序
     * @param array
     * @param left
     * @param right
     */
    private static void insertSort(int[] array,int left,int right) {
        for (int i = left+1; i <= right; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= left;j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    private static void quick(int[] array,int start,int end) {
        //能不能不写大于号？？？  预防 1 2 3 4 5 6  直接没有左树 或者没有右树
        if(start >= end) {
            return;
        }

        if(end-start+1 <= 15) {
            //对 start 和 end区间 范围内 使用插入排序
            insertSort(array,start,end);
            return;
        }
        //System.out.println("start: " +start +" end: "+end);

        // 在执行 partition 找基准之前，尽量能去解决 划分不均匀的问题
        int index = findMidValOfIndex(array,start,end);
        swap(array,start,index);
        int pivot = partition(array,start,end);
        quick(array,start,pivot-1);
        quick(array,pivot+1,end);
    }

    private static int findMidValOfIndex(int[] array,int start,int end) {
        int midIndex = (start+end) / 2;
        //    3                 9
        if(array[start] < array[end]) {
            if(array[midIndex] < array[start]) {
                return start;
            }else if(array[midIndex] > array[end]) {
                return end;
            }else {
                return midIndex;
            }
        }else {
            if(array[midIndex] > array[start]) {
                return start;
            }else if(array[midIndex] < array[end]) {
                return end;
            }else {
                return midIndex;
            }
        }
    }



    /**
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(logN)
     * 稳定性：不稳定的排序
     * @param array
     *
     * 问题：
     * 当我们给定的数据 是有序的时候，这个快排的时间复杂度是O(n^2)
     * 空间复杂度：O(n)
     */
    public static void quickSort1(int[] array) {
        quick(array,0,array.length-1);
    }


    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int end = array.length-1;
        int pivot = partition(array,start,end);
        //1.判断左边是不是有2个元素
        if(pivot > start+1) {
            stack.push(start);
            stack.push(pivot-1);
        }
        //2.判断右边是不是有2个元素
        if(pivot < end-1) {
            stack.push(pivot+1);
            stack.push(end);
        }
        while (!stack.isEmpty()) {
            end = stack.pop();
            start = stack.pop();
            pivot = partition(array,start,end);
            //3.判断左边是不是有2个元素
            if(pivot > start+1) {
                stack.push(start);
                stack.push(pivot-1);
            }
            //4.判断右边是不是有2个元素
            if(pivot < end-1) {
                stack.push(pivot+1);
                stack.push(end);
            }
        }

    }


    /**
     * 归并排序：
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(N)
     * 稳定性：稳定
     * 插入  冒泡  归并
     * @param array
     */
    public static void mergeSort1(int[] array) {
        mergeSortChild(array,0,array.length-1);
    }

    private static void mergeSortChild(int[] array,int left,int right) {
        if(left == right) {
            return;
        }
        int mid = (left+right) / 2;
        mergeSortChild(array,left,mid);
        mergeSortChild(array,mid+1,right);
        //合并
        merge(array,left,mid,right);
    }

    private static void merge(int[] array,int left,int mid,int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;
        int[] tmpArr = new int[right-left+1];
        int k = 0;//表示tmpArr 的下标
        while (s1 <= e1  && s2 <= e2) {
            if(array[s1] <= array[s2]) {
                tmpArr[k++] = array[s1++];
            }else{
                tmpArr[k++] = array[s2++];
            }
        }
        while (s1 <= e1) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmpArr[k++] = array[s2++];
        }
        //tmpArr当中 的数据 是right  left 之间有序的数据
        for (int i = 0; i < k; i++) {
            array[i+left] = tmpArr[i];
        }
    }

    /**
     * 非递归的归并排序
     * @param array
     */
    public static void mergeSort(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            for (int i = 0; i < array.length; i += gap*2) {
                int left = i;
                int mid = left + gap -1;
                int right = mid+gap;
                if(mid >= array.length) {
                    mid = array.length-1;
                }
                if(right >= array.length) {
                    right = array.length-1;
                }
                merge(array,left,mid,right);
            }
            gap *= 2;
        }
    }


    /**
     * 计数排序：范围小 且集中的数据
     * 时间复杂度：O(n+范围) -》 范围越小，时间复杂度越小
     * 空间复杂度：O(范围)
     * @param array
     */
    public static void countSort(int[] array) {
        //1、遍历数组 找到 最小值 和最大值  -》 才能确定 计数数组的大小
        int maxVal = array[0];
        int minVal = array[0];
        //O(n)
        for (int i = 0; i < array.length; i++) {
            if(array[i] > maxVal) {
                maxVal = array[i];
            }
            if(array[i] < minVal) {
                minVal = array[i];
            }
        }
        //2、确定计数数组的长度
        int len = maxVal - minVal + 1 ;
        int[] countArr = new int[len];
        //3. 开始遍历 当前数组 统计每个数字出现的次数  O(n)
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            countArr[val-minVal] ++;//??????????????
        }

        int index = 0;
        //4. 遍历计数数组，看每个下标的值是几，就打印几个下标的数据就好了 O(范围 + n)
        //范围遍历一次，位置上所有的数的个数加起来等于n
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                //不敢打印
                array[index] = i+minVal;//??????????????
                index++;
                countArr[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {188,2,19,134,29,15};
        countSort(array);
        System.out.println("排序后："+Arrays.toString(array));
    }
}
