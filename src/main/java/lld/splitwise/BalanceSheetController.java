package lld.splitwise;


import lld.splitwise.expense.split.Split;
import lld.splitwise.user.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount){

        //update the total amount paid of the expense paid by user
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + totalExpenseAmount);

        for(Split split : splits) {
            // person who paid
            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmountOwe();


            if(expensePaidBy.getUserId().equals(userOwe.getUserId())){
                // add split's amount in expense for self split
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense()+oweAmount);
            }
            else {
                //update the balance of paid user

                // add split's amount in get back amount of paid user
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + oweAmount);

                Balance userOweBalance;
                if(paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {

                    userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                }
                else {
                    userOweBalance = new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }

                // set split's amount as get back to the user who owe the amount
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);


                //set split's amount as owe to the user who owe the amount
                oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe() + oweAmount);
                oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense() + oweAmount);

                Balance userPaidBalance;
                if(oweUserExpenseSheet.getUserVsBalance().containsKey(expensePaidBy.getUserId())){
                    userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(expensePaidBy.getUserId());
                }
                else{
                    userPaidBalance = new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(expensePaidBy.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayment());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }
}
