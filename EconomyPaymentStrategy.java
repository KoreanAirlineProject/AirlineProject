class EconomyPaymentStrategy implements PaymentStrategy{

    
    private int price = 100000;

    @Override
    public String payment(String ticketNum) {
        String message = "이코노미석 예약 완료.\n" + price +"원 결제 되었습니다.\n 예약 번호는 " + ticketNum;
        System.out.println( message);
        return message;
    }

}

