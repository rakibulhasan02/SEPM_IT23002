//  package ExamPrepFinalAssignment.FinalAssignMentCode.qus3;


 class bankAccount{
    private String accountNumber;
    private double balence;

    //setter validatation
    public void setAccountNumber(String accountNumber){
        if(accountNumber==null || accountNumber.trim().isEmpty()){
            System.out.println("Invalid account number");
        }
        else this.accountNumber=accountNumber;
    }

    public void setInitialBalence(double balence){
        if(balence<0) System.out.println("Invalid balence! can not negative");
        else this.balence=balence;
    }

    //getther methods
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalence(){
        return balence;
    }
    
 }
public class EncapsulationWithBankAccount {

    public static void main(String[] args) {
        bankAccount acc=new bankAccount();
        acc.setAccountNumber("Acc1111");
        acc.setInitialBalence(5000);
        System.out.println("Account Number: "+acc.getAccountNumber());
        System.out.println("Balence: "+acc.getBalence());
    }
}