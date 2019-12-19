package Models.Factory;

import View.game.GameObject;

public interface IPlateFactory {
    public GameObject makePlate(int mode) ;
    public GameObject makeSpecialPlate();
}
