public class InterestCalcImpl implements InterestCalculator {
    @Override
    public double simpleInterest(double amount,float rate,float time) {
        return (amount * rate * time) / 100;
    }

    @Override
    public double compoundInterest(double amount,float rate,float time) {
        return amount * (Math.pow((1+ rate/100),time))-amount;
    }
}
