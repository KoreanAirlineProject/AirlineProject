public class BusinessPaymentStrategy implements PaymentStrategy{

    private int price = 150000;    

    @Override
    public String payment(String ticketNum) {
        String message = "비지니스석 예약 완료.\n" + price +"원 결제 되었습니다.\n 예약 번호는 " + ticketNum;
        System.out.println(message);
        return message;
    }

}

