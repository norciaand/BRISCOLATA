package Gioco;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    
    private boolean pressed1, pressed2, pressed3, pressedEnter, pressedT;
    private String messaggio;

    public KeyHandler() {
        messaggio = "";
    }

    public boolean isChatMode() {
        return chatMode;
    }

    private boolean chatMode;

    public void setChatMode(boolean chatMode) {
        this.chatMode = chatMode;
    }

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

    public boolean isPressedT() {
        return pressedT;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void resetMessaggio() {
        this.messaggio = "";
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (chatMode){
            char x = e.getKeyChar();
            if (x == 27) {
                setChatMode(false);
            }
            else if (x == 8){
                if(!messaggio.isEmpty()){
                    messaggio = messaggio.substring(0,messaggio.length()-1);
                }
            } else if (x == 127) {
                if(!messaggio.isEmpty()){
                    messaggio = "";
                }
            }
            else if (messaggio.length() < 14 && x != 10){
                messaggio = messaggio + x;
            }
        }
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
        } else if (code == KeyEvent.VK_T) {
            pressedT = true;
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
        } else if (code == KeyEvent.VK_T) {
            pressedT = false;
        }
    }
    
}
