//Given a list/array of possible scores, print/output the unique no. of ways using which
//we can reach the given target. Ordering of the combination doesn't matter so if two
// combinations have different ordering count it as 1 unique combination.

// Score = 3,5,10
// target = 20

//Output : {3,3,3,3,3,5} , {10,10}, {5,5,10}/{5,10,5}/{10,5,5} , {5,5,5,5} --> 4 ways

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum1 {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int[] scores = {2,3,6,7};
        int target = 7;
        //Sorting the array since scores can be given in any order so we don't have to put
        //extra validation at the end while adding to the res
        Arrays.sort(scores);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        solve(scores,0,target,new ArrayList<>(),res);
        System.out.println("The unique number of ways to reach the target "+target+" from the scores "+ Arrays.toString(scores)+ " is "+res.size());
    }

    public static void solve(int[] scores, int index, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
        if(index == scores.length){
            if(target == 0){
                System.out.println(res);
                res.add(new ArrayList<>(path));
                System.out.println(res);
            }
            return;
        }

        /*Below for loop was checking repetitive iterations which were already checked so to avoid
        that since we don't have duplicates in the input so to save time and not check that
        extra repetitive iterations, another soln without for loop is written below
        for(int i=index;i<scores.length;i++){
            System.out.println("Index : " +index);
            System.out.println("i : " +i);
            System.out.println("target : " +target);
            if(target >= scores[i]) {
                path.add(scores[i]);
                System.out.println(path);
                solve(scores, i, target - scores[i], path, res);
                System.out.println(path);
                path.remove(path.size() - 1);
                System.out.println(path);
            }
        }*/

        System.out.println("target " +target);
        if(target >= scores[index]){
            System.out.println("index " +index+ " scores[index] " +scores[index]);
            path.add(scores[index]);
            solve(scores,index,target-scores[index],path,res);
            path.remove(path.size()-1);
        }
        solve(scores,index+1,target,path,res);

    }
}