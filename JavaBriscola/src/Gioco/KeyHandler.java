package Gioco;

import javax.sound.midi.Soundbank;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    
    private boolean pressed1, pressed2, pressed3, pressedEnter;

    public boolean isPressed1() {
        return pressed1;
    }

    public boolean isPressed2() {
        return pressed2;
    }

    public boolean isPressed3() {
        return pressed3;
    }

    public boolean isPressedEnter() {
        return pressedEnter;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        
        if (code == KeyEvent.VK_1 || code == KeyEvent.VK_NUMPAD1) {
            pressed1 = true;
        } else if (code == KeyEvent.VK_2 || code == KeyEvent.VK_NUMPAD2) {
            pressed2 = true;
        } else if (code == KeyEvent.VK_3 || code == KeyEvent.VK_NUMPAD3) {
            pressed3 = true;
        } else if (code == KeyEvent.VK_ENTER) {
            pressedEnter = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        

        if (code == KeyEvent.VK_1 || code == KeyEvent.VK_NUMPAD1) {
            pressed1 = false;
        } else if (code == KeyEvent.VK_2 || code == KeyEvent.VK_NUMPAD2) {
            pressed2 = false;
        } else if (code == KeyEvent.VK_3 || code == KeyEvent.VK_NUMPAD3) {
            pressed3 = false;
        } else if (code == KeyEvent.VK_ENTER) {
            pressedEnter = false;
        }
        
    }
    
}
