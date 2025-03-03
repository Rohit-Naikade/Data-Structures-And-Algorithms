import java.util.*;

public class RatInTheMaze {

    static class Choice {
        char dir;
        int dx, dy;

        Choice(char c, int x, int y) {
            dir = c;
            dx = x;
            dy = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");

        int n = sc.nextInt();

        System.out.println("Enter elements:");

        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                list.add(num);
            }
            maze.add(list);
        }

        ArrayList<String> answer = new ArrayList<>();
        

        Choice choices[] = { new Choice('D', 1, 0),
                new Choice('U', -1, 0), new Choice('R', 0, 1), new Choice('L', 0, -1) };
        StringBuilder path = new StringBuilder("");
        findPaths(0, 0, n, choices, path, maze, answer);
        System.out.println(answer);
    }

    private static void findPaths(int x, int y, int n, RatInTheMaze.Choice[] choices, StringBuilder path,
            ArrayList<ArrayList<Integer>> maze, ArrayList<String> answer) {

        if (isSolved(x, y, n)) {
            answer.add(path.toString());
            return;
        }

        for (Choice c : choices) {
            int newX=x+c.dx;
            int newY=y+c.dy;
            //System.out.println("newX: "+newX+" newY:"+newY);
           // System.out.println(maze);
            if (isVisited(newX, newY, maze, n)) {
                path.append(c.dir);
                maze.get(x).set(y, 0);
                //System.out.println("before:"+path);
                findPaths(newX, newY, n, choices, path, maze, answer);
                //path.replace(path.length()-1, path.length()-1, "");
                path.deleteCharAt(path.length()-1);
                //System.out.println("after:"+path);
                maze.get(x).set(y, 1);
            }
        }
    }

    private static boolean isVisited(int x, int y, ArrayList<ArrayList<Integer>> maze, int n) {
        //System.out.println(maze.get(x).get(y));
        return (x>=0 && x<= n-1) && (y>=0 && y<= n-1) && maze.get(x).get(y)==1;
    }

    private static boolean isSolved(int x, int y, int n) {
        return x == n - 1 && y == n - 1;
    }
}
