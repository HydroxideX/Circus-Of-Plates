package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory;

import eg.edu.alexu.csd.oop.game.GameObject;

public interface IPlateFactory {
    public GameObject makePlate(int mode) ;
    public GameObject makeSpecialPlate();
}
