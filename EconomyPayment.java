public class EconomyPayment implements IPayment{

    private int price = 100000;

    @Override
    public String payment() {
        String message = "이코노미석 예약 완료.\n" + price +"원 결제 되었습니다.";
        System.out.println( message);
        return message;
    }

}

