// 
// Decompiled by Procyon v0.5.36
// 

package View.game;

import java.util.List;
import java.awt.Font;
import java.util.LinkedList;
import java.awt.Graphics;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JPanel;

class AnimationPanel extends JPanel
{
    Map<GameObject, ConstantObject> constants;
    Map<GameObject, ControlableObject> controlable;
    Map<GameObject, MovableObject> movables;
    World world;
    int controlSpeed;
    boolean gameOver;
    
    public AnimationPanel(final World world) {
        this.constants = new LinkedHashMap<GameObject, ConstantObject>();
        this.controlable = new LinkedHashMap<GameObject, ControlableObject>();
        this.movables = new LinkedHashMap<GameObject, MovableObject>();
        this.gameOver = false;
        this.setupKeyBinding();
        this.init(world);
    }
    
    public void init(final World world) {
        this.world = world;
        this.setPreferredSize(new Dimension(world.getWidth(), world.getHeight()));
        this.controlSpeed = world.getControlSpeed();
        for (final GameObject gameObject : world.getConstantObjects()) {
            this.constants.put(gameObject, new ConstantObject());
        }
        for (final GameObject gameObject : world.getControlableObjects()) {
            this.controlable.put(gameObject, new ControlableObject(gameObject));
        }
        for (final GameObject gameObject : world.getMovableObjects()) {
            this.movables.put(gameObject, new MovableObject(gameObject));
        }
        this.repaint();
    }
    
    private void setupKeyBinding() {
        final int condition = 2;
        final InputMap inMap = this.getInputMap(condition);
        final ActionMap actMap = this.getActionMap();
        Direction[] values;
        for (int length = (values = Direction.values()).length, i = 0; i < length; ++i) {
            final Direction direction = values[i];
            final int key = direction.getKey();
            final String name = direction.name();
            inMap.put(KeyStroke.getKeyStroke(key, 0), name);
            inMap.put(KeyStroke.getKeyStroke(key, 64), name);
            actMap.put(name, new ArrowsKeyAction(this, direction));
        }
    }
    
    ConstantObject getConstantData(final GameObject o) {
        ConstantObject data = this.constants.get(o);
        if (data == null) {
            data = new ConstantObject();
            this.constants.put(o, data);
        }
        return data;
    }
    
    MovableObject getMovableData(final GameObject o) {
        MovableObject data = this.movables.get(o);
        if (data == null) {
            data = new MovableObject(o);
            this.movables.put(o, data);
        }
        return data;
    }
    
    ControlableObject getControlableData(final GameObject o) {
        ControlableObject data = this.controlable.get(o);
        if (data == null) {
            data = new ControlableObject(o);
            this.controlable.put(o, data);
        }
        return data;
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        for (final GameObject o : this.world.getConstantObjects()) {
            if (o.isVisible()) {
                g.drawImage(o.getSpriteImages()[this.getConstantData(o).getState()], o.getX(), o.getY(), null);
            }
        }
        for (final GameObject o : this.world.getMovableObjects()) {
            if (o.isVisible()) {
                g.drawImage(o.getSpriteImages()[this.getMovableData(o).getState()], o.getX(), o.getY(), null);
            }
        }
        for (final GameObject o : this.world.getControlableObjects()) {
            if (o.isVisible()) {
                g.drawImage(o.getSpriteImages()[this.getControlableData(o).getState()], o.getX(), o.getY(), null);
            }
        }
        if (this.world.getConstantObjects().size() != this.constants.size()) {
            final List<GameObject> deleted = new LinkedList<GameObject>();
            for (final GameObject o2 : this.constants.keySet()) {
                if (!this.world.getConstantObjects().contains(o2)) {
                    deleted.add(o2);
                }
            }
            for (final GameObject d : deleted) {
                this.constants.remove(d);
            }
        }
        if (this.world.getControlableObjects().size() != this.controlable.size()) {
            final List<GameObject> deleted = new LinkedList<GameObject>();
            for (final GameObject o2 : this.controlable.keySet()) {
                if (!this.world.getControlableObjects().contains(o2)) {
                    deleted.add(o2);
                }
            }
            for (final GameObject d : deleted) {
                this.controlable.remove(d);
            }
        }
        if (this.world.getMovableObjects().size() != this.movables.size()) {
            final List<GameObject> deleted = new LinkedList<GameObject>();
            for (final GameObject o2 : this.movables.keySet()) {
                if (!this.world.getMovableObjects().contains(o2)) {
                    deleted.add(o2);
                }
            }
            for (final GameObject d : deleted) {
                this.movables.remove(d);
            }
        }
        if (this.gameOver) {
            g.setFont(new Font("TimesRoman", 1, 40));
            g.drawString("Game Over", this.getWidth() / 2 - 100, this.getHeight() / 2);
        }
    }
}
