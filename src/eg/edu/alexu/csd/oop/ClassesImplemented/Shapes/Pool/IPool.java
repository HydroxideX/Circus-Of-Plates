package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Pool;

import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;

public interface IPool {
    boolean exists(String type);

    void add (Plate p);

    Plate get(String type);
}
