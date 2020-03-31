package interview;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: WZL
 * @Date: 2020/3/29 20:37
 */
public class GetHighestScore {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap();
        map.put(4,10);
        int target = map.get(4);
        target -- ;
        System.out.println(map.get(4));

    }

    public void getHighScore(int n,int m,int[] num,int[] target){
        if(num.length != target.length){
            return;
        }
        Pair<Integer,Integer> pair;
        List<Pair<Integer,Integer>> list = new ArrayList<Pair<Integer, Integer>>();

        for(int i = 0 ; i < n ; i ++){
            pair = new Pair<Integer, Integer>(num[i],target[i]);
            list.add(pair);
        }
    }
}
