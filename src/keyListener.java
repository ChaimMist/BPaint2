import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener {
    public static boolean cntrl = false;
    public keyListener(){
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if( keyCode == KeyEvent.VK_B){
            Menu.brushOpen = true;
            Menu.equippedBrush = true;
            Menu.equippedEraser = false;
            Menu.fillOpen = false;
            Menu.eraserOpen = false;
            Menu.thicknessIsOpen = false;
            Menu.screenMove = false;
            Menu.colorShow(true);
            Menu.equipped();
        }
        if (keyCode == KeyEvent.VK_CONTROL){
            cntrl = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyReleased = e.getKeyCode();
        if (keyReleased == KeyEvent.VK_CONTROL){
            cntrl = false;
        }
    }
}
