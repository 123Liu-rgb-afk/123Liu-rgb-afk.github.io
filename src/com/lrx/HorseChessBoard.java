package com.lrx;

import java.util.ArrayList;
import java.awt.Point;
import java.util.Comparator;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class HorseChessBoard {
    //定义属性
    private static int X = 6;//表示列col
    private static int Y = 6;//表示行row
    private static int[][] chessBoard = new int[Y][X];//棋盘
    private static boolean[] visited = new boolean[X * Y];//记录某个位置是否走过
    private static boolean finished = false;//记录马儿是否走完棋盘

    public static void main(String[] args) {
        int row = 2;
        int col = 2;

        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard,row - 1,col - 1,1);
        long end = System.currentTimeMillis();

        System.out.println("遍历时间=" + (end - start));
        //输出当前棋盘
        for (int[] rows : chessBoard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }
    //编写一个方法，对ps的各个位置，可以走的下一次位置进行排序
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }

    //图的优先搜索，遍历棋盘，如果遍历成功，将finished设置为true
    //并且，将马儿走的每一步step,记录到棋盘chessBoard
    public static void traversalChessBoard(int[][] chessBoard, int row,int col, int step) {
        //先把step记录到棋盘中
        chessBoard[row][col] = step;
        //把这个位置设置为已经访问
        visited[row * X + col] = true;
        //获得当前位置可以走那几步
        ArrayList<Point> ps = next(new Point(col,row));
        sort(ps);
        //遍历
        while(!ps.isEmpty()){
            //取出ps的第一个位置
            Point p = ps.remove(0);
            //遍历该位置是否走过，如果没有走，就递归
            if(!visited[p.y * X + p.x]){
                //遍历
                traversalChessBoard(chessBoard,p.y,p.x,step + 1);
            }

        }
        //退出while，判断是否成功
        if(step < X * Y && !finished ) {
            //重置
            chessBoard[row][col] = 0;
            visited[row * X + col] = false;

        }else{
            finished = true;
        }


    }

    //编写方法可以获取到当前位置可以走的下一步的所有位置(Point 表示 x,y)
    public static ArrayList<Point> next(Point curPoint) {
        //先创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<>();

        //创建一个Point对象(位置)，放入ps
        Point p1 = new Point();

        // 判断是否可以走5位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 判断是否可以走6位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        // 判断是否可以走7位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        // 判断是否可以走0位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 判断是否可以走1位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        // 判断是否可以走2位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        // 判断是否可以走3位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        // 判断是否可以走4位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }

        return ps;
    }
}
