/*
 * @Group Project: Hasibul Islam, Tashin Alam and Shakir Chowdhury
 */

//import statement

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal extends Organism {
    private int energy;	 		private int Animal_v1;
    private int Animal_v2; 		private List<Point> vision;
    public Animal(String Organism_type) throws IOException {super(Organism_type);}
    public boolean canConsume(Point p) {return true;
    }

}
