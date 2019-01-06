package LeetCode;

/**
 * Created by edwardwang on 1/6/19.
 */
public class IslandPerimeter {
    private static final int [][] grid1 = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    private static final int [][] grid2 = {{1,0}};
    private static final int output1 = 16;
    private static final int output2 = 4;


    public static void main(String[] args)
    {
        IslandPerimeterSolution solution = new IslandPerimeterSolution();
        //test1
        int perimeter = solution.islandPerimeter(grid1);
        System.out.println(perimeter == output1 ? "Correct --> Perimeter="+output1 :
                "Incorrect-Perimeter Found: "+perimeter+" Shoulder be: "+output1);
        //test 2
        int perimeter2 = solution.islandPerimeter(grid2);
        System.out.println(perimeter2 == output2 ? "Correct-Perimeter="+output2 :
                "Incorrect-Perimeter Found: "+perimeter2+" Shoulder be: "+output2);
    }
}

class IslandPerimeterSolution{
    //keep track of NSEW and if they are within bounds of grid
    class Compass{
        Coordinate n, s, e, w;
        boolean[] isOutOfBounds = {true, true, true, true};
        public Compass(Coordinate n, Coordinate s, Coordinate e, Coordinate w, boolean[] isOutOfBounds) {
            this.n = n;
            this.s = s;
            this.e = e;
            this.w = w;
            this.isOutOfBounds = isOutOfBounds;
        }
        public void print(int [][] grid)
        {
            if(!isOutOfBounds[0])System.out.println("N -> " + n.printCoordinate() + "\tValue: "+grid[n.x][n.y]);
            if(!isOutOfBounds[1])System.out.println("S -> " + s.printCoordinate() + "\tValue: "+grid[s.x][s.y]);
            if(!isOutOfBounds[2])System.out.println("E -> " + e.printCoordinate() + "\tValue: "+grid[e.x][e.y]);
            if(!isOutOfBounds[3])System.out.println("W -> " + w.printCoordinate() + "\tValue: "+grid[w.x][w.y]);
        }
    }
    class Coordinate{
        int x=0,y=0;
        public Coordinate(){}
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String printCoordinate()
        {
            return "X: "+x+"\tY: "+y;
        }
    }

    private int width=0, height = 0;
    public int islandPerimeter(int [][] grid)
    {
        int perimeter = 0;
        Compass compass;
        width = grid[0].length;
        height = grid.length;
        boolean isNextGridEmpty = false;
        for(int x=0;x<height;x++)
        {
            for(int y=0;y<width;y++)
            {
                if(grid[x][y]==1)
                {
                    //get compass indexes
                    compass = getCompass(x, y);
                    //compass.print(grid);
                    for(int i=0;i<4;i++)
                    {
                        //check if direction is out of bounds and add that to perimeter
                        if(compass.isOutOfBounds[i]) perimeter++;
                        else
                        {
                            //check directions for index that contains '0' and add to perimeter
                            if(i==0 && contains0(grid,compass.n)) perimeter++;
                            else if(i==1 && contains0(grid,compass.s)) perimeter++;
                            else if(i==2 && contains0(grid,compass.e))
                            {
                                perimeter++;
                                isNextGridEmpty = true;
                            }
                            else if(i==3 && contains0(grid,compass.w)) perimeter++;
                        }
                    }
                    //optomize grid traversal bc I know next grid is already empty
                    if(isNextGridEmpty)
                    {
                        y++;
                        isNextGridEmpty = false;
                    }
                }
            }
        }
        return perimeter;
    }

    private boolean contains0(int[][] grid, Coordinate coordinate)
    {
        return grid[coordinate.x][coordinate.y] == 0;
    }

    /**
     * Get index of indexes north, south, east and west of current index while checking that they are in bounds.
     * Return: n, s, e, w
     * */
    private Compass getCompass(int x, int y)
    {
        Coordinate n = new Coordinate(), s = new Coordinate(), e = new Coordinate(), w = new Coordinate();
        boolean isOutOfBounds[] = new boolean[4];
        //North
        if(x-1>-1) n = new Coordinate(x-1,y);
        else isOutOfBounds[0] = true;
        //South
        if(x+1<height) s = new Coordinate(x+1,y);
        else isOutOfBounds[1] = true;
        //East
        if(y+1<width) e = new Coordinate(x,y+1);
        else isOutOfBounds[2] = true;
        //West
        if(y-1>-1) w = new Coordinate(x,y-1);
        else isOutOfBounds[3] = true;
        //return Compass object
        return new Compass(n,s,e,w, isOutOfBounds);
    }
}