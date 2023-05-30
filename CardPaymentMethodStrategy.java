import javax.swing.JOptionPane;

class CardPaymentMethodStrategy implements PaymentMethodStrategy {

    @Override
    public boolean PaymentMethod() {
        String input = JOptionPane.showInputDialog(
            null,
            "카드 번호를 입력하세요.",
            "카드 결제",
            JOptionPane.PLAIN_MESSAGE
        );
        return input != null;
    }
}
