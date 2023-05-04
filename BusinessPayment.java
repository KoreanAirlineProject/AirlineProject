public class BusinessPayment implements IPayment{

    private int price = 150000;    

    @Override
    public String payment() {
        String message = "비지니스석 예약 완료.\n" + price +"원 결제 되었습니다.";
        System.out.println(message);
        return message;
    }

}

