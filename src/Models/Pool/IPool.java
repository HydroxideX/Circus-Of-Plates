package Models.Pool;

import Models.Plates.Plate;

public interface IPool {
    boolean exists(String type);

    void add (Plate p);

    Plate get(String type);
}
