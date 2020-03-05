package Question5;

import java.util.Map;

/**
 * @Author: WZL
 * @Date: 2020/3/5 19:46
 */
public class Solution {
    public static void main(String[] args) {
        //String s = "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";
        String s = "ac";
        System.out.println("==="+longestPalindrome(s));

    }

    //暴力法，超时！
    public static  String longestPalindrome(String s) {
        String maxStr = "";
        int maxLength  = 0;
        if(null != s && !"".equals(s)){
            for(int i = 0; i<=s.length() ; i++){
                for(int  j = i; j <= s.length() ; j++){
                    String s1 = s.substring(i,j);
                    if(s1.contentEquals(new StringBuffer(s1).reverse())){
                        if(maxLength < s1.length()){
                           maxLength = s1.length();
                           maxStr = s1;
                        }
                    }
//                    System.out.println(maxStr);
                    System.out.println(s1);
                }
            }

        }
        return maxStr;

    }


    public static  String longestPalindrome2(String s) {
        //判空
        if(null == s || s.isEmpty()){
            return "";
        }

        //只有一个数字的时候
        if(s.length() == 1){
            return s;
        }
        int maxLength = 0;
        String maxStr = "";

        String[] arr = s.split("");
        int j = 0;

        while(j<arr.length){
            //奇数情况
            int a[] = expand(arr,j-1,j+1);
            //偶数情况
            int b[] = expand(arr,j,j+1);
            if(a[1] - a[0] > b[1] - b[0] && a[1] - a[0] > maxLength){
                maxLength = a[1] - a[0];
                maxStr = s.substring(a[0],a[1]+1);
            }else if(b[1] - b [0] > maxLength){
                maxLength = b[1] - b[0];
                maxStr = s.substring(b[0],b[1]+1);
            }
//            System.out.println(j+"a[0]=="+a[0]);
//            System.out.println(j+"a[1]=="+a[1]);
//            System.out.println(j+"b[0]=="+b[0]);
//            System.out.println(j+"b[1]=="+b[1]);
            j++;
        }

        //不是回文字符，返回第一个字符
        if(maxLength == 0){
            maxStr = arr[0];
        }

        return  maxStr;
    }

    //向两边扩展判断是否为回文字符，返回数字a[0]为左下标，a[1]为右下标
    public static int[] expand(String[] arr, int left, int right){
        int a[] ={0,0};
        if(left < 0){
            a[0] = 0;
            a[1] = 0;
           return a;
        }else if(right >= arr.length){
            a[0] = arr.length - 1;
            a[1] = arr.length - 1;
            return a;
        }

        while(left > -1 && right < arr.length && arr[left].equals(arr[right])){
            left -- ;
            right ++;
        }

        a[0] = left+1;
        a[1] = right-1;
        return a;
    }
}
