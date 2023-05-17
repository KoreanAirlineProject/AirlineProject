import java.awt.*;

public class button {
    private ButtonState buttonState;
 
    public button() {
        this.buttonState = new Off();
    }

    public void setButtonState(ButtonState buttonState) {
        this.buttonState = buttonState;
    }

    public Color buttonClick() {
        return buttonState.buttonClick();
    }

}
