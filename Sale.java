class Sale {
    private String a;
    private String b;
    private double c;
    private String d;
        
    public Sale(String name, String service, double amount, String date) {
        a = name;
        b = service;
        c = amount;
        d = date;
    } 
    public String getName() {
        return a;
    }
    public String getServiceCategory() {
        return b;
    }
    public double getAmount() {
        return c; 
    }
    public String getDate() {
        return d;
    }
}