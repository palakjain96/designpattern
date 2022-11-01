package com.library;
import java.io.*;

abstract class Plan {
    protected double rate;
    abstract void getRate();
    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class DomesticPlan extends Plan{
    @Override
    void getRate(){
        rate=3.50;
    }
}
class CommercialPlan extends Plan{
    @Override
    void getRate(){
        rate=7.50;
    }
}
class InstitutionalPlan extends Plan{
    @Override
    void getRate(){
        rate=5.50;
    }
}

class GetPlanFactory{
    public Plan getPlan(String planType){
        if(planType==null)
            return null;
        if(planType.equalsIgnoreCase("DOMESTICPLAN")){
            return new DomesticPlan();
        }
        if(planType.equalsIgnoreCase("COMMERCIALPLAN")){
            return new CommercialPlan();
        }
        if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")){
            return new InstitutionalPlan();
        }
        return null;
    }
}
class GenerateBill {

    public static void main(String[] args) throws IOException {
        // write your code here
        GetPlanFactory planFactory = new GetPlanFactory();
        System.out.print("Enter the name of plan for which the bill will be generated: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String planName=br.readLine();
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units=Integer.parseInt(br.readLine());
        Plan p= planFactory.getPlan(planName);
        System.out.print("Bill amount forvvv "+planName+" of  "+units+" units is: ");
        p.getRate();
        p.calculateBill(units);
    }
}
