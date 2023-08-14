import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Main extends JFrame {
    private int[][] maze=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,1,1,1,1,1,0,0,0,0,0,1},
                    {1,0,0,1,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };
    public List<Integer> path=new ArrayList<>();
    public Main(){
        setTitle("MAZE SOLVER");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchpath(maze,1,1,path);
        //  System.out.println(path);

    }
    @Override
    public void paint(Graphics g){
        g.translate(50,50);
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color=Color.BLACK;break;
                    case 9: color=Color.RED;break;
                    default : color=Color.WHITE;break;


                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,40);
                g.setColor(Color.RED);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i=0;i<path.size();i+=2){
            int pathx=path.get(i);
            int pathy=path.get(i+1);
            System.out.println("X coordinates"+pathx);
            System.out.println("Y coordinates"+pathy);
            g.setColor(Color.GREEN);
            g.fillRect(30*pathx,30*pathy,20,20);
        }

    }
    public static void main(String[] args){
        Main view=new Main();
        view.setVisible(true);

    }

    boolean searchpath(int [][]maze, int x, int y,List<Integer>path){
        if(maze[y][x]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[y][x]==0){
            maze[y][x]=2;
            int dx=-1;
            int dy=0;
            if(searchpath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;

            }
            dx=1;
            dy=0;
            if(searchpath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;

            }
            dx=0;
            dy=-1;
            if(searchpath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx=0;
            dy=1;
            if(searchpath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
