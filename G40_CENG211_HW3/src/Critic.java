public abstract  class Critic implements CriticI {
    private int limit;
    private double opinion;
    private String criticType;
    private int criticNumber;
    public Critic(double opinion,String criticType,int criticNumber) {
        this.limit = 0;
        this.opinion = opinion;
        this.criticType = criticType;
        this.criticNumber = criticNumber;
    }
    public Critic(Critic theCritic){
        this.limit = theCritic.getLimit();
        this.opinion = theCritic.getOpinion();
        this.criticType = getCriticType();
        this.criticNumber = getCriticNumber();
    }
    abstract void resetLimit();

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getOpinion() {
        return opinion;
    }

    public void setOpinion(double opinion) {
        this.opinion = opinion;
    }

    public String getCriticType() {
        return new String(criticType);
    }

    public void setCriticType(String criticType) {
        this.criticType = criticType;
    }

    public int getCriticNumber() {
        return criticNumber;
    }

    public void setCriticNumber(int criticNumber) {
        this.criticNumber = criticNumber;
    }
}

