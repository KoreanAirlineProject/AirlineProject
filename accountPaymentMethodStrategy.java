import javax.swing.JOptionPane;

class accountPaymentMethodStrategy implements PaymentMethodStrategy {

    @Override
    public boolean PaymentMethod() {
        JOptionPane.showMessageDialog(
            null, "삼성 페이를 사용합니다.");

        return true;
    }

    
}
