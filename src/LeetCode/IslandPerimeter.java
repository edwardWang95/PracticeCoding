package LeetCode;

/**
 * Created by edwardwang on 1/6/19.
 */
public class IslandPerimeter {
    private static final int [][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    private static final int output = 16;

    public static void main(String[] args)
    {
        IslandPerimeterSolution solution = new IslandPerimeterSolution();
        String isCorrect = solution.islandPerimeter(grid) == output ? "Correct" : "Incorrect";
        System.out.println("Island Perimeter Solution: " + isCorrect);
    }
}

class IslandPerimeterSolution{
    public int islandPerimeter(int [][] grid)
    {
        return 0;
    }
}