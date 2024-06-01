import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author 12629
 * @Description：
 */
public class Test {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextInt()) {
            int num = scan.nextInt();
            int ret = func(num);
            System.out.print(ret);
        }
    }
    public static int func(int n) {
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        while(f3 < n) {
            f3 = f1 + f2;
            if(f3 >= n) {
                break;
            }
            f1 = f2;
            f2 = f3;
        }
        if(Math.abs(f2-n) > Math.abs(f3-n)) {
            return Math.abs(f3-n);
        }else{
            return Math.abs(f2-n);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while(scan.hasNextLine()) {
            String str = scan.nextLine();
            String[] strs = str.split(" ");
            for(String s : strs) {
                set.add(s);
            }
        }
        System.out.println( set.size());
    }
}
