/*
 * @Group Project: Hasibul Islam, Tashin Alam and Shakir Chowdhury
 */

//import statement
import java.awt.Point;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class GameGrid {

    public final static int MAX = 20;
    public Organism[][] grid;
    public Set<Point> set;

    private int initC = 0;
    private int initH = 0;
    private int initP = 0;

    public int CarnivoreCount = initC;
    public int HerbivoreCount = initH;
    public int PlantCount = initP;


    public GameGrid() throws IOException {
        grid = new Organism[MAX][MAX];
        set = new HashSet<Point>();

        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                grid[i][j] = new Organism();
            }
        }
        populateGrid(MAX,MAX,MAX);
    }
    public GameGrid(int x_size, int y_size, int c, int h, int p) throws IOException {
        grid = new Organism[x_size][y_size];
        set = new HashSet<Point>();

        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                grid[i][j] = new Organism();
            }
        }

        populateGrid(c,h,p);
    }


    private void populateGrid(int c, int h, int p) throws IOException {
        generateRandomC(c);
        generateRandomH(h);
        generateRandomP(p);
    }


    private void generateRandomC(int carnivores) throws IOException{
        for(int i = 0; i<carnivores; i++) {
            Point carnivorePoint = randomPoint();
            grid[(int)carnivorePoint.getX()][(int)carnivorePoint.getY()] = new Carnivore();
            System.out.println(carnivorePoint.toString());
            System.out.println(grid[(int)carnivorePoint.getX()][(int)carnivorePoint.getY()].getType());
            CarnivoreCount++;
        }
    }

    private void generateRandomH(int herbivores) throws IOException{
        for(int i = 0; i<herbivores; i++) {
            Point herbivorePoint = randomPoint();
            grid[(int)herbivorePoint.getX()][(int)herbivorePoint.getY()] = new Herbivore();
            System.out.println(herbivorePoint.toString());
            System.out.println(grid[(int)herbivorePoint.getX()][(int)herbivorePoint.getY()].getType());
            HerbivoreCount++;
        }
    }

    private void generateRandomP(int plants) throws IOException{
        for(int i = 0; i<plants; i++) {
            Point plantPoint = randomPoint();
            grid[(int)plantPoint.getX()][(int)plantPoint.getY()] = new Plant();
            System.out.println(plantPoint.toString());
            System.out.println(grid[(int)plantPoint.getX()][(int)plantPoint.getY()].getType());
            PlantCount++;
        }
    }


    private Point randomPoint() {
        Point randP = new Point(ThreadLocalRandom.current().nextInt(0, MAX), ThreadLocalRandom.current().nextInt(0, MAX));

        if(set.contains(randP))
            randP = new Point(ThreadLocalRandom.current().nextInt(0, MAX), ThreadLocalRandom.current().nextInt(0, MAX));
        else
            set.add(randP);

        return randP;
    }
}
