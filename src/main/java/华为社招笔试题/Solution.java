package 华为社招笔试题;

import java.util.Arrays;
import java.util.Scanner;

public class Solution  {

    /*
    题目：
        成绩排序，录取成绩前3的学生，排序按照依次总分、语文成绩、数学成绩、英语成绩、姓名拼音来进行排序。
        录取学生需要成绩中无不及格（单科不可以小于60分）以及排名前三。
     */
    class Grade implements Comparable<Grade>{
        String name;
        int yuwen;
        int shuxue;
        int yingyu;

        @Override
        public String toString() {
            return name+" "+yuwen+" "+shuxue+" "+yingyu;
        }

        @Override
        public int compareTo(Grade o) {
            int thistotal = this.yuwen+this.shuxue+this.yingyu;
            int total = o.yuwen+o.shuxue+o.yingyu;
            if(thistotal>total){
                return -1;
            } else if (thistotal<total){
                return 1;
            }else if(this.yuwen>o.yuwen){
                return -1;
            }else if (this.yuwen<o.yuwen){
                return 1;
            }else if (this.shuxue>o.shuxue){
                return -1;
            }else if (this.shuxue<o.shuxue){
                return 1;
            }else if (this.yingyu>o.yingyu){
                return -1;
            }else if (this.yingyu<o.yingyu){
                return 1;
            }else{
                return this.name.compareTo(o.name);
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        Grade[] grades = new Grade[10];
        for(int i=0;i<10;i++){
            Grade grade = solution.new Grade();
            grade.name=sc.next();
            grade.yuwen = sc.nextInt();
            grade.shuxue = sc.nextInt();
            grade.yingyu = sc.nextInt();
            grades[i]=grade;
        }
        Arrays.sort(grades);
        System.out.println("[First round name list]");
        for(Grade grade:grades){
            if(grade.yuwen<60||grade.shuxue<60||grade.yingyu<60){
                continue;
            }
            System.out.println(grade);
        }
        System.out.println();
        System.out.println("[Final name list]");
        int i;
        int n=1;
        int total = grades[0].yuwen+grades[0].shuxue+grades[0].yingyu;
        for( i=0;i<10;i++){
            if(n<3){
                if(grades[i].yuwen<60||grades[i].shuxue<60||grades[i].yingyu<60)continue;
                System.out.println(grades[i]);
                if(grades[i].yuwen+grades[i].shuxue+grades[i].yingyu!=total){
                    n++;
                    total=grades[i].yuwen+grades[i].shuxue+grades[i].yingyu;
                }
            }else if (total==grades[i].yuwen+grades[i].shuxue+grades[i].yingyu){
                System.out.println(grades[i]);
            } else{
                break;
            }
        }
    }
}
