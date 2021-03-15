public class Commission extends Hourly{
    double totSales;
    double commRate;
    
    public Commission(String eName, String eAddress, String ePhone,String socSecNumber, double rate, double ncommRate){
        super(eName,eAddress,ePhone,socSecNumber,rate);
        commRate = ncommRate;
    }
    
    public void addSales(double totalSales){
        totSales = totalSales;
    }
    
    @Override
    public double pay(){
        double payment = super.pay() + (totSales*commRate);
        totSales = 0;
        return payment;
    }
    
    @Override
    public String toString(){
        String result = super.toString();
        result += "\nTotal Sales: " + totSales;
        return result;
    }
}

